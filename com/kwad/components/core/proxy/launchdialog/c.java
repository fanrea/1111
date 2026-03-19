package com.kwad.components.core.proxy.launchdialog;

import com.kwad.components.core.proxy.launchdialog.g;
import com.kwad.components.core.proxy.n;
import com.kwad.sdk.utils.bx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements n {
    private static long Yd = 7000;
    private DetectEventType Ye;
    private WeakReference<com.kwad.components.core.proxy.a> Yf;
    private List<g> Yg = new ArrayList();
    private a Yh = new a(this, 0);
    private boolean started = false;

    public c(DetectEventType detectEventType, com.kwad.components.core.proxy.a aVar, g... gVarArr) {
        this.Ye = detectEventType;
        this.Yf = new WeakReference<>(aVar);
        this.Yg.addAll(Arrays.asList(gVarArr));
    }

    public final void a(f fVar) {
        this.Yh.Yj = fVar;
    }

    public final boolean b(DetectEventType detectEventType) {
        return detectEventType != null && detectEventType.equals(this.Ye);
    }

    public final void start() {
        this.started = true;
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "start call: " + this.Ye);
        bx.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.proxy.launchdialog.c.1
            @Override // java.lang.Runnable
            public final void run() {
                c.this.Yh.l(c.this.sm());
                com.kwad.sdk.core.d.c.d("LifecycleSequence", "DETECT_TIMEOUT call: " + c.this.Ye);
                c.this.stop();
            }
        }, Yd);
        d dVarSh = sh();
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "start call current: " + dVarSh + this.Ye);
        a(dVarSh);
    }

    public final void stop() {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "stop call: " + this.Ye);
        this.Yh.stop();
        this.started = false;
    }

    private d sh() {
        com.kwad.components.core.proxy.a aVar;
        WeakReference<com.kwad.components.core.proxy.a> weakReference = this.Yf;
        if (weakReference == null || weakReference.get() == null || (aVar = this.Yf.get()) == null) {
            return null;
        }
        return aVar.sh();
    }

    private void a(d dVar) {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "checkMatch event: " + dVar);
        WeakReference<com.kwad.components.core.proxy.a> weakReference = this.Yf;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        if (this.Yg.size() == 0) {
            this.Yh.k(sm());
            return;
        }
        g gVar = this.Yg.get(0);
        if (gVar instanceof g.a) {
            if (this.Yg.size() < 2) {
                this.Yh.m(sm());
                return;
            }
            g gVar2 = this.Yg.get(1);
            if (!(gVar2 instanceof g.b)) {
                this.Yh.m(sm());
                return;
            }
            d dVarSg = this.Yf.get().sg();
            g.b bVar = (g.b) gVar2;
            long jSp = dVarSg.sp();
            com.kwad.sdk.core.d.c.d("LifecycleSequence", "checkMatch last: " + dVarSg);
            g.a aVar = (g.a) gVar;
            if (aVar.K(jSp) && bVar.b(dVar.so())) {
                this.Yg.remove(gVar);
                this.Yg.remove(gVar2);
                com.kwad.sdk.core.d.c.d("LifecycleSequence", "DurationMoreThanItem remove first: " + gVar + this.Ye);
                com.kwad.sdk.core.d.c.d("LifecycleSequence", "DurationMoreThanItem remove second: " + gVar2 + this.Ye);
                if (sl()) {
                    return;
                }
                this.Yh.j(sm());
                return;
            }
            com.kwad.sdk.core.d.c.d("LifecycleSequence", "DurationMoreThanItem not match two: " + aVar.K(jSp) + ", " + bVar.b(dVar.so()));
            this.Yh.m(sm());
            return;
        }
        if (gVar instanceof g.b) {
            if (((g.b) gVar).b(dVar.so())) {
                this.Yg.remove(gVar);
                com.kwad.sdk.core.d.c.d("LifecycleSequence", "PageEventItem remove: " + gVar);
                if (sl()) {
                    return;
                }
                this.Yh.j(sm());
                return;
            }
            this.Yh.m(sm());
        }
    }

    private boolean sl() {
        if (this.Yg.size() != 0) {
            return false;
        }
        this.Yh.k(sm());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.proxy.a sm() {
        WeakReference<com.kwad.components.core.proxy.a> weakReference = this.Yf;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.kwad.components.core.proxy.k
    public final void a(com.kwad.components.core.proxy.a aVar) {
        if (this.started) {
            a(sh());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void b(com.kwad.components.core.proxy.a aVar) {
        if (this.started) {
            a(sh());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void c(com.kwad.components.core.proxy.a aVar) {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "LifecycleSequence onResume: " + aVar.getPageName() + " , type:" + this.Ye);
        if (this.started) {
            a(sh());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void d(com.kwad.components.core.proxy.a aVar) {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", this.started + " LifecycleSequence onPause: " + aVar.getPageName() + " , type:" + this.Ye);
        if (this.started) {
            a(sh());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void e(com.kwad.components.core.proxy.a aVar) {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", this.started + " LifecycleSequence onStop: " + aVar.getPageName() + " , type:" + this.Ye);
        if (this.started) {
            a(sh());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void f(com.kwad.components.core.proxy.a aVar) {
        if (this.started) {
            a(sh());
        }
    }

    @Override // com.kwad.components.core.proxy.n
    public final boolean g(com.kwad.components.core.proxy.a aVar) {
        WeakReference<com.kwad.components.core.proxy.a> weakReference;
        if (aVar == null || (weakReference = this.Yf) == null || weakReference.get() == null) {
            return false;
        }
        return this.Yf.get().equals(aVar);
    }

    class a implements f {
        private f Yj;
        private boolean Yk;

        private a() {
            this.Yk = false;
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stop() {
            sn();
            this.Yj = null;
        }

        private void sn() {
            this.Yk = true;
        }

        @Override // com.kwad.components.core.proxy.launchdialog.f
        public final void j(com.kwad.components.core.proxy.a aVar) {
            f fVar = this.Yj;
            if (fVar == null) {
                return;
            }
            fVar.j(aVar);
        }

        @Override // com.kwad.components.core.proxy.launchdialog.f
        public final void k(com.kwad.components.core.proxy.a aVar) {
            f fVar;
            if (this.Yk || (fVar = this.Yj) == null) {
                return;
            }
            fVar.k(aVar);
            sn();
        }

        @Override // com.kwad.components.core.proxy.launchdialog.f
        public final void l(com.kwad.components.core.proxy.a aVar) {
            f fVar;
            if (this.Yk || (fVar = this.Yj) == null) {
                return;
            }
            fVar.l(aVar);
            sn();
        }

        @Override // com.kwad.components.core.proxy.launchdialog.f
        public final void m(com.kwad.components.core.proxy.a aVar) {
            f fVar;
            if (this.Yk || (fVar = this.Yj) == null) {
                return;
            }
            fVar.m(aVar);
            sn();
        }
    }
}
