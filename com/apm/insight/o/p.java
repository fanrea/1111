package com.apm.insight.o;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class p {
    private static String a;
    private static File b;
    private static File c;
    private static File d;

    public static File a() {
        File file = c;
        return file == null ? d(com.apm.insight.g.f()) : file;
    }

    public static File a(Context context) {
        return new File(j(context), "apminsight/CrashLogJava");
    }

    public static File a(Context context, String str) {
        return new File(j(context) + "/apminsight/CrashCommonLog/" + str);
    }

    public static File a(File file) {
        return new File(file, "flog.txt");
    }

    public static File a(File file, String str) {
        return new File(file, file.getName() + str);
    }

    public static String a(String str) {
        return "dart_" + str;
    }

    public static File b(Context context) {
        return new File(j(context), "apminsight/CrashLogSimple");
    }

    public static File b(Context context, String str) {
        return new File(j(context) + "/apminsight/CustomFile/" + str);
    }

    public static File b(File file) {
        return new File(file, "tombstone.txt");
    }

    public static File b(String str) {
        return new File(a(com.apm.insight.g.f(), str), "fds.txt");
    }

    public static String b() {
        return "anr_" + com.apm.insight.g.d();
    }

    public static File c(Context context) {
        return new File(j(context), "apminsight/RuntimeContext");
    }

    public static File c(File file) {
        return new File(file, "header.bin");
    }

    public static File c(String str) {
        return new File(a(com.apm.insight.g.f(), str), "threads.txt");
    }

    public static String c() {
        return String.format("alog_%s.npth", com.apm.insight.g.d());
    }

    public static File d(Context context) {
        if (c == null) {
            if (context == null) {
                context = com.apm.insight.g.f();
            }
            c = new File(j(context), "apminsight/CrashLogNative");
        }
        return c;
    }

    public static File d(File file) {
        return new File(a(com.apm.insight.g.f(), file.getName()), "maps.txt");
    }

    public static File d(String str) {
        return new File(a(com.apm.insight.g.f(), str), "meminfo.txt");
    }

    public static String d() {
        return String.format("ensure_%s", com.apm.insight.g.d());
    }

    public static File e(Context context) {
        if (d == null) {
            d = new File(j(context) + "/apminsight/CrashCommonLog/" + com.apm.insight.g.e());
        }
        return d;
    }

    public static File e(File file) {
        return new File(file, "callback.json");
    }

    public static File e(String str) {
        return new File(a(com.apm.insight.g.f(), str), "pthreads.txt");
    }

    public static File f(Context context) {
        return new File(j(context), "apminsight/CrashCommonLog");
    }

    public static File f(File file) {
        return new File(file, "upload.json");
    }

    public static File f(String str) {
        return new File(a(com.apm.insight.g.f(), str), "rountines.txt");
    }

    public static File g(Context context) {
        return new File(j(context), "apminsight/issueCrashTimes");
    }

    public static File g(File file) {
        return new File(file, "javastack.txt");
    }

    public static File g(String str) {
        return new File(a(com.apm.insight.g.f(), str), "leakd_threads.txt");
    }

    public static File h(Context context) {
        return new File(j(context) + "/apminsight/issueCrashTimes/current.times");
    }

    public static File h(File file) {
        return new File(a(com.apm.insight.g.f(), file.getName()), "logcat.txt");
    }

    public static File i(Context context) {
        return new File(j(context), "apminsight/alogCrash");
    }

    public static File i(File file) {
        return new File(a(com.apm.insight.g.f(), file.getName()), "fds.txt");
    }

    public static File j(File file) {
        return new File(a(com.apm.insight.g.f(), file.getName()), "threads.txt");
    }

    public static String j(Context context) {
        if (TextUtils.isEmpty(a)) {
            try {
                a = context.getFilesDir().getAbsolutePath();
            } catch (Exception e) {
                a = "/sdcard/";
                e.printStackTrace();
            }
        }
        return a;
    }

    public static File k(Context context) {
        return new File(j(context) + "/apminsight/CustomFile/" + com.apm.insight.g.e());
    }

    public static File k(File file) {
        return new File(a(com.apm.insight.g.f(), file.getName()), "meminfo.txt");
    }

    public static File l(File file) {
        return new File(a(com.apm.insight.g.f(), file.getName()), "pthreads.txt");
    }

    public static File m(File file) {
        return new File(a(com.apm.insight.g.f(), file.getName()), "rountines.txt");
    }

    public static File n(File file) {
        return new File(a(com.apm.insight.g.f(), file.getName()), "leakd_threads.txt");
    }

    public static File o(File file) {
        return new File(file, "abortmsg.txt");
    }
}
