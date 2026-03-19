package com.bytedance.sdk.djx.net.k3;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface Authenticator {
    public static final Authenticator NONE = new Authenticator() { // from class: com.bytedance.sdk.djx.net.k3.Authenticator.1
        @Override // com.bytedance.sdk.djx.net.k3.Authenticator
        public Request authenticate(Route route, Response response) {
            return null;
        }
    };

    Request authenticate(Route route, Response response) throws IOException;
}
