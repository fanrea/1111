package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class xm {
    private static final b a = new n30();
    private static final b b = new s10();
    private static final Map<e2, JSONObject> c = new HashMap(4);
    private static final Map<e2, JSONObject> d = new HashMap(4);

    /* compiled from: A */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e2.values().length];
            a = iArr;
            try {
                iArr[e2.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e2.UNIFIED_INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e2.NATIVEEXPRESSAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[e2.UNIFIED_BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[e2.REWARDVIDEOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[e2.UNIFIED_INTERSTITIAL_FULLSCREEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[e2.NATIVEUNIFIEDAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: A */
    interface b {
        String a();

        String b();

        String c();

        String d();

        String e();

        String f();

        String g();
    }

    private static Map<e2, JSONObject> a(boolean z) {
        if (z) {
            return d;
        }
        return c;
    }

    static String a(e2 e2Var, String str, int i) {
        int i2 = 0;
        boolean z = str.length() == 6;
        Map<e2, JSONObject> mapA = a(z);
        JSONObject jSONObject = mapA.get(e2Var);
        int i3 = 20;
        if (jSONObject == null) {
            try {
                String strA = a(e2Var, z);
                if (TextUtils.isEmpty(strA)) {
                    i2 = 10;
                } else if ('{' != strA.charAt(0)) {
                    i2 = 5;
                } else {
                    jSONObject = new JSONObject(strA);
                }
            } catch (JSONException unused) {
                i2 = 20;
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            mapA.put(e2Var, jSONObject);
        }
        String strOptString = jSONObject.optString(str);
        if (TextUtils.isEmpty(strOptString)) {
            if (i2 != 0) {
                i3 = i2;
            } else if (jSONObject.length() != 0) {
                i3 = 13;
            }
            qc qcVar = new qc(1190024);
            qcVar.c(i);
            qcVar.d(i3);
            qcVar.a(new f5().a(e2Var).a(!z).d(str));
            b10.a(qcVar);
        }
        return strOptString;
    }

    static String a(e2 e2Var, boolean z) {
        b bVar = z ? b : a;
        switch (a.a[e2Var.ordinal()]) {
            case 1:
                return bVar.g();
            case 2:
                return bVar.f();
            case 3:
                return bVar.b();
            case 4:
                return bVar.a();
            case 5:
                return bVar.d();
            case 6:
                return bVar.c();
            case 7:
                return bVar.e();
            default:
                return "{}";
        }
    }
}
