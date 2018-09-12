package health.sport.oxygen.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import health.sport.oxygen.R;
import health.sport.oxygen.models.News;
import health.sport.oxygen.server.ApiClient;
import health.sport.oxygen.server.ApiInterface;
import health.sport.oxygen.ui.Adapter.NewsAdapter;
import health.sport.oxygen.util.EndlessRecyclerViewScrollListener;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class NewsActivity extends AppCompatActivity {


    private int page = 1;
    private ProgressBar process;
    private RecyclerView recyclerView;
    private EndlessRecyclerViewScrollListener scrollListener;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    private List<News> newsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        process = findViewById(R.id.process);
        recyclerView = findViewById(R.id.list);

        process.setVisibility(View.VISIBLE);


        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        scrollListener = new EndlessRecyclerViewScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int p, int totalItemsCount, RecyclerView view) {
                page = p;
                getData();
            }
        };

        recyclerView.addOnScrollListener(scrollListener);

        getData();

    }

    private void refreshDisplay(List<News> items) {

        if (items.size() > 0) {

            if (mAdapter == null) {
                newsList = items;
                mAdapter = new NewsAdapter(newsList, this);
                recyclerView.setAdapter(mAdapter);
            } else {
                newsList.addAll(items);
                mAdapter.notifyDataSetChanged();
            }


        }

    }


    private void getData() {
        ApiInterface apiService = ApiClient.getClient2().create(ApiInterface.class);
        Call<ResponseBody> call = apiService.getNews(page);
        call.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {

                String sampleXml = null;
                try {
                    sampleXml = String.valueOf(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JSONObject jsonObj = null;
                try {
                    jsonObj = XML.toJSONObject(sampleXml);

                    JSONArray jsonArray;

                    jsonArray = jsonObj.getJSONObject("news-service")
                            .getJSONObject("news-category")
                            .getJSONObject("headline-list")
                            .getJSONArray("headline");


                    List<News> items = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {

                        String mJsonString = jsonArray.get(i).toString();
                        JsonParser parser = new JsonParser();
                        JsonElement mJson = parser.parse(mJsonString);
                        Gson gson = new Gson();
                        News object = gson.fromJson(mJson, News.class);

                        items.add(object);
                    }

                    process.setVisibility(View.GONE);
                    refreshDisplay(items);
                } catch (JSONException e) {
                    Log.e("JSON exception", e.getMessage());
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(NewsActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                process.setVisibility(View.GONE);
            }
        });
    }
}
