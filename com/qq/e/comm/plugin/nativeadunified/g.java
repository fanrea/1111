package com.qq.e.comm.plugin.nativeadunified;

import android.view.MotionEvent;
import android.view.View;
import com.qq.e.comm.plugin.callback.biz.DLInterceptStateCallback;
import com.qq.e.comm.plugin.cl;
import com.qq.e.comm.plugin.h4;
import com.qq.e.comm.plugin.ms;
import com.qq.e.comm.plugin.ns;
import com.qq.e.comm.plugin.os;
import com.qq.e.comm.plugin.pc;
import com.qq.e.comm.plugin.qm$h$$ExternalSyntheticBackport0;
import com.qq.e.comm.plugin.x5;
import com.qq.e.comm.plugin.yq;
import com.qq.e.comm.plugin.zu;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class g implements View.OnTouchListener, os {
    private static final String n = "c";
    private final h4 a;
    private final int b;
    private final e c;
    private int d;
    private int[] e;
    private int f;
    private float g;
    private float h;
    private boolean i;
    private boolean j;
    private final ns m = new ns();

    private void c() {
        if (this.a.h1()) {
            this.d = 0;
            cl clVar = this.c.j;
            if (clVar != null) {
                clVar.f();
            }
        }
    }

    public void d() {
        x5.c(this.a.s0(), DLInterceptStateCallback.class);
        this.j = true;
    }

    @Override // com.qq.e.comm.plugin.os
    public boolean k() {
        return this.j;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.j) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.i = false;
            this.g = motionEvent.getX();
            this.h = motionEvent.getY();
            if (this.a.I1()) {
                this.d = 0;
            }
            if (this.d > 0) {
                pc.a(view, true);
            }
        } else {
            if (action == 1) {
                if (this.d != 2) {
                    view.performClick();
                    if (this.d == 1) {
                        c();
                    }
                } else if (a(motionEvent.getX(), motionEvent.getY())) {
                    view.performClick();
                    c();
                }
                return true;
            }
            if (action == 2 && this.d == 2 && !this.i) {
                if (Math.hypot(motionEvent.getY() - this.h, motionEvent.getX() - this.g) > this.b) {
                    if (!a(motionEvent.getX(), motionEvent.getY())) {
                        pc.a(view, false);
                    }
                    this.i = true;
                }
            }
        }
        return false;
    }

    private boolean a(float f, float f2) {
        double dAtan2;
        float f3 = f - this.g;
        float f4 = f2 - this.h;
        if (f3 == 0.0f && f4 == 0.0f) {
            dAtan2 = Double.NaN;
        } else {
            dAtan2 = (Math.atan2(f4, f3) / 3.141592653589793d) * 180.0d;
            if (dAtan2 < 0.0d) {
                dAtan2 += 360.0d;
            }
        }
        for (int i = 0; i < this.f; i++) {
            int i2 = i * 2;
            if (Double.isNaN(dAtan2)) {
                return true;
            }
            int[] iArr = this.e;
            int i3 = iArr[i2];
            int i4 = iArr[i2 + 1];
            if ((i3 >= i4 || (dAtan2 >= i3 && dAtan2 <= i4)) && (i3 < i4 || dAtan2 >= i3 || dAtan2 <= i4)) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        ((DLInterceptStateCallback) x5.b(this.a.s0(), DLInterceptStateCallback.class)).E().a(new a(this));
    }

    public g(h4 h4Var, int i, e eVar) {
        this.e = new int[0];
        this.a = h4Var;
        this.b = zu.a(i);
        this.c = eVar;
        this.d = h4Var.J0();
        yq yqVarP0 = h4Var.p0();
        if (yqVarP0 != null) {
            JSONArray jSONArrayB = yqVarP0.b();
            int length = jSONArrayB == null ? 0 : (jSONArrayB.length() + 1) / 2;
            this.f = length;
            if (length > 0) {
                this.e = new int[length * 2];
                int i2 = 0;
                while (true) {
                    int i3 = this.f;
                    if (i2 >= i3) {
                        break;
                    }
                    int i4 = i2 * 2;
                    this.e[i4] = i3 > 0 ? jSONArrayB.optInt(i4, 0) : 0;
                    int[] iArr = this.e;
                    int i5 = i4 + 1;
                    int iOptInt = 360;
                    if (this.f > 0) {
                        iOptInt = jSONArrayB.optInt(i5, 360);
                    }
                    iArr[i5] = iOptInt;
                    i2++;
                }
            }
        }
        b();
    }

    /* compiled from: A */
    class a extends ms<Integer> {
        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            String unused = g.n;
            qm$h$$ExternalSyntheticBackport0.m(num);
            int unused2 = g.this.d;
            if (g.this.a.I1()) {
                return;
            }
            g.this.d = num.intValue();
        }

        a(os osVar) {
            super(osVar);
        }
    }

    @Override // com.qq.e.comm.plugin.os
    public ns i() {
        return this.m;
    }
}
