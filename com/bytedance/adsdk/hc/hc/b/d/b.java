package com.bytedance.adsdk.hc.hc.b.d;

import com.bytedance.adsdk.hc.hc.hc.d.de;
import java.util.Deque;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends an {
    @Override // com.bytedance.adsdk.hc.hc.b.d.an
    public int d(String str, int i, Deque<com.bytedance.adsdk.hc.hc.hc.d> deque, com.bytedance.adsdk.hc.hc.b.d dVar) {
        char cD = d(i, str);
        if (!com.bytedance.adsdk.hc.hc.u.d.hc(cD) && cD != '$') {
            return dVar.d(str, i, deque);
        }
        return d(str, i, deque);
    }

    private int d(String str, int i, Deque<com.bytedance.adsdk.hc.hc.hc.d> deque) {
        int i2;
        int i3 = 0;
        while (true) {
            i2 = i3 + i;
            char cD = d(i2, str);
            if (!com.bytedance.adsdk.hc.hc.u.d.hc(cD) && !com.bytedance.adsdk.hc.hc.u.d.b(cD) && '.' != cD && '[' != cD && ']' != cD && '_' != cD && '-' != cD && '$' != cD) {
                break;
            }
            i3++;
        }
        String strSubstring = str.substring(i, i2);
        if (com.bytedance.adsdk.hc.hc.c.d.d(strSubstring) != null) {
            deque.push(new com.bytedance.adsdk.hc.hc.hc.d.h(strSubstring));
        } else {
            deque.push(new de(strSubstring));
        }
        return i2;
    }
}
