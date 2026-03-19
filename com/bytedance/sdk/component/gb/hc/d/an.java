package com.bytedance.sdk.component.gb.hc.d;

import com.bytedance.sdk.component.gb.hc.d.hc.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an implements u {
    private List<com.bytedance.sdk.component.gb.hc.d.hc.d> d = new ArrayList();

    @Override // com.bytedance.sdk.component.gb.hc.d.u
    public List<com.bytedance.sdk.component.gb.d.hc> d(int i, com.bytedance.sdk.component.gb.d.hc hcVar, boolean z, String str) {
        return null;
    }

    public an(Queue<String> queue, com.bytedance.sdk.component.gb.d.u uVar) {
        com.bytedance.sdk.component.gb.hc.c.hc.d dVarGb;
        if (com.bytedance.sdk.component.gb.hc.hc.d.d(uVar)) {
            this.d.add(new com.bytedance.sdk.component.gb.hc.d.hc.b(uVar.h(), queue, uVar));
        }
        if (com.bytedance.sdk.component.gb.hc.hc.d.u(uVar)) {
            if (uVar.d() != null) {
                dVarGb = uVar.d();
            } else {
                dVarGb = uVar.gb();
            }
            this.d.add(new com.bytedance.sdk.component.gb.hc.d.hc.c(dVarGb, queue, uVar));
        }
        if (com.bytedance.sdk.component.gb.hc.hc.d.hc(uVar)) {
            this.d.add(new com.bytedance.sdk.component.gb.hc.d.hc.u(uVar.gb(), queue, uVar));
        }
        if (com.bytedance.sdk.component.gb.hc.hc.d.b(uVar)) {
            this.d.add(new com.bytedance.sdk.component.gb.hc.d.hc.an(uVar.gb(), queue, uVar));
        }
        if (com.bytedance.sdk.component.gb.hc.hc.d.c(uVar)) {
            this.d.add(new com.bytedance.sdk.component.gb.hc.d.hc.hc(uVar.tt(), queue, uVar));
        }
        if (com.bytedance.sdk.component.gb.hc.hc.d.an(uVar)) {
            this.d.add(new h(uVar.an(), queue, uVar));
        }
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.u
    public void d(com.bytedance.sdk.component.gb.d.hc hcVar) {
        Iterator<com.bytedance.sdk.component.gb.hc.d.hc.d> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().hc(hcVar);
        }
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.u
    public hc d(int i, List<com.bytedance.sdk.component.gb.d.hc> list, int i2) {
        Iterator<com.bytedance.sdk.component.gb.hc.d.hc.d> it = this.d.iterator();
        hc hcVarD = null;
        while (it.hasNext()) {
            hcVarD = it.next().d(i, list, i2);
            if (hcVarD.d()) {
                break;
            }
        }
        return hcVarD;
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.u
    public List<com.bytedance.sdk.component.gb.d.hc> d(int i, com.bytedance.sdk.component.gb.d.hc hcVar, boolean z, List<String> list) {
        Iterator<com.bytedance.sdk.component.gb.hc.d.hc.d> it = this.d.iterator();
        while (it.hasNext()) {
            List<com.bytedance.sdk.component.gb.d.hc> listD = it.next().d(i, hcVar, z, list, "get");
            if (listD != null && listD.size() != 0) {
                return listD;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.u
    public boolean d(int i, String str, com.bytedance.sdk.component.gb.d.hc hcVar) {
        Iterator<com.bytedance.sdk.component.gb.hc.d.hc.d> it = this.d.iterator();
        while (it.hasNext()) {
            if (it.next().d(i, str, hcVar)) {
                return true;
            }
        }
        return false;
    }
}
