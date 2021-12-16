package com.okay.presentationdemo;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    public DifferentDisplay presentation;
    public Display[] presentationDispalys;
    public VideoView videoView;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayManager displayManager = (DisplayManager) getSystemService(Context.DISPLAY_SERVICE);
        presentationDispalys = displayManager.getDisplays();
        presentation = new DifferentDisplay(this, presentationDispalys[1]);
        presentation.show();
        videoView = presentation.videoView;
        Toast.makeText(getApplicationContext(), "hello presentation", Toast.LENGTH_SHORT).show();
    }
}
