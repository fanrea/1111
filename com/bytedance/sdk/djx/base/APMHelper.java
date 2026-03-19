package com.bytedance.sdk.djx.base;

import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import com.apm.applog.AppLog;
import com.apm.insight.AttachUserData;
import com.apm.insight.CrashType;
import com.apm.insight.MonitorCrash;
import com.apm.insight.Npth;
import com.bytedance.sdk.djx.DJXSdkConfig;
import com.bytedance.sdk.djx.IDJXPrivacyController;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.utils.DJXSdkUtils;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.ToolUtils;
import com.bytedance.sdk.djx.utils.Utils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class APMHelper {
    private static final String[] PACKAGE_NAMES = {com.bytedance.sdk.djx.BuildConfig.LIBRARY_PACKAGE_NAME, "com.bytedance.sdk.adtnc", "com.ss.ttvideoengine", "com.ss.ttm", "com.ss.mediakit", "com.onething", "com.pangrowth.empay", "com.bytedance.sdk.nov", "com.dragon.reader.lib", "com.android.ttcjpaysdk", "com.ss.android.caijing.cjpay", "com.bdcaijing.tfccsmsdk"};
    private static final String[] SO_LIST = {"libavmdl.so", "libttmplayer.so", "libvideodec.so", "libttopenssl.so", "libcjtfccsm.so", "libcjtfccsm.so"};
    public static MonitorCrash monitorCrash;

    public static void init(DJXSdkConfig dJXSdkConfig) {
        try {
            Npth.getConfigManager().setAnrEnable(DJXSdkUtils.isEnableAnr4APM(dJXSdkConfig));
            Npth.getConfigManager().setNativeCrashEnable(DJXSdkUtils.isEnableNativeCrash4APM(dJXSdkConfig));
            IDJXPrivacyController privacyController = dJXSdkConfig.getPrivacyController() != null ? dJXSdkConfig.getPrivacyController() : DevInfo.getPrivacyController();
            AppLog.setAndroidIdEnabled(privacyController.isCanUseAndroidId());
            AppLog.setOAIdEnabled(privacyController.isCanUseOAID());
            MonitorCrash monitorCrashInitSDK = MonitorCrash.initSDK(InnerManager.getContext(), "540060", 2902L, "2.9.0.2", PACKAGE_NAMES, SO_LIST);
            monitorCrash = monitorCrashInitSDK;
            monitorCrashInitSDK.setCustomDataCallback(new AttachUserData() { // from class: com.bytedance.sdk.djx.base.APMHelper.1
                @Override // com.apm.insight.AttachUserData
                public Map<? extends String, ? extends String> getUserData(CrashType crashType) {
                    APMHelper.addMonitorTags();
                    HashMap map = new HashMap();
                    if (!TextUtils.isEmpty(DevInfo.sPartner)) {
                        map.put(b.z0, DevInfo.sPartner);
                    }
                    if (!TextUtils.isEmpty(DevInfo.sSiteId)) {
                        map.put("site_id", DevInfo.sSiteId);
                    }
                    map.put("app_name", ToolUtils.getAppName());
                    map.put("app_ver_name", ToolUtils.getVersionName());
                    map.put("app_ver_code", ToolUtils.getVersionCode());
                    map.put("plugin_mode", (Utils.pluginMode() ? 1 : 0) + "");
                    return map;
                }
            });
            addMonitorTags();
        } catch (Throwable th) {
            LG.d("APMHelper", "apm init error, check ignore", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addMonitorTags() {
        if (monitorCrash != null) {
            if (!TextUtils.isEmpty(DevInfo.sPartner)) {
                monitorCrash.addTags(b.z0, DevInfo.sPartner);
            }
            if (!TextUtils.isEmpty(DevInfo.sSiteId)) {
                monitorCrash.addTags("site_id", DevInfo.sSiteId);
            }
            monitorCrash.addTags("plugin_mode", (Utils.pluginMode() ? 1 : 0) + "");
        }
    }
}
