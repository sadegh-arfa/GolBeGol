package golbegol.brlyan.golbegol.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import golbegol.brlyan.golbegol.R;
import golbegol.brlyan.golbegol.ui.Adapter.WidgetAdapter;
import golbegol.brlyan.golbegol.ui.Cell.widget;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private static List<widget> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add New Widget To your Activities", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        recyclerView.setItemAnimator(itemAnimator);

        tempData();

    }


    private void tempData() {


        data.add(new widget(1, R.drawable.widget_walking, 50, 0xff008080, 1l, "Walking", "Steps"));
        data.add(new widget(2, R.drawable.ic_glass_of_water, 4, 0xff242869, 1l, "water", "Glass"));
        data.add(new widget(3, R.drawable.ic_cardiogram, 76, 0xff800000, 1l, "cardiogram", "Bpm"));
        data.add(new widget(4, R.drawable.runner, 1, 0xff6a25c8, 1l, "Run", "KM"));

        refreshDisplay();

    }


    private void refreshDisplay() {
        // The number of Columns
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.Adapter mAdapter = new WidgetAdapter(data, this);
        recyclerView.setAdapter(mAdapter);

    }


}
