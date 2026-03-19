package com.bytedance.sdk.component.hc.d;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class u extends e {
    List<String> d;
    List<String> hc;

    u(List<String> list, List<String> list2) {
        this.d = list;
        this.hc = list2;
    }

    public static final class d {
        private final List<String> d = new ArrayList();
        private final List<String> hc = new ArrayList();

        public d d(String str, String str2) {
            this.d.add(str);
            this.hc.add(str2);
            return this;
        }

        public u d() {
            return new u(this.d, this.hc);
        }
    }
}
