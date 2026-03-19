package com.bytedance.adsdk.hc.hc.b.d;

import com.alibaba.fastjson.parser.JSONLexer;
import java.util.Deque;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class an {
    public abstract int d(String str, int i, Deque<com.bytedance.adsdk.hc.hc.hc.d> deque, com.bytedance.adsdk.hc.hc.b.d dVar);

    protected char d(int i, String str) {
        return i >= str.length() ? JSONLexer.EOI : str.charAt(i);
    }

    protected int hc(int i, String str) {
        while (com.bytedance.adsdk.hc.hc.u.d.d(d(i, str))) {
            i++;
        }
        return i;
    }

    protected int getIdentifier(int i, String str) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + i;
            char cD = d(i3, str);
            if (!com.bytedance.adsdk.hc.hc.u.d.hc(cD) && !com.bytedance.adsdk.hc.hc.u.d.b(cD)) {
                return i3;
            }
            i2++;
        }
    }
}
