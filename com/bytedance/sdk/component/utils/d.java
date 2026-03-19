package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.util.cm;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {

    /* renamed from: com.bytedance.sdk.component.utils.d$d, reason: collision with other inner class name */
    static class C0288d {
        static final Random d = d.b();
    }

    public static JSONObject d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        return d(jSONObject.toString());
    }

    public static JSONObject d(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            try {
                String strHc = hc(str);
                if (!TextUtils.isEmpty(strHc)) {
                    jSONObject.put(cm.V, strHc);
                    jSONObject.put("cypher", 3);
                } else {
                    jSONObject.put(cm.V, str);
                    jSONObject.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject.put(cm.V, str);
                jSONObject.put("cypher", 0);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return jSONObject;
    }

    public static String hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strD = d();
        String strD2 = d(strD, 32);
        String strHc = hc();
        String strD3 = null;
        if (strD2 != null && strHc != null) {
            strD3 = com.bytedance.sdk.component.u.d.d(str, strHc, strD2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(3).append(strD).append(strHc).append(strD3);
        return sb.toString();
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strD = d(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strD == null) ? str : com.bytedance.sdk.component.u.d.hc(str.substring(49), strSubstring, strD);
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
            C0288d.d.nextBytes(bArr);
            return u.d(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Random b() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }
}
