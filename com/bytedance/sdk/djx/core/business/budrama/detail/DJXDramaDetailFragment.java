package com.bytedance.sdk.djx.core.business.budrama.detail;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.djx.DJXPlaySpeedScope;
import com.bytedance.sdk.djx.DJXRewardAdResult;
import com.bytedance.sdk.djx.DJXToastType;
import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.base.dynamic.DynamicManager;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.core.act.DJXGlobalReceiver;
import com.bytedance.sdk.djx.core.act.DJXReportActivity;
import com.bytedance.sdk.djx.core.act.GRListener;
import com.bytedance.sdk.djx.core.api.ApiManager;
import com.bytedance.sdk.djx.core.api.rsp.DramaActionRsp;
import com.bytedance.sdk.djx.core.api.rsp.DramaUnlockModel;
import com.bytedance.sdk.djx.core.business.ActiveLog;
import com.bytedance.sdk.djx.core.business.SpeedPlayManager;
import com.bytedance.sdk.djx.core.business.SpeedScopeType;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.core.business.base.FragMvpProxy;
import com.bytedance.sdk.djx.core.business.base.FragProxy;
import com.bytedance.sdk.djx.core.business.budrama.DefaultDramaParamsWrapperKt;
import com.bytedance.sdk.djx.core.business.budrama.DramaLog;
import com.bytedance.sdk.djx.core.business.budrama.DramaManager;
import com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaListDialog;
import com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaRewardDialog;
import com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailAdapter;
import com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailContract;
import com.bytedance.sdk.djx.core.business.buprivacy.DJXPrivacySettingActivity;
import com.bytedance.sdk.djx.core.business.bureport.DJXReportParams;
import com.bytedance.sdk.djx.core.business.view.DJXErrorView;
import com.bytedance.sdk.djx.core.business.view.VerticalViewPager;
import com.bytedance.sdk.djx.core.business.view.loading.DJXDmtLoadingLayout;
import com.bytedance.sdk.djx.core.business.view.refresh.DJXDmtLoadView;
import com.bytedance.sdk.djx.core.business.view.refresh.DJXDmtRefreshView;
import com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout;
import com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout2;
import com.bytedance.sdk.djx.core.business.view.share.DJXShareConfig;
import com.bytedance.sdk.djx.core.business.view.share.DJXShareDialog;
import com.bytedance.sdk.djx.core.init.pay.PayInitHelper;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.log.SdkTLog;
import com.bytedance.sdk.djx.core.log.T2WLog;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.core.util.AdVideoCallbackUtil;
import com.bytedance.sdk.djx.core.util.ToastUtil;
import com.bytedance.sdk.djx.core.vod.IPreloadCallback;
import com.bytedance.sdk.djx.core.vod.IVideoService;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;
import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaListener;
import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaUnlockListener;
import com.bytedance.sdk.djx.model.DJXDramaDetailConfig;
import com.bytedance.sdk.djx.model.DJXDramaUnlockAdMode;
import com.bytedance.sdk.djx.model.DJXDramaUnlockInfo;
import com.bytedance.sdk.djx.model.DJXDramaUnlockMethod;
import com.bytedance.sdk.djx.model.DJXEpisodeStatus;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.DJXOrder;
import com.bytedance.sdk.djx.model.DJXOthers;
import com.bytedance.sdk.djx.model.DJXUnlockModeType;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.model.DramaDrawAd;
import com.bytedance.sdk.djx.model.VideoM;
import com.bytedance.sdk.djx.model.ev.BEAdCome;
import com.bytedance.sdk.djx.model.ev.BEDetailVideoLoad;
import com.bytedance.sdk.djx.model.ev.BEDismissOuterLoadingEvent;
import com.bytedance.sdk.djx.model.ev.BEDramaFavorAction;
import com.bytedance.sdk.djx.model.ev.BEGlobalSpeedUpdate;
import com.bytedance.sdk.djx.model.ev.BESettingUpdate;
import com.bytedance.sdk.djx.net.ImageTag;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.params.DJXWidgetDramaDetailParams;
import com.bytedance.sdk.djx.utils.ActivityStackUtils;
import com.bytedance.sdk.djx.utils.DeviceUtils;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.NetworkUtils;
import com.bytedance.sdk.djx.utils.StatusBarUtil;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.bytedance.sdk.djx.utils.WeakHandler;
import com.bytedance.sdk.djx.utils.bus.BusEvent;
import com.bytedance.sdk.djx.utils.bus.DJXBus;
import com.bytedance.sdk.djx.utils.bus.IBusListener;
import com.bytedance.sdk.djx.utils.service.ServiceManager;
import com.bytedance.sdk.djx.utils.thread.TTExecutor;
import com.bytedance.sdk.djx.utils.thread.TTRunnable;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDramaDetailFragment extends FragMvpProxy<DramaDetailPresenter> implements DramaDetailContract.View, WeakHandler.IHandler {
    private static final String TAG = "DJXDramaDetailFragment";
    private static final int WHAT_MSG_NETWORK_DISCONNECTED = 101;
    public static int sRealScreenHeightPixels = -1;
    public static int sRealScreenWidthPixels = -1;
    private ActiveLog mActiveLog;
    private AdKey mAdKey;
    private DramaDetailAdapter mAdapter;
    private FrameLayout mCustomBannerContainer;
    private DJXErrorView mDJXErrorView;
    private DJXDramaDetailConfig mDetailConfig;
    private Drama mDrama;
    private DJXDramaListDialog mDramaListDialog;
    List<Integer> mDrawPositions;
    private int mFreeSet;
    private String mFromGid;
    private TextView mIcpTipsView;
    private boolean mIsUserVisible;
    private DramaDetailLoadFromCacheTask mLoadCacheTask;
    private DJXDmtLoadingLayout mLoadingLayout;
    private ViewPager.OnPageChangeListener mPageChangeListener;
    private DJXRefreshLayout2 mRefreshLayout;
    private DJXDramaRewardDialog mRewardDialog;
    private TextView mScriptTipsView;
    private DJXShareDialog mShareDialog;
    private TextView mTitle;
    private VerticalViewPager mViewPager;
    private DJXWidgetDramaDetailParams mWidgetParams;
    private DJXDramaUnlockAdMode mAdMode = DJXDramaUnlockAdMode.MODE_COMMON;
    private String mCategory = "hotsoon_video_detail_draw";
    private String mFromCategory = "";
    private final String mFeatureValues = "skit_only";
    private int mFirstPlayDuration = -1;
    private final Map<String, Object> mSourceMap = new HashMap();
    private int firstUnLockIndex = -1;
    private boolean isContinuesUnlockMode = false;
    private final DramaLog mDramaLog = new DramaLog();
    private final SdkTLog mTLog = new SdkTLog();
    private final Map<String, Object> mCommonParams = new HashMap();
    private long mStartTime = -1;
    private long mUnlockStartTime = -1;
    private boolean mHasReportPlayFirst = false;
    private long mUIRenderStartTime = -1;
    private int mPosition = 0;
    private int mPrePosition = -1;
    private boolean mIsPlayFirst = true;
    private boolean mIsWaitingAd = false;
    private boolean mHasReward = false;
    private boolean mNeedRollback = false;
    private boolean hasCustomAdShown = false;
    private boolean mDramaTipsShown = false;
    private int mRefreshFirstPosition = -1;
    private int mDramaInitCursor = 1;
    private boolean mHasSelectedOver = false;
    private boolean mIsInitLoadFinished = false;
    private long mBlockTime = -1;
    private int mLastLockSet = 0;
    private boolean mFakeHasMember = false;
    private AtomicBoolean mIsUnlockFlowStarted = new AtomicBoolean(false);
    private boolean mRewardVerifyCallback = false;
    private boolean mIsDeleteNeedCallback = true;
    private T2WLog mT2WLog = new T2WLog("play");
    private SpeedPlayManager mSpeedPlayManager = new SpeedPlayManager();
    private final WeakHandler mHandler = new WeakHandler(Looper.getMainLooper(), this);
    private final IBusListener mBusListener = new IBusListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.1
        public void onBusEvent(BusEvent busEvent) {
            List<Object> list;
            Drama drama;
            String codeId;
            if (busEvent instanceof BEDismissOuterLoadingEvent) {
                if (DJXDramaDetailFragment.this.mLoadingLayout != null) {
                    DJXDramaDetailFragment.this.mLoadingLayout.setVisibility(4);
                    return;
                }
                return;
            }
            if (busEvent instanceof BEAdCome) {
                if (DJXDramaDetailFragment.this.mIsWaitingAd && (codeId = DJXDramaDetailFragment.this.mAdKey.getCodeId()) != null) {
                    BEAdCome bEAdCome = (BEAdCome) busEvent;
                    if (codeId.equals(bEAdCome.getCodeId())) {
                        if (bEAdCome.isLoadSuccess()) {
                            IDJXAd ad = AdManager.inst().getAd(DJXDramaDetailFragment.this.mAdKey);
                            if (ad != null) {
                                DJXDramaDetailFragment dJXDramaDetailFragment = DJXDramaDetailFragment.this;
                                dJXDramaDetailFragment.showSdkAd(ad, dJXDramaDetailFragment.mLastLockSet);
                            }
                        } else {
                            DJXDramaDetailFragment.this.handleUnlockFlowEnd(false, DJXDramaUnlockMethod.METHOD_AD, DJXDramaDetailFragment.this.mLastLockSet, IDJXDramaUnlockListener.UnlockErrorStatus.ERROR_AD_ERROR, null, null);
                            LG.e(DJXDramaDetailFragment.TAG, "csj ad loadRewardVideoAd onError");
                            if (!DJXDramaDetailFragment.this.mIsUserVisible) {
                                DJXDramaDetailFragment.this.mNeedRollback = true;
                            } else {
                                ToastUtil.show(InnerManager.getContext(), "广告异常，请稍后重试");
                                if (DJXDramaDetailFragment.this.mPosition > 0) {
                                    DJXDramaDetailFragment.this.mViewPager.setCurrentItem(DJXDramaDetailFragment.this.mPosition - 1, true);
                                }
                            }
                        }
                        DJXDramaDetailFragment.this.mIsWaitingAd = false;
                        DJXDramaDetailFragment.this.mLastLockSet = 0;
                        return;
                    }
                    return;
                }
                return;
            }
            if (busEvent instanceof BEDetailVideoLoad) {
                BEDetailVideoLoad bEDetailVideoLoad = (BEDetailVideoLoad) busEvent;
                if (bEDetailVideoLoad.getPosition() == DJXDramaDetailFragment.this.mViewPager.getCurrentItem()) {
                    if (bEDetailVideoLoad.isRetry()) {
                        DJXDramaDetailFragment.this.mT2WLog.setVideoRetryNum(DJXDramaDetailFragment.this.mT2WLog.getVideoRetryNum() + 1);
                    }
                    DJXDramaDetailFragment.this.mT2WLog.sendLoad(bEDetailVideoLoad.getPosition());
                    return;
                }
                return;
            }
            if (busEvent instanceof BEGlobalSpeedUpdate) {
                DJXDramaDetailFragment.this.mSpeedPlayManager.updateGlobalSpeed();
                DJXDramaDetailFragment dJXDramaDetailFragment2 = DJXDramaDetailFragment.this;
                DramaDetailHolderBase holderByPosition = dJXDramaDetailFragment2.getHolderByPosition(dJXDramaDetailFragment2.mPosition);
                if (holderByPosition instanceof DramaDetailHolder) {
                    ((DramaDetailHolder) holderByPosition).setSpeed(DJXDramaDetailFragment.this.mSpeedPlayManager.getGlobalSpeed(), SpeedScopeType.GLOBAL);
                    return;
                }
                return;
            }
            if (busEvent instanceof BEDramaFavorAction) {
                BEDramaFavorAction bEDramaFavorAction = (BEDramaFavorAction) busEvent;
                if (DJXDramaDetailFragment.this.mDrama.id != bEDramaFavorAction.getDramaId() || (list = DJXDramaDetailFragment.this.mAdapter.getList()) == null || list.isEmpty()) {
                    return;
                }
                for (Object obj : list) {
                    if ((obj instanceof DramaDetail) && (drama = ((DramaDetail) obj).getDrama()) != null && drama.isFavor != bEDramaFavorAction.isFavor()) {
                        drama.isFavor = bEDramaFavorAction.isFavor();
                        if (bEDramaFavorAction.isFavor()) {
                            drama.favoriteCount++;
                        } else {
                            drama.favoriteCount--;
                        }
                    }
                }
            }
        }
    };
    private final Runnable mTipsAction = new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.2
        @Override // java.lang.Runnable
        public void run() {
            if (DJXDramaDetailFragment.this.mScriptTipsView != null) {
                DJXDramaDetailFragment.this.mScriptTipsView.setVisibility(8);
            }
            if (DJXDramaDetailFragment.this.mIcpTipsView != null) {
                DJXDramaDetailFragment.this.mIcpTipsView.setVisibility(8);
            }
            DJXDramaDetailFragment.this.mDramaTipsShown = true;
        }
    };
    private final IContinuesDialogCallBack showContinuesDialogCallBack = new IContinuesDialogCallBack() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.3
        @Override // com.bytedance.sdk.djx.core.business.budrama.detail.IContinuesDialogCallBack
        public void showContinuesDialog(DramaUnlockModel dramaUnlockModel) {
            final DramaDetail currentDramaDetail;
            List<Integer> unlockIndexList = dramaUnlockModel.getUnlockIndexList();
            DJXDramaDetailFragment.this.isContinuesUnlockMode = true;
            if (unlockIndexList == null) {
                DJXDramaDetailFragment.this.isContinuesUnlockMode = false;
                DJXDramaDetailFragment.this.firstUnLockIndex = -1;
                return;
            }
            if (unlockIndexList.isEmpty() || unlockIndexList.get(unlockIndexList.size() - 1) == null || (currentDramaDetail = DJXDramaDetailFragment.this.getCurrentDramaDetail()) == null) {
                return;
            }
            Map<String, ? extends Object> mapCreateParamsMap = DramaDetailHelper.createParamsMap(currentDramaDetail, DJXDramaDetailFragment.this.mDrama);
            DJXDramaDetailFragment dJXDramaDetailFragment = DJXDramaDetailFragment.this;
            dJXDramaDetailFragment.firstUnLockIndex = dJXDramaDetailFragment.getFirstLockedIndex(unlockIndexList.get(unlockIndexList.size() - 1).intValue());
            if (DJXDramaDetailFragment.this.firstUnLockIndex < 0) {
                ((DramaDetailPresenter) DJXDramaDetailFragment.this.mPresenter).unLockDrama();
                DJXDramaDetailFragment.this.isContinuesUnlockMode = false;
                mapCreateParamsMap.put("is_continuity_unlock", false);
            } else {
                mapCreateParamsMap.put("is_continuity_unlock", true);
                mapCreateParamsMap.put("first_unlock_index", Integer.valueOf(DJXDramaDetailFragment.this.firstUnLockIndex));
                mapCreateParamsMap.put("first_lock_index", unlockIndexList.get(0));
                DJXDramaDetailFragment.this.mDetailConfig.getUnlockListener().unlockFlowStart(DJXDramaDetailFragment.this.getCurrentDramaDetail().getDrama(), new IDJXDramaUnlockListener.UnlockCallback() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.3.1
                    @Override // com.bytedance.sdk.djx.interfaces.listener.IDJXDramaUnlockListener.UnlockCallback
                    public void onConfirm(DJXDramaUnlockInfo dJXDramaUnlockInfo) {
                        if (dJXDramaUnlockInfo.getCancelUnlock()) {
                            ((DramaDetailPresenter) DJXDramaDetailFragment.this.mPresenter).unLockDrama();
                            DJXDramaDetailFragment.this.isContinuesUnlockMode = false;
                            DJXDramaDetailFragment.this.firstUnLockIndex = -1;
                            return;
                        }
                        DJXDramaDetailFragment.this.handleUnlockInfo(currentDramaDetail, dJXDramaUnlockInfo);
                    }
                }, mapCreateParamsMap);
            }
        }
    };
    private IVideoService videoService = (IVideoService) ServiceManager.getInstance().getService(IVideoService.class);
    private final DataSetObserver mDataSetObserver = new DataSetObserver() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.20
        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (DJXDramaDetailFragment.this.mAdapter == null || DJXDramaDetailFragment.this.getMyActivity() == null || DJXDramaDetailFragment.this.getMyActivity().isFinishing()) {
                return;
            }
            if (DJXDramaDetailFragment.this.mAdapter.getCount() > 0) {
                DJXDramaDetailFragment.this.mLoadingLayout.setVisibility(4);
            } else {
                DJXDramaDetailFragment.this.mLoadingLayout.setVisibility(0);
            }
            DJXDramaDetailFragment.this.resetVodPreload();
        }
    };
    private final GRListener mNetChangedListener = new GRListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.21
        @Override // com.bytedance.sdk.djx.core.act.GRListener
        public void onNetChanged(int i, int i2) {
            if (!NetworkUtils.isActive(InnerManager.getContext())) {
                if (i != 0) {
                    DJXDramaDetailFragment.this.mDJXErrorView.show(false);
                } else if (DJXDramaDetailFragment.this.mAdapter != null && DJXDramaDetailFragment.this.mAdapter.getCount() <= 0) {
                    DJXDramaDetailFragment.this.mDJXErrorView.show(true);
                }
                DJXDramaDetailFragment.this.mHandler.sendEmptyMessageDelayed(101, 2000L);
                return;
            }
            DJXDramaDetailFragment.this.mHandler.removeMessages(101);
            DJXDramaDetailFragment.this.mDJXErrorView.show(false);
            if (i != i2) {
                ((DramaDetailPresenter) DJXDramaDetailFragment.this.mPresenter).loadDramaInit(DJXDramaDetailFragment.this.mDramaInitCursor);
            }
            if (i2 == 1 || DJXDramaDetailFragment.this.mDetailConfig.isHideCellularToast()) {
                return;
            }
            DJXDramaDetailFragment dJXDramaDetailFragment = DJXDramaDetailFragment.this;
            dJXDramaDetailFragment.toastCenter(dJXDramaDetailFragment.getResources().getString(R.string.djx_str_no_wifi_tip));
        }
    };
    private final IBusListener mConfigBusListener = new IBusListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.22
        public void onBusEvent(BusEvent busEvent) {
            if (busEvent instanceof BESettingUpdate) {
                DJXDramaDetailFragment.this.resetCategory();
            }
        }
    };

    @Override // com.bytedance.sdk.djx.core.business.base.BaseContract.BaseView
    public void showError() {
    }

    private DJXDramaDetailFragment(Drama drama) {
        this.mDrama = drama;
    }

    public static DJXDramaDetailFragment obtain(DJXWidgetDramaDetailParams dJXWidgetDramaDetailParams) {
        if (dJXWidgetDramaDetailParams == null) {
            LG.e(TAG, "drama params can not be null");
            return null;
        }
        if (dJXWidgetDramaDetailParams.id < 0 || dJXWidgetDramaDetailParams.index < 1) {
            LG.d(TAG, "create drama detail, params invalid, params : " + dJXWidgetDramaDetailParams + ", freeSet = " + dJXWidgetDramaDetailParams.detailConfig.getFreeSet());
            return null;
        }
        Drama drama = new Drama();
        drama.id = dJXWidgetDramaDetailParams.id;
        drama.index = dJXWidgetDramaDetailParams.index;
        DJXDramaDetailFragment dJXDramaDetailFragment = new DJXDramaDetailFragment(drama);
        dJXDramaDetailFragment.setWidgetParams(dJXWidgetDramaDetailParams, dJXWidgetDramaDetailParams.detailConfig);
        dJXDramaDetailFragment.setParams(dJXWidgetDramaDetailParams.detailConfig.getAdMode(), dJXWidgetDramaDetailParams.detailConfig.getFreeSet());
        return dJXDramaDetailFragment;
    }

    public void setWidgetParams(DJXWidgetDramaDetailParams dJXWidgetDramaDetailParams, DJXDramaDetailConfig dJXDramaDetailConfig) {
        this.mWidgetParams = dJXWidgetDramaDetailParams;
        this.mDetailConfig = dJXDramaDetailConfig;
        if (dJXDramaDetailConfig.getAdCustomProvider() != null) {
            this.mDrawPositions = this.mDetailConfig.getAdCustomProvider().getDetailDrawAdPositions();
        }
        int i = this.mDrama.index;
        if (i <= 0) {
            i = 1;
        }
        this.mDramaInitCursor = i;
        this.mFirstPlayDuration = dJXWidgetDramaDetailParams.mCurrentDuration;
        int i2 = AnonymousClass23.$SwitchMap$com$bytedance$sdk$djx$params$DJXWidgetDramaDetailParams$DJXDramaEnterFrom[dJXWidgetDramaDetailParams.mFrom.ordinal()];
        if (i2 == 1) {
            this.mFromCategory = ILogConst.CATEGORY_SKIT_BANNER;
        } else if (i2 == 2) {
            this.mFromCategory = ILogConst.CATEGORY_ME_DRAMA_HISTORY;
        } else if (i2 == 3) {
            this.mFromCategory = ILogConst.CATEGORY_DRAMA_HOME_HISTORY;
        } else if (i2 == 4) {
            this.mFromCategory = "skit_mixed_feed";
        } else {
            this.mFromCategory = "";
        }
        this.mFromGid = this.mWidgetParams.mFromGid;
        if (this.mWidgetParams.mRecMap != null) {
            this.mSourceMap.putAll(this.mWidgetParams.mRecMap);
        }
        this.mSourceMap.put("shortplay_id", Long.valueOf(this.mDrama.id));
        try {
            this.mSourceMap.put("episode_id", Long.valueOf(Long.parseLong(this.mFromGid)));
        } catch (Exception unused) {
        }
        this.mCommonParams.put("page_scene", ILogConst.Params.SCENE_PLAY_PAGE);
        this.mCommonParams.put("from_scene", SdkTLog.INSTANCE.getEnterScene(this.mWidgetParams.mFrom));
    }

    public void setParams(DJXDramaUnlockAdMode dJXDramaUnlockAdMode, int i) {
        this.mFreeSet = i;
        this.mAdMode = dJXDramaUnlockAdMode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.djx.core.business.base.FragMvpProxy
    public DramaDetailPresenter bindPresenter() {
        DramaDetailPresenter dramaDetailPresenter = new DramaDetailPresenter(this.mWidgetParams, this.mDrama);
        dramaDetailPresenter.setDrawPositions(this.mDrawPositions);
        dramaDetailPresenter.setT2WLog(this.mT2WLog);
        return dramaDetailPresenter;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected Object getLayoutId() {
        return Integer.valueOf(R.layout.djx_frag_drama_detail);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mT2WLog.sendInit();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void initData(Bundle bundle) {
        DJXBus.getInstance().addListener(this.mBusListener);
        resetCategory();
        initAdData();
        DramaManager.getInstance().uploadLocalHistory();
        if (this.mActiveLog == null) {
            ActiveLog activeLog = new ActiveLog(this.mContentView, this.mCategory, "skit_immersion", null);
            this.mActiveLog = activeLog;
            activeLog.putParam(ILogConst.Keys.KEY_MODE, "playlet");
            this.mActiveLog.putParam(ILogConst.Keys.INTERFACE_TYPE, DJXDramaUnlockAdMode.MODE_COMMON.equals(this.mAdMode) ? "sdk" : "api");
            if (TextUtils.isEmpty(this.mFromCategory)) {
                return;
            }
            if (this.mFromCategory.equals("mixed_feed")) {
                this.mActiveLog.putParam("enter_style", "mixed_feed");
            } else if (this.mFromCategory.equals(ILogConst.CATEGORY_SKIT_BANNER)) {
                this.mActiveLog.putParam("enter_style", ILogConst.CATEGORY_EXTERNAL_BANNER);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetCategory() {
        this.mCategory = "hotsoon_video_detail_draw";
        AdKey adKey = this.mAdKey;
        if (adKey != null) {
            adKey.category("hotsoon_video_detail_draw");
        }
        DramaDetailAdapter dramaDetailAdapter = this.mAdapter;
        if (dramaDetailAdapter != null) {
            dramaDetailAdapter.setCategory(this.mCategory);
        }
        ActiveLog activeLog = this.mActiveLog;
        if (activeLog != null) {
            activeLog.setCategory(this.mCategory);
        }
        this.mDramaLog.reset();
        this.mDramaLog.setParams(this.mCategory, this.mFromCategory, this.mFromGid, this.mCommonParams);
        this.mDramaLog.setDramaParams(this.mFreeSet);
    }

    private void initAdData() {
        if (DJXDramaUnlockAdMode.MODE_COMMON.equals(this.mAdMode)) {
            String dramaRewardedAdCodeId = DynamicManager.getInstance().getDramaRewardedAdCodeId();
            this.mAdKey = AdKey.obtain().codeId(dramaRewardedAdCodeId).paramsCode(this.mWidgetParams.hashCode()).category(this.mCategory).adCategory("skit_immersion").adType("reward").commonParams(constructAdCommonParams()).featureValues("skit_only");
            AdManager.inst().buildAdLoader(5, this.mAdKey, this.mDetailConfig.getAdListener());
            AdManager.inst().hasAd(this.mAdKey, 0);
        }
    }

    private Map<String, Object> constructAdCommonParams() {
        HashMap map = new HashMap();
        map.put(ILogConst.Keys.INTERFACE_TYPE, DJXDramaUnlockAdMode.MODE_COMMON.equals(this.mAdMode) ? "sdk" : "api");
        map.put(ILogConst.Keys.KEY_SKIT_ID, Long.valueOf(this.mDrama.id));
        map.put(ILogConst.Keys.KEY_MODE, "playet");
        return map;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void initView(View view) throws NoSuchMethodException, SecurityException {
        initRealScreenSize();
        DJXRefreshLayout2 dJXRefreshLayout2 = (DJXRefreshLayout2) findById(R.id.djx_drama_refresh);
        this.mRefreshLayout = dJXRefreshLayout2;
        dJXRefreshLayout2.setIsCanSecondFloor(false);
        this.mRefreshLayout.setRefreshView(new DJXDmtRefreshView(getContext()));
        this.mRefreshLayout.setRefreshEnable(true);
        this.mRefreshLayout.setRefreshHeight(UIUtil.dp2px(60.0f));
        this.mRefreshLayout.setPullToRefreshHeight(UIUtil.dp2px(70.0f));
        this.mRefreshLayout.setRefreshOffset(UIUtil.dp2px(30.0f));
        this.mRefreshLayout.setLoadView(new DJXDmtLoadView(getContext()));
        this.mRefreshLayout.setLoadHeight(UIUtil.dp2px(60.0f));
        this.mRefreshLayout.setLoadToRefreshHeight(UIUtil.dp2px(70.0f));
        this.mRefreshLayout.setLoadEnable(true);
        this.mRefreshLayout.setSlideListener(new DJXRefreshLayout2.OnSlideListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.4
            @Override // com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout2.OnSlideListener
            public void onSlideDown() {
                if (DJXDramaDetailFragment.this.getCurrentDramaIndex() <= 1) {
                    DJXDramaDetailFragment.this.toastCenter("已到顶部");
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout2.OnSlideListener
            public void onSlideUp() {
                if (DJXDramaDetailFragment.this.getCurrentDramaIndex() < DJXDramaDetailFragment.this.mDrama.total || DJXDramaDetailFragment.this.isCanInfiniteScroll()) {
                    return;
                }
                DJXDramaDetailFragment.this.toastCenter("已到底部");
            }
        });
        this.mRefreshLayout.setOnLoadListener(new DJXRefreshLayout.OnLoadListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.5
            @Override // com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout.OnLoadListener
            public void onLoad() {
                ((DramaDetailPresenter) DJXDramaDetailFragment.this.mPresenter).loadDramaAfter(false);
            }
        });
        this.mRefreshLayout.setOnRefreshListener(new DJXRefreshLayout.OnRefreshListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.6
            @Override // com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout.OnRefreshListener
            public void onRefresh() {
                ((DramaDetailPresenter) DJXDramaDetailFragment.this.mPresenter).loadDramaBefore();
            }
        });
        DJXDmtLoadingLayout dJXDmtLoadingLayout = (DJXDmtLoadingLayout) findById(R.id.djx_loading_layout);
        this.mLoadingLayout = dJXDmtLoadingLayout;
        dJXDmtLoadingLayout.setVisibility(0);
        DJXErrorView dJXErrorView = (DJXErrorView) findById(R.id.djx_drama_error_view);
        this.mDJXErrorView = dJXErrorView;
        dJXErrorView.setRetryListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (NetworkUtils.isActive(InnerManager.getContext())) {
                    DJXDramaDetailFragment.this.mT2WLog.setReqRetryNum(DJXDramaDetailFragment.this.mT2WLog.getReqRetryNum() + 1);
                    DJXDramaDetailFragment.this.mDJXErrorView.show(false);
                    ((DramaDetailPresenter) DJXDramaDetailFragment.this.mPresenter).loadDramaInit(DJXDramaDetailFragment.this.mDramaInitCursor);
                    return;
                }
                ToastUtil.show(InnerManager.getContext(), DJXDramaDetailFragment.this.getResources().getString(R.string.djx_str_no_network_tip));
            }
        });
        DramaDetailAdapter dramaDetailAdapter = new DramaDetailAdapter(getContext(), this.mDetailConfig, this.mCommonParams);
        this.mAdapter = dramaDetailAdapter;
        dramaDetailAdapter.setCategory(this.mCategory);
        this.mAdapter.setFromCategory(this.mFromCategory);
        this.mAdapter.setFromGid(this.mFromGid);
        this.mAdapter.setDrawListener(new DramaDetailAdapter.OnDrawListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.8
            @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailAdapter.OnDrawListener
            public long getRootGid() {
                return 0L;
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailAdapter.OnDrawListener
            public void onRenderFirstFrame() {
                DJXDramaDetailFragment.this.mT2WLog.sendFirstFrame(DJXDramaDetailFragment.this.mViewPager.getCurrentItem());
                DJXDramaDetailFragment.this.mLoadingLayout.setVisibility(4);
                DJXDramaDetailFragment.this.setDramaTips();
                if (DJXDramaDetailFragment.this.mDramaTipsShown) {
                    return;
                }
                if (!TextUtils.isEmpty(DJXDramaDetailFragment.this.mDrama.scriptAuthor) && !TextUtils.isEmpty(DJXDramaDetailFragment.this.mDrama.scriptName)) {
                    DJXDramaDetailFragment.this.mScriptTipsView.setVisibility(0);
                }
                if (!TextUtils.isEmpty(DJXDramaDetailFragment.this.mDrama.icpNumber)) {
                    DJXDramaDetailFragment.this.mIcpTipsView.setVisibility(0);
                }
                DJXDramaDetailFragment.this.mHandler.postDelayed(DJXDramaDetailFragment.this.mTipsAction, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailAdapter.OnDrawListener
            public void onVideoModelExpired(VideoM videoM) {
                if (videoM != null) {
                    try {
                        if (DJXDramaDetailFragment.this.mAdapter != null) {
                            int count = DJXDramaDetailFragment.this.mAdapter.getCount();
                            for (int i = 0; i < count; i++) {
                                Object itemData = DJXDramaDetailFragment.this.mAdapter.getItemData(i);
                                if (itemData instanceof DramaDetail) {
                                    DramaDetail dramaDetail = (DramaDetail) itemData;
                                    if (dramaDetail.getVideoModel() != null && !TextUtils.isEmpty(videoM.getVideoId()) && videoM.getVideoId().equals(dramaDetail.getVideoModel().getVideoId())) {
                                        dramaDetail.setVideoModel(videoM);
                                        return;
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailAdapter.OnDrawListener
            public void onVideoCompletion(boolean z) {
                if (SettingData.getInstance().isSkitContinue()) {
                    if (DJXDramaDetailFragment.this.mDramaListDialog == null || !DJXDramaDetailFragment.this.mDramaListDialog.isShowing()) {
                        if (DJXDramaDetailFragment.this.getCurrentDramaIndex() != DJXDramaDetailFragment.this.mDrama.total || !DJXDramaDetailFragment.this.isCanInfiniteScroll()) {
                            if (DJXDramaDetailFragment.this.mViewPager != null) {
                                DJXDramaDetailFragment.this.mViewPager.scrollNextItem(true);
                                return;
                            }
                            return;
                        }
                        ((DramaDetailPresenter) DJXDramaDetailFragment.this.mPresenter).loadDramaAfter(false);
                    }
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailAdapter.OnDrawListener
            public int getCurrentPosition() {
                return DJXDramaDetailFragment.this.mPosition;
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailAdapter.OnDrawListener
            public Context getActivity4Adapter() {
                return DJXDramaDetailFragment.this.getMyActivity() == null ? DJXDramaDetailFragment.this.getContext() : DJXDramaDetailFragment.this.getMyActivity();
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailAdapter.OnDrawListener
            public void onPlayStart(Object obj) throws IOException {
                if (obj instanceof DramaDetail) {
                    Drama dramaCopy = Drama.copy(DJXDramaDetailFragment.this.mDrama);
                    DramaDetail dramaDetail = (DramaDetail) obj;
                    dramaCopy.index = dramaDetail.getIndex();
                    dramaCopy.actionTime = System.currentTimeMillis() / 1000;
                    DramaManager.getInstance().saveLocalHistory(dramaCopy);
                    if (SettingData.getInstance().isEnableDramaCache()) {
                        DramaNetCacheManager.INSTANCE.saveDramaDetail(dramaDetail);
                    }
                    ApiManager.postDramaPlayAction(dramaCopy, new IApiCallback<DramaActionRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.8.1
                        @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                        public void onApiSuccess(DramaActionRsp dramaActionRsp) {
                            LG.d(DJXDramaDetailFragment.TAG, "postDramaPlay SUCCESS");
                        }

                        @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                        public void onApiFailure(DJXError dJXError, DramaActionRsp dramaActionRsp) {
                            LG.w(DJXDramaDetailFragment.TAG, "postDramaPlay failed, history will save into local");
                            DramaManager.historyStranded();
                        }
                    });
                }
                if (DJXDramaDetailFragment.this.mHasReportPlayFirst) {
                    return;
                }
                if (DJXDramaDetailFragment.this.mViewPager.getCurrentItem() == 0 && DJXDramaDetailFragment.this.mUIRenderStartTime > 0) {
                    System.currentTimeMillis();
                    long unused = DJXDramaDetailFragment.this.mUIRenderStartTime;
                }
                DJXDramaDetailFragment.this.mUIRenderStartTime = -1L;
                DJXDramaDetailFragment.this.mHasReportPlayFirst = true;
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailAdapter.OnDrawListener
            public void onClickDramaTitle(View view2, DramaDetail dramaDetail) {
                DJXDramaDetailFragment.this.showDramaListDialog(dramaDetail);
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailAdapter.OnDrawListener
            public boolean isBlock(DramaDetail dramaDetail) {
                return DJXDramaDetailFragment.this.isNeedLock(dramaDetail.getIndex());
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailAdapter.OnDrawListener
            public void unlockFlowStart(final DramaDetail dramaDetail) {
                DJXDramaDetailFragment.this.mViewPager.setCanScroll(false);
                DJXDramaDetailFragment.this.mIsUnlockFlowStarted.set(true);
                if (SettingData.getInstance().isIsInDramaBlackList()) {
                    DJXDramaDetailFragment.this.showRewardDialog(dramaDetail, DefaultDramaParamsWrapperKt.getDefaultDramaUnlockInfo(dramaDetail.getDrama()));
                    return;
                }
                LG.i(DJXDramaDetailFragment.TAG, "UnlockFlow1.start");
                DJXDramaDetailFragment.this.mDetailConfig.getUnlockListener().unlockFlowStart(dramaDetail.getDrama(), new IDJXDramaUnlockListener.UnlockCallback() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.8.2
                    @Override // com.bytedance.sdk.djx.interfaces.listener.IDJXDramaUnlockListener.UnlockCallback
                    public void onConfirm(DJXDramaUnlockInfo dJXDramaUnlockInfo) {
                        LG.i(DJXDramaDetailFragment.TAG, "UnlockFlow2.getUnlockInfo: " + dJXDramaUnlockInfo);
                        DJXDramaDetailFragment.this.mUnlockStartTime = SystemClock.elapsedRealtime();
                        if (dJXDramaUnlockInfo.getUnlockType() == DJXUnlockModeType.UNLOCKTYPE_CONTINUES && SettingData.getInstance().getConsecutiveUnlockingEnable() && !SettingData.getInstance().isIsInDramaBlackList()) {
                            DJXDramaDetailFragment.this.isContinuesUnlockMode = true;
                        }
                        DJXDramaDetailFragment.this.handleUnlockInfo(dramaDetail, dJXDramaUnlockInfo);
                        DJXDramaDetailFragment.this.mTLog.sendUnlockBegin(DJXDramaDetailFragment.this.mDrama.id, dJXDramaUnlockInfo.getMethod(), DJXDramaDetailFragment.this.mDetailConfig.getAdMode(), DJXDramaDetailFragment.this.isContinuesUnlockMode);
                    }
                }, DramaDetailHelper.createParamsMap(dramaDetail, DJXDramaDetailFragment.this.mDrama));
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailAdapter.OnDrawListener
            public boolean isRefreshFirst() {
                return DJXDramaDetailFragment.this.mRefreshFirstPosition == DJXDramaDetailFragment.this.mPosition;
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailAdapter.OnDrawListener
            public Map<String, Object> getSourceRecMap() {
                return DJXDramaDetailFragment.this.mSourceMap;
            }

            @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailAdapter.OnDrawListener
            public void deleteHolder(int i) {
                DJXDramaDetailFragment.this.mIsDeleteNeedCallback = !(r0.mAdapter.getItemData(DJXDramaDetailFragment.this.mViewPager.getCurrentItem()) instanceof DramaDetail);
                if (DJXDramaDetailFragment.this.mAdapter != null) {
                    DJXDramaDetailFragment.this.mAdapter.remove(i);
                }
                DJXDramaDetailFragment.this.mViewPager.post(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.8.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DJXDramaDetailFragment.this.mPageChangeListener != null) {
                            if (DJXDramaDetailFragment.this.mPrePosition > DJXDramaDetailFragment.this.mPosition) {
                                DJXDramaDetailFragment.this.mViewPager.setCurrentItem(DJXDramaDetailFragment.this.mViewPager.getCurrentItem() - 1);
                            }
                            if (DJXDramaDetailFragment.this.mAdapter != null) {
                                DJXDramaDetailFragment.this.mAdapter.setCurrent(-1);
                            }
                            DJXDramaDetailFragment.this.mPageChangeListener.onPageSelected(DJXDramaDetailFragment.this.mViewPager.getCurrentItem());
                        }
                    }
                });
            }
        });
        this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
        VerticalViewPager verticalViewPager = (VerticalViewPager) findById(R.id.djx_drama_pager);
        this.mViewPager = verticalViewPager;
        verticalViewPager.setNeedResetCurItem(true);
        this.mViewPager.setAdapter(this.mAdapter);
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setMinFlingDistance(SettingData.getInstance().getMinFlingDistance());
        this.mViewPager.setMinFlingVelocity(SettingData.getInstance().getMinFlingVelocity());
        this.mViewPager.setMinScrollDistance((float) SettingData.getInstance().getMinScrollDistance());
        this.mViewPager.setCanScroll(true);
        TextView textView = (TextView) findById(R.id.djx_script_tips);
        this.mScriptTipsView = textView;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        if (this.mDetailConfig.getScriptTipsTopMargin() > 0) {
            marginLayoutParams.topMargin = UIUtil.dp2px(this.mDetailConfig.getScriptTipsTopMargin());
        }
        TextView textView2 = (TextView) findById(R.id.djx_icp_tips);
        this.mIcpTipsView = textView2;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
        if (this.mDetailConfig.getIcpTipsBottomMargin() > 0) {
            marginLayoutParams2.bottomMargin = UIUtil.dp2px(this.mDetailConfig.getIcpTipsBottomMargin());
        }
        View viewFindById = findById(R.id.djx_drama_detail_title_layout);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) viewFindById.getLayoutParams();
        marginLayoutParams3.topMargin = this.mDetailConfig.getTopOffset() < 0 ? StatusBarUtil.getStatusBarHeight(getMyActivity()) + UIUtil.dp2px(16.0f) : UIUtil.dp2px(this.mDetailConfig.getTopOffset());
        viewFindById.setLayoutParams(marginLayoutParams3);
        this.mTitle = (TextView) findById(R.id.djx_drama_detail_title);
        View viewFindById2 = findById(R.id.djx_drama_detail_close);
        TextView textView3 = (TextView) findById(R.id.djx_drama_detail_title);
        this.mTitle = textView3;
        textView3.setVisibility(this.mDetailConfig.isHideTopInfo() ? 8 : 0);
        findById(R.id.djx_drama_detail_close).setVisibility(this.mDetailConfig.isHideBack() ? 8 : 0);
        viewFindById2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (DJXDramaDetailFragment.this.mDetailConfig.getCloseListener() != null) {
                    try {
                        DJXDramaDetailFragment.this.mDetailConfig.getCloseListener().onClick(view2);
                    } catch (Throwable th) {
                        LG.e(DJXDramaDetailFragment.TAG, "error occurred: IDJXDramaListener.mCloseListener.onClick()", th);
                    }
                } else if (DJXDramaDetailFragment.this.getMyActivity() != null) {
                    DJXDramaDetailFragment.this.getMyActivity().finish();
                }
                if (DJXDramaDetailFragment.this.mDetailConfig.getListener() != null) {
                    try {
                        DJXDramaDetailFragment.this.mDetailConfig.getListener().onDJXClose();
                    } catch (Throwable th2) {
                        LG.e(DJXDramaDetailFragment.TAG, "error occurred: IDJXDramaListener.onDJXClose()", th2);
                    }
                }
            }
        });
        final View viewFindById3 = findById(R.id.djx_drama_detail_more);
        viewFindById3.setVisibility(this.mDetailConfig.isHideMore() ? 8 : 0);
        viewFindById3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DJXDramaDetailFragment.this.showMore();
            }
        });
        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.11
            private int mCurrent = -1;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int index;
                if (DJXDramaDetailFragment.this.mActiveLog != null) {
                    DJXDramaDetailFragment.this.mActiveLog.active();
                }
                DramaDetailHolderBase holderByPosition = DJXDramaDetailFragment.this.getHolderByPosition(i);
                if (holderByPosition != null) {
                    Object data = holderByPosition.getData();
                    if (data instanceof DramaDetail) {
                        index = ((DramaDetail) data).getIndex();
                        DJXDramaDetailFragment.this.mTitle.setText(String.format(Locale.getDefault(), "第%d集", Integer.valueOf(index)));
                    } else {
                        if ((data instanceof DramaDrawAd) && !((DramaDrawAd) data).getIsAddView()) {
                            DJXDramaDetailFragment.this.mViewPager.scrollNextItem(true);
                            return;
                        }
                        index = 1;
                    }
                    boolean z = data instanceof DramaDrawAd;
                    DJXDramaDetailFragment.this.mTitle.setVisibility(z || DJXDramaDetailFragment.this.mDetailConfig.isHideTopInfo() ? 8 : 0);
                    viewFindById3.setVisibility(z || DJXDramaDetailFragment.this.mDetailConfig.isHideMore() ? 8 : 0);
                } else {
                    index = 1;
                }
                if (DJXDramaDetailFragment.this.mRefreshFirstPosition != i) {
                    DJXDramaDetailFragment.this.mRefreshFirstPosition = -1;
                }
                DJXDramaDetailFragment.this.playCurrentHolder(i);
                if (i >= DJXDramaDetailFragment.this.mAdapter.getCount() - 2 && index != DJXDramaDetailFragment.this.mDrama.total) {
                    ((DramaDetailPresenter) DJXDramaDetailFragment.this.mPresenter).loadDramaAfter(true);
                }
                int i2 = this.mCurrent;
                int i3 = i > i2 ? i + 1 : i < i2 ? i - 1 : -1;
                if (i3 > -1 && i3 < DJXDramaDetailFragment.this.mAdapter.getCount()) {
                    Object itemData = DJXDramaDetailFragment.this.mAdapter.getItemData(i3);
                    if (itemData instanceof DramaDetail) {
                        DJXDramaDetailFragment.this.videoService.preload(((DramaDetail) itemData).getVideoModel(), 819200L, (IPreloadCallback<VideoM>) null);
                    }
                }
                this.mCurrent = i;
                if (DJXDramaDetailFragment.this.mIsDeleteNeedCallback && DJXDramaDetailFragment.this.mDetailConfig.getListener() != null) {
                    try {
                        Map<String, Object> map = new HashMap<>();
                        Object itemData2 = DJXDramaDetailFragment.this.mAdapter.getItemData(i);
                        if (itemData2 instanceof DramaDetail) {
                            map = DramaDetailHelper.createParamsMap((DramaDetail) itemData2, DJXDramaDetailFragment.this.mDrama);
                        }
                        DJXDramaDetailFragment.this.mDetailConfig.getListener().onDJXPageChange(i, map);
                        LG.d(DJXDramaDetailFragment.TAG, "onDJXPageChange: " + i + ", map = " + map);
                    } catch (Throwable th) {
                        LG.e(DJXDramaDetailFragment.TAG, "error occurred: IDJXDramaListener.onDJXPageChange()", th);
                    }
                }
                DJXDramaDetailFragment.this.mIsDeleteNeedCallback = true;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0) {
                    ImageTag.resume(DJXDramaDetailFragment.this.getContext(), "drama_detail");
                } else {
                    ImageTag.pause(DJXDramaDetailFragment.this.getContext(), "drama_detail");
                }
            }
        };
        this.mPageChangeListener = onPageChangeListener;
        this.mViewPager.addOnPageChangeListener(onPageChangeListener);
        if (SettingData.getInstance().isEnableDramaCache()) {
            this.mViewPager.post(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m353x605d8af8();
                }
            });
        }
        this.mCustomBannerContainer = (FrameLayout) findById(R.id.djx_drama_banner);
        loadCustomBanner();
    }

    /* renamed from: lambda$initView$0$com-bytedance-sdk-djx-core-business-budrama-detail-DJXDramaDetailFragment, reason: not valid java name */
    /* synthetic */ void m353x605d8af8() {
        DramaDetailLoadFromCacheTask dramaDetailLoadFromCacheTask = this.mLoadCacheTask;
        if (dramaDetailLoadFromCacheTask != null) {
            dramaDetailLoadFromCacheTask.start();
        }
    }

    private void loadCustomBanner() {
        View detailAdBannerView;
        DJXDramaDetailConfig dJXDramaDetailConfig = this.mDetailConfig;
        if (dJXDramaDetailConfig == null || dJXDramaDetailConfig.getAdCustomProvider() == null || !SettingData.getInstance().isBannerCustomDetailOpen() || (detailAdBannerView = this.mDetailConfig.getAdCustomProvider().getDetailAdBannerView()) == null) {
            return;
        }
        this.mCustomBannerContainer.addView(detailAdBannerView);
        this.mCustomBannerContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUnlockInfo(DramaDetail dramaDetail, DJXDramaUnlockInfo dJXDramaUnlockInfo) {
        if (dJXDramaUnlockInfo.getHasMember()) {
            if (this.mFakeHasMember) {
                Activity myActivity = getMyActivity();
                if (myActivity != null) {
                    myActivity.finish();
                }
                throw new IllegalArgumentException("The user does not receive VIP benefits");
            }
            this.mDramaInitCursor = getCurrentDramaIndex();
            ((DramaDetailPresenter) this.mPresenter).loadDramaInit(this.mDramaInitCursor);
            this.mFakeHasMember = true;
            return;
        }
        if (dJXDramaUnlockInfo.getCancelUnlock()) {
            handleUnlockFlowEnd(false, dJXDramaUnlockInfo.getMethod(), dJXDramaUnlockInfo.getLockSet(), IDJXDramaUnlockListener.UnlockErrorStatus.USER_CANCEL, null, null);
            return;
        }
        int i = AnonymousClass23.$SwitchMap$com$bytedance$sdk$djx$model$DJXDramaUnlockMethod[dJXDramaUnlockInfo.getMethod().ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                unlockByPaySkit(dJXDramaUnlockInfo);
                return;
            }
            return;
        }
        if (this.mDetailConfig.isHideRewardDialog()) {
            showAd(dramaDetail, dJXDramaUnlockInfo.getSafeLockSet());
        } else {
            showRewardDialog(dramaDetail, dJXDramaUnlockInfo);
        }
    }

    private void unlockByPaySkit(final DJXDramaUnlockInfo dJXDramaUnlockInfo) {
        final IDJXService.IDJXCallback<DJXOrder> iDJXCallback = new IDJXService.IDJXCallback<DJXOrder>() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.12
            @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
            public void onSuccess(DJXOrder dJXOrder, DJXOthers dJXOthers) {
                DramaDetail currentDramaDetail = DJXDramaDetailFragment.this.getCurrentDramaDetail();
                Map<String, Object> map = new HashMap<>();
                if (currentDramaDetail != null) {
                    map = currentDramaDetail.getDrama().toMap();
                }
                DJXDramaDetailFragment.this.handleUnlockFlowEnd(true, dJXDramaUnlockInfo.getMethod(), dJXDramaUnlockInfo.getLockSet(), null, map, dJXOrder.combo == null ? null : Long.valueOf(dJXOrder.combo.duration));
                DJXDramaDetailFragment dJXDramaDetailFragment = DJXDramaDetailFragment.this;
                dJXDramaDetailFragment.mDramaInitCursor = dJXDramaDetailFragment.getCurrentDramaIndex();
                ((DramaDetailPresenter) DJXDramaDetailFragment.this.mPresenter).loadDramaInit(DJXDramaDetailFragment.this.mDramaInitCursor);
                if (DJXDramaDetailFragment.this.mIsUserVisible) {
                    DJXDramaDetailFragment dJXDramaDetailFragment2 = DJXDramaDetailFragment.this;
                    DramaDetailHolderBase holderByPosition = dJXDramaDetailFragment2.getHolderByPosition(dJXDramaDetailFragment2.mPosition);
                    if (holderByPosition instanceof DramaDetailHolder) {
                        ((DramaDetailHolder) holderByPosition).startBySendLog();
                    }
                }
            }

            @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
            public void onError(DJXError dJXError) {
                DJXDramaDetailFragment.this.handleUnlockFlowEnd(false, dJXDramaUnlockInfo.getMethod(), dJXDramaUnlockInfo.getLockSet(), IDJXDramaUnlockListener.UnlockErrorStatus.ERROR_PAY, null, null);
                if (!DJXDramaDetailFragment.this.mIsUserVisible) {
                    DJXDramaDetailFragment.this.mNeedRollback = true;
                    return;
                }
                ToastUtil.show(InnerManager.getContext(), "购买失败，请稍后重试");
                if (DJXDramaDetailFragment.this.mPosition > 0) {
                    DJXDramaDetailFragment.this.mViewPager.setCurrentItem(DJXDramaDetailFragment.this.mPosition - 1, true);
                }
            }
        };
        if (!TokenHelper.getInstance().isCustomLoginSuccess()) {
            DevInfo.sRouter.onLogin(new IDJXService.IDJXCallback<Boolean>() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.13
                @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
                public void onSuccess(Boolean bool, DJXOthers dJXOthers) {
                    PayInitHelper.pay(dJXDramaUnlockInfo.getOrderParams(), iDJXCallback);
                }

                @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
                public void onError(DJXError dJXError) {
                    iDJXCallback.onError(dJXError);
                }
            });
        } else {
            PayInitHelper.pay(dJXDramaUnlockInfo.getOrderParams(), iDJXCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRewardDialog(final DramaDetail dramaDetail, final DJXDramaUnlockInfo dJXDramaUnlockInfo) {
        DJXDramaRewardDialog dJXDramaRewardDialog = this.mRewardDialog;
        if (dJXDramaRewardDialog == null || !dJXDramaRewardDialog.isShowing()) {
            if (this.mDetailConfig.getListener() != null) {
                Map<String, Object> map = this.mDrama.toMap();
                map.put("index", Integer.valueOf(dramaDetail.getIndex()));
                map.put("group_id", Long.valueOf(dramaDetail.getGroupId()));
                this.mDetailConfig.getListener().onRewardDialogShow(map);
            }
            DJXDramaRewardDialog dJXDramaRewardDialog2 = new DJXDramaRewardDialog(getMyActivity(), dJXDramaUnlockInfo.getSafeLockSet(), this.mHasSelectedOver);
            this.mRewardDialog = dJXDramaRewardDialog2;
            dJXDramaRewardDialog2.setOnDramaRewardDialogListener(new DJXDramaRewardDialog.OnDramaRewardDialogListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.14
                @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaRewardDialog.OnDramaRewardDialogListener
                public void onConfirm() {
                    Map<String, Object> map2 = DJXDramaDetailFragment.this.mDrama.toMap();
                    map2.put("index", Integer.valueOf(dramaDetail.getIndex()));
                    map2.put("group_id", Long.valueOf(dramaDetail.getGroupId()));
                    if (DJXDramaDetailFragment.this.mDetailConfig.getListener() != null) {
                        DJXDramaDetailFragment.this.mDetailConfig.getListener().onUnlockDialogAction(IDJXDramaListener.UNLOCK_ACTION_CONFIRM, map2);
                    }
                    DJXDramaDetailFragment.this.showAd(dramaDetail, dJXDramaUnlockInfo.getSafeLockSet());
                }

                @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaRewardDialog.OnDramaRewardDialogListener
                public void onCancel() {
                    if (DJXDramaDetailFragment.this.mDetailConfig.getListener() != null) {
                        Map<String, Object> map2 = DJXDramaDetailFragment.this.mDrama.toMap();
                        map2.put("index", Integer.valueOf(dramaDetail.getIndex()));
                        map2.put("group_id", Long.valueOf(dramaDetail.getGroupId()));
                        DJXDramaDetailFragment.this.mDetailConfig.getListener().onUnlockDialogAction(IDJXDramaListener.UNLOCK_ACTION_CANCEL, map2);
                    }
                    Activity myActivity = DJXDramaDetailFragment.this.getMyActivity();
                    if (myActivity != null) {
                        myActivity.finish();
                    }
                }
            });
            this.mRewardDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAd(final DramaDetail dramaDetail, final int i) {
        LG.i(TAG, "UnlockFlow3.showAd: " + this.mDetailConfig.getAdMode());
        if (this.mHasReward) {
            rewardArrived(i);
            return;
        }
        int i2 = AnonymousClass23.$SwitchMap$com$bytedance$sdk$djx$model$DJXDramaUnlockAdMode[this.mDetailConfig.getAdMode().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            this.mDetailConfig.getUnlockListener().showCustomAd(dramaDetail.getDrama(), new IDJXDramaUnlockListener.CustomAdCallback() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.15
                @Override // com.bytedance.sdk.djx.interfaces.listener.IDJXDramaUnlockListener.CustomAdCallback
                public void onError() {
                    DJXDramaDetailFragment.this.handleUnlockFlowEnd(false, DJXDramaUnlockMethod.METHOD_AD, i, IDJXDramaUnlockListener.UnlockErrorStatus.ERROR_GET_VIDEO_AD_ERROR, null, null);
                }

                @Override // com.bytedance.sdk.djx.interfaces.listener.IDJXDramaUnlockListener.CustomAdCallback
                public void onShow(String str) {
                    LG.i(DJXDramaDetailFragment.TAG, "IDJXDramaListener.showCustomAd.onShow");
                    DJXDramaDetailFragment.this.hasCustomAdShown = true;
                    DJXDramaDetailFragment.this.mDramaLog.sendCustomAdShow(dramaDetail, str, DJXDramaDetailFragment.this.isContinuesUnlockMode);
                    DJXDramaDetailFragment.this.mBlockTime = SystemClock.elapsedRealtime();
                    DJXDramaDetailFragment.this.monitorCustomAd();
                }

                @Override // com.bytedance.sdk.djx.interfaces.listener.IDJXDramaUnlockListener.CustomAdCallback
                public void onRewardVerify(DJXRewardAdResult dJXRewardAdResult) {
                    if (DJXDramaDetailFragment.this.mIsUnlockFlowStarted.get()) {
                        LG.i(DJXDramaDetailFragment.TAG, "IDJXDramaListener.showCustomAd.onRewardVerify");
                        if (!DJXDramaDetailFragment.this.hasCustomAdShown) {
                            LG.e(DJXDramaDetailFragment.TAG, "onRewardVerify: plz show AD than invoke onShow first");
                            dramaDetail.getDrama().toMap();
                            DJXDramaDetailFragment.this.handleUnlockFlowEnd(false, DJXDramaUnlockMethod.METHOD_AD, i, IDJXDramaUnlockListener.UnlockErrorStatus.ERROR_AD_NOT_SHOWN, null, null);
                        } else if (dJXRewardAdResult.isSuccess()) {
                            DJXDramaDetailFragment.this.mDramaLog.sendCustomAdShowFinish(dramaDetail, DJXDramaDetailFragment.this.mBlockTime, DJXDramaDetailFragment.this.mDetailConfig.getAdMode(), DJXDramaDetailFragment.this.isContinuesUnlockMode);
                            DJXDramaDetailFragment.this.mBlockTime = -1L;
                            DJXDramaDetailFragment.this.rewardArrived(i);
                        } else {
                            DJXDramaDetailFragment.this.handleUnlockFlowEnd(false, DJXDramaUnlockMethod.METHOD_AD, i, IDJXDramaUnlockListener.UnlockErrorStatus.DEV_RETURN_VERIFY_FAILED, null, null);
                            LG.e(DJXDramaDetailFragment.TAG, "custom ad verify false");
                        }
                    }
                }
            });
        } else {
            IDJXAd ad = AdManager.inst().getAd(this.mAdKey);
            if (ad != null) {
                showSdkAd(ad, i);
            } else {
                this.mIsWaitingAd = true;
                this.mLastLockSet = i;
            }
        }
    }

    /* renamed from: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment$23, reason: invalid class name */
    static /* synthetic */ class AnonymousClass23 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$sdk$djx$model$DJXDramaUnlockAdMode;
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$sdk$djx$model$DJXDramaUnlockMethod;
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$sdk$djx$params$DJXWidgetDramaDetailParams$DJXDramaEnterFrom;

        static {
            int[] iArr = new int[DJXDramaUnlockAdMode.values().length];
            $SwitchMap$com$bytedance$sdk$djx$model$DJXDramaUnlockAdMode = iArr;
            try {
                iArr[DJXDramaUnlockAdMode.MODE_COMMON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$model$DJXDramaUnlockAdMode[DJXDramaUnlockAdMode.MODE_SPECIFIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[DJXDramaUnlockMethod.values().length];
            $SwitchMap$com$bytedance$sdk$djx$model$DJXDramaUnlockMethod = iArr2;
            try {
                iArr2[DJXDramaUnlockMethod.METHOD_AD.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$model$DJXDramaUnlockMethod[DJXDramaUnlockMethod.METHOD_PAY_SKIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$model$DJXDramaUnlockMethod[DJXDramaUnlockMethod.METHOD_PAY_MEMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[DJXWidgetDramaDetailParams.DJXDramaEnterFrom.values().length];
            $SwitchMap$com$bytedance$sdk$djx$params$DJXWidgetDramaDetailParams$DJXDramaEnterFrom = iArr3;
            try {
                iArr3[DJXWidgetDramaDetailParams.DJXDramaEnterFrom.DRAMA_CARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$params$DJXWidgetDramaDetailParams$DJXDramaEnterFrom[DJXWidgetDramaDetailParams.DJXDramaEnterFrom.DRAMA_HISTORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$params$DJXWidgetDramaDetailParams$DJXDramaEnterFrom[DJXWidgetDramaDetailParams.DJXDramaEnterFrom.DRAMA_HOME_RECENTLY_WATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$params$DJXWidgetDramaDetailParams$DJXDramaEnterFrom[DJXWidgetDramaDetailParams.DJXDramaEnterFrom.SKIT_MIXED.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$params$DJXWidgetDramaDetailParams$DJXDramaEnterFrom[DJXWidgetDramaDetailParams.DJXDramaEnterFrom.DEFAULT.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void monitorCustomAd() {
        TTExecutor.get().delayExecuteTask(new TTRunnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.16
            public void run() {
                try {
                    Activity topActivity = ActivityStackUtils.getTopActivity();
                    if (topActivity == null || DJXDramaDetailFragment.this.getCurrentDramaDetail() == null) {
                        return;
                    }
                    String localClassName = topActivity.getLocalClassName();
                    DJXDramaDetailFragment.this.mDramaLog.sendCustomAdCheck(DJXDramaDetailFragment.this.getCurrentDramaDetail(), localClassName, localClassName.equals("com.bytedance.sdk.djx.core.act.DJXDramaDetailActivity") ? 0 : 1, DJXDramaDetailFragment.this.isContinuesUnlockMode);
                } catch (Throwable unused) {
                }
            }
        }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSdkAd(final IDJXAd iDJXAd, final int i) {
        this.mRewardVerifyCallback = false;
        final Map<String, Object> mediaExtraInfo = iDJXAd.getMediaExtraInfo();
        iDJXAd.setRewardVideoListener(new IDJXAd.RewardVideoListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.17
            @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.ExpressVideoAdListener
            public void onClickRetry() {
            }

            @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.ExpressVideoAdListener
            public void onProgressUpdate(long j, long j2) {
            }

            @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.ExpressVideoAdListener
            public void onVideoLoad() {
            }

            @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.RewardVideoListener
            public void onRewardVerify(boolean z, int i2, String str, int i3, String str2) {
                if (z) {
                    DJXDramaDetailFragment.this.mRewardVerifyCallback = true;
                    DJXDramaDetailFragment.this.rewardArrived(i);
                }
                if (AdManager.inst().mAdListenerMap == null || DJXDramaDetailFragment.this.mAdKey == null) {
                    return;
                }
                HashMap map = new HashMap();
                AdVideoCallbackUtil.addCallbackParams(map, DJXDramaDetailFragment.this.mAdKey, iDJXAd, null);
                Map map2 = mediaExtraInfo;
                if (map2 != null) {
                    map.putAll(map2);
                }
                map.put("reward_verify", Boolean.valueOf(z));
                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(DJXDramaDetailFragment.this.mAdKey.getParamsCode()));
                if (iDJXAdListener != null) {
                    iDJXAdListener.onRewardVerify(map);
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.RewardVideoListener
            public void onSkippedVideo() {
                if (AdManager.inst().mAdListenerMap != null && DJXDramaDetailFragment.this.mAdKey != null) {
                    HashMap map = new HashMap();
                    AdVideoCallbackUtil.addCallbackParams(map, DJXDramaDetailFragment.this.mAdKey, iDJXAd, null);
                    Map map2 = mediaExtraInfo;
                    if (map2 != null) {
                        map.putAll(map2);
                    }
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(DJXDramaDetailFragment.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onSkippedVideo(map);
                    }
                }
                if (!DJXDramaDetailFragment.this.mIsUnlockFlowStarted.get() || DJXDramaDetailFragment.this.mRewardVerifyCallback) {
                    return;
                }
                DJXDramaDetailFragment.this.handleUnlockFlowEnd(false, DJXDramaUnlockMethod.METHOD_AD, DJXDramaDetailFragment.this.mLastLockSet, IDJXDramaUnlockListener.UnlockErrorStatus.USER_SKIP_AD, null, null);
                LG.e(DJXDramaDetailFragment.TAG, "csj ad reward skip");
                if (DJXDramaDetailFragment.this.mIsUserVisible) {
                    if (DJXDramaDetailFragment.this.mPosition > 0) {
                        DJXDramaDetailFragment.this.mViewPager.setCurrentItem(DJXDramaDetailFragment.this.mPosition - 1, true);
                        return;
                    }
                    return;
                }
                DJXDramaDetailFragment.this.mNeedRollback = true;
            }

            @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.AdInteractionListener
            public void onAdClicked(View view, IDJXAd iDJXAd2) {
                if (AdManager.inst().mAdListenerMap == null || DJXDramaDetailFragment.this.mAdKey == null) {
                    return;
                }
                HashMap map = new HashMap();
                AdVideoCallbackUtil.addCallbackParams(map, DJXDramaDetailFragment.this.mAdKey, iDJXAd, null);
                Map map2 = mediaExtraInfo;
                if (map2 != null) {
                    map.putAll(map2);
                }
                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(DJXDramaDetailFragment.this.mAdKey.getParamsCode()));
                if (iDJXAdListener != null) {
                    iDJXAdListener.onDJXAdClicked(map);
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.AdInteractionListener
            public void onAdCreativeClick(View view, IDJXAd iDJXAd2) {
                if (AdManager.inst().mAdListenerMap == null || DJXDramaDetailFragment.this.mAdKey == null) {
                    return;
                }
                HashMap map = new HashMap();
                AdVideoCallbackUtil.addCallbackParams(map, DJXDramaDetailFragment.this.mAdKey, iDJXAd, null);
                Map map2 = mediaExtraInfo;
                if (map2 != null) {
                    map.putAll(map2);
                }
                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(DJXDramaDetailFragment.this.mAdKey.getParamsCode()));
                if (iDJXAdListener != null) {
                    iDJXAdListener.onDJXAdClicked(map);
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.AdInteractionListener
            public void onAdShow(IDJXAd iDJXAd2) {
                if (AdManager.inst().mAdListenerMap == null || DJXDramaDetailFragment.this.mAdKey == null) {
                    return;
                }
                HashMap map = new HashMap();
                AdVideoCallbackUtil.addCallbackParams(map, DJXDramaDetailFragment.this.mAdKey, iDJXAd, null);
                Map map2 = mediaExtraInfo;
                if (map2 != null) {
                    map.putAll(map2);
                }
                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(DJXDramaDetailFragment.this.mAdKey.getParamsCode()));
                if (iDJXAdListener != null) {
                    iDJXAdListener.onDJXAdShow(map);
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.ExpressVideoAdListener
            public void onVideoError(int i2, int i3) {
                DJXDramaDetailFragment.this.handleUnlockFlowEnd(false, DJXDramaUnlockMethod.METHOD_AD, i, IDJXDramaUnlockListener.UnlockErrorStatus.ERROR_AD_ERROR, null, null);
                LG.e(DJXDramaDetailFragment.TAG, "csj ad onVideoError, errCode = " + i2 + "extraCode = " + i3);
                if (!DJXDramaDetailFragment.this.mIsUserVisible) {
                    DJXDramaDetailFragment.this.mNeedRollback = true;
                    return;
                }
                ToastUtil.show(InnerManager.getContext(), "广告异常，请稍后重试");
                if (DJXDramaDetailFragment.this.mPosition > 0) {
                    DJXDramaDetailFragment.this.mViewPager.setCurrentItem(DJXDramaDetailFragment.this.mPosition - 1, true);
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.ExpressVideoAdListener
            public void onVideoAdStartPlay() {
                if (AdManager.inst().mAdListenerMap == null || DJXDramaDetailFragment.this.mAdKey == null) {
                    return;
                }
                HashMap map = new HashMap();
                AdVideoCallbackUtil.addCallbackParams(map, DJXDramaDetailFragment.this.mAdKey, iDJXAd, null);
                AdVideoCallbackUtil.addTotalDuration(iDJXAd.getVideoDuration(), map);
                Map map2 = mediaExtraInfo;
                if (map2 != null) {
                    map.putAll(map2);
                }
                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(DJXDramaDetailFragment.this.mAdKey.getParamsCode()));
                if (iDJXAdListener != null) {
                    iDJXAdListener.onDJXAdPlayStart(map);
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.ExpressVideoAdListener
            public void onVideoAdPaused(long j, long j2) {
                if (AdManager.inst().mAdListenerMap == null || DJXDramaDetailFragment.this.mAdKey == null) {
                    return;
                }
                HashMap map = new HashMap();
                AdVideoCallbackUtil.addCallbackParams(map, DJXDramaDetailFragment.this.mAdKey, iDJXAd, null);
                AdVideoCallbackUtil.addTotalDuration(iDJXAd.getVideoDuration(), map);
                Map map2 = mediaExtraInfo;
                if (map2 != null) {
                    map.putAll(map2);
                }
                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(DJXDramaDetailFragment.this.mAdKey.getParamsCode()));
                if (iDJXAdListener != null) {
                    iDJXAdListener.onDJXAdPlayPause(map);
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.ExpressVideoAdListener
            public void onVideoAdContinuePlay() {
                if (AdManager.inst().mAdListenerMap == null || DJXDramaDetailFragment.this.mAdKey == null) {
                    return;
                }
                HashMap map = new HashMap();
                AdVideoCallbackUtil.addCallbackParams(map, DJXDramaDetailFragment.this.mAdKey, iDJXAd, null);
                AdVideoCallbackUtil.addTotalDuration(iDJXAd.getVideoDuration(), map);
                Map map2 = mediaExtraInfo;
                if (map2 != null) {
                    map.putAll(map2);
                }
                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(DJXDramaDetailFragment.this.mAdKey.getParamsCode()));
                if (iDJXAdListener != null) {
                    iDJXAdListener.onDJXAdPlayContinue(map);
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.ExpressVideoAdListener
            public void onVideoAdComplete(long j) {
                if (AdManager.inst().mAdListenerMap == null || DJXDramaDetailFragment.this.mAdKey == null) {
                    return;
                }
                HashMap map = new HashMap();
                AdVideoCallbackUtil.addCallbackParams(map, DJXDramaDetailFragment.this.mAdKey, iDJXAd, null);
                AdVideoCallbackUtil.addTotalDuration(iDJXAd.getVideoDuration(), map);
                Map map2 = mediaExtraInfo;
                if (map2 != null) {
                    map.putAll(map2);
                }
                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(DJXDramaDetailFragment.this.mAdKey.getParamsCode()));
                if (iDJXAdListener != null) {
                    iDJXAdListener.onDJXAdPlayComplete(map);
                }
            }
        });
        iDJXAd.show(getContext());
        this.mHasSelectedOver = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewardArrived(int i) {
        LG.i(TAG, "UnlockFlow4.unlock: " + getCurrentDramaDetail());
        DJXDramaRewardDialog dJXDramaRewardDialog = this.mRewardDialog;
        if (dJXDramaRewardDialog != null && dJXDramaRewardDialog.isShowing()) {
            this.mRewardDialog.dismiss();
        }
        ((DramaDetailPresenter) this.mPresenter).unlockDrama(getRealDramaIndex(), this.mDetailConfig.getFreeSet(), i, this.isContinuesUnlockMode, this.showContinuesDialogCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMore() {
        if (this.mAdapter.getItemData(this.mViewPager.getCurrentItem()) instanceof DramaDrawAd) {
            return;
        }
        DJXShareDialog dJXShareDialog = this.mShareDialog;
        if (dJXShareDialog == null || !dJXShareDialog.isShowing()) {
            DJXShareDialog dJXShareDialogBuild = DJXShareDialog.build(getMyActivity());
            this.mShareDialog = dJXShareDialogBuild;
            dJXShareDialogBuild.setShowPrivacySetting(true);
            this.mShareDialog.setListener(new DJXShareDialog.OnShareDialogListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.18
                @Override // com.bytedance.sdk.djx.core.business.view.share.DJXShareDialog.OnShareDialogListener
                public void onClick(String str) {
                    if (str.equals("report")) {
                        DramaDetail dramaDetail = (DramaDetail) DJXDramaDetailFragment.this.mAdapter.getItemData(DJXDramaDetailFragment.this.mViewPager.getCurrentItem());
                        Context context = DJXDramaDetailFragment.this.getMyActivity() == null ? DJXDramaDetailFragment.this.getContext() : DJXDramaDetailFragment.this.getMyActivity();
                        if (DJXDramaDetailFragment.this.mDetailConfig.getReportDelegate() == null) {
                            DJXReportActivity.go(DJXReportParams.obtain().position(DJXDramaDetailFragment.this.mViewPager.getCurrentItem()).category(DJXDramaDetailFragment.this.mCategory).source(DJXReportParams.DRAW_REPORT_SOURCE).dramaDetail(DJXDramaDetailFragment.this.getCurrentDramaDetail()).reportListener(new DJXReportParams.IDJXReportCallback() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.18.1
                                @Override // com.bytedance.sdk.djx.core.business.bureport.DJXReportParams.IDJXReportCallback
                                public void onClose(FragProxy fragProxy) {
                                }

                                @Override // com.bytedance.sdk.djx.core.business.bureport.DJXReportParams.IDJXReportCallback
                                public void onOpen(FragProxy fragProxy) {
                                }

                                @Override // com.bytedance.sdk.djx.core.business.bureport.DJXReportParams.IDJXReportCallback
                                public void onDJXReportResult(boolean z, Map<String, Object> map) {
                                    if (z) {
                                        ToastUtil.show(InnerManager.getContext(), DJXDramaDetailFragment.this.getResources().getString(R.string.djx_report_success_tip));
                                    } else {
                                        ToastUtil.show(InnerManager.getContext(), DJXDramaDetailFragment.this.getResources().getString(R.string.djx_report_fail_tip));
                                    }
                                }
                            }));
                            return;
                        } else if (dramaDetail != null) {
                            DJXDramaDetailFragment.this.mDetailConfig.getReportDelegate().onEnter(context, dramaDetail.getGroupId());
                            return;
                        } else {
                            LG.e(DJXDramaDetailFragment.TAG, "report view launch failed, DramaDetail is null");
                            return;
                        }
                    }
                    if (str.equals(DJXShareConfig.CHANNEL_NAME.PRIVACY_SETTING)) {
                        DJXPrivacySettingActivity.go(null);
                    }
                }
            });
            this.mShareDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDramaTips() {
        this.mHandler.removeCallbacks(this.mTipsAction);
        if (!TextUtils.isEmpty(this.mDrama.scriptAuthor) && !TextUtils.isEmpty(this.mDrama.scriptName)) {
            this.mScriptTipsView.setText(String.format("改编自番茄小说《%s》\n（作者：%s）", this.mDrama.scriptName, this.mDrama.scriptAuthor));
        } else {
            this.mScriptTipsView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mDrama.icpNumber)) {
            this.mIcpTipsView.setText(String.format("备案号：%s", this.mDrama.icpNumber));
        } else {
            this.mIcpTipsView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDramaListDialog(final DramaDetail dramaDetail) {
        DJXDramaListDialog dJXDramaListDialog = this.mDramaListDialog;
        if ((dJXDramaListDialog == null || !dJXDramaListDialog.isShowing()) && dramaDetail != null) {
            if (this.mDetailConfig.getListener() != null) {
                Map<String, Object> map = this.mDrama.toMap();
                map.put("index", Integer.valueOf(dramaDetail.getIndex()));
                map.put("group_id", Long.valueOf(dramaDetail.getGroupId()));
                this.mDetailConfig.getListener().onDramaGalleryShow(map);
            }
            DJXDramaListDialog dJXDramaListDialog2 = new DJXDramaListDialog(getMyActivity());
            this.mDramaListDialog = dJXDramaListDialog2;
            dJXDramaListDialog2.setDrama(this.mDrama);
            Object currentData = getCurrentData();
            if (currentData instanceof DramaDetail) {
                this.mDramaListDialog.setInitIndex(((DramaDetail) currentData).getIndex());
            }
            this.mDramaListDialog.setDramaListDialogListener(new DJXDramaListDialog.OnDramaListDialogListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment.19
                @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaListDialog.OnDramaListDialogListener
                public void onItemClick(int i) {
                    if (DJXDramaDetailFragment.this.mDetailConfig.getListener() != null) {
                        Map<String, Object> map2 = DJXDramaDetailFragment.this.mDrama.toMap();
                        map2.put("index", Integer.valueOf(dramaDetail.getIndex()));
                        map2.put("index_selected", Integer.valueOf(i));
                        map2.put("group_id", Long.valueOf(dramaDetail.getGroupId()));
                        DJXDramaDetailFragment.this.mDetailConfig.getListener().onDramaGalleryClick(map2);
                    }
                    if (i == DJXDramaDetailFragment.this.getCurrentDramaIndex()) {
                        return;
                    }
                    DJXDramaDetailFragment.this.mAdapter.removeAll();
                    DJXDramaDetailFragment.this.mDramaInitCursor = i;
                    ((DramaDetailPresenter) DJXDramaDetailFragment.this.mPresenter).loadDramaInit(i);
                }

                @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaListDialog.OnDramaListDialogListener
                public boolean isNeedLock(DJXDramaListDialog.DramaItem dramaItem) {
                    return DJXDramaDetailFragment.this.isNeedLock(dramaItem.index);
                }

                @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaListDialog.OnDramaListDialogListener
                public boolean isCurrentIndex(int i) {
                    return i == DJXDramaDetailFragment.this.getCurrentDramaIndex();
                }
            });
            this.mDramaListDialog.show();
        }
    }

    private void initRealScreenSize() throws NoSuchMethodException, SecurityException {
        int height;
        int i;
        if (getMyActivity() == null) {
            sRealScreenWidthPixels = UIUtil.getScreenWidth(InnerManager.getContext());
            sRealScreenHeightPixels = UIUtil.getScreenHeight(InnerManager.getContext());
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playCurrentHolder(int i) {
        DramaDetailAdapter dramaDetailAdapter;
        int i2;
        if (i == 0 && !this.mIsUserVisible && this.mIsPlayFirst) {
            return;
        }
        this.mPrePosition = this.mPosition;
        this.mPosition = i;
        DramaDetailHolderBase<?> holderByPosition = getHolderByPosition(i);
        boolean z = holderByPosition instanceof DramaDetailHolder;
        if (z) {
            ((DramaDetailHolder) holderByPosition).setSpeed(this.mSpeedPlayManager.getDramaSpeed(getCurrentDramaDetail().getSkitId()), SpeedScopeType.DRAMA);
        }
        if (z && (i2 = this.mFirstPlayDuration) > 0) {
            ((DramaDetailHolder) holderByPosition).setResumeDuration(i2);
            this.mFirstPlayDuration = -1;
        }
        if (holderByPosition != null && (dramaDetailAdapter = this.mAdapter) != null) {
            dramaDetailAdapter.onPageSelected(i, holderByPosition);
        }
        this.mIsPlayFirst = false;
    }

    private void setCurrentHolderSpeed(int i) {
        DramaDetailHolderBase<?> holderByPosition = getHolderByPosition(i);
        if (holderByPosition instanceof DramaDetailHolder) {
            ((DramaDetailHolder) holderByPosition).setSpeed(this.mSpeedPlayManager.getEpisodeSpeed(), SpeedScopeType.EPISODE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DramaDetailHolderBase<?> getHolderByPosition(int i) {
        List<DramaDetailHolderBase<?>> currentHolders = getCurrentHolders();
        for (int i2 = 0; i2 < currentHolders.size(); i2++) {
            DramaDetailHolderBase<?> dramaDetailHolderBase = currentHolders.get(i2);
            if (i == dramaDetailHolderBase.getAdapterPosition()) {
                return dramaDetailHolderBase;
            }
        }
        return null;
    }

    private List<DramaDetailHolderBase<?>> getCurrentHolders() {
        ArrayList arrayList = new ArrayList();
        int childCount = this.mViewPager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mViewPager.getChildAt(i);
            if (childAt.getTag() instanceof DramaDetailHolderBase) {
                arrayList.add((DramaDetailHolderBase) childAt.getTag());
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMvpProxy, com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void processLogic() {
        this.mT2WLog.sendViewFinish();
        super.processLogic();
        DJXBus.getInstance().addListener(this.mConfigBusListener);
        int networkType = NetworkUtils.getNetworkType(InnerManager.getContext());
        ((DramaDetailPresenter) this.mPresenter).loadDramaInit(this.mDramaInitCursor);
        this.mNetChangedListener.onNetChanged(networkType, networkType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFirstLockedIndex(int i) {
        List<DJXEpisodeStatus> list = this.mDrama.episodeStatusList;
        if (i < 1 || i > list.size() || list == null) {
            return -1;
        }
        for (int i2 = i - 1; i2 < list.size(); i2++) {
            DJXEpisodeStatus dJXEpisodeStatus = list.get(i2);
            if (dJXEpisodeStatus.isLocked() && dJXEpisodeStatus.getIndex() != i) {
                this.firstUnLockIndex = dJXEpisodeStatus.getIndex();
                return dJXEpisodeStatus.getIndex();
            }
        }
        return -1;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void onFragmentShow() {
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
            DramaDetailAdapter dramaDetailAdapter = this.mAdapter;
            if (dramaDetailAdapter != null) {
                dramaDetailAdapter.onUserVisible();
            }
        }
        if (this.mNeedRollback) {
            ToastUtil.show(InnerManager.getContext(), "解锁异常，奖励已保留，请稍后重试");
            if (this.mPosition > 0) {
                if (this.isContinuesUnlockMode && ((DramaDetailPresenter) this.mPresenter).getUnlockList() != null && ((DramaDetailPresenter) this.mPresenter).getUnlockList().contains(Integer.valueOf(getCurrentDramaIndex()))) {
                    this.mViewPager.setCurrentItem(this.mPosition, true);
                    ((DramaDetailPresenter) this.mPresenter).unLockDrama();
                } else {
                    this.mViewPager.setCurrentItem(this.mPosition - 1, true);
                }
            }
            this.mNeedRollback = false;
        }
        ActiveLog activeLog = this.mActiveLog;
        if (activeLog != null) {
            activeLog.startCheckingShow();
        }
        this.mStartTime = System.currentTimeMillis();
        this.mUIRenderStartTime = System.currentTimeMillis();
        ImageTag.resume(InnerManager.getContext(), "drama_detail");
        this.mTLog.sendPageEvent(ILogConst.Params.SCENE_PLAY_PAGE, ILogConst.EVENT_T_SHOW, this.mDrama, SdkTLog.INSTANCE.getEnterScene(this.mWidgetParams.mFrom));
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void onFragmentHide() {
        super.onFragmentHide();
        this.mT2WLog.setIsFragmentShow(false);
        if (this.mCategory != null && this.mStartTime > 0) {
            this.mStartTime = -1L;
        }
        this.mIsUserVisible = false;
        DJXGlobalReceiver.removeListener(this.mNetChangedListener);
        DramaDetailAdapter dramaDetailAdapter = this.mAdapter;
        if (dramaDetailAdapter != null) {
            dramaDetailAdapter.onUserInvisible();
            LG.i(TAG, "DJXDrawFragment onUserInvisible");
        }
        ActiveLog activeLog = this.mActiveLog;
        if (activeLog != null) {
            activeLog.stopCheckingShow();
        }
        ImageTag.pause(InnerManager.getContext(), "drama_detail");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toastCenter(String str) {
        ToastUtil.showCenter(InnerManager.getContext(), View.inflate(getMyActivity(), R.layout.djx_view_toast_draw, null), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetVodPreload() {
        DramaDetailAdapter dramaDetailAdapter = this.mAdapter;
        if (dramaDetailAdapter == null || dramaDetailAdapter.getCount() <= 0 || !this.videoService.isNewPreload()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.mAdapter.getList()) {
            if (obj instanceof DramaDetail) {
                DramaDetail dramaDetail = (DramaDetail) obj;
                if (dramaDetail.getVideoModel() != null) {
                    arrayList.add(dramaDetail.getVideoModel());
                }
            }
        }
        this.videoService.preload(arrayList);
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailContract.View
    public void onLoadDrama(int i, boolean z, boolean z2, List list, boolean z3, Drama drama, long j, boolean z4) throws IOException {
        if (z && !z4) {
            DramaDetailLoadFromCacheTask dramaDetailLoadFromCacheTask = this.mLoadCacheTask;
            if (dramaDetailLoadFromCacheTask != null) {
                this.mT2WLog.sendReqEnd(i == 0, i, "", dramaDetailLoadFromCacheTask.getStatus());
            } else {
                this.mT2WLog.sendReqEnd(i == 0, i, "", null);
            }
        }
        if (i == -4 || i == -1) {
            ToastUtil.show(InnerManager.getContext(), getResources().getString(R.string.djx_str_network_error_retry));
            if (z) {
                this.mDJXErrorView.show(true);
            }
            this.mHasSelectedOver = false;
            return;
        }
        if (i == -8) {
            this.mDJXErrorView.show(true);
            this.mAdapter.removeAll();
            return;
        }
        if (z) {
            if (drama != null) {
                this.mDrama = drama;
                this.mDramaLog.setDramaParams(this.mFreeSet);
            }
            if (z3) {
                this.mAdapter.setPlaySource(ILogConst.PLAY_SOURCE_DRAW_REC);
                this.mRefreshLayout.setLoading(false);
                if (i != 0 || list == null || list.isEmpty()) {
                    return;
                }
                ToastUtil.show(InnerManager.getContext(), getResources().getString(R.string.djx_tips_drama_switch));
                switchNewDrama(drama);
                this.mViewPager.setDefaultCurrentItem(0);
                this.mAdapter.refresh(list);
                this.mRefreshFirstPosition = 0;
            } else {
                if (i != 0) {
                    this.mDJXErrorView.show(true);
                    return;
                }
                if (list == null || list.isEmpty()) {
                    this.mDJXErrorView.show(true);
                    this.mAdapter.removeAll();
                    return;
                }
                int iFindPositionByIndex = findPositionByIndex(this.mDramaInitCursor, list);
                if (z4 && iFindPositionByIndex != -1) {
                    this.mAdapter.append(list.subList(iFindPositionByIndex + 1, list.size()));
                    this.mAdapter.append(0, list.subList(0, iFindPositionByIndex));
                    if ((list.get(iFindPositionByIndex) instanceof DramaDetail) && drama != null && drama.episodeStatusList != null) {
                        DramaNetCacheManager.INSTANCE.updateDramaDetail((DramaDetail) list.get(iFindPositionByIndex), drama.episodeStatusList);
                    }
                    this.mAdapter.updateItem(iFindPositionByIndex, list.get(iFindPositionByIndex));
                } else {
                    this.mViewPager.setDefaultCurrentItem(iFindPositionByIndex);
                    this.mAdapter.refresh(list);
                    this.mRefreshFirstPosition = iFindPositionByIndex;
                }
            }
            this.mIsInitLoadFinished = true;
        } else {
            this.mHasSelectedOver = false;
            if (z2) {
                this.mAdapter.append((List<Object>) list);
                this.mRefreshLayout.setLoading(false);
            } else {
                this.mAdapter.append(0, list);
                this.mRefreshLayout.setRefreshing(false);
            }
        }
        this.mRefreshLayout.setRefreshEnable(((DramaDetailPresenter) this.mPresenter).getDramaPullDownEnable());
        if (!isCanInfiniteScroll()) {
            this.mRefreshLayout.setLoadEnable(((DramaDetailPresenter) this.mPresenter).getDramaLoadMoreEnable());
        } else if (j > 0) {
            this.mDramaLog.sendDrawReq(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCanInfiniteScroll() {
        String str = this.mFromCategory;
        if (str == null || str.isEmpty()) {
            return this.mDetailConfig.isInfiniteScrollEnabled();
        }
        return this.mDetailConfig.isInfiniteScrollEnabled() && (this.mFromCategory.equals(ILogConst.CATEGORY_ME_DRAMA_HISTORY) ^ true);
    }

    private void switchNewDrama(Drama drama) {
        this.mDrama = drama;
        DJXDramaListDialog dJXDramaListDialog = this.mDramaListDialog;
        if (dJXDramaListDialog != null) {
            if (dJXDramaListDialog.isShowing()) {
                this.mDramaListDialog.dismiss();
            }
            this.mDramaListDialog = null;
        }
        this.mDramaLog.setDramaParams(this.mFreeSet);
        this.mDramaTipsShown = false;
        setDramaTips();
        if (this.mDetailConfig.getListener() != null) {
            this.mDetailConfig.getListener().onDramaSwitch(this.mDrama.toMap());
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailContract.View
    public void onUnlockDrama(int i, int i2, List<Integer> list) {
        if (i == 0) {
            DramaDetail currentDramaDetail = getCurrentDramaDetail();
            Map<String, Object> map = new HashMap<>();
            if (currentDramaDetail != null) {
                int index = (currentDramaDetail.getIndex() + i2) - 1;
                if (!list.isEmpty() && list.get(list.size() - 1) != null) {
                    index = list.get(list.size() - 1).intValue();
                }
                this.mDramaLog.sendUnlockEvent(currentDramaDetail, i2, index, this.mDetailConfig.getAdMode());
                map = currentDramaDetail.getDrama().toMap();
            }
            handleUnlockFlowEnd(true, DJXDramaUnlockMethod.METHOD_AD, i2, null, map, null);
            this.mDramaInitCursor = getCurrentDramaIndex();
            ((DramaDetailPresenter) this.mPresenter).loadDramaInit(this.mDramaInitCursor);
            if (this.mIsUserVisible) {
                DramaDetailHolderBase<?> holderByPosition = getHolderByPosition(this.mPosition);
                if (holderByPosition instanceof DramaDetailHolder) {
                    ((DramaDetailHolder) holderByPosition).startBySendLog();
                }
            }
            this.mHasReward = false;
            return;
        }
        handleUnlockFlowEnd(false, DJXDramaUnlockMethod.METHOD_AD, i2, IDJXDramaUnlockListener.UnlockErrorStatus.ERROR_REQUEST_ERROR, null, null);
        LG.e(TAG, "unlock request error code = " + i);
        if (this.mIsUserVisible) {
            ToastUtil.show(InnerManager.getContext(), "解锁异常，奖励已保留，请稍后重试");
            int i3 = this.mPosition;
            if (i3 > 0) {
                this.mViewPager.setCurrentItem(i3 - 1, true);
            }
        } else {
            this.mNeedRollback = true;
        }
        this.mHasReward = true;
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailContract.View
    public void setLoadMoreEnable(boolean z) {
        DJXRefreshLayout2 dJXRefreshLayout2 = this.mRefreshLayout;
        if (dJXRefreshLayout2 != null) {
            dJXRefreshLayout2.setLoadEnable(z);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailContract.View
    public int getAdapterCount() {
        DramaDetailAdapter dramaDetailAdapter = this.mAdapter;
        if (dramaDetailAdapter != null) {
            return dramaDetailAdapter.getCount();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailContract.View
    public void setRefreshingEnable(boolean z) {
        DJXRefreshLayout2 dJXRefreshLayout2 = this.mRefreshLayout;
        if (dJXRefreshLayout2 != null) {
            dJXRefreshLayout2.setRefreshEnable(z);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailContract.View
    public void setLoadCacheTask(DramaDetailLoadFromCacheTask dramaDetailLoadFromCacheTask) {
        this.mLoadCacheTask = dramaDetailLoadFromCacheTask;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragMvpProxy, com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onDetach() {
        super.onDetach();
        this.mHandler.removeCallbacksAndMessages((Object) null);
        DJXBus.getInstance().removeListener(this.mConfigBusListener);
        DJXBus.getInstance().removeListener(this.mBusListener);
        DramaDetailAdapter dramaDetailAdapter = this.mAdapter;
        if (dramaDetailAdapter != null) {
            dramaDetailAdapter.onDestroy(this.mViewPager);
        }
        DJXDramaListDialog dJXDramaListDialog = this.mDramaListDialog;
        if (dJXDramaListDialog != null) {
            if (dJXDramaListDialog.isShowing()) {
                this.mDramaListDialog.dismiss();
            }
            this.mDramaListDialog = null;
        }
        DJXDramaRewardDialog dJXDramaRewardDialog = this.mRewardDialog;
        if (dJXDramaRewardDialog != null && dJXDramaRewardDialog.isShowing()) {
            this.mRewardDialog.dismiss();
            this.mRewardDialog = null;
        }
        DJXGlobalReceiver.removeListener(this.mNetChangedListener);
        DramaDetailAdapter dramaDetailAdapter2 = this.mAdapter;
        if (dramaDetailAdapter2 != null) {
            try {
                dramaDetailAdapter2.unregisterDataSetObserver(this.mDataSetObserver);
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
    public void destroy() {
        super.destroy();
        AdManager.inst().clear(this.mWidgetParams.hashCode());
    }

    public static int getBottomOffset(int i) {
        if (i >= 0) {
            return i;
        }
        int offsetDownward = SettingData.getInstance().getOffsetDownward() <= 0 ? 20 : SettingData.getInstance().getOffsetDownward();
        return (!DeviceUtils.isFullScreenDevice() || DeviceUtils.checkDeviceHasNavigationBar()) ? offsetDownward : offsetDownward + 16;
    }

    Object getCurrentData() {
        DramaDetailAdapter dramaDetailAdapter = this.mAdapter;
        if (dramaDetailAdapter != null) {
            return dramaDetailAdapter.getItemData(this.mPosition);
        }
        return null;
    }

    public void handleMsg(Message message) {
        if (message.what == 101) {
            ToastUtil.show(InnerManager.getContext(), getResources().getString(R.string.djx_str_network_error), DJXToastType.NETWORK_ERROR);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public boolean setCurrentPage(int i) {
        DramaDetailAdapter dramaDetailAdapter = this.mAdapter;
        if (dramaDetailAdapter == null || i >= dramaDetailAdapter.getCount() || i < 0) {
            return false;
        }
        this.mViewPager.setCurrentItem(i);
        return true;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public void seekTo(long j) {
        super.seekTo(j);
        DramaDetailHolderBase<?> holderByPosition = getHolderByPosition(this.mPosition);
        if (holderByPosition instanceof DramaDetailHolder) {
            ((DramaDetailHolder) holderByPosition).seekTo(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DramaDetail getCurrentDramaDetail() {
        DramaDetailHolderBase<?> holderByPosition = getHolderByPosition(this.mPosition);
        if (holderByPosition instanceof DramaDetailHolder) {
            return ((DramaDetailHolder) holderByPosition).getData();
        }
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public int getCurrentDramaIndex() {
        DramaDetailHolderBase<?> holderByPosition = getHolderByPosition(this.mPosition);
        if (holderByPosition instanceof DramaDetailHolder) {
            return ((DramaDetailHolder) holderByPosition).getData().getIndex();
        }
        if (holderByPosition instanceof DramaDetailDrawAdHolder) {
            return Math.max(((DramaDetailDrawAdHolder) holderByPosition).getData().getAdPosition() - 1, 0);
        }
        return super.getCurrentDramaIndex();
    }

    public int getRealDramaIndex() {
        int i = this.firstUnLockIndex;
        return i > 0 ? i : getCurrentDramaIndex();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public void setCurrentDramaIndex(int i) {
        super.setCurrentDramaIndex(i);
        if (this.mAdapter != null && i >= 1 && i <= this.mDrama.total && i != getCurrentDramaIndex()) {
            this.mAdapter.removeAll();
            this.mDramaInitCursor = i;
            ((DramaDetailPresenter) this.mPresenter).loadDramaInit(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedLock(int i) {
        List<DJXEpisodeStatus> list = this.mDrama.episodeStatusList;
        if (list == null) {
            LG.w(TAG, "isNeedLock is true for episodeStatusList is null");
            return true;
        }
        for (DJXEpisodeStatus dJXEpisodeStatus : list) {
            if (dJXEpisodeStatus.getIndex() == i) {
                return dJXEpisodeStatus.isLocked();
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public void openMoreDialog() {
        super.openMoreDialog();
        showMore();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public void openDramaGallery() {
        super.openDramaGallery();
        showDramaListDialog(getCurrentDramaDetail());
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.IDJXWidget
    public void setSpeedPlay(float f, DJXPlaySpeedScope dJXPlaySpeedScope) {
        super.setSpeedPlay(f, dJXPlaySpeedScope);
        this.mSpeedPlayManager.updateSpeed(f, dJXPlaySpeedScope);
        setCurrentHolderSpeed(this.mPosition);
    }

    @Deprecated
    private int correctInitIndex(int i) {
        if (i > this.mDrama.unlockIndex) {
            this.mHasSelectedOver = true;
            return Math.min(this.mDrama.unlockIndex + 1, this.mDrama.total);
        }
        this.mHasSelectedOver = false;
        return i;
    }

    private int findPositionByIndex(int i, List<Object> list) {
        for (Object obj : list) {
            if ((obj instanceof DramaDetail) && i == ((DramaDetail) obj).getIndex()) {
                return list.indexOf(obj);
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUnlockFlowEnd(Boolean bool, DJXDramaUnlockMethod dJXDramaUnlockMethod, int i, IDJXDramaUnlockListener.UnlockErrorStatus unlockErrorStatus, Map<String, Object> map, Long l) {
        this.mViewPager.setCanScroll(true);
        this.mIsUnlockFlowStarted.set(false);
        DJXDramaRewardDialog dJXDramaRewardDialog = this.mRewardDialog;
        if (dJXDramaRewardDialog != null && dJXDramaRewardDialog.isShowing()) {
            this.mRewardDialog.dismiss();
        }
        this.mDetailConfig.getUnlockListener().unlockFlowEnd(this.mDrama, unlockErrorStatus, map);
        this.mTLog.sendUnlockEnd(bool.booleanValue(), this.mDrama.id, SystemClock.elapsedRealtime() - this.mUnlockStartTime, dJXDramaUnlockMethod, this.mDetailConfig.getAdMode(), Integer.valueOf(i), l, this.isContinuesUnlockMode);
    }
}
