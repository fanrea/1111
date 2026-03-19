package com.android.gdt.qone.m;

import android.content.Context;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class e {
    public final g a;
    public final d b;
    public final Context c;
    public volatile boolean d = false;
    public c e;

    public e(Context context, g gVar) {
        this.a = null;
        this.c = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.c = context;
        this.a = gVar;
        this.b = new d(this);
    }
}
