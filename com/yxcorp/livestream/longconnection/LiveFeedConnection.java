package com.yxcorp.livestream.longconnection;

import android.os.Handler;
import com.google.protobuf.nano.MessageNano;
import com.kuaishou.android.live.model.Horse;
import com.kuaishou.common.netty.NanoSocketMessageUtil;
import com.kuaishou.common.netty.client.ConnectionClient;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;
import com.yxcorp.livestream.longconnection.LongConnectionParams;
import com.yxcorp.livestream.longconnection.RunnablePipeline;
import com.yxcorp.livestream.longconnection.exception.ChannelException;
import com.yxcorp.livestream.longconnection.exception.ClientException;
import com.yxcorp.livestream.longconnection.operation.ConnectOperation;
import com.yxcorp.livestream.longconnection.operation.DisconnectOperation;
import com.yxcorp.livestream.longconnection.operation.EnterRoomOperation;
import com.yxcorp.livestream.longconnection.operation.HorseRaceOperation;
import com.yxcorp.livestream.longconnection.operation.SendMessageOperation;
import com.yxcorp.livestream.longconnection.operation.VoipSignalOperation;
import com.yxcorp.livestream.longconnection.operation.WaitOption;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Future;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveFeedConnection {
    private static final String TAG = "LiveFeedConnection";
    private static List<LiveFeedConnection> sLiveFeedConnections = new Vector();
    Handler mLongConnectionHandler;
    final LongConnectionContext mContext = new LongConnectionContext();
    final RunnablePipeline mMessageRunnablePipeline = makePipeline();
    private Future mMessageRunnablePipelineFuture = this.mMessageRunnablePipeline.start();

    public static void closeAllConnections() {
        Iterator<LiveFeedConnection> it = sLiveFeedConnections.iterator();
        while (it.hasNext()) {
            LiveFeedConnection next = it.next();
            if (next != null) {
                LiveStreamLogger.debugLog(TAG, "close_one_by_one", "params: " + next.getLongConnectionParams(), "server: " + next.getCurrentServerUriInfo());
                next.exit();
            }
            it.remove();
        }
    }

    public static RunnablePipeline makePipeline() {
        return new RunnablePipeline();
    }

    public LiveFeedConnection() {
        this.mContext.setMessageRunnablePipeline(this.mMessageRunnablePipeline);
        sLiveFeedConnections.add(this);
    }

    public void open(LongConnectionParams longConnectionParams) {
        this.mContext.setLongConnectionParams(longConnectionParams);
        clearHandlerMessages();
        LongConnectionContext longConnectionContext = this.mContext;
        longConnectionContext.submitOperation(new ConnectOperation(longConnectionContext));
    }

    public <T extends MessageNano> void registerSCMessageListener(int i, Class<T> cls, SCMessageListener<T> sCMessageListener) {
        this.mContext.registerSCMessageListener(i, cls, sCMessageListener);
        if (this.mContext.getClient() != null) {
            this.mContext.registerHandlers();
        }
    }

    public <T extends MessageNano> void unregisterSCMessageListener(int i, SCMessageListener<T> sCMessageListener) {
        this.mContext.unregisterSCMessageListener(i, sCMessageListener);
    }

    public void clearSCMessageListener() {
        ConnectionClient client = this.mContext.getClient();
        if (client != null) {
            client.getChannelHandler().getPayloadHandlers().clearHandlers();
        }
        this.mContext.clearSCMessageListener();
    }

    /* renamed from: com.yxcorp.livestream.longconnection.LiveFeedConnection$1, reason: invalid class name */
    class AnonymousClass1 implements ObservableOnSubscribe<LiveFeedConnection> {
        boolean mDone;
        final Object mLocker = new Object();
        final /* synthetic */ Horse val$horse;
        final /* synthetic */ LongConnectionParams val$longConnectionParams;

        AnonymousClass1(LongConnectionParams longConnectionParams, Horse horse) {
            this.val$longConnectionParams = longConnectionParams;
            this.val$horse = horse;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void deliverError(ObservableEmitter<LiveFeedConnection> observableEmitter, Throwable th) {
            synchronized (this.mLocker) {
                if (!observableEmitter.isDisposed() && !this.mDone) {
                    observableEmitter.onError(th);
                    this.mDone = true;
                }
            }
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(final ObservableEmitter<LiveFeedConnection> observableEmitter) {
            LiveFeedConnection.this.setExceptionListener(new OnConnectionExceptionListener() { // from class: com.yxcorp.livestream.longconnection.LiveFeedConnection.1.1
                @Override // com.yxcorp.livestream.longconnection.OnConnectionExceptionListener
                public void onServerException(LiveLongConnectionServerException liveLongConnectionServerException) {
                    AnonymousClass1.this.deliverError(observableEmitter, liveLongConnectionServerException);
                }

                @Override // com.yxcorp.livestream.longconnection.OnConnectionExceptionListener
                public void onChannelException(ChannelException channelException) {
                    AnonymousClass1.this.deliverError(observableEmitter, channelException);
                }

                @Override // com.yxcorp.livestream.longconnection.OnConnectionExceptionListener
                public void onClientException(ClientException clientException) {
                    AnonymousClass1.this.deliverError(observableEmitter, clientException);
                }
            });
            LiveFeedConnection.this.open(this.val$longConnectionParams.setServerUriInfo(new LongConnectionParams.ServerUriInfo(this.val$horse.mHostAndPort, "")));
            LiveFeedConnection.this.mContext.submitOperation(new HorseRaceOperation(LiveFeedConnection.this.mContext, this.val$horse.mTag, new Runnable() { // from class: com.yxcorp.livestream.longconnection.LiveFeedConnection.1.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (AnonymousClass1.this.mLocker) {
                        if (!AnonymousClass1.this.mDone) {
                            observableEmitter.onNext(LiveFeedConnection.this);
                            observableEmitter.onComplete();
                            AnonymousClass1.this.mDone = true;
                        }
                    }
                }
            }));
        }
    }

    public Observable<LiveFeedConnection> horseRace(LongConnectionParams longConnectionParams, Horse horse) {
        return Observable.create(new AnonymousClass1(longConnectionParams, horse));
    }

    public void horseRaceLoss() {
        LiveStreamMessages.CSRaceLose cSRaceLose = new LiveStreamMessages.CSRaceLose();
        cSRaceLose.time = System.currentTimeMillis();
        LongConnectionContext longConnectionContext = this.mContext;
        longConnectionContext.submitOperation(new SendMessageOperation(longConnectionContext, NanoSocketMessageUtil.pack(cSRaceLose, 205)));
    }

    public void addWaitOption(long j) {
        this.mContext.submitOperation(new WaitOption(j));
    }

    public void enterRoom() {
        LongConnectionContext longConnectionContext = this.mContext;
        longConnectionContext.submitOperation(new EnterRoomOperation(longConnectionContext));
    }

    public boolean isConnected() {
        return this.mMessageRunnablePipeline.getStatus() == RunnablePipeline.Status.RUNNING && this.mContext.getClient() != null;
    }

    public void pause(int i) {
        LiveStreamMessages.CSUserPause cSUserPause = new LiveStreamMessages.CSUserPause();
        cSUserPause.pauseType = i;
        cSUserPause.time = System.currentTimeMillis();
        LongConnectionContext longConnectionContext = this.mContext;
        longConnectionContext.submitOperation(new SendMessageOperation(longConnectionContext, NanoSocketMessageUtil.pack(cSUserPause, 201)));
    }

    public void disconnect() {
        LongConnectionContext longConnectionContext = this.mContext;
        longConnectionContext.submitOperation(new DisconnectOperation(longConnectionContext));
    }

    public void notifyBadNetworkEvent() {
        LiveStreamMessages.CSAuthorPushTrafficZero cSAuthorPushTrafficZero = new LiveStreamMessages.CSAuthorPushTrafficZero();
        cSAuthorPushTrafficZero.time = System.currentTimeMillis();
        LongConnectionContext longConnectionContext = this.mContext;
        longConnectionContext.submitOperation(new SendMessageOperation(longConnectionContext, NanoSocketMessageUtil.pack(cSAuthorPushTrafficZero, 203)));
    }

    public void sendVoipSignal(byte[] bArr) {
        LongConnectionContext longConnectionContext = this.mContext;
        longConnectionContext.submitOperation(new VoipSignalOperation(longConnectionContext, bArr));
    }

    public void exit() {
        LiveStreamMessages.CSUserExit cSUserExit = new LiveStreamMessages.CSUserExit();
        cSUserExit.time = System.currentTimeMillis();
        LongConnectionContext longConnectionContext = this.mContext;
        longConnectionContext.submitOperation(new SendMessageOperation(longConnectionContext, NanoSocketMessageUtil.pack(cSUserExit, 202)));
        exitQuietly();
    }

    public void exitQuietly() {
        disconnect();
        this.mContext.submitOperation(new Runnable() { // from class: com.yxcorp.livestream.longconnection.LiveFeedConnection.2
            @Override // java.lang.Runnable
            public void run() {
                LiveFeedConnection.this.quitThread();
            }
        });
    }

    public LongConnectionParams getLongConnectionParams() {
        return this.mContext.getLongConnectionParams();
    }

    public LongConnectionParams.ServerUriInfo getCurrentServerUriInfo() {
        return this.mContext.getCurrentServerUriInfo();
    }

    public OnConnectionExceptionListener getExceptionListener() {
        return this.mContext.getExceptionListener();
    }

    public LiveFeedConnection setExceptionListener(OnConnectionExceptionListener onConnectionExceptionListener) {
        this.mContext.setExceptionListener(onConnectionExceptionListener);
        return this;
    }

    public LiveFeedConnection setInfoListener(LiveInfoListener liveInfoListener) {
        this.mContext.setInfoListener(liveInfoListener);
        return this;
    }

    public void setMessageListener(LiveMessageListener liveMessageListener) {
        this.mContext.setMessageListener(liveMessageListener);
    }

    public void setHeartbeatListener(HeartbeatListener heartbeatListener) {
        this.mContext.setHeartbeatListener(heartbeatListener);
    }

    public LiveMessageListener getMessageListener() {
        return this.mContext.getMessageListener();
    }

    private void clearHandlerMessages() {
        Handler handler = this.mLongConnectionHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    synchronized void quitThread() {
        LiveStreamLogger.debugLog(TAG, "quitThread", "params: " + getLongConnectionParams(), "server: " + getCurrentServerUriInfo());
        this.mMessageRunnablePipeline.quit();
        sLiveFeedConnections.remove(this);
    }

    public long getNextConnectLatency() {
        return this.mContext.getNextConnectLatency();
    }
}
