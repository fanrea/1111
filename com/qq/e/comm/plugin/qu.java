package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.kuaishou.android.live.network.ApiStatus;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qu implements sj {
    private static Boolean c;
    private static Boolean d;
    private static Boolean e;
    private static Boolean f;
    private static String g;
    private final sj a;
    private final Context b;

    public qu(Context context, sj sjVar) {
        this.b = context.getApplicationContext();
        this.a = sjVar;
    }

    @Override // com.qq.e.comm.plugin.sj
    public w2 a() {
        w2 w2VarA = this.a.a();
        w2VarA.p0 = String.valueOf(ru.l());
        if (e == null || f == null) {
            int iA = r1.d().f().a("asicc", 1);
            e = Boolean.valueOf(iA > 0);
            f = Boolean.valueOf(iA == 1);
        }
        if (e.booleanValue()) {
            if (f.booleanValue()) {
                if (TextUtils.isEmpty(g)) {
                    g = String.valueOf(ru.i());
                }
                w2VarA.q0 = g;
            } else {
                w2VarA.q0 = String.valueOf(ru.i());
            }
        }
        w2VarA.r0 = String.valueOf(ru.k());
        w2VarA.s0 = String.valueOf(ru.e().second);
        w2VarA.t0 = String.valueOf(ru.g());
        w2VarA.u0 = String.valueOf(ru.f());
        w2VarA.v0 = "2";
        w2VarA.f785K = ru.b();
        w2VarA.L = ru.c();
        w2VarA.M = String.valueOf(ru.d());
        return w2VarA;
    }

    public void a(MotionEvent motionEvent, boolean z, w2 w2Var, int i, int i2) {
        int x;
        int y;
        if (motionEvent == null || w2Var == null || this.b == null) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0 || action == 1) {
            vx vxVarF = r1.d().f();
            if (c == null) {
                c = Boolean.valueOf(vxVarF.a("otCheck", 0) == 1);
            }
            if (c.booleanValue() && ru.p()) {
                JSONObject jSONObjectJ = ru.j();
                int iOptInt = jSONObjectJ.optInt("data", -1);
                float fA = m10.a(jSONObjectJ.optString("offsetx"), 0.0f);
                float fA2 = m10.a(jSONObjectJ.optString("offsety"), 0.0f);
                if (iOptInt >= 0) {
                    if (z) {
                        x = (int) (motionEvent.getRawX() - fA);
                        y = (int) (motionEvent.getRawY() - fA2);
                    } else {
                        x = ((int) (motionEvent.getX() - fA)) + i;
                        y = ((int) (motionEvent.getY() - fA2)) + i2;
                    }
                    if (action == 0) {
                        w2Var.w0 = String.valueOf(iOptInt);
                        w2Var.x0 = String.valueOf(yu.b(this.b, x));
                        w2Var.y0 = String.valueOf(yu.b(this.b, y));
                        if (iOptInt > 0) {
                            w2Var.z0 = jSONObjectJ.optString("caller");
                            b10.a(9300003, null, Integer.valueOf(action), new ja(jSONObjectJ));
                        }
                    } else if (action == 1) {
                        w2Var.A0 = String.valueOf(iOptInt);
                        w2Var.B0 = String.valueOf(yu.b(this.b, x));
                        w2Var.C0 = String.valueOf(yu.b(this.b, y));
                        if (iOptInt > 0) {
                            w2Var.D0 = jSONObjectJ.optString("caller");
                            b10.a(9300003, null, Integer.valueOf(action), new ja(jSONObjectJ));
                        }
                    }
                } else if (action == 0) {
                    w2Var.w0 = String.valueOf(iOptInt);
                    w2Var.x0 = String.valueOf(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG);
                    w2Var.y0 = String.valueOf(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG);
                } else if (action == 1) {
                    w2Var.A0 = String.valueOf(iOptInt);
                    w2Var.B0 = String.valueOf(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG);
                    w2Var.C0 = String.valueOf(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG);
                }
            }
            if (d == null) {
                d = Boolean.valueOf(vxVarF.a("fcCheck", 0) == 1);
            }
            if (d.booleanValue()) {
                JSONObject jSONObjectH = ru.h();
                int iOptInt2 = jSONObjectH.optInt("data", -1);
                w2Var.E0 = String.valueOf(iOptInt2);
                if (iOptInt2 > 0) {
                    w2Var.F0 = jSONObjectH.optString("caller");
                    b10.a(9300002, null, 0, new ja(jSONObjectH));
                }
            }
        }
    }
}
