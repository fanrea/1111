package com.qq.e.comm.plugin;

import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ca extends f5 {
    public ca(f5 f5Var) throws JSONException {
        super(f5Var);
        a("deeplink_scene", (Object) 1);
    }

    public ca b(boolean z) throws JSONException {
        if (z) {
            a("deeplink_type", (Object) 3);
        } else {
            a("deeplink_type", (Object) 1);
        }
        return this;
    }

    public ca a(long j) throws JSONException {
        a("cost_time", Long.valueOf(j));
        return this;
    }
}
