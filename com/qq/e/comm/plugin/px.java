package com.qq.e.comm.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import com.pandora.common.Constants;
import com.qq.e.comm.plugin.rr;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class px {
    private static final String b = sf.l().h() + "/activate";
    private static final String c = sf.l().h() + "/launch";
    private static final px d = new px();
    private volatile Boolean a = Boolean.FALSE;

    private synchronized void e(vx vxVar, hu huVar, qa qaVar, b0 b0Var, long j) {
        if (this.a.booleanValue()) {
            return;
        }
        sf.l().a(System.currentTimeMillis());
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i = sf.A;
        if (i > 0) {
            d(vxVar, huVar, qaVar, b0Var, j);
            sf.l().c();
        } else {
            c(vxVar, huVar, qaVar, b0Var, j);
            sf.l().a(false);
        }
        this.a = Boolean.TRUE;
        b10.a(new wt(2130307).b(SystemClock.elapsedRealtime() - jElapsedRealtime).b(i > 0 ? 1 : 0));
    }

    private void c(vx vxVar, hu huVar, qa qaVar, b0 b0Var, long j) throws JSONException {
        String strB = b(vxVar, huVar, qaVar, b0Var, j);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        String str = su.j() ? b : "https://sdk.e.qq.com/activate";
        if (!TextUtils.isEmpty(vxVar.e())) {
            atomicBoolean.set(true);
            str = su.j() ? c : "https://sdk.e.qq.com/launch";
        }
        sr.a().a(new nx(str, strB.getBytes(Charset.forName("UTF-8"))), rr.a.High, new a(atomicBoolean));
    }

    /* compiled from: A */
    class a extends hz {
        final /* synthetic */ AtomicBoolean a;

        a(AtomicBoolean atomicBoolean) {
            this.a = atomicBoolean;
        }

        @Override // com.qq.e.comm.plugin.hz
        public void a(aw awVar, int i, Exception exc) throws JSONException {
            px.this.a(this.a.get(), i, exc.getMessage(), false);
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) throws IllegalStateException, JSONException {
            try {
                if (hwVar.a() == 200) {
                    String strC = hwVar.c();
                    if (TextUtils.isEmpty(strC)) {
                        px.this.a(this.a.get(), 3000, "response empty", false);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(strC);
                    int iOptInt = jSONObject.optInt("ret", -1);
                    if (iOptInt == 0) {
                        px.this.a(this.a.get(), 0, "", false);
                        sf.l().b(false, jSONObject);
                        return;
                    }
                    px.this.a(this.a.get(), 3000, "code=" + iOptInt, false);
                    return;
                }
                px.this.a(this.a.get(), 3005, "status=" + hwVar.a(), false);
                hwVar.a();
            } catch (IOException e) {
                px.this.a(this.a.get(), 3001, e.getMessage(), false);
            } catch (JSONException e2) {
                px.this.a(this.a.get(), 5001, e2.getMessage(), false);
            }
        }
    }

    private void d(vx vxVar, hu huVar, qa qaVar, b0 b0Var, long j) {
        String str;
        byte[] bytes = a(vxVar, huVar, qaVar, b0Var, j).getBytes(Charset.forName("UTF-8"));
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (TextUtils.isEmpty(vxVar.e())) {
            str = "https://sdk.e.qq.com/activate";
        } else {
            atomicBoolean.set(true);
            str = "https://sdk.e.qq.com/launch";
        }
        b bVar = new b(atomicBoolean);
        sr.a().a(new nx(str, bytes), rr.a.High, bVar);
    }

    /* compiled from: A */
    class b extends hz {
        final /* synthetic */ AtomicBoolean a;

        b(AtomicBoolean atomicBoolean) {
            this.a = atomicBoolean;
        }

        @Override // com.qq.e.comm.plugin.hz
        public void a(aw awVar, int i, Exception exc) throws JSONException {
            px.this.a(this.a.get(), i, exc.getMessage(), true);
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) throws IllegalStateException, JSONException {
            try {
                if (hwVar.a() == 200) {
                    String strC = hwVar.c();
                    if (TextUtils.isEmpty(strC)) {
                        px.this.a(this.a.get(), 3000, "response empty", true);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(strC);
                    int iOptInt = jSONObject.optInt("ret", -1);
                    if (iOptInt == 0) {
                        px.this.a(this.a.get(), 0, "", true);
                        sf.l().b(jSONObject);
                        return;
                    }
                    px.this.a(this.a.get(), 3000, "code=" + iOptInt, true);
                    return;
                }
                px.this.a(this.a.get(), 3005, "status=" + hwVar.a(), true);
                hwVar.a();
            } catch (IOException e) {
                px.this.a(this.a.get(), 3001, e.getMessage(), true);
            } catch (JSONException e2) {
                px.this.a(this.a.get(), 5001, e2.getMessage(), true);
            }
        }
    }

    private String b(vx vxVar, hu huVar, qa qaVar, b0 b0Var, long j) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = mx.a(vxVar);
            jSONObject.put(NetworkDefine.PARAM_SIGNATURE, mx.a(vxVar, huVar));
            jSONObject.put("dev", mx.b(qaVar));
            jSONObject.put(PointCategory.APP, mx.a(b0Var));
            jSONObject.put("c", mx.a(qaVar));
            jSONObject.put("sdk", mx.a(huVar));
            if (su.j()) {
                jSONObject.put(Constants.APPLog.APP_REGION, sf.l().g());
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("sdk_init_time", (System.nanoTime() - j) / 1000000);
            jSONObject2.put("performance", jSONObject3);
            jSONObject.put(com.alipay.sdk.m.k.b.l, jSONObject2);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    private String a(vx vxVar, hu huVar, qa qaVar, b0 b0Var, long j) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = mx.a(vxVar);
            JSONObject jSONObject2 = new JSONObject();
            if (qaVar != null) {
                jSONObject2.putOpt(Constants.APPLog.DEVICE_ID, qaVar.j());
                c20.a(jSONObject2, "/launch");
            }
            jSONObject.put("dev", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            if (b0Var != null) {
                jSONObject3.putOpt(com.alipay.sdk.m.s.a.r, b0Var.a());
            }
            jSONObject.put(PointCategory.APP, jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.putOpt("sdkv", su.i());
            if (huVar != null) {
                jSONObject4.putOpt("pv", Integer.valueOf(huVar.b()));
            }
            jSONObject.put("sdk", jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("sdk_init_time", (System.nanoTime() - j) / 1000000);
            jSONObject5.put("performance", jSONObject6);
            jSONObject.put(com.alipay.sdk.m.k.b.l, jSONObject5);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public void b() {
        r1 r1VarD = r1.d();
        e(r1VarD.f(), r1VarD.e(), r1VarD.c(), r1VarD.b(), System.nanoTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i, String str, boolean z2) throws JSONException {
        if (i != 0 && !z2) {
            sf.l().a(true);
            if (sf.z && as.d() == 2) {
                sf.l().p();
            }
        }
        ja jaVar = new ja();
        if (!TextUtils.isEmpty(str)) {
            jaVar.a("msg", str);
        }
        int i2 = (z2 ? 1 : 0) * 100;
        b10.a(z ? 9120029 : 9120039, null, Integer.valueOf(i2 + 20 + (n3.c() ? 1 : 2)), Integer.valueOf(i), jaVar);
        if (i != 0) {
            b10.a(9120050, null, Integer.valueOf(i2 + ((as.i() ? 1 : 2) * 10) + as.d()), Integer.valueOf(i), jaVar);
        }
    }

    public static px a() {
        return d;
    }
}
