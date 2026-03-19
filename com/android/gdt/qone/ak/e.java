package com.android.gdt.qone.ak;

import android.text.TextUtils;
import com.android.gdt.qone.uin.U;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.sigmob.sdk.base.mta.PointType;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class e {
    public static String a(String str) {
        com.android.gdt.qone.w.c cVar;
        com.android.gdt.qone.ar.a aVar = new com.android.gdt.qone.ar.a(str);
        com.android.gdt.qone.ag.o oVarA = com.android.gdt.qone.ag.o.a(str);
        synchronized (com.android.gdt.qone.w.c.class) {
            cVar = com.android.gdt.qone.w.c.p;
        }
        com.android.gdt.qone.am.a aVarA = com.android.gdt.qone.am.a.a(str);
        JSONObject jSONObject = new JSONObject();
        String string = null;
        try {
            jSONObject.put("1", aVar.b());
            jSONObject.put("2", String.valueOf(com.android.gdt.qone.ar.d.h().a().getApplicationInfo().targetSdkVersion));
            jSONObject.put("3", !com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.h, com.android.gdt.qone.at.a.a(str).a.l).booleanValue() ? "" : aVar.e());
            jSONObject.put("4", U.a(com.android.gdt.qone.s.b.a(13)));
            jSONObject.put("5", "");
            String strA = com.android.gdt.qone.at.a.a(oVarA.a).a.i;
            if (TextUtils.isEmpty(strA)) {
                com.android.gdt.qone.av.a aVar2 = com.android.gdt.qone.at.a.a(oVarA.a).a;
                strA = (aVar2.a && aVar2.e && com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.g, aVar2.l).booleanValue()) ? com.android.gdt.qone.ag.p.a().a(7, new com.android.gdt.qone.ag.b()) : "";
            }
            jSONObject.put("6", strA);
            com.android.gdt.qone.av.a aVar3 = com.android.gdt.qone.at.a.a(oVarA.a).a;
            jSONObject.put("7", (aVar3.e && com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.n, aVar3.l).booleanValue()) ? com.android.gdt.qone.ag.p.a().a(1, new com.android.gdt.qone.ag.i()) : "");
            com.android.gdt.qone.av.a aVar4 = com.android.gdt.qone.at.a.a(oVarA.a).a;
            jSONObject.put(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, (aVar4.e && com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.o, aVar4.l).booleanValue()) ? com.android.gdt.qone.ag.p.a().a(2, new com.android.gdt.qone.ag.j()) : "");
            jSONObject.put("9", oVarA.a());
            com.android.gdt.qone.av.a aVar5 = com.android.gdt.qone.at.a.a(oVarA.a).a;
            jSONObject.put(PointType.SIGMOB_APP, (aVar5.e && com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.p, aVar5.l).booleanValue()) ? com.android.gdt.qone.ag.p.a().a(4, new com.android.gdt.qone.ag.l()) : "");
            com.android.gdt.qone.av.a aVar6 = com.android.gdt.qone.at.a.a(oVarA.a).a;
            jSONObject.put("11", (aVar6.e && com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.q, aVar6.l).booleanValue()) ? com.android.gdt.qone.ag.p.a().a(5, new com.android.gdt.qone.ag.n()) : "");
            jSONObject.put(PointType.SIGMOB_REPORT_TRACKING, aVar.g());
            jSONObject.put("14", cVar.g());
            com.android.gdt.qone.ae.f fVarA = com.android.gdt.qone.ae.f.a();
            if (!fVarA.a.get()) {
                fVarA.a(str);
            }
            String str2 = fVarA.b;
            if (!fVarA.a.get()) {
                fVarA.a(str);
            }
            String str3 = fVarA.c;
            jSONObject.put("15", str2);
            jSONObject.put("16", str3);
            jSONObject.put("12", a(cVar, oVarA, aVarA));
            string = jSONObject.toString();
            jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return string == null ? "" : string;
    }

    public static String a(com.android.gdt.qone.w.c cVar, com.android.gdt.qone.ag.o oVar, com.android.gdt.qone.am.a aVar) {
        Class<?> cls;
        String str;
        int iLastIndexOf;
        JSONObject jSONObject = new JSONObject();
        try {
            cVar.getClass();
            Class<?>[] clsArr = new Class[0];
            Object[] objArr = new Object[0];
            Object objInvoke = null;
            try {
                cls = Class.forName("com.huawei.system.BuildEx");
            } catch (Exception unused) {
                cls = null;
            }
            try {
                objInvoke = cls.getMethod("getOsBrand", clsArr).invoke(null, objArr);
            } catch (Exception unused2) {
            }
            String str2 = (String) objInvoke;
            jSONObject.put("harmony", (str2 != null && "harmony".equalsIgnoreCase(str2)) ? "1" : "0");
            jSONObject.put("clone", com.android.gdt.qone.w.c.q() ? "1" : "0");
            jSONObject.put("containe", com.android.gdt.qone.w.c.f());
            com.android.gdt.qone.av.a aVar2 = com.android.gdt.qone.at.a.a(oVar.a).a;
            jSONObject.put("oz", (aVar2.e && com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.s, aVar2.l).booleanValue()) ? com.android.gdt.qone.ag.p.a().a(8, new com.android.gdt.qone.ag.c()) : "");
            jSONObject.put("oz2", !com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.t, com.android.gdt.qone.at.a.a(oVar.a).a.l).booleanValue() ? "" : com.android.gdt.qone.ag.p.a().a(10, new com.android.gdt.qone.ag.d()));
            jSONObject.put("oo", !com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.u, com.android.gdt.qone.at.a.a(oVar.a).a.l).booleanValue() ? "" : com.android.gdt.qone.ag.p.a().a(9, new com.android.gdt.qone.ag.e()));
            jSONObject.put("kelong", aVar.a() ? "1" : "0");
            jSONObject.put("ip", oVar.c());
            jSONObject.put("multiUser", com.android.gdt.qone.ae.e.a(com.android.gdt.qone.ar.d.h().a()));
            jSONObject.put("bod", U.a(com.android.gdt.qone.s.b.a(12)));
            jSONObject.put(com.baidu.mobads.container.adrequest.g.T, U.a(com.android.gdt.qone.s.b.a(13)));
            jSONObject.put("dv", U.a(com.android.gdt.qone.s.b.a(14)));
            jSONObject.put("firstLevel", U.a(com.android.gdt.qone.s.b.a(15)));
            jSONObject.put("manufact", U.a(com.android.gdt.qone.s.b.a(16)));
            jSONObject.put("name", U.a(com.android.gdt.qone.s.b.a(17)));
            jSONObject.put("host", U.a(com.android.gdt.qone.s.b.a(18)));
            synchronized (cVar) {
                if (cVar.n == null) {
                    cVar.n = U.c();
                }
                str = cVar.n;
            }
            jSONObject.put("kernel", str);
            jSONObject.put("pre", String.valueOf(com.android.gdt.qone.w.a.h()));
            jSONObject.put(com.alipay.sdk.m.s.a.w, com.android.gdt.qone.w.a.f());
            jSONObject.put("ch", com.android.gdt.qone.w.a.a());
            String strC = com.android.gdt.qone.w.a.c();
            if (TextUtils.isEmpty(strC)) {
                strC = com.android.gdt.qone.w.a.e();
            }
            String strSubstring = (!TextUtils.isEmpty(strC) && (iLastIndexOf = strC.lastIndexOf(58)) >= 0) ? strC.substring(iLastIndexOf + 1) : "";
            jSONObject.put("svr", strSubstring);
            jSONObject.put("fit", com.android.gdt.qone.w.a.d());
            jSONObject.put("jv", com.android.gdt.qone.ar.d.h().getSdkVersion());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }
}
