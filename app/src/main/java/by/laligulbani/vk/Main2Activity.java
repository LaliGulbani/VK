package by.laligulbani.vk;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import by.laligulbani.vk.model.entity.message.Item;
import by.laligulbani.vk.model.management.IModelManagement;
import by.laligulbani.vk.presenter.recycleViewMessanger.Adapter;
import by.laligulbani.vk.presenter.recycleViewMessanger.Messenger;
import by.laligulbani.vk.presenter.recycleViewNews.Message;
import by.laligulbani.vk.presenter.recycleViewNews.MyCustomAdapter;
import by.laligulbani.vk.presenter.task.Callback;
import by.laligulbani.vk.presenter.task.GetMessageTask;

import static by.laligulbani.vk.ui.login.LoginActivity.PREFERENCES_TOKEN;
import static by.laligulbani.vk.ui.login.LoginActivity.mPreferences;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private List<Message> list;
    RecyclerView recycle_message;
    private String mToken;


    public IModelManagement modelManager;


    private RecyclerView recycleView;
    private LinearLayoutManager verticalLinearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recycle_message = (RecyclerView)findViewById(R.id.recyclerView_messanger);
        mToken = mPreferences.getString(PREFERENCES_TOKEN, "не определено");



        recycleView = (RecyclerView) findViewById(R.id.recyclerView);

        verticalLinearLayoutManager = new LinearLayoutManager(this);
        //horizontalLinearLayoutManager = new LinearLayoutManager(this);

        recycleView.setLayoutManager(verticalLinearLayoutManager);
        recycleView.setHasFixedSize(true);

        MyCustomAdapter adapter = new MyCustomAdapter(initData());
        recycleView.setAdapter(adapter);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    private List<Message> initData() {
        list = new ArrayList<>();
        list.add(new Message("a","a",R.mipmap.ic_launcher,R.string.action_settings));
        return list;
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        switch (id) {
            case R.id.nav_news:
                /*ContentFragment fragment = new ContentFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame,fragment);
                fragmentTransaction.commit();
                */
                return true;
            case R.id.nav_notification:
                return true;
            case R.id.nav_messengers:
                new GetMessageTask(modelManager, mToken, new Callback() {
                    @Override
                    public void setText(List<Messenger> listItem) {
                        Adapter adapterMessage = new Adapter(listItem);
                        recycle_message.setAdapter(adapterMessage);

                    }
                });
                return true;
            case R.id.nav_friends:
                return true;
            case R.id.nav_groups:
                return true;
            case R.id.nav_photo:
                return true;

        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
