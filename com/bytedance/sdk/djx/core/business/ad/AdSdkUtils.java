package com.bytedance.sdk.djx.core.business.ad;

import android.text.TextUtils;
import com.bykv.vk.openvk.TTVfSdk;
import com.bytedance.sdk.djx.utils.Reflector;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AdSdkUtils {
    private static final String IS_P_FIELD = "IS_P";
    private static final String OPEN_CLASS = "com.bytedance.sdk.openadsdk.TTAdNative";
    private static final String OPPO_3110_CLASS = "com.bykv.vk.openvk.TTVfNative";
    private static final String OPPO_CLASS = "com.ttshell.sdk.api.TTObNative";
    private static final String TTAD_CONSTANT_CLASS = "com.bytedance.sdk.openadsdk.TTAdConstant";
    private static final String TTAD_CONSTANT_CLASS2 = "com.bytedance.sdk.openadsdk.TTAdSdk";

    public static boolean isInitSuccess() {
        try {
            if (isExist(OPEN_CLASS)) {
                return TTAdSdk.isInitSuccess();
            }
            if (isExist(OPPO_3110_CLASS)) {
                return TTVfSdk.isInitSuccess();
            }
            return isExist(OPPO_CLASS);
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isPluginSdk() {
        if (!isExist(OPEN_CLASS)) {
            return false;
        }
        try {
            try {
                return ((Boolean) Reflector.on(TTAD_CONSTANT_CLASS).field(IS_P_FIELD).get((Object) null)).booleanValue();
            } catch (Throwable unused) {
                return false;
            }
        } catch (Throwable unused2) {
            return ((Boolean) Reflector.on(TTAD_CONSTANT_CLASS2).field(IS_P_FIELD).get((Object) null)).booleanValue();
        }
    }

    public static boolean isOppo() {
        return isExist(OPPO_CLASS) || isExist(OPPO_3110_CLASS);
    }

    public static String getVersion() {
        String sDKVersion;
        try {
            if (isExist(OPPO_3110_CLASS)) {
                sDKVersion = TTVfSdk.getVfManager().getSDKVersion();
            } else {
                sDKVersion = isExist(OPEN_CLASS) ? TTAdSdk.getAdManager().getSDKVersion() : "";
            }
            return sDKVersion;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isAdSdkExist() {
        return isExist(OPEN_CLASS) || isExist(OPPO_CLASS) || isExist(OPPO_3110_CLASS);
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
