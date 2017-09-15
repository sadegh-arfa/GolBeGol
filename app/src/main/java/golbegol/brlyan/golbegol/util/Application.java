package golbegol.brlyan.golbegol.util;

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


public class Application extends android.app.Application{

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    public void onCreate() {
        super.onCreate();

        addAnalytic();
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
