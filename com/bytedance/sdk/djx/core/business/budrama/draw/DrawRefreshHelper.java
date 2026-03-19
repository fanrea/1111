package com.bytedance.sdk.djx.core.business.budrama.draw;

import com.bytedance.sdk.djx.core.business.view.DJXDrawTitleBar;
import com.bytedance.sdk.djx.core.business.view.DJXDrawTitleRefresh;
import com.bytedance.sdk.djx.core.business.view.refresh.IRefresh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DrawRefreshHelper implements IRefresh {
    private static final int S_PULL = 1;
    private static final int S_REFRESHING = 2;
    private static final int S_RELEASE = 3;
    private DJXDrawTitleBar mTitleBar;
    private DJXDrawTitleRefresh mTitleRefresh;

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setPullToRefresh() {
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setReleaseToRefresh() {
    }

    public void init(DJXDrawTitleBar dJXDrawTitleBar, DJXDrawTitleRefresh dJXDrawTitleRefresh) {
        this.mTitleBar = dJXDrawTitleBar;
        this.mTitleRefresh = dJXDrawTitleRefresh;
        dJXDrawTitleBar.setAlpha(1.0f);
        this.mTitleRefresh.setAlpha(0.0f);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setHeight(float f, float f2, float f3) {
        float fMin = Math.min(Math.max(f / f2, 0.0f), 1.0f);
        float fMin2 = Math.min(f, f2);
        this.mTitleBar.setTranslationY(fMin2 / 2.0f);
        this.mTitleRefresh.setTranslationY(fMin2);
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

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setRefresh() {
        this.mTitleBar.showLoading(true);
    }
}
