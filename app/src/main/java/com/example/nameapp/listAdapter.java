package com.example.nameapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.view.Gravity.CENTER_VERTICAL;
import static com.example.nameapp.R.id.img;

/**
 * Created by Sebastian on 23.01.2017.
 */

public class listAdapter extends RecyclerView.Adapter<listAdapter.ViewHolder>{
    private ArrayList<CreateList> mDataset;
    private Context context;
    private View rootView;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView name;
        public ViewHolder(View v) {
            super(v);
            name = (TextView) itemView.findViewById(R.id.name);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }

    public listAdapter(Context context, ArrayList<CreateList> mDataset){
        this.mDataset = mDataset;
        this.context = context;
    }

    //Create new views (invoked by the alyout manager)
    @Override
    public listAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        //create new view
        rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_layout, parent, false);

        //set the view's size, margins, paddings and layout parameters

        return new ViewHolder(rootView);
    }

    //Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        //get element from your dataset at this position
        // replace the contents of the view with that element
        holder.name.setText(mDataset.get(position).getImage_title());
        //holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //holder.img.setImageResource(mDataset.get(position).getImage_ID());

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, mDataset.get(position).getImage_title(), Toast.LENGTH_SHORT).show();
                //ImageView imageView = (ImageView)rootView.findViewById(R.id.img);
                holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
                holder.img.setImageResource(mDataset.get(position).getImage_ID());
            }
        });
        holder.img.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v){
               holder.img.setImageDrawable(null);
           }
        });
        //holder.mImageView.setImageURI(Uri.parse(mDataset.get(position)));
    }

    //return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount(){
        return mDataset.size();
    }
}
