package com.example.number;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    static boolean isplay=true;
    MediaPlayer mediaPlayer;
    ImageButton music_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music_btn=(ImageButton)findViewById(R.id.imageButton3);
//        music_btn.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if(isplay==true){
//                    if(mediaPlayer!=null){
//                            mediaPlayer.stop();
//                            music_btn.setBackgroundResource(R.drawable.btn_music2);
//                            isplay=false;
//                    }
//                }
//                else{
//                    Playmusic();
//                    music_btn.setBackgroundResource(R.drawable.btn_music1);
//                    isplay=true;
//                }
//                return false;
//            }
//        });
        music_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isplay==true){
                    if(mediaPlayer!=null){
                            mediaPlayer.stop();
                            music_btn.setBackgroundResource(R.drawable.btn_music2);
                            isplay=false;
                    }
                }
                else{
                    Playmusic();
                    music_btn.setBackgroundResource(R.drawable.btn_music1);
                    isplay=true;
                }
            }
        });
        Playmusic();
    }



    public void OnPlay(View v){
        startActivity(new Intent(MainActivity.this,SelectActivity.class));
    }

//    public void OnMusic(View v, MotionEvent event){
//        if(isplay==true){
//            if(mediaPlayer!=null){
//                mediaPlayer.stop();
//                music_btn.setBackgroundResource(R.drawable.btn_music2);
//                isplay=false;
//            }
//        }
//        else{
//            Playmusic();
//            music_btn.setBackgroundResource(R.drawable.btn_music1);
//            isplay=true;
//        }
//    }

    public void OnAbout(View v){
        startActivity(new Intent(MainActivity.this,AboutActivity.class));
    }


    public void Playmusic(){
        mediaPlayer=MediaPlayer.create(this,R.raw.main_music);//资源路径
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
        if(isplay==true){
            Playmusic();
        }
    }


}
