package com.qq.e.comm.plugin;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Region;
import android.view.MotionEvent;
import android.view.View;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class lc implements vj, xj {
    private final h8 a;
    private final boolean b;
    private final int c;
    private boolean d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final Path j = new Path();
    private int k;
    private int l;
    private int m;
    private int n;
    private j5 o;

    @Override // com.qq.e.comm.plugin.vj
    public xj a() {
        return this;
    }

    @Override // com.qq.e.comm.plugin.xj
    public void b(Canvas canvas, int i, int i2) {
    }

    @Override // com.qq.e.comm.plugin.vj
    public boolean e() {
        return true;
    }

    lc(h8 h8Var) {
        this.a = h8Var;
        JSONObject jSONObject = h8Var.c;
        if (jSONObject != null && jSONObject.length() > 0) {
            this.b = jSONObject.optInt(com.kuaishou.weapon.p0.t.v) == 1;
            this.c = jSONObject.optInt("imnd", 0);
            this.d = true ^ b();
            this.e = jSONObject.optInt("et");
            int iA = t30.c(jSONObject.opt("er")).a(new JSONObject[0]);
            this.f = iA;
            this.g = iA * 2;
            this.h = jSONObject.optInt("ers", 0);
            this.i = jSONObject.optInt("erf", 0);
            return;
        }
        this.b = false;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.c = 0;
        this.d = !b();
    }

    private boolean g() {
        return (this.o.a() * 100) / this.o.b() >= this.e;
    }

    @Override // com.qq.e.comm.plugin.vj
    public h8 c() {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.vj
    public boolean b() {
        return this.c > 0;
    }

    @Override // com.qq.e.comm.plugin.vj
    public int d() {
        int i = this.c;
        if (i > 0) {
            return i;
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.vj
    public void f() {
        this.d = !b();
    }

    @Override // com.qq.e.comm.plugin.xj
    public void a(Canvas canvas, int i, int i2) {
        if (this.j.isEmpty()) {
            return;
        }
        canvas.clipPath(this.j, Region.Op.DIFFERENCE);
    }

    @Override // com.qq.e.comm.plugin.vj
    public Boolean b(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (x < 0.0f || x > this.m || y < 0.0f || y > this.n) {
            return null;
        }
        a(x, y);
        boolean z = false;
        if (this.b && this.d && g()) {
            z = true;
        }
        if (!z || !a(true, view)) {
            this.j.addCircle(x, y, this.f, Path.Direction.CW);
            view.invalidate();
        }
        if (z) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.vj
    public Boolean c(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        if (!this.d) {
            this.d = true;
            boolean z = this.b && g();
            a(z, view);
            if (z) {
                return Boolean.TRUE;
            }
        }
        return null;
    }

    private void a(float f, float f2) {
        int i;
        int i2 = 0;
        if (f <= 0.0f) {
            i = 0;
        } else if (f >= this.m) {
            i = this.k - 1;
        } else {
            i = ((int) f) / this.g;
        }
        if (f2 > 0.0f) {
            if (f2 >= this.n) {
                i2 = this.l - 1;
            } else {
                i2 = ((int) f2) / this.g;
            }
        }
        this.o.a((i * this.l) + i2, true);
    }

    @Override // com.qq.e.comm.plugin.vj
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        boolean z = this.d && g();
        a(z, view);
        if (z) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.vj
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.k <= 0) {
            this.m = view.getWidth();
            this.n = view.getHeight();
            double d = this.m;
            Double.isNaN(d);
            double d2 = this.g;
            Double.isNaN(d2);
            this.k = (int) Math.ceil((d * 1.0d) / d2);
            double d3 = this.n;
            Double.isNaN(d3);
            double d4 = this.g;
            Double.isNaN(d4);
            int iCeil = (int) Math.ceil((d3 * 1.0d) / d4);
            this.l = iCeil;
            this.o = new j5(this.k * iCeil);
        }
        a(x, y);
        this.j.addCircle(x, y, this.f, Path.Direction.CW);
        view.invalidate();
        return null;
    }

    private boolean a(boolean z, View view) {
        if ((z ? this.h : this.i) != 1) {
            return false;
        }
        this.j.reset();
        view.invalidate();
        this.k = 0;
        return true;
    }
}
