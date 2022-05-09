package com.example.linkplace.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.linkplace.R;
import com.example.linkplace.View.Fragment.LoginFragment;

public class MainActivity extends AppCompatActivity {
    LoginFragment loginFragment;
    OnBackPressedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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