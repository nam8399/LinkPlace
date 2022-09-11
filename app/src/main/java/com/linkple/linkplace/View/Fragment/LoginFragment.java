package com.linkple.linkplace.View.Fragment;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.linkple.linkplace.R;
import com.linkple.linkplace.View.Activity.MainActivity;
import com.linkple.linkplace.View.Activity.OnBackPressedListener;
import com.linkple.linkplace.View.Activity.SettingActivity;
import com.linkple.linkplace.View.Activity.WebviewActivity;
import com.linkple.linkplace.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment implements OnBackPressedListener {
    private FragmentLoginBinding binding;

    MainActivity activity;
    String url = "";

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

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
        binding = FragmentLoginBinding.inflate(getLayoutInflater());

        activity = (MainActivity) getActivity();

        settingStartbtn();

        listenerSetting();

        return binding.getRoot();
    }


    private void listenerSetting() {
        binding.servciewebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = "congruous-swim-6f8.notion.site/9e8be44d40ce459389088d7772d04b56";
                Intent intent = new Intent(getContext(), WebviewActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        binding.privacywebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = "congruous-swim-6f8.notion.site/88709a0b9ca44b58871bb19573c3cb69";
                Intent intent = new Intent(getContext(), WebviewActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        binding.allcheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.allcheckbox.isChecked()) {
                    binding.checkbox1.setChecked(true);
                    binding.checkbox2.setChecked(true);
                    binding.startbutton.setEnabled(true);
                    binding.startbutton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    binding.startbutton.setEnabled(false);
                    binding.startbutton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    binding.checkbox1.setChecked(false);
                    binding.checkbox2.setChecked(false);
                }
            }
        });

        binding.checkbox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.checkbox1.isChecked() && binding.checkbox2.isChecked()) {
                    binding.startbutton.setEnabled(true);
                    binding.startbutton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    binding.startbutton.setEnabled(false);
                    binding.startbutton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                }
            }
        });

        binding.checkbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.checkbox1.isChecked() && binding.checkbox2.isChecked()) {
                    binding.startbutton.setEnabled(true);
                    binding.startbutton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    binding.startbutton.setEnabled(false);
                    binding.startbutton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                }
            }
        });



        binding.startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(InputNumberFragment.newInstance());
            }
        });
    }

    private void settingStartbtn() {
        binding.startbutton.setEnabled(false);
        binding.startbutton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
    }

    @Override
    public void onBackPressed() {
        getActivity().finish();
    }

    @Override public void onResume() {
        super.onResume();
        activity.setOnBackPressedListener(this);
    }

    public void onDestroyView() {
        super.onDestroyView();

        binding=null;
    }
}