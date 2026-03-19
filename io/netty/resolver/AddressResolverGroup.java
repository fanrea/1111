package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.IdentityHashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class AddressResolverGroup<T extends SocketAddress> implements Closeable {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AddressResolverGroup.class);
    private final Map<EventExecutor, AddressResolver<T>> resolvers = new IdentityHashMap();

    protected abstract AddressResolver<T> newResolver(EventExecutor eventExecutor);

    protected AddressResolverGroup() {
    }

    public AddressResolver<T> getResolver(final EventExecutor eventExecutor) {
        final AddressResolver<T> addressResolverNewResolver;
        if (eventExecutor == null) {
            throw new NullPointerException("executor");
        }
        if (eventExecutor.isShuttingDown()) {
            throw new IllegalStateException("executor not accepting a task");
        }
        synchronized (this.resolvers) {
            addressResolverNewResolver = this.resolvers.get(eventExecutor);
            if (addressResolverNewResolver == null) {
                try {
                    addressResolverNewResolver = newResolver(eventExecutor);
                    this.resolvers.put(eventExecutor, addressResolverNewResolver);
                    eventExecutor.terminationFuture().addListener(new FutureListener<Object>() { // from class: io.netty.resolver.AddressResolverGroup.1
                        @Override // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(Future<Object> future) {
                            AddressResolverGroup.this.resolvers.remove(eventExecutor);
                            addressResolverNewResolver.close();
                        }
                    });
                } catch (Exception e) {
                    throw new IllegalStateException("failed to create a new resolver", e);
                }
            }
        }
        return addressResolverNewResolver;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AddressResolver[] addressResolverArr;
        synchronized (this.resolvers) {
            addressResolverArr = (AddressResolver[]) this.resolvers.values().toArray(new AddressResolver[this.resolvers.size()]);
            this.resolvers.clear();
        }
        for (AddressResolver addressResolver : addressResolverArr) {
            try {
                addressResolver.close();
            } catch (Throwable th) {
                logger.warn("Failed to close a resolver:", th);
            }
        }
    }
}
