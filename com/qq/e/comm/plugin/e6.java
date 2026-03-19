package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.io.IOException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class e6 {
    int a;
    int b;
    int c;
    int d;

    void a(w wVar) throws IOException {
    }

    e6() {
    }

    static int a(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & 255) << 24) | (str.charAt(0) & 255) | ((str.charAt(1) & 255) << 8) | ((str.charAt(2) & 255) << 16);
    }

    void b(w wVar) throws IOException {
        int iAvailable = wVar.available();
        a(wVar);
        int iAvailable2 = iAvailable - wVar.available();
        int i = this.a;
        if (iAvailable2 > i) {
            throw new IOException("Out of chunk area");
        }
        if (iAvailable2 < i) {
            wVar.skip(i - iAvailable2);
        }
    }
}
