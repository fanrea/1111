package com.android.gdt.qone.h;

import android.content.Context;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class g {
    public final Context a;
    public c b;
    public final f c;
    public final e d;

    public g(Context context, e eVar) {
        this.a = null;
        this.d = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.a = context;
        this.d = eVar;
        this.c = new f(this);
    }

    public static void a(String str) {
        com.android.gdt.qone.af.b.c("LXOP " + str);
    }
}
