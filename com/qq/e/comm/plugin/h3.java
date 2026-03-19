package com.qq.e.comm.plugin;

import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class h3 extends f5 {
    private static final String k = m10.a("YXV0b2Rvd25sb2Fk");

    public h3(f5 f5Var) {
        super(f5Var);
    }

    public h3 g(int i) throws JSONException {
        a("download_scene", Integer.valueOf(i));
        return this;
    }

    public h3 b(boolean z) throws JSONException {
        a(k, Integer.valueOf(z ? 1 : 2));
        return this;
    }

    public h3 a(long j) throws JSONException {
        a("cost_time", Long.valueOf(j));
        return this;
    }

    public h3 f(int i) throws JSONException {
        a("dialog_type", Integer.valueOf(i));
        return this;
    }

    public h3 d(int i) throws JSONException {
        a("actor", Integer.valueOf(i));
        return this;
    }

    public h3 e(int i) throws JSONException {
        a("actor_code", Integer.valueOf(i));
        return this;
    }
}
