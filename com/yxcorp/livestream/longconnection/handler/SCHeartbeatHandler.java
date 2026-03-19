package com.yxcorp.livestream.longconnection.handler;

import com.kuaishou.common.netty.handler.NanoPayloadHandler;
import com.kuaishou.socket.nano.SocketMessages;
import com.yxcorp.livestream.longconnection.HeartbeatAckListener;
import io.netty.channel.ChannelHandlerContext;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class SCHeartbeatHandler implements NanoPayloadHandler<SocketMessages.SCHeartbeatAck> {
    private boolean mAckReceived = true;
    private HeartbeatAckListener mHeartbeatAckListener;
    private int mNoAckCount;

    public int getNoAckCount() {
        return this.mNoAckCount;
    }

    public SCHeartbeatHandler setNoAckCount(int i) {
        this.mNoAckCount = i;
        return this;
    }

    public boolean isAckReceived() {
        return this.mAckReceived;
    }

    public void setPendingHeartbeat() {
        this.mAckReceived = false;
    }

    @Override // com.kuaishou.common.netty.handler.NanoPayloadHandler
    public void handle(ChannelHandlerContext channelHandlerContext, SocketMessages.SCHeartbeatAck sCHeartbeatAck) {
        this.mNoAckCount = 0;
        this.mAckReceived = true;
        HeartbeatAckListener heartbeatAckListener = this.mHeartbeatAckListener;
        if (heartbeatAckListener != null) {
            heartbeatAckListener.onHeartbeatAckReceived(sCHeartbeatAck.timestamp, sCHeartbeatAck.clientTimestamp);
        }
    }

    public void setHeartbeatAckListener(HeartbeatAckListener heartbeatAckListener) {
        this.mHeartbeatAckListener = heartbeatAckListener;
    }
}
