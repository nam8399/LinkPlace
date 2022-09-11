package com.linkple.linkplace.View.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linkple.linkplace.R;
import com.linkple.linkplace.View.Activity.OnBackPressedListener;
import com.linkple.linkplace.databinding.FragmentNoSendAuthNumBinding;


public class noSendAuthNumFragment extends Fragment implements OnBackPressedListener {
    private FragmentNoSendAuthNumBinding binding;

    public noSendAuthNumFragment() {
        // Required empty public constructor
    }

    public static noSendAuthNumFragment newInstance() {
        return new noSendAuthNumFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNoSendAuthNumBinding.inflate(getLayoutInflater());

        listenerSetting();

       return binding.getRoot();
    }

    private void listenerSetting() {
        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle(); // 번들을 통해 값 전달
                bundle.putString("cancel",binding.phonenumberchecktext.getText().toString());//번들에 넘길 값 저장
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                InputNumberFragment inputNumberFragment = new InputNumberFragment();//프래그먼트2 선언
                inputNumberFragment.setArguments(bundle);//번들을 프래그먼트2로 보낼 준비
                transaction.replace(R.id.frameLayout, inputNumberFragment);
                transaction.commit();
            }
        });
    }

    @Override
    public void onBackPressed() {
    }

    public void onDestroyView() {
        super.onDestroyView();

        binding=null;
    }
}