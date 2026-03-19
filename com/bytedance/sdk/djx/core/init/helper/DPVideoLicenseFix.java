package com.bytedance.sdk.djx.core.init.helper;

import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.commonsdk.api.utils.CommonSdkUtils;
import com.bytedance.sdk.djx.base.dynamic.DynamicManager;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.impl.DJXSdkInstance;
import com.bytedance.sdk.djx.internal.IPLTInternal;
import com.bytedance.sdk.djx.utils.InnerManager;
import java.util.concurrent.Executors;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DPVideoLicenseFix {
    private static final String TAG = "DPVideoLicenseFix";

    public static void init(final Context context, final String str) {
        Log.e(TAG, "DPVideoLicenseFix init");
        Executors.newSingleThreadExecutor().submit(new Runnable() { // from class: com.bytedance.sdk.djx.core.init.helper.DPVideoLicenseFix.1
            @Override // java.lang.Runnable
            public void run() {
                Log.e(DPVideoLicenseFix.TAG, "DPVideoLicenseFix init2");
                InnerManager.setContext(context);
                DynamicManager.getInstance().init(context, str);
                DevInfo.sPartner = DynamicManager.getInstance().getInitPartner();
                DevInfo.sSecureKey = DynamicManager.getInstance().getInitSecureKey();
                DevInfo.sOldSecureKey = DynamicManager.getInstance().getInitOldSecureKey();
                DevInfo.sAppId = DynamicManager.getInstance().getInitAppId();
                DevInfo.sSiteId = DynamicManager.getInstance().getInitSiteId();
                CommonSdkUtils.getAppLogInstance(DPVideoLicenseFix.clsLoader(), DevInfo.sAppId);
                DPVideoLicenseFix.initVod();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initVod() {
        try {
            Log.e(TAG, "DPVideoLicenseFix initVod1");
            Class<?> clsLoadClass = clsLoader().loadClass("com.bytedance.sdk.djx.core.DJXPLTImpl");
            Log.e(TAG, "DPVideoLicenseFix initVod2");
            IPLTInternal iPLTInternal = (IPLTInternal) clsLoadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Log.e(TAG, "DPVideoLicenseFix initVod3=" + (iPLTInternal == null));
            if (iPLTInternal != null) {
                iPLTInternal.initVod();
            }
        } catch (Throwable th) {
            Log.e(TAG, "DPVideoLicenseFix initVod error===", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ClassLoader clsLoader() {
        return DJXSdkInstance.getInstance().getClass().getClassLoader();
    }
}
