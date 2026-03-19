package com.android.gdt.qone.r;

import com.android.gdt.qone.ai.f;
import com.qq.e.comm.managers.setting.GlobalSetting;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class d {
    @com.android.gdt.qone.q.b
    public static int sendSample(int i, int i2, int i3) {
        f fVarA = f.a();
        com.android.gdt.qone.ai.c cVarA = b.a(fVarA);
        cVarA.a.put("6", String.valueOf(i));
        cVarA.a.put("7", String.valueOf(i2));
        cVarA.a.put(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, String.valueOf(i3));
        a.a().getClass();
        fVarA.a(cVarA, "x8", null);
        return 0;
    }
}
