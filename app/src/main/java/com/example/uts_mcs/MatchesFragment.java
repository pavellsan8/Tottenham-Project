package com.example.uts_mcs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MatchesFragment extends Fragment {

    RecyclerView recyclerViewMatchesBig;
    ArrayList<matchesBig> matchesBigArrayList = new ArrayList<>();
    AdapterMatchesBigData adapterMatchesBig;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matches, container, false);

        recyclerViewMatchesBig = view.findViewById(R.id.rv_matches_big);
        recyclerViewMatchesBig.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapterMatchesBig = new AdapterMatchesBigData(this.getContext(), matchesBigArrayList);
        recyclerViewMatchesBig.setAdapter(adapterMatchesBig);

        matchesBigArrayList.add(new matchesBig(R.drawable.nc_logo, R.drawable.th_logo, "Premier League", "Sunday, 23 Apr 2023", "23:30 PM", "St. James' Park", "NEW", "TOT", "Buy Your Tickets Here", "Vs", "$100"));
        matchesBigArrayList.add(new matchesBig(R.drawable.th_logo, R.drawable.mu_logo, "Premier League", "Friday, 28 Apr 2023", "02:15 PM", "Tottenham Hotspur Stadium", "TOT", "MUN", "Buy Your Tickets Here", "Vs", "$100"));
        matchesBigArrayList.add(new matchesBig(R.drawable.liv_logo, R.drawable.th_logo, "Premier League", "Sunday, 30 Apr 2023", "23:00 PM", "Anfield", "LIV", "TOT", "Buy Your Tickets Here","Vs", "$100"));
        matchesBigArrayList.add(new matchesBig(R.drawable.th_logo, R.drawable.cp_logo, "Premier League", "Saturday, 06 May 2023", "21:00 PM", "Tottenham Hotspur Stadium", "TOT", "CRY", "Buy Your Tickets Here","Vs", "$100"));
        matchesBigArrayList.add(new matchesBig(R.drawable.av_logo, R.drawable.th_logo, "Premier League", "Saturday, 13 May 2023", "21:00 PM", "Villa Park", "AVL", "TOT", "Buy Your Tickets Here","Vs", "$100"));
        matchesBigArrayList.add(new matchesBig(R.drawable.th_logo, R.drawable.bf_logo, "Premier League", "Saturday, 20 May 2023", "18:30 PM", "Tottenham Hotspur Stadium", "TOT", "BRE", "Buy Your Tickets Here","Vs", "$100"));
        matchesBigArrayList.add(new matchesBig(R.drawable.lu_logo, R.drawable.th_logo, "Premier League", "Sunday, 28 May 2023", "22:30 PM", "Elland Road", "LEE", "TOT", "Buy Your Tickets Here","Vs", "$100"));

        return view;
    }
}