package io.netty.util.concurrent;

import io.netty.util.internal.PlatformDependent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class FailedFuture<V> extends CompleteFuture<V> {
    private final Throwable cause;

    @Override // io.netty.util.concurrent.Future
    public final V getNow() {
        return null;
    }

    @Override // io.netty.util.concurrent.Future
    public final boolean isSuccess() {
        return false;
    }

    public FailedFuture(EventExecutor eventExecutor, Throwable th) {
        super(eventExecutor);
        if (th == null) {
            throw new NullPointerException("cause");
        }
        this.cause = th;
    }

    @Override // io.netty.util.concurrent.Future
    public final Throwable cause() {
        return this.cause;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public final Future<V> sync() throws Throwable {
        PlatformDependent.throwException(this.cause);
        return this;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public final Future<V> syncUninterruptibly() throws Throwable {
        PlatformDependent.throwException(this.cause);
        return this;
    }
}
