package com.unity.tabletgorjav;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;

import static com.unity.tabletgorjav.Commands.acCold;
import static com.unity.tabletgorjav.Commands.acFanDown;
import static com.unity.tabletgorjav.Commands.acFanUp;
import static com.unity.tabletgorjav.Commands.acNum;
import static com.unity.tabletgorjav.Commands.acOff;
import static com.unity.tabletgorjav.Commands.acOn;
import static com.unity.tabletgorjav.Commands.swingOff;
import static com.unity.tabletgorjav.Commands.swingOn;

public class AirActivity extends Activity {
    String ip_address, strPort, strZeroParam, strFirstParam, strSecondParam, strHttp;
    MaterialButton swing, tempUp, tempDown, fanUp, fanDown, cold, power;
    TextView txt_temp;
    int temP;
    boolean b_power, b_swing = false;
    WebView webView;
//    JSONObject jsonParam = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air);
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(this);
        // load URL data from PrefConfig
        strPort = PrefConfig.loadPORTPref(this);
        strZeroParam = PrefConfig.loadZeroParam(this);
        strFirstParam = PrefConfig.loadFirstParam(this);
        strSecondParam = PrefConfig.loadSecondParam(this);
        strHttp = PrefConfig.loadHttpPref(this);
        temP = PrefConfig.loadAirTemp(this);

        webView = findViewById(R.id.web);
        swing = findViewById(R.id.exit_btn);
        tempUp = findViewById(R.id.vol_up_btn);
        tempDown = findViewById(R.id.vol_down_btn);
        fanUp = findViewById(R.id.ch_up_btn);
        fanDown = findViewById(R.id.ch_down_btn);
        cold = findViewById(R.id.btn_cold);
        power = findViewById(R.id.power_btn);
        txt_temp = findViewById(R.id.txtTemp);
        txt_temp.setText(String.valueOf(temP));

//        power.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                airOn(this);
//            }
//        });
//        power.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                airOff(this);
//                return false;
//            }
//        });
        // Only one onClick Listener for all Material buttons
        @SuppressLint("NonConstantResourceId") View.OnClickListener onClickListener = v -> {
            switch (v.getId()) {
                case R.id.power_btn:
                    if (!b_power) {
                        acOn(getApplicationContext());
                        b_power = true;
                    } else {
                        acOff(getApplicationContext());
                        b_power = false;
                    }
                    break;
                case R.id.exit_btn:
                    if (!b_swing) {
                        swingOn(getApplicationContext());
                        b_swing = true;
                    } else {
                        swingOff(getApplicationContext());
                        b_swing = false;
                    }
                    break;
                case R.id.vol_up_btn:
                    while (temP <= 29) {
                        temP++;
                        txt_temp.setText(String.valueOf(temP));
                        acNum(getApplicationContext());
                        break;
                    }
                    break;
                case R.id.vol_down_btn:
                    while (temP >= 21) {
                        temP--;
                        txt_temp.setText(String.valueOf(temP));
                        acNum(getApplicationContext());
                        break;
                    }
                    break;
                case R.id.ch_up_btn:
                    acFanUp(getApplicationContext());
                    break;
                case R.id.ch_down_btn:
                    acFanDown(getApplicationContext());
                    break;
                case R.id.btn_cold:
                    acCold(getApplicationContext());
                    break;
            }
        };
        power.setOnClickListener(onClickListener);
        swing.setOnClickListener(onClickListener);
        tempUp.setOnClickListener(onClickListener);
        tempDown.setOnClickListener(onClickListener);
        fanUp.setOnClickListener(onClickListener);
        fanDown.setOnClickListener(onClickListener);
        cold.setOnClickListener(onClickListener);
    }
//        public void sendData() {
//        Thread thread = new Thread(() -> {
//            try {
//                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.setRequestMethod("POST");
//                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//                conn.setRequestProperty("Accept", "application/json");
//                conn.setDoOutput(true);
//                conn.setDoInput(true);
//
//                JSONObject json = new JSONObject();
//                JSONArray pin_array = new JSONArray();
//                pin_array.put(jsonParam);
//                json.put("command", "command");
//                json.put("pins", pin_array);
//
//                Log.i("JSON", json.toString());
//                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
//                os.writeBytes(json.toString());
//                os.flush();
//                os.close();
//                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                    conn.disconnect();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//        thread.start();
//    }

}