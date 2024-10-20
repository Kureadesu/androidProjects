package com.app.kopi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfilePage_business extends AppCompatActivity {

    ImageButton profileBtn, savesBtn;
    FloatingActionButton searchBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_page_business);
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
            Intent intent = new Intent(ProfilePage_business.this, ProfilePage.class);
            startActivity(intent);
        });
        savesBtn.setImageResource(R.drawable.baseline_home_24);
        savesBtn.setOnClickListener(v -> {
            // Handle home button click
            Intent intent = new Intent(ProfilePage_business.this, HomePage.class);
            startActivity(intent);
        });

        searchBtn.setScaleType(ImageView.ScaleType.FIT_CENTER);
        searchBtn.setOnClickListener(v -> {
            // Handle search button click
            Intent intent = new Intent(ProfilePage_business.this, SearchPage.class);
            startActivity(intent);
        });
    }
}