package health.sport.oxygen.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by S_ on 9/12/2018.
 * Sadegh.arfa@gmail.com
 * +989303033100
 */
public class MainNews {


    @SerializedName("news-entity")
    @Expose
    private NewsEntity newsEntity;

    public NewsEntity getNewsEntity() {
        return newsEntity;
    }

    public void setNewsEntity(NewsEntity newsEntity) {
        this.newsEntity = newsEntity;
    }

}
