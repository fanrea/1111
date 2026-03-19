package com.kwai.kanas.vader.b;

import android.util.Log;
import com.kwai.kanas.upload.response.KanasLogResponse;
import com.kwai.kanas.vader.Channel;
import com.kwai.kanas.vader.f.f;
import com.kwai.kanas.vader.f.g;
import com.kwai.kanas.vader.f.h;
import com.kwai.kanas.vader.persistent.LogRecord;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class a {
    static final int a = 500;
    private static int i;
    private static int j;
    final f b;
    final com.kwai.kanas.vader.b c;
    final ScheduledExecutorService d;
    final Channel e;
    final String f;
    volatile long g;
    volatile boolean h = false;
    private final e k = new e(TimeUnit.SECONDS.toMillis(1));

    abstract void a(List<LogRecord> list, h hVar);

    abstract void b(long j2);

    abstract List<LogRecord> c();

    abstract boolean d();

    abstract g e();

    a(Channel channel, com.kwai.kanas.vader.b bVar, f fVar, String str, ScheduledExecutorService scheduledExecutorService, long j2) {
        this.e = channel;
        this.f = "LogChannel_" + channel.name() + "(" + str + ")";
        this.c = bVar;
        this.d = scheduledExecutorService;
        this.b = fVar;
        this.g = j2;
    }

    public static int a() {
        return i;
    }

    public static int b() {
        return j;
    }

    public void a(long j2) {
        if (this.h) {
            throw new IllegalStateException("Shouldn't start LogDataChannel twice.");
        }
        this.h = true;
        b(j2);
    }

    void f() {
        List<LogRecord> listC = c();
        h hVarA = a(listC);
        a(listC, hVarA);
        if (d()) {
            return;
        }
        b(hVarA.b());
    }

    private h a(List<LogRecord> list) {
        if (list.isEmpty()) {
            Log.d(this.f, "No logs to send, mark as success.");
            return h.a(true, this.g);
        }
        h hVarB = b(list);
        Log.d(this.f, "Log upload success ? " + hVarB.a());
        i = i + 1;
        if (hVarB.a()) {
            this.k.a();
            return hVarB;
        }
        j++;
        this.k.b();
        Log.d(this.f, "Schedule retry after : " + this.k.c());
        return h.a(hVarB.a(), this.k.c());
    }

    private h b(List<LogRecord> list) {
        try {
            Log.d(this.f, "Upload logs. Count : " + list.size());
            KanasLogResponse kanasLogResponseA = this.b.a(list, e());
            if (kanasLogResponseA != null) {
                Log.d(this.f, "LogResponse.nextInterval: " + kanasLogResponseA.getNextRequestPeriodInMs());
                if (kanasLogResponseA.getNextRequestPeriodInMs() >= 0) {
                    this.g = kanasLogResponseA.getNextRequestPeriodInMs();
                }
                return h.a(true, this.g);
            }
        } catch (Exception e) {
            this.c.a(e);
        }
        return h.a(false, this.g);
    }

    public final void a(int i2, TimeUnit timeUnit) {
        this.d.shutdown();
        this.d.awaitTermination(i2, timeUnit);
    }
}
