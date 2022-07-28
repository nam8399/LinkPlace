package com.example.linkplace.View.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.linkplace.R;
import com.example.linkplace.View.Adapter.RecyclerAdapter;
import com.example.linkplace.View.Adapter.RecyclerAdapter2;
import com.example.linkplace.View.Adapter.RecyclerAdapter3;
import com.example.linkplace.View.Fragment.InputNumberFragment;
import com.example.linkplace.View.Fragment.MyProfileCharactorFragment;
import com.example.linkplace.View.Fragment.MyProfileDrinkFragment;
import com.example.linkplace.View.Fragment.MyProfileEducationFragment;
import com.example.linkplace.View.Fragment.MyProfileImageSetFragment;
import com.example.linkplace.View.Fragment.MyProfileJobFragement;
import com.example.linkplace.View.Fragment.MyProfilePetFragment;
import com.example.linkplace.View.Fragment.MyProfileReligionFragment;
import com.example.linkplace.View.Fragment.MyProfileSmokeFragment;
import com.example.linkplace.View.Fragment.SettingFragment;
import com.example.linkplace.View.Fragment.noSendAuthNumFragment;
import com.example.linkplace.View.Model.ProfileData;
import com.example.linkplace.View.Util.charactorData;
import com.example.linkplace.View.Util.jobData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyProfileActivity extends AppCompatActivity {
    ImageView mapbtn;
    TextView myprofileaddimage, myprofiletoptext, myprofiletextcount, myprofilejobbtn, myprofilereligionbtn, myprofiledrinkbtn, myprofilesmokebtn,
            myprofilepetbtn, myprofileeducation, myprofilename, myprofilegender, myprofileage;
    ImageView myprofilecharactorbtn, image1;
    EditText myprofileedittext;
    LinearLayout myprofiletop;
    private long backKeyPressedTime = 0;
    FrameLayout frameLayout;
    Toast toast;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String myjob, myreligion, mydrink, mysmoke, mypet, myeducation;
    ArrayList<String> mycharactorlist;
    private RecyclerAdapter adapter;
    private RecyclerAdapter2 adapter2;
    private RecyclerAdapter3 adapter3;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    String name, age, gender, job, charactor, hobby, wantfriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        editor = pref.edit();

        myjob = pref.getString("MyJob", "학생");
        myreligion = pref.getString("MyReligion", "무교");
        mydrink = pref.getString("MyDrink", "전혀 안함");
        mysmoke = pref.getString("MySmoke", "비흡연");
        mypet = pref.getString("MyPet", "강아지");
        myeducation = pref.getString("MyEducation", "대학교 졸업");
        Log.d("뭐자","에듀테이션" + myeducation);

        mapbtn = findViewById(R.id.mapbtn);
        myprofileaddimage = findViewById(R.id.myprofileaddimage);
        frameLayout = findViewById(R.id.frameLayout);
        myprofiletoptext = findViewById(R.id.myprofiletoptext);
        myprofiletextcount = findViewById(R.id.myprofiletextcount);
        myprofileedittext = (EditText) findViewById(R.id.myprofileedittext);
        myprofilejobbtn = findViewById(R.id.myprofilejobbtn);
        myprofiletop= findViewById(R.id.myprofiletop);
        myprofilereligionbtn = findViewById(R.id.myprofilereligionbtn);
        myprofiledrinkbtn = findViewById(R.id.myprofiledrinkbtn);
        myprofilesmokebtn = findViewById(R.id.myprofilesmokebtn);
        myprofilepetbtn = findViewById(R.id.myprofilepetbtn);
        myprofilecharactorbtn = findViewById(R.id.myprofilecharactorbtn);
        myprofileeducation = findViewById(R.id.myprofileeducation);
        myprofilename = findViewById(R.id.myprofilename);
        myprofilegender = findViewById(R.id.myprofilegender);
        myprofileage = findViewById(R.id.myprofileage);
        image1 = findViewById(R.id.image1);

        Intent intent = getIntent();

        myprofilejobbtn.setText(myjob);
        myprofilereligionbtn.setText(myreligion);
        myprofiledrinkbtn.setText(mydrink);
        myprofilesmokebtn.setText(mysmoke);
        myprofilepetbtn.setText(mypet);
        myprofileeducation.setText(myeducation);
        Log.d("뭐자","에듀테이션22" + myeducation);

        init();
        try {
            getCharactorData();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            byte[] byteArray = getIntent().getByteArrayExtra("image1");
            Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

            image1.setImageBitmap(bitmap);
            image1.setClipToOutline(true);
        } catch (Exception e) {
            e.printStackTrace();
        }




        try {
            switch (intent.getExtras().getString("Job position")) {
                case "0":
                    myprofilejobbtn.setText("학생");
                    break;
                case "1":
                    myprofilejobbtn.setText("직장인");
                    break;
                case "2":
                    myprofilejobbtn.setText("사업가");
                    break;
                case "3":
                    myprofilejobbtn.setText("군인");
                    break;
                case "4":
                    myprofilejobbtn.setText("취업준비중");
                    break;
                case "5":
                    myprofilejobbtn.setText("기타");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myjob = myprofilejobbtn.getText().toString();
            editor.putString("MyJob", myjob);
            editor.apply();
        }

        try {
            switch (intent.getExtras().getString("Religion position")) {
                case "0":
                    myprofilereligionbtn.setText("무교");
                    break;
                case "1":
                    myprofilereligionbtn.setText("기독교");
                    break;
                case "2":
                    myprofilereligionbtn.setText("불교");
                    break;
                case "3":
                    myprofilereligionbtn.setText("천주교");
                    break;
                case "4":
                    myprofilereligionbtn.setText("기타");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myreligion = myprofilereligionbtn.getText().toString();
            editor.putString("MyReligion", myreligion);
            editor.apply();
        }

        try {
            switch (intent.getExtras().getString("Drink position")) {
                case "0":
                    myprofiledrinkbtn.setText("전혀 안 함");
                    break;
                case "1":
                    myprofiledrinkbtn.setText("특별한 날 가끔");
                    break;
                case "2":
                    myprofiledrinkbtn.setText("한달에 1~2번");
                    break;
                case "3":
                    myprofiledrinkbtn.setText("일주일에 1~2번");
                    break;
                case "4":
                    myprofiledrinkbtn.setText("일주일에 3~5번");
                    break;
                case "5":
                    myprofiledrinkbtn.setText("거의 매일");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mydrink = myprofiledrinkbtn.getText().toString();
            editor.putString("MyDrink", mydrink);
            editor.apply();
        }

        try {
            switch (intent.getExtras().getString("Smoke position")) {
                case "0":
                    myprofilesmokebtn.setText("전혀 안 함");
                    break;
                case "1":
                    myprofilesmokebtn.setText("특별한 날 가끔");
                    break;
                case "2":
                    myprofilesmokebtn.setText("매일");
                    break;
                case "3":
                    myprofilesmokebtn.setText("전자 담배만");
                    break;
                case "4":
                    myprofilesmokebtn.setText("기타");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysmoke = myprofilesmokebtn.getText().toString();
            editor.putString("MySmoke", mysmoke);
            editor.apply();
        }


        try {
            switch (intent.getExtras().getString("Pet position")) {
                case "0":
                    myprofilepetbtn.setText("강아지");
                    break;
                case "1":
                    myprofilepetbtn.setText("고양이");
                    break;
                case "2":
                    myprofilepetbtn.setText("햄스터");
                    break;
                case "3":
                    myprofilepetbtn.setText("물고기");
                    break;
                case "4":
                    myprofilepetbtn.setText("파충류");
                    break;
                case "5":
                    myprofilepetbtn.setText("양서류");
                    break;
                case "6":
                    myprofilepetbtn.setText("없음");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mypet = myprofilepetbtn.getText().toString();
            editor.putString("MyPet", mypet);
            editor.apply();
        }


        String eduactiontext = "";

        try {
            switch (intent.getExtras().getInt("education position")) {
                case 1:
                    eduactiontext = "전문대";
                    break;
                case 2:
                    eduactiontext = "대학교";
                    break;
                case 3:
                    eduactiontext = "대학원";
                    break;
                case 4:
                    eduactiontext = "고등학교";
                    break;
                case 5:
                    eduactiontext = "중학교";
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            switch (intent.getExtras().getInt("education2 position")) {
                case 1:
                    eduactiontext += " 재학";
                    myprofileeducation.setText(eduactiontext);
                    myeducation = eduactiontext;
                    break;
                case 2:
                    eduactiontext += " 졸업";
                    myprofileeducation.setText(eduactiontext);
                    myeducation = eduactiontext;
                   break;
                case 3:
                    eduactiontext += " 기타";
                    myprofileeducation.setText(eduactiontext);
                    myeducation = eduactiontext;
                    break;
                case 4:
                    eduactiontext += " 중퇴";
                    myprofileeducation.setText(eduactiontext);
                    myeducation = eduactiontext;
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            editor.putString("MyEducation", myeducation);
            editor.apply();

        }


        mapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), PlaceActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                startActivity(intent);
                finish();
            }
        });

        myprofileaddimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfileImageSetFragment myProfileImageSetFragment = new MyProfileImageSetFragment();
                frameLayout.setVisibility(View.VISIBLE);
                myprofiletoptext.setText("사진");
                fragmentTransaction.add(R.id.frameLayout, myProfileImageSetFragment).commit();
            }
        });

        myprofileedittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                myprofiletextcount.setText("" + (300 - myprofileedittext.getText().toString().length()));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        myprofilejobbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = new MainActivity();
                mainActivity.replaceFragment(SettingFragment.newInstance());
            }
        });

        myprofilereligionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfileReligionFragment myProfileReligionFragment = new MyProfileReligionFragment();
                frameLayout.setVisibility(View.VISIBLE);
                fragmentTransaction.add(R.id.frameLayout, myProfileReligionFragment).commit();
                myprofiletop.setVisibility(View.INVISIBLE);
            }
        });

        myprofiledrinkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfileDrinkFragment myProfileDrinkFragment = new MyProfileDrinkFragment();
                frameLayout.setVisibility(View.VISIBLE);
                fragmentTransaction.add(R.id.frameLayout, myProfileDrinkFragment).commit();
                myprofiletop.setVisibility(View.INVISIBLE);
            }
        });

        myprofilesmokebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfileSmokeFragment myProfileSmokeFragment = new MyProfileSmokeFragment();
                frameLayout.setVisibility(View.VISIBLE);
                fragmentTransaction.add(R.id.frameLayout, myProfileSmokeFragment).commit();
                myprofiletop.setVisibility(View.INVISIBLE);
            }
        });

        myprofilepetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfilePetFragment myProfilePetFragment = new MyProfilePetFragment();
                frameLayout.setVisibility(View.VISIBLE);
                fragmentTransaction.add(R.id.frameLayout, myProfilePetFragment).commit();
                myprofiletop.setVisibility(View.INVISIBLE);
            }
        });

        myprofilecharactorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfileCharactorFragment myProfileCharactorFragment = new MyProfileCharactorFragment();
                frameLayout.setVisibility(View.VISIBLE);
                fragmentTransaction.add(R.id.frameLayout, myProfileCharactorFragment).commit();
                myprofiletop.setVisibility(View.INVISIBLE);
            }
        });

        myprofileeducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfileEducationFragment myProfileEducationFragment = new MyProfileEducationFragment();
                frameLayout.setVisibility(View.VISIBLE);
                fragmentTransaction.add(R.id.frameLayout, myProfileEducationFragment).commit();
                myprofiletop.setVisibility(View.INVISIBLE);
            }
        });

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        databaseReference.child(uid).child("ProfileData").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ProfileData profileData1 = dataSnapshot.getValue(ProfileData.class);

                //각각의 값 받아오기 get어쩌구 함수들은 intakegroup.class에서 지정한것
                name = profileData1.getName();
                age = profileData1.getBirth();
                gender = profileData1.getGender();
                job = profileData1.getJob();
                charactor = profileData1.getCharactor();
                hobby = profileData1.getHobby();
                wantfriend = profileData1.getWantfriend();
                myprofilename.setText(name);
                myprofilejobbtn.setText(job);

                if (gender.equals("남성")) {
                    myprofilegender.setText("남성");
                    myprofilegender.setTextColor(ColorStateList.valueOf(Color.parseColor("#0062D7")));
                } else {
                    myprofilegender.setText("여성");
                    myprofilegender.setTextColor(ColorStateList.valueOf(Color.parseColor("#EF5DA8")));
                }
                myprofileage.setText(age + "세");

                String charactorlist[] = charactor.split(",");

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

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (frameLayout.getVisibility() != View.VISIBLE && System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "뒤로 가기 버튼을 한 번 더 누르시면 종료됩니다.", Toast.LENGTH_LONG);
            toast.show();
            return;
        } else {
            frameLayout.setVisibility(View.GONE);
            myprofiletoptext.setText("마이 프로필");
        }

        if (System.currentTimeMillis() <= backKeyPressedTime + 2500) {
            moveTaskToBack(true); // 태스크를 백그라운드로 이동
            finishAndRemoveTask(); // 액티비티 종료 + 태스크 리스트에서 지우기
            android.os.Process.killProcess(android.os.Process.myPid()); // 앱 프로세스 종료
            System.exit(0);
        }
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview_charactor);
        RecyclerView recyclerView2 = findViewById(R.id.recyclerview_hobby);
        RecyclerView recyclerview3 = findViewById(R.id.recyclerview_wantfriend);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView2.setLayoutManager(linearLayoutManager2);

        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerview3.setLayoutManager(linearLayoutManager3);

        adapter = new RecyclerAdapter();
        adapter2 = new RecyclerAdapter2();
        adapter3 = new RecyclerAdapter3();
        recyclerView.setAdapter(adapter);
        recyclerView2.setAdapter(adapter2);
        recyclerview3.setAdapter(adapter3);
    }

    private void getCharactorData() {
        Intent intent = getIntent();
        ArrayList<String> list = (ArrayList<String>) intent.getSerializableExtra("Charactor position");

        for (int i = 0; i < list.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            charactorData data = new charactorData();
            data.setTitle(list.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);

        myprofiletop.setVisibility(View.VISIBLE);
    }



    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        try {
            switch (intent.getExtras().getString("Job position")) {
                case "0":
                    myprofilejobbtn.setText("학생");
                    break;
                case "1":
                    myprofilejobbtn.setText("직장인");
                    break;
                case "2":
                    myprofilejobbtn.setText("사업가");
                    break;
                case "3":
                    myprofilejobbtn.setText("군인");
                    break;
                case "4":
                    myprofilejobbtn.setText("취업준비중");
                    break;
                case "5":
                    myprofilejobbtn.setText("기타");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myjob = myprofilejobbtn.getText().toString();
            editor.putString("MyJob", myjob);
            editor.apply();
        }

        try {
            switch (intent.getExtras().getString("Religion position")) {
                case "0":
                    myprofilereligionbtn.setText("무교");
                    break;
                case "1":
                    myprofilereligionbtn.setText("기독교");
                    break;
                case "2":
                    myprofilereligionbtn.setText("불교");
                    break;
                case "3":
                    myprofilereligionbtn.setText("천주교");
                    break;
                case "4":
                    myprofilereligionbtn.setText("기타");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myreligion = myprofilereligionbtn.getText().toString();
            editor.putString("MyReligion", myreligion);
            editor.apply();
        }

        try {
            switch (intent.getExtras().getString("Drink position")) {
                case "0":
                    myprofiledrinkbtn.setText("전혀 안 함");
                    break;
                case "1":
                    myprofiledrinkbtn.setText("특별한 날 가끔");
                    break;
                case "2":
                    myprofiledrinkbtn.setText("한달에 1~2번");
                    break;
                case "3":
                    myprofiledrinkbtn.setText("일주일에 1~2번");
                    break;
                case "4":
                    myprofiledrinkbtn.setText("일주일에 3~5번");
                    break;
                case "5":
                    myprofiledrinkbtn.setText("거의 매일");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mydrink = myprofiledrinkbtn.getText().toString();
            editor.putString("MyDrink", mydrink);
            editor.apply();
        }

        try {
            switch (intent.getExtras().getString("Smoke position")) {
                case "0":
                    myprofilesmokebtn.setText("전혀 안 함");
                    break;
                case "1":
                    myprofilesmokebtn.setText("특별한 날 가끔");
                    break;
                case "2":
                    myprofilesmokebtn.setText("매일");
                    break;
                case "3":
                    myprofilesmokebtn.setText("전자 담배만");
                    break;
                case "4":
                    myprofilesmokebtn.setText("기타");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysmoke = myprofilesmokebtn.getText().toString();
            editor.putString("MySmoke", mysmoke);
            editor.apply();
        }


        try {
            switch (intent.getExtras().getString("Pet position")) {
                case "0":
                    myprofilepetbtn.setText("강아지");
                    break;
                case "1":
                    myprofilepetbtn.setText("고양이");
                    break;
                case "2":
                    myprofilepetbtn.setText("햄스터");
                    break;
                case "3":
                    myprofilepetbtn.setText("물고기");
                    break;
                case "4":
                    myprofilepetbtn.setText("파충류");
                    break;
                case "5":
                    myprofilepetbtn.setText("양서류");
                    break;
                case "6":
                    myprofilepetbtn.setText("없음");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mypet = myprofilepetbtn.getText().toString();
            editor.putString("MyPet", mypet);
            editor.apply();
        }

        String eduactiontext = "";

        try {
            switch (intent.getExtras().getInt("education position")) {
                case 1:
                    eduactiontext = "전문대";
                    break;
                case 2:
                    eduactiontext = "대학교";
                    break;
                case 3:
                    eduactiontext = "대학원";
                    break;
                case 4:
                    eduactiontext = "고등학교";
                    break;
                case 5:
                    eduactiontext = "중학교";
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            switch (intent.getExtras().getInt("education2 position")) {
                case 1:
                    Log.d("또타냐?","오바지");
                    eduactiontext += " 재학";
                    myprofileeducation.setText(eduactiontext);
                    myeducation = eduactiontext;
                    break;
                case 2:
                    eduactiontext += " 졸업";
                    myprofileeducation.setText(eduactiontext);
                    myeducation = eduactiontext;
                    break;
                case 3:
                    eduactiontext += " 기타";
                    myprofileeducation.setText(eduactiontext);
                    myeducation = eduactiontext;
                    break;
                case 4:
                    eduactiontext += " 중퇴";
                    myprofileeducation.setText(eduactiontext);
                    myeducation = eduactiontext;
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            editor.putString("MyEducation", myeducation);
            editor.apply();

        }



    }
}