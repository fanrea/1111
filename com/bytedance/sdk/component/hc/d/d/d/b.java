package com.bytedance.sdk.component.hc.d.d.d;

import com.bytedance.sdk.component.b.hc.cb;
import com.bytedance.sdk.component.b.hc.np;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends cb {
    private d hc;

    public b(d dVar) {
        this.hc = dVar;
    }

    @Override // com.bytedance.sdk.component.b.hc.cb
    public void d(com.bytedance.sdk.component.b.hc.u uVar, InetSocketAddress inetSocketAddress, Proxy proxy, np npVar, IOException iOException) {
        super.d(uVar, inetSocketAddress, proxy, npVar, iOException);
        d dVar = this.hc;
        if (dVar != null) {
            dVar.d(uVar, inetSocketAddress, proxy, npVar, iOException);
        }
    }

    @Override // com.bytedance.sdk.component.b.hc.cb
    public void d(com.bytedance.sdk.component.b.hc.u uVar, IOException iOException) {
        super.d(uVar, iOException);
        d dVar = this.hc;
        if (dVar != null) {
            dVar.d(uVar, iOException);
        }
    }
}
