package justeatengineer.justeatengineer.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class DtoEntity {

    @SerializedName("Name")
    private String Name;

    @SerializedName("RatingStars")
    private float RatingStars;

    @SerializedName("CuisineTypes")
    private List<DtoCuisine> CuisineTypes;

    @SerializedName("Logo")
    private List<DtoLogo> StandardResolutionURL;

    public DtoEntity(List<DtoCuisine> cuisineTypes, String name, float ratingStars, List<DtoLogo> standardResolutionURL) {
        CuisineTypes = cuisineTypes;
        Name = name;
        RatingStars = ratingStars;
        StandardResolutionURL = standardResolutionURL;
    }


    public List<DtoCuisine> getCuisineTypes() {
        return CuisineTypes;
    }

    public void setCuisineTypes(List<DtoCuisine> cuisineTypes) {
        CuisineTypes = cuisineTypes;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getRatingStars() {
        return RatingStars;
    }

    public void setRatingStars(float ratingStars) {
        RatingStars = ratingStars;
    }

    public List<DtoLogo> getStandardResolutionURL() {
        return StandardResolutionURL;
    }

    public void setStandardResolutionURL(List<DtoLogo> standardResolutionURL) {
        StandardResolutionURL = standardResolutionURL;
    }
}
