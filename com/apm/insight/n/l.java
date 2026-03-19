package com.apm.insight.n;

import android.content.Context;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.t;
import com.bytedance.apm.common.utility.NetworkUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class l implements Runnable {
    private Context a;

    private l(Context context) {
        this.a = context;
    }

    public static void a(Context context) {
        a(context, 0);
    }

    public static void a(Context context, int i) {
        com.apm.insight.runtime.q.b().a(new l(context), i);
    }

    public static boolean a() {
        return c.a().c() || !com.apm.insight.o.a.b(com.apm.insight.g.f());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.apm.insight.b.g.e();
        } catch (Throwable unused) {
        }
        try {
            if (com.apm.insight.o.a.b(this.a)) {
                c.a().a(NetworkUtils.isNetworkAvailable(this.a));
            } else {
                NativeImpl.i();
            }
            t.a().a(com.apm.insight.g.a().b(), com.apm.insight.entity.b.b());
            if (com.apm.insight.runtime.q.b().a() == null || com.apm.insight.f.a() == null) {
            }
        } catch (Throwable th) {
            try {
                com.apm.insight.o.q.b(th);
            } finally {
                t.a().a(com.apm.insight.g.a().b(), com.apm.insight.entity.b.b());
                if (com.apm.insight.runtime.q.b().a() != null && com.apm.insight.f.a() != null) {
                    com.apm.insight.m.d.a(com.apm.insight.runtime.q.b().a(), this.a).a();
                }
            }
        }
    }
}
