package com.bytedance.sdk.djx.core.business.budrama.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.sdk.djx.absdk.EMABManager;
import com.bytedance.sdk.djx.core.api.ApiManager;
import com.bytedance.sdk.djx.core.api.req.DramaApi;
import com.bytedance.sdk.djx.core.api.rsp.DramaRsp;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.base.BaseViewModel;
import com.bytedance.sdk.djx.core.business.budrama.DramaManager;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.FeedAdModel;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.utils.LG;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDramaHomeViewModel extends BaseViewModel {
    public static final String FEED_CATEGORY = "feed_shortplays";
    public static final int FEED_PAGE_COUNT = 10;
    public static final int HISTORY_COUNT = 2;
    public static final String HOT_CATEGORY = "hot_shortplays";
    private static final int HOT_DRAMA_BUCKET_COUNT = 10;
    private static final int HOT_DRAMA_BUCKET_SIZE = 3;
    private static final int HOT_DRAMA_REQUEST_PAGE_SIZE = 30;
    private static final String KEY_AB_FIRST_AD_POS = "playlet_home_feed_ad_sort.first_ad_pos";
    private static final String KEY_AB_FOLLOW_POS = "playlet_home_feed_ad_sort.follow_ad_pos";
    private static final String KEY_AB_FOLLOW_SEP = "playlet_home_feed_ad_sort.follow_sep";
    private static final String TAG = "DJXDramaHomeViewModel";
    private AdKey mAdKey;
    private boolean mIsFirstAd = true;
    private boolean mIsSecondAd = true;
    private int mCountAd = 0;
    private int mAdIndex = -1;
    private int gridFirstAdPos = ((Integer) EMABManager.getInstance().getConfig(KEY_AB_FIRST_AD_POS, 0)).intValue();
    private int gridFollowSep = ((Integer) EMABManager.getInstance().getConfig(KEY_AB_FOLLOW_SEP, 0)).intValue();
    private int gridFollowAdPos = ((Integer) EMABManager.getInstance().getConfig(KEY_AB_FOLLOW_POS, 0)).intValue();
    private final MutableLiveData<BaseViewModel.DataWrapper<List<Drama>>> mHotList = new MutableLiveData<>();
    private final MutableLiveData<BaseViewModel.DataWrapper<List<Drama>>> mHistoryList = new MutableLiveData<>();
    private final MutableLiveData<BaseViewModel.DataWrapper<List<Drama>>> mGridList = new MutableLiveData<>();
    private List<Drama> mHotListCache = null;
    private Integer mHotDramaIndex = 0;
    private boolean isFeedLoading = false;
    private int mFeedPage = 1;

    static /* synthetic */ int access$608(DJXDramaHomeViewModel dJXDramaHomeViewModel) {
        int i = dJXDramaHomeViewModel.mFeedPage;
        dJXDramaHomeViewModel.mFeedPage = i + 1;
        return i;
    }

    public LiveData<BaseViewModel.DataWrapper<List<Drama>>> getHotList() {
        return this.mHotList;
    }

    public LiveData<BaseViewModel.DataWrapper<List<Drama>>> getHistoryList() {
        return this.mHistoryList;
    }

    public LiveData<BaseViewModel.DataWrapper<List<Drama>>> getGridList() {
        return this.mGridList;
    }

    public void loadHotList(List<String> list) {
        DramaApi.loadDramaList(HOT_CATEGORY, list, 1, 30, 2, new IApiCallback<DramaRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeViewModel.1
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaRsp dramaRsp) {
                DJXDramaHomeViewModel.this.mHotListCache = dramaRsp.getData();
                DJXDramaHomeViewModel.this.mHotDramaIndex = 0;
                DJXDramaHomeViewModel.this.acquire3HotDrama();
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaRsp dramaRsp) {
                BaseViewModel.DataWrapper dataWrapper = new BaseViewModel.DataWrapper(null);
                dataWrapper.setResult(BaseViewModel.NetworkResult.FAILED);
                DJXDramaHomeViewModel dJXDramaHomeViewModel = DJXDramaHomeViewModel.this;
                dJXDramaHomeViewModel.setValueInUIThread(dJXDramaHomeViewModel.mHotList, dataWrapper);
            }
        });
    }

    public void setAdKey(AdKey adKey) {
        this.mAdKey = adKey;
    }

    public void acquire3HotDrama() {
        List<Drama> list = this.mHotListCache;
        if (list == null || list.isEmpty()) {
            setValueInUIThread(this.mHotList, new BaseViewModel.DataWrapper(this.mHotListCache).setResult(BaseViewModel.NetworkResult.SUCCESS));
            return;
        }
        if (this.mHotDramaIndex.intValue() + 3 > this.mHotListCache.size()) {
            this.mHotDramaIndex = 0;
        }
        List<Drama> listSubList = this.mHotListCache.subList(this.mHotDramaIndex.intValue(), Math.min(this.mHotDramaIndex.intValue() + 3, this.mHotListCache.size()));
        setValueInUIThread(this.mHotList, new BaseViewModel.DataWrapper(listSubList).setResult(BaseViewModel.NetworkResult.SUCCESS));
        this.mHotDramaIndex = Integer.valueOf(this.mHotDramaIndex.intValue() + listSubList.size());
    }

    public void refreshHistory() {
        setValueInUIThread(this.mHistoryList, new BaseViewModel.DataWrapper(DramaManager.getInstance().getLatestHistory(2)));
    }

    public void loadLastedHistory() {
        DramaApi.loadDramaHistory(1, 20, new IApiCallback<DramaRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeViewModel.2
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaRsp dramaRsp) throws JSONException {
                List<Drama> data = dramaRsp.getData();
                Collections.reverse(data);
                DramaManager.getInstance().saveLocalHistory(data);
                DJXDramaHomeViewModel.this.refreshHistory();
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaRsp dramaRsp) {
                LG.e(DJXDramaHomeViewModel.TAG, "loadDramaHistory onApiFailure: msg = " + dJXError);
            }
        });
    }

    public void loadAllHistory() {
        ApiManager.loadAllDramaHistory(new IApiCallback<DramaRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeViewModel.3
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaRsp dramaRsp) throws JSONException {
                DramaManager.getInstance().saveLocalHistory(dramaRsp.getData());
                DJXDramaHomeViewModel.this.refreshHistory();
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaRsp dramaRsp) {
                LG.e(DJXDramaHomeViewModel.TAG, "loadDramaHistory onApiFailure: msg = " + dJXError);
            }
        });
    }

    public void loadGridList(boolean z) {
        if (this.isFeedLoading) {
            return;
        }
        this.isFeedLoading = true;
        setValueInUIThread(this.mUiData, new BaseViewModel.DataWrapper(BaseViewModel.UIEvent.SHOW_PROGRESS));
        if (z) {
            this.mFeedPage = 1;
            this.mCountAd = 0;
            this.mIsFirstAd = true;
            this.mIsSecondAd = true;
        }
        DramaApi.loadDramaList(FEED_CATEGORY, null, this.mFeedPage, 10, 2, new IApiCallback<DramaRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeViewModel.4
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaRsp dramaRsp) {
                BaseViewModel.DataWrapper dataWrapper = new BaseViewModel.DataWrapper(dramaRsp.getData());
                dataWrapper.setResult(BaseViewModel.NetworkResult.SUCCESS);
                dataWrapper.setExtra(Boolean.valueOf(dramaRsp.isHasMore()));
                dataWrapper.parseDuration = dramaRsp.parseDuration;
                dataWrapper.errCode = dramaRsp.getCode();
                dataWrapper.errMsg = dramaRsp.getMsg();
                DJXDramaHomeViewModel dJXDramaHomeViewModel = DJXDramaHomeViewModel.this;
                dJXDramaHomeViewModel.setValueInUIThread(dJXDramaHomeViewModel.mGridList, dataWrapper);
                DJXDramaHomeViewModel dJXDramaHomeViewModel2 = DJXDramaHomeViewModel.this;
                dJXDramaHomeViewModel2.setValueInUIThread(dJXDramaHomeViewModel2.mUiData, new BaseViewModel.DataWrapper(BaseViewModel.UIEvent.DISMISS_PROGRESS));
                DJXDramaHomeViewModel.this.isFeedLoading = false;
                DJXDramaHomeViewModel.access$608(DJXDramaHomeViewModel.this);
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaRsp dramaRsp) {
                BaseViewModel.DataWrapper dataWrapper = new BaseViewModel.DataWrapper(null);
                dataWrapper.setResult(BaseViewModel.NetworkResult.FAILED);
                dataWrapper.errCode = dJXError.code;
                dataWrapper.errMsg = dJXError.msg;
                LG.e(DJXDramaHomeViewModel.TAG, "onApiFailure: msg = " + dJXError);
                DJXDramaHomeViewModel dJXDramaHomeViewModel = DJXDramaHomeViewModel.this;
                dJXDramaHomeViewModel.setValueInUIThread(dJXDramaHomeViewModel.mGridList, dataWrapper);
                DJXDramaHomeViewModel dJXDramaHomeViewModel2 = DJXDramaHomeViewModel.this;
                dJXDramaHomeViewModel2.setValueInUIThread(dJXDramaHomeViewModel2.mUiData, new BaseViewModel.DataWrapper(BaseViewModel.UIEvent.DISMISS_PROGRESS));
                DJXDramaHomeViewModel.this.isFeedLoading = false;
            }
        });
    }

    public boolean hasCache() {
        return this.mHotListCache != null;
    }

    public List<Object> inflateAd(List<Drama> list) {
        if (list == null) {
            return null;
        }
        initSortData();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Drama drama : list) {
            int i2 = this.mCountAd + 1;
            this.mCountAd = i2;
            if (this.mIsFirstAd && i2 >= this.gridFirstAdPos) {
                this.mIsFirstAd = false;
                if (AdManager.inst().hasAd(this.mAdKey, i)) {
                    insertAd(arrayList);
                    i++;
                }
            }
            if (!this.mIsFirstAd && this.mIsSecondAd && this.mCountAd >= this.gridFollowAdPos - 1) {
                this.mIsSecondAd = false;
                if (AdManager.inst().hasAd(this.mAdKey, i)) {
                    insertAd(arrayList);
                    i++;
                }
            }
            if (!this.mIsFirstAd && !this.mIsSecondAd && this.mCountAd >= this.gridFollowSep - 1 && AdManager.inst().hasAd(this.mAdKey, i)) {
                insertAd(arrayList);
                i++;
            }
            arrayList.add(drama);
        }
        return arrayList;
    }

    private void insertAd(List<Object> list) {
        list.add(new FeedAdModel());
        this.mCountAd = 0;
    }

    private void initSortData() {
        if (this.gridFirstAdPos <= 0) {
            this.gridFirstAdPos = 1;
        }
        if (this.gridFollowSep <= 0) {
            this.gridFollowSep = 2;
        }
        if (this.gridFollowAdPos <= 0) {
            this.gridFollowAdPos = 1;
        }
        int i = this.gridFollowAdPos;
        int i2 = this.gridFollowSep;
        if (i > i2) {
            this.gridFollowAdPos = i2;
        }
    }
}
