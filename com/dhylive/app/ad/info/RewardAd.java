package com.dhylive.app.ad.info;

import android.app.Activity;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RewardAd.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J:\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112(\b\u0002\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0014H&R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/dhylive/app/ad/info/RewardAd;", "AD", "", "sdkAd", "sdkType", "", "sdkName", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V", "getSdkAd", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSdkName", "()Ljava/lang/String;", "getSdkType", "showAd", "", "activity", "Landroid/app/Activity;", "options", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class RewardAd<AD> {
    private final AD sdkAd;
    private final String sdkName;
    private final String sdkType;

    public abstract void showAd(Activity activity, HashMap<String, String> options);

    public RewardAd(AD ad, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "sdkType");
        Intrinsics.checkNotNullParameter(str2, "sdkName");
        this.sdkAd = ad;
        this.sdkType = str;
        this.sdkName = str2;
    }

    public /* synthetic */ RewardAd(Object obj, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
    }

    public final AD getSdkAd() {
        return this.sdkAd;
    }

    public final String getSdkType() {
        return this.sdkType;
    }

    public final String getSdkName() {
        return this.sdkName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showAd$default(RewardAd rewardAd, Activity activity, HashMap map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAd");
        }
        if ((i & 2) != 0) {
            map = null;
        }
        rewardAd.showAd(activity, map);
    }
}
