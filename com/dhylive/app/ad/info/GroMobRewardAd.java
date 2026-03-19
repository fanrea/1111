package com.dhylive.app.ad.info;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationRewardManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RewardAd.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J8\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/dhylive/app/ad/info/GroMobRewardAd;", "Lcom/dhylive/app/ad/info/RewardAd;", "Lcom/bytedance/sdk/openadsdk/TTRewardVideoAd;", "sdkAd", "sdkType", "", "sdkName", "(Lcom/bytedance/sdk/openadsdk/TTRewardVideoAd;Ljava/lang/String;Ljava/lang/String;)V", "showAd", "", "activity", "Landroid/app/Activity;", "options", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class GroMobRewardAd extends RewardAd<TTRewardVideoAd> {
    public /* synthetic */ GroMobRewardAd(TTRewardVideoAd tTRewardVideoAd, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(tTRewardVideoAd, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroMobRewardAd(TTRewardVideoAd tTRewardVideoAd, String str, String str2) {
        super(tTRewardVideoAd, str, str2);
        Intrinsics.checkNotNullParameter(str, "sdkType");
        Intrinsics.checkNotNullParameter(str2, "sdkName");
    }

    @Override // com.dhylive.app.ad.info.RewardAd
    public void showAd(Activity activity, HashMap<String, String> options) {
        MediationRewardManager mediationManager;
        Intrinsics.checkNotNullParameter(activity, "activity");
        TTRewardVideoAd sdkAd = getSdkAd();
        Boolean boolValueOf = (sdkAd == null || (mediationManager = sdkAd.getMediationManager()) == null) ? null : Boolean.valueOf(mediationManager.isReady());
        if (getSdkAd() == null || !Intrinsics.areEqual(boolValueOf, true)) {
            return;
        }
        getSdkAd().showRewardVideoAd(activity);
    }
}
