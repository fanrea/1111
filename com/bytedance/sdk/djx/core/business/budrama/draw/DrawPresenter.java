package com.bytedance.sdk.djx.core.business.budrama.draw;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.g;
import com.bytedance.sdk.djx.DJXSdk;
import com.bytedance.sdk.djx.core.api.ApiManager;
import com.bytedance.sdk.djx.core.api.req.FeedReqParams;
import com.bytedance.sdk.djx.core.api.rsp.FeedRsp;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdLog;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.ad.AdSdkInitManager;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.core.business.base.PresenterAbstract;
import com.bytedance.sdk.djx.core.business.budrama.draw.DrawContract;
import com.bytedance.sdk.djx.core.business.reporter.DrawReporter;
import com.bytedance.sdk.djx.core.log.T2WLog;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.core.util.DJXToolUtil;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.Feed;
import com.bytedance.sdk.djx.model.ev.BEAdCome;
import com.bytedance.sdk.djx.net.api.BaseRsp;
import com.bytedance.sdk.djx.net.api.ErrCode;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.params.DJXWidgetDrawParams;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.WeakHandler;
import com.bytedance.sdk.djx.utils.bus.BusEvent;
import com.bytedance.sdk.djx.utils.bus.DJXBus;
import com.bytedance.sdk.djx.utils.bus.IBusListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class DrawPresenter extends PresenterAbstract<DrawContract.View> implements DrawContract.Presenter, WeakHandler.IHandler {
    private static final String TAG = "DrawPresenter";
    private static final int WHAT_MSG_FIRST_AD = 1;
    private AdKey mAdKey;
    private AdKey mAdKeyFullScreenInterstitial;
    private AdKey mAdKeyHalfScreenInterstitial;
    private AdKey mAdKeyInterstitialPost;
    private String mCategory;
    private String mCodeId;
    private Map<String, Object> mCommonParams;
    private FirstFeed mFirstFeed;
    private JSONArray mPreloadIds;
    private String mRefreshAdPos;
    private int mRefreshDataCount;
    private int mRefreshPage;
    private String mRefreshReqId;
    private long mRootGid;
    private T2WLog mT2WLog;
    private DJXWidgetDrawParams mWidgetParams;
    private boolean mIsFirstAd = true;
    private boolean mIsSecondAd = true;
    private boolean mIsLoading = false;
    private int mCountAd = 0;
    private int mAdIndex = -1;
    private boolean mIsFirstRequest = true;
    private boolean mHasMore = true;
    private boolean mWaitAdSdkInit = false;
    private int mRootGidPage = 0;
    private final WeakHandler mHandler = new WeakHandler(Looper.getMainLooper(), this);
    private final IBusListener mBusListener = new IBusListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawPresenter.2
        public void onBusEvent(BusEvent busEvent) {
            if (busEvent instanceof BEAdCome) {
                BEAdCome bEAdCome = (BEAdCome) busEvent;
                if (DrawPresenter.this.mCodeId == null || !DrawPresenter.this.mCodeId.equals(bEAdCome.getCodeId())) {
                    return;
                }
                DrawPresenter.this.mHandler.removeMessages(1);
                DJXBus.getInstance().removeListener(this);
                DrawPresenter.this.mHandler.sendEmptyMessage(1);
            }
        }
    };

    DrawPresenter() {
    }

    static /* synthetic */ int access$1108(DrawPresenter drawPresenter) {
        int i = drawPresenter.mRootGidPage;
        drawPresenter.mRootGidPage = i + 1;
        return i;
    }

    public void setAdKey(AdKey adKey, AdKey adKey2, AdKey adKey3, AdKey adKey4) {
        this.mAdKey = adKey;
        if (adKey != null) {
            this.mCodeId = adKey.getCodeId();
        }
        this.mAdKeyInterstitialPost = adKey2;
        this.mAdKeyHalfScreenInterstitial = adKey3;
        this.mAdKeyFullScreenInterstitial = adKey4;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void setParams(DJXWidgetDrawParams dJXWidgetDrawParams) {
        this.mWidgetParams = dJXWidgetDrawParams;
    }

    public void setT2Log(T2WLog t2WLog) {
        this.mT2WLog = t2WLog;
    }

    public void setCommonParams(Map<String, Object> map) {
        this.mCommonParams = map;
    }

    public void setRootGroupId(long j) {
        this.mRootGid = j;
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawContract.Presenter
    public void loadMore(boolean z) {
        if (this.mHasMore) {
            load(false, false, z);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawContract.Presenter
    public void loadRefresh(boolean z) {
        if (!AdSdkInitManager.inst().needWaitSdkInit()) {
            if (!DJXSdk.isStartSuccess()) {
                showLoading(true);
                LG.e(TAG, "loadRefresh: sdk not start");
                return;
            } else {
                load(true, z, false);
                this.mWaitAdSdkInit = false;
                AdSdkInitManager.inst().reportInitDelayDuration();
                LG.d(TAG, "loadRefresh: no need wait");
                return;
            }
        }
        AdSdkInitManager.inst().setStartTime(SystemClock.elapsedRealtime());
        LG.d(TAG, "loadRefresh: need wait");
        this.mWaitAdSdkInit = true;
    }

    public void showLoading(Boolean bool) {
        if (this.mView != 0) {
            ((DrawContract.View) this.mView).setLoading(bool.booleanValue());
            this.mIsLoading = bool.booleanValue();
        }
    }

    public void loadRefreshAfterInit() {
        if (this.mWaitAdSdkInit) {
            loadRefresh(false);
            this.mWaitAdSdkInit = false;
            LG.d(TAG, "loadRefreshAfterInit: restart refresh");
            return;
        }
        LG.d(TAG, "loadRefreshAfterInit: no need refresh");
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    private void load(final boolean z, boolean z2, final boolean z3) {
        String string;
        if (this.mView == 0) {
            return;
        }
        if (!z && !z3) {
            ((DrawContract.View) this.mView).setLoading(true);
        }
        if (this.mIsLoading) {
            return;
        }
        if (z && !z3) {
            this.mT2WLog.sendReqBegin();
        }
        this.mIsLoading = true;
        DJXWidgetDrawParams dJXWidgetDrawParams = this.mWidgetParams;
        if (dJXWidgetDrawParams != null && dJXWidgetDrawParams.mListener != null) {
            this.mWidgetParams.mListener.onDJXRequestStart(null);
            LG.d(TAG, "onDJXRequestStart");
        }
        String str = this.mIsFirstRequest ? FeedReqParams.REQ_TYPE_OPEN : z ? "refresh" : FeedReqParams.REQ_TYPE_LOAD_MORE;
        String token = AdManager.inst().getToken(this.mAdKey);
        JSONArray jSONArray = this.mPreloadIds;
        if (jSONArray == null || jSONArray.length() <= 0) {
            string = null;
        } else {
            string = this.mPreloadIds.toString();
            this.mPreloadIds = null;
        }
        String token2 = SettingData.getInstance().getAdHalfScreenInterstitialAwake() != -1 ? AdManager.inst().getToken(this.mAdKeyHalfScreenInterstitial) : null;
        String token3 = SettingData.getInstance().getAdFullScreenInterstitialAwake() != -1 ? AdManager.inst().getToken(this.mAdKeyFullScreenInterstitial) : null;
        String token4 = SettingData.getInstance().getAdInterstitialPostAwake() != -1 ? AdManager.inst().getToken(this.mAdKeyInterstitialPost) : null;
        boolean z4 = this.mIsFirstRequest;
        final boolean z5 = z4 || z;
        if (z5) {
            this.mRefreshPage = 0;
            this.mRefreshReqId = null;
            this.mRefreshAdPos = null;
            this.mRefreshDataCount = z4 ? ((DrawContract.View) this.mView).getAdapterCount() : 0;
            if (this.mIsFirstRequest && ((DrawContract.View) this.mView).getAdapterCount() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ((DrawContract.View) this.mView).getAdapterCount(); i++) {
                    Object adapterItem = ((DrawContract.View) this.mView).getAdapterItem(i);
                    if ((adapterItem instanceof Feed) && ((Feed) adapterItem).isType4Ad()) {
                        sb.append(i).append(",");
                    }
                }
                String string2 = sb.toString();
                this.mRefreshAdPos = string2;
                if (string2.endsWith(",")) {
                    String str2 = this.mRefreshAdPos;
                    this.mRefreshAdPos = str2.substring(0, str2.length() - 1);
                }
            }
        } else {
            this.mRefreshPage++;
            this.mRefreshDataCount = ((DrawContract.View) this.mView).getAdapterCount();
        }
        DrawReporter.reportAdRequestEngine(this.mCategory);
        ApiManager.getInstance().feed(new IApiCallback<FeedRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawPresenter.1
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(FeedRsp feedRsp) {
                int i2 = 0;
                if (DrawPresenter.this.mView != null) {
                    ((DrawContract.View) DrawPresenter.this.mView).setLoading(false);
                }
                DrawPresenter.this.mIsFirstRequest = false;
                if (feedRsp == null) {
                    DrawPresenter.this.mIsLoading = false;
                    if (DrawPresenter.this.mView != null) {
                        ((DrawContract.View) DrawPresenter.this.mView).onLoadRefresh(-3, z, z3, null);
                    }
                    DrawPresenter.this.onResponseFail(DJXError.build(-3, ErrCode.msg(-3)), null);
                    return;
                }
                Iterator<Feed> it = feedRsp.getData().iterator();
                while (it.hasNext()) {
                    if (it.next().isDelete()) {
                        it.remove();
                    }
                }
                DrawPresenter.this.mHasMore = feedRsp.isHasMore();
                ((DrawContract.View) DrawPresenter.this.mView).setLoadMoreEnable(DrawPresenter.this.mHasMore);
                if (z5) {
                    DrawPresenter.this.mRefreshReqId = feedRsp.getRequestId();
                }
                if (!feedRsp.getData().isEmpty()) {
                    StringBuilder sb2 = new StringBuilder();
                    int adapterCount = z ? 0 : ((DrawContract.View) DrawPresenter.this.mView).getAdapterCount();
                    for (Feed feed : feedRsp.getData()) {
                        if (feed != null) {
                            feed.setRootGidPage(DrawPresenter.this.mRootGidPage);
                            if (feed.isType4Ad()) {
                                sb2.append(adapterCount).append(",");
                            }
                        }
                        adapterCount++;
                    }
                    DrawPresenter.this.mRefreshAdPos = sb2.toString();
                    if (DrawPresenter.this.mRefreshAdPos.endsWith(",")) {
                        DrawPresenter drawPresenter = DrawPresenter.this;
                        drawPresenter.mRefreshAdPos = drawPresenter.mRefreshAdPos.substring(0, DrawPresenter.this.mRefreshAdPos.length() - 1);
                    }
                }
                if (DrawPresenter.this.mRootGid > 0) {
                    DrawPresenter.access$1108(DrawPresenter.this);
                }
                LG.d(DrawPresenter.TAG, "FeedApi.onApiSuccess: " + feedRsp.getData().size());
                if (z) {
                    DrawPresenter.this.mIsFirstAd = true;
                    DrawPresenter.this.mIsSecondAd = true;
                    DrawPresenter.this.mCountAd = 0;
                    DrawPresenter.this.mFirstFeed = null;
                }
                if (!DrawPresenter.this.mIsFirstAd || AdManager.inst().hasAd(DrawPresenter.this.mAdKey, 0)) {
                    DJXBus.getInstance().removeListener(DrawPresenter.this.mBusListener);
                    DrawPresenter.this.mIsLoading = false;
                    if (DrawPresenter.this.mView != null) {
                        ((DrawContract.View) DrawPresenter.this.mView).onLoadRefresh(0, z, z3, DrawPresenter.this.inflateAd(feedRsp.getData()));
                    }
                } else {
                    DrawPresenter.this.mFirstFeed = new FirstFeed(z, z3, feedRsp.getData());
                    DrawPresenter.this.mHandler.sendEmptyMessageDelayed(1, AdSdkInitManager.inst().getDelay4NoMix() + 500);
                }
                List<Feed> data = feedRsp.getData();
                if (data != null && !data.isEmpty()) {
                    Iterator<Feed> it2 = feedRsp.getData().iterator();
                    while (it2.hasNext()) {
                        if (it2.next().isType4Ad()) {
                            i2++;
                        }
                    }
                }
                DrawReporter.reportAdRequestEngineSuccess(DrawPresenter.this.mCategory, i2, feedRsp.getRequestId());
                DrawPresenter.this.onResponseSuccess(feedRsp);
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, FeedRsp feedRsp) {
                LG.d(DrawPresenter.TAG, "FeedApi.onApiFailure: " + dJXError);
                if (DrawPresenter.this.mView != null) {
                    ((DrawContract.View) DrawPresenter.this.mView).setLoading(false);
                }
                DrawPresenter.this.mIsLoading = false;
                if (DrawPresenter.this.mView != null) {
                    ((DrawContract.View) DrawPresenter.this.mView).onLoadRefresh(dJXError.code, z, z3, null);
                }
                DrawPresenter.this.onResponseFail(dJXError, feedRsp);
            }
        }, FeedReqParams.build().requestType(str).adToken(token).adPreloadIds(string).category(this.mCategory).adTokenHalfScreenInterstitial(token2).adTokenFullScreenInterstitial(token3).adTokenPostIt(token4).drawType(this.mWidgetParams.mDrawContentType).dramaFree(this.mWidgetParams.mDramaFree).topDramaId(this.mWidgetParams.mTopDramaId).platformSource(0).rootGid(this.mRootGid, this.mRootGidPage).adRefresh(new FeedReqParams.AdRefresh(this.mRefreshPage, this.mRefreshReqId, this.mRefreshDataCount, this.mRefreshAdPos)).urgeStay(z2 ? "1" : "0"), this.mCommonParams);
    }

    public String getRefreshReqId() {
        return this.mRefreshReqId;
    }

    public List<Object> inflateAd(List<Feed> list) {
        if (list == null) {
            return null;
        }
        if (DJXToolUtil.isMixAdLogic()) {
            return new ArrayList(list);
        }
        int drawFirstAdPos = SettingData.getInstance().getDrawFirstAdPos();
        int drawFollowSep = SettingData.getInstance().getDrawFollowSep();
        int drawFollowAdPos = SettingData.getInstance().getDrawFollowAdPos();
        List<Object> arrayList = new ArrayList<>();
        int i = 0;
        for (Feed feed : list) {
            int i2 = this.mCountAd + 1;
            this.mCountAd = i2;
            this.mAdIndex++;
            boolean z = this.mIsFirstAd;
            if (z && i2 >= drawFirstAdPos) {
                this.mIsFirstAd = false;
                if (AdManager.inst().hasAd(this.mAdKey, i)) {
                    insertAd(arrayList, feed);
                    i++;
                    this.mAdIndex++;
                } else {
                    sendAdFillFail(drawFirstAdPos, drawFollowSep, drawFollowAdPos);
                }
            } else if (!z && this.mIsSecondAd && i2 >= drawFollowAdPos - 1) {
                this.mIsSecondAd = false;
                if (AdManager.inst().hasAd(this.mAdKey, i)) {
                    insertAd(arrayList, feed);
                    i++;
                    this.mAdIndex++;
                } else {
                    sendAdFillFail(drawFirstAdPos, drawFollowSep, drawFollowAdPos);
                }
            } else if (!z && !this.mIsSecondAd && i2 >= drawFollowSep - 1) {
                if (AdManager.inst().hasAd(this.mAdKey, i)) {
                    insertAd(arrayList, feed);
                    i++;
                    this.mAdIndex++;
                } else {
                    sendAdFillFail(drawFirstAdPos, drawFollowSep, drawFollowAdPos);
                }
            }
            arrayList.add(feed);
        }
        return arrayList;
    }

    private void insertAd(List<Object> list, Feed feed) {
        this.mCountAd = 0;
        DJXWidgetDrawParams dJXWidgetDrawParams = this.mWidgetParams;
        String str = dJXWidgetDrawParams == null ? null : dJXWidgetDrawParams.mAdCodeId;
        DJXWidgetDrawParams dJXWidgetDrawParams2 = this.mWidgetParams;
        if (DJXToolUtil.isNativeAd(str, dJXWidgetDrawParams2 != null ? dJXWidgetDrawParams2.mNativeAdCodeId : null)) {
            DrawAdNativeModel drawAdNativeModel = new DrawAdNativeModel();
            drawAdNativeModel.setAdShakeCoverShow(feed.getAdShakeCoverShow());
            list.add(drawAdNativeModel);
            return;
        }
        list.add(new DrawAdModel());
    }

    public void handleMsg(Message message) {
        if (message.what == 1) {
            this.mHandler.removeMessages(1);
            this.mIsLoading = false;
            if (this.mView == 0 || this.mFirstFeed == null) {
                return;
            }
            LG.d(TAG, "FeedApi.onApiSuccess: first ad come");
            ((DrawContract.View) this.mView).onLoadRefresh(0, this.mFirstFeed.mIsRefresh, this.mFirstFeed.mIsPreload, inflateAd(this.mFirstFeed.mData));
            this.mFirstFeed = null;
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.PresenterAbstract, com.bytedance.sdk.djx.core.business.base.BaseContract.BasePresenter
    public void attach(DrawContract.View view) {
        super.attach((DrawPresenter) view);
        DJXBus.getInstance().addListener(this.mBusListener);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.PresenterAbstract, com.bytedance.sdk.djx.core.business.base.BaseContract.BasePresenter
    public void detach() {
        super.detach();
        DJXBus.getInstance().removeListener(this.mBusListener);
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    private static class FirstFeed {
        List<Feed> mData;
        boolean mIsPreload;
        boolean mIsRefresh;

        FirstFeed(boolean z, boolean z2, List<Feed> list) {
            this.mData = list;
            this.mIsPreload = z2;
            this.mIsRefresh = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResponseFail(DJXError dJXError, BaseRsp<List<Feed>> baseRsp) {
        DrawReporter.reportAdRequestEngineFail(this.mCategory, baseRsp == null ? "" : baseRsp.getRequestId(), dJXError.code, dJXError.msg);
        DJXWidgetDrawParams dJXWidgetDrawParams = this.mWidgetParams;
        if (dJXWidgetDrawParams == null || dJXWidgetDrawParams.mListener == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(g.o, dJXError.requestId);
        map.put("sub_code", dJXError.subCode);
        map.put("msg", dJXError.msg);
        map.put("code", Integer.valueOf(dJXError.code));
        if (baseRsp == null) {
            this.mWidgetParams.mListener.onDJXRequestFail(dJXError.code, dJXError.msg, map);
            LG.d(TAG, "onDJXRequestFail: code = " + dJXError);
        } else {
            if (TextUtils.isEmpty(dJXError.requestId)) {
                map.put(g.o, baseRsp.getRequestId());
            }
            this.mWidgetParams.mListener.onDJXRequestFail(dJXError.code, dJXError.msg, map);
            LG.d(TAG, "onDJXRequestFail: code = " + dJXError + ", map = " + map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResponseSuccess(BaseRsp<List<Feed>> baseRsp) {
        List<Feed> data;
        DJXWidgetDrawParams dJXWidgetDrawParams = this.mWidgetParams;
        if (dJXWidgetDrawParams == null || dJXWidgetDrawParams.mListener == null) {
            return;
        }
        if (baseRsp == null) {
            this.mWidgetParams.mListener.onDJXRequestFail(-3, ErrCode.msg(-3), null);
            LG.d(TAG, "onDJXRequestFail: code = -3, msg = " + ErrCode.msg(-3));
            return;
        }
        try {
            data = baseRsp.getData();
        } catch (Exception e) {
            e.printStackTrace();
            data = null;
        }
        if (data == null || data.isEmpty()) {
            this.mWidgetParams.mListener.onDJXRequestFail(-3, ErrCode.msg(-3), null);
            LG.d(TAG, "onDJXRequestFail: code = -3, msg = " + ErrCode.msg(-3));
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Feed feed : data) {
            map.put(g.o, baseRsp.getRequestId());
            map.put("group_id", Long.valueOf(feed.getGroupId()));
            map.put("title", feed.getTitle());
            map.put("video_duration", Integer.valueOf(feed.getVideoDuration()));
            map.put("video_size", Long.valueOf(feed.getVideoSize()));
            map.put("category", Integer.valueOf(feed.getCategory()));
            map.put("content_type", feed.getContentType());
            map.put("is_stick", Boolean.valueOf(feed.isStick()));
            map.put("cover_list", feed.getCoverImages());
            arrayList.add(map);
            map = new HashMap();
        }
        this.mWidgetParams.mListener.onDJXRequestSuccess(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            LG.d(TAG, "onDJXRequestSuccess i = " + i + ", map = " + ((Map) arrayList.get(i)).toString());
        }
    }

    private void sendAdFillFail(int i, int i2, int i3) {
        AdLog.getInstance().sendAdFillFail(this.mAdKey, i, i2, i3, this.mAdIndex);
        DJXWidgetDrawParams dJXWidgetDrawParams = this.mWidgetParams;
        if (dJXWidgetDrawParams == null || dJXWidgetDrawParams.mAdListener == null || this.mAdKey == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(IDJXAd.AD_CODE_ID, this.mAdKey.getCodeId());
        map.put("ad_first_pos", Integer.valueOf(i));
        map.put("ad_follow_sep", Integer.valueOf(i2));
        map.put("ad_follow_pos", Integer.valueOf(i3));
        this.mWidgetParams.mAdListener.onDJXAdFillFail(map);
    }
}
