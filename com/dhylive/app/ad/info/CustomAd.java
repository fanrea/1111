package com.dhylive.app.ad.info;

import kotlin.Metadata;

/* compiled from: CustomAd.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/dhylive/app/ad/info/CustomAd;", "AD", "", "adInfo", "(Ljava/lang/Object;)V", "getAdInfo", "()Ljava/lang/Object;", "Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class CustomAd<AD> {
    private final AD adInfo;

    public CustomAd(AD ad) {
        this.adInfo = ad;
    }

    public final AD getAdInfo() {
        return this.adInfo;
    }
}
