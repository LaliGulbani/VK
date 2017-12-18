package by.laligulbani.vk.ui.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.laligulbani.vk.R;
import by.laligulbani.vk.model.management.ModelManagementFactory;
import by.laligulbani.vk.presenter.task.GetMessageTask;
import by.laligulbani.vk.ui.adapter.MessageAdapter;

import static by.laligulbani.vk.ui.activity.LoginActivity.APP_PREFERENCES_NAME;
import static by.laligulbani.vk.ui.activity.LoginActivity.PREFERENCES_TOKEN;

public class MessagesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState) {
        View root = inflater.inflate(R.layout.fragment_root_message, container, false);

        SwipeRefreshLayout swipeRefreshLayoutMessage = (SwipeRefreshLayout) root.findViewById(R.id.swipe_container_message);
        swipeRefreshLayoutMessage.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.CYAN);

        RecyclerView mRecycleViewMessage = (RecyclerView) root.findViewById(R.id.recyclerView_messages);
        mRecycleViewMessage.setLayoutManager(new LinearLayoutManager(getActivity()));

        final String mToken = getActivity()
                .getSharedPreferences(APP_PREFERENCES_NAME, 0)
                .getString(PREFERENCES_TOKEN, "");

        new GetMessageTask(ModelManagementFactory.getInstance(), mToken, (messages) -> {
            mRecycleViewMessage.setAdapter(new MessageAdapter(messages));
        }).execute();

        return root;
    }

}

