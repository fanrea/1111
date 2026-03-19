package com.dhylive.app.ad.impl;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.dhylive.app.ad.CustomAdListener;
import com.dhylive.app.ad.info.CustomAd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomAdListenerImpl.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u001c\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\f"}, d2 = {"Lcom/dhylive/app/ad/impl/CustomAdListenerImpl;", "Lcom/dhylive/app/ad/CustomAdListener;", "()V", IAdInterListener.AdCommandType.AD_CLICK, "", "onAdClose", "onAdLoadFail", "onAdLoadSuccess", "AD", "ad", "Lcom/dhylive/app/ad/info/CustomAd;", "onAdShow", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class CustomAdListenerImpl implements CustomAdListener {
    @Override // com.dhylive.app.ad.CustomAdListener
    public void onAdClick() {
    }

    @Override // com.dhylive.app.ad.CustomAdListener
    public void onAdClose() {
    }

    @Override // com.dhylive.app.ad.CustomAdListener
    public void onAdLoadFail() {
    }

    @Override // com.dhylive.app.ad.CustomAdListener
    public <AD> void onAdLoadSuccess(CustomAd<AD> ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
    }

    @Override // com.dhylive.app.ad.CustomAdListener
    public void onAdShow() {
    }
}
