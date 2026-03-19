package com.baidu.mobads.sdk.api;

import io.reactivex.annotations.SchedulerSupport;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public enum CPUAdType {
    FEED("feed"),
    INTERSTITIAL("int"),
    REWARDVIDEO("rvideo"),
    OTHER(SchedulerSupport.CUSTOM);

    private final String value;

    CPUAdType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static CPUAdType parse(String str) {
        for (CPUAdType cPUAdType : values()) {
            if (cPUAdType.value.equalsIgnoreCase(str)) {
                return cPUAdType;
            }
        }
        return null;
    }
}
