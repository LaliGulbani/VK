package by.laligulbani.vk.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import by.laligulbani.vk.R;
import by.laligulbani.vk.model.facade.dialog.IDialogFacade;
import by.laligulbani.vk.model.facade.dto.DialogDto;
import by.laligulbani.vk.model.service.image.entity.ImageRequest;
import by.laligulbani.vk.ui.activity.MessageActivity;

public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.MessageHolder> {

    private final List<DialogDto> dialogs;
    private final IDialogFacade dialogFacade;
    Context ctx;

    public DialogAdapter(final IDialogFacade dialogFacade, final List<DialogDto> dialogs, Context ctx) {
        this.dialogFacade = dialogFacade;
        this.dialogs = dialogs;
        this.ctx=ctx;
    }

    @Override
    public MessageHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        final View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_dialog, parent, false);

        return new MessageHolder(view, dialogs, ctx);
    }

    @Override
    public void onBindViewHolder(final MessageHolder holder, final int position) {

        final DialogDto dialog = this.dialogs.get(position);

        holder.from.setText(dialog.getFrom());
        holder.time.setText(dialog.getDate());
        holder.message.setText(dialog.getBody());

        dialogFacade.getImage(new ImageRequest.Builder()
                .load(dialog.getImage())
                .into(holder.avatar)
                .build());
    }

    @Override
    public int getItemCount() {
        return dialogs.size();
    }

    class MessageHolder extends ViewHolder {

        List<DialogDto> dialogs;
        Context ctx;

        private final ImageView avatar;
        private final TextView message;
        private final TextView from;
        private final TextView time;

        MessageHolder(final View itemView, final List<DialogDto> dialogs, Context ctx) {
            super(itemView);
            this.dialogs = dialogs;
            this.ctx = ctx;

            itemView.setOnClickListener(this::onClick);

            this.avatar = (ImageView) itemView.findViewById(R.id.profile_avatar_image_view);
            this.message = (TextView) itemView.findViewById(R.id.message_text_view);
            this.time = (TextView) itemView.findViewById(R.id.time_message_text_view);
            this.from = (TextView) itemView.findViewById(R.id.name_friend_text_view);
        }

        private void onClick(View v) {

            int position = getAdapterPosition();

            DialogDto dialog = this.dialogs.get(position);

            Intent intent = new Intent (ctx, MessageActivity.class);
            intent.putExtra("user_id", dialog.getId());
            intent.putExtra("user_imageUrl", dialog.getImage());
            ctx.startActivity(intent);
        }
    }
}
