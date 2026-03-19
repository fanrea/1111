package com.kwai.kanas.vader.b;

import android.content.Context;
import android.util.Log;
import com.kwai.kanas.vader.Channel;
import com.kwai.kanas.vader.f.f;
import com.kwai.kanas.vader.f.g;
import com.kwai.kanas.vader.f.h;
import com.kwai.kanas.vader.persistent.LogRecord;
import com.kwai.kanas.vader.persistent.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class b extends a {
    private static final int i = 500;
    private final int j;
    private final Object k;
    private final com.kwai.kanas.vader.c.a<LogRecord> l;
    private final com.kwai.kanas.vader.persistent.e m;
    private final d n;
    private ScheduledFuture<?> o;
    private boolean p;

    private void c(long j) {
    }

    public b(Context context, Channel channel, com.kwai.kanas.vader.b bVar, f fVar, com.kwai.kanas.vader.persistent.e eVar, com.kwai.kanas.vader.e.e eVar2, long j) {
        super(channel, bVar, fVar, "NORMAL", com.kwai.kanas.vader.c.b("LogChannel_" + channel.name()), j);
        this.k = new Object();
        this.m = eVar;
        this.l = com.kwai.kanas.vader.c.a.a(2000);
        this.n = new d(bVar, eVar);
        this.o = this.d.schedule(new Runnable() { // from class: com.kwai.kanas.vader.b.b.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, 0L, TimeUnit.MILLISECONDS);
        this.j = eVar2.a(channel);
    }

    public void a(LogRecord logRecord) {
        synchronized (this.k) {
            this.l.add(logRecord);
            if (this.o.isDone()) {
                b(this.g);
            }
        }
    }

    public void g() {
        synchronized (this.k) {
            if (this.o.isDone()) {
                b(0L);
            } else if (this.o.cancel(false) && this.o.getDelay(TimeUnit.MILLISECONDS) > 0) {
                b(0L);
            }
        }
    }

    @Override // com.kwai.kanas.vader.b.a
    List<LogRecord> c() {
        ArrayList arrayList;
        synchronized (this.k) {
            Log.d(this.f, "Copy evictingQueue. Size : " + this.l.size());
            arrayList = new ArrayList(Math.min(500, this.l.size()));
            a((List<LogRecord>) arrayList);
        }
        this.p = this.n.a(arrayList, i());
        return arrayList;
    }

    @Override // com.kwai.kanas.vader.b.a
    boolean d() {
        boolean z;
        synchronized (this.k) {
            z = this.l.size() == 0 && this.p;
            if (z) {
                Log.d(this.f, "There's more data, schedule next uploading");
            } else {
                Log.d(this.f, "No more data, stop scheduling");
            }
        }
        return z;
    }

    @Override // com.kwai.kanas.vader.b.a
    void a(List<LogRecord> list, h hVar) {
        if (hVar.a()) {
            synchronized (this.k) {
                Log.d(this.f, "EvictingQueue remove logs. Count : " + list.size());
                this.l.removeAll(list);
            }
            Log.d(this.f, "Schedule delete DBAction");
            this.m.a(new com.kwai.kanas.vader.persistent.a(list, a.EnumC0655a.Delete));
        }
    }

    @Override // com.kwai.kanas.vader.b.a
    void b(long j) {
        synchronized (this.k) {
            Log.d(this.f, "Schedule a log sending");
            this.o = this.d.schedule(new Runnable() { // from class: com.kwai.kanas.vader.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.f();
                }
            }, j, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.kwai.kanas.vader.b.a
    g e() {
        return g.a(false);
    }

    private void a(List<LogRecord> list) {
        int iMax = Math.max(0, this.l.size() - 500);
        Iterator<LogRecord> it = this.l.iterator();
        for (int i2 = 0; i2 < iMax; i2++) {
            it.next();
        }
        while (it.hasNext()) {
            list.add(it.next());
        }
    }

    private int h() {
        int iChannelSeqId;
        synchronized (this.k) {
            LogRecord logRecordPeek = this.l.peek();
            iChannelSeqId = logRecordPeek == null ? Integer.MAX_VALUE : logRecordPeek.channelSeqId();
        }
        return iChannelSeqId;
    }

    private com.kwai.kanas.vader.f.e i() {
        return com.kwai.kanas.vader.f.e.a(this.e, this.j + 1, h());
    }
}
