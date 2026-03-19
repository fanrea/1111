package com.fc.tjcpl.sdk.h;

import android.os.Handler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class h {
    public static h d;
    public final Map<String, e> c = Collections.synchronizedMap(new HashMap());
    public Handler b = new Handler();
    public Executor a = new ThreadPoolExecutor(1, 5, 0, TimeUnit.MILLISECONDS, new g());

    public static h a() {
        if (d == null) {
            synchronized (h.class) {
                if (d == null) {
                    d = new h();
                }
            }
        }
        return d;
    }

    public void a(b bVar, d dVar, j jVar) {
        e eVar = new e(bVar, dVar, jVar, this.b);
        String strA = bVar.a();
        if (this.c.get(strA) == null) {
            this.c.put(strA, eVar);
            this.a.execute(eVar);
        }
    }
}
