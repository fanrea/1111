package com.bytedance.sdk.djx.ad;

import com.bykv.vk.openvk.TTVfManager;
import com.bykv.vk.openvk.TTVfSdk;
import com.bytedance.sdk.djx.utils.AdSdkUtils;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AdManagerAdpater {
    public static AdManagerAdpater getInstance() {
        return new AdManagerAdpater();
    }

    public static boolean check() {
        if (AdSdkUtils.isAdSdkExist()) {
            return AdSdkUtils.isOppo() ? TTVfSdk.getVfManager() != null : TTAdSdk.getAdManager() != null;
        }
        return false;
    }

    public boolean register(IPluginListener iPluginListener) {
        if (!AdSdkUtils.isPluginSdk()) {
            return false;
        }
        if (AdSdkUtils.isOppo()) {
            return registerOppo(iPluginListener);
        }
        return registerOpen(iPluginListener);
    }

    private boolean registerOppo(IPluginListener iPluginListener) {
        TTVfManager vfManager = TTVfSdk.getVfManager();
        if (vfManager == null) {
            return false;
        }
        OppoPluginListener.INSTANCE.setPluginListener(iPluginListener);
        vfManager.register(OppoPluginListener.INSTANCE);
        return true;
    }

    private boolean registerOpen(IPluginListener iPluginListener) {
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            return false;
        }
        OpenPluginListener.INSTANCE.setPluginListener(iPluginListener);
        adManager.register(OpenPluginListener.INSTANCE);
        return true;
    }
}
