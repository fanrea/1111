package com.qq.e.comm.plugin;

import android.content.Context;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.mediation.interfaces.BaseNativeExpressAd;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class r7 {
    public static BaseNativeExpressAd a(String str, ADSize aDSize, Context context, String str2, String str3, String str4) throws Exception {
        return (BaseNativeExpressAd) Class.forName(str).asSubclass(BaseNativeExpressAd.class).getDeclaredConstructor(Context.class, ADSize.class, String.class, String.class, String.class).newInstance(context, aDSize, str2, str3, str4);
    }
}
