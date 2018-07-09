package com.kewenc.kewencimagetext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recView;
    private LinearLayoutManager mLayoutManager;
    private List<String> mData = new ArrayList<String>();
    private RecyclerAdapter mAdapter;
    private AppCompatButton btnImageView;
    private AppCompatButton btnEditView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnImageView = findViewById(R.id.btnImageView);
        btnEditView = findViewById(R.id.btnEditView);
        btnImageView.setOnClickListener(this);
        btnEditView.setOnClickListener(this);
        recView = findViewById(R.id.recView);
        mLayoutManager = new LinearLayoutManager(this);
        recView.setLayoutManager(mLayoutManager);
        recView.setHasFixedSize(true);
        mData.add("TextView");
        mData.add("EditText");
        mData.add("ImageView");
        mData.add("TextView");
        mData.add("EditText");
        mData.add("ImageView");
        mAdapter = new RecyclerAdapter(mData);
        recView.setAdapter(mAdapter);
        mAdapter.setOnTtemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,"点击Item："+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void addData(){
        mData.add("哈哈");
        int position = mData.size();
        if (position > 0){
            mAdapter.notifyDataSetChanged();
            recView.scrollToPosition(mData.size() - 1);
        }
    }
    public void delData(){
        int position = mData.size();
        if (position > 0){
            mData.remove(position - 1);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnEditView:
                addData();
                break;
            case R.id.btnImageView:
                delData();
                break;
        }
    }
}
