package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.d.d;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class gb {
    private Handler an;
    private long b;
    private long c;
    private final Queue<Integer> d;
    private Runnable h;
    private boolean hc;
    private SoftReference<JumpUnknownSourceActivity> u;

    private gb() {
        this.d = new ArrayDeque();
        this.hc = false;
        this.an = new Handler(Looper.getMainLooper());
        this.h = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.gb.1
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                gb.this.b();
            }
        };
        com.ss.android.socialbase.downloader.d.d.d().d(new d.InterfaceC0785d() { // from class: com.ss.android.socialbase.appdownloader.gb.2
            @Override // com.ss.android.socialbase.downloader.d.d.InterfaceC0785d
            public void b() {
            }

            @Override // com.ss.android.socialbase.downloader.d.d.InterfaceC0785d
            public void hc() throws JSONException {
                if (gb.this.d.isEmpty()) {
                    return;
                }
                long jD = com.ss.android.socialbase.downloader.uo.d.b().d("install_on_resume_install_interval", 120000L);
                long jCurrentTimeMillis = System.currentTimeMillis() - gb.this.c;
                if (jCurrentTimeMillis < jD) {
                    if (gb.this.an.hasCallbacks(gb.this.h)) {
                        return;
                    }
                    gb.this.an.postDelayed(gb.this.h, jD - jCurrentTimeMillis);
                } else {
                    gb.this.c = System.currentTimeMillis();
                    gb.this.b();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() throws JSONException {
        final Integer numPoll;
        if (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.d.d.d().hc()) {
            synchronized (this.d) {
                numPoll = this.d.poll();
            }
            this.an.removeCallbacks(this.h);
            if (numPoll != null) {
                final Context contextTr = com.ss.android.socialbase.downloader.downloader.b.tr();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.an.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.gb.3
                        @Override // java.lang.Runnable
                        public void run() throws JSONException {
                            gb.this.hc(contextTr, numPoll.intValue(), false);
                        }
                    });
                } else {
                    hc(contextTr, numPoll.intValue(), false);
                }
                this.an.postDelayed(this.h, 20000L);
                return;
            }
            this.hc = false;
        }
    }

    void d(com.ss.android.socialbase.downloader.h.b bVar, String str) throws JSONException {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        b();
    }

    private static class d {
        private static final gb d = new gb();
    }

    public static gb d() {
        return d.d;
    }

    public int d(final Context context, final int i, final boolean z) {
        if (z) {
            return hc(context, i, z);
        }
        if (c()) {
            this.an.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.gb.4
                @Override // java.lang.Runnable
                public void run() {
                    gb.this.d(context, i, z);
                }
            }, 1000L);
            return 1;
        }
        if (com.ss.android.socialbase.downloader.d.d.d().hc()) {
            com.ss.android.socialbase.downloader.an.d.b("leaves", "on Foreground");
            return hc(context, i, z);
        }
        if (hc.d()) {
            return 1;
        }
        boolean z2 = Build.VERSION.SDK_INT < 29;
        if (this.d.isEmpty() && !this.hc && z2) {
            return hc(context, i, z);
        }
        int iD = com.ss.android.socialbase.downloader.uo.d.b().d("install_queue_size", 3);
        synchronized (this.d) {
            while (this.d.size() > iD) {
                this.d.poll();
            }
        }
        if (z2) {
            this.an.removeCallbacks(this.h);
            this.an.postDelayed(this.h, com.ss.android.socialbase.downloader.uo.d.d(i).d("install_queue_timeout", 20000L));
        }
        synchronized (this.d) {
            if (!this.d.contains(Integer.valueOf(i))) {
                this.d.offer(Integer.valueOf(i));
            }
        }
        return 1;
    }

    private boolean c() {
        return System.currentTimeMillis() - this.b < 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hc(Context context, int i, boolean z) throws JSONException {
        int iHc = b.hc(context, i, z);
        if (iHc == 1) {
            this.hc = true;
        }
        this.b = System.currentTimeMillis();
        return iHc;
    }

    public void d(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.u = new SoftReference<>(jumpUnknownSourceActivity);
    }

    public JumpUnknownSourceActivity hc() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.u;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.u = null;
        return jumpUnknownSourceActivity;
    }
}
