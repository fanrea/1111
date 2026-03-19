package com.kuaishou.aegon.httpdns;

import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final /* synthetic */ class a implements Runnable {
    private final List a;

    private a(List list) {
        this.a = list;
    }

    public static Runnable a(List list) {
        return new a(list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpDnsResolver.nativeIncreasePriority((String[]) this.a.toArray(new String[0]));
    }
}
