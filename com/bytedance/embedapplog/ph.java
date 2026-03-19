package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ph {
    private static volatile String d;

    public static String d(Context context, fs fsVar) {
        AdvertisingIdClient.Info advertisingIdInfo;
        if (TextUtils.isEmpty(d)) {
            synchronized (ph.class) {
                if (!TextUtils.isEmpty(d)) {
                    return d;
                }
                try {
                    advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                } catch (Throwable th) {
                    if (!(th instanceof ClassNotFoundException) && !(th instanceof NoClassDefFoundError)) {
                        com.bytedance.sdk.component.utils.mq.d(th);
                    }
                }
                String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                if (TextUtils.isEmpty(id)) {
                    id = fsVar.c().getString("google_aid", null);
                } else if (!TextUtils.equals(fsVar.c().getString("google_aid", null), id)) {
                    d(context, id, fsVar);
                }
                d = id;
            }
        }
        return d;
    }

    private static void d(Context context, String str, fs fsVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        fsVar.c().edit().putString("google_aid", str).apply();
    }
}
