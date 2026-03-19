package com.bytedance.sdk.component.b.hc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface e {
    public static final e d = new e() { // from class: com.bytedance.sdk.component.b.hc.e.1
        @Override // com.bytedance.sdk.component.b.hc.e
        public List<InetAddress> d(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (Throwable unused) {
                return new ArrayList();
            }
        }
    };

    List<InetAddress> d(String str) throws UnknownHostException;
}
