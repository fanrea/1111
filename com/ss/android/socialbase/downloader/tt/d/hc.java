package com.ss.android.socialbase.downloader.tt.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.downloader.e.an;
import com.ss.android.socialbase.downloader.h.u;
import com.ss.android.socialbase.downloader.tt.mk;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc {
    private static final HandlerThread b;
    private static final Handler c;
    static long d;
    static long hc;

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        b = handlerThread;
        hc();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        c = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.tt.d.hc.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static Looper d() {
        return b.getLooper();
    }

    public static void d(final String str, final mk mkVar) {
        c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.tt.d.hc.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        try {
                            List<u> listHc = hc.hc(0L, null, null);
                            bVarD = d.d().d(str) ? d.d().d(str, listHc) : null;
                            if (bVarD == null) {
                                b bVar = new b(str, listHc, 0L);
                                try {
                                    bVar.d();
                                    if (bVar.u()) {
                                        d.d().d(str, bVar);
                                    }
                                    bVarD = bVar;
                                } catch (Exception e) {
                                    e = e;
                                    bVarD = bVar;
                                    mq.d(e);
                                    try {
                                        bVarD.b();
                                        return;
                                    } catch (Throwable unused) {
                                        return;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    bVarD = bVar;
                                    try {
                                        bVarD.b();
                                    } catch (Throwable unused2) {
                                    }
                                    throw th;
                                }
                            }
                            Map<String, String> mapTt = bVarD.tt();
                            mk mkVar2 = mkVar;
                            if (mkVar2 != null) {
                                mkVar2.d(mapTt);
                            }
                            try {
                                bVarD.b();
                            } catch (Throwable unused3) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } else {
                    mk mkVar3 = mkVar;
                    if (mkVar3 != null) {
                        mkVar3.d(null);
                    }
                }
            }
        });
    }

    private static void hc() {
        d = com.ss.android.socialbase.downloader.uo.d.b().d("preconnect_connection_outdate_time", 300000L);
        hc = com.ss.android.socialbase.downloader.uo.d.b().d("preconnect_head_info_outdate_time", 300000L);
        d.d().d(com.ss.android.socialbase.downloader.uo.d.b().d("preconnect_max_cache_size", 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<u> hc(long j, com.ss.android.socialbase.downloader.h.b bVar, List<u> list) {
        return an.d(list, bVar == null ? null : bVar.o(), j, 0L);
    }
}
