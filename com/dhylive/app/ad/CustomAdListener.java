package com.dhylive.app.ad;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.dhylive.app.ad.info.CustomAd;
import kotlin.Metadata;

/* compiled from: CustomAdListener.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u001c\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/dhylive/app/ad/CustomAdListener;", "", IAdInterListener.AdCommandType.AD_CLICK, "", "onAdClose", "onAdLoadFail", "onAdLoadSuccess", "AD", "ad", "Lcom/dhylive/app/ad/info/CustomAd;", "onAdShow", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface CustomAdListener {
    void onAdClick();

    void onAdClose();

    void onAdLoadFail();

    <AD> void onAdLoadSuccess(CustomAd<AD> ad);

    void onAdShow();
}
