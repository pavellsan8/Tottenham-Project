package com.example.uts_mcs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMatchData extends RecyclerView.Adapter<AdapterMatchData.MyViewHolder> {
    Context context;
    ArrayList<matches> matchesArrayList;
    LayoutInflater layoutInflater;

    public AdapterMatchData(Context context, ArrayList<matches> matchesArrayList) {
        this.context = context;
        this.matchesArrayList = matchesArrayList;
        this.layoutInflater = layoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterMatchData.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.matches_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMatchData.MyViewHolder holder, int position) {
        holder.teamPic.setImageResource(matchesArrayList.get(position).getImage());
        holder.date.setText(matchesArrayList.get(position).getDate());
        holder.time.setText(matchesArrayList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return matchesArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView teamPic;
        TextView date, time;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            teamPic = itemView.findViewById(R.id.ot_image);
            date = itemView.findViewById(R.id.datematches);
            time = itemView.findViewById(R.id.timematches);
        }
    }
}
