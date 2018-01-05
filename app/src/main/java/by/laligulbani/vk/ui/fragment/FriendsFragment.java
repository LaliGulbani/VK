package by.laligulbani.vk.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.laligulbani.vk.R;
import by.laligulbani.vk.model.service.executor.IExecutorServiceFactory;
import by.laligulbani.vk.model.service.user.IUserServiceFactory;
import by.laligulbani.vk.ui.activity.MainActivity;
import by.laligulbani.vk.ui.activity.MessageListActivity;
import by.laligulbani.vk.ui.adapter.IClickListener;
import by.laligulbani.vk.ui.adapter.FriendsAdapter;
import by.laligulbani.vk.ui.task.Task;

import static by.laligulbani.vk.Api.EMPTY;
import static by.laligulbani.vk.ui.activity.LoginActivity.APP_PREFERENCES_NAME;
import static by.laligulbani.vk.ui.activity.LoginActivity.PREFERENCES_TOKEN;

public class FriendsFragment extends Fragment implements IClickListener {

    private RecyclerView recyclerViewFriends;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle saveInstanceState) {
        return inflater.inflate(R.layout.fragment_root_recycle_view, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.recyclerViewFriends = (RecyclerView) view.findViewById(R.id.recycler_view);
        this.recyclerViewFriends.setLayoutManager(new LinearLayoutManager(getActivity()));
        FriendsAdapter friendsAdapter = new FriendsAdapter(friends);

        updateFriends();
    }

    private void updateFriends() {

        final String token = getActivity()
                .getSharedPreferences(APP_PREFERENCES_NAME, 0)
                .getString(PREFERENCES_TOKEN, EMPTY);

        IExecutorServiceFactory.getInstance().executeOnExecutor(new Task<>(
                () -> IUserServiceFactory.getInstance().getFriends(token),
                (friends) -> this.recyclerViewFriends.setAdapter(new FriendsAdapter(friends))));

        friendsAdapter.setClickListener(this);
    }

    @Override
    public void itemClicked(View view, int position) {
        Intent intent = new Intent(MainActivity.this, MessageListActivity.class);
        startActivity(intent);


    }
}
