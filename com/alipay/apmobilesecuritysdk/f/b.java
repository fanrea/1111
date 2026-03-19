package com.alipay.apmobilesecuritysdk.f;

import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class b {
    public static b a = new b();
    public Thread b = null;
    public LinkedList<Runnable> c = new LinkedList<>();

    public static b a() {
        return a;
    }

    public static /* synthetic */ Thread b(b bVar) {
        bVar.b = null;
        return null;
    }

    public final synchronized void a(Runnable runnable) {
        this.c.add(runnable);
        if (this.b == null) {
            Thread thread = new Thread(new c(this));
            this.b = thread;
            thread.start();
        }
    }
}
