package com.tranduc.lab1androidnetworking.bai1;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;
import com.squareup.picasso.Picasso;

public class Bai1Presenter {
    private Context context;
    private Bai1Contact bai1Contact;
    private String url = "https://tophinhnen.com/wp-content/uploads/2018/01/top-hinh-nen-ronaldo-dep-nhat-5.jpg";
    private Bai1Model model;

    public Bai1Presenter(Context context, Bai1Contact bai1Contact) {
        this.context = context;
        this.bai1Contact = bai1Contact;

        model = new Bai1Model("");
    }

    @BindingAdapter({"app:imageUrl"})
    public static void LoadImage(AppCompatImageView imageView, String url1){
        if (!url1.equals("")) {
           Picasso.with(imageView.getContext()).load(url1.trim()).into(imageView);
        }
    }

    public void loadImage(){
        model.setUrl(url);
        bai1Contact.updateModel(model);
    }
}
