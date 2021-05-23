package com.example.findmyfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity   {
    EditText Name,Email,Password,Phone;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
        //xu ly su kien cho nut dang ki
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khoi tao intent
                Intent intent = new Intent(MainActivity.this,Login.class);
                //put du lieu vao intent de gui sang login
                intent.putExtra("email", Email.getText().toString());
                intent.putExtra("password", Password.getText().toString());
                // goi pthuc startActivity va truyen intent sang
                startActivity(intent);
            }

        });
    }

    private void getViews(){
        Name = findViewById(R.id.inputName);
        Email = findViewById(R.id.inputEmail);
        Password = findViewById(R.id.intputPassword);
        Phone = findViewById(R.id.inputPhone);
        btnSignUp = findViewById(R.id.btnAdd);
    }

}