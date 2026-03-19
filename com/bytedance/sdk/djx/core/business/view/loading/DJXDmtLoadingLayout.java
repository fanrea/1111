package com.bytedance.sdk.djx.core.business.view.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.pangle.cn.pangrowth.base.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDmtLoadingLayout extends FrameLayout {
    private View mProgress;

    public DJXDmtLoadingLayout(Context context) {
        this(context, null);
    }

    public DJXDmtLoadingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DJXDmtLoadingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mProgress = LayoutInflater.from(context).inflate(R.layout.djx_layout_dmt_loading, (ViewGroup) this, true).findViewById(R.id.djx_dmt_loading_double_loading_view);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.mProgress;
        if (view == null) {
            return;
        }
        view.setVisibility(i);
    }
}
