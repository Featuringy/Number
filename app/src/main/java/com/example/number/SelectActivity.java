package com.example.number;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import static com.example.number.MainActivity.isplay;

public class SelectActivity extends Activity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        if(isplay==true){
            Playmusic();
        }
    }


    public void Playmusic(){
        mediaPlayer= MediaPlayer.create(this,R.raw.number_music);//资源路径
        mediaPlayer.setLooping(true);//循环播放
        mediaPlayer.start();//开始播放
    }

    @Override
    protected void onStop(){
        super.onStop();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

    @Override
    protected void onRestart(){  //从其他界面返回到本界面时调用这个方法
        super.onRestart();
        if(MainActivity.isplay==true){
            Playmusic();
        }
    }

    public void onOne(View v){
        startActivity(new Intent(SelectActivity.this,OneActivity.class));
    }

    public void onTwo(View v){
        startActivity(new Intent(SelectActivity.this,TwoActivity.class));
    }

    public void onThree(View v){
        startActivity(new Intent(SelectActivity.this,ThreeActivity.class));
    }

    public void onFour(View v){
        startActivity(new Intent(SelectActivity.this,FourActivity.class));
    }

    public void onFive(View v){
        startActivity(new Intent(SelectActivity.this,FiveActivity.class));
    }

    public void onSix(View v){
        startActivity(new Intent(SelectActivity.this,SixActivity.class));
    }

    public void onSeven(View v){
        startActivity(new Intent(SelectActivity.this,SevenActivity.class));
    }

    public void onEight(View v){
        startActivity(new Intent(SelectActivity.this,EightActivity.class));
    }

    public void onNine(View v){
        startActivity(new Intent(SelectActivity.this,NineActivity.class));
    }

    public void onZero(View v){
        startActivity(new Intent(SelectActivity.this,ZeroActivity.class));
    }

}
