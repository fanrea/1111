package com.bytedance.sdk.djx.internal.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class MetaDataUtils {
    private static final String TAG = "MetaDataUtils";
    private static ApplicationInfo applicationInfoCache;

    public static <T> T getMetaDataInApp(Context context, String str) {
        if (str != null && str.length() != 0) {
            if (applicationInfoCache == null) {
                try {
                    applicationInfoCache = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
            ApplicationInfo applicationInfo = applicationInfoCache;
            if (applicationInfo != null && applicationInfo.metaData != null) {
                try {
                    return (T) applicationInfoCache.metaData.get(str);
                } catch (Exception e2) {
                    DJXLogger.e(TAG, "meta data get error: " + str, e2);
                }
            }
        }
        return null;
    }
}
