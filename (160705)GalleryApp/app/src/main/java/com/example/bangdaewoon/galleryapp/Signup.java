package com.example.bangdaewoon.galleryapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
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
        EditText emailEdt=(EditText)findViewById(R.id.emailInput);
        EditText idEdt=(EditText)findViewById(R.id.idInput);
        EditText passwordEdt=(EditText)findViewById(R.id.passwordInput);

        signupBtn.setOnClickListener(new View.OnClickListener() {               //SIGNUP 버튼 클릭 이벤트
            @Override
            public void onClick(View view) {

                emailInput=(EditText)findViewById(R.id.emailInput);
                idInput=(EditText)findViewById(R.id.idInput);
                passwordInput=(EditText)findViewById(R.id.passwordInput);
                pref=getSharedPreferences("User", Activity.MODE_PRIVATE);
                editor=pref.edit();

                String email=emailInput.getText().toString();
                String id=idInput.getText().toString();
                String password=passwordInput.getText().toString();

                //if (email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$")){editor.putString("email",email);}//E-mail 정규표현식 추후구현

                if (email.matches("@")){editor.putString("email",email);} //야메
                else {Toast.makeText(Signup.this,"E-mail 형식에 어긋납니다",Toast.LENGTH_LONG).show();}

                if (id.length()>5){editor.putString("id",id);}
                else {Toast.makeText(Signup.this,"ID는 영문, 숫자 포함 6자 이상으로 설정하여주십시오.",Toast.LENGTH_LONG).show();}

                if (password.length()>5){editor.putString("password",password);}
                else {Toast.makeText(Signup.this,"비밀번호는 영문, 숫자, 특수문자 포함 6자 이상으로 설정하여주십시오.",Toast.LENGTH_LONG).show();}

                editor.commit();

                Toast.makeText(Signup.this,"E-MAIL: " + pref.getString("email","") + "   " + "ID: " + pref.getString("id",""),Toast.LENGTH_LONG).show();

            }
        });


    }
}
