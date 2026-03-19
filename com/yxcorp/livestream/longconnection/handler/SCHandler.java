package com.yxcorp.livestream.longconnection.handler;

import com.google.protobuf.nano.MessageNano;
import com.kuaishou.common.netty.handler.NanoPayloadHandler;
import com.yxcorp.livestream.longconnection.LongConnectionContext;
import io.netty.channel.ChannelHandlerContext;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class SCHandler<T extends MessageNano> implements NanoPayloadHandler<T> {
    final LongConnectionContext mLongConnectionContext;

    public abstract void handleMessage(T t);

    public SCHandler(LongConnectionContext longConnectionContext) {
        this.mLongConnectionContext = longConnectionContext;
    }

    @Override // com.kuaishou.common.netty.handler.NanoPayloadHandler
    public final void handle(ChannelHandlerContext channelHandlerContext, final T t) {
        this.mLongConnectionContext.getMessageRunnablePipeline().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.handler.SCHandler.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                SCHandler.this.handleMessage(t);
            }
        });
    }
}
