package justeatengineer.justeatengineer.dto;

import com.google.gson.annotations.SerializedName;

public class DtoLogo {

    @SerializedName("StandardResolutionURL")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
