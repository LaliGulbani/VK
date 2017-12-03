package by.laligulbani.vk.presenter.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import by.laligulbani.vk.presenter.recycleViewMessanger.Message;

public class MessagesFragment extends Fragment {

    private SwipeRefreshLayout mSwipeRefreshLayoutMessage;
    private RecyclerView mRecycleViewMessage;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View root = inflater.inflate(R.layout.fragment_root_message, container, false);

        mSwipeRefreshLayoutMessage = (SwipeRefreshLayout) root.findViewById(R.id.swipe_container_message);
        mSwipeRefreshLayoutMessage.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.CYAN);

        mRecycleViewMessage = (RecyclerView) root.findViewById(R.id.recyclerView_messages);
        mRecycleViewMessage.setLayoutManager(new LinearLayoutManager(getActivity()));

        private class MessageHolder extends RecyclerView.ViewHolder {
            public ImageView mAvatar;
            public TextView mTextMessage;
            public TextView mFromWhom;
            public TextView mTimeMessage;
            public TextView mCountMessage;

            public MessageHolder(View itemView) {
                super(itemView);
                mAvatar = (ImageView) itemView.findViewById(R.id.avatar_who_send_message_image_view);
                mTextMessage = (TextView) itemView.findViewById(R.id.message_text_view);
                mTimeMessage = (TextView) itemView.findViewById(R.id.time_message_text_view);
                mFromWhom = (TextView) itemView.findViewById(R.id.from_whom_message_text_view);
                mCountMessage = (TextView) itemView.findViewById(R.id.count_message_text_view);
            }
        }

        private class MessageAdapter extends RecyclerView.Adapter<MessageHolder>{
            private List<Message> mMessage;
            public MessageAdapter(List<Message> message){
                mMessage = message;
            }

            @Override
            public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType){
                LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
                View view = layoutInflater.inflate(R.layout.fragment_item_message, parent, false);
                return new MessageHolder(view);
            }
            @Override
            public void onBindViewHolder(MessageHolder holder, int position) {
                Message message = mMessage.get(position);
                holder.mFromWhom.setText(message.getTitle());
            }

            @Override
            public int getItemCount() {
                return mMessage.size();
            }
        }



        return root;
    }


}

