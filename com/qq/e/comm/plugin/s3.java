package com.qq.e.comm.plugin;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class s3 {
    private Context a;
    private final List<g> b;
    private int c;
    private volatile int d;
    private volatile Activity e;
    private final Application.ActivityLifecycleCallbacks f;
    private volatile boolean g;
    private volatile int h;

    /* compiled from: A */
    static class f {
        static int a = -1;
        static int b = 0;
        static int c = 1;
    }

    /* compiled from: A */
    public interface g {
        boolean d();

        boolean h();
    }

    /* compiled from: A */
    private static class h {
        private static final s3 a = new s3(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Activity activity) {
    }

    private s3() {
        this.h = -1;
        this.b = new ArrayList();
        this.d = f.a;
        this.f = new a();
    }

    /* compiled from: A */
    class a implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            s3.this.a("onActivityCreated", activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            s3.this.a("onActivityStarted", activity);
            int i = s3.this.c;
            s3.this.c = activity != null ? activity.hashCode() : i;
            if (i == 0) {
                s3.this.e();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            s3.this.a("onActivityResumed", activity);
            s3.this.e = activity;
            int i = s3.this.c;
            if (activity != null) {
                s3.this.c = activity.hashCode();
            }
            if (i == 0) {
                s3.this.e();
            }
            if (s3.this.h >= 0 || s3.this.e == null || s3.this.e.getIntent() == null) {
                return;
            }
            s3 s3Var = s3.this;
            s3Var.h = s3Var.e.getIntent().getSourceBounds() == null ? 0 : 1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            s3.this.a("onActivityPaused", activity);
            if (s3.this.c != 0 || activity == null) {
                return;
            }
            s3.this.c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            s3.this.a("onActivityStopped", activity);
            if (s3.this.e == activity) {
                s3.this.e = null;
            }
            if (activity == null || activity.hashCode() != s3.this.c) {
                return;
            }
            s3.this.c = 0;
            s3.this.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            s3.this.a("onActivityDestroyed", activity);
        }
    }

    /* synthetic */ s3(a aVar) {
        this();
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ g a;

        b(g gVar) {
            this.a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (s3.this.b.contains(this.a)) {
                return;
            }
            s3.this.b.add(this.a);
        }
    }

    public boolean c() {
        if (this.d == f.a) {
            if (pa.d(this.a)) {
                this.d = f.c;
            } else {
                this.d = f.b;
            }
        }
        return this.d == f.c;
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ g a;

        c(g gVar) {
            this.a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            s3.this.b.remove(this.a);
        }
    }

    /* compiled from: A */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = s3.this.b.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                s3.this.g = true;
                if (gVar.d()) {
                    it.remove();
                }
                s3.this.g = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.d = f.c;
        xo.b(new d());
    }

    /* compiled from: A */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = s3.this.b.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                s3.this.g = true;
                if (gVar.h()) {
                    it.remove();
                }
                s3.this.g = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.d = f.b;
        xo.b(new e());
    }

    public void a(g gVar) {
        if (gVar == null) {
            return;
        }
        b bVar = new b(gVar);
        if (this.g) {
            xo.a((Runnable) bVar);
        } else {
            xo.b(bVar);
        }
    }

    public boolean b(g gVar) {
        if (gVar == null) {
            return false;
        }
        return this.b.contains(gVar);
    }

    public static s3 b() {
        return h.a;
    }

    public void c(g gVar) {
        if (gVar == null) {
            return;
        }
        c cVar = new c(gVar);
        if (this.g) {
            xo.a((Runnable) cVar);
        } else {
            xo.b(cVar);
        }
    }

    public boolean d(g gVar) {
        if (gVar == null) {
            return false;
        }
        return this.b.remove(gVar);
    }

    public Activity a() {
        return this.e;
    }

    public void a(Context context) {
        this.a = context;
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this.f);
        }
    }
}
