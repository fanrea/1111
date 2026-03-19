package com.bytedance.sdk.djx.model.ev;

import com.bytedance.sdk.djx.utils.bus.BusEvent;
import kotlin.Metadata;

/* compiled from: BEDramaFavorAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/djx/model/ev/BEDramaFavorAction;", "Lcom/bytedance/sdk/djx/utils/bus/BusEvent;", "dramaId", "", "isFavor", "", "(JZ)V", "getDramaId", "()J", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class BEDramaFavorAction extends BusEvent {
    private final long dramaId;
    private final boolean isFavor;

    public static /* synthetic */ BEDramaFavorAction copy$default(BEDramaFavorAction bEDramaFavorAction, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = bEDramaFavorAction.dramaId;
        }
        if ((i & 2) != 0) {
            z = bEDramaFavorAction.isFavor;
        }
        return bEDramaFavorAction.copy(j, z);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDramaId() {
        return this.dramaId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsFavor() {
        return this.isFavor;
    }

    public final BEDramaFavorAction copy(long dramaId, boolean isFavor) {
        return new BEDramaFavorAction(dramaId, isFavor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BEDramaFavorAction)) {
            return false;
        }
        BEDramaFavorAction bEDramaFavorAction = (BEDramaFavorAction) other;
        return this.dramaId == bEDramaFavorAction.dramaId && this.isFavor == bEDramaFavorAction.isFavor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = Long.hashCode(this.dramaId) * 31;
        boolean z = this.isFavor;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        return "BEDramaFavorAction(dramaId=" + this.dramaId + ", isFavor=" + this.isFavor + ')';
    }

    public final long getDramaId() {
        return this.dramaId;
    }

    public final boolean isFavor() {
        return this.isFavor;
    }

    public BEDramaFavorAction(long j, boolean z) {
        this.dramaId = j;
        this.isFavor = z;
    }
}
