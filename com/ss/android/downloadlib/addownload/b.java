package com.ss.android.downloadlib.addownload;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    private static String d = "b";
    private static volatile b hc;
    private ConcurrentHashMap<Long, Runnable> b;

    public b() {
        this.b = null;
        this.b = new ConcurrentHashMap<>();
    }

    public static b d() {
        if (hc == null) {
            synchronized (b.class) {
                if (hc == null) {
                    hc = new b();
                }
            }
        }
        return hc;
    }

    public void d(u uVar, boolean z, int i, com.ss.android.d.d.b.b bVar) {
        if (bVar instanceof com.ss.android.hc.d.d.b) {
            ((com.ss.android.hc.d.d.b) bVar).b(3);
        }
        long jC = bVar.c();
        if (i == 4) {
            if (!z) {
                d(jC, false, 2);
                uVar.hc(false);
                return;
            } else {
                d(jC, true, 2);
                return;
            }
        }
        if (i == 5) {
            if (!z) {
                d(jC, false, 1);
                uVar.b(false);
                return;
            } else {
                d(jC, true, 1);
                return;
            }
        }
        if (i != 7) {
            return;
        }
        Runnable runnableRemove = this.b.remove(Long.valueOf(jC));
        if (z) {
            com.ss.android.downloadlib.c.d.d().d(jC, 1);
            d(jC, true, 1);
        } else {
            if (runnableRemove != null) {
                com.ss.android.downloadlib.gb.d().hc().post(runnableRemove);
            }
            d(jC, false, 1);
        }
    }

    private void d(long j, boolean z, int i) {
        com.ss.android.downloadlib.c.d.d().d(j, z, i);
        if (z) {
            mq.sy();
        }
    }

    public void d(final u uVar, final int i, final com.ss.android.d.d.b.b bVar) {
        com.ss.android.downloadlib.hc.u.d().d(new com.ss.android.downloadlib.hc.c() { // from class: com.ss.android.downloadlib.addownload.b.1
            @Override // com.ss.android.downloadlib.hc.c
            public void d(boolean z) {
                b.this.d(uVar, z, i, bVar);
            }
        }, hc());
    }

    public long hc() {
        return mq.tt().optLong("quick_app_check_internal", 1200L);
    }

    public static boolean d(com.ss.android.socialbase.downloader.h.b bVar) {
        return bVar == null || bVar.w() == 0 || bVar.w() == -4;
    }
}
