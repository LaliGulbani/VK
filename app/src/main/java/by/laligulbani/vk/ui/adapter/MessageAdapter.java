package by.laligulbani.vk.ui.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import by.laligulbani.vk.R;
import by.laligulbani.vk.entity.messages.Message;


public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {

    private List<Message> mMessage;

    public MessageAdapter(List<Message> message) {
        this.mMessage = message;
    }

    @Override
    public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.fragment_item_message, parent, false);
        return new MessageHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(MessageHolder holder, int position) {
        Message message = mMessage.get(position);
        holder.mFromWhom.setText(message.getId());
        //holder.mCountMessage.setText();
        holder.mTimeMessage.setText(message.getDate());
        holder.mTextMessage.setText(message.getBody());
//                Malevich.INSTANCE.load(messageModel.getUrl()).into(pHolder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mMessage.size();
    }

    class MessageHolder extends RecyclerView.ViewHolder {

        ImageView mAvatar;
        TextView mTextMessage;
        TextView mFromWhom;
        TextView mTimeMessage;
        TextView mCountMessage;

        MessageHolder(View itemView) {
            super(itemView);
            mAvatar = (ImageView) itemView.findViewById(R.id.profile_avatar_image_view);
            mTextMessage = (TextView) itemView.findViewById(R.id.message_text_view);
            mTimeMessage = (TextView) itemView.findViewById(R.id.time_message_text_view);
            mFromWhom = (TextView) itemView.findViewById(R.id.from_whom_message_text_view);
            mCountMessage = (TextView) itemView.findViewById(R.id.count_message_text_view);
        }
    }
}
