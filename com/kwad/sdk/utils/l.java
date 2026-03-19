package com.kwad.sdk.utils;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class l<T> {
    protected boolean clx = false;
    protected boolean enable;

    protected abstract T db(Context context);

    public l(boolean z) {
        this.enable = z;
    }

    public final void dx(boolean z) {
        this.enable = z;
    }

    public final T da(Context context) {
        if (!this.enable || this.clx) {
            return null;
        }
        try {
            return db(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }
}
