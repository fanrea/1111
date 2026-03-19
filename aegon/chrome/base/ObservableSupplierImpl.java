package aegon.chrome.base;

import android.os.Handler;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ObservableSupplierImpl<E> implements ObservableSupplier<E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private E mObject;
    private final Thread mThread = Thread.currentThread();
    private final Handler mHandler = new Handler();
    private final ObserverList<Callback<E>> mObservers = new ObserverList<>();

    private void checkThread() {
    }

    @Override // aegon.chrome.base.ObservableSupplier
    public E addObserver(Callback<E> callback) {
        checkThread();
        this.mObservers.addObserver(callback);
        E e = this.mObject;
        if (e != null) {
            this.mHandler.post(ObservableSupplierImpl$$Lambda$1.lambdaFactory$(this, e, callback));
        }
        return this.mObject;
    }

    static /* synthetic */ void lambda$addObserver$0(ObservableSupplierImpl observableSupplierImpl, Object obj, Callback callback) {
        if (observableSupplierImpl.mObject == obj && observableSupplierImpl.mObservers.hasObserver(callback)) {
            callback.onResult(observableSupplierImpl.mObject);
        }
    }

    @Override // aegon.chrome.base.ObservableSupplier
    public void removeObserver(Callback<E> callback) {
        checkThread();
        this.mObservers.removeObserver(callback);
    }

    public void set(E e) {
        checkThread();
        if (e == this.mObject) {
            return;
        }
        this.mObject = e;
        Iterator<Callback<E>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().onResult(this.mObject);
        }
    }

    @Override // aegon.chrome.base.Supplier
    public E get() {
        checkThread();
        return this.mObject;
    }
}
