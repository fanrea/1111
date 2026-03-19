package com.pangrowth.adclog;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class n2 {
    static {
        new ArrayList();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(".");
        return (iLastIndexOf == -1 ? new StringBuilder().append(str) : new StringBuilder().append(str.substring(0, iLastIndexOf))).append("-cloudMsg.zip").toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.pangrowth.adclog.p2 r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pangrowth.adclog.n2.a(com.pangrowth.adclog.p2):void");
    }

    public static void a(q2 q2Var) {
        if (v.a()) {
            Log.d("cloudmessage", a0.a(new String[]{"uploadInfo=" + q2Var}));
        }
        if (TextUtils.isEmpty(q2Var.c)) {
            return;
        }
        Map<String, String> map = r2.a;
        r2.a("https://mon.snssdk.com/monitor/collect/c/cloudcontrol/file", q2Var.d, q2Var.c, q2Var.e, q2Var.f, q2Var.g);
    }
}
