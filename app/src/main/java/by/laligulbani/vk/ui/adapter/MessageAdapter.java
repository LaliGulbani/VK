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

    private List<Message> messages;

    public MessageAdapter(List<Message> message) {
        this.messages = message;
    }

    @Override
    public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_message, parent, false);
        return new MessageHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MessageHolder holder, int position) {
        Message message = messages.get(position);
        holder.fromWhom.setText(message.getId());
//      holder.countMessage.setText();
        holder.timeMessage.setText(message.getDate());
        holder.textMessage.setText(message.getBody());
//      Malevich.INSTANCE.load(messageModel.getUrl()).into(pHolder.mImageView);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class MessageHolder extends RecyclerView.ViewHolder {

        private final ImageView avatar;
        private final TextView textMessage;
        private final TextView fromWhom;
        private final TextView timeMessage;
        private final TextView countMessage;

        MessageHolder(View itemView) {
            super(itemView);
            avatar = (ImageView) itemView.findViewById(R.id.profile_avatar_image_view);
            textMessage = (TextView) itemView.findViewById(R.id.message_text_view);
            timeMessage = (TextView) itemView.findViewById(R.id.time_message_text_view);
            fromWhom = (TextView) itemView.findViewById(R.id.name_friend_text_view);
            countMessage = (TextView) itemView.findViewById(R.id.count_message_text_view);
        }
    }
}
