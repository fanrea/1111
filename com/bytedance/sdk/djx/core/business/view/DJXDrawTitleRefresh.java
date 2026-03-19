package com.bytedance.sdk.djx.core.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.djx.core.business.view.loading.DJXDoubleColorBallAnimationView;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDrawTitleRefresh extends FrameLayout {
    private DJXDoubleColorBallAnimationView mLoadingView;
    private TextView mTvContent;

    public DJXDrawTitleRefresh(Context context) {
        super(context);
        init(context);
    }

    public DJXDrawTitleRefresh(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DJXDrawTitleRefresh(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public DJXDrawTitleRefresh(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.djx_view_draw_title_refresh, this);
        this.mTvContent = (TextView) findViewById(R.id.djx_draw_title_refresh_content);
        this.mLoadingView = (DJXDoubleColorBallAnimationView) findViewById(R.id.djx_draw_title_refresh_loading);
    }

    public void setProgress(float f) {
        DJXDoubleColorBallAnimationView dJXDoubleColorBallAnimationView = this.mLoadingView;
        if (dJXDoubleColorBallAnimationView != null) {
            dJXDoubleColorBallAnimationView.setProgress(f);
        }
    }

    public void setContent(boolean z) {
        TextView textView = this.mTvContent;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
    }
}
