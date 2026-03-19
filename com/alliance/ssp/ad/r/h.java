package com.alliance.ssp.ad.r;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.alliance.ssp.ad.o0.k;
import com.alliance.ssp.ad.o0.p;
import com.alliance.ssp.ad.r.i;

/* compiled from: ImageLoader.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class h implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ i.a b;
    public final /* synthetic */ i c;

    /* compiled from: ImageLoader.java */
    public class a implements Runnable {
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ Exception b;

        public a(Bitmap bitmap, Exception exc) {
            this.a = bitmap;
            this.b = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setUncaughtExceptionHandler(p.d);
            Bitmap bitmap = this.a;
            if (bitmap != null) {
                h hVar = h.this;
                i.a aVar = hVar.b;
                if (aVar != null) {
                    aVar.a(hVar.a, bitmap);
                    return;
                }
                return;
            }
            h hVar2 = h.this;
            i.a aVar2 = hVar2.b;
            if (aVar2 != null) {
                Exception exc = this.b;
                if (exc != null) {
                    aVar2.a(hVar2.a, exc);
                } else {
                    aVar2.a(hVar2.a, new Exception("download image exception"));
                }
            }
        }
    }

    public h(i iVar, String str, i.a aVar) {
        this.c = iVar;
        this.a = str;
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.alliance.ssp.ad.s.c cVar;
        Thread.currentThread().setUncaughtExceptionHandler(p.d);
        Bitmap bitmapB = null;
        try {
            e = null;
            bitmapB = c.b(this.a);
        } catch (Exception e) {
            e = e;
            e.printStackTrace();
        }
        synchronized (k.b) {
            if (k.a == null) {
                k.a = new Handler(Looper.getMainLooper());
            }
        }
        k.a.post(new a(bitmapB, e));
        if (bitmapB == null || (cVar = this.c.a) == null) {
            return;
        }
        cVar.a(this.a, bitmapB);
    }
}
