package com.example.bangdaewoon.galleryapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Intro extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);                 //Activity 생성(디바이스에 띄우기)
        setContentView(R.layout.activity_intro);            //해당 화면 지정(activity_intro.xml)
        startLoading();                                     //startLoading 메소드 호출
    }

    private void startLoading(){
        Handler handler = new Handler();                    //핸들러 객체 생성
        handler.postDelayed(new Runnable(){                 //대기후 실행 3000='3초'
            @Override
            public void run(){
                Intent intent = new Intent(getBaseContext(), MainActivity.class);//인텐드 MainActivity 클래스로 보내기
                startActivity(intent);
            }
        }, 3000);
    }
}