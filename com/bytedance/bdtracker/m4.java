package com.bytedance.bdtracker;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.util.HardwareUtils;
import com.bytedance.applog.util.SensitiveUtils;
import com.bytedance.bdtracker.l0;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class m4 implements q4 {
    public static String h;
    public static String i;
    public static String j;
    public static JSONArray k;
    public static volatile String l;
    public static String[] m;
    public static String n;
    public final Context a;
    public u3 b;
    public final s3 c;
    public final String d;
    public final d e;
    public final q1 f;
    public final List<String> g = Collections.singletonList("DeviceParamsProvider");

    public m4(d dVar, Context context, q1 q1Var, s3 s3Var) {
        this.e = dVar;
        this.f = q1Var;
        this.d = q1Var.c.getLocalTest() ? "_local" : "";
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        l4 l4Var = new l4();
        this.c = s3Var;
        f4 f4Var = new f4(applicationContext, "snssdk_openudid", q1Var.c.getSpName());
        this.b = f4Var;
        f4Var.a = s3Var;
        if (!q1Var.c.getAnonymous()) {
            new Thread(new k4(l4Var)).start();
        }
        a(q1Var.c.getAccount());
    }

    public void a(Account account) {
        s3 s3Var = this.c;
        if (s3Var != null) {
            s3Var.a(account);
        }
    }

    public void a(String str) {
        this.b.a(str);
        this.e.D.debug(this.g, "DeviceParamsProvider#clear clearKey=" + str + " sDeviceId=" + l, new Object[0]);
    }

    public String b() {
        if (!TextUtils.isEmpty(l)) {
            return l;
        }
        l = this.b.c("", "");
        return l;
    }

    public void b(String str) {
        if (!l0.b.a(str) || l0.b.a(str, l)) {
            return;
        }
        l = this.b.c(str, l);
    }

    public String c() {
        if (!TextUtils.isEmpty(h)) {
            return h;
        }
        q1 q1Var = this.f;
        String secureAndroidId = !(q1Var.c.isAndroidIdEnabled() && !q1Var.a("openudid")) ? "" : HardwareUtils.getSecureAndroidId(this.a);
        try {
            if (!l0.b.e(secureAndroidId) || "9774d56d682e549c".equals(secureAndroidId)) {
                SharedPreferences sharedPreferencesA = f4.a(this.a, "snssdk_openudid", 0);
                String string = sharedPreferencesA.getString("openudid", null);
                if (l0.b.e(string)) {
                    this.c.d(string, null);
                    secureAndroidId = string;
                } else {
                    String string2 = new BigInteger(80, new SecureRandom()).toString(16);
                    if (string2.charAt(0) == '-') {
                        string2 = string2.substring(1);
                    }
                    int length = 13 - string2.length();
                    if (length > 0) {
                        StringBuilder sb = new StringBuilder();
                        while (length > 0) {
                            sb.append('F');
                            length--;
                        }
                        sb.append(string2);
                        string2 = sb.toString();
                    }
                    SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                    editorEdit.putString("openudid", string2);
                    editorEdit.apply();
                    secureAndroidId = string2;
                }
            } else {
                secureAndroidId = this.b.d(null, secureAndroidId);
            }
        } catch (Throwable th) {
            this.e.D.error(this.g, "getOpenUdid failed", th, new Object[0]);
        }
        if (!TextUtils.isEmpty(secureAndroidId)) {
            secureAndroidId = a.a(secureAndroidId).append(this.d).toString();
        }
        if (!TextUtils.isEmpty(secureAndroidId)) {
            h = secureAndroidId;
        }
        return secureAndroidId;
    }

    public String d() {
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        try {
            String strE = this.b.e(null, SensitiveUtils.getSerialNumber(this.a));
            if (!TextUtils.isEmpty(strE)) {
                strE = strE + this.d;
            }
            n = strE;
            return strE;
        } catch (Throwable th) {
            this.e.D.error(this.g, "getSerialNumber failed", th, new Object[0]);
            return null;
        }
    }

    public String[] e() {
        String[] strArr = m;
        if (strArr != null && strArr.length > 0) {
            return strArr;
        }
        try {
            String[] strArrA = this.b.a((String[]) null, SensitiveUtils.getSimSerialNumbers(this.a));
            if (strArrA == null) {
                strArrA = new String[0];
            }
            for (int i2 = 0; i2 < strArrA.length; i2++) {
                strArrA[i2] = strArrA[i2] + this.d;
            }
            m = strArrA;
            return strArrA;
        } catch (Throwable th) {
            this.e.D.error(this.g, "getSimSerialNumbers failed", th, new Object[0]);
            return null;
        }
    }

    public String f() {
        if (!TextUtils.isEmpty(j)) {
            return j;
        }
        try {
            q1 q1Var = this.f;
            String strF = this.b.f(null, q1Var.c.isImeiEnable() && !q1Var.a("IMEI") ? SensitiveUtils.getDeviceId(this.a) : this.f.c.getAppImei());
            if (!TextUtils.isEmpty(strF)) {
                strF = strF + this.d;
            }
            j = strF;
            return strF;
        } catch (Throwable th) {
            this.e.D.error(this.g, "getUdId failed", th, new Object[0]);
            return null;
        }
    }

    public JSONArray g() {
        JSONArray jSONArray = k;
        if (jSONArray != null) {
            return jSONArray;
        }
        try {
            q1 q1Var = this.f;
            if (!(q1Var.c.isImeiEnable() && !q1Var.a("IMEI"))) {
                return new JSONArray();
            }
            JSONArray multiImeiFromSystem = SensitiveUtils.getMultiImeiFromSystem(this.a);
            if (multiImeiFromSystem == null) {
                multiImeiFromSystem = SensitiveUtils.getMultiImeiFallback(this.a);
            }
            JSONArray jSONArray2 = new JSONArray(this.b.g(null, multiImeiFromSystem.toString()));
            if (!TextUtils.isEmpty(this.d)) {
                String str = this.d;
                if (jSONArray2.length() != 0) {
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(i2);
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString = jSONObjectOptJSONObject.optString("id");
                            if (!TextUtils.isEmpty(strOptString)) {
                                jSONObjectOptJSONObject.remove("id");
                                jSONObjectOptJSONObject.put("id", strOptString + str);
                            }
                        }
                    }
                }
            }
            k = jSONArray2;
            return jSONArray2;
        } catch (Throwable th) {
            this.e.D.error(this.g, "getUdIdList failed", th, new Object[0]);
            return null;
        }
    }

    public String a() {
        if (!TextUtils.isEmpty(i)) {
            return i;
        }
        try {
            SharedPreferences sharedPreferencesA = f4.a(this.a, "snssdk_openudid", 0);
            String string = sharedPreferencesA.getString("clientudid", null);
            if (l0.b.e(string)) {
                this.c.b(string, null);
            } else {
                string = UUID.randomUUID().toString();
                SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                editorEdit.putString("clientudid", string);
                editorEdit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                string = string + this.d;
            }
            i = string;
            return string;
        } catch (Throwable th) {
            this.e.D.error(this.g, "getClientUDID failed", th, new Object[0]);
            return "";
        }
    }
}
