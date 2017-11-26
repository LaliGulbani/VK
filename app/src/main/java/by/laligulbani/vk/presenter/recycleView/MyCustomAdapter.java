package by.laligulbani.vk.presenter.recycleView;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import by.laligulbani.vk.R;


public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.ViewHolder> {
    private List<Message> list;

    public MyCustomAdapter(List<Message> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message message = list.get(position);
        holder.imgMsg.setImageResource(message.getResId());
        holder.txtMsg.setText(message.getMsg());
        holder.txtDesc.setText(message.getDesc());
        holder.text.setText(message.getDescId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        TextView txtDesc;
        TextView txtMsg;
        ImageView imgMsg;
        CardView cv;

        public ViewHolder(View itemView){
            super(itemView);

            text = (TextView)itemView.findViewById(R.id.text1);
            txtDesc = (TextView)itemView.findViewById(R.id.txtDesc);
            txtMsg = (TextView)itemView.findViewById(R.id.textMsg);
            imgMsg = (ImageView) itemView.findViewById(R.id.imgMsg);
            cv = (CardView) itemView.findViewById(R.id.card_view);

        }
    }
}
