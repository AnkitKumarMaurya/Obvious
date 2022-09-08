package com.smarthub.obvious.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.smarthub.obvious.R;
import com.smarthub.obvious.listeners.ImageClickListener;
import com.smarthub.obvious.model.ImageListItem;
import com.smarthub.obvious.utils.AppLogger;

import java.util.ArrayList;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHold> {

    ImageClickListener imageClickListener;
    ArrayList<ImageListItem> imageListItems;

    public ImageListAdapter(ArrayList<ImageListItem> imageListItems,ImageClickListener imageClickListener) {
        this.imageListItems = imageListItems;
        this.imageClickListener = imageClickListener;
    }

    @NonNull
    @Override
    public ViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_view,parent,false);
        return new ViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHold holder, int position) {
        AppLogger.d(" pos : "+ position+", url :"+ imageListItems.get(position).getUrl());
        Glide.with(holder.imageView).
                load(imageListItems.get(position).getUrl()).
                into(holder.imageView);
        holder.itemView.setOnClickListener(v -> imageClickListener.clickItem(position));
    }

    @Override
    public int getItemCount() {
        return (imageListItems!=null) ? imageListItems.size() : 0;
    }

    public class ViewHold extends RecyclerView.ViewHolder{

        ImageView imageView;
        public ViewHold(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
