package com.example.bangdaewoon.myapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn=(Button)findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"issue: click!",Toast.LENGTH_LONG).show();
                Intent myIntent=new Intent(getApplicationContext(),NewActivity.class);
                startActivity(myIntent);

            }
        });
        Button start2Btn=(Button)findViewById(R.id.start2Btn);
        start2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myItent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                startActivity(myItent);
            }
        });
        Button start3Btn=(Button)findViewById(R.id.start3Btn);
        start3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("tel:010-5174-5086"));
                startActivity(myIntent);
            }
        });


    }
}
