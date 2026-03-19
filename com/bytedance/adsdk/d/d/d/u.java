package com.bytedance.adsdk.d.d.d;

import android.text.TextUtils;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class u {
    int an;
    int c;
    int h;
    int u;

    void d(com.bytedance.adsdk.d.d.hc.d dVar) throws IOException {
    }

    u() {
    }

    static int d(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & 255) << 24) | (str.charAt(0) & 255) | ((str.charAt(1) & 255) << 8) | ((str.charAt(2) & 255) << 16);
    }

    void hc(com.bytedance.adsdk.d.d.hc.d dVar) throws IOException {
        int iC = dVar.c();
        d(dVar);
        int iC2 = iC - dVar.c();
        int i = this.c;
        if (iC2 > i) {
            throw new IOException("Out of chunk area");
        }
        if (iC2 < i) {
            dVar.d(i - iC2);
        }
    }
}
