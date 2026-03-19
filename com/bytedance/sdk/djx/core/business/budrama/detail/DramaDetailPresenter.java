package com.bytedance.sdk.djx.core.business.budrama.detail;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.g;
import com.bytedance.sdk.djx.core.api.ApiManager;
import com.bytedance.sdk.djx.core.api.req.DramaApi;
import com.bytedance.sdk.djx.core.api.rsp.DramaFeedRsp;
import com.bytedance.sdk.djx.core.api.rsp.DramaFeedRspKt;
import com.bytedance.sdk.djx.core.api.rsp.DramaUnlockModel;
import com.bytedance.sdk.djx.core.api.rsp.DramaUnlockRsp;
import com.bytedance.sdk.djx.core.business.base.PresenterAbstract;
import com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailContract;
import com.bytedance.sdk.djx.core.log.T2WLog;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.model.CacheStatus;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.model.DramaFeed;
import com.bytedance.sdk.djx.net.api.ErrCode;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.params.DJXWidgetDramaDetailParams;
import com.bytedance.sdk.djx.utils.LG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class DramaDetailPresenter extends PresenterAbstract<DramaDetailContract.View> implements DramaDetailContract.Presenter {
    private static final String TAG = "DramaDetailPresenter";
    private Drama mDrama;
    private List<Integer> mDrawAdPositions;
    private T2WLog mT2WLog;
    private final DJXWidgetDramaDetailParams mWidgetParams;
    private boolean mIsLoading = false;
    private int mMinDramaCursor = 0;
    private int mMaxDramaCursor = 0;
    private int mDramaTotal = Integer.MAX_VALUE;
    private long mNextRecommendDramaId = -1;
    private int mLockSet = -1;
    private List<Integer> mUnlockList = null;

    DramaDetailPresenter(DJXWidgetDramaDetailParams dJXWidgetDramaDetailParams, Drama drama) {
        this.mWidgetParams = dJXWidgetDramaDetailParams;
        this.mDrama = drama;
    }

    public void setDrawPositions(List<Integer> list) {
        this.mDrawAdPositions = list;
    }

    public void setT2WLog(T2WLog t2WLog) {
        this.mT2WLog = t2WLog;
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailContract.Presenter
    public boolean getDramaPullDownEnable() {
        return this.mMinDramaCursor > 1;
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailContract.Presenter
    public boolean getDramaLoadMoreEnable() {
        return this.mMaxDramaCursor < this.mDramaTotal;
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailContract.Presenter
    public void loadDramaInit(int i) {
        loadDramaDetail(true, false, i);
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailContract.Presenter
    public void loadDramaBefore() {
        loadDramaDetail(false, false, 0);
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailContract.Presenter
    public void loadDramaAfter(boolean z) {
        if (this.mMaxDramaCursor == this.mDramaTotal && !z && this.mWidgetParams.detailConfig.isInfiniteScrollEnabled()) {
            loadNewDrama();
        } else {
            loadDramaDetail(false, true, 0);
        }
    }

    public void unLockDrama() {
        if (this.mUnlockList != null) {
            ((DramaDetailContract.View) this.mView).onUnlockDrama(0, this.mLockSet, this.mUnlockList);
        } else {
            LG.e(TAG, "UnlockList is null");
        }
    }

    public List<Integer> getUnlockList() {
        return this.mUnlockList;
    }

    public void loadNewDrama() {
        if (this.mView == 0 || this.mIsLoading) {
            return;
        }
        this.mIsLoading = true;
        if (this.mWidgetParams.detailConfig.getListener() != null) {
            this.mWidgetParams.detailConfig.getListener().onDJXRequestStart(null);
            LG.d(TAG, "onDJXRequestStart");
        }
        ApiManager.getInstance().dramaDetail(this.mNextRecommendDramaId, 1, 20, this.mWidgetParams.detailConfig.getFreeSet(), this.mDrawAdPositions, new IApiCallback<DramaFeedRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailPresenter.1
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaFeedRsp dramaFeedRsp) {
                DramaDetailPresenter.this.mIsLoading = false;
                List<DramaFeed> data = dramaFeedRsp.getData();
                if (!data.isEmpty()) {
                    DramaDetail firstDramaDetail = DramaFeedRspKt.getFirstDramaDetail(data);
                    DramaDetail lastDramaDetail = DramaFeedRspKt.getLastDramaDetail(data);
                    if (firstDramaDetail != null) {
                        DramaDetailPresenter.this.mMinDramaCursor = firstDramaDetail.getIndex();
                    }
                    if (lastDramaDetail != null) {
                        DramaDetailPresenter.this.mMaxDramaCursor = lastDramaDetail.getIndex();
                    }
                    if (dramaFeedRsp.getDrama() != null) {
                        DramaDetailPresenter.this.mDrama = dramaFeedRsp.getDrama();
                        DramaDetailPresenter.this.mDramaTotal = dramaFeedRsp.getDrama().total;
                    }
                    DramaDetailPresenter.this.mDrama.episodeStatusList = dramaFeedRsp.getEpisodeStatusList();
                    DramaDetailPresenter.this.mNextRecommendDramaId = -1L;
                }
                if (DramaDetailPresenter.this.mView != null) {
                    ((DramaDetailContract.View) DramaDetailPresenter.this.mView).onLoadDrama(0, true, false, data, true, DramaDetailPresenter.this.mDrama, -1L, false);
                }
                DramaDetailPresenter.this.onResponseSuccess(dramaFeedRsp);
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaFeedRsp dramaFeedRsp) {
                DramaDetailPresenter.this.mIsLoading = false;
                if (DramaDetailPresenter.this.mView != null) {
                    ((DramaDetailContract.View) DramaDetailPresenter.this.mView).onLoadDrama(dJXError.code, true, false, null, false, null, -1L, false);
                }
                DramaDetailPresenter.this.onResponseFail(dJXError, dramaFeedRsp);
            }
        });
    }

    private void loadDramaDetail(final boolean z, final boolean z2, int i) {
        int iMax;
        if (this.mView == 0 || this.mIsLoading) {
            return;
        }
        if (z) {
            this.mT2WLog.sendReqBegin();
        }
        int iMin = 20;
        if (z) {
            iMax = Math.max(i - 10, 1);
        } else if (z2) {
            iMax = Math.max(this.mMaxDramaCursor + 1, 1);
        } else {
            iMax = Math.max(this.mMinDramaCursor - 20, 1);
            iMin = Math.min(this.mMinDramaCursor - iMax, 20);
            if (iMin <= 0) {
                ((DramaDetailContract.View) this.mView).onLoadDrama(0, false, false, null, false, null, -1L, false);
                return;
            }
        }
        int i2 = iMin;
        int i3 = iMax;
        this.mIsLoading = true;
        final DramaDetailLoadFromCacheTask dramaDetailLoadFromCacheTask = null;
        if (this.mWidgetParams.detailConfig.getListener() != null) {
            this.mWidgetParams.detailConfig.getListener().onDJXRequestStart(null);
            LG.d(TAG, "onDJXRequestStart");
        }
        if (SettingData.getInstance().isEnableDramaCache()) {
            dramaDetailLoadFromCacheTask = DramaNetCacheManager.INSTANCE.getDramaDetailLoadFromCacheTask(this.mDrama.id, i, new IDramaDetailLoadFromCacheCallback() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailPresenter$$ExternalSyntheticLambda0
                @Override // com.bytedance.sdk.djx.core.business.budrama.detail.IDramaDetailLoadFromCacheCallback
                public final void onLoadComplete(DramaDetail dramaDetail) {
                    this.f$0.m356x6db3cb95(dramaDetail);
                }
            });
            ((DramaDetailContract.View) this.mView).setLoadCacheTask(dramaDetailLoadFromCacheTask);
        }
        ApiManager.getInstance().dramaDetail(this.mDrama.id, i3, i2, this.mWidgetParams.detailConfig.getFreeSet(), this.mDrawAdPositions, new IApiCallback<DramaFeedRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailPresenter.2
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaFeedRsp dramaFeedRsp) {
                boolean z3 = false;
                DramaDetailPresenter.this.mIsLoading = false;
                List<DramaFeed> data = dramaFeedRsp.getData();
                if (!data.isEmpty()) {
                    DramaDetail firstDramaDetail = DramaFeedRspKt.getFirstDramaDetail(data);
                    DramaDetail lastDramaDetail = DramaFeedRspKt.getLastDramaDetail(data);
                    if (dramaFeedRsp.getDrama() != null) {
                        DramaDetailPresenter.this.mDrama = dramaFeedRsp.getDrama();
                        DramaDetailPresenter.this.mDramaTotal = dramaFeedRsp.getDrama().total;
                    }
                    if (z) {
                        if (firstDramaDetail != null) {
                            DramaDetailPresenter.this.mMinDramaCursor = firstDramaDetail.getIndex();
                        }
                        if (lastDramaDetail != null) {
                            DramaDetailPresenter.this.mMaxDramaCursor = lastDramaDetail.getIndex();
                        }
                        DramaDetailPresenter.this.mDrama.episodeStatusList = dramaFeedRsp.getEpisodeStatusList();
                    } else {
                        if (firstDramaDetail != null) {
                            if (DramaDetailPresenter.this.mMinDramaCursor <= 0) {
                                DramaDetailPresenter.this.mMinDramaCursor = firstDramaDetail.getIndex();
                            } else {
                                DramaDetailPresenter.this.mMinDramaCursor = Math.min(firstDramaDetail.getIndex(), DramaDetailPresenter.this.mMinDramaCursor);
                            }
                        }
                        if (lastDramaDetail != null) {
                            DramaDetailPresenter.this.mMaxDramaCursor = Math.max(lastDramaDetail.getIndex(), DramaDetailPresenter.this.mMaxDramaCursor);
                        }
                    }
                    if (lastDramaDetail != null) {
                        DramaDetailPresenter.this.mNextRecommendDramaId = lastDramaDetail.getNextRecommendSkitId();
                    }
                    if (DramaDetailPresenter.this.mView != null) {
                        long nextRecommendSkitId = lastDramaDetail != null ? lastDramaDetail.getNextRecommendSkitId() : -1L;
                        DramaDetailLoadFromCacheTask dramaDetailLoadFromCacheTask2 = dramaDetailLoadFromCacheTask;
                        if (dramaDetailLoadFromCacheTask2 != null) {
                            if (dramaDetailLoadFromCacheTask2.getStatus() == CacheStatus.SUCCESS) {
                                z3 = true;
                            } else {
                                dramaDetailLoadFromCacheTask.cancel();
                            }
                        }
                        ((DramaDetailContract.View) DramaDetailPresenter.this.mView).onLoadDrama(0, z, z2, data, false, DramaDetailPresenter.this.mDrama, nextRecommendSkitId, z3);
                    }
                }
                DramaDetailPresenter.this.onResponseSuccess(dramaFeedRsp);
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaFeedRsp dramaFeedRsp) {
                DramaDetailPresenter.this.mIsLoading = false;
                if (DramaDetailPresenter.this.mView != null) {
                    ((DramaDetailContract.View) DramaDetailPresenter.this.mView).onLoadDrama(dJXError.code, z, z2, null, false, null, -1L, false);
                }
                DramaDetailPresenter.this.onResponseFail(dJXError, dramaFeedRsp);
            }
        });
    }

    /* renamed from: lambda$loadDramaDetail$0$com-bytedance-sdk-djx-core-business-budrama-detail-DramaDetailPresenter, reason: not valid java name */
    /* synthetic */ void m356x6db3cb95(DramaDetail dramaDetail) {
        if (dramaDetail == null || this.mView == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(dramaDetail);
        Drama drama = dramaDetail.getDrama();
        this.mDrama = drama;
        drama.episodeStatusList = dramaDetail.getDrama().episodeStatusList;
        ((DramaDetailContract.View) this.mView).onLoadDrama(0, true, false, arrayList, false, this.mDrama, -1L, false);
    }

    public void unlockDrama(int i, int i2, int i3, final boolean z, final IContinuesDialogCallBack iContinuesDialogCallBack) {
        DramaApi.postDramaAdUnlock(this.mDrama, i, i2, i3, new IApiCallback<DramaUnlockRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailPresenter.3
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaUnlockRsp dramaUnlockRsp) {
                if (DramaDetailPresenter.this.mView != null) {
                    if (dramaUnlockRsp.getData() == null) {
                        ((DramaDetailContract.View) DramaDetailPresenter.this.mView).onUnlockDrama(-3, -1, null);
                        LG.e(DramaDetailPresenter.TAG, "onApiSuccess but response is NULL");
                        return;
                    }
                    DramaUnlockModel data = dramaUnlockRsp.getData();
                    int lockSet = data.getLockSet();
                    DramaDetailPresenter.this.mLockSet = lockSet;
                    List<Integer> unlockIndexList = data.getUnlockIndexList();
                    DramaDetailPresenter.this.mUnlockList = unlockIndexList;
                    if (!z || !SettingData.getInstance().getConsecutiveUnlockingEnable()) {
                        ((DramaDetailContract.View) DramaDetailPresenter.this.mView).onUnlockDrama(0, lockSet, unlockIndexList);
                    } else {
                        iContinuesDialogCallBack.showContinuesDialog(data);
                    }
                }
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaUnlockRsp dramaUnlockRsp) {
                LG.e(DramaDetailPresenter.TAG, "onApiFailure: msg = " + dJXError);
                if (DramaDetailPresenter.this.mView != null) {
                    ((DramaDetailContract.View) DramaDetailPresenter.this.mView).onUnlockDrama(dJXError.code, -1, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResponseFail(DJXError dJXError, DramaFeedRsp dramaFeedRsp) {
        if (this.mWidgetParams.detailConfig.getListener() == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(g.o, dJXError.requestId);
        map.put("sub_code", dJXError.subCode);
        map.put("msg", dJXError.msg);
        map.put("code", Integer.valueOf(dJXError.code));
        if (dramaFeedRsp == null) {
            this.mWidgetParams.detailConfig.getListener().onDJXRequestFail(dJXError.code, dJXError.msg, null);
            LG.d(TAG, "onDJXRequestFail: code = " + dJXError);
        } else {
            if (TextUtils.isEmpty(dJXError.requestId)) {
                map.put(g.o, dramaFeedRsp.getRequestId());
            }
            this.mWidgetParams.detailConfig.getListener().onDJXRequestFail(dJXError.code, dJXError.msg, map);
            LG.d(TAG, "onDJXRequestFail: code = " + dJXError + ", map = " + map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResponseSuccess(DramaFeedRsp dramaFeedRsp) {
        List<DramaFeed> data;
        if (this.mWidgetParams.detailConfig.getListener() == null) {
            return;
        }
        if (dramaFeedRsp == null) {
            this.mWidgetParams.detailConfig.getListener().onDJXRequestFail(-3, ErrCode.msg(-3), null);
            LG.d(TAG, "onDJXRequestFail: code = -3, msg = " + ErrCode.msg(-3));
            return;
        }
        try {
            data = dramaFeedRsp.getData();
        } catch (Exception e) {
            e.printStackTrace();
            data = null;
        }
        if (data == null || data.isEmpty()) {
            this.mWidgetParams.detailConfig.getListener().onDJXRequestFail(-3, ErrCode.msg(-3), null);
            LG.d(TAG, "onDJXRequestFail: code = -3, msg = " + ErrCode.msg(-3));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (DramaFeed dramaFeed : data) {
            if (dramaFeed instanceof DramaDetail) {
                Map<String, Object> mapCreateParamsMap = DramaDetailHelper.createParamsMap((DramaDetail) dramaFeed, this.mDrama);
                mapCreateParamsMap.put(g.o, dramaFeedRsp.getRequestId());
                arrayList.add(mapCreateParamsMap);
            }
        }
        this.mWidgetParams.detailConfig.getListener().onDJXRequestSuccess(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            LG.d(TAG, "onDJXRequestSuccess i = " + i + ", map = " + ((Map) arrayList.get(i)).toString());
        }
    }
}
