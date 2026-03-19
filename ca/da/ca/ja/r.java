package ca.da.ca.ja;

import android.content.Context;
import android.util.Log;
import com.apm.applog.ILogger;

/* compiled from: TLog.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class r {
    public static ILogger a = null;
    public static boolean b = false;
    public static final int c;

    static {
        if (String.valueOf(10890).charAt(0) >= '4') {
            c = 10010489;
        } else {
            c = 10890;
        }
    }

    public static void a(Context context, ILogger iLogger) {
        try {
            b = (context.getApplicationInfo().flags & 2) != 0;
        } catch (Throwable unused) {
            b = true;
        }
        a = iLogger;
    }

    public static void a(String str) {
        a(str, (Throwable) null);
    }

    public static void a(String str, Throwable th) {
        ILogger iLogger = a;
        if (iLogger != null) {
            iLogger.log(str, th);
        } else if (b) {
            Log.d("AppLog", str, th);
        }
    }

    public static void a(Throwable th) {
        a("U SHALL NOT PASS!", th);
    }
}
