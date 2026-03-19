package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.PlatformDependent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class FailedChannelFuture extends CompleteChannelFuture {
    private final Throwable cause;

    @Override // io.netty.util.concurrent.Future
    public final boolean isSuccess() {
        return false;
    }

    FailedChannelFuture(Channel channel, EventExecutor eventExecutor, Throwable th) {
        super(channel, eventExecutor);
        if (th == null) {
            throw new NullPointerException("cause");
        }
        this.cause = th;
    }

    @Override // io.netty.util.concurrent.Future
    public final Throwable cause() {
        return this.cause;
    }

    @Override // io.netty.channel.CompleteChannelFuture, io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public final Future<Void> sync() throws Throwable {
        PlatformDependent.throwException(this.cause);
        return this;
    }

    @Override // io.netty.channel.CompleteChannelFuture, io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public final Future<Void> syncUninterruptibly() throws Throwable {
        PlatformDependent.throwException(this.cause);
        return this;
    }
}
