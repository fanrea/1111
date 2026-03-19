package com.bytedance.sdk.djx.core.vod.util;

import com.bytedance.sdk.djx.absdk.EMABManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SRABConfig {
    public static boolean enableSR() {
        return ((Integer) EMABManager.getInstance().getConfig("player_sr_option", 0)).intValue() == 1;
    }

    public static int abSRMultiple() {
        return ((Integer) EMABManager.getInstance().getConfig("player_sr_multiple", 1)).intValue() == 0 ? 1 : 2;
    }
}
