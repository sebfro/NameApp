package com.example.nameapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by sebas on 18.01.2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private ArrayList<CreateList> mDataset;
    private ArrayList<MainActivity.T> newImgs;
    private Context context;
    private final String DEBUG_TAG = "Error";

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public ViewHolder(View v) {
            super(v);
            img = (ImageView) itemView.findViewById(R.id.images);
        }
    }

    public MyAdapter(Context context, ArrayList<CreateList> myDataset, ArrayList<MainActivity.T> newImgs){
        this.newImgs = newImgs;
        mDataset = myDataset;
        this.context = context;
    }

    //Create new views (invoked by the alyout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        //create new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_layout, parent, false);

        //set the view's size, margins, paddings and layout parameters

        return new ViewHolder(v);
    }

    //Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        //get element from your dataset at this position
        // replace the contents of the view with that element
            if (position < 3) {
                holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
                holder.img.setImageResource(mDataset.get(position).getImage_ID());
            } else {
                Log.d(DEBUG_TAG, "About to print pic.");
                holder.img.setImageDrawable(newImgs.get(position-3).getD());
            }

            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position < 3) {
                        Toast.makeText(context, mDataset.get(position).getImage_title(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, newImgs.get(position-3).getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            //holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //holder.img.setImageDrawable(newImgs.get(0));

        //holder.mImageView.setImageURI(Uri.parse(mDataset.get(position)));
    }

    //return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount(){
        return mDataset.size() + newImgs.size();
    }
}
