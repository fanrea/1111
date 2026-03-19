package com.bytedance.msdk.gb;

import com.bytedance.sdk.openadsdk.ats.AutoService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class e {
    private static boolean d = true;

    public static byte[] d(byte[] bArr, int i) {
        com.bytedance.sdk.component.c.hc hcVar = (com.bytedance.sdk.component.c.hc) AutoService.d(com.bytedance.sdk.component.c.hc.class);
        return hcVar != null ? hcVar.d(bArr, i) : new byte[0];
    }

    public static boolean d() {
        com.bytedance.msdk.d.u.b.hc("TMe", "applogSOLoadSuccess = " + d);
        return d;
    }

    static {
        try {
            com.bytedance.sdk.openadsdk.zw.an.d("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError unused) {
            d = false;
        }
    }
}
