package com.kuaishou.live.longconnection;

import com.google.protobuf.nano.MessageNano;
import com.kuaishou.live.longconnection.connector.LiveFeedConnectorHorseRaceImpl;
import com.kuaishou.livestream.message.nano.LiveFansGroupMessages;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;
import com.kuaishou.livestream.message.nano.SCActionSignal;
import com.yxcorp.livestream.longconnection.ConnectionSumStatistics;
import com.yxcorp.livestream.longconnection.HeartbeatListener;
import com.yxcorp.livestream.longconnection.LiveInfoListener;
import com.yxcorp.livestream.longconnection.LiveLongConnectionServerException;
import com.yxcorp.livestream.longconnection.LiveMessageListener;
import com.yxcorp.livestream.longconnection.LongConnectionParams;
import com.yxcorp.livestream.longconnection.OnConnectionExceptionListener;
import com.yxcorp.livestream.longconnection.SCMessageListener;
import com.yxcorp.livestream.longconnection.exception.ChannelException;
import com.yxcorp.livestream.longconnection.exception.ClientException;
import com.yxcorp.livestream.longconnection.exception.ServerInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveLongConnectionImpl implements LiveLongConnection {
    private LiveFeedConnectorManager mConnectionManager;
    private final Set<SCMessageListener<SCActionSignal>> mActionSignalListeners = new CopyOnWriteArraySet();
    private final Set<HeartbeatListener> mHeartbeatListeners = new HashSet();
    private final Set<OnConnectionExceptionListener> mExceptionListeners = new HashSet();
    private final Set<LiveInfoListener> mLiveInfoListeners = new HashSet();
    private final Set<LiveMessageListener> mLiveMessageListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private final Map<SCMessageListener, LiveFeedConnectorHorseRaceImpl.SCMessageListenerWrapper> mSCMessageListeners = new HashMap();
    private SCMessageListener<SCActionSignal> mActionSignalMessageListener = new SCMessageListener<SCActionSignal>() { // from class: com.kuaishou.live.longconnection.LiveLongConnectionImpl.1
        @Override // com.yxcorp.livestream.longconnection.SCMessageListener
        public void onMessageReceived(SCActionSignal sCActionSignal) {
            if (LiveLongConnectionImpl.this.mActionSignalListeners == null || LiveLongConnectionImpl.this.mActionSignalListeners.isEmpty()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mActionSignalListeners.iterator();
            while (it.hasNext()) {
                ((SCMessageListener) it.next()).onMessageReceived(sCActionSignal);
            }
        }
    };

    public LiveLongConnectionImpl(LiveLongConnectionContext liveLongConnectionContext) {
        createLiveFeedConnectorManager(liveLongConnectionContext);
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void addMessageListener(LiveMessageListener liveMessageListener) {
        if (liveMessageListener == null) {
            return;
        }
        this.mLiveMessageListeners.add(liveMessageListener);
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void removeMessageListener(LiveMessageListener liveMessageListener) {
        if (liveMessageListener == null) {
            return;
        }
        this.mLiveMessageListeners.remove(liveMessageListener);
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void addHeartbeatListener(HeartbeatListener heartbeatListener) {
        if (heartbeatListener == null) {
            return;
        }
        this.mHeartbeatListeners.add(heartbeatListener);
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void removeHeartbeatListener(HeartbeatListener heartbeatListener) {
        if (heartbeatListener == null) {
            return;
        }
        this.mHeartbeatListeners.remove(heartbeatListener);
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void addActionSignalListener(SCMessageListener<SCActionSignal> sCMessageListener) {
        if (sCMessageListener == null) {
            return;
        }
        this.mActionSignalListeners.add(sCMessageListener);
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void removeActionSignalListener(SCMessageListener<SCActionSignal> sCMessageListener) {
        if (sCMessageListener == null) {
            return;
        }
        this.mActionSignalListeners.remove(sCMessageListener);
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public <T extends MessageNano> void registerSCMessageListener(int i, Class<T> cls, SCMessageListener<T> sCMessageListener) {
        if (sCMessageListener == null) {
            return;
        }
        this.mSCMessageListeners.put(sCMessageListener, new LiveFeedConnectorHorseRaceImpl.SCMessageListenerWrapper(i, cls, sCMessageListener));
        LiveFeedConnectorManager liveFeedConnectorManager = this.mConnectionManager;
        if (liveFeedConnectorManager != null) {
            liveFeedConnectorManager.registerSCMessageListener(i, cls, sCMessageListener);
        }
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public <T extends MessageNano> void unregisterSCMessageListener(int i, SCMessageListener<T> sCMessageListener) {
        if (sCMessageListener == null) {
            return;
        }
        this.mSCMessageListeners.remove(sCMessageListener);
        LiveFeedConnectorManager liveFeedConnectorManager = this.mConnectionManager;
        if (liveFeedConnectorManager != null) {
            liveFeedConnectorManager.unregisterSCMessageListener(i, sCMessageListener);
        }
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void addExceptionListener(OnConnectionExceptionListener onConnectionExceptionListener) {
        if (onConnectionExceptionListener == null) {
            return;
        }
        this.mExceptionListeners.add(onConnectionExceptionListener);
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void removeExceptionListener(OnConnectionExceptionListener onConnectionExceptionListener) {
        if (onConnectionExceptionListener == null) {
            return;
        }
        this.mExceptionListeners.remove(onConnectionExceptionListener);
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void addInfoListener(LiveInfoListener liveInfoListener) {
        if (liveInfoListener == null) {
            return;
        }
        this.mLiveInfoListeners.add(liveInfoListener);
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void removeInfoListener(LiveInfoListener liveInfoListener) {
        if (liveInfoListener == null) {
            return;
        }
        this.mLiveInfoListeners.remove(liveInfoListener);
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void resume() {
        this.mConnectionManager.resume();
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public boolean hasExited() {
        return this.mConnectionManager.hasExited();
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void disconnect() {
        this.mConnectionManager.disconnect();
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public boolean isConnected() {
        return this.mConnectionManager.isConnected();
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void forceExit() {
        this.mConnectionManager.forceExit();
        clearLongConnectionListeners();
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void exitImmediately() {
        this.mConnectionManager.exitImmediately();
        clearLongConnectionListeners();
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void exitDelayed(int i) {
        this.mConnectionManager.exitDelayed(i);
        clearLongConnectionListeners();
        this.mConnectionManager.setMessageListener(new ExitingOnMessageListenerWrapper());
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void reconnect() {
        this.mConnectionManager.reconnect();
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void sendVoipSignal(byte[] bArr) {
        this.mConnectionManager.sendVoipSignal(bArr);
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void markCurrentServerUriFailed() {
        this.mConnectionManager.markCurrentServerUriFailed();
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void clearLiveFeedMessageListener() {
        this.mHeartbeatListeners.clear();
        this.mActionSignalListeners.clear();
        this.mExceptionListeners.clear();
        this.mLiveInfoListeners.clear();
        this.mExceptionListeners.clear();
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void notifyBadNetworkEvent() {
        this.mConnectionManager.notifyBadNetworkEvent();
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void anchorPause() {
        this.mConnectionManager.anchorPause();
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public boolean hasAuthorPauseCalled() {
        return this.mConnectionManager.hasAuthorPauseCalled();
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void anchorPauseForPhoneCall() {
        this.mConnectionManager.anchorPauseForPhoneCall();
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void audiencePause() {
        this.mConnectionManager.audiencePause();
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void pause(int i) {
        this.mConnectionManager.pause(i);
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public ConnectionSumStatistics getConnectionStatistics() {
        return this.mConnectionManager.getConnectionStatistics();
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public Set<LiveMessageListener> getLiveMessageListeners() {
        return this.mLiveMessageListeners;
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public LongConnectionParams.ServerUriInfo getCurrentServerUriInfo() {
        return this.mConnectionManager.getCurrentServerUriInfo();
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void resetLiveFeedConnector(LiveLongConnectionContext liveLongConnectionContext) {
        createLiveFeedConnectorManager(liveLongConnectionContext);
        if (this.mSCMessageListeners.isEmpty() || this.mConnectionManager == null) {
            return;
        }
        for (LiveFeedConnectorHorseRaceImpl.SCMessageListenerWrapper sCMessageListenerWrapper : this.mSCMessageListeners.values()) {
            if (sCMessageListenerWrapper != null) {
                this.mConnectionManager.registerSCMessageListener(sCMessageListenerWrapper.payloadType, sCMessageListenerWrapper.tClass, sCMessageListenerWrapper.scMessageListener);
            }
        }
    }

    @Override // com.kuaishou.live.longconnection.LiveLongConnection
    public void retryHorseRace() {
        this.mConnectionManager.retryHorseRace();
    }

    private void clearLongConnectionListeners() {
        this.mConnectionManager.setExceptionListener(null);
        this.mConnectionManager.setHeartbeatListener(null);
        this.mConnectionManager.setInfoListener(null);
        this.mConnectionManager.setExceptionListener(null);
    }

    private void createLiveFeedConnectorManager(LiveLongConnectionContext liveLongConnectionContext) {
        this.mConnectionManager = new LiveFeedConnectorManager(liveLongConnectionContext, new OnMessageListenerWrapper(), new LiveInfoListenerWrapper(), new OnHeartbeatListenerWrapper(), new OnExceptionListenerWrapper());
        this.mConnectionManager.registerSCMessageListener(510, SCActionSignal.class, this.mActionSignalMessageListener);
    }

    class OnExceptionListenerWrapper implements OnConnectionExceptionListener {
        private OnExceptionListenerWrapper() {
        }

        @Override // com.yxcorp.livestream.longconnection.OnConnectionExceptionListener
        public void onServerException(LiveLongConnectionServerException liveLongConnectionServerException) {
            LiveLongConnectionImpl.this.mConnectionManager.getConnectionStatistics().setLastErrorCode(liveLongConnectionServerException.errorCode);
            if (LiveLongConnectionImpl.this.mExceptionListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mExceptionListeners.iterator();
            while (it.hasNext()) {
                ((OnConnectionExceptionListener) it.next()).onServerException(liveLongConnectionServerException);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.OnConnectionExceptionListener
        public void onChannelException(ChannelException channelException) {
            LiveLongConnectionImpl.this.mConnectionManager.getConnectionStatistics().setLastErrorCode(-1);
            if (LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mExceptionListeners.iterator();
            while (it.hasNext()) {
                ((OnConnectionExceptionListener) it.next()).onChannelException(channelException);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.OnConnectionExceptionListener
        public void onClientException(ClientException clientException) {
            LiveLongConnectionImpl.this.mConnectionManager.getConnectionStatistics().setLastErrorCode(-2);
            if (LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mExceptionListeners.iterator();
            while (it.hasNext()) {
                ((OnConnectionExceptionListener) it.next()).onClientException(clientException);
            }
        }
    }

    class LiveInfoListenerWrapper implements LiveInfoListener {
        LiveInfoListenerWrapper() {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveInfoListener
        public void onServerInfo(ServerInfo serverInfo) {
            Iterator it = LiveLongConnectionImpl.this.mLiveInfoListeners.iterator();
            while (it.hasNext()) {
                ((LiveInfoListener) it.next()).onServerInfo(serverInfo);
            }
        }
    }

    class OnHeartbeatListenerWrapper implements HeartbeatListener {
        OnHeartbeatListenerWrapper() {
        }

        @Override // com.yxcorp.livestream.longconnection.HeartbeatAckListener
        public void onHeartbeatAckReceived(long j, long j2) {
            Iterator it = LiveLongConnectionImpl.this.mHeartbeatListeners.iterator();
            while (it.hasNext()) {
                ((HeartbeatListener) it.next()).onHeartbeatAckReceived(j, j2);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.HeartbeatListener
        public void onHeartbeatSend(long j) {
            Iterator it = LiveLongConnectionImpl.this.mHeartbeatListeners.iterator();
            while (it.hasNext()) {
                ((HeartbeatListener) it.next()).onHeartbeatSend(j);
            }
        }
    }

    class OnMessageListenerWrapper implements LiveMessageListener {
        OnMessageListenerWrapper() {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onConnectionStart() {
            LiveLongConnectionImpl.this.mConnectionManager.getConnectionStatistics().onStartConnect();
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onConnectionEstablished() {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onConnectionEstablished();
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onConnectionHorseRaceStart() {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onConnectionHorseRaceStart();
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onConnectionHorseRaceSuccess(String str, long j) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onConnectionHorseRaceSuccess(str, j);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onConnectionHorseRaceFail(long j) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onConnectionHorseRaceFail(j);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onEnterRoomAckReceived(LiveStreamMessages.SCEnterRoomAck sCEnterRoomAck) {
            LiveLongConnectionImpl.this.mConnectionManager.getConnectionStatistics().setCurrentServerUriInfo(LiveLongConnectionImpl.this.mConnectionManager.getCurrentServerUriInfo());
            LiveLongConnectionImpl.this.mConnectionManager.getConnectionStatistics().setLastErrorCode(0);
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onEnterRoomAckReceived(sCEnterRoomAck);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onFeedReceived(LiveStreamMessages.SCFeedPush sCFeedPush) {
            LiveLongConnectionImpl.this.mConnectionManager.getConnectionStatistics().setCurrentServerUriInfo(LiveLongConnectionImpl.this.mConnectionManager.getCurrentServerUriInfo());
            LiveLongConnectionImpl.this.mConnectionManager.getConnectionStatistics().onFirstFeedReceived();
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onFeedReceived(sCFeedPush);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onFeedReceived(LiveStreamMessages.SCLiveWatchingList sCLiveWatchingList) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onFeedReceived(sCLiveWatchingList);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onConnectionInterrupt() {
            LiveLongConnectionImpl.this.mConnectionManager.getConnectionStatistics().setLastErrorCode(1051);
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onConnectionInterrupt();
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onAuthorPause(LiveStreamMessages.SCAuthorPause sCAuthorPause) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onAuthorPause(sCAuthorPause);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onAssistantStatusChange(LiveStreamMessages.SCAssistantStatus sCAssistantStatus) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onAssistantStatusChange(sCAssistantStatus);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onAuthorResume(LiveStreamMessages.SCAuthorResume sCAuthorResume) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onAuthorResume(sCAuthorResume);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onLiveChatCall(LiveStreamMessages.SCLiveChatCall sCLiveChatCall) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onLiveChatCall(sCLiveChatCall);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onLiveChatReady(LiveStreamMessages.SCLiveChatReady sCLiveChatReady) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onLiveChatReady(sCLiveChatReady);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onLiveChatEnded() {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onLiveChatEnded();
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onRenderingMagicFaceDisable() {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onRenderingMagicFaceDisable();
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onRenderingMagicFaceEnable() {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onRenderingMagicFaceEnable();
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onSuspectedViolationChange(LiveStreamMessages.SCSuspectedViolation sCSuspectedViolation) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onSuspectedViolationChange(sCSuspectedViolation);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onVoipSignal(LiveStreamMessages.SCVoipSignal sCVoipSignal) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onVoipSignal(sCVoipSignal);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onWishListOpened(LiveStreamMessages.SCWishListOpened sCWishListOpened) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onWishListOpened(sCWishListOpened);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onWishListClosed(LiveStreamMessages.SCWishListClosed sCWishListClosed) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onWishListClosed(sCWishListClosed);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onFansTopOpen(LiveStreamMessages.SCLiveFansTopOpened sCLiveFansTopOpened) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onFansTopOpen(sCLiveFansTopOpened);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onFansTopClose(LiveStreamMessages.SCLiveFansTopClosed sCLiveFansTopClosed) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onFansTopClose(sCLiveFansTopClosed);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onLiveDistrictRankInfoReceived(LiveStreamMessages.SCLiveDistrictRankInfo sCLiveDistrictRankInfo) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onLiveDistrictRankInfoReceived(sCLiveDistrictRankInfo);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onLiveDistrictRankClosed(LiveStreamMessages.SCLiveDistrictRankClosed sCLiveDistrictRankClosed) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onLiveDistrictRankClosed(sCLiveDistrictRankClosed);
            }
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onLiveFansGroupStatusChanged(LiveFansGroupMessages.SCLiveFansGroupStatusChanged sCLiveFansGroupStatusChanged) {
            if (LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onLiveFansGroupStatusChanged(sCLiveFansGroupStatusChanged);
            }
        }
    }

    class ExitingOnMessageListenerWrapper extends LiveMessageListener.SimpleLiveMessageListener {
        private ExitingOnMessageListenerWrapper() {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener.SimpleLiveMessageListener, com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onVoipSignal(LiveStreamMessages.SCVoipSignal sCVoipSignal) {
            if (sCVoipSignal == null || sCVoipSignal.signal == null || sCVoipSignal.signal.signalType != 3 || LiveLongConnectionImpl.this.mLiveMessageListeners == null || LiveLongConnectionImpl.this.hasExited()) {
                return;
            }
            Iterator it = LiveLongConnectionImpl.this.mLiveMessageListeners.iterator();
            while (it.hasNext()) {
                ((LiveMessageListener) it.next()).onVoipSignal(sCVoipSignal);
            }
        }
    }
}
