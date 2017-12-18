package by.laligulbani.vk.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.laligulbani.vk.R;

public class FriendsFragment extends Fragment {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable
                             Bundle savedInstanceState) {

        View root  = inflater.inflate(R.layout.fragment_root_friends, container, false);

        Toolbar toolbar = (Toolbar) root.findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        viewPager = (ViewPager)root.findViewById(R.id.viewpager);
        //ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        //viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout)root.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        RecyclerView mRecycleViewFriends = (RecyclerView) root.findViewById(R.id.recycleView_friends);
        mRecycleViewFriends.setLayoutManager(new LinearLayoutManager(getActivity()));




        return root;

    }

}





