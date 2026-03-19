package com.kuaishou.live.longconnection.connector;

import com.google.protobuf.nano.MessageNano;
import com.yxcorp.livestream.longconnection.HeartbeatListener;
import com.yxcorp.livestream.longconnection.LiveFeedConnection;
import com.yxcorp.livestream.longconnection.LiveInfoListener;
import com.yxcorp.livestream.longconnection.LiveMessageListener;
import com.yxcorp.livestream.longconnection.LongConnectionParams;
import com.yxcorp.livestream.longconnection.OnConnectionExceptionListener;
import com.yxcorp.livestream.longconnection.SCMessageListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveFeedConnectorDefaultImpl implements LiveFeedConnector {
    private LiveFeedConnection mConnection = new LiveFeedConnection();
    private LongConnectionParams.ServerUriInfo mCurrentServer;
    private final List<String> mHostPorts;

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void disposeRace() {
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void retryHorseRace(LongConnectionParams longConnectionParams) {
    }

    public LiveFeedConnectorDefaultImpl(List<String> list) {
        this.mHostPorts = list;
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public LongConnectionParams.ServerUriInfo getCurrentServerUriInfo() {
        return this.mConnection.getCurrentServerUriInfo();
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void anchorPause() {
        this.mConnection.pause(0);
        this.mConnection.disconnect();
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void anchorPauseForPhoneCall() {
        this.mConnection.pause(1);
        this.mConnection.disconnect();
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void audiencePause() {
        this.mConnection.pause(0);
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void pause(int i) {
        this.mConnection.pause(i);
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public boolean isConnected() {
        return this.mConnection.isConnected();
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void disconnect() {
        this.mConnection.disconnect();
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void exit() {
        this.mConnection.exit();
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void forceExit() {
        exit();
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void reconnect(LongConnectionParams longConnectionParams) {
        List<LongConnectionParams.ServerUriInfo> serverUriInfos = getServerUriInfos(this.mHostPorts);
        if (serverUriInfos == null || serverUriInfos.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= serverUriInfos.size()) {
                break;
            }
            if (serverUriInfos.get(i).getServerUri().equals(this.mCurrentServer.getServerUri())) {
                this.mCurrentServer = serverUriInfos.get((i + 1) % serverUriInfos.size());
                break;
            }
            i++;
        }
        LiveFeedConnection liveFeedConnection = this.mConnection;
        liveFeedConnection.addWaitOption(liveFeedConnection.getNextConnectLatency());
        connectInternal(longConnectionParams.setServerUriInfo(this.mCurrentServer));
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void setExceptionListener(OnConnectionExceptionListener onConnectionExceptionListener) {
        this.mConnection.setExceptionListener(onConnectionExceptionListener);
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void setInfoListener(LiveInfoListener liveInfoListener) {
        this.mConnection.setInfoListener(liveInfoListener);
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void setMessageListener(LiveMessageListener liveMessageListener) {
        this.mConnection.setMessageListener(liveMessageListener);
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void setHeartbeatListener(HeartbeatListener heartbeatListener) {
        this.mConnection.setHeartbeatListener(heartbeatListener);
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public <T extends MessageNano> void registerSCMessageListener(int i, Class<T> cls, SCMessageListener<T> sCMessageListener) {
        this.mConnection.registerSCMessageListener(i, cls, sCMessageListener);
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public <T extends MessageNano> void unregisterSCMessageListener(int i, SCMessageListener<T> sCMessageListener) {
        this.mConnection.unregisterSCMessageListener(i, sCMessageListener);
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void notifyBadNetworkEvent() {
        this.mConnection.notifyBadNetworkEvent();
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void connect(LongConnectionParams longConnectionParams) {
        List<LongConnectionParams.ServerUriInfo> serverUriInfos = getServerUriInfos(this.mHostPorts);
        if (serverUriInfos == null || serverUriInfos.isEmpty()) {
            return;
        }
        if (this.mCurrentServer == null) {
            this.mCurrentServer = serverUriInfos.get(0);
        }
        connectInternal(longConnectionParams.setServerUriInfo(this.mCurrentServer));
    }

    @Override // com.kuaishou.live.longconnection.connector.LiveFeedConnector
    public void sendVoipSignal(byte[] bArr) {
        this.mConnection.sendVoipSignal(bArr);
    }

    private void connectInternal(LongConnectionParams longConnectionParams) {
        this.mConnection.open(longConnectionParams);
        this.mConnection.enterRoom();
    }

    static List<LongConnectionParams.ServerUriInfo> getServerUriInfos(List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new LongConnectionParams.ServerUriInfo(it.next(), "none"));
        }
        return arrayList;
    }
}
