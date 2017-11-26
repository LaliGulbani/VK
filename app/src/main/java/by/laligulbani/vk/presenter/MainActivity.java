package by.laligulbani.vk.presenter;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.Main2Activity;
import by.laligulbani.vk.R;
import by.laligulbani.vk.model.management.IModelManagement;
import by.laligulbani.vk.model.management.ModelManager;
import by.laligulbani.vk.presenter.task.GetMessageTask;

public class MainActivity extends AppCompatActivity {

    public String token;
    public IModelManagement modelManager;

    private TextView tvMessages;
    private TextView tvToken;

    private WebView webView;

    private Button btnAuthorize;
    private Button btnGetMessage;
    private Button btnDisplayToken;
    private Button newIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.newIntent = (Button)findViewById(R.id.new_intent);
        newIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        this.webView = (WebView) findViewById(R.id.webView);
        this.webView.setWebViewClient(new MainActivityViewClient());
        this.webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        this.btnAuthorize = (Button) findViewById(R.id.btnAuthorize);
        this.btnAuthorize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(Api.AUTHORIZATION_URL);
            }
        });

        this.btnGetMessage = (Button) findViewById(R.id.btnGetMessage);
        this.btnGetMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (token == null) {
                    tvMessages.setText("You are not authorized!");
                    tvToken.setText("You are not authorized!");
                    return;
                }

                new GetMessageTask(modelManager, token, tvMessages).execute();
            }
        });

        this.btnDisplayToken = (Button) findViewById(R.id.btnToken);
        this.btnDisplayToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvToken.setText(token);
            }
        });

        this.tvMessages = (TextView) findViewById(R.id.tvMessages);
        this.tvToken = (TextView) findViewById(R.id.tvToken);

        modelManager = new ModelManager();
    }

    private class MainActivityViewClient extends WebViewClient {

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return handleRedirect(view, request.getUrl());
        }

        @SuppressWarnings("deprecation")
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return handleRedirect(view, Uri.parse(url));
        }

        private boolean handleRedirect(WebView view, Uri uri) {
            final String currentRedirect = uri.getScheme() + ":" + uri.getSchemeSpecificPart();
            if (Api.REDIRECT_URL.equals(currentRedirect)) {
                final Uri redirect = Uri.parse(uri.toString().replace("#", "?"));
                token = redirect.getQueryParameter("access_token");
                view.loadUrl(uri.toString());
                return true;
            }
            return false;
        }
    }
}
