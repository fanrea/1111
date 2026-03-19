package io.netty.channel;

import io.netty.channel.Channel;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.OneTimeTask;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class DefaultChannelPipeline implements ChannelPipeline {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultChannelPipeline.class);
    private static final FastThreadLocal<Map<Class<?>, String>> nameCaches = new FastThreadLocal<Map<Class<?>, String>>() { // from class: io.netty.channel.DefaultChannelPipeline.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public final Map<Class<?>, String> initialValue() {
            return new WeakHashMap();
        }
    };
    final AbstractChannel channel;
    private Map<EventExecutorGroup, ChannelHandlerInvoker> childInvokers;
    final AbstractChannelHandlerContext head;
    final AbstractChannelHandlerContext tail;
    private final boolean touch = ResourceLeakDetector.isEnabled();

    DefaultChannelPipeline(AbstractChannel abstractChannel) {
        if (abstractChannel == null) {
            throw new NullPointerException("channel");
        }
        this.channel = abstractChannel;
        this.tail = new TailContext(this);
        this.head = new HeadContext(this);
        AbstractChannelHandlerContext abstractChannelHandlerContext = this.head;
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.tail;
        abstractChannelHandlerContext.next = abstractChannelHandlerContext2;
        abstractChannelHandlerContext2.prev = abstractChannelHandlerContext;
    }

    final Object touch(Object obj, AbstractChannelHandlerContext abstractChannelHandlerContext) {
        return this.touch ? ReferenceCountUtil.touch(obj, abstractChannelHandlerContext) : obj;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final Channel channel() {
        return this.channel;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(String str, ChannelHandler channelHandler) {
        return addFirst((ChannelHandlerInvoker) null, str, channelHandler);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final synchronized ChannelPipeline addFirst(EventExecutorGroup eventExecutorGroup, String str, ChannelHandler channelHandler) {
        addFirst0(new DefaultChannelHandlerContext(this, findInvoker(eventExecutorGroup), filterName(str, channelHandler), channelHandler));
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(ChannelHandlerInvoker channelHandlerInvoker, String str, ChannelHandler channelHandler) {
        addFirst0(new DefaultChannelHandlerContext(this, channelHandlerInvoker, filterName(str, channelHandler), channelHandler));
        return this;
    }

    private void addFirst0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        checkMultiplicity(abstractChannelHandlerContext);
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.head.next;
        AbstractChannelHandlerContext abstractChannelHandlerContext3 = this.head;
        abstractChannelHandlerContext.prev = abstractChannelHandlerContext3;
        abstractChannelHandlerContext.next = abstractChannelHandlerContext2;
        abstractChannelHandlerContext3.next = abstractChannelHandlerContext;
        abstractChannelHandlerContext2.prev = abstractChannelHandlerContext;
        callHandlerAdded(abstractChannelHandlerContext);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(String str, ChannelHandler channelHandler) {
        return addLast((ChannelHandlerInvoker) null, str, channelHandler);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final synchronized ChannelPipeline addLast(EventExecutorGroup eventExecutorGroup, String str, ChannelHandler channelHandler) {
        addLast0(new DefaultChannelHandlerContext(this, findInvoker(eventExecutorGroup), filterName(str, channelHandler), channelHandler));
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final synchronized ChannelPipeline addLast(ChannelHandlerInvoker channelHandlerInvoker, String str, ChannelHandler channelHandler) {
        addLast0(new DefaultChannelHandlerContext(this, channelHandlerInvoker, filterName(str, channelHandler), channelHandler));
        return this;
    }

    private void addLast0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        checkMultiplicity(abstractChannelHandlerContext);
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.tail.prev;
        abstractChannelHandlerContext.prev = abstractChannelHandlerContext2;
        AbstractChannelHandlerContext abstractChannelHandlerContext3 = this.tail;
        abstractChannelHandlerContext.next = abstractChannelHandlerContext3;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext;
        abstractChannelHandlerContext3.prev = abstractChannelHandlerContext;
        callHandlerAdded(abstractChannelHandlerContext);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addBefore(String str, String str2, ChannelHandler channelHandler) {
        return addBefore((ChannelHandlerInvoker) null, str, str2, channelHandler);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final synchronized ChannelPipeline addBefore(EventExecutorGroup eventExecutorGroup, String str, String str2, ChannelHandler channelHandler) {
        addBefore0(getContextOrDie(str), new DefaultChannelHandlerContext(this, findInvoker(eventExecutorGroup), filterName(str2, channelHandler), channelHandler));
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final synchronized ChannelPipeline addBefore(ChannelHandlerInvoker channelHandlerInvoker, String str, String str2, ChannelHandler channelHandler) {
        addBefore0(getContextOrDie(str), new DefaultChannelHandlerContext(this, channelHandlerInvoker, filterName(str2, channelHandler), channelHandler));
        return this;
    }

    private void addBefore0(AbstractChannelHandlerContext abstractChannelHandlerContext, AbstractChannelHandlerContext abstractChannelHandlerContext2) {
        checkMultiplicity(abstractChannelHandlerContext2);
        abstractChannelHandlerContext2.prev = abstractChannelHandlerContext.prev;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext;
        abstractChannelHandlerContext.prev.next = abstractChannelHandlerContext2;
        abstractChannelHandlerContext.prev = abstractChannelHandlerContext2;
        callHandlerAdded(abstractChannelHandlerContext2);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addAfter(String str, String str2, ChannelHandler channelHandler) {
        return addAfter((ChannelHandlerInvoker) null, str, str2, channelHandler);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final synchronized ChannelPipeline addAfter(EventExecutorGroup eventExecutorGroup, String str, String str2, ChannelHandler channelHandler) {
        addAfter0(getContextOrDie(str), new DefaultChannelHandlerContext(this, findInvoker(eventExecutorGroup), filterName(str2, channelHandler), channelHandler));
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final synchronized ChannelPipeline addAfter(ChannelHandlerInvoker channelHandlerInvoker, String str, String str2, ChannelHandler channelHandler) {
        addAfter0(getContextOrDie(str), new DefaultChannelHandlerContext(this, channelHandlerInvoker, filterName(str2, channelHandler), channelHandler));
        return this;
    }

    private void addAfter0(AbstractChannelHandlerContext abstractChannelHandlerContext, AbstractChannelHandlerContext abstractChannelHandlerContext2) {
        checkMultiplicity(abstractChannelHandlerContext2);
        abstractChannelHandlerContext2.prev = abstractChannelHandlerContext;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext.next;
        abstractChannelHandlerContext.next.prev = abstractChannelHandlerContext2;
        abstractChannelHandlerContext.next = abstractChannelHandlerContext2;
        callHandlerAdded(abstractChannelHandlerContext2);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(ChannelHandler... channelHandlerArr) {
        return addFirst((ChannelHandlerInvoker) null, channelHandlerArr);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(EventExecutorGroup eventExecutorGroup, ChannelHandler... channelHandlerArr) {
        if (channelHandlerArr == null) {
            throw new NullPointerException("handlers");
        }
        if (channelHandlerArr.length != 0 && channelHandlerArr[0] != null) {
            int i = 1;
            while (i < channelHandlerArr.length && channelHandlerArr[i] != null) {
                i++;
            }
            for (int i2 = i - 1; i2 >= 0; i2--) {
                ChannelHandler channelHandler = channelHandlerArr[i2];
                addFirst(eventExecutorGroup, generateName(channelHandler), channelHandler);
            }
        }
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(ChannelHandlerInvoker channelHandlerInvoker, ChannelHandler... channelHandlerArr) {
        if (channelHandlerArr == null) {
            throw new NullPointerException("handlers");
        }
        if (channelHandlerArr.length != 0 && channelHandlerArr[0] != null) {
            int i = 1;
            while (i < channelHandlerArr.length && channelHandlerArr[i] != null) {
                i++;
            }
            for (int i2 = i - 1; i2 >= 0; i2--) {
                addFirst(channelHandlerInvoker, (String) null, channelHandlerArr[i2]);
            }
        }
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(ChannelHandler... channelHandlerArr) {
        return addLast((ChannelHandlerInvoker) null, channelHandlerArr);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(EventExecutorGroup eventExecutorGroup, ChannelHandler... channelHandlerArr) {
        if (channelHandlerArr == null) {
            throw new NullPointerException("handlers");
        }
        for (ChannelHandler channelHandler : channelHandlerArr) {
            if (channelHandler == null) {
                break;
            }
            addLast(eventExecutorGroup, generateName(channelHandler), channelHandler);
        }
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(ChannelHandlerInvoker channelHandlerInvoker, ChannelHandler... channelHandlerArr) {
        if (channelHandlerArr == null) {
            throw new NullPointerException("handlers");
        }
        for (ChannelHandler channelHandler : channelHandlerArr) {
            if (channelHandler == null) {
                break;
            }
            addLast(channelHandlerInvoker, (String) null, channelHandler);
        }
        return this;
    }

    private ChannelHandlerInvoker findInvoker(EventExecutorGroup eventExecutorGroup) {
        if (eventExecutorGroup == null) {
            return null;
        }
        Map identityHashMap = this.childInvokers;
        if (identityHashMap == null) {
            identityHashMap = new IdentityHashMap(4);
            this.childInvokers = identityHashMap;
        }
        ChannelHandlerInvoker defaultChannelHandlerInvoker = (ChannelHandlerInvoker) identityHashMap.get(eventExecutorGroup);
        if (defaultChannelHandlerInvoker == null) {
            EventExecutor next = eventExecutorGroup.next();
            if (next instanceof EventLoop) {
                defaultChannelHandlerInvoker = ((EventLoop) next).asInvoker();
            } else {
                defaultChannelHandlerInvoker = new DefaultChannelHandlerInvoker(next);
            }
            identityHashMap.put(eventExecutorGroup, defaultChannelHandlerInvoker);
        }
        return defaultChannelHandlerInvoker;
    }

    private String generateName(ChannelHandler channelHandler) {
        Map<Class<?>, String> map = nameCaches.get();
        Class<?> cls = channelHandler.getClass();
        String strGenerateName0 = map.get(cls);
        if (strGenerateName0 == null) {
            strGenerateName0 = generateName0(cls);
            map.put(cls, strGenerateName0);
        }
        synchronized (this) {
            if (context0(strGenerateName0) != null) {
                int i = 1;
                String strSubstring = strGenerateName0.substring(0, strGenerateName0.length() - 1);
                while (true) {
                    strGenerateName0 = strSubstring + i;
                    if (context0(strGenerateName0) == null) {
                        break;
                    }
                    i++;
                }
            }
        }
        return strGenerateName0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String generateName0(Class<?> cls) {
        return StringUtil.simpleClassName(cls) + "#0";
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline remove(ChannelHandler channelHandler) throws Throwable {
        remove(getContextOrDie(channelHandler));
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandler remove(String str) {
        return remove(getContextOrDie(str)).handler();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final <T extends ChannelHandler> T remove(Class<T> cls) {
        return (T) remove(getContextOrDie((Class<? extends ChannelHandler>) cls)).handler();
    }

    private AbstractChannelHandlerContext remove(final AbstractChannelHandlerContext abstractChannelHandlerContext) throws Throwable {
        synchronized (this) {
            if (abstractChannelHandlerContext.channel().isRegistered() && !abstractChannelHandlerContext.executor().inEventLoop()) {
                waitForFuture(abstractChannelHandlerContext.executor().submit((Runnable) new OneTimeTask() { // from class: io.netty.channel.DefaultChannelPipeline.2
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (DefaultChannelPipeline.this) {
                            DefaultChannelPipeline.this.remove0(abstractChannelHandlerContext);
                        }
                    }
                }));
                return abstractChannelHandlerContext;
            }
            remove0(abstractChannelHandlerContext);
            return abstractChannelHandlerContext;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void remove0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = abstractChannelHandlerContext.prev;
        AbstractChannelHandlerContext abstractChannelHandlerContext3 = abstractChannelHandlerContext.next;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext3;
        abstractChannelHandlerContext3.prev = abstractChannelHandlerContext2;
        callHandlerRemoved(abstractChannelHandlerContext);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandler removeFirst() {
        if (this.head.next == this.tail) {
            throw new NoSuchElementException();
        }
        return remove(this.head.next).handler();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandler removeLast() {
        AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next;
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.tail;
        if (abstractChannelHandlerContext == abstractChannelHandlerContext2) {
            throw new NoSuchElementException();
        }
        return remove(abstractChannelHandlerContext2.prev).handler();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline replace(ChannelHandler channelHandler, String str, ChannelHandler channelHandler2) throws Throwable {
        replace(getContextOrDie(channelHandler), str, channelHandler2);
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandler replace(String str, String str2, ChannelHandler channelHandler) {
        return replace(getContextOrDie(str), str2, channelHandler);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final <T extends ChannelHandler> T replace(Class<T> cls, String str, ChannelHandler channelHandler) {
        return (T) replace(getContextOrDie((Class<? extends ChannelHandler>) cls), str, channelHandler);
    }

    private ChannelHandler replace(final AbstractChannelHandlerContext abstractChannelHandlerContext, String str, ChannelHandler channelHandler) throws Throwable {
        synchronized (this) {
            if (str == null) {
                str = abstractChannelHandlerContext.name();
            } else if (!abstractChannelHandlerContext.name().equals(str)) {
                str = filterName(str, channelHandler);
            }
            final DefaultChannelHandlerContext defaultChannelHandlerContext = new DefaultChannelHandlerContext(this, abstractChannelHandlerContext.invoker, str, channelHandler);
            if (defaultChannelHandlerContext.channel().isRegistered() && !defaultChannelHandlerContext.executor().inEventLoop()) {
                waitForFuture(defaultChannelHandlerContext.executor().submit((Runnable) new OneTimeTask() { // from class: io.netty.channel.DefaultChannelPipeline.3
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (DefaultChannelPipeline.this) {
                            DefaultChannelPipeline.this.replace0(abstractChannelHandlerContext, defaultChannelHandlerContext);
                        }
                    }
                }));
                return abstractChannelHandlerContext.handler();
            }
            replace0(abstractChannelHandlerContext, defaultChannelHandlerContext);
            return abstractChannelHandlerContext.handler();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replace0(AbstractChannelHandlerContext abstractChannelHandlerContext, AbstractChannelHandlerContext abstractChannelHandlerContext2) {
        checkMultiplicity(abstractChannelHandlerContext2);
        AbstractChannelHandlerContext abstractChannelHandlerContext3 = abstractChannelHandlerContext.prev;
        AbstractChannelHandlerContext abstractChannelHandlerContext4 = abstractChannelHandlerContext.next;
        abstractChannelHandlerContext2.prev = abstractChannelHandlerContext3;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext4;
        abstractChannelHandlerContext3.next = abstractChannelHandlerContext2;
        abstractChannelHandlerContext4.prev = abstractChannelHandlerContext2;
        abstractChannelHandlerContext.prev = abstractChannelHandlerContext2;
        abstractChannelHandlerContext.next = abstractChannelHandlerContext2;
        callHandlerAdded(abstractChannelHandlerContext2);
        callHandlerRemoved(abstractChannelHandlerContext);
    }

    private static void checkMultiplicity(ChannelHandlerContext channelHandlerContext) {
        ChannelHandler channelHandlerHandler = channelHandlerContext.handler();
        if (channelHandlerHandler instanceof ChannelHandlerAdapter) {
            ChannelHandlerAdapter channelHandlerAdapter = (ChannelHandlerAdapter) channelHandlerHandler;
            if (!channelHandlerAdapter.isSharable() && channelHandlerAdapter.added) {
                throw new ChannelPipelineException(channelHandlerAdapter.getClass().getName() + " is not a @Sharable handler, so can't be added or removed multiple times.");
            }
            channelHandlerAdapter.added = true;
        }
    }

    private void callHandlerAdded(final AbstractChannelHandlerContext abstractChannelHandlerContext) {
        if (abstractChannelHandlerContext.channel().isRegistered() && !abstractChannelHandlerContext.executor().inEventLoop()) {
            abstractChannelHandlerContext.executor().execute(new OneTimeTask() { // from class: io.netty.channel.DefaultChannelPipeline.4
                @Override // java.lang.Runnable
                public void run() {
                    DefaultChannelPipeline.this.callHandlerAdded0(abstractChannelHandlerContext);
                }
            });
        } else {
            callHandlerAdded0(abstractChannelHandlerContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callHandlerAdded0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        try {
            abstractChannelHandlerContext.handler().handlerAdded(abstractChannelHandlerContext);
        } catch (Throwable th) {
            boolean z = false;
            try {
                remove(abstractChannelHandlerContext);
                z = true;
            } catch (Throwable th2) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Failed to remove a handler: " + abstractChannelHandlerContext.name(), th2);
                }
            }
            if (z) {
                fireExceptionCaught(new ChannelPipelineException(abstractChannelHandlerContext.handler().getClass().getName() + ".handlerAdded() has thrown an exception; removed.", th));
                return;
            }
            fireExceptionCaught(new ChannelPipelineException(abstractChannelHandlerContext.handler().getClass().getName() + ".handlerAdded() has thrown an exception; also failed to remove.", th));
        }
    }

    private void callHandlerRemoved(final AbstractChannelHandlerContext abstractChannelHandlerContext) {
        if (abstractChannelHandlerContext.channel().isRegistered() && !abstractChannelHandlerContext.executor().inEventLoop()) {
            abstractChannelHandlerContext.executor().execute(new OneTimeTask() { // from class: io.netty.channel.DefaultChannelPipeline.5
                @Override // java.lang.Runnable
                public void run() {
                    DefaultChannelPipeline.this.callHandlerRemoved0(abstractChannelHandlerContext);
                }
            });
        } else {
            callHandlerRemoved0(abstractChannelHandlerContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callHandlerRemoved0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        try {
            abstractChannelHandlerContext.handler().handlerRemoved(abstractChannelHandlerContext);
            abstractChannelHandlerContext.setRemoved();
        } catch (Throwable th) {
            fireExceptionCaught(new ChannelPipelineException(abstractChannelHandlerContext.handler().getClass().getName() + ".handlerRemoved() has thrown an exception.", th));
        }
    }

    private static void waitForFuture(Future<?> future) throws Throwable {
        try {
            future.get();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            PlatformDependent.throwException(e.getCause());
        }
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandler first() {
        ChannelHandlerContext channelHandlerContextFirstContext = firstContext();
        if (channelHandlerContextFirstContext == null) {
            return null;
        }
        return channelHandlerContextFirstContext.handler();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext firstContext() {
        if (this.head.next == this.tail) {
            return null;
        }
        return this.head.next;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandler last() {
        AbstractChannelHandlerContext abstractChannelHandlerContext = this.tail.prev;
        if (abstractChannelHandlerContext == this.head) {
            return null;
        }
        return abstractChannelHandlerContext.handler();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext lastContext() {
        AbstractChannelHandlerContext abstractChannelHandlerContext = this.tail.prev;
        if (abstractChannelHandlerContext == this.head) {
            return null;
        }
        return abstractChannelHandlerContext;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandler get(String str) {
        ChannelHandlerContext channelHandlerContextContext = context(str);
        if (channelHandlerContextContext == null) {
            return null;
        }
        return channelHandlerContextContext.handler();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final <T extends ChannelHandler> T get(Class<T> cls) {
        ChannelHandlerContext channelHandlerContextContext = context((Class<? extends ChannelHandler>) cls);
        if (channelHandlerContextContext == null) {
            return null;
        }
        return (T) channelHandlerContextContext.handler();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext context(String str) {
        if (str == null) {
            throw new NullPointerException("name");
        }
        return context0(str);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext context(ChannelHandler channelHandler) {
        if (channelHandler == null) {
            throw new NullPointerException("handler");
        }
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != null; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            if (abstractChannelHandlerContext.handler() == channelHandler) {
                return abstractChannelHandlerContext;
            }
        }
        return null;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext context(Class<? extends ChannelHandler> cls) {
        if (cls == null) {
            throw new NullPointerException("handlerType");
        }
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != null; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            if (cls.isAssignableFrom(abstractChannelHandlerContext.handler().getClass())) {
                return abstractChannelHandlerContext;
            }
        }
        return null;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final List<String> names() {
        ArrayList arrayList = new ArrayList();
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != null; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            arrayList.add(abstractChannelHandlerContext.name());
        }
        return arrayList;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final Map<String, ChannelHandler> toMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != this.tail; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            linkedHashMap.put(abstractChannelHandlerContext.name(), abstractChannelHandlerContext.handler());
        }
        return linkedHashMap;
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<String, ChannelHandler>> iterator() {
        return toMap().entrySet().iterator();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append('{');
        AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next;
        while (abstractChannelHandlerContext != this.tail) {
            sb.append('(');
            sb.append(abstractChannelHandlerContext.name());
            sb.append(" = ");
            sb.append(abstractChannelHandlerContext.handler().getClass().getName());
            sb.append(')');
            abstractChannelHandlerContext = abstractChannelHandlerContext.next;
            if (abstractChannelHandlerContext == this.tail) {
                break;
            }
            sb.append(", ");
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelRegistered() {
        this.head.fireChannelRegistered();
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelUnregistered() {
        this.head.fireChannelUnregistered();
        if (!this.channel.isOpen()) {
            destroy();
        }
        return this;
    }

    private void destroy() {
        destroyUp(this.head.next, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyUp(final AbstractChannelHandlerContext abstractChannelHandlerContext, boolean z) {
        Thread threadCurrentThread = Thread.currentThread();
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.tail;
        while (abstractChannelHandlerContext != abstractChannelHandlerContext2) {
            EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
            if (!z && !eventExecutorExecutor.inEventLoop(threadCurrentThread)) {
                eventExecutorExecutor.execute(new OneTimeTask() { // from class: io.netty.channel.DefaultChannelPipeline.6
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultChannelPipeline.this.destroyUp(abstractChannelHandlerContext, true);
                    }
                });
                return;
            } else {
                abstractChannelHandlerContext = abstractChannelHandlerContext.next;
                z = false;
            }
        }
        destroyDown(threadCurrentThread, abstractChannelHandlerContext2.prev, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyDown(Thread thread, final AbstractChannelHandlerContext abstractChannelHandlerContext, boolean z) {
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.head;
        while (abstractChannelHandlerContext != abstractChannelHandlerContext2) {
            EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
            if (z || eventExecutorExecutor.inEventLoop(thread)) {
                synchronized (this) {
                    remove0(abstractChannelHandlerContext);
                }
                abstractChannelHandlerContext = abstractChannelHandlerContext.prev;
                z = false;
            } else {
                eventExecutorExecutor.execute(new OneTimeTask() { // from class: io.netty.channel.DefaultChannelPipeline.7
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultChannelPipeline.this.destroyDown(Thread.currentThread(), abstractChannelHandlerContext, true);
                    }
                });
                return;
            }
        }
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelActive() {
        this.head.fireChannelActive();
        if (this.channel.config().isAutoRead()) {
            this.channel.read();
        }
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelInactive() {
        this.head.fireChannelInactive();
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireExceptionCaught(Throwable th) {
        this.head.fireExceptionCaught(th);
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireUserEventTriggered(Object obj) {
        this.head.fireUserEventTriggered(obj);
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelRead(Object obj) {
        this.head.fireChannelRead(obj);
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelReadComplete() {
        this.head.fireChannelReadComplete();
        if (this.channel.config().isAutoRead()) {
            read();
        }
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelWritabilityChanged() {
        this.head.fireChannelWritabilityChanged();
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelFuture bind(SocketAddress socketAddress) {
        return this.tail.bind(socketAddress);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelFuture connect(SocketAddress socketAddress) {
        return this.tail.connect(socketAddress);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        return this.tail.connect(socketAddress, socketAddress2);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelFuture disconnect() {
        return this.tail.disconnect();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelFuture close() {
        return this.tail.close();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelFuture deregister() {
        return this.tail.deregister();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline flush() {
        this.tail.flush();
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelFuture bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return this.tail.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return this.tail.connect(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        return this.tail.connect(socketAddress, socketAddress2, channelPromise);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelFuture disconnect(ChannelPromise channelPromise) {
        return this.tail.disconnect(channelPromise);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelFuture close(ChannelPromise channelPromise) {
        return this.tail.close(channelPromise);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelFuture deregister(ChannelPromise channelPromise) {
        return this.tail.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline read() {
        this.tail.read();
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelFuture write(Object obj) {
        return this.tail.write(obj);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelFuture write(Object obj, ChannelPromise channelPromise) {
        return this.tail.write(obj, channelPromise);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
        return this.tail.writeAndFlush(obj, channelPromise);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelFuture writeAndFlush(Object obj) {
        return this.tail.writeAndFlush(obj);
    }

    private String filterName(String str, ChannelHandler channelHandler) {
        if (str == null) {
            return generateName(channelHandler);
        }
        if (context0(str) == null) {
            return str;
        }
        throw new IllegalArgumentException("Duplicate handler name: " + str);
    }

    private AbstractChannelHandlerContext context0(String str) {
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != this.tail; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            if (abstractChannelHandlerContext.name().equals(str)) {
                return abstractChannelHandlerContext;
            }
        }
        return null;
    }

    private AbstractChannelHandlerContext getContextOrDie(String str) {
        AbstractChannelHandlerContext abstractChannelHandlerContext = (AbstractChannelHandlerContext) context(str);
        if (abstractChannelHandlerContext != null) {
            return abstractChannelHandlerContext;
        }
        throw new NoSuchElementException(str);
    }

    private AbstractChannelHandlerContext getContextOrDie(ChannelHandler channelHandler) {
        AbstractChannelHandlerContext abstractChannelHandlerContext = (AbstractChannelHandlerContext) context(channelHandler);
        if (abstractChannelHandlerContext != null) {
            return abstractChannelHandlerContext;
        }
        throw new NoSuchElementException(channelHandler.getClass().getName());
    }

    private AbstractChannelHandlerContext getContextOrDie(Class<? extends ChannelHandler> cls) {
        AbstractChannelHandlerContext abstractChannelHandlerContext = (AbstractChannelHandlerContext) context(cls);
        if (abstractChannelHandlerContext != null) {
            return abstractChannelHandlerContext;
        }
        throw new NoSuchElementException(cls.getName());
    }

    static final class TailContext extends AbstractChannelHandlerContext implements ChannelInboundHandler {
        private static final String TAIL_NAME = DefaultChannelPipeline.generateName0(TailContext.class);

        @Override // io.netty.channel.ChannelInboundHandler
        public final void channelActive(ChannelHandlerContext channelHandlerContext) {
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public final void channelInactive(ChannelHandlerContext channelHandlerContext) {
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public final void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public final void channelRegistered(ChannelHandlerContext channelHandlerContext) {
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public final void channelUnregistered(ChannelHandlerContext channelHandlerContext) {
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public final void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) {
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public final ChannelHandler handler() {
            return this;
        }

        @Override // io.netty.channel.ChannelHandler
        public final void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        }

        @Override // io.netty.channel.ChannelHandler
        public final void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        }

        TailContext(DefaultChannelPipeline defaultChannelPipeline) {
            super(defaultChannelPipeline, null, TAIL_NAME, true, false);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public final void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
            ReferenceCountUtil.release(obj);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public final void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
            try {
                DefaultChannelPipeline.logger.warn("An exceptionCaught() event was fired, and it reached at the tail of the pipeline. It usually means the last handler in the pipeline did not handle the exception.", th);
            } finally {
                ReferenceCountUtil.release(th);
            }
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public final void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
            try {
                DefaultChannelPipeline.logger.debug("Discarded inbound message {} that reached at the tail of the pipeline. Please check your pipeline configuration.", obj);
            } finally {
                ReferenceCountUtil.release(obj);
            }
        }
    }

    static final class HeadContext extends AbstractChannelHandlerContext implements ChannelOutboundHandler {
        private static final String HEAD_NAME = DefaultChannelPipeline.generateName0(HeadContext.class);
        private final Channel.Unsafe unsafe;

        @Override // io.netty.channel.ChannelHandlerContext
        public final ChannelHandler handler() {
            return this;
        }

        @Override // io.netty.channel.ChannelHandler
        public final void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        }

        @Override // io.netty.channel.ChannelHandler
        public final void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        }

        HeadContext(DefaultChannelPipeline defaultChannelPipeline) {
            super(defaultChannelPipeline, null, HEAD_NAME, false, true);
            this.unsafe = defaultChannelPipeline.channel().unsafe();
        }

        @Override // io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
        public final void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
            channelHandlerContext.fireExceptionCaught(th);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public final void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) {
            this.unsafe.bind(socketAddress, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public final void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            this.unsafe.connect(socketAddress, socketAddress2, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public final void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.unsafe.disconnect(channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public final void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.unsafe.close(channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public final void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.unsafe.deregister(channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public final void read(ChannelHandlerContext channelHandlerContext) {
            this.unsafe.beginRead();
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public final void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
            this.unsafe.write(obj, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public final void flush(ChannelHandlerContext channelHandlerContext) {
            this.unsafe.flush();
        }
    }
}
