package health.sport.oxygen.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import health.sport.oxygen.R;


public class WebViewActivity extends Activity {

    private String url;
    private String title;
    private WebView webView;
    private ProgressBar progressBar;
    private ProgressBar progressBar2;

    private TextView titleTv;
    private CardView cardView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_view);


        url = getIntent().getStringExtra("url");
        title = getIntent().getStringExtra("title");


        titleTv = (TextView) findViewById(R.id.title);
        cardView = (CardView) findViewById(R.id.cardView);

        if (title != null) {
            titleTv.setText(title);
        }

        if (title == null) {
            cardView.setVisibility(View.GONE);
        }

        if (!url.startsWith("http://") && !url.startsWith("https://"))
            url = "http://" + url;


        webView = (WebView) findViewById(R.id.webView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new AppWebViewClients(progressBar, progressBar2));
        webView.loadUrl(url);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });
    }


    public class AppWebViewClients extends WebViewClient {
        private ProgressBar progressBar;
        private ProgressBar progressBar2;

        public AppWebViewClients(ProgressBar progressBar, ProgressBar progressBar2) {
            this.progressBar = progressBar;
            this.progressBar2 = progressBar2;
            progressBar.setVisibility(View.VISIBLE);
            progressBar2.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
            progressBar2.setVisibility(View.GONE);
        }
    }


}
