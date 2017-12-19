package by.laligulbani.vk.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import by.laligulbani.vk.ui.fragment.FriendsListFragment;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new FriendsListFragment();
            //транзакция?
        }
        else if (position == 1)
        {
            fragment = new FriendsListFragment();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Все друзья";
        }
        else if (position == 1)
        {
            title = "Друзья онлайн";
        }

        return title;
    }
}
