package com.example.linkplace.View.Fragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.linkplace.R;
import com.example.linkplace.View.Activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileSetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileSetFragment extends Fragment {
    Button inputnamebtn, back_button;
    EditText inputnametext;
    TextView nameinputguidetext;
    LinearLayout inputnameLinear;

    public ProfileSetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProfileSetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileSetFragment newInstance() {
        return new ProfileSetFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_set, container, false);

        inputnamebtn = view.findViewById(R.id.inputnamebtn);
        back_button = view.findViewById(R.id.back_button);
        inputnametext = view.findViewById(R.id.inputnametext);
        nameinputguidetext = view.findViewById(R.id.nameinputguidetext);
        inputnameLinear = view.findViewById(R.id.inputnameLinear);

        inputnamebtn.setEnabled(false);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(InputNumberFragment.newInstance());
            }
        });

        inputnametext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (inputnametext.length() > 1 && inputnamebtn.length() < 13) {
                    inputnamebtn.setClickable(true);
                    inputnamebtn.setEnabled(true);
                    inputnamebtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    inputnamebtn.setClickable(false);
                    inputnamebtn.setEnabled(false);
                    inputnamebtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                }
            }
        });

        inputnamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(ProfileBirthSetFragment.newInstance());
            }
        });

        String content = nameinputguidetext.getText().toString();
        SpannableString spannableString = new SpannableString(content);

        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        nameinputguidetext.setText(spannableString);


        inputnametext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    inputnameLinear.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    inputnameLinear.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });


        return view;
    }
}