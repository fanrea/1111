package com.bytedance.sdk.djx.core.business.budrama.home;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.core.business.budrama.GridRenderHelper;
import com.bytedance.sdk.djx.core.business.budrama.home.DramaGridAdapter;
import com.bytedance.sdk.djx.core.business.view.rv.base.BaseViewHolder;
import com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView;
import com.bytedance.sdk.djx.model.FeedAdModel;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXHomeAdItemView extends IMultiItemView {
    private static final int COLUMN_SPACING = 10;
    private static final float RATIO = 0.5625f;
    private static final int SPAN_COUNT = 2;
    private AdKey mAdKey;
    private DramaGridAdapter.DJXHomeAdItemListener mItemAdListener;
    private int mLayoutWidth;
    protected RecyclerView mRecyclerView;

    @Override // com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView
    public void bindViewHolder(BaseViewHolder baseViewHolder, Object obj, int i) {
    }

    public void setContainer(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    public void setListener(DramaGridAdapter.DJXHomeAdItemListener dJXHomeAdItemListener) {
        this.mItemAdListener = dJXHomeAdItemListener;
    }

    public void setAdKey(AdKey adKey) {
        this.mAdKey = adKey;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView
    public Object getItemViewLayoutId() {
        View viewInflate = LayoutInflater.from(this.mRecyclerView.getContext()).inflate(R.layout.djx_item_home_ad, (ViewGroup) this.mRecyclerView, false);
        viewInflate.setLayoutParams(GridRenderHelper.handleVerticalLayoutParams(viewInflate.getLayoutParams(), this.mRecyclerView.getWidth(), 10, 2, RATIO));
        this.mLayoutWidth = GridRenderHelper.getRealSpace(this.mRecyclerView.getWidth(), 10, 2);
        return viewInflate;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView
    public boolean isForViewType(Object obj, int i) {
        return obj instanceof FeedAdModel;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView
    public void bindViewHolder(BaseViewHolder baseViewHolder, Object obj, int i, List<Object> list) {
        FrameLayout.LayoutParams layoutParams;
        FrameLayout frameLayout = (FrameLayout) baseViewHolder.getView(R.id.djx_home_page_item_ad_frame);
        IDJXAd tempAd = AdManager.inst().getTempAd(i);
        if (tempAd == null && (obj instanceof FeedAdModel)) {
            tempAd = AdManager.inst().getAd(this.mAdKey);
        }
        if (tempAd == null) {
            return;
        }
        AdManager.inst().saveTempAd(i, tempAd);
        bindAd(baseViewHolder, tempAd, i);
        View adView = tempAd.getAdView();
        if (adView != null) {
            frameLayout.removeAllViews();
            if (adView.getLayoutParams() == null) {
                layoutParams = new FrameLayout.LayoutParams(this.mLayoutWidth, -2);
            } else {
                layoutParams = new FrameLayout.LayoutParams(adView.getLayoutParams());
            }
            if (adView.getParent() != null) {
                ((ViewGroup) adView.getParent()).removeView(adView);
            }
            frameLayout.addView(adView, layoutParams);
        }
    }

    private void bindAd(BaseViewHolder baseViewHolder, IDJXAd iDJXAd, final int i) {
        RecyclerView recyclerView;
        if (iDJXAd == null || baseViewHolder == null) {
            return;
        }
        Activity activity = null;
        if (baseViewHolder.getConvertView() != null && (baseViewHolder.getConvertView().getContext() instanceof Activity)) {
            activity = (Activity) baseViewHolder.getConvertView().getContext();
        }
        if (activity == null && (recyclerView = this.mRecyclerView) != null && recyclerView.getContext() != null && (this.mRecyclerView.getContext() instanceof Activity)) {
            activity = (Activity) this.mRecyclerView.getContext();
        }
        if (activity != null) {
            iDJXAd.setDislikeCallback(activity, new IDJXAd.DislikeInteractionCallback() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXHomeAdItemView.1
                @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.DislikeInteractionCallback
                public void onCancel() {
                }

                @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.DislikeInteractionCallback
                public void onRefuse() {
                }

                @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.DislikeInteractionCallback
                public void onShow() {
                }

                @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.DislikeInteractionCallback
                public void onSelected(int i2, String str) {
                    if (DJXHomeAdItemView.this.mItemAdListener != null) {
                        DJXHomeAdItemView.this.mItemAdListener.onItemClose(null, i, null);
                        AdManager.inst().removeTempAd(i);
                    }
                }
            });
        }
    }
}
