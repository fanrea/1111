package com.qq.e.comm.plugin;

import com.kuaishou.android.live.network.ApiStatus;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class g50 {
    public static void a(int i, f5 f5Var, h4 h4Var, Integer num) {
        int i2;
        if (h4Var != null) {
            if (h4Var.E1()) {
                i2 = 0;
                num = null;
            } else if (k.d(h4Var)) {
                i2 = 2;
            } else {
                i2 = k.f(h4Var) ? 1 : ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG;
            }
            b10.a(i, new a(f5Var), Integer.valueOf(i2), num, null);
        }
    }

    /* compiled from: A */
    private static class a extends f5 {
        public a(f5 f5Var) throws JSONException {
            super(f5Var);
            a("wx_sdk_method", (Object) 3);
        }
    }
}
