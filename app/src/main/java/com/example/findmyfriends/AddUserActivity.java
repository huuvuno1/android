package com.example.findmyfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddUserActivity extends AppCompatActivity {
    EditText inputName,inputEmail,inputPhone;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        getViews();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lay du lieu va put ve ACTIVITYLISTUSER
                Intent res = new Intent();
                // put du lieu la ham getUserinfo
                res.putExtra("user", getUserinfo());
                setResult(RESULT_OK, res);
                finish();
            }
        });
    }
    private void getViews(){
        inputName = findViewById(R.id.inputName);
        inputEmail =findViewById(R.id.inputEmail);
        inputPhone = findViewById(R.id.inputPhone);
        btnAdd = findViewById(R.id.btnAdd);
    }
    private User getUserinfo () {
        String name = inputName.getText().toString();
        String email = inputEmail.getText().toString();
        String phone = inputPhone.getText().toString();
        return new User(name,email,phone);
    }
}