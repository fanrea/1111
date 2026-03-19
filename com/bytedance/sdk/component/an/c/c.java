package com.bytedance.sdk.component.an.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends d {
    @Override // com.bytedance.sdk.component.an.c.tt
    public String d() {
        return "cache_policy";
    }

    @Override // com.bytedance.sdk.component.an.c.tt
    public void d(com.bytedance.sdk.component.an.b.b bVar) {
        com.bytedance.sdk.component.an.hc hcVarSy = bVar.sy();
        if (hcVarSy != null) {
            if (hcVarSy.b()) {
                bVar.d(new tc());
                return;
            } else if (hcVarSy.c()) {
                bVar.d(new an());
                return;
            }
        }
        bVar.d(new mk());
    }
}
