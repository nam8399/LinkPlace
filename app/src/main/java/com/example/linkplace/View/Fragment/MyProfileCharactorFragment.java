package com.example.linkplace.View.Fragment;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.linkplace.R;
import com.example.linkplace.View.Activity.MainActivity;
import com.example.linkplace.View.Activity.MyProfileActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.linkplace.R.drawable.characterclickbtn;
import static com.example.linkplace.R.drawable.characterselectbtn;
import static com.example.linkplace.R.drawable.genderclickbtn;
import static com.example.linkplace.R.drawable.genderselectbutton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyProfileSmokeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyProfileCharactorFragment extends Fragment {
    Button back_button, inputcharacterbtn, extervalbtn, intervalbtn, activitybtn, quietbtn, cutebtn, adultbtn, passionbtn, relaxedbtn;
    Button fourthdimentionbtn, politebtn, humorousbtn, seriousbtn, challengebtn, carefulbtn;
    int selectCount = 0;
    int btn1cnt, btn2cnt, btn3cnt, btn4cnt, btn5cnt, btn6cnt, btn7cnt, btn8cnt, btn9cnt, btn10cnt, btn11cnt, btn12cnt, btn13cnt, btn14cnt = 0;
    boolean click1, click2, click3, click4, click5, click6, click7, click8, click9, click10;
    ArrayList<String> listTitle = new ArrayList<String>();

    public MyProfileCharactorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MyProfileReligionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyProfileCharactorFragment newInstance() {
        return new MyProfileCharactorFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile_charactor, container, false);

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

        inputcharacterbtn.setEnabled(false);

        extervalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn1cnt == 0) {
                    click1 = true;
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
                } else {
                    click1 = false;
                    selectCount -= 1;
                    btn1cnt -= 1;
                    extervalbtn.setBackgroundResource(characterselectbtn);
                    extervalbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
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
                    click2 = true;
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
                } else {
                     click2 = false;
                    selectCount -= 1;
                    btn2cnt -= 1;
                    intervalbtn.setBackgroundResource(characterselectbtn);
                    intervalbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
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
                    click3 = true;
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
                } else {
                    click3 = false;
                    selectCount -= 1;
                    btn3cnt -= 1;
                    activitybtn.setBackgroundResource(characterselectbtn);
                    activitybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
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
                    click4 = true;
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
                } else {
                    click4 = false;
                    selectCount -= 1;
                    btn4cnt -= 1;
                    quietbtn.setBackgroundResource(characterselectbtn);
                    quietbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
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
                    click5 = true;
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
                } else {
                    click5 = false;
                    selectCount -= 1;
                    btn5cnt -= 1;
                    cutebtn.setBackgroundResource(characterselectbtn);
                    cutebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
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
                    click6 = true;
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
                } else {
                    click6 = false;
                    selectCount -= 1;
                    btn6cnt -= 1;
                    adultbtn.setBackgroundResource(characterselectbtn);
                    adultbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
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
                    click7 = true;
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
                } else {
                    click7 = false;
                    selectCount -= 1;
                    btn7cnt -= 1;
                    passionbtn.setBackgroundResource(characterselectbtn);
                    passionbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
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
                    click8 = true;
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
                } else {
                    click8 = false;
                    selectCount -= 1;
                    btn8cnt -= 1;
                    relaxedbtn.setBackgroundResource(characterselectbtn);
                    relaxedbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
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
                    click9 = true;
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
                } else {
                    click9 = false;
                    selectCount -= 1;
                    btn9cnt -= 1;
                    fourthdimentionbtn.setBackgroundResource(characterselectbtn);
                    fourthdimentionbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
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
                    click10 = true;
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
                } else {
                    click10 = false;
                    selectCount -= 1;
                    btn10cnt -= 1;
                    politebtn.setBackgroundResource(characterselectbtn);
                    politebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
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
                Intent intent = new Intent(getContext(), MyProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                clickmanage();
                intent.putExtra("Charactor position", listTitle);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }

    private void clickmanage() {
        if (click1) {
            listTitle.add("외향적인");
        }
        if (click2) {
            listTitle.add("내성적인");
        }
        if (click3) {
            listTitle.add("활발한");
        }
        if (click4) {
            listTitle.add("조용한");
        }
        if (click5) {
            listTitle.add("귀여운");
        }
        if (click6) {
            listTitle.add("어른스러운");
        }
        if (click7) {
            listTitle.add("열정적인");
        }
        if (click8) {
            listTitle.add("느긋한");
        }
        if (click9) {
            listTitle.add("4차원적인");
        }
        if (click10) {
            listTitle.add("예의 바른");
        }


    }
}