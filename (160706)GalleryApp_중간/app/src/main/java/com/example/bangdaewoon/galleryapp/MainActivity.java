package com.example.bangdaewoon.galleryapp;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signupBtn=(Button)findViewById(R.id.signupBtn);
        Button loginBtn=(Button)findViewById(R.id.loginBtn);

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

                String id=idInput.getText().toString();
                String password=passwordInput.getText().toString();
                if(id.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity.this,"ID,비밀번호를 입력하세요.",Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(myIntent);
                }


            }
        });
    }
}
