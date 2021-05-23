package com.example.findmyfriends;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import static android.content.ContentValues.TAG;

public class UserAdapter extends ArrayAdapter<User> {
        Context context;
        List<User> lsUser;
        int resource;

    public UserAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
        this.context = context;
        this.lsUser = objects;
        this.resource = resource;
    }
    @Override
    public int getCount() {
        return lsUser.size();
    }

    @Nullable
    @Override
    public User getItem(int position) {
        return lsUser.get(position);
    }

    @Override
    public int getPosition(@Nullable User item) {
        return lsUser.indexOf(item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, null);
        //lay ra doi tuong control va view
        TextView txtFullName = convertView.findViewById(R.id.txtFullName);
        ImageButton call = convertView.findViewById(R.id.callphone);
        ImageButton sendMsg = convertView.findViewById(R.id.sendMessage);
        //lay du lieu tren tung dong va hien thi
        User user = lsUser.get(position);
        //gan cac gia tri hien thi len giao dien
        txtFullName.setText(user.getUsername());
        //xu ly su kien voi cac nut lenh tren item_row
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //thuc hien cuoc goi o day
                // lay duoc sdt de thuc hien cuoc goi
                String phonecall = user.getPhone();
                // su dung intent khong tuong minh thuc hien cuoc goi
                Intent getP = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + phonecall));
                //start activity
                context.startActivity(getP);
            }
        });

       sendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //thuc hien gui tin nhac
                String phonecall = user.getPhone().toString();
                Intent Mess = new Intent(Intent.ACTION_SENDTO,Uri.parse(phonecall));

                if (Mess.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(Mess);
                } else {
                    Log.e(TAG, "Can't resolve app for ACTION_SENDTO Intent.");
                }
               context.startActivity(Mess);

            }
        });
        return convertView;
    }
}
