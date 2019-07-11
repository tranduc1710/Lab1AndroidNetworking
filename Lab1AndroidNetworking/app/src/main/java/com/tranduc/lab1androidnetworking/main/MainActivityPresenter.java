package com.tranduc.lab1androidnetworking.main;

import android.content.Context;
import android.content.Intent;

import com.tranduc.lab1androidnetworking.bai1.Bai1;
import com.tranduc.lab1androidnetworking.bai2.Bai2;
import com.tranduc.lab1androidnetworking.bai2.SplashScreen;
import com.tranduc.lab1androidnetworking.bai3.Bai3;
import com.tranduc.lab1androidnetworking.bai4.Bai4;

public class MainActivityPresenter {
    private Context context;
    private MainActivityContact activityContact;

    public MainActivityPresenter(Context context, MainActivityContact activityContact) {
        this.context = context;
        this.activityContact = activityContact;
    }

    public void bai1(){
        activityContact.startActivity(new Intent(context, Bai1.class));
    }

    public void bai2(){
        activityContact.startActivity(new Intent(context, SplashScreen.class));
    }

    public void bai3(){
        activityContact.startActivity(new Intent(context, Bai3.class));
    }

    public void bai4(){
        activityContact.startActivity(new Intent(context, Bai4.class));
    }
}
