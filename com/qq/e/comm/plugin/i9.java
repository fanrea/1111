package com.qq.e.comm.plugin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class i9 {
    public String a;
    public CopyOnWriteArrayList<gl> b;
    public long c;
    public long d;
    public int e;

    public String toString() {
        return "DnsCacheObj{host='" + this.a + "', ipList=" + this.b + ", ttl=" + this.c + ", updateTime=" + this.d + ", from=" + this.e + '}';
    }

    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList<gl> copyOnWriteArrayList = this.b;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<gl> it = this.b.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().a);
            }
        }
        return arrayList;
    }
}
