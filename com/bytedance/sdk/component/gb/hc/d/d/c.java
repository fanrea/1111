package com.bytedance.sdk.component.gb.hc.d.d;

import com.bytedance.sdk.component.gb.d.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private static String d = "com.bytedance.openadsdk";
    private static String hc = "content://" + d + ".TTMultiProvider";

    public static String d(u uVar) {
        if (uVar.getContext() != null) {
            d = uVar.getContext().getPackageName();
            hc = "content://" + d + ".TTMultiProvider";
        }
        return hc;
    }
}
