package by.laligulbani.vk.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import by.laligulbani.vk.R;
import by.laligulbani.vk.ui.fragment.DialogFragment;
import by.laligulbani.vk.ui.fragment.FriendsViewPagerFragment;

import static android.support.v4.view.GravityCompat.START;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private CharSequence title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        drawer.addDrawerListener(toggle);

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this::onSelected);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(START)) {
            drawer.closeDrawer(START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        return item.getItemId() == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    private boolean onSelected(final MenuItem item) {

        final int id = item.getItemId();

        switch (id) {
            case R.id.nav_news:
                getSupportActionBar().setTitle("Новости");
                break;
            case R.id.nav_notification:
                break;
            case R.id.nav_messanges:
                getSupportActionBar().setTitle("Сообщения");
                replaceMessageFragment(new DialogFragment());
                break;
            case R.id.nav_friends:
                getSupportActionBar().setTitle("Друзья");
                replaceFriendsFragment(new FriendsViewPagerFragment());
                break;
            case R.id.nav_groups:
                break;
            case R.id.nav_photo:
                break;
            default: {
                drawer.closeDrawer(START);
            }
        }
        return true;
    }

    private void replaceMessageFragment(final Fragment fragment) {
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private void replaceFriendsFragment(final android.support.v4.app.Fragment fragment) {
        final android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
