package com.example.linkplace.View.Fragment;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import com.example.linkplace.R;
import com.example.linkplace.View.Activity.MyProfileActivity;

import static com.example.linkplace.R.drawable.genderclickbtn;
import static com.example.linkplace.R.drawable.genderselectbutton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyProfileSmokeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyProfileEducationFragment extends Fragment {
    Button inputjobbtn, studentbtn, workerbtn, businessbtn, armybtn, preparingbtn, etcbtn;
    NumberPicker educationpicker, educationpicker2;
    private String clickposition;

    public MyProfileEducationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MyProfileReligionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyProfileEducationFragment newInstance() {
        return new MyProfileEducationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile_education, container, false);

        inputjobbtn = view.findViewById(R.id.inputjobbtn);
        educationpicker = view.findViewById(R.id.educationpicker);
        educationpicker2 = view.findViewById(R.id.educationpicker2);
//        educationpicker.setMinValue(0);
//        educationpicker.setMaxValue(2);
//        educationpicker.setDisplayedValues( new String[] { "Belgium", "France", "United Kingdom" } );

        String[] arrayString= new String[]{" ","전문대","대학교","대학원","고등학교","중학교"};
        educationpicker.setMinValue(0);
        educationpicker.setMaxValue(arrayString.length-1);
        educationpicker.setValue(0);

        educationpicker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                // TODO Auto-generated method stub
                return arrayString[value];
            }
        });

        String[] arrayString2= new String[]{" ","재학","졸업","기타","중퇴"};
        educationpicker2.setMinValue(0);
        educationpicker2.setMaxValue(arrayString2.length-1);
        educationpicker2.setValue(0);

        educationpicker2.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                // TODO Auto-generated method stub
                return arrayString2[value];
            }
        });




        inputjobbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MyProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("education position", educationpicker.getValue());
                intent.putExtra("education2 position", educationpicker2.getValue());
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}