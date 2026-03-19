package com.bytedance.sdk.djx.core.business.budrama.draw;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter;
import com.bytedance.sdk.djx.model.Feed;
import com.bytedance.sdk.djx.model.VideoM;
import com.bytedance.sdk.djx.params.DJXWidgetDrawParams;
import com.bytedance.sdk.djx.utils.LG;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DrawAdapter2 extends RecyclePagerAdapter<HolderBase> {
    private static final int ITEM_TYPE_DRAMA = 1002;
    private static final String TAG = "DrawAdapter2";
    private AdKey mAdKey;
    private AdKey mAdKeyBanner;
    private AdKey mAdKeyFullScreenInterstitial;
    private AdKey mAdKeyHalfScreenInterstitial;
    private AdKey mAdKeyInterstitialPost;
    private String mCategory;
    private OnClickDrawListener mClickDrawListener;
    private final Map<String, Object> mCommonParams;
    private int mCurrent;
    private final List<PosModel> mDelList;
    private String mFeatureValues;
    private HolderBase mHolder;
    private DJXWidgetDrawParams mWidgetDrawParams;

    public interface OnClickDrawListener {
        Context getActivity4Adapter();

        String getCachePlayReason();

        int getCurrentPosition();

        long getRootGid();

        String getVideoPlayType(Feed feed);

        void onClickComment(View view, Feed feed);

        void onClickShare(View view, Feed feed);

        void onPlayStart(Object obj);

        void onRenderFirstFrame();

        void onVideoCompletion(boolean z);

        void onVideoModelExpired(VideoM videoM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter
    public void onBindViewHolder(HolderBase holderBase, Object obj, int i, boolean z) {
    }

    public DrawAdapter2(Context context, Map<String, Object> map) {
        super(context);
        this.mCurrent = -1;
        this.mDelList = new ArrayList();
        this.mFeatureValues = "";
        this.mCommonParams = map;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void setClickDrawListener(OnClickDrawListener onClickDrawListener) {
        this.mClickDrawListener = onClickDrawListener;
    }

    public void setAdKey(AdKey adKey, AdKey adKey2, AdKey adKey3, AdKey adKey4) {
        this.mAdKey = adKey;
        this.mAdKeyHalfScreenInterstitial = adKey3;
        this.mAdKeyFullScreenInterstitial = adKey4;
        this.mAdKeyInterstitialPost = adKey2;
    }

    public void setWidgetDrawParams(DJXWidgetDrawParams dJXWidgetDrawParams) {
        this.mWidgetDrawParams = dJXWidgetDrawParams;
    }

    public int getOriginalCount() {
        return getCount() + this.mDelList.size();
    }

    public void filterCurrentDataList() {
        refresh(getList(), null);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter
    public Object remove(int i) {
        Object objRemove = super.remove(i);
        if (objRemove instanceof Feed) {
            if (((Feed) objRemove).isType4Ad()) {
                this.mDelList.add(PosModel.createAd(i));
            }
        } else if ((objRemove instanceof DrawAdNativeModel) || (objRemove instanceof DrawAdModel)) {
            this.mDelList.add(PosModel.createAd(i));
        }
        return objRemove;
    }

    public int removeCache(int i) {
        int i2;
        int count = getCount();
        if (count <= 0 || i >= count - 1) {
            i2 = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < count && i3 < i; i3++) {
                Object itemData = getItemData(i3);
                if (itemData != null) {
                    arrayList.add(itemData);
                }
            }
            this.mList.clear();
            this.mList.addAll(arrayList);
            i2 = count - i;
            notifyItemRangeRemoved(i, i2);
        }
        return Math.max(i2, 0);
    }

    public void refresh(List<Object> list, Runnable runnable) {
        HolderBase holderBase = this.mHolder;
        if (holderBase != null) {
            holderBase.onAdStop(true);
        }
        if (runnable != null) {
            runnable.run();
        }
        refresh(list);
        this.mCurrent = -1;
        HolderBase holderBase2 = this.mHolder;
        if (holderBase2 != null) {
            holderBase2.onHolderStop();
            this.mHolder = null;
        }
    }

    public void onUserVisible() {
        HolderBase holderBase = this.mHolder;
        if (holderBase != null) {
            holderBase.onHolderResume();
        }
    }

    public void onUserInvisible() {
        HolderBase holderBase = this.mHolder;
        if (holderBase != null) {
            holderBase.onHolderPause();
            LG.i(TAG, "onUserInvisible holder pause");
        }
    }

    public void onPageSelected(int i, HolderBase holderBase, boolean z) {
        if (i != this.mCurrent) {
            this.mCurrent = i;
            HolderBase holderBase2 = this.mHolder;
            if (holderBase2 != holderBase) {
                if (holderBase2 != null) {
                    holderBase2.onAdStop(false);
                    this.mHolder.onHolderStop();
                    this.mHolder = null;
                }
                this.mHolder = holderBase;
                if (holderBase != null) {
                    holderBase.onHolderShow();
                    if (z) {
                        holderBase.onHolderPause();
                        LG.i(TAG, "DrawAdapter2 onPageSelected holder pause, pos = " + i + " , holder = " + holderBase + " ,isNeedPause = true");
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter
    protected int getItemViewType(int i) {
        Object itemData = getItemData(i);
        if (itemData instanceof Feed) {
            ((Feed) itemData).isType4Drama();
        }
        return 1002;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter
    public HolderBase onCreateViewHolder(ViewGroup viewGroup, int i, int i2) {
        if (i == 1002) {
            return new DrawHolderDrama(this.mClickDrawListener, this.mWidgetDrawParams, this.mCategory, this.mCommonParams, this.mFeatureValues);
        }
        return new DrawHolderDrama(this.mClickDrawListener, this.mWidgetDrawParams, this.mCategory, this.mCommonParams, this.mFeatureValues);
    }

    public void setFeatureValues(String str) {
        this.mFeatureValues = str;
    }
}
