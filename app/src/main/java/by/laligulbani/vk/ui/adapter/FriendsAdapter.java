package by.laligulbani.vk.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import by.laligulbani.vk.R;
import by.laligulbani.vk.entity.users.UserFull;

import static java.lang.String.format;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendsHolder> {

    private final List<UserFull> friends;
    private ClickListener clicklistener = null;

    public FriendsAdapter(final List<UserFull> friends) {
        this.friends = friends;
    }

    @Override
    public FriendsHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        final View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_friends, parent, false);

        return new FriendsHolder(view);
    }

    @Override
    public void onBindViewHolder(final FriendsHolder holder, final int position) {

        final UserFull friend = friends.get(position);

        holder.nameFriend.setText(format("%s %s", friend.getFirstName(), friend.getLastName()));
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    class FriendsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView nameFriend;

        FriendsHolder(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nameFriend = (TextView) itemView.findViewById(R.id.name_friend_text_view);
        }

        @Override
        public void onClick(View v) {
            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }
}

