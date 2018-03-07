package com.vdian.android.wdb.functionset;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScrollViewNestActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Integer> numbers = new ArrayList<>();
    private static int i,j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view_nest);
        initView();
        initData();
    }

    private void initData() {
        for (int i = 0; i <100 ; i++) {
            numbers.add(i);
        }

        adapter = new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                Log.e("wf","onCreate"+(++i));
                return new ActivityItemHolder(LayoutInflater.from(ScrollViewNestActivity.this).inflate(R.layout.recycle_item_activity_name,parent,false));
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
                ((ActivityItemHolder)holder).activityNameTv.setText(""+numbers.get(position));
                Log.e("wf","onBind"+(++j));
            }

            @Override
            public int getItemCount() {
                return numbers.size();
            }
        };

        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ScrollViewNestActivity.this){
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_number_content);
    }

    public static final class ActivityItemHolder extends RecyclerView.ViewHolder {
        public TextView activityNameTv;

        public ActivityItemHolder(View itemView) {
            super(itemView);
            activityNameTv = (TextView) itemView.findViewById(R.id.tv_activity_name);
        }
    }


}
