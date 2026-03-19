package com.kwad.sdk.live.audience;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.kuaishou.live.longconnection.LiveLongConnection;
import com.kwad.sdk.live.audience.api.KSLiveRequestHelper;
import com.kwad.sdk.live.audience.listener.KSLiveStateListener;
import com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionManager;
import com.kwad.sdk.live.audience.model.KSLivePlayConfig;
import com.kwad.sdk.live.audience.model.KSLivePlayConfigExt;
import com.kwad.sdk.live.audience.net.KSLiveException;
import com.kwad.sdk.live.audience.net.KSLiveHttpTask;
import com.kwad.sdk.live.audience.net.KSLiveHttpTaskManager;
import com.kwad.sdk.live.audience.net.KSLiveTaskListener;
import com.kwad.sdk.live.audience.player.KSLivePlayerController;
import com.kwad.sdk.live.audience.player.KSLivePlayerControllerImpl;
import com.kwad.sdk.live.audience.test.KSLiveLogger;
import com.kwai.video.ksliveplayer.KSCoreLivePlayer;
import com.yxcorp.livestream.longconnection.LiveInfoListener;
import com.yxcorp.livestream.longconnection.LiveLongConnectionServerException;
import com.yxcorp.livestream.longconnection.OnConnectionExceptionListener;
import com.yxcorp.livestream.longconnection.exception.ChannelException;
import com.yxcorp.livestream.longconnection.exception.ClientException;
import com.yxcorp.livestream.longconnection.exception.ServerInfo;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveAudienceImpl implements KSLiveAudience {
    private static final long DELAY_UPDATE_PLAY_CONFIG_DURATION_MS = 2000;
    private final KSLiveAudienceParam mAudienceParam;
    private boolean mHasDispatchedLiveEnd;
    private boolean mIsKSLivePlayConfigUpdated;
    private final KSLivePlayConfig mKSLivePlayConfig;
    private KSLivePlayerController mLivePlayerController;
    private KSLiveStateListener mLiveStateListener;
    private LiveLongConnection mLongConnection;
    private AtomicBoolean mHasDestroy = new AtomicBoolean(false);
    private KSLiveHttpTaskManager mHttpTaskManager = new KSLiveHttpTaskManager();
    private Handler mUpdateLiveConfigHandler = new Handler(Looper.getMainLooper());

    @interface UpdatePlayConfigReason {
        public static final int ANCHOR_FALLBACK = 3;
        public static final int GET_NEW_URL = 2;
        public static final int START_PLAY = 1;
    }

    public static KSLiveAudience newInstance(KSLiveAudienceParam kSLiveAudienceParam) {
        return new KSLiveAudienceImpl(kSLiveAudienceParam);
    }

    KSLiveAudienceImpl(KSLiveAudienceParam kSLiveAudienceParam) {
        this.mAudienceParam = kSLiveAudienceParam;
        if (this.mAudienceParam.mLivePlayConfig == null) {
            KSLiveLogger.i("KSLivePlayConfig is null, mock data");
            this.mKSLivePlayConfig = KSLivePlayConfig.createHolderConfig();
            this.mAudienceParam.mLivePlayConfig = this.mKSLivePlayConfig;
        } else {
            this.mKSLivePlayConfig = kSLiveAudienceParam.mLivePlayConfig;
        }
        this.mLivePlayerController = KSLivePlayerControllerImpl.newInstance(this.mKSLivePlayConfig, kSLiveAudienceParam.mExtraInfoJson);
        this.mLongConnection = new KSLiveLongConnectionManager(this.mAudienceParam, this.mHttpTaskManager).getLiveLongConnection();
    }

    @Override // com.kwad.sdk.live.audience.KSLiveAudience
    public void setLiveStateListener(KSLiveStateListener kSLiveStateListener) {
        this.mLiveStateListener = kSLiveStateListener;
    }

    @Override // com.kwad.sdk.live.audience.KSLiveAudience
    public void init() {
        simpleLog("live start");
        this.mHasDestroy.set(false);
        if (!isPlayConfigInvalid(this.mKSLivePlayConfig)) {
            initLive();
            this.mLivePlayerController.prepare();
        }
        tryUpdateLivePlayConfig(1);
    }

    @Override // com.kwad.sdk.live.audience.KSLiveAudience
    public void pause() {
        simpleLog("live pause");
        if (isPlayConfigInvalid(this.mKSLivePlayConfig)) {
            return;
        }
        this.mLivePlayerController.pause();
        if (this.mIsKSLivePlayConfigUpdated) {
            this.mLongConnection.audiencePause();
        }
    }

    @Override // com.kwad.sdk.live.audience.KSLiveAudience
    public void resume() {
        simpleLog("live resume");
        if (isPlayConfigInvalid(this.mKSLivePlayConfig)) {
            return;
        }
        this.mLivePlayerController.resume();
        if (this.mIsKSLivePlayConfigUpdated) {
            this.mLongConnection.resume();
        }
    }

    @Override // com.kwad.sdk.live.audience.KSLiveAudience
    public void destroy() {
        simpleLog("live destroy");
        this.mHasDestroy.set(true);
        if (isPlayConfigInvalid(this.mKSLivePlayConfig)) {
            return;
        }
        requestStopLive();
        this.mLivePlayerController.release();
        this.mLongConnection.forceExit();
        this.mHttpTaskManager.release();
        this.mUpdateLiveConfigHandler.removeCallbacksAndMessages(null);
        this.mIsKSLivePlayConfigUpdated = false;
        this.mHasDispatchedLiveEnd = false;
    }

    @Override // com.kwad.sdk.live.audience.KSLiveAudience
    public KSLivePlayerController getPlayerController() {
        return this.mLivePlayerController;
    }

    @Override // com.kwad.sdk.live.audience.KSLiveAudience
    public LiveLongConnection getLongConnection() {
        return this.mLongConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLive() {
        this.mLivePlayerController.addUrlSwitchListener(new KSLivePlayerController.UrlSwitchListener() { // from class: com.kwad.sdk.live.audience.KSLiveAudienceImpl.1
            @Override // com.kwad.sdk.live.audience.player.KSLivePlayerController.UrlSwitchListener
            public void onRunOutOfUrls() {
                KSLiveAudienceImpl.this.simpleLog("liveAudience onRunOutOfUrls");
                KSLiveAudienceImpl.this.tryUpdateLivePlayConfig(2);
            }
        });
        this.mLongConnection.addInfoListener(new LiveInfoListener() { // from class: com.kwad.sdk.live.audience.KSLiveAudienceImpl.2
            @Override // com.yxcorp.livestream.longconnection.LiveInfoListener
            public void onServerInfo(ServerInfo serverInfo) {
                KSLiveLogger.i("liveAudience onServerInfo", "onServerInfo", serverInfo.toString());
                if (serverInfo.mCode == 6111) {
                    KSLiveAudienceImpl.this.tryUpdateLivePlayConfig(3);
                    return;
                }
                if (serverInfo.mCode != 601 || KSLiveAudienceImpl.this.mLiveStateListener == null || KSLiveAudienceImpl.this.mHasDispatchedLiveEnd) {
                    return;
                }
                KSLiveAudienceImpl.this.simpleLog("live end");
                KSLiveAudienceImpl.this.mLiveStateListener.onLiveEnd();
                KSLiveAudienceImpl.this.mHasDispatchedLiveEnd = true;
            }
        });
        this.mLongConnection.addExceptionListener(new OnConnectionExceptionListener() { // from class: com.kwad.sdk.live.audience.KSLiveAudienceImpl.3
            @Override // com.yxcorp.livestream.longconnection.OnConnectionExceptionListener
            public void onChannelException(ChannelException channelException) {
            }

            @Override // com.yxcorp.livestream.longconnection.OnConnectionExceptionListener
            public void onClientException(ClientException clientException) {
            }

            @Override // com.yxcorp.livestream.longconnection.OnConnectionExceptionListener
            public void onServerException(LiveLongConnectionServerException liveLongConnectionServerException) {
                KSLiveAudienceImpl.this.simpleLog("liveAudience onServerException", liveLongConnectionServerException);
                if (liveLongConnectionServerException.errorCode != 601 || liveLongConnectionServerException.subCode != 611) {
                    KSLiveAudienceImpl.this.handleServerError(liveLongConnectionServerException);
                } else {
                    KSLiveAudienceImpl.this.tryUpdateLivePlayConfig(2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryUpdateLivePlayConfig(final int i) {
        this.mUpdateLiveConfigHandler.removeCallbacksAndMessages(null);
        if (!KSLiveNetwork.isNetworkConnected(KSLiveInitModule.getInstance().getAppContext())) {
            simpleLog("delay updatePlayConfig");
            this.mUpdateLiveConfigHandler.postDelayed(new Runnable() { // from class: com.kwad.sdk.live.audience.KSLiveAudienceImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    KSLiveAudienceImpl.this.tryUpdateLivePlayConfig(i);
                }
            }, DELAY_UPDATE_PLAY_CONFIG_DURATION_MS);
        } else if (i == 1) {
            requestStartPlay();
        } else if (i == 2) {
            requestGetPlayUrl();
        } else {
            if (i != 3) {
                return;
            }
            requestGetNewProvider();
        }
    }

    private void requestStartPlay() {
        simpleLog("requestStartPlay");
        this.mHttpTaskManager.executeTask(new KSLiveHttpTask(KSLiveRequestHelper.buildStartPlayRequest(this.mAudienceParam.mAnchorId, this.mAudienceParam.mSource, this.mAudienceParam.mExpTag, this.mAudienceParam.mReason, this.mAudienceParam.liveServiceToken, this.mAudienceParam.userId), KSLivePlayConfig.parser()), new KSLivePlayConfigListener(1));
    }

    private void requestGetPlayUrl() {
        simpleLog("requestGetPlayUrl");
        this.mHttpTaskManager.executeTask(new KSLiveHttpTask(KSLiveRequestHelper.buildGetPlayUrlRequest(this.mAudienceParam.mAnchorId, this.mAudienceParam.liveServiceToken, this.mAudienceParam.userId), KSLivePlayConfig.parser()), new KSLivePlayConfigListener(2));
    }

    private void requestGetNewProvider() {
        simpleLog("requestGetNewProvider");
        this.mHttpTaskManager.executeTask(new KSLiveHttpTask(KSLiveRequestHelper.buildGetNewProviderRequest(this.mAudienceParam.mAnchorId, this.mAudienceParam.liveServiceToken, this.mAudienceParam.userId), KSLivePlayConfig.parser()), new KSLivePlayConfigListener(3));
    }

    private void requestStopLive() {
        simpleLog("requestStopLive");
        String liveStreamId = this.mKSLivePlayConfig.getLiveStreamId();
        if (TextUtils.isEmpty(liveStreamId)) {
            return;
        }
        this.mHttpTaskManager.executeTask(new KSLiveHttpTask(KSLiveRequestHelper.buildStopLiveRequest(liveStreamId, this.mAudienceParam.liveServiceToken, this.mAudienceParam.userId)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleServerError(Throwable th) {
        if (th instanceof KSLiveException) {
            if (((KSLiveException) th).mErrorCode != 601 || this.mLiveStateListener == null || this.mHasDispatchedLiveEnd) {
                return;
            }
            simpleLog("live end ks live exception");
            this.mLiveStateListener.onLiveEnd();
            this.mHasDispatchedLiveEnd = true;
            return;
        }
        if (th instanceof LiveLongConnectionServerException) {
            if (((LiveLongConnectionServerException) th).errorCode != 601 || this.mLiveStateListener == null || this.mHasDispatchedLiveEnd) {
                return;
            }
            simpleLog("live end server error");
            this.mLiveStateListener.onLiveEnd();
            this.mHasDispatchedLiveEnd = true;
            return;
        }
        simpleLog("handleServerError" + th.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void simpleLog(String str) {
        KSLiveLogger.i("liveAudience " + str, "liveStreamId", this.mKSLivePlayConfig.getLiveStreamId(), "anchorId", this.mAudienceParam.mAnchorId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void simpleLog(String str, Throwable th) {
        KSLiveLogger.e("liveAudience " + str, "liveStreamId", this.mKSLivePlayConfig.getLiveStreamId(), "anchorId", this.mAudienceParam.mAnchorId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isPlayConfigInvalid(KSLivePlayConfig kSLivePlayConfig) {
        return TextUtils.isEmpty(kSLivePlayConfig.getLiveStreamId());
    }

    class KSLivePlayConfigListener implements KSLiveTaskListener<KSLivePlayConfig> {
        private int mUpdateReason;

        public KSLivePlayConfigListener(int i) {
            this.mUpdateReason = i;
        }

        @Override // com.kwad.sdk.live.audience.net.KSLiveTaskListener
        public void onSuccess(KSLivePlayConfig kSLivePlayConfig) {
            KSLiveAudienceImpl.this.simpleLog("getPlayConfigSuccess" + this.mUpdateReason);
            updateKSLivePlayConfig(this.mUpdateReason == 1, kSLivePlayConfig);
        }

        @Override // com.kwad.sdk.live.audience.net.KSLiveTaskListener
        public void onError(Throwable th) {
            KSLiveAudienceImpl.this.simpleLog("getPlayConfigError" + this.mUpdateReason, th);
            KSLiveAudienceImpl.this.handleServerError(th);
        }

        private void updateKSLivePlayConfig(boolean z, KSLivePlayConfig kSLivePlayConfig) {
            if (KSLiveAudienceImpl.this.mHasDestroy.get()) {
                return;
            }
            KSLivePlayConfig kSLivePlayConfig2 = KSLiveAudienceImpl.this.mKSLivePlayConfig;
            boolean zIsPlayConfigInvalid = KSLiveAudienceImpl.isPlayConfigInvalid(kSLivePlayConfig2);
            boolean z2 = isDataSourceChanged(kSLivePlayConfig2, kSLivePlayConfig) || !z || zIsPlayConfigInvalid;
            KSLiveLogger.i("liveAudience updateKSLivePlayConfig", "isStartPlay", Boolean.valueOf(z), "oldConfig", kSLivePlayConfig2, "newConfig", kSLivePlayConfig);
            KSLivePlayConfigExt.copyValueFromResponse(kSLivePlayConfig2, kSLivePlayConfig);
            if (zIsPlayConfigInvalid) {
                KSLiveAudienceImpl.this.initLive();
            }
            KSLiveAudienceImpl.this.mIsKSLivePlayConfigUpdated = true;
            if (z) {
                KSLiveAudienceImpl.this.simpleLog("longConnection start");
                KSLiveAudienceImpl.this.mLongConnection.resume();
            }
            if (KSLiveAudienceImpl.this.mLiveStateListener != null) {
                KSLiveAudienceImpl.this.mLiveStateListener.onPlayConfigUpdated(KSLiveAudienceImpl.this.mKSLivePlayConfig, z);
            }
            refreshLivePlayerDataSource(z2);
        }

        private boolean isDataSourceChanged(KSLivePlayConfig kSLivePlayConfig, KSLivePlayConfig kSLivePlayConfig2) {
            if (!TextUtils.isEmpty(kSLivePlayConfig.mLiveManifestJson) || TextUtils.isEmpty(kSLivePlayConfig2.mLiveManifestJson)) {
                return !TextUtils.isEmpty(kSLivePlayConfig.mLiveManifestJson) && TextUtils.isEmpty(kSLivePlayConfig2.mLiveManifestJson);
            }
            return true;
        }

        private void refreshLivePlayerDataSource(boolean z) {
            KSLiveLogger.i("refreshLivePlayerDataSource", "shouldRebuildPlayer", Boolean.valueOf(z));
            KSLivePlayConfig kSLivePlayConfig = KSLiveAudienceImpl.this.mKSLivePlayConfig;
            KSCoreLivePlayer kSCoreLivePlayer = KSLiveAudienceImpl.this.mLivePlayerController.getKSCoreLivePlayer();
            if (!TextUtils.isEmpty(kSLivePlayConfig.mLiveManifestJson)) {
                kSCoreLivePlayer.refreshDataManifest(kSLivePlayConfig.mLiveManifestJson, z);
            } else {
                if (Utils.isEmpty(kSLivePlayConfig.mPlayUrls)) {
                    return;
                }
                kSCoreLivePlayer.refreshMultiPlayUrls(Utils.getPlayUrls(kSLivePlayConfig.mPlayUrls), z);
            }
        }
    }
}
