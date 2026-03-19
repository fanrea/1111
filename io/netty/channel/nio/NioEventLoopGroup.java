package io.netty.channel.nio;

import io.netty.channel.EventLoop;
import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.util.concurrent.EventExecutor;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class NioEventLoopGroup extends MultithreadEventLoopGroup {
    public NioEventLoopGroup() {
        this(0);
    }

    public NioEventLoopGroup(int i) {
        this(i, (Executor) null);
    }

    public NioEventLoopGroup(int i, ThreadFactory threadFactory) {
        this(i, threadFactory, SelectorProvider.provider());
    }

    public NioEventLoopGroup(int i, Executor executor) {
        this(i, executor, SelectorProvider.provider());
    }

    public NioEventLoopGroup(int i, ThreadFactory threadFactory, SelectorProvider selectorProvider) {
        super(i, threadFactory, selectorProvider);
    }

    public NioEventLoopGroup(int i, Executor executor, SelectorProvider selectorProvider) {
        super(i, executor, selectorProvider);
    }

    public void setIoRatio(int i) {
        Iterator it = children().iterator();
        while (it.hasNext()) {
            ((NioEventLoop) ((EventExecutor) it.next())).setIoRatio(i);
        }
    }

    public void rebuildSelectors() {
        Iterator it = children().iterator();
        while (it.hasNext()) {
            ((NioEventLoop) ((EventExecutor) it.next())).rebuildSelector();
        }
    }

    @Override // io.netty.channel.MultithreadEventLoopGroup, io.netty.util.concurrent.MultithreadEventExecutorGroup
    public EventLoop newChild(Executor executor, Object... objArr) {
        return new NioEventLoop(this, executor, (SelectorProvider) objArr[0]);
    }
}
