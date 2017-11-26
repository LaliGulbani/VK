package by.laligulbani.vk.ui.login;


import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.Main2Activity;

public class LoginActivity extends AppCompatActivity {

    public String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView = new WebView(this);
        setContentView(webView);

        webView.setWebViewClient(new WebViewClient()
        {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return handleRedirect(request.getUrl());
            }

            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return handleRedirect(Uri.parse(url));
            }

            private boolean handleRedirect(Uri uri) {
                final String currentRedirect = uri.getScheme() + ":" + uri.getSchemeSpecificPart();
                if (Api.REDIRECT_URL.equals(currentRedirect)) {
                    final Uri redirect = Uri.parse(uri.toString().replace("#", "?"));
                    token = redirect.getQueryParameter("access_token");
                    Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                    startActivity(intent);
                    finish();
                    return true;
                }
                return false;
            }

        });
        webView.loadUrl(Api.AUTHORIZATION_URL);


    }
}
