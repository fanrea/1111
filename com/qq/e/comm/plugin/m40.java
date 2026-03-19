package com.qq.e.comm.plugin;

import android.content.Context;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class m40 {
    static com.qq.e.comm.plugin.va.m.p a(Context context, com.qq.e.comm.plugin.va.m.q qVar, q40 q40Var) {
        if (q40Var == q40.ONLINE_PLAYER) {
            try {
                return vs.l().a(qVar);
            } catch (Exception unused) {
            }
        }
        return new ip(context, qVar);
    }
}
