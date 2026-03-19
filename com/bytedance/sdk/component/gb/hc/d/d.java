package com.bytedance.sdk.component.gb.hc.d;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d {
    public abstract boolean d(com.bytedance.sdk.component.gb.d.hc hcVar);

    public abstract boolean d(String str);

    public abstract List<com.bytedance.sdk.component.gb.d.hc> hc(int i, com.bytedance.sdk.component.gb.d.hc hcVar, boolean z, List<String> list, String str);

    public abstract boolean hc(int i, String str, com.bytedance.sdk.component.gb.d.hc hcVar);

    public List<com.bytedance.sdk.component.gb.d.hc> d(int i, com.bytedance.sdk.component.gb.d.hc hcVar, boolean z, List<String> list, String str) {
        if (com.bytedance.sdk.component.gb.hc.b.d.d(i)) {
            return hc(i, hcVar, z, list, str);
        }
        if (d(hcVar)) {
            return hc(i, hcVar, z, list, str);
        }
        return null;
    }

    public boolean d(int i, String str, com.bytedance.sdk.component.gb.d.hc hcVar) {
        if (com.bytedance.sdk.component.gb.hc.b.d.d(i)) {
            return d(str);
        }
        if (d(hcVar)) {
            return hc(i, str, hcVar);
        }
        return false;
    }
}
