package com.bytedance.sdk.djx.core.settings;

import com.bytedance.sdk.djx.settings.DJXGlobalSettings;
import com.bytedance.sdk.djx.utils.DJXSdkUtils;
import com.bytedance.sdk.djx.utils.ZeusUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class PluginChecker {
    private static final String TAG = "PluginChecker";

    public static boolean checkVersion() {
        int pluginVersion;
        if (DJXSdkUtils.isRunningPlugin() && (pluginVersion = ZeusUtils.getPluginVersion(DJXSdkUtils.getPluginPackageName())) >= 0) {
            return !DJXGlobalSettings.getInstance().getVideoPluginBlockList().contains(String.valueOf(pluginVersion));
        }
        return true;
    }
}
