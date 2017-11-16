package by.laligulbani.vk.presenter;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Collection;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.model.entity.Message;
import by.laligulbani.vk.model.management.IModelManagement;
import by.laligulbani.vk.model.management.ModelManager;

public class MainActivity extends AppCompatActivity {

    public String token;
    public IModelManagement modelManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final WebView webview = new WebView(this);
        setContentView(webview);
        webview.setWebViewClient(new MainActivityViewClient());
        webview.loadUrl(Api.AUTORIZATION_URL);
        modelManager = new ModelManager();
    }

    private void refrash() {
        final Collection<Message> messages = modelManager.getMessages(token);
        final StringBuilder sb = new StringBuilder();
        for (final Message message : messages) {
            sb.append(message.getId());
            sb.append("\n");
        }
        final String result = sb.toString();
        //TODO add setting result to textview
    }

    private class MainActivityViewClient extends WebViewClient {

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
                return true;
            }
            return false;
        }
    }
}
