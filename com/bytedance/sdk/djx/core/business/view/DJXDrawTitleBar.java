package com.bytedance.sdk.djx.core.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.djx.core.business.view.loading.DJXDoubleColorBallAnimationView;
import com.bytedance.sdk.djx.core.business.view.tab.NewsPagerSlidingTab;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.params.DJXWidgetDrawParams;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDrawTitleBar extends FrameLayout {
    private ImageView mIvClose;
    private ImageView mIvLive;
    private LinearLayout mLayoutTop;
    private DJXDoubleColorBallAnimationView mLoadingViw;
    private RelativeLayout mTabsLayout;
    private NewsPagerSlidingTab mTabsSlidingView;

    public DJXDrawTitleBar(Context context) {
        super(context);
        init(context);
    }

    public DJXDrawTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DJXDrawTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public DJXDrawTitleBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.djx_view_draw_title_bar, this);
        this.mTabsLayout = (RelativeLayout) findViewById(R.id.djx_draw_title_bar_tabs_layout);
        this.mTabsSlidingView = (NewsPagerSlidingTab) findViewById(R.id.djx_draw_title_bar_tabs);
        this.mLoadingViw = (DJXDoubleColorBallAnimationView) findViewById(R.id.djx_draw_title_bar_loading);
        this.mLayoutTop = (LinearLayout) findViewById(R.id.djx_draw_title_bar_top_layout);
        this.mIvClose = (ImageView) findViewById(R.id.djx_draw_title_bar_close);
        this.mIvLive = (ImageView) findViewById(R.id.djx_draw_title_bar_enter_live_icon);
    }

    public void showLoading(boolean z) {
        DJXDoubleColorBallAnimationView dJXDoubleColorBallAnimationView = this.mLoadingViw;
        if (dJXDoubleColorBallAnimationView != null) {
            dJXDoubleColorBallAnimationView.setVisibility(z ? 0 : 8);
        }
    }

    public NewsPagerSlidingTab getTabsSlidingView() {
        return this.mTabsSlidingView;
    }

    public void setCloseListener(boolean z, View.OnClickListener onClickListener) {
        ImageView imageView = this.mIvClose;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setLiveListener(boolean z, View.OnClickListener onClickListener) {
        ImageView imageView = this.mIvLive;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
            this.mIvLive.setOnClickListener(onClickListener);
        }
    }

    public void initTitle(DJXWidgetDrawParams dJXWidgetDrawParams) {
        setCustomMargin(dJXWidgetDrawParams);
        if (!SettingData.getInstance().isInnerBack()) {
            this.mIvClose.setImageDrawable(getResources().getDrawable(R.drawable.djx_close));
        }
        if (dJXWidgetDrawParams != null && dJXWidgetDrawParams.mIsHideClose) {
            this.mIvClose.setVisibility(8);
        } else {
            this.mIvClose.setVisibility(0);
        }
    }

    private void setCustomMargin(DJXWidgetDrawParams dJXWidgetDrawParams) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mLayoutTop.getLayoutParams();
        if (dJXWidgetDrawParams != null && dJXWidgetDrawParams.mTitleTopMargin >= 0) {
            marginLayoutParams.topMargin = UIUtil.dp2px(dJXWidgetDrawParams.mTitleTopMargin);
        }
        this.mLayoutTop.setLayoutParams(marginLayoutParams);
        RelativeLayout relativeLayout = this.mTabsLayout;
        if (relativeLayout != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) relativeLayout.getLayoutParams();
            if (dJXWidgetDrawParams != null && dJXWidgetDrawParams.mTitleTopMargin >= 0) {
                marginLayoutParams2.topMargin = UIUtil.dp2px(dJXWidgetDrawParams.mTitleTopMargin - 6);
            }
            relativeLayout.setLayoutParams(marginLayoutParams2);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.mIvLive.getLayoutParams();
        if (dJXWidgetDrawParams != null && dJXWidgetDrawParams.mTitleLeftMargin >= 0) {
            marginLayoutParams3.leftMargin = UIUtil.dp2px(dJXWidgetDrawParams.mTitleLeftMargin);
        }
        this.mIvLive.setLayoutParams(marginLayoutParams3);
    }
}
