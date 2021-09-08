package com.kakaologin_sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends Activity {
    ImageButton createQr;
    Button smallBarcode;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        final View drawerView = (View) findViewById(R.id.drawer);
        Button btnOpenDrawer = (Button)findViewById(R.id.btn_OpenDrawer);
        Button btnCloseDrawer = (Button)findViewById(R.id.btn_CloseDrawer);
        Button qrCode = (Button)findViewById(R.id.qr_code);
        Button myPage = (Button)findViewById(R.id.mypage);
        Button DailyQuiz = (Button)findViewById(R.id.btn_DailyQuiz);
        smallBarcode = (Button)findViewById(R.id.small_barcode);
        smallBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CreateQR.class);
                startActivity(i);
            }
        });

        //바코드 누르면 qr 생성되게 바코드 이미지를 버튼화 시킵니다 ~~
        createQr = (ImageButton) findViewById(R.id.qrcreate);

        createQr.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, CreateQR.class);
                startActivity(intent);
            }
        });

        btnOpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(drawerView);
            }
        });
        btnCloseDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(drawerView);
            }
        });
        qrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ScanQR.class);
                startActivity(i);
            }
        });
        myPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MyPage.class);
                startActivity(i);
            }
        });
        DailyQuiz.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DailyQuiz.class);
                startActivity(i);
            }
        });
    }
}
