package by.laligulbani.vk.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import by.laligulbani.vk.Api;

public class LoginActivity extends AppCompatActivity {

    public static final String APP_PREFERENCES_NAME = "pref_name";
    public static final String PREFERENCES_TOKEN = "token";
    public String token;
    public static SharedPreferences mPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView = new WebView(this);
        setContentView(webView);

        mPreferences = getSharedPreferences(APP_PREFERENCES_NAME, Context.MODE_PRIVATE);

        webView.setWebViewClient(new WebViewClient() {
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
                    mPreferences.edit().putString(PREFERENCES_TOKEN, token).apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
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
