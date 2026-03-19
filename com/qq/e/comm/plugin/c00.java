package com.qq.e.comm.plugin;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class c00 {
    private final AtomicInteger a = new AtomicInteger(0);

    c00() {
    }

    boolean e() {
        return this.a.compareAndSet(0, 1) || this.a.compareAndSet(4, 1);
    }

    boolean g() {
        return this.a.compareAndSet(1, 2);
    }

    boolean j() {
        return this.a.compareAndSet(2, 3);
    }

    boolean f() {
        return this.a.compareAndSet(2, 4) || this.a.compareAndSet(3, 4);
    }

    boolean i() {
        return this.a.compareAndSet(4, 5);
    }

    boolean h() {
        return this.a.compareAndSet(5, 6);
    }

    boolean b() {
        return this.a.compareAndSet(6, 7);
    }

    boolean k() {
        return this.a.compareAndSet(7, 8);
    }

    boolean c() {
        return this.a.compareAndSet(7, 0) || this.a.compareAndSet(6, 0) || this.a.compareAndSet(8, 0);
    }

    boolean d() {
        return this.a.compareAndSet(2, 0) || this.a.compareAndSet(3, 0) || this.a.compareAndSet(5, 0) || this.a.compareAndSet(6, 0);
    }

    boolean n() {
        return this.a.get() == 2 || this.a.get() == 3;
    }

    boolean m() {
        return this.a.get() == 4;
    }

    boolean o() {
        return this.a.get() == 5;
    }

    boolean p() {
        return this.a.get() == 7 || this.a.get() == 6 || this.a.get() == 8;
    }

    boolean l() {
        return this.a.get() == 7 || this.a.get() == 8;
    }

    int a() {
        return this.a.get();
    }
}
