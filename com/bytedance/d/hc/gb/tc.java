package com.bytedance.d.hc.gb;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class tc {
    public static void d(String str) {
        if (com.bytedance.d.hc.gb.u().an()) {
            com.bytedance.sdk.component.utils.mq.d("npth", str);
        }
    }

    public static void d(Throwable th) {
        if (com.bytedance.d.hc.gb.u().an()) {
            com.bytedance.sdk.component.utils.mq.b("npth", "NPTH Catch Error", th);
        }
    }

    public static void hc(Throwable th) {
        if (com.bytedance.d.hc.gb.u().an()) {
            com.bytedance.sdk.component.utils.mq.hc("npth", "NPTH Catch Error", th);
        }
    }
}
