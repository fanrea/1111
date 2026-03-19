package com.bytedance.sdk.djx.model;

import com.alipay.sdk.m.p.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DJXDramaUnlockInfo.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003JQ\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\t\u0010,\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006-"}, d2 = {"Lcom/bytedance/sdk/djx/model/DJXDramaUnlockInfo;", "", "dramaId", "", "lockSet", "", e.s, "Lcom/bytedance/sdk/djx/model/DJXDramaUnlockMethod;", "hasMember", "", "orderParams", "", "cancelUnlock", "unlockType", "Lcom/bytedance/sdk/djx/model/DJXUnlockModeType;", "(JILcom/bytedance/sdk/djx/model/DJXDramaUnlockMethod;ZLjava/lang/String;ZLcom/bytedance/sdk/djx/model/DJXUnlockModeType;)V", "getCancelUnlock", "()Z", "getDramaId", "()J", "getHasMember", "getLockSet", "()I", "getMethod", "()Lcom/bytedance/sdk/djx/model/DJXDramaUnlockMethod;", "getOrderParams", "()Ljava/lang/String;", "safeLockSet", "getSafeLockSet", "getUnlockType", "()Lcom/bytedance/sdk/djx/model/DJXUnlockModeType;", "setUnlockType", "(Lcom/bytedance/sdk/djx/model/DJXUnlockModeType;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "sdk_api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class DJXDramaUnlockInfo {
    private final boolean cancelUnlock;
    private final long dramaId;
    private final boolean hasMember;
    private final int lockSet;
    private final DJXDramaUnlockMethod method;
    private final String orderParams;
    private DJXUnlockModeType unlockType;

    /* renamed from: component1, reason: from getter */
    public final long getDramaId() {
        return this.dramaId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLockSet() {
        return this.lockSet;
    }

    /* renamed from: component3, reason: from getter */
    public final DJXDramaUnlockMethod getMethod() {
        return this.method;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getHasMember() {
        return this.hasMember;
    }

    /* renamed from: component5, reason: from getter */
    public final String getOrderParams() {
        return this.orderParams;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getCancelUnlock() {
        return this.cancelUnlock;
    }

    /* renamed from: component7, reason: from getter */
    public final DJXUnlockModeType getUnlockType() {
        return this.unlockType;
    }

    public final DJXDramaUnlockInfo copy(long dramaId, int lockSet, DJXDramaUnlockMethod method, boolean hasMember, String orderParams, boolean cancelUnlock, DJXUnlockModeType unlockType) {
        Intrinsics.checkNotNullParameter(method, e.s);
        Intrinsics.checkNotNullParameter(unlockType, "unlockType");
        return new DJXDramaUnlockInfo(dramaId, lockSet, method, hasMember, orderParams, cancelUnlock, unlockType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DJXDramaUnlockInfo)) {
            return false;
        }
        DJXDramaUnlockInfo dJXDramaUnlockInfo = (DJXDramaUnlockInfo) other;
        return this.dramaId == dJXDramaUnlockInfo.dramaId && this.lockSet == dJXDramaUnlockInfo.lockSet && this.method == dJXDramaUnlockInfo.method && this.hasMember == dJXDramaUnlockInfo.hasMember && Intrinsics.areEqual(this.orderParams, dJXDramaUnlockInfo.orderParams) && this.cancelUnlock == dJXDramaUnlockInfo.cancelUnlock && this.unlockType == dJXDramaUnlockInfo.unlockType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.dramaId) * 31) + Integer.hashCode(this.lockSet)) * 31) + this.method.hashCode()) * 31;
        boolean z = this.hasMember;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        String str = this.orderParams;
        int iHashCode2 = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z2 = this.cancelUnlock;
        return ((iHashCode2 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.unlockType.hashCode();
    }

    public String toString() {
        return "DJXDramaUnlockInfo(dramaId=" + this.dramaId + ", lockSet=" + this.lockSet + ", method=" + this.method + ", hasMember=" + this.hasMember + ", orderParams=" + ((Object) this.orderParams) + ", cancelUnlock=" + this.cancelUnlock + ", unlockType=" + this.unlockType + ')';
    }

    public DJXDramaUnlockInfo(long j, int i, DJXDramaUnlockMethod dJXDramaUnlockMethod, boolean z, String str, boolean z2, DJXUnlockModeType dJXUnlockModeType) {
        Intrinsics.checkNotNullParameter(dJXDramaUnlockMethod, e.s);
        Intrinsics.checkNotNullParameter(dJXUnlockModeType, "unlockType");
        this.dramaId = j;
        this.lockSet = i;
        this.method = dJXDramaUnlockMethod;
        this.hasMember = z;
        this.orderParams = str;
        this.cancelUnlock = z2;
        this.unlockType = dJXUnlockModeType;
    }

    public final long getDramaId() {
        return this.dramaId;
    }

    public final int getLockSet() {
        return this.lockSet;
    }

    public final DJXDramaUnlockMethod getMethod() {
        return this.method;
    }

    public final boolean getHasMember() {
        return this.hasMember;
    }

    public final String getOrderParams() {
        return this.orderParams;
    }

    public final boolean getCancelUnlock() {
        return this.cancelUnlock;
    }

    public /* synthetic */ DJXDramaUnlockInfo(long j, int i, DJXDramaUnlockMethod dJXDramaUnlockMethod, boolean z, String str, boolean z2, DJXUnlockModeType dJXUnlockModeType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i, dJXDramaUnlockMethod, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? null : str, (i2 & 32) != 0 ? false : z2, (i2 & 64) != 0 ? DJXUnlockModeType.UNLOCKTYPE_DEFAULT : dJXUnlockModeType);
    }

    public final DJXUnlockModeType getUnlockType() {
        return this.unlockType;
    }

    public final void setUnlockType(DJXUnlockModeType dJXUnlockModeType) {
        Intrinsics.checkNotNullParameter(dJXUnlockModeType, "<set-?>");
        this.unlockType = dJXUnlockModeType;
    }

    public final int getSafeLockSet() {
        int i = this.lockSet;
        if (i < 1) {
            return 1;
        }
        return i;
    }
}
