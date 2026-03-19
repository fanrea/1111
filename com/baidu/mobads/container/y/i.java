package com.baidu.mobads.container.y;

import com.baidu.mobads.container.util.b.a.k;
import com.baidu.mobads.container.y.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class i implements k.a {
    final /* synthetic */ h.b a;
    final /* synthetic */ h b;

    i(h hVar, h.b bVar) {
        this.b = hVar;
        this.a = bVar;
    }

    @Override // com.baidu.mobads.container.util.b.a.k.a
    public void a(String str, String str2, long j) {
    }

    @Override // com.baidu.mobads.container.util.b.a.k.a
    public void a(String str, String str2, com.baidu.mobads.container.util.b.f<?> fVar) {
        if (this.a != null) {
            this.a.b(new h.a(str2, str));
        }
    }

    @Override // com.baidu.mobads.container.util.b.a.k.a
    public void a(String str, String str2, com.baidu.mobads.container.util.d.c cVar) {
        if (this.a != null) {
            this.a.a("Store cache data failed!", -2);
        }
    }
}
