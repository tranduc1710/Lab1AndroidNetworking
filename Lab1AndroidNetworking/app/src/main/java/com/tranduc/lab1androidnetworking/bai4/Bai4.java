package com.tranduc.lab1androidnetworking.bai4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.tranduc.lab1androidnetworking.R;
import com.tranduc.lab1androidnetworking.databinding.ActivityBai4Binding;

public class Bai4 extends AppCompatActivity implements Bai4Contact{
    private ActivityBai4Binding binding;
    private Bai4Presenter bai4Presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bai4);

        bai4Presenter = new Bai4Presenter(this, this);

        binding.setBai4(bai4Presenter);
    }
}
