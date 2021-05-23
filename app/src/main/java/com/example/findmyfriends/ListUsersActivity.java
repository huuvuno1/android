package com.example.findmyfriends;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListUsersActivity  extends AppCompatActivity {
    ListView lvUser;
    UserAdapter adapter;
    List<User> listUser = new ArrayList<>();
    FloatingActionButton btnAddNewUser;
    final  static int INSERT_CODE  = 101;
    private int requestCode;
    private int resultCode;
    @Nullable
    private Intent data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        listUser = initUsers();
        adapter = new UserAdapter(ListUsersActivity.this, R.layout.iteam_user,listUser);
        lvUser = findViewById(R.id.lvUsers);
        lvUser.setAdapter(adapter);
        btnAddNewUser = findViewById(R.id.btnAddNewUser);
        btnAddNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListUsersActivity.this,AddUserActivity.class);
                startActivityForResult(intent,INSERT_CODE);


            }
        });
    }

    private List<User> initUsers () {
        List<User> kq = new ArrayList<>();
        User user0 = new User("Ha", "ha@gmail.com", "0987654");
        User user1 = new User("Minh", "minh@gmail.com", "0987654");
        User user2 = new User("tuan", "tuan@gmail.com", "0987654");
        User user3 = new User("kha", "kha@gmail.com", "0987654");
        kq.add(user0);
        kq.add(user1);
        kq.add(user2);
        kq.add(user3);
        return kq;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        // xu ly du lieu tra ve
        if(requestCode == INSERT_CODE) {
            // XU LY DU LIEU INSERT O DAY
            if(resultCode ==RESULT_OK) {
                //lay du lieu tra ve va add vao list
                User user = (User) data.getSerializableExtra("user");
                listUser.add(user);
                //goi adaptor change , khi DL thay doi thi adaptor se cap nhat
                adapter.notifyDataSetChanged();

            }
        }
    }
}
