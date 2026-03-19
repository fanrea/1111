package com.kwai.kanas.vader;

import android.content.Context;
import com.kwai.kanas.vader.f.i;
import com.kwai.kanas.vader.persistent.LogRecordDatabase;
import com.kwai.middleware.azeroth.interfaces.JsonAdapter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class d {
    public static final boolean a = true;
    private final ExecutorService b = c.a("vader");
    private final i c;
    private com.kwai.kanas.vader.a.a d;

    public d(final Context context, final i iVar, final String str) {
        this.c = iVar;
        a(new Runnable() { // from class: com.kwai.kanas.vader.d.1
            @Override // java.lang.Runnable
            public void run() {
                e eVar = new e(iVar, str);
                b bVarE = iVar.e();
                LogRecordDatabase logRecordDatabaseA = eVar.a(context);
                com.kwai.kanas.vader.persistent.e eVar2 = new com.kwai.kanas.vader.persistent.e(bVarE, logRecordDatabaseA);
                com.kwai.kanas.vader.e.e eVar3 = new com.kwai.kanas.vader.e.e(context, logRecordDatabaseA, bVarE);
                d.this.d = new com.kwai.kanas.vader.a.a(iVar, eVar2, eVar3, eVar.a(context, eVar2, eVar3), eVar.b(context, eVar2, eVar3), eVar.c(context, eVar2, eVar3));
            }
        });
    }

    public i a() {
        return this.c;
    }

    public void a(final JsonAdapter jsonAdapter, final Channel channel, final String str) {
        a(new Runnable() { // from class: com.kwai.kanas.vader.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.d.a(jsonAdapter, channel, str);
            }
        });
    }

    public boolean a(final JsonAdapter jsonAdapter, final Channel channel, final String str, final int i) {
        Boolean bool = (Boolean) a(a(new Callable<Boolean>() { // from class: com.kwai.kanas.vader.d.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() {
                Future<?> futureA = d.this.d.a(jsonAdapter, channel, str);
                if (futureA == null) {
                    return Boolean.FALSE;
                }
                return Boolean.valueOf(d.this.a(futureA, i) != null);
            }
        }), i);
        return bool != null && bool.booleanValue();
    }

    public void b() {
        a(new Runnable() { // from class: com.kwai.kanas.vader.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.d.a();
            }
        });
    }

    private void a(final Runnable runnable) {
        this.b.execute(new Runnable() { // from class: com.kwai.kanas.vader.d.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    d.this.c.e().a(e);
                }
            }
        });
    }

    private <V> Future<V> a(final Callable<V> callable) {
        return this.b.submit(new Callable<V>() { // from class: com.kwai.kanas.vader.d.6
            @Override // java.util.concurrent.Callable
            public V call() {
                try {
                    return (V) callable.call();
                } catch (Exception e) {
                    d.this.c.e().a(e);
                    return null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <V> V a(Future<V> future, int i) {
        try {
            return future.get(i, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            this.c.e().a(e);
            return null;
        }
    }
}
