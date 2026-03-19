package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bb {
    private static String getPackageName(Context context) {
        return ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).TQ() ? "com.kwad.sdk" : context.getPackageName();
    }

    private static int getIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, getPackageName(context));
    }

    public static int getId(Context context, String str) {
        return getIdentifier(context, str, "id");
    }

    public static int getAppIconId(Context context) {
        int i;
        try {
            i = y.getPackageInfo(context.getApplicationContext(), context.getPackageName(), 64).applicationInfo.icon;
        } catch (Throwable unused) {
            i = 0;
        }
        return i <= 0 ? aL(context, "ksad_notification_small_icon") : i;
    }

    public static int aL(Context context, String str) {
        Resources resourcesEf = ef(context);
        if (resourcesEf == null) {
            resourcesEf = context.getResources();
        }
        return resourcesEf.getIdentifier(str, "drawable", context.getPackageName());
    }

    public static Resources ef(Context context) {
        if (context == null) {
            return null;
        }
        return ServiceProvider.anu().getResources();
    }
}
