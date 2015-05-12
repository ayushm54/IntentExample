package com.example.ayush.intentexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Ayush on 28-Dec-14.
 */
public class TimerReceiverBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Alarm Notification...",Toast.LENGTH_LONG).show();
    }
}
