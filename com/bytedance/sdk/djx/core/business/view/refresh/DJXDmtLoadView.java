package com.bytedance.sdk.djx.core.business.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.sdk.djx.core.business.view.loading.DJXDoubleColorBallAnimationView;
import com.pangle.cn.pangrowth.base.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDmtLoadView extends DJXBaseLoadView {
    private DJXDoubleColorBallAnimationView mLoadingView;
    private float mMaxOffset;

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setPullToRefresh() {
    }

    public DJXDmtLoadView(Context context) {
        super(context);
        this.mMaxOffset = 0.0f;
        init(context);
    }

    public DJXDmtLoadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxOffset = 0.0f;
        init(context);
    }

    private void init(Context context) {
        setBackgroundColor(0);
        inflate(context, R.layout.djx_view_dmt_load, this);
        DJXDoubleColorBallAnimationView dJXDoubleColorBallAnimationView = (DJXDoubleColorBallAnimationView) findViewById(R.id.djx_dmt_load_loading);
        this.mLoadingView = dJXDoubleColorBallAnimationView;
        dJXDoubleColorBallAnimationView.setProgress(0.0f);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setHeight(float f, float f2, float f3) {
        this.mLoadingView.setProgress(Math.min(Math.max(f / f2, 0.0f), 1.0f));
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setRefresh() {
        this.mLoadingView.startAnimate();
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setReleaseToRefresh() {
        this.mLoadingView.setProgress(1.0f);
    }
}
