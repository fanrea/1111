package com.kuaishou.live.longconnection;

import android.os.Handler;
import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.kuaishou.common.async.Async;
import com.kuaishou.live.longconnection.connector.LiveFeedConnector;
import com.kuaishou.live.longconnection.connector.LiveFeedConnectorDefaultImpl;
import com.kuaishou.live.longconnection.connector.LiveFeedConnectorHorseRaceImpl;
import com.yxcorp.livestream.longconnection.ConnectionSumStatistics;
import com.yxcorp.livestream.longconnection.HeartbeatListener;
import com.yxcorp.livestream.longconnection.LiveInfoListener;
import com.yxcorp.livestream.longconnection.LiveMessageListener;
import com.yxcorp.livestream.longconnection.LiveStreamLogger;
import com.yxcorp.livestream.longconnection.LongConnectionParams;
import com.yxcorp.livestream.longconnection.OnConnectionExceptionListener;
import com.yxcorp.livestream.longconnection.SCMessageListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveFeedConnectorManager {
    private static final String TAG = "LiveFeedConnectorManager";
    private LiveLongConnectionContext mConnectionContext;
    private LiveFeedConnector mConnectionImpl;
    private OnConnectionExceptionListener mExceptionListener;
    private boolean mHasAuthorPauseCalled;
    private boolean mHasStopped;
    private HeartbeatListener mHeartbeatListener;
    private LiveInfoListener mLiveInfoListener;
    private LiveMessageListener mLiveMessageListener;
    private ConnectionSumStatistics mConnectionSumStatistics = new ConnectionSumStatistics();
    private final List<Runnable> mPendingRunnables = new ArrayList();
    private Handler mExitHandler = new Handler();

    LiveFeedConnectorManager(LiveLongConnectionContext liveLongConnectionContext, LiveMessageListener liveMessageListener, LiveInfoListener liveInfoListener, HeartbeatListener heartbeatListener, OnConnectionExceptionListener onConnectionExceptionListener) {
        this.mConnectionContext = liveLongConnectionContext;
        this.mExceptionListener = onConnectionExceptionListener;
        this.mLiveMessageListener = liveMessageListener;
        this.mLiveInfoListener = liveInfoListener;
        this.mHeartbeatListener = heartbeatListener;
        Async.setContext(liveLongConnectionContext.mContext);
    }

    void setExceptionListener(OnConnectionExceptionListener onConnectionExceptionListener) {
        this.mExceptionListener = onConnectionExceptionListener;
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector != null) {
            liveFeedConnector.setExceptionListener(onConnectionExceptionListener);
        }
    }

    void setMessageListener(LiveMessageListener liveMessageListener) {
        this.mLiveMessageListener = liveMessageListener;
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector != null) {
            liveFeedConnector.setMessageListener(liveMessageListener);
        }
    }

    void setInfoListener(LiveInfoListener liveInfoListener) {
        this.mLiveInfoListener = liveInfoListener;
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector != null) {
            liveFeedConnector.setInfoListener(liveInfoListener);
        }
    }

    void setHeartbeatListener(HeartbeatListener heartbeatListener) {
        this.mHeartbeatListener = heartbeatListener;
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector != null) {
            liveFeedConnector.setHeartbeatListener(heartbeatListener);
        }
    }

    ConnectionSumStatistics getConnectionStatistics() {
        return this.mConnectionSumStatistics;
    }

    LongConnectionParams.ServerUriInfo getCurrentServerUriInfo() {
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector == null) {
            return null;
        }
        return liveFeedConnector.getCurrentServerUriInfo();
    }

    void markCurrentServerUriFailed() {
        LongConnectionParams.ServerUriInfo currentServerUriInfo = getCurrentServerUriInfo();
        if (currentServerUriInfo != null) {
            this.mConnectionSumStatistics.addFailedHostPort(currentServerUriInfo.getServerUri());
        }
    }

    boolean hasAuthorPauseCalled() {
        return this.mHasAuthorPauseCalled;
    }

    @Deprecated
    void anchorPause() {
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector == null) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.LiveFeedConnectorManager.1
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorManager.this.mConnectionImpl.anchorPause();
                }
            });
        } else {
            liveFeedConnector.anchorPause();
        }
    }

    @Deprecated
    void anchorPauseForPhoneCall() {
        this.mHasAuthorPauseCalled = true;
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector == null) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.LiveFeedConnectorManager.2
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorManager.this.mConnectionImpl.anchorPauseForPhoneCall();
                }
            });
        } else {
            liveFeedConnector.anchorPauseForPhoneCall();
        }
    }

    @Deprecated
    void audiencePause() {
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector == null) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.LiveFeedConnectorManager.3
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorManager.this.mConnectionImpl.audiencePause();
                }
            });
        } else {
            liveFeedConnector.audiencePause();
        }
    }

    void pause(final int i) {
        this.mHasAuthorPauseCalled = i == 1;
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector == null) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.LiveFeedConnectorManager.4
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorManager.this.mConnectionImpl.pause(i);
                }
            });
        } else {
            liveFeedConnector.pause(i);
        }
    }

    void resume() {
        this.mHasAuthorPauseCalled = false;
        LiveStreamLogger.debugLog(TAG, "resume, liveStreamId: " + this.mConnectionContext.getLiveStreamId() + ", anchorId: " + this.mConnectionContext.mAnchorId, new Object[0]);
        if (isConnected() || this.mHasStopped) {
            return;
        }
        connect();
    }

    boolean isConnected() {
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        return liveFeedConnector != null && liveFeedConnector.isConnected();
    }

    void disconnect() {
        LiveStreamLogger.debugLog(TAG, "disconnect, liveStreamId: " + this.mConnectionContext.getLiveStreamId() + ", anchorId: " + this.mConnectionContext.mAnchorId, new Object[0]);
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector == null) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.LiveFeedConnectorManager.5
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorManager.this.mConnectionImpl.disconnect();
                }
            });
        } else {
            liveFeedConnector.disconnect();
        }
    }

    void retryHorseRace() {
        LiveStreamLogger.debugLog(TAG, "retryHorseRace, liveStreamId: " + this.mConnectionContext.getLiveStreamId() + ", anchorId: " + this.mConnectionContext.mAnchorId, new Object[0]);
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector != null) {
            liveFeedConnector.retryHorseRace(buildLongConnectionParams());
        }
    }

    void disposeRace() {
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector == null) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.LiveFeedConnectorManager.6
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorManager.this.mConnectionImpl.disposeRace();
                }
            });
        } else {
            liveFeedConnector.disposeRace();
        }
    }

    void forceExit() {
        this.mHasStopped = true;
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector == null) {
            this.mPendingRunnables.clear();
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.LiveFeedConnectorManager.7
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorManager.this.mConnectionImpl.forceExit();
                }
            });
        } else {
            liveFeedConnector.forceExit();
        }
    }

    void exitImmediately() {
        if (this.mHasStopped) {
            return;
        }
        this.mHasStopped = true;
        this.mExitHandler.removeCallbacksAndMessages(null);
        exitInternal();
    }

    void exitDelayed(int i) {
        if (this.mHasStopped) {
            return;
        }
        this.mHasStopped = true;
        this.mExitHandler.postDelayed(new Runnable() { // from class: com.kuaishou.live.longconnection.LiveFeedConnectorManager.8
            @Override // java.lang.Runnable
            public void run() {
                LiveFeedConnectorManager.this.exitInternal();
            }
        }, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitInternal() {
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector == null) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.LiveFeedConnectorManager.9
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorManager.this.mConnectionImpl.exit();
                }
            });
        } else {
            liveFeedConnector.exit();
        }
    }

    boolean hasExited() {
        return this.mHasStopped;
    }

    void reconnect() {
        if (hasExited()) {
            return;
        }
        LiveStreamLogger.debugLog(TAG, "reconnect, liveStreamId: " + this.mConnectionContext.getLiveStreamId() + ", anchorId: " + this.mConnectionContext.mAnchorId, "retryCount: " + this.mConnectionSumStatistics.getRetryCount());
        if (this.mConnectionSumStatistics.getRetryCount() >= 9) {
            return;
        }
        this.mConnectionSumStatistics.addRetryCount();
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector == null) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.LiveFeedConnectorManager.10
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorManager.this.mConnectionImpl.reconnect(LiveFeedConnectorManager.this.buildLongConnectionParams());
                }
            });
        } else {
            liveFeedConnector.reconnect(buildLongConnectionParams());
        }
    }

    <T extends MessageNano> void registerSCMessageListener(final int i, final Class<T> cls, final SCMessageListener<T> sCMessageListener) {
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector == null) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.LiveFeedConnectorManager.11
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorManager.this.mConnectionImpl.registerSCMessageListener(i, cls, sCMessageListener);
                }
            });
        } else {
            liveFeedConnector.registerSCMessageListener(i, cls, sCMessageListener);
        }
    }

    <T extends MessageNano> void unregisterSCMessageListener(final int i, final SCMessageListener<T> sCMessageListener) {
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector == null) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.LiveFeedConnectorManager.12
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorManager.this.mConnectionImpl.unregisterSCMessageListener(i, sCMessageListener);
                }
            });
        } else {
            liveFeedConnector.unregisterSCMessageListener(i, sCMessageListener);
        }
    }

    void notifyBadNetworkEvent() {
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector == null) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.LiveFeedConnectorManager.13
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorManager.this.mConnectionImpl.notifyBadNetworkEvent();
                }
            });
        } else {
            liveFeedConnector.notifyBadNetworkEvent();
        }
    }

    private void connect() {
        if (hasExited()) {
            return;
        }
        LiveStreamLogger.debugLog(TAG, "connect, liveStreamId: " + this.mConnectionContext.getLiveStreamId() + ", anchorId: " + this.mConnectionContext.mAnchorId, new Object[0]);
        if (this.mConnectionImpl == null) {
            if (!this.mConnectionContext.getRace().mRounds.isEmpty()) {
                this.mConnectionImpl = new LiveFeedConnectorHorseRaceImpl(this.mConnectionContext.getRace(), true);
            } else {
                this.mConnectionImpl = new LiveFeedConnectorDefaultImpl(this.mConnectionContext.getHostPorts());
            }
            this.mConnectionImpl.setHeartbeatListener(this.mHeartbeatListener);
            this.mConnectionImpl.setInfoListener(this.mLiveInfoListener);
            this.mConnectionImpl.setMessageListener(this.mLiveMessageListener);
            this.mConnectionImpl.setExceptionListener(this.mExceptionListener);
        }
        this.mConnectionImpl.connect(buildLongConnectionParams());
        if (!this.mPendingRunnables.isEmpty()) {
            Iterator<Runnable> it = this.mPendingRunnables.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
        this.mPendingRunnables.clear();
    }

    void sendVoipSignal(final byte[] bArr) {
        LiveFeedConnector liveFeedConnector = this.mConnectionImpl;
        if (liveFeedConnector == null) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.LiveFeedConnectorManager.14
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorManager.this.mConnectionImpl.sendVoipSignal(bArr);
                }
            });
        } else {
            liveFeedConnector.sendVoipSignal(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LongConnectionParams buildLongConnectionParams() {
        LongConnectionParams longConnectionParams = new LongConnectionParams();
        if (!TextUtils.isEmpty(this.mConnectionContext.mOldToken)) {
            longConnectionParams.setToken(this.mConnectionContext.mOldToken);
        }
        if (!TextUtils.isEmpty(this.mConnectionContext.mPushArrowRedPacketId)) {
            longConnectionParams.setBroadcastGiftToken(this.mConnectionContext.mPushArrowRedPacketId);
        }
        if (!TextUtils.isEmpty(this.mConnectionContext.mSessionId)) {
            longConnectionParams.setSessionId(this.mConnectionContext.mSessionId);
        }
        longConnectionParams.setLiveStreamStartPlaySourceType(this.mConnectionContext.mLiveStreamStartPlaySourceType);
        double[] location = this.mConnectionContext.getLocation();
        longConnectionParams.setLiveStreamId(this.mConnectionContext.getLiveStreamId()).setmAppId(this.mConnectionContext.mAppId).setmBiz(this.mConnectionContext.mBiz).setDeviceId(this.mConnectionContext.mDeviceId).setIsAuthor(this.mConnectionContext.mIsAnchor).setIsEscrow(this.mConnectionContext.mIsEscrow).setIsSimpleLive(this.mConnectionContext.mIsSimpleLive).setAppVer(this.mConnectionContext.mAppVer).setSys(this.mConnectionContext.mSys).setSysVer(this.mConnectionContext.mSysVer).setPhoneModel(this.mConnectionContext.mPhoneModel).setChannel(this.mConnectionContext.mChannel).setLocale(this.mConnectionContext.getLocale()).setLatitude(location[0]).setLongitude(location[1]).setAttach(this.mConnectionContext.getAttach()).setUserId(Long.valueOf(this.mConnectionContext.getUserId()).longValue()).setOperator(this.mConnectionContext.getOperator()).setFirstEnterRoom(this.mConnectionContext.isFirstEnterRoom()).setExpTag(this.mConnectionContext.getExpTag()).setServiceToken(this.mConnectionContext.getApiServiceToken()).setAnchorId(this.mConnectionContext.mAnchorId).setRetryCount(this.mConnectionSumStatistics.getRetryCount()).setLastErrorCode(this.mConnectionSumStatistics.getLastErrorCode()).setKpn(this.mConnectionContext.mKpn).setKpf(this.mConnectionContext.mKpf).setAppType(this.mConnectionContext.mAppType).setClientId(this.mConnectionContext.mClientId);
        return longConnectionParams;
    }
}
