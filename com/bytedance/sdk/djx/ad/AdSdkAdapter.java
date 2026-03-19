package com.bytedance.sdk.djx.ad;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AdSdkAdapter {
    public static AdManagerAdpater getAdManager() {
        if (AdManagerAdpater.check()) {
            return AdManagerAdpater.getInstance();
        }
        return null;
    }
}
