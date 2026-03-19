package lkxssdk.f0;

import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a<T> extends b<T> {
    @Override // java.util.Queue
    public boolean offer(T t) {
        return a((a<T>) t);
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public T remove() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            T tB = b();
            if (tB != null) {
                return tB;
            }
            throw new NoSuchElementException();
        } finally {
            reentrantLock.unlock();
        }
    }
}
