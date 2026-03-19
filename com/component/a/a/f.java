package com.component.a.a;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.x;
import com.component.a.f.e;
import com.component.a.i.w;
import com.component.lottie.LottieAnimationView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f extends LottieAnimationView implements com.component.a.c.c {
    public static final boolean a;
    private static final int b = 0;
    private static final int c = 1;
    private static final int d = 2;
    private static final int e = 0;
    private static final int f = 1;
    private static final int g = 2;
    private final List<a> h;
    private final Map<com.component.lottie.t, e.h> i;
    private final Map<com.component.a.f.b, b> j;
    private com.component.a.i.f k;
    private e.h l;
    private int m;
    private boolean n;
    private String o;
    private int p;
    private int q;
    private float r;
    private boolean s;
    private final Handler t;

    static {
        a = x.a(null).a() <= 25;
    }

    public static class b {
        private final e.h a;
        private final com.component.lottie.t b;

        public b(e.h hVar, com.component.lottie.t tVar) {
            this.a = hVar;
            this.b = tVar;
        }

        public e.h a() {
            return this.a;
        }

        public com.component.lottie.t b() {
            return this.b;
        }
    }

    public f(Context context, com.component.a.f.e eVar) {
        super(context);
        this.m = 0;
        this.n = false;
        this.p = 0;
        this.q = 0;
        this.r = -1.0f;
        this.s = false;
        this.t = new Handler(Looper.getMainLooper(), new k(this));
        this.j = new HashMap();
        this.i = new HashMap();
        this.h = new CopyOnWriteArrayList();
        i(true);
        e("");
        c(false);
        b(true);
        setSaveFromParentEnabled(false);
        a(new g(this));
        if (eVar == null) {
            return;
        }
        setLifeCycle(new com.component.a.i.f(eVar));
        a(this.k);
        a(eVar);
        i iVar = new i(this);
        for (e.h hVar : eVar.l()) {
            if (TextUtils.isEmpty(hVar.b(""))) {
                com.component.lottie.k.a(context, hVar, iVar);
            }
        }
    }

    private void a(com.component.a.f.e eVar) {
        if (eVar != null) {
            Context context = getContext();
            Drawable drawableA = com.component.a.i.r.a(context, eVar.h());
            if (x.a(context).a() > 16) {
                setBackground(drawableA);
            } else {
                setBackgroundDrawable(drawableA);
            }
        }
    }

    @Override // com.component.a.c.c
    public void switchViewStyle(com.component.a.f.e eVar) {
        a(eVar);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e.h a(Animator animator) {
        if (animator instanceof com.component.lottie.g.d) {
            com.component.lottie.t tVarD = ((com.component.lottie.g.d) animator).d();
            if (tVarD != null) {
                return this.i.get(tVarD);
            }
            return this.l;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e.h hVar) {
        if (hVar == null || TextUtils.isEmpty(hVar.e(""))) {
            return;
        }
        com.baidu.mobads.container.util.h.a(new j(this, hVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.h hVar) {
        b(hVar);
    }

    public void a(int i, boolean z) {
        super.setVisibility(i);
        this.s = z;
    }

    public String C() {
        return this.o;
    }

    public void a(a aVar) {
        this.h.add(aVar);
    }

    public void b(a aVar) {
        this.h.remove(aVar);
    }

    public void a(e.h hVar) {
        if (hVar == null) {
            return;
        }
        this.l = hVar;
        setScaleType(e.a(hVar.f("fit_center")));
        k(hVar.a(0) == 1);
        if (this.r > 0.0f) {
            super.c(this.r);
        } else {
            super.c(hVar.a(1.0f));
        }
        if (this.q <= 0) {
            this.q = hVar.c(0);
        }
        if (this.p <= 0) {
            this.p = hVar.b(0);
        }
        if (this.p > 0) {
            f(-1);
        } else {
            f(hVar.d(0));
        }
        e(hVar.e(1));
    }

    public void h(int i) {
        this.q = i;
    }

    @Override // com.component.lottie.LottieAnimationView
    public void c(float f2) {
        super.c(f2);
        this.r = f2;
    }

    public void i(int i) {
        this.p = i;
        if (this.p > 0) {
            f(-1);
        }
    }

    public void k(boolean z) {
        this.n = z;
        if (z && w.a(this)) {
            this.m = 1;
        }
    }

    public boolean D() {
        if (this.j.isEmpty()) {
            return false;
        }
        Iterator<b> it = this.j.values().iterator();
        while (it.hasNext()) {
            if (!it.next().b.q()) {
                return false;
            }
        }
        return true;
    }

    public void a(e.h hVar, com.component.lottie.t tVar) {
        if (hVar != null && tVar != null) {
            try {
                com.component.a.f.b bVarB = com.component.a.f.b.b(hVar.d(""));
                this.j.put(bVarB, new b(hVar, tVar));
                this.i.put(tVar, hVar);
                String strC = hVar.c("");
                if (!TextUtils.isEmpty(strC)) {
                    this.o = strC;
                }
                if (com.component.a.f.b.NORMAL == bVarB) {
                    a(hVar);
                    a(tVar);
                }
            } catch (Throwable th) {
                com.component.lottie.g.c.c("Error binding...", th);
            }
        }
    }

    public void E() {
        a(com.component.a.f.b.NORMAL);
    }

    public void a(com.component.a.f.b bVar) {
        b bVar2 = this.j.get(bVar);
        if (bVar2 != null) {
            a(bVar2.a);
            com.baidu.mobads.container.util.h.a(new l(this, bVar2));
        }
    }

    @Override // com.component.lottie.LottieAnimationView
    public void f() {
        if (a) {
            u();
        } else {
            com.baidu.mobads.container.util.h.a(new m(this));
        }
    }

    @Override // com.component.lottie.LottieAnimationView
    public void g() {
        if (a) {
            u();
        } else {
            com.baidu.mobads.container.util.h.a(new n(this));
        }
    }

    @Override // com.component.lottie.LottieAnimationView
    public void s() {
        this.t.removeCallbacksAndMessages(null);
        com.baidu.mobads.container.util.h.a(new o(this));
    }

    @Override // com.component.lottie.LottieAnimationView
    public void t() {
        this.t.removeMessages(0);
        this.t.removeMessages(1);
        com.baidu.mobads.container.util.h.a(new p(this));
    }

    @Override // com.component.lottie.LottieAnimationView
    public void u() {
        this.t.removeCallbacksAndMessages(null);
        com.baidu.mobads.container.util.h.a(new h(this));
    }

    public void F() {
        if (this.m == 1) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.component.lottie.t tVarC = c();
        if (!p() && tVarC != null && tVarC.q()) {
            super.f();
            if (this.p > 0) {
                this.t.sendEmptyMessageDelayed(2, this.p);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        try {
            this.n = false;
            this.t.removeCallbacksAndMessages(null);
            if (this.q > 0) {
                this.t.sendEmptyMessageDelayed(0, this.q);
            } else {
                G();
            }
        } catch (Throwable th) {
            bq.a().d(th);
        }
    }

    @Override // com.component.a.c.c
    public void setLifeCycle(com.component.a.i.f fVar) {
        this.k = fVar;
    }

    @Override // com.component.a.c.c
    public com.component.a.i.f getLifeCycle() {
        return this.k;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.k != null) {
            this.k.a(this, z);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.k != null) {
            this.k.a((View) this, i);
        }
    }

    @Override // com.component.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.n) {
            f();
        }
        if (this.k != null) {
            this.k.e(this);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.k != null) {
            this.k.f(this);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.k != null) {
            this.k.b(view, i);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (this.k != null) {
            this.k.a(motionEvent, zDispatchTouchEvent);
        }
        return zDispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (this.k != null) {
            this.k.b(motionEvent, zOnTouchEvent);
        }
        return zOnTouchEvent;
    }

    public static abstract class a {
        public void a(e.h hVar) {
        }

        public void a(e.h hVar, boolean z) {
        }

        public void b(e.h hVar) {
        }

        public void c(e.h hVar) {
        }
    }
}
