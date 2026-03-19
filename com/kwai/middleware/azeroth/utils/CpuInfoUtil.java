package com.kwai.middleware.azeroth.utils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class CpuInfoUtil {
    private static int sCpuCoreCount;
    private static int sCpuMaxFreqInKHz;

    public static synchronized int getCpuCoreCount() {
        if (sCpuCoreCount == 0) {
            sCpuCoreCount = SystemUtils.getCpuCoreCount();
        }
        return sCpuCoreCount;
    }

    public static synchronized int getCpuMaxFreqInKHz() {
        if (sCpuMaxFreqInKHz == 0) {
            sCpuMaxFreqInKHz = SystemUtils.getCpuMaxFreqInKHz();
        }
        return sCpuMaxFreqInKHz;
    }
}
