package com.example.linkplace.View.Fragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.linkplace.R;
import com.example.linkplace.View.Activity.MainActivity;
import com.example.linkplace.View.Model.ProfileData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileBirthSetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileBirthSetFragment extends Fragment {
    EditText profile_year, profile_month, profile_day;
    Button back_button, inputbirthbtn;
    LinearLayout inputauthbirthtext, inputauthbirthtext2, inputauthbirthtext3;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    String name;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters

    public ProfileBirthSetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProfileBirthSetFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static ProfileBirthSetFragment newInstance() {
        return new ProfileBirthSetFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_birth_set, container, false);
        profile_year = view.findViewById(R.id.profile_year);
        profile_month = view.findViewById(R.id.profile_month);
        profile_day = view.findViewById(R.id.profile_day);
        back_button = view.findViewById(R.id.back_button);
        inputauthbirthtext = view.findViewById(R.id.inputauthbirthtext);
        inputauthbirthtext2 = view.findViewById(R.id.inputauthbirthtext2);
        inputauthbirthtext3 = view.findViewById(R.id.inputauthbirthtext3);
        inputbirthbtn = view.findViewById(R.id.inputbirthbtn);

        inputbirthbtn.setEnabled(false);

        init();




        return view;
    }

    private void init() {
        profile_year.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    inputauthbirthtext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    inputauthbirthtext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        profile_day.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    inputauthbirthtext3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    inputauthbirthtext3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        profile_month.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    inputauthbirthtext2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    inputauthbirthtext2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        profile_year.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (profile_year.length() > 3) {
                    profile_month.requestFocus();
                }
            }
        });

        profile_month.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (profile_month.length() > 1) {
                    profile_day.requestFocus();
                }
            }
        });

        profile_day.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (profile_month.length() > 1) {
                    inputbirthbtn.setEnabled(true);
                    inputbirthbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    inputbirthbtn.setEnabled(false);
                    inputbirthbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                }
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(ProfileSetFragment.newInstance());
            }
        });

        inputbirthbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(GenderSetFragment.newInstance());
                String year = profile_year.getText().toString();
                int age = 2022 - Integer.parseInt(year) + 1;
                year = String.valueOf(age);
                addProfileData(name, year, "", "", "", "", "", "", "", "", "", "", "");
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
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
    }

    public void addProfileData(String name, String birth, String gender, String job, String charactor, String hobby, String wantfriend, String ImageUrl, String education,
                               String religion, String drink, String smoke, String pet) {

        //여기에서 직접 변수를 만들어서 값을 직접 넣는것도 가능합니다.
        // ex) 갓 태어난 동물만 입력해서 int age=1; 등을 넣는 경우

        //animal.java에서 선언했던 함수.
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        ProfileData profileData1 = new ProfileData(name, birth, gender, job, charactor, hobby, wantfriend, ImageUrl, education, religion, drink, smoke, pet);
        databaseReference.child(uid).child("ProfileData").setValue(profileData1);

    }
}