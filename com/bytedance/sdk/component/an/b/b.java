package com.bytedance.sdk.component.an.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.an.cb;
import com.bytedance.sdk.component.an.jh;
import com.bytedance.sdk.component.an.k;
import com.bytedance.sdk.component.an.mk;
import com.bytedance.sdk.component.an.tc;
import com.bytedance.sdk.component.an.tt;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements tt {
    private ImageView.ScaleType an;
    private String b;
    private String c;
    private jh cb;
    Future<?> d;
    private int de;
    private boolean e;
    private int gb;
    private Bitmap.Config h;
    private String hc;
    private int he;
    private ExecutorService j;
    private boolean jh;
    private boolean k;
    private int mk;
    private WeakReference<ImageView> mq;
    private com.bytedance.sdk.component.an.b.d np;
    private final Handler rf;
    private boolean s;
    private com.bytedance.sdk.component.an.h sy;
    private com.bytedance.sdk.component.an.gb tc;
    private int tt;
    private cb u;
    private volatile boolean uo;
    private k us;
    private an v;
    private int vv;
    private int w;
    private com.bytedance.sdk.component.an.hc yi;
    private Queue<com.bytedance.sdk.component.an.c.tt> yo;
    private boolean zw;

    private b(hc hcVar) {
        this.yo = new LinkedBlockingQueue();
        this.rf = new Handler(Looper.getMainLooper());
        this.jh = true;
        this.hc = hcVar.c;
        this.u = new d(hcVar.d);
        this.mq = new WeakReference<>(hcVar.hc);
        this.an = hcVar.u;
        this.h = hcVar.an;
        this.gb = hcVar.h;
        this.tt = hcVar.gb;
        this.mk = hcVar.tt;
        this.w = hcVar.tc;
        this.cb = hcVar.mk;
        this.yi = d(hcVar);
        if (!TextUtils.isEmpty(hcVar.b)) {
            hc(hcVar.b);
            d(hcVar.b);
        }
        this.k = hcVar.mq;
        this.e = hcVar.uo;
        this.v = hcVar.cb;
        this.tc = hcVar.w;
        this.vv = hcVar.rf;
        this.he = hcVar.yo;
        this.j = hcVar.sy;
        this.zw = hcVar.jh;
        this.s = hcVar.de;
        this.us = hcVar.v;
        this.yo.add(new com.bytedance.sdk.component.an.c.b());
    }

    private com.bytedance.sdk.component.an.hc d(hc hcVar) {
        if (hcVar.e != null) {
            return hcVar.e;
        }
        if (!TextUtils.isEmpty(hcVar.k)) {
            return com.bytedance.sdk.component.an.b.d.d.d(new File(hcVar.k));
        }
        return com.bytedance.sdk.component.an.b.d.d.tt();
    }

    public int tt() {
        return this.he;
    }

    public int tc() {
        return this.vv;
    }

    @Override // com.bytedance.sdk.component.an.tt
    @ATSMethod(2)
    public String hc() {
        return this.hc;
    }

    public cb mk() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.an.tt
    @ATSMethod(6)
    public String an() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    @Override // com.bytedance.sdk.component.an.tt
    @ATSMethod(7)
    public String h() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.an.tt
    @ATSMethod(8)
    public Bitmap.Config gb() {
        return this.h;
    }

    public void hc(String str) {
        WeakReference<ImageView> weakReference = this.mq;
        if (weakReference != null && weakReference.get() != null) {
            this.mq.get().setTag(1094453505, str);
        }
        this.b = str;
    }

    @Override // com.bytedance.sdk.component.an.tt
    @ATSMethod(5)
    public ImageView.ScaleType u() {
        return this.an;
    }

    public Bitmap.Config mq() {
        return this.h;
    }

    @Override // com.bytedance.sdk.component.an.tt
    @ATSMethod(3)
    public int b() {
        return this.gb;
    }

    @Override // com.bytedance.sdk.component.an.tt
    @ATSMethod(4)
    public int c() {
        return this.tt;
    }

    public int uo() {
        return this.mk;
    }

    public boolean k() {
        return this.k;
    }

    public boolean e() {
        return this.e;
    }

    public void d(boolean z) {
        this.jh = z;
    }

    public boolean cb() {
        return this.jh;
    }

    public com.bytedance.sdk.component.an.h w() {
        return this.sy;
    }

    public void d(com.bytedance.sdk.component.an.h hVar) {
        this.sy = hVar;
    }

    public int yo() {
        return this.de;
    }

    public void d(int i) {
        this.de = i;
    }

    public com.bytedance.sdk.component.an.b.d rf() {
        return this.np;
    }

    public void d(com.bytedance.sdk.component.an.b.d dVar) {
        this.np = dVar;
    }

    public an jh() {
        return this.v;
    }

    public com.bytedance.sdk.component.an.hc sy() {
        return this.yi;
    }

    public boolean d(com.bytedance.sdk.component.an.c.tt ttVar) {
        if (this.uo) {
            return false;
        }
        return this.yo.add(ttVar);
    }

    public boolean de() {
        return this.zw;
    }

    public k v() {
        return this.us;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public tt yi() {
        an anVar;
        try {
            anVar = this.v;
        } catch (Exception e) {
            mq.c("ImageRequest", e.getMessage());
        }
        if (anVar == null) {
            cb cbVar = this.u;
            if (cbVar != null) {
                cbVar.d(1005, "not init !", null);
            }
            return this;
        }
        ExecutorService executorServiceAn = this.j == null ? anVar.an() : null;
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.an.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.an.c.tt ttVar;
                while (!b.this.uo && (ttVar = (com.bytedance.sdk.component.an.c.tt) b.this.yo.poll()) != null) {
                    try {
                        if (b.this.cb != null) {
                            b.this.cb.d(ttVar.d(), b.this);
                        }
                        ttVar.d(b.this);
                        if (b.this.cb != null) {
                            b.this.cb.hc(ttVar.d(), b.this);
                        }
                    } catch (Throwable th) {
                        b.this.d(2000, th.getMessage(), th);
                        if (b.this.cb != null) {
                            b.this.cb.hc("exception", b.this);
                            return;
                        }
                        return;
                    }
                }
                if (b.this.uo) {
                    b.this.d(1003, "canceled", null);
                }
            }
        };
        if (this.s) {
            runnable.run();
        } else {
            ExecutorService executorService = this.j;
            if (executorService != null) {
                this.d = executorService.submit(runnable);
            } else if (executorServiceAn != null) {
                this.d = executorServiceAn.submit(runnable);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, String str, Throwable th) {
        new com.bytedance.sdk.component.an.c.gb(i, str, th).d(this);
        this.yo.clear();
    }

    @Override // com.bytedance.sdk.component.an.tt
    @ATSMethod(1)
    public boolean d() {
        this.uo = true;
        Future<?> future = this.d;
        if (future != null) {
            return future.cancel(true);
        }
        return true;
    }

    public String np() {
        return an();
    }

    public static class hc implements tc {
        private Bitmap.Config an;
        private String b;
        private String c;
        private an cb;
        private cb d;
        private boolean de;
        private com.bytedance.sdk.component.an.hc e;
        private int gb;
        private int h;
        private ImageView hc;
        private boolean jh;
        private String k;
        private jh mk;
        private boolean mq;
        private int rf;
        private ExecutorService sy;
        private ImageView.ScaleType u;
        private boolean uo;
        private k v;
        private com.bytedance.sdk.component.an.gb w;
        private int yo;
        private int tt = 1;
        private int tc = 5;

        public hc(an anVar) {
            this.cb = anVar;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(4)
        public tc d(String str) {
            this.c = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(5)
        public tc hc(String str) {
            this.b = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(6)
        public tc d(com.bytedance.sdk.component.an.hc hcVar) {
            this.e = hcVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(8)
        public tc d(ImageView.ScaleType scaleType) {
            this.u = scaleType;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(9)
        public tc d(Bitmap.Config config) {
            this.an = config;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(10)
        public tc d(int i) {
            this.h = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(11)
        public tc hc(int i) {
            this.gb = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(12)
        public tc b(int i) {
            this.tt = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(13)
        public tc d(jh jhVar) {
            this.mk = jhVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(14)
        public tc d(boolean z) {
            this.mq = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(15)
        public tc hc(boolean z) {
            this.uo = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(16)
        public tc d(ExecutorService executorService) {
            this.sy = executorService;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(7)
        public tc b(String str) {
            this.k = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(1)
        public tt d(cb cbVar, int i) {
            this.tc = i;
            return d(cbVar);
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(2)
        public tt d(cb cbVar) {
            this.d = cbVar;
            return new b(this).yi();
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(3)
        public tt d(ImageView imageView) {
            this.hc = imageView;
            return new b(this).yi();
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(17)
        public tc d(com.bytedance.sdk.component.an.gb gbVar) {
            this.w = gbVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(18)
        public tc c(int i) {
            this.yo = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(19)
        public tc u(int i) {
            this.rf = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(20)
        public tc b(boolean z) {
            this.de = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.an.tc
        @ATSMethod(21)
        public tc d(k kVar) {
            this.v = kVar;
            return this;
        }
    }

    private class d implements cb {
        private cb hc;

        public d(cb cbVar) {
            this.hc = cbVar;
        }

        @Override // com.bytedance.sdk.component.an.cb
        @ATSMethod(1)
        public void d(final mk mkVar) {
            final ImageView imageView = (ImageView) b.this.mq.get();
            if (imageView != null && b.this.mk != 3 && d(imageView) && (mkVar.b() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) mkVar.b();
                b.this.rf.post(new Runnable() { // from class: com.bytedance.sdk.component.an.b.b.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (b.this.tc != null && (mkVar.b() instanceof Bitmap)) {
                    com.bytedance.sdk.component.an.gb gbVar = b.this.tc;
                    Bitmap bitmap2 = (Bitmap) mkVar.b();
                    Bitmap bitmapD = gbVar.d(bitmap2);
                    if (bitmapD != null) {
                        mkVar.setResult(bitmapD);
                    }
                }
            } catch (Throwable unused) {
            }
            if (b.this.w == 5) {
                b.this.rf.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.component.an.b.b.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.hc != null) {
                            d.this.hc.d(mkVar);
                        }
                    }
                });
                return;
            }
            cb cbVar = this.hc;
            if (cbVar != null) {
                cbVar.d(mkVar);
            }
        }

        private boolean d(ImageView imageView) {
            Object tag;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(b.this.b)) ? false : true;
        }

        @Override // com.bytedance.sdk.component.an.cb
        @ATSMethod(2)
        public void d(final int i, final String str, final Throwable th) {
            if (b.this.w == 5) {
                b.this.rf.post(new Runnable() { // from class: com.bytedance.sdk.component.an.b.b.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.hc != null) {
                            d.this.hc.d(i, str, th);
                        }
                    }
                });
                return;
            }
            cb cbVar = this.hc;
            if (cbVar != null) {
                cbVar.d(i, str, th);
            }
        }
    }
}
