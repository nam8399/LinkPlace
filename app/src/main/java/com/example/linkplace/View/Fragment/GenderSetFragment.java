package com.example.linkplace.View.Fragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
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

import static com.example.linkplace.R.drawable.genderclickbtn;
import static com.example.linkplace.R.drawable.genderselectbutton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileBirthSetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GenderSetFragment extends Fragment {
    EditText profile_year, profile_month, profile_day;
    Button back_button, inputgenderbtn, gendermalebtn, genderfemalebtn;
    LinearLayout inputauthbirthtext, inputauthbirthtext2, inputauthbirthtext3;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters

    public GenderSetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProfileBirthSetFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static GenderSetFragment newInstance() {
        return new GenderSetFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gender_set, container, false);
        back_button = view.findViewById(R.id.back_button);
        inputgenderbtn = view.findViewById(R.id.inputgenderbtn);
        gendermalebtn = view.findViewById(R.id.gendermalebtn);
        genderfemalebtn = view.findViewById(R.id.genderfemalebtn);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(ProfileBirthSetFragment.newInstance());
            }
        });

        inputgenderbtn.setEnabled(false);

        gendermalebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gendermalebtn.setBackgroundResource(genderclickbtn);
                genderfemalebtn.setBackgroundResource(genderselectbutton);
                gendermalebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                genderfemalebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                gendermalebtn.setTypeface(Typeface.DEFAULT_BOLD);
                genderfemalebtn.setTypeface(Typeface.DEFAULT);
                inputgenderbtn.setEnabled(true);
                inputgenderbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
            }
        });

        genderfemalebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gendermalebtn.setBackgroundResource(genderselectbutton);
                genderfemalebtn.setBackgroundResource(genderclickbtn);
                gendermalebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                genderfemalebtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                gendermalebtn.setTypeface(Typeface.DEFAULT);
                genderfemalebtn.setTypeface(Typeface.DEFAULT_BOLD);
                inputgenderbtn.setEnabled(true);
                inputgenderbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
            }
        });

        inputgenderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(JobSetFragment.newInstance());
            }
        });


        return view;
    }
}