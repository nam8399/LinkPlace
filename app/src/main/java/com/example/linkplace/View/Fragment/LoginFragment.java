package com.example.linkplace.View.Fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.linkplace.R;
import com.example.linkplace.View.Activity.MainActivity;
import com.example.linkplace.View.Activity.OnBackPressedListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment implements OnBackPressedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    MainActivity activity;

    TextView loginagree_text;

    // TODO: Rename and change types of parameters

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        TextView textView = view.findViewById(R.id.startbutton);
        InputNumberFragment inputNumberFragment = new InputNumberFragment();

        activity = (MainActivity) getActivity();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(InputNumberFragment.newInstance());
            }
        });

        loginagree_text = view.findViewById(R.id.loginagree_text);

        String content = loginagree_text.getText().toString();
        SpannableString spannableString = new SpannableString(content);
//        int start = content.indexOf("서비스");
//        int end = start + inputnumber.length();

        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 6, 27, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), 6, 27, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 32, 42, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), 32, 42, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        loginagree_text.setText(spannableString);

        return view;
    }

    @Override
    public void onBackPressed() {
        getActivity().finish();
    }

    @Override public void onResume() {
        super.onResume();
        activity.setOnBackPressedListener(this);
    }
}