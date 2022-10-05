package com.linkple.linkplace.View.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.linkple.linkplace.R;
import com.linkple.linkplace.View.Adapter.FriendRecyclerAdapter;
import com.linkple.linkplace.View.Adapter.FriendRecyclerAdapter2;
import com.linkple.linkplace.View.Adapter.FriendRecyclerAdapter3;
import com.linkple.linkplace.View.Model.FriendImageAdapter;
import com.linkple.linkplace.View.Model.FriendImageItem;
import com.linkple.linkplace.View.Model.ProfileData;
import com.linkple.linkplace.View.Util.charactorData;
import com.linkple.linkplace.View.Util.jobData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.linkple.linkplace.databinding.ActivityFriendBinding;
import com.linkple.linkplace.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class FriendActivity extends AppCompatActivity {
    private ActivityFriendBinding binding;

    private Intent intent;
    private int number;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    String name, age, gender, job, charactor, hobby, wantfriend, imageUrl, education, religion, drink, smoke, pet, introduce, career, key, ImageUrl;
    FriendImageAdapter friendImageAdapter;
    private ArrayList<FriendImageItem> mList;
    RecyclerView mRecyclerView;
    private FriendRecyclerAdapter adapter;
    private FriendRecyclerAdapter2 adapter2;
    private FriendRecyclerAdapter3 adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFriendBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getintentdata(); // intent로 받은 데이터 셋팅

        initview(); // view 셋팅

        initRecyclerview(); //recyclerview 설정
    }

    private void initview() {
        binding.inputnumberbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FriendActivity.this);

                builder.setTitle("알림").setMessage("해당 버전에서 지원하지 않습니다.\n다음 업데이트를 기다려주세요.");

                builder.setPositiveButton("확인", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                    }
                });

                AlertDialog alertDialog = builder.create();

                alertDialog.show();
            }
        });

        binding.settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("FriendActivity","setting button click");
                final PopupMenu popupMenu = new PopupMenu(getApplicationContext(),view);
                getMenuInflater().inflate(R.menu.drawerlayout,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.menu_item1){
//                            Intent mail_intent = new Intent(Intent.ACTION_SEND);
//                            mail_intent.setType("*/*");
//                            mail_intent.setPackage("com.google.android.gm");

                            Intent mail_intent = new Intent(Intent.ACTION_SENDTO);
                            mail_intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                            mail_intent.putExtra(Intent.EXTRA_EMAIL, "jjinjisik@gmail.com"); // 받는 사람 이메일
                            mail_intent.putExtra(Intent.EXTRA_SUBJECT, "[LinkPlace 신고]"); // 메일 제목
                            mail_intent.putExtra(Intent.EXTRA_TEXT, "제보자 닉네임 : \n신고 사용자 닉네임 : \n신고 내용 :\n\n- 받는 사람에 jjinjisik@gmail.com을 기입해주세요"); // 메일 내용
                            startActivity(mail_intent);
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

        binding.clickfriendname.setText(name);
        binding.clickfriendage.setText(age);
        binding.clickfriendname.setText(name);
        binding.clickfriendage.setText(age);
        if (gender.equals("남성")) {
            binding.clickfriendgender.setText(gender);
            binding.clickfriendgender.setTextColor(ColorStateList.valueOf(Color.parseColor("#0062D7")));
        } else {
            binding.clickfriendgender.setText(gender);
            binding.clickfriendgender.setTextColor(ColorStateList.valueOf(Color.parseColor("#EF5DA8")));
        }
        binding.topclickfriendname.setText(name);

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.friendcareertext.setText(career);

        databaseReference.child("Link").child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ProfileData profileData1 = dataSnapshot.getValue(ProfileData.class);

                //각각의 값 받아오기 get어쩌구 함수들은 intakegroup.class에서 지정한것
                ImageUrl = profileData1.getImageUrl();

                String imageUrlList[] = ImageUrl.split(",");
                for (int i = 0; i < imageUrlList.length; i++) {
                    // 각 List의 값들을 data 객체에 set 해줍니다.
                    addItem(imageUrlList[i]);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
    }

    private void getintentdata() {
        intent = getIntent();
        number = intent.getIntExtra("number", -1);
        name = intent.getStringExtra("name");
        age = intent.getStringExtra("age");
        gender = intent.getStringExtra("gender");
        job = intent.getStringExtra("job");
        charactor = intent.getStringExtra("charactor");
        hobby = intent.getStringExtra("hobby");
        wantfriend = intent.getStringExtra("wantfriend");
        education = intent.getStringExtra("education");
        religion = intent.getStringExtra("religion");
        drink = intent.getStringExtra("drink");
        smoke = intent.getStringExtra("smoke");
        pet = intent.getStringExtra("pet");
        introduce = intent.getStringExtra("content");
        career = intent.getStringExtra("career");
        key = intent.getStringExtra("key");


        if (introduce.equals("")) {
            binding.friendintroduce.setVisibility(View.GONE);
        } else {
            binding.friendintroducetext.setText(introduce);
        }

        if (career.equals("")) {
            binding.friendcareer.setVisibility(View.GONE);
        } else {
            binding.friendcareertext.setText(career);
        }

        if (education.equals("")) {
            binding.friendeducation.setVisibility(View.GONE);
        } else {
            binding.friendeducationtext.setText(education);
        }

        if (religion.equals("")) {
            binding.friendregilion.setVisibility(View.GONE);
        } else {
            binding.friendregiliontext.setText(religion);
        }

        if (drink.equals("")) {
            binding.frienddrink.setVisibility(View.GONE);
        } else {
            binding.frienddrinktext.setText(drink);
        }

        if (smoke.equals("")) {
            binding.friendsmoke.setVisibility(View.GONE);
        } else {
            binding.friendsmoketext.setText(smoke);
        }

        if (pet.equals("")) {
            binding.friendpet.setVisibility(View.GONE);
        } else {
            binding.friendpettext.setText(pet);
        }

    }

    public void initRecyclerview(){
        mRecyclerView = (RecyclerView) findViewById(R.id.friendrecycler);
        mList = new ArrayList<>();

        friendImageAdapter = new FriendImageAdapter(mList);
        mRecyclerView.setAdapter(friendImageAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        RecyclerView recyclerView = findViewById(R.id.recyclerview_friend_charactor);
        RecyclerView recyclerView2 = findViewById(R.id.recyclerview_friend_hobby);
        RecyclerView recyclerview3 = findViewById(R.id.recyclerview_friend_wantfriend);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView2.setLayoutManager(linearLayoutManager2);

        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerview3.setLayoutManager(linearLayoutManager3);

        adapter = new FriendRecyclerAdapter();
        adapter2 = new FriendRecyclerAdapter2();
        adapter3 = new FriendRecyclerAdapter3();
        recyclerView.setAdapter(adapter);
        recyclerView2.setAdapter(adapter2);
        recyclerview3.setAdapter(adapter3);

        String charactorlist[] = charactor.split(",");

        adapter.clear();
        adapter2.clear();
        adapter3.clear();

        for (int i = 0; i < charactorlist.length; i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            charactorData data = new charactorData();
            data.setTitle(charactorlist[i]);

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();


        String hobbylist[] = hobby.split(",");

        for (int i = 0; i < hobbylist.length; i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            jobData data = new jobData();
            data.setTitle(hobbylist[i]);

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter2.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter2.notifyDataSetChanged();

        String wanfriendlist[] = wantfriend.split(",");


        for (int i = 0; i < wanfriendlist.length; i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            jobData data = new jobData();
            data.setTitle(wanfriendlist[i]);

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter3.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter3.notifyDataSetChanged();
    }

    public void addItem(String imgName){
        FriendImageItem item = new FriendImageItem();

        item.setImgName(imgName);

        mList.add(item);
    }
}