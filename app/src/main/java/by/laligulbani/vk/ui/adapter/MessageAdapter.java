package by.laligulbani.vk.ui.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import by.laligulbani.vk.R;
import by.laligulbani.vk.entity.messages.Message;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {

    private final List<Message> messages;

    public MessageAdapter(final List<Message> message) {
        this.messages = message;
    }

    @Override
    public MessageHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        final View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_message, parent, false);

        return new MessageHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MessageHolder holder, final int position) {

        final Message message = messages.get(position);

        holder.from.setText(message.getId());
        holder.time.setText(message.getDate());
        holder.message.setText(message.getBody());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class MessageHolder extends ViewHolder {

        private final ImageView avatar;
        private final TextView message;
        private final TextView from;
        private final TextView time;
        //private fin//al TextView count;

        MessageHolder(final View itemView) {
            super(itemView);
            this.avatar = (ImageView) itemView.findViewById(R.id.profile_avatar_image_view);
            this.message = (TextView) itemView.findViewById(R.id.message_text_view);
            this.time = (TextView) itemView.findViewById(R.id.time_message_text_view);
            this.from = (TextView) itemView.findViewById(R.id.name_friend_text_view);
          // this.count = (TextView) itemView.findViewById(R.id.count_message_text_view);
        }
    }
}
