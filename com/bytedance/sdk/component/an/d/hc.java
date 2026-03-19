package com.bytedance.sdk.component.an.d;

import com.bytedance.sdk.component.an.mq;
import com.bytedance.sdk.component.an.tt;
import java.security.NoSuchAlgorithmException;
import java.util.WeakHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static mq d() {
        return new mq() { // from class: com.bytedance.sdk.component.an.d.hc.1
            private WeakHashMap<String, String> d = new WeakHashMap<>();

            @Override // com.bytedance.sdk.component.an.mq
            public String d(tt ttVar) {
                return d(ttVar.hc() + "#width=" + ttVar.b() + "#height=" + ttVar.c() + "#scaletype=" + ttVar.u() + "#bitmapConfig=" + ttVar.gb());
            }

            @Override // com.bytedance.sdk.component.an.mq
            public String hc(tt ttVar) {
                return d(ttVar.hc());
            }

            private String d(String str) throws NoSuchAlgorithmException {
                String str2 = this.d.get(str);
                if (str2 != null) {
                    return str2;
                }
                String strD = com.bytedance.sdk.component.an.b.b.b.d(str);
                this.d.put(str, strD);
                return strD;
            }
        };
    }
}
