package golbegol.brlyan.golbegol.ui.Cell;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by S_ on 9/15/2017.
 * Sadegh.arfa@gmail.com
 * +989303033100
 */

public class widget implements Parcelable {

    int id , image , process , backgroundColor;
    Long duration ;
    String name , unit ;

    public widget(int id, int image, int process, int backgroundColor, Long duration, String name, String unit) {
        this.id = id;
        this.image = image;
        this.process = process;
        this.backgroundColor = backgroundColor;
        this.duration = duration;
        this.name = name;
        this.unit = unit;
    }


    protected widget(Parcel in) {
        id = in.readInt();
        image = in.readInt();
        process = in.readInt();
        backgroundColor = in.readInt();
        name = in.readString();
        unit = in.readString();
    }

    public static final Creator<widget> CREATOR = new Creator<widget>() {
        @Override
        public widget createFromParcel(Parcel in) {
            return new widget(in);
        }

        @Override
        public widget[] newArray(int size) {
            return new widget[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(image);
        dest.writeInt(process);
        dest.writeInt(backgroundColor);
        dest.writeString(name);
        dest.writeString(unit);
    }
}
