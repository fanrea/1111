package com.dhylive.app.ad.impl;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.dhylive.app.ad.InterstitialAdListener;
import com.dhylive.app.ad.info.InterstitialAd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InterstitialAdListenerImpl.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u001c\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016¨\u0006\u000e"}, d2 = {"Lcom/dhylive/app/ad/impl/InterstitialAdListenerImpl;", "Lcom/dhylive/app/ad/InterstitialAdListener;", "()V", IAdInterListener.AdCommandType.AD_CLICK, "", "onAdClose", "onAdLoadFail", "onAdLoadSuccess", "AD", "interstitialAd", "Lcom/dhylive/app/ad/info/InterstitialAd;", "onAdPlayFail", "onAdPlaySuccess", "onAdReward", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class InterstitialAdListenerImpl implements InterstitialAdListener {
    @Override // com.dhylive.app.ad.InterstitialAdListener
    public void onAdClick() {
    }

    @Override // com.dhylive.app.ad.InterstitialAdListener
    public void onAdClose() {
    }

    @Override // com.dhylive.app.ad.InterstitialAdListener
    public void onAdLoadFail() {
    }

    @Override // com.dhylive.app.ad.InterstitialAdListener
    public <AD> void onAdLoadSuccess(InterstitialAd<AD> interstitialAd) {
        Intrinsics.checkNotNullParameter(interstitialAd, "interstitialAd");
    }

    @Override // com.dhylive.app.ad.InterstitialAdListener
    public void onAdPlayFail() {
    }

    @Override // com.dhylive.app.ad.InterstitialAdListener
    public void onAdPlaySuccess() {
    }

    @Override // com.dhylive.app.ad.InterstitialAdListener
    public void onAdReward() {
    }
}
