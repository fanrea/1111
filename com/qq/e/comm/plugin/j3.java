package com.qq.e.comm.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class j3 {
    private static final Map<String, v20> a = new ConcurrentHashMap();

    private static int a(int i) {
        if (i == 4 || i == 6) {
            return 302;
        }
        if (i == 14) {
            return 309;
        }
        if (i != 11) {
            return i != 12 ? 999 : 313;
        }
        return 301;
    }

    public static v20 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new v20();
        }
        Map<String, v20> map = a;
        v20 v20Var = map.get(str);
        if (v20Var != null) {
            return v20Var;
        }
        v20 v20Var2 = new v20();
        map.put(str, v20Var2);
        return v20Var2;
    }

    public static void a(int i, int i2, f5 f5Var) throws JSONException {
        h3 h3Var = new h3(f5Var);
        h3Var.g(i2);
        b10.a(i, h3Var, Integer.valueOf(i2), null);
    }

    public static void b(int i, ApkDownloadTask apkDownloadTask) throws JSONException {
        if (i == 0) {
            a(4001009, apkDownloadTask, 0, 0);
        } else {
            if (i == 13 || i == 7 || i == 9) {
                return;
            }
            a(4001006, apkDownloadTask, 3, a(i));
        }
    }

    public static void a(int i, f5 f5Var) {
        b10.a(i, f5Var);
    }

    public static void b(int i, ApkDownloadTask apkDownloadTask, int i2, int i3) throws JSONException {
        a(i, apkDownloadTask, i2, i3, null);
    }

    public static void a(int i, ApkDownloadTask apkDownloadTask) throws JSONException {
        a(i, apkDownloadTask, 0);
    }

    public static void a(int i, ApkDownloadTask apkDownloadTask, long j) throws JSONException {
        ca caVar = new ca(f5.a(apkDownloadTask.v()));
        caVar.b(true);
        if (j > 0) {
            caVar.a(SystemClock.elapsedRealtime() - j);
        }
        b10.a(i, caVar);
    }

    public static void a(int i, int i2, int i3, f5 f5Var) throws JSONException {
        h3 h3Var = new h3(f5Var);
        h3Var.g(i2);
        h3Var.f(i3);
        b10.a(i, h3Var, Integer.valueOf(i2), Integer.valueOf(i3), null);
    }

    public static void a(int i, ApkDownloadTask apkDownloadTask, int i2, int i3) throws JSONException {
        String strR = apkDownloadTask.r();
        h3 h3VarA = a(apkDownloadTask);
        v20 v20VarA = a(strR);
        if (i == 4001011 && v20VarA.c > 0) {
            h3VarA.a(System.currentTimeMillis() - v20VarA.c);
        }
        if (i2 > 0) {
            h3VarA.d(i2);
        }
        if (i3 > 0) {
            h3VarA.e(i3);
        }
        b10.a(i, h3VarA, Integer.valueOf(i2), Integer.valueOf(i3), null);
    }

    public static void a(int i, ApkDownloadTask apkDownloadTask, int i2) throws JSONException {
        b(i, apkDownloadTask, i2, 0);
    }

    public static void a(int i, ApkDownloadTask apkDownloadTask, int i2, int i3, ja jaVar) throws JSONException {
        h3 h3VarA = a(apkDownloadTask);
        if (i2 > 0) {
            h3VarA.d(i2);
        }
        if (i3 > 0) {
            h3VarA.e(i3);
        }
        b10.a(i, h3VarA, Integer.valueOf(i2), Integer.valueOf(i3), jaVar);
    }

    private static h3 a(ApkDownloadTask apkDownloadTask) throws JSONException {
        h3 h3Var = new h3(f5.a(apkDownloadTask.v()));
        v20 v20VarA = a(apkDownloadTask.r());
        h3Var.b(v20VarA.a);
        h3Var.g(v20VarA.b);
        return h3Var;
    }
}
