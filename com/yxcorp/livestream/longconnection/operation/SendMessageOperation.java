package com.yxcorp.livestream.longconnection.operation;

import com.baidu.mobads.container.util.cm;
import com.kuaishou.common.netty.client.ConnectionClient;
import com.kuaishou.socket.nano.SocketMessages;
import com.yxcorp.livestream.longconnection.LiveStreamLogger;
import com.yxcorp.livestream.longconnection.LongConnectionContext;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class SendMessageOperation implements Runnable {
    private final LongConnectionContext mContext;
    private final SocketMessages.SocketMessage mMessage;

    public SendMessageOperation(LongConnectionContext longConnectionContext, SocketMessages.SocketMessage socketMessage) {
        this.mContext = longConnectionContext;
        this.mMessage = socketMessage;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConnectionClient client = this.mContext.getClient();
        if (client == null) {
            LiveStreamLogger.debugLog("SendMessageOperation", "connectionClient is null", cm.V, this.mMessage);
        } else {
            client.getChannel().writeAndFlush(this.mMessage);
            LiveStreamLogger.debugLog("SendMessageOperation", cm.V, this.mMessage);
        }
    }
}
