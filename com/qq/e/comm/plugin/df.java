package com.qq.e.comm.plugin;

import android.view.View;
import com.qq.e.comm.plugin.q6;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class df extends o4 {
    private final bc b;

    public df(h4 h4Var, bc bcVar) {
        super(h4Var);
        this.b = bcVar;
    }

    @Override // com.qq.e.comm.plugin.o4
    protected void a(View view, String str, long j) {
        i6 i6Var = new i6(this.a);
        i6Var.b = str;
        i6Var.e = j > 0;
        this.b.a(i6Var, false);
        b10.a(9120027, f5.a(this.a), Integer.valueOf(q6.a(q6.c.END_CARD, this.a).b));
    }

    @Override // com.qq.e.comm.plugin.o4
    public ih<String> a() {
        return new ih<>(1000, "Unsupported action");
    }

    @Override // com.qq.e.comm.plugin.o4
    public JSONObject c(View view) throws JSONException {
        return dx.a(view.getContext(), this.a);
    }
}
