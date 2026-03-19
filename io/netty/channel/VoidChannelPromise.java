package io.netty.channel;

import io.netty.util.concurrent.AbstractFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class VoidChannelPromise extends AbstractFuture<Void> implements ChannelPromise {
    private final Channel channel;
    private final boolean fireException;

    @Override // io.netty.util.concurrent.Future, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // io.netty.util.concurrent.Future
    public final Throwable cause() {
        return null;
    }

    @Override // io.netty.util.concurrent.Future
    public final Void getNow() {
        return null;
    }

    @Override // io.netty.util.concurrent.Future
    public final boolean isCancellable() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return false;
    }

    @Override // io.netty.util.concurrent.Future
    public final boolean isSuccess() {
        return false;
    }

    @Override // io.netty.channel.ChannelFuture
    public final boolean isVoid() {
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    public final Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public final Future<Void> removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        return this;
    }

    @Override // io.netty.channel.ChannelPromise
    public final VoidChannelPromise setSuccess() {
        return this;
    }

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.ProgressivePromise
    public final VoidChannelPromise setSuccess(Void r1) {
        return this;
    }

    @Override // io.netty.util.concurrent.Promise
    public final boolean setUncancellable() {
        return true;
    }

    @Override // io.netty.channel.ChannelPromise
    public final boolean trySuccess() {
        return false;
    }

    @Override // io.netty.util.concurrent.Promise
    public final boolean trySuccess(Void r1) {
        return false;
    }

    VoidChannelPromise(Channel channel, boolean z) {
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        this.channel = channel;
        this.fireException = z;
    }

    @Override // io.netty.util.concurrent.Future
    public final Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        fail();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public final Future<Void> addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        fail();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public final Future<Void> await() throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public final boolean await(long j, TimeUnit timeUnit) {
        fail();
        return false;
    }

    @Override // io.netty.util.concurrent.Future
    public final boolean await(long j) {
        fail();
        return false;
    }

    @Override // io.netty.util.concurrent.Future
    public final Future<Void> awaitUninterruptibly() {
        fail();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public final boolean awaitUninterruptibly(long j, TimeUnit timeUnit) {
        fail();
        return false;
    }

    @Override // io.netty.util.concurrent.Future
    public final boolean awaitUninterruptibly(long j) {
        fail();
        return false;
    }

    @Override // io.netty.channel.ChannelPromise, io.netty.channel.ChannelFuture
    public final Channel channel() {
        return this.channel;
    }

    @Override // io.netty.util.concurrent.Future
    public final Future<Void> sync() {
        fail();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public final Future<Void> syncUninterruptibly() {
        fail();
        return this;
    }

    @Override // io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    public final VoidChannelPromise setFailure(Throwable th) {
        fireException(th);
        return this;
    }

    @Override // io.netty.util.concurrent.Promise
    public final boolean tryFailure(Throwable th) {
        fireException(th);
        return false;
    }

    private static void fail() {
        throw new IllegalStateException("void future");
    }

    @Override // io.netty.channel.ChannelPromise
    public final ChannelPromise unvoid() {
        DefaultChannelPromise defaultChannelPromise = new DefaultChannelPromise(this.channel);
        if (this.fireException) {
            defaultChannelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.VoidChannelPromise.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) {
                    if (channelFuture.isSuccess()) {
                        return;
                    }
                    VoidChannelPromise.this.fireException(channelFuture.cause());
                }
            });
        }
        return defaultChannelPromise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireException(Throwable th) {
        if (this.fireException && this.channel.isRegistered()) {
            this.channel.pipeline().fireExceptionCaught(th);
        }
    }
}
