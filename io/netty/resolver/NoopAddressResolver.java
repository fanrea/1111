package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class NoopAddressResolver extends AbstractAddressResolver<SocketAddress> {
    @Override // io.netty.resolver.AbstractAddressResolver
    protected boolean doIsResolved(SocketAddress socketAddress) {
        return true;
    }

    public NoopAddressResolver(EventExecutor eventExecutor) {
        super(eventExecutor);
    }

    @Override // io.netty.resolver.AbstractAddressResolver
    protected void doResolve(SocketAddress socketAddress, Promise<SocketAddress> promise) {
        promise.setSuccess(socketAddress);
    }

    @Override // io.netty.resolver.AbstractAddressResolver
    protected void doResolveAll(SocketAddress socketAddress, Promise<List<SocketAddress>> promise) {
        promise.setSuccess(Collections.singletonList(socketAddress));
    }
}
