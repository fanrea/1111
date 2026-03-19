package com.bytedance.sdk.component.b.hc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class cb {
    public static final cb d = new cb() { // from class: com.bytedance.sdk.component.b.hc.cb.1
    };

    public interface d {
        cb d(u uVar);
    }

    public void d(u uVar, IOException iOException) {
    }

    public void d(u uVar, InetSocketAddress inetSocketAddress, Proxy proxy, np npVar, IOException iOException) {
    }

    static d d(cb cbVar) {
        return new d() { // from class: com.bytedance.sdk.component.b.hc.cb.2
            @Override // com.bytedance.sdk.component.b.hc.cb.d
            public cb d(u uVar) {
                return cb.this;
            }
        };
    }
}
