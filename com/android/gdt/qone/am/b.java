package com.android.gdt.qone.am;

import android.text.TextUtils;
import com.android.gdt.qone.ai.c;
import com.android.gdt.qone.ap.f;
import com.qq.e.comm.managers.setting.GlobalSetting;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;

    public b(int i, String str) {
        this.a = str;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String strValueOf = String.valueOf(com.android.gdt.qone.ap.a.a());
        com.android.gdt.qone.ak.b bVarA = f.a(this.a);
        String str2 = "0";
        if (bVarA != null) {
            String str3 = TextUtils.isEmpty(bVarA.a()) ? "0" : "1";
            str = TextUtils.isEmpty(bVarA.b()) ? "0" : "1";
            str2 = str3;
        } else {
            str = "0";
        }
        String str4 = this.a;
        long j = this.b;
        com.android.gdt.qone.ai.f fVarA = com.android.gdt.qone.ai.f.a();
        c cVarA = com.android.gdt.qone.r.b.a(fVarA);
        cVarA.a.put("6", str2);
        cVarA.a.put("7", str);
        cVarA.a.put(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, String.valueOf(j));
        cVarA.a.put("9", strValueOf);
        fVarA.a(cVarA, "v8", str4);
    }
}
