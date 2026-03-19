package com.android.gdt.qone.ak;

import com.android.gdt.qone.uin.U;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.sigmob.sdk.base.mta.PointType;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class m implements a {
    public final /* synthetic */ o a;

    public m(o oVar) {
        this.a = oVar;
    }

    @Override // com.android.gdt.qone.ak.a
    public final void a(b bVar) {
        com.android.gdt.qone.ah.a aVarA = com.android.gdt.qone.ah.a.a();
        String str = this.a.d;
        synchronized (aVarA) {
        }
        com.android.gdt.qone.am.a aVarA2 = com.android.gdt.qone.am.a.a(this.a.d);
        if (aVarA2.a()) {
            int i = aVarA2.c ? 2 : aVarA2.b ? 1 : 0;
            StringBuilder sb = new StringBuilder();
            sb.append(aVarA2.c ? "1" : "0");
            sb.append(aVarA2.b ? "1" : "0");
            sb.append(aVarA2.d);
            String string = sb.toString();
            if (aVarA2.e == null) {
                aVarA2.e = new b("", "", aVarA2.a);
            }
            String str2 = aVarA2.a;
            com.android.gdt.qone.ar.a aVar = new com.android.gdt.qone.ar.a(str2);
            String strA = aVarA2.e.a();
            String strB = aVarA2.e.b();
            String strC = aVar.c();
            String strF = aVar.f();
            com.android.gdt.qone.ai.f fVarA = com.android.gdt.qone.ai.f.a();
            com.android.gdt.qone.ai.c cVarA = com.android.gdt.qone.r.b.a(fVarA);
            cVarA.a.put("6", strA);
            cVarA.a.put("7", strB);
            cVarA.a.put("9", strC);
            cVarA.a.put(PointType.SIGMOB_APP, strF);
            cVarA.a.put(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, String.valueOf(i));
            cVarA.a.put("11", string);
            fVarA.a(cVarA, "v7", str2);
            com.android.gdt.qone.af.c.b("CloneDetect", "%s, %s is clone，type：%d", str2, com.android.gdt.qone.w.a.e(), Integer.valueOf(i));
        }
        com.android.gdt.qone.ao.h hVarA = com.android.gdt.qone.ao.h.a(this.a.d);
        if (com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.v, com.android.gdt.qone.at.a.a(hVarA.a).a.l).booleanValue() && com.android.gdt.qone.w.a.g()) {
            com.android.gdt.qone.v.a.a().a(new com.android.gdt.qone.ao.d(hVarA));
            com.android.gdt.qone.v.a.a().a(com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.b.A, com.android.gdt.qone.at.a.a(hVarA.a).a.l).intValue() * 1000, new com.android.gdt.qone.ao.g(hVarA));
        }
        String str3 = this.a.d;
        if (com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.x, com.android.gdt.qone.at.a.a(str3).a.l).booleanValue()) {
            U.e(str3);
        }
    }
}
