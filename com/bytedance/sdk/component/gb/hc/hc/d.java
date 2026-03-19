package com.bytedance.sdk.component.gb.hc.hc;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.gb.d.an;
import com.bytedance.sdk.component.gb.d.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static long d(int i, Context context, u uVar) {
        return hc(i, context, uVar);
    }

    private static long hc(int i, Context context, u uVar) {
        if (context == null) {
            return i;
        }
        Runtime runtime = Runtime.getRuntime();
        long jFreeMemory = runtime.freeMemory() / 1048576;
        long jMaxMemory = (runtime.maxMemory() / 1048576) - (runtime.totalMemory() / 1048576);
        if (jMaxMemory <= 0) {
            if (jFreeMemory <= 2) {
                return 1L;
            }
            if (jFreeMemory <= 10) {
                return Math.min(i, 10);
            }
            return Math.min((jFreeMemory / 2) * 10, i);
        }
        long j = ((jFreeMemory + jMaxMemory) - 10) / 2;
        if (j <= 2) {
            return 1L;
        }
        if (j <= 10) {
            return Math.min(i, 10);
        }
        return Math.min(j * 10, i);
    }

    public static boolean d(u uVar) {
        an anVarHc = uVar.hc();
        return (anVarHc == null || TextUtils.isEmpty(anVarHc.d())) ? false : true;
    }

    public static boolean hc(u uVar) {
        an anVarHc = uVar.hc();
        return (anVarHc == null || TextUtils.isEmpty(anVarHc.hc())) ? false : true;
    }

    public static boolean b(u uVar) {
        an anVarHc = uVar.hc();
        return (anVarHc == null || TextUtils.isEmpty(anVarHc.c())) ? false : true;
    }

    public static boolean c(u uVar) {
        an anVarHc = uVar.hc();
        return (anVarHc == null || TextUtils.isEmpty(anVarHc.u())) ? false : true;
    }

    public static boolean u(u uVar) {
        an anVarHc = uVar.hc();
        return (anVarHc == null || TextUtils.isEmpty(anVarHc.b())) ? false : true;
    }

    public static boolean an(u uVar) {
        an anVarHc = uVar.hc();
        return (anVarHc == null || TextUtils.isEmpty(anVarHc.an())) ? false : true;
    }
}
