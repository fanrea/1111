package com.bytedance.sdk.djx;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DJXRewardAdResult.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/djx/DJXRewardAdResult;", "", "isSuccess", "", "extraData", "", "", "(ZLjava/util/Map;)V", "getExtraData", "()Ljava/util/Map;", "setExtraData", "(Ljava/util/Map;)V", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "sdk_api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class DJXRewardAdResult {
    private Map<String, ? extends Object> extraData;
    private final boolean isSuccess;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DJXRewardAdResult copy$default(DJXRewardAdResult dJXRewardAdResult, boolean z, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            z = dJXRewardAdResult.isSuccess;
        }
        if ((i & 2) != 0) {
            map = dJXRewardAdResult.extraData;
        }
        return dJXRewardAdResult.copy(z, map);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public final Map<String, Object> component2() {
        return this.extraData;
    }

    public final DJXRewardAdResult copy(boolean isSuccess, Map<String, ? extends Object> extraData) {
        return new DJXRewardAdResult(isSuccess, extraData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DJXRewardAdResult)) {
            return false;
        }
        DJXRewardAdResult dJXRewardAdResult = (DJXRewardAdResult) other;
        return this.isSuccess == dJXRewardAdResult.isSuccess && Intrinsics.areEqual(this.extraData, dJXRewardAdResult.extraData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.isSuccess;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        Map<String, ? extends Object> map = this.extraData;
        return i + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "DJXRewardAdResult(isSuccess=" + this.isSuccess + ", extraData=" + this.extraData + ')';
    }

    public DJXRewardAdResult(boolean z, Map<String, ? extends Object> map) {
        this.isSuccess = z;
        this.extraData = map;
    }

    public /* synthetic */ DJXRewardAdResult(boolean z, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : map);
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final Map<String, Object> getExtraData() {
        return this.extraData;
    }

    public final void setExtraData(Map<String, ? extends Object> map) {
        this.extraData = map;
    }
}
