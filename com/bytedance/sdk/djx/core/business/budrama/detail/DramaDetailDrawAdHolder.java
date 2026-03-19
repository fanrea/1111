package com.bytedance.sdk.djx.core.business.budrama.detail;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.djx.IDJXCustomView;
import com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailAdapter;
import com.bytedance.sdk.djx.core.log.SdkTLog;
import com.bytedance.sdk.djx.model.DJXDramaDetailConfig;
import com.bytedance.sdk.djx.model.DramaDrawAd;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaDetailDrawAdHolder extends DramaDetailHolderBase<DramaDrawAd> {
    private final DramaDetailAdapter.OnDrawListener mClickDrawListener;
    private final Map<String, Object> mCommonParams;
    private IDJXCustomView mCustomView;
    private final DJXDramaDetailConfig mDetailConfig;
    private DramaDrawAd mDrawAd;
    private FrameLayout mFrameLayout;
    private int mPosition;
    private SdkTLog mTLog = new SdkTLog();
    private final IDJXCustomView.IDJXNotifyListener mNotifyListener = new IDJXCustomView.IDJXNotifyListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailDrawAdHolder.1
        @Override // com.bytedance.sdk.djx.IDJXCustomView.IDJXNotifyListener
        public void notifyDelete() {
            if (DramaDetailDrawAdHolder.this.mClickDrawListener != null) {
                DramaDetailDrawAdHolder.this.mClickDrawListener.deleteHolder(DramaDetailDrawAdHolder.this.mPosition);
            }
            if (DramaDetailDrawAdHolder.this.mTLog == null || DramaDetailDrawAdHolder.this.mDrawAd == null) {
                return;
            }
            DramaDetailDrawAdHolder.this.mTLog.sendDeleteCustomDrawAd(DramaDetailDrawAdHolder.this.mDrawAd.getAdPosition());
        }
    };

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolderBase, com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase
    public /* bridge */ /* synthetic */ void onHolderPause() {
        super.onHolderPause();
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolderBase, com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase
    public /* bridge */ /* synthetic */ void onHolderResume() {
        super.onHolderResume();
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolderBase, com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase
    public /* bridge */ /* synthetic */ void onHolderStop() {
        super.onHolderStop();
    }

    public DramaDetailDrawAdHolder(DramaDetailAdapter.OnDrawListener onDrawListener, DJXDramaDetailConfig dJXDramaDetailConfig, Map<String, Object> map) {
        this.mDetailConfig = dJXDramaDetailConfig;
        this.mCommonParams = map;
        this.mClickDrawListener = onDrawListener;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter.Holder
    protected Object getLayoutId() {
        return Integer.valueOf(R.layout.djx_item_drama_detail_draw_ad);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter.Holder
    public void createHolder(DramaDrawAd dramaDrawAd, int i, View view) {
        this.mDrawAd = dramaDrawAd;
        this.mPosition = i;
        this.mFrameLayout = (FrameLayout) view.findViewById(R.id.djx_drama_detail_item_ad_frame);
        IDJXCustomView customView = getCustomView();
        if (customView != null) {
            customView.notifyListener(this.mNotifyListener);
            customView.createHolder(i, dramaDrawAd.getAdPosition());
        }
    }

    private IDJXCustomView getCustomView() {
        if (this.mCustomView == null && this.mDetailConfig.getAdCustomProvider() != null) {
            this.mCustomView = this.mDetailConfig.getAdCustomProvider().getDetailAdDrawView();
        }
        this.mTLog.sendGetCustomDrawAd(this.mCustomView == null, this.mDrawAd.getAdPosition());
        return this.mCustomView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter.Holder
    public void bindHolder(boolean z, DramaDrawAd dramaDrawAd, int i, View view) {
        ViewGroup.LayoutParams layoutParams;
        if (z && (layoutParams = getItemView().getLayoutParams()) != null) {
            layoutParams.height = -1;
            getItemView().setLayoutParams(layoutParams);
        }
        this.mDrawAd = dramaDrawAd;
        this.mPosition = i;
        this.mFrameLayout.setVisibility(0);
        fillAd(getData().getAdPosition());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void fillAd(int r5) {
        /*
            r4 = this;
            com.bytedance.sdk.djx.IDJXCustomView r0 = r4.getCustomView()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L2a
            com.bytedance.sdk.djx.IDJXCustomView r0 = r4.getCustomView()
            com.bytedance.sdk.djx.IDJXCustomView$IDJXNotifyListener r3 = r4.mNotifyListener
            r0.notifyListener(r3)
            com.bytedance.sdk.djx.IDJXCustomView r0 = r4.getCustomView()
            int r3 = r4.mPosition
            android.view.View r5 = r0.bindHolder(r3, r5)
            if (r5 == 0) goto L2a
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r3 = -1
            r0.<init>(r3, r3)
            android.widget.FrameLayout r3 = r4.mFrameLayout
            r3.addView(r5, r0)
            r5 = r1
            goto L2b
        L2a:
            r5 = r2
        L2b:
            com.bytedance.sdk.djx.core.log.SdkTLog r0 = r4.mTLog
            com.bytedance.sdk.djx.model.DramaDrawAd r3 = r4.mDrawAd
            int r3 = r3.getAdPosition()
            r0.sendGetCustomDrawAd(r5, r3)
            com.bytedance.sdk.djx.model.DramaDrawAd r0 = r4.getData()
            r0.setAddView(r5)
            android.view.View r0 = r4.getItemView()
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r5 != 0) goto L61
            android.view.View r5 = r4.getItemView()
            r2 = 8
            r5.setVisibility(r2)
            boolean r5 = r0 instanceof com.bytedance.sdk.djx.core.business.view.VerticalViewPager.LayoutParams
            if (r5 == 0) goto L78
            r5 = r0
            com.bytedance.sdk.djx.core.business.view.VerticalViewPager$LayoutParams r5 = (com.bytedance.sdk.djx.core.business.view.VerticalViewPager.LayoutParams) r5
            r5.isDecor = r1
            android.view.View r5 = r4.getItemView()
            r5.setLayoutParams(r0)
            goto L78
        L61:
            android.view.View r5 = r4.getItemView()
            r5.setVisibility(r2)
            boolean r5 = r0 instanceof com.bytedance.sdk.djx.core.business.view.VerticalViewPager.LayoutParams
            if (r5 == 0) goto L78
            r5 = r0
            com.bytedance.sdk.djx.core.business.view.VerticalViewPager$LayoutParams r5 = (com.bytedance.sdk.djx.core.business.view.VerticalViewPager.LayoutParams) r5
            r5.isDecor = r2
            android.view.View r5 = r4.getItemView()
            r5.setLayoutParams(r0)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailDrawAdHolder.fillAd(int):void");
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolderBase, com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase
    public void onHolderShow() {
        super.onHolderShow();
        if (getCustomView() != null) {
            getCustomView().notifyListener(this.mNotifyListener);
            getCustomView().selectHolder(this.mPosition, getData().getAdPosition());
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase, com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter.Holder
    protected void destroy() {
        this.mFrameLayout.removeAllViews();
        getData().setAddView(false);
        if (getCustomView() != null) {
            getCustomView().onDestroy();
        }
        this.mCustomView = null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHolderBase
    public DramaDrawAd getData() {
        return this.mDrawAd;
    }
}
