package com.qq.e.comm.plugin;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.qq.e.comm.plugin.w40;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class pc implements View.OnTouchListener, View.OnClickListener, gk {
    private final w40 a;
    private final w40.d b;
    private h8 c;
    private PointF d;
    private PointF e;
    private MotionEvent f;
    private View g;
    private List<Runnable> h;
    private int i = 0;
    private List<vj> j;
    private List<vj> m;
    private List<vj> n;
    private w40 o;
    private boolean p;

    public pc(w40 w40Var, w40.d dVar) {
        this.a = w40Var;
        this.b = dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x002f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.util.List<com.qq.e.comm.plugin.h8> r6) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.pc.a(java.util.List):void");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (a(this.c)) {
            this.c.e();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = false;
        if (!this.a.K()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (view != null && (view.getScaleX() == 0.0f || view.getScaleY() == 0.0f)) {
                return false;
            }
            PointF pointFA = a(motionEvent);
            this.d = pointFA;
            this.e = pointFA;
            this.o = null;
            e8 e8VarC = this.a.c();
            if (e8VarC != null && e8VarC.k()) {
                a(view, true);
            }
        }
        if (this.j == null) {
            return false;
        }
        this.f = motionEvent;
        this.g = view;
        if (action == 0) {
            b(view, motionEvent);
            d();
        } else if (action == 1) {
            c();
            d(view, motionEvent);
        } else if (action != 2) {
            if (action != 3) {
                return false;
            }
            c();
            a(view, motionEvent);
        } else if (this.m != null) {
            c(view, motionEvent);
        }
        if (b() || (this.i == 1 && !view.isClickable())) {
            z = true;
        }
        a(action);
        return z;
    }

    private void b(View view, MotionEvent motionEvent) {
        for (vj vjVar : this.j) {
            h8 h8VarC = vjVar.c();
            if (h8VarC != null) {
                if (!b() && h8VarC.a()) {
                    a(vjVar.a(view, motionEvent, this.d), vjVar);
                }
                if (h8VarC.h) {
                    this.b.c(this.a, h8VarC);
                }
            }
        }
    }

    private void d(View view, MotionEvent motionEvent) {
        this.p = true;
        this.e = a(motionEvent);
        for (vj vjVar : this.j) {
            h8 h8VarC = vjVar.c();
            if (h8VarC != null) {
                if (!b() && h8VarC.a()) {
                    a(vjVar.a(view, motionEvent, this.d, this.e), vjVar);
                }
                if (h8VarC.h) {
                    this.b.a(this.a, h8VarC);
                }
                vjVar.f();
            }
        }
    }

    private void c(View view, MotionEvent motionEvent) {
        this.e = a(motionEvent);
        for (vj vjVar : this.m) {
            h8 h8VarC = vjVar.c();
            if (h8VarC != null && !b() && h8VarC.a()) {
                a(vjVar.b(view, motionEvent, this.d, this.e), vjVar);
            }
        }
    }

    /* compiled from: A */
    private final class b implements Runnable {
        vj a;

        private b(vj vjVar) {
            this.a = vjVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (pc.this.b()) {
                return;
            }
            pc pcVar = pc.this;
            pcVar.a(this.a.c(pcVar.g, pc.this.f, pc.this.d, pc.this.e), this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        return this.i == 3;
    }

    private boolean a(h8 h8Var) {
        if (this.o == null) {
            this.o = a(this.a, this.d);
        }
        w40 w40Var = this.o;
        if (w40Var != null) {
            h8Var.a(w40Var.r());
        } else {
            h8Var.a(0);
        }
        w40 w40Var2 = this.a;
        if (w40Var2 != null) {
            h8Var.a(w40Var2.q());
        }
        return this.b.b(this.a, h8Var);
    }

    @Override // com.qq.e.comm.plugin.gk
    public void c(w40 w40Var, h8 h8Var) {
        this.b.c(w40Var, h8Var);
    }

    private void d() {
        List<vj> list = this.n;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (vj vjVar : this.n) {
            if (this.h == null) {
                this.h = new ArrayList(this.n.size());
            }
            b bVar = new b(vjVar);
            this.h.add(bVar);
            vjVar.d();
            k8.a().postDelayed(bVar, vjVar.d());
        }
    }

    private boolean b(w40 w40Var, PointF pointF) {
        Rect rectF;
        if (w40Var == null || (rectF = w40Var.F()) == null) {
            return false;
        }
        return rectF.contains((int) pointF.x, (int) pointF.y);
    }

    private w40 a(w40 w40Var, PointF pointF) {
        if (pointF == null) {
            return null;
        }
        if (!(w40Var instanceof zn)) {
            return w40Var;
        }
        zn znVar = (zn) w40Var;
        for (int iO = znVar.O() - 1; iO >= 0; iO--) {
            w40 w40VarM = znVar.m(iO);
            if (((w40VarM instanceof zn) || w40VarM.r() != 0) && b(w40VarM, pointF)) {
                w40 w40VarA = a(w40VarM, pointF);
                if (w40VarA.r() != 0) {
                    return w40VarA;
                }
            }
        }
        return w40Var;
    }

    private void c() {
        List<Runnable> list = this.h;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Runnable> it = this.h.iterator();
        while (it.hasNext()) {
            k8.a().removeCallbacks(it.next());
        }
    }

    public static void a(View view, boolean z) {
        ViewParent parent;
        if (view == null || (parent = view.getParent()) == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(z);
    }

    @Override // com.qq.e.comm.plugin.gk
    public boolean b(w40 w40Var, h8 h8Var) {
        return this.b.b(w40Var, h8Var);
    }

    private void a(View view, MotionEvent motionEvent) {
        if (this.p) {
            return;
        }
        this.e = a(motionEvent);
        for (vj vjVar : this.j) {
            h8 h8VarC = vjVar.c();
            if (h8VarC != null) {
                if (h8VarC.a()) {
                    vjVar.a(view, motionEvent, this.d, this.e);
                }
                if (h8VarC.h) {
                    this.b.a(this.a, vjVar.c());
                }
                vjVar.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool, vj vjVar) {
        if (bool == null) {
            this.i = 1;
            return;
        }
        h8 h8VarC = vjVar.c();
        if (a(h8VarC)) {
            if (bool.booleanValue()) {
                this.i = 3;
                h8VarC.e();
                return;
            } else {
                this.i = 1;
                return;
            }
        }
        if (bool.booleanValue()) {
            this.i = 1;
        } else if (this.i == 0) {
            this.i = 2;
        }
    }

    private boolean a() {
        return this.a.c().a() == 2;
    }

    @Override // com.qq.e.comm.plugin.gk
    public void a(w40 w40Var, h8 h8Var) {
        this.b.a(w40Var, h8Var);
    }

    @Override // com.qq.e.comm.plugin.gk
    public void a(w40 w40Var, h8 h8Var, float f) {
        this.b.a(w40Var, h8Var, f);
    }

    private void a(int i) {
        if (i == 1 || i == 3) {
            this.i = 0;
            this.p = false;
        }
    }

    private PointF a(MotionEvent motionEvent) {
        return new PointF(motionEvent.getRawX(), motionEvent.getRawY());
    }
}
