package com.qq.e.comm.plugin;

import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class lb implements xj {
    private final k5 a = new k5();
    private List<xj> b;

    public boolean c(int i) {
        return this.a.c(i);
    }

    @Override // com.qq.e.comm.plugin.xj
    public void b(Canvas canvas, int i, int i2) {
        this.a.b(canvas, i, i2);
        List<xj> list = this.b;
        if (list != null) {
            Iterator<xj> it = list.iterator();
            while (it.hasNext()) {
                it.next().b(canvas, i, i2);
            }
        }
    }

    public void a(xj xjVar) {
        if (this.b == null) {
            this.b = new ArrayList(2);
        }
        this.b.add(xjVar);
    }

    public boolean b(int i) {
        return this.a.b(i);
    }

    public boolean b(int[] iArr) {
        return this.a.b(iArr);
    }

    @Override // com.qq.e.comm.plugin.xj
    public void a(Canvas canvas, int i, int i2) {
        List<xj> list = this.b;
        if (list != null) {
            Iterator<xj> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(canvas, i, i2);
            }
        }
        this.a.a(canvas, i, i2);
    }

    public boolean a() {
        return this.a.a() || this.b != null;
    }

    public boolean a(int i) {
        return this.a.a(i);
    }

    public boolean a(Object[] objArr) {
        return this.a.a(objArr);
    }

    public boolean a(int[] iArr) {
        return this.a.a(iArr);
    }
}
