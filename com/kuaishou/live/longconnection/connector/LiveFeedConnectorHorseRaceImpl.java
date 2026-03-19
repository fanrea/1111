package com.kuaishou.live.longconnection.connector;

import android.util.Log;
import com.google.protobuf.nano.MessageNano;
import com.kuaishou.android.live.model.Race;
import com.kuaishou.android.live.model.Round;
import com.yxcorp.livestream.longconnection.HeartbeatListener;
import com.yxcorp.livestream.longconnection.LiveFeedConnection;
import com.yxcorp.livestream.longconnection.LiveInfoListener;
import com.yxcorp.livestream.longconnection.LiveMessageListener;
import com.yxcorp.livestream.longconnection.LiveStreamLogger;
import com.yxcorp.livestream.longconnection.LongConnectionParams;
import com.yxcorp.livestream.longconnection.OnConnectionExceptionListener;
import com.yxcorp.livestream.longconnection.SCMessageListener;
import com.yxcorp.livestream.longconnection.exception.HorseRaceFailedException;
import com.yxcorp.livestream.longconnection.horserace.HorseRunner;
import com.yxcorp.livestream.longconnection.horserace.RacePolicy;
import com.yxcorp.livestream.longconnection.horserace.RacePolicyFactory;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveFeedConnectorHorseRaceImpl implements LiveFeedConnector {
    private static final String TAG = "LiveFeedConnectorHorseRaceImpl";
    private boolean mHasStopped;
    private HeartbeatListener mHeartbeatListener;
    private LiveInfoListener mInfoListener;
    private boolean mIsRacing;
    private LiveMessageListener mLiveMessageListener;
    private boolean mNeedStopRunnerOnConsumer;
    private OnConnectionExceptionListener mOnConnectionExceptionListener;
    private final Race mRace;
    private Disposable mRaceDisposable;
    private RacePolicy mRacePolicy;
    private Disposable mRacePolicyDisposable;
    private Disposable mReconnectDisposable;
    private LiveFeedConnection mConnection = new LiveFeedConnection();
    private List<Runnable> mPendingRunnables = new ArrayList();
    private List<SCMessageListenerWrapper> mSCMessageListeners = new ArrayList();

    public LiveFeedConnectorHorseRaceImpl(Race race, boolean z) {
        this.mRace = race;
        this.mNeedStopRunnerOnConsumer = z;
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public LongConnectionParams.ServerUriInfo getCurrentServerUriInfo() {
        return this.mConnection.getCurrentServerUriInfo();
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void anchorPause() {
        if (this.mIsRacing) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.connector.LiveFeedConnectorHorseRaceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.pause(0);
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.disconnect();
                }
            });
        } else {
            this.mConnection.pause(0);
            this.mConnection.disconnect();
        }
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void anchorPauseForPhoneCall() {
        if (this.mIsRacing) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.connector.LiveFeedConnectorHorseRaceImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.pause(1);
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.disconnect();
                }
            });
        } else {
            this.mConnection.pause(1);
            this.mConnection.disconnect();
        }
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void audiencePause() {
        if (this.mIsRacing) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.connector.LiveFeedConnectorHorseRaceImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.pause(0);
                }
            });
        } else {
            this.mConnection.pause(0);
        }
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void pause(final int i) {
        LiveStreamLogger.debugLog("LiveFeedConnectorHorseRaceImpl#longConnectionPause()", "pauseType", Integer.valueOf(i));
        if (this.mIsRacing) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.connector.LiveFeedConnectorHorseRaceImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.pause(i);
                }
            });
        } else {
            this.mConnection.pause(i);
        }
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public boolean isConnected() {
        return this.mConnection.isConnected();
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void disconnect() {
        if (this.mIsRacing) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.connector.LiveFeedConnectorHorseRaceImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.disconnect();
                }
            });
        } else {
            this.mConnection.disconnect();
        }
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void disposeRace() {
        dispose(this.mReconnectDisposable);
        this.mReconnectDisposable = null;
        dispose(this.mRacePolicyDisposable);
        dispose(this.mRaceDisposable);
        this.mIsRacing = false;
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void forceExit() {
        RacePolicy racePolicy = this.mRacePolicy;
        if (racePolicy != null) {
            racePolicy.cancelRace();
        }
        disposeRace();
        this.mHasStopped = true;
        this.mOnConnectionExceptionListener = null;
        this.mLiveMessageListener = null;
        this.mHeartbeatListener = null;
        this.mConnection.setExceptionListener(null);
        this.mConnection.setMessageListener(null);
        this.mConnection.setHeartbeatListener(null);
        this.mConnection.clearSCMessageListener();
        this.mConnection.exit();
        Race race = this.mRace;
        if (race != null) {
            race.clearState();
        }
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void exit() {
        Disposable disposable = this.mReconnectDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        this.mHasStopped = true;
        this.mOnConnectionExceptionListener = null;
        this.mInfoListener = null;
        this.mLiveMessageListener = null;
        this.mHeartbeatListener = null;
        if (this.mIsRacing) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.connector.LiveFeedConnectorHorseRaceImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.setExceptionListener(null);
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.setMessageListener(null);
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.setHeartbeatListener(null);
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.clearSCMessageListener();
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.exit();
                }
            });
            return;
        }
        this.mConnection.setExceptionListener(null);
        this.mConnection.setMessageListener(null);
        this.mConnection.setHeartbeatListener(null);
        this.mConnection.clearSCMessageListener();
        this.mConnection.exit();
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void reconnect(final LongConnectionParams longConnectionParams) {
        checkIsStopped();
        if (this.mReconnectDisposable == null) {
            this.mReconnectDisposable = Observable.timer(this.mConnection.getNextConnectLatency(), TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>() { // from class: com.kuaishou.live.longconnection.connector.LiveFeedConnectorHorseRaceImpl.7
                @Override // io.reactivex.functions.Consumer
                public void accept(Long l) {
                    if (!LiveFeedConnectorHorseRaceImpl.this.mIsRacing) {
                        LiveFeedConnectorHorseRaceImpl.this.mConnection.setExceptionListener(null);
                        LiveFeedConnectorHorseRaceImpl.this.mConnection.setMessageListener(null);
                        LiveFeedConnectorHorseRaceImpl.this.mRace.clearState();
                        LiveFeedConnectorHorseRaceImpl.this.raceAndConnect(longConnectionParams);
                    }
                    LiveFeedConnectorHorseRaceImpl.this.mReconnectDisposable = null;
                }
            });
        }
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void setExceptionListener(OnConnectionExceptionListener onConnectionExceptionListener) {
        this.mOnConnectionExceptionListener = onConnectionExceptionListener;
        this.mConnection.setExceptionListener(this.mOnConnectionExceptionListener);
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void setInfoListener(LiveInfoListener liveInfoListener) {
        this.mInfoListener = liveInfoListener;
        this.mConnection.setInfoListener(liveInfoListener);
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void setMessageListener(LiveMessageListener liveMessageListener) {
        this.mLiveMessageListener = liveMessageListener;
        this.mConnection.setMessageListener(liveMessageListener);
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void setHeartbeatListener(HeartbeatListener heartbeatListener) {
        this.mHeartbeatListener = heartbeatListener;
        this.mConnection.setHeartbeatListener(heartbeatListener);
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public <T extends MessageNano> void registerSCMessageListener(int i, Class<T> cls, SCMessageListener<T> sCMessageListener) {
        LiveFeedConnection liveFeedConnection = this.mConnection;
        if (liveFeedConnection != null) {
            liveFeedConnection.registerSCMessageListener(i, cls, sCMessageListener);
        }
        this.mSCMessageListeners.add(new SCMessageListenerWrapper(i, cls, sCMessageListener));
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public <T extends MessageNano> void unregisterSCMessageListener(int i, SCMessageListener<T> sCMessageListener) {
        SCMessageListenerWrapper sCMessageListenerWrapperFindSCMessageListenerWrapper = findSCMessageListenerWrapper(i, sCMessageListener);
        if (sCMessageListenerWrapperFindSCMessageListenerWrapper != null) {
            this.mSCMessageListeners.remove(sCMessageListenerWrapperFindSCMessageListenerWrapper);
        }
        this.mConnection.unregisterSCMessageListener(i, sCMessageListener);
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void notifyBadNetworkEvent() {
        if (!this.mRace.mSuccess) {
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.connector.LiveFeedConnectorHorseRaceImpl.8
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.notifyBadNetworkEvent();
                }
            });
        } else {
            this.mConnection.notifyBadNetworkEvent();
        }
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void connect(LongConnectionParams longConnectionParams) {
        checkIsStopped();
        if (!this.mRace.mSuccess) {
            if (this.mIsRacing) {
                return;
            }
            raceAndConnect(longConnectionParams);
        } else {
            if (this.mConnection.getLongConnectionParams() != null) {
                longConnectionParams.setServerUriInfo(this.mConnection.getLongConnectionParams().getServerUriInfo());
            }
            connectWithoutRace(longConnectionParams);
        }
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void sendVoipSignal(byte[] bArr) {
        this.mConnection.sendVoipSignal(bArr);
    }

    private void connectWithoutRace(LongConnectionParams longConnectionParams) {
        this.mConnection.open(longConnectionParams);
        this.mConnection.enterRoom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raceAndConnect(LongConnectionParams longConnectionParams) {
        LiveStreamLogger.debugLog(TAG, "raceAndConnect", longConnectionParams);
        if (!this.mHasStopped) {
            this.mRace.mStartTime = System.currentTimeMillis();
        }
        LiveMessageListener liveMessageListener = this.mLiveMessageListener;
        if (liveMessageListener != null) {
            liveMessageListener.onConnectionStart();
        }
        this.mIsRacing = true;
        createRaceObservable(this.mRace.mRounds.get(0), longConnectionParams).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<HorseRunner>() { // from class: com.kuaishou.live.longconnection.connector.LiveFeedConnectorHorseRaceImpl.9
            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                LiveFeedConnectorHorseRaceImpl.this.mRaceDisposable = disposable;
                if (LiveFeedConnectorHorseRaceImpl.this.mHasStopped || LiveFeedConnectorHorseRaceImpl.this.mLiveMessageListener == null) {
                    return;
                }
                LiveFeedConnectorHorseRaceImpl.this.mLiveMessageListener.onConnectionHorseRaceStart();
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(HorseRunner horseRunner) {
                if (LiveFeedConnectorHorseRaceImpl.this.mConnection != null) {
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.exitQuietly();
                }
                LiveFeedConnectorHorseRaceImpl.this.mIsRacing = false;
                LiveFeedConnectorHorseRaceImpl.this.mRacePolicy.selectWinnerCompleted();
                LiveFeedConnectorHorseRaceImpl.this.mConnection = horseRunner.mConnection;
                if (LiveFeedConnectorHorseRaceImpl.this.mConnection != null) {
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.enterRoom();
                }
                if (LiveFeedConnectorHorseRaceImpl.this.mConnection != null && !LiveFeedConnectorHorseRaceImpl.this.mHasStopped) {
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.setExceptionListener(LiveFeedConnectorHorseRaceImpl.this.mOnConnectionExceptionListener);
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.setInfoListener(LiveFeedConnectorHorseRaceImpl.this.mInfoListener);
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.setMessageListener(LiveFeedConnectorHorseRaceImpl.this.mLiveMessageListener);
                    LiveFeedConnectorHorseRaceImpl.this.mConnection.setHeartbeatListener(LiveFeedConnectorHorseRaceImpl.this.mHeartbeatListener);
                    for (SCMessageListenerWrapper sCMessageListenerWrapper : LiveFeedConnectorHorseRaceImpl.this.mSCMessageListeners) {
                        LiveFeedConnectorHorseRaceImpl.this.mConnection.registerSCMessageListener(sCMessageListenerWrapper.payloadType, sCMessageListenerWrapper.tClass, sCMessageListenerWrapper.scMessageListener);
                    }
                }
                if (!LiveFeedConnectorHorseRaceImpl.this.mHasStopped) {
                    LiveFeedConnectorHorseRaceImpl.this.mRace.mCost = System.currentTimeMillis() - LiveFeedConnectorHorseRaceImpl.this.mRace.mStartTime;
                    LiveFeedConnectorHorseRaceImpl.this.mRace.mSuccess = true;
                    if (LiveFeedConnectorHorseRaceImpl.this.mLiveMessageListener != null) {
                        LiveFeedConnectorHorseRaceImpl.this.mLiveMessageListener.onConnectionHorseRaceSuccess(horseRunner.mHorse.mHostAndPort, LiveFeedConnectorHorseRaceImpl.this.mRace.mCost);
                    }
                }
                Iterator it = LiveFeedConnectorHorseRaceImpl.this.mPendingRunnables.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                    it.remove();
                }
                if (LiveFeedConnectorHorseRaceImpl.this.mConnection != null) {
                    LiveStreamLogger.debugLog(LiveFeedConnectorHorseRaceImpl.TAG, "raceAndConnect Success, liveStreamId: " + LiveFeedConnectorHorseRaceImpl.this.mConnection.getLongConnectionParams().getLiveStreamId() + ", winnerHorseRunner: " + horseRunner.mHorse + ", currentServerUriInfo: " + LiveFeedConnectorHorseRaceImpl.this.mConnection.getCurrentServerUriInfo(), new Object[0]);
                }
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                LiveStreamLogger.debugLog(LiveFeedConnectorHorseRaceImpl.TAG, "raceAndConnect Error", Log.getStackTraceString(th));
                if (!LiveFeedConnectorHorseRaceImpl.this.mHasStopped) {
                    LiveFeedConnectorHorseRaceImpl.this.mRace.mCost = System.currentTimeMillis() - LiveFeedConnectorHorseRaceImpl.this.mRace.mStartTime;
                    LiveFeedConnectorHorseRaceImpl.this.mRace.mSuccess = false;
                    if (LiveFeedConnectorHorseRaceImpl.this.mLiveMessageListener != null) {
                        LiveFeedConnectorHorseRaceImpl.this.mLiveMessageListener.onConnectionHorseRaceFail(LiveFeedConnectorHorseRaceImpl.this.mRace.mCost);
                    }
                }
                LiveFeedConnectorHorseRaceImpl.this.mIsRacing = false;
                OnConnectionExceptionListener onConnectionExceptionListener = LiveFeedConnectorHorseRaceImpl.this.mOnConnectionExceptionListener;
                if (onConnectionExceptionListener != null) {
                    onConnectionExceptionListener.onClientException(new HorseRaceFailedException(th));
                }
            }
        });
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void retryHorseRace(final LongConnectionParams longConnectionParams) {
        if (this.mIsRacing) {
            LiveStreamLogger.debugLog(TAG, "retryHorseRace", "mIsRacing: " + this.mIsRacing);
            this.mPendingRunnables.add(new Runnable() { // from class: com.kuaishou.live.longconnection.connector.LiveFeedConnectorHorseRaceImpl.10
                @Override // java.lang.Runnable
                public void run() {
                    LiveFeedConnectorHorseRaceImpl.this.connect(longConnectionParams);
                }
            });
            return;
        }
        connect(longConnectionParams);
    }

    Single<HorseRunner> createRaceObservable(final Round round, final LongConnectionParams longConnectionParams) {
        LiveStreamLogger.debugLog(TAG, "connect", "currentRound: " + round.toString());
        this.mRacePolicy = RacePolicyFactory.create(round, this.mNeedStopRunnerOnConsumer);
        return this.mRacePolicy.selectWinner(round.mHorses, longConnectionParams).doOnSuccess(new Consumer<HorseRunner>() { // from class: com.kuaishou.live.longconnection.connector.LiveFeedConnectorHorseRaceImpl.13
            @Override // io.reactivex.functions.Consumer
            public void accept(HorseRunner horseRunner) {
                if (LiveFeedConnectorHorseRaceImpl.this.mHasStopped) {
                    return;
                }
                round.mCost = System.currentTimeMillis() - round.mStartTime;
                round.mSuccess = true;
            }
        }).doOnSubscribe(new Consumer<Disposable>() { // from class: com.kuaishou.live.longconnection.connector.LiveFeedConnectorHorseRaceImpl.12
            @Override // io.reactivex.functions.Consumer
            public void accept(Disposable disposable) {
                LiveFeedConnectorHorseRaceImpl.this.mRacePolicyDisposable = disposable;
                round.mStartTime = System.currentTimeMillis();
                LiveStreamLogger.debugLog(LiveFeedConnectorHorseRaceImpl.TAG, "onSubscribe", new Object[0]);
            }
        }).onErrorResumeNext(new Function<Throwable, SingleSource<? extends HorseRunner>>() { // from class: com.kuaishou.live.longconnection.connector.LiveFeedConnectorHorseRaceImpl.11
            @Override // io.reactivex.functions.Function
            public SingleSource<? extends HorseRunner> apply(Throwable th) {
                round.mCost = System.currentTimeMillis() - round.mStartTime;
                LiveStreamLogger.debugLog(LiveFeedConnectorHorseRaceImpl.TAG, "onErrorResumeNext", Log.getStackTraceString(th));
                int iIndexOf = LiveFeedConnectorHorseRaceImpl.this.mRace.mRounds.indexOf(round);
                if (iIndexOf < LiveFeedConnectorHorseRaceImpl.this.mRace.mRounds.size() - 1) {
                    LiveFeedConnectorHorseRaceImpl liveFeedConnectorHorseRaceImpl = LiveFeedConnectorHorseRaceImpl.this;
                    return liveFeedConnectorHorseRaceImpl.createRaceObservable(liveFeedConnectorHorseRaceImpl.mRace.mRounds.get(iIndexOf + 1), longConnectionParams);
                }
                return Single.error(th);
            }
        });
    }

    private void checkIsStopped() {
        if (this.mHasStopped) {
            throw new IllegalStateException("Connector has been stopped");
        }
    }

    private void dispose(Disposable disposable) {
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        disposable.dispose();
    }

    private <T extends MessageNano> SCMessageListenerWrapper findSCMessageListenerWrapper(int i, SCMessageListener<T> sCMessageListener) {
        for (SCMessageListenerWrapper sCMessageListenerWrapper : this.mSCMessageListeners) {
            if (sCMessageListenerWrapper.payloadType == i && sCMessageListenerWrapper.scMessageListener == sCMessageListener) {
                return sCMessageListenerWrapper;
            }
        }
        return null;
    }

    public static class SCMessageListenerWrapper<T extends MessageNano> {
        public final int payloadType;
        public final SCMessageListener<T> scMessageListener;
        public final Class<T> tClass;

        public SCMessageListenerWrapper(int i, Class<T> cls, SCMessageListener<T> sCMessageListener) {
            this.payloadType = i;
            this.tClass = cls;
            this.scMessageListener = sCMessageListener;
        }
    }
}
