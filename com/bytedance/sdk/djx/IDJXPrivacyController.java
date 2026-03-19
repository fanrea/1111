package com.bytedance.sdk.djx;

import com.bytedance.sdk.commonsdk.api.ICommonPrivacyController;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class IDJXPrivacyController implements ICommonPrivacyController {
    @Override // com.bytedance.sdk.commonsdk.api.ICommonPrivacyController
    public String getAndroidId() {
        return null;
    }

    @Override // com.bytedance.sdk.commonsdk.api.ICommonPrivacyController
    public String getImei() {
        return null;
    }

    @Override // com.bytedance.sdk.commonsdk.api.ICommonPrivacyController
    public String getImsi() {
        return null;
    }

    @Override // com.bytedance.sdk.commonsdk.api.ICommonPrivacyController
    public boolean isCanUseAndroidId() {
        return true;
    }

    @Override // com.bytedance.sdk.commonsdk.api.ICommonPrivacyController
    public boolean isCanUseGAID() {
        return false;
    }

    @Override // com.bytedance.sdk.commonsdk.api.ICommonPrivacyController
    public boolean isCanUseICCID() {
        return true;
    }

    @Override // com.bytedance.sdk.commonsdk.api.ICommonPrivacyController
    public boolean isCanUseMac() {
        return true;
    }

    @Override // com.bytedance.sdk.commonsdk.api.ICommonPrivacyController
    public boolean isCanUseOAID() {
        return true;
    }

    @Override // com.bytedance.sdk.commonsdk.api.ICommonPrivacyController
    public boolean isCanUseOperatorInfo() {
        return true;
    }

    @Override // com.bytedance.sdk.commonsdk.api.ICommonPrivacyController
    public boolean isCanUsePhoneState() {
        return true;
    }

    @Override // com.bytedance.sdk.commonsdk.api.ICommonPrivacyController
    public boolean isCanUseSerialNumber() {
        return true;
    }

    @Override // com.bytedance.sdk.commonsdk.api.ICommonPrivacyController
    public boolean isOnlyICPNumber() {
        return false;
    }

    @Override // com.bytedance.sdk.commonsdk.api.ICommonPrivacyController
    public boolean isTeenagerMode() {
        return false;
    }
}
