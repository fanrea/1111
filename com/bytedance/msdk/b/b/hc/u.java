package com.bytedance.msdk.b.b.hc;

import com.bytedance.msdk.b.b.hc.d;
import com.bytedance.msdk.gb.j;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u implements d.InterfaceC0215d {
    private com.bytedance.msdk.b.an.d.hc b;
    private List<d> d = new CopyOnWriteArrayList();
    private com.bytedance.msdk.b.an.hc.hc hc;

    public u(List<d> list) {
        if (j.d(list)) {
            return;
        }
        this.d.addAll(list);
    }

    public void d(com.bytedance.msdk.b.an.d.hc hcVar, com.bytedance.msdk.b.an.hc.hc hcVar2) {
        this.b = hcVar;
        this.hc = hcVar2;
        if (j.d(this.d)) {
            return;
        }
        com.bytedance.msdk.d.u.an.d(new Runnable() { // from class: com.bytedance.msdk.b.b.hc.u.1
            @Override // java.lang.Runnable
            public void run() {
                ((d) u.this.d.get(0)).d(u.this);
            }
        });
    }

    @Override // com.bytedance.msdk.b.b.hc.d.InterfaceC0215d
    public com.bytedance.msdk.b.an.hc.hc d() {
        return this.hc;
    }

    @Override // com.bytedance.msdk.b.b.hc.d.InterfaceC0215d
    public com.bytedance.msdk.b.an.d.hc hc() {
        return this.b;
    }

    @Override // com.bytedance.msdk.b.b.hc.d.InterfaceC0215d
    public void d(d dVar) {
        int iIndexOf;
        if (j.d(this.d) || dVar == null || (iIndexOf = this.d.indexOf(dVar)) == -1 || iIndexOf >= this.d.size() - 1) {
            return;
        }
        this.d.get(iIndexOf + 1).d(this);
    }
}
