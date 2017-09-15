package golbegol.brlyan.golbegol.ui;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TabHost;

import golbegol.brlyan.golbegol.R;


public class MainActivity extends TabActivity {

    public static Activity Main;
    public static TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Main = this;
        tabHost = getTabHost();

        // Tab for Home
        TabHost.TabSpec home = tabHost.newTabSpec("Home");
        home.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_home));
        Intent HomeIntent = new Intent(this, HomeActivity.class);
        home.setContent(HomeIntent);

        // Tab for TimeLine
        TabHost.TabSpec timeLine = tabHost.newTabSpec("TimeLine");
        timeLine.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_timeline));
        Intent timeLineIntent = new Intent(this, TimeLineActivity.class);
        timeLine.setContent(timeLineIntent);


        // Tab for store
        TabHost.TabSpec store = tabHost.newTabSpec("Store");
        store.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_store));
        Intent storeIntent = new Intent(this, StoreActivity.class);
        store.setContent(storeIntent);


        // Tab for map
        TabHost.TabSpec map = tabHost.newTabSpec("Map");
        map.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_map));
        Intent mapIntent = new Intent(this, MapsActivity.class);
        map.setContent(mapIntent);


        // Adding all TabSpec to TabHost
        tabHost.addTab(home); // Adding home tab
        tabHost.addTab(timeLine); // Adding timeLine tab
        tabHost.addTab(store); // Adding store tab
        tabHost.addTab(map); // Adding map tab

    }
}
