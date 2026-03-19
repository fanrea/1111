package com.bykv.vk.openvk.component.video.d.c;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.openvk.component.video.api.d;
import com.bykv.vk.openvk.component.video.d.c.b;
import com.bytedance.sdk.component.utils.zw;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements com.bykv.vk.openvk.component.video.api.d, b.an, b.InterfaceC0160b, b.c, b.d, b.h, b.hc, b.u, zw.d {
    private static final AtomicInteger d = new AtomicInteger(0);
    private static final SparseIntArray he = new SparseIntArray();
    private SurfaceHolder b;
    private volatile boolean bc;
    private boolean de;
    private SurfaceTexture hc;
    private volatile zw k;
    private boolean mk;
    private boolean tc;
    private int u;
    private ArrayList<Runnable> v;
    private boolean vv;
    private int c = 0;
    private boolean an = false;
    private volatile b h = null;
    private final boolean gb = false;
    private boolean tt = false;
    private volatile int mq = 201;
    private long uo = -1;
    private volatile boolean e = false;
    private boolean cb = false;
    private long w = 0;
    private long yo = Long.MIN_VALUE;
    private long rf = 0;
    private long jh = 0;
    private long sy = 0;
    private int np = 0;
    private String yi = "0";
    private final List<WeakReference<d.InterfaceC0158d>> zw = new CopyOnWriteArrayList();
    private com.bykv.vk.openvk.component.video.api.b.c j = null;
    private boolean s = false;
    private volatile int us = 200;
    private AtomicBoolean z = new AtomicBoolean(false);
    private AtomicBoolean fs = new AtomicBoolean(false);
    private AtomicBoolean ba = new AtomicBoolean(false);
    private Surface mt = null;
    private final Runnable r = new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.h == null) {
                return;
            }
            long jRf = c.this.rf();
            if (jRf > 0 && Build.VERSION.SDK_INT >= 23 && c.this.uo() && c.this.yo != Long.MIN_VALUE) {
                try {
                    if (c.this.yo == jRf) {
                        if (!c.this.cb && c.this.rf >= 400) {
                            c.this.hc(701, 800);
                            c.this.cb = true;
                        }
                        c.this.rf += c.this.us;
                    } else {
                        if (c.this.cb) {
                            c.this.w += c.this.rf;
                            c.this.hc(702, 800);
                            com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_MEDIA", "handleMsg:  bufferingDuration =", Long.valueOf(c.this.w), "  bufferCount =", Integer.valueOf(c.this.c));
                        }
                        c.this.rf = 0L;
                        c.this.cb = false;
                    }
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_MEDIA", "error:" + th.getMessage());
                }
            }
            if (c.this.yo() > 0) {
                if (c.this.yo != jRf) {
                    if (com.bykv.vk.openvk.component.video.api.b.c()) {
                        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_MEDIA", "run: lastCur = ", Long.valueOf(c.this.yo), "  curPosition = ", Long.valueOf(jRf));
                    }
                    c cVar = c.this;
                    cVar.d(jRf, cVar.yo());
                }
                c.this.yo = jRf;
            }
            if (!c.this.tt()) {
                if (c.this.k != null) {
                    c.this.k.postDelayed(this, c.this.us);
                }
            } else {
                c cVar2 = c.this;
                cVar2.d(cVar2.yo(), c.this.yo());
            }
        }
    };
    private final d hv = new d();
    private long dc = 0;
    private long tr = 0;
    private boolean nv = false;

    private boolean d(int i, int i2) {
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, long j2) {
        for (WeakReference<d.InterfaceC0158d> weakReference : this.zw) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().d(this, j, j2);
            }
        }
    }

    public c(String str) {
        d("mda_" + str + Config.replace + d.addAndGet(1), (Looper) null);
    }

    private void d(String str, Looper looper) {
        this.np = 0;
        if (looper != null) {
            this.e = true;
            this.k = new zw(looper, this);
        } else if (this.k == null) {
            this.k = com.bytedance.sdk.component.tc.hc.d.d().d(this, "csj_" + str);
        }
        this.nv = Build.VERSION.SDK_INT >= 17;
        v();
    }

    private void de() {
        this.w = 0L;
        this.c = 0;
        this.rf = 0L;
        this.cb = false;
        this.yo = Long.MIN_VALUE;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void hc(final boolean z) {
        if (e()) {
            return;
        }
        this.vv = z;
        if (this.h != null) {
            this.h.d(z);
        } else if (this.k != null) {
            this.k.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.11
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.h != null) {
                        c.this.h.d(z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.k != null) {
            this.k.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.12
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.h == null) {
                        try {
                            c.this.h = new hc();
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO_MEDIA", th.getMessage());
                        }
                        if (c.this.h == null) {
                            return;
                        }
                        b unused = c.this.h;
                        c.this.yi = "0";
                        c.this.h.d((b.u) c.this);
                        c.this.h.d((b.hc) c.this);
                        c.this.h.d((b.InterfaceC0160b) c.this);
                        c.this.h.d((b.d) c.this);
                        c.this.h.d((b.an) c.this);
                        c.this.h.d((b.c) c.this);
                        c.this.h.d((b.h) c.this);
                        try {
                            c.this.h.b(false);
                        } catch (Throwable unused2) {
                        }
                        c.this.tt = false;
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d() {
        if (e() || this.h == null) {
            return;
        }
        if (this.mq != 206) {
            de();
            this.bc = false;
            this.hv.d(true);
            hc(0L);
            if (this.k != null) {
                this.k.removeCallbacks(this.r);
                this.k.postDelayed(this.r, this.us);
            }
        }
        this.z.set(true);
        if ((this.fs.get() || this.ba.get()) && this.k != null) {
            this.k.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.13
                @Override // java.lang.Runnable
                public void run() {
                    c.this.us();
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(boolean z, long j, boolean z2) {
        if (e()) {
            return;
        }
        v();
        this.s = z2;
        this.bc = false;
        d(z2);
        if (z) {
            this.uo = j;
            np();
        } else {
            hc(j);
        }
        if (this.k != null) {
            this.k.removeCallbacks(this.r);
            this.k.postDelayed(this.r, this.us);
        }
        this.z.set(true);
        if ((this.fs.get() || this.ba.get()) && this.k != null) {
            this.k.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.14
                @Override // java.lang.Runnable
                public void run() {
                    c.this.us();
                }
            });
        }
    }

    private void hc(long j) {
        this.hv.d(j);
        if (this.vv) {
            hc(this.hv);
        } else if (hc(this.j)) {
            hc(this.hv);
        } else {
            d(this.hv);
        }
    }

    private boolean hc(com.bykv.vk.openvk.component.video.api.b.c cVar) {
        return cVar != null && cVar.h();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void hc() {
        if (e() || this.k == null) {
            return;
        }
        this.z.set(true);
        this.k.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.15
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.k() || c.this.h == null) {
                    return;
                }
                try {
                    c.this.h.u();
                    com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_MEDIA", "resume play exec start ");
                    for (WeakReference weakReference : c.this.zw) {
                        if (weakReference != null && weakReference.get() != null) {
                            weakReference.get();
                        }
                    }
                    c.this.mq = 206;
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_MEDIA", "play: catch exception ", th.getMessage());
                }
            }
        });
    }

    class d implements Runnable {
        private boolean b;
        private long hc;

        d() {
        }

        public void d(boolean z) {
            this.b = z;
        }

        public void d(long j) {
            this.hc = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.h != null) {
                try {
                    if (!this.b) {
                        long jTt = c.this.h.tt();
                        c.this.uo = Math.max(this.hc, jTt);
                    }
                    long unused = c.this.uo;
                } catch (Throwable unused2) {
                }
            }
            if (c.this.k != null) {
                c.this.k.sendEmptyMessageDelayed(100, 0L);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void b() {
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_MEDIA", "pause: from outer");
        if (e() || this.k == null) {
            return;
        }
        this.k.removeMessages(100);
        this.bc = true;
        if (!this.nv) {
            if (this.de || hc(this.j)) {
                if (this.k != null) {
                    this.k.sendEmptyMessage(101);
                    return;
                }
                return;
            }
            d(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.16
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.k != null) {
                        c.this.k.sendEmptyMessage(101);
                    }
                }
            });
            return;
        }
        if (this.an || hc(this.j)) {
            if (this.k != null) {
                this.k.sendEmptyMessage(101);
                return;
            }
            return;
        }
        d(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.17
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.k != null) {
                    c.this.k.sendEmptyMessage(101);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void u() {
        if (e()) {
            return;
        }
        this.mk = true;
        z();
        if (this.k != null) {
            try {
                this.k.removeCallbacksAndMessages(null);
                if (this.h != null) {
                    this.k.sendEmptyMessage(103);
                }
                he();
            } catch (Throwable unused) {
                he();
            }
        }
    }

    private void np() {
        hc(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.k != null) {
                    c.this.k.sendEmptyMessage(104);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void c() {
        if (e()) {
            return;
        }
        hc(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.k != null) {
                    c.this.k.sendEmptyMessage(105);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(final long j) {
        if (e()) {
            return;
        }
        if (this.mq == 207 || this.mq == 206 || this.mq == 209) {
            hc(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.k != null) {
                        c.this.k.obtainMessage(106, Long.valueOf(j)).sendToTarget();
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean an() {
        return this.an;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(final SurfaceTexture surfaceTexture) {
        if (e()) {
            return;
        }
        this.hc = surfaceTexture;
        hc(true);
        hc(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.v();
                if (c.this.k != null) {
                    c.this.k.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(final SurfaceHolder surfaceHolder) {
        if (e()) {
            return;
        }
        this.b = surfaceHolder;
        hc(true);
        hc(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.6
            @Override // java.lang.Runnable
            public void run() {
                c.this.v();
                if (c.this.k != null) {
                    c.this.k.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    public int jh() {
        if (e()) {
            return 203;
        }
        return this.mq;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(final com.bykv.vk.openvk.component.video.api.b.c cVar) {
        if (e()) {
            return;
        }
        this.j = cVar;
        if (cVar != null) {
            this.nv = this.nv && !cVar.h();
        }
        hc(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.7
            @Override // java.lang.Runnable
            public void run() {
                c.this.v();
                if (c.this.k != null) {
                    c.this.k.obtainMessage(107, cVar).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean uo() {
        return (this.mq == 206 || (this.k != null && this.k.hasMessages(100))) && !this.bc;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean tc() {
        return sy() || uo() || k();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean k() {
        return ((this.mq != 207 && !this.bc) || this.k == null || this.k.hasMessages(100)) ? false : true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean e() {
        return this.mk;
    }

    public boolean sy() {
        return this.mq == 205;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean tt() {
        return this.mq == 209;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x015e  */
    @Override // com.bytedance.sdk.component.utils.zw.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(android.os.Message r17) {
        /*
            Method dump skipped, instructions count: 666
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.d.c.c.d(android.os.Message):void");
    }

    private void d(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.h.d(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void yi() {
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_MEDIA", "releaseMediaPlayer: ");
        if (this.h == null) {
            return;
        }
        try {
            this.h.mq();
        } catch (Throwable unused) {
        }
        this.h.d((b.hc) null);
        this.h.d((b.h) null);
        this.h.d((b.d) null);
        this.h.d((b.c) null);
        this.h.d((b.InterfaceC0160b) null);
        this.h.d((b.u) null);
        this.h.d((b.an) null);
        try {
            this.h.mk();
        } catch (Throwable unused2) {
        }
    }

    private void he() {
        zw zwVar = this.k;
        if (zwVar == null || zwVar.getLooper() == null) {
            return;
        }
        zwVar.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.8
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.k == null || c.this.k.getLooper() == null) {
                    return;
                }
                try {
                    if (c.this.e) {
                        c.this.k.removeCallbacksAndMessages(null);
                    } else {
                        com.bytedance.sdk.component.tc.hc.d.d().d(c.this.k);
                    }
                    c.this.k = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b.d
    public void d(b bVar, int i) {
        if (this.h != bVar) {
            return;
        }
        for (WeakReference<d.InterfaceC0158d> weakReference : this.zw) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().hc(this, i);
            }
        }
    }

    private void vv() {
        SparseIntArray sparseIntArray = he;
        Integer numValueOf = Integer.valueOf(sparseIntArray.get(this.np));
        if (numValueOf == null) {
            sparseIntArray.put(this.np, 1);
        } else {
            sparseIntArray.put(this.np, numValueOf.intValue() + 1);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b.hc
    public void d(b bVar) {
        this.mq = 209;
        he.delete(this.np);
        if (this.k != null) {
            this.k.removeCallbacks(this.r);
        }
        for (WeakReference<d.InterfaceC0158d> weakReference : this.zw) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().d(this);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b.InterfaceC0160b
    public boolean d(b bVar, int i, int i2) {
        com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO_MEDIA", "what=" + i + "extra=" + i2);
        vv();
        this.mq = 200;
        if (this.k != null) {
            this.k.removeCallbacks(this.r);
        }
        if (d(i, i2)) {
            he();
        }
        if (!this.z.get()) {
            return true;
        }
        this.z.set(false);
        com.bykv.vk.openvk.component.video.api.b.hc hcVar = new com.bykv.vk.openvk.component.video.api.b.hc(i, i2);
        for (WeakReference<d.InterfaceC0158d> weakReference : this.zw) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().d(this, hcVar);
            }
        }
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b.c
    public boolean hc(b bVar, int i, int i2) {
        com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO_MEDIA", "what,extra:" + i + "," + i2);
        if (this.h != bVar) {
            return false;
        }
        if (i2 == -1004) {
            com.bykv.vk.openvk.component.video.api.b.hc hcVar = new com.bykv.vk.openvk.component.video.api.b.hc(i, i2);
            for (WeakReference<d.InterfaceC0158d> weakReference : this.zw) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().d(this, hcVar);
                }
            }
        }
        hc(i, i2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(int i, int i2) {
        if (i == 701) {
            this.dc = SystemClock.elapsedRealtime();
            this.c++;
            for (WeakReference<d.InterfaceC0158d> weakReference : this.zw) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().d(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.c));
            return;
        }
        if (i == 702) {
            if (this.dc > 0) {
                this.tr += SystemClock.elapsedRealtime() - this.dc;
                this.dc = 0L;
            }
            for (WeakReference<d.InterfaceC0158d> weakReference2 : this.zw) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    weakReference2.get().d((com.bykv.vk.openvk.component.video.api.d) this, Integer.MAX_VALUE);
                }
            }
            com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.c), " mBufferTotalTime = ", Long.valueOf(this.tr));
            return;
        }
        if (this.nv && i == 3) {
            com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_MEDIA", "hasPendingPauseCommand:" + this.bc);
            us();
            zw();
            d(this.s);
            com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_MEDIA", "onRenderStart");
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b.u
    public void hc(b bVar) {
        if (e()) {
            return;
        }
        this.mq = 205;
        try {
            com.bykv.vk.openvk.component.video.api.b.c cVar = this.j;
            if (cVar != null) {
                float fE = cVar.e();
                if (fE > 0.0f) {
                    com.bykv.vk.openvk.component.video.api.hc hcVar = new com.bykv.vk.openvk.component.video.api.hc();
                    hcVar.d(fE);
                    this.h.d(hcVar);
                }
            }
        } catch (Throwable unused) {
        }
        if (this.k != null) {
            if (this.bc) {
                j();
            } else {
                com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO_MEDIA", "onPrepared op_Start");
                this.k.sendMessage(this.k.obtainMessage(100, -1, -1));
            }
        }
        he.delete(this.np);
        com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO_MEDIA", "onPrepared:" + this.nv + " " + this.de);
        if (!this.nv && !this.de) {
            zw();
            this.de = true;
        }
        for (WeakReference<d.InterfaceC0158d> weakReference : this.zw) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().hc(this);
            }
        }
    }

    private void zw() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.sy;
        for (WeakReference<d.InterfaceC0158d> weakReference : this.zw) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().d(this, jElapsedRealtime);
            }
        }
        this.an = true;
    }

    private void j() {
        if (this.k != null) {
            this.k.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c.this.h.h();
                        c.this.mq = 207;
                        c.this.bc = false;
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b.an
    public void b(b bVar) {
        for (WeakReference<d.InterfaceC0158d> weakReference : this.zw) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().d((com.bykv.vk.openvk.component.video.api.d) this, true);
            }
        }
    }

    private void d(Runnable runnable) {
        try {
            if (this.v == null) {
                this.v = new ArrayList<>();
            }
            this.v.add(runnable);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO_MEDIA", th.getMessage());
        }
    }

    private void s() {
        if (this.tc) {
            return;
        }
        this.tc = true;
        Iterator it = new ArrayList(this.v).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.v.clear();
        this.tc = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void us() {
        ArrayList<Runnable> arrayList = this.v;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        s();
    }

    private void z() {
        ArrayList<Runnable> arrayList = this.v;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.v.clear();
    }

    private void hc(Runnable runnable) {
        if (runnable == null || e()) {
            return;
        }
        if (!this.mk) {
            runnable.run();
        } else {
            d(runnable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(final boolean z) {
        if (e()) {
            return;
        }
        if (this.k == null) {
            com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_MEDIA", "quietPlay set opHandler is null");
        } else {
            this.k.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.c.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.e() || c.this.h == null) {
                        return;
                    }
                    try {
                        c.this.s = z;
                        c.this.h.c(z);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public long cb() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.cb) {
                long j = this.rf;
                if (j > 0) {
                    return this.w + j;
                }
            }
            return this.w;
        }
        return this.tr;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public int mk() {
        if (this.h == null || e()) {
            return 0;
        }
        return this.h.uo();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public int mq() {
        if (this.h == null || e()) {
            return 0;
        }
        return this.h.k();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public int w() {
        return this.c;
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b.h
    public void d(b bVar, int i, int i2, int i3, int i4) {
        for (WeakReference<d.InterfaceC0158d> weakReference : this.zw) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().d((com.bykv.vk.openvk.component.video.api.d) this, i, i2);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public long yo() {
        long j = this.jh;
        if (j != 0) {
            return j;
        }
        if (this.mq == 206 || this.mq == 207) {
            try {
                this.jh = this.h.tc();
            } catch (Throwable unused) {
            }
        }
        return this.jh;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public long rf() {
        if (e()) {
            return 0L;
        }
        if (this.mq == 206 || this.mq == 207) {
            try {
                return this.h.tt();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void b(boolean z) {
        if (e()) {
            return;
        }
        this.h.u(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(d.InterfaceC0158d interfaceC0158d) {
        if (interfaceC0158d == null) {
            return;
        }
        for (WeakReference<d.InterfaceC0158d> weakReference : this.zw) {
            if (weakReference != null && weakReference.get() == interfaceC0158d) {
                return;
            }
        }
        this.zw.add(new WeakReference<>(interfaceC0158d));
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void hc(int i) {
        if (e()) {
            return;
        }
        this.us = i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public SurfaceHolder h() {
        return this.b;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public SurfaceTexture gb() {
        return this.hc;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(int i) {
        this.u = i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(float f) {
        try {
            com.bykv.vk.openvk.component.video.api.hc hcVar = new com.bykv.vk.openvk.component.video.api.hc();
            hcVar.d(f);
            this.h.d(hcVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
