package com.bytedance.sdk.djx.internal.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.openvk.TTVfSdk;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.ttshell.sdk.api.config.TTObSdk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AdSdkVersionCheckUtil {
    private static final String MIN_OPEN_OPPO_3110_SDK_VERSION = "3.4.6.3";
    private static final String MIN_OPEN_OPPO_SDK_VERSION = "2.8.1.0";
    public static final String MIN_OPEN_SDK_VERSION = "4.6.0.0";
    private static final String OPEN_CLASS = "com.bytedance.sdk.openadsdk.TTAdNative";
    private static final String OPPO_3110_CLASS = "com.bykv.vk.openvk.TTVfNative";
    private static final String OPPO_CLASS = "com.ttshell.sdk.api.TTObNative";
    private static final String TAG = "AdSdkVersionCheckUtil";
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static String sOpenAdCheckerMessage = "";

    public static boolean checkOpenAdSdkVersion() {
        String sDKVersion = null;
        sOpenAdCheckerMessage = null;
        try {
            if (isExist(OPPO_CLASS)) {
                sDKVersion = TTObSdk.getAdManager().getSDKVersion();
                if (MIN_OPEN_OPPO_SDK_VERSION.compareTo(sDKVersion) > 0) {
                    sOpenAdCheckerMessage = "穿山甲版本过低，推荐版本为4.6.0.0";
                }
            } else if (isExist(OPPO_3110_CLASS)) {
                sDKVersion = TTVfSdk.getVfManager().getSDKVersion();
                if (MIN_OPEN_OPPO_3110_SDK_VERSION.compareTo(sDKVersion) > 0) {
                    sOpenAdCheckerMessage = "穿山甲版本过低，推荐版本为3.4.6.3";
                }
            } else if (isExist(OPEN_CLASS)) {
                sDKVersion = TTAdSdk.getAdManager().getSDKVersion();
                if (MIN_OPEN_SDK_VERSION.compareTo(sDKVersion) > 0) {
                    sOpenAdCheckerMessage = "穿山甲版本过低，推荐版本为4.6.0.0";
                }
            } else {
                sOpenAdCheckerMessage = "穿山甲接入版本异常";
            }
            DJXLogger.d(TAG, "openadsdk version: " + String.valueOf(sDKVersion));
            return TextUtils.isEmpty(sOpenAdCheckerMessage);
        } catch (Throwable th) {
            DJXLogger.e(TAG, "checkOpenAdSdkVersion: ", th);
            return false;
        }
    }

    private static boolean isExist(String str) throws ClassNotFoundException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
