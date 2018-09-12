package health.sport.oxygen.util;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by S_ on 9/15/2017.
 * Sadegh.arfa@gmail.com
 * +989303033100
 */


public class ApplicationLoader extends android.app.Application{

    private FirebaseAnalytics mFirebaseAnalytics;
    private static volatile ApplicationLoader localInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        localInstance = this;

        addAnalytic();
    }


    public static ApplicationLoader getInstance(){
        return localInstance;
    }

    private void addAnalytic(){
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode == ConnectionResult.SUCCESS) {
            try {
                constant.AnalyticInitialized = true ;
                // Obtain the FirebaseAnalytics instance.
                mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
            } catch (Exception e) {
                Log.i("TAG", "onCreate: Exception in AplicationLoader for Analytic ");
            }
        }


    }


}
