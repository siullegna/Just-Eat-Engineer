package justeatengineer.justeatengineer.wservice;


import java.util.List;

import justeatengineer.justeatengineer.dto.DtoEntity;
import justeatengineer.justeatengineer.util.Constants;
import justeatengineer.justeatengineer.wservice.response.RestaurantResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface JustEatService {

    @GET(Constants.URL)
    public void getRestaurants(@Query("q") String query,Callback<RestaurantResponse> restaurantResponseCallback);
}
