package com.bytedance.msdk.gb;

import android.text.TextUtils;
import com.baidu.mobads.container.util.cm;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static Random d = new SecureRandom();

    public static JSONObject d(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String strD = d(jSONObject.toString());
                if (!TextUtils.isEmpty(strD)) {
                    jSONObject2.put(cm.V, strD);
                    jSONObject2.put("cypher", 3);
                } else {
                    jSONObject2.put(cm.V, jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject2.put(cm.V, jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        } catch (Throwable th) {
            com.bytedance.msdk.d.u.b.d(th.getMessage());
        }
        return jSONObject2;
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strD = d();
        String strD2 = d(strD, 32);
        String strHc = hc();
        String strD3 = null;
        if (strD2 != null && strHc != null) {
            strD3 = d.d(str, strHc, strD2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(3).append(strD).append(strHc).append(strD3);
        return sb.toString();
    }

    public static String d() {
        String strD = d(16);
        if (strD == null || strD.length() != 32) {
            return null;
        }
        return strD;
    }

    public static String d(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String hc() {
        String strD = d(8);
        if (strD == null || strD.length() != 16) {
            return null;
        }
        return strD;
    }

    public static String d(int i) {
        try {
            byte[] bArr = new byte[i];
            d.nextBytes(bArr);
            return uo.d(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
