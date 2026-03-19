package com.qq.e.comm.plugin;

import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class q2 extends z9<s2> {
    q2(w40<?, ?> w40Var, ob obVar, s2 s2Var) {
        super(w40Var, obVar, s2Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qq.e.comm.plugin.z9
    void a(x9 x9Var) {
        try {
            ((s2) this.c).a(new JSONArray(this.b.a((mj) x9Var).toString()));
        } catch (JSONException unused) {
        }
    }
}
