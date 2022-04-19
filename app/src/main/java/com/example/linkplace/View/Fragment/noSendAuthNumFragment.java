package com.example.linkplace.View.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.linkplace.R;
import com.example.linkplace.View.Activity.MainActivity;
import com.example.linkplace.View.Activity.OnBackPressedListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link noSendAuthNumFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class noSendAuthNumFragment extends Fragment implements OnBackPressedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    TextView cancel_button, phonenumberchecktext;

    // TODO: Rename and change types of parameters


    public noSendAuthNumFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment noSendAuthNumFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static noSendAuthNumFragment newInstance() {
        return new noSendAuthNumFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_no_send_auth_num, container, false);
        cancel_button = view.findViewById(R.id.cancel_button);
        phonenumberchecktext = view.findViewById(R.id.phonenumberchecktext);

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //((MainActivity)getActivity()).replaceFragment(InputNumberFragment.newInstance());
                Bundle bundle = new Bundle(); // 번들을 통해 값 전달
                bundle.putString("cancel",phonenumberchecktext.getText().toString());//번들에 넘길 값 저장
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                InputNumberFragment inputNumberFragment = new InputNumberFragment();//프래그먼트2 선언
                inputNumberFragment.setArguments(bundle);//번들을 프래그먼트2로 보낼 준비
                transaction.replace(R.id.frameLayout, inputNumberFragment);
                transaction.commit();
            }
        });



       return view;
    }

    @Override
    public void onBackPressed() {
    }
}