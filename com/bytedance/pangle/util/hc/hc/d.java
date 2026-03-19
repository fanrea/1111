package com.bytedance.pangle.util.hc.hc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private List<b> d = new ArrayList();

    public List<b> d() {
        return this.d;
    }

    public void d(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.d) {
            if (!set.contains(bVar.mq())) {
                arrayList.add(bVar);
            }
        }
        this.d = arrayList;
    }

    public void d(List<b> list) {
        this.d = list;
    }
}
