package com.qq.e.comm.plugin;

import android.os.Build;
import android.util.Pair;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.plugin.a5;
import com.qq.e.comm.plugin.aw;
import com.qq.e.comm.plugin.rr;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ix {

    /* compiled from: A */
    class a implements a5.b {
        final /* synthetic */ String a;
        final /* synthetic */ hx b;

        @Override // com.qq.e.comm.plugin.a5.b
        public void a(JSONArray jSONArray, Map<Integer, tr> map) throws JSONException {
            jn jnVar = new jn();
            r1 r1VarD = r1.d();
            jn jnVar2 = new jn();
            Pair<Integer, Integer> pairB = pa.b();
            jnVar2.a("ifa", com.qq.e.comm.plugin.a.a()).a("os", 2).a("osv", String.valueOf(Build.VERSION.SDK_INT)).a("model", Build.MODEL).a("connection_type", r1VarD.c().p().b()).a("language", Locale.getDefault().getLanguage()).a("h", pairB.first).a("w", pairB.second).a("country", Locale.getDefault().getCountry()).a("device_type", t10.d() ? 2 : 1).a("make", Build.BRAND);
            jn jnVar3 = new jn();
            jnVar3.a(com.alipay.sdk.m.k.b.D0, r1VarD.b().a()).a("bundle", r1VarD.a().getPackageName()).a("ver", r1VarD.b().d());
            jn jnVar4 = new jn();
            JSONObject jSONObjectOptJSONObject = GlobalSetting.getSettings().optJSONObject(GlobalSetting.OVERSEA_PRIVACY_INFO);
            if (jSONObjectOptJSONObject != null) {
                jnVar4.a("gdpr", jSONObjectOptJSONObject.optBoolean("gdpr", false) ? 1 : 0).a(GlobalSetting.CCPA, jSONObjectOptJSONObject.optBoolean(GlobalSetting.CCPA, false) ? 1 : 0).a("coppa", jSONObjectOptJSONObject.optBoolean("coppa", false) ? 1 : 0);
            } else {
                jnVar4.a("gdpr", 0).a(GlobalSetting.CCPA, 0).a("coppa", 0);
            }
            jnVar.a("sdk_version", su.c()).a("device", jnVar2.a()).a("mediation_id", this.a).a(PointCategory.APP, jnVar3.a()).a("adns", jSONArray).a("ext", jnVar4.a());
            C0711a c0711a = new C0711a(map);
            cu cuVar = new cu("{domain}/auction".replace("{domain}", sf.l().h()), aw.a.POST, jnVar.toString().getBytes(d6.a));
            b10.a(1144001, (f5) null);
            sr.a().a(cuVar, rr.a.High, c0711a);
        }

        a(String str, hx hxVar) {
            this.a = str;
            this.b = hxVar;
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.ix$a$a, reason: collision with other inner class name */
        class C0711a implements qr {
            final /* synthetic */ Map a;

            C0711a(Map map) {
                this.a = map;
            }

            @Override // com.qq.e.comm.plugin.qr
            public void a(aw awVar, Exception exc) {
                a.this.b.a(null, this.a);
                b10.a(1144004, (f5) null);
            }

            @Override // com.qq.e.comm.plugin.qr
            public void a(aw awVar, hw hwVar) {
                int iA = hwVar.a();
                b10.a(1144002, null, Integer.valueOf(iA));
                if (iA == 200) {
                    try {
                        qy qyVar = new qy(new JSONObject(hwVar.c()));
                        int iG = qyVar.g();
                        b10.a(1144003, null, Integer.valueOf(iG));
                        if (iG == 0 && qyVar.a() > 0) {
                            a.this.b.a(qyVar, this.a);
                        } else {
                            a.this.b.a(null, this.a);
                        }
                        return;
                    } catch (Exception unused) {
                        a.this.b.a(null, this.a);
                        return;
                    }
                }
                a.this.b.a(null, this.a);
            }
        }
    }

    public static void a(List<tr> list, String str, hx hxVar) {
        a5.a(list, new a(str, hxVar));
    }
}
