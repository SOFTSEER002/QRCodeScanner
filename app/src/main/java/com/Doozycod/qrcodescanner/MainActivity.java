package com.Doozycod.qrcodescanner;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button scan_qr_btn = findViewById(R.id.scan_code_btn);

        //      Requesting Permission for the Camera
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity)
                    MainActivity.this, Manifest.permission.CAMERA)) {


            } else {
                ActivityCompat.requestPermissions((Activity) MainActivity.this,
                        new String[]{Manifest.permission.CAMERA},
                        200);
            }

        }
        scan_qr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QRCodeScanActivity.class));
            }
        });
    }
}
