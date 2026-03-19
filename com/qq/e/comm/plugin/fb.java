package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.plugin.cb;
import com.qq.e.comm.plugin.hb;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class fb implements hb.b {
    private static volatile fb h;
    private final cb b;
    private final cb c;
    private final ExecutorService g;
    private final Map<String, File> d = new ConcurrentHashMap();
    private final List<String> e = new CopyOnWriteArrayList();
    private final Map<String, Pair<String, Long>> f = new ConcurrentHashMap();
    private final Map<String, hb> a = new ConcurrentHashMap();

    private void a(gb gbVar) throws IllegalArgumentException {
    }

    private fb() {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(15, new a());
        this.b = new cb.b().a(executorServiceNewFixedThreadPool).b(10000).a(10000).a();
        this.c = new cb.b().a(executorServiceNewFixedThreadPool).b(10000).a(10000).a(false).a();
        this.g = Executors.newSingleThreadExecutor(new b());
    }

    /* compiled from: A */
    class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_DOWNLOAD_THREAD");
        }

        a() {
        }
    }

    /* compiled from: A */
    class b implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_DOWNLOAD_THREAD");
        }

        b() {
        }
    }

    /* compiled from: A */
    class c implements hb.a {
        final /* synthetic */ gb a;

        c(gb gbVar) {
            this.a = gbVar;
        }

        @Override // com.qq.e.comm.plugin.hb.a
        public void a(File file) {
            fb.this.a(this.a.g(), file);
        }
    }

    public boolean f(String str) {
        hb hbVar = this.a.get(b(str));
        return hbVar != null && hbVar.b();
    }

    private String b(String str) {
        if (str != null) {
            return String.valueOf(str.hashCode());
        }
        throw new NullPointerException("Tag can't be null!");
    }

    @Override // com.qq.e.comm.plugin.hb.b
    public void a(String str) {
        this.a.remove(str);
    }

    public File d(String str) {
        return this.d.get(str);
    }

    public Pair<String, Long> c(String str) {
        return this.f.get(str);
    }

    public boolean e(String str) {
        return this.e.contains(str);
    }

    /* compiled from: A */
    static class d implements bb, h7 {
        private final bb a;
        private final List<String> b;
        private final Map<String, Pair<String, Long>> c;
        private final String d;

        d(bb bbVar, List<String> list, Map<String, Pair<String, Long>> map, gb gbVar) {
            this.a = bbVar;
            this.b = list;
            this.c = map;
            this.d = gbVar.e();
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) {
            bb bbVar = this.a;
            if (bbVar != null) {
                bbVar.a(file, j);
            }
        }

        @Override // com.qq.e.comm.plugin.bb
        public void b() {
            bb bbVar = this.a;
            if (bbVar != null) {
                bbVar.b();
            }
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(long j, boolean z) {
            bb bbVar = this.a;
            if (bbVar != null) {
                bbVar.a(j, z);
            }
        }

        @Override // com.qq.e.comm.plugin.h7
        public void a(String str, long j) {
            this.c.put(this.d, new Pair<>(str, Long.valueOf(j)));
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(db dbVar) {
            bb bbVar = this.a;
            if (bbVar != null) {
                bbVar.a(dbVar);
            }
            this.b.add(this.d);
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(boolean z) {
            bb bbVar = this.a;
            if (bbVar != null) {
                bbVar.a(z);
            }
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(long j, long j2, int i) {
            bb bbVar = this.a;
            if (bbVar != null) {
                bbVar.a(j, j2, i);
            }
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a() {
            bb bbVar = this.a;
            if (bbVar != null) {
                bbVar.a();
            }
        }
    }

    void a(String str, File file) {
        this.d.put(str, file);
    }

    public void a(gb gbVar, bb bbVar) {
        a(gbVar);
        if (TextUtils.isEmpty(gbVar.g())) {
            if (bbVar != null) {
                bbVar.a(new db(4, "UrlIsEmpty"));
                return;
            }
            return;
        }
        if (gbVar.c() < 1.0d) {
            b10.a(1400011, gbVar.a(), Integer.valueOf((int) (gbVar.c() * 100.0d)));
        }
        d dVar = new d(bbVar, this.e, this.f, gbVar);
        String strB = b(gbVar.e());
        hb hbVar = this.a.get(strB);
        if (hbVar != null) {
            if (hbVar.b()) {
                if (gbVar.c() > hbVar.a().c()) {
                    hbVar.a(gbVar.c());
                }
                hbVar.a(dVar);
                return;
            }
            return;
        }
        hb hbVar2 = new hb(strB, gbVar, dVar, gbVar.h() ? this.b : this.c);
        hbVar2.a(this);
        hbVar2.a(new c(gbVar));
        this.a.put(strB, hbVar2);
        if (this.e.contains(gbVar.g())) {
            this.e.remove(gbVar.g());
        }
        a(hbVar2, gbVar.j());
    }

    private void a(hb hbVar, boolean z) {
        if (z) {
            this.g.submit(hbVar);
        } else {
            qg.b.submit(hbVar);
        }
    }

    public static fb a() {
        if (h == null) {
            synchronized (fb.class) {
                if (h == null) {
                    h = new fb();
                }
            }
        }
        return h;
    }
}
