package com.example.linkplace.View.Fragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
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

import static com.example.linkplace.R.drawable.genderclickbtn;
import static com.example.linkplace.R.drawable.genderselectbutton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileBirthSetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GenderSetFragment extends Fragment {
    EditText profile_year, profile_month, profile_day;
    Button back_button, inputgenderbtn, gendermalebtn, genderfemalebtn;
    LinearLayout inputauthbirthtext, inputauthbirthtext2, inputauthbirthtext3;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    String name, age, gender;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters

    public GenderSetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProfileBirthSetFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static GenderSetFragment newInstance() {
        return new GenderSetFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gender_set, container, false);
        back_button = view.findViewById(R.id.back_button);
        inputgenderbtn = view.findViewById(R.id.inputgenderbtn);
        gendermalebtn = view.findViewById(R.id.gendermalebtn);
        genderfemalebtn = view.findViewById(R.id.genderfemalebtn);

        init();


        return view;
    }

    private void init() {
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(ProfileBirthSetFragment.newInstance());
            }
        });

        inputgenderbtn.setEnabled(false);

        gendermalebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gendermalebtn.setBackgroundResource(genderclickbtn);
                genderfemalebtn.setBackgroundResource(genderselectbutton);
                gendermalebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                genderfemalebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                gendermalebtn.setTypeface(Typeface.DEFAULT_BOLD);
                genderfemalebtn.setTypeface(Typeface.DEFAULT);
                inputgenderbtn.setEnabled(true);
                inputgenderbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                gender = "남성";
            }
        });

        genderfemalebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gendermalebtn.setBackgroundResource(genderselectbutton);
                genderfemalebtn.setBackgroundResource(genderclickbtn);
                gendermalebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                genderfemalebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                gendermalebtn.setTypeface(Typeface.DEFAULT);
                genderfemalebtn.setTypeface(Typeface.DEFAULT_BOLD);
                inputgenderbtn.setEnabled(true);
                inputgenderbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                gender = "여성";
            }
        });

        inputgenderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(JobSetFragment.newInstance());
                addProfileData(name, age, gender, "", "", "", "", "", "", "", "", "", "");
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