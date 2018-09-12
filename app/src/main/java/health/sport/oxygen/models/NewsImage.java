package health.sport.oxygen.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by S_ on 9/12/2018.
 * Sadegh.arfa@gmail.com
 * +989303033100
 */
public class NewsImage {

    @SerializedName("picture-quality")
    @Expose
    private String quelity;


    @SerializedName("picture-url")
    @Expose
    private String picture;

    public NewsImage() {
    }

    public String getQuelity() {
        return quelity;
    }

    public void setQuelity(String quelity) {
        this.quelity = quelity;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
