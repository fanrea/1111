package com.qq.e.comm.plugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class n9 {
    private static final ExecutorService e = Executors.newFixedThreadPool(4);
    private final int a;
    private final String[] b;
    private final ExecutorService c;
    protected final int d;

    abstract o9 a(b bVar, String str, String str2, int i) throws Exception;

    public n9(String[] strArr, int i, int i2, ExecutorService executorService) {
        if (strArr != null && strArr.length > 1 && executorService == null) {
            executorService = e;
        }
        this.a = i;
        this.d = i2 <= 0 ? 8 : i2;
        this.b = strArr;
        this.c = executorService;
    }

    private o9 a(String str) throws Exception {
        return a(str, this.a);
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ b a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;
        final /* synthetic */ c e;

        a(b bVar, String str, String str2, int i, c cVar) {
            this.a = bVar;
            this.b = str;
            this.c = str2;
            this.d = i;
            this.e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() throws Exception {
            Exception exc;
            o9 o9VarA = null;
            try {
                exc = null;
                o9VarA = n9.this.a(this.a, this.b, this.c, this.d);
            } catch (Exception e) {
                exc = new Exception(e);
            }
            synchronized (this.e) {
                c cVar = this.e;
                int i = cVar.c + 1;
                cVar.c = i;
                if (cVar.a == null) {
                    cVar.a = o9VarA;
                }
                if (cVar.b == null) {
                    cVar.b = exc;
                }
                if (i == n9.this.b.length || this.e.a != null) {
                    this.e.notify();
                }
            }
        }
    }

    /* compiled from: A */
    private static class c {
        o9 a;
        Exception b;
        int c = 0;

        c() {
        }
    }

    private o9 a(String str, int i) throws Exception {
        String[] strArr = this.b;
        if (strArr != null && strArr.length != 0) {
            if (str != null && str.length() != 0) {
                b bVar = new b();
                String[] strArr2 = this.b;
                if (strArr2.length != 1 && this.c != null) {
                    c cVar = new c();
                    for (String str2 : this.b) {
                        this.c.submit(new a(bVar, str2, str, i, cVar));
                    }
                    synchronized (cVar) {
                        try {
                            cVar.wait(this.d * 1000);
                        } catch (InterruptedException unused) {
                        }
                    }
                    bVar.a();
                    Exception exc = cVar.b;
                    if (exc != null && cVar.a == null) {
                        throw exc;
                    }
                    return cVar.a;
                }
                o9 o9VarA = null;
                for (String str3 : strArr2) {
                    o9VarA = a(bVar, str3, str, i);
                    if (o9VarA != null) {
                        break;
                    }
                }
                return o9VarA;
            }
            throw new IOException("host can not empty");
        }
        throw new IOException("server can not empty");
    }

    /* compiled from: A */
    static class b {
        Queue<Runnable> a = new ConcurrentLinkedQueue();

        b() {
        }

        void a(Runnable runnable) {
            if (runnable != null) {
                this.a.offer(runnable);
            }
        }

        void a() {
            while (true) {
                Runnable runnablePoll = this.a.poll();
                if (runnablePoll == null) {
                    return;
                } else {
                    runnablePoll.run();
                }
            }
        }
    }

    public kv[] a(xa xaVar) throws Exception {
        o9 o9VarA = a(xaVar.a);
        if (o9VarA != null) {
            List<kv> listA = o9VarA.a();
            if (listA == null || listA.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (kv kvVar : listA) {
                if (kvVar.a() || kvVar.c() || kvVar.b() || kvVar.b == this.a) {
                    arrayList.add(kvVar);
                }
            }
            return (kv[]) arrayList.toArray(new kv[0]);
        }
        throw new IOException("response is null");
    }
}
