package com.app.kopi;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterPage extends AppCompatActivity {
    EditText user_edt, pass_edt, email_edt;
    Button button;
    TextView textView5, login_hyperlink;
    private VideoView video;
    boolean wasPlaying = false;
    @Override
    protected void onStart() {
        super.onStart();
        if (wasPlaying) {
            video.resume();
            video.start();
        }
    }// Track playback state
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        video = findViewById(R.id.videoView);
        user_edt = findViewById(R.id.code_edt);
        pass_edt = findViewById(R.id.pass_edt);
        email_edt = findViewById(R.id.email_edt);
        button = findViewById(R.id.button);
        textView5 = findViewById(R.id.textView5);
        login_hyperlink = findViewById(R.id.login_hyperlink);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.landing_page_bg);
        video.setZOrderOnTop(true);
        video.setZOrderMediaOverlay(true);
        video.setVideoURI(uri);
        video.start();
        video.setOnPreparedListener(
                mediaPlayer -> {
                    mediaPlayer.setLooping(true);
                    wasPlaying = true;
                });
        login_hyperlink.setOnClickListener(View -> {
            startActivity(new Intent(RegisterPage.this, LoginPage.class));
            finish();
        });

        button.setOnClickListener(View -> {
            startActivity(new Intent(RegisterPage.this, VerifyPage.class));
            finish();
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentPosition", video.getCurrentPosition());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int currentPosition = savedInstanceState.getInt("currentPosition", 0);
        video.seekTo(currentPosition);
        video.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        video.stopPlayback();
        video.suspend();
    }
}