package lkxssdk.e0;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a implements ThreadFactory {
    public static final AtomicInteger a = new AtomicInteger(1);
    public final String d;
    public final int e;
    public final AtomicInteger c = new AtomicInteger(1);
    public final ThreadGroup b = Thread.currentThread().getThreadGroup();

    public a(int i, String str) {
        this.e = i;
        this.d = str + a.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.b, runnable, this.d + this.c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        thread.setPriority(this.e);
        return thread;
    }
}
