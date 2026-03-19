package com.kwad.sdk.glide.load.engine.a;

import com.kwad.sdk.utils.ax;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class c {
    private final Map<String, a> bVh = new HashMap();
    private final b bVi = new b();

    c() {
    }

    final void hk(String str) {
        a aVarAhe;
        synchronized (this) {
            aVarAhe = this.bVh.get(str);
            if (aVarAhe == null) {
                aVarAhe = this.bVi.ahe();
                this.bVh.put(str, aVarAhe);
            }
            aVarAhe.bVk++;
        }
        aVarAhe.bVj.lock();
    }

    final void hl(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) ax.checkNotNull(this.bVh.get(str));
            if (aVar.bVk <= 0) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.bVk);
            }
            aVar.bVk--;
            if (aVar.bVk == 0) {
                a aVarRemove = this.bVh.remove(str);
                if (!aVarRemove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVarRemove + ", safeKey: " + str);
                }
                this.bVi.a(aVarRemove);
            }
        }
        aVar.bVj.unlock();
    }

    static class a {
        final Lock bVj = new ReentrantLock();
        int bVk;

        a() {
        }
    }

    static class b {
        private final Queue<a> bVl = new ArrayDeque();

        b() {
        }

        final a ahe() {
            a aVarPoll;
            synchronized (this.bVl) {
                aVarPoll = this.bVl.poll();
            }
            return aVarPoll == null ? new a() : aVarPoll;
        }

        final void a(a aVar) {
            synchronized (this.bVl) {
                if (this.bVl.size() < 10) {
                    this.bVl.offer(aVar);
                }
            }
        }
    }
}
