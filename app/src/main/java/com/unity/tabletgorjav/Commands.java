package com.unity.tabletgorjav;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class Commands {
    static String ip_address, strPort, strZeroParam, strFirstParam, strSecondParam, strHttp;
    //  TV
//    static void tv_power(Context context) {
//        // IP-Address load from pref_config
//        ip_address = PrefConfig.loadIpPref(context);
//        // load data from PrefConfig
//        strPort = PrefConfig.loadPORTPref(context);
//        strZeroParam = PrefConfig.loadZeroParam(context);
//        strFirstParam = PrefConfig.loadFirstParam(context);
//        strSecondParam = PrefConfig.loadSecondParam(context);
//        strHttp = PrefConfig.loadHttpPref(context);
//        String str = strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam;
//        System.out.println(str);
//        Log.e("tv_power onResponse => ", str);
//        Thread thread = new Thread(() -> {
//            try {
//                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.setRequestMethod("POST");
//                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//                conn.setRequestProperty("Accept", "application/json");
//                conn.setDoOutput(true);
//                conn.setDoInput(true);
//                JSONObject jsonParam = new JSONObject();
//                JSONObject json = new JSONObject();
//                JSONArray pin_array = new JSONArray();
//                jsonParam.put("command", "command");
//                jsonParam.put("action", "tvpower");
//                pin_array.put(jsonParam);
//                json.put("command", "tv_remote");
//                json.put("pins", pin_array);
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
    //  AIR CONDITIONER
    static void air_power_on(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
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
                JSONObject json = new JSONObject();
                JSONArray pin_array = new JSONArray();
                jsonParam.put("command", "command");
                jsonParam.put("action", "on");
                pin_array.put(jsonParam);
                json.put("command", "command");
                json.put("pins", pin_array);
                Log.i("JSON", json.toString());
                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                os.writeBytes(json.toString());
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
    }
    static void air_power_off(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
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
                JSONObject json = new JSONObject();
                JSONArray pin_array = new JSONArray();
                jsonParam.put("command", "command");
                jsonParam.put("action", "off");
                pin_array.put(jsonParam);
                json.put("command", "command");
                json.put("pins", pin_array);
                Log.i("JSON", json.toString());
                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                os.writeBytes(json.toString());
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
    }
    //  UNLOCK DOOR WITH FINGERPRINT
    static void fingerPrintLock(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + "/");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept", "application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "smart_door");
                jsonParam.put("state", "1");
                jsonParam.put("action", "");
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
    }
    static void fingerPrintUnLock(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + "/");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept", "application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "smart_door");
                jsonParam.put("state", "0");
                jsonParam.put("action", "");
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
    }
    static void fingerPrintAfterLock(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + "/");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept", "application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "smart_door");
                jsonParam.put("state", "2");
                jsonParam.put("action", "");
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
    }
    //  ON / OFF WATER PUMP
    static void water_on(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + "/");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "water_pump");
                jsonParam.put("state", "1");
                jsonParam.put("action", "");
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
    }
    static void water_off(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + "/");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "water_pump");
                jsonParam.put("state", "0");
                jsonParam.put("action", "");
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
    }
    //  TURN OFF WATER LEAK SENSOR
    static void water_sensor_off(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "water_sensor_van");
                jsonParam.put("state", "0");
                jsonParam.put("action", "");
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
    }   // water leak sensor -> for turn off
    //  TURN OFF GAS LEAK SENSOR
    static void gas_sensor_off(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "gas_sensor");
                jsonParam.put("state", "0");
                jsonParam.put("action", "");
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
    }   // gas leak sensor -> for turn off
    //  TURN OFF GERKON (IF DOOR OPENED) SENSOR
    static void gerKon_sensor_off(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "ping_gerkon");
                jsonParam.put("state", "0");
                jsonParam.put("action", "");
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
    }   // gerKon sensor -> for turn off
    //  CURTAIN
    static void curtain_up(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "curtain");
                jsonParam.put("state", "1");
                jsonParam.put("action", "");
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
    }
    static void curtain_down(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "curtain");
                jsonParam.put("state", "2");
                jsonParam.put("action", "");
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
    }
    static void curtain_stop(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "curtain");
                jsonParam.put("state", "0");
                jsonParam.put("action", "");
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
    }
    //  TURN ON / OFF SOCKETS 1, 2, 3
    static void socket1_on(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
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
                JSONObject json = new JSONObject();
                JSONArray pin_array = new JSONArray();
                jsonParam.put("command", "socket1");
                jsonParam.put("action", "1");
                pin_array.put(jsonParam);
                json.put("command", "socket");
                json.put("pins", pin_array);
                Log.i("JSON", json.toString());
                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                os.writeBytes(json.toString());
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
    }    // Send json data to ESP 8266 module  -> in Browser you can type like [ip_address/control/socket1=1 or socket2=1 or socket3=1 <-> socket1=0 or socket2=0 or socket3=0]
    static void socket1_off(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
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
                JSONObject json = new JSONObject();
                JSONArray pin_array = new JSONArray();
                jsonParam.put("command", "socket1");
                jsonParam.put("action", "0");
                pin_array.put(jsonParam);
                json.put("command", "socket");
                json.put("pins", pin_array);
                Log.i("JSON", json.toString());
                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                os.writeBytes(json.toString());
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
    }
    static void socket2_on(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
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
                JSONObject json = new JSONObject();
                JSONArray pin_array = new JSONArray();
                jsonParam.put("command", "socket2");
                jsonParam.put("action", "1");
                pin_array.put(jsonParam);
                json.put("command", "socket");
                json.put("pins", pin_array);
                Log.i("JSON", json.toString());
                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                os.writeBytes(json.toString());
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
    }
    static void socket2_off(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
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
                JSONObject json = new JSONObject();
                JSONArray pin_array = new JSONArray();
                jsonParam.put("command", "socket2");
                jsonParam.put("action", "0");
                pin_array.put(jsonParam);
                json.put("command", "socket");
                json.put("pins", pin_array);
                Log.i("JSON", json.toString());
                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                os.writeBytes(json.toString());
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
    }
    static void socket3_on(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
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
                JSONObject json = new JSONObject();
                JSONArray pin_array = new JSONArray();
                jsonParam.put("command", "socket3");
                jsonParam.put("action", "1");
                pin_array.put(jsonParam);
                json.put("command", "socket");
                json.put("pins", pin_array);
                Log.i("JSON", json.toString());
                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                os.writeBytes(json.toString());
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
    }
    static void socket3_off(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
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
                JSONObject json = new JSONObject();
                JSONArray pin_array = new JSONArray();
                jsonParam.put("command", "socket3");
                jsonParam.put("action", "0");
                pin_array.put(jsonParam);
                json.put("command", "socket");
                json.put("pins", pin_array);
                Log.i("JSON", json.toString());
                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                os.writeBytes(json.toString());
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
    }
    //  ON / OFF KITCHEN LIGHT
    static void MainLampOn(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "kitchen_light123");
                jsonParam.put("state", "1");
                jsonParam.put("action", "");
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
    }
    static void MainLampOff(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "kitchen_light123");
                jsonParam.put("state", "0");
                jsonParam.put("action", "");
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
    }
    //  ON / OFF ALL ELECTRIC DEVICES
    static void ElectricDeviceON(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "control_tok_command");
                jsonParam.put("state", "1");
                jsonParam.put("action", "");
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
    }
    static void ElectricDeviceOFF(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "control_tok_command");
                jsonParam.put("state", "0");
                jsonParam.put("action", "");
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
    }
    // STOVE => AUTO, MANUAL, FIRST STOVE, SECOND STOVE
    static void ActivatedStove(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
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
                JSONObject json = new JSONObject();
                JSONArray pin_array = new JSONArray();
                jsonParam.put("command", "cooker2");
                jsonParam.put("action", "9");
                pin_array.put(jsonParam);
                json.put("command", "smart_stove");
                json.put("pins", pin_array);
                Log.i("JSON", json.toString());
                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                os.writeBytes(json.toString());
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
    }
    static void InactivatedStove(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
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
                JSONObject json = new JSONObject();
                JSONArray pin_array = new JSONArray();
                jsonParam.put("command", "cooker2");
                jsonParam.put("action", "0");
                pin_array.put(jsonParam);
                json.put("command", "smart_stove");
                json.put("pins", pin_array);
                Log.i("JSON", json.toString());
                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                os.writeBytes(json.toString());
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
    }
    static void FirstStoveOff(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                JSONObject json = new JSONObject();
                JSONArray pin_array = new JSONArray();

                jsonParam.put("command", "cooker1");
                jsonParam.put("action", "0");
                pin_array.put(jsonParam);
                json.put("command", "smart_stove");
                json.put("pins", pin_array);

                Log.i("JSON", json.toString());
                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                os.writeBytes(json.toString());
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
    }
    static void SecondStoveOff(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                JSONObject json = new JSONObject();
                JSONArray pin_array = new JSONArray();

                jsonParam.put("command", "cooker3");
                jsonParam.put("action", "0");
                pin_array.put(jsonParam);
                json.put("command", "smart_stove");
                json.put("pins", pin_array);

                Log.i("JSON", json.toString());
                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                os.writeBytes(json.toString());
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
    }
    //  ON / OFF LIGHT WITH PIR
    static void pir_light_on(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "pir_led_selector_command");
                jsonParam.put("state", "1");
                jsonParam.put("action", "");
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
    }
    static void pir_light_off(Context context) {
        // IP-Address load from pref_config
        ip_address = PrefConfig.loadIpPref(context);
        // load data from PrefConfig
        strPort = PrefConfig.loadPORTPref(context);
        strZeroParam = PrefConfig.loadZeroParam(context);
        strFirstParam = PrefConfig.loadFirstParam(context);
        strSecondParam = PrefConfig.loadSecondParam(context);
        strHttp = PrefConfig.loadHttpPref(context);
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(strHttp + "://" + ip_address + strPort + strZeroParam + strFirstParam + strSecondParam);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("command", "pir_led_selector_command");
                jsonParam.put("state", "0");
                jsonParam.put("action", "");
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
    }



//    public static void tvPower(Context context) {
//        RequestQueue queue = Volley.newRequestQueue(context);
//        String url = "http://192.168.1.17/control/?command=tvpower";
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                response -> Log.e("RESPONSE => ", "DOOR UNLOCK => " + response.substring(0, 10)), error -> Log.e("RESPONSE => ", "DOOR UNLOCK ERROR"));
//        queue.add(stringRequest);
//    }
//    public static void satOk(Context context) {
//        RequestQueue queue = Volley.newRequestQueue(context);
//        String url = "http://192.168.1.17/control/?command=satok";
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                response -> Log.e("RESPONSE => ", "DOOR UNLOCK => " + response.substring(0, 10)), error -> Log.e("RESPONSE => ", "DOOR UNLOCK ERROR"));
//        queue.add(stringRequest);
//    }
//    public static void tv_menu(Context context) {
//        RequestQueue queue = Volley.newRequestQueue(context);
//        String url = "http://192.168.1.17/control/?command=menu";
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                response -> Log.e("RESPONSE => ", "DOOR UNLOCK => " + response.substring(0, 10)), error -> Log.e("RESPONSE => ", "DOOR UNLOCK ERROR"));
//        queue.add(stringRequest);
//    }
//    public static void tv_exit(Context context) {
//        RequestQueue queue = Volley.newRequestQueue(context);
//        String url = "http://192.168.1.17/control/?command=exit";
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                response -> Log.e("RESPONSE => ", "DOOR UNLOCK => " + response.substring(0, 10)), error -> Log.e("RESPONSE => ", "DOOR UNLOCK ERROR"));
//        queue.add(stringRequest);
//    }
//    public static void tv_mute(Context context) {
//        RequestQueue queue = Volley.newRequestQueue(context);
//        String url = "http://192.168.1.17/control/?command=mute";
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                response -> Log.e("RESPONSE => ", "DOOR UNLOCK => " + response.substring(0, 10)), error -> Log.e("RESPONSE => ", "DOOR UNLOCK ERROR"));
//        queue.add(stringRequest);
//    }
//    public static void upVolume(Context context) {
//        RequestQueue queue = Volley.newRequestQueue(context);
//        String url = "http://192.168.1.17/control/?command=upvolume";
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                response -> Log.e("RESPONSE => ", "DOOR UNLOCK => " + response.substring(0, 10)), error -> Log.e("RESPONSE => ", "DOOR UNLOCK ERROR"));
//        queue.add(stringRequest);
//    }
//    public static void volumeDown(Context context) {
//        RequestQueue queue = Volley.newRequestQueue(context);
//        String url = "http://192.168.1.17/control/?command=volumedown";
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                response -> Log.e("RESPONSE => ", "DOOR UNLOCK => " + response.substring(0, 10)), error -> Log.e("RESPONSE => ", "DOOR UNLOCK ERROR"));
//        queue.add(stringRequest);
//    }
//    public static void tv_up(Context context) {
//        RequestQueue queue = Volley.newRequestQueue(context);
//        String url = "http://192.168.1.17/control/?command=up";
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                response -> Log.e("RESPONSE => ", "DOOR UNLOCK => " + response.substring(0, 10)), error -> Log.e("RESPONSE => ", "DOOR UNLOCK ERROR"));
//        queue.add(stringRequest);
//    }
//    public static void tv_down(Context context) {
//        RequestQueue queue = Volley.newRequestQueue(context);
//        String url = "http://192.168.1.17/control/?command=down";
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                response -> Log.e("RESPONSE => ", "DOOR UNLOCK => " + response.substring(0, 10)), error -> Log.e("RESPONSE => ", "DOOR UNLOCK ERROR"));
//        queue.add(stringRequest);
//    }
//    public static void right(Context context) {
//        RequestQueue queue = Volley.newRequestQueue(context);
//        String url = "http://192.168.1.17/control/?command=right";
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                response -> Log.e("RESPONSE => ", "DOOR UNLOCK => " + response.substring(0, 10)), error -> Log.e("RESPONSE => ", "DOOR UNLOCK ERROR"));
//        queue.add(stringRequest);
//    }
//    public static void left(Context context) {
//        RequestQueue queue = Volley.newRequestQueue(context);
//        String url = "http://192.168.1.17/control/?command=left";
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                response -> Log.e("RESPONSE => ", "DOOR UNLOCK => " + response.substring(0, 10)), error -> Log.e("RESPONSE => ", "DOOR UNLOCK ERROR"));
//        queue.add(stringRequest);
//    }


    public static void tvUp(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.17/control/?command=up";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }
    public static void tvDown(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.17/control/?command=down";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }

    public static void satOk(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.17/control/?command=satok";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }

    public static void tvPower(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.17/control/?command=tvpower";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }

    public static void tvMute(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.17/control/?command=mute";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }

    public static void tvVolumeDown(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.17/control/?command=volumedown";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }

    public static void tvUpVolume(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.17/control/?command=upvolume";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }

    public static void tvMenu(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.17/control/?command=menu";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }

    public static void tvExit(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.17/control/?command=exit";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }

    public static void tvRight(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.17/control/?command=right";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }

    public static void tvLeft(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.17/control/?command=left";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }


    public static void acOn(Context context) {
        ip_address = PrefConfig.loadIpPref(context);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.177/control/?command=on";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    // Display the first 500 characters of the response string.
                    Log.e("RESPONSE => ", "ENGINE START => ");
                }, error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
    public static void acOff(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.177/control/?command=off";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }

    public static void swingOn(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.177/control/?command=swingon";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }

    public static void swingOff(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.177/control/?command=swingoff";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }

    public static void acNum(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.177/control/?command=22";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }
    public static void acCold(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.177/control/?command=cold";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }
    public static void acFanUp(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.177/control/?command=high";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }
    public static void acFanDown(Context context) {
        ip_address = PrefConfig.loadIpPref(context);
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.177/control/?command=low";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> Log.e("RESPONSE => ", "ENGINE START => "), error -> Log.e("RESPONSE => ", "ENGINE START ERROR"));
        queue.add(stringRequest);
    }

}