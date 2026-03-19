package com.bytedance.adsdk.hc.hc.b.d;

import java.util.Deque;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends an {
    @Override // com.bytedance.adsdk.hc.hc.b.d.an
    public int d(String str, int i, Deque<com.bytedance.adsdk.hc.hc.hc.d> deque, com.bytedance.adsdk.hc.hc.b.d dVar) {
        char cD;
        int i2 = i;
        while (true) {
            cD = d(i2, str);
            if (!com.bytedance.adsdk.hc.hc.u.d.hc(cD) && !com.bytedance.adsdk.hc.hc.u.d.b(cD)) {
                break;
            }
            i2++;
        }
        if (cD != '(') {
            return dVar.d(str, i, deque);
        }
        deque.push(new com.bytedance.adsdk.hc.hc.hc.d.tc(str.substring(i, i2)));
        return i2 + 1;
    }
}
