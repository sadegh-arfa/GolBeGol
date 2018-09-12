package health.sport.oxygen.util;

import android.content.Context;
import android.content.SharedPreferences;

import health.sport.oxygen.models.User;

/**
 * Created by S_ on 9/11/2018.
 * Sadegh.arfa@gmail.com
 * +989303033100
 */
public class userConfig {

    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    private static void init() {
        if (preferences == null) {
            preferences = ApplicationLoader.getInstance().getSharedPreferences("userConfig", Context.MODE_PRIVATE);
            editor = preferences.edit();
        }
    }

    public static boolean isValid(){
        init();
        return preferences.getString("token" , null) != null;
    }

    public static void setUser(User user){
        init();
        editor.putString("name" , user.getItem().getName());
        editor.putString("token" , user.getItem().getApi_key());
        editor.putString("mail" , user.getItem().getEmail());
        editor.putInt("status" , user.getItem().getStatus());
        editor.commit();
    }

}
