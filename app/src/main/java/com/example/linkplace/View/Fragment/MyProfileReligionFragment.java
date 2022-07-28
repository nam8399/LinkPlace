package com.example.linkplace.View.Fragment;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.linkplace.R;
import com.example.linkplace.View.Activity.MyProfileActivity;

import static com.example.linkplace.R.drawable.genderclickbtn;
import static com.example.linkplace.R.drawable.genderselectbutton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyProfileReligionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyProfileReligionFragment extends Fragment {
    Button inputjobbtn, studentbtn, workerbtn, businessbtn, armybtn, preparingbtn, etcbtn;
    private String clickposition;

    public MyProfileReligionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MyProfileReligionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyProfileReligionFragment newInstance() {
        return new MyProfileReligionFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile_religion, container, false);

        inputjobbtn = view.findViewById(R.id.inputjobbtn);
        studentbtn = view.findViewById(R.id.studentbtn);
        workerbtn = view.findViewById(R.id.workerbtn);
        businessbtn = view.findViewById(R.id.businessbtn);
        armybtn = view.findViewById(R.id.armybtn);
        preparingbtn = view.findViewById(R.id.preparingbtn);
        etcbtn = view.findViewById(R.id.etcbtn);


        inputjobbtn.setEnabled(false);

        studentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentbtn.setBackgroundResource(genderclickbtn);
                workerbtn.setBackgroundResource(genderselectbutton);
                businessbtn.setBackgroundResource(genderselectbutton);
                armybtn.setBackgroundResource(genderselectbutton);
                preparingbtn.setBackgroundResource(genderselectbutton);

                studentbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                workerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                businessbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                armybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                preparingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));

                studentbtn.setTypeface(Typeface.DEFAULT_BOLD);
                workerbtn.setTypeface(Typeface.DEFAULT);
                businessbtn.setTypeface(Typeface.DEFAULT);
                armybtn.setTypeface(Typeface.DEFAULT);
                preparingbtn.setTypeface(Typeface.DEFAULT);
                inputjobbtn.setEnabled(true);
                inputjobbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                clickposition = "0";
            }
        });

        workerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workerbtn.setBackgroundResource(genderclickbtn);
                studentbtn.setBackgroundResource(genderselectbutton);
                businessbtn.setBackgroundResource(genderselectbutton);
                armybtn.setBackgroundResource(genderselectbutton);
                preparingbtn.setBackgroundResource(genderselectbutton);

                workerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                studentbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                businessbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                armybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                preparingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));

                workerbtn.setTypeface(Typeface.DEFAULT_BOLD);
                studentbtn.setTypeface(Typeface.DEFAULT);
                businessbtn.setTypeface(Typeface.DEFAULT);
                armybtn.setTypeface(Typeface.DEFAULT);
                preparingbtn.setTypeface(Typeface.DEFAULT);
                inputjobbtn.setEnabled(true);
                inputjobbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                clickposition = "1";
            }
        });

        businessbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                businessbtn.setBackgroundResource(genderclickbtn);
                studentbtn.setBackgroundResource(genderselectbutton);
                workerbtn.setBackgroundResource(genderselectbutton);
                armybtn.setBackgroundResource(genderselectbutton);
                preparingbtn.setBackgroundResource(genderselectbutton);

                businessbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                studentbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                workerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                armybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                preparingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));

                businessbtn.setTypeface(Typeface.DEFAULT_BOLD);
                studentbtn.setTypeface(Typeface.DEFAULT);
                workerbtn.setTypeface(Typeface.DEFAULT);
                armybtn.setTypeface(Typeface.DEFAULT);
                preparingbtn.setTypeface(Typeface.DEFAULT);
                inputjobbtn.setEnabled(true);
                inputjobbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                clickposition = "2";
            }
        });

        armybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                armybtn.setBackgroundResource(genderclickbtn);
                studentbtn.setBackgroundResource(genderselectbutton);
                workerbtn.setBackgroundResource(genderselectbutton);
                businessbtn.setBackgroundResource(genderselectbutton);
                preparingbtn.setBackgroundResource(genderselectbutton);

                armybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                studentbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                workerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                businessbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                preparingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));

                armybtn.setTypeface(Typeface.DEFAULT_BOLD);
                studentbtn.setTypeface(Typeface.DEFAULT);
                workerbtn.setTypeface(Typeface.DEFAULT);
                businessbtn.setTypeface(Typeface.DEFAULT);
                preparingbtn.setTypeface(Typeface.DEFAULT);
                inputjobbtn.setEnabled(true);
                inputjobbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                clickposition = "3";
            }
        });

        preparingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preparingbtn.setBackgroundResource(genderclickbtn);
                studentbtn.setBackgroundResource(genderselectbutton);
                workerbtn.setBackgroundResource(genderselectbutton);
                businessbtn.setBackgroundResource(genderselectbutton);
                armybtn.setBackgroundResource(genderselectbutton);

                preparingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                studentbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                workerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                businessbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                armybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));

                preparingbtn.setTypeface(Typeface.DEFAULT_BOLD);
                studentbtn.setTypeface(Typeface.DEFAULT);
                workerbtn.setTypeface(Typeface.DEFAULT);
                businessbtn.setTypeface(Typeface.DEFAULT);
                armybtn.setTypeface(Typeface.DEFAULT);
                inputjobbtn.setEnabled(true);
                inputjobbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                clickposition = "4";
            }
        });


        inputjobbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MyProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("Religion position", clickposition);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}