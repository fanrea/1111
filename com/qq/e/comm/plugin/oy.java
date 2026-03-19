package com.qq.e.comm.plugin;

import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class oy {
    public static int a;

    public static void a(int i, Throwable th) throws JSONException {
        int i2;
        if (th instanceof NullPointerException) {
            i2 = 2;
        } else {
            i2 = th instanceof IllegalStateException ? 3 : 1;
        }
        ja jaVar = new ja();
        jaVar.a("ot", th.getMessage());
        jaVar.a("s_cnt", Integer.valueOf(a));
        b10.a(9130034, null, Integer.valueOf(i), Integer.valueOf(i2), jaVar);
    }
}
