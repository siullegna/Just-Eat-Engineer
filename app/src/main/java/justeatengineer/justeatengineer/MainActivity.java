package justeatengineer.justeatengineer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import justeatengineer.justeatengineer.dto.DtoEntity;
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

    private JustEatService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsyncGet get = new AsyncGet();
        get.execute();


    }

    private class AsyncGet extends AsyncTask<String,Void,String>{

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

            Gson gson =new GsonBuilder().create();


            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(Constants.PROTOCOL+ Constants.HOST)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setRequestInterceptor(requestInterceptor)
                    .setConverter(new GsonConverter(gson))
                    .build();

            service = restAdapter.create(JustEatService.class);

            service.getRestaurants("se19", new Callback<RestaurantResponse>() {
                @Override
                public void success(RestaurantResponse restaurantResponse, Response response) {
                    toast("funciono");
                }

                @Override
                public void failure(RetrofitError error) {
                    toast("no funciono");
                }
            });

            return null;
        }
    }

    private void toast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
