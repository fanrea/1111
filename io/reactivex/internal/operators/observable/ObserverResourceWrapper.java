package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -8612022020200669122L;
    final Observer<? super T> actual;
    final AtomicReference<Disposable> subscription = new AtomicReference<>();

    public ObserverResourceWrapper(Observer<? super T> observer) {
        this.actual = observer;
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this.subscription, disposable)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        dispose();
        this.actual.onError(th);
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        dispose();
        this.actual.onComplete();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.subscription);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.subscription.get() == DisposableHelper.DISPOSED;
    }

    public final void setResource(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }
}
