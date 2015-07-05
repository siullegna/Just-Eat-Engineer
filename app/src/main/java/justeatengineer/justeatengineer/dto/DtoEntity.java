package justeatengineer.justeatengineer.dto;

/**
 * Created by luisangelgarcia on 7/5/15.
 */
public class DtoEntity {
    private String Name;
    private float RatingStars;
    private String[] CuisineTypes;
    private String StandardResolutionURL;

    public DtoEntity(String[] cuisineTypes, String name, float ratingStars, String standardResolutionURL) {
        CuisineTypes = cuisineTypes;
        Name = name;
        RatingStars = ratingStars;
        StandardResolutionURL = standardResolutionURL;
    }


    public String[] getCuisineTypes() {
        return CuisineTypes;
    }

    public void setCuisineTypes(String[] cuisineTypes) {
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

    public String getStandardResolutionURL() {
        return StandardResolutionURL;
    }

    public void setStandardResolutionURL(String standardResolutionURL) {
        StandardResolutionURL = standardResolutionURL;
    }
}
