package com.kuaishou.aegon.httpdns;

import com.kuaishou.aegon.a.a;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final /* synthetic */ class b implements a.InterfaceC0398a {
    private final String a;

    private b(String str) {
        this.a = str;
    }

    public static a.InterfaceC0398a a(String str) {
        return new b(str);
    }

    @Override // com.kuaishou.aegon.a.a.InterfaceC0398a
    public final Object get() {
        return HttpDnsResolver.nativeResolve(this.a);
    }
}
