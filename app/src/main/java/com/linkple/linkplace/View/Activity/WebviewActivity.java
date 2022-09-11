package com.linkple.linkplace.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.linkple.linkplace.R;
import com.linkple.linkplace.View.Fragment.LoginFragment;
import com.linkple.linkplace.databinding.ActivityWebviewBinding;

public class WebviewActivity extends AppCompatActivity {
    private ActivityWebviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        webviewSetting();
    }

    private void webviewSetting() {
        binding.webview.getSettings().setJavaScriptEnabled(true);//자바스크립트 허용
        binding.webview.setWebChromeClient(new WebChromeClient());//웹뷰에 크롬 사용 허용//이 부분이 없으면 크롬에서 alert가 뜨지 않음
        binding.webview.setWebViewClient(new WebViewClientClass());//새창열기 없이 웹뷰 내에서 다시 열기//페이지 이동 원활히 하기위해 사용
        WebSettings settings = binding.webview.getSettings();
        settings.setDomStorageEnabled(true);

        Intent urlIntent = getIntent();
        String url = urlIntent.getStringExtra("url");
        binding.webview.loadUrl(url);//웹뷰 실행
    }

    private class WebViewClientClass extends WebViewClient {//페이지 이동
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("check URL",url);
            view.loadUrl(url);
            return true;
        }
    }
}