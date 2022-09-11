package com.linkple.linkplace.View.Fragment;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.linkple.linkplace.R;
import com.linkple.linkplace.View.Activity.MyProfileActivity;
import com.linkple.linkplace.View.Model.ProfileData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.linkple.linkplace.databinding.FragmentMyProfileSmokeBinding;

import static com.linkple.linkplace.R.drawable.genderclickbtn;
import static com.linkple.linkplace.R.drawable.genderselectbutton;

public class MyProfileSmokeFragment extends Fragment {
    private FragmentMyProfileSmokeBinding binding;
    private String clickposition;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    String name, age, gender, job, charactor, hobby, wantfriend, imageUrl, education, religion, drink, smoke, pet, introduce, career;
    public MyProfileSmokeFragment() {
        // Required empty public constructor
    }


    public static MyProfileSmokeFragment newInstance() {
        return new MyProfileSmokeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMyProfileSmokeBinding.inflate(getLayoutInflater());

        listenerSetting();

        firebaseSetting();

        return binding.getRoot();
    }

    private void firebaseSetting() {
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
                charactor = profileData1.getHobby();
                hobby = profileData1.getHobby();
                wantfriend = profileData1.getWantfriend();
                imageUrl = profileData1.getImageUrl();
                education = profileData1.getEducation();
                religion = profileData1.getReligion();
                drink = profileData1.getDrink();
                smoke = profileData1.getSmoke();
                pet = profileData1.getPet();
                introduce = profileData1.getIntroduce();
                career = profileData1.getCareer();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
    }

    private void listenerSetting() {
        binding.inputsmokebtn.setEnabled(false);

        binding.studentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.studentbtn.setBackgroundResource(genderclickbtn);
                binding.workerbtn.setBackgroundResource(genderselectbutton);
                binding.businessbtn.setBackgroundResource(genderselectbutton);
                binding.armybtn.setBackgroundResource(genderselectbutton);
                binding.preparingbtn.setBackgroundResource(genderselectbutton);

                binding.studentbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                binding.workerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                binding.businessbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                binding.armybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                binding.preparingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));

                binding.studentbtn.setTypeface(Typeface.DEFAULT_BOLD);
                binding.workerbtn.setTypeface(Typeface.DEFAULT);
                binding.businessbtn.setTypeface(Typeface.DEFAULT);
                binding.armybtn.setTypeface(Typeface.DEFAULT);
                binding.preparingbtn.setTypeface(Typeface.DEFAULT);
                smokebtnEnable();
                clickposition = "0";
            }
        });

        binding.workerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.workerbtn.setBackgroundResource(genderclickbtn);
                binding.studentbtn.setBackgroundResource(genderselectbutton);
                binding.businessbtn.setBackgroundResource(genderselectbutton);
                binding.armybtn.setBackgroundResource(genderselectbutton);
                binding.preparingbtn.setBackgroundResource(genderselectbutton);

                binding.workerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                binding.studentbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                binding.businessbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                binding.armybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                binding.preparingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));

                binding.workerbtn.setTypeface(Typeface.DEFAULT_BOLD);
                binding.studentbtn.setTypeface(Typeface.DEFAULT);
                binding.businessbtn.setTypeface(Typeface.DEFAULT);
                binding.armybtn.setTypeface(Typeface.DEFAULT);
                binding.preparingbtn.setTypeface(Typeface.DEFAULT);
                smokebtnEnable();
                clickposition = "1";
            }
        });

        binding.businessbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.businessbtn.setBackgroundResource(genderclickbtn);
                binding.studentbtn.setBackgroundResource(genderselectbutton);
                binding.workerbtn.setBackgroundResource(genderselectbutton);
                binding.armybtn.setBackgroundResource(genderselectbutton);
                binding.preparingbtn.setBackgroundResource(genderselectbutton);

                binding.businessbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                binding.studentbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                binding.workerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                binding.armybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                binding.preparingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));

                binding.businessbtn.setTypeface(Typeface.DEFAULT_BOLD);
                binding.studentbtn.setTypeface(Typeface.DEFAULT);
                binding.workerbtn.setTypeface(Typeface.DEFAULT);
                binding.armybtn.setTypeface(Typeface.DEFAULT);
                binding.preparingbtn.setTypeface(Typeface.DEFAULT);
                smokebtnEnable();
                clickposition = "2";
            }
        });

        binding.armybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.armybtn.setBackgroundResource(genderclickbtn);
                binding.studentbtn.setBackgroundResource(genderselectbutton);
                binding.workerbtn.setBackgroundResource(genderselectbutton);
                binding.businessbtn.setBackgroundResource(genderselectbutton);
                binding.preparingbtn.setBackgroundResource(genderselectbutton);

                binding.armybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                binding.studentbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                binding.workerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                binding.businessbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                binding.preparingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));

                binding.armybtn.setTypeface(Typeface.DEFAULT_BOLD);
                binding.studentbtn.setTypeface(Typeface.DEFAULT);
                binding.workerbtn.setTypeface(Typeface.DEFAULT);
                binding.businessbtn.setTypeface(Typeface.DEFAULT);
                binding.preparingbtn.setTypeface(Typeface.DEFAULT);
                smokebtnEnable();
                clickposition = "3";
            }
        });

        binding.preparingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.preparingbtn.setBackgroundResource(genderclickbtn);
                binding.studentbtn.setBackgroundResource(genderselectbutton);
                binding.workerbtn.setBackgroundResource(genderselectbutton);
                binding.businessbtn.setBackgroundResource(genderselectbutton);
                binding.armybtn.setBackgroundResource(genderselectbutton);

                binding.preparingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                binding.studentbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                binding.workerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                binding.businessbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                binding.armybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));

                binding.preparingbtn.setTypeface(Typeface.DEFAULT_BOLD);
                binding.studentbtn.setTypeface(Typeface.DEFAULT);
                binding.workerbtn.setTypeface(Typeface.DEFAULT);
                binding.businessbtn.setTypeface(Typeface.DEFAULT);
                binding.armybtn.setTypeface(Typeface.DEFAULT);
                smokebtnEnable();
                clickposition = "4";
            }
        });


        binding.inputsmokebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MyProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("Smoke position", clickposition);
                getSmoke();
                addProfileData(name, age, gender, job, charactor, hobby, wantfriend, imageUrl, education, religion, drink, smoke, pet, introduce, career);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

    private void smokebtnEnable() {
        binding.inputsmokebtn.setEnabled(true);
        binding.inputsmokebtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
    }

    private void getSmoke() {
        try {
            switch (clickposition) {
                case "0":
                    smoke = "전혀 안 함";
                    break;
                case "1":
                    smoke = "특별한 날 가끔";
                    break;
                case "2":
                    smoke = "매일";
                    break;
                case "3":
                    smoke = "전자 담배만";
                    break;
                case "4":
                    smoke = "기타";
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addProfileData(String name, String birth, String gender, String job, String charactor, String hobby, String wantfriend, String ImageUrl, String education,
                               String religion, String drink, String smoke, String pet, String introduce, String career) {


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        ProfileData profileData1 = new ProfileData(name, birth, gender, job, charactor, hobby, wantfriend, ImageUrl, education, religion, drink, smoke, pet, introduce, career);
        databaseReference.child(uid).child("ProfileData").setValue(profileData1);

    }

    public void onDestroyView() {
        super.onDestroyView();

        binding=null;
    }
}