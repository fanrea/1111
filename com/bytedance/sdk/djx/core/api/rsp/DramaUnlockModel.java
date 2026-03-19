package com.bytedance.sdk.djx.core.api.rsp;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DramaUnlockRsp.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/djx/core/api/rsp/DramaUnlockModel;", "", "lockSet", "", "unlockIndexList", "", "(ILjava/util/List;)V", "getLockSet", "()I", "getUnlockIndexList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class DramaUnlockModel {
    private final int lockSet;
    private final List<Integer> unlockIndexList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DramaUnlockModel copy$default(DramaUnlockModel dramaUnlockModel, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dramaUnlockModel.lockSet;
        }
        if ((i2 & 2) != 0) {
            list = dramaUnlockModel.unlockIndexList;
        }
        return dramaUnlockModel.copy(i, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getLockSet() {
        return this.lockSet;
    }

    public final List<Integer> component2() {
        return this.unlockIndexList;
    }

    public final DramaUnlockModel copy(int lockSet, List<Integer> unlockIndexList) {
        Intrinsics.checkNotNullParameter(unlockIndexList, "unlockIndexList");
        return new DramaUnlockModel(lockSet, unlockIndexList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DramaUnlockModel)) {
            return false;
        }
        DramaUnlockModel dramaUnlockModel = (DramaUnlockModel) other;
        return this.lockSet == dramaUnlockModel.lockSet && Intrinsics.areEqual(this.unlockIndexList, dramaUnlockModel.unlockIndexList);
    }

    public int hashCode() {
        return (Integer.hashCode(this.lockSet) * 31) + this.unlockIndexList.hashCode();
    }

    public String toString() {
        return "DramaUnlockModel(lockSet=" + this.lockSet + ", unlockIndexList=" + this.unlockIndexList + ')';
    }

    public DramaUnlockModel(int i, List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "unlockIndexList");
        this.lockSet = i;
        this.unlockIndexList = list;
    }

    public final int getLockSet() {
        return this.lockSet;
    }

    public final List<Integer> getUnlockIndexList() {
        return this.unlockIndexList;
    }
}
