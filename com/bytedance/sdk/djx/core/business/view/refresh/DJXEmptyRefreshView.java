package com.bytedance.sdk.djx.core.business.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.sdk.djx.utils.debug.DebugInfo;
import com.pangle.cn.pangrowth.base.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXEmptyRefreshView extends DJXBaseRefreshView {
    private IRefresh mRefreshListener;
    private TextView mTvContent;
    private TextView mTvHeight;

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.DJXBaseRefreshView
    public void setReleaseToSecondFloor() {
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.DJXBaseRefreshView
    public void setToFirstFloor() {
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.DJXBaseRefreshView
    public void setToSecondFloor() {
    }

    public DJXEmptyRefreshView(Context context) {
        super(context);
        init(context);
    }

    public DJXEmptyRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        if (DebugInfo.buildDrawRefresh(this)) {
            inflate(context, R.layout.djx_view_refresh_empty, this);
            this.mTvContent = (TextView) findViewById(R.id.djx_refresh_empty_content);
            this.mTvHeight = (TextView) findViewById(R.id.djx_refresh_empty_height);
        }
    }

    public DJXEmptyRefreshView setRefreshListener(IRefresh iRefresh) {
        this.mRefreshListener = iRefresh;
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setHeight(float f, float f2, float f3) {
        IRefresh iRefresh = this.mRefreshListener;
        if (iRefresh != null) {
            iRefresh.setHeight(f, f2, f3);
        }
        if (this.mTvHeight != null) {
            this.mTvHeight.setText(((int) f) + ":" + ((int) f2) + ":" + ((int) f3));
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setRefresh() {
        IRefresh iRefresh = this.mRefreshListener;
        if (iRefresh != null) {
            iRefresh.setRefresh();
        }
        TextView textView = this.mTvContent;
        if (textView != null) {
            textView.setText("正在刷新");
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setPullToRefresh() {
        IRefresh iRefresh = this.mRefreshListener;
        if (iRefresh != null) {
            iRefresh.setPullToRefresh();
        }
        TextView textView = this.mTvContent;
        if (textView != null) {
            textView.setText("下拉刷新");
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setReleaseToRefresh() {
        IRefresh iRefresh = this.mRefreshListener;
        if (iRefresh != null) {
            iRefresh.setReleaseToRefresh();
        }
        TextView textView = this.mTvContent;
        if (textView != null) {
            textView.setText("释放刷新");
        }
    }
}
