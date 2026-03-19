package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class SucceededChannelFuture extends CompleteChannelFuture {
    @Override // io.netty.util.concurrent.Future
    public final Throwable cause() {
        return null;
    }

    @Override // io.netty.util.concurrent.Future
    public final boolean isSuccess() {
        return true;
    }

    SucceededChannelFuture(Channel channel, EventExecutor eventExecutor) {
        super(channel, eventExecutor);
    }
}
