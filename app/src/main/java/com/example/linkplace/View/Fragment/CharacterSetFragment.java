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
public class CharacterSetFragment extends Fragment {
    Button back_button, inputcharacterbtn, extervalbtn, intervalbtn, activitybtn, quietbtn, cutebtn, adultbtn, passionbtn, relaxedbtn;
    Button fourthdimentionbtn, politebtn, humorousbtn, seriousbtn, challengebtn, carefulbtn;
    int selectCount = 0;
    int btn1cnt, btn2cnt, btn3cnt, btn4cnt, btn5cnt, btn6cnt, btn7cnt, btn8cnt, btn9cnt, btn10cnt, btn11cnt, btn12cnt, btn13cnt, btn14cnt = 0;
    boolean chr1, chr2, chr3, chr4, chr5, chr6, chr7, chr8, chr9, chr10, chr11, chr12, chr13, chr14;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    String name, age, gender, job, charactor;


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

        init();




        return view;
    }

    private void init() {
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
                    chr1 = true;
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
                    chr1 = false;
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
                    chr2 = true;
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
                    chr2 = false;
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
                    chr3 = true;
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
                    chr3 = false;
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
                    chr4 = true;
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
                    chr4 = false;
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
                    chr5 = true;
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
                    chr5 = false;
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
                    chr6 = true;
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
                    chr6 = false;
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
                    chr7 = true;
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
                    chr7 = false;
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
                    chr8 = true;
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
                    chr8 = false;
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
                    chr9 = true;
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
                    chr9 = false;
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
                    chr10 = true;
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
                    chr10 = false;
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
                    chr11 = true;
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
                    chr11 = false;
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
                    chr12 = true;
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
                    chr12 = false;
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
                    chr13 = true;
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
                    chr13 = false;
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
                    chr14 = true;
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
                    chr14 = false;
                }
            }
        });


        inputcharacterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(SetHobbyFragment.newInstance());
                addProfileData(name, age, gender, job, chrResult(), "", "", "", "", "", "", "", "");
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
            result += "외향적인";
        }

        if (chr2) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "내향적인";
        }

        if (chr3) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "활발한";
        }

        if (chr4) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "조용한";
        }

        if (chr5) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "귀여운";
        }

        if (chr6) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "어른스러운";
        }

        if (chr7) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "열정적인";
        }

        if (chr8) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "느긋한";
        }

        if (chr9) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "4차원적인";
        }

        if (chr10) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "예의 바른";
        }

        if (chr11) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "유머러스한";
        }

        if (chr12) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "진지한";
        }

        if (chr13) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "도전적인";
        }

        if (chr14) {
            if (!result.equals("")) {
                result += ",";
            }
            result += "신중한";
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