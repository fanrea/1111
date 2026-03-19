package com.kuaishou.live.longconnection.connector;

import com.google.protobuf.nano.MessageNano;
import com.yxcorp.livestream.longconnection.HeartbeatListener;
import com.yxcorp.livestream.longconnection.LiveInfoListener;
import com.yxcorp.livestream.longconnection.LiveMessageListener;
import com.yxcorp.livestream.longconnection.LongConnectionParams;
import com.yxcorp.livestream.longconnection.OnConnectionExceptionListener;
import com.yxcorp.livestream.longconnection.SCMessageListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveFeedConnector {
    @Deprecated
    void anchorPause();

    @Deprecated
    void anchorPauseForPhoneCall();

    @Deprecated
    void audiencePause();

    void connect(LongConnectionParams longConnectionParams);

    void disconnect();

    void disposeRace();

    void exit();

    void forceExit();

    LongConnectionParams.ServerUriInfo getCurrentServerUriInfo();

    boolean isConnected();

    void notifyBadNetworkEvent();

    void pause(int i);

    void reconnect(LongConnectionParams longConnectionParams);

    <T extends MessageNano> void registerSCMessageListener(int i, Class<T> cls, SCMessageListener<T> sCMessageListener);

    void retryHorseRace(LongConnectionParams longConnectionParams);

    void sendVoipSignal(byte[] bArr);

    void setExceptionListener(OnConnectionExceptionListener onConnectionExceptionListener);

    void setHeartbeatListener(HeartbeatListener heartbeatListener);

    void setInfoListener(LiveInfoListener liveInfoListener);

    void setMessageListener(LiveMessageListener liveMessageListener);

    <T extends MessageNano> void unregisterSCMessageListener(int i, SCMessageListener<T> sCMessageListener);
}
