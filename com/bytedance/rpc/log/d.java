package com.bytedance.rpc.log;

import android.util.Log;

/* compiled from: Logger.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static String a = "tt-rpc";
    private static LogLevel b = LogLevel.DEBUG;
    private static c c;
    private static b d;

    public static void a(LogLevel logLevel) {
        if (logLevel != null) {
            b = logLevel;
        }
    }

    public static void a(CharSequence charSequence) {
        a((String) null, charSequence);
    }

    public static void b(CharSequence charSequence) {
        b(null, charSequence);
    }

    public static void a(String str, CharSequence charSequence) {
        if (b(LogLevel.DEBUG) && com.bytedance.sdk.djx.proguard3.c.d.b(charSequence)) {
            String strA = a(str);
            b bVar = d;
            if (bVar == null || !bVar.a(strA, charSequence, LogLevel.DEBUG)) {
                c cVar = c;
                if (cVar == null) {
                    Log.d(strA, charSequence.toString());
                } else {
                    cVar.a(strA, charSequence.toString());
                }
            }
        }
    }

    public static void b(String str, CharSequence charSequence) {
        if (b(LogLevel.ERROR) && com.bytedance.sdk.djx.proguard3.c.d.b(charSequence)) {
            String strA = a(str);
            b bVar = d;
            if (bVar == null || !bVar.a(strA, charSequence, LogLevel.ERROR)) {
                c cVar = c;
                if (cVar == null) {
                    Log.e(strA, charSequence.toString());
                } else {
                    cVar.b(strA, charSequence.toString());
                }
            }
        }
    }

    public static void a(Throwable th) {
        a(th, false);
    }

    public static void a(Throwable th, boolean z) {
        if (th == null || !b(LogLevel.ERROR)) {
            return;
        }
        b bVar = d;
        if (bVar == null || !bVar.a(th, z)) {
            c cVar = c;
            if (cVar == null) {
                String strA = a((String) null);
                if (strA == null) {
                    strA = "error";
                }
                b(strA, a.a().b(th));
                return;
            }
            cVar.a(th, z);
        }
    }

    private static String a(String str) {
        if (!com.bytedance.sdk.djx.proguard3.c.d.c(str)) {
            return str;
        }
        if (str == null && com.bytedance.sdk.djx.proguard3.c.d.b(a)) {
            return a;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        for (int i = 2; i < 4; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (!d.class.getName().equals(stackTraceElement.getClassName())) {
                String fileName = stackTraceElement.getFileName();
                int iLastIndexOf = fileName == null ? -1 : fileName.lastIndexOf(46);
                return iLastIndexOf > 0 ? fileName.substring(0, iLastIndexOf) : fileName;
            }
        }
        return str;
    }

    public static final boolean a() {
        return b.log();
    }

    public static final boolean b() {
        return b(LogLevel.DEBUG);
    }

    public static final boolean c() {
        return b(LogLevel.ERROR);
    }

    private static boolean b(LogLevel logLevel) {
        if (logLevel == null || !a()) {
            return false;
        }
        c cVar = c;
        if (cVar == null) {
            return b.ordinal() <= logLevel.ordinal();
        }
        return cVar.a(logLevel);
    }
}
