package com.bytedance.adsdk.hc.hc.b.d;

import com.bytedance.adsdk.hc.hc.hc.d.jh;
import java.util.Deque;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends an {
    @Override // com.bytedance.adsdk.hc.hc.b.d.an
    public int d(String str, int i, Deque<com.bytedance.adsdk.hc.hc.hc.d> deque, com.bytedance.adsdk.hc.hc.b.d dVar) {
        if ('\'' != d(i, str)) {
            return dVar.d(str, i, deque);
        }
        int i2 = i + 1;
        int length = str.length();
        int i3 = i2;
        while (i3 < length && d(i3, str) != '\'') {
            i3++;
        }
        if (d(i3, str) != '\'') {
            throw new com.bytedance.adsdk.hc.d.d("String expression not surrounded by '", str.substring(i2 - 1));
        }
        deque.push(new jh(str.substring(i2, i3)));
        return i3 + 1;
    }
}
