package com.qq.e.comm.plugin;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class q20 implements vj {
    private final h8 a;
    private final boolean b;

    @Override // com.qq.e.comm.plugin.vj
    public xj a() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.vj
    public boolean b() {
        return false;
    }

    @Override // com.qq.e.comm.plugin.vj
    public Boolean c(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        return null;
    }

    @Override // com.qq.e.comm.plugin.vj
    public int d() {
        return 0;
    }

    @Override // com.qq.e.comm.plugin.vj
    public void f() {
    }

    @Override // com.qq.e.comm.plugin.vj
    public Boolean b(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        return Boolean.FALSE;
    }

    public q20(h8 h8Var) {
        this.a = h8Var;
        this.b = h8Var.c.optInt(com.kuaishou.weapon.p0.t.v) == 1;
    }

    @Override // com.qq.e.comm.plugin.vj
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) throws JSONException {
        a(view, motionEvent);
        return Boolean.TRUE;
    }

    @Override // com.qq.e.comm.plugin.vj
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF) throws JSONException {
        a(view, motionEvent);
        return Boolean.FALSE;
    }

    @Override // com.qq.e.comm.plugin.vj
    public h8 c() {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.vj
    public boolean e() {
        return this.b;
    }

    private void a(View view, MotionEvent motionEvent) throws JSONException {
        int action = motionEvent.getAction();
        int i = 1;
        if (action != 0) {
            if (action == 1) {
                i = 3;
            } else if (action != 3) {
                return;
            } else {
                i = 4;
            }
        }
        try {
            this.a.c.put("te", i);
        } catch (JSONException unused) {
        }
    }
}
