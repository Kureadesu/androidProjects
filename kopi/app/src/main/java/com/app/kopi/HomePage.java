package com.app.kopi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomePage extends AppCompatActivity {
    ImageButton profileBtn, savesBtn;
    ImageView eventBtn, dcBtn;
    TextView eventBtn_txt, dcBtn_txt;
    FloatingActionButton searchBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        profileBtn = findViewById(R.id.profileBtn);
        savesBtn = findViewById(R.id.savesBtn);
        eventBtn = findViewById(R.id.eventBtn);
        dcBtn = findViewById(R.id.dcBtn);
        eventBtn_txt = findViewById(R.id.eventBtn_txt);
        dcBtn_txt = findViewById(R.id.dcBtn_txt);
        searchBtn = findViewById(R.id.searchBtn);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.home_pic_1);

        profileBtn.setImageResource(R.drawable.baseline_person_24);
        profileBtn.setOnClickListener(v -> {
            // Handle profile button click
            Intent intent = new Intent(HomePage.this, ProfilePage.class);
            startActivity(intent);
        });

        savesBtn.setImageResource(R.drawable.baseline_favorite_24);
        savesBtn.setOnClickListener(v -> {
            // Handle home button click
            Intent intent = new Intent(HomePage.this, SavedPage.class);
            startActivity(intent);
        });

        // initialize navbar buttons
        eventBtn.setImageResource(R.drawable.baseline_calendar_today_24);
        dcBtn.setImageResource(R.drawable.voucher);

        View.OnClickListener homeBtnClickListener = new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.eventBtn) {
                    // Handle event button click
                    Intent intent = new Intent(HomePage.this, EventPage.class);
                    startActivity(intent);
                } else if (view.getId() == R.id.dcBtn) {
                    // Handle dc button click
                    Intent intent = new Intent(HomePage.this, VoucherPage.class);
                    startActivity(intent);
                } else if (view.getId() == R.id.eventBtn_txt) {
                    // Handle event button click
                    Intent intent = new Intent(HomePage.this, EventPage.class);
                    startActivity(intent);
                }
                else if (view.getId() == R.id.dcBtn_txt) {
                    // Handle dc button click
                    Intent intent = new Intent(HomePage.this, VoucherPage.class);
                    startActivity(intent);
                }
            }
        };
        eventBtn.setOnClickListener(homeBtnClickListener);
        dcBtn.setOnClickListener(homeBtnClickListener);
        eventBtn_txt.setOnClickListener(homeBtnClickListener);
        dcBtn_txt.setOnClickListener(homeBtnClickListener);
        
        searchBtn.setScaleType(ImageView.ScaleType.FIT_CENTER);
        searchBtn.setOnClickListener(v -> {
            // Handle search button click
            Intent intent = new Intent(HomePage.this, SearchPage.class);
            startActivity(intent);
        });
    }
}