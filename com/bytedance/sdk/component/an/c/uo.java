package com.bytedance.sdk.component.an.c;

import com.bytedance.sdk.component.an.cb;
import com.bytedance.sdk.component.an.rf;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class uo<T> extends d {
    private boolean b;
    private byte[] c;
    private T d;
    private com.bytedance.sdk.component.an.an hc;

    @Override // com.bytedance.sdk.component.an.c.tt
    public String d() {
        return "success";
    }

    public uo(T t, byte[] bArr, com.bytedance.sdk.component.an.an anVar, boolean z) {
        this.d = t;
        this.hc = anVar;
        this.b = z;
        this.c = bArr;
    }

    @Override // com.bytedance.sdk.component.an.c.tt
    public void d(com.bytedance.sdk.component.an.b.b bVar) {
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

    private Map<String, String> hc() {
        com.bytedance.sdk.component.an.an anVar = this.hc;
        if (anVar != null) {
            return anVar.u();
        }
        return null;
    }

    private void hc(com.bytedance.sdk.component.an.b.b bVar) {
        cb cbVarMk = bVar.mk();
        int iUo = bVar.uo();
        if (cbVarMk != null) {
            T t = this.d;
            if (iUo == 3) {
                com.bytedance.sdk.component.an.hc hcVarSy = bVar.sy();
                if (this.c == null && hcVarSy.h()) {
                    this.c = bVar.jh().hc(hcVarSy).d((rf) bVar.an());
                }
                T t2 = (T) this.c;
                if (t2 == null) {
                    t2 = this.d;
                }
                t = (T) t2;
                if (!(t instanceof byte[])) {
                    cbVarMk.d(2000, "final data is not raw", new RuntimeException("final data is not raw"));
                }
            } else if (iUo == 2 && (t instanceof byte[])) {
                try {
                    t = (T) bVar.jh().d(bVar).d((byte[]) t);
                } catch (Throwable th) {
                    cbVarMk.d(2000, "decode failed", th);
                    return;
                }
            }
            cbVarMk.d(new com.bytedance.sdk.component.an.b.c().d(bVar, t, hc(), this.b));
        }
    }
}
