package com.bytedance.sdk.component.gb.hc.d;

import android.content.Context;
import com.bytedance.sdk.component.gb.hc.d.d.hc.gb;
import com.bytedance.sdk.component.gb.hc.d.d.hc.h;
import com.bytedance.sdk.component.utils.mq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements u {
    private gb an;
    private com.bytedance.sdk.component.gb.hc.d.d.hc.u b;
    private h c;
    private com.bytedance.sdk.component.gb.hc.d.d.hc.c d;
    private com.bytedance.sdk.component.gb.hc.c.hc.d gb;
    private com.bytedance.sdk.component.gb.hc.c.hc.d h;
    private com.bytedance.sdk.component.gb.hc.d.d.hc.an hc;
    private List<com.bytedance.sdk.component.gb.hc.d.d.hc.hc> k = new ArrayList();
    private com.bytedance.sdk.component.gb.hc.c.hc.d mk;
    private com.bytedance.sdk.component.gb.hc.c.hc.d mq;
    private com.bytedance.sdk.component.gb.hc.c.hc.d tc;
    private com.bytedance.sdk.component.gb.hc.c.hc.d tt;
    private com.bytedance.sdk.component.gb.hc.d.d.hc.d u;
    private com.bytedance.sdk.component.gb.d.u uo;

    @Override // com.bytedance.sdk.component.gb.hc.d.u
    public List<com.bytedance.sdk.component.gb.d.hc> d(int i, com.bytedance.sdk.component.gb.d.hc hcVar, boolean z, String str) {
        return null;
    }

    public c(com.bytedance.sdk.component.gb.d.u uVar) {
        this.uo = uVar;
        Context context = uVar.getContext();
        if (com.bytedance.sdk.component.gb.hc.hc.d.d(uVar)) {
            this.h = this.uo.h();
            com.bytedance.sdk.component.gb.hc.d.d.hc.c cVar = new com.bytedance.sdk.component.gb.hc.d.d.hc.c(context, this.h, this.uo);
            this.d = cVar;
            this.k.add(cVar);
        }
        if (com.bytedance.sdk.component.gb.hc.hc.d.u(uVar)) {
            if (this.uo.d() != null) {
                this.tt = this.uo.d();
            } else {
                this.tt = this.uo.gb();
            }
            com.bytedance.sdk.component.gb.hc.d.d.hc.u uVar2 = new com.bytedance.sdk.component.gb.hc.d.d.hc.u(context, this.tt, this.uo);
            this.b = uVar2;
            this.k.add(uVar2);
        }
        if (com.bytedance.sdk.component.gb.hc.hc.d.hc(uVar)) {
            this.gb = this.uo.gb();
            com.bytedance.sdk.component.gb.hc.d.d.hc.an anVar = new com.bytedance.sdk.component.gb.hc.d.d.hc.an(context, this.gb, this.uo);
            this.hc = anVar;
            this.k.add(anVar);
        }
        if (com.bytedance.sdk.component.gb.hc.hc.d.b(uVar)) {
            this.tc = this.uo.gb();
            h hVar = new h(context, this.tc, this.uo);
            this.c = hVar;
            this.k.add(hVar);
        }
        if (com.bytedance.sdk.component.gb.hc.hc.d.c(uVar)) {
            this.mk = this.uo.tt();
            com.bytedance.sdk.component.gb.hc.d.d.hc.d dVar = new com.bytedance.sdk.component.gb.hc.d.d.hc.d(context, this.mk, this.uo);
            this.u = dVar;
            this.k.add(dVar);
        }
        if (com.bytedance.sdk.component.gb.hc.hc.d.an(uVar)) {
            this.mq = this.uo.an();
            gb gbVar = new gb(context, this.mq, this.uo);
            this.an = gbVar;
            this.k.add(gbVar);
        }
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.u
    public void d(com.bytedance.sdk.component.gb.d.hc hcVar) {
        if (hcVar == null) {
            return;
        }
        try {
            hcVar.hc(System.currentTimeMillis());
            Iterator<com.bytedance.sdk.component.gb.hc.d.d.hc.hc> it = this.k.iterator();
            while (it.hasNext()) {
                it.next().hc(hcVar);
            }
        } catch (Throwable th) {
            mq.d(th);
            com.bytedance.sdk.component.gb.hc.b.hc.d(com.bytedance.sdk.component.gb.hc.hc.hc.d.d(), 1, this.uo);
        }
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.u
    public hc d(int i, List<com.bytedance.sdk.component.gb.d.hc> list, int i2) {
        Iterator<com.bytedance.sdk.component.gb.hc.d.d.hc.hc> it = this.k.iterator();
        hc hcVarD = null;
        while (it.hasNext()) {
            hcVarD = it.next().d(i, list);
            if (hcVarD.d()) {
                break;
            }
        }
        return hcVarD;
    }

    public List<com.bytedance.sdk.component.gb.d.hc> d(com.bytedance.sdk.component.gb.d.hc hcVar, int i, int i2, boolean z) {
        Iterator<com.bytedance.sdk.component.gb.hc.d.d.hc.hc> it = this.k.iterator();
        while (it.hasNext()) {
            List<com.bytedance.sdk.component.gb.d.hc> listD = it.next().d(i2, i, hcVar, z);
            if (listD != null && listD.size() != 0) {
                return listD;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.u
    public List<com.bytedance.sdk.component.gb.d.hc> d(int i, com.bytedance.sdk.component.gb.d.hc hcVar, boolean z, List<String> list) {
        Iterator<com.bytedance.sdk.component.gb.hc.d.d.hc.hc> it = this.k.iterator();
        while (it.hasNext()) {
            List<com.bytedance.sdk.component.gb.d.hc> listD = it.next().d(i, hcVar, z, list, "db");
            if (listD != null && listD.size() != 0) {
                return listD;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.u
    public boolean d(int i, String str, com.bytedance.sdk.component.gb.d.hc hcVar) {
        Iterator<com.bytedance.sdk.component.gb.hc.d.d.hc.hc> it = this.k.iterator();
        while (it.hasNext()) {
            if (it.next().d(i, str, hcVar)) {
                return true;
            }
        }
        return false;
    }
}
