package com.bytedance.sdk.djx.core.business.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.pangle.cn.pangrowth.base.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXLoadMoreView extends DJXBaseLoadView {
    private ProgressBar progressBar;

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setHeight(float f, float f2, float f3) {
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setPullToRefresh() {
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setRefresh() {
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setReleaseToRefresh() {
    }

    public DJXLoadMoreView(Context context) {
        this(context, null);
    }

    public DJXLoadMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.progressBar = (ProgressBar) LayoutInflater.from(context).inflate(R.layout.djx_view_loadmore, (ViewGroup) this, true).findViewById(R.id.djx_rbottom_progress);
    }
}
