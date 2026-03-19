package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class CompositeNameResolver<T> extends SimpleNameResolver<T> {
    private final NameResolver<T>[] resolvers;

    public CompositeNameResolver(EventExecutor eventExecutor, NameResolver<T>... nameResolverArr) {
        super(eventExecutor);
        ObjectUtil.checkNotNull(nameResolverArr, "resolvers");
        for (int i = 0; i < nameResolverArr.length; i++) {
            if (nameResolverArr[i] == null) {
                throw new NullPointerException("resolvers[" + i + ']');
            }
        }
        if (nameResolverArr.length < 2) {
            throw new IllegalArgumentException("resolvers: " + Arrays.asList(nameResolverArr) + " (expected: at least 2 resolvers)");
        }
        this.resolvers = (NameResolver[]) nameResolverArr.clone();
    }

    @Override // io.netty.resolver.SimpleNameResolver
    protected final void doResolve(String str, Promise<T> promise) {
        doResolveRec(str, promise, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doResolveRec(final String str, final Promise<T> promise, final int i, Throwable th) {
        NameResolver<T>[] nameResolverArr = this.resolvers;
        if (i >= nameResolverArr.length) {
            promise.setFailure(th);
        } else {
            nameResolverArr[i].resolve(str).addListener(new FutureListener<T>() { // from class: io.netty.resolver.CompositeNameResolver.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<T> future) {
                    if (!future.isSuccess()) {
                        CompositeNameResolver.this.doResolveRec(str, promise, i + 1, future.cause());
                    } else {
                        promise.setSuccess(future.getNow());
                    }
                }
            });
        }
    }

    @Override // io.netty.resolver.SimpleNameResolver
    protected final void doResolveAll(String str, Promise<List<T>> promise) {
        doResolveAllRec(str, promise, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doResolveAllRec(final String str, final Promise<List<T>> promise, final int i, Throwable th) {
        NameResolver<T>[] nameResolverArr = this.resolvers;
        if (i >= nameResolverArr.length) {
            promise.setFailure(th);
        } else {
            nameResolverArr[i].resolveAll(str).addListener(new FutureListener<List<T>>() { // from class: io.netty.resolver.CompositeNameResolver.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<List<T>> future) {
                    if (!future.isSuccess()) {
                        CompositeNameResolver.this.doResolveAllRec(str, promise, i + 1, future.cause());
                    } else {
                        promise.setSuccess(future.getNow());
                    }
                }
            });
        }
    }
}
