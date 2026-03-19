package com.bytedance.sdk.component.gb.hc.d.hc;

import com.bytedance.sdk.component.gb.d.hc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d<T extends com.bytedance.sdk.component.gb.d.hc> extends com.bytedance.sdk.component.gb.hc.d.d {
    public com.bytedance.sdk.component.gb.d.u b;
    private Queue<T> c = new ConcurrentLinkedQueue();
    public com.bytedance.sdk.component.gb.hc.c.hc.d d;
    public String hc;
    private Queue<String> u;

    public d(com.bytedance.sdk.component.gb.hc.c.hc.d dVar, Queue<String> queue, String str, com.bytedance.sdk.component.gb.d.u uVar) {
        this.d = dVar;
        this.u = queue;
        this.b = uVar;
        this.hc = str;
    }

    public void hc(T t) {
        if (this.c == null || t == null || !d(t)) {
            return;
        }
        this.c.offer(t);
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d
    public List<com.bytedance.sdk.component.gb.d.hc> hc(int i, com.bytedance.sdk.component.gb.d.hc hcVar, boolean z, List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        this.c.size();
        do {
            T tPoll = this.c.poll();
            if (tPoll == null) {
                break;
            }
            arrayList.add(tPoll);
        } while (arrayList.size() != this.d.hc());
        return arrayList;
    }

    private void hc(int i, List<T> list, int i2) {
        com.bytedance.sdk.component.gb.d.hc hcVar;
        int size = this.c.size();
        if ((i == -1 || i == 200 || i == 509 || i == -3) && list != null && list.size() != 0 && size != 0) {
            HashMap map = new HashMap();
            for (T t : this.c) {
                if (t != null) {
                    map.put(t.b(), t);
                }
            }
            for (T t2 : list) {
                if (t2 != null && (hcVar = (com.bytedance.sdk.component.gb.d.hc) map.get(t2.b())) != null) {
                    this.c.remove(hcVar);
                }
            }
        }
        this.c.size();
    }

    public com.bytedance.sdk.component.gb.hc.d.hc d(int i, List<T> list, int i2) {
        com.bytedance.sdk.component.gb.hc.d.hc hcVar = new com.bytedance.sdk.component.gb.hc.d.hc();
        if (list != null && list.size() != 0 && list.get(0) != null && d(list.get(0))) {
            hc(i, list, i2);
            hcVar.d(true);
            return hcVar;
        }
        hcVar.d(false);
        return hcVar;
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d
    public boolean hc(int i, String str, com.bytedance.sdk.component.gb.d.hc hcVar) {
        int size = this.c.size();
        int iD = this.d.d();
        com.bytedance.sdk.component.gb.hc.b.d.hc(i);
        return size >= iD;
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d
    public boolean d(String str) {
        return this.c.size() > 0;
    }
}
