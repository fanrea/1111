package com.dhylive.app.ad.info;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InterstitialAd.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/dhylive/app/ad/info/GroMobInterstitialAd;", "Lcom/dhylive/app/ad/info/InterstitialAd;", "Lcom/bytedance/sdk/openadsdk/TTFullScreenVideoAd;", "adInfo", "(Lcom/bytedance/sdk/openadsdk/TTFullScreenVideoAd;)V", "showAd", "", "activity", "Landroid/app/Activity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class GroMobInterstitialAd extends InterstitialAd<TTFullScreenVideoAd> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroMobInterstitialAd(TTFullScreenVideoAd tTFullScreenVideoAd) {
        super(tTFullScreenVideoAd);
        Intrinsics.checkNotNullParameter(tTFullScreenVideoAd, "adInfo");
    }

    @Override // com.dhylive.app.ad.info.InterstitialAd
    public void showAd(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        TTFullScreenVideoAd adInfo = getAdInfo();
        if (adInfo.getMediationManager().isReady()) {
            adInfo.showFullScreenVideoAd(activity);
        }
        setShow(true);
    }
}
