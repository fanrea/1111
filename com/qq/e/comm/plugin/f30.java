package com.qq.e.comm.plugin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.dd;
import com.qq.e.comm.plugin.f0;
import com.qq.e.comm.plugin.g1;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class f30 extends f0 implements dd.i {
    private static boolean E;
    private static final int F;
    private boolean A;
    private final ViewGroup B;
    private NativeExpressADView C;
    private int D;
    private volatile int x;
    private final Runnable y;
    private volatile boolean z;

    static {
        q8.a().b(e2.UNIFIED_BANNER);
        E = r1.d().f().a("ubuis", 1) == 1;
        F = yu.a(r1.d().a(), 48);
    }

    private boolean h() {
        return r1.d().f().a("ubulap", 1) == 1;
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f30.this.z) {
                f30 f30Var = f30.this;
                f30Var.loadAd(f30Var.i);
            }
        }
    }

    f30(Context context, ViewGroup viewGroup, ADSize aDSize, String str, String str2, String str3, ADListener aDListener, mb mbVar) {
        super(context, aDSize, str, str2, mbVar, aDListener, str3, e2.UNIFIED_BANNER);
        this.x = 30;
        this.y = new a();
        this.z = true;
        this.D = -1;
        this.B = viewGroup;
        this.A = r1.d().f().a("disbr", str2, 1) == 1;
    }

    public void fetchAd() {
        n();
        loadAd(this.a.b());
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i) {
        this.i = i;
        c(i);
        o();
    }

    /* compiled from: A */
    class b implements g1.h<ed> {
        b() {
        }

        @Override // com.qq.e.comm.plugin.g1.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ed a(JSONObject jSONObject) {
            return f30.this.a(jSONObject);
        }

        @Override // com.qq.e.comm.plugin.g1.h
        public void a(ed edVar) {
            f30.this.D = edVar.o0();
            dd ddVarA = f30.this.u.a(edVar);
            jq jqVar = new jq(null, ddVarA, f30.this.b, new ff(edVar));
            f30.this.a(ddVarA, jqVar);
            f30.this.p = new String[]{edVar.e1()};
            f30.this.q = new String[]{edVar.W()};
            go.b(f30.this.r, 1);
            f30.this.a(jqVar, edVar);
        }

        @Override // com.qq.e.comm.plugin.g1.h
        public void a(eo eoVar) {
            f30.this.b(eoVar.a());
        }
    }

    @Override // com.qq.e.comm.plugin.f0
    protected g1<ed> f() {
        return super.a(xc.a("ubcasi", this.a.c(), this.d, 0), xc.a("ubreti", this.a.c(), this.d, 0));
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ NativeExpressADView a;

        c(NativeExpressADView nativeExpressADView) {
            this.a = nativeExpressADView;
        }

        @Override // java.lang.Runnable
        public void run() {
            f30.this.a(this.a);
            f30.this.h.onADEvent(new ADEvent(100, new Object[0]));
        }
    }

    private void c(int i) {
        g();
        this.s.a(a(i), this.t, this.r, new b());
    }

    /* compiled from: A */
    class d implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            f30.this.C.render();
        }
    }

    /* compiled from: A */
    class e implements ADListener {
        final /* synthetic */ dd a;
        final /* synthetic */ AtomicBoolean b;
        final /* synthetic */ NativeExpressADView c;

        e(dd ddVar, AtomicBoolean atomicBoolean, NativeExpressADView nativeExpressADView) {
            this.a = ddVar;
            this.b = atomicBoolean;
            this.c = nativeExpressADView;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 106) {
                this.c.removeAllViews();
                f30.this.h.onADEvent(aDEvent);
            } else {
                if (type != 109) {
                    f30.this.h.onADEvent(aDEvent);
                    return;
                }
                View viewJ = this.a.j();
                if (viewJ == null || !this.b.compareAndSet(false, true)) {
                    return;
                }
                this.c.addView(viewJ, viewJ.getLayoutParams());
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (this.A) {
            if (z) {
                n();
                o();
            } else {
                m();
            }
        }
    }

    public void setRefresh(int i) {
        this.x = i;
    }

    private void o() {
        if (this.x == 0) {
            m();
            return;
        }
        if (this.z) {
            if (this.x >= 30 && this.x <= 120) {
                xo.a(this.y, this.x * 1000);
            } else {
                xo.a(this.y, 30000L);
            }
        }
    }

    public void n() {
        xo.e(this.y);
        this.z = true;
    }

    public void m() {
        xo.e(this.y);
        this.z = false;
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.v = loadAdParams;
        this.w = b5.a(loadAdParams);
    }

    public final int q() {
        return this.D;
    }

    NativeExpressADView r() {
        return this.C;
    }

    /* compiled from: A */
    private static class f extends f0.b {
        @Override // com.qq.e.comm.plugin.f0.b
        public dd a(ed edVar) {
            return new f4(this.a, edVar);
        }

        private f(Context context, ADSize aDSize) {
            super(context, aDSize);
        }

        /* synthetic */ f(Context context, ADSize aDSize, a aVar) {
            this(context, aDSize);
        }
    }

    private void b(dd ddVar, NativeExpressADView nativeExpressADView) {
        ddVar.setAdListener(new e(ddVar, new AtomicBoolean(false), nativeExpressADView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NativeExpressADView nativeExpressADView) {
        int childCount = this.B.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.B.getChildAt(i);
                if (childAt instanceof NativeExpressADView) {
                    ((NativeExpressADView) childAt).destroy();
                }
            }
            this.B.removeAllViews();
        }
        this.C = nativeExpressADView;
        if (!nativeExpressADView.isValid()) {
            this.h.onADEvent(new ADEvent(110, new Object[0]));
            return;
        }
        this.C.addOnAttachStateChangeListener(new d());
        if (E && su.h() >= 580) {
            this.C.setSizeRules(F, 3.125d, 6.4d);
        }
        this.B.addView(this.C, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.qq.e.comm.plugin.f0
    protected w1 a(int i) {
        w1 w1VarA = super.a(i);
        LoadAdParams loadAdParams = this.v;
        if (loadAdParams != null) {
            w1VarA.a(loadAdParams.getDevExtra());
            if (h()) {
                w1VarA.c(loadAdParams.getLoginAppId());
                w1VarA.a(loadAdParams.getLoginType());
                w1VarA.d(loadAdParams.getLoginOpenid());
                w1VarA.b(loadAdParams.getExtraInfo());
            }
        }
        return w1VarA;
    }

    @Override // com.qq.e.comm.plugin.dd.i
    public void a(ed edVar) {
        b(edVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NativeExpressADView nativeExpressADView, h4 h4Var) {
        xo.a((Runnable) new c(nativeExpressADView));
        go.a(this.r, 1, h4Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(dd ddVar, NativeExpressADView nativeExpressADView) {
        ddVar.a(this);
        b(ddVar, nativeExpressADView);
        a((h4) ddVar.d());
    }

    @Override // com.qq.e.comm.plugin.f0
    protected f0.b a() {
        return new f(this.b, this.f, null);
    }

    protected void a(h4 h4Var) {
        xc.d().a(h4Var, this.a.c(), "ubcasi", 0).a(h4Var, this.a.c(), "ubreti", 0).a();
    }
}
