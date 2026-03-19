package com.ss.android.downloadlib.h;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class tc {
    private static Map<String, d> d = Collections.synchronizedMap(new HashMap());

    public interface d {
        void d();

        void d(String str);
    }

    public static void d(String[] strArr, d dVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        d(strValueOf, dVar);
        TTDelegateActivity.d(strValueOf, strArr);
    }

    public static void d(String str) {
        d dVarB;
        if (TextUtils.isEmpty(str) || (dVarB = b(str)) == null) {
            return;
        }
        dVarB.d();
    }

    public static void d(String str, String str2) {
        d dVarB;
        if (TextUtils.isEmpty(str) || (dVarB = b(str)) == null) {
            return;
        }
        dVarB.d(str2);
    }

    private static void d(String str, d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        d.put(str, dVar);
    }

    private static d b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d.remove(str);
    }

    public static boolean hc(String str) {
        return com.ss.android.downloadlib.addownload.mq.u().d(com.ss.android.downloadlib.addownload.mq.getContext(), str);
    }
}
