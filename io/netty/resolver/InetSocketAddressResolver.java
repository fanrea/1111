package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class InetSocketAddressResolver extends AbstractAddressResolver<InetSocketAddress> {
    private final NameResolver<InetAddress> nameResolver;

    @Override // io.netty.resolver.AbstractAddressResolver
    protected /* bridge */ /* synthetic */ void doResolve(SocketAddress socketAddress, Promise promise) {
        doResolve((InetSocketAddress) socketAddress, (Promise<InetSocketAddress>) promise);
    }

    @Override // io.netty.resolver.AbstractAddressResolver
    protected /* bridge */ /* synthetic */ void doResolveAll(SocketAddress socketAddress, Promise promise) {
        doResolveAll((InetSocketAddress) socketAddress, (Promise<List<InetSocketAddress>>) promise);
    }

    public InetSocketAddressResolver(EventExecutor eventExecutor, NameResolver<InetAddress> nameResolver) {
        super(eventExecutor, InetSocketAddress.class);
        this.nameResolver = nameResolver;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.resolver.AbstractAddressResolver
    public boolean doIsResolved(InetSocketAddress inetSocketAddress) {
        return !inetSocketAddress.isUnresolved();
    }

    protected void doResolve(final InetSocketAddress inetSocketAddress, final Promise<InetSocketAddress> promise) {
        this.nameResolver.resolve(inetSocketAddress.getHostName()).addListener(new FutureListener<InetAddress>() { // from class: io.netty.resolver.InetSocketAddressResolver.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<InetAddress> future) {
                if (future.isSuccess()) {
                    promise.setSuccess(new InetSocketAddress(future.getNow(), inetSocketAddress.getPort()));
                } else {
                    promise.setFailure(future.cause());
                }
            }
        });
    }

    protected void doResolveAll(final InetSocketAddress inetSocketAddress, final Promise<List<InetSocketAddress>> promise) {
        this.nameResolver.resolveAll(inetSocketAddress.getHostName()).addListener(new FutureListener<List<InetAddress>>() { // from class: io.netty.resolver.InetSocketAddressResolver.2
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<List<InetAddress>> future) {
                if (future.isSuccess()) {
                    List<InetAddress> now = future.getNow();
                    ArrayList arrayList = new ArrayList(now.size());
                    Iterator<InetAddress> it = now.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new InetSocketAddress(it.next(), inetSocketAddress.getPort()));
                    }
                    promise.setSuccess(arrayList);
                    return;
                }
                promise.setFailure(future.cause());
            }
        });
    }
}
