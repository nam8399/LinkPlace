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
import android.view.MotionEvent;
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

import static com.example.linkplace.R.drawable.characterclickbtn;
import static com.example.linkplace.R.drawable.characterselectbtn;
import static com.example.linkplace.R.drawable.genderclickbtn;
import static com.example.linkplace.R.drawable.genderselectbutton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileBirthSetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetHobbyFragment extends Fragment {
    Button back_button, inputhobbybtn, moviebtn, musicbtn, coinsingerbtn, gamebtn, shoppingbtn, tripbtn, readingbookbtn, eattourbtn;
    Button cafetourbtn, healthbtn, watchsportsbtn, footballbtn, baseballbtn, basketballbtn, bowlingbtn, mountainbtn, golfbtn, craftsbtn;
    Button englishstudybtn, bakingbtn, dancebtn, campingbtn, techniquebtn, joggingbtn, talkingbtn, playmusicbtn, drawingbtn, beerbtn;
    int selectCount = 0;
    int btn1cnt, btn2cnt, btn3cnt, btn4cnt, btn5cnt, btn6cnt, btn7cnt, btn8cnt, btn9cnt, btn10cnt, btn11cnt, btn12cnt, btn13cnt, btn14cnt, btn15cnt, btn16cnt, btn17cnt, btn18cnt = 0;
    int btn19cnt, btn20cnt, btn21cnt, btn22cnt, btn23cnt, btn24cnt, btn25cnt, btn26cnt, btn27cnt, btn28cnt;

    boolean chr1, chr2, chr3, chr4, chr5, chr6, chr7, chr8, chr9, chr10, chr11, chr12, chr13, chr14, chr15, chr16, chr17, chr18, chr19, chr20,
            chr21, chr22, chr23, chr24, chr25, chr26, chr27, chr28;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    String name, age, gender, job, charactor;

    // TODO: Rename and change types of parameters

    public SetHobbyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProfileBirthSetFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static SetHobbyFragment newInstance() {
        return new SetHobbyFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_set_hobby, container, false);
        back_button = view.findViewById(R.id.back_button);
        inputhobbybtn = view.findViewById(R.id.inputhobbybtn);
        moviebtn = view.findViewById(R.id.moviebtn);
        musicbtn = view.findViewById(R.id.musicbtn);
        coinsingerbtn = view.findViewById(R.id.coinsingerbtn);
        gamebtn = view.findViewById(R.id.gamebtn);
        shoppingbtn = view.findViewById(R.id.shoppingbtn);
        tripbtn = view.findViewById(R.id.tripbtn);
        readingbookbtn = view.findViewById(R.id.readingbookbtn);
        eattourbtn = view.findViewById(R.id.eattourbtn);
        cafetourbtn = view.findViewById(R.id.cafetourbtn);
        healthbtn = view.findViewById(R.id.healthbtn);
        watchsportsbtn = view.findViewById(R.id.watchsportsbtn);
        footballbtn = view.findViewById(R.id.footballbtn);
        baseballbtn = view.findViewById(R.id.baseballbtn);
        basketballbtn = view.findViewById(R.id.basketballbtn);
        bowlingbtn = view.findViewById(R.id.bowlingbtn);
        mountainbtn = view.findViewById(R.id.mountainbtn);
        golfbtn = view.findViewById(R.id.golfbtn);
        craftsbtn = view.findViewById(R.id.craftsbtn);
        englishstudybtn = view.findViewById(R.id.englishstudybtn);
        bakingbtn = view.findViewById(R.id.bakingbtn);
        dancebtn = view.findViewById(R.id.dancebtn);
        campingbtn = view.findViewById(R.id.campingbtn);
        techniquebtn = view.findViewById(R.id.techniquebtn);
        joggingbtn = view.findViewById(R.id.joggingbtn);
        talkingbtn = view.findViewById(R.id.talkingbtn);
        playmusicbtn = view.findViewById(R.id.playmusicbtn);
        drawingbtn = view.findViewById(R.id.drawingbtn);
        beerbtn = view.findViewById(R.id.beerbtn);


        init();





        return view;
    }

    private void init() {

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(CharacterSetFragment.newInstance());
            }
        });

        inputhobbybtn.setEnabled(false);

        moviebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn1cnt == 0) {
                    selectCount += 1;
                    btn1cnt += 1;
                    moviebtn.setBackgroundResource(characterclickbtn);
                    moviebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr1 = true;
                } else {
                    selectCount -= 1;
                    btn1cnt -= 1;
                    moviebtn.setBackgroundResource(characterselectbtn);
                    moviebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr1 = false;
                }
            }
        });

        musicbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn2cnt == 0) {
                    selectCount += 1;
                    btn2cnt += 1;
                    musicbtn.setBackgroundResource(characterclickbtn);
                    musicbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr2 = true;
                } else {
                    selectCount -= 1;
                    btn2cnt -= 1;
                    musicbtn.setBackgroundResource(characterselectbtn);
                    musicbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr2 = false;
                }
            }
        });

        coinsingerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn3cnt == 0) {
                    selectCount += 1;
                    btn3cnt += 1;
                    coinsingerbtn.setBackgroundResource(characterclickbtn);
                    coinsingerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr3 = true;
                } else {
                    selectCount -= 1;
                    btn3cnt -= 1;
                    coinsingerbtn.setBackgroundResource(characterselectbtn);
                    coinsingerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr3 = false;
                }
            }
        });

        gamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn4cnt == 0) {
                    selectCount += 1;
                    btn4cnt += 1;
                    gamebtn.setBackgroundResource(characterclickbtn);
                    gamebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr4 = true;
                } else {
                    selectCount -= 1;
                    btn4cnt -= 1;
                    gamebtn.setBackgroundResource(characterselectbtn);
                    gamebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr4 = false;
                }
            }
        });

        shoppingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn5cnt == 0) {
                    selectCount += 1;
                    btn5cnt += 1;
                    shoppingbtn.setBackgroundResource(characterclickbtn);
                    shoppingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr5 = true;
                } else {
                    selectCount -= 1;
                    btn5cnt -= 1;
                    shoppingbtn.setBackgroundResource(characterselectbtn);
                    shoppingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr5 = false;
                }
            }
        });

        tripbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn6cnt == 0) {
                    selectCount += 1;
                    btn6cnt += 1;
                    tripbtn.setBackgroundResource(characterclickbtn);
                    tripbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr6 = true;
                } else {
                    selectCount -= 1;
                    btn6cnt -= 1;
                    tripbtn.setBackgroundResource(characterselectbtn);
                    tripbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr6 = false;
                }
            }
        });

        readingbookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn7cnt == 0) {
                    selectCount += 1;
                    btn7cnt += 1;
                    readingbookbtn.setBackgroundResource(characterclickbtn);
                    readingbookbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr7 = true;
                } else {
                    selectCount -= 1;
                    btn7cnt -= 1;
                    readingbookbtn.setBackgroundResource(characterselectbtn);
                    readingbookbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr7 = false;
                }
            }
        });

        eattourbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn8cnt == 0) {
                    selectCount += 1;
                    btn8cnt += 1;
                    eattourbtn.setBackgroundResource(characterclickbtn);
                    eattourbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr8 = true;
                } else {
                    selectCount -= 1;
                    btn8cnt -= 1;
                    eattourbtn.setBackgroundResource(characterselectbtn);
                    eattourbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr8 = false;
                }
            }
        });

        cafetourbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn9cnt == 0) {
                    selectCount += 1;
                    btn9cnt += 1;
                    cafetourbtn.setBackgroundResource(characterclickbtn);
                    cafetourbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr9 = true;
                } else {
                    selectCount -= 1;
                    btn9cnt -= 1;
                    cafetourbtn.setBackgroundResource(characterselectbtn);
                    cafetourbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr9 = false;
                }
            }
        });

        healthbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn10cnt == 0) {
                    selectCount += 1;
                    btn10cnt += 1;
                    healthbtn.setBackgroundResource(characterclickbtn);
                    healthbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr10 = true;
                } else {
                    selectCount -= 1;
                    btn10cnt -= 1;
                    healthbtn.setBackgroundResource(characterselectbtn);
                    healthbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr10 = false;
                }
            }
        });

        watchsportsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn11cnt == 0) {
                    selectCount += 1;
                    btn11cnt += 1;
                    watchsportsbtn.setBackgroundResource(characterclickbtn);
                    watchsportsbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr11 = true;
                } else {
                    selectCount -= 1;
                    btn11cnt -= 1;
                    watchsportsbtn.setBackgroundResource(characterselectbtn);
                    watchsportsbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr11 = false;
                }
            }
        });

        footballbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn12cnt == 0) {
                    selectCount += 1;
                    btn12cnt += 1;
                    footballbtn.setBackgroundResource(characterclickbtn);
                    footballbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr12 = true;
                } else {
                    selectCount -= 1;
                    btn12cnt -= 1;
                    footballbtn.setBackgroundResource(characterselectbtn);
                    footballbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr12 = false;
                }
            }
        });

        baseballbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn13cnt == 0) {
                    selectCount += 1;
                    btn13cnt += 1;
                    baseballbtn.setBackgroundResource(characterclickbtn);
                    baseballbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr13 = true;
                } else {
                    selectCount -= 1;
                    btn13cnt -= 1;
                    baseballbtn.setBackgroundResource(characterselectbtn);
                    baseballbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr13 = false;
                }
            }
        });

        basketballbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn14cnt == 0) {
                    selectCount += 1;
                    btn14cnt += 1;
                    basketballbtn.setBackgroundResource(characterclickbtn);
                    basketballbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr14 = true;
                } else {
                    selectCount -= 1;
                    btn14cnt -= 1;
                    basketballbtn.setBackgroundResource(characterselectbtn);
                    basketballbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr14 = false;
                }
            }
        });

        bowlingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn15cnt == 0) {
                    selectCount += 1;
                    btn15cnt += 1;
                    bowlingbtn.setBackgroundResource(characterclickbtn);
                    bowlingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr15 = true;
                } else {
                    selectCount -= 1;
                    btn15cnt -= 1;
                    bowlingbtn.setBackgroundResource(characterselectbtn);
                    bowlingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr15 = false;
                }
            }
        });

        mountainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn16cnt == 0) {
                    selectCount += 1;
                    btn16cnt += 1;
                    mountainbtn.setBackgroundResource(characterclickbtn);
                    mountainbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr16 = true;
                } else {
                    selectCount -= 1;
                    btn16cnt -= 1;
                    mountainbtn.setBackgroundResource(characterselectbtn);
                    mountainbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr16 = false;
                }
            }
        });

        golfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn17cnt == 0) {
                    selectCount += 1;
                    btn17cnt += 1;
                    golfbtn.setBackgroundResource(characterclickbtn);
                    golfbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr17 = true;
                } else {
                    selectCount -= 1;
                    btn17cnt -= 1;
                    golfbtn.setBackgroundResource(characterselectbtn);
                    golfbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr17 = false;
                }
            }
        });

        craftsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn18cnt == 0) {
                    selectCount += 1;
                    btn18cnt += 1;
                    craftsbtn.setBackgroundResource(characterclickbtn);
                    craftsbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr18 = true;
                } else {
                    selectCount -= 1;
                    btn18cnt -= 1;
                    craftsbtn.setBackgroundResource(characterselectbtn);
                    craftsbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr18 = false;
                }
            }
        });

        englishstudybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn19cnt == 0) {
                    selectCount += 1;
                    btn19cnt += 1;
                    englishstudybtn.setBackgroundResource(characterclickbtn);
                    englishstudybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr19 = true;
                } else {
                    selectCount -= 1;
                    btn19cnt -= 1;
                    englishstudybtn.setBackgroundResource(characterselectbtn);
                    englishstudybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr19 = false;
                }
            }
        });

        bakingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn20cnt == 0) {
                    selectCount += 1;
                    btn20cnt += 1;
                    bakingbtn.setBackgroundResource(characterclickbtn);
                    bakingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr20 = true;
                } else {
                    selectCount -= 1;
                    btn20cnt -= 1;
                    bakingbtn.setBackgroundResource(characterselectbtn);
                    bakingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr20 = false;
                }
            }
        });

        dancebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn26cnt == 0) {
                    selectCount += 1;
                    btn26cnt += 1;
                    dancebtn.setBackgroundResource(characterclickbtn);
                    dancebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr21 = true;
                } else {
                    selectCount -= 1;
                    btn26cnt -= 1;
                    dancebtn.setBackgroundResource(characterselectbtn);
                    dancebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr21 = true;
                }
            }
        });

        campingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn21cnt == 0) {
                    selectCount += 1;
                    btn21cnt += 1;
                    campingbtn.setBackgroundResource(characterclickbtn);
                    campingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr22 = true;
                } else {
                    selectCount -= 1;
                    btn21cnt -= 1;
                    campingbtn.setBackgroundResource(characterselectbtn);
                    campingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr22 = true;
                }
            }
        });

        techniquebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn22cnt == 0) {
                    selectCount += 1;
                    btn22cnt += 1;
                    techniquebtn.setBackgroundResource(characterclickbtn);
                    techniquebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr23 = true;
                } else {
                    selectCount -= 1;
                    btn22cnt -= 1;
                    techniquebtn.setBackgroundResource(characterselectbtn);
                    techniquebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr23 = true;
                }
            }
        });

        joggingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn23cnt == 0) {
                    selectCount += 1;
                    btn23cnt += 1;
                    joggingbtn.setBackgroundResource(characterclickbtn);
                    joggingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr24 = true;
                } else {
                    selectCount -= 1;
                    btn23cnt -= 1;
                    joggingbtn.setBackgroundResource(characterselectbtn);
                    joggingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr24 = true;
                }
            }
        });

        talkingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn24cnt == 0) {
                    selectCount += 1;
                    btn24cnt += 1;
                    talkingbtn.setBackgroundResource(characterclickbtn);
                    talkingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr25 = true;
                } else {
                    selectCount -= 1;
                    btn24cnt -= 1;
                    talkingbtn.setBackgroundResource(characterselectbtn);
                    talkingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr25 = true;
                }
            }
        });

        playmusicbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn25cnt == 0) {
                    selectCount += 1;
                    btn25cnt += 1;
                    playmusicbtn.setBackgroundResource(characterclickbtn);
                    playmusicbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr26 = true;
                } else {
                    selectCount -= 1;
                    btn25cnt -= 1;
                    playmusicbtn.setBackgroundResource(characterselectbtn);
                    playmusicbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr26 = true;
                }
            }
        });

        drawingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn27cnt == 0) {
                    selectCount += 1;
                    btn27cnt += 1;
                    drawingbtn.setBackgroundResource(characterclickbtn);
                    drawingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr27 = true;
                } else {
                    selectCount -= 1;
                    btn27cnt -= 1;
                    drawingbtn.setBackgroundResource(characterselectbtn);
                    drawingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr27 = true;
                }
            }
        });

        beerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn28cnt == 0) {
                    selectCount += 1;
                    btn28cnt += 1;
                    beerbtn.setBackgroundResource(characterclickbtn);
                    beerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    chr28 = true;
                } else {
                    selectCount -= 1;
                    btn28cnt -= 1;
                    beerbtn.setBackgroundResource(characterselectbtn);
                    beerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputhobbybtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputhobbybtn.setEnabled(true);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputhobbybtn.setEnabled(false);
                        inputhobbybtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr28 = true;
                }
            }
        });



        inputhobbybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(FriendCharacterFragment.newInstance());
                addProfileData(name, age, gender, job, charactor, chrResult(), "", "", "", "", "", "", "");
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
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
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