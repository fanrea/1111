package com.qq.e.comm.plugin;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kuaishou.android.live.network.ApiStatus;
import com.qq.e.comm.plugin.callback.biz.VideoDownloadErrorCallback;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class k {
    private static final ConcurrentHashMap<String, Long> a = new ConcurrentHashMap<>();
    private static volatile int b = -1;

    public static int a() {
        return 1;
    }

    private static boolean b(int i) {
        return i == 46;
    }

    private static boolean c(int i) {
        return i == 3;
    }

    public static void g(h4 h4Var) {
        if (b == -1) {
            b = r1.d().f().a("vdende", 1);
        }
        if (b != 1 || h4Var == null) {
            return;
        }
        ((VideoDownloadErrorCallback) x5.b(h4Var.s0(), VideoDownloadErrorCallback.class)).y().a();
    }

    public static List<JSONObject> a(JSONArray jSONArray, j jVar) {
        return a(jSONArray, jVar, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00c9 A[Catch: all -> 0x00f7, TryCatch #1 {all -> 0x00f7, blocks: (B:43:0x00ae, B:50:0x00c9, B:51:0x00cb, B:59:0x00df, B:47:0x00bb, B:48:0x00c3), top: B:89:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00df A[Catch: all -> 0x00f7, TRY_LEAVE, TryCatch #1 {all -> 0x00f7, blocks: (B:43:0x00ae, B:50:0x00c9, B:51:0x00cb, B:59:0x00df, B:47:0x00bb, B:48:0x00c3), top: B:89:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<org.json.JSONObject> a(org.json.JSONArray r18, com.qq.e.comm.plugin.j r19, boolean[] r20, com.qq.e.comm.plugin.w1 r21) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.k.a(org.json.JSONArray, com.qq.e.comm.plugin.j, boolean[], com.qq.e.comm.plugin.w1):java.util.List");
    }

    public static boolean d(h4 h4Var) {
        if (h4Var == null) {
            return false;
        }
        return b(h4Var.B0());
    }

    public static boolean f(h4 h4Var) {
        if (h4Var == null) {
            return false;
        }
        return c(h4Var.n0());
    }

    public static boolean e(h4 h4Var) {
        if (h4Var == null) {
            return false;
        }
        return d(h4Var) || f(h4Var);
    }

    public static long b(h4 h4Var) {
        return a(h4Var) + (a(h4Var.f(), a(h4Var.y0(), h4Var.x0(), h4Var.k())) * 60 * 1000);
    }

    public static boolean c(h4 h4Var) {
        return a(b(h4Var));
    }

    @Deprecated
    public static boolean d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return b(jSONObject.optInt("producttype"));
    }

    @Deprecated
    public static boolean f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return c(jSONObject.optInt("mini_program_type"));
    }

    public static boolean b(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt("producttype") == 1000;
    }

    public static boolean b() {
        if (b == -1) {
            b = r1.d().f().a("vdende", 1);
        }
        return b == 1;
    }

    @Deprecated
    public static boolean e(JSONObject jSONObject) {
        return d(jSONObject) || f(jSONObject);
    }

    public static boolean c(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt("producttype") == 30;
    }

    public static int a(String str, ku kuVar, e2 e2Var) {
        return xb.a(e2Var, str, kuVar);
    }

    public static int a(int i, int i2) {
        if (i2 > 0 && i > 0) {
            return Math.min(i2, i);
        }
        if (i2 > 0) {
            return i2;
        }
        if (i > 0) {
            return i;
        }
        return 1560;
    }

    public static long a(h4 h4Var) {
        if (h4Var == null) {
            return SystemClock.elapsedRealtime();
        }
        long jD = h4Var.d();
        if (h4Var.s1() && jD <= System.currentTimeMillis()) {
            return (jD - System.currentTimeMillis()) + SystemClock.elapsedRealtime();
        }
        return SystemClock.elapsedRealtime();
    }

    public static int a(Context context, JSONObject jSONObject) {
        boolean zD = y.d(jSONObject);
        boolean zA = a(jSONObject);
        boolean zB = b(jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ext");
        String strC = null;
        String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString(ILogConst.Keys.KEY_PKG_NAME) : null;
        boolean z = zB && !TextUtils.isEmpty(strOptString);
        if (!zD && !zA && !z) {
            return 0;
        }
        if (zD) {
            strC = y.c(jSONObject);
        } else if (zA) {
            strC = "com.jingdong.app.mall";
        } else if (z) {
            strC = strOptString;
        }
        boolean zB2 = q.b(context, strC);
        int iOptInt = jSONObject.optInt("reltarget");
        if (zB2 && iOptInt == 1) {
            return 2;
        }
        return (zB2 || iOptInt != 2) ? 0 : 1;
    }

    public static boolean a(String str) {
        String strE = fo.e();
        String strD = fo.d();
        String host = Uri.parse(str).getHost();
        return host.equals(Uri.parse("https://mi.gdt.qq.com/").getHost()) || (!TextUtils.isEmpty(strE) && host.equals(Uri.parse(strE).getHost())) || (!TextUtils.isEmpty(strD) && host.equals(Uri.parse(strD).getHost()));
    }

    public static boolean a(long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime <= j || j <= 0) {
            return false;
        }
        long j2 = jElapsedRealtime - j;
        GDTLogger.e(String.format("当前时间: %s, 广告有效期: %s, 已过期 %s:%s:%s，请重新拉取广告", Long.valueOf(jElapsedRealtime), Long.valueOf(j), Long.valueOf(j2 / 3600000), Long.valueOf((j2 / 60000) % 60), Long.valueOf((j2 / 1000) % 60)));
        return true;
    }

    public static boolean a(Context context, h4 h4Var) {
        if (h4Var.k1()) {
            if (n.a().d(context, h4Var.o().e()) == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt("producttype") == 25;
    }

    public static boolean a(int i) {
        return i != 0 ? i != 2 : r1.d().c().p() == zr.WIFI;
    }

    private static void a(j jVar, JSONArray jSONArray, JSONObject jSONObject, String str, boolean z, int i, w1 w1Var) throws Throwable {
        int i2;
        ja jaVar = new ja();
        jaVar.a(com.sigmob.sdk.base.n.p, str);
        jaVar.a(com.alipay.sdk.m.t.a.k, System.currentTimeMillis() + "");
        jaVar.a("install_status", z ? "1" : "0");
        jaVar.a("plc", sx.a(jVar));
        jSONArray.put(jaVar);
        f5 f5Var = new f5();
        f5Var.c(jVar.b());
        f5Var.a(jVar.a());
        String strOptString = jSONObject.optString("cl");
        f5Var.a(strOptString);
        f5Var.a(jSONObject);
        f5Var.b(jSONObject.optInt("producttype"));
        String str2 = jVar.b() + Config.replace + strOptString;
        long jCurrentTimeMillis = System.currentTimeMillis();
        ConcurrentHashMap<String, Long> concurrentHashMap = a;
        Long l = concurrentHashMap.get(str2);
        if (l == null) {
            i2 = ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG;
        } else {
            long jLongValue = jCurrentTimeMillis - l.longValue();
            if (jLongValue <= 60000) {
                i2 = ((int) (jLongValue / 1000)) + 1;
            } else {
                i2 = ((int) ((jLongValue / 60000) * (-1))) - 1;
            }
        }
        concurrentHashMap.put(str2, Long.valueOf(jCurrentTimeMillis));
        b10.a(100202, f5Var, Integer.valueOf(i), Integer.valueOf(i2), jaVar);
        if (w1Var == null || !jVar.a().k()) {
            return;
        }
        b10.a(1400015, f5Var, Integer.valueOf((w1Var.B() != 0 ? 2 : 1) + (i * 10)), Integer.valueOf(i2), jaVar);
    }
}
