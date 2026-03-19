package com.qq.e.comm.plugin;

import android.view.View;
import com.qq.e.comm.plugin.fq;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class hq extends o4 {
    private final fq.a b;

    @Override // com.qq.e.comm.plugin.o4
    protected JSONObject c(View view) throws JSONException {
        return new JSONObject(this.a.i());
    }

    public hq(h4 h4Var, fq.a aVar) {
        super(h4Var);
        this.b = aVar;
    }

    @Override // com.qq.e.comm.plugin.o4
    protected ih<String> a() {
        this.b.b();
        return new ih<>(null);
    }

    @Override // com.qq.e.comm.plugin.o4
    protected void a(View view, String str, long j) {
        this.b.a(view, str);
    }
}
