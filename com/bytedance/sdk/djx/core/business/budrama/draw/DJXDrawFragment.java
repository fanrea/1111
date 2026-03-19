package com.bytedance.sdk.djx.core.business.budrama.draw;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.sdk.djx.DJXPlaySpeedScope;
import com.bytedance.sdk.djx.DJXToastType;
import com.bytedance.sdk.djx.base.dynamic.DynamicManager;
import com.bytedance.sdk.djx.core.act.DJXGlobalReceiver;
import com.bytedance.sdk.djx.core.act.GRListener;
import com.bytedance.sdk.djx.core.api.req.FeedApi;
import com.bytedance.sdk.djx.core.business.ActiveLog;
import com.bytedance.sdk.djx.core.business.SpeedPlayManager;
import com.bytedance.sdk.djx.core.business.SpeedScopeType;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.base.FragMvpProxy;
import com.bytedance.sdk.djx.core.business.base.FragProxy;
import com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment;
import com.bytedance.sdk.djx.core.business.budrama.draw.DrawAdapter2;
import com.bytedance.sdk.djx.core.business.budrama.draw.DrawContract;
import com.bytedance.sdk.djx.core.business.buguide.DJXDrawGuideView;
import com.bytedance.sdk.djx.core.business.bureport.DJXReportFragment;
import com.bytedance.sdk.djx.core.business.bureport.DJXReportParams;
import com.bytedance.sdk.djx.core.business.reporter.DrawReporter;
import com.bytedance.sdk.djx.core.business.view.DJXErrorView;
import com.bytedance.sdk.djx.core.business.view.VerticalViewPager;
import com.bytedance.sdk.djx.core.business.view.loading.DJXDmtLoadingLayout;
import com.bytedance.sdk.djx.core.business.view.refresh.DJXEmptyRefreshView;
import com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout;
import com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout2;
import com.bytedance.sdk.djx.core.business.view.share.DJXShareDialog;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.log.SdkTLog;
import com.bytedance.sdk.djx.core.log.T2WLog;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.core.util.DJXToolUtil;
import com.bytedance.sdk.djx.core.util.GuideHelper;
import com.bytedance.sdk.djx.core.util.ToastUtil;
import com.bytedance.sdk.djx.core.vod.IVideoService;
import com.bytedance.sdk.djx.core.vod.render.MeasureHelper;
import com.bytedance.sdk.djx.model.DJXDramaUnlockAdMode;
import com.bytedance.sdk.djx.model.Feed;
import com.bytedance.sdk.djx.model.VideoM;
import com.bytedance.sdk.djx.model.ev.BEAdSdkInit;
import com.bytedance.sdk.djx.model.ev.BEDJXSdkInit;
import com.bytedance.sdk.djx.model.ev.BEDismissOuterLoadingEvent;
import com.bytedance.sdk.djx.model.ev.BEDrawVideoLoad;
import com.bytedance.sdk.djx.model.ev.BEGlobalSpeedUpdate;
import com.bytedance.sdk.djx.model.ev.BESettingUpdate;
import com.bytedance.sdk.djx.model.ev.BEVideoChange;
import com.bytedance.sdk.djx.net.ImageTag;
import com.bytedance.sdk.djx.params.DJXWidgetDrawParams;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.NetworkUtils;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.bytedance.sdk.djx.utils.WeakHandler;
import com.bytedance.sdk.djx.utils.bus.BusEvent;
import com.bytedance.sdk.djx.utils.bus.DJXBus;
import com.bytedance.sdk.djx.utils.bus.IBusListener;
import com.bytedance.sdk.djx.utils.debug.DebugInfo;
import com.bytedance.sdk.djx.utils.service.ServiceManager;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDrawFragment extends FragMvpProxy<DrawPresenter> implements DrawContract.View, WeakHandler.IHandler {
    private static final String TAG = "DJXDrawFragment";
    private static final int WHAT_MSG_NETWORK_DISCONNECTED = 101;
    private static final int WHAT_MSG_PLAY_3S = 100;
    public static int sRealScreenHeightPixels = -1;
    public static int sRealScreenWidthPixels = -1;
    private ActiveLog mActiveLog;
    private AdKey mAdKey;
    private AdKey mAdKeyFullScreenInterstitial;
    private AdKey mAdKeyHalfScreenInterstitial;
    private AdKey mAdKeyInterstitial;
    private AdKey mAdKeyInterstitialPost;
    private DrawAdapter2 mAdapter;
    private String mCategory;
    private DJXErrorView mDJXErrorView;
    private TextView mDebugTextView;
    private DJXDrawBoxFragment.IDrawBoxListener mDrawBoxListener;
    private long mEnterTime;
    private Feed mFirstFeed;
    private DJXDrawGuideView mGuideView;
    private boolean mIsUserVisible;
    private DJXDmtLoadingLayout mLoadingLayout;
    private int mPosition;
    private Feed mPreloadFeed;
    private DJXRefreshLayout2 mRefreshLayout;
    private DJXReportFragment mReportFragment;
    private long mRootGid;
    private DJXShareDialog mShareDialog;
    private VerticalViewPager mViewPager;
    private DJXWidgetDrawParams mWidgetParams;
    private boolean mIsReportShow = false;
    private boolean mIsPlayFirst = true;
    private boolean mIsPlayCache = false;
    private boolean mHasDelCache = false;
    private boolean mCacheByNetErr = false;
    private boolean mHasRenderFirst = false;
    private final List<Feed> mCachedVideos = new ArrayList();
    private final WeakHandler mHandler = new WeakHandler(Looper.getMainLooper(), this);
    private final DrawLog mDrawLog = new DrawLog();
    private final SdkTLog mTLog = new SdkTLog();
    private final Map<String, Object> mCommonParams = new HashMap();
    private long mStartTime = -1;
    private final GuideHelper mGuideHelper = GuideHelper.getInstance();
    private final SettingData mSettingData = SettingData.getInstance();
    private final HashSet<String> mWatchedVideoSet = new HashSet<>();
    private SpeedPlayManager mSpeedPlayManager = new SpeedPlayManager();
    private final IBusListener mBusListener = new IBusListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawFragment.1
        public void onBusEvent(BusEvent busEvent) {
            if (busEvent instanceof BEAdSdkInit) {
                if (DJXDrawFragment.this.mPresenter != null) {
                    ((DrawPresenter) DJXDrawFragment.this.mPresenter).loadRefreshAfterInit();
                    return;
                }
                return;
            }
            if (busEvent instanceof BEDismissOuterLoadingEvent) {
                if (DJXDrawFragment.this.mLoadingLayout != null) {
                    DJXDrawFragment.this.mLoadingLayout.setVisibility(4);
                    return;
                }
                return;
            }
            if (busEvent instanceof BEDrawVideoLoad) {
                BEDrawVideoLoad bEDrawVideoLoad = (BEDrawVideoLoad) busEvent;
                if (bEDrawVideoLoad.getPosition() == DJXDrawFragment.this.mViewPager.getCurrentItem()) {
                    if (bEDrawVideoLoad.isRetry()) {
                        DJXDrawFragment.this.mT2WLog.setVideoRetryNum(DJXDrawFragment.this.mT2WLog.getVideoRetryNum() + 1);
                    }
                    DJXDrawFragment.this.mT2WLog.sendLoad(bEDrawVideoLoad.getPosition());
                    return;
                }
                return;
            }
            if ((busEvent instanceof BEDJXSdkInit) && DJXDrawFragment.this.mPresenter != null && ((BEDJXSdkInit) busEvent).isSuccess && ((DrawPresenter) DJXDrawFragment.this.mPresenter).isLoading()) {
                ((DrawPresenter) DJXDrawFragment.this.mPresenter).showLoading(false);
                DJXDrawFragment.this.mT2WLog.setReqRetryNum(DJXDrawFragment.this.mT2WLog.getReqRetryNum() + 1);
                ((DrawPresenter) DJXDrawFragment.this.mPresenter).loadRefresh(false);
            }
        }
    };
    private String mCachePlayReason = ILogConst.CACHE_PLAY_REASON_NULL;
    private boolean mHasReportPlayFirst = false;
    private long mUIRenderStartTime = -1;
    private boolean mHasSendPlayMsg = false;
    private final T2WLog mT2WLog = new T2WLog("draw");
    private final boolean mUpdateVideoList = false;
    private final DataSetObserver mDataSetObserver = new DataSetObserver() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawFragment.8
        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (DJXDrawFragment.this.mAdapter == null || DJXDrawFragment.this.getMyActivity() == null || DJXDrawFragment.this.getMyActivity().isFinishing()) {
                return;
            }
            if (DJXDrawFragment.this.mAdapter.getCount() > 0) {
                DJXDrawFragment.this.mLoadingLayout.setVisibility(4);
            } else {
                DJXDrawFragment.this.mLoadingLayout.setVisibility(0);
            }
            DJXDrawFragment.this.resetVodPreload();
        }
    };
    private final GRListener mNetChangedListener = new GRListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawFragment.9
        @Override // com.bytedance.sdk.djx.core.act.GRListener
        public void onNetChanged(int i, int i2) {
            if (!NetworkUtils.isActive(DJXDrawFragment.this.getContext())) {
                if (i != 0) {
                    DJXDrawFragment.this.mDJXErrorView.show(false);
                } else if (DJXDrawFragment.this.mAdapter != null && DJXDrawFragment.this.mAdapter.getCount() <= 0) {
                    LG.d(DJXDrawFragment.TAG, "mAdapter count = 0");
                    DJXDrawFragment.this.mDJXErrorView.show(true);
                }
                DJXDrawFragment.this.mHandler.sendEmptyMessageDelayed(101, 2000L);
                return;
            }
            DJXDrawFragment.this.mHandler.removeMessages(101);
            if (DJXDrawFragment.this.mCacheByNetErr) {
                DJXDrawFragment.this.mCacheByNetErr = !NetworkUtils.isStrongNetwork(i2);
                if (!DJXDrawFragment.this.mHasDelCache && i != i2) {
                    ((DrawPresenter) DJXDrawFragment.this.mPresenter).loadMore(true);
                }
            }
            DJXDrawFragment.this.mDJXErrorView.show(false);
            if (i2 != 1) {
                DJXDrawFragment dJXDrawFragment = DJXDrawFragment.this;
                dJXDrawFragment.toastCenter(dJXDrawFragment.getResources().getString(R.string.djx_str_no_wifi_tip));
            }
            if (i == i2 || DJXDrawFragment.this.mAdapter == null || DJXDrawFragment.this.mAdapter.getCount() > 0 || !NetworkUtils.isActive(DJXDrawFragment.this.getContext())) {
                return;
            }
            ((DrawPresenter) DJXDrawFragment.this.mPresenter).loadRefresh(false);
        }
    };
    private final IBusListener mConfigBusListener = new IBusListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawFragment.10
        public void onBusEvent(BusEvent busEvent) {
            if (busEvent instanceof BESettingUpdate) {
                DJXDrawFragment.this.resetCategory();
                return;
            }
            if (busEvent instanceof BEGlobalSpeedUpdate) {
                DJXDrawFragment.this.mSpeedPlayManager.updateGlobalSpeed();
                DJXDrawFragment dJXDrawFragment = DJXDrawFragment.this;
                HolderBase holderByPosition = dJXDrawFragment.getHolderByPosition(dJXDrawFragment.mPosition);
                if (holderByPosition instanceof DrawHolderDrama) {
                    ((DrawHolderDrama) holderByPosition).setSpeed(DJXDrawFragment.this.mSpeedPlayManager.getGlobalSpeed(), SpeedScopeType.GLOBAL);
                }
            }
        }
    };

    public static int getBottomOffset(int i) {
        return i;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.BaseContract.BaseView
    public void showError() {
    }

    public void setWidgetParams(DJXWidgetDrawParams dJXWidgetDrawParams) {
        this.mWidgetParams = dJXWidgetDrawParams;
    }

    public void setDrawBoxListener(DJXDrawBoxFragment.IDrawBoxListener iDrawBoxListener) {
        this.mDrawBoxListener = iDrawBoxListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.djx.core.business.base.FragMvpProxy
    public DrawPresenter bindPresenter() {
        DrawPresenter drawPresenter = new DrawPresenter();
        drawPresenter.setParams(this.mWidgetParams);
        drawPresenter.setT2Log(this.mT2WLog);
        drawPresenter.setAdKey(this.mAdKey, this.mAdKeyInterstitialPost, this.mAdKeyHalfScreenInterstitial, this.mAdKeyFullScreenInterstitial);
        drawPresenter.setCategory(this.mCategory);
        drawPresenter.setCommonParams(null);
        drawPresenter.setRootGroupId(this.mRootGid);
        return drawPresenter;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected Object getLayoutId() {
        return Integer.valueOf(R.layout.djx_frag_draw);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mT2WLog.sendInit();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void initData(Bundle bundle) {
        List<Feed> feedList;
        DJXBus.getInstance().addListener(this.mBusListener);
        resetCategory();
        if (this.mActiveLog == null) {
            getDrawType();
            this.mActiveLog = new ActiveLog(this.mContentView, this.mCategory, "skit_mixed_feed", null);
        }
        DJXWidgetDrawParams dJXWidgetDrawParams = this.mWidgetParams;
        if (!(dJXWidgetDrawParams != null && dJXWidgetDrawParams.mDrawContentType == 1) && (feedList = DrawPreload2.getInstance().getFeedList()) != null) {
            this.mCachedVideos.addAll(feedList);
        }
        this.mCommonParams.put("page_scene", "home_page");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetCategory() {
        this.mCategory = "hotsoon_video_detail_draw";
        AdKey adKey = this.mAdKey;
        if (adKey != null) {
            adKey.category("hotsoon_video_detail_draw");
        }
        AdKey adKey2 = this.mAdKeyHalfScreenInterstitial;
        if (adKey2 != null) {
            adKey2.category(this.mCategory);
        }
        AdKey adKey3 = this.mAdKeyFullScreenInterstitial;
        if (adKey3 != null) {
            adKey3.category(this.mCategory);
        }
        AdKey adKey4 = this.mAdKeyInterstitialPost;
        if (adKey4 != null) {
            adKey4.category(this.mCategory);
        }
        if (this.mPresenter != 0) {
            ((DrawPresenter) this.mPresenter).setCategory(this.mCategory);
            ((DrawPresenter) this.mPresenter).setAdKey(this.mAdKey, this.mAdKeyInterstitialPost, this.mAdKeyHalfScreenInterstitial, this.mAdKeyFullScreenInterstitial);
        }
        DrawAdapter2 drawAdapter2 = this.mAdapter;
        if (drawAdapter2 != null) {
            drawAdapter2.setCategory(this.mCategory);
            this.mAdapter.setAdKey(this.mAdKey, this.mAdKeyInterstitialPost, this.mAdKeyHalfScreenInterstitial, this.mAdKeyFullScreenInterstitial);
        }
        ActiveLog activeLog = this.mActiveLog;
        if (activeLog != null) {
            activeLog.setCategory(this.mCategory);
        }
        this.mDrawLog.reset();
        this.mDrawLog.setParams(this.mCategory, null, getFeatureValues());
    }

    private String getFeatureValues() {
        return FeedApi.getFeatureValues(this.mCategory, getDrawType());
    }

    private void initAdData() {
        int i;
        int iHashCode;
        DJXWidgetDrawParams dJXWidgetDrawParams = this.mWidgetParams;
        String str = dJXWidgetDrawParams == null ? "" : dJXWidgetDrawParams.mAdCodeId;
        DJXWidgetDrawParams dJXWidgetDrawParams2 = this.mWidgetParams;
        String str2 = dJXWidgetDrawParams2 != null ? dJXWidgetDrawParams2.mNativeAdCodeId : "";
        DJXWidgetDrawParams dJXWidgetDrawParams3 = this.mWidgetParams;
        if ((dJXWidgetDrawParams3 != null && dJXWidgetDrawParams3.mDrawContentType == 1) || DJXToolUtil.isNativeAd(str, str2)) {
            String str3 = str2;
            i = 4;
            str = str3;
        } else {
            i = 1;
        }
        DJXWidgetDrawParams dJXWidgetDrawParams4 = this.mWidgetParams;
        if (dJXWidgetDrawParams4 != null) {
            int i2 = dJXWidgetDrawParams4.mAdOffset;
            iHashCode = this.mWidgetParams.hashCode();
        } else {
            iHashCode = 0;
        }
        Map<String, Object> mapConstructAdCommonParams = constructAdCommonParams();
        this.mAdKey = AdKey.obtain().codeId(str).paramsCode(iHashCode).adType("draw").adCategory(this.mWidgetParams.mDrawContentType == 1 ? "skit_mixed_feed" : "mixed_feed").category(this.mCategory).width(UIUtil.px2dp(UIUtil.getScreenWidth(InnerManager.getContext()))).commonParams(mapConstructAdCommonParams).featureValues(getFeatureValues());
        AdManager adManagerInst = AdManager.inst();
        AdKey adKey = this.mAdKey;
        DJXWidgetDrawParams dJXWidgetDrawParams5 = this.mWidgetParams;
        adManagerInst.buildAdLoader(i, adKey, dJXWidgetDrawParams5 == null ? null : dJXWidgetDrawParams5.mAdListener);
        AdManager adManagerInst2 = AdManager.inst();
        AdKey adKey2 = this.mAdKey;
        DJXWidgetDrawParams dJXWidgetDrawParams6 = this.mWidgetParams;
        adManagerInst2.buildMixAdLoader(i, adKey2, dJXWidgetDrawParams6 == null ? null : dJXWidgetDrawParams6.mAdListener);
        DynamicManager dynamicManager = DynamicManager.getInstance();
        this.mAdKeyHalfScreenInterstitial = AdKey.obtain().codeId(DynamicManager.getInstance().getDynamicModel().mSmallDrawHalfScreenInterstitialCodeId).commonParams(mapConstructAdCommonParams).paramsCode(iHashCode).width(UIUtil.px2dp(UIUtil.getScreenWidth(getContext()))).featureValues(getFeatureValues()).category(this.mCategory);
        AdManager adManagerInst3 = AdManager.inst();
        AdKey adKey3 = this.mAdKeyHalfScreenInterstitial;
        DJXWidgetDrawParams dJXWidgetDrawParams7 = this.mWidgetParams;
        adManagerInst3.buildMixAdLoader(7, adKey3, dJXWidgetDrawParams7 == null ? null : dJXWidgetDrawParams7.mAdListener);
        this.mAdKeyFullScreenInterstitial = AdKey.obtain().codeId(DynamicManager.getInstance().getDynamicModel().mSmallDrawFullScreenInterstitialCodeId).commonParams(mapConstructAdCommonParams).paramsCode(iHashCode).width(UIUtil.px2dp(UIUtil.getScreenWidth(getContext()))).featureValues(getFeatureValues()).category(this.mCategory);
        AdManager adManagerInst4 = AdManager.inst();
        AdKey adKey4 = this.mAdKeyFullScreenInterstitial;
        DJXWidgetDrawParams dJXWidgetDrawParams8 = this.mWidgetParams;
        adManagerInst4.buildMixAdLoader(7, adKey4, dJXWidgetDrawParams8 == null ? null : dJXWidgetDrawParams8.mAdListener);
        this.mAdKeyInterstitialPost = AdKey.obtain().codeId(dynamicManager.getSmallDrawNoteCodeId()).commonParams(mapConstructAdCommonParams).paramsCode(iHashCode).width((UIUtil.px2dp(UIUtil.getScreenWidth(getContext())) * 2) / 3).featureValues(getFeatureValues()).category(this.mCategory);
        AdManager adManagerInst5 = AdManager.inst();
        AdKey adKey5 = this.mAdKeyInterstitialPost;
        DJXWidgetDrawParams dJXWidgetDrawParams9 = this.mWidgetParams;
        adManagerInst5.buildMixAdLoader(2, adKey5, dJXWidgetDrawParams9 != null ? dJXWidgetDrawParams9.mAdListener : null);
        editAdKey();
        if (DJXToolUtil.isMixAdLogic()) {
            return;
        }
        AdManager.inst().hasAd(this.mAdKey, 0);
    }

    public Map<String, Object> constructAdCommonParams() {
        HashMap map = new HashMap();
        if ((this.mWidgetParams.mDrawContentType & 1) != 0 && this.mWidgetParams.mDetailConfig != null) {
            map.put(ILogConst.Keys.INTERFACE_TYPE, DJXDramaUnlockAdMode.MODE_COMMON.equals(this.mWidgetParams.mDetailConfig.getAdMode()) ? "sdk" : "api");
            map.put(ILogConst.Keys.KEY_MODE, "playet");
        }
        return map;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void initView(View view) throws NoSuchMethodException, SecurityException {
        initRealScreenSize();
        addDebugView();
        DJXRefreshLayout2 dJXRefreshLayout2 = (DJXRefreshLayout2) findById(R.id.djx_draw_refresh);
        this.mRefreshLayout = dJXRefreshLayout2;
        dJXRefreshLayout2.setIsCanSecondFloor(false);
        this.mRefreshLayout.setRefreshEnable(this.mWidgetParams.mEnableRefresh);
        this.mRefreshLayout.setRefreshHeight(0);
        this.mRefreshLayout.setRefreshFixedContent(true);
        this.mRefreshLayout.setLoadEnable(true);
        this.mRefreshLayout.setForceStopIntercept(true);
        if (this.mWidgetParams.mEnableRefresh) {
            DJXEmptyRefreshView dJXEmptyRefreshView = new DJXEmptyRefreshView(getContext());
            DJXDrawBoxFragment.IDrawBoxListener iDrawBoxListener = this.mDrawBoxListener;
            if (iDrawBoxListener != null) {
                dJXEmptyRefreshView.setRefreshListener(iDrawBoxListener.getRefresh());
            }
            this.mRefreshLayout.setRefreshView(dJXEmptyRefreshView);
        }
        this.mRefreshLayout.setOnLoadListener(new DJXRefreshLayout.OnLoadListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawFragment.2
            @Override // com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout.OnLoadListener
            public void onLoad() {
                ((DrawPresenter) DJXDrawFragment.this.mPresenter).loadMore(false);
            }
        });
        if (this.mWidgetParams.mEnableRefresh) {
            this.mRefreshLayout.setOnRefreshListener(new DJXRefreshLayout.OnRefreshListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawFragment.3
                @Override // com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout.OnRefreshListener
                public void onRefresh() {
                    if (NetworkUtils.isActive(InnerManager.getContext())) {
                        ((DrawPresenter) DJXDrawFragment.this.mPresenter).loadRefresh(false);
                        DJXDrawFragment.this.mDrawLog.pullRefresh();
                        return;
                    }
                    ToastUtil.show(InnerManager.getContext(), DJXDrawFragment.this.getResources().getString(R.string.djx_str_refresh_error_retry));
                    DJXDrawFragment.this.mRefreshLayout.setRefreshing(false);
                    if (DJXDrawFragment.this.mDrawBoxListener != null) {
                        DJXDrawFragment.this.mDrawBoxListener.onFinishRefresh();
                    }
                }
            });
        }
        this.mRefreshLayout.setSlideListener(new DJXRefreshLayout2.OnSlideListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawFragment.4
            @Override // com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout2.OnSlideListener
            public void onSlideDown() {
            }

            @Override // com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout2.OnSlideListener
            public void onSlideUp() {
                if (((DrawPresenter) DJXDrawFragment.this.mPresenter).isLoading() || !DJXDrawFragment.this.mRefreshLayout.isLoading()) {
                    return;
                }
                DJXDrawFragment.this.setLoading(false);
            }
        });
        DJXDmtLoadingLayout dJXDmtLoadingLayout = (DJXDmtLoadingLayout) findById(R.id.djx_loading_layout);
        this.mLoadingLayout = dJXDmtLoadingLayout;
        dJXDmtLoadingLayout.setVisibility(0);
        DJXErrorView dJXErrorView = (DJXErrorView) findById(R.id.djx_draw_error_view);
        this.mDJXErrorView = dJXErrorView;
        dJXErrorView.setRetryListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (NetworkUtils.isActive(InnerManager.getContext())) {
                    DJXDrawFragment.this.mT2WLog.setReqRetryNum(DJXDrawFragment.this.mT2WLog.getReqRetryNum() + 1);
                    DJXDrawFragment.this.mDJXErrorView.show(false);
                    ((DrawPresenter) DJXDrawFragment.this.mPresenter).loadRefresh(false);
                    return;
                }
                ToastUtil.show(InnerManager.getContext(), DJXDrawFragment.this.getResources().getString(R.string.djx_str_no_network_tip));
            }
        });
        DrawAdapter2 drawAdapter2 = new DrawAdapter2(getContext(), this.mCommonParams);
        this.mAdapter = drawAdapter2;
        drawAdapter2.setCategory(this.mCategory);
        this.mAdapter.setAdKey(this.mAdKey, this.mAdKeyInterstitialPost, this.mAdKeyHalfScreenInterstitial, this.mAdKeyFullScreenInterstitial);
        this.mAdapter.setWidgetDrawParams(this.mWidgetParams);
        this.mAdapter.setFeatureValues(getFeatureValues());
        this.mAdapter.setClickDrawListener(new DrawAdapter2.OnClickDrawListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawFragment.6
            @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawAdapter2.OnClickDrawListener
            public void onClickComment(View view2, Feed feed) {
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawAdapter2.OnClickDrawListener
            public void onClickShare(View view2, Feed feed) {
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawAdapter2.OnClickDrawListener
            public void onRenderFirstFrame() {
                DJXDrawFragment.this.mT2WLog.sendFirstFrame(DJXDrawFragment.this.mViewPager.getCurrentItem());
                DJXDrawFragment.this.mHasRenderFirst = true;
                DJXDrawFragment.this.mLoadingLayout.setVisibility(4);
                if (DJXDrawFragment.this.mViewPager != null && DJXDrawFragment.this.mViewPager.getCurrentItem() == 0 && DJXDrawFragment.this.isAdded() && !GuideHelper.getInstance().hasDrawShowedAndSet() && DJXDrawFragment.this.mWidgetParams.mIsShowGuide) {
                    try {
                        if (DJXDrawFragment.this.mGuideView == null) {
                            DJXDrawFragment.this.mGuideView = new DJXDrawGuideView(DJXDrawFragment.this.getContext());
                            DJXDrawFragment.this.mGuideView.show(true, (ViewGroup) DJXDrawFragment.this.mContentView);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawAdapter2.OnClickDrawListener
            public void onVideoModelExpired(VideoM videoM) {
                if (videoM != null) {
                    try {
                        if (DJXDrawFragment.this.mAdapter != null) {
                            int count = DJXDrawFragment.this.mAdapter.getCount();
                            for (int i = 0; i < count; i++) {
                                Object itemData = DJXDrawFragment.this.mAdapter.getItemData(i);
                                if (itemData instanceof Feed) {
                                    Feed feed = (Feed) itemData;
                                    if (feed.getVideoModel() != null && !TextUtils.isEmpty(videoM.getVideoId()) && videoM.getVideoId().equals(feed.getVideoModel().getVideoId())) {
                                        feed.setVideoModel(videoM);
                                        return;
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawAdapter2.OnClickDrawListener
            public void onVideoCompletion(boolean z) {
                if (DJXDrawFragment.this.mReportFragment == null || !DJXDrawFragment.this.mIsReportShow) {
                    if (DJXDrawFragment.this.mShareDialog == null || !DJXDrawFragment.this.mShareDialog.isShowing()) {
                        DJXDrawFragment dJXDrawFragment = DJXDrawFragment.this;
                        dJXDrawFragment.getHolderByPosition(dJXDrawFragment.mPosition);
                        if ((z || SettingData.getInstance().isContinuousPlay()) && DJXDrawFragment.this.mViewPager != null) {
                            DJXDrawFragment.this.mViewPager.scrollNextItem(true);
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawAdapter2.OnClickDrawListener
            public int getCurrentPosition() {
                return DJXDrawFragment.this.mPosition;
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawAdapter2.OnClickDrawListener
            public Context getActivity4Adapter() {
                return DJXDrawFragment.this.getMyActivity() == null ? DJXDrawFragment.this.getContext() : DJXDrawFragment.this.getMyActivity();
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawAdapter2.OnClickDrawListener
            public void onPlayStart(Object obj) {
                if (DJXDrawFragment.this.mHasReportPlayFirst) {
                    return;
                }
                if (DJXDrawFragment.this.mViewPager.getCurrentItem() == 0 && DJXDrawFragment.this.mUIRenderStartTime > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - DJXDrawFragment.this.mUIRenderStartTime;
                    String videoPlayType = obj instanceof Feed ? getVideoPlayType((Feed) obj) : "other";
                    DrawReporter.sendPlayFirstEvent(obj, DJXDrawFragment.this.mCategory, jCurrentTimeMillis, videoPlayType, ILogConst.VIDEO_PLAY_TYPE_CACHE_VIDEO.equals(videoPlayType) ? getCachePlayReason() : ILogConst.CACHE_PLAY_REASON_NULL, null);
                }
                DJXDrawFragment.this.mUIRenderStartTime = -1L;
                DJXDrawFragment.this.mHasReportPlayFirst = true;
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawAdapter2.OnClickDrawListener
            public String getVideoPlayType(Feed feed) {
                return DJXDrawFragment.this.mCachedVideos.contains(feed) ? ILogConst.VIDEO_PLAY_TYPE_CACHE_VIDEO : DJXDrawFragment.this.mPreloadFeed == feed ? DJXDrawFragment.this.mPreloadFeed.isOnlinePreload() ? ILogConst.VIDEO_PLAY_TYPE_ONLINE_PRELOAD_VIDEO : ILogConst.VIDEO_PLAY_TYPE_PRELOAD_VIDEO : ILogConst.VIDEO_PLAY_TYPE_ONLINE_VIDEO;
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawAdapter2.OnClickDrawListener
            public String getCachePlayReason() {
                return DJXDrawFragment.this.mCachePlayReason;
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawAdapter2.OnClickDrawListener
            public long getRootGid() {
                return DJXDrawFragment.this.mRootGid;
            }
        });
        this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
        VerticalViewPager verticalViewPager = (VerticalViewPager) findById(R.id.djx_draw_pager);
        this.mViewPager = verticalViewPager;
        verticalViewPager.setAdapter(this.mAdapter);
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setMinFlingDistance(SettingData.getInstance().getMinFlingDistance());
        this.mViewPager.setMinFlingVelocity(SettingData.getInstance().getMinFlingVelocity());
        this.mViewPager.setMinScrollDistance((float) SettingData.getInstance().getMinScrollDistance());
        this.mViewPager.setCanScroll(true);
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawFragment.7
            private boolean mFirst = true;
            private int mCurrent = -1;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (this.mFirst && f == 0.0f && i2 == 0) {
                    this.mFirst = false;
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                DJXDrawFragment.this.playCurrentHolder(i);
                if (i >= DJXDrawFragment.this.mAdapter.getCount() - 2 || (!this.mFirst && DJXDrawFragment.this.mCacheByNetErr && !DJXDrawFragment.this.mHasDelCache)) {
                    ((DrawPresenter) DJXDrawFragment.this.mPresenter).loadMore(true);
                }
                int i2 = this.mCurrent;
                int i3 = i > i2 ? i + 1 : i < i2 ? i - 1 : -1;
                if (i3 > -1 && i3 < DJXDrawFragment.this.mAdapter.getCount()) {
                    Object itemData = DJXDrawFragment.this.mAdapter.getItemData(i3);
                    if (itemData instanceof Feed) {
                        Feed feed = (Feed) itemData;
                        if (!feed.isType4Ad()) {
                            ((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).preload(feed, 819200L);
                        }
                    }
                }
                this.mCurrent = i;
                if (DJXDrawFragment.this.mWidgetParams != null && DJXDrawFragment.this.mWidgetParams.mListener != null) {
                    try {
                        HashMap map = new HashMap();
                        Object itemData2 = DJXDrawFragment.this.mAdapter.getItemData(i);
                        if (itemData2 instanceof Feed) {
                            map.put("group_id", Long.valueOf(((Feed) itemData2).getGroupId()));
                            map.put("extra", ((Feed) itemData2).getExtra());
                        }
                        DJXDrawFragment.this.mWidgetParams.mListener.onDJXPageChange(i, map);
                        LG.d(DJXDrawFragment.TAG, "onDJXPageChange: " + i + ", map = " + map);
                    } catch (Throwable th) {
                        LG.e(DJXDrawFragment.TAG, "error occurred: IDJXDrawListener.onDJXPageChange()", th);
                    }
                }
                DJXDrawFragment.this.updateDebugView();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0) {
                    ImageTag.resume(DJXDrawFragment.this.getContext(), ImageTag.TAG_DRAW_VIDEO);
                } else {
                    ImageTag.pause(DJXDrawFragment.this.getContext(), ImageTag.TAG_DRAW_VIDEO);
                }
            }
        });
    }

    private void addDebugView() {
        if (this.mContentView instanceof ViewGroup) {
            this.mDebugTextView = DebugInfo.buildDrawTextView((ViewGroup) this.mContentView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDebugView() {
        try {
            if (this.mDebugTextView != null) {
                this.mDebugTextView.setText(this.mPosition + "/" + this.mAdapter.getCount());
                Object itemData = this.mAdapter.getItemData(this.mPosition);
                if (itemData instanceof Feed) {
                    Feed feed = (Feed) itemData;
                    this.mDebugTextView.append("\n");
                    if (feed.getDrama() != null) {
                        this.mDebugTextView.append(feed.getDrama().toString());
                        this.mDebugTextView.append("\n");
                    }
                    String str = "网络请求";
                    if (feed.isPreloadVideo()) {
                        str = feed.isOnlinePreload() ? "线上预加载" : "请求预加载";
                    } else if (feed.isCachedVideo()) {
                        str = "本地缓存";
                    }
                    this.mDebugTextView.append("视频来源：" + str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void initRealScreenSize() throws NoSuchMethodException, SecurityException {
        int height;
        int i;
        if (getMyActivity() == null) {
            sRealScreenWidthPixels = UIUtil.getScreenWidth(InnerManager.getContext());
            int screenHeight = UIUtil.getScreenHeight(InnerManager.getContext());
            sRealScreenHeightPixels = screenHeight;
            MeasureHelper.sRealScreenHeightPixels = screenHeight;
            MeasureHelper.sRealScreenWidthPixels = sRealScreenWidthPixels;
            return;
        }
        Display defaultDisplay = getMyActivity().getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
            height = displayMetrics.heightPixels;
        } else {
            try {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                int iIntValue = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                height = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                i = iIntValue;
            } catch (Exception unused) {
                int width = defaultDisplay.getWidth();
                height = defaultDisplay.getHeight();
                i = width;
            }
        }
        sRealScreenHeightPixels = height;
        sRealScreenWidthPixels = i;
        MeasureHelper.sRealScreenHeightPixels = height;
        MeasureHelper.sRealScreenWidthPixels = sRealScreenWidthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playCurrentHolder(int i) {
        DrawAdapter2 drawAdapter2;
        DJXBus.getInstance().sendEvent(new BEVideoChange());
        if (i == 0 && !this.mIsUserVisible && this.mIsPlayFirst) {
            return;
        }
        if (!this.mHasSendPlayMsg && !this.mIsPlayCache && (drawAdapter2 = this.mAdapter) != null && drawAdapter2.getCount() > 0 && i == 0) {
            this.mHasSendPlayMsg = true;
            Object itemData = this.mAdapter.getItemData(0);
            if (itemData instanceof Feed) {
                this.mFirstFeed = (Feed) itemData;
                long switchCacheTimeout = SettingData.getInstance().getSwitchCacheTimeout();
                if (switchCacheTimeout > 0) {
                    this.mHandler.sendEmptyMessageDelayed(100, switchCacheTimeout);
                }
            }
        }
        this.mPosition = i;
        HolderBase<?> holderByPosition = getHolderByPosition(i);
        boolean z = holderByPosition instanceof DrawHolderDrama;
        if (z) {
            ((DrawHolderDrama) holderByPosition).setSpeed(this.mSpeedPlayManager.getGlobalSpeed(), SpeedScopeType.DRAMA);
        }
        if (holderByPosition != null) {
            DrawAdapter2 drawAdapter22 = this.mAdapter;
            if (drawAdapter22 != null) {
                drawAdapter22.onPageSelected(i, holderByPosition, this.mIsReportShow);
            }
            if (z) {
                this.mIsPlayFirst = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HolderBase<?> getHolderByPosition(int i) {
        List<HolderBase<?>> currentHolders = getCurrentHolders();
        for (int i2 = 0; i2 < currentHolders.size(); i2++) {
            HolderBase<?> holderBase = currentHolders.get(i2);
            if (i == holderBase.getAdapterPosition()) {
                return holderBase;
            }
        }
        return null;
    }

    private void setCurrentHolderSpeed(int i) {
        HolderBase<?> holderByPosition = getHolderByPosition(i);
        if (holderByPosition instanceof DrawHolderDrama) {
            ((DrawHolderDrama) holderByPosition).setSpeed(this.mSpeedPlayManager.getEpisodeSpeed(), SpeedScopeType.EPISODE);
        }
    }

    private List<HolderBase<?>> getCurrentHolders() {
        ArrayList arrayList = new ArrayList();
        int childCount = this.mViewPager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mViewPager.getChildAt(i);
            if (childAt.getTag() instanceof HolderBase) {
                arrayList.add((HolderBase) childAt.getTag());
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMvpProxy, com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void processLogic() {
        this.mT2WLog.sendViewFinish();
        super.processLogic();
        DJXBus.getInstance().addListener(this.mConfigBusListener);
        int networkType = NetworkUtils.getNetworkType(getContext());
        Feed feed = this.mWidgetParams.mDrawContentType == 1 ? null : DrawPreload.getInstance().getFeed();
        this.mPreloadFeed = feed;
        if (feed != null) {
            checkSwitchCache(true);
        } else if (!checkSwitchCache(false)) {
            ((DrawPresenter) this.mPresenter).loadRefresh(false);
        }
        this.mNetChangedListener.onNetChanged(networkType, networkType);
    }

    private boolean checkSwitchCache(boolean z) {
        DrawAdapter2 drawAdapter2;
        Feed feed;
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        if (z && (feed = this.mPreloadFeed) != null) {
            arrayList.add(0, feed);
        }
        if (!NetworkUtils.isStrongNetwork(getContext()) && !this.mCachedVideos.isEmpty()) {
            arrayList.addAll(this.mCachedVideos);
            this.mIsPlayCache = true;
            this.mCacheByNetErr = true;
            this.mCachePlayReason = ILogConst.CACHE_PLAY_REASON_DISCONNECTED;
            z2 = true;
        }
        if (!arrayList.isEmpty() && (drawAdapter2 = this.mAdapter) != null) {
            drawAdapter2.removeAll();
            this.mAdapter.append((Object) arrayList);
        }
        return z2;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void onFragmentShow() {
        DrawAdapter2 drawAdapter2;
        super.onFragmentShow();
        this.mT2WLog.setIsFragmentShow(true);
        this.mT2WLog.sendTotalLog();
        this.mIsUserVisible = true;
        DJXGlobalReceiver.addListener(this.mNetChangedListener);
        resetVodPreload();
        if (this.mIsPlayFirst) {
            this.mIsPlayFirst = false;
            VerticalViewPager verticalViewPager = this.mViewPager;
            if (verticalViewPager != null && verticalViewPager.getCurrentItem() == 0) {
                playCurrentHolder(0);
            }
        } else {
            DrawAdapter2 drawAdapter22 = this.mAdapter;
            if (drawAdapter22 != null && this.mReportFragment == null && !this.mIsReportShow) {
                drawAdapter22.onUserVisible();
            }
        }
        ActiveLog activeLog = this.mActiveLog;
        if (activeLog != null) {
            activeLog.startCheckingShow();
        }
        if (NetworkUtils.isActive(getContext()) && (drawAdapter2 = this.mAdapter) != null && drawAdapter2.getCount() <= 0 && this.mPresenter != 0) {
            ((DrawPresenter) this.mPresenter).loadRefresh(false);
        }
        this.mStartTime = System.currentTimeMillis();
        this.mUIRenderStartTime = System.currentTimeMillis();
        this.mEnterTime = System.currentTimeMillis();
        DJXDrawBoxFragment.IDrawBoxListener iDrawBoxListener = this.mDrawBoxListener;
        if (iDrawBoxListener != null && this.mCategory != null) {
            this.mDrawLog.sendEnterYes(iDrawBoxListener.getEnterType());
        }
        String str = this.mCategory;
        if (str != null) {
            DrawReporter.reportAppEvoke(str, null, null);
        }
        this.mTLog.sendPageEvent(ILogConst.Params.SCENE_DRAW_PAGE, ILogConst.EVENT_T_SHOW, null, null);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void onFragmentHide() {
        super.onFragmentHide();
        this.mT2WLog.setIsFragmentShow(false);
        if (this.mCategory != null) {
            this.mDrawLog.sendEnterNo(System.currentTimeMillis() - this.mEnterTime);
        }
        if (this.mCategory != null && this.mStartTime > 0) {
            DrawReporter.reportStayOtherPage(this.mCategory, "draw", System.currentTimeMillis() - this.mStartTime, null);
            this.mStartTime = -1L;
        }
        this.mIsUserVisible = false;
        DJXGlobalReceiver.removeListener(this.mNetChangedListener);
        DrawAdapter2 drawAdapter2 = this.mAdapter;
        if (drawAdapter2 != null) {
            drawAdapter2.onUserInvisible();
            LG.i(TAG, "DJXDrawFragment onUserInvisible");
        }
        ActiveLog activeLog = this.mActiveLog;
        if (activeLog != null) {
            activeLog.stopCheckingShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toastCenter(String str) {
        ToastUtil.showCenter(getMyActivity(), View.inflate(getMyActivity(), R.layout.djx_view_toast_draw, null), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetVodPreload() {
        DrawAdapter2 drawAdapter2 = this.mAdapter;
        if (drawAdapter2 == null || drawAdapter2.getCount() <= 0 || !((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).isNewPreload()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.mAdapter.getList()) {
            if (obj instanceof Feed) {
                Feed feed = (Feed) obj;
                if (feed.getVideoModel() != null) {
                    arrayList.add(feed.getVideoModel());
                }
            }
        }
        ((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).preload(arrayList);
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawContract.View
    public void onLoadRefresh(int i, boolean z, boolean z2, List list) {
        DJXWidgetDrawParams dJXWidgetDrawParams;
        if (z && !z2) {
            this.mT2WLog.sendReqEnd(i == 0, i, "", null);
        }
        if ((i == -4 || i == -1) && !z2) {
            ToastUtil.show(InnerManager.getContext(), getResources().getString(R.string.djx_str_network_error_retry));
        }
        if (z && (dJXWidgetDrawParams = this.mWidgetParams) != null && dJXWidgetDrawParams.mListener != null) {
            try {
                this.mWidgetParams.mListener.onDJXRefreshFinish();
                LG.d(TAG, "onDJXRefreshFinish");
            } catch (Throwable th) {
                LG.e(TAG, "error occurred: IDJXDrawListener.onDJXRefreshFinish()", th);
            }
        }
        this.mRefreshLayout.setRefreshing(false);
        this.mRefreshLayout.setLoading(false);
        DJXDrawBoxFragment.IDrawBoxListener iDrawBoxListener = this.mDrawBoxListener;
        if (iDrawBoxListener != null) {
            iDrawBoxListener.onFinishRefresh();
        }
        if (this.mIsPlayCache && list != null && !list.isEmpty() && !this.mHasDelCache) {
            this.mHasDelCache = true;
            this.mDrawLog.sendDelCacheVideo(((DrawPresenter) this.mPresenter).getRefreshReqId(), this.mCachedVideos.size(), this.mAdapter.removeCache(this.mPosition + 1));
        }
        if (z) {
            if (list != null && !list.isEmpty()) {
                this.mIsPlayFirst = true;
                final boolean z3 = this.mIsPlayCache && !this.mHasDelCache;
                Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!z3 && DJXDrawFragment.this.mAdapter.getList() != null) {
                            try {
                                for (Object obj : DJXDrawFragment.this.mAdapter.getList()) {
                                    if (obj instanceof Feed) {
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                        }
                        if (DJXDrawFragment.this.mViewPager.getCurrentItem() != 0) {
                            DJXDrawFragment.this.mViewPager.setCurrentItem(0, false);
                        }
                    }
                };
                if (z3) {
                    runnable.run();
                    this.mAdapter.append((List<Object>) list);
                } else {
                    this.mAdapter.refresh(list, runnable);
                }
                if (this.mViewPager.getCurrentItem() == 0) {
                    playCurrentHolder(this.mViewPager.getCurrentItem());
                }
            }
        } else if (list != null && !list.isEmpty()) {
            this.mAdapter.append((List<Object>) list);
        }
        DrawAdapter2 drawAdapter2 = this.mAdapter;
        if (drawAdapter2 != null) {
            if (drawAdapter2.getCount() <= 0) {
                LG.e(TAG, "mAdapter count = 0");
            }
            this.mDJXErrorView.show(this.mAdapter.getCount() <= 0);
        }
        if (list != null && !list.isEmpty()) {
            this.mIsPlayCache = false;
            this.mCacheByNetErr = false;
        }
        updateDebugView();
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawContract.View
    public void setLoading(boolean z) {
        DJXRefreshLayout2 dJXRefreshLayout2 = this.mRefreshLayout;
        if (dJXRefreshLayout2 != null) {
            dJXRefreshLayout2.setLoading(z);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawContract.View
    public void setRefreshing(boolean z) {
        DJXRefreshLayout2 dJXRefreshLayout2 = this.mRefreshLayout;
        if (dJXRefreshLayout2 != null) {
            dJXRefreshLayout2.setRefreshing(z);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawContract.View
    public void setLoadMoreEnable(boolean z) {
        DJXRefreshLayout2 dJXRefreshLayout2 = this.mRefreshLayout;
        if (dJXRefreshLayout2 != null) {
            dJXRefreshLayout2.setLoadEnable(z);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawContract.View
    public int getAdapterCount() {
        DrawAdapter2 drawAdapter2 = this.mAdapter;
        if (drawAdapter2 != null) {
            return drawAdapter2.getOriginalCount();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawContract.View
    public int getAdapterCount2() {
        DrawAdapter2 drawAdapter2 = this.mAdapter;
        if (drawAdapter2 != null) {
            return drawAdapter2.getCount();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawContract.View
    public Object getAdapterItem(int i) {
        DrawAdapter2 drawAdapter2 = this.mAdapter;
        if (drawAdapter2 != null) {
            return drawAdapter2.getItemData(i);
        }
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.draw.DrawContract.View
    public void setRefreshingEnable(boolean z) {
        DJXRefreshLayout2 dJXRefreshLayout2 = this.mRefreshLayout;
        if (dJXRefreshLayout2 != null) {
            dJXRefreshLayout2.setRefreshEnable(z);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public Fragment getReportFragment() {
        return initReportFragment().getFragment();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public android.app.Fragment getReportFragment2() {
        return initReportFragment().getFragment2();
    }

    private DJXReportFragment initReportFragment() {
        DJXReportParams dJXReportParamsReportListener = DJXReportParams.obtain().reportTopPadding(this.mWidgetParams.mReportTopPadding).source(DJXReportParams.DRAW_REPORT_SOURCE).reportListener(new DJXReportParams.IDJXReportCallback() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawFragment.12
            @Override // com.bytedance.sdk.djx.core.business.bureport.DJXReportParams.IDJXReportCallback
            public void onDJXReportResult(boolean z, Map<String, Object> map) {
                if (z) {
                    ToastUtil.show(InnerManager.getContext(), DJXDrawFragment.this.getResources().getString(R.string.djx_report_success_tip));
                } else {
                    ToastUtil.show(InnerManager.getContext(), DJXDrawFragment.this.getResources().getString(R.string.djx_report_fail_tip));
                }
                if (DJXDrawFragment.this.mWidgetParams == null || DJXDrawFragment.this.mWidgetParams.mListener == null) {
                    return;
                }
                DJXDrawFragment.this.mWidgetParams.mListener.onDJXReportResult(z, map);
            }

            @Override // com.bytedance.sdk.djx.core.business.bureport.DJXReportParams.IDJXReportCallback
            public void onOpen(FragProxy fragProxy) {
                DJXDrawFragment.this.mIsReportShow = true;
                if (DJXDrawFragment.this.mAdapter != null) {
                    DJXDrawFragment.this.mAdapter.onUserInvisible();
                    LG.i(DJXDrawFragment.TAG, "DJXReportFragment onOpen fragProxy = " + fragProxy);
                }
                if (fragProxy instanceof DJXReportFragment) {
                    DJXDrawFragment.this.mReportFragment = (DJXReportFragment) fragProxy;
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.bureport.DJXReportParams.IDJXReportCallback
            public void onClose(FragProxy fragProxy) {
                DJXDrawFragment.this.mIsReportShow = false;
                if (DJXDrawFragment.this.mAdapter != null) {
                    DJXDrawFragment.this.mAdapter.onUserVisible();
                }
                if (!(fragProxy instanceof DJXReportFragment) || DJXDrawFragment.this.mReportFragment == null) {
                    return;
                }
                DJXDrawFragment.this.mReportFragment = null;
            }
        });
        DrawAdapter2 drawAdapter2 = this.mAdapter;
        if (drawAdapter2 != null) {
            Object itemData = drawAdapter2.getItemData(this.mPosition);
            if (itemData instanceof Feed) {
                dJXReportParamsReportListener.category(this.mCategory).feed((Feed) itemData);
            }
        }
        dJXReportParamsReportListener.position(this.mViewPager.getCurrentItem());
        return DJXReportFragment.build(isV4Support()).setReportParams(dJXReportParamsReportListener);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public void refresh() {
        if (getMyActivity() == null || getMyActivity().isFinishing()) {
            return;
        }
        ((DrawPresenter) this.mPresenter).loadRefresh(false);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMvpProxy, com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onDetach() {
        super.onDetach();
        this.mHandler.removeCallbacksAndMessages((Object) null);
        DJXBus.getInstance().removeListener(this.mConfigBusListener);
        DJXBus.getInstance().removeListener(this.mBusListener);
        DrawAdapter2 drawAdapter2 = this.mAdapter;
        if (drawAdapter2 != null) {
            drawAdapter2.onDestroy(this.mViewPager);
        }
        DJXShareDialog dJXShareDialog = this.mShareDialog;
        if (dJXShareDialog != null) {
            if (dJXShareDialog.isShowing()) {
                this.mShareDialog.dismiss();
            }
            this.mShareDialog.setListener(null);
            this.mShareDialog = null;
        }
        DJXGlobalReceiver.removeListener(this.mNetChangedListener);
        DrawAdapter2 drawAdapter22 = this.mAdapter;
        if (drawAdapter22 != null) {
            try {
                drawAdapter22.unregisterDataSetObserver(this.mDataSetObserver);
            } catch (Throwable unused) {
            }
        }
        ActiveLog activeLog = this.mActiveLog;
        if (activeLog != null) {
            activeLog.stopCheckingShow();
        }
        DJXDmtLoadingLayout dJXDmtLoadingLayout = this.mLoadingLayout;
        if (dJXDmtLoadingLayout != null) {
            dJXDmtLoadingLayout.setVisibility(4);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public boolean canBackPress() {
        return this.mReportFragment == null;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public void backRefresh() {
        if (getMyActivity() == null || getMyActivity().isFinishing() || this.mPresenter == 0) {
            return;
        }
        ToastUtil.show(InnerManager.getContext(), getResources().getString(R.string.djx_back_tip));
        ((DrawPresenter) this.mPresenter).loadRefresh(true);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public void destroy() {
        super.destroy();
        if (this.mWidgetParams != null) {
            AdManager.inst().clear(this.mWidgetParams.hashCode());
        }
    }

    Object getCurrentData() {
        DrawAdapter2 drawAdapter2 = this.mAdapter;
        if (drawAdapter2 != null) {
            return drawAdapter2.getItemData(this.mPosition);
        }
        return null;
    }

    Feed getCurrentFeed() {
        Object currentData = getCurrentData();
        if (currentData instanceof Feed) {
            return (Feed) currentData;
        }
        return null;
    }

    void slide2Invisible() {
        DrawAdapter2 drawAdapter2 = this.mAdapter;
        if (drawAdapter2 != null) {
            drawAdapter2.onUserInvisible();
            LG.i(TAG, "DJXDrawFragment slide2Invisible");
        }
    }

    public void handleMsg(Message message) {
        if (message.what == 100) {
            if (this.mHasRenderFirst || this.mCachedVideos.isEmpty()) {
                return;
            }
            this.mIsPlayCache = true;
            DrawAdapter2 drawAdapter2 = this.mAdapter;
            if (drawAdapter2 != null) {
                this.mCachePlayReason = ILogConst.CACHE_PLAY_REASON_RENDER_SLOW_ONLINE;
                if (this.mPreloadFeed == this.mFirstFeed) {
                    this.mCachePlayReason = ILogConst.CACHE_PLAY_REASON_RENDER_SLOW_PRELOAD;
                }
                drawAdapter2.refresh(this.mCachedVideos, null);
                if (this.mViewPager.getCurrentItem() == 0) {
                    playCurrentHolder(this.mViewPager.getCurrentItem());
                    return;
                }
                return;
            }
            return;
        }
        if (message.what == 101) {
            ToastUtil.show(InnerManager.getContext(), getResources().getString(R.string.djx_str_network_error), DJXToastType.NETWORK_ERROR);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public boolean setCurrentPage(int i) {
        DrawAdapter2 drawAdapter2 = this.mAdapter;
        if (drawAdapter2 == null || i >= drawAdapter2.getCount() || i < 0) {
            return false;
        }
        this.mViewPager.setCurrentItem(i);
        return true;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public void seekTo(long j) {
        super.seekTo(j);
        try {
            HolderBase<?> holderByPosition = getHolderByPosition(this.mPosition);
            if (holderByPosition instanceof DrawHolderDrama) {
                ((DrawHolderDrama) holderByPosition).seekTo(j);
            }
        } catch (Exception e) {
            LG.e(TAG, "seekTo", e);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public void setSpeedPlay(float f, DJXPlaySpeedScope dJXPlaySpeedScope) {
        super.setSpeedPlay(f, dJXPlaySpeedScope);
        this.mSpeedPlayManager.updateSpeed(f, dJXPlaySpeedScope);
        setCurrentHolderSpeed(this.mPosition);
    }

    private int getDrawType() {
        return this.mWidgetParams.mDrawContentType;
    }
}
