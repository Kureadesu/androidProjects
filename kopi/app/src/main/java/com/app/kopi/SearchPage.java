package com.app.kopi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SearchPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton back_btn = findViewById(R.id.backBtn);
        back_btn.setOnClickListener(this::backBtn);

        Button viewResult1 = (Button) findViewById(R.id.btn_viewResult1);
        viewResult1.setOnClickListener(this::viewResult1);
    }

    public void backBtn(View v) {
        startActivity(new Intent(SearchPage.this, HomePage.class));
        finish();
    }
    public void viewResult1(View v) {
        startActivity(new Intent(this, CafeProfile.class));
        finish();
    }
}