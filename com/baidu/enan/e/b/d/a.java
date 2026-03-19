package com.baidu.enan.e.b.d;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.baidu.enan.f.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static String a(Context context) {
        try {
            Map<String, String> mapA = a(context, -1);
            if (mapA != null && mapA.size() > 0) {
                StringBuffer stringBuffer = new StringBuffer();
                for (Map.Entry<String, String> entry : mapA.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                        stringBuffer.append(key);
                        stringBuffer.append("#");
                        stringBuffer.append(value);
                        stringBuffer.append(i.b);
                    }
                }
                return stringBuffer.toString();
            }
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
        }
        return "";
    }

    public static Map<String, String> a(Context context, int i) {
        try {
            HashMap map = new HashMap();
            List<Sensor> sensorList = ((SensorManager) context.getSystemService("sensor")).getSensorList(i);
            if (sensorList == null) {
                return null;
            }
            for (Sensor sensor : sensorList) {
                if (sensor != null) {
                    String name = sensor.getName();
                    String vendor = sensor.getVendor();
                    int type = sensor.getType();
                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(vendor)) {
                        map.put(name, vendor + "," + type);
                    }
                }
            }
            return map;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }
}
