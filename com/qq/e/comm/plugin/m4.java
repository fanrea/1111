package com.qq.e.comm.plugin;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class m4 implements vj {
    private final h8 a;
    private final boolean b;
    private final int c;
    private boolean d;
    private final kb e;
    private final r20 f;

    abstract boolean d(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2);

    public m4(h8 h8Var) {
        this.a = h8Var;
        JSONObject jSONObject = h8Var.c;
        if (jSONObject != null && jSONObject.length() > 0) {
            this.b = jSONObject.optInt(com.kuaishou.weapon.p0.t.v) == 1;
            this.c = jSONObject.optInt("imnd", 0);
            this.d = true ^ b();
            kb kbVarA = kb.a(jSONObject);
            this.e = kbVarA;
            this.f = kbVarA == null ? r20.a(jSONObject) : null;
            return;
        }
        this.b = false;
        this.e = null;
        this.f = null;
        this.c = 0;
        this.d = !b();
    }

    @Override // com.qq.e.comm.plugin.vj
    public h8 c() {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.vj
    public boolean e() {
        return (!this.b && this.e == null && this.f == null) ? false : true;
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

    @Override // com.qq.e.comm.plugin.vj
    public xj a() {
        return this.f;
    }

    @Override // com.qq.e.comm.plugin.vj
    public Boolean b(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        boolean z = false;
        if (this.b && this.d && d(view, motionEvent, pointF, pointF2)) {
            z = true;
        }
        kb kbVar = this.e;
        if (kbVar != null) {
            if (z) {
                kbVar.a(true, view);
            } else {
                kbVar.a(view, pointF2);
            }
        }
        r20 r20Var = this.f;
        if (r20Var != null) {
            if (z) {
                r20Var.a(view, motionEvent);
            } else {
                r20Var.b(view, motionEvent);
            }
        }
        if (z) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.vj
    public Boolean c(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        r20 r20Var;
        kb kbVar;
        boolean z = false;
        if (!this.d) {
            this.d = true;
            if (this.b && d(view, motionEvent, pointF, pointF2)) {
                z = true;
            }
        }
        if (z && (kbVar = this.e) != null) {
            kbVar.a(true, view);
        }
        if (z && (r20Var = this.f) != null) {
            r20Var.a(view, motionEvent);
        }
        if (z) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.vj
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        boolean z = this.d && d(view, motionEvent, pointF, pointF2);
        kb kbVar = this.e;
        if (kbVar != null) {
            kbVar.a(z, view);
        }
        r20 r20Var = this.f;
        if (r20Var != null) {
            r20Var.a(view, motionEvent);
        }
        if (z) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.vj
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF) {
        kb kbVar = this.e;
        if (kbVar != null) {
            kbVar.b(view, pointF);
        }
        r20 r20Var = this.f;
        if (r20Var == null) {
            return null;
        }
        r20Var.c(view, motionEvent);
        return null;
    }
}
