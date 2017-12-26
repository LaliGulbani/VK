package by.laligulbani.vk.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.laligulbani.vk.R;
import by.laligulbani.vk.model.service.executor.IExecutorServiceFactory;
import by.laligulbani.vk.model.service.user.IUserServiceFactory;
import by.laligulbani.vk.ui.adapter.FriendsAdapter;
import by.laligulbani.vk.ui.adapter.ViewPagerAdapter;
import by.laligulbani.vk.ui.task.Task;

import static by.laligulbani.vk.ui.activity.LoginActivity.APP_PREFERENCES_NAME;
import static by.laligulbani.vk.ui.activity.LoginActivity.PREFERENCES_TOKEN;

public class FriendsFragment extends Fragment {

    private RecyclerView recyclerViewFriends;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle saveInstanceState) {
        return inflater.inflate(R.layout.fragment_root_friends, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager viewPager = (ViewPager)view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new ViewPagerAdapter(getActivity().getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        this.recyclerViewFriends = (RecyclerView) view.findViewById(R.id.recycleView_friends);
        this.recyclerViewFriends.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateFriends();
    }

    private void updateFriends() {

        final String token = getActivity()
                .getSharedPreferences(APP_PREFERENCES_NAME, 0)
                .getString(PREFERENCES_TOKEN, "");

        IExecutorServiceFactory.getInstance().executeOnExecutor(new Task<>(
                () -> IUserServiceFactory.getInstance().getFriends(token),
                (friends) -> this.recyclerViewFriends.setAdapter(new FriendsAdapter(friends))));
    }
}
