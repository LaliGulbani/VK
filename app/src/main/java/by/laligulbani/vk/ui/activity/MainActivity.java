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
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import by.laligulbani.vk.R;
import by.laligulbani.vk.model.service.executor.IExecutorServiceFactory;
import by.laligulbani.vk.model.service.image.IImageServiceFactory;
import by.laligulbani.vk.model.service.image.entity.ImageRequest;
import by.laligulbani.vk.model.service.user.IUserServiceFactory;
import by.laligulbani.vk.ui.fragment.DialogFragment;
import by.laligulbani.vk.ui.fragment.FriendsViewPagerFragment;
import by.laligulbani.vk.ui.task.Task;

import static android.support.v4.view.GravityCompat.START;
import static by.laligulbani.vk.Api.EMPTY;
import static by.laligulbani.vk.ui.activity.LoginActivity.APP_PREFERENCES_NAME;
import static by.laligulbani.vk.ui.activity.LoginActivity.PREFERENCES_TOKEN;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;


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

        View hView = navigationView.getHeaderView(0);
        TextView nameUser = (TextView)hView.findViewById(R.id.profile_name);
        ImageView imageUser = (ImageView)hView.findViewById(R.id.drawer_profile_image);

        final String token = getSharedPreferences(APP_PREFERENCES_NAME, 0)
                .getString(PREFERENCES_TOKEN, EMPTY);

        IExecutorServiceFactory.getInstance().executeOnExecutor(new Task<>(
                () -> IUserServiceFactory.getInstance().getMainUser(token),
                (mainUser) -> {
                    nameUser.setText(String.format("%s %s", mainUser.getFirstName(), mainUser.getLastName()));

                    IImageServiceFactory.getInstance().enqueue(new ImageRequest.Builder()
                            .load(mainUser.getPhoto50())
                            .into(imageUser)
                            .build());
                }
        ));

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
