package com.kwai.kanas.vader.a;

import android.util.Log;
import com.kwai.kanas.vader.Channel;
import com.kwai.kanas.vader.b.b;
import com.kwai.kanas.vader.e.d;
import com.kwai.kanas.vader.f.i;
import com.kwai.kanas.vader.persistent.LogRecord;
import com.kwai.kanas.vader.persistent.a;
import com.kwai.kanas.vader.persistent.e;
import com.kwai.middleware.azeroth.interfaces.JsonAdapter;
import com.kwai.middleware.azeroth.utils.Charsets;
import com.kwai.middleware.azeroth.utils.JsonUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class a {
    private static final String a = "Assembler";
    private static final long b = 921600;
    private final Map<Channel, b> c = new HashMap();
    private final com.kwai.kanas.vader.b d;
    private final Random e;
    private final e f;
    private final com.kwai.kanas.vader.e.e g;
    private int h;

    public a(i iVar, e eVar, com.kwai.kanas.vader.e.e eVar2, b bVar, b bVar2, b bVar3) {
        this.d = iVar.e();
        this.c.put(Channel.REAL_TIME, bVar);
        this.c.put(Channel.HIGH_FREQ, bVar2);
        this.c.put(Channel.NORMAL, bVar3);
        this.e = new Random();
        this.g = eVar2;
        this.f = eVar;
        this.f.a();
        Iterator<b> it = this.c.values().iterator();
        while (it.hasNext()) {
            it.next().a(TimeUnit.SECONDS.toMillis(5L));
        }
    }

    public Future<?> a(JsonAdapter jsonAdapter, Channel channel, String str) {
        Future<?> futureA;
        LogRecord logRecordB = b(jsonAdapter, channel, str);
        long length = logRecordB.payload().length;
        if (length <= b) {
            futureA = this.f.a(new com.kwai.kanas.vader.persistent.a(logRecordB, a.EnumC0655a.Add));
        } else {
            Log.w(a, "Single log size too large: " + length + " > 500 KB. Not adding to database.");
            this.d.a("log_size_too_large", logRecordB.seqId() + ", " + logRecordB.customType() + ", " + logRecordB.customSeqId() + ", " + logRecordB.payload().length);
            futureA = null;
        }
        this.c.get(channel).a(logRecordB);
        return futureA;
    }

    public void a() {
        Iterator<b> it = this.c.values().iterator();
        while (it.hasNext()) {
            it.next().g();
        }
    }

    private LogRecord b(JsonAdapter jsonAdapter, Channel channel, String str) {
        d dVarA = this.g.a(channel, str);
        return new LogRecord(dVarA.a(), channel, dVarA.b(), str, dVarA.c(), System.currentTimeMillis(), JsonUtils.toJson(jsonAdapter).toString().getBytes(Charsets.UTF_8));
    }
}
