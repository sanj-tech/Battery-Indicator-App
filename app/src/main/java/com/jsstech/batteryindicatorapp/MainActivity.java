package com.jsstech.batteryindicatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }
    BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context,Intent intent) {
            int level=intent.getIntExtra("level",0);
            ProgressBar progressBar=findViewById(R.id.progress_lvl);
            progressBar.setProgress(level);
            TextView textView=findViewById(R.id.txt_view);
            textView.setText("Battery level..."+Integer.toString(level) +"%");

        }
    };
}