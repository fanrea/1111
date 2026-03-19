package com.android.gdt.qone.ap;

import android.text.TextUtils;
import com.android.gdt.qone.ad.h;
import com.android.gdt.qone.uin.U;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b implements com.android.gdt.qone.x.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public b(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // com.android.gdt.qone.x.a
    public final void a() {
        String str = this.a;
        String str2 = this.b;
        if (com.android.gdt.qone.an.a.a.a) {
            byte bA = U.a(str, str2);
            if (bA != 0) {
                com.android.gdt.qone.ai.f fVarA = com.android.gdt.qone.ai.f.a();
                com.android.gdt.qone.ai.c cVarA = com.android.gdt.qone.r.b.a(fVarA);
                cVarA.a.put("6", String.valueOf((int) bA));
                fVarA.a(cVarA, "v6", str);
            }
            if (bA == 0) {
                com.android.gdt.qone.u.a.a("com.qone.qm.mulprocess_share", com.android.gdt.qone.w.a.e(), null);
                h.a(str).a("q_s_t", System.currentTimeMillis());
                com.android.gdt.qone.af.c.b("QM", "QM was successfully updated to local: %s (appKey: %s)", str2, str);
                if (TextUtils.isEmpty(h.a(str).c("is_first"))) {
                    h.a(str).a("is_first", "false");
                }
            }
        }
    }
}
