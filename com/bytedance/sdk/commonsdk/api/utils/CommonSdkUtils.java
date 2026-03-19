package com.bytedance.sdk.commonsdk.api.utils;

import android.content.Context;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.sdk.commonsdk.api.ICommonPrivacyController;
import com.bytedance.sdk.commonsdk.api.IGetNewTokenApiConfigCallback;
import com.bytedance.sdk.commonsdk.api.service.ICommonSdkApplogService;
import com.bytedance.sdk.commonsdk.api.service.ICommonSdkService;
import com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService;
import com.bytedance.sdk.djx.net.api.TokenApiConfig;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class CommonSdkUtils {
    private static final String TAG = "CommonSdkUtils";
    private static ICommonSdkService sCommonSdkService;
    private static Context sContext;

    public static Context getContext() {
        return sContext;
    }

    private CommonSdkUtils() {
    }

    public static void init(Context context, boolean z, boolean z2) {
        initContext(context);
        initLGBase(z);
        initCommonSdkLogger(z2);
    }

    private static void initContext(Context context) {
        if (context == null || sContext != null) {
            return;
        }
        sContext = context.getApplicationContext();
    }

    private static void initLGBase(boolean z) {
        LGBase.init(z);
    }

    private static void initCommonSdkLogger(boolean z) {
        CommonSdkLogger.DEBUG = z;
    }

    private static ICommonSdkService commonSdkServiceImpl(ClassLoader classLoader) {
        ICommonSdkService iCommonSdkService = sCommonSdkService;
        if (iCommonSdkService != null) {
            return iCommonSdkService;
        }
        try {
            sCommonSdkService = (ICommonSdkService) classLoader.loadClass("com.bytedance.sdk.commonsdk.register.CommonSdkService").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            CommonSdkLogger.d(TAG, "CommonSdkService class load failed,ex=" + e.getMessage());
        }
        return sCommonSdkService;
    }

    public static IAppLogInstance getAppLogInstance(ClassLoader classLoader, String str) {
        return getCommonSdkApplogService(classLoader).getAppLogInstance(str);
    }

    public static void initApplog(ClassLoader classLoader, Context context, TokenApiConfig tokenApiConfig, ICommonPrivacyController iCommonPrivacyController, boolean z, IGetNewTokenApiConfigCallback iGetNewTokenApiConfigCallback) {
        getCommonSdkApplogService(classLoader).initApplog(context, tokenApiConfig, iCommonPrivacyController, z, iGetNewTokenApiConfigCallback);
    }

    public static ICommonSdkApplogService getCommonSdkApplogService(ClassLoader classLoader) {
        return commonSdkServiceImpl(classLoader).getCommonSdkApplogService();
    }

    public static ICommonSdkTokenService getTokenService(ClassLoader classLoader) {
        return commonSdkServiceImpl(classLoader).getCommonSdkTokenService();
    }
}
