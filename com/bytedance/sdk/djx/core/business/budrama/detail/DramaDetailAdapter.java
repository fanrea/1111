package com.bytedance.sdk.djx.core.business.budrama.detail;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.model.DJXDramaDetailConfig;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.model.DramaDrawAd;
import com.bytedance.sdk.djx.model.VideoM;
import com.bytedance.sdk.djx.utils.LG;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaDetailAdapter extends RecyclePagerAdapter<DramaDetailHolderBase<?>> {
    private static final String TAG = "DramaDetailAdapter";
    private static final int TYPE_CUSTOM_DRAW_AD = 11;
    private static final int TYPE_DRAMA = 10;
    private String mCategory;
    private final Map<String, Object> mCommonParams;
    private int mCurrent;
    private final DJXDramaDetailConfig mDetailConfig;
    private OnDrawListener mDrawListener;
    private String mFromCategory;
    private String mFromGid;
    private DramaDetailHolderBase<?> mHolder;
    private String mPlaySource;

    public interface OnDrawListener {
        void deleteHolder(int i);

        Context getActivity4Adapter();

        int getCurrentPosition();

        long getRootGid();

        Map<String, Object> getSourceRecMap();

        boolean isBlock(DramaDetail dramaDetail);

        boolean isRefreshFirst();

        void onClickDramaTitle(View view, DramaDetail dramaDetail);

        void onPlayStart(Object obj);

        void onRenderFirstFrame();

        void onVideoCompletion(boolean z);

        void onVideoModelExpired(VideoM videoM);

        void unlockFlowStart(DramaDetail dramaDetail);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter
    public void onBindViewHolder(DramaDetailHolderBase<?> dramaDetailHolderBase, Object obj, int i, boolean z) {
    }

    public DramaDetailAdapter(Context context, DJXDramaDetailConfig dJXDramaDetailConfig, Map<String, Object> map) {
        super(context);
        this.mCurrent = -1;
        this.mPlaySource = ILogConst.PLAY_SOURCE_DEFAULT;
        this.mCommonParams = map;
        this.mDetailConfig = dJXDramaDetailConfig;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void setDrawListener(OnDrawListener onDrawListener) {
        this.mDrawListener = onDrawListener;
    }

    public void setFromCategory(String str) {
        this.mFromCategory = str;
    }

    public void setFromGid(String str) {
        this.mFromGid = str;
    }

    public void setPlaySource(String str) {
        this.mPlaySource = str;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter
    public void refresh(List<Object> list) {
        this.mCurrent = -1;
        DramaDetailHolderBase<?> dramaDetailHolderBase = this.mHolder;
        if (dramaDetailHolderBase != null) {
            dramaDetailHolderBase.onHolderStop();
            this.mHolder = null;
        }
        super.refresh(list);
    }

    public void setCurrent(int i) {
        this.mCurrent = i;
    }

    public void onUserVisible() {
        DramaDetailHolderBase<?> dramaDetailHolderBase = this.mHolder;
        if (dramaDetailHolderBase != null) {
            dramaDetailHolderBase.onHolderResume();
        }
    }

    public void onUserInvisible() {
        DramaDetailHolderBase<?> dramaDetailHolderBase = this.mHolder;
        if (dramaDetailHolderBase != null) {
            dramaDetailHolderBase.onHolderPause();
            LG.i(TAG, "onUserInvisible holder pause");
        }
    }

    public void onPageSelected(int i, DramaDetailHolderBase<?> dramaDetailHolderBase) {
        if (i != this.mCurrent) {
            this.mCurrent = i;
            DramaDetailHolderBase<?> dramaDetailHolderBase2 = this.mHolder;
            if (dramaDetailHolderBase2 != dramaDetailHolderBase) {
                if (dramaDetailHolderBase2 != null) {
                    dramaDetailHolderBase2.onHolderStop();
                }
                this.mHolder = dramaDetailHolderBase;
                if (dramaDetailHolderBase != null) {
                    dramaDetailHolderBase.onHolderShow();
                    LG.i(TAG, "DramaDetailAdapter onPageSelected holder pause, pos = " + i + " , holder = " + dramaDetailHolderBase);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter
    public DramaDetailHolderBase<?> onCreateViewHolder(ViewGroup viewGroup, int i, int i2) {
        if (11 == i) {
            return new DramaDetailDrawAdHolder(this.mDrawListener, this.mDetailConfig, this.mCommonParams);
        }
        return new DramaDetailHolder(this.mDrawListener, this.mDetailConfig, this.mCategory, this.mCommonParams, this.mFromCategory, this.mFromGid, this.mPlaySource);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter
    protected int getItemViewType(int i) {
        return getItemData(i) instanceof DramaDrawAd ? 11 : 10;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public float getPageWidth(int i) {
        Object itemData = getItemData(i);
        if (!(itemData instanceof DramaDrawAd) || ((DramaDrawAd) itemData).getIsAddView()) {
            return super.getPageWidth(i);
        }
        return 0.0f;
    }
}
