package lkxssdk.e0;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class f {
    public final d a;
    public Executor b;
    public Executor c;
    public final Map<String, String> e = Collections.synchronizedMap(new HashMap());
    public final Map<String, ReentrantLock> f = new WeakHashMap();
    public final AtomicBoolean g = new AtomicBoolean(false);
    public final Object h = new Object();
    public Executor d = lkxssdk.a.a.c();

    public f(d dVar) {
        this.a = dVar;
        this.b = dVar.a;
        this.c = dVar.b;
    }

    public ReentrantLock a(String str) {
        ReentrantLock reentrantLock = this.f.get(str);
        if (reentrantLock != null) {
            return reentrantLock;
        }
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.f.put(str, reentrantLock2);
        return reentrantLock2;
    }

    public void a(lkxssdk.d0.a aVar) {
        this.e.remove(aVar.getId() + "");
    }

    public void a(lkxssdk.d0.a aVar, String str) {
        this.e.put(aVar.getId() + "", str);
    }
}
