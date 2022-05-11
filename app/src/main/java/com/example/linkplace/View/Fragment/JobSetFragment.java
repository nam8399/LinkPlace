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
public class JobSetFragment extends Fragment {
    Button back_button, inputjobbtn, studentbtn, workerbtn, businessbtn, armybtn, preparingbtn, etcbtn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters

    public JobSetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProfileBirthSetFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static JobSetFragment newInstance() {
        return new JobSetFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_job_set, container, false);
        back_button = view.findViewById(R.id.back_button);
        inputjobbtn = view.findViewById(R.id.inputjobbtn);
        studentbtn = view.findViewById(R.id.studentbtn);
        workerbtn = view.findViewById(R.id.workerbtn);
        businessbtn = view.findViewById(R.id.businessbtn);
        armybtn = view.findViewById(R.id.armybtn);
        preparingbtn = view.findViewById(R.id.preparingbtn);
        etcbtn = view.findViewById(R.id.etcbtn);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(GenderSetFragment.newInstance());
            }
        });

        inputjobbtn.setEnabled(false);

        studentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentbtn.setBackgroundResource(genderclickbtn);
                workerbtn.setBackgroundResource(genderselectbutton);
                businessbtn.setBackgroundResource(genderselectbutton);
                armybtn.setBackgroundResource(genderselectbutton);
                preparingbtn.setBackgroundResource(genderselectbutton);
                etcbtn.setBackgroundResource(genderselectbutton);

                studentbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                workerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                businessbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                armybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                preparingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                etcbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));

                studentbtn.setTypeface(Typeface.DEFAULT_BOLD);
                workerbtn.setTypeface(Typeface.DEFAULT);
                businessbtn.setTypeface(Typeface.DEFAULT);
                armybtn.setTypeface(Typeface.DEFAULT);
                preparingbtn.setTypeface(Typeface.DEFAULT);
                etcbtn.setTypeface(Typeface.DEFAULT);
                inputjobbtn.setEnabled(true);
                inputjobbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
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
                etcbtn.setBackgroundResource(genderselectbutton);

                workerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                studentbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                businessbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                armybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                preparingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                etcbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));

                workerbtn.setTypeface(Typeface.DEFAULT_BOLD);
                studentbtn.setTypeface(Typeface.DEFAULT);
                businessbtn.setTypeface(Typeface.DEFAULT);
                armybtn.setTypeface(Typeface.DEFAULT);
                preparingbtn.setTypeface(Typeface.DEFAULT);
                etcbtn.setTypeface(Typeface.DEFAULT);
                inputjobbtn.setEnabled(true);
                inputjobbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
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
                etcbtn.setBackgroundResource(genderselectbutton);

                businessbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                studentbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                workerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                armybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                preparingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                etcbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));

                businessbtn.setTypeface(Typeface.DEFAULT_BOLD);
                studentbtn.setTypeface(Typeface.DEFAULT);
                workerbtn.setTypeface(Typeface.DEFAULT);
                armybtn.setTypeface(Typeface.DEFAULT);
                preparingbtn.setTypeface(Typeface.DEFAULT);
                etcbtn.setTypeface(Typeface.DEFAULT);
                inputjobbtn.setEnabled(true);
                inputjobbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
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
                etcbtn.setBackgroundResource(genderselectbutton);

                armybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                studentbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                workerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                businessbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                preparingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                etcbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));

                armybtn.setTypeface(Typeface.DEFAULT_BOLD);
                studentbtn.setTypeface(Typeface.DEFAULT);
                workerbtn.setTypeface(Typeface.DEFAULT);
                businessbtn.setTypeface(Typeface.DEFAULT);
                preparingbtn.setTypeface(Typeface.DEFAULT);
                etcbtn.setTypeface(Typeface.DEFAULT);
                inputjobbtn.setEnabled(true);
                inputjobbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
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
                etcbtn.setBackgroundResource(genderselectbutton);

                preparingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                studentbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                workerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                businessbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                armybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                etcbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));

                preparingbtn.setTypeface(Typeface.DEFAULT_BOLD);
                studentbtn.setTypeface(Typeface.DEFAULT);
                workerbtn.setTypeface(Typeface.DEFAULT);
                businessbtn.setTypeface(Typeface.DEFAULT);
                armybtn.setTypeface(Typeface.DEFAULT);
                etcbtn.setTypeface(Typeface.DEFAULT);
                inputjobbtn.setEnabled(true);
                inputjobbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
            }
        });

        etcbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etcbtn.setBackgroundResource(genderclickbtn);
                studentbtn.setBackgroundResource(genderselectbutton);
                workerbtn.setBackgroundResource(genderselectbutton);
                businessbtn.setBackgroundResource(genderselectbutton);
                armybtn.setBackgroundResource(genderselectbutton);
                preparingbtn.setBackgroundResource(genderselectbutton);

                etcbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                studentbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                workerbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                businessbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                armybtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));
                preparingbtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#9FA4A9")));

                etcbtn.setTypeface(Typeface.DEFAULT_BOLD);
                studentbtn.setTypeface(Typeface.DEFAULT);
                workerbtn.setTypeface(Typeface.DEFAULT);
                businessbtn.setTypeface(Typeface.DEFAULT);
                armybtn.setTypeface(Typeface.DEFAULT);
                preparingbtn.setTypeface(Typeface.DEFAULT);
                inputjobbtn.setEnabled(true);
                inputjobbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
            }
        });

        inputjobbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(CharacterSetFragment.newInstance());
            }
        });


        return view;
    }
}