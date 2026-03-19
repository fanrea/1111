package io.reactivex.internal.subscribers;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class BlockingLastSubscriber<T> extends BlockingBaseSubscriber<T> {
    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        this.value = t;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.value = null;
        this.error = th;
        countDown();
    }
}
