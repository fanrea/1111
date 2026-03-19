package com.ss.android.socialbase.downloader.tt;

import android.net.Uri;
import android.os.Handler;
import java.net.InetAddress;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    private final Handler b;
    private final com.ss.android.socialbase.downloader.e.gb<String, hc> d;
    private final Handler hc;

    public interface d {
        void d(String str, List<InetAddress> list);
    }

    /* renamed from: com.ss.android.socialbase.downloader.tt.b$b, reason: collision with other inner class name */
    private static class C0794b {
        private static final b d = new b();
    }

    private b() {
        this.d = new com.ss.android.socialbase.downloader.e.gb<>(4, 16, false);
        this.hc = new Handler(com.ss.android.socialbase.downloader.tt.d.hc.d());
        this.b = new Handler(com.ss.android.socialbase.downloader.k.u.d());
    }

    public static b d() {
        return C0794b.d;
    }

    public void d(final String str, final d dVar, final long j) {
        this.hc.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.tt.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.hc(str, dVar, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(final String str, final d dVar, long j) {
        final hc hcVar;
        an anVarSy;
        try {
            String host = Uri.parse(str).getHost();
            synchronized (this.d) {
                hcVar = this.d.get(host);
            }
            if (hcVar != null) {
                if (System.currentTimeMillis() - hcVar.hc < com.ss.android.socialbase.downloader.uo.d.b().d("dns_expire_min", 10) * 60 * 1000) {
                    if (dVar != null) {
                        dVar.d(str, hcVar.d);
                        return;
                    }
                    return;
                }
            }
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.tt.b.2
                @Override // java.lang.Runnable
                public void run() {
                    d dVar2 = dVar;
                    if (dVar2 != null) {
                        String str2 = str;
                        hc hcVar2 = hcVar;
                        dVar2.d(str2, hcVar2 == null ? null : hcVar2.d);
                    }
                }
            };
            this.b.postDelayed(runnable, j);
            List<InetAddress> listD = null;
            if (com.ss.android.socialbase.downloader.uo.d.b().d("use_host_dns", 1) == 1 && (anVarSy = com.ss.android.socialbase.downloader.downloader.b.sy()) != null) {
                try {
                    listD = anVarSy.d(host);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.mq.d(th);
                }
            }
            if (listD == null || listD.isEmpty()) {
                try {
                    listD = com.ss.android.socialbase.downloader.downloader.b.de().d(host);
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.mq.d(th2);
                }
            }
            if (listD != null && !listD.isEmpty()) {
                d(host, listD);
            } else if (hcVar != null) {
                listD = hcVar.d;
            }
            this.b.removeCallbacks(runnable);
            if (dVar != null) {
                dVar.d(str, listD);
            }
        } catch (Throwable th3) {
            com.bytedance.sdk.component.utils.mq.d(th3);
        }
    }

    private void d(String str, List<InetAddress> list) {
        synchronized (this.d) {
            hc hcVar = this.d.get(str);
            if (hcVar == null) {
                hcVar = new hc();
                this.d.put(str, hcVar);
            }
            hcVar.d = list;
            hcVar.hc = System.currentTimeMillis();
        }
    }

    private static class hc {
        List<InetAddress> d;
        long hc;

        private hc() {
        }
    }
}
