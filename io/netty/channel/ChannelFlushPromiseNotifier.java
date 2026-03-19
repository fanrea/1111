package io.netty.channel;

import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ChannelFlushPromiseNotifier {
    private final Queue<FlushCheckpoint> flushCheckpoints;
    private final boolean tryNotify;
    private long writeCounter;

    interface FlushCheckpoint {
        long flushCheckpoint();

        void flushCheckpoint(long j);

        ChannelPromise promise();
    }

    public ChannelFlushPromiseNotifier(boolean z) {
        this.flushCheckpoints = new ArrayDeque();
        this.tryNotify = z;
    }

    public ChannelFlushPromiseNotifier() {
        this(false);
    }

    @Deprecated
    public final ChannelFlushPromiseNotifier add(ChannelPromise channelPromise, int i) {
        return add(channelPromise, i);
    }

    public final ChannelFlushPromiseNotifier add(ChannelPromise channelPromise, long j) {
        if (channelPromise == null) {
            throw new NullPointerException("promise");
        }
        if (j < 0) {
            throw new IllegalArgumentException("pendingDataSize must be >= 0 but was " + j);
        }
        long j2 = this.writeCounter + j;
        if (channelPromise instanceof FlushCheckpoint) {
            FlushCheckpoint flushCheckpoint = (FlushCheckpoint) channelPromise;
            flushCheckpoint.flushCheckpoint(j2);
            this.flushCheckpoints.add(flushCheckpoint);
        } else {
            this.flushCheckpoints.add(new DefaultFlushCheckpoint(j2, channelPromise));
        }
        return this;
    }

    public final ChannelFlushPromiseNotifier increaseWriteCounter(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("delta must be >= 0 but was " + j);
        }
        this.writeCounter += j;
        return this;
    }

    public final long writeCounter() {
        return this.writeCounter;
    }

    public final ChannelFlushPromiseNotifier notifyPromises() {
        notifyPromises0(null);
        return this;
    }

    @Deprecated
    public final ChannelFlushPromiseNotifier notifyFlushFutures() {
        return notifyPromises();
    }

    public final ChannelFlushPromiseNotifier notifyPromises(Throwable th) {
        notifyPromises();
        while (true) {
            FlushCheckpoint flushCheckpointPoll = this.flushCheckpoints.poll();
            if (flushCheckpointPoll == null) {
                return this;
            }
            if (this.tryNotify) {
                flushCheckpointPoll.promise().tryFailure(th);
            } else {
                flushCheckpointPoll.promise().setFailure(th);
            }
        }
    }

    @Deprecated
    public final ChannelFlushPromiseNotifier notifyFlushFutures(Throwable th) {
        return notifyPromises(th);
    }

    public final ChannelFlushPromiseNotifier notifyPromises(Throwable th, Throwable th2) {
        notifyPromises0(th);
        while (true) {
            FlushCheckpoint flushCheckpointPoll = this.flushCheckpoints.poll();
            if (flushCheckpointPoll == null) {
                return this;
            }
            if (this.tryNotify) {
                flushCheckpointPoll.promise().tryFailure(th2);
            } else {
                flushCheckpointPoll.promise().setFailure(th2);
            }
        }
    }

    @Deprecated
    public final ChannelFlushPromiseNotifier notifyFlushFutures(Throwable th, Throwable th2) {
        return notifyPromises(th, th2);
    }

    private void notifyPromises0(Throwable th) {
        if (this.flushCheckpoints.isEmpty()) {
            this.writeCounter = 0L;
            return;
        }
        long j = this.writeCounter;
        while (true) {
            FlushCheckpoint flushCheckpointPeek = this.flushCheckpoints.peek();
            if (flushCheckpointPeek == null) {
                this.writeCounter = 0L;
                break;
            }
            if (flushCheckpointPeek.flushCheckpoint() > j) {
                if (j > 0 && this.flushCheckpoints.size() == 1) {
                    this.writeCounter = 0L;
                    flushCheckpointPeek.flushCheckpoint(flushCheckpointPeek.flushCheckpoint() - j);
                }
            } else {
                this.flushCheckpoints.remove();
                ChannelPromise channelPromisePromise = flushCheckpointPeek.promise();
                if (th == null) {
                    if (this.tryNotify) {
                        channelPromisePromise.trySuccess();
                    } else {
                        channelPromisePromise.setSuccess();
                    }
                } else if (this.tryNotify) {
                    channelPromisePromise.tryFailure(th);
                } else {
                    channelPromisePromise.setFailure(th);
                }
            }
        }
        long j2 = this.writeCounter;
        if (j2 >= 549755813888L) {
            this.writeCounter = 0L;
            for (FlushCheckpoint flushCheckpoint : this.flushCheckpoints) {
                flushCheckpoint.flushCheckpoint(flushCheckpoint.flushCheckpoint() - j2);
            }
        }
    }

    static class DefaultFlushCheckpoint implements FlushCheckpoint {
        private long checkpoint;
        private final ChannelPromise future;

        DefaultFlushCheckpoint(long j, ChannelPromise channelPromise) {
            this.checkpoint = j;
            this.future = channelPromise;
        }

        @Override // io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
        public long flushCheckpoint() {
            return this.checkpoint;
        }

        @Override // io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
        public void flushCheckpoint(long j) {
            this.checkpoint = j;
        }

        @Override // io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
        public ChannelPromise promise() {
            return this.future;
        }
    }
}
