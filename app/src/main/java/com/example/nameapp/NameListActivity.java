package com.example.nameapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class NameListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    //private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private final String image_titles[] = {
            "Sebastian","Daniel","Fedme",
    };
    private final Integer image_ids[] = {
            R.drawable.img1, R.drawable.img2, R.drawable.img3,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.list_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getApplicationContext());

        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<CreateList> createLists = prepareData();

        listAdapter mAdapter = new listAdapter(getApplicationContext(), createLists);
        mRecyclerView.setAdapter(mAdapter);
    }

    private ArrayList<CreateList> prepareData(){
        ArrayList<CreateList> names = new ArrayList<>();
        for(int i = 0; i < image_titles.length; i++){
            CreateList createList = new CreateList();
            createList.setImage_title(image_titles[i]);
            createList.setImage_ID(image_ids[i]);
            names.add(createList);
        }
        return names;
    }
}
