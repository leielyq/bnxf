package com.bnxf.bnxf.test;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bnxf.bnxf.R;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by leiel on 2018/2/23 0023.
 */

public class TestViewBinder extends ItemViewBinder<TestItem,TestViewBinder.TestHolder> {

    @NonNull
    @Override
    protected TestHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_test, parent, false);
        return new TestHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull TestHolder holder, @NonNull TestItem item) {
        holder.textView.setText("hello: " + item.text);

        Log.d("TestViewBinder", item.text);
    }

    static class TestHolder extends RecyclerView.ViewHolder {
        private @NonNull
        final TextView textView;

        public TestHolder(View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.item_test_text);
        }
    }

}
