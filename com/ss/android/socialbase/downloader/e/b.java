package com.ss.android.socialbase.downloader.e;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.downloader.c.jh;
import com.ss.android.socialbase.downloader.c.vv;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    public static void d(int i, SparseArray<vv> sparseArray, boolean z, com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar) {
        SparseArray<vv> sparseArrayClone;
        if (!z || sparseArray == null) {
            return;
        }
        try {
            if (sparseArray.size() <= 0) {
                return;
            }
            synchronized (sparseArray) {
                sparseArrayClone = sparseArray.clone();
            }
            for (int i2 = 0; i2 < sparseArrayClone.size(); i2++) {
                vv vvVar = sparseArrayClone.get(sparseArrayClone.keyAt(i2));
                if (vvVar != null) {
                    if (i == 1) {
                        vvVar.d(bVar);
                    } else if (i == 2) {
                        vvVar.hc(bVar);
                    } else if (i == 4) {
                        vvVar.b(bVar);
                    } else if (i == 5) {
                        vvVar.hc(bVar, dVar);
                    } else if (i == 6) {
                        vvVar.gb(bVar);
                    } else if (i == 7) {
                        vvVar.b(bVar, dVar);
                    } else if (i != 11) {
                        switch (i) {
                            case -7:
                                if (vvVar instanceof com.ss.android.socialbase.downloader.c.b) {
                                    ((com.ss.android.socialbase.downloader.c.b) vvVar).tc(bVar);
                                    break;
                                } else {
                                    break;
                                }
                            case -6:
                                vvVar.tt(bVar);
                                break;
                            case -5:
                            case -2:
                                vvVar.c(bVar);
                                break;
                            case -4:
                                vvVar.an(bVar);
                                break;
                            case -3:
                                vvVar.u(bVar);
                                break;
                            case -1:
                                vvVar.d(bVar, dVar);
                                break;
                        }
                    } else if (vvVar instanceof jh) {
                        ((jh) vvVar).h(bVar);
                    }
                }
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }
}
