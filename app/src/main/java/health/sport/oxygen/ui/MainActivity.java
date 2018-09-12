package health.sport.oxygen.ui;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TabHost;

import health.sport.oxygen.R;
import health.sport.oxygen.models.News;


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






        // Tab for store
        TabHost.TabSpec store = tabHost.newTabSpec("Store");
        store.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_store));
        Intent storeIntent = new Intent(this, StoreActivity.class);
        store.setContent(storeIntent);


        // Tab for news
        TabHost.TabSpec map = tabHost.newTabSpec("News");
        map.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_home));
        Intent mapIntent = new Intent(this, NewsActivity.class);
        map.setContent(mapIntent);

        // Tab for sport
        TabHost.TabSpec timeLine = tabHost.newTabSpec("TimeLine");
        timeLine.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_sport));
        Intent timeLineIntent = new Intent(this, TimeLineActivity.class);
        timeLine.setContent(timeLineIntent);

        // Tab for Home
        TabHost.TabSpec home = tabHost.newTabSpec("Home");
        home.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_tools));
        Intent HomeIntent = new Intent(this, HomeActivity.class);
        home.setContent(HomeIntent);


        // Adding all TabSpec to TabHost
        tabHost.addTab(store); // Adding store tab
        tabHost.addTab(timeLine); // Adding timeLine tab
        tabHost.addTab(home); // Adding map tab
        tabHost.addTab(map); // Adding home tab

        tabHost.setCurrentTab(3);

    }
}
