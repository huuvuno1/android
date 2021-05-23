package com.example.findmyfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText Email2,Password2;
    Button btnSignUp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getViews();
        //tiep nhan doi tuong intent truyen sang tu Mainactivity
        //nhan intent tra ve qua phthuc getIntent()
        Intent result = getIntent();
        // lay du lieu duoc truyen sang va hien len giao dien
        String Emaill = result.getStringExtra("email");
        String Passwordd = result.getStringExtra("password");
        // day du lieu len form
        Email2.setText(Emaill);
        Password2.setText(Passwordd);
    }
    private void getViews(){
        Email2 = findViewById(R.id.Email2);
        Password2 = findViewById(R.id.Password2);
        btnSignUp2 = findViewById(R.id.btnSignUp2);
    }
}