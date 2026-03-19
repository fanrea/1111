package io.netty.util.concurrent;

import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class PromiseNotifier<V, F extends Future<V>> implements GenericFutureListener<F> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PromiseNotifier.class);
    private final Promise<? super V>[] promises;

    @SafeVarargs
    public PromiseNotifier(Promise<? super V>... promiseArr) {
        ObjectUtil.checkNotNull(promiseArr, "promises");
        for (Promise<? super V> promise : promiseArr) {
            if (promise == null) {
                throw new IllegalArgumentException("promises contains null Promise");
            }
        }
        this.promises = (Promise[]) promiseArr.clone();
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(F f) {
        int i = 0;
        if (f.isSuccess()) {
            Object obj = f.get();
            Promise<? super V>[] promiseArr = this.promises;
            int length = promiseArr.length;
            while (i < length) {
                Promise<? super V> promise = promiseArr[i];
                if (!promise.trySuccess(obj)) {
                    logger.warn("Failed to mark a promise as success because it is done already: {}", promise);
                }
                i++;
            }
            return;
        }
        Throwable thCause = f.cause();
        Promise<? super V>[] promiseArr2 = this.promises;
        int length2 = promiseArr2.length;
        while (i < length2) {
            Promise<? super V> promise2 = promiseArr2[i];
            if (!promise2.tryFailure(thCause)) {
                logger.warn("Failed to mark a promise as failure because it's done already: {}", promise2, thCause);
            }
            i++;
        }
    }
}
