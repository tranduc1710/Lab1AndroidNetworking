package com.tranduc.lab1androidnetworking.bai4;

import android.app.ProgressDialog;
import android.content.Context;

import androidx.databinding.ObservableField;

public class Bai4Presenter {
    private Context context;
    private Bai4Contact bai4Contact;
    private ProgressDialog progressDialog;
    public ObservableField<String> time;

    public Bai4Presenter(Context context, Bai4Contact bai4Contact) {
        this.context = context;
        this.bai4Contact = bai4Contact;
        time = new ObservableField<>();
    }

    public void loadDialog(){
        AsyncTask asyncTask = new AsyncTask(context, time);
        asyncTask.execute(time.get());
    }

    public class AsyncTask extends android.os.AsyncTask<String, String, String>{
        private Context context;
        private ObservableField<String> editText;

        public AsyncTask(Context context, ObservableField<String> time) {
            this.context = context;
            this.editText = time;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = (ProgressDialog) ProgressDialog.show(context, "Wait" , editText.get() + " seconds");
        }

        @Override
        protected String doInBackground(String... strings) {
            publishProgress("Sleeping...");
            try {
                int time = Integer.parseInt(strings[0]) * 1000;
                Thread.sleep(time);
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }
    }
}
