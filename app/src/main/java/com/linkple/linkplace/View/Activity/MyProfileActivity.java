package com.linkple.linkplace.View.Activity;

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
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Toast;

import com.linkple.linkplace.R;
import com.linkple.linkplace.View.Adapter.RecyclerAdapter;
import com.linkple.linkplace.View.Adapter.RecyclerAdapter2;
import com.linkple.linkplace.View.Adapter.RecyclerAdapter3;
import com.linkple.linkplace.View.Fragment.MyProfileCharactorFragment;
import com.linkple.linkplace.View.Fragment.MyProfileDrinkFragment;
import com.linkple.linkplace.View.Fragment.MyProfileEducationFragment;
import com.linkple.linkplace.View.Fragment.MyProfileHobbyFragment;
import com.linkple.linkplace.View.Fragment.MyProfileImageSetFragment;
import com.linkple.linkplace.View.Fragment.MyProfileJobFragement;
import com.linkple.linkplace.View.Fragment.MyProfilePetFragment;
import com.linkple.linkplace.View.Fragment.MyProfileReligionFragment;
import com.linkple.linkplace.View.Fragment.MyProfileSmokeFragment;
import com.linkple.linkplace.View.Fragment.MyProfileWantFriendFragment;
import com.linkple.linkplace.View.Model.ProfileData;
import com.linkple.linkplace.View.Util.charactorData;
import com.linkple.linkplace.View.Util.jobData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.linkple.linkplace.databinding.ActivityMyProfileBinding;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class MyProfileActivity extends AppCompatActivity {
    private ActivityMyProfileBinding binding;
    private long backKeyPressedTime = 0;
    Toast toast;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String myjob, myreligion, mydrink, mysmoke, mypet, myeducation;
    private RecyclerAdapter charactorAdapter; // charactor adpater
    private RecyclerAdapter2 jobAdapter; // job adapter
    private RecyclerAdapter3 wantfriendAdapter; // wantfriend adpater

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    String name, age, gender, job, charactor, hobby, wantfriend, imageUrl, education, religion, drink, smoke, pet, introduce, career;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        datasetting(); // 초기 데이터 셋팅

        initRecyclerView(); // Recyclerview 생성

        listener(); // 버튼 동작 설정

        firebaseDataSetting(); // Firebase로 받은 데이터 설정
    }

    private void firebaseDataSetting() {
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

                if (!introduce.equals("")) {
                    binding.myprofileedittext.setText(introduce);
                }

                if (!career.equals("")) {
                    binding.myprofilecareer.setText(career);
                }

                String imageUrlList[] = imageUrl.split(",");
                binding.imagecounttext.setText("사진 (" + imageUrlList.length + "/9)");
                for (int i = 0; i < imageUrlList.length; i++) {
                    // 각 List의 값들을 data 객체에 set 해줍니다.
                    switch (i) {
                        case 0:
                            byte[] b = binaryStringToByteArray(imageUrlList[i]);
                            ByteArrayInputStream is = new ByteArrayInputStream(b);
                            Drawable reviewImage = Drawable.createFromStream(is, "reviewImage");
                            binding.circleimage.setImageDrawable(reviewImage);
                            binding.image1.setImageDrawable(reviewImage);
                            binding.image1.setOutlineProvider(new ViewOutlineProvider() {
                                @Override
                                public void getOutline(View view, Outline outline) {
                                    outline.setRoundRect(0,0,view.getWidth(), view.getHeight(), 40);
                                }
                            });
                            binding.image1.setClipToOutline(true);
                            break;
                        case 1:
                            byte[] b2 = binaryStringToByteArray(imageUrlList[i]);
                            ByteArrayInputStream is2 = new ByteArrayInputStream(b2);
                            Drawable reviewImage2 = Drawable.createFromStream(is2, "reviewImage");
                            binding.image2.setImageDrawable(reviewImage2);
                            binding.image2.setOutlineProvider(new ViewOutlineProvider() {
                                @Override
                                public void getOutline(View view, Outline outline) {
                                    outline.setRoundRect(0,0,view.getWidth(), view.getHeight(), 40);
                                }
                            });
                            binding.image2.setClipToOutline(true);
                            break;
                        case 2:
                            byte[] b3 = binaryStringToByteArray(imageUrlList[i]);
                            ByteArrayInputStream is3 = new ByteArrayInputStream(b3);
                            Drawable reviewImage3 = Drawable.createFromStream(is3, "reviewImage");
                            binding.image3.setImageDrawable(reviewImage3);
                            binding.image3.setOutlineProvider(new ViewOutlineProvider() {
                                @Override
                                public void getOutline(View view, Outline outline) {
                                    outline.setRoundRect(0,0,view.getWidth(), view.getHeight(), 40);
                                }
                            });
                            binding.image3.setClipToOutline(true);
                            break;
                        case 3:
                            byte[] b4 = binaryStringToByteArray(imageUrlList[i]);
                            ByteArrayInputStream is4 = new ByteArrayInputStream(b4);
                            Drawable reviewImage4 = Drawable.createFromStream(is4, "reviewImage");
                            binding.image4.setImageDrawable(reviewImage4);
                            binding.image4.setOutlineProvider(new ViewOutlineProvider() {
                                @Override
                                public void getOutline(View view, Outline outline) {
                                    outline.setRoundRect(0,0,view.getWidth(), view.getHeight(), 40);
                                }
                            });
                            binding.image4.setClipToOutline(true);
                            break;
                        case 4:
                            byte[] b5 = binaryStringToByteArray(imageUrlList[i]);
                            ByteArrayInputStream is5 = new ByteArrayInputStream(b5);
                            Drawable reviewImage5 = Drawable.createFromStream(is5, "reviewImage");
                            binding.image5.setImageDrawable(reviewImage5);
                            binding.image5.setOutlineProvider(new ViewOutlineProvider() {
                                @Override
                                public void getOutline(View view, Outline outline) {
                                    outline.setRoundRect(0,0,view.getWidth(), view.getHeight(), 40);
                                }
                            });
                            binding.image5.setClipToOutline(true);
                            break;
                        case 5:
                            byte[] b6 = binaryStringToByteArray(imageUrlList[i]);
                            ByteArrayInputStream is6 = new ByteArrayInputStream(b6);
                            Drawable reviewImage6 = Drawable.createFromStream(is6, "reviewImage");
                            binding.image6.setImageDrawable(reviewImage6);
                            binding.image6.setOutlineProvider(new ViewOutlineProvider() {
                                @Override
                                public void getOutline(View view, Outline outline) {
                                    outline.setRoundRect(0,0,view.getWidth(), view.getHeight(), 40);
                                }
                            });
                            binding.image6.setClipToOutline(true);
                            break;
                        case 6:
                            byte[] b7 = binaryStringToByteArray(imageUrlList[i]);
                            ByteArrayInputStream is7 = new ByteArrayInputStream(b7);
                            Drawable reviewImage7 = Drawable.createFromStream(is7, "reviewImage");
                            binding.image7.setImageDrawable(reviewImage7);
                            binding.image7.setOutlineProvider(new ViewOutlineProvider() {
                                @Override
                                public void getOutline(View view, Outline outline) {
                                    outline.setRoundRect(0,0,view.getWidth(), view.getHeight(), 40);
                                }
                            });
                            binding.image7.setClipToOutline(true);
                            break;
                        case 7:
                            byte[] b8 = binaryStringToByteArray(imageUrlList[i]);
                            ByteArrayInputStream is8 = new ByteArrayInputStream(b8);
                            Drawable reviewImage8 = Drawable.createFromStream(is8, "reviewImage");
                            binding.image8.setImageDrawable(reviewImage8);
                            binding.image8.setOutlineProvider(new ViewOutlineProvider() {
                                @Override
                                public void getOutline(View view, Outline outline) {
                                    outline.setRoundRect(0,0,view.getWidth(), view.getHeight(), 40);
                                }
                            });
                            binding.image8.setClipToOutline(true);
                            break;
                        case 8:
                            byte[] b9 = binaryStringToByteArray(imageUrlList[i]);
                            ByteArrayInputStream is9 = new ByteArrayInputStream(b9);
                            Drawable reviewImage9 = Drawable.createFromStream(is9, "reviewImage");
                            binding.image9.setImageDrawable(reviewImage9);
                            binding.image9.setOutlineProvider(new ViewOutlineProvider() {
                                @Override
                                public void getOutline(View view, Outline outline) {
                                    outline.setRoundRect(0,0,view.getWidth(), view.getHeight(), 40);
                                }
                            });
                            binding.image9.setClipToOutline(true);
                            break;
                    }

                }




                if (gender.equals("남성")) {
                    binding.myprofilegender.setText("남성");
                    binding.myprofilegender.setTextColor(ColorStateList.valueOf(Color.parseColor("#0062D7")));
                } else {
                    binding.myprofilegender.setText("여성");
                    binding.myprofilegender.setTextColor(ColorStateList.valueOf(Color.parseColor("#EF5DA8")));
                }
                binding.myprofileage.setText(age + "세");


                binding.myprofilename.setText(name);

                String charactorlist[] = charactor.split(",");

                charactorAdapter.clear();
                jobAdapter.clear();
                wantfriendAdapter.clear();

                for (int i = 0; i < charactorlist.length; i++) {
                    // 각 List의 값들을 data 객체에 set 해줍니다.
                    charactorData data = new charactorData();
                    data.setTitle(charactorlist[i]);

                    // 각 값이 들어간 data를 adapter에 추가합니다.
                    charactorAdapter.addItem(data);
                }

                // adapter의 값이 변경되었다는 것을 알려줍니다.
                charactorAdapter.notifyDataSetChanged();


                String hobbylist[] = hobby.split(",");

                for (int i = 0; i < hobbylist.length; i++) {
                    // 각 List의 값들을 data 객체에 set 해줍니다.
                    jobData data = new jobData();
                    data.setTitle(hobbylist[i]);

                    // 각 값이 들어간 data를 adapter에 추가합니다.
                    jobAdapter.addItem(data);
                }

                // adapter의 값이 변경되었다는 것을 알려줍니다.
                jobAdapter.notifyDataSetChanged();

                String wanfriendlist[] = wantfriend.split(",");


                for (int i = 0; i < wanfriendlist.length; i++) {
                    // 각 List의 값들을 data 객체에 set 해줍니다.
                    jobData data = new jobData();
                    data.setTitle(wanfriendlist[i]);

                    // 각 값이 들어간 data를 adapter에 추가합니다.
                    wantfriendAdapter.addItem(data);
                }

                // adapter의 값이 변경되었다는 것을 알려줍니다.
                wantfriendAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
    }

    private void listener() {
        binding.mapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), PlaceActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                startActivity(intent);
                introduce = binding.myprofileedittext.getText().toString();
                career = binding.myprofilecareer.getText().toString();
                addProfileData(name, age, gender, job, charactor, hobby, wantfriend, imageUrl, education, religion, drink, smoke, pet, introduce, career);
                finish();
            }
        });

        binding.myprofileaddimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfileImageSetFragment myProfileImageSetFragment = new MyProfileImageSetFragment();
                binding.frameLayout.setVisibility(View.VISIBLE);
                binding.myprofiletoptext.setText("사진");
                fragmentTransaction.add(R.id.frameLayout, myProfileImageSetFragment).commit();
            }
        });

        binding.myprofileedittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.myprofiletextcount.setText("" + (300 - binding.myprofileedittext.getText().toString().length()));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        binding.myprofilejobbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfileJobFragement myProfileJobFragement = new MyProfileJobFragement();
                binding.frameLayout.setVisibility(View.VISIBLE);
                fragmentTransaction.add(R.id.frameLayout, myProfileJobFragement).commit();
                binding.myprofiletop.setVisibility(View.INVISIBLE);
            }
        });

        binding.myprofilereligionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfileReligionFragment myProfileReligionFragment = new MyProfileReligionFragment();
                binding.frameLayout.setVisibility(View.VISIBLE);
                fragmentTransaction.add(R.id.frameLayout, myProfileReligionFragment).commit();
                binding.myprofiletop.setVisibility(View.INVISIBLE);
            }
        });

        binding.myprofiledrinkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfileDrinkFragment myProfileDrinkFragment = new MyProfileDrinkFragment();
                binding.frameLayout.setVisibility(View.VISIBLE);
                fragmentTransaction.add(R.id.frameLayout, myProfileDrinkFragment).commit();
                binding.myprofiletop.setVisibility(View.INVISIBLE);
            }
        });

        binding.myprofilesmokebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfileSmokeFragment myProfileSmokeFragment = new MyProfileSmokeFragment();
                binding.frameLayout.setVisibility(View.VISIBLE);
                fragmentTransaction.add(R.id.frameLayout, myProfileSmokeFragment).commit();
                binding.myprofiletop.setVisibility(View.INVISIBLE);
            }
        });

        binding.myprofilepetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfilePetFragment myProfilePetFragment = new MyProfilePetFragment();
                binding.frameLayout.setVisibility(View.VISIBLE);
                fragmentTransaction.add(R.id.frameLayout, myProfilePetFragment).commit();
                binding.myprofiletop.setVisibility(View.INVISIBLE);
            }
        });

        binding.myprofilecharactorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfileCharactorFragment myProfileCharactorFragment = new MyProfileCharactorFragment();
                binding.frameLayout.setVisibility(View.VISIBLE);
                fragmentTransaction.add(R.id.frameLayout, myProfileCharactorFragment).commit();
                binding.myprofiletop.setVisibility(View.INVISIBLE);
            }
        });

        binding.myprofilehobbybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfileHobbyFragment myProfileHobbyFragment = new MyProfileHobbyFragment();
                binding.frameLayout.setVisibility(View.VISIBLE);
                fragmentTransaction.add(R.id.frameLayout, myProfileHobbyFragment).commit();
                binding.myprofiletop.setVisibility(View.INVISIBLE);
            }
        });

        binding.myprofilwantfriendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfileWantFriendFragment myProfileWantFriendFragment = new MyProfileWantFriendFragment();
                binding.frameLayout.setVisibility(View.VISIBLE);
                fragmentTransaction.add(R.id.frameLayout, myProfileWantFriendFragment).commit();
                binding.myprofiletop.setVisibility(View.INVISIBLE);
            }
        });

        binding.myprofileeducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyProfileEducationFragment myProfileEducationFragment = new MyProfileEducationFragment();
                binding.frameLayout.setVisibility(View.VISIBLE);
                fragmentTransaction.add(R.id.frameLayout, myProfileEducationFragment).commit();
                binding.myprofiletop.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void datasetting() {
        pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        editor = pref.edit();

        myjob = pref.getString("MyJob", "학생");
        myreligion = pref.getString("MyReligion", "무교");
        mydrink = pref.getString("MyDrink", "전혀 안함");
        mysmoke = pref.getString("MySmoke", "비흡연");
        mypet = pref.getString("MyPet", "강아지");
        myeducation = pref.getString("MyEducation", "대학교 졸업");
        Log.d("뭐자","에듀테이션" + myeducation);


        Intent intent = getIntent();

        binding.myprofilejobbtn.setText(myjob);
        binding.myprofilereligionbtn.setText(myreligion);
        binding.myprofiledrinkbtn.setText(mydrink);
        binding.myprofilesmokebtn.setText(mysmoke);
        binding.myprofilepetbtn.setText(mypet);
        binding.myprofileeducation.setText(myeducation);

        try {
            byte[] byteArray = getIntent().getByteArrayExtra("image1");
            Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

            binding.image1.setImageBitmap(bitmap);
            binding.image1.setClipToOutline(true);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            switch (intent.getExtras().getString("Job position")) {
                case "0":
                    binding.myprofilejobbtn.setText("학생");
                    break;
                case "1":
                    binding.myprofilejobbtn.setText("직장인");
                    break;
                case "2":
                    binding.myprofilejobbtn.setText("사업가");
                    break;
                case "3":
                    binding.myprofilejobbtn.setText("군인");
                    break;
                case "4":
                    binding.myprofilejobbtn.setText("취업준비중");
                    break;
                case "5":
                    binding.myprofilejobbtn.setText("기타");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myjob = binding.myprofilejobbtn.getText().toString();
            editor.putString("MyJob", myjob);
            editor.apply();
            job = myjob;
        }

        try {
            switch (intent.getExtras().getString("Religion position")) {
                case "0":
                    binding.myprofilereligionbtn.setText("무교");
                    break;
                case "1":
                    binding.myprofilereligionbtn.setText("기독교");
                    break;
                case "2":
                    binding.myprofilereligionbtn.setText("불교");
                    break;
                case "3":
                    binding.myprofilereligionbtn.setText("천주교");
                    break;
                case "4":
                    binding.myprofilereligionbtn.setText("기타");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myreligion = binding.myprofilereligionbtn.getText().toString();
            editor.putString("MyReligion", myreligion);
            editor.apply();
            religion = myreligion;
        }

        try {
            switch (intent.getExtras().getString("Drink position")) {
                case "0":
                    binding.myprofiledrinkbtn.setText("전혀 안 함");
                    break;
                case "1":
                    binding.myprofiledrinkbtn.setText("특별한 날 가끔");
                    break;
                case "2":
                    binding.myprofiledrinkbtn.setText("한달에 1~2번");
                    break;
                case "3":
                    binding.myprofiledrinkbtn.setText("일주일에 1~2번");
                    break;
                case "4":
                    binding.myprofiledrinkbtn.setText("일주일에 3~5번");
                    break;
                case "5":
                    binding.myprofiledrinkbtn.setText("거의 매일");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mydrink = binding.myprofiledrinkbtn.getText().toString();
            editor.putString("MyDrink", mydrink);
            editor.apply();
            drink = mydrink;
        }

        try {
            switch (intent.getExtras().getString("Smoke position")) {
                case "0":
                    binding.myprofilesmokebtn.setText("전혀 안 함");
                    break;
                case "1":
                    binding.myprofilesmokebtn.setText("특별한 날 가끔");
                    break;
                case "2":
                    binding.myprofilesmokebtn.setText("매일");
                    break;
                case "3":
                    binding.myprofilesmokebtn.setText("전자 담배만");
                    break;
                case "4":
                    binding.myprofilesmokebtn.setText("기타");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysmoke = binding.myprofilesmokebtn.getText().toString();
            editor.putString("MySmoke", mysmoke);
            editor.apply();
            smoke = mysmoke;
        }


        try {
            switch (intent.getExtras().getString("Pet position")) {
                case "0":
                    binding.myprofilepetbtn.setText("강아지");
                    break;
                case "1":
                    binding.myprofilepetbtn.setText("고양이");
                    break;
                case "2":
                    binding.myprofilepetbtn.setText("햄스터");
                    break;
                case "3":
                    binding.myprofilepetbtn.setText("물고기");
                    break;
                case "4":
                    binding.myprofilepetbtn.setText("파충류");
                    break;
                case "5":
                    binding.myprofilepetbtn.setText("양서류");
                    break;
                case "6":
                    binding.myprofilepetbtn.setText("없음");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mypet = binding.myprofilepetbtn.getText().toString();
            editor.putString("MyPet", mypet);
            editor.apply();
            pet = mypet;
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
                    binding.myprofileeducation.setText(eduactiontext);
                    myeducation = eduactiontext;
                    break;
                case 2:
                    eduactiontext += " 졸업";
                    binding.myprofileeducation.setText(eduactiontext);
                    myeducation = eduactiontext;
                    break;
                case 3:
                    eduactiontext += " 기타";
                    binding.myprofileeducation.setText(eduactiontext);
                    myeducation = eduactiontext;
                    break;
                case 4:
                    eduactiontext += " 중퇴";
                    binding.myprofileeducation.setText(eduactiontext);
                    myeducation = eduactiontext;
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            editor.putString("MyEducation", myeducation);
            editor.apply();
            education = myeducation;
        }

    }

    @Override
    public void onBackPressed() {
        if (binding.frameLayout.getVisibility() != View.VISIBLE && System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "뒤로 가기 버튼을 한 번 더 누르시면 종료됩니다.", Toast.LENGTH_LONG);
            toast.show();
            return;
        } else {
            binding.frameLayout.setVisibility(View.GONE);
            binding.myprofiletoptext.setText("마이 프로필");
        }

        if (System.currentTimeMillis() <= backKeyPressedTime + 2500) {
            moveTaskToBack(true); // 태스크를 백그라운드로 이동
            finishAndRemoveTask(); // 액티비티 종료 + 태스크 리스트에서 지우기
            android.os.Process.killProcess(android.os.Process.myPid()); // 앱 프로세스 종료
            System.exit(0);
        }
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview_charactor);
        RecyclerView recyclerView2 = findViewById(R.id.recyclerview_hobby);
        RecyclerView recyclerview3 = findViewById(R.id.recyclerview_wantfriend);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView2.setLayoutManager(linearLayoutManager2);

        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerview3.setLayoutManager(linearLayoutManager3);

        charactorAdapter = new RecyclerAdapter();
        jobAdapter = new RecyclerAdapter2();
        wantfriendAdapter = new RecyclerAdapter3();
        recyclerView.setAdapter(charactorAdapter);
        recyclerView2.setAdapter(jobAdapter);
        recyclerview3.setAdapter(wantfriendAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);

        binding.myprofiletop.setVisibility(View.VISIBLE);
    }



    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        try {
            switch (intent.getExtras().getString("Job position")) {
                case "0":
                    binding.myprofilejobbtn.setText("학생");
                    break;
                case "1":
                    binding.myprofilejobbtn.setText("직장인");
                    break;
                case "2":
                    binding.myprofilejobbtn.setText("사업가");
                    break;
                case "3":
                    binding.myprofilejobbtn.setText("군인");
                    break;
                case "4":
                    binding.myprofilejobbtn.setText("취업준비중");
                    break;
                case "5":
                    binding.myprofilejobbtn.setText("기타");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myjob = binding.myprofilejobbtn.getText().toString();
            editor.putString("MyJob", myjob);
            editor.apply();
        }

        try {
            switch (intent.getExtras().getString("Religion position")) {
                case "0":
                    binding.myprofilereligionbtn.setText("무교");
                    break;
                case "1":
                    binding.myprofilereligionbtn.setText("기독교");
                    break;
                case "2":
                    binding.myprofilereligionbtn.setText("불교");
                    break;
                case "3":
                    binding.myprofilereligionbtn.setText("천주교");
                    break;
                case "4":
                    binding.myprofilereligionbtn.setText("기타");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myreligion = binding.myprofilereligionbtn.getText().toString();
            editor.putString("MyReligion", myreligion);
            editor.apply();
        }

        try {
            switch (intent.getExtras().getString("Drink position")) {
                case "0":
                    binding.myprofiledrinkbtn.setText("전혀 안 함");
                    break;
                case "1":
                    binding.myprofiledrinkbtn.setText("특별한 날 가끔");
                    break;
                case "2":
                    binding.myprofiledrinkbtn.setText("한달에 1~2번");
                    break;
                case "3":
                    binding.myprofiledrinkbtn.setText("일주일에 1~2번");
                    break;
                case "4":
                    binding.myprofiledrinkbtn.setText("일주일에 3~5번");
                    break;
                case "5":
                    binding.myprofiledrinkbtn.setText("거의 매일");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mydrink = binding.myprofiledrinkbtn.getText().toString();
            editor.putString("MyDrink", mydrink);
            editor.apply();
        }

        try {
            switch (intent.getExtras().getString("Smoke position")) {
                case "0":
                    binding.myprofilesmokebtn.setText("전혀 안 함");
                    break;
                case "1":
                    binding.myprofilesmokebtn.setText("특별한 날 가끔");
                    break;
                case "2":
                    binding.myprofilesmokebtn.setText("매일");
                    break;
                case "3":
                    binding.myprofilesmokebtn.setText("전자 담배만");
                    break;
                case "4":
                    binding.myprofilesmokebtn.setText("기타");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysmoke = binding.myprofilesmokebtn.getText().toString();
            editor.putString("MySmoke", mysmoke);
            editor.apply();
        }


        try {
            switch (intent.getExtras().getString("Pet position")) {
                case "0":
                    binding.myprofilepetbtn.setText("강아지");
                    break;
                case "1":
                    binding.myprofilepetbtn.setText("고양이");
                    break;
                case "2":
                    binding.myprofilepetbtn.setText("햄스터");
                    break;
                case "3":
                    binding.myprofilepetbtn.setText("물고기");
                    break;
                case "4":
                    binding.myprofilepetbtn.setText("파충류");
                    break;
                case "5":
                    binding.myprofilepetbtn.setText("양서류");
                    break;
                case "6":
                    binding.myprofilepetbtn.setText("없음");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mypet = binding.myprofilepetbtn.getText().toString();
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
                    binding.myprofileeducation.setText(eduactiontext);
                    myeducation = eduactiontext;
                    break;
                case 2:
                    eduactiontext += " 졸업";
                    binding.myprofileeducation.setText(eduactiontext);
                    myeducation = eduactiontext;
                    break;
                case 3:
                    eduactiontext += " 기타";
                    binding.myprofileeducation.setText(eduactiontext);
                    myeducation = eduactiontext;
                    break;
                case 4:
                    eduactiontext += " 중퇴";
                    binding.myprofileeducation.setText(eduactiontext);
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

    public static byte[] binaryStringToByteArray(String s) {
        int count = s.length() / 8;
        byte[] b = new byte[count];
        for (int i = 1; i < count; ++i) {
            String t = s.substring((i - 1) * 8, i * 8);
            b[i - 1] = binaryStringToByte(t);
        }
        return b;
    }

    // 스트링을 바이너리 바이트로
    public static byte binaryStringToByte(String s) {
        byte ret = 0, total = 0;
        for (int i = 0; i < 8; ++i) {
            ret = (s.charAt(7 - i) == '1') ? (byte) (1 << i) : 0;
            total = (byte) (ret | total);
        }
        return total;
    }

    public void addProfileData(String name, String birth, String gender, String job, String charactor, String hobby, String wantfriend, String ImageUrl, String education,
                               String religion, String drink, String smoke, String pet, String introduce, String career) {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        ProfileData profileData1 = new ProfileData(name, birth, gender, job, charactor, hobby, wantfriend, ImageUrl, education, religion, drink, smoke, pet, introduce, career);
        databaseReference.child(uid).child("ProfileData").setValue(profileData1);

    }
}