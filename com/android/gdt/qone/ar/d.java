package com.android.gdt.qone.ar;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class d implements c {
    public static volatile d a;

    public static d h() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    @Override // com.android.gdt.qone.ar.c
    public final synchronized Context a() {
        ConcurrentHashMap concurrentHashMap = com.android.gdt.qone.aq.b.a;
        com.android.gdt.qone.aq.a.a.getClass();
        com.android.gdt.qone.as.a aVar = (com.android.gdt.qone.as.a) com.android.gdt.qone.aq.b.a.get("SdkInfo");
        c cVar = aVar instanceof c ? (c) aVar : null;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    @Override // com.android.gdt.qone.ar.c
    public final String getSdkVersion() {
        ConcurrentHashMap concurrentHashMap = com.android.gdt.qone.aq.b.a;
        com.android.gdt.qone.aq.a.a.getClass();
        com.android.gdt.qone.as.a aVar = (com.android.gdt.qone.as.a) com.android.gdt.qone.aq.b.a.get("SdkInfo");
        c cVar = aVar instanceof c ? (c) aVar : null;
        return cVar == null ? "" : cVar.getSdkVersion();
    }
}
