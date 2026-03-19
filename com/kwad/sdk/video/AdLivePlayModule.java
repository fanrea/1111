package com.kwad.sdk.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import com.kuaishou.livestream.message.nano.LiveShopMessages;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;
import com.kuaishou.livestream.message.nano.LiveTreasureBoxMessage;
import com.kuaishou.livestream.message.nano.SCActionSignal;
import com.kuaishou.merchant.message.nano.LiveRoomSignalMessage;
import com.kuaishou.protobuf.livestream.nano.SCLiveConditionRedPackInfo;
import com.kuaishou.socket.nano.SocketMessages;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.components.offline.api.core.adlive.model.LiveShopItemInfo;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.AdLiveVideoViewImpl;
import com.kwad.sdk.AdLiveViewImpl;
import com.kwad.sdk.TKAdLiveViewImpl;
import com.kwad.sdk.live.audience.KSLiveAudience;
import com.kwad.sdk.live.audience.KSLiveAudienceImpl;
import com.kwad.sdk.live.audience.KSLiveAudienceParam;
import com.kwad.sdk.live.audience.listener.KSLiveStateListener;
import com.kwad.sdk.live.audience.model.KSLivePlayConfig;
import com.kwad.sdk.live.audience.player.KSLivePlayerController;
import com.kwad.sdk.utils.LiveTimerHelper;
import com.kwad.sdk.utils.LiveViewUtils;
import com.kwad.sdk.widget.KSLiveTextureView;
import com.yxcorp.livestream.longconnection.LiveMessageListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class AdLivePlayModule implements IAdLivePlayModule {
    private static final String TAG = "AdLivePlayModule";
    private static final String sTimerNamePrefix = "ksad-AdLivePlayModule-timer";
    private static final AtomicInteger sTimerNextSerialNumber = new AtomicInteger(0);
    private IAdLiveOfflineView mAdLiveView;
    private String mAppId;
    private boolean mAudioEnabled;
    private String mAuthorId;
    private boolean mForceGetAudioFocus;
    private boolean mHasLossAudioFocus;
    private KSLiveAudience mKSLiveAudience;
    private KSLivePlayConfig mKSLivePlayConfig;
    private String mLiveServiceToken;
    private OfflineOnAudioConflictListener mOnAudioConflictListener;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private KSLiveTextureView mTextureView;
    private Runnable mUpdateProgressRunnable;
    private long mUserId;
    private List<TextureView.SurfaceTextureListener> mTextureListeners = new ArrayList();
    private List<AdLivePlayStateListener> mKSLiveStateListeners = new ArrayList();
    private List<OnAdLiveResumeInterceptor> mOnResumeInterceptors = new CopyOnWriteArrayList();
    private List<AdLiveCallerContextListener> mCallerContextListeners = new ArrayList();
    private boolean mCanResume = false;
    private boolean mRelease = false;
    private boolean stopped = false;
    private boolean mHasLiveStart = false;
    private boolean mHasLivePauseUnexecuted = false;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final LiveTimerHelper mTimerHelper = new LiveTimerHelper();

    public AdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j) {
        this.mAdLiveView = iAdLiveOfflineView;
        this.mTextureView = (KSLiveTextureView) this.mAdLiveView.getTextureView();
        this.mAppId = str;
        this.mLiveServiceToken = str3;
        this.mUserId = j;
        this.mAuthorId = str2;
        try {
            Log.d(TAG, "AdLivePlayModule init ");
            configLive();
            startLive();
        } catch (Throwable th) {
            OfflineHostProvider.getApi().crash().gatherException(th);
            Log.d(TAG, "AdLivePlayModule init error " + th.getMessage());
        }
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public void onResume() {
        boolean z;
        Iterator<OnAdLiveResumeInterceptor> it = this.mOnResumeInterceptors.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || it.next().handledAdLiveOnResume();
            }
        }
        if (z || this.stopped) {
            return;
        }
        resume();
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public void onPause() {
        pauseLive();
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public void onDestroy() {
        releaseLive();
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public void pause() {
        pauseLive();
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public void resume() {
        resumeLive();
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public void skipToEnd() {
        pauseLive();
        this.stopped = true;
        notifyLiveCompleted();
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public void release() {
        releaseLive();
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public long getPlayDuration() {
        return this.mTimerHelper.getTime();
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public void registerAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.mCallerContextListeners.add(adLiveCallerContextListener);
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public void unRegisterAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.mCallerContextListeners.remove(adLiveCallerContextListener);
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public void unRegisterAdLivePlayStateListener(AdLivePlayStateListener adLivePlayStateListener) {
        this.mKSLiveStateListeners.remove(adLivePlayStateListener);
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public void registerAdLivePlayStateListener(AdLivePlayStateListener adLivePlayStateListener) {
        this.mKSLiveStateListeners.add(adLivePlayStateListener);
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public LiveShopItemInfo getCurrentShowShopItemInfo() {
        LiveRoomSignalMessage.ItemInfo currentShowShopItemInfo;
        IAdLiveOfflineView iAdLiveOfflineView = this.mAdLiveView;
        if (!(iAdLiveOfflineView instanceof AdLiveViewImpl) || (currentShowShopItemInfo = ((AdLiveViewImpl) iAdLiveOfflineView).getCurrentShowShopItemInfo()) == null) {
            return null;
        }
        LiveShopItemInfo liveShopItemInfo = new LiveShopItemInfo();
        liveShopItemInfo.itemId = currentShowShopItemInfo.itemId;
        liveShopItemInfo.imageUrl = new String[currentShowShopItemInfo.imageUrl.length];
        for (int i = 0; i < currentShowShopItemInfo.imageUrl.length; i++) {
            liveShopItemInfo.imageUrl[i] = currentShowShopItemInfo.imageUrl[i].url;
        }
        liveShopItemInfo.title = currentShowShopItemInfo.title;
        liveShopItemInfo.price = currentShowShopItemInfo.price;
        liveShopItemInfo.showIcon = currentShowShopItemInfo.showIcon;
        liveShopItemInfo.jumpUrl = currentShowShopItemInfo.jumpUrl;
        liveShopItemInfo.saleType = currentShowShopItemInfo.saleType;
        liveShopItemInfo.extraMap = currentShowShopItemInfo.extraMap;
        liveShopItemInfo.originPrice = currentShowShopItemInfo.originPrice;
        liveShopItemInfo.pricePrefix = currentShowShopItemInfo.pricePrefix;
        liveShopItemInfo.currency = currentShowShopItemInfo.currency;
        liveShopItemInfo.priceSuffix = currentShowShopItemInfo.priceSuffix;
        return liveShopItemInfo;
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public void addInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor) {
        if (onAdLiveResumeInterceptor != null) {
            this.mOnResumeInterceptors.add(onAdLiveResumeInterceptor);
        }
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public void removeInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor) {
        if (onAdLiveResumeInterceptor != null) {
            this.mOnResumeInterceptors.remove(onAdLiveResumeInterceptor);
        }
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public void setAudioEnabled(boolean z, boolean z2) {
        if (this.mKSLiveAudience == null) {
            return;
        }
        if (this.mAudioEnabled != z) {
            notifyLiveAudioEnableChange(z);
        }
        this.mAudioEnabled = z;
        if (z) {
            OfflineHostProvider.getApi().env().requestAudioFocus(this.mTextureView.getContext(), true);
            this.mKSLiveAudience.getPlayerController().setVolume(1.0f, 1.0f);
        } else {
            this.mKSLiveAudience.getPlayerController().setVolume(0.0f, 0.0f);
        }
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLivePlayModule
    public void setForceGetAudioFocus(boolean z) {
        this.mForceGetAudioFocus = z;
        KSLiveTextureView kSLiveTextureView = this.mTextureView;
        if (kSLiveTextureView == null || kSLiveTextureView.getContext() == null) {
            return;
        }
        OfflineHostProvider.getApi().env().addOnAudioConflictListener(this.mTextureView.getContext(), getAudioConflictListener());
    }

    private boolean isCloseDialogShowing() {
        boolean z;
        Iterator<AdLiveCallerContextListener> it = this.mCallerContextListeners.iterator();
        while (true) {
            while (it.hasNext()) {
                z = z || it.next().isCloseDialogShowing();
            }
            return z;
        }
    }

    private void configLive() {
        if (this.mTextureView == null) {
            Log.e(TAG, "configLive mTextureView is null ");
            return;
        }
        KSLiveAudienceParam.Builder reason = new KSLiveAudienceParam.Builder().setReason("sdk");
        KSLivePlayConfig kSLivePlayConfig = this.mKSLivePlayConfig;
        this.mKSLiveAudience = KSLiveAudienceImpl.newInstance(reason.setLivePlayConfig((kSLivePlayConfig == null || TextUtils.isEmpty(kSLivePlayConfig.mLiveStreamId) || this.mKSLivePlayConfig.mPlayUrls.size() <= 0) ? null : this.mKSLivePlayConfig).setSource(60).setAppId(this.mAppId).setBiz(OfflineHostProvider.getApi().env().getBiz()).setAnchorId(this.mAuthorId).setLiveServiceToken(this.mLiveServiceToken).setUserId(this.mUserId).setExpTag("").build());
        this.mKSLiveAudience.setLiveStateListener(new KSLiveStateListener() { // from class: com.kwad.sdk.video.AdLivePlayModule.1
            @Override // com.kwad.sdk.live.audience.listener.KSLiveStateListener
            public void onPlayConfigUpdated(KSLivePlayConfig kSLivePlayConfig2, boolean z) {
                AdLivePlayModule.this.mKSLivePlayConfig = kSLivePlayConfig2;
            }

            @Override // com.kwad.sdk.live.audience.listener.KSLiveStateListener
            public void onLiveEnd() {
                AdLivePlayModule.this.mTimerHelper.stopTiming();
                long time = AdLivePlayModule.this.mTimerHelper.getTime();
                AdLivePlayModule.this.notifyLivePlayEnd();
                if (time > 800) {
                    AdLivePlayModule.this.notifyLiveCompleted();
                }
            }
        });
        this.mKSLiveAudience.getPlayerController().addRenderListener(new KSLivePlayerController.RenderListener() { // from class: com.kwad.sdk.video.AdLivePlayModule.2
            @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController.RenderListener
            public void onVideoRenderStart() {
                if (!AdLivePlayModule.this.mHasLiveStart) {
                    AdLivePlayModule.this.mHasLiveStart = true;
                }
                if (AdLivePlayModule.this.mHasLivePauseUnexecuted) {
                    AdLivePlayModule.this.mHasLivePauseUnexecuted = false;
                    AdLivePlayModule.this.pauseLive();
                    return;
                }
                Log.d(AdLivePlayModule.TAG, "onVideoRenderStart");
                if (AdLivePlayModule.this.mTimerHelper.isStarting()) {
                    AdLivePlayModule.this.mTimerHelper.resumeTiming();
                    AdLivePlayModule.this.notifyLivePlayResume();
                } else {
                    AdLivePlayModule.this.mTimerHelper.startTiming();
                    AdLivePlayModule.this.notifyLivePlayStart();
                    AdLivePlayModule.this.startUpdateProgressTimer();
                }
            }

            @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController.RenderListener
            public void onAudioRenderStart() {
                Log.d(AdLivePlayModule.TAG, "onAudioRenderStart");
            }
        });
        this.mKSLiveAudience.getPlayerController().setVolume(0.0f, 0.0f);
        this.mTextureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.sdk.video.AdLivePlayModule.3
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (surfaceTexture == AdLivePlayModule.this.mSurfaceTexture) {
                    return;
                }
                if (AdLivePlayModule.this.mSurfaceTexture == null) {
                    AdLivePlayModule.this.mSurfaceTexture = surfaceTexture;
                    if (AdLivePlayModule.this.mSurface == null) {
                        AdLivePlayModule.this.mSurface = new Surface(surfaceTexture);
                    }
                    AdLivePlayModule.this.mKSLiveAudience.getPlayerController().setSurface(AdLivePlayModule.this.mSurface);
                } else {
                    AdLivePlayModule.this.mTextureView.setSurfaceTexture(AdLivePlayModule.this.mSurfaceTexture);
                }
                Iterator it = AdLivePlayModule.this.mTextureListeners.iterator();
                while (it.hasNext()) {
                    ((TextureView.SurfaceTextureListener) it.next()).onSurfaceTextureAvailable(surfaceTexture, i, i2);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                Iterator it = AdLivePlayModule.this.mTextureListeners.iterator();
                while (it.hasNext()) {
                    ((TextureView.SurfaceTextureListener) it.next()).onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                Iterator it = AdLivePlayModule.this.mTextureListeners.iterator();
                while (it.hasNext()) {
                    ((TextureView.SurfaceTextureListener) it.next()).onSurfaceTextureDestroyed(surfaceTexture);
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                Iterator it = AdLivePlayModule.this.mTextureListeners.iterator();
                while (it.hasNext()) {
                    ((TextureView.SurfaceTextureListener) it.next()).onSurfaceTextureUpdated(surfaceTexture);
                }
            }
        });
        this.mKSLiveAudience.getPlayerController().addPreparedListener(new KSLivePlayerController.PreparedListener() { // from class: com.kwad.sdk.video.AdLivePlayModule.4
            @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController.PreparedListener
            public void onPrepared() {
                Log.d(AdLivePlayModule.TAG, "onPrepared");
                if (!AdLivePlayModule.this.mRelease) {
                    AdLivePlayModule.this.notifyLivePrepared();
                } else {
                    AdLivePlayModule.this.releaseLive();
                }
            }
        });
        this.mKSLiveAudience.getPlayerController().addErrorListener(new KSLivePlayerController.ErrorListener() { // from class: com.kwad.sdk.video.AdLivePlayModule.5
            @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController.ErrorListener
            public void onError(int i, int i2) {
                Log.d(AdLivePlayModule.TAG, "addErrorListener what:" + i + "  extra:" + i2);
            }
        });
        this.mKSLiveAudience.getPlayerController().addVideoSizeListener(new KSLivePlayerController.VideoSizeListener() { // from class: com.kwad.sdk.video.AdLivePlayModule.6
            @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController.VideoSizeListener
            public void onVideoSizeChanged(int i, int i2) {
                Log.d(AdLivePlayModule.TAG, "onVideoSizeChanged width:" + i + "  height:" + i2);
                if (AdLivePlayModule.this.mAdLiveView instanceof AdLiveVideoViewImpl) {
                    LiveViewUtils.adapterAdViewSizeUseByForce((AdLiveVideoViewImpl) AdLivePlayModule.this.mAdLiveView, i, i2);
                } else {
                    AdLivePlayModule.this.setPlayersLayout(i, i2);
                }
            }
        });
        this.mKSLiveAudience.getLongConnection().addMessageListener(new LiveMessageListener.SimpleLiveMessageListener() { // from class: com.kwad.sdk.video.AdLivePlayModule.7
            @Override // com.yxcorp.livestream.longconnection.LiveMessageListener.SimpleLiveMessageListener, com.yxcorp.livestream.longconnection.LiveMessageListener
            public void onEnterRoomAckReceived(LiveStreamMessages.SCEnterRoomAck sCEnterRoomAck) {
                super.onEnterRoomAckReceived(sCEnterRoomAck);
                Log.d(AdLivePlayModule.TAG, "onEnterRoomAckReceived");
            }
        });
        if (this.mAdLiveView instanceof AdLiveViewImpl) {
            this.mKSLiveAudience.getLongConnection().addMessageListener(((AdLiveViewImpl) this.mAdLiveView).getLiveMessageListener());
            this.mKSLiveAudience.getLongConnection().registerSCMessageListener(510, SCActionSignal.class, ((AdLiveViewImpl) this.mAdLiveView).getSCMessageListener());
            this.mKSLiveAudience.getLongConnection().registerSCMessageListener(362, LiveShopMessages.SCLiveShopState.class, ((AdLiveViewImpl) this.mAdLiveView).getSCMessageListener());
        }
        if (this.mAdLiveView instanceof TKAdLiveViewImpl) {
            this.mKSLiveAudience.getLongConnection().addMessageListener(((TKAdLiveViewImpl) this.mAdLiveView).getLiveMessageListener());
            this.mKSLiveAudience.getLongConnection().registerSCMessageListener(510, SCActionSignal.class, ((TKAdLiveViewImpl) this.mAdLiveView).getSCMessageListener());
            this.mKSLiveAudience.getLongConnection().registerSCMessageListener(362, LiveShopMessages.SCLiveShopState.class, ((TKAdLiveViewImpl) this.mAdLiveView).getSCMessageListener());
            this.mKSLiveAudience.getLongConnection().registerSCMessageListener(SocketMessages.PayloadType.SC_LIVE_CONDITION_RED_PACK, SCLiveConditionRedPackInfo.class, ((TKAdLiveViewImpl) this.mAdLiveView).getSCMessageListener());
            this.mKSLiveAudience.getLongConnection().registerSCMessageListener(SocketMessages.PayloadType.SC_LIVE_TREASURE_BOX_SHOW, LiveTreasureBoxMessage.SCLiveTreasureBoxShow.class, ((TKAdLiveViewImpl) this.mAdLiveView).getSCMessageListener());
        }
        if (this.mAdLiveView instanceof AdLiveVideoViewImpl) {
            this.mKSLiveAudience.getLongConnection().addMessageListener(((AdLiveVideoViewImpl) this.mAdLiveView).getLiveMessageListener());
            try {
                this.mKSLiveAudience.getLongConnection().registerSCMessageListener(510, SCActionSignal.class, ((AdLiveVideoViewImpl) this.mAdLiveView).getSCMessageListener());
                this.mKSLiveAudience.getLongConnection().registerSCMessageListener(362, LiveShopMessages.SCLiveShopState.class, ((AdLiveVideoViewImpl) this.mAdLiveView).getSCMessageListener());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayersLayout(long j, long j2) {
        Context context;
        int i;
        int i2;
        float f;
        int statusBarHeight;
        KSLiveTextureView kSLiveTextureView = this.mTextureView;
        if (kSLiveTextureView == null || j == 0 || j2 == 0 || (context = kSLiveTextureView.getContext()) == null) {
            return;
        }
        float f2 = j / j2;
        int screenWidth = LiveViewUtils.getScreenWidth(context);
        int screenRealHeight = LiveViewUtils.getScreenRealHeight(context);
        if (screenRealHeight < screenWidth || j2 < j) {
            float f3 = screenRealHeight;
            float f4 = f3 * f2;
            float f5 = screenWidth;
            if (f4 > f5) {
                i2 = (int) (f5 / f2);
                i = screenWidth;
            } else {
                i = (int) f4;
                i2 = screenRealHeight;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mTextureView.getLayoutParams();
            double d = i2;
            double d2 = screenRealHeight;
            Double.isNaN(d2);
            if (d > d2 * 0.7d) {
                IAdLiveOfflineView iAdLiveOfflineView = this.mAdLiveView;
                if (iAdLiveOfflineView instanceof AdLiveViewImpl) {
                    iAdLiveOfflineView.getView().setPadding((screenWidth - i) / 2, 0, 0, 0);
                    this.mAdLiveView.getView().setLayoutParams(this.mAdLiveView.getView().getLayoutParams());
                }
                marginLayoutParams.topMargin = 0;
                f = f3 / i2;
                i = (int) f4;
                i2 = screenRealHeight;
            } else {
                if (i == 0 || i2 == 0) {
                    marginLayoutParams.topMargin = 0;
                    i2 = -1;
                    i = -1;
                } else {
                    if (j2 >= j) {
                        statusBarHeight = LiveViewUtils.dip2px(context, 107.0f);
                    } else {
                        statusBarHeight = ((screenRealHeight - i2) / 2) - OfflineHostProvider.getApi().env().getStatusBarHeight(context);
                    }
                    marginLayoutParams.topMargin = statusBarHeight;
                }
                f = 1.0f;
            }
            ViewGroup.LayoutParams layoutParams = this.mTextureView.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.mTextureView.setLayoutParams(layoutParams);
            this.mTextureView.setScaleX(f);
        }
    }

    private void startLive() {
        Log.d(TAG, "startLive");
        try {
            if (this.mHasLivePauseUnexecuted) {
                this.mHasLivePauseUnexecuted = false;
            }
            if (this.mKSLiveAudience != null) {
                this.mKSLiveAudience.init();
                this.mCanResume = false;
            }
        } catch (Throwable th) {
            OfflineHostProvider.getApi().crash().gatherException(th);
            Log.d(TAG, "startLive error:" + th.getMessage());
        }
    }

    public void resumeLive() {
        if (this.mCanResume) {
            if (this.mHasLivePauseUnexecuted) {
                this.mHasLivePauseUnexecuted = false;
            }
            if (isCloseDialogShowing()) {
                return;
            }
            this.stopped = false;
            try {
                if (this.mKSLiveAudience != null) {
                    this.mKSLiveAudience.resume();
                    this.mCanResume = false;
                }
                boolean z = this.mForceGetAudioFocus && this.mHasLossAudioFocus;
                if (!this.mAudioEnabled && !z) {
                    setAudioEnabled(false, false);
                    return;
                }
                OfflineHostProvider.getApi().env().requestAudioFocus(this.mTextureView.getContext(), this.mForceGetAudioFocus);
                if (z) {
                    this.mHasLossAudioFocus = false;
                    setAudioEnabled(true, true);
                } else if (this.mHasLossAudioFocus) {
                    setAudioEnabled(this.mAudioEnabled, this.mAudioEnabled);
                }
            } catch (Throwable th) {
                OfflineHostProvider.getApi().crash().gatherException(th);
                Log.d(TAG, "resumeLive error:" + th.getMessage());
            }
        }
    }

    public void pauseLive() {
        if (this.mRelease || isCloseDialogShowing()) {
            return;
        }
        if (!this.mHasLiveStart) {
            this.mHasLivePauseUnexecuted = true;
            return;
        }
        Log.d(TAG, "pauseLive");
        try {
            if (this.mKSLiveAudience != null) {
                this.mKSLiveAudience.pause();
                this.mCanResume = true;
            }
            this.mTimerHelper.pauseTiming();
            notifyLivePlayPause();
        } catch (Throwable th) {
            Log.d(TAG, "pauseLive error:" + th.getMessage());
        }
    }

    public void releaseLive() {
        Log.d(TAG, "releaseLive");
        if (this.mRelease) {
            return;
        }
        if (this.mHasLivePauseUnexecuted) {
            this.mHasLivePauseUnexecuted = false;
        }
        this.mTimerHelper.stopTiming();
        this.mRelease = true;
        try {
            if (this.mKSLiveAudience != null) {
                this.mKSLiveAudience.destroy();
            }
            clearListener();
            this.mCanResume = false;
            this.mSurfaceTexture = null;
            this.mHandler.removeCallbacksAndMessages(null);
            cancelUpdateProgressTimer();
        } catch (Throwable th) {
            OfflineHostProvider.getApi().crash().gatherException(th);
            Log.d(TAG, "releaseLive error:" + th.getMessage());
        }
    }

    private void clearListener() {
        this.mKSLiveStateListeners.clear();
        this.mOnResumeInterceptors.clear();
        this.mCallerContextListeners.clear();
        if (this.mOnAudioConflictListener == null || this.mTextureView == null) {
            return;
        }
        OfflineHostProvider.getApi().env().removeOnAudioConflictListener(this.mTextureView.getContext(), this.mOnAudioConflictListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLivePlayProgress() {
        Iterator<AdLivePlayStateListener> it = this.mKSLiveStateListeners.iterator();
        while (it.hasNext()) {
            AdLivePlayStateListener next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.onLivePlayProgress(this.mTimerHelper.getTime());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLivePlayStart() {
        Log.d(TAG, "notifyLivePlayStart");
        Iterator<AdLivePlayStateListener> it = this.mKSLiveStateListeners.iterator();
        while (it.hasNext()) {
            AdLivePlayStateListener next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.onLivePlayStart();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLivePlayResume() {
        Log.d(TAG, "onLivePlayResume");
        Iterator<AdLivePlayStateListener> it = this.mKSLiveStateListeners.iterator();
        while (it.hasNext()) {
            AdLivePlayStateListener next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.onLivePlayResume();
            }
        }
    }

    private void notifyLivePlayPause() {
        Log.d(TAG, "notifyLivePlayPause");
        Iterator<AdLivePlayStateListener> it = this.mKSLiveStateListeners.iterator();
        while (it.hasNext()) {
            AdLivePlayStateListener next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.onLivePlayPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLivePlayEnd() {
        Log.d(TAG, "notifyLivePlayEnd");
        Iterator<AdLivePlayStateListener> it = this.mKSLiveStateListeners.iterator();
        while (it.hasNext()) {
            AdLivePlayStateListener next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.onLivePlayEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLivePrepared() {
        Log.d(TAG, "notifyLivePrepared");
        Iterator<AdLivePlayStateListener> it = this.mKSLiveStateListeners.iterator();
        while (it.hasNext()) {
            AdLivePlayStateListener next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.onLivePrepared();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLiveCompleted() {
        Log.d(TAG, "notifyLiveCompleted");
        Iterator<AdLivePlayStateListener> it = this.mKSLiveStateListeners.iterator();
        while (it.hasNext()) {
            AdLivePlayStateListener next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.onLivePlayCompleted();
            }
        }
    }

    private void notifyLiveAudioEnableChange(boolean z) {
        Log.d(TAG, "notifyLiveAudioEnableChange");
        Iterator<AdLivePlayStateListener> it = this.mKSLiveStateListeners.iterator();
        while (it.hasNext()) {
            AdLivePlayStateListener next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.onLiveAudioEnableChange(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpdateProgressTimer() {
        cancelUpdateProgressTimer();
        if (this.mUpdateProgressRunnable == null) {
            this.mUpdateProgressRunnable = new Runnable() { // from class: com.kwad.sdk.video.AdLivePlayModule.8
                @Override // java.lang.Runnable
                public void run() {
                    AdLivePlayModule.this.notifyLivePlayProgress();
                    if (AdLivePlayModule.this.mUpdateProgressRunnable != null) {
                        AdLivePlayModule.this.mHandler.postDelayed(AdLivePlayModule.this.mUpdateProgressRunnable, 1000L);
                    }
                }
            };
        }
        this.mHandler.post(this.mUpdateProgressRunnable);
    }

    private void cancelUpdateProgressTimer() {
        Runnable runnable = this.mUpdateProgressRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.mUpdateProgressRunnable = null;
        }
    }

    private OfflineOnAudioConflictListener getAudioConflictListener() {
        if (this.mOnAudioConflictListener == null) {
            this.mOnAudioConflictListener = new OfflineOnAudioConflictListener() { // from class: com.kwad.sdk.video.AdLivePlayModule.9
                @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
                public void onAudioBeReleased() {
                }

                @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
                public void onAudioBeOccupied() {
                    AdLivePlayModule.this.mHasLossAudioFocus = true;
                    AdLivePlayModule.this.setAudioEnabled(false, false);
                }
            };
        }
        return this.mOnAudioConflictListener;
    }
}
