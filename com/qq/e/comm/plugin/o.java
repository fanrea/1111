package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class o {
    private static String a(int i, ApkDownloadTask apkDownloadTask) {
        return (String) pro.getobjresult(183, 1, Integer.valueOf(i), apkDownloadTask);
    }

    private static String a(int i, ApkDownloadTask apkDownloadTask, h4 h4Var) {
        return (String) pro.getobjresult(184, 1, Integer.valueOf(i), apkDownloadTask, h4Var);
    }

    private static String a(int i, ApkDownloadTask apkDownloadTask, boolean z, int i2) {
        return (String) pro.getobjresult(185, 1, Integer.valueOf(i), apkDownloadTask, Boolean.valueOf(z), Integer.valueOf(i2));
    }

    public static JSONObject a(ApkDownloadTask apkDownloadTask, h4 h4Var) {
        return (JSONObject) pro.getobjresult(186, 1, apkDownloadTask, h4Var);
    }

    public static void a(ApkDownloadTask apkDownloadTask) {
        pro.getVresult(187, 1, apkDownloadTask);
    }

    public static void a(ApkDownloadTask apkDownloadTask, boolean z) {
        pro.getVresult(188, 1, apkDownloadTask, Boolean.valueOf(z));
    }

    public static String b(ApkDownloadTask apkDownloadTask) {
        return (String) pro.getobjresult(189, 1, apkDownloadTask);
    }

    public static void b(ApkDownloadTask apkDownloadTask, h4 h4Var) {
        pro.getVresult(190, 1, apkDownloadTask, h4Var);
    }

    public static void c(ApkDownloadTask apkDownloadTask) {
        pro.getVresult(191, 1, apkDownloadTask);
    }

    public static void c(ApkDownloadTask apkDownloadTask, h4 h4Var) {
        pro.getVresult(192, 1, apkDownloadTask, h4Var);
    }

    private static boolean d(ApkDownloadTask apkDownloadTask) {
        return pro.getZresult(193, 1, apkDownloadTask);
    }
}
