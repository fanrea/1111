package com.yxcorp.livestream.longconnection.operation;

import com.kuaishou.common.netty.client.ConnectionClient;
import com.yxcorp.livestream.longconnection.LongConnectionContext;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class DisconnectOperation implements Runnable {
    private final LongConnectionContext mContext;

    public DisconnectOperation(LongConnectionContext longConnectionContext) {
        this.mContext = longConnectionContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mContext.stopHeartbeat();
        ConnectionClient client = this.mContext.getClient();
        if (client != null) {
            client.getChannelHandler().getPayloadHandlers().clearHandlers();
            this.mContext.setClient(null);
        }
    }
}
