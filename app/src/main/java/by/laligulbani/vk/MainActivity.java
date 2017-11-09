package by.laligulbani.vk;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String REDIRECT_URL = "https://oauth.vk.com/blank.html";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webview = new WebView(this);
        setContentView(webview);

        webview.setWebViewClient(new WebViewClient() {


            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.d(TAG, "shouldOverrideUrlLoading() called with: view = [" + view + "], request = [" + request.getUrl() + "]");
                return handleRedirect(request.getUrl());
            }

            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return handleRedirect(Uri.parse(url));
            }
        });
        webview.loadUrl("https://oauth.vk.com/authorize?client_id=6249213&redirect_uri=" +
                REDIRECT_URL +
                "&display=mobile&scope=friends&response_type=token&v=5.69");

    }

    private boolean handleRedirect(Uri uri) {
        final String currentRedirect = uri.getScheme() + ":" + uri.getSchemeSpecificPart();
        Log.d(TAG, "handleRedirect: expected " +currentRedirect);
        Log.d(TAG, "handleRedirect() called with: uri = [" + uri + "]");

        // TODO: 07.11.2017 handle https://oauth.vk.com/blank.html#access_token=06c73214961ab1aef8450d38e1135bc2e69ab4df72e7d144f63b5e9102fc70b83b050fc8c6c956a62f830&expires_in=86400&user_id=111447184
        if (REDIRECT_URL.equals(currentRedirect)) {
            final Uri redirect = Uri.parse(uri.toString().replace("#", "?"));
            final String accessToken = redirect.getQueryParameter("access_token");

            Toast.makeText(this, accessToken, Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
