package com.bytedance.sdk.djx.model;

import kotlin.Metadata;

/* compiled from: DJXEpisodeStatus.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/djx/model/DJXEpisodeStatus;", "", "index", "", "isLocked", "", "(IZ)V", "getIndex", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "sdk_api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class DJXEpisodeStatus {
    private final int index;
    private final boolean isLocked;

    public static /* synthetic */ DJXEpisodeStatus copy$default(DJXEpisodeStatus dJXEpisodeStatus, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dJXEpisodeStatus.index;
        }
        if ((i2 & 2) != 0) {
            z = dJXEpisodeStatus.isLocked;
        }
        return dJXEpisodeStatus.copy(i, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsLocked() {
        return this.isLocked;
    }

    public final DJXEpisodeStatus copy(int index, boolean isLocked) {
        return new DJXEpisodeStatus(index, isLocked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DJXEpisodeStatus)) {
            return false;
        }
        DJXEpisodeStatus dJXEpisodeStatus = (DJXEpisodeStatus) other;
        return this.index == dJXEpisodeStatus.index && this.isLocked == dJXEpisodeStatus.isLocked;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = Integer.hashCode(this.index) * 31;
        boolean z = this.isLocked;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public DJXEpisodeStatus(int i, boolean z) {
        this.index = i;
        this.isLocked = z;
    }

    public final int getIndex() {
        return this.index;
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public String toString() {
        return "DJXEpisodeStatus(index=" + this.index + ", isLocked=" + this.isLocked + ')';
    }
}
