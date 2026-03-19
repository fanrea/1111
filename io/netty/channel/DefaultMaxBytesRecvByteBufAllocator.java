package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import java.util.AbstractMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class DefaultMaxBytesRecvByteBufAllocator implements MaxBytesRecvByteBufAllocator {
    private volatile int maxBytesPerIndividualRead;
    private volatile int maxBytesPerRead;

    final class HandleImpl implements RecvByteBufAllocator.Handle {
        private int attemptBytesRead;
        private int bytesToRead;
        private int individualReadMax;
        private int lastBytesRead;

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public final void incMessagesRead(int i) {
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public final void readComplete() {
        }

        private HandleImpl() {
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public final ByteBuf allocate(ByteBufAllocator byteBufAllocator) {
            return byteBufAllocator.ioBuffer(guess());
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public final int guess() {
            return Math.min(this.individualReadMax, this.bytesToRead);
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public final void reset(ChannelConfig channelConfig) {
            this.bytesToRead = DefaultMaxBytesRecvByteBufAllocator.this.maxBytesPerRead();
            this.individualReadMax = DefaultMaxBytesRecvByteBufAllocator.this.maxBytesPerIndividualRead();
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public final void lastBytesRead(int i) {
            this.lastBytesRead = i;
            this.bytesToRead -= i;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public final int lastBytesRead() {
            return this.lastBytesRead;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public final boolean continueReading() {
            return this.bytesToRead > 0 && this.attemptBytesRead == this.lastBytesRead;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public final void attemptedBytesRead(int i) {
            this.attemptBytesRead = i;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public final int attemptedBytesRead() {
            return this.attemptBytesRead;
        }
    }

    public DefaultMaxBytesRecvByteBufAllocator() {
        this(65536, 65536);
    }

    public DefaultMaxBytesRecvByteBufAllocator(int i, int i2) {
        checkMaxBytesPerReadPair(i, i2);
        this.maxBytesPerRead = i;
        this.maxBytesPerIndividualRead = i2;
    }

    @Override // io.netty.channel.RecvByteBufAllocator
    public RecvByteBufAllocator.Handle newHandle() {
        return new HandleImpl();
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public int maxBytesPerRead() {
        return this.maxBytesPerRead;
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerRead(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxBytesPerRead: " + i + " (expected: > 0)");
        }
        synchronized (this) {
            int iMaxBytesPerIndividualRead = maxBytesPerIndividualRead();
            if (i < iMaxBytesPerIndividualRead) {
                throw new IllegalArgumentException("maxBytesPerRead cannot be less than maxBytesPerIndividualRead (" + iMaxBytesPerIndividualRead + "): " + i);
            }
            this.maxBytesPerRead = i;
        }
        return this;
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public int maxBytesPerIndividualRead() {
        return this.maxBytesPerIndividualRead;
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerIndividualRead(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxBytesPerIndividualRead: " + i + " (expected: > 0)");
        }
        synchronized (this) {
            int iMaxBytesPerRead = maxBytesPerRead();
            if (i > iMaxBytesPerRead) {
                throw new IllegalArgumentException("maxBytesPerIndividualRead cannot be greater than maxBytesPerRead (" + iMaxBytesPerRead + "): " + i);
            }
            this.maxBytesPerIndividualRead = i;
        }
        return this;
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public synchronized Map.Entry<Integer, Integer> maxBytesPerReadPair() {
        return new AbstractMap.SimpleEntry(Integer.valueOf(this.maxBytesPerRead), Integer.valueOf(this.maxBytesPerIndividualRead));
    }

    private void checkMaxBytesPerReadPair(int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxBytesPerRead: " + i + " (expected: > 0)");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxBytesPerIndividualRead: " + i2 + " (expected: > 0)");
        }
        if (i >= i2) {
            return;
        }
        throw new IllegalArgumentException("maxBytesPerRead cannot be less than maxBytesPerIndividualRead (" + i2 + "): " + i);
    }

    @Override // io.netty.channel.MaxBytesRecvByteBufAllocator
    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerReadPair(int i, int i2) {
        checkMaxBytesPerReadPair(i, i2);
        synchronized (this) {
            this.maxBytesPerRead = i;
            this.maxBytesPerIndividualRead = i2;
        }
        return this;
    }
}
