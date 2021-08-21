package com.kakaologin_sample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class ScanQR extends AppCompatActivity {
//    String uid;
//    int point;
    TextView uidView, pointView;
    IntentIntegrator integrator;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanqr);
        uidView = findViewById(R.id.uid);
        pointView = findViewById(R.id.point);
        integrator = new IntentIntegrator(this);
        //바코드 안의 텍스트
        integrator.setPrompt("바코드를 사각형 안에 비춰주세요");
        //바코드 인식시 소리 여부
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(true);
        integrator.setCaptureActivity(CaptureActivity.class);
        //바코드 스캐너 시작
        integrator.initiateScan();
    }

    @Override public void onBackPressed() {
        super.onBackPressed();
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if (result.getContents() == null) {
                Log.d("SCAN FAILED", "nothing scanned");
            } else {
                Toast.makeText(ScanQR.this, "스캔 완료!", Toast.LENGTH_SHORT).show();
                Log.d("SCAN SUCCESSED", result.getContents());
                // QR코드를 읽어서 uid와 point에 저장
                try {
                    //data를 json으로 변환
                    JSONObject obj = new JSONObject(result.getContents());
                    uidView.setText(obj.getString("uid"));
                    pointView.setText(obj.getString("point"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(ScanQR.this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        }
        else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
