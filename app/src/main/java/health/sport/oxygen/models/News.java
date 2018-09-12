package health.sport.oxygen.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by S_ on 9/12/2018.
 * Sadegh.arfa@gmail.com
 * +989303033100
 */
public class News {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("cat-id")
    @Expose
    private int catId;
    @SerializedName("is-hot")
    @Expose
    private Boolean isHot;
    @SerializedName("is-newspaper")
    @Expose
    private Boolean isNewspaper;
    @SerializedName("main-news")
    @Expose
    private MainNews mainNews;

    @SerializedName("headline-picture")
    @Expose
    private NewsImage newsImage;

    public Boolean getHot() {
        return isHot;
    }

    public void setHot(Boolean hot) {
        isHot = hot;
    }

    public Boolean getNewspaper() {
        return isNewspaper;
    }

    public void setNewspaper(Boolean newspaper) {
        isNewspaper = newspaper;
    }

    public NewsImage getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(NewsImage newsImage) {
        this.newsImage = newsImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    public Boolean getIsNewspaper() {
        return isNewspaper;
    }

    public void setIsNewspaper(Boolean isNewspaper) {
        this.isNewspaper = isNewspaper;
    }

    public MainNews getMainNews() {
        return mainNews;
    }

    public void setMainNews(MainNews mainNews) {
        this.mainNews = mainNews;
    }


    
}
