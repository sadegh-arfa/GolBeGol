package health.sport.oxygen.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import health.sport.oxygen.R;
import health.sport.oxygen.ui.Adapter.WidgetAdapter;
import health.sport.oxygen.models.widget;
import health.sport.oxygen.ui.Cell.coffeWidget;
import health.sport.oxygen.ui.Cell.waterwidget;

public class HomeActivity extends AppCompatActivity {



    private LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        layout = findViewById(R.id.baseLayout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add New Widget To your Activities", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        waterwidget w1 =new waterwidget(this);
        layout.addView(w1);

        coffeWidget w2 = new coffeWidget(this);
        layout.addView(w2);



    }





}
