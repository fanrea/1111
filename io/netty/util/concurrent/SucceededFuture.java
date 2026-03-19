package io.netty.util.concurrent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SucceededFuture<V> extends CompleteFuture<V> {
    private final V result;

    @Override // io.netty.util.concurrent.Future
    public final Throwable cause() {
        return null;
    }

    @Override // io.netty.util.concurrent.Future
    public final boolean isSuccess() {
        return true;
    }

    public SucceededFuture(EventExecutor eventExecutor, V v) {
        super(eventExecutor);
        this.result = v;
    }

    @Override // io.netty.util.concurrent.Future
    public final V getNow() {
        return this.result;
    }
}
