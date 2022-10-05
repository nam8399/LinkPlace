package com.linkple.linkplace.View.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.linkple.linkplace.R;
import com.linkple.linkplace.View.Fragment.LoginFragment;
import com.linkple.linkplace.databinding.ActivitySettingBinding;

public class SettingActivity extends AppCompatActivity {
    ActivitySettingBinding binding;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listener();

        webviewSetting();
    }

    private void webviewSetting() {
        binding.webview.getSettings().setJavaScriptEnabled(true);//자바스크립트 허용
        binding.webview.setWebChromeClient(new WebChromeClient());//웹뷰에 크롬 사용 허용//이 부분이 없으면 크롬에서 alert가 뜨지 않음
        binding.webview.setWebViewClient(new WebViewClientClass());//새창열기 없이 웹뷰 내에서 다시 열기//페이지 이동 원활히 하기위해 사용
        WebSettings settings = binding.webview.getSettings();
        settings.setDomStorageEnabled(true);
    }

    private void listener() {
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.qnabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.webview.setVisibility(View.VISIBLE);
                binding.webview.loadUrl("congruous-swim-6f8.notion.site/3e33f3723dae4c1da2ae5acde1970fa6");//웹뷰 실행
                binding.settingLinear.setVisibility(View.INVISIBLE);
                binding.guideTextLinear.setVisibility(View.INVISIBLE);
                binding.guideLine.setVisibility(View.INVISIBLE);
            }
        });

        binding.guidebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.webview.setVisibility(View.VISIBLE);
                Intent mail_intent = new Intent(Intent.ACTION_SENDTO);
                mail_intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                mail_intent.putExtra(Intent.EXTRA_EMAIL, "jjinjisik@gmail.com"); // 받는 사람 이메일
                mail_intent.putExtra(Intent.EXTRA_SUBJECT, "[LinkPlace 신고]"); // 메일 제목
                mail_intent.putExtra(Intent.EXTRA_TEXT, "제보자 닉네임 : \n신고 사용자 닉네임 : \n신고 내용 :\n\n- 받는 사람에 jjinjisik@gmail.com을 기입해주세요"); // 메일 내용
                startActivity(mail_intent);
                binding.settingLinear.setVisibility(View.INVISIBLE);
                binding.guideTextLinear.setVisibility(View.INVISIBLE);
                binding.guideLine.setVisibility(View.INVISIBLE);
            }
        });

        binding.privacybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.webview.setVisibility(View.VISIBLE);
                binding.webview.loadUrl("congruous-swim-6f8.notion.site/88709a0b9ca44b58871bb19573c3cb69");//웹뷰 실행
                binding.settingLinear.setVisibility(View.INVISIBLE);
                binding.guideTextLinear.setVisibility(View.INVISIBLE);
                binding.guideLine.setVisibility(View.INVISIBLE);
            }
        });


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        binding.logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(SettingActivity.this, "로그아웃 되었습니다.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(SettingActivity.this, MainActivity.class));
            }
        });
        
        binding.removeid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert_confirm = new AlertDialog.Builder(SettingActivity.this);
                alert_confirm.setMessage("정말 계정을 삭제 할까요?").setCancelable(false).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                databaseReference.child(uid).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void aVoid) {
                                                        Toast.makeText(SettingActivity.this, "계정이 삭제 되었습니다.", Toast.LENGTH_LONG).show();
                                                        startActivity(new Intent(SettingActivity.this, MainActivity.class));
                                                    }
                                                }).addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        System.out.println("error: "+e.getMessage());
                                                        Toast.makeText(SettingActivity.this, "회원탈퇴 실패", Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                            }
                                        });
                            }
                        }
                );
                alert_confirm.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(SettingActivity.this, "취소", Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog alertDialog = alert_confirm.create();
                alertDialog.show();
            }
        });
    }

    private class WebViewClientClass extends WebViewClient {//페이지 이동
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("check URL",url);
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if (binding.webview.getVisibility() == View.INVISIBLE) {
            finish();
        } else {
            binding.webview.setVisibility(View.INVISIBLE);
            binding.settingLinear.setVisibility(View.VISIBLE);
            binding.guideTextLinear.setVisibility(View.VISIBLE);
            binding.guideLine.setVisibility(View.VISIBLE);
        }
    }
}