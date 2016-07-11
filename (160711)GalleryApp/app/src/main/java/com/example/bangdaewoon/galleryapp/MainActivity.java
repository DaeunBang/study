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
    EditText idInput, passwordInput;                    //id, password EditText 변수화
    SharedPreferences pref;                             //SharedPreferences 선언
    SharedPreferences.Editor editor;                    //SharedPreferences Editor 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signupBtn=(Button)findViewById(R.id.signupBtn);  //signup, login 버튼 변수화
        Button loginBtn=(Button)findViewById(R.id.loginBtn);

        pref=getSharedPreferences("User",Activity.MODE_PRIVATE);    // 'USER' 파일명으로 저 및 MODE_PRIVATE 모드 설정
        //pref=getSharedPreferences("USER",Activity.MODE_PRIVATE);
        pref.edit();                                                // ?

        signupBtn.setOnClickListener(new View.OnClickListener() {   //signup 버튼 클릭리스너 객체생성
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(getApplicationContext(),Signup.class);   //인텐트 객체(Signup 클래스) 생성
                startActivity(myIntent);                                            //스타트액티비티(인텐트)

            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener(){     //signup 버튼 클릭리스너 객체생성
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(getApplicationContext(),Gallery.class);  //인텐트 객체(Gallery 클래스) 생성

                idInput=(EditText)findViewById(R.id.idInput);
                passwordInput=(EditText)findViewById(R.id.passwordInput);

                //Toast.makeText(MainActivity.this,pref.getString("id","") + "님, 반갑습니다. 로그인해주시기 바랍니다.",Toast.LENGTH_LONG).show();

                String id=idInput.getText().toString();                 //ID.password입력칸 스트링변수선언
                String password=passwordInput.getText().toString();
                if(id.isEmpty() || password.isEmpty()){                 //id, password 널 조건체크
                    Toast.makeText(MainActivity.this,"ID,비밀번호를 입력하세요.",Toast.LENGTH_SHORT).show();
                }else{
                    if(pref.getString("id","").equals(id) && pref.getString("password","").equals(password)){//shardPreference에 저장된 값과 사용자 입력값 비교
                        Toast.makeText(MainActivity.this,pref.getString("id","") + "님 환영합니다.",Toast.LENGTH_SHORT).show();
                        startActivity(myIntent);                                   //조건에 충족시 Gallery 클래스 스타트
                    }
                    else{
                        Toast.makeText(MainActivity.this,"ID,비밀번호가 틀렸습니다.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}