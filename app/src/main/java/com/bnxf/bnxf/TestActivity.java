package com.bnxf.bnxf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.bnxf.bnxf.app.net.NetUrl;
import com.bnxf.bnxf.app.net.NetWork;
import com.bnxf.bnxf.test.TestItem;
import com.bnxf.bnxf.test.TestViewBinder;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class TestActivity extends AppCompatActivity {
    private MultiTypeAdapter adapter;
    private Items items;
    private RecyclerView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mList = findViewById(R.id.activity_test_list);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        mList.setLayoutManager(linearLayoutManager);
        adapter = new MultiTypeAdapter();
        adapter.register(TestItem.class,new TestViewBinder());
        mList.setAdapter(adapter);

        mList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                final int itemCount = linearLayoutManager.getItemCount();
                final int lastVisiblePosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                final boolean isBottom = (lastVisiblePosition >= itemCount - 20);
                if (isBottom) {
                    Toast.makeText(TestActivity.this, "上啦加载", Toast.LENGTH_SHORT).show();
                }
            }
        });

        NetWork.doPost(NetUrl.TEST, null, new NetWork.NetCallBack() {
            @Override
            public void call(String str) {
                Toast.makeText(TestActivity.this, str, Toast.LENGTH_SHORT).show();

                items = new Items();
                String[] split = str.split("");
                for (int i = 0; i < split.length; i++) {
                    items.add(new TestItem(split[i]));
                }
                adapter.setItems(items);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
