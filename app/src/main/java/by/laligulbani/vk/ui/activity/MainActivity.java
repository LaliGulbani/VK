package by.laligulbani.vk.ui.activity;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import by.laligulbani.vk.R;
import by.laligulbani.vk.entity.message_list.Message;
import by.laligulbani.vk.model.management.ModelManagementFactory;
import by.laligulbani.vk.presenter.task.GetMessageTask;
import by.laligulbani.vk.ui.fragment.MessagesFragment;

import static by.laligulbani.vk.ui.activity.LoginActivity.APP_PREFERENCES_NAME;
import static java.util.Collections.emptyList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String mToken;
    private MessagesFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mToken = getSharedPreferences(APP_PREFERENCES_NAME, Context.MODE_PRIVATE)
                .getString(LoginActivity.PREFERENCES_TOKEN, "не определено");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mFragment = new MessagesFragment();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return item.getItemId() == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_news:
                replaceMessageFragment(emptyList());
                break;
            case R.id.nav_notification:
                break;
            case R.id.nav_messanges:
                new GetMessageTask(ModelManagementFactory.getModelManager(), mToken, this::replaceMessageFragment);
                break;
            case R.id.nav_friends:
                break;
            case R.id.nav_groups:
                break;
            case R.id.nav_photo:
                break;
            default: {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        }
        return true;
    }

    private void replaceMessageFragment(List<Message> messages) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame_layout, mFragment);
        fragmentTransaction.commit();
    }
}
