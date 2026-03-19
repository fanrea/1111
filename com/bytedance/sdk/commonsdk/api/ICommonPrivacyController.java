package com.bytedance.sdk.commonsdk.api;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface ICommonPrivacyController {
    String getAndroidId();

    String getImei();

    String getImsi();

    boolean isCanUseAndroidId();

    boolean isCanUseGAID();

    boolean isCanUseICCID();

    boolean isCanUseMac();

    boolean isCanUseOAID();

    boolean isCanUseOperatorInfo();

    boolean isCanUsePhoneState();

    boolean isCanUseSerialNumber();

    boolean isOnlyICPNumber();

    boolean isTeenagerMode();
}
