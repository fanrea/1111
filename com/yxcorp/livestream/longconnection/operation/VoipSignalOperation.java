package com.yxcorp.livestream.longconnection.operation;

import android.os.SystemClock;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.kuaishou.common.netty.NanoSocketMessageUtil;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;
import com.kuaishou.socket.nano.SocketMessages;
import com.yxcorp.livestream.longconnection.LongConnectionContext;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class VoipSignalOperation implements Runnable {
    private final LongConnectionContext mContext;
    private byte[] mData;

    public VoipSignalOperation(LongConnectionContext longConnectionContext, byte[] bArr) {
        this.mContext = longConnectionContext;
        this.mData = bArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mContext.getClient() == null) {
            return;
        }
        try {
            SocketMessages.SocketMessage socketMessagePack = NanoSocketMessageUtil.pack(LiveStreamMessages.CSVoipSignal.parseFrom(this.mData), 206);
            this.mContext.setMessageLastSendTime(206, SystemClock.elapsedRealtime());
            new SendMessageOperation(this.mContext, socketMessagePack).run();
        } catch (InvalidProtocolBufferNanoException e) {
            e.printStackTrace();
        }
    }
}
