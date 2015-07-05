package justeatengineer.justeatengineer.wservice.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import justeatengineer.justeatengineer.dto.DtoEntity;

public class RestaurantResponse {

    @SerializedName("Restaurants")
    private
    List<DtoEntity> mRestaurants;


    public List<DtoEntity> getmRestaurants() {
        return mRestaurants;
    }

    public void setmRestaurants(List<DtoEntity> mRestaurants) {
        this.mRestaurants = mRestaurants;
    }
}
