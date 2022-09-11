package com.linkple.linkplace.View.Fragment;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
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
import com.linkple.linkplace.databinding.FragmentMyProfileHobbyBinding;

import java.util.ArrayList;

import static com.linkple.linkplace.R.drawable.characterclickbtn;
import static com.linkple.linkplace.R.drawable.characterselectbtn;

public class MyProfileHobbyFragment extends Fragment {
    private FragmentMyProfileHobbyBinding binding;

    int selectCount = 0;
    int btn1cnt, btn2cnt, btn3cnt, btn4cnt, btn5cnt, btn6cnt, btn7cnt, btn8cnt, btn9cnt, btn10cnt, btn11cnt, btn12cnt, btn13cnt, btn14cnt = 0;
    boolean click1, click2, click3, click4, click5, click6, click7, click8, click9, click10;
    ArrayList<String> listTitle = new ArrayList<String>();


    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    String name, age, gender, job, charactor, hobby, wantfriend, imageUrl, education, religion, drink, smoke, pet, introduce, career;

    public MyProfileHobbyFragment() {
        // Required empty public constructor
    }

    public static MyProfileHobbyFragment newInstance() {
        return new MyProfileHobbyFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMyProfileHobbyBinding.inflate(getLayoutInflater());

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
                charactor = profileData1.getCharactor();
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
        binding.inputhobbybtn.setEnabled(false);

        binding.extervalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn1cnt == 0) {
                    click1 = true;
                    selectCount += 1;
                    btn1cnt += 1;
                    binding.extervalbtn.setBackgroundResource(characterclickbtn);
                    binding.extervalbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                } else {
                    click1 = false;
                    selectCount -= 1;
                    btn1cnt -= 1;
                    binding.extervalbtn.setBackgroundResource(characterselectbtn);
                    binding.extervalbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    hobbybtnEnable();
                }
            }
        });

        binding.intervalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn2cnt == 0) {
                    click2 = true;
                    selectCount += 1;
                    btn2cnt += 1;
                    binding.intervalbtn.setBackgroundResource(characterclickbtn);
                    binding.intervalbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                } else {
                    click2 = false;
                    selectCount -= 1;
                    btn2cnt -= 1;
                    binding.intervalbtn.setBackgroundResource(characterselectbtn);
                    binding.intervalbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    hobbybtnEnable();
                }
            }
        });

        binding.activitybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn3cnt == 0) {
                    click3 = true;
                    selectCount += 1;
                    btn3cnt += 1;
                    binding.activitybtn.setBackgroundResource(characterclickbtn);
                    binding.activitybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                } else {
                    click3 = false;
                    selectCount -= 1;
                    btn3cnt -= 1;
                    binding.activitybtn.setBackgroundResource(characterselectbtn);
                    binding.activitybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    hobbybtnEnable();
                }
            }
        });

        binding.quietbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn4cnt == 0) {
                    click4 = true;
                    selectCount += 1;
                    btn4cnt += 1;
                    binding.quietbtn.setBackgroundResource(characterclickbtn);
                    binding.quietbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                } else {
                    click4 = false;
                    selectCount -= 1;
                    btn4cnt -= 1;
                    binding.quietbtn.setBackgroundResource(characterselectbtn);
                    binding.quietbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    hobbybtnEnable();
                }
            }
        });

        binding.cutebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn5cnt == 0) {
                    click5 = true;
                    selectCount += 1;
                    btn5cnt += 1;
                    binding.cutebtn.setBackgroundResource(characterclickbtn);
                    binding.cutebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                } else {
                    click5 = false;
                    selectCount -= 1;
                    btn5cnt -= 1;
                    binding.cutebtn.setBackgroundResource(characterselectbtn);
                    binding.cutebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    hobbybtnEnable();
                }
            }
        });

        binding.adultbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn6cnt == 0) {
                    click6 = true;
                    selectCount += 1;
                    btn6cnt += 1;
                    binding.adultbtn.setBackgroundResource(characterclickbtn);
                    binding.adultbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                } else {
                    click6 = false;
                    selectCount -= 1;
                    btn6cnt -= 1;
                    binding.adultbtn.setBackgroundResource(characterselectbtn);
                    binding.adultbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    hobbybtnEnable();
                }
            }
        });

        binding.passionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn7cnt == 0) {
                    click7 = true;
                    selectCount += 1;
                    btn7cnt += 1;
                    binding.passionbtn.setBackgroundResource(characterclickbtn);
                    binding.passionbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                } else {
                    click7 = false;
                    selectCount -= 1;
                    btn7cnt -= 1;
                    binding.passionbtn.setBackgroundResource(characterselectbtn);
                    binding.passionbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    hobbybtnEnable();
                }
            }
        });

        binding.relaxedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn8cnt == 0) {
                    click8 = true;
                    selectCount += 1;
                    btn8cnt += 1;
                    binding.relaxedbtn.setBackgroundResource(characterclickbtn);
                    binding.relaxedbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                } else {
                    click8 = false;
                    selectCount -= 1;
                    btn8cnt -= 1;
                    binding.relaxedbtn.setBackgroundResource(characterselectbtn);
                    binding.relaxedbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    hobbybtnEnable();
                }
            }
        });

        binding.fourthdimentionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn9cnt == 0) {
                    click9 = true;
                    selectCount += 1;
                    btn9cnt += 1;
                    binding.fourthdimentionbtn.setBackgroundResource(characterclickbtn);
                    binding.fourthdimentionbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                } else {
                    click9 = false;
                    selectCount -= 1;
                    btn9cnt -= 1;
                    binding.fourthdimentionbtn.setBackgroundResource(characterselectbtn);
                    binding.fourthdimentionbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    hobbybtnEnable();
                }
            }
        });

        binding.politebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn10cnt == 0) {
                    click10 = true;
                    selectCount += 1;
                    btn10cnt += 1;
                    binding.politebtn.setBackgroundResource(characterclickbtn);
                    binding.politebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                } else {
                    click10 = false;
                    selectCount -= 1;
                    btn10cnt -= 1;
                    binding.politebtn.setBackgroundResource(characterselectbtn);
                    binding.politebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    hobbybtnEnable();
                }
            }
        });




        binding.inputhobbybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MyProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                addProfileData(name, age, gender, job, charactor, clickmanage(), wantfriend, imageUrl, education, religion, drink, smoke, pet, introduce, career);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

    private void hobbybtnEnable() {
        if (selectCount > 1 && selectCount < 11) {
            binding.inputhobbybtn.setEnabled(true);
            binding.inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
        } else {
            binding.inputhobbybtn.setEnabled(false);
            binding.inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
        }
    }

    private String clickmanage() {
        String result = "";

        if (click1) {
            result += "영화/드라마";
        }
        if (click2) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "음악 감상";
        }
        if (click3) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "코인노래방";
        }
        if (click4) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "게임";
        }
        if (click5) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "여행";
        }
        if (click6) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "쇼핑";
        }
        if (click7) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "독서";
        }
        if (click8) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "맛집 투어";
        }
        if (click9) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "카페 투어";
        }
        if (click10) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "운동/헬스";
        }

        return result;

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