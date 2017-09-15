package golbegol.brlyan.golbegol.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import golbegol.brlyan.golbegol.R;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences preferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        preferences = getSharedPreferences("mainConfig",MODE_PRIVATE);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (preferences.getString("Token",null) != null){
                    startActivity(new Intent(SplashActivity.this , MainActivity.class));
                }else{
                    startActivity(new Intent(SplashActivity.this , LoginActivity.class));
                }
                finish();
            }
        }, 1500);



    }
}
