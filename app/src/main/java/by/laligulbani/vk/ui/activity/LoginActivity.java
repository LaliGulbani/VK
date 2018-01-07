package by.laligulbani.vk.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import by.laligulbani.vk.model.db.IDataBaseFactory;
import by.laligulbani.vk.model.facade.dialog.IDialogFacadeFactory;
import by.laligulbani.vk.model.service.executor.IExecutorService;
import by.laligulbani.vk.model.service.executor.IExecutorServiceFactory;
import by.laligulbani.vk.model.service.user.IUserServiceFactory;
import by.laligulbani.vk.model.util.ContextHolder;
import by.laligulbani.vk.ui.task.Task;

import static android.net.Uri.parse;
import static by.laligulbani.vk.Api.AUTHORIZATION_URL;
import static by.laligulbani.vk.Api.REDIRECT_URL;

public class LoginActivity extends AppCompatActivity {

    public static final String APP_PREFERENCES_NAME = "pref_name";
    public static final String PREFERENCES_TOKEN = "token";
    public static final String PREFERENCES_ID_USER = "id_user";

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

                final Uri parse = getToken(uri);
                final String id = parse.getQueryParameter("user_id");
                final String token = parse.getQueryParameter("access_token");

                setPreferences(PREFERENCES_TOKEN, token);
                setPreferences(PREFERENCES_ID_USER, id);

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();

                init(token);
                return true;
            }
            return false;
        }

        private Uri getToken(final Uri uri) {
            return parse(uri.toString().replace("#", "?"));
        }

        private void setPreferences(final String namePreferences, final String value) {
            getSharedPreferences(APP_PREFERENCES_NAME, MODE_PRIVATE)
                    .edit()
                    .putString(namePreferences, value)
                    .apply();
        }

        private void init(final String token) {

            final Context applicationContext = getApplicationContext();
            ContextHolder.setContext(applicationContext);
            applicationContext.deleteDatabase(IDataBaseFactory.DB_NAME);

            final IExecutorService executorService = IExecutorServiceFactory.getInstance();
//            executorService.executeOnExecutor(new Task<>(() -> IDialogFacadeFactory.getInstance().getDialogs(token)));
//            executorService.executeOnExecutor(new Task<>(() -> IUserServiceFactory.getInstance().getFriendsOnline(token)));
//            executorService.executeOnExecutor(new Task<>(() -> IUserServiceFactory.getInstance().getFriends(token)));
        }
    }
}
