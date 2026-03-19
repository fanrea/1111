package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.w40;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class c50 implements w40.g, ul {
    private final w40 a;
    private final w40.f b;
    private final Map<Integer, z8> c = new HashMap(3);

    c50(w40 w40Var, w40.f fVar) {
        this.a = w40Var;
        this.b = fVar;
        w40Var.a(this);
    }

    @Override // com.qq.e.comm.plugin.ul
    public void a(z8 z8Var) {
        this.c.put(Integer.valueOf(z8Var.a - 1), z8Var);
    }

    @Override // com.qq.e.comm.plugin.w40.g
    public void a(w40 w40Var, int i, int i2) throws JSONException {
        z8 z8Var;
        if (this.c.size() <= 0 || (z8Var = this.c.get(Integer.valueOf(i2))) == null) {
            return;
        }
        z8Var.a("lastStateType", Integer.valueOf(i + 1));
        this.b.a(this.a, z8Var);
    }
}
