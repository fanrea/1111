package com.android.gdt.qone.ap;

import com.android.gdt.qone.uin.U;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class c implements com.android.gdt.qone.x.a {
    public final /* synthetic */ String a;

    public c(String str) {
        this.a = str;
    }

    @Override // com.android.gdt.qone.x.a
    public final void a() {
        byte bA;
        com.android.gdt.qone.an.b bVar = com.android.gdt.qone.an.a.a;
        String str = this.a;
        if (bVar.a && (bA = U.a(str, "")) != 0) {
            com.android.gdt.qone.ai.f fVarA = com.android.gdt.qone.ai.f.a();
            com.android.gdt.qone.ai.c cVarA = com.android.gdt.qone.r.b.a(fVarA);
            cVarA.a.put("6", String.valueOf((int) bA));
            fVarA.a(cVarA, "v6", str);
        }
    }
}
