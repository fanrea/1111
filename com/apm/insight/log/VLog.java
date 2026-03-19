package com.apm.insight.log;

import android.content.Context;
import com.apm.insight.log.VLogConfig;
import com.apm.insight.log.a.f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class VLog {
    private static boolean a = false;
    private static Object b = new Object();

    public static void init(Context context, int i) throws Throwable {
        synchronized (b) {
            if (a) {
                return;
            }
            a = true;
            a.a(new VLogConfig.Builder(context).setMaxDirSize((i << 10) << 10).setOffloadMainThreadWrite(true).build());
        }
    }

    public static void v(String str, String str2) {
        a.a(str, str2);
    }

    public static void d(String str, String str2) {
        a.b(str, str2);
    }

    public static void i(String str, String str2) {
        a.c(str, str2);
    }

    public static void w(String str, String str2) {
        a.d(str, str2);
    }

    public static void e(String str, String str2) {
        a.e(str, str2);
    }

    public static void changeLevel(int i) {
        a.a(i);
    }

    public static void flush() {
        a.a();
    }

    public static List<String> getLogFiles(long j, long j2) {
        ArrayList arrayList = new ArrayList();
        try {
            File[] fileArrA = f.a((String) null, (String) null, j * 1000, j2 * 1000);
            for (File file : fileArrA) {
                arrayList.add(file.getAbsolutePath());
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static List<String> getLogFiles(boolean z, long j, long j2, int i) {
        ArrayList arrayList = new ArrayList();
        try {
            for (File file : f.a(z, j * 1000, j2 * 1000, i)) {
                arrayList.add(file.getAbsolutePath());
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static HashMap<String, String> getLastFetchErrorInfo() {
        return a.b();
    }

    public static void destroy() {
        a.c();
    }

    public static void release() {
        a.d();
    }

    public static ILog createInstance(VLogConfig vLogConfig, String str) {
        ILog vLog = getInstance(str);
        return vLog != null ? vLog : a.a(str, vLogConfig);
    }

    public static ILog getInstance(String str) {
        return a.a(str);
    }
}
