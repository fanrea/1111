package com.bytedance.sdk.component.adexpress.hc;

import com.bytedance.sdk.component.adexpress.hc.tc;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq implements tc.d {
    private tt b;
    private AtomicBoolean c = new AtomicBoolean(false);
    e d;
    private List<tc> hc;

    public mq(List<tc> list, tt ttVar) {
        this.hc = list;
        this.b = ttVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.tc.d
    public void d() {
        this.b.an();
        Iterator<tc> it = this.hc.iterator();
        while (it.hasNext() && !it.next().d(this)) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.tc.d
    public void d(tc tcVar) {
        int iIndexOf = this.hc.indexOf(tcVar);
        if (iIndexOf < 0) {
            return;
        }
        do {
            iIndexOf++;
            if (iIndexOf >= this.hc.size()) {
                return;
            }
        } while (!this.hc.get(iIndexOf).d(this));
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.tc.d
    public boolean hc(tc tcVar) {
        int iIndexOf = this.hc.indexOf(tcVar);
        return iIndexOf < this.hc.size() - 1 && iIndexOf >= 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.tc.d
    public e hc() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.tc.d
    public void d(e eVar) {
        this.d = eVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.tc.d
    public void d(boolean z) {
        this.c.getAndSet(z);
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.tc.d
    public boolean b() {
        return this.c.get();
    }
}
