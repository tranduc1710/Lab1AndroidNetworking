package com.tranduc.lab1androidnetworking.bai2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

import com.squareup.picasso.Picasso;
import com.tranduc.lab1androidnetworking.R;
import com.tranduc.lab1androidnetworking.bai1.Bai1Model;


public class Bai2Presenter {
    private Context context;
    private Bai2Contact bai2Contact;
    public ObservableField<String> title;
    private Bai1Model model;

    public Bai2Presenter(final Context context, Bai2Contact bai2Contact) {
        this.context = context;
        this.bai2Contact = bai2Contact;

        model = new Bai1Model("");
    }

    @BindingAdapter({"app:imageUrl"})
    public static void LoadImage(AppCompatImageView imageView, String url1){
        if (!url1.equals("")) {
            Picasso.with(imageView.getContext()).load(url1.trim()).into(imageView);
        }
    }

    public void loadImage(){
        loadDialog dialog = new loadDialog();
        dialog.execute();
    }

    private class loadDialog extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            final ProgressDialog progressDialog = new ProgressDialog(context);
            progressDialog.setMax(100);
            progressDialog.setMessage("Loading...");
            progressDialog.setTitle("ProgressDialog");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.show();

            final Handler handle = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    progressDialog.incrementProgressBy(1);
                }
            };

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (progressDialog.getProgress() <= progressDialog
                                .getMax()) {
                            Thread.sleep(10);
                            handle.sendMessage(handle.obtainMessage());
                            if (progressDialog.getProgress() == progressDialog
                                    .getMax()) {
                                progressDialog.dismiss();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            model.setUrl("https://tophinhnen.com/wp-content/uploads/2018/01/top-hinh-nen-ronaldo-dep-nhat-5.jpg");
            bai2Contact.updateModel(model);
        }
    }
}
