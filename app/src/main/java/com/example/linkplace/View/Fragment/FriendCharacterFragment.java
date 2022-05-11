package com.example.linkplace.View.Fragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

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

import static com.example.linkplace.R.drawable.characterclickbtn;
import static com.example.linkplace.R.drawable.characterselectbtn;
import static com.example.linkplace.R.drawable.genderclickbtn;
import static com.example.linkplace.R.drawable.genderselectbutton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FriendCharacterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FriendCharacterFragment extends Fragment {
    Button back_button, inputhobbybtn, moviebtn, musicbtn, coinsingerbtn, gamebtn, shoppingbtn, tripbtn, readingbookbtn, eattourbtn;
    Button cafetourbtn, healthbtn, watchsportsbtn, footballbtn, baseballbtn, basketballbtn, bowlingbtn, mountainbtn, golfbtn, craftsbtn;
    Button englishstudybtn, bakingbtn, dancebtn, campingbtn, techniquebtn, joggingbtn, talkingbtn, playmusicbtn, drawingbtn, beerbtn;
    int selectCount = 0;
    int btn1cnt, btn2cnt, btn3cnt, btn4cnt, btn5cnt, btn6cnt, btn7cnt, btn8cnt, btn9cnt, btn10cnt, btn11cnt, btn12cnt, btn13cnt, btn14cnt, btn15cnt, btn16cnt, btn17cnt, btn18cnt = 0;
    int btn19cnt, btn20cnt, btn21cnt, btn22cnt, btn23cnt, btn24cnt, btn25cnt, btn26cnt, btn27cnt, btn28cnt;;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters

    public FriendCharacterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProfileBirthSetFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static FriendCharacterFragment newInstance() {
        return new FriendCharacterFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend_character, container, false);
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




        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(JobSetFragment.newInstance());
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
                }
            }
        });



        inputhobbybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //((MainActivity)getActivity()).replaceFragment(ProfileBirthSetFragment.newInstance());
            }
        });


        return view;
    }
}