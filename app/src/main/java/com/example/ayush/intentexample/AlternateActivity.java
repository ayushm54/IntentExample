package com.example.ayush.intentexample;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;

/**
 * Created by Ayush on 28-Dec-14.
 */
public class AlternateActivity extends ActionBarActivity{

    Button bt,btTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternate);
        bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent=new Intent();
                setResult(RESULT_OK,replyIntent);
                finish();
            }
        });

        btTimer= (Button) findViewById(R.id.btStartTImer);
        btTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerAlert(v);
            }
        });
    }

    private void timerAlert(View v) {
        EditText txtTimer= (EditText) findViewById(R.id.edTimer);
        int i=Integer.parseInt(txtTimer.getText().toString());
        Intent timerIntent=new Intent(this, TimerReceiverBroadcast.class);
        PendingIntent PI=PendingIntent.getBroadcast(this.getApplicationContext(),0,timerIntent,0);
        AlarmManager AM= (AlarmManager) getSystemService(ALARM_SERVICE);
        AM.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(i*1000),PI);
        Toast.makeText(this,"Alarm is set for "+i+"seconds!",Toast.LENGTH_SHORT).show();
    }
}
