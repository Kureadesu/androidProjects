package com.app.kopi;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VerifyPage extends AppCompatActivity {
    View verifySuccess;
    Button button;
    EditText code;
    VideoView videoView;
    boolean wasPlaying = false;
    @Override
    protected void onStart() {
        super.onStart();
        if (wasPlaying) {
            videoView.resume();
            videoView.start();
        }
    }// Track playback state
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verify_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        verifySuccess = findViewById(R.id.verifySuccess);
        button = findViewById(R.id.button);
        code = findViewById(R.id.code_edt);
        videoView = findViewById(R.id.videoView);

        videoView.setZOrderOnTop(true);
        videoView.setZOrderMediaOverlay(true);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.landing_page_bg);
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setOnPreparedListener(
                mediaPlayer -> {
                    mediaPlayer.setLooping(true);
                    wasPlaying = true;
                });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verifySuccess.setVisibility(View.VISIBLE);
                Intent intent = new Intent (VerifyPage.this, HomePage.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentPosition", videoView.getCurrentPosition());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int currentPosition = savedInstanceState.getInt("currentPosition", 0);
        videoView.seekTo(currentPosition);
        videoView.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        videoView.stopPlayback();
        videoView.suspend();
    }
}