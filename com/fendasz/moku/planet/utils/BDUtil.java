package com.fendasz.moku.planet.utils;

import android.content.Context;
import android.util.Log;
import com.alipay.sdk.m.s.a;
import com.fendasz.moku.planet.entity.UserDeviceInfo;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.source.bean.BaiduConfigData;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class BDUtil {
    private static final String BD_GEOCODING = "https://api.map.baidu.com/reverse_geocoding/v3/";
    private static final String BD_GEOCODING_SN = "https://api.map.baidu.com/reverse_geocoding/v3?";
    private static final String SP_BD_AK_KEY = "moku_sp_bd_ak_key";
    private static final String SP_BD_ENABLE_KEY = "moku_sp_bd_enable_key";
    private static final String SP_BD_SK_KEY = "moku_sp_bd_sk_key";
    private static final String TAG = "BDUtil=>";
    private static BDUtil bdUtil;
    private static boolean isInitConfig;

    private BDUtil() {
    }

    public static synchronized BDUtil getInstance() {
        if (bdUtil == null) {
            bdUtil = new BDUtil();
        }
        return bdUtil;
    }

    public boolean isInitConfig() {
        Log.d(TAG, "isInitConfig:" + isInitConfig);
        return isInitConfig;
    }

    public void putConfig(Context context, BaiduConfigData baiduConfigData) {
        isInitConfig = true;
        SharedPreferencesUtils.getInstance(context).putBoolean(SP_BD_ENABLE_KEY, baiduConfigData.getEnable().booleanValue());
        SharedPreferencesUtils.getInstance(context).putString(SP_BD_AK_KEY, baiduConfigData.getAppKey());
        SharedPreferencesUtils.getInstance(context).putString(SP_BD_SK_KEY, baiduConfigData.getSk());
    }

    public void setUnable(Context context) throws NoSuchMethodException, SecurityException {
        isInitConfig = true;
        SharedPreferencesUtils.getInstance(context).putBoolean(SP_BD_ENABLE_KEY, false);
        UserDeviceInfo userDeviceInfo = MokuConfigure.getInstance().getUserDeviceInfo(context);
        if (userDeviceInfo != null) {
            userDeviceInfo.setLongitudeAndLatitudeAddress(null);
        }
    }

    public boolean isEnable(Context context) {
        return SharedPreferencesUtils.getInstance(context).getBoolean(SP_BD_ENABLE_KEY, false);
    }

    public String bdLocation(Context context, String str, String str2) {
        String string;
        if (!isEnable(context) || (string = SharedPreferencesUtils.getInstance(context).getString(SP_BD_AK_KEY, null)) == null) {
            return null;
        }
        return queryLocationGeocoder(str, str2, string);
    }

    public String bdLocationWithSN(Context context, String str, String str2) {
        try {
            if (isEnable(context)) {
                String string = SharedPreferencesUtils.getInstance(context).getString(SP_BD_AK_KEY, null);
                String string2 = SharedPreferencesUtils.getInstance(context).getString(SP_BD_SK_KEY, null);
                if (string != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("ak", string);
                    linkedHashMap.put("output", "json");
                    linkedHashMap.put("coordtype", "wgs84ll");
                    linkedHashMap.put("extensions_poi", "0");
                    linkedHashMap.put("location", str2 + "," + str);
                    linkedHashMap.put("sn", caculateSn(string, string2, str, str2));
                    return requestGetSN(BD_GEOCODING_SN, linkedHashMap);
                }
            }
        } catch (Exception unused) {
            LogUtils.logE(TAG, "bdLocationWithSN error");
        }
        return null;
    }

    private String queryLocationGeocoder(String str, String str2, String str3) throws Throwable {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", str3);
        treeMap.put("location", str2 + "," + str);
        treeMap.put("extensions_poi", "0");
        treeMap.put("output", "json");
        treeMap.put("language_auto", "0");
        String strSendGet = HttpUtil.sendGet(BD_GEOCODING, treeMap);
        Log.d(TAG, "locationGeocoder_result=>" + strSendGet);
        if (StringUtils.isEmpty(strSendGet)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strSendGet);
            if (jSONObject.optInt("status") != 0 || (jSONObjectOptJSONObject = jSONObject.optJSONObject("result")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("addressComponent")) == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder(128);
            sb.append(jSONObjectOptJSONObject2.optString("country"));
            sb.append(jSONObjectOptJSONObject2.optString("province"));
            sb.append(jSONObjectOptJSONObject2.optString("city"));
            sb.append(jSONObjectOptJSONObject2.optString("district"));
            return sb.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String requestGetSN(String str, Map<String, String> map) throws Exception {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        if (str != null && str.length() > 0 && map != null && map.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                stringBuffer.append(((Object) entry.getKey()) + "=");
                stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8").replace("+", "%20") + a.n);
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            URL url = new URL(stringBuffer.toString());
            System.out.println(stringBuffer.toString());
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10);
            httpURLConnection.setReadTimeout(10);
            httpURLConnection.connect();
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer2 = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer2.append(line);
            }
            bufferedReader.close();
            inputStreamReader.close();
            String string = stringBuffer2.toString();
            if (!StringUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    if (jSONObject.optInt("status") == 0 && (jSONObjectOptJSONObject = jSONObject.optJSONObject("result")) != null && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("addressComponent")) != null) {
                        StringBuilder sb = new StringBuilder(128);
                        sb.append(jSONObjectOptJSONObject2.optString("country"));
                        sb.append(jSONObjectOptJSONObject2.optString("province"));
                        sb.append(jSONObjectOptJSONObject2.optString("city"));
                        sb.append(jSONObjectOptJSONObject2.optString("district"));
                        return sb.toString();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public String caculateSn(String str, String str2, String str3, String str4) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ak", str);
        linkedHashMap.put("output", "json");
        linkedHashMap.put("coordtype", "wgs84ll");
        linkedHashMap.put("extensions_poi", "0");
        linkedHashMap.put("location", str4 + "," + str3);
        String str5 = new String("/reverse_geocoding/v3?" + toQueryString(linkedHashMap) + str2);
        System.out.println(str5);
        String strMD5 = MD5(URLEncoder.encode(str5, "UTF-8"));
        System.out.println(strMD5);
        return strMD5;
    }

    public String toQueryString(Map<?, ?> map) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey() + "=");
            stringBuffer.append(URLEncoder.encode((String) entry.getValue(), "UTF-8").replace("+", "%20") + a.n);
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public String MD5(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                stringBuffer.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
