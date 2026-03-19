package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.pi.UIADI;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class i1 {
    public static NEADI a(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener) {
        if (qp.c(str2)) {
            return new eh(context, aDSize, str, str2, aDListener);
        }
        return new dh(context, aDSize, str, str2, str3, aDListener);
    }

    public static NUADI a(Context context, String str, String str2, String str3, ADListener aDListener) {
        if (qp.c(str2)) {
            return new ir(context, str, str2, aDListener);
        }
        return new com.qq.e.comm.plugin.nativeadunified.f(context, str, str2, str3, aDListener);
    }

    public static RVADI a(Context context, String str, String str2, ADListener aDListener, String str3) {
        if (qp.c(str2)) {
            return new cx(context, str, str2, aDListener);
        }
        return new je(context, str, str2, str3, aDListener);
    }

    public static NSPVI a(Context context, String str, String str2, String str3) {
        if (qp.c(str2)) {
            return new nz(context, str, str2);
        }
        return new qz(context, str, str2, str3);
    }

    public static UBVI a(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, ADListener aDListener) {
        if (qp.c(str2)) {
            return new com.qq.e.comm.plugin.banner2.b(unifiedBannerView, activity, str, str2, aDListener);
        }
        return new h30(unifiedBannerView, activity, str, str2, str3, aDListener);
    }

    public static UIADI a(Activity activity, String str, String str2, String str3, ADListener aDListener) {
        if (qp.c(str2)) {
            return new k30(activity, str, str2, aDListener);
        }
        return new j30(activity, str, str2, str3, aDListener);
    }
}
