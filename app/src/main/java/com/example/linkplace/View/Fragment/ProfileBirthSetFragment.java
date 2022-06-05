package com.example.linkplace.View.Fragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileBirthSetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileBirthSetFragment extends Fragment {
    EditText profile_year, profile_month, profile_day;
    Button back_button, inputbirthbtn;
    LinearLayout inputauthbirthtext, inputauthbirthtext2, inputauthbirthtext3;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters

    public ProfileBirthSetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProfileBirthSetFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static ProfileBirthSetFragment newInstance() {
        return new ProfileBirthSetFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_birth_set, container, false);
        profile_year = view.findViewById(R.id.profile_year);
        profile_month = view.findViewById(R.id.profile_month);
        profile_day = view.findViewById(R.id.profile_day);
        back_button = view.findViewById(R.id.back_button);
        inputauthbirthtext = view.findViewById(R.id.inputauthbirthtext);
        inputauthbirthtext2 = view.findViewById(R.id.inputauthbirthtext2);
        inputauthbirthtext3 = view.findViewById(R.id.inputauthbirthtext3);
        inputbirthbtn = view.findViewById(R.id.inputbirthbtn);

        inputbirthbtn.setEnabled(false);

        profile_year.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    inputauthbirthtext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    inputauthbirthtext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        profile_day.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    inputauthbirthtext3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    inputauthbirthtext3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        profile_month.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    inputauthbirthtext2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    inputauthbirthtext2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        profile_year.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (profile_year.length() > 3) {
                    profile_month.requestFocus();
                }
            }
        });

        profile_month.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (profile_month.length() > 1) {
                    profile_day.requestFocus();
                }
            }
        });

        profile_day.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (profile_month.length() > 1) {
                    inputbirthbtn.setEnabled(true);
                    inputbirthbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    inputbirthbtn.setEnabled(false);
                    inputbirthbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                }
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(ProfileSetFragment.newInstance());
            }
        });

        inputbirthbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(GenderSetFragment.newInstance());
            }
        });


        return view;
    }
}