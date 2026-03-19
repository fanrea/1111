package com.android.gdt.qone.ao;

import android.text.TextUtils;
import com.android.gdt.qone.sdk.S.SpreadValue;
import com.kuaishou.weapon.p0.t;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.sigmob.sdk.base.mta.PointType;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class f implements Runnable {
    public final /* synthetic */ g a;

    public f(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        h hVar = this.a.a;
        ConcurrentHashMap concurrentHashMap = h.e;
        com.android.gdt.qone.ad.c cVar = com.android.gdt.qone.ad.b.a;
        if (com.android.gdt.qone.ae.d.a(cVar.a() != null ? cVar.a.getLong("l_u_time", 0L) : 0L, com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.b.z, com.android.gdt.qone.at.a.a(hVar.a).a.l).intValue())) {
            boolean zBooleanValue = com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.w, com.android.gdt.qone.at.a.a(hVar.a).a.l).booleanValue();
            boolean zBooleanValue2 = (cVar.a() == null ? Boolean.TRUE : Boolean.valueOf(cVar.a.getBoolean("sp_need_report", true))).booleanValue();
            if (zBooleanValue && !zBooleanValue2) {
                return;
            }
            HashMap mapA = new c().a().a();
            if (mapA.size() <= 1) {
                return;
            }
            h hVar2 = this.a.a;
            String str = hVar2.a;
            String str2 = hVar2.c;
            SpreadValue spreadValue = mapA.containsKey(str2) ? (SpreadValue) mapA.remove(str2) : null;
            if (spreadValue == null || hVar2.d.get()) {
                return;
            }
            hVar2.d.set(true);
            JSONArray jSONArray = new JSONArray();
            for (SpreadValue spreadValue2 : mapA.values()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("aid", spreadValue2.a());
                    jSONObject.put("appKey", spreadValue2.b());
                    jSONObject.put("firstTime", spreadValue2.c());
                    jSONObject.put("oaid", spreadValue2.f());
                    jSONObject.put("q16", spreadValue2.g());
                    jSONObject.put("q36", spreadValue2.h());
                    jSONObject.put(n.l, spreadValue2.i());
                    jSONObject.put("updateTime", spreadValue2.j());
                    jSONObject.put("fromKey", spreadValue2.d());
                    jSONObject.put("fromSource", spreadValue2.e());
                } catch (JSONException e) {
                    com.android.gdt.qone.af.c.a(e);
                }
                jSONArray.put(jSONObject);
            }
            String string = jSONArray.toString();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            com.android.gdt.qone.ad.b.a.a(false);
            String strB = spreadValue.b();
            long jC = spreadValue.c();
            String strF = spreadValue.f();
            String strA = spreadValue.a();
            long j = spreadValue.j();
            int iIntValue = com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.b.z, com.android.gdt.qone.at.a.a(str).a.l).intValue();
            boolean zBooleanValue3 = com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.w, com.android.gdt.qone.at.a.a(str).a.l).booleanValue();
            e eVar = new e(hVar2);
            com.android.gdt.qone.ai.f fVarA = com.android.gdt.qone.ai.f.a();
            com.android.gdt.qone.ai.c cVarA = com.android.gdt.qone.r.b.a(fVarA);
            cVarA.a.put("6", strA);
            cVarA.a.put("7", strF);
            cVarA.a.put(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, String.valueOf(jC));
            cVarA.a.put("9", String.valueOf(j));
            cVarA.a.put(PointType.SIGMOB_APP, String.valueOf(iIntValue));
            cVarA.a.put("11", String.valueOf(zBooleanValue3 ? 1 : 0));
            cVarA.a.put("12", string);
            cVarA.b = eVar;
            fVarA.a(cVarA, "s1", strB);
            com.android.gdt.qone.af.c.b(t.l, "Spread data has been reported over,appKey = %s", strB);
        }
    }
}
