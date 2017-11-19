package by.laligulbani.vk.presenter;

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
import by.laligulbani.vk.R;
import by.laligulbani.vk.model.management.IModelManagement;
import by.laligulbani.vk.model.management.ModelManager;
import by.laligulbani.vk.presenter.task.GetMessageTask;

public class MainActivity extends AppCompatActivity {

    public String token;
    public IModelManagement modelManager;

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final WebView webview = new WebView(this);
        setContentView(webview);
        webview.setWebViewClient(new MainActivityViewClient());
        webview.loadUrl(Api.AUTORIZATION_URL);
        modelManager = new ModelManager();

        this.textView = (TextView) (findViewById(R.id.text_messenger));
        this.button = (Button) (findViewById(R.id.btn_messenger));
    }

    public void DDDDDDDDDDDD(View view) {
        new GetMessageTask(modelManager, token, textView).execute();
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
                setContentView(R.layout.activity_main);
                //Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                //startActivity(intent);
                return true;
            }
            return false;
        }
    }
}
