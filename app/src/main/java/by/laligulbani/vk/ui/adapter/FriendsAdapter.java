package by.laligulbani.vk.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import by.laligulbani.vk.R;
import by.laligulbani.vk.model.facade.dto.UserDto;
import by.laligulbani.vk.model.facade.user.IUserFacade;
import by.laligulbani.vk.model.service.image.entity.ImageRequest;

import static java.lang.String.format;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendsHolder> {

    private final List<UserDto> friends;
    private final IUserFacade userFacade;
    private OnItemClickListener listener;

    public FriendsAdapter(final IUserFacade userFacade, final List<UserDto> friends) {
        this.friends = friends;
        this.userFacade = userFacade;
    }

    @Override
    public FriendsHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        final View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_friends, parent, false);

        return new FriendsHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(final FriendsHolder holder, final int position) {

        final UserDto friend = friends.get(position);

        holder.nameFriend.setText(format("%s %s", friend.getFirstName(), friend.getLastName()));

        userFacade.getImage(new ImageRequest.Builder()
                .load(friend.getImage())
                .into(holder.avatar)
                .build());
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }


    class FriendsHolder extends RecyclerView.ViewHolder{

        private final TextView nameFriend;
        private final ImageView avatar;

        FriendsHolder(final View itemView, OnItemClickListener listener) {
            super(itemView);

            nameFriend = (TextView) itemView.findViewById(R.id.name_friend_text_view);
            avatar = (ImageView) itemView.findViewById(R.id.profile_avatar_friend_image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);

                        }
                    }
                }
            });
        }
    }
}

