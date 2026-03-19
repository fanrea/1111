package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import com.qq.e.comm.managers.status.SDKStatus;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class r1 {
    private volatile Context a;
    private volatile vx b;
    private volatile hu c;
    private volatile b0 d;
    private volatile qa e;
    private volatile JSONObject f;

    /* compiled from: A */
    private static final class b {
        private static r1 a = new r1();
    }

    private r1() {
    }

    private void a(Context context, JSONObject jSONObject) {
        this.a = context.getApplicationContext();
        this.d = new b0(jSONObject.optString("appId"), context, jSONObject.optString(Config.PACKAGE_NAME));
        this.e = new qa(this.a);
        this.c = new hu(jSONObject.optInt("pv"), jSONObject.optString(NetworkDefine.PARAM_SIGNATURE));
        this.b = new vx(this.a);
        this.f = jSONObject;
    }

    private void d(JSONObject jSONObject) throws JSONException {
        if (jSONObject.optBoolean("mup", true)) {
            return;
        }
        ja jaVar = new ja();
        jaVar.a("msg", this.d.f());
        b10.b(9120038, null, 0, jaVar);
    }

    public static r1 d() {
        return b.a;
    }

    public vx f() {
        return this.b;
    }

    public hu e() {
        return this.c;
    }

    public b0 b() {
        return this.d;
    }

    public qa c() {
        return this.e;
    }

    private void g() throws JSONException {
        c(this.f);
        e(this.f);
        d(this.f);
    }

    public Context a() {
        return this.a;
    }

    public synchronized boolean b(Context context, JSONObject jSONObject) {
        a(context, jSONObject);
        return true;
    }

    private void e(JSONObject jSONObject) throws JSONException {
        int i;
        if (this.c.b() > 10000) {
            i = 1;
        } else if (this.c.b() < SDKStatus.getBuildInPluginVersion()) {
            i = 2;
        } else if (SDKStatus.getBuildInPluginVersion() > 0) {
            return;
        } else {
            i = 3;
        }
        ja jaVar = new ja();
        jaVar.a("msg", jSONObject.optString("vas"));
        jaVar.a("data", Integer.valueOf(su.a()));
        b10.b(9120028, null, Integer.valueOf(i), jaVar);
    }

    private void c(JSONObject jSONObject) throws JSONException {
        int iOptInt = jSONObject.optInt("ifg");
        int iOptInt2 = jSONObject.optInt("ict", -1);
        ja jaVar = new ja();
        String strOptString = jSONObject.optString("tcr");
        if (!TextUtils.isEmpty(strOptString)) {
            jaVar.a("data", strOptString);
        }
        if (d().f().a("piplaei", 0) == 1) {
            jaVar.a("ver", su.c());
            jaVar.a("data2", d().b().d());
            jaVar.a("data3", gp.a(fu.b(this.a)));
        }
        if (iOptInt2 >= 0) {
            wt wtVarB = new wt(2030014).b(iOptInt).b(iOptInt2);
            wtVarB.a(jaVar);
            b10.a(wtVarB);
        }
        int iOptInt3 = jSONObject.optInt("pct", -1);
        if (iOptInt3 >= 0) {
            wt wtVarB2 = new wt(2130301).b(iOptInt).b(iOptInt3);
            wtVarB2.a(jaVar);
            b10.a(wtVarB2);
        }
    }

    public void b(JSONObject jSONObject) throws JSONException {
        a(jSONObject);
        g();
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        b10.a(1440000, null, Integer.valueOf(jSONObject.optInt("scr", -1)));
    }
}
