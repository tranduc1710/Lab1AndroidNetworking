package com.tranduc.lab1androidnetworking.bai1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.ImageView;

import com.tranduc.lab1androidnetworking.R;
import com.tranduc.lab1androidnetworking.databinding.ActivityBai1Binding;

public class Bai1 extends AppCompatActivity implements Bai1Contact {
    private Bai1Presenter bai1Presenter;
    private ActivityBai1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bai1);
        bai1Presenter = new Bai1Presenter(this, this);

        binding.setModel(new Bai1Model(""));
        binding.setBai1(bai1Presenter);
    }

    @Override
    public void updateModel(Bai1Model model) {
        binding.setModel(model);
    }
}
