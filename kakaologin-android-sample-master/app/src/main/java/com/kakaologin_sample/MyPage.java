package com.kakaologin_sample;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyPage extends Activity {

    WebView wv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        wv = findViewById(R.id.wv);
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //페이지 로딩이 끝나면 호출
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                Toast.makeText(MyPage.this, "로딩 끝", Toast.LENGTH_SHORT).show();
            }
        });
        wv.loadUrl("file:///android_asset/www/mypage.html");
    }
}
