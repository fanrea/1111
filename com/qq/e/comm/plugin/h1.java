package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class h1 {
    private static final int a = r1.d().f().a("depml", 1000);

    public static String a(Map<String, String> map, int i) {
        if (map != null && !map.isEmpty()) {
            try {
                String string = new JSONObject(map).toString();
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                int length = string.length();
                int i2 = a;
                if (length <= i2) {
                    return string;
                }
                ja jaVar = new ja();
                jaVar.a("msg", string);
                jaVar.a("data", Integer.valueOf(string.length()));
                b10.a(9720001, null, Integer.valueOf(i), Integer.valueOf(i2), jaVar);
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return null;
    }
}
