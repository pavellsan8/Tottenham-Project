package com.example.uts_mcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MatchBigDetail extends AppCompatActivity {

    ImageView backBtn, homeTeam, awayTeam;
    String title, date, time, stadium, homeTag, awayTag, price, vs;
    int imageHome, imageAway;
    TextView titleTV, dateTV, timeTV, stadiumTV, homeTagTV, awayTagTV, priceTV, vsTV;
    EditText quantity;
    Button buyticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_big_detail);

        titleTV = findViewById(R.id.matchTitleTicket);
        homeTeam = findViewById(R.id.homeImgTicket);
        homeTagTV = findViewById(R.id.homeTagTicket);
        vsTV = findViewById(R.id.vsText);
        dateTV = findViewById(R.id.dateMatchTicket);
        timeTV = findViewById(R.id.timeMatchTicket);
        stadiumTV = findViewById(R.id.stadiumMatchTicket);
        awayTeam = findViewById(R.id.awayImgTicket);
        awayTagTV = findViewById(R.id.awayTagTicket);
        priceTV = findViewById(R.id.ticketPrice);
        backBtn = findViewById(R.id.backIconTicket);
        quantity = findViewById(R.id.inputTicket);
        buyticket = findViewById(R.id.buttonBuy);

        Intent intent = getIntent();
        title = intent.getExtras().getString("Title");
        imageHome = intent.getExtras().getInt("homeImg");
        homeTag = intent.getExtras().getString("homeTag");
        vs = intent.getExtras().getString("VS");
        date = intent.getExtras().getString("Date");
        time = intent.getExtras().getString("Time");
        stadium = intent.getExtras().getString("Stadium");
        imageAway = intent.getExtras().getInt("awayImg");
        awayTag = intent.getExtras().getString("awayTag");
        price = intent.getExtras().getString("Price");

        titleTV.setText(title);
        homeTeam.setImageResource(imageHome);
        homeTagTV.setText(homeTag);
        vsTV.setText(vs);
        dateTV.setText(date);
        timeTV.setText(time);
        stadiumTV.setText(stadium);
        awayTeam.setImageResource(imageAway);
        awayTagTV.setText(awayTag);
        priceTV.setText(price);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MatchBigDetail.this, HomeActivity.class));
                finish();
            }
        });

        buyticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantityCheck = Integer.parseInt(quantity.getText().toString());

                if (quantity.equals("")) Toast.makeText(MatchBigDetail.this, "Field can't be empty", Toast.LENGTH_SHORT).show();
                if (quantityCheck == 0) Toast.makeText(MatchBigDetail.this, "Quantity can't be zero", Toast.LENGTH_SHORT).show();

                if (quantityCheck > 0) {
                    Toast.makeText(MatchBigDetail.this, "Successfully Buying Ticket", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MatchBigDetail.this, HomeActivity.class));
                    finish();
                }
            }
        });
    }
}