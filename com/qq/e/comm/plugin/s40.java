package com.qq.e.comm.plugin;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class s40 implements sj {
    private static final SparseArray<a> f = new SparseArray<>();
    private static Boolean g;
    private final WeakReference<View> a;
    private final h4 b;
    private final sj c;
    private final int d;
    private final a e = new a();

    public s40(View view, h4 h4Var, sj sjVar, int i) {
        this.a = new WeakReference<>(view);
        this.b = h4Var;
        this.c = sjVar;
        this.d = i;
    }

    @Override // com.qq.e.comm.plugin.sj
    public w2 a() {
        w2 w2VarA = this.c.a();
        View view = this.a.get();
        if (view == null) {
            return w2VarA;
        }
        int iE = u2.e(view);
        SparseArray<a> sparseArray = f;
        a aVar = sparseArray.get(iE);
        if (aVar != null && aVar.d != 0) {
            w2VarA.b = String.valueOf(System.currentTimeMillis() - aVar.d);
            w2VarA.c = String.valueOf(System.currentTimeMillis() - aVar.c);
            w2VarA.q = String.valueOf(aVar.a);
            w2VarA.r = String.valueOf(aVar.b);
            sparseArray.remove(iE);
        }
        a(w2VarA);
        b(w2VarA);
        c(w2VarA);
        w2VarA.h = "0";
        int i = this.d;
        if (i == 1) {
            this.b.c(System.currentTimeMillis());
            w2VarA.i = "0";
        } else if (i == 2) {
            this.b.b(System.currentTimeMillis());
            w2VarA.i = String.valueOf(System.currentTimeMillis() - this.b.R());
        }
        w2VarA.j = "0";
        if (g == null) {
            g = Boolean.valueOf(r1.d().f().a("cvic", 1) == 1);
        }
        if (g.booleanValue()) {
            w2VarA.u = String.valueOf(d50.a(view, 100, this.d).second);
        }
        return w2VarA;
    }

    private void b(w2 w2Var) {
        View view = this.a.get();
        if (view == null) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int i = rect.top;
        int i2 = rect.left;
        int i3 = rect.right;
        int i4 = rect.bottom;
        w2Var.m = String.valueOf(yu.b(view.getContext(), iArr[0]));
        w2Var.n = String.valueOf(yu.b(view.getContext(), iArr[1]));
        w2Var.o = String.valueOf(yu.b(view.getContext(), i3 - i2));
        w2Var.p = String.valueOf(yu.b(view.getContext(), i4 - i));
    }

    private void c(w2 w2Var) {
        View view = this.a.get();
        if (view != null) {
            float fA = d50.a(view);
            boolean zC = d50.c(view);
            w2Var.t = String.format("%.2f", Float.valueOf(fA));
            w2Var.s = String.valueOf(zC ? 1 : 0);
        }
    }

    /* compiled from: A */
    static class a {
        public float a;
        public float b;
        public long c;
        public long d;

        a() {
        }
    }

    private void a(w2 w2Var) {
        View view = this.a.get();
        if (w2Var == null || view == null) {
            return;
        }
        w2Var.k = String.valueOf(yu.b(view.getContext(), view.getWidth()));
        w2Var.l = String.valueOf(yu.b(view.getContext(), view.getHeight()));
    }

    public void a(MotionEvent motionEvent, boolean z, w2 w2Var, int i, int i2) {
        View view = this.a.get();
        if (motionEvent == null || w2Var == null || view == null) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            int rawX = (int) (z ? motionEvent.getRawX() : i + motionEvent.getX());
            float rawY = z ? motionEvent.getRawY() : motionEvent.getY() + i2;
            w2Var.d = String.valueOf(yu.b(view.getContext(), rawX));
            w2Var.e = String.valueOf(yu.b(view.getContext(), (int) rawY));
            this.e.c = System.currentTimeMillis();
        } else if (action == 1) {
            int rawX2 = (int) (z ? motionEvent.getRawX() : i + motionEvent.getX());
            float rawY2 = z ? motionEvent.getRawY() : motionEvent.getY() + i2;
            w2Var.f = String.valueOf(yu.b(view.getContext(), rawX2));
            w2Var.g = String.valueOf(yu.b(view.getContext(), (int) rawY2));
            this.e.d = System.currentTimeMillis();
            a aVar = this.e;
            w2Var.a = String.valueOf(aVar.d - aVar.c);
            this.e.a = motionEvent.getPressure();
            this.e.b = motionEvent.getSize();
        }
        f.put(u2.e(view), this.e);
    }
}
