package com.qq.e.comm.plugin;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class z40 {
    private final int a;
    private final ArrayList<im> b = new ArrayList<>();
    private final String c;
    private final int d;
    private volatile boolean e;

    z40(String str, int i, im imVar, int i2) {
        this.c = str;
        this.d = i;
        this.a = i2;
        a(imVar);
    }

    int c() {
        return this.d;
    }

    im d() {
        Iterator<im> it = this.b.iterator();
        while (it.hasNext()) {
            im next = it.next();
            if (next != null && next.b() == 1) {
                next.a(2);
                return next;
            }
        }
        return null;
    }

    boolean a(im imVar) {
        if (this.b.size() >= this.a) {
            return false;
        }
        imVar.a(1);
        this.b.add(imVar);
        if (this.b.size() == this.a) {
            this.e = false;
        } else {
            this.e = true;
        }
        return true;
    }

    boolean e() {
        return this.e;
    }

    int b() {
        return this.a;
    }

    void a() {
        this.b.clear();
    }
}
