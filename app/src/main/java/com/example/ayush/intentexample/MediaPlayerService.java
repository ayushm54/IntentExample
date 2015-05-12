package com.example.ayush.intentexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

/**
 * Created by Ayush on 28-Dec-14.
 */
public class MediaPlayerService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    MediaPlayer md;

    @Override
    public void onCreate(){
        md=MediaPlayer.create(this,R.raw.bichdan);
        md.setLooping(true);
    }

    @Override
    public void onStart(Intent intent,int startid){
        md.start();
    }

    @Override
    public void onDestroy(){
        md.stop();
    }
}
