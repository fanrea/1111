package com.bytedance.sdk.component.an.c;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an extends d {
    @Override // com.bytedance.sdk.component.an.c.tt
    public String d() {
        return "disk_cache";
    }

    @Override // com.bytedance.sdk.component.an.c.tt
    public void d(com.bytedance.sdk.component.an.b.b bVar) {
        byte[] bArrD;
        String strAn = bVar.an();
        com.bytedance.sdk.component.an.hc hcVarSy = bVar.sy();
        if (bVar.de() || hcVarSy.an()) {
            bArrD = d(bVar, strAn);
        } else {
            bArrD = hc(bVar, strAn);
        }
        if (bArrD == null) {
            bVar.d(new mk());
            return;
        }
        bVar.d(new hc(bArrD, null));
        if (hcVarSy.h()) {
            bVar.jh().hc(hcVarSy).d(strAn, bArrD);
        }
    }

    private byte[] d(com.bytedance.sdk.component.an.b.b bVar, String str) {
        bVar.jh().b(bVar.sy());
        Collection<com.bytedance.sdk.component.an.b> collectionB = bVar.jh().b();
        if (collectionB == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.an.b> it = collectionB.iterator();
        while (it.hasNext()) {
            byte[] bArrD = it.next().d((com.bytedance.sdk.component.an.b) str);
            if (bArrD != null) {
                return bArrD;
            }
        }
        return null;
    }

    private byte[] hc(com.bytedance.sdk.component.an.b.b bVar, String str) {
        com.bytedance.sdk.component.an.b bVarB = bVar.jh().b(bVar.sy());
        if (bVarB == null) {
            return null;
        }
        return bVarB.d((com.bytedance.sdk.component.an.b) str);
    }
}
