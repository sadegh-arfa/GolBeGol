package health.sport.oxygen.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.StrictMode;
import android.util.TypedValue;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AndroidUtilites {

    public static float density = 1;

    public static int dp(float value) {
        if (value == 0) {
            return 0;
        }

        Resources r = ApplicationLoader.getInstance().getResources();
        int px = Math.round(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, value, r.getDisplayMetrics()));
        return px;


    }


    public static int appInstalledOrNot(String uri) {
        PackageManager pm = ApplicationLoader.getInstance().getPackageManager();
        try {
            PackageInfo app = pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return app.versionCode;
        } catch (PackageManager.NameNotFoundException e) {

        }

        return -1;
    }



    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.toLowerCase().startsWith(manufacturer.toLowerCase())) {
            return capitalize(model);
        } else {
            return model;
        }
    }


    private static String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }


    public static boolean isNetworkAvailable() {
        final ConnectivityManager connectivityManager = (ConnectivityManager) ApplicationLoader.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public static boolean isInternetAvailable() {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            final InetAddress address = InetAddress.getByName("www.google.com");
            return !address.equals("");
        } catch (UnknownHostException e) {
            // Log error
        }
        return false;
    }
}