package com.example.uts_mcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView back, imageDetail;
    TextView titleTool, dateDetail, descDetail, detailText;
    String title, date, desc, detail;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageDetail = findViewById(R.id.detailImage);
        titleTool = findViewById(R.id.toolbarTitle);
        dateDetail = findViewById(R.id.detailDate);
        descDetail = findViewById(R.id.detailTitle);
        detailText = findViewById(R.id.detailText);
        back = findViewById(R.id.backIcon);

        Intent intent = getIntent();
        image = intent.getExtras().getInt("Image");
        title = intent.getExtras().getString("Title");
        desc = intent.getExtras().getString("Desc");
        date = intent.getExtras().getString("Date");
        detail = intent.getExtras().getString("Detail");

        imageDetail.setImageResource(image);
        titleTool.setText(title);
        descDetail.setText(desc);
        dateDetail.setText(date);
        detailText.setText(detail);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailActivity.this, HomeActivity.class));
                finish();
            }
        });
    }
}