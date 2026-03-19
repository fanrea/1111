package com.bytedance.sdk.djx.model;

import kotlin.Metadata;

/* compiled from: DramaFeed.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/djx/model/DramaFeed;", "", "()V", "cellType", "", "getCellType", "()I", "setCellType", "(I)V", "isDrawAd", "", "()Z", "setDrawAd", "(Z)V", "Companion", "model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaFeed {
    public static final int CELL_DRAMA_DETAIL = 3202;
    public static final int CELL_DRAMA_DRAW_AD = 3203;
    private int cellType = -1;
    private boolean isDrawAd;

    public final int getCellType() {
        return this.cellType;
    }

    public final void setCellType(int i) {
        this.cellType = i;
    }

    /* renamed from: isDrawAd, reason: from getter */
    public final boolean getIsDrawAd() {
        return this.isDrawAd;
    }

    public final void setDrawAd(boolean z) {
        this.isDrawAd = z;
    }
}
