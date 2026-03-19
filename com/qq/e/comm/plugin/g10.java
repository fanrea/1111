package com.qq.e.comm.plugin;

import java.util.Iterator;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class g10 {
    private final l50<String, m> a = new l50<>();

    public void a(m mVar) {
        this.a.a((l50<String, m>) "*", (String) mVar);
    }

    public void b(m mVar) {
        b("*", mVar);
    }

    public void a(String str, m mVar) {
        this.a.a((l50<String, m>) str, (String) mVar);
    }

    public void b(String str, m mVar) {
        this.a.a(str, (String) mVar);
    }

    public void a(String str, int i, int i2, long j) {
        Iterator<m> it = this.a.a(str).iterator();
        while (it.hasNext()) {
            it.next().a(str, i, i2, j);
        }
        Iterator<m> it2 = this.a.a("*").iterator();
        while (it2.hasNext()) {
            it2.next().a(str, i, i2, j);
        }
    }
}
