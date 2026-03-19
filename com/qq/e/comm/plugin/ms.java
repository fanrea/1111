package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class ms<T> {
    private final os a;

    public abstract void b(T t);

    public ms(os osVar) {
        this.a = osVar;
        if (osVar.i() != null) {
            osVar.i().a(this);
        }
    }

    void a(T t) {
        os osVar = this.a;
        if (osVar == null || osVar.k()) {
            return;
        }
        b(t);
    }
}
