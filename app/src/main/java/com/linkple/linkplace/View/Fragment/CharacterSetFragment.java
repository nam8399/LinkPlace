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
import com.linkple.linkplace.databinding.FragmentCharacterSetBinding;

import static com.linkple.linkplace.R.drawable.characterclickbtn;
import static com.linkple.linkplace.R.drawable.characterselectbtn;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileBirthSetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterSetFragment extends Fragment {
    FragmentCharacterSetBinding binding;

    int selectCount = 0;
    int btn1cnt, btn2cnt, btn3cnt, btn4cnt, btn5cnt, btn6cnt, btn7cnt, btn8cnt, btn9cnt, btn10cnt, btn11cnt, btn12cnt, btn13cnt, btn14cnt = 0;
    boolean chr1, chr2, chr3, chr4, chr5, chr6, chr7, chr8, chr9, chr10, chr11, chr12, chr13, chr14;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    String name, age, gender, job;

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
        binding = FragmentCharacterSetBinding.inflate(getLayoutInflater());

        listenerSetting();


        return binding.getRoot();
    }

    private void listenerSetting() {
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(JobSetFragment.newInstance());
            }
        });

        binding.inputcharacterbtn.setEnabled(false);

        binding.extervalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn1cnt == 0) {
                    selectCount += 1;
                    btn1cnt += 1;
                    binding.extervalbtn.setBackgroundResource(characterclickbtn);
                    binding.extervalbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    chr1 = true;
                } else {
                    selectCount -= 1;
                    btn1cnt -= 1;
                    binding.extervalbtn.setBackgroundResource(characterselectbtn);
                    binding.extervalbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr1 = false;
                }
            }
        });

        binding.intervalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn2cnt == 0) {
                    selectCount += 1;
                    btn2cnt += 1;
                    binding.intervalbtn.setBackgroundResource(characterclickbtn);
                    binding.intervalbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    chr2 = true;
                } else {
                    selectCount -= 1;
                    btn2cnt -= 1;
                    binding.intervalbtn.setBackgroundResource(characterselectbtn);
                    binding.intervalbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr2 = false;
                }
            }
        });

        binding.activitybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn3cnt == 0) {
                    selectCount += 1;
                    btn3cnt += 1;
                    binding.activitybtn.setBackgroundResource(characterclickbtn);
                    binding.activitybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    chr3 = true;
                } else {
                    selectCount -= 1;
                    btn3cnt -= 1;
                    binding.activitybtn.setBackgroundResource(characterselectbtn);
                    binding.activitybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr3 = false;
                }
            }
        });

        binding.quietbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn4cnt == 0) {
                    selectCount += 1;
                    btn4cnt += 1;
                    binding.quietbtn.setBackgroundResource(characterclickbtn);
                    binding.quietbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    chr4 = true;
                } else {
                    selectCount -= 1;
                    btn4cnt -= 1;
                    binding.quietbtn.setBackgroundResource(characterselectbtn);
                    binding.quietbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr4 = false;
                }
            }
        });

        binding.cutebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn5cnt == 0) {
                    selectCount += 1;
                    btn5cnt += 1;
                    binding.cutebtn.setBackgroundResource(characterclickbtn);
                    binding.cutebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    chr5 = true;
                } else {
                    selectCount -= 1;
                    btn5cnt -= 1;
                    binding.cutebtn.setBackgroundResource(characterselectbtn);
                    binding.cutebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr5 = false;
                }
            }
        });

        binding.adultbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn6cnt == 0) {
                    selectCount += 1;
                    btn6cnt += 1;
                    binding.adultbtn.setBackgroundResource(characterclickbtn);
                    binding.adultbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    chr6 = true;
                } else {
                    selectCount -= 1;
                    btn6cnt -= 1;
                    binding.adultbtn.setBackgroundResource(characterselectbtn);
                    binding.adultbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr6 = false;
                }
            }
        });

        binding.passionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn7cnt == 0) {
                    selectCount += 1;
                    btn7cnt += 1;
                    binding.passionbtn.setBackgroundResource(characterclickbtn);
                    binding.passionbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    chr7 = true;
                } else {
                    selectCount -= 1;
                    btn7cnt -= 1;
                    binding.passionbtn.setBackgroundResource(characterselectbtn);
                    binding.passionbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr7 = false;
                }
            }
        });

        binding.relaxedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn8cnt == 0) {
                    selectCount += 1;
                    btn8cnt += 1;
                    binding.relaxedbtn.setBackgroundResource(characterclickbtn);
                    binding.relaxedbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    chr8 = true;
                } else {
                    selectCount -= 1;
                    btn8cnt -= 1;
                    binding.relaxedbtn.setBackgroundResource(characterselectbtn);
                    binding.relaxedbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr8 = false;
                }
            }
        });

        binding.fourthdimentionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn9cnt == 0) {
                    selectCount += 1;
                    btn9cnt += 1;
                    binding.fourthdimentionbtn.setBackgroundResource(characterclickbtn);
                    binding.fourthdimentionbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    chr9 = true;
                } else {
                    selectCount -= 1;
                    btn9cnt -= 1;
                    binding.fourthdimentionbtn.setBackgroundResource(characterselectbtn);
                    binding.fourthdimentionbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr9 = false;
                }
            }
        });

        binding.politebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn10cnt == 0) {
                    selectCount += 1;
                    btn10cnt += 1;
                    binding.politebtn.setBackgroundResource(characterclickbtn);
                    binding.politebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    chr10 = true;
                } else {
                    selectCount -= 1;
                    btn10cnt -= 1;
                    binding.politebtn.setBackgroundResource(characterselectbtn);
                    binding.politebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr10 = false;
                }
            }
        });

        binding.humorousbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn11cnt == 0) {
                    selectCount += 1;
                    btn11cnt += 1;
                    binding.humorousbtn.setBackgroundResource(characterclickbtn);
                    binding.humorousbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    chr11 = true;
                } else {
                    selectCount -= 1;
                    btn11cnt -= 1;
                    binding.humorousbtn.setBackgroundResource(characterselectbtn);
                    binding.humorousbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr11 = false;
                }
            }
        });

        binding.seriousbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn12cnt == 0) {
                    selectCount += 1;
                    btn12cnt += 1;
                    binding.seriousbtn.setBackgroundResource(characterclickbtn);
                    binding.seriousbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    chr12 = true;
                } else {
                    selectCount -= 1;
                    btn12cnt -= 1;
                    binding.seriousbtn.setBackgroundResource(characterselectbtn);
                    binding.seriousbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr12 = false;
                }
            }
        });

        binding.challengebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn13cnt == 0) {
                    selectCount += 1;
                    btn13cnt += 1;
                    binding.challengebtn.setBackgroundResource(characterclickbtn);
                    binding.challengebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    chr13 = true;
                } else {
                    selectCount -= 1;
                    btn13cnt -= 1;
                    binding.challengebtn.setBackgroundResource(characterselectbtn);
                    binding.challengebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr13 = false;
                }
            }
        });

        binding.carefulbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn14cnt == 0) {
                    selectCount += 1;
                    btn14cnt += 1;
                    binding.carefulbtn.setBackgroundResource(characterclickbtn);
                    binding.carefulbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    chr14 = true;
                } else {
                    selectCount -= 1;
                    btn14cnt -= 1;
                    binding.carefulbtn.setBackgroundResource(characterselectbtn);
                    binding.carefulbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                    binding.inputcharacterbtn.setText("다음 (" + selectCount + "/10)");
                    if (selectCount > 1 && selectCount < 11) {
                        binding.inputcharacterbtn.setEnabled(true);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                    } else {
                        binding.inputcharacterbtn.setEnabled(false);
                        binding.inputcharacterbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    }
                    chr14 = false;
                }
            }
        });


        binding.inputcharacterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(SetHobbyFragment.newInstance());
                addProfileData(name, age, gender, job, chrResult(), "", "", "", "", "", "", "", "", "", "");
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