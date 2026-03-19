package com.qq.e.comm.plugin;

import android.content.Context;
import com.kuaishou.android.live.network.ApiStatus;
import com.qq.e.comm.plugin.u00;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class v0<T extends u00> {
    Context a;
    List<T> b = new LinkedList();
    private long c = 0;
    private boolean d;

    private void e(List<T> list) {
        pro.getVresult(com.baidu.mobads.container.util.bu.g, 0, this, list);
    }

    void a(List<T> list) {
    }

    abstract void a(Set<Integer> set);

    abstract List<T> b();

    abstract void c(List<T> list);

    abstract void d(List<T> list);

    abstract boolean e();

    public v0(Context context) {
        this.a = context;
    }

    void g() {
        ArrayList arrayList = new ArrayList(this.b);
        this.b.clear();
        c(arrayList);
    }

    void a(T t) {
        if (t == null) {
            return;
        }
        if (this.b.size() >= 1000) {
            Iterator<T> it = this.b.iterator();
            for (int size = this.b.size() + ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG; size > 0 && it.hasNext(); size--) {
                it.next();
                it.remove();
            }
        }
        this.b.add(t);
        qm$h$$ExternalSyntheticBackport0.m(t);
        this.b.size();
    }

    void b(List<T> list) {
        this.c = System.currentTimeMillis() / 1000;
        HashSet hashSet = new HashSet();
        for (T t : list) {
            if (t != null) {
                if (t.a() >= 0) {
                    hashSet.add(Integer.valueOf(t.a()));
                }
                this.b.remove(t);
            }
        }
        a(hashSet);
    }

    void a() {
        ArrayList arrayList = new ArrayList(this.b);
        List<T> listB = b();
        if (listB != null && listB.size() > 0) {
            arrayList.addAll(listB);
        }
        if (arrayList.size() > 0) {
            e(arrayList);
        }
    }

    long c() {
        return this.c;
    }

    void f() {
        if (e()) {
            a();
        }
    }

    protected boolean d() {
        return this.d;
    }

    void a(boolean z) {
        this.d = z;
    }
}
