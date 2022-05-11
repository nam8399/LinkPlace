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
 * Use the {@link ProfileBirthSetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterSetFragment extends Fragment {
    Button back_button, inputcharacterbtn, extervalbtn, intervalbtn, activitybtn, quietbtn, cutebtn, adultbtn, passionbtn, relaxedbtn;
    Button fourthdimentionbtn, politebtn, humorousbtn, seriousbtn, challengebtn, carefulbtn;
    int selectCount = 0;
    int btn1cnt, btn2cnt, btn3cnt, btn4cnt, btn5cnt, btn6cnt, btn7cnt, btn8cnt, btn9cnt, btn10cnt, btn11cnt, btn12cnt, btn13cnt, btn14cnt = 0;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters

    public CharacterSetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProfileBirthSetFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static CharacterSetFragment newInstance() {
        return new CharacterSetFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_set, container, false);
        back_button = view.findViewById(R.id.back_button);
        inputcharacterbtn = view.findViewById(R.id.inputcharacterbtn);
        extervalbtn = view.findViewById(R.id.extervalbtn);
        intervalbtn = view.findViewById(R.id.intervalbtn);
        activitybtn = view.findViewById(R.id.activitybtn);
        quietbtn = view.findViewById(R.id.quietbtn);
        cutebtn = view.findViewById(R.id.cutebtn);
        adultbtn = view.findViewById(R.id.adultbtn);
        passionbtn = view.findViewById(R.id.passionbtn);
        relaxedbtn = view.findViewById(R.id.relaxedbtn);
        fourthdimentionbtn = view.findViewById(R.id.fourthdimentionbtn);
        politebtn = view.findViewById(R.id.politebtn);
        seriousbtn = view.findViewById(R.id.seriousbtn);
        humorousbtn = view.findViewById(R.id.humorousbtn);
        challengebtn = view.findViewById(R.id.challengebtn);
        carefulbtn = view.findViewById(R.id.carefulbtn);


        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(JobSetFragment.newInstance());
            }
        });

        inputcharacterbtn.setEnabled(false);

        extervalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn1cnt == 0) {
                    selectCount += 1;
                    btn1cnt += 1;
                    extervalbtn.setBackgroundResource(characterclickbtn);
                    extervalbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                } else {
                    selectCount -= 1;
                    btn1cnt -= 1;
                    extervalbtn.setBackgroundResource(characterselectbtn);
                    extervalbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                }
            }
        });

        intervalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn2cnt == 0) {
                    selectCount += 1;
                    btn2cnt += 1;
                    intervalbtn.setBackgroundResource(characterclickbtn);
                    intervalbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                } else {
                    selectCount -= 1;
                    btn2cnt -= 1;
                    intervalbtn.setBackgroundResource(characterselectbtn);
                    intervalbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                }
            }
        });

        activitybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn3cnt == 0) {
                    selectCount += 1;
                    btn3cnt += 1;
                    activitybtn.setBackgroundResource(characterclickbtn);
                    activitybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                } else {
                    selectCount -= 1;
                    btn3cnt -= 1;
                    activitybtn.setBackgroundResource(characterselectbtn);
                    activitybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                }
            }
        });

        quietbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn4cnt == 0) {
                    selectCount += 1;
                    btn4cnt += 1;
                    quietbtn.setBackgroundResource(characterclickbtn);
                    quietbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                } else {
                    selectCount -= 1;
                    btn4cnt -= 1;
                    quietbtn.setBackgroundResource(characterselectbtn);
                    quietbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                }
            }
        });

        cutebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn5cnt == 0) {
                    selectCount += 1;
                    btn5cnt += 1;
                    cutebtn.setBackgroundResource(characterclickbtn);
                    cutebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                } else {
                    selectCount -= 1;
                    btn5cnt -= 1;
                    cutebtn.setBackgroundResource(characterselectbtn);
                    cutebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                }
            }
        });

        adultbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn6cnt == 0) {
                    selectCount += 1;
                    btn6cnt += 1;
                    adultbtn.setBackgroundResource(characterclickbtn);
                    adultbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                } else {
                    selectCount -= 1;
                    btn6cnt -= 1;
                    adultbtn.setBackgroundResource(characterselectbtn);
                    adultbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                }
            }
        });

        passionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn7cnt == 0) {
                    selectCount += 1;
                    btn7cnt += 1;
                    passionbtn.setBackgroundResource(characterclickbtn);
                    passionbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                } else {
                    selectCount -= 1;
                    btn7cnt -= 1;
                    passionbtn.setBackgroundResource(characterselectbtn);
                    passionbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                }
            }
        });

        relaxedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn8cnt == 0) {
                    selectCount += 1;
                    btn8cnt += 1;
                    relaxedbtn.setBackgroundResource(characterclickbtn);
                    relaxedbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                } else {
                    selectCount -= 1;
                    btn8cnt -= 1;
                    relaxedbtn.setBackgroundResource(characterselectbtn);
                    relaxedbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                }
            }
        });

        fourthdimentionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn9cnt == 0) {
                    selectCount += 1;
                    btn9cnt += 1;
                    fourthdimentionbtn.setBackgroundResource(characterclickbtn);
                    fourthdimentionbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                } else {
                    selectCount -= 1;
                    btn9cnt -= 1;
                    fourthdimentionbtn.setBackgroundResource(characterselectbtn);
                    fourthdimentionbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                }
            }
        });

        politebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn10cnt == 0) {
                    selectCount += 1;
                    btn10cnt += 1;
                    politebtn.setBackgroundResource(characterclickbtn);
                    politebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                } else {
                    selectCount -= 1;
                    btn10cnt -= 1;
                    politebtn.setBackgroundResource(characterselectbtn);
                    politebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                }
            }
        });

        humorousbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn11cnt == 0) {
                    selectCount += 1;
                    btn11cnt += 1;
                    humorousbtn.setBackgroundResource(characterclickbtn);
                    humorousbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                } else {
                    selectCount -= 1;
                    btn11cnt -= 1;
                    humorousbtn.setBackgroundResource(characterselectbtn);
                    humorousbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                }
            }
        });

        seriousbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn12cnt == 0) {
                    selectCount += 1;
                    btn12cnt += 1;
                    seriousbtn.setBackgroundResource(characterclickbtn);
                    seriousbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                } else {
                    selectCount -= 1;
                    btn12cnt -= 1;
                    seriousbtn.setBackgroundResource(characterselectbtn);
                    seriousbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                }
            }
        });

        challengebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn13cnt == 0) {
                    selectCount += 1;
                    btn13cnt += 1;
                    challengebtn.setBackgroundResource(characterclickbtn);
                    challengebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                } else {
                    selectCount -= 1;
                    btn13cnt -= 1;
                    challengebtn.setBackgroundResource(characterselectbtn);
                    challengebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                }
            }
        });

        carefulbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn14cnt == 0) {
                    selectCount += 1;
                    btn14cnt += 1;
                    carefulbtn.setBackgroundResource(characterclickbtn);
                    carefulbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                } else {
                    selectCount -= 1;
                    btn14cnt -= 1;
                    carefulbtn.setBackgroundResource(characterselectbtn);
                    carefulbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        inputcharacterbtn.setEnabled(true);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        inputcharacterbtn.setEnabled(false);
                        inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                }
            }
        });


        inputcharacterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(SetHobbyFragment.newInstance());
            }
        });


        return view;
    }
}