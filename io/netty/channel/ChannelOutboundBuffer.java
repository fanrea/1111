package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.Recycler;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.OneTimeTask;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ChannelOutboundBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final AtomicLongFieldUpdater<ChannelOutboundBuffer> TOTAL_PENDING_SIZE_UPDATER;
    private static final AtomicIntegerFieldUpdater<ChannelOutboundBuffer> UNWRITABLE_UPDATER;
    private final Channel channel;
    private volatile Runnable fireChannelWritabilityChangedTask;
    private int flushed;
    private Entry flushedEntry;
    private boolean inFail;
    private int nioBufferCount;
    private long nioBufferSize;
    private Entry tailEntry;
    private volatile long totalPendingSize;
    private Entry unflushedEntry;
    private volatile int unwritable;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ChannelOutboundBuffer.class);
    private static final FastThreadLocal<ByteBuffer[]> NIO_BUFFERS = new FastThreadLocal<ByteBuffer[]>() { // from class: io.netty.channel.ChannelOutboundBuffer.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public final ByteBuffer[] initialValue() {
            return new ByteBuffer[1024];
        }
    };

    public interface MessageProcessor {
        boolean processMessage(Object obj);
    }

    @Deprecated
    public final void recycle() {
    }

    static {
        AtomicIntegerFieldUpdater<ChannelOutboundBuffer> atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(ChannelOutboundBuffer.class, "unwritable");
        if (atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater == null) {
            atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "unwritable");
        }
        UNWRITABLE_UPDATER = atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater;
        AtomicLongFieldUpdater<ChannelOutboundBuffer> atomicLongFieldUpdaterNewAtomicLongFieldUpdater = PlatformDependent.newAtomicLongFieldUpdater(ChannelOutboundBuffer.class, "totalPendingSize");
        if (atomicLongFieldUpdaterNewAtomicLongFieldUpdater == null) {
            atomicLongFieldUpdaterNewAtomicLongFieldUpdater = AtomicLongFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "totalPendingSize");
        }
        TOTAL_PENDING_SIZE_UPDATER = atomicLongFieldUpdaterNewAtomicLongFieldUpdater;
    }

    ChannelOutboundBuffer(AbstractChannel abstractChannel) {
        this.channel = abstractChannel;
    }

    public final void addMessage(Object obj, int i, ChannelPromise channelPromise) {
        Entry entryNewInstance = Entry.newInstance(obj, i, total(obj), channelPromise);
        Entry entry = this.tailEntry;
        if (entry == null) {
            this.flushedEntry = null;
            this.tailEntry = entryNewInstance;
        } else {
            entry.next = entryNewInstance;
            this.tailEntry = entryNewInstance;
        }
        if (this.unflushedEntry == null) {
            this.unflushedEntry = entryNewInstance;
        }
        incrementPendingOutboundBytes(i, false);
    }

    public final void addFlush() {
        Entry entry = this.unflushedEntry;
        if (entry != null) {
            if (this.flushedEntry == null) {
                this.flushedEntry = entry;
            }
            do {
                this.flushed++;
                if (!entry.promise.setUncancellable()) {
                    decrementPendingOutboundBytes(entry.cancel(), false, true);
                }
                entry = entry.next;
            } while (entry != null);
            this.unflushedEntry = null;
        }
    }

    final void incrementPendingOutboundBytes(long j) {
        incrementPendingOutboundBytes(j, true);
    }

    private void incrementPendingOutboundBytes(long j, boolean z) {
        if (j != 0 && TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, j) >= this.channel.config().getWriteBufferHighWaterMark()) {
            setUnwritable(z);
        }
    }

    final void decrementPendingOutboundBytes(long j) {
        decrementPendingOutboundBytes(j, true, true);
    }

    private void decrementPendingOutboundBytes(long j, boolean z, boolean z2) {
        if (j == 0) {
            return;
        }
        long jAddAndGet = TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -j);
        if (z2) {
            if (jAddAndGet == 0 || jAddAndGet <= this.channel.config().getWriteBufferLowWaterMark()) {
                setWritable(z);
            }
        }
    }

    private static long total(Object obj) {
        if (obj instanceof ByteBuf) {
            return ((ByteBuf) obj).readableBytes();
        }
        if (obj instanceof FileRegion) {
            return ((FileRegion) obj).count();
        }
        if (obj instanceof ByteBufHolder) {
            return ((ByteBufHolder) obj).content().readableBytes();
        }
        return -1L;
    }

    public final Object current() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            return null;
        }
        return entry.msg;
    }

    public final void progress(long j) {
        Entry entry = this.flushedEntry;
        ChannelPromise channelPromise = entry.promise;
        if (channelPromise instanceof ChannelProgressivePromise) {
            long j2 = entry.progress + j;
            entry.progress = j2;
            ((ChannelProgressivePromise) channelPromise).tryProgress(j2, entry.total);
        }
    }

    public final boolean remove() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            clearNioBuffers();
            return false;
        }
        Object obj = entry.msg;
        ChannelPromise channelPromise = entry.promise;
        int i = entry.pendingSize;
        removeEntry(entry);
        if (!entry.cancelled) {
            ReferenceCountUtil.safeRelease(obj);
            safeSuccess(channelPromise);
            decrementPendingOutboundBytes(i, false, true);
        }
        entry.recycle();
        return true;
    }

    public final boolean remove(Throwable th) {
        return remove0(th, true);
    }

    private boolean remove0(Throwable th, boolean z) {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            clearNioBuffers();
            return false;
        }
        Object obj = entry.msg;
        ChannelPromise channelPromise = entry.promise;
        int i = entry.pendingSize;
        removeEntry(entry);
        if (!entry.cancelled) {
            ReferenceCountUtil.safeRelease(obj);
            safeFail(channelPromise, th);
            decrementPendingOutboundBytes(i, false, z);
        }
        entry.recycle();
        return true;
    }

    private void removeEntry(Entry entry) {
        int i = this.flushed - 1;
        this.flushed = i;
        if (i == 0) {
            this.flushedEntry = null;
            if (entry == this.tailEntry) {
                this.tailEntry = null;
                this.unflushedEntry = null;
                return;
            }
            return;
        }
        this.flushedEntry = entry.next;
    }

    public final void removeBytes(long j) {
        while (true) {
            Object objCurrent = current();
            if (!(objCurrent instanceof ByteBuf)) {
                break;
            }
            ByteBuf byteBuf = (ByteBuf) objCurrent;
            int i = byteBuf.readerIndex();
            long jWriterIndex = byteBuf.writerIndex() - i;
            if (jWriterIndex <= j) {
                if (j != 0) {
                    progress(jWriterIndex);
                    j -= jWriterIndex;
                }
                remove();
            } else if (j != 0) {
                byteBuf.readerIndex(i + ((int) j));
                progress(j);
            }
        }
        clearNioBuffers();
    }

    private void clearNioBuffers() {
        int i = this.nioBufferCount;
        if (i > 0) {
            this.nioBufferCount = 0;
            Arrays.fill(NIO_BUFFERS.get(), 0, i, (Object) null);
        }
    }

    public final ByteBuffer[] nioBuffers() throws Throwable {
        ByteBuf byteBuf;
        int i;
        int iWriterIndex;
        InternalThreadLocalMap internalThreadLocalMap = InternalThreadLocalMap.get();
        ByteBuffer[] byteBufferArrExpandNioBufferArray = NIO_BUFFERS.get(internalThreadLocalMap);
        long j = 0;
        int iFillBufferArray = 0;
        for (Entry entry = this.flushedEntry; isFlushedEntry(entry) && (entry.msg instanceof ByteBuf); entry = entry.next) {
            if (!entry.cancelled && (iWriterIndex = byteBuf.writerIndex() - (i = (byteBuf = (ByteBuf) entry.msg).readerIndex())) > 0) {
                if (Integer.MAX_VALUE - iWriterIndex < j) {
                    break;
                }
                j += iWriterIndex;
                int iNioBufferCount = entry.count;
                if (iNioBufferCount == -1) {
                    iNioBufferCount = byteBuf.nioBufferCount();
                    entry.count = iNioBufferCount;
                }
                int i2 = iFillBufferArray + iNioBufferCount;
                if (i2 > byteBufferArrExpandNioBufferArray.length) {
                    byteBufferArrExpandNioBufferArray = expandNioBufferArray(byteBufferArrExpandNioBufferArray, i2, iFillBufferArray);
                    NIO_BUFFERS.set(internalThreadLocalMap, byteBufferArrExpandNioBufferArray);
                }
                if (iNioBufferCount == 1) {
                    ByteBuffer byteBufferInternalNioBuffer = entry.buf;
                    if (byteBufferInternalNioBuffer == null) {
                        byteBufferInternalNioBuffer = byteBuf.internalNioBuffer(i, iWriterIndex);
                        entry.buf = byteBufferInternalNioBuffer;
                    }
                    byteBufferArrExpandNioBufferArray[iFillBufferArray] = byteBufferInternalNioBuffer;
                    iFillBufferArray++;
                } else {
                    ByteBuffer[] byteBufferArrNioBuffers = entry.bufs;
                    if (byteBufferArrNioBuffers == null) {
                        byteBufferArrNioBuffers = byteBuf.nioBuffers();
                        entry.bufs = byteBufferArrNioBuffers;
                    }
                    iFillBufferArray = fillBufferArray(byteBufferArrNioBuffers, byteBufferArrExpandNioBufferArray, iFillBufferArray);
                }
            }
        }
        this.nioBufferCount = iFillBufferArray;
        this.nioBufferSize = j;
        return byteBufferArrExpandNioBufferArray;
    }

    private static int fillBufferArray(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2, int i) {
        int length = byteBufferArr.length;
        int i2 = 0;
        while (i2 < length) {
            ByteBuffer byteBuffer = byteBufferArr[i2];
            if (byteBuffer == null) {
                break;
            }
            byteBufferArr2[i] = byteBuffer;
            i2++;
            i++;
        }
        return i;
    }

    private static ByteBuffer[] expandNioBufferArray(ByteBuffer[] byteBufferArr, int i, int i2) {
        int length = byteBufferArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
        } while (i > length);
        ByteBuffer[] byteBufferArr2 = new ByteBuffer[length];
        System.arraycopy(byteBufferArr, 0, byteBufferArr2, 0, i2);
        return byteBufferArr2;
    }

    public final int nioBufferCount() {
        return this.nioBufferCount;
    }

    public final long nioBufferSize() {
        return this.nioBufferSize;
    }

    public final boolean isWritable() {
        return this.unwritable == 0;
    }

    public final boolean getUserDefinedWritability(int i) {
        return (writabilityMask(i) & this.unwritable) == 0;
    }

    public final void setUserDefinedWritability(int i, boolean z) {
        if (z) {
            setUserDefinedWritability(i);
        } else {
            clearUserDefinedWritability(i);
        }
    }

    private void setUserDefinedWritability(int i) {
        int i2;
        int i3;
        int iWritabilityMask = writabilityMask(i) ^ (-1);
        do {
            i2 = this.unwritable;
            i3 = i2 & iWritabilityMask;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i2, i3));
        if (i2 == 0 || i3 != 0) {
            return;
        }
        fireChannelWritabilityChanged(true);
    }

    private void clearUserDefinedWritability(int i) {
        int i2;
        int i3;
        int iWritabilityMask = writabilityMask(i);
        do {
            i2 = this.unwritable;
            i3 = i2 | iWritabilityMask;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i2, i3));
        if (i2 != 0 || i3 == 0) {
            return;
        }
        fireChannelWritabilityChanged(true);
    }

    private static int writabilityMask(int i) {
        if (i > 0 && i <= 31) {
            return 1 << i;
        }
        throw new IllegalArgumentException("index: " + i + " (expected: 1~31)");
    }

    private void setWritable(boolean z) {
        int i;
        int i2;
        do {
            i = this.unwritable;
            i2 = i & (-2);
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i, i2));
        if (i == 0 || i2 != 0) {
            return;
        }
        fireChannelWritabilityChanged(z);
    }

    private void setUnwritable(boolean z) {
        int i;
        int i2;
        do {
            i = this.unwritable;
            i2 = i | 1;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i, i2));
        if (i != 0 || i2 == 0) {
            return;
        }
        fireChannelWritabilityChanged(z);
    }

    private void fireChannelWritabilityChanged(boolean z) {
        final ChannelPipeline channelPipelinePipeline = this.channel.pipeline();
        if (z) {
            Runnable runnable = this.fireChannelWritabilityChangedTask;
            if (runnable == null) {
                runnable = new Runnable() { // from class: io.netty.channel.ChannelOutboundBuffer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        channelPipelinePipeline.fireChannelWritabilityChanged();
                    }
                };
                this.fireChannelWritabilityChangedTask = runnable;
            }
            this.channel.eventLoop().execute(runnable);
            return;
        }
        channelPipelinePipeline.fireChannelWritabilityChanged();
    }

    public final int size() {
        return this.flushed;
    }

    public final boolean isEmpty() {
        return this.flushed == 0;
    }

    final void failFlushed(Throwable th, boolean z) {
        if (this.inFail) {
            return;
        }
        try {
            this.inFail = true;
            do {
            } while (remove0(th, z));
        } finally {
            this.inFail = false;
        }
    }

    final void close(final ClosedChannelException closedChannelException) {
        if (this.inFail) {
            this.channel.eventLoop().execute(new OneTimeTask() { // from class: io.netty.channel.ChannelOutboundBuffer.3
                @Override // java.lang.Runnable
                public void run() {
                    ChannelOutboundBuffer.this.close(closedChannelException);
                }
            });
            return;
        }
        this.inFail = true;
        if (this.channel.isOpen()) {
            throw new IllegalStateException("close() must be invoked after the channel is closed.");
        }
        if (!isEmpty()) {
            throw new IllegalStateException("close() must be invoked after all flushed writes are handled.");
        }
        try {
            for (Entry entryRecycleAndGetNext = this.unflushedEntry; entryRecycleAndGetNext != null; entryRecycleAndGetNext = entryRecycleAndGetNext.recycleAndGetNext()) {
                TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -entryRecycleAndGetNext.pendingSize);
                if (!entryRecycleAndGetNext.cancelled) {
                    ReferenceCountUtil.safeRelease(entryRecycleAndGetNext.msg);
                    safeFail(entryRecycleAndGetNext.promise, closedChannelException);
                }
            }
            this.inFail = false;
            clearNioBuffers();
        } catch (Throwable th) {
            this.inFail = false;
            throw th;
        }
    }

    private static void safeSuccess(ChannelPromise channelPromise) {
        if ((channelPromise instanceof VoidChannelPromise) || channelPromise.trySuccess()) {
            return;
        }
        logger.warn("Failed to mark a promise as success because it is done already: {}", channelPromise);
    }

    private static void safeFail(ChannelPromise channelPromise, Throwable th) {
        if ((channelPromise instanceof VoidChannelPromise) || channelPromise.tryFailure(th)) {
            return;
        }
        logger.warn("Failed to mark a promise as failure because it's done already: {}", channelPromise, th);
    }

    public final long totalPendingWriteBytes() {
        return this.totalPendingSize;
    }

    public final long bytesBeforeUnwritable() {
        long writeBufferHighWaterMark = this.channel.config().getWriteBufferHighWaterMark() - this.totalPendingSize;
        if (writeBufferHighWaterMark <= 0 || !isWritable()) {
            return 0L;
        }
        return writeBufferHighWaterMark;
    }

    public final long bytesBeforeWritable() {
        long writeBufferLowWaterMark = this.totalPendingSize - this.channel.config().getWriteBufferLowWaterMark();
        if (writeBufferLowWaterMark <= 0 || isWritable()) {
            return 0L;
        }
        return writeBufferLowWaterMark;
    }

    public final void forEachFlushedMessage(MessageProcessor messageProcessor) {
        if (messageProcessor == null) {
            throw new NullPointerException("processor");
        }
        Entry entry = this.flushedEntry;
        if (entry == null) {
            return;
        }
        do {
            if (!entry.cancelled && !messageProcessor.processMessage(entry.msg)) {
                return;
            } else {
                entry = entry.next;
            }
        } while (isFlushedEntry(entry));
    }

    private boolean isFlushedEntry(Entry entry) {
        return (entry == null || entry == this.unflushedEntry) ? false : true;
    }

    static final class Entry {
        private static final Recycler<Entry> RECYCLER = new Recycler<Entry>() { // from class: io.netty.channel.ChannelOutboundBuffer.Entry.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.Recycler
            /* renamed from: newObject */
            public final Entry newObject2(Recycler.Handle<Entry> handle) {
                return new Entry(handle);
            }
        };
        ByteBuffer buf;
        ByteBuffer[] bufs;
        boolean cancelled;
        int count;
        private final Recycler.Handle handle;
        Object msg;
        Entry next;
        int pendingSize;
        long progress;
        ChannelPromise promise;
        long total;

        private Entry(Recycler.Handle handle) {
            this.count = -1;
            this.handle = handle;
        }

        static Entry newInstance(Object obj, int i, long j, ChannelPromise channelPromise) {
            Entry entry = RECYCLER.get();
            entry.msg = obj;
            entry.pendingSize = i;
            entry.total = j;
            entry.promise = channelPromise;
            return entry;
        }

        final int cancel() {
            if (this.cancelled) {
                return 0;
            }
            this.cancelled = true;
            int i = this.pendingSize;
            ReferenceCountUtil.safeRelease(this.msg);
            this.msg = Unpooled.EMPTY_BUFFER;
            this.pendingSize = 0;
            this.total = 0L;
            this.progress = 0L;
            this.bufs = null;
            this.buf = null;
            return i;
        }

        final void recycle() {
            this.next = null;
            this.bufs = null;
            this.buf = null;
            this.msg = null;
            this.promise = null;
            this.progress = 0L;
            this.total = 0L;
            this.pendingSize = 0;
            this.count = -1;
            this.cancelled = false;
            RECYCLER.recycle(this, this.handle);
        }

        final Entry recycleAndGetNext() {
            Entry entry = this.next;
            recycle();
            return entry;
        }
    }
}
