package com.bytedance.sdk.djx.core.business.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.pangle.cn.pangrowth.base.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXRefreshView extends DJXBaseRefreshView {
    private final DJXRCircleView mCircleView;
    private final CircularProgressDrawable mProgress;
    private final View mRefreshContainer;
    private final TextView mTvSecondFloor;

    public DJXRefreshView(Context context) {
        this(context, null);
    }

    public DJXRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.djx_view_refresh, (ViewGroup) this, true);
        this.mRefreshContainer = viewInflate.findViewById(R.id.djx_rheader_container);
        this.mTvSecondFloor = (TextView) viewInflate.findViewById(R.id.djx_rheader_second);
        DJXRCircleView dJXRCircleView = (DJXRCircleView) viewInflate.findViewById(R.id.djx_rheader_image);
        this.mCircleView = dJXRCircleView;
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getContext());
        this.mProgress = circularProgressDrawable;
        circularProgressDrawable.setStyle(1);
        dJXRCircleView.setImageDrawable(circularProgressDrawable);
        circularProgressDrawable.setArrowEnabled(true);
        circularProgressDrawable.stop();
    }

    public void setSecondFloorView(View view) {
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(view, 0);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setHeight(float f, float f2, float f3) {
        this.mProgress.stop();
        moveSpinner(f, f2, f3);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setRefresh() {
        this.mProgress.setAlpha(255);
        this.mProgress.setArrowEnabled(false);
        this.mProgress.setProgressRotation(1.0f);
        this.mProgress.start();
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setPullToRefresh() {
        this.mTvSecondFloor.setVisibility(8);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.IRefresh
    public void setReleaseToRefresh() {
        this.mTvSecondFloor.setVisibility(8);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.DJXBaseRefreshView
    public void setReleaseToSecondFloor() {
        this.mTvSecondFloor.setVisibility(0);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.DJXBaseRefreshView
    public void setToSecondFloor() {
        this.mRefreshContainer.setVisibility(8);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.DJXBaseRefreshView
    public void setToFirstFloor() {
        this.mRefreshContainer.setVisibility(0);
    }

    public void setColorSchemeColors(int... iArr) {
        this.mProgress.setColorSchemeColors(iArr);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mCircleView.setBackgroundColor(i);
    }

    private void moveSpinner(float f, float f2, float f3) {
        this.mProgress.setArrowEnabled(true);
        float f4 = getContext().getResources().getDisplayMetrics().density;
        float fMax = (((float) Math.max(Math.min(1.0f, Math.abs(f / r10)) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float f5 = f4 * 64.0f;
        double dMax = Math.max(0.0f, Math.min(Math.abs(f) - (f3 / 10.0f), f5 * 2.0f) / f5) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
        this.mProgress.setStartEndTrim(0.0f, Math.min(0.8f, fMax * 0.8f));
        this.mProgress.setArrowScale(Math.min(1.0f, fMax));
        this.mProgress.setProgressRotation((((fMax * 0.4f) - 0.25f) + (fPow * 2.0f)) * 0.5f);
        int i = (int) ((f / f2) * 255.0f);
        if (i < 255 && i > 100) {
            i = 100;
        }
        this.mProgress.setAlpha(i <= 255 ? i : 255);
    }
}
