package com.example.nameapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;

import java.io.File;
import java.util.ArrayList;

import static android.R.attr.path;

public class GalleryActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<MainActivity.T> drawableArrayList;

    private ArrayList<String> image_titles = new ArrayList<String>();
    /*
    private String image_titles[] = {
            "Sebastian","daniel","fedme",
    };
    */

    private ArrayList<Integer> image_ids = new ArrayList<Integer>();
    /*
    private Integer image_ids[] = {
            R.drawable.img1, R.drawable.img2, R.drawable.img3,
    };
    */

    private ArrayList<Drawable> newImgs = new ArrayList<Drawable>();

    private File imgDir = new File("/app/res/drawable/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        //drawableArrayList  = (ArrayList<Drawable>)getIntent().getSerializableExtra("drawableArrayList");
        //drawableArrayList = (ArrayList<Drawable>)getIntent().getParcelableArrayListExtra("drawableArrayList");

        //Bundle extra = getIntent().getExtras();
        drawableArrayList = MainActivity.drawableArrayList;

        image_titles.add("Sebastian");
        image_titles.add("Daniel");
        image_titles.add("Fedme");
        //image_titles.add("Geir");

        image_ids.add(R.drawable.img1);
        image_ids.add(R.drawable.img2);
        image_ids.add(R.drawable.img3);

        //Use this if changes in content do not change the layout size of the recyclerview
        mRecyclerView.setHasFixedSize(true);

        //Use a linear layout manager
        mLayoutManager = new GridLayoutManager(getApplicationContext(),4);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<CreateList> createLists = prepareData();

        //specify an adapter
        mAdapter = new MyAdapter(getApplicationContext(), createLists, drawableArrayList);
        mRecyclerView.setAdapter(mAdapter);

    }



    private ArrayList<CreateList> prepareData(){
        ArrayList<CreateList> images = new ArrayList<>();
        for(int i = 0; i < image_ids.size(); i++){
            CreateList createList = new CreateList();
            createList.setImage_title(image_titles.get(i));
            createList.setImage_ID(image_ids.get(i));
            images.add(createList);
        }


        /*String path = Environment.DIRECTORY_PICTURES;
        File f = new File(path);
        File file[] = f.listFiles();
        for ( int i = 0; i < file.length; i++){
            if (file[i] != null) {
                CreateList createList = new CreateList();
                createList.setImage_Location(file[i].getName());
                images.add(createList);
            }
        }
        */


        return images;
    }
    }

