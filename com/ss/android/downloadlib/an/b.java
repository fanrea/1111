package com.ss.android.downloadlib.an;

import com.ss.android.socialbase.appdownloader.b.mk;
import com.ss.android.socialbase.appdownloader.b.tc;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements mk {
    private static volatile b d;
    private List<mk> hc;

    public static b d() {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b();
                }
            }
        }
        return d;
    }

    private b() {
        ArrayList arrayList = new ArrayList();
        this.hc = arrayList;
        arrayList.add(new hc());
        this.hc.add(new d());
    }

    @Override // com.ss.android.socialbase.appdownloader.b.mk
    public void d(com.ss.android.socialbase.downloader.h.b bVar, tc tcVar) {
        if (bVar != null && this.hc.size() != 0) {
            d(bVar, 0, tcVar);
        } else if (tcVar != null) {
            tcVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final com.ss.android.socialbase.downloader.h.b bVar, final int i, final tc tcVar) {
        if (i == this.hc.size() || i < 0) {
            tcVar.d();
        } else {
            this.hc.get(i).d(bVar, new tc() { // from class: com.ss.android.downloadlib.an.b.1
                @Override // com.ss.android.socialbase.appdownloader.b.tc
                public void d() {
                    b.this.d(bVar, i + 1, tcVar);
                }
            });
        }
    }
}
