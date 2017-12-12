package by.laligulbani.vk.ui.activity;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import by.laligulbani.vk.entity.messages.Message;
import by.laligulbani.vk.entity.messages.Wrapp;
import by.laligulbani.vk.model.management.ModelManagementFactory;
import by.laligulbani.vk.presenter.task.GetMessageTask;
import by.laligulbani.vk.ui.fragment.MessagesFragment;

import static java.util.Collections.emptyList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private MessagesFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return item.getItemId() == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_news:
                replaceMessageFragment(emptyList());
                break;
            case R.id.nav_notification:
                break;
            case R.id.nav_messanges:
                final String mToken = getSharedPreferences(APP_PREFERENCES_NAME, Context.MODE_PRIVATE)
                        .getString(PREFERENCES_TOKEN, "");


                new GetMessageTask(ModelManagementFactory.getInstance(), mToken, (messages) -> {

                    mFragment = new MessagesFragment();
                    final Bundle args = new Bundle();
                    args.putParcelable(MessagesFragment.MESSAGES, new Wrapp(messages));
                    mFragment.setArguments(args);

                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container_frame_layout, mFragment);
                    fragmentTransaction.commit();



                }).execute();
                break;
            case R.id.nav_friends:
                Intent intent = new Intent(this, FriendsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_groups:
                Intent intent2 = new Intent(this, ExampleActivity.class);
                startActivity(intent2);
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

        mFragment = new MessagesFragment();

        final Bundle args = new Bundle();
        args.putParcelable(MessagesFragment.MESSAGES, new Wrapp(messages));

        mFragment.setArguments(args);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_frame_layout, mFragment);
        fragmentTransaction.commit();
    }
}
