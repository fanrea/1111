package com.qq.e.comm.plugin;

import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class fc implements dk {
    private final ck a;
    private ek b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;

    public fc(ck ckVar) {
        this.a = ckVar;
    }

    @Override // com.qq.e.comm.plugin.dk
    public h4 b() {
        return this.a.b();
    }

    @Override // com.qq.e.comm.plugin.dk
    public void e() {
        a(g());
    }

    @Override // com.qq.e.comm.plugin.dk
    public void f() {
        this.g = true;
        this.a.e();
    }

    @Override // com.qq.e.comm.plugin.dk
    public void c() {
        a(this.a.a(), a());
    }

    @Override // com.qq.e.comm.plugin.dk
    public boolean d() {
        return a(g(), a());
    }

    boolean a(boolean z, boolean z2) {
        if (z) {
            this.a.a(9001);
            return false;
        }
        if (!z2) {
            this.a.a(9000);
            return false;
        }
        this.a.g();
        return true;
    }

    @Override // com.qq.e.comm.plugin.dk
    public void destroy() {
        if (!this.e && !this.c) {
            this.a.f();
        }
        if (!this.f || this.g) {
            return;
        }
        this.a.c();
    }

    boolean g() {
        return this.c;
    }

    boolean h() {
        return this.d;
    }

    boolean a() {
        return this.e;
    }

    void a(String str, boolean z) {
        if (TextUtils.isEmpty(str) || z) {
            return;
        }
        this.e = false;
        this.d = false;
        this.c = false;
        if (this.b != null) {
            this.a.d();
            this.f = true;
            this.b.loadUrl(str);
        }
    }

    void a(boolean z) {
        if (z) {
            return;
        }
        if (!this.e) {
            this.a.h();
        }
        this.e = true;
    }

    @Override // com.qq.e.comm.plugin.dk
    public void a(String str) {
        a(str, g(), h());
    }

    void a(String str, boolean z, boolean z2) {
        ek ekVar;
        if (z) {
            return;
        }
        this.a.a(str);
        this.c = true;
        if (z2 || (ekVar = this.b) == null) {
            return;
        }
        ekVar.loadUrl(str);
        this.d = true;
    }

    @Override // com.qq.e.comm.plugin.dk
    public void a(ek ekVar) {
        this.b = ekVar;
    }
}
