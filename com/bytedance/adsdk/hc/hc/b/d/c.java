package com.bytedance.adsdk.hc.hc.b.d;

import com.bytedance.adsdk.hc.hc.hc.d.sy;
import java.util.Deque;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends an {
    @Override // com.bytedance.adsdk.hc.hc.b.d.an
    public int d(String str, int i, Deque<com.bytedance.adsdk.hc.hc.hc.d> deque, com.bytedance.adsdk.hc.hc.b.d dVar) {
        if ('(' != d(i, str)) {
            return dVar.d(str, i, deque);
        }
        deque.push(new sy(com.bytedance.adsdk.hc.hc.c.c.LEFT_PAREN));
        return i + 1;
    }
}
