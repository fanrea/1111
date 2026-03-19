package com.android.gdt.qone.d;

import android.content.Context;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b {
    public final Context a;
    public final g b;
    public final a c;
    public e d;
    public volatile boolean e = false;

    public b(Context context, g gVar) {
        if (context == null) {
            throw new NullPointerException("context can not be null");
        }
        this.a = context;
        this.b = gVar;
        this.c = new a(this, gVar);
    }
}
