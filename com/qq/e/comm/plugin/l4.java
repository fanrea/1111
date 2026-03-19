package com.qq.e.comm.plugin;

import android.os.Handler;
import android.os.Looper;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class l4<T> {
    protected Handler a = new Handler(Looper.getMainLooper());
    protected final Object b = new Object();
    protected final no<T> c;

    protected abstract void a();

    public l4(no<T> noVar) {
        this.c = noVar;
    }

    public final void b() {
        a();
    }
}
