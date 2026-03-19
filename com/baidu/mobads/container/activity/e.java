package com.baidu.mobads.container.activity;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e {
    private static volatile e a;
    private List<v> b = new CopyOnWriteArrayList();

    private e() {
    }

    public static e a() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    public void a(v vVar) {
        if (vVar != null && !this.b.contains(vVar)) {
            this.b.add(vVar);
        }
    }

    public void a(int i) {
        for (v vVar : this.b) {
            if (i == 1) {
                vVar.d();
            } else if (i == 2) {
                vVar.e();
            } else if (i == 3) {
                vVar.f();
            } else if (i == 4) {
                vVar.g();
            } else if (i == 5) {
                vVar.h();
            } else if (i == 6) {
                vVar.i();
            } else if (i == 8) {
                vVar.j();
            } else if (i == 9) {
                vVar.k();
            } else if (i == 7) {
                vVar.l();
            } else if (i == 10 && (vVar instanceof u)) {
                ((u) vVar).a();
            } else if (i == 11 && (vVar instanceof u)) {
                ((u) vVar).b();
            } else if (i == 12 && (vVar instanceof u)) {
                ((u) vVar).c();
            }
        }
    }

    public void b(v vVar) {
        if (vVar != null && this.b.contains(vVar)) {
            this.b.remove(vVar);
        }
    }
}
