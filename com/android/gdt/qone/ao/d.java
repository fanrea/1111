package com.android.gdt.qone.ao;

import android.text.TextUtils;
import com.android.gdt.qone.ag.o;
import com.android.gdt.qone.ag.p;
import com.android.gdt.qone.sdk.S.SpreadValue;
import com.android.gdt.qone.uin.U;
import java.util.HashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class d implements Runnable {
    public final /* synthetic */ h a;

    public d(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        h hVar = this.a;
        String strA = "";
        if (U.e()) {
            str = "";
        } else {
            o oVarA = o.a(hVar.a);
            String strA2 = oVarA.a();
            String str2 = com.android.gdt.qone.at.a.a(oVarA.a).a.i;
            if (TextUtils.isEmpty(str2)) {
                com.android.gdt.qone.av.a aVar = com.android.gdt.qone.at.a.a(oVarA.a).a;
                if (aVar.a && aVar.e && com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.g, aVar.l).booleanValue()) {
                    strA = p.a().a(7, new com.android.gdt.qone.ag.b());
                }
            } else {
                strA = str2;
            }
            str = strA;
            strA = strA2;
        }
        HashMap map = new HashMap();
        map.put(hVar.c, new SpreadValue().a(strA).e(str).b(hVar.a).h(hVar.b).f(com.android.gdt.qone.ap.f.a(hVar.a).a()).g(com.android.gdt.qone.ap.f.a(hVar.a).b()).a(System.currentTimeMillis()).c(hVar.a).d(hVar.b).b(System.currentTimeMillis()));
        String str3 = j.f;
        i.a.a(map, hVar.a, hVar.b);
    }
}
