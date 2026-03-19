package com.ss.android.downloadlib.hc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc {
    public void d(final com.ss.android.hc.d.hc.hc hcVar, final h hVar, int i) {
        com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.hc.hc.1
            @Override // java.lang.Runnable
            public void run() {
                if (tt.d(hcVar)) {
                    hVar.d(false);
                } else if (!an.d(hcVar)) {
                    hVar.d(false);
                } else {
                    an.d(hcVar, new gb() { // from class: com.ss.android.downloadlib.hc.hc.1.1
                        @Override // com.ss.android.downloadlib.hc.gb
                        public void d(boolean z) {
                            hVar.d(z);
                        }
                    });
                }
            }
        }, i);
    }
}
