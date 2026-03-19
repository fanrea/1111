package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.forbes.Config;
import com.qq.e.comm.managers.status.SDKStatus;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class j2 extends q0<com.qq.e.comm.plugin.w.d> {
    private static volatile j2 v;
    private JSONObject u;

    public static j2 l() {
        if (v == null) {
            synchronized (j2.class) {
                if (v == null) {
                    v = new j2();
                }
            }
        }
        return v;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [T, com.qq.e.comm.plugin.i2] */
    @Override // com.qq.e.comm.plugin.q0
    public void a(Context context, String str) {
        try {
            String strB = r1.d().f().b("wdc", "{\"jcc\":\"10000,100,60000,1000,10000\"}");
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strB);
            this.u = jSONObject;
            this.a = strB;
            if (jSONObject.optInt(com.alipay.sdk.m.s.a.w) > 0) {
                super.a(context, str);
            } else {
                this.h = context.getDir(gu.a(str), 0);
            }
            if (this.k == 0) {
                this.k = new i2(b());
            }
        } catch (Throwable th) {
            qc qcVar = new qc(9800002);
            qcVar.c(d().a);
            qcVar.d(100);
            ja jaVar = new ja();
            jaVar.a("ver", 0);
            jaVar.a("ot", Log.getStackTraceString(th));
            b10.a(qcVar);
        }
    }

    @Override // com.qq.e.comm.plugin.q0
    protected kc d() {
        return kc.AIRBAG;
    }

    @Override // com.qq.e.comm.plugin.q0
    protected boolean i() {
        return false;
    }

    private j2() {
    }

    @Override // com.qq.e.comm.plugin.q0
    protected boolean e() throws Throwable {
        long jOptLong = this.u.optLong("ddl");
        if ((jOptLong > 0 && jOptLong <= System.currentTimeMillis()) || !a(this.u)) {
            return false;
        }
        String[] strArrSplit = this.b.split(Config.replace);
        if (strArrSplit.length < 2) {
            return false;
        }
        String str = strArrSplit[strArrSplit.length - 1];
        this.d = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f = this.u.optInt("ddc", 3);
        int pluginVersion = SDKStatus.getPluginVersion();
        int iOptInt = this.u.optInt("psv");
        int iOptInt2 = this.u.optInt("pev");
        if (pluginVersion < iOptInt || pluginVersion > iOptInt2) {
            return false;
        }
        this.e = this.u.optString("mcn");
        return !TextUtils.isEmpty(r0);
    }
}
