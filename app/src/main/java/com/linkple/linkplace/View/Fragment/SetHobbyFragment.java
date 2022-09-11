package com.linkple.linkplace.View.Fragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linkple.linkplace.View.Activity.MainActivity;
import com.linkple.linkplace.View.Model.ProfileData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.linkple.linkplace.databinding.FragmentSetHobbyBinding;

import static com.linkple.linkplace.R.drawable.characterclickbtn;
import static com.linkple.linkplace.R.drawable.characterselectbtn;


public class SetHobbyFragment extends Fragment {
    private FragmentSetHobbyBinding binding;

    int selectCount = 0;
    int btn1cnt, btn2cnt, btn3cnt, btn4cnt, btn5cnt, btn6cnt, btn7cnt, btn8cnt, btn9cnt, btn10cnt, btn11cnt, btn12cnt, btn13cnt, btn14cnt, btn15cnt, btn16cnt, btn17cnt, btn18cnt = 0;
    int btn19cnt, btn20cnt, btn21cnt, btn22cnt, btn23cnt, btn24cnt, btn25cnt, btn26cnt, btn27cnt, btn28cnt;

    boolean chr1, chr2, chr3, chr4, chr5, chr6, chr7, chr8, chr9, chr10, chr11, chr12, chr13, chr14, chr15, chr16, chr17, chr18, chr19, chr20,
            chr21, chr22, chr23, chr24, chr25, chr26, chr27, chr28;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    String name, age, gender, job, charactor;

    public SetHobbyFragment() {
        // Required empty public constructor
    }

    public static SetHobbyFragment newInstance() {
        return new SetHobbyFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSetHobbyBinding.inflate(getLayoutInflater());

        listenrSetting();

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
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
    }

    private void listenrSetting() {

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(CharacterSetFragment.newInstance());
            }
        });

        binding.inputhobbybtn.setEnabled(false);

        binding.moviebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn1cnt == 0) {
                    selectCount += 1;
                    btn1cnt += 1;
                    binding.moviebtn.setBackgroundResource(characterclickbtn);
                    binding.moviebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr1 = true;
                } else {
                    selectCount -= 1;
                    btn1cnt -= 1;
                    binding.moviebtn.setBackgroundResource(characterselectbtn);
                    binding.moviebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr1 = false;
                }
            }
        });

        binding.musicbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn2cnt == 0) {
                    selectCount += 1;
                    btn2cnt += 1;
                    binding.musicbtn.setBackgroundResource(characterclickbtn);
                    binding.musicbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr2 = true;
                } else {
                    selectCount -= 1;
                    btn2cnt -= 1;
                    binding.musicbtn.setBackgroundResource(characterselectbtn);
                    binding.musicbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr2 = false;
                }
            }
        });

        binding.coinsingerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn3cnt == 0) {
                    selectCount += 1;
                    btn3cnt += 1;
                    binding.coinsingerbtn.setBackgroundResource(characterclickbtn);
                    binding.coinsingerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr3 = true;
                } else {
                    selectCount -= 1;
                    btn3cnt -= 1;
                    binding.coinsingerbtn.setBackgroundResource(characterselectbtn);
                    binding.coinsingerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr3 = false;
                }
            }
        });

        binding.gamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn4cnt == 0) {
                    selectCount += 1;
                    btn4cnt += 1;
                    binding.gamebtn.setBackgroundResource(characterclickbtn);
                    binding.gamebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr4 = true;
                } else {
                    selectCount -= 1;
                    btn4cnt -= 1;
                    binding.gamebtn.setBackgroundResource(characterselectbtn);
                    binding.gamebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr4 = false;
                }
            }
        });

        binding.shoppingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn5cnt == 0) {
                    selectCount += 1;
                    btn5cnt += 1;
                    binding.shoppingbtn.setBackgroundResource(characterclickbtn);
                    binding.shoppingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr5 = true;
                } else {
                    selectCount -= 1;
                    btn5cnt -= 1;
                    binding.shoppingbtn.setBackgroundResource(characterselectbtn);
                    binding.shoppingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr5 = false;
                }
            }
        });

        binding.tripbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn6cnt == 0) {
                    selectCount += 1;
                    btn6cnt += 1;
                    binding.tripbtn.setBackgroundResource(characterclickbtn);
                    binding.tripbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr6 = true;
                } else {
                    selectCount -= 1;
                    btn6cnt -= 1;
                    binding.tripbtn.setBackgroundResource(characterselectbtn);
                    binding.tripbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr6 = false;
                }
            }
        });

        binding.readingbookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn7cnt == 0) {
                    selectCount += 1;
                    btn7cnt += 1;
                    binding.readingbookbtn.setBackgroundResource(characterclickbtn);
                    binding.readingbookbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr7 = true;
                } else {
                    selectCount -= 1;
                    btn7cnt -= 1;
                    binding.readingbookbtn.setBackgroundResource(characterselectbtn);
                    binding.readingbookbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr7 = false;
                }
            }
        });

        binding.eattourbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn8cnt == 0) {
                    selectCount += 1;
                    btn8cnt += 1;
                    binding.eattourbtn.setBackgroundResource(characterclickbtn);
                    binding.eattourbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr8 = true;
                } else {
                    selectCount -= 1;
                    btn8cnt -= 1;
                    binding.eattourbtn.setBackgroundResource(characterselectbtn);
                    binding.eattourbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr8 = false;
                }
            }
        });

        binding.cafetourbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn9cnt == 0) {
                    selectCount += 1;
                    btn9cnt += 1;
                    binding.cafetourbtn.setBackgroundResource(characterclickbtn);
                    binding.cafetourbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr9 = true;
                } else {
                    selectCount -= 1;
                    btn9cnt -= 1;
                    binding.cafetourbtn.setBackgroundResource(characterselectbtn);
                    binding.cafetourbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr9 = false;
                }
            }
        });

        binding.healthbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn10cnt == 0) {
                    selectCount += 1;
                    btn10cnt += 1;
                    binding.healthbtn.setBackgroundResource(characterclickbtn);
                    binding.healthbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr10 = true;
                } else {
                    selectCount -= 1;
                    btn10cnt -= 1;
                    binding.healthbtn.setBackgroundResource(characterselectbtn);
                    binding.healthbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr10 = false;
                }
            }
        });

        binding.watchsportsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn11cnt == 0) {
                    selectCount += 1;
                    btn11cnt += 1;
                    binding.watchsportsbtn.setBackgroundResource(characterclickbtn);
                    binding.watchsportsbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr11 = true;
                } else {
                    selectCount -= 1;
                    btn11cnt -= 1;
                    binding.watchsportsbtn.setBackgroundResource(characterselectbtn);
                    binding.watchsportsbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr11 = false;
                }
            }
        });

        binding.footballbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn12cnt == 0) {
                    selectCount += 1;
                    btn12cnt += 1;
                    binding.footballbtn.setBackgroundResource(characterclickbtn);
                    binding.footballbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr12 = true;
                } else {
                    selectCount -= 1;
                    btn12cnt -= 1;
                    binding.footballbtn.setBackgroundResource(characterselectbtn);
                    binding.footballbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr12 = false;
                }
            }
        });

        binding.baseballbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn13cnt == 0) {
                    selectCount += 1;
                    btn13cnt += 1;
                    binding.baseballbtn.setBackgroundResource(characterclickbtn);
                    binding.baseballbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr13 = true;
                } else {
                    selectCount -= 1;
                    btn13cnt -= 1;
                    binding.baseballbtn.setBackgroundResource(characterselectbtn);
                    binding.baseballbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr13 = false;
                }
            }
        });

        binding.basketballbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn14cnt == 0) {
                    selectCount += 1;
                    btn14cnt += 1;
                    binding.basketballbtn.setBackgroundResource(characterclickbtn);
                    binding.basketballbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr14 = true;
                } else {
                    selectCount -= 1;
                    btn14cnt -= 1;
                    binding.basketballbtn.setBackgroundResource(characterselectbtn);
                    binding.basketballbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr14 = false;
                }
            }
        });

        binding.bowlingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn15cnt == 0) {
                    selectCount += 1;
                    btn15cnt += 1;
                    binding.bowlingbtn.setBackgroundResource(characterclickbtn);
                    binding.bowlingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr15 = true;
                } else {
                    selectCount -= 1;
                    btn15cnt -= 1;
                    binding.bowlingbtn.setBackgroundResource(characterselectbtn);
                    binding.bowlingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr15 = false;
                }
            }
        });

        binding.mountainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn16cnt == 0) {
                    selectCount += 1;
                    btn16cnt += 1;
                    binding.mountainbtn.setBackgroundResource(characterclickbtn);
                    binding.mountainbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr16 = true;
                } else {
                    selectCount -= 1;
                    btn16cnt -= 1;
                    binding.mountainbtn.setBackgroundResource(characterselectbtn);
                    binding.mountainbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr16 = false;
                }
            }
        });

        binding.golfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn17cnt == 0) {
                    selectCount += 1;
                    btn17cnt += 1;
                    binding.golfbtn.setBackgroundResource(characterclickbtn);
                    binding.golfbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr17 = true;
                } else {
                    selectCount -= 1;
                    btn17cnt -= 1;
                    binding.golfbtn.setBackgroundResource(characterselectbtn);
                    binding.golfbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr17 = false;
                }
            }
        });

        binding.craftsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn18cnt == 0) {
                    selectCount += 1;
                    btn18cnt += 1;
                    binding.craftsbtn.setBackgroundResource(characterclickbtn);
                    binding.craftsbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr18 = true;
                } else {
                    selectCount -= 1;
                    btn18cnt -= 1;
                    binding.craftsbtn.setBackgroundResource(characterselectbtn);
                    binding.craftsbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr18 = false;
                }
            }
        });

        binding.englishstudybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn19cnt == 0) {
                    selectCount += 1;
                    btn19cnt += 1;
                    binding.englishstudybtn.setBackgroundResource(characterclickbtn);
                    binding.englishstudybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr19 = true;
                } else {
                    selectCount -= 1;
                    btn19cnt -= 1;
                    binding.englishstudybtn.setBackgroundResource(characterselectbtn);
                    binding.englishstudybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr19 = false;
                }
            }
        });

        binding.bakingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn20cnt == 0) {
                    selectCount += 1;
                    btn20cnt += 1;
                    binding.bakingbtn.setBackgroundResource(characterclickbtn);
                    binding.bakingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr20 = true;
                } else {
                    selectCount -= 1;
                    btn20cnt -= 1;
                    binding.bakingbtn.setBackgroundResource(characterselectbtn);
                    binding.bakingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr20 = false;
                }
            }
        });

        binding.dancebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn26cnt == 0) {
                    selectCount += 1;
                    btn26cnt += 1;
                    binding.dancebtn.setBackgroundResource(characterclickbtn);
                    binding.dancebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr21 = true;
                } else {
                    selectCount -= 1;
                    btn26cnt -= 1;
                    binding.dancebtn.setBackgroundResource(characterselectbtn);
                    binding.dancebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr21 = true;
                }
            }
        });

        binding.campingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn21cnt == 0) {
                    selectCount += 1;
                    btn21cnt += 1;
                    binding.campingbtn.setBackgroundResource(characterclickbtn);
                    binding.campingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr22 = true;
                } else {
                    selectCount -= 1;
                    btn21cnt -= 1;
                    binding.campingbtn.setBackgroundResource(characterselectbtn);
                    binding.campingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr22 = true;
                }
            }
        });

        binding.techniquebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn22cnt == 0) {
                    selectCount += 1;
                    btn22cnt += 1;
                    binding.techniquebtn.setBackgroundResource(characterclickbtn);
                    binding.techniquebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr23 = true;
                } else {
                    selectCount -= 1;
                    btn22cnt -= 1;
                    binding.techniquebtn.setBackgroundResource(characterselectbtn);
                    binding.techniquebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr23 = true;
                }
            }
        });

        binding.joggingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn23cnt == 0) {
                    selectCount += 1;
                    btn23cnt += 1;
                    binding.joggingbtn.setBackgroundResource(characterclickbtn);
                    binding.joggingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr24 = true;
                } else {
                    selectCount -= 1;
                    btn23cnt -= 1;
                    binding.joggingbtn.setBackgroundResource(characterselectbtn);
                    binding.joggingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr24 = true;
                }
            }
        });

        binding.talkingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn24cnt == 0) {
                    selectCount += 1;
                    btn24cnt += 1;
                    binding.talkingbtn.setBackgroundResource(characterclickbtn);
                    binding.talkingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr25 = true;
                } else {
                    selectCount -= 1;
                    btn24cnt -= 1;
                    binding.talkingbtn.setBackgroundResource(characterselectbtn);
                    binding.talkingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr25 = true;
                }
            }
        });

        binding.playmusicbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn25cnt == 0) {
                    selectCount += 1;
                    btn25cnt += 1;
                    binding.playmusicbtn.setBackgroundResource(characterclickbtn);
                    binding.playmusicbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr26 = true;
                } else {
                    selectCount -= 1;
                    btn25cnt -= 1;
                    binding.playmusicbtn.setBackgroundResource(characterselectbtn);
                    binding.playmusicbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr26 = true;
                }
            }
        });

        binding.drawingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn27cnt == 0) {
                    selectCount += 1;
                    btn27cnt += 1;
                    binding.drawingbtn.setBackgroundResource(characterclickbtn);
                    binding.drawingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr27 = true;
                } else {
                    selectCount -= 1;
                    btn27cnt -= 1;
                    binding.drawingbtn.setBackgroundResource(characterselectbtn);
                    binding.drawingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr27 = true;
                }
            }
        });

        binding.beerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn28cnt == 0) {
                    selectCount += 1;
                    btn28cnt += 1;
                    binding.beerbtn.setBackgroundResource(characterclickbtn);
                    binding.beerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    hobbybtnEnable();
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr28 = true;
                } else {
                    selectCount -= 1;
                    btn28cnt -= 1;
                    binding.beerbtn.setBackgroundResource(characterselectbtn);
                    binding.beerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    hobbybtnEnable();
                    chr28 = true;
                }
            }
        });



        binding.inputhobbybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(FriendCharacterFragment.newInstance());
                addProfileData(name, age, gender, job, charactor, chrResult(), "", "", "", "", "", "", "" ,"", "");
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

    public String chrResult() {
        String result = "";

        if (chr1) {
            result += "영화/드라마";
        }

        if (chr2) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "음악감상";
        }

        if (chr3) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "코인노래방";
        }

        if (chr4) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "게임";
        }

        if (chr5) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "여행";
        }

        if (chr6) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "쇼핑";
        }

        if (chr7) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "독서";
        }

        if (chr8) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "맛집 투어";
        }

        if (chr9) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "카페 투어";
        }

        if (chr10) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "운동/헬스";
        }

        if (chr11) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "스포츠 관전";
        }

        if (chr12) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "축구";
        }

        if (chr13) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "야구";
        }

        if (chr14) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "농구";
        }

        if (chr15) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "볼링/당구";
        }

        if (chr16) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "등산";
        }

        if (chr17) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "골프";
        }

        if (chr18) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "공예";
        }

        if (chr19) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "그림 그리기";
        }

        if (chr20) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "술 마시기";
        }

        if (chr21) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "어학공부";
        }

        if (chr22) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "베이킹";
        }

        if (chr23) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "댄스";
        }

        if (chr24) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "캠핑";
        }

        if (chr25) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "재테크";
        }

        if (chr26) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "산책하기";
        }

        if (chr27) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "수다";
        }

        if (chr28) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "악기 연주";
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