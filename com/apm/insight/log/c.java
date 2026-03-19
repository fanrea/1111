package com.apm.insight.log;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.apm.insight.log.a.e;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c implements e {
    public static boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean a(Context context) throws Throwable {
        String strB = b();
        if (strB == null || strB.contains(":")) {
            return false;
        }
        return strB.equals(context.getPackageName()) || strB.equals(context.getApplicationInfo().processName);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x004c A[EXC_TOP_SPLITTER, PHI: r1
  0x004c: PHI (r1v6 java.io.BufferedReader) = (r1v5 java.io.BufferedReader), (r1v7 java.io.BufferedReader), (r1v7 java.io.BufferedReader) binds: [B:26:0x005d, B:11:0x003c, B:13:0x0046] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b() throws java.lang.Throwable {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto Lb
            java.lang.String r0 = android.app.Application.getProcessName()
            return r0
        Lb:
            r0 = 0
            java.lang.String r1 = "android.app.ActivityThread"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L28
            java.lang.String r2 = "currentProcessName"
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> L28
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch: java.lang.Exception -> L28
            r2 = 1
            r1.setAccessible(r2)     // Catch: java.lang.Exception -> L28
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L28
            java.lang.Object r1 = r1.invoke(r0, r2)     // Catch: java.lang.Exception -> L28
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L28
            return r1
        L28:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5c
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5c
            java.lang.String r3 = "/proc/self/cmdline"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5c
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5c
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L5d
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L5d
            if (r3 != 0) goto L4c
            java.lang.String r2 = r2.trim()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L5d
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L5d
            if (r3 != 0) goto L4c
            r1.close()     // Catch: java.lang.Exception -> L4b
        L4b:
            return r2
        L4c:
            r1.close()     // Catch: java.lang.Exception -> L60
            goto L60
        L50:
            r0 = move-exception
            goto L56
        L52:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L56:
            if (r1 == 0) goto L5b
            r1.close()     // Catch: java.lang.Exception -> L5b
        L5b:
            throw r0
        L5c:
            r1 = r0
        L5d:
            if (r1 == 0) goto L60
            goto L4c
        L60:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.log.c.b():java.lang.String");
    }

    public static String b(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "unknown" : str;
    }

    c() {
    }

    @Override // com.apm.insight.log.a.e
    public void c() {
        System.loadLibrary("volc_log");
    }

    public static File c(Context context) {
        File file = new File(context.getFilesDir(), "volc_log");
        if (file.exists() && !file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, "logs");
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file2;
    }

    public static String d(Context context) {
        File file = new File(context.getFilesDir(), "volc_log");
        if (file.exists() && !file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, "cache");
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file2.getAbsolutePath();
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof UnknownHostException) {
                return "ALOG:UnknownHostException";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
        } catch (Throwable unused) {
        }
        printWriter.flush();
        return stringWriter.toString();
    }
}
