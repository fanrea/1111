package com.pangrowth.adclog;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f1 {
    public static volatile Context f = null;
    public static volatile f1 g = null;
    public static i1 h = null;
    public static volatile boolean i = false;
    public static volatile String j = "";
    public static String k;
    public List<s1> b;
    public long e;
    public volatile HashMap<String, String> d = new HashMap<>();
    public Vector a = new Vector(10);
    public final ExecutorService c = (ExecutorService) AsyncTask.THREAD_POOL_EXECUTOR;

    public class a implements Runnable {
        public a(f1 f1Var) {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                s2.a(f1.f.getApplicationInfo().dataDir + File.separator + "dbFiles");
            } catch (Throwable unused) {
            }
        }
    }

    public f1() {
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(new y1());
        arrayList.add(new v1());
        arrayList.add(new h2());
        arrayList.add(new f2());
        arrayList.add(new i2());
        arrayList.add(new w1());
        arrayList.add(new g2());
        arrayList.add(new a2());
        arrayList.add(new u1());
        arrayList.add(new t1());
        arrayList.add(new d2());
        arrayList.add(new e2());
        arrayList.add(new z1());
        arrayList.add(new b2());
        arrayList.add(new x1());
        arrayList.add(new c2());
        this.b = Collections.unmodifiableList(arrayList);
        d();
        a();
        try {
            j = b().getAbsolutePath() + "/dump.hprof";
        } catch (Exception e) {
            e.printStackTrace();
        }
        m2.a().b();
    }

    public static File b() {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/monitor");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static f1 c() {
        if (g == null) {
            synchronized (f1.class) {
                if (g == null) {
                    if (!i) {
                        throw new RuntimeException("call CloudMessageManager.init() first");
                    }
                    g = new f1();
                }
            }
        }
        return g;
    }

    public final void a() {
        this.c.execute(new a(this));
    }

    public final void a(i1 i1Var) {
        if (i1Var != null) {
            for (s1 s1Var : this.b) {
                if (s1Var instanceof u1) {
                    ((u1) s1Var).b = i1Var;
                    return;
                }
            }
        }
    }

    public final void d() {
        i1 i1Var = h;
        if (i1Var != null) {
            a(i1Var);
            h = null;
        }
    }
}
