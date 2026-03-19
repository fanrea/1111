package com.kwai.kanas.vader.persistent;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.kwai.kanas.vader.Channel;
import com.kwai.kanas.vader.persistent.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class e {
    private static final String a = "LogPersistor";
    private static final int b = 10;
    private static final int c = 15;
    private final LinkedBlockingQueue<a> d = new LinkedBlockingQueue<>();
    private final ExecutorService e = com.kwai.kanas.vader.c.a("logPersistor");
    private final com.kwai.kanas.vader.b f;
    private LogRecordDatabase g;

    public e(com.kwai.kanas.vader.b bVar, LogRecordDatabase logRecordDatabase) {
        this.f = bVar;
        this.g = logRecordDatabase;
    }

    public synchronized Future<?> a() {
        return this.e.submit(new Runnable() { // from class: com.kwai.kanas.vader.persistent.e.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int iA = e.this.g.a().a(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(15L));
                    if (iA > 0) {
                        e.this.f.a("evict_logs", "Evicting total : " + iA + " logs.");
                    }
                } catch (Exception e) {
                    e.this.f.a(e);
                }
            }
        });
    }

    public synchronized Future<?> a(a aVar) {
        this.d.offer(aVar);
        return this.e.submit(new Runnable() { // from class: com.kwai.kanas.vader.persistent.e.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.c();
                } catch (Exception e) {
                    e.this.f.a(e);
                }
            }
        });
    }

    public synchronized Future<List<LogRecord>> a(final Channel channel, final int i, final int i2, final int i3) {
        this.d.offer(new a(new ArrayList(), a.EnumC0655a.Sentinel));
        return this.e.submit(new Callable<List<LogRecord>>() { // from class: com.kwai.kanas.vader.persistent.e.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<LogRecord> call() {
                e.this.c();
                return e.this.b(channel, i, i2, i3);
            }
        });
    }

    public synchronized Future<?> b() {
        return this.e.submit(new Runnable() { // from class: com.kwai.kanas.vader.persistent.e.4
            @Override // java.lang.Runnable
            public void run() {
                e.this.g.a().g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        while (true) {
            a aVarPoll = this.d.poll();
            if (aVarPoll == null || aVarPoll.b() == a.EnumC0655a.Sentinel) {
                return;
            }
            int i = 0;
            do {
                a aVarPeek = this.d.peek();
                if (aVarPeek == null || !aVarPoll.a(aVarPeek)) {
                    break;
                }
                this.d.poll();
                i++;
                b(aVarPoll);
            } while (i <= 10);
            b(aVarPoll);
        }
    }

    private void b(a aVar) {
        Log.d(a, "execute composed action : " + aVar.a().size() + " type : " + aVar.b());
        if (aVar.b() == a.EnumC0655a.Add) {
            c(aVar);
        } else if (aVar.b() == a.EnumC0655a.Delete) {
            d(aVar);
        } else {
            throw new IllegalArgumentException("Unknown DBAction type : " + aVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<LogRecord> b(Channel channel, int i, int i2, int i3) {
        try {
            return this.g.a().a(channel, i, i2, i3);
        } catch (SQLiteException e) {
            this.f.a(e);
            return new ArrayList();
        }
    }

    private void c(a aVar) {
        boolean z;
        try {
            this.g.a().a(aVar.a());
            z = false;
        } catch (SQLiteException e) {
            this.f.a(e);
            z = true;
        }
        if (z) {
            Iterator<LogRecord> it = aVar.a().iterator();
            while (it.hasNext()) {
                try {
                    this.g.a().a(it.next());
                } catch (SQLiteException e2) {
                    this.f.a(e2);
                }
            }
        }
    }

    private void d(a aVar) {
        boolean z;
        try {
            this.g.a().b(aVar.a());
            z = false;
        } catch (SQLiteException e) {
            this.f.a(e);
            z = true;
        }
        if (z) {
            Iterator<LogRecord> it = aVar.a().iterator();
            while (it.hasNext()) {
                try {
                    this.g.a().b(it.next());
                } catch (SQLiteException e2) {
                    this.f.a(e2);
                }
            }
        }
    }

    public void a(int i, TimeUnit timeUnit) throws InterruptedException {
        this.e.shutdown();
        this.e.awaitTermination(i, timeUnit);
    }
}
