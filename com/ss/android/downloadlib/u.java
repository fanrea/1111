package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.downloadlib.h.uo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u {
    private ScheduledExecutorService b;
    private ExecutorService c;
    private ExecutorService d;
    private ExecutorService hc;

    private static class d {
        private static u d = new u();
    }

    public static u d() {
        return d.d;
    }

    private u() {
    }

    public void d(Runnable runnable) {
        d(runnable, false);
    }

    public void hc(Runnable runnable) {
        hc(runnable, false);
    }

    public void d(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !uo.hc()) {
            runnable.run();
        } else {
            hc().execute(runnable);
        }
    }

    public void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        u().execute(runnable);
    }

    public void hc(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !uo.hc()) {
            runnable.run();
        } else {
            b().execute(runnable);
        }
    }

    public void d(Runnable runnable, long j) {
        try {
            c().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    public ExecutorService hc() {
        if (this.d == null) {
            synchronized (u.class) {
                if (this.d == null) {
                    this.d = new com.bytedance.sdk.component.tc.c.c(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.k.d(tc.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.d;
    }

    public ExecutorService b() {
        if (this.hc == null) {
            synchronized (u.class) {
                if (this.hc == null) {
                    this.hc = new com.bytedance.sdk.component.tc.c.c(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.k.d(tc.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.hc;
    }

    public ScheduledExecutorService c() {
        if (this.b == null) {
            synchronized (u.class) {
                if (this.b == null) {
                    this.b = new com.bytedance.sdk.component.tc.c.u(0, new com.ss.android.socialbase.downloader.k.d(tc.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.b;
    }

    public ExecutorService u() {
        if (this.c == null) {
            synchronized (u.class) {
                if (this.c == null) {
                    this.c = new com.bytedance.sdk.component.tc.c.c(5, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.k.d(tc.class.getName() + "-InstallFinishCheckCPUThreadPool"));
                }
            }
        }
        return this.c;
    }

    public void an() {
        d(new Runnable() { // from class: com.ss.android.downloadlib.u.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.downloader.mq mqVarNp;
                synchronized (u.class) {
                    try {
                        String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                        for (int i = 0; i < 13; i++) {
                            SharedPreferences sharedPreferencesD = com.bytedance.sdk.openadsdk.ats.b.d(com.ss.android.downloadlib.addownload.mq.getContext(), strArr[i], 0);
                            if (sharedPreferencesD != null) {
                                sharedPreferencesD.edit().clear().apply();
                            }
                        }
                        mqVarNp = com.ss.android.socialbase.downloader.downloader.b.np();
                    } catch (Throwable unused) {
                    }
                    if (mqVarNp instanceof com.ss.android.socialbase.downloader.impls.c) {
                        SparseArray<com.ss.android.socialbase.downloader.h.b> sparseArrayD = ((com.ss.android.socialbase.downloader.impls.c) mqVarNp).d().d();
                        for (int size = sparseArrayD.size() - 1; size >= 0; size--) {
                            com.ss.android.socialbase.downloader.h.b bVar = sparseArrayD.get(sparseArrayD.keyAt(size));
                            if (bVar != null) {
                                com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.downloadlib.addownload.mq.getContext()).tc(bVar.h());
                            }
                        }
                    }
                }
            }
        });
    }
}
