package by.laligulbani.vk.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import by.laligulbani.vk.ui.adapter.MessageAdapter;

public class MessageListActivity extends AppCompatActivity {
//TODO сделать фрагментом
    private RecyclerView messageRecycler;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        messageRecycler = (RecyclerView) findViewById(R.id.reyclerview_message_list);
        messageAdapter = new MessageAdapter(this, messageList);
        messageRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
}
