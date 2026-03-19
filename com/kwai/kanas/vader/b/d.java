package com.kwai.kanas.vader.b;

import android.util.Log;
import com.kwai.kanas.vader.persistent.LogRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class d {
    private final com.kwai.kanas.vader.b a;
    private final com.kwai.kanas.vader.persistent.e b;

    d(com.kwai.kanas.vader.b bVar, com.kwai.kanas.vader.persistent.e eVar) {
        this.a = bVar;
        this.b = eVar;
    }

    final boolean a(List<LogRecord> list, com.kwai.kanas.vader.f.e eVar) throws ExecutionException, InterruptedException, TimeoutException {
        Exception e;
        List<LogRecord> list2;
        String strName = eVar.a().name();
        boolean z = false;
        if (list.size() < 500) {
            int size = 500 - list.size();
            Future<List<LogRecord>> futureA = this.b.a(eVar.a(), eVar.b(), eVar.c(), size);
            ArrayList arrayList = new ArrayList();
            try {
                list2 = futureA.get(1L, TimeUnit.SECONDS);
            } catch (TimeoutException unused) {
                list2 = arrayList;
            } catch (Exception e2) {
                e = e2;
                list2 = arrayList;
            }
            try {
                Log.d(strName, "Get additional from database: " + list2.size());
                if (list2.size() < size) {
                    z = true;
                }
            } catch (TimeoutException unused2) {
            } catch (Exception e3) {
                e = e3;
                Log.d(strName, "Get additional from database: ", e);
                this.a.a(e);
            }
            list.addAll(list2);
        }
        return z;
    }
}
