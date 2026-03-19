package com.baidu.mobads.container.util;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bi extends com.baidu.mobads.container.d.a {
    final /* synthetic */ bh a;

    bi(bh bhVar) {
        this.a = bhVar;
    }

    @Override // com.baidu.mobads.container.d.a
    public Object a() {
        if (this.a.h.get() != 0) {
            return null;
        }
        if (this.a.b != null) {
            this.a.f = this.a.d - this.a.e;
            try {
                this.a.b.a(this.a.f);
            } catch (Throwable th) {
            }
        }
        if (this.a.e <= 0) {
            if (this.a.b != null) {
                try {
                    this.a.b.a();
                } catch (Throwable th2) {
                }
            }
            this.a.b();
        } else {
            bh.f(this.a);
        }
        return null;
    }
}
