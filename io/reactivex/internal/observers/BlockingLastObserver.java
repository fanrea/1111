package io.reactivex.internal.observers;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        this.value = t;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        this.value = null;
        this.error = th;
        countDown();
    }
}
