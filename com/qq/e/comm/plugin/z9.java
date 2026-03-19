package com.qq.e.comm.plugin;

import com.baidu.mobstat.forbes.Config;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class z9<T> {
    final w40<?, ?> a;
    final ob b;
    final T c;

    abstract void a(x9 x9Var);

    public String toString() {
        return this.b.getClass() + Config.replace + this.b.d();
    }

    z9(w40<?, ?> w40Var, ob obVar, T t) {
        this.a = w40Var;
        this.b = obVar;
        this.c = t;
    }

    void a() {
        this.b.c();
    }
}
