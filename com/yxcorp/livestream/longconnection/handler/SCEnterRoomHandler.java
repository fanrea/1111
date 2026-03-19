package com.yxcorp.livestream.longconnection.handler;

import android.os.SystemClock;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;
import com.yxcorp.livestream.longconnection.LongConnectionContext;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class SCEnterRoomHandler extends SCHandler<LiveStreamMessages.SCEnterRoomAck> {
    public SCEnterRoomHandler(LongConnectionContext longConnectionContext) {
        super(longConnectionContext);
    }

    @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
    public void handleMessage(final LiveStreamMessages.SCEnterRoomAck sCEnterRoomAck) {
        if (this.mLongConnectionContext.getClient() == null) {
            return;
        }
        this.mLongConnectionContext.setMessageLastReceiveTime(300, SystemClock.elapsedRealtime());
        this.mLongConnectionContext.updateLatency(sCEnterRoomAck.minReconnectMs, sCEnterRoomAck.maxReconnectMs, sCEnterRoomAck.heartbeatIntervalMs);
        this.mLongConnectionContext.startHeartbeat();
        this.mLongConnectionContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.handler.SCEnterRoomHandler.1
            @Override // java.lang.Runnable
            public void run() {
                if (SCEnterRoomHandler.this.mLongConnectionContext.mMessageListener != null) {
                    SCEnterRoomHandler.this.mLongConnectionContext.mMessageListener.onEnterRoomAckReceived(sCEnterRoomAck);
                }
            }
        });
    }
}
