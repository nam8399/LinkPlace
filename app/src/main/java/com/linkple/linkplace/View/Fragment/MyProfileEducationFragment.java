package com.linkple.linkplace.View.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

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
import com.linkple.linkplace.databinding.FragmentMyProfileEducationBinding;

public class MyProfileEducationFragment extends Fragment {
    private FragmentMyProfileEducationBinding binding;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    String name, age, gender, job, charactor, hobby, wantfriend, imageUrl, education, religion, drink, smoke, pet, introduce, career;

    public MyProfileEducationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMyProfileEducationBinding.inflate(getLayoutInflater());

        initPicker();

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
        binding.inputjobbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MyProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("education position", binding.educationpicker.getValue());
                intent.putExtra("education2 position", binding.educationpicker2.getValue());
                getEducation();
                addProfileData(name, age, gender, job, charactor, hobby, wantfriend, imageUrl, education, religion, drink, smoke, pet, introduce, career);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

    private void initPicker() {
        String[] arrayString= new String[]{" ","전문대","대학교","대학원","고등학교","중학교"};
        binding.educationpicker.setMinValue(0);
        binding.educationpicker.setMaxValue(arrayString.length-1);
        binding.educationpicker.setValue(0);

        binding.educationpicker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                // TODO Auto-generated method stub
                return arrayString[value];
            }
        });

        String[] arrayString2= new String[]{" ","재학","졸업","기타","중퇴"};
        binding.educationpicker2.setMinValue(0);
        binding.educationpicker2.setMaxValue(arrayString2.length-1);
        binding.educationpicker2.setValue(0);

        binding.educationpicker2.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                // TODO Auto-generated method stub
                return arrayString2[value];
            }
        });
    }

    private void getEducation() {
        try {
            switch (binding.educationpicker.getValue()) {
                case 1:
                    education = "전문대";
                    break;
                case 2:
                    education = "대학교";
                    break;
                case 3:
                    education = "대학원";
                    break;
                case 4:
                    education = "고등학교";
                    break;
                case 5:
                    education = "중학교";
                    break;
            }

            switch (binding.educationpicker2.getValue()) {
                case 1:
                    education += " 재학";
                    break;
                case 2:
                    education += " 졸업";
                    break;
                case 3:
                    education += " 기타";
                    break;
                case 4:
                    education += " 중퇴";
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