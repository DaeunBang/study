package com.example.bangdaewoon.galleryapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {                                                     //회원가입 클래스
    EditText emailInput;
    EditText idInput;
    EditText passwordInput;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button signupBtn=(Button)findViewById(R.id.signupBtn);
//        EditText emailEdt=(EditText)findViewById(R.id.emailInput);
//        EditText idEdt=(EditText)findViewById(R.id.idInput);
//        EditText passwordEdt=(EditText)findViewById(R.id.passwordInput);

        signupBtn.setOnClickListener(new View.OnClickListener() {               //SIGNUP 버튼 클릭 이벤트
            @Override
            public void onClick(View view) {

                emailInput=(EditText)findViewById(R.id.emailInput);
                idInput=(EditText)findViewById(R.id.idInput);
                passwordInput=(EditText)findViewById(R.id.passwordInput);
                pref=getSharedPreferences("User", Activity.MODE_PRIVATE);
                editor=pref.edit();

                Intent myIntent=new Intent(getApplicationContext(),MainActivity.class);

                String email=emailInput.getText().toString();
                String id=idInput.getText().toString();
                String password=passwordInput.getText().toString();

                boolean flag;                                                   //가입양식의 사용자 입력값과 정규표현식 비교를 위한 불린 플래그 선언

                if(email.isEmpty() || id.isEmpty() || password.isEmpty()) {     //양식 널조건 체크
                    Toast.makeText(Signup.this, "E-Mail, ID, Password를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }else{
                    if (flag = Pattern.matches("^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$", email)) {
                        editor.putString("email", email);
                        editor.commit();
                    } else {
                        editor.clear();
                        Toast.makeText(Signup.this, "E-Mail 형식에 어긋납니다", Toast.LENGTH_SHORT).show();
                    }
                    if (flag = Pattern.matches("^.*(?=^.{6,15}$)(?=.*\\d)(?=.*[a-zA-Z]).*$", id)) {
                        editor.putString("id", id);
                        editor.commit();
                    } else {
                        editor.clear();
                        Toast.makeText(Signup.this, "ID는 영문, 숫자 포함 6자 이상으로 설정하여주십시오.", Toast.LENGTH_SHORT).show();
                    }
                    if (flag = Pattern.matches("^.*(?=^.{6,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$", password)) {
                        editor.putString("password", password);
                        editor.commit();
                        Toast.makeText(Signup.this, pref.getString("id", "") + "님, 반갑습니다. 로그인해주시기 바랍니다.", Toast.LENGTH_LONG).show();
                        startActivity(myIntent);
                    } else {
                        editor.clear();
                        Toast.makeText(Signup.this, "비밀번호는 영문, 숫자, 특수문자 포함 6자 이상으로 설정하여주십시오.", Toast.LENGTH_SHORT).show();
                    }
                }
                //Toast.makeText(Signup.this,pref.getString("id","")+pref.getString("email","")+pref.getString("password",""),Toast.LENGTH_LONG).show();
            }
        });
    }
}
