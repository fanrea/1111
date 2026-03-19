package com.baidu.mobads.container.components.b;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private final f a;
    private volatile boolean b;

    private c() {
        this.a = new f();
        this.b = false;
    }

    private static class a {
        private static final c a = new c();

        private a() {
        }
    }

    public static c a() {
        return a.a;
    }

    public void a(Context context, e eVar) {
        a(context);
        this.a.a(eVar);
    }

    public void b(Context context, e eVar) {
        this.a.b(eVar);
        b(context);
    }

    public boolean b() {
        return this.a.b();
    }

    private void a(Context context) {
        if (!this.b) {
            this.b = b.a().a(context, this.a);
        }
    }

    private void b(Context context) {
        if (this.b && this.a.a()) {
            b.a().b(context, this.a);
            this.b = false;
        }
    }
}
