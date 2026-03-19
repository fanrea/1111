package com.qq.e.comm.plugin;

import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ao {
    private long a;
    private long b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private boolean h;
    private boolean i;
    private final WeakReference<View> j;
    private final f5 k;

    public ao(View view, f5 f5Var) {
        this.j = new WeakReference<>(view);
        this.k = f5Var;
    }

    public void d() {
        if (this.i) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.b = jCurrentTimeMillis;
        if (this.a == 0) {
            this.a = jCurrentTimeMillis;
        }
    }

    public void b() {
        if (this.i) {
            return;
        }
        this.c += System.currentTimeMillis() - this.b;
    }

    public void c() {
        if (this.i) {
            return;
        }
        this.d = System.currentTimeMillis();
    }

    public void a(boolean z) {
        if (this.i) {
            return;
        }
        if (z) {
            this.h = false;
        }
        if (this.h) {
            return;
        }
        this.g += System.currentTimeMillis() - this.f;
        View view = this.j.get();
        if (view != null) {
            view.post(new a());
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ao aoVar = ao.this;
            aoVar.a(aoVar.k);
        }
    }

    public void b(boolean z) {
        if (this.i || this.h) {
            return;
        }
        this.f = System.currentTimeMillis();
        if (z) {
            this.h = true;
        }
    }

    public void a() {
        if (this.i) {
            return;
        }
        this.e += System.currentTimeMillis() - this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f5 f5Var) {
        if (this.i || this.a == 0) {
            return;
        }
        this.i = true;
        v8.a(2230111, System.currentTimeMillis() - this.a, a50.d, f5Var);
        v8.a(2230112, this.c, a50.d, f5Var);
        v8.a(2230113, this.e, a50.d, f5Var);
        v8.a(2230114, this.g, a50.d, f5Var);
    }
}
