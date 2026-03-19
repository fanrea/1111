package com.bytedance.sdk.component.an.c;

import com.bytedance.sdk.component.an.cb;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb extends d {
    private String b;
    private Throwable d;
    private int hc;

    @Override // com.bytedance.sdk.component.an.c.tt
    public String d() {
        return com.alipay.sdk.m.u.h.i;
    }

    public gb(int i, String str, Throwable th) {
        this.hc = i;
        this.b = str;
        this.d = th;
    }

    @Override // com.bytedance.sdk.component.an.c.tt
    public void d(com.bytedance.sdk.component.an.b.b bVar) {
        bVar.d(new com.bytedance.sdk.component.an.b.d(this.hc, this.b, this.d));
        String strNp = bVar.np();
        Map<String, List<com.bytedance.sdk.component.an.b.b>> mapH = bVar.jh().h();
        List<com.bytedance.sdk.component.an.b.b> list = mapH.get(strNp);
        if (list == null) {
            hc(bVar);
            return;
        }
        synchronized (list) {
            Iterator<com.bytedance.sdk.component.an.b.b> it = list.iterator();
            while (it.hasNext()) {
                hc(it.next());
            }
            list.clear();
            mapH.remove(strNp);
        }
    }

    private void hc(com.bytedance.sdk.component.an.b.b bVar) {
        cb cbVarMk = bVar.mk();
        if (cbVarMk != null) {
            cbVarMk.d(this.hc, this.b, this.d);
        }
    }
}
