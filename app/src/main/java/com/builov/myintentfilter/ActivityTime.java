package com.builov.myintentfilter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class ActivityTime extends Activity {

    Timer timer;
    private myTimerTask tTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        final String time = sdf.format(new Date(System.currentTimeMillis()));
        final TextView tvTime = findViewById(R.id.tvTime);

        tvTime.setText(time);

        timer = new Timer();
        tTask = new myTimerTask();
        timer.schedule(tTask, 1000,1000);
    }

    class myTimerTask extends TimerTask {
        @Override
        public void run() {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    final String time = sdf.format(new Date(System.currentTimeMillis()));
    final TextView tvTime = findViewById(R.id.tvTime);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tvTime.setText(time);
                }
            });
        }
    }

    @Override
    public void onBackPressed()
    {        // code here to show dialog
        timer.cancel();
        super.onBackPressed();  // optional depending on your needs
    }

    @Override
    public void onDestroy()
    {
        timer.cancel();
        super.onDestroy();
    }
}
