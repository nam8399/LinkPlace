package com.linkple.linkplace.View.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.linkple.linkplace.R;
import com.linkple.linkplace.View.Activity.MainActivity;
import com.linkple.linkplace.View.Activity.PlaceActivity;
import com.linkple.linkplace.View.Model.ProfileData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.linkple.linkplace.View.Util.ProgressDialog;
import com.linkple.linkplace.databinding.FragmentProfileSetBinding;

public class ProfileSetFragment extends Fragment {
    private SharedPreferences sharedPref;
    FragmentProfileSetBinding binding;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    Thread autologincheck_Thread;

    FirebaseAuth mAuth;

    Handler handler = new Handler();
    ProgressDialog progressDialog;
    String name;

    public ProfileSetFragment() {
        // Required empty public constructor
    }

    public static ProfileSetFragment newInstance() {
        return new ProfileSetFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProfileSetBinding.inflate(getLayoutInflater());

        listenerSetting();

        return binding.getRoot();
    }



    private void autologincheck() {
        autologincheck_Thread = new Thread(new Runnable() {
            boolean isRun = false;
            int value = 0;

            @Override
            public void run() {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                try {
                    String uid = user.getUid();
                    databaseReference.child(uid).child("ProfileData").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            ProfileData profileData1 = dataSnapshot.getValue(ProfileData.class);

                            name = null;
                            //각각의 값 받아오기 get어쩌구 함수들은 intakegroup.class에서 지정한것
                            try {
                                name = profileData1.getWantfriend();
                                Log.d("InputNumberFragment", "name : " + name);
                            } catch (Exception e) {
                                name = null;
                                e.printStackTrace();

                            }
                            if (name != null && !name.equals("")) {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            progressDialog.dismiss();
                                            Intent intent = new Intent(getContext(), PlaceActivity.class);
                                            startActivity(intent);
                                            getActivity().finish();
                                            Toast toast = Toast.makeText(getContext(), "자동 로그인 성공", Toast.LENGTH_SHORT);
                                            toast.show();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                    }
                                });
                            } else {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressDialog.dismiss();
                                    }
                                });
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        autologincheck_Thread.start(); //start()붙이면 바로실행시킨다.

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        autologincheck_Thread.interrupt();
    }

    private void listenerSetting() {
        binding.inputnamebtn.setEnabled(false);
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(InputNumberFragment.newInstance());
            }
        });

        binding.inputnametext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (binding.inputnametext.length() > 1 && binding.inputnamebtn.length() < 13) {
                    binding.inputnamebtn.setClickable(true);
                    binding.inputnamebtn.setEnabled(true);
                    binding.inputnamebtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    binding.inputnamebtn.setClickable(false);
                    binding.inputnamebtn.setEnabled(false);
                    binding.inputnamebtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                }
            }
        });

        binding.inputnamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProfileData(binding.inputnametext.getText().toString(), "", "", "", "", "", "", "", "", "", "", "", "", "", "");
                ((MainActivity)getActivity()).replaceFragment(ProfileBirthSetFragment.newInstance());
            }
        });

        String content = binding.nameinputguidetext.getText().toString();
        SpannableString spannableString = new SpannableString(content);

        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        binding.nameinputguidetext.setText(spannableString);


        binding.inputnametext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    binding.inputnameLinear.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    binding.inputnameLinear.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });
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
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        autologincheck_Thread.interrupt();
        binding=null;
    }

    @Override
    public void onStart() {
        super.onStart();
        progressDialog = new ProgressDialog(getContext());
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        progressDialog.setCancelable(false);

        progressDialog.show();


        autologincheck();
    }
}