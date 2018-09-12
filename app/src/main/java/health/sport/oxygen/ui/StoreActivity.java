package health.sport.oxygen.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import okhttp3.ResponseBody;
import retrofit2.Call;

public class StoreActivity extends AppCompatActivity {


    private int page = 1;

    private List<News> newsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        ApiInterface apiService = ApiClient.getClient2().create(ApiInterface.class);

        Call<ResponseBody> call = apiService.getNews(page);
        call.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {

                if (response.body() != null){

                    String sampleXml = null;
                    try {
                        sampleXml = String.valueOf(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    JSONObject jsonObj = null;
                    try {
                        jsonObj = XML.toJSONObject(sampleXml);

                        JSONArray jsonArray ;

                        jsonArray = jsonObj.getJSONObject("news-service")
                                .getJSONObject("news-category")
                                .getJSONObject("headline-list")
                                .getJSONArray("headline");


                        for (int i = 0; i < jsonArray.length(); i++) {

                            String mJsonString = jsonArray.get(i).toString();
                            JsonParser parser = new JsonParser();
                            JsonElement mJson =  parser.parse(mJsonString);
                            Gson gson = new Gson();
                            News object = gson.fromJson(mJson, News.class);

                            newsList.add(object);
                        }

                    } catch (JSONException e) {
                        Log.e("JSON exception", e.getMessage());
                        e.printStackTrace();
                    }


                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(StoreActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }
}
