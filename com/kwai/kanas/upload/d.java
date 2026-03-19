package com.kwai.kanas.upload;

import android.os.SystemClock;
import com.kwai.kanas.a.b;
import com.kwai.kanas.a.c;
import com.kwai.kanas.upload.response.KanasLogResponse;
import com.kwai.kanas.vader.Channel;
import com.kwai.kanas.vader.persistent.LogRecord;
import com.kwai.middleware.azeroth.utils.Callback;
import com.kwai.middleware.azeroth.utils.Charsets;
import com.kwai.middleware.azeroth.utils.JsonUtils;
import java.util.List;
import java.util.concurrent.TimeoutException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class d implements com.kwai.kanas.vader.f.f {
    private final Channel a;

    public d(Channel channel) {
        this.a = channel;
    }

    @Override // com.kwai.kanas.vader.f.f
    public KanasLogResponse a(List<LogRecord> list, com.kwai.kanas.vader.f.g gVar) {
        try {
            c.a aVarA = a(list);
            if (aVarA.a.length == 0) {
                return null;
            }
            final a aVar = new a();
            final Object obj = new Object();
            com.kwai.kanas.upload.a.a().a(this.a, aVarA, gVar, KanasLogResponse.class, new Callback<KanasLogResponse>() { // from class: com.kwai.kanas.upload.d.1
                @Override // com.kwai.middleware.azeroth.utils.Callback
                public void onFailure(Throwable th) {
                    com.kwai.kanas.upload.a.a().a(th);
                    aVar.b = th;
                    synchronized (obj) {
                        obj.notify();
                    }
                }

                @Override // com.kwai.middleware.azeroth.utils.Callback
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(KanasLogResponse kanasLogResponse) {
                    aVar.a = kanasLogResponse;
                    synchronized (obj) {
                        obj.notify();
                    }
                }
            });
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            synchronized (obj) {
                obj.wait(15000L);
                if (aVar.b == null && SystemClock.elapsedRealtime() - jElapsedRealtime >= 15000) {
                    aVar.b = new TimeoutException("request ");
                }
            }
            KanasLogResponse kanasLogResponse = aVar.a;
            if (kanasLogResponse != null) {
                if (!kanasLogResponse.isDebugLoggerConfigEnable()) {
                    com.kwai.kanas.upload.a.a().e();
                }
                return kanasLogResponse;
            }
            if (aVar.b == null) {
                throw new NullPointerException("response is null");
            }
            throw aVar.b;
        } catch (Throwable th) {
            com.kwai.kanas.upload.a.a().a(th);
            return null;
        }
    }

    private c.a a(List<LogRecord> list) {
        c.a aVar = new c.a();
        aVar.a = new c.b[list.size()];
        for (int i = 0; i < list.size(); i++) {
            LogRecord logRecord = list.get(i);
            aVar.a[i] = (c.b) JsonUtils.fromJson(new String(logRecord.payload(), Charsets.UTF_8), c.b.class);
            if (aVar.a[i] == null) {
                aVar.a[i] = new c.b();
            }
            aVar.a[i].b = logRecord.seqId();
            aVar.a[i].a = logRecord.clientTimestamp();
            b.a aVar2 = new b.a();
            aVar2.a = a(logRecord.channelType());
            aVar2.b = logRecord.channelSeqId();
            aVar2.c = logRecord.customType();
            aVar2.d = logRecord.customSeqId();
            aVar.a[i].e.i = aVar2;
        }
        return aVar;
    }

    private int a(Channel channel) {
        if (channel == Channel.REAL_TIME) {
            return 1;
        }
        if (channel == Channel.HIGH_FREQ) {
            return 2;
        }
        return channel == Channel.NORMAL ? 3 : 0;
    }

    static class a {
        private KanasLogResponse a;
        private Throwable b;

        private a() {
        }
    }
}
