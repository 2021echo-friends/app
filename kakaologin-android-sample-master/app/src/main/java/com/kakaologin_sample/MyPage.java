package com.kakaologin_sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyPage extends Activity {

    WebView wv;
    Button back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
        // 큐알코드에서 넘겨준 포인트 적립되는거 해야 함
        // 근데 웹이라서 .. 디비랑 왔다갔다 해야할 듯 ...
        wv = findViewById(R.id.wv);
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //페이지 로딩이 끝나면 호출
//        wv.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                Toast.makeText(MyPage.this, "로딩 끝", Toast.LENGTH_SHORT).show();
//            }
//        });
        wv.loadUrl("file:///android_asset/www/mypage.html");

        back = findViewById(R.id.back_mp);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MyPage.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });
    }
}
