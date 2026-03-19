package com.bytedance.sdk.djx.model;

import kotlin.Metadata;

/* compiled from: DramaDrawAd.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/djx/model/DramaDrawAd;", "Lcom/bytedance/sdk/djx/model/DramaFeed;", "adPosition", "", "(I)V", "getAdPosition", "()I", "setAdPosition", "isAddView", "", "()Z", "setAddView", "(Z)V", "component1", "copy", "equals", "other", "", "hashCode", "toString", "", "model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class DramaDrawAd extends DramaFeed {
    private int adPosition;
    private boolean isAddView;

    public static /* synthetic */ DramaDrawAd copy$default(DramaDrawAd dramaDrawAd, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dramaDrawAd.adPosition;
        }
        return dramaDrawAd.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAdPosition() {
        return this.adPosition;
    }

    public final DramaDrawAd copy(int adPosition) {
        return new DramaDrawAd(adPosition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DramaDrawAd) && this.adPosition == ((DramaDrawAd) other).adPosition;
    }

    public int hashCode() {
        return Integer.hashCode(this.adPosition);
    }

    public String toString() {
        return "DramaDrawAd(adPosition=" + this.adPosition + ')';
    }

    public final int getAdPosition() {
        return this.adPosition;
    }

    public final void setAdPosition(int i) {
        this.adPosition = i;
    }

    public DramaDrawAd(int i) {
        this.adPosition = i;
    }

    /* renamed from: isAddView, reason: from getter */
    public final boolean getIsAddView() {
        return this.isAddView;
    }

    public final void setAddView(boolean z) {
        this.isAddView = z;
    }
}
