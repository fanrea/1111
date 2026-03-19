package com.bytedance.sdk.component.hc.d.d.d;

import com.bytedance.sdk.component.b.hc.j;
import com.bytedance.sdk.component.hc.d.cb;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements com.bytedance.sdk.component.hc.d.hc {
    com.bytedance.sdk.component.b.hc.u d;

    public c(com.bytedance.sdk.component.b.hc.u uVar) {
        this.d = uVar;
    }

    @Override // com.bytedance.sdk.component.hc.d.hc
    public cb d() throws IOException {
        return new tt(this.d.hc());
    }

    @Override // com.bytedance.sdk.component.hc.d.hc
    public void d(final com.bytedance.sdk.component.hc.d.b bVar) {
        this.d.d(new com.bytedance.sdk.component.b.hc.an() { // from class: com.bytedance.sdk.component.hc.d.d.d.c.1
            @Override // com.bytedance.sdk.component.b.hc.an
            public void d(com.bytedance.sdk.component.b.hc.u uVar, IOException iOException) {
                bVar.onFailure(new c(uVar), iOException);
            }

            @Override // com.bytedance.sdk.component.b.hc.an
            public void d(com.bytedance.sdk.component.b.hc.u uVar, j jVar) throws IOException {
                bVar.onResponse(new c(uVar), new tt(jVar));
            }
        });
    }

    @Override // com.bytedance.sdk.component.hc.d.hc
    public void hc() {
        this.d.b();
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.hc.d.hc clone() {
        return new c(this.d.u());
    }

    @Override // com.bytedance.sdk.component.hc.d.hc
    public boolean b() {
        return this.d.c();
    }
}
