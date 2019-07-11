package com.tranduc.lab1androidnetworking.bai2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.tranduc.lab1androidnetworking.R;
import com.tranduc.lab1androidnetworking.bai1.Bai1Model;
import com.tranduc.lab1androidnetworking.databinding.ActivityBai2Binding;

public class Bai2 extends AppCompatActivity implements Bai2Contact{
    private Bai2Presenter bai2Presenter;
    private ActivityBai2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bai2);
        bai2Presenter = new Bai2Presenter(this, this);

        binding.setModel(new Bai1Model(""));

        binding.setBai2(bai2Presenter);
    }

    @Override
    public void updateModel(Bai1Model model) {
        binding.setModel(model);
    }
}
