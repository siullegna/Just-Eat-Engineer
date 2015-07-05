package justeatengineer.justeatengineer.dto;

import com.google.gson.annotations.SerializedName;

public class DtoCuisine {

    @SerializedName("Id")
    private int Id;

    @SerializedName("Name")
    private String Name;

    @SerializedName("SeoName")
    private String SeoName;

    public DtoCuisine(int id, String name, String seoName) {
        this.Id = id;
        this.Name = name;
        this.SeoName = seoName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSeoName() {
        return SeoName;
    }

    public void setSeoName(String seoName) {
        SeoName = seoName;
    }
}
