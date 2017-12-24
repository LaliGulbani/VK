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
import by.laligulbani.vk.model.facade.dto.DialogDto;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {

    private final List<DialogDto> dialogs;

    public MessageAdapter(final List<DialogDto> dialogs) {
        this.dialogs = dialogs;
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

        final DialogDto dialog = this.dialogs.get(position);

        holder.from.setText(dialog.getFrom());
        holder.time.setText(dialog.getDate());
        holder.message.setText(dialog.getBody());
        holder.avatar.setImageBitmap(dialog.getImage());
    }

    @Override
    public int getItemCount() {
        return dialogs.size();
    }

    class MessageHolder extends ViewHolder {

        private final ImageView avatar;
        private final TextView message;
        private final TextView from;
        private final TextView time;

        MessageHolder(final View itemView) {
            super(itemView);
            this.avatar = (ImageView) itemView.findViewById(R.id.profile_avatar_image_view);
            this.message = (TextView) itemView.findViewById(R.id.message_text_view);
            this.time = (TextView) itemView.findViewById(R.id.time_message_text_view);
            this.from = (TextView) itemView.findViewById(R.id.name_friend_text_view);
        }
    }
}
