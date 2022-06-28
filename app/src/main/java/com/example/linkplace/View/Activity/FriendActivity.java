package com.example.linkplace.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.linkplace.R;

public class FriendActivity extends AppCompatActivity {
    private Intent intent;
    private int number;
    private ImageView imageView;
    private TextView clickfriendname, clickfriendage, clickfriendgender, topclickfriendname;
    private String name, age, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        intent = getIntent();
        number = intent.getIntExtra("number", -1);
        name = intent.getStringExtra("name");
        age = intent.getStringExtra("age");
        gender = intent.getStringExtra("gender");

        clickfriendname = findViewById(R.id.clickfriendname);
        clickfriendage = findViewById(R.id.clickfriendage);
        clickfriendgender = findViewById(R.id.clickfriendgender);
        topclickfriendname = findViewById(R.id.topclickfriendname);

        clickfriendname.setText(name);
        clickfriendage.setText(age);
        clickfriendgender.setText(gender);
        if (gender.equals("남성")) {
            clickfriendgender.setTextColor(ColorStateList.valueOf(Color.parseColor("#0062D7")));
        }
        topclickfriendname.setText(name);

    }
}