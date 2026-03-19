package com.bytedance.adsdk.ugeno.u.d;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements b {
    private List<c> d = new CopyOnWriteArrayList();

    @Override // com.bytedance.adsdk.ugeno.u.d.b
    public void d(c cVar) {
        this.d.add(cVar);
    }

    @Override // com.bytedance.adsdk.ugeno.u.d.b
    public void d(String str) {
        if (this.d.isEmpty()) {
            return;
        }
        Iterator<c> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().d(str);
        }
    }
}
