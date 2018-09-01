package com.harinie.aaghettoblaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

public class SplashActivity extends Activity {

    private Handler handler;
    private static int SPLASH_TIME_OUT = 2000; //ms to show splash screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
