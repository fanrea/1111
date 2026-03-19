package com.pandora.common.utils;

import android.content.Context;
import android.text.TextUtils;
import com.pandora.common.applog.AppLogWrapper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AppLogUtils {
    public static final String APPLOG_CLASS_NAME = "com.bytedance.applog.AppLog";
    private static final String TAG = "AppLogUtils";
    private static Class<?> sAppLogClass;

    public static boolean isAppLogExist() {
        try {
            return getAppLogClass() != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void init(Context context, String appid, String appRegion, String channel, boolean securityDeviceId, boolean autoStartAppLog) {
        if (context == null) {
            return;
        }
        TTVideoLog.d(TAG, "init appid:" + appid + ", channel:" + channel);
        if (TextUtils.isEmpty(appid)) {
            return;
        }
        AppLogWrapper.init(context, appid, appRegion, channel, securityDeviceId, autoStartAppLog);
    }

    private static Class<?> getAppLogClass() throws ClassNotFoundException {
        Class<?> cls;
        synchronized (AppLogUtils.class) {
            if (sAppLogClass == null) {
                sAppLogClass = Class.forName("com.bytedance.applog.AppLog");
            }
            cls = sAppLogClass;
        }
        return cls;
    }

    public static void startAppLog() {
        AppLogWrapper.start();
    }
}
