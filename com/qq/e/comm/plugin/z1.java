package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import com.qq.e.comm.plugin.callback.biz.ARCallback;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class z1 {
    private static volatile z1 d;
    private SharedPreferences a;
    private long b = 0;
    private volatile JSONObject c;

    private SharedPreferences a(Context context) {
        return (SharedPreferences) pro.getobjresult(367, 0, this, context);
    }

    private y1 a(h4 h4Var) {
        return (y1) pro.getobjresult(368, 0, this, h4Var);
    }

    private String a(int i) {
        return (String) pro.getobjresult(369, 0, this, Integer.valueOf(i));
    }

    private void a() {
        pro.getVresult(370, 0, this);
    }

    private void a(y1 y1Var, int i) {
        pro.getVresult(371, 0, this, y1Var, Integer.valueOf(i));
    }

    private boolean a(h4 h4Var, y1 y1Var) {
        return pro.getZresult(372, 0, this, h4Var, y1Var);
    }

    public static z1 b() {
        return (z1) pro.getobjresult(373, 1, new Object[0]);
    }

    private boolean c() {
        return pro.getZresult(374, 0, this);
    }

    private boolean d() {
        return pro.getZresult(375, 0, this);
    }

    public y1 b(h4 h4Var) {
        return (y1) pro.getobjresult(376, 0, this, h4Var);
    }

    private z1() {
        if (r1.d().f().a("acrale", 0) == 1) {
            this.a = a(r1.d().a());
            a();
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ h4 a;
        final /* synthetic */ y1 b;

        a(h4 h4Var, y1 y1Var) {
            this.a = h4Var;
            this.b = y1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((ARCallback) x5.b(this.a.s0(), ARCallback.class)).J().b(this.b);
        }
    }
}
