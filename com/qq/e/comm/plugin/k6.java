package com.qq.e.comm.plugin;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class k6 extends m4 {
    private final boolean g;
    private final int[] h;
    private final int i;
    private final Boolean j;
    private final Boolean k;
    private final boolean l;
    private final int m;
    private boolean n;

    @Override // com.qq.e.comm.plugin.m4, com.qq.e.comm.plugin.vj
    public /* bridge */ /* synthetic */ boolean b() {
        return super.b();
    }

    @Override // com.qq.e.comm.plugin.m4, com.qq.e.comm.plugin.vj
    public /* bridge */ /* synthetic */ h8 c() {
        return super.c();
    }

    @Override // com.qq.e.comm.plugin.m4, com.qq.e.comm.plugin.vj
    public /* bridge */ /* synthetic */ void f() {
        super.f();
    }

    @Override // com.qq.e.comm.plugin.m4, com.qq.e.comm.plugin.vj
    public /* bridge */ /* synthetic */ Boolean c(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        return super.c(view, motionEvent, pointF, pointF2);
    }

    public k6(h8 h8Var, boolean z, int i) {
        Object objOpt;
        Object objOpt2;
        super(h8Var);
        this.l = z;
        this.m = i;
        this.g = h8Var.a == 4;
        JSONObject jSONObject = h8Var.c;
        if (jSONObject != null && jSONObject.length() > 0) {
            int iOptInt = jSONObject.optInt("vp");
            if (iOptInt == 2) {
                this.k = Boolean.TRUE;
            } else if (iOptInt == 1) {
                this.k = Boolean.FALSE;
            } else {
                this.k = null;
            }
            int iOptInt2 = jSONObject.optInt(com.baidu.mobads.container.adrequest.g.R);
            if (iOptInt2 == 1) {
                this.j = Boolean.TRUE;
            } else if (iOptInt2 == 2) {
                this.j = Boolean.FALSE;
            } else {
                this.j = null;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("as");
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("ds");
            int length = jSONArrayOptJSONArray == null ? 0 : jSONArrayOptJSONArray.length();
            int length2 = jSONArrayOptJSONArray2 == null ? 0 : jSONArrayOptJSONArray2.length();
            if (length2 <= 0 && (objOpt2 = jSONObject.opt("cr")) != null) {
                jSONArrayOptJSONArray2 = new JSONArray((Collection) Collections.singletonList(objOpt2));
                length2 = 1;
            }
            int iMax = Math.max(length2, (length + 1) / 2);
            this.i = iMax;
            if (iMax == 0) {
                this.h = null;
                return;
            }
            this.h = new int[iMax * 3];
            for (int i2 = 0; i2 < this.i; i2++) {
                int i3 = i2 * 3;
                this.h[i3] = (length2 <= 0 || (objOpt = jSONArrayOptJSONArray2.opt(i2)) == null) ? -1 : t30.c(objOpt).a(new JSONObject[0]);
                this.h[i3 + 1] = length > 0 ? jSONArrayOptJSONArray.optInt(i2 * 2, 0) : 0;
                int[] iArr = this.h;
                int i4 = i3 + 2;
                int iOptInt3 = 360;
                if (length > 0) {
                    iOptInt3 = jSONArrayOptJSONArray.optInt((i2 * 2) + 1, 360);
                }
                iArr[i4] = iOptInt3;
            }
            return;
        }
        this.h = null;
        this.i = 0;
        this.j = null;
        this.k = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00cc  */
    @Override // com.qq.e.comm.plugin.m4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean d(android.view.View r9, android.view.MotionEvent r10, android.graphics.PointF r11, android.graphics.PointF r12) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.k6.d(android.view.View, android.view.MotionEvent, android.graphics.PointF, android.graphics.PointF):boolean");
    }

    @Override // com.qq.e.comm.plugin.m4, com.qq.e.comm.plugin.vj
    public Boolean b(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        if (this.l && !this.n) {
            if (Math.hypot(pointF2.y - pointF.y, pointF2.x - pointF.x) > this.m) {
                if (!d(view, motionEvent, pointF, pointF2)) {
                    pc.a(view, false);
                }
                this.n = true;
            }
        }
        return super.b(view, motionEvent, pointF, pointF2);
    }

    @Override // com.qq.e.comm.plugin.m4, com.qq.e.comm.plugin.vj
    public boolean e() {
        return this.l || super.e();
    }

    @Override // com.qq.e.comm.plugin.m4, com.qq.e.comm.plugin.vj
    public /* bridge */ /* synthetic */ int d() {
        return super.d();
    }

    public static boolean a(JSONObject jSONObject) {
        return jSONObject.remove("tdc") != null;
    }

    @Override // com.qq.e.comm.plugin.m4, com.qq.e.comm.plugin.vj
    public /* bridge */ /* synthetic */ xj a() {
        return super.a();
    }

    public static boolean a(JSONObject jSONObject, e2 e2Var) {
        return jSONObject == null || jSONObject.length() <= 0 || jSONObject.optInt("sys") != 1 || a(e2Var);
    }

    private static boolean a(e2 e2Var) {
        int iA;
        if (e2Var == null) {
            return false;
        }
        try {
            iA = r1.d().f().a("tdsc_" + e2Var.d(), 0);
            if (iA > 10000) {
                iA = b.c().a(String.valueOf(iA), 0);
            }
        } catch (Exception unused) {
        }
        return iA == 1;
    }

    @Override // com.qq.e.comm.plugin.m4, com.qq.e.comm.plugin.vj
    public /* bridge */ /* synthetic */ Boolean a(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        return super.a(view, motionEvent, pointF, pointF2);
    }

    @Override // com.qq.e.comm.plugin.m4, com.qq.e.comm.plugin.vj
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF) {
        this.n = false;
        return c().c.optInt("tdc") == 1 ? Boolean.TRUE : super.a(view, motionEvent, pointF);
    }
}
