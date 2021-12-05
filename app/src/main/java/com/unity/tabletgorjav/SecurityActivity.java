package com.unity.tabletgorjav;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;

import static com.unity.tabletgorjav.Commands.ElectricDeviceOFF;
import static com.unity.tabletgorjav.Commands.ElectricDeviceON;
import static com.unity.tabletgorjav.Commands.fingerPrintAfterLock;
import static com.unity.tabletgorjav.Commands.fingerPrintLock;
import static com.unity.tabletgorjav.Commands.fingerPrintUnLock;

public class SecurityActivity extends Activity {
    MaterialButton unlock_door, police, fire, panic, usual, unusual;
    int state_security, state_no_security, electricState;
    Intent mIntent, mIntent2;
    ImageView electric_devices, img_electric;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);
        unlock_door = findViewById(R.id.btn_unlock);
//        police = findViewById(R.id.btn_police);
//        fire =findViewById(R.id.btn_fire);
//        panic = findViewById(R.id.btn_panik);
        usual = findViewById(R.id.btn_usual);
        unusual = findViewById(R.id.btn_unusual);

        electric_devices = findViewById(R.id.img_cycle5);
        img_electric = findViewById(R.id.img_moon3);
        electricState = PrefConfig.loadElectricDevices(getApplicationContext());

        // load data from PrefConfig
        state_security = PrefConfig.loadSecurity(this);
        state_no_security = PrefConfig.loadNoSecurity(this);

        System.out.println("state security" + state_security);
        System.out.println("state no security" + state_no_security);

        if (state_security == 0) {
            unusual_off();
        } else if (state_security == 1){
            unusual_on();
        }
        if (electricState == 0) {
            img_electric.setBackgroundColor(getColor(R.color.gray));
        } else if (electricState == 1) {
            img_electric.setBackgroundColor(getColor(R.color.green));
        }

        // Give Personal PERMISSION for Call Phone
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
        }

        electric_devices.setOnClickListener(v -> {
            if (electricState == 0) {
                ElectricDeviceON(getApplicationContext());
                img_electric.setBackgroundColor(getColor(R.color.green));
                electricState = 1;
            } else if (electricState == 1) {
                ElectricDeviceOFF(getApplicationContext());
                img_electric.setBackgroundColor(getColor(R.color.gray));
                electricState = 0;
            }
            PrefConfig.saveElectricDevices(getApplicationContext(), electricState);
        });
        // Only one onClick Listener for all Material buttons
        @SuppressLint("NonConstantResourceId") View.OnClickListener onClickListener = v -> {
            switch (v.getId()) {
                case R.id.btn_unlock:
                    fingerPrintAfterLock(getApplicationContext());
                    break;
//                case R.id.btn_police:
//                    String number = ("tel:002");
//                    mIntent = new Intent(Intent.ACTION_CALL);
//                    mIntent.setData(Uri.parse(number));
//                    //You already have permission
//                    try {
//                        startActivity(mIntent);
//                    } catch(SecurityException e) {
//                        e.printStackTrace();
//                    }
//                    break;
//                case R.id.btn_fire:
//
//                    String number2 = ("tel:003");
//                    mIntent2 = new Intent(Intent.ACTION_CALL);
//                    mIntent2.setData(Uri.parse(number2));
//                    //You already have permission
//                    try {
//                        startActivity(mIntent2);
//                    } catch(SecurityException e) {
//                        e.printStackTrace();
//                    }
//                    break;
//                case R.id.btn_panik:
//
//                    break;
                case R.id.btn_usual:
                    if (state_security == 0) {
                        unusual_off();
                        state_security = 1;
                    } else {
                        unusual_on();
                        state_security = 0;
                    }
                    break;
                case R.id.btn_unusual:
                    if (state_security == 0) {
                        unusual_on();
                        state_security = 1;
                    } else {
                        unusual_off();
                        state_security = 0;
                    }
                    break;
            }
        };
        unlock_door.setOnClickListener(onClickListener);
//        police.setOnClickListener(onClickListener);
//        fire.setOnClickListener(onClickListener);
//        panic.setOnClickListener(onClickListener);
        usual.setOnClickListener(onClickListener);
        unusual.setOnClickListener(onClickListener);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void unusual_on(){
        unlock_door.setIconTintResource(R.color.light_blue_600);
        unlock_door.setRippleColorResource(R.color.light_blue_600);

        unusual.setTextColor(getResources().getColor(R.color.white));
        unusual.setBackgroundTintList(getColorStateList(R.color.light_blue_600));
        PrefConfig.saveSecurity(getApplicationContext(), 1);

        usual.setTextColor(getResources().getColor(R.color.bold_text));
        usual.setBackgroundTintList(getColorStateList(R.color.white));
        PrefConfig.saveNoSecurity(getApplicationContext(), 0);

        fingerPrintLock(getApplicationContext());
        System.out.println("goragly => 1 adaty => 0");

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void unusual_off(){
        unlock_door.setIconTintResource(R.color.green);
        unlock_door.setRippleColorResource(R.color.green);

        unusual.setTextColor(getResources().getColor(R.color.bold_text));
        unusual.setBackgroundTintList(getColorStateList(R.color.white));
        PrefConfig.saveSecurity(getApplicationContext(), 0);

        usual.setTextColor(getResources().getColor(R.color.white));
        usual.setBackgroundTintList(getColorStateList(R.color.green));
        PrefConfig.saveNoSecurity(getApplicationContext(), 1);

        fingerPrintUnLock(getApplicationContext());
        System.out.println("goragly => 0 adaty => 1");

    }
    // Check if PERMISSION is GRANTED or NOT GRANTED
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, R.string.granted, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, R.string.notGranted, Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}
