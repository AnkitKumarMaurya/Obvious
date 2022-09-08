package com.smarthub.obvious.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.smarthub.obvious.R;
import com.smarthub.obvious.model.ImageListItem;
import com.smarthub.obvious.utils.AppLogger;

import java.util.ArrayList;

public class ImageDetailsAdapter extends RecyclerView.Adapter<ImageDetailsAdapter.ViewHold> {

    ArrayList<ImageListItem> imageListItems;

    public ImageDetailsAdapter(ArrayList<ImageListItem> imageListItems) {
        this.imageListItems = imageListItems;
    }

    @NonNull
    @Override
    public ViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new ViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHold holder, int position) {
        AppLogger.d(" pos : "+ position+", url :"+ imageListItems.get(position).getUrl());
        Glide.with(holder.imageView).
                load(imageListItems.get(position).getUrl()).
                into(holder.imageView);
        holder.textTitle.setText(imageListItems.get(position).getTitle());
        holder.textCopyright.setText(imageListItems.get(position).getCopyright());
        holder.textDate.setText(imageListItems.get(position).getDate());
        holder.textType.setText(imageListItems.get(position).getMedia_type());
        holder.textVersion.setText(imageListItems.get(position).getService_version());
        holder.explanation.setText(imageListItems.get(position).getExplanation());
    }

    @Override
    public int getItemCount() {
        return (imageListItems!=null) ? imageListItems.size() : 0;
    }

    public class ViewHold extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textTitle;
        TextView textCopyright;
        TextView textDate;
        TextView textType;
        TextView textVersion;
        TextView explanation;
        public ViewHold(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textTitle = itemView.findViewById(R.id.text_title);
            textCopyright = itemView.findViewById(R.id.text_copyright);
            textDate = itemView.findViewById(R.id.text_date);
            textType = itemView.findViewById(R.id.text_type);
            textVersion = itemView.findViewById(R.id.text_version);
            explanation = itemView.findViewById(R.id.explanation);
        }
    }
}
