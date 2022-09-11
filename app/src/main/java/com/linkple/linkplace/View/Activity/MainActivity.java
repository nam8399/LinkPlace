package com.linkple.linkplace.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.linkple.linkplace.R;
import com.linkple.linkplace.View.Fragment.LoginFragment;
import com.linkple.linkplace.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    LoginFragment loginFragment;
    OnBackPressedListener listener;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginFragment = new LoginFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, loginFragment).commit();
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }

    public void setOnBackPressedListener(OnBackPressedListener listener){
        this.listener = listener; }
        @Override public void onBackPressed() {
        if(listener!=null){
            listener.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }


}