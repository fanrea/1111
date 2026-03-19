package com.bytedance.sdk.djx.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum DJXUserGender {
    GENDER_MALE("male"),
    GENDER_FEMALE("female"),
    GENDER_UNKNOWN("unknown");

    private final String gender;

    DJXUserGender(String str) {
        this.gender = str;
    }

    public String getGender() {
        return this.gender;
    }
}
