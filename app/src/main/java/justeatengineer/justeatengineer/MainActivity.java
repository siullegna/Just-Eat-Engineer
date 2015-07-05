package justeatengineer.justeatengineer;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import justeatengineer.justeatengineer.fragment.Information;
import justeatengineer.justeatengineer.util.Constants;
import justeatengineer.justeatengineer.wservice.JustEatService;
import justeatengineer.justeatengineer.wservice.response.RestaurantResponse;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

/**
 * Created by luisangelgarcia on 7/5/15.
 */
public class MainActivity extends AppCompatActivity {

    private final String TAG_FRAGMENT_INFORMATION = "Information";

    private LocationManager mLocationManager;
    private JustEatService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        AsyncGet get = new AsyncGet();
        get.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private class AsyncGet extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            // Define the interceptor, add authentication headers
            RequestInterceptor requestInterceptor = new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addHeader("Accept-Tenant", Constants.ACCEPT_TENANT);
                    request.addHeader("Accept-Language", Constants.ACCEPT_LANG);
                    request.addHeader("Authorization", Constants.AUTHORIZATION);
                    request.addHeader("User-Agent", Constants.HOST);
                }
            };

            Gson gson = new GsonBuilder().create();


            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(Constants.PROTOCOL + Constants.HOST)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setRequestInterceptor(requestInterceptor)
                    .setConverter(new GsonConverter(gson))
                    .build();

            service = restAdapter.create(JustEatService.class);

            service.getRestaurants("se19", new Callback<RestaurantResponse>() {
                @Override
                public void success(RestaurantResponse restaurantResponse, Response response) {
                    toast("funciono");

                    Information fragment = (Information)
                            getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_INFORMATION);
                    fragment.setInformation(restaurantResponse.getmRestaurants());

                }

                @Override
                public void failure(RetrofitError error) {
                    //toast("no funciono");
                }
            });

            return null;
        }
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_location) {

        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        Fragment fragment = new Information();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frame_container, fragment, TAG_FRAGMENT_INFORMATION).commit();

        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000l,
                10f, mLocationListener);
    }


    private final LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };
}
