package com.unity.tabletgorjav;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import org.json.JSONObject;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.unity.tabletgorjav.Commands.MainLampOff;
import static com.unity.tabletgorjav.Commands.MainLampOn;

public class LightActivity extends Activity {

    SeekBar seekBar_lamp;
    int light_degree, sw_int;
    String ip_address, strPort, strZeroParam, strFirstParam, strSecondParam, strHttp;
    TextView txtLightD;
    Switch swLamp;
    ImageView l1, l2, l3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //remove status bar
        setContentView(R.layout.activity_light);
        // Seek_bar (change mode of lights)
        seekBar_lamp = findViewById(R.id.seekBar);
        txtLightD = findViewById(R.id.txt_LDegree);
        swLamp = findViewById(R.id.sw_light);

        l1 = findViewById(R.id.imageView21);
        l2 = findViewById(R.id.imageView22);
        l3 = findViewById(R.id.imageView23);


        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(this);
        // load URL data from PrefConfig
        strPort = PrefConfig.loadPORTPref(this);
        strZeroParam = PrefConfig.loadZeroParam(this);
        strFirstParam = PrefConfig.loadFirstParam(this);
        strSecondParam = PrefConfig.loadSecondParam(this);
        strHttp = PrefConfig.loadHttpPref(this);
        sw_int = PrefConfig.loadKitchenState(this);
        light_degree = PrefConfig.loadDimmerState(this);

        if (light_degree == 1) {
            seekBar_lamp.setProgress(1);
            txtLightD.setText(R.string.percent25);
            l1.setAlpha(50);
            l2.setAlpha(50);
            l3.setAlpha(50);
        } else if (light_degree == 2) {
            seekBar_lamp.setProgress(2);
            txtLightD.setText(R.string.percent50);
            l1.setAlpha(75);
            l2.setAlpha(75);
            l3.setAlpha(75);
        } else if (light_degree == 3) {
            seekBar_lamp.setProgress(3);
            txtLightD.setText(R.string.percent100);
            l1.setAlpha(100);
            l2.setAlpha(100);
            l3.setAlpha(100);
        }else if (light_degree == 0 ) {
            seekBar_lamp.setProgress(0);
            txtLightD.setText(R.string.percent0);
            l1.setAlpha(0);
            l2.setAlpha(0);
            l3.setAlpha(0);
        }
        if (sw_int == 0) {
            swLamp.setChecked(false);
        } else if (sw_int == 1) {
            swLamp.setChecked(true);
        }

        swLamp.setOnClickListener(v -> {
            if (swLamp.isChecked()) {
                MainLampOn(getApplicationContext());
//                PrefConfig.saveKitchenState(getApplicationContext(), 1);
            } else {
                MainLampOff(getApplicationContext());
//                PrefConfig.saveKitchenState(getApplicationContext(), 0);
            }
        });
        // Seek_bar (for changing mode of lights)
        seekBar_lamp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int degree, boolean b) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                light_degree = seekBar.getProgress();
                Thread thread = new Thread(() -> {
                    try {
                        URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("POST");
                        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                        conn.setRequestProperty("Accept", "application/json");
                        conn.setDoOutput(true);
                        conn.setDoInput(true);
                        JSONObject jsonParam = new JSONObject();
                        if (light_degree == 0) {
                            jsonParam.put("command", "three_mode_switch");
                            jsonParam.put("state", "0");
                            jsonParam.put("action", "");
                            txtLightD.setText(R.string.percent0);
                            l1.setAlpha(0);
                            l2.setAlpha(0);
                            l3.setAlpha(0);
                        } else if (light_degree == 1) {
                            jsonParam.put("command", "three_mode_switch");
                            jsonParam.put("state", "1");
                            jsonParam.put("action", "");
                            txtLightD.setText(R.string.percent25);
                            l1.setAlpha(50);
                            l2.setAlpha(50);
                            l3.setAlpha(50);
                        } else if (light_degree == 2) {
                            jsonParam.put("command", "three_mode_switch");
                            jsonParam.put("state", "2");
                            jsonParam.put("action", "");
                            txtLightD.setText(R.string.percent50);
                            l1.setAlpha(75);
                            l2.setAlpha(75);
                            l3.setAlpha(75);
                        } else if (light_degree == 3) {
                            jsonParam.put("command", "three_mode_switch");
                            jsonParam.put("state", "3");
                            jsonParam.put("action", "");
                            txtLightD.setText(R.string.percent100);
                            l1.setAlpha(100);
                            l2.setAlpha(100);
                            l3.setAlpha(100);
                        }
                        Log.i("JSON", jsonParam.toString());
                        DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                        os.writeBytes(jsonParam.toString());
                        os.flush();
                        os.close();
                        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                            conn.disconnect();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                thread.start();
                PrefConfig.saveDimmerState(getApplicationContext(), light_degree);
            }
        });
    }
}