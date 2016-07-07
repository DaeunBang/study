package com.example.bangdaewoon.galleryapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText idInput, passwordInput;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signupBtn=(Button)findViewById(R.id.signupBtn);
        Button loginBtn=(Button)findViewById(R.id.loginBtn);

        pref=getSharedPreferences("User",Activity.MODE_PRIVATE);
        //pref=getSharedPreferences("USER",Activity.MODE_PRIVATE);
        pref.edit();

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(getApplicationContext(),Signup.class);
                startActivity(myIntent);

            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(getApplicationContext(),Gallery.class);

                idInput=(EditText)findViewById(R.id.idInput);
                passwordInput=(EditText)findViewById(R.id.passwordInput);

                //Toast.makeText(MainActivity.this,pref.getString("id","") + "님, 반갑습니다. 로그인해주시기 바랍니다.",Toast.LENGTH_LONG).show();

                String id=idInput.getText().toString();
                String password=passwordInput.getText().toString();
                if(id.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity.this,"ID,비밀번호를 입력하세요.",Toast.LENGTH_SHORT).show();
                }else{
                    if(pref.getString("id","").equals(id) && pref.getString("password","").equals(password)){
                        Toast.makeText(MainActivity.this,pref.getString("id","") + "님 환영합니다.",Toast.LENGTH_SHORT).show();
                        startActivity(myIntent);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"ID,비밀번호가 틀렸습니다.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}