package com.qq.e.comm.plugin;

import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class ec implements ck {
    private final h4 a;
    private final f5 b;
    private long c;

    public ec(h4 h4Var) {
        this.a = h4Var;
        this.b = f5.a(h4Var);
    }

    @Override // com.qq.e.comm.plugin.ck
    public h4 b() {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.ck
    public String a() {
        Object obj = this.a;
        return obj instanceof bk ? ((bk) obj).a() : "";
    }

    @Override // com.qq.e.comm.plugin.ck
    public void g() {
        gc.f(this.b, 0);
    }

    @Override // com.qq.e.comm.plugin.ck
    public void d() {
        this.c = System.currentTimeMillis();
        gc.c(this.b, 0);
    }

    @Override // com.qq.e.comm.plugin.ck
    public void h() {
        gc.d(this.b, 0);
        wt wtVar = new wt(2020030);
        wtVar.b(System.currentTimeMillis() - this.c);
        wtVar.a(this.b);
        b10.a(wtVar);
    }

    @Override // com.qq.e.comm.plugin.ck
    public void e() {
        gc.b(this.b, 0);
    }

    @Override // com.qq.e.comm.plugin.ck
    public void f() {
        gc.a(this.b, 0);
    }

    @Override // com.qq.e.comm.plugin.ck
    public void c() {
        gc.e(this.b, 0);
    }

    @Override // com.qq.e.comm.plugin.ck
    public void a(String str) throws JSONException {
        gc.a(this.b, 0, 0, new ja().a("url", str));
    }

    @Override // com.qq.e.comm.plugin.ck
    public void a(int i) throws JSONException {
        gc.b(this.b, 0, i, new ja().a("url", a()));
    }
}
