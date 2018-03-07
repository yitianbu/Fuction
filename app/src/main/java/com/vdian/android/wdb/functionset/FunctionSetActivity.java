package com.vdian.android.wdb.functionset;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

public class FunctionSetActivity extends AppCompatActivity {

    private RecyclerView activityContentRv;
    private RecyclerView.Adapter mContentAdapter;
    private String[] activityNames = new String[]{"ScrollView嵌套","NestScrollView使用"};
    private Class[] activities = new Class[]{ScrollViewNestActivity.class,ScrollViewNestActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_set);
        initView();
        initData();


    }

    private void initData() {
        mContentAdapter = new RecyclerView.Adapter() {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new ActivityItemHolder(LayoutInflater.from(FunctionSetActivity.this).inflate(R.layout.recycle_item_activity_name,parent,false));
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, final int position) {
                ((ActivityItemHolder)holder).activityNameTv.setText(activityNames[position]);
                ((ActivityItemHolder)holder).contentView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FunctionSetActivity.this, activities[0]);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return activityNames.length;
            }
        };
        activityContentRv.setAdapter(mContentAdapter);
        activityContentRv.setLayoutManager(new LinearLayoutManager(FunctionSetActivity.this));
        activityContentRv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }

    public static final class ActivityItemHolder extends ViewHolder {
        public TextView activityNameTv;
        public View contentView;

        public ActivityItemHolder(View itemView) {
            super(itemView);
            activityNameTv = (TextView) itemView.findViewById(R.id.tv_activity_name);
            contentView = itemView;
        }
    }

    private void initView() {
        activityContentRv = (RecyclerView) findViewById(R.id.rv_activity_content);
    }
}
