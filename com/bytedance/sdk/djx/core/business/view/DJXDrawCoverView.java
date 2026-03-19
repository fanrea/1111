package com.bytedance.sdk.djx.core.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.djx.core.vod.render.MeasureHelper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDrawCoverView extends ImageView {
    private MeasureHelper mMeasureHelper;

    public DJXDrawCoverView(Context context) {
        super(context);
        init();
    }

    public DJXDrawCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DJXDrawCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mMeasureHelper = new MeasureHelper();
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] iArrDoMeasure = this.mMeasureHelper.doMeasure(i, i2);
        setMeasuredDimension(iArrDoMeasure[0], iArrDoMeasure[1]);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(this.mMeasureHelper.doLayoutParams(layoutParams));
    }

    public void setVideoSize(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.mMeasureHelper.setVideoSize(i, i2);
        setLayoutParams(this.mMeasureHelper.doLayoutParams(getLayoutParams()));
        requestLayout();
    }
}
