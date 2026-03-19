package com.bytedance.adsdk.hc.hc.b.d;

import com.bytedance.adsdk.hc.hc.hc.d.e;
import java.util.Deque;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h extends an {
    private boolean d(String str, int i, Deque<com.bytedance.adsdk.hc.hc.hc.d> deque) {
        if ('-' == d(i, str)) {
            if (deque.peek() != null && !com.bytedance.adsdk.hc.hc.c.b.d(deque.peek().d())) {
                return false;
            }
            if (com.bytedance.adsdk.hc.hc.u.d.b(d(i + 1, str))) {
                return true;
            }
            throw new IllegalArgumentException("Unrecognized - symbol, not a negative number or operator, problem range:" + str.substring(0, i));
        }
        return com.bytedance.adsdk.hc.hc.u.d.b(d(i, str));
    }

    @Override // com.bytedance.adsdk.hc.hc.b.d.an
    public int d(String str, int i, Deque<com.bytedance.adsdk.hc.hc.hc.d> deque, com.bytedance.adsdk.hc.hc.b.d dVar) {
        char cD;
        if (!d(str, i, deque)) {
            return dVar.d(str, i, deque);
        }
        int i2 = d(i, str) == '-' ? i + 1 : i;
        boolean z = false;
        while (true) {
            cD = d(i2, str);
            if (!com.bytedance.adsdk.hc.hc.u.d.b(cD) && (z || cD != '.')) {
                break;
            }
            i2++;
            if (cD == '.') {
                z = true;
            }
        }
        if (cD == '.') {
            throw new IllegalArgumentException("Illegal negative number format, problem interval:" + str.substring(i, i2));
        }
        deque.push(new e(str.substring(i, i2)));
        return i2;
    }
}
