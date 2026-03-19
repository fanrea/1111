package com.tencent.gatherer.core.internal.util.odex;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class g {
    private boolean a;
    private Object b;

    protected abstract Object a();

    public Object b() {
        if (!this.a) {
            this.b = a();
            this.a = true;
        }
        return this.b;
    }
}
