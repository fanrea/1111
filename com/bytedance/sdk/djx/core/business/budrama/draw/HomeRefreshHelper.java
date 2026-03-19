package com.bytedance.sdk.djx.core.business.budrama.draw;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.sdk.djx.core.business.view.DJXDrawTitleRefresh;
import com.bytedance.sdk.djx.core.business.view.refresh.IRefresh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class HomeRefreshHelper implements IRefresh {
    private ConstraintLayout mTitleBar;
    private DJXDrawTitleRefresh mTitleRefresh;

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setPullToRefresh() {
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setRefresh() {
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setReleaseToRefresh() {
    }

    public void init(ConstraintLayout constraintLayout, DJXDrawTitleRefresh dJXDrawTitleRefresh) {
        this.mTitleBar = constraintLayout;
        this.mTitleRefresh = dJXDrawTitleRefresh;
        constraintLayout.setAlpha(1.0f);
        this.mTitleRefresh.setAlpha(0.0f);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setHeight(float f, float f2, float f3) {
        float fMin = Math.min(Math.max(f / f2, 0.0f), 1.0f);
        this.mTitleRefresh.setTranslationY(Math.min(f, f2) / 3.0f);
        if (fMin <= 0.5d) {
            this.mTitleBar.setAlpha(Math.max(1.0f - Math.min(fMin / 0.5f, 1.0f), 0.0f));
            this.mTitleRefresh.setAlpha(0.0f);
        } else {
            float fMax = Math.max((fMin / 0.5f) - 1.0f, 0.0f);
            this.mTitleBar.setAlpha(0.0f);
            this.mTitleRefresh.setAlpha(fMax);
        }
        this.mTitleRefresh.setProgress(fMin);
    }
}
