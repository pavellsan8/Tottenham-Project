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

public class AdapterNewsData extends RecyclerView.Adapter<AdapterNewsData.MyViewHolder> {
    Context context;
    ArrayList<news> newsArrayList;
    LayoutInflater layoutInflater;

    public AdapterNewsData(Context context, ArrayList<news> newsArrayList) {
        this.context = context;
        this.newsArrayList = newsArrayList;
        this.layoutInflater = layoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterNewsData.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.news_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNewsData.MyViewHolder holder, int position) {
        holder.newsImg.setImageResource(newsArrayList.get(position).getImage());
        holder.newsTitle.setText(newsArrayList.get(position).getTitle());
        holder.newsDesc.setText(newsArrayList.get(position).getDesc());
        holder.newsDate.setText(newsArrayList.get(position).getDate());
        holder.newsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(context, DetailActivity.class);
                detail.putExtra("Image", newsArrayList.get(position).getImage());
                detail.putExtra("Title", newsArrayList.get(position).getTitle());
                detail.putExtra("Desc", newsArrayList.get(position).getDesc());
                detail.putExtra("Date", newsArrayList.get(position).getDate());
                detail.putExtra("Detail", newsArrayList.get(position).getDetail());
                context.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImg;
        TextView newsTitle, newsDesc, newsDate;
        CardView newsCard;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            newsImg = itemView.findViewById(R.id.newsImage);
            newsTitle = itemView.findViewById(R.id.newsTitle);
            newsDesc = itemView.findViewById(R.id.newsDesc);
            newsDate = itemView.findViewById(R.id.newsDate);
            newsCard = itemView.findViewById(R.id.newsCV);
        }
    }
}