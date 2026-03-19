package com.ss.android.downloadlib.an;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.hc.an;
import com.ss.android.downloadlib.hc.tt;
import com.ss.android.socialbase.appdownloader.b.mk;
import com.ss.android.socialbase.appdownloader.b.tc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d implements mk {
    @Override // com.ss.android.socialbase.appdownloader.b.mk
    public void d(com.ss.android.socialbase.downloader.h.b bVar, final tc tcVar) {
        d(bVar, new com.ss.android.downloadlib.guide.install.d() { // from class: com.ss.android.downloadlib.an.d.1
            @Override // com.ss.android.downloadlib.guide.install.d
            public void d() {
                tcVar.d();
            }
        });
    }

    public void d(final com.ss.android.socialbase.downloader.h.b bVar, final com.ss.android.downloadlib.guide.install.d dVar) {
        com.ss.android.hc.d.hc.hc hcVarD = an.d().d(bVar);
        if (hcVarD != null && tt.d(hcVarD)) {
            TTDelegateActivity.d(hcVarD, new com.ss.android.downloadlib.guide.install.d() { // from class: com.ss.android.downloadlib.an.d.2
                @Override // com.ss.android.downloadlib.guide.install.d
                public void d() {
                    d.this.hc(bVar, dVar);
                }
            });
        } else {
            hc(bVar, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(com.ss.android.socialbase.downloader.h.b bVar, final com.ss.android.downloadlib.guide.install.d dVar) {
        com.ss.android.hc.d.hc.hc hcVarD = an.d().d(bVar);
        boolean zD = com.ss.android.downloadlib.hc.an.d(hcVarD);
        boolean zHc = com.ss.android.downloadlib.hc.an.hc(hcVarD);
        if (!zD || !zHc) {
            dVar.d();
        } else {
            com.ss.android.downloadlib.hc.b.d(hcVarD, new com.ss.android.downloadlib.guide.install.d() { // from class: com.ss.android.downloadlib.an.d.3
                @Override // com.ss.android.downloadlib.guide.install.d
                public void d() {
                    dVar.d();
                }
            });
        }
    }
}
