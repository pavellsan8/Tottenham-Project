package com.example.uts_mcs;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterGalleryData extends RecyclerView.Adapter<AdapterGalleryData.MyViewHolder> {
    Context context;
    ArrayList<gallery> galleryArrayList;
    LayoutInflater layoutInflater;

    public AdapterGalleryData(Context context, ArrayList<gallery> galleryArrayList) {
        this.context = context;
        this.galleryArrayList = galleryArrayList;
        this.layoutInflater = layoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterGalleryData.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.gallery_list, parent, false);
        return new AdapterGalleryData.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGalleryData.MyViewHolder holder, int position) {
        holder.galleryImg.setImageResource(galleryArrayList.get(position).getImage());
        holder.galleryTitle.setText(galleryArrayList.get(position).getTitle());
        holder.galleryDesc.setText(galleryArrayList.get(position).getDesc());
        holder.galleryDate.setText(galleryArrayList.get(position).getDate());
        holder.galleryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(context, DetailActivity.class);
                detail.putExtra("Image", galleryArrayList.get(position).getImage());
                detail.putExtra("Title", galleryArrayList.get(position).getTitle());
                detail.putExtra("Desc", galleryArrayList.get(position).getDesc());
                detail.putExtra("Date", galleryArrayList.get(position).getDate());
                detail.putExtra("Detail", galleryArrayList.get(position).getDetail());
                context.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return galleryArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView galleryImg;
        TextView galleryTitle, galleryDesc, galleryDate;
        CardView galleryCard;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            galleryImg = itemView.findViewById(R.id.galleryImage);
            galleryTitle = itemView.findViewById(R.id.galleryTitle);
            galleryDesc = itemView.findViewById(R.id.galleryDesc);
            galleryDate = itemView.findViewById(R.id.galleryDate);
            galleryCard = itemView.findViewById(R.id.galleryCV);
        }
    }
}
