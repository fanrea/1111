package com.bytedance.sdk.djx.model.ev;

import com.bytedance.sdk.djx.utils.bus.BusEvent;
import kotlin.Metadata;

/* compiled from: BEDramaLikeAction.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sdk/djx/model/ev/BEDramaLikeAction;", "Lcom/bytedance/sdk/djx/utils/bus/BusEvent;", "dramaId", "", "dramaIndex", "", "isLiked", "", "(JIZ)V", "getDramaId", "()J", "getDramaIndex", "()I", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class BEDramaLikeAction extends BusEvent {
    private final long dramaId;
    private final int dramaIndex;
    private final boolean isLiked;

    public static /* synthetic */ BEDramaLikeAction copy$default(BEDramaLikeAction bEDramaLikeAction, long j, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = bEDramaLikeAction.dramaId;
        }
        if ((i2 & 2) != 0) {
            i = bEDramaLikeAction.dramaIndex;
        }
        if ((i2 & 4) != 0) {
            z = bEDramaLikeAction.isLiked;
        }
        return bEDramaLikeAction.copy(j, i, z);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDramaId() {
        return this.dramaId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDramaIndex() {
        return this.dramaIndex;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsLiked() {
        return this.isLiked;
    }

    public final BEDramaLikeAction copy(long dramaId, int dramaIndex, boolean isLiked) {
        return new BEDramaLikeAction(dramaId, dramaIndex, isLiked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BEDramaLikeAction)) {
            return false;
        }
        BEDramaLikeAction bEDramaLikeAction = (BEDramaLikeAction) other;
        return this.dramaId == bEDramaLikeAction.dramaId && this.dramaIndex == bEDramaLikeAction.dramaIndex && this.isLiked == bEDramaLikeAction.isLiked;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.dramaId) * 31) + Integer.hashCode(this.dramaIndex)) * 31;
        boolean z = this.isLiked;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        return "BEDramaLikeAction(dramaId=" + this.dramaId + ", dramaIndex=" + this.dramaIndex + ", isLiked=" + this.isLiked + ')';
    }

    public final long getDramaId() {
        return this.dramaId;
    }

    public final int getDramaIndex() {
        return this.dramaIndex;
    }

    public final boolean isLiked() {
        return this.isLiked;
    }

    public BEDramaLikeAction(long j, int i, boolean z) {
        this.dramaId = j;
        this.dramaIndex = i;
        this.isLiked = z;
    }
}
