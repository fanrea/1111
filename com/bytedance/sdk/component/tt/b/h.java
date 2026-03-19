package com.bytedance.sdk.component.tt.b;

import android.content.Context;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h {
    private static HashMap<Integer, d> b;
    private static volatile h d;
    private static HashMap<Integer, u> hc;

    private h() {
        hc = new HashMap<>();
        b = new HashMap<>();
    }

    public static synchronized h d() {
        if (d == null) {
            synchronized (h.class) {
                if (d == null) {
                    d = new h();
                }
            }
        }
        return d;
    }

    public u d(int i) {
        u uVar = hc.get(Integer.valueOf(i));
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(i);
        hc.put(Integer.valueOf(i), uVar2);
        return uVar2;
    }

    public d d(int i, Context context) {
        d dVar = b.get(Integer.valueOf(i));
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(context, i);
        b.put(Integer.valueOf(i), dVar2);
        return dVar2;
    }
}
