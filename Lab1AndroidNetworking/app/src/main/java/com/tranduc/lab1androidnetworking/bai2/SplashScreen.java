package com.tranduc.lab1androidnetworking.bai2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.tranduc.lab1androidnetworking.R;
import com.tranduc.lab1androidnetworking.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends AppCompatActivity{
    private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, Bai2.class));
                finish();
            }
        }, 3000);
    }
}
