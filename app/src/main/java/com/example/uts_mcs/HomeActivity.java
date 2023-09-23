package com.example.uts_mcs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottom_navbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homemenu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                        break;
                    case R.id.matchmenu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MatchesFragment()).commit();
                        break;
                    case R.id.historymenu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HistoryFragment()).commit();
                        break;
                }
                return false;
            }
        });
    }
}