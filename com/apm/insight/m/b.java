package com.apm.insight.m;

import android.content.Context;
import android.os.Handler;
import com.apm.insight.g;
import com.apm.insight.runtime.q;
import com.apm.insight.runtime.t;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b extends a {
    private static Runnable b = new Runnable() { // from class: com.apm.insight.m.b.1
        @Override // java.lang.Runnable
        public void run() {
            q.b().a().removeCallbacks(this);
            q.b().a(new b(q.b().a(), 0L, 30000L, g.f()));
        }
    };
    private Context a;

    public b(Handler handler, long j, long j2, Context context) {
        super(handler, j, j2);
        this.a = context;
    }

    public static void d() {
        q.b().a(b, 100L);
    }

    @Override // java.lang.Runnable
    public void run() {
        Map<String, Object> mapB;
        try {
            mapB = g.a().b();
        } catch (Throwable unused) {
            mapB = null;
        }
        try {
            t.a().a(mapB, com.apm.insight.entity.b.b());
        } catch (Throwable unused2) {
        }
    }
}
