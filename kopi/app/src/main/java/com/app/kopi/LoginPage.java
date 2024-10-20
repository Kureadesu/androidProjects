package com.app.kopi;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginPage extends AppCompatActivity {

    VideoView videoview;
    EditText username, password;
    CheckBox rememberMe;
    Button loginBtn;
    TextView register;
    boolean wasPlaying = false; // Track playback state
    @Override
    protected void onStart() {
        super.onStart();
        if (wasPlaying) {
            videoview.resume();
            videoview.start();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        videoview = findViewById(R.id.videoView);
        username = findViewById(R.id.code_edt);
        password = findViewById(R.id.pass_edt);
        rememberMe = findViewById(R.id.checkBox);
        loginBtn = findViewById(R.id.button);

        videoview.setZOrderOnTop(true);
        videoview.setZOrderMediaOverlay(true);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.landing_page_bg);
        videoview.setZOrderOnTop(true);
        videoview.setZOrderMediaOverlay(true);
        videoview.setVideoURI(uri);
        videoview.start();
        videoview.setOnPreparedListener(
                mediaPlayer -> {
                    mediaPlayer.setLooping(true);
                    wasPlaying = true;
                });

        loginBtn.setOnClickListener(v -> {
            // create intent object
            Intent intent = new Intent(LoginPage.this, HomePage.class);
            startActivity(intent);
        });

        register = findViewById(R.id.login_hyperlink);
        register.setOnClickListener(v -> {
            Intent intent = new Intent(LoginPage.this, RegisterPage.class);
            startActivity(intent);
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentPosition", videoview.getCurrentPosition());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int currentPosition = savedInstanceState.getInt("currentPosition", 0);
        videoview.seekTo(currentPosition);
        videoview.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        videoview.stopPlayback();
        videoview.suspend();
    }
}