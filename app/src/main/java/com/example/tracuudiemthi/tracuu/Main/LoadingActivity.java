package com.example.tracuudiemthi.tracuu.Main;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tracuudiemthi.R;
import com.example.tracuudiemthi.tracuu.Utils.CountingData;
import com.example.tracuudiemthi.tracuu.Utils.DataUtils;

public class LoadingActivity extends AppCompatActivity {
    public static long start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_layout);
        start = System.currentTimeMillis();
        new Create().execute(new Void[0]);
    }
    private class Create extends AsyncTask<Void, Void, Void> {
        private Create() {}
        public void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            CountingData.getInstance().initData(getApplicationContext());
            return null;
        }
        public void onPostExecute(Void a) {
            super.onPostExecute(a);
            Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
