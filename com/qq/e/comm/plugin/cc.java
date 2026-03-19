package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class cc {
    public static fk a(Context context, h4 h4Var, String str, int i, sd sdVar) {
        if (a(h4Var)) {
            return new wn(context, h4Var);
        }
        return new ic(context, h4Var, str, i, sdVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(h4 h4Var) {
        if ((h4Var instanceof lk) && !TextUtils.isEmpty(h4Var.i0())) {
            return !((lk) h4Var).b();
        }
        return false;
    }
}
