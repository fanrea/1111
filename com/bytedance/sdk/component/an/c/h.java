package com.bytedance.sdk.component.an.c;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h extends d {
    @Override // com.bytedance.sdk.component.an.c.tt
    public String d() {
        return "check_duplicate";
    }

    @Override // com.bytedance.sdk.component.an.c.tt
    public void d(com.bytedance.sdk.component.an.b.b bVar) {
        List<com.bytedance.sdk.component.an.b.b> linkedList;
        String strNp = bVar.np();
        Map<String, List<com.bytedance.sdk.component.an.b.b>> mapH = bVar.jh().h();
        synchronized (mapH) {
            linkedList = mapH.get(strNp);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
        }
        synchronized (linkedList) {
            linkedList.add(bVar);
            mapH.put(strNp, linkedList);
            if (linkedList.size() <= 1) {
                bVar.d(new c());
            }
        }
    }
}
