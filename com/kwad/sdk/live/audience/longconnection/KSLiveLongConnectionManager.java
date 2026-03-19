package com.kwad.sdk.live.audience.longconnection;

import android.text.TextUtils;
import com.kuaishou.android.live.model.Horse;
import com.kuaishou.android.live.model.Race;
import com.kuaishou.android.live.model.Round;
import com.kuaishou.live.longconnection.LiveLongConnection;
import com.kuaishou.live.longconnection.LiveLongConnectionContext;
import com.kuaishou.live.longconnection.LiveLongConnectionImpl;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;
import com.kwad.sdk.live.audience.KSLiveAudienceParam;
import com.kwad.sdk.live.audience.KSLiveInitModule;
import com.kwad.sdk.live.audience.KSLiveNetwork;
import com.kwad.sdk.live.audience.Utils;
import com.kwad.sdk.live.audience.api.KSLiveRequestHelper;
import com.kwad.sdk.live.audience.model.KSLivePlayConfig;
import com.kwad.sdk.live.audience.model.KSLiveRaceInfo;
import com.kwad.sdk.live.audience.net.KSLiveHttpTask;
import com.kwad.sdk.live.audience.net.KSLiveHttpTaskManager;
import com.kwad.sdk.live.audience.net.KSLiveTaskListener;
import com.kwad.sdk.live.audience.test.KSLiveLogger;
import com.kwad.sdk.live.audience.test.KSLiveTestConfig;
import com.yxcorp.livestream.longconnection.LiveLongConnectionServerException;
import com.yxcorp.livestream.longconnection.LiveMessageListener;
import com.yxcorp.livestream.longconnection.OnConnectionExceptionListener;
import com.yxcorp.livestream.longconnection.exception.BootstrapClientException;
import com.yxcorp.livestream.longconnection.exception.ChannelException;
import com.yxcorp.livestream.longconnection.exception.ClientException;
import com.yxcorp.livestream.longconnection.exception.EnterRoomTimeOutException;
import com.yxcorp.livestream.longconnection.exception.HeartBeatInterruptException;
import com.yxcorp.livestream.longconnection.exception.HorseRaceFailedException;
import com.yxcorp.livestream.longconnection.handler.SCErrorHandler;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveLongConnectionManager {
    private KSLiveAudienceParam mAudienceParam;
    private KSLivePlayConfig mKSLivePlayConfig;
    private LiveLongConnection mLiveLongConnection;
    private KSLiveHttpTaskManager mTaskManager;
    private boolean mIsFirstEnterRoom = true;
    private boolean mShouldRetryOnConnectionInterrupt = true;
    private KSLiveLongConnectionConfig mLongConnectionConfig = KSLiveInitModule.getInstance().getLongConnectionConfig();

    public KSLiveLongConnectionManager(KSLiveAudienceParam kSLiveAudienceParam, KSLiveHttpTaskManager kSLiveHttpTaskManager) {
        this.mAudienceParam = kSLiveAudienceParam;
        this.mKSLivePlayConfig = kSLiveAudienceParam.mLivePlayConfig;
        this.mTaskManager = kSLiveHttpTaskManager;
        initLiveLongConnection();
    }

    public LiveLongConnection getLiveLongConnection() {
        return this.mLiveLongConnection;
    }

    private void initLiveLongConnection() {
        this.mLiveLongConnection = new LiveLongConnectionImpl(buildLongConnectionContext());
        this.mLiveLongConnection.addMessageListener(new LiveMessageListener.SimpleLiveMessageListener() { // from class: com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionManager.1
            @Override // com.yxcorp.livestream.longconnection.LiveMessageListener.SimpleLiveMessageListener, com.yxcorp.livestream.longconnection.LiveMessageListener
            public void onEnterRoomAckReceived(LiveStreamMessages.SCEnterRoomAck sCEnterRoomAck) {
                KSLiveLogger.i("onEnterRoomAckReceived");
                KSLiveLongConnectionManager.this.mIsFirstEnterRoom = false;
            }

            @Override // com.yxcorp.livestream.longconnection.LiveMessageListener.SimpleLiveMessageListener, com.yxcorp.livestream.longconnection.LiveMessageListener
            public void onConnectionInterrupt() {
                super.onConnectionInterrupt();
                KSLiveLogger.i("longConnectionInterrupt", "mShouldRetry", Boolean.valueOf(KSLiveLongConnectionManager.this.mShouldRetryOnConnectionInterrupt), "hasExited", Boolean.valueOf(KSLiveLongConnectionManager.this.mLiveLongConnection.hasExited()));
                if (KSLiveLongConnectionManager.this.mLiveLongConnection.hasExited() || !KSLiveLongConnectionManager.this.mShouldRetryOnConnectionInterrupt) {
                    return;
                }
                KSLiveLongConnectionManager.this.mLiveLongConnection.markCurrentServerUriFailed();
                KSLiveLongConnectionManager.this.mLiveLongConnection.reconnect();
            }
        });
        this.mLiveLongConnection.addExceptionListener(new OnConnectionExceptionListener() { // from class: com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionManager.2
            @Override // com.yxcorp.livestream.longconnection.OnConnectionExceptionListener
            public void onServerException(LiveLongConnectionServerException liveLongConnectionServerException) {
                KSLiveLogger.e("longConnectionServerException", "uriInfo", KSLiveLongConnectionManager.this.mLiveLongConnection.getCurrentServerUriInfo(), liveLongConnectionServerException);
                if (SCErrorHandler.isLiveEndError(liveLongConnectionServerException.errorCode) || SCErrorHandler.isAuthError(liveLongConnectionServerException.errorCode)) {
                    KSLiveLongConnectionManager.this.mShouldRetryOnConnectionInterrupt = false;
                }
            }

            @Override // com.yxcorp.livestream.longconnection.OnConnectionExceptionListener
            public void onChannelException(ChannelException channelException) {
                KSLiveLogger.e("longConnectionChannelException", channelException);
            }

            @Override // com.yxcorp.livestream.longconnection.OnConnectionExceptionListener
            public void onClientException(ClientException clientException) {
                KSLiveLogger.e("longConnectionClientException", clientException);
                if ((clientException instanceof EnterRoomTimeOutException) || (clientException instanceof BootstrapClientException) || (clientException instanceof HeartBeatInterruptException) || (clientException instanceof HorseRaceFailedException)) {
                    if (KSLiveLongConnectionManager.this.mLiveLongConnection.hasExited()) {
                        return;
                    }
                    KSLiveLongConnectionManager.this.mLiveLongConnection.markCurrentServerUriFailed();
                    if (!(clientException instanceof HorseRaceFailedException) || !KSLiveLongConnectionManager.this.isNetworkConnected()) {
                        KSLiveLongConnectionManager.this.mLiveLongConnection.reconnect();
                        return;
                    } else {
                        KSLiveLongConnectionManager.this.retryHorseRace();
                        return;
                    }
                }
                KSLiveLongConnectionManager.this.mShouldRetryOnConnectionInterrupt = false;
            }
        });
    }

    private LiveLongConnectionContext buildLongConnectionContext() {
        LiveLongConnectionContext liveLongConnectionContext = new LiveLongConnectionContext() { // from class: com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionManager.3
            @Override // com.kuaishou.live.longconnection.LiveLongConnectionContext
            public String getUserId() {
                return "0";
            }

            @Override // com.kuaishou.live.longconnection.LiveLongConnectionContext
            public String getLiveStreamId() {
                return Utils.emptyIfNull(KSLiveLongConnectionManager.this.mKSLivePlayConfig.getLiveStreamId());
            }

            @Override // com.kuaishou.live.longconnection.LiveLongConnectionContext
            public String getLocale() {
                return Utils.emptyIfNull(KSLiveLongConnectionManager.this.mKSLivePlayConfig.getLocale());
            }

            @Override // com.kuaishou.live.longconnection.LiveLongConnectionContext
            public String getAttach() {
                return Utils.emptyIfNull(KSLiveLongConnectionManager.this.mKSLivePlayConfig.getAttach());
            }

            @Override // com.kuaishou.live.longconnection.LiveLongConnectionContext
            public double[] getLocation() {
                return new double[]{KSLiveLongConnectionManager.this.mLongConnectionConfig.getLatitude(), KSLiveLongConnectionManager.this.mLongConnectionConfig.getLongitude()};
            }

            @Override // com.kuaishou.live.longconnection.LiveLongConnectionContext
            public String getExpTag() {
                return Utils.emptyIfNull(KSLiveLongConnectionManager.this.mAudienceParam.mExpTag);
            }

            @Override // com.kuaishou.live.longconnection.LiveLongConnectionContext
            public boolean isFirstEnterRoom() {
                return KSLiveLongConnectionManager.this.mIsFirstEnterRoom;
            }

            @Override // com.kuaishou.live.longconnection.LiveLongConnectionContext
            public List<String> getHostPorts() {
                return KSLiveLongConnectionManager.this.mKSLivePlayConfig.getSocketHostPorts();
            }

            @Override // com.kuaishou.live.longconnection.LiveLongConnectionContext
            public Race getRace() {
                Race raceBuildTestRaceIfNecessary = KSLiveLongConnectionManager.this.buildTestRaceIfNecessary();
                return raceBuildTestRaceIfNecessary != null ? raceBuildTestRaceIfNecessary : KSLiveLongConnectionManager.this.mKSLivePlayConfig.getRace();
            }

            @Override // com.kuaishou.live.longconnection.LiveLongConnectionContext
            public String getApiServiceToken() {
                return KSLiveLongConnectionManager.this.mAudienceParam.liveServiceToken;
            }

            @Override // com.kuaishou.live.longconnection.LiveLongConnectionContext
            public String getOperator() {
                try {
                    return KSLiveLongConnectionManager.this.mLongConnectionConfig.getOperator();
                } catch (Throwable unused) {
                    return "";
                }
            }
        };
        liveLongConnectionContext.mContext = KSLiveInitModule.getInstance().getAppContext();
        liveLongConnectionContext.mLiveStreamStartPlaySourceType = this.mLongConnectionConfig.getLiveStreamStartPlaySourceType();
        liveLongConnectionContext.mAnchorId = this.mAudienceParam.mAnchorId;
        liveLongConnectionContext.mOldToken = this.mLongConnectionConfig.getToken();
        liveLongConnectionContext.mSessionId = "";
        liveLongConnectionContext.mPushArrowRedPacketId = "";
        liveLongConnectionContext.mDeviceId = this.mLongConnectionConfig.getDeviceId();
        liveLongConnectionContext.mAppVer = this.mLongConnectionConfig.getAppVersion();
        liveLongConnectionContext.mSys = "";
        liveLongConnectionContext.mSysVer = "";
        liveLongConnectionContext.mPhoneModel = "";
        liveLongConnectionContext.mChannel = "";
        liveLongConnectionContext.mKpn = this.mLongConnectionConfig.getKpn();
        liveLongConnectionContext.mKpf = this.mLongConnectionConfig.getKpf();
        liveLongConnectionContext.mAppType = this.mLongConnectionConfig.getAppType();
        liveLongConnectionContext.mClientId = this.mLongConnectionConfig.getClientId();
        liveLongConnectionContext.mAppId = this.mLongConnectionConfig.getAppId();
        liveLongConnectionContext.mBiz = this.mLongConnectionConfig.getBiz();
        return liveLongConnectionContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Race buildTestRaceIfNecessary() {
        KSLiveTestConfig testConfig = KSLiveInitModule.getInstance().getTestConfig();
        if (testConfig == null || TextUtils.isEmpty(testConfig.getLiveTestHorsePort())) {
            return null;
        }
        Race race = new Race();
        race.mRounds = new ArrayList();
        Round round = new Round();
        round.mHorses = new ArrayList();
        Horse horse = new Horse();
        horse.mHostAndPort = testConfig.getLiveTestHorsePort();
        round.mHorses.add(horse);
        race.mRounds.add(round);
        return race;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryHorseRace() {
        if (this.mTaskManager == null) {
            return;
        }
        String liveStreamId = this.mKSLivePlayConfig.getLiveStreamId();
        KSLiveLogger.i("longConnectionGetNewRaceInfoStart", "liveStreamId", liveStreamId);
        this.mTaskManager.executeTask(new KSLiveHttpTask(KSLiveRequestHelper.buildGetNewRaceRequest(liveStreamId), KSLiveRaceInfo.parser()), new KSLiveTaskListener<KSLiveRaceInfo>() { // from class: com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionManager.4
            @Override // com.kwad.sdk.live.audience.net.KSLiveTaskListener
            public void onSuccess(KSLiveRaceInfo kSLiveRaceInfo) {
                KSLiveLogger.i("longConnectionGetNewRaceInfoSuccess", "raceInfo", kSLiveRaceInfo);
                if (KSLiveLongConnectionManager.this.mKSLivePlayConfig == null || kSLiveRaceInfo == null || kSLiveRaceInfo.mRace == null || kSLiveRaceInfo.mRace.mRounds.isEmpty()) {
                    return;
                }
                KSLiveLongConnectionManager.this.mKSLivePlayConfig.mAttach = kSLiveRaceInfo.mAttach;
                KSLiveLongConnectionManager.this.mKSLivePlayConfig.mRace.mRounds.clear();
                KSLiveLongConnectionManager.this.mKSLivePlayConfig.mRace.clearState();
                KSLiveLongConnectionManager.this.mKSLivePlayConfig.mRace.mRounds.addAll(kSLiveRaceInfo.mRace.mRounds);
                KSLiveLongConnectionManager.this.mLiveLongConnection.retryHorseRace();
            }

            @Override // com.kwad.sdk.live.audience.net.KSLiveTaskListener
            public void onError(Throwable th) {
                KSLiveLogger.e("longConnectionGetNewRaceInfoSuccessFailed", th);
                KSLiveLongConnectionManager.this.mLiveLongConnection.reconnect();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNetworkConnected() {
        return KSLiveNetwork.isNetworkConnected(KSLiveInitModule.getInstance().getAppContext());
    }
}
