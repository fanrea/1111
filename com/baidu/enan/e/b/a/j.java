package com.baidu.enan.e.b.a;

import android.os.Build;
import android.view.InputDevice;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j {
    public static String a() throws JSONException {
        try {
            int[] deviceIds = InputDevice.getDeviceIds();
            JSONArray jSONArray = new JSONArray();
            for (int i : deviceIds) {
                InputDevice device = InputDevice.getDevice(i);
                if (device != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", device.getName());
                    jSONObject.put("1", device.isVirtual() ? 1 : 0);
                    if (Build.VERSION.SDK_INT >= 19) {
                        jSONObject.put("2", device.getVendorId());
                    }
                    jSONObject.put("3", device.getSources());
                    String string = device.toString();
                    jSONObject.put("4", string.indexOf("Location: built-in") > 0 ? 1 : string.indexOf("Location: external") > 0 ? 2 : 0);
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray.toString().replace("   ", "");
        } catch (Exception e) {
            com.baidu.enan.f.b.a(e);
            return "";
        }
    }
}
