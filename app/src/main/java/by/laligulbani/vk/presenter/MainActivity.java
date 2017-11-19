package by.laligulbani.vk.presenter;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.R;
import by.laligulbani.vk.model.entity.Item;
import by.laligulbani.vk.model.management.IModelManagement;
import by.laligulbani.vk.model.management.ModelManager;

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
        this.button.setOnClickListener((arg) -> refresh());


    }

    private void refresh() {
        new GetMessageTask().execute();
    }

    private class GetMessageTask extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(final String[] tokens) {
            final List<Item> items = modelManager.getMessages(token);
            final StringBuilder sb = new StringBuilder();
            for (final Item item : items) {
                sb.append(item.body);
                sb.append("\n");
            }
            return sb.toString();
        }

        @Override
        protected void onPostExecute(final String result) {
            textView.setText(result);
        }
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

                return true;
            }
            return false;
        }
    }
}
