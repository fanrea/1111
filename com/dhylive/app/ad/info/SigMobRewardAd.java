package com.dhylive.app.ad.info;

import android.app.Activity;
import com.windmill.sdk.reward.WMRewardAd;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RewardAd.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J8\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/dhylive/app/ad/info/SigMobRewardAd;", "Lcom/dhylive/app/ad/info/RewardAd;", "Lcom/windmill/sdk/reward/WMRewardAd;", "sdkAd", "sdkType", "", "sdkName", "(Lcom/windmill/sdk/reward/WMRewardAd;Ljava/lang/String;Ljava/lang/String;)V", "showAd", "", "activity", "Landroid/app/Activity;", "options", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class SigMobRewardAd extends RewardAd<WMRewardAd> {
    public /* synthetic */ SigMobRewardAd(WMRewardAd wMRewardAd, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(wMRewardAd, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SigMobRewardAd(WMRewardAd wMRewardAd, String str, String str2) {
        super(wMRewardAd, str, str2);
        Intrinsics.checkNotNullParameter(wMRewardAd, "sdkAd");
        Intrinsics.checkNotNullParameter(str, "sdkType");
        Intrinsics.checkNotNullParameter(str2, "sdkName");
    }

    @Override // com.dhylive.app.ad.info.RewardAd
    public void showAd(Activity activity, HashMap<String, String> options) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (getSdkAd().isReady()) {
            getSdkAd().show(activity, options);
        }
    }
}
