package by.laligulbani.vk.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static android.net.Uri.parse;
import static by.laligulbani.vk.Api.AUTHORIZATION_URL;
import static by.laligulbani.vk.Api.REDIRECT_URL;

public class LoginActivity extends AppCompatActivity {

    public static final String APP_PREFERENCES_NAME = "pref_name";
    public static final String PREFERENCES_TOKEN = "token";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final WebView webView = new WebView(this);
        webView.setWebViewClient(new LoginWebViewClient());
        webView.loadUrl(AUTHORIZATION_URL);

        setContentView(webView);
    }

    private class LoginWebViewClient extends WebViewClient {

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(final WebView view, final WebResourceRequest request) {
            return handleRedirect(request.getUrl());
        }

        @Override
        public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
            return handleRedirect(parse(url));
        }

        private boolean handleRedirect(final Uri uri) {

            if (REDIRECT_URL.endsWith(uri.getSchemeSpecificPart())) {
                getSharedPreferences(APP_PREFERENCES_NAME, MODE_PRIVATE)
                        .edit()
                        .putString(PREFERENCES_TOKEN, getToken(uri))
                        .apply();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();

                return true;
            }
            return false;
        }

        private String getToken(final Uri uri) {
            return parse(uri.toString().replace("#", "?"))
                    .getQueryParameter("access_token");
        }
    }
}
