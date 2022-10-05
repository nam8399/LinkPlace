package com.linkple.linkplace.View.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.linkple.linkplace.R;
import com.linkple.linkplace.View.Activity.MainActivity;
import com.linkple.linkplace.View.Activity.OnBackPressedListener;
import com.linkple.linkplace.View.Activity.PlaceActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.linkple.linkplace.View.Model.ProfileData;
import com.linkple.linkplace.databinding.FragmentInputNumberBinding;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputNumberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputNumberFragment extends Fragment implements OnBackPressedListener {
    private FragmentInputNumberBinding binding;

    MainActivity activity;

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    private SharedPreferences sharedPref;
    String TAG = "InputNumberFragment";
    String mVerificationId = "";
    private static final String KEY_VERIFICATION_ID = "key_verification_id";
    PhoneAuthProvider.ForceResendingToken mResendToken;

    String phoneNum = "+821012341234";
    String authNum;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    String name;

    TimerTask timerTask;
    Timer timer = new Timer();

    FirebaseAuth mAuth;

    public InputNumberFragment() {
        // Required empty public constructor
    }

    public static InputNumberFragment newInstance() {
        return new InputNumberFragment();
    }

    // TODO: Rename and change types and number of parameters
    public static InputNumberFragment newInstance(String param1, String param2) {
        InputNumberFragment fragment = new InputNumberFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentInputNumberBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        activity = (MainActivity) getActivity();

        visibleSetting();

        listener(savedInstanceState);

        firebaseSetting();

        return binding.getRoot();
    }

    private void firebaseSetting() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        try {
            String uid = user.getUid();
            databaseReference.child(uid).child("ProfileData").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    ProfileData profileData1 = dataSnapshot.getValue(ProfileData.class);

                    //각각의 값 받아오기 get어쩌구 함수들은 intakegroup.class에서 지정한것
                    try {
                        name = null;
                        name = profileData1.getWantfriend();
                        Log.d("InputNumberFragment", "name : " + name);
                    } catch (Exception e) {
                        name = null;
                        e.printStackTrace();
                    }

                    if (mAuth.getCurrentUser() != null && name != null) {
                        try {
                            Intent intent = new Intent(getContext(), PlaceActivity.class);
                            startActivity(intent);
                            getActivity().finish();
                            Toast toast = Toast.makeText(getContext(), "자동 로그인 성공", Toast.LENGTH_SHORT);
                            toast.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listener(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();

        binding.inputnumbertext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (binding.inputnumbertext.length() > 7) {
                    binding.inputnumberbtn.setClickable(true);
                    binding.inputnumberbtn.setEnabled(true);
                    binding.inputnumberbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    binding.inputnumberbtn.setClickable(false);
                    binding.inputnumberbtn.setEnabled(false);
                    binding.inputnumberbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                }
            }
        });

        binding.inputauthnumbertext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    binding.inputauthnumbertext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    binding.inputauthnumbertext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        binding.inputauthnumbertext2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    binding.inputauthnumbertext2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    binding.inputauthnumbertext2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        binding.inputauthnumbertext3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    binding.inputauthnumbertext3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    binding.inputauthnumbertext3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        binding.inputauthnumbertext4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    binding.inputauthnumbertext4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    binding.inputauthnumbertext4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        binding.inputauthnumbertext5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    binding.inputauthnumbertext5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    binding.inputauthnumbertext5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        binding.inputauthnumbertext6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    binding.inputauthnumbertext6.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    binding.inputauthnumbertext6.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        binding.inputauthnumbertext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (binding.inputauthnumbertext.length() > 0) {
                    binding.inputauthnumbertext2.requestFocus();
                }
            }
        });

        binding.inputauthnumbertext2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (binding.inputauthnumbertext2.length() > 0) {
                    binding.inputauthnumbertext3.requestFocus();
                }
            }
        });

        binding.inputauthnumbertext3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (binding.inputauthnumbertext3.length() > 0) {
                    binding.inputauthnumbertext4.requestFocus();
                }
            }
        });

        binding.inputauthnumbertext4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (binding.inputauthnumbertext4.length() > 0) {
                    binding.inputauthnumbertext5.requestFocus();
                }
            }
        });

        binding.inputauthnumbertext5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (binding.inputauthnumbertext5.length() > 0) {
                    binding.inputauthnumbertext6.requestFocus();
                }
            }
        });

        binding.inputauthnumbertext6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (binding.inputauthnumbertext6.length() > 0) {
                    binding.inputnumberbtn.setEnabled(true);
                    binding.inputnumberbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    binding.inputnumberbtn.setEnabled(false);
                    binding.inputnumberbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                }
            }
        });


        binding.inputnumberbtn.setOnClickListener(new View.OnClickListener() { // 버튼 클릭 시
            @Override
            public void onClick(View view) {
                //sendNumber();
                if (binding.inputnumberbtn.getText().toString().equals("전송하기")) {
                    binding.cancelButton.setVisibility(View.INVISIBLE);
                    binding.backButton.setVisibility(View.VISIBLE);
                    initCallBack();
                    String inputnumber = "+82" + binding.inputnumbertext.getText().toString().substring(1);
                    binding.guidtextrview.setText("인증번호 6자리를\n입력해주세요.");
                    binding.guidnumberview.setText(inputnumber + "로\n인증번호 문자메시지가 전송되었습니다.");
                    binding.authcounttext.setVisibility(View.VISIBLE);

                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            inputnumber,
                            60,
                            TimeUnit.SECONDS,
                            activity,
                            mCallbacks
                    );

//                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                            phoneNum,
//                            60,
//                            TimeUnit.SECONDS,
//                            activity,
//                            mCallbacks
//                    );

                    startTimerTask();

                    binding.inputnumberbtn.setText("인증하기");
                    binding.inputnumberbtn.setEnabled(false);
                    binding.inputnumberbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));

                    String content = binding.guidnumberview.getText().toString();
                    SpannableString spannableString = new SpannableString(content);
                    int start = content.indexOf(inputnumber);
                    int end = start + inputnumber.length();

                    spannableString.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                    binding.guidnumberview.setText(spannableString);
                    binding.nosendAuthNum.setVisibility(View.VISIBLE);
                    binding.robotalertlinear.setVisibility(View.INVISIBLE);
                    binding.inputnumberLinear.setVisibility(View.GONE);
                    binding.inputauthnumberLinear.setVisibility(View.VISIBLE);
                } else if (binding.inputnumberbtn.getText().toString().equals("인증하기")) {
                    binding.inputnumberbtn.setEnabled(false);
                    authNum = binding.inputauthnumbertext.getText().toString();
                    authNum += binding.inputauthnumbertext2.getText().toString();
                    authNum += binding.inputauthnumbertext3.getText().toString();
                    authNum += binding.inputauthnumbertext4.getText().toString();
                    authNum += binding.inputauthnumbertext5.getText().toString();
                    authNum += binding.inputauthnumbertext6.getText().toString();
                    Log.d(TAG, "입력 인증번호 : " + authNum);
                    if (mVerificationId == null && savedInstanceState != null) {
                        onRestoreInstanceState(savedInstanceState);
                    }
                    signInWithPhoneAuthCredential(PhoneAuthProvider.getCredential(mVerificationId, authNum));
                } else if (binding.inputnumberbtn.getText().toString().equals("재전송하기")) {
                    Toast toast = Toast.makeText(getContext(), "인증번호가 재전송 되었습니다.", Toast.LENGTH_SHORT);
                    toast.show();
                    binding.authcounttext.setTextColor(Color.parseColor("#919191"));
                    startTimerTask();
                    binding.inputnumberbtn.setText("인증하기");
                    binding.inputnumberbtn.setEnabled(false);
                    binding.inputnumberbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    binding.inputauthnumbertext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CACDD2")));
                    binding.inputauthnumbertext2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CACDD2")));
                    binding.inputauthnumbertext3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CACDD2")));
                    binding.inputauthnumbertext4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CACDD2")));
                    binding.inputauthnumbertext5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CACDD2")));
                    binding.inputauthnumbertext6.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CACDD2")));
                    binding.inputauthnumbertext.setEnabled(true);
                    binding.inputauthnumbertext2.setEnabled(true);
                    binding.inputauthnumbertext3.setEnabled(true);
                    binding.inputauthnumbertext4.setEnabled(true);
                    binding.inputauthnumbertext5.setEnabled(true);
                    binding.inputauthnumbertext6.setEnabled(true);
                }
            }
        });

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.guidtextrview.setText("본인 확인을 위해\n휴대전화 번호 인증이 필요해요");
                binding.guidnumberview.setText("입력하신 휴대전화 번호로\n인증번호 문자메시지가 전송됩니다.");
                binding.inputnumberbtn.setText("전송하기");
                binding.backButton.setVisibility(View.INVISIBLE);
                binding.inputnumberLinear.setVisibility(View.VISIBLE);
                binding.cancelButton.setVisibility(View.VISIBLE);
                binding.nosendAuthNum.setVisibility(View.GONE);
                binding.robotalertlinear.setVisibility(View.VISIBLE);
                binding.inputauthnumberLinear.setVisibility(View.GONE);
                binding.inputnumberbtn.setClickable(false);
                binding.inputnumberbtn.setEnabled(false);
                binding.authcounttext.setVisibility(View.INVISIBLE);
            }
        });

        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //onBackPressed();
                ((MainActivity)getActivity()).replaceFragment(LoginFragment.newInstance());
            }
        });

        binding.nosendAuthNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(noSendAuthNumFragment.newInstance());
            }
        });

        if (getArguments() != null)
        {
            binding.cancelButton.setVisibility(View.INVISIBLE);
            binding.backButton.setVisibility(View.VISIBLE);

            String inputnumber = binding.inputnumbertext.getText().toString();
            binding.guidtextrview.setText("인증번호 6자리를\n입력해주세요.");
            binding.guidnumberview.setText(getArguments().getString("cancel") + "로\n인증번호 문자메시지가 전송되었습니다.");
            binding.authcounttext.setVisibility(View.VISIBLE);

            startTimerTask();

            binding.inputnumberbtn.setText("인증하기");
            binding.inputnumberbtn.setEnabled(false);
            binding.inputnumberbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));

            String content = binding.guidnumberview.getText().toString();
            SpannableString spannableString = new SpannableString(content);
            int start = content.indexOf(getArguments().getString("cancel"));
            int end = start + getArguments().getString("cancel").length();

            spannableString.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            binding. guidnumberview.setText(spannableString);
            binding.nosendAuthNum.setVisibility(View.VISIBLE);
            binding.robotalertlinear.setVisibility(View.GONE);
            binding.inputnumberLinear.setVisibility(View.GONE);
            binding.inputauthnumberLinear.setVisibility(View.VISIBLE);
        }

    }

    private void visibleSetting() {
        binding.nosendAuthNum.setVisibility(View.GONE);
        binding.robotalertlinear.setVisibility(View.VISIBLE);
        binding.inputauthnumberLinear.setVisibility(View.GONE);
        binding.inputnumberbtn.setClickable(false);
        binding.inputnumberbtn.setEnabled(false);
        binding.authcounttext.setVisibility(View.INVISIBLE);
        binding.backButton.setVisibility(View.INVISIBLE);
    }

    private void startTimerTask()
    {
        stopTimerTask();
        timerTask = new TimerTask()
        {
            int count = 60;
            int minute = 4 ;

            @Override
            public void run()
            {
                count--;
                if (count == -1) {
                    minute--;
                    count = 59;
                }
                if (count == 0 && minute == 0) {
                    timerTask.cancel();
                    binding.authcounttext.setTextColor(Color.RED);
                }
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (count == 0 && minute == 0) {
                            binding.authcounttext.setText("*인증번호 입력 시간이 초과되었습니다.");
                            binding.inputnumberbtn.setText("재전송하기");
                            binding.inputnumberbtn.setEnabled(true);
                            binding.inputnumberbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                            binding.inputauthnumbertext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E14D4D")));
                            binding.inputauthnumbertext2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E14D4D")));
                            binding.inputauthnumbertext3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E14D4D")));
                            binding.inputauthnumbertext4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E14D4D")));
                            binding.inputauthnumbertext5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E14D4D")));
                            binding.inputauthnumbertext6.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E14D4D")));
                            binding.inputauthnumbertext.setEnabled(false);
                            binding.inputauthnumbertext2.setEnabled(false);
                            binding.inputauthnumbertext3.setEnabled(false);
                            binding.inputauthnumbertext4.setEnabled(false);
                            binding.inputauthnumbertext5.setEnabled(false);
                            binding.inputauthnumbertext6.setEnabled(false);
                        } else if (count < 10) {
                            binding.authcounttext.setText("0" + minute + ":"+ "0" + count);
                        }
                        else {
                            binding.authcounttext.setText("0" + minute + ":"+ count);
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask,0 ,1000);
    }

    private void stopTimerTask()
    {
        if(timerTask != null)
        {
            binding.authcounttext.setText("05:00");
            timerTask.cancel();
            timerTask = null;
        }
    }

    private void sendNumber() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(phoneNum)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(this.getActivity())
                .setCallbacks(mCallbacks)
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private void initCallBack() {
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {
                // This callback will be invoked in two situations:
                // 1 - Instant verification. In some cases the phone number can be instantly
                //     verified without needing to send or enter a verification code.
                // 2 - Auto-retrieval. On some devices Google Play services can automatically
                //     detect the incoming verification SMS and perform verification without
                //     user action.
                Log.d(TAG, "onVerificationCompleted:" + credential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                // This callback is invoked in an invalid request for verification is made,
                // for instance if the the phone number format is not valid.
                Log.w(TAG, "onVerificationFailed", e);

                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                } else if (e instanceof FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                }

                // Show a message and update the UI
            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                Log.d(TAG, "onCodeSent:" + verificationId);

                // Save verification ID and resending token so we can use them later
                mVerificationId = verificationId;
                mResendToken = token;
            }
        };
    }

    @Override
    public void onBackPressed() {
        //((MainActivity)getActivity()).replaceFragment(LoginFragment.newInstance());
    }

    @Override public void onResume() {
        super.onResume();
        activity.setOnBackPressedListener(this);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener((Activity) getContext(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            Toast toast = Toast.makeText(getContext(), "인증이 성공하였습니다.", Toast.LENGTH_SHORT);
                            toast.show();
                            ((MainActivity)getActivity()).replaceFragment(ProfileSetFragment.newInstance());
                            binding.inputnumberbtn.setEnabled(true);

                            // Update UI
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast toast = Toast.makeText(getContext(), "인증이 실패하였습니다.", Toast.LENGTH_SHORT);
                            toast.show();
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                            }
                            binding.inputnumberbtn.setEnabled(true);
                        }
                    }
                });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_VERIFICATION_ID,mVerificationId);
    }

    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        mVerificationId = savedInstanceState.getString(KEY_VERIFICATION_ID);
    }

    public void onDestroyView() {
        super.onDestroyView();

//        binding=null;
    }
}