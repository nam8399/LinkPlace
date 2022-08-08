package com.example.linkplace.View.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.linkplace.R;
import com.example.linkplace.View.Activity.MainActivity;
import com.example.linkplace.View.Activity.OnBackPressedListener;
import com.example.linkplace.View.Activity.PlaceActivity;
import com.example.linkplace.View.Model.ProfileData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputNumberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputNumberFragment extends Fragment implements OnBackPressedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    MainActivity activity;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    String TAG = "InputNumberFragment";
    String mVerificationId = "";
    private static final String KEY_VERIFICATION_ID = "key_verification_id";
    PhoneAuthProvider.ForceResendingToken mResendToken;
    TextView guidetextview, guidnumberview, nosendAuthText, inputnumberText, inputauthnumbertext, inputauthnumbertext2,
            inputauthnumbertext3, inputauthnumbertext4, inputauthnumbertext5, inputauthnumbertext6, authcounttext, nosendauthnumtext;
    Button sendnumberbtn, back_button, cancel_button;
    LinearLayout inputauthnumberLinear, inputnumberLinear;
    String phoneNum = "+821012341234";
    String authNum;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input_number, container, false);
        activity = (MainActivity) getActivity();
        sendnumberbtn = view.findViewById(R.id.inputnumberbtn);
        cancel_button = view.findViewById(R.id.cancel_button);
        back_button = view.findViewById(R.id.back_button);
        guidetextview = view.findViewById(R.id.numberinputguide);
        guidnumberview = view.findViewById(R.id.numberinputguide2);
        nosendAuthText = view.findViewById(R.id.nosendAuthNum);
        inputnumberText = view.findViewById(R.id.inputnumbertext);
        inputnumberLinear = view.findViewById(R.id.inputnumberLinear);
        inputauthnumbertext = view.findViewById(R.id.inputauthnumbertext);
        inputauthnumbertext2 = view.findViewById(R.id.inputauthnumbertext2);
        inputauthnumbertext3 = view.findViewById(R.id.inputauthnumbertext3);
        inputauthnumbertext4 = view.findViewById(R.id.inputauthnumbertext4);
        inputauthnumbertext5 = view.findViewById(R.id.inputauthnumbertext5);
        inputauthnumbertext6 = view.findViewById(R.id.inputauthnumbertext6);
        nosendauthnumtext = view.findViewById(R.id.nosendAuthNum);
        authcounttext = view.findViewById(R.id.authcounttext);
        inputauthnumberLinear = view.findViewById(R.id.inputauthnumberLinear);
        nosendAuthText.setVisibility(View.GONE);
        inputauthnumberLinear.setVisibility(View.GONE);
        sendnumberbtn.setClickable(false);
        sendnumberbtn.setEnabled(false);
        authcounttext.setVisibility(View.INVISIBLE);
        back_button.setVisibility(View.INVISIBLE);


        mAuth = FirebaseAuth.getInstance();

        inputnumberText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (inputnumberText.length() > 7) {
                    sendnumberbtn.setClickable(true);
                    sendnumberbtn.setEnabled(true);
                    sendnumberbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    sendnumberbtn.setClickable(false);
                    sendnumberbtn.setEnabled(false);
                    sendnumberbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                }
            }
        });

        inputauthnumbertext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    inputauthnumbertext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    inputauthnumbertext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        inputauthnumbertext2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    inputauthnumbertext2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    inputauthnumbertext2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        inputauthnumbertext3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    inputauthnumbertext3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    inputauthnumbertext3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        inputauthnumbertext4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    inputauthnumbertext4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    inputauthnumbertext4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        inputauthnumbertext5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    inputauthnumbertext5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    inputauthnumbertext5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        inputauthnumbertext6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    inputauthnumbertext6.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    inputauthnumbertext6.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#898A8D")));
                }
            }
        });

        inputauthnumbertext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (inputauthnumbertext.length() > 0) {
                    inputauthnumbertext2.requestFocus();
                }
            }
        });

        inputauthnumbertext2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (inputauthnumbertext2.length() > 0) {
                    inputauthnumbertext3.requestFocus();
                }
            }
        });

        inputauthnumbertext3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (inputauthnumbertext3.length() > 0) {
                    inputauthnumbertext4.requestFocus();
                }
            }
        });

        inputauthnumbertext4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (inputauthnumbertext4.length() > 0) {
                    inputauthnumbertext5.requestFocus();
                }
            }
        });

        inputauthnumbertext5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (inputauthnumbertext5.length() > 0) {
                    inputauthnumbertext6.requestFocus();
                }
            }
        });

        inputauthnumbertext6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (inputauthnumbertext6.length() > 0) {
                    sendnumberbtn.setEnabled(true);
                    sendnumberbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                } else {
                    sendnumberbtn.setEnabled(false);
                    sendnumberbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                }
            }
        });

        if (mAuth.getCurrentUser() != null) {
            Intent intent = new Intent(getContext(), PlaceActivity.class);
            startActivity(intent);
            getActivity().finish();
            Toast toast = Toast.makeText(getContext(), "자동 로그인 성공", Toast.LENGTH_SHORT);
            toast.show();
        }

        sendnumberbtn.setOnClickListener(new View.OnClickListener() { // 버튼 클릭 시
            @Override
            public void onClick(View view) {
                //sendNumber();
                if (sendnumberbtn.getText().toString().equals("전송하기")) {
                    cancel_button.setVisibility(View.INVISIBLE);
                    back_button.setVisibility(View.VISIBLE);
                    initCallBack();
                    String inputnumber = "+82" + inputnumberText.getText().toString().substring(1);
                    guidetextview.setText("인증번호 6자리를\n입력해주세요.");
                    guidnumberview.setText(inputnumber + "로\n인증번호 문자메시지가 전송되었습니다.");
                    authcounttext.setVisibility(View.VISIBLE);

                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            phoneNum,
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

                    sendnumberbtn.setText("인증하기");
                    sendnumberbtn.setEnabled(false);
                    sendnumberbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));

                    String content = guidnumberview.getText().toString();
                    SpannableString spannableString = new SpannableString(content);
                    int start = content.indexOf(inputnumber);
                    int end = start + inputnumber.length();

                    spannableString.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                    guidnumberview.setText(spannableString);
                    nosendAuthText.setVisibility(View.VISIBLE);
                    inputnumberLinear.setVisibility(View.GONE);
                    inputauthnumberLinear.setVisibility(View.VISIBLE);
                } else if (sendnumberbtn.getText().toString().equals("인증하기")) {
                    authNum = inputauthnumbertext.getText().toString();
                    authNum += inputauthnumbertext2.getText().toString();
                    authNum += inputauthnumbertext3.getText().toString();
                    authNum += inputauthnumbertext4.getText().toString();
                    authNum += inputauthnumbertext5.getText().toString();
                    authNum += inputauthnumbertext6.getText().toString();
                    Log.d(TAG, "입력 인증번호 : " + authNum);
                    if (mVerificationId == null && savedInstanceState != null) {
                        onRestoreInstanceState(savedInstanceState);
                    }
                    signInWithPhoneAuthCredential(PhoneAuthProvider.getCredential(mVerificationId, authNum));
                } else if (sendnumberbtn.getText().toString().equals("재전송하기")) {
                    Toast toast = Toast.makeText(getContext(), "인증번호가 재전송 되었습니다.", Toast.LENGTH_SHORT);
                    toast.show();
                    authcounttext.setTextColor(Color.parseColor("#919191"));
                    startTimerTask();
                    sendnumberbtn.setText("인증하기");
                    sendnumberbtn.setEnabled(false);
                    sendnumberbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
                    inputauthnumbertext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CACDD2")));
                    inputauthnumbertext2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CACDD2")));
                    inputauthnumbertext3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CACDD2")));
                    inputauthnumbertext4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CACDD2")));
                    inputauthnumbertext5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CACDD2")));
                    inputauthnumbertext6.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CACDD2")));
                    inputauthnumbertext.setEnabled(true);
                    inputauthnumbertext2.setEnabled(true);
                    inputauthnumbertext3.setEnabled(true);
                    inputauthnumbertext4.setEnabled(true);
                    inputauthnumbertext5.setEnabled(true);
                    inputauthnumbertext6.setEnabled(true);
                }
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guidetextview.setText("본인 확인을 위해\n휴대전화 번호 인증이 필요해요");
                guidnumberview.setText("입력하신 휴대전화 번호로\n인증번호 문자메시지가 전송됩니다.");
                sendnumberbtn.setText("전송하기");
                back_button.setVisibility(View.INVISIBLE);
                inputnumberLinear.setVisibility(View.VISIBLE);
                cancel_button.setVisibility(View.VISIBLE);
                nosendAuthText.setVisibility(View.GONE);
                inputauthnumberLinear.setVisibility(View.GONE);
                sendnumberbtn.setClickable(false);
                sendnumberbtn.setEnabled(false);
                authcounttext.setVisibility(View.INVISIBLE);
            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //onBackPressed();
                ((MainActivity)getActivity()).replaceFragment(LoginFragment.newInstance());
            }
        });

        nosendauthnumtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(noSendAuthNumFragment.newInstance());
            }
        });

        if (getArguments() != null)
        {
            cancel_button.setVisibility(View.INVISIBLE);
            back_button.setVisibility(View.VISIBLE);

            String inputnumber = inputnumberText.getText().toString();
            guidetextview.setText("인증번호 6자리를\n입력해주세요.");
            guidnumberview.setText(getArguments().getString("cancel") + "로\n인증번호 문자메시지가 전송되었습니다.");
            authcounttext.setVisibility(View.VISIBLE);

            startTimerTask();

            sendnumberbtn.setText("인증하기");
            sendnumberbtn.setEnabled(false);
            sendnumberbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));

            String content = guidnumberview.getText().toString();
            SpannableString spannableString = new SpannableString(content);
            int start = content.indexOf(getArguments().getString("cancel"));
            int end = start + getArguments().getString("cancel").length();

            spannableString.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            guidnumberview.setText(spannableString);
            nosendAuthText.setVisibility(View.VISIBLE);
            inputnumberLinear.setVisibility(View.GONE);
            inputauthnumberLinear.setVisibility(View.VISIBLE);
        }


        return view;
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
                    authcounttext.setTextColor(Color.RED);
                }
                authcounttext.post(new Runnable() {
                    @Override
                    public void run() {
                        if (count == 0 && minute == 0) {
                            authcounttext.setText("*인증번호 입력 시간이 초과되었습니다.");
                            sendnumberbtn.setText("재전송하기");
                            sendnumberbtn.setEnabled(true);
                            sendnumberbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                            inputauthnumbertext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E14D4D")));
                            inputauthnumbertext2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E14D4D")));
                            inputauthnumbertext3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E14D4D")));
                            inputauthnumbertext4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E14D4D")));
                            inputauthnumbertext5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E14D4D")));
                            inputauthnumbertext6.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E14D4D")));
                            inputauthnumbertext.setEnabled(false);
                            inputauthnumbertext2.setEnabled(false);
                            inputauthnumbertext3.setEnabled(false);
                            inputauthnumbertext4.setEnabled(false);
                            inputauthnumbertext5.setEnabled(false);
                            inputauthnumbertext6.setEnabled(false);
                        } else if (count < 10) {
                            authcounttext.setText("0" + minute + ":"+ "0" + count);
                        }
                        else {
                            authcounttext.setText("0" + minute + ":"+ count);
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
            authcounttext.setText("05:00");
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


                            // Update UI
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast toast = Toast.makeText(getContext(), "인증이 실패하였습니다.", Toast.LENGTH_SHORT);
                            toast.show();
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                            }
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
}