package com.bytedance.sdk.djx.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum DJXUserAge {
    AGE_60S("60s"),
    AGE_70S("70s"),
    AGE_80S("80s"),
    AGE_90S("90s"),
    AGE_00S("00s"),
    AGE_10S("10s"),
    AGE_20S("20s"),
    AGE_UNKNOWN("unknown");

    private final String age;

    DJXUserAge(String str) {
        this.age = str;
    }

    public String getAge() {
        return this.age;
    }
}
