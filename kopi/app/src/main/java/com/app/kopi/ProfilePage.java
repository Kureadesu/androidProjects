package com.app.kopi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfilePage extends AppCompatActivity {

    ImageButton profileBtn, savesBtn;
    FloatingActionButton searchBtn;
    TextView logoutBtn, reviewBtn1, reviewBtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        searchBtn = findViewById(R.id.searchBtn);
        profileBtn = findViewById(R.id.profileBtn);
        savesBtn = findViewById(R.id.savesBtn);
        profileBtn.setImageResource(R.drawable.baseline_person_24);
        profileBtn.setOnClickListener(v -> {
            // Handle profile button click
            Intent intent = new Intent(ProfilePage.this, ProfilePage.class);
            startActivity(intent);
            finish();
        });
        savesBtn.setImageResource(R.drawable.baseline_home_24);
        savesBtn.setOnClickListener(v -> {
            // Handle home button click
            Intent intent = new Intent(ProfilePage.this, HomePage.class);
            startActivity(intent);
            finish();
        });

        searchBtn.setScaleType(ImageView.ScaleType.FIT_CENTER);
        searchBtn.setOnClickListener(v -> {
            // Handle search button click
            Intent intent = new Intent(ProfilePage.this, SearchPage.class);
            startActivity(intent);
            finish();
        });

        logoutBtn = findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(v -> {
            // Handle logout button click
            Intent intent = new Intent(ProfilePage.this, LoginPage.class);
            startActivity(intent);
            finish();
        });

        reviewBtn1 = findViewById(R.id.review_btn);
        reviewBtn1.setOnClickListener(v -> {
            // Handle review button click
            Intent intent = new Intent(ProfilePage.this, CafeReviewPage.class);
            startActivity(intent);
            finish();
        });
        reviewBtn2 = findViewById(R.id.reviewBtn2);
        reviewBtn2.setOnClickListener(v -> {
            // Handle review button click
            Intent intent = new Intent(ProfilePage.this, CafeReviewPage.class);
            startActivity(intent);
            finish();
        });
    }
}