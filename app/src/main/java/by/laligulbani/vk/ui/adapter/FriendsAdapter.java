package by.laligulbani.vk.ui.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import by.laligulbani.vk.R;
import by.laligulbani.vk.entity.friends.Friends;


public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendsHolder> {

    private List<Friends> friends;

    public FriendsAdapter(List<Friends> friends) {
        this.friends = friends;
    }

    @Override
    public FriendsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friends, parent, false);
        return new FriendsHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendsHolder holder, int position) {
        Friends friend = friends.get(position);
        holder.nameFriend.setText(friend.getName());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }


    class FriendsHolder extends RecyclerView.ViewHolder {
        TextView nameFriend;

        FriendsHolder(View itemView) {
            super(itemView);
            nameFriend = (TextView) itemView.findViewById(R.id.name_friend_text_view);

        }
    }
}

