package com.bytedance.sdk.commonsdk.api.detector_api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitConfig.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/sdk/commonsdk/api/detector_api/AdActInfo;", "", "actNameRegex", "", "adType", "Lcom/bytedance/sdk/commonsdk/api/detector_api/AdType;", "adnType", "Lcom/bytedance/sdk/commonsdk/api/detector_api/AdnType;", "(Ljava/lang/String;Lcom/bytedance/sdk/commonsdk/api/detector_api/AdType;Lcom/bytedance/sdk/commonsdk/api/detector_api/AdnType;)V", "getActNameRegex", "()Ljava/lang/String;", "getAdType", "()Lcom/bytedance/sdk/commonsdk/api/detector_api/AdType;", "getAdnType", "()Lcom/bytedance/sdk/commonsdk/api/detector_api/AdnType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class AdActInfo {
    private final String actNameRegex;
    private final AdType adType;
    private final AdnType adnType;

    public static /* synthetic */ AdActInfo copy$default(AdActInfo adActInfo, String str, AdType adType, AdnType adnType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adActInfo.actNameRegex;
        }
        if ((i & 2) != 0) {
            adType = adActInfo.adType;
        }
        if ((i & 4) != 0) {
            adnType = adActInfo.adnType;
        }
        return adActInfo.copy(str, adType, adnType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getActNameRegex() {
        return this.actNameRegex;
    }

    /* renamed from: component2, reason: from getter */
    public final AdType getAdType() {
        return this.adType;
    }

    /* renamed from: component3, reason: from getter */
    public final AdnType getAdnType() {
        return this.adnType;
    }

    public final AdActInfo copy(String actNameRegex, AdType adType, AdnType adnType) {
        Intrinsics.checkNotNullParameter(actNameRegex, "actNameRegex");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(adnType, "adnType");
        return new AdActInfo(actNameRegex, adType, adnType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdActInfo)) {
            return false;
        }
        AdActInfo adActInfo = (AdActInfo) other;
        return Intrinsics.areEqual(this.actNameRegex, adActInfo.actNameRegex) && this.adType == adActInfo.adType && this.adnType == adActInfo.adnType;
    }

    public int hashCode() {
        return (((this.actNameRegex.hashCode() * 31) + this.adType.hashCode()) * 31) + this.adnType.hashCode();
    }

    public String toString() {
        return "AdActInfo(actNameRegex=" + this.actNameRegex + ", adType=" + this.adType + ", adnType=" + this.adnType + ')';
    }

    public AdActInfo(String str, AdType adType, AdnType adnType) {
        Intrinsics.checkNotNullParameter(str, "actNameRegex");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(adnType, "adnType");
        this.actNameRegex = str;
        this.adType = adType;
        this.adnType = adnType;
    }

    public final String getActNameRegex() {
        return this.actNameRegex;
    }

    public final AdType getAdType() {
        return this.adType;
    }

    public final AdnType getAdnType() {
        return this.adnType;
    }
}
