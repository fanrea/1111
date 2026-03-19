package com.dhylive.app.ad;

import com.baidu.mobads.sdk.api.IAdInterListener;
import kotlin.Metadata;

/* compiled from: BannerAdListener.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/dhylive/app/ad/BannerAdListener;", "", IAdInterListener.AdCommandType.AD_CLICK, "", "onAdClose", "onAdLoadFail", "onAdLoadSuccess", "onAdShow", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface BannerAdListener {
    void onAdClick();

    void onAdClose();

    void onAdLoadFail();

    void onAdLoadSuccess();

    void onAdShow();
}
