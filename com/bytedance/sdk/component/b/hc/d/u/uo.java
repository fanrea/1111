package com.bytedance.sdk.component.b.hc.d.u;

import java.io.IOException;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface uo {
    public static final uo d = new uo() { // from class: com.bytedance.sdk.component.b.hc.d.u.uo.1
        @Override // com.bytedance.sdk.component.b.hc.d.u.uo
        public boolean d(int i, List<b> list) {
            return true;
        }

        @Override // com.bytedance.sdk.component.b.hc.d.u.uo
        public boolean d(int i, List<b> list, boolean z) {
            return true;
        }

        @Override // com.bytedance.sdk.component.b.hc.d.u.uo
        public boolean d(int i, com.bytedance.sdk.component.b.d.u uVar, int i2, boolean z) throws IOException {
            uVar.gb(i2);
            return true;
        }
    };

    boolean d(int i, com.bytedance.sdk.component.b.d.u uVar, int i2, boolean z) throws IOException;

    boolean d(int i, List<b> list);

    boolean d(int i, List<b> list, boolean z);
}
