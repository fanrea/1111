package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class t {
    private static String bFY = abx();
    private static long bFZ = 0;
    private static Context bGa;

    public static void init(Context context) {
        bGa = context;
    }

    public static String abr() {
        com.kwad.sdk.core.d.c.d("ReportIdManager", ">> updateSessionId");
        String strAbx = abx();
        bFY = strAbx;
        return strAbx;
    }

    public static String abs() {
        return bFY;
    }

    public static long abt() {
        long jBT = bT(bGa);
        b(bGa, 1 + jBT);
        return jBT;
    }

    public static synchronized long abu() {
        long jBU;
        jBU = bU(bGa);
        c(bGa, 1 + jBU);
        return jBU;
    }

    public static long abv() {
        com.kwad.sdk.core.d.c.d("ReportIdManager", ">> updateListId");
        long jCurrentTimeMillis = System.currentTimeMillis();
        bFZ = jCurrentTimeMillis;
        return jCurrentTimeMillis;
    }

    public static long abw() {
        return bFZ;
    }

    private static String abx() {
        return UUID.randomUUID().toString();
    }

    private static boolean b(Context context, long j) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
        editorEdit.putLong(com.baidu.mobads.container.adrequest.g.ag, j);
        return editorEdit.commit();
    }

    private static long bT(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong(com.baidu.mobads.container.adrequest.g.ag, 1L);
    }

    private static boolean c(Context context, long j) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("ksadsdk_mplogseq", 0).edit();
        editorEdit.putLong(com.baidu.mobads.container.adrequest.g.ag, j);
        return editorEdit.commit();
    }

    private static long bU(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_mplogseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong(com.baidu.mobads.container.adrequest.g.ag, 1L);
    }
}
