package com.okay.presentationdemo;

import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

public class DifferentDisplay extends Presentation implements View.OnClickListener {
    public VideoView videoView;

    public DifferentDisplay(Context outerContext, Display display) {
        super(outerContext, display);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_video);
        View button = findViewById(R.id.testbutton);
        button.setOnClickListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //暂时把stop当成dismiss

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void onClick(View v) {

        new Thread() {
            @Override
            public void run() {
                super.run();
                Looper.prepare();
                Toast.makeText(getContext(), "点击副屏按钮", Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        }.start();

    }
}
