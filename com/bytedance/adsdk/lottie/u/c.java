package com.bytedance.adsdk.lottie.u;

import com.bytedance.adsdk.lottie.mk;
import com.bytedance.sdk.component.utils.mq;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements mk {
    private static final Set<String> d = new HashSet();

    @Override // com.bytedance.adsdk.lottie.mk
    public void d(String str) {
        d(str, null);
    }

    @Override // com.bytedance.adsdk.lottie.mk
    public void d(String str, Throwable th) {
        Set<String> set = d;
        if (set.contains(str)) {
            return;
        }
        mq.hc(com.component.lottie.c.b, str, th);
        set.add(str);
    }

    @Override // com.bytedance.adsdk.lottie.mk
    public void hc(String str, Throwable th) {
        boolean z = com.bytedance.adsdk.lottie.u.d;
    }
}
