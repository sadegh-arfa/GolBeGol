package health.sport.oxygen.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by S_ on 9/12/2018.
 * Sadegh.arfa@gmail.com
 * +989303033100
 */
public class Date {


    @SerializedName("date-number")
    @Expose
    private String dateNumber;
    @SerializedName("date-string")
    @Expose
    private String dateString;

    public String getDateNumber() {
        return dateNumber;
    }

    public void setDateNumber(String dateNumber) {
        this.dateNumber = dateNumber;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }
}
