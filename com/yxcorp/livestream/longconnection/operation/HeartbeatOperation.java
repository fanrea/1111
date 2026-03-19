package com.yxcorp.livestream.longconnection.operation;

import android.os.SystemClock;
import com.kuaishou.common.netty.NanoSocketMessageUtil;
import com.kuaishou.socket.nano.SocketMessages;
import com.yxcorp.livestream.longconnection.LiveStreamLogger;
import com.yxcorp.livestream.longconnection.LongConnectionContext;
import com.yxcorp.livestream.longconnection.OnConnectionExceptionListener;
import com.yxcorp.livestream.longconnection.exception.HeartBeatInterruptException;
import com.yxcorp.livestream.longconnection.handler.SCErrorHandler;
import com.yxcorp.livestream.longconnection.handler.SCHeartbeatHandler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class HeartbeatOperation implements Runnable {
    private static final int HEARTBEAT_RETRY_LIMIT = 3;
    private static final String TAG = "HeartbeatOperation";
    final LongConnectionContext mContext;
    private final SCHeartbeatHandler mHeartbeatHandler;

    public HeartbeatOperation(LongConnectionContext longConnectionContext, SCHeartbeatHandler sCHeartbeatHandler) {
        this.mContext = longConnectionContext;
        this.mHeartbeatHandler = sCHeartbeatHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        LiveStreamLogger.debugLog(TAG, "start sendHeartbeat", "heartbeatInterval: " + this.mContext.getHeartbeatInterval());
        if (SCErrorHandler.isLiveEndError(this.mContext.getLastErrorCode())) {
            LiveStreamLogger.debugLog(TAG, "sendHeartbeat liveEnd error: " + this.mContext.getLastErrorCode(), new Object[0]);
            return;
        }
        if (!this.mHeartbeatHandler.isAckReceived()) {
            SCHeartbeatHandler sCHeartbeatHandler = this.mHeartbeatHandler;
            sCHeartbeatHandler.setNoAckCount(sCHeartbeatHandler.getNoAckCount() + 1);
        }
        if (this.mHeartbeatHandler.getNoAckCount() < 3) {
            LiveStreamLogger.debugLog(TAG, "sendHeartbeat NoAckCount: " + this.mHeartbeatHandler.getNoAckCount(), new Object[0]);
            SocketMessages.CSHeartbeat cSHeartbeat = new SocketMessages.CSHeartbeat();
            cSHeartbeat.timestamp = System.currentTimeMillis();
            SocketMessages.SocketMessage socketMessagePack = NanoSocketMessageUtil.pack(cSHeartbeat, 1);
            this.mContext.setMessageLastSendTime(1, SystemClock.elapsedRealtime());
            this.mHeartbeatHandler.setPendingHeartbeat();
            new SendMessageOperation(this.mContext, socketMessagePack).run();
            this.mContext.retryHeartbeat();
            if (this.mContext.getHeartbeatListener() != null) {
                this.mContext.getHeartbeatListener().onHeartbeatSend(cSHeartbeat.timestamp);
                return;
            }
            return;
        }
        LiveStreamLogger.debugLog(TAG, "sendHeartbeat No Ack Error, NoAckCount: " + this.mHeartbeatHandler.getNoAckCount(), new Object[0]);
        SocketMessages.CSError cSError = new SocketMessages.CSError();
        cSError.code = 1052;
        this.mContext.getMessageRunnablePipeline().post(new SendMessageOperation(this.mContext, NanoSocketMessageUtil.pack(cSError, 3)));
        this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.HeartbeatOperation.1
            @Override // java.lang.Runnable
            public void run() {
                OnConnectionExceptionListener exceptionListener = HeartbeatOperation.this.mContext.getExceptionListener();
                if (exceptionListener != null) {
                    exceptionListener.onClientException(new HeartBeatInterruptException());
                }
            }
        });
    }
}
