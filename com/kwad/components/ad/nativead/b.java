package com.kwad.components.ad.nativead;

import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.ca;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private static long iV;
    private com.kwad.sdk.core.g.d iQ;
    private com.kwad.sdk.core.g.c iR;
    private CopyOnWriteArrayList<d> qs = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<C0428b> qt = new CopyOnWriteArrayList<>();
    private int qu;

    public interface c {
        void D(String str);
    }

    public interface e {
        void i(double d);
    }

    static final class a {
        private static final b qx = new b();
    }

    public static b fr() {
        return a.qx;
    }

    public static class d {
        private final WeakReference<View> qA;
        private final e qz;

        public d(e eVar, View view) {
            this.qA = new WeakReference<>(view);
            this.qz = eVar;
        }
    }

    /* renamed from: com.kwad.components.ad.nativead.b$b, reason: collision with other inner class name */
    public static class C0428b {
        private Context mContext;
        private c qy;

        public C0428b(c cVar, Context context) {
            this.qy = cVar;
            this.mContext = context;
        }
    }

    public final void a(float f, View view, e eVar) {
        if (view == null || view.getContext() == null) {
            return;
        }
        if (this.iQ == null) {
            this.qu = com.kwad.sdk.c.a.a.bu(view.getContext());
            a(f, view.getContext());
        }
        this.qs.add(new d(eVar, view));
    }

    public final void a(e eVar) {
        Iterator<d> it = this.qs.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.qz == eVar) {
                this.qs.remove(next);
            }
        }
        com.kwad.sdk.core.d.c.d("KSNativeAdRotateAndShakeManager", "sShakeItems size " + this.qs.size());
    }

    private void a(float f, Context context) {
        this.iQ = new com.kwad.sdk.core.g.d(f);
        this.qs = new CopyOnWriteArrayList<>();
        this.iQ.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.nativead.b.1
            @Override // com.kwad.sdk.core.g.b
            public final void ci() {
            }

            @Override // com.kwad.sdk.core.g.b
            public final void d(double d2) {
                if (b.this.qs != null) {
                    b.this.h(d2);
                    bx.a(new bh() { // from class: com.kwad.components.ad.nativead.b.1.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            com.kwad.sdk.core.d.c.d("KSNativeAdRotateAndShakeManager", "onShakeEvent openGate2");
                            b.this.iQ.abR();
                        }
                    }, null, 500L);
                }
            }
        });
        this.iQ.K(f);
        this.iQ.bW(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(double d2) {
        CopyOnWriteArrayList<d> copyOnWriteArrayList = this.qs;
        int iYu = (int) (com.kwad.sdk.core.config.e.Yu() * 100.0f);
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        int i = Integer.MAX_VALUE;
        Iterator<d> it = copyOnWriteArrayList.iterator();
        d dVar = null;
        d dVar2 = null;
        while (it.hasNext()) {
            d next = it.next();
            WeakReference weakReference = next.qA;
            if (weakReference != null) {
                Rect rect = new Rect();
                if (((View) weakReference.get()).getGlobalVisibleRect(rect) && ca.v((View) weakReference.get(), iYu)) {
                    int i2 = this.qu / 2;
                    int iMin = Math.min(Math.abs(rect.top - i2), Math.abs(rect.bottom - i2));
                    if (iMin < i) {
                        dVar = next;
                        i = iMin;
                    } else if (iMin == i) {
                        dVar2 = next;
                    }
                }
            }
        }
        if (dVar != null) {
            if (dVar2 != null) {
                Rect rect2 = new Rect();
                ((View) dVar.qA.get()).getGlobalVisibleRect(rect2);
                Rect rect3 = new Rect();
                ((View) dVar2.qA.get()).getGlobalVisibleRect(rect2);
                if (rect2.top < rect3.top) {
                    dVar = dVar2;
                }
            }
            dVar.qz.i(d2);
        }
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo, Context context, c cVar) {
        com.kwad.sdk.core.g.c cVar2 = this.iR;
        if (cVar2 == null) {
            a(rotateInfo, context);
        } else {
            cVar2.a(rotateInfo);
        }
        this.qt.add(new C0428b(cVar, context));
    }

    public final void a(c cVar) {
        Iterator<C0428b> it = this.qt.iterator();
        while (it.hasNext()) {
            C0428b next = it.next();
            if (next != null && next.qy == cVar) {
                this.qt.remove(next);
            }
        }
        com.kwad.sdk.core.d.c.d("KSNativeAdRotateAndShakeManager", "sRotateItems size " + this.qt.size());
    }

    private void a(AdMatrixInfo.RotateInfo rotateInfo, Context context) {
        com.kwad.sdk.core.g.c cVar = new com.kwad.sdk.core.g.c(rotateInfo);
        this.iR = cVar;
        cVar.a(new com.kwad.sdk.core.g.a() { // from class: com.kwad.components.ad.nativead.b.2
            @Override // com.kwad.sdk.core.g.a
            public final void cj() {
            }

            @Override // com.kwad.sdk.core.g.a
            public final void r(String str) {
                if (b.this.qt != null) {
                    Iterator it = b.this.qt.iterator();
                    while (it.hasNext()) {
                        C0428b c0428b = (C0428b) it.next();
                        if (c0428b != null && c0428b.qy != null) {
                            c0428b.qy.D(str);
                            return;
                        }
                    }
                }
            }
        });
        this.iR.bW(context);
    }

    public final void N(Context context) {
        try {
            com.kwad.sdk.core.g.c cVar = this.iR;
            if (cVar != null) {
                cVar.bW(context);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void D(Context context) {
        try {
            com.kwad.sdk.core.g.c cVar = this.iR;
            if (cVar != null) {
                cVar.bX(context);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static synchronized boolean cd() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!(jElapsedRealtime - iV > 500)) {
            return false;
        }
        iV = jElapsedRealtime;
        return true;
    }
}
