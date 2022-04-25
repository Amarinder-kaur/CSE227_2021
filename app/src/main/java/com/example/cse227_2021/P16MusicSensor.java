package com.example.cse227_2021;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class P16MusicSensor extends BroadcastReceiver {
    MediaPlayer mediaPlayer;
    @Override
    public void onReceive(Context context, Intent intent) {
        mediaPlayer=MediaPlayer.create(context,R.raw.sun);
        mediaPlayer.start();
        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();
    }
}
