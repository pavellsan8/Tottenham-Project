package com.example.uts_mcs;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMatchesBigData extends RecyclerView.Adapter<AdapterMatchesBigData.MyViewHolder> {

    Context context;
    ArrayList<matchesBig> matchesBigArrayList;
    LayoutInflater layoutInflater;

    public AdapterMatchesBigData(Context context, ArrayList<matchesBig> matchesBigArrayList) {
        this.context = context;
        this.matchesBigArrayList = matchesBigArrayList;
        this.layoutInflater = layoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterMatchesBigData.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.matches_big_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMatchesBigData.MyViewHolder holder, int position) {
        holder.homeTeam.setImageResource(matchesBigArrayList.get(position).getHomeImage());
        holder.awayTeam.setImageResource(matchesBigArrayList.get(position).getAwayImage());
        holder.title.setText(matchesBigArrayList.get(position).getTitle());
        holder.date.setText(matchesBigArrayList.get(position).getDate());
        holder.time.setText(matchesBigArrayList.get(position).getTime());
        holder.stadium.setText(matchesBigArrayList.get(position).getStadium());
        holder.home.setText(matchesBigArrayList.get(position).getHomeTeam());
        holder.away.setText(matchesBigArrayList.get(position).getAwayTeam());
        holder.tickets.setText(matchesBigArrayList.get(position).getTicket());
        holder.matchCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(context, MatchBigDetail.class);
                detail.putExtra("Title", matchesBigArrayList.get(position).getTitle());
                detail.putExtra("homeImg", matchesBigArrayList.get(position).getHomeImage());
                detail.putExtra("awayImg", matchesBigArrayList.get(position).getAwayImage());
                detail.putExtra("Date", matchesBigArrayList.get(position).getDate());
                detail.putExtra("Time", matchesBigArrayList.get(position).getTime());
                detail.putExtra("Stadium", matchesBigArrayList.get(position).getStadium());
                detail.putExtra("homeTag", matchesBigArrayList.get(position).getHomeTeam());
                detail.putExtra("awayTag", matchesBigArrayList.get(position).getAwayTeam());
                detail.putExtra("VS", matchesBigArrayList.get(position).getVs());
                detail.putExtra("Price", matchesBigArrayList.get(position).getPrice());
                context.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return matchesBigArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView homeTeam, awayTeam;
        TextView title, date, time, stadium, home, away, tickets, vs;
        CardView matchCV;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            homeTeam = itemView.findViewById(R.id.homeImg);
            awayTeam = itemView.findViewById(R.id.awayImg);
            title = itemView.findViewById(R.id.matchTitle);
            date = itemView.findViewById(R.id.dateMatch);
            time = itemView.findViewById(R.id.timeMatch);
            stadium = itemView.findViewById(R.id.stadiumMatch);
            home = itemView.findViewById(R.id.homeTag);
            away = itemView.findViewById(R.id.awayTag);
            tickets = itemView.findViewById(R.id.buyTickets);
            vs = itemView.findViewById(R.id.vsText);
            matchCV = itemView.findViewById(R.id.match_cv);
        }
    }
}
