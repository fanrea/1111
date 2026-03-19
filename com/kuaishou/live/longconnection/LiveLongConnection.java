package com.kuaishou.live.longconnection;

import com.google.protobuf.nano.MessageNano;
import com.kuaishou.livestream.message.nano.SCActionSignal;
import com.yxcorp.livestream.longconnection.ConnectionSumStatistics;
import com.yxcorp.livestream.longconnection.HeartbeatListener;
import com.yxcorp.livestream.longconnection.LiveInfoListener;
import com.yxcorp.livestream.longconnection.LiveMessageListener;
import com.yxcorp.livestream.longconnection.LongConnectionParams;
import com.yxcorp.livestream.longconnection.OnConnectionExceptionListener;
import com.yxcorp.livestream.longconnection.SCMessageListener;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveLongConnection {
    void addActionSignalListener(SCMessageListener<SCActionSignal> sCMessageListener);

    void addExceptionListener(OnConnectionExceptionListener onConnectionExceptionListener);

    void addHeartbeatListener(HeartbeatListener heartbeatListener);

    void addInfoListener(LiveInfoListener liveInfoListener);

    void addMessageListener(LiveMessageListener liveMessageListener);

    @Deprecated
    void anchorPause();

    @Deprecated
    void anchorPauseForPhoneCall();

    @Deprecated
    void audiencePause();

    void clearLiveFeedMessageListener();

    void disconnect();

    void exitDelayed(int i);

    void exitImmediately();

    void forceExit();

    ConnectionSumStatistics getConnectionStatistics();

    LongConnectionParams.ServerUriInfo getCurrentServerUriInfo();

    Set<LiveMessageListener> getLiveMessageListeners();

    boolean hasAuthorPauseCalled();

    boolean hasExited();

    boolean isConnected();

    void markCurrentServerUriFailed();

    void notifyBadNetworkEvent();

    void pause(int i);

    void reconnect();

    <T extends MessageNano> void registerSCMessageListener(int i, Class<T> cls, SCMessageListener<T> sCMessageListener);

    void removeActionSignalListener(SCMessageListener<SCActionSignal> sCMessageListener);

    void removeExceptionListener(OnConnectionExceptionListener onConnectionExceptionListener);

    void removeHeartbeatListener(HeartbeatListener heartbeatListener);

    void removeInfoListener(LiveInfoListener liveInfoListener);

    void removeMessageListener(LiveMessageListener liveMessageListener);

    void resetLiveFeedConnector(LiveLongConnectionContext liveLongConnectionContext);

    void resume();

    void retryHorseRace();

    void sendVoipSignal(byte[] bArr);

    <T extends MessageNano> void unregisterSCMessageListener(int i, SCMessageListener<T> sCMessageListener);
}
