package aegon.chrome.base;

import android.os.Handler;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class Promise<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Exception mRejectReason;
    private T mResult;
    private boolean mThrowingRejectionHandler;
    private int mState = 0;
    private final List<Callback<T>> mFulfillCallbacks = new LinkedList();
    private final List<Callback<Exception>> mRejectCallbacks = new LinkedList();
    private final Thread mThread = Thread.currentThread();
    private final Handler mHandler = new Handler();

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface AsyncFunction<A, R> {
        Promise<R> apply(A a);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface Function<A, R> {
        R apply(A a);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    @interface PromiseState {
        public static final int FULFILLED = 1;
        public static final int REJECTED = 2;
        public static final int UNFULFILLED = 0;
    }

    private void checkThread() {
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class UnhandledRejectionException extends RuntimeException {
        public UnhandledRejectionException(String str, Throwable th) {
            super(str, th);
        }
    }

    public void then(Callback<T> callback) {
        checkThread();
        if (this.mThrowingRejectionHandler) {
            thenInner(callback);
        } else {
            then(callback, Promise$$Lambda$1.instance);
            this.mThrowingRejectionHandler = true;
        }
    }

    static /* synthetic */ void lambda$then$0(Exception exc) {
        throw new UnhandledRejectionException("Promise was rejected without a rejection handler.", exc);
    }

    public void then(Callback<T> callback, Callback<Exception> callback2) {
        checkThread();
        thenInner(callback);
        exceptInner(callback2);
    }

    public void except(Callback<Exception> callback) {
        checkThread();
        exceptInner(callback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void thenInner(Callback<T> callback) {
        int i = this.mState;
        if (i == 1) {
            postCallbackToLooper(callback, this.mResult);
        } else if (i == 0) {
            this.mFulfillCallbacks.add(callback);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void exceptInner(Callback<Exception> callback) {
        int i = this.mState;
        if (i == 2) {
            postCallbackToLooper(callback, this.mRejectReason);
        } else if (i == 0) {
            this.mRejectCallbacks.add(callback);
        }
    }

    public <R> Promise<R> then(Function<T, R> function) {
        checkThread();
        Promise<R> promise = new Promise<>();
        thenInner(Promise$$Lambda$2.lambdaFactory$(promise, function));
        Objects.requireNonNull(promise);
        exceptInner(Promise$$Lambda$3.lambdaFactory$(promise));
        return promise;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$then$1(Promise promise, Function function, Object obj) {
        try {
            promise.fulfill(function.apply(obj));
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public <R> Promise<R> then(AsyncFunction<T, R> asyncFunction) {
        checkThread();
        Promise<R> promise = new Promise<>();
        thenInner(Promise$$Lambda$4.lambdaFactory$(asyncFunction, promise));
        Objects.requireNonNull(promise);
        exceptInner(Promise$$Lambda$5.lambdaFactory$(promise));
        return promise;
    }

    static /* synthetic */ void lambda$then$2(AsyncFunction asyncFunction, Promise promise, Object obj) {
        try {
            Promise promiseApply = asyncFunction.apply(obj);
            Objects.requireNonNull(promise);
            Callback<T> callbackLambdaFactory$ = Promise$$Lambda$7.lambdaFactory$(promise);
            Objects.requireNonNull(promise);
            promiseApply.then(callbackLambdaFactory$, Promise$$Lambda$8.lambdaFactory$(promise));
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public void fulfill(T t) {
        checkThread();
        this.mState = 1;
        this.mResult = t;
        Iterator<Callback<T>> it = this.mFulfillCallbacks.iterator();
        while (it.hasNext()) {
            postCallbackToLooper(it.next(), t);
        }
        this.mFulfillCallbacks.clear();
    }

    public void reject(Exception exc) {
        checkThread();
        this.mState = 2;
        this.mRejectReason = exc;
        Iterator<Callback<Exception>> it = this.mRejectCallbacks.iterator();
        while (it.hasNext()) {
            postCallbackToLooper((Callback) it.next(), exc);
        }
        this.mRejectCallbacks.clear();
    }

    public void reject() {
        reject(null);
    }

    public boolean isFulfilled() {
        checkThread();
        return this.mState == 1;
    }

    public boolean isRejected() {
        checkThread();
        return this.mState == 2;
    }

    public T getResult() {
        return this.mResult;
    }

    public static <T> Promise<T> fulfilled(T t) {
        Promise<T> promise = new Promise<>();
        promise.fulfill(t);
        return promise;
    }

    private <S> void postCallbackToLooper(Callback<S> callback, S s) {
        this.mHandler.post(Promise$$Lambda$6.lambdaFactory$(callback, s));
    }
}
