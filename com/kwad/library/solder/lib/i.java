package com.kwad.library.solder.lib;

import android.content.Context;
import android.util.Log;
import com.kwad.library.solder.lib.a.f;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.ext.c;
import com.kwad.sdk.utils.bx;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i {
    private static volatile i bij;
    private static Map<String, Integer> bil = new ConcurrentHashMap(8);
    private static a bim;
    private e bik;
    private volatile boolean mHasInit = false;

    public interface a {
        boolean Pr();

        void b(String str, File file);

        void f(String str, Throwable th);

        int getCorePoolSize();

        int getMaxRetryCount();
    }

    private i() {
    }

    public static i Po() {
        if (bij == null) {
            synchronized (i.class) {
                if (bij == null) {
                    bij = new i();
                }
            }
        }
        return bij;
    }

    private static ExecutorService dP(int i) {
        return new ThreadPoolExecutor(i, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.library.solder.lib.i.1
            private final AtomicInteger bin = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                try {
                    String name = thread.getName();
                    thread.setName(name + "-");
                    i.bil.put(name, 1);
                } catch (Throwable th) {
                    com.kwad.library.solder.lib.a.e("Sodler", Log.getStackTraceString(th));
                }
                return thread;
            }
        });
    }

    public static boolean cT(String str) {
        try {
            Map<String, Integer> map = bil;
            if (map != null) {
                return map.containsKey(str);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(a aVar) {
        bim = aVar;
    }

    private synchronized void init(Context context) {
        if (this.mHasInit) {
            return;
        }
        c.a aVarDb = new c.a().db("sodler");
        a aVar = bim;
        c.a aVarCm = aVarDb.dS(aVar != null ? aVar.getMaxRetryCount() : 1).cm(false);
        a aVar2 = bim;
        c.a aVarCn = aVarCm.cn(aVar2 != null && aVar2.Pr());
        a aVar3 = bim;
        c.a aVarA = aVarCn.a(dP(aVar3 != null ? aVar3.getCorePoolSize() : 0));
        a aVar4 = bim;
        com.kwad.library.solder.lib.ext.c cVarPU = aVarA.dT(aVar4 != null ? aVar4.getCorePoolSize() : 0).PU();
        d dVar = new d(context);
        c cVar = new c(context, cVarPU);
        f fVar = new f(context);
        fVar.a(new f.a() { // from class: com.kwad.library.solder.lib.i.2
            @Override // com.kwad.library.solder.lib.a.f.a
            public final void a(com.kwad.library.solder.lib.a.e eVar, File file) throws PluginError.UpdateError {
                if (i.bim != null) {
                    try {
                        i.bim.b(eVar.getDownloadUrl(), file);
                    } catch (Throwable th) {
                        i.bim.f(eVar.getDownloadUrl(), th);
                        throw new PluginError.UpdateError(th.getMessage(), PluginError.ERROR_UPD_PLUGIN_CONNECTION);
                    }
                }
            }
        });
        this.bik = new e(dVar, fVar, cVar, cVarPU, new com.kwad.library.solder.lib.ext.a());
        this.mHasInit = true;
    }

    public final <P extends com.kwad.library.solder.lib.a.a, R extends com.kwad.library.solder.lib.a.e<P>> void a(Context context, R r, com.kwad.library.solder.lib.ext.b<P, R> bVar) {
        init(context);
        r.dR(this.bik.Pi().getRetryCount());
        r.a(new b<P, R>(bVar, new b.C0565b()) { // from class: com.kwad.library.solder.lib.i.3
            /* JADX WARN: Incorrect types in method signature: (TR;Lcom/kwad/library/solder/lib/ext/PluginError;)V */
            @Override // com.kwad.library.solder.lib.b, com.kwad.library.solder.lib.ext.b
            public final void a(final com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
                super.a((AnonymousClass3<P, R>) eVar, pluginError);
                com.kwad.library.solder.lib.a.e("Sodler", "load failed:" + pluginError.getCode() + ":" + pluginError.getMessage());
                i.this.bik.i(eVar);
                bx.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.library.solder.lib.i.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (eVar.Py()) {
                            i.this.bik.a(eVar, 16);
                        }
                    }
                }, eVar.Px() instanceof PluginError.UpdateError ? 1000L : 0L);
            }
        });
        this.bik.a(r, 16);
    }

    public final com.kwad.library.solder.lib.a.a s(Context context, String str) {
        if (!this.mHasInit && context != null) {
            init(context);
        }
        e eVar = this.bik;
        if (eVar != null) {
            return eVar.Pj().cR(str);
        }
        return null;
    }

    public final com.kwad.library.solder.lib.ext.c Pi() {
        if (!this.mHasInit) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return this.bik.Pi();
    }

    public final void r(Context context, final String str) {
        if (!this.mHasInit && context != null) {
            init(context);
        }
        if (Pi() == null || Pi().PS() == null) {
            return;
        }
        Pi().PS().execute(new Runnable() { // from class: com.kwad.library.solder.lib.i.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    i.this.bik.Pl().cP(str);
                } catch (Throwable th) {
                    Log.getStackTraceString(th);
                }
            }
        });
    }
}
