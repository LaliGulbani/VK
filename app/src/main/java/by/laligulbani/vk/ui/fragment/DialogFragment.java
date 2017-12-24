package by.laligulbani.vk.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import by.laligulbani.vk.R;
import by.laligulbani.vk.model.function.Consumer;
import by.laligulbani.vk.model.function.Runnable;
import by.laligulbani.vk.ui.adapter.MessageAdapter;
import by.laligulbani.vk.model.facade.dto.DialogDto;
import by.laligulbani.vk.ui.task.Task;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.CYAN;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static by.laligulbani.vk.ui.activity.LoginActivity.APP_PREFERENCES_NAME;
import static by.laligulbani.vk.ui.activity.LoginActivity.PREFERENCES_TOKEN;
import static by.laligulbani.vk.model.facade.dialog.IDialogFacadeFactory.getInstance;

public class DialogFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle saveInstanceState) {
        return inflater.inflate(R.layout.fragment_root_message, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_messages);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final SwipeRefreshLayout layout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container_message);
        layout.setColorSchemeColors(RED, GREEN, BLUE, CYAN);
        //layout.setOnRefreshListener(this::updateMessages);

        updateMessages();
    }

    private void updateMessages() {

        final String token = getActivity()
                .getSharedPreferences(APP_PREFERENCES_NAME, 0)
                .getString(PREFERENCES_TOKEN, "");

        new Task((Runnable<List<DialogDto>>) () -> getInstance().getDialogs(token),
                (Consumer<List<DialogDto>>) (messages) -> this.recyclerView.setAdapter(new MessageAdapter(messages)))
                .execute();
    }
}

