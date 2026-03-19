package com.qq.e.comm.plugin;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobstat.forbes.Config;
import com.pandora.common.Constants;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.plugin.aw;
import com.qq.e.comm.plugin.rr;
import com.qq.e.comm.plugin.sf;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class mp {
    private static volatile mp h;
    private Context a;
    private volatile np b;
    private int c;
    private AtomicInteger d;
    private String e;
    private long f;
    private boolean g;

    private mp(Context context) throws Throwable {
        this.a = context.getApplicationContext();
        if (qp.b()) {
            String strA = lp.a(context);
            if (!TextUtils.isEmpty(strA)) {
                try {
                    a(new JSONObject(strA));
                } catch (Exception unused) {
                    a(new JSONObject());
                }
            } else {
                a(new JSONObject());
            }
            this.c = r1.d().f().a("lg_cfrto", 30) * 1000;
            this.d = new AtomicInteger(r1.d().f().a("lg_cfrts", 2));
            a(false);
        }
    }

    /* compiled from: A */
    class a implements sf.j {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // com.qq.e.comm.plugin.sf.j
        public void a() {
            mp.this.a(this.a, true);
        }
    }

    /* compiled from: A */
    class b implements qr {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;

        b(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, Exception exc) {
            mp.this.g = false;
            mp.this.c(this.a, this.b);
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) throws JSONException {
            try {
                int iA = hwVar.a();
                if (iA == 200) {
                    String strC = hwVar.c();
                    if (!TextUtils.isEmpty(strC)) {
                        try {
                            JSONObject jSONObject = new JSONObject(strC);
                            int i = jSONObject.getInt("code");
                            if (!TextUtils.isEmpty(strC) && strC.length() > 4000) {
                                int length = (strC.length() / 4000) + 1;
                                int i2 = 0;
                                while (i2 < length) {
                                    int i3 = 4000 * i2;
                                    i2++;
                                    strC.substring(i3, Math.min(4000 * i2, strC.length()));
                                }
                            }
                            ja jaVar = new ja();
                            jaVar.a("code", Integer.valueOf(i));
                            b10.a(1231002, null, null, null, jaVar);
                            if (i == 0) {
                                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                                mp.this.a(jSONObjectOptJSONObject);
                                if (jSONObjectOptJSONObject != null) {
                                    mp.this.c(jSONObjectOptJSONObject.toString());
                                }
                            } else if (i == 110) {
                                sf.l().b();
                            }
                            mp.this.f = SystemClock.elapsedRealtime();
                        } catch (JSONException unused) {
                        }
                        mp.this.g = false;
                        return;
                    }
                }
                if (iA != 200) {
                    b10.a(70022, (f5) null);
                } else {
                    b10.a(70032, (f5) null);
                }
                mp.this.g = false;
                mp.this.c(this.a, this.b);
            } catch (Exception unused2) {
                mp.this.g = false;
                mp.this.c(this.a, this.b);
            }
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;

        c(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            mp.this.a(this.a, this.b);
        }
    }

    /* compiled from: A */
    class d implements Runnable {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            lp.b(mp.this.a, this.a);
            mp.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() throws Throwable {
        if (!a() || this.b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("updateTime", System.currentTimeMillis());
            List<yn> listB = this.b.b();
            JSONArray jSONArray = new JSONArray();
            if (listB != null && listB.size() > 0) {
                for (yn ynVar : listB) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("phyPosId", ynVar.e());
                    List<tr> listJ = ynVar.j();
                    JSONArray jSONArray2 = new JSONArray();
                    if (listJ != null && listJ.size() > 0) {
                        for (tr trVar : listJ) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("name", trVar.o());
                            jSONObject3.put("posId", trVar.p());
                            jSONObject3.put("ext", trVar.j());
                            jSONObject3.put("className", trVar.e());
                            jSONArray2.put(jSONObject3);
                        }
                    }
                    jSONObject2.put(PointCategory.NETWORK, jSONArray2);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("layerConfigs", jSONArray);
            lp.c(this.a, jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public HashMap<String, String> b() {
        if (this.b != null) {
            return this.b.e();
        }
        return new HashMap<>();
    }

    public boolean b(String str) throws JSONException {
        if (su.j() && !sf.l().m()) {
            return false;
        }
        boolean zD = qp.d(str);
        f5 f5Var = new f5();
        f5Var.c(str);
        if (zD) {
            b10.a(1231004, f5Var);
        }
        if (this.b == null) {
            if (zD) {
                b10.a(1231005, f5Var);
            }
            return false;
        }
        boolean z = a(str) != null;
        if (zD && !z) {
            b10.a(1231011, f5Var);
        }
        return z;
    }

    private String b(boolean z) {
        if (!su.j()) {
            return z ? "https://sdk.e.qq.com/mediation?version=1" : "https://sdk.e.qq.com/mediation?version=2";
        }
        if (z) {
            return "{domain}/mediation?version=1".replace("{domain}", sf.l().h());
        }
        return "{domain}/mediation?version=2".replace("{domain}", sf.l().h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2) {
        aw nxVar;
        synchronized (this) {
            if (this.g) {
                return;
            }
            if (SystemClock.elapsedRealtime() - this.f > this.b.d() || z) {
                this.g = true;
                b10.a(1231001, (f5) null);
                b bVar = new b(z, z2);
                if (!z2) {
                    nxVar = new cu(b(false), aw.a.POST, b(z, false).getBytes(d6.a));
                } else {
                    nxVar = new nx(b(true), b(z, true).getBytes(d6.a));
                }
                sr.a().a(nxVar, rr.a.High, bVar);
            }
        }
    }

    private String b(boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.alipay.sdk.m.k.b.D0, r1.d().b().a());
            jSONObject.put("sdk_ver", su.i());
            jSONObject.put("plugin_ver", String.valueOf(r1.d().e().b()));
            Object objA = ma.IMEI.a(r1.d().a());
            Pair<String, String> pairF = c20.f();
            if (su.j()) {
                jSONObject.put(Config.GAID, gp.a(com.qq.e.comm.plugin.a.a()));
            } else {
                jSONObject.put(com.baidu.mobads.upgrade.remote.gray.c.l, objA);
            }
            jSONObject.put("app_ver_name", r1.d().b().d());
            if (su.j()) {
                jSONObject.put(Constants.APPLog.APP_REGION, sf.l().g());
            }
            if (pairF != null) {
                jSONObject.put("taid", pairF.first);
                jSONObject.put("oaid", pairF.second);
            }
            jSONObject.put("android_id", ma.ANDROIDID.c().b(r1.d().a()));
            jSONObject.put("encrypt", z2 ? 1 : 0);
            jSONObject.put("config_version", z ? "" : this.b.a());
            String strC = this.b.c();
            if (!TextUtils.isEmpty(strC)) {
                jSONObject.put("suid", strC);
            }
            jSONObject.put("protocol_version", 2);
            jSONObject.put("os", 2);
            jSONObject.toString();
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2) {
        b10.a(1231003, (f5) null);
        if (this.d.getAndDecrement() > 0) {
            xo.a(new c(z, z2), this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        qg.b.execute(new d(str));
    }

    yn a(String str) {
        List<yn> listB;
        if (TextUtils.isEmpty(str) || (listB = this.b.b()) == null || listB.size() <= 0) {
            return null;
        }
        for (yn ynVar : listB) {
            if (TextUtils.equals(str, ynVar.e())) {
                return ynVar;
            }
        }
        return null;
    }

    public void a(JSONObject jSONObject) {
        this.e = jSONObject.toString();
        this.b = new np(jSONObject);
    }

    public static mp a(Context context) {
        if (h == null) {
            synchronized (mp.class) {
                if (h == null) {
                    h = new mp(context);
                }
            }
        }
        return h;
    }

    public void a(boolean z) {
        if (su.j()) {
            sf.l().a(new a(z));
        } else {
            a(z, true);
        }
    }

    private boolean a() {
        return GlobalSetting.isEnableMediationTool();
    }
}
