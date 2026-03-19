package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.Thread;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ThreadLocalRandom extends Random {
    private static final long addend = 11;
    private static volatile long initialSeedUniquifier = 0;
    private static final long mask = 281474976710655L;
    private static final long multiplier = 25214903917L;
    private static volatile long seedGeneratorEndTime = 0;
    private static final long seedGeneratorStartTime;
    private static final Thread seedGeneratorThread;
    private static final BlockingQueue<byte[]> seedQueue;
    private static final long serialVersionUID = -5851777807851030925L;
    boolean initialized;
    private long pad0;
    private long pad1;
    private long pad2;
    private long pad3;
    private long pad4;
    private long pad5;
    private long pad6;
    private long pad7;
    private long rnd;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ThreadLocalRandom.class);
    private static final AtomicLong seedUniquifier = new AtomicLong();

    static {
        long j = SystemPropertyUtil.getLong("io.netty.initialSeedUniquifier", 0L);
        initialSeedUniquifier = j;
        if (j == 0) {
            Thread thread = new Thread("initialSeedUniquifierGenerator") { // from class: io.netty.util.internal.ThreadLocalRandom.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    byte[] bArrGenerateSeed = new SecureRandom().generateSeed(8);
                    long unused = ThreadLocalRandom.seedGeneratorEndTime = System.nanoTime();
                    ThreadLocalRandom.seedQueue.add(bArrGenerateSeed);
                }
            };
            seedGeneratorThread = thread;
            thread.setDaemon(true);
            seedGeneratorThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.netty.util.internal.ThreadLocalRandom.2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread2, Throwable th) {
                    ThreadLocalRandom.logger.debug("An exception has been raised by {}", thread2.getName(), th);
                }
            });
            seedQueue = new LinkedBlockingQueue();
            seedGeneratorStartTime = System.nanoTime();
            seedGeneratorThread.start();
            return;
        }
        seedGeneratorThread = null;
        seedQueue = null;
        seedGeneratorStartTime = 0L;
    }

    public static void setInitialSeedUniquifier(long j) {
        initialSeedUniquifier = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0081, code lost:
    
        r4 = (r13[7] & 255) | ((((((((r13[0] & 255) << 56) | ((r13[1] & 255) << 48)) | ((r13[2] & 255) << 40)) | ((r13[3] & 255) << 32)) | ((r13[4] & 255) << 24)) | ((r13[5] & 255) << 16)) | ((r13[6] & 255) << 8));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long getInitialSeedUniquifier() {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.ThreadLocalRandom.getInitialSeedUniquifier():long");
    }

    private static long newSeed() {
        long j;
        long initialSeedUniquifier2;
        long j2;
        do {
            j = seedUniquifier.get();
            initialSeedUniquifier2 = j != 0 ? j : getInitialSeedUniquifier();
            j2 = 181783497276652981L * initialSeedUniquifier2;
        } while (!seedUniquifier.compareAndSet(j, j2));
        if (j == 0 && logger.isDebugEnabled()) {
            if (seedGeneratorEndTime != 0) {
                logger.debug(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x (took %d ms)", Long.valueOf(initialSeedUniquifier2), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(seedGeneratorEndTime - seedGeneratorStartTime))));
            } else {
                logger.debug(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x", Long.valueOf(initialSeedUniquifier2)));
            }
        }
        return System.nanoTime() ^ j2;
    }

    ThreadLocalRandom() {
        super(newSeed());
        this.initialized = true;
    }

    public static ThreadLocalRandom current() {
        return InternalThreadLocalMap.get().random();
    }

    @Override // java.util.Random
    public final void setSeed(long j) {
        if (this.initialized) {
            throw new UnsupportedOperationException();
        }
        this.rnd = (j ^ multiplier) & mask;
    }

    @Override // java.util.Random
    protected final int next(int i) {
        this.rnd = ((this.rnd * multiplier) + 11) & mask;
        return (int) (this.rnd >>> (48 - i));
    }

    public final int nextInt(int i, int i2) {
        if (i >= i2) {
            throw new IllegalArgumentException();
        }
        return nextInt(i2 - i) + i;
    }

    public final long nextLong(long j) {
        long j2 = 0;
        if (j <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        while (j >= 2147483647L) {
            int next = next(2);
            long j3 = j >>> 1;
            if ((next & 2) != 0) {
                j3 = j - j3;
            }
            if ((next & 1) == 0) {
                j2 += j - j3;
            }
            j = j3;
        }
        return j2 + nextInt((int) j);
    }

    public final long nextLong(long j, long j2) {
        if (j >= j2) {
            throw new IllegalArgumentException();
        }
        return nextLong(j2 - j) + j;
    }

    public final double nextDouble(double d) {
        if (d <= 0.0d) {
            throw new IllegalArgumentException("n must be positive");
        }
        return nextDouble() * d;
    }

    public final double nextDouble(double d, double d2) {
        if (d >= d2) {
            throw new IllegalArgumentException();
        }
        return (nextDouble() * (d2 - d)) + d;
    }
}
