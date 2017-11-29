package by.laligulbani.vk.presenter.recycleViewMessanger;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import by.laligulbani.vk.R;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Messenger> list;

    public Adapter(List<Messenger> list) {
        this.list = list;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_messanger, parent, false);
        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        Messenger messenger = list.get(position);

        holder.textMessage.setText(messenger.getMessage());
        holder.from_whom.setText(messenger.getPersonSend());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textMessage;
        TextView from_whom;
        ImageView image;


        public ViewHolder(View itemView) {
            super(itemView);

            textMessage = (TextView) itemView.findViewById(R.id.message);
            from_whom = (TextView) itemView.findViewById(R.id.from_whom);
            image = (ImageView) itemView.findViewById(R.id.imgPerson);


        }
    }
}

