package com.app.kopi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SavedPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saved_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this::backToHome);

        Button viewCafeBtn = findViewById(R.id.saved_viewCafeBtn1);
        viewCafeBtn.setOnClickListener(this::viewCafe);
    }

    public void backToHome(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
        finish();
    }
    public void viewCafe(View view) {
        Intent intent = new Intent(this, CafeProfile.class);
        startActivity(intent);
        finish();
    }
}