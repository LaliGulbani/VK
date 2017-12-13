package by.laligulbani.vk.ui.fragment;

import android.annotation.SuppressLint;
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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import by.laligulbani.vk.R;
import by.laligulbani.vk.entity.messages.Message;
import by.laligulbani.vk.model.management.ModelManagementFactory;
import by.laligulbani.vk.presenter.task.GetMessageTask;

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

    class MessageHolder extends RecyclerView.ViewHolder {

        private ImageView mAvatar;
        private TextView mTextMessage;
        private TextView mFromWhom;
        private TextView mTimeMessage;
        private TextView mCountMessage;

        MessageHolder(View itemView) {
            super(itemView);
            mAvatar = (ImageView) itemView.findViewById(R.id.profile_avatar_image_view);
            mTextMessage = (TextView) itemView.findViewById(R.id.message_text_view);
            mTimeMessage = (TextView) itemView.findViewById(R.id.time_message_text_view);
            mFromWhom = (TextView) itemView.findViewById(R.id.from_whom_message_text_view);
            mCountMessage = (TextView) itemView.findViewById(R.id.count_message_text_view);
        }
    }

    class MessageAdapter extends RecyclerView.Adapter<MessageHolder> {

        private List<Message> mMessage;

        MessageAdapter(List<Message> message) {
            this.mMessage = message;
        }

        @Override
        public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater
                    .from(getActivity())
                    .inflate(R.layout.fragment_item_message, parent, false);
            return new MessageHolder(view);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(MessageHolder holder, int position) {
            Message message = mMessage.get(position);
            holder.mFromWhom.setText(Long.toString(message.getId()));
            //holder.mCountMessage.setText();
            holder.mTimeMessage.setText(message.getDate());
            holder.mTextMessage.setText(message.getBody());
//                Malevich.INSTANCE.load(messageModel.getUrl()).into(pHolder.mImageView);
        }

        @Override
        public int getItemCount() {
            return mMessage.size();
        }
    }
}

