package com.bytedance.adsdk.hc.hc.b.d;

import com.bytedance.adsdk.hc.hc.hc.d.cb;
import java.util.Deque;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb extends an {
    @Override // com.bytedance.adsdk.hc.hc.b.d.an
    public int d(String str, int i, Deque<com.bytedance.adsdk.hc.hc.hc.d> deque, com.bytedance.adsdk.hc.hc.b.d dVar) {
        if (!com.bytedance.adsdk.hc.hc.u.d.c(d(i, str))) {
            return dVar.d(str, i, deque);
        }
        int i2 = i + 1;
        String str2 = new String(new char[]{d(i, str), d(i2, str)});
        if (com.bytedance.adsdk.hc.hc.c.b.d(str2) != null) {
            deque.push(new cb(com.bytedance.adsdk.hc.hc.c.b.d(str2)));
            return i + 2;
        }
        String strValueOf = String.valueOf(d(i, str));
        if (com.bytedance.adsdk.hc.hc.c.b.d(strValueOf) != null) {
            deque.push(new cb(com.bytedance.adsdk.hc.hc.c.b.d(strValueOf)));
            return i2;
        }
        throw new IllegalArgumentException("Unrecognized:" + strValueOf + "examine:" + str.substring(0, i));
    }
}
