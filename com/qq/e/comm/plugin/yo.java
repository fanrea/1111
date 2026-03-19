package com.qq.e.comm.plugin;

import com.qq.e.comm.compliance.DownloadConfirmListener;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class yo implements qs {
    private final qs a;

    public yo(qs qsVar) {
        this.a = qsVar;
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ h4 b;

        c(String str, h4 h4Var) {
            this.a = str;
            this.b = h4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            yo.this.a.a(this.a, this.b);
        }
    }

    /* compiled from: A */
    class d implements Runnable {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            yo.this.a.b(this.a);
        }
    }

    /* compiled from: A */
    class e implements Runnable {
        final /* synthetic */ String a;

        e(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            yo.this.a.a(this.a);
        }
    }

    /* compiled from: A */
    class f implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ h4 b;

        f(String str, h4 h4Var) {
            this.a = str;
            this.b = h4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            yo.this.a.b(this.a, this.b);
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public boolean b(String str, h4 h4Var) {
        if (this.a == null) {
            return true;
        }
        xo.a((Runnable) new f(str, h4Var));
        return true;
    }

    /* compiled from: A */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            yo.this.a.i();
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public void i() {
        if (this.a != null) {
            xo.a((Runnable) new g());
        }
    }

    /* compiled from: A */
    class h implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ rs b;

        h(String str, rs rsVar) {
            this.a = str;
            this.b = rsVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            yo.this.a.a(this.a, this.b);
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public void b(String str) {
        if (this.a != null) {
            xo.a((Runnable) new d(str));
        }
    }

    /* compiled from: A */
    class i implements Runnable {
        final /* synthetic */ boolean a;

        i(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            yo.this.a.a(this.a);
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public void a(boolean z) {
        if (this.a != null) {
            xo.a((Runnable) new i(z));
        }
    }

    /* compiled from: A */
    class j implements Runnable {
        final /* synthetic */ l3 a;

        j(l3 l3Var) {
            this.a = l3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            yo.this.a.a(this.a);
        }
    }

    /* compiled from: A */
    class k implements Runnable {
        final /* synthetic */ h4 a;
        final /* synthetic */ DownloadConfirmListener b;
        final /* synthetic */ rs c;
        final /* synthetic */ int d;

        k(h4 h4Var, DownloadConfirmListener downloadConfirmListener, rs rsVar, int i) {
            this.a = h4Var;
            this.b = downloadConfirmListener;
            this.c = rsVar;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            yo.this.a.a(this.a, this.b, this.c, this.d);
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ h4 a;
        final /* synthetic */ rs b;

        a(h4 h4Var, rs rsVar) {
            this.a = h4Var;
            this.b = rsVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            yo.this.a.a(this.a, this.b);
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public m h() {
        return this.a.h();
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            yo.this.a.g();
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public void g() {
        if (this.a != null) {
            xo.a((Runnable) new b());
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public void a(String str) {
        if (this.a != null) {
            xo.a((Runnable) new e(str));
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public void a(l3 l3Var) {
        if (this.a != null) {
            xo.a((Runnable) new j(l3Var));
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public void a(h4 h4Var, DownloadConfirmListener downloadConfirmListener, rs rsVar, int i2) {
        if (this.a != null) {
            xo.a((Runnable) new k(h4Var, downloadConfirmListener, rsVar, i2));
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public void a(String str, h4 h4Var) {
        if (this.a != null) {
            xo.a((Runnable) new c(str, h4Var));
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public void a(String str, rs rsVar) {
        if (this.a != null) {
            xo.a((Runnable) new h(str, rsVar));
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public void a(h4 h4Var, rs rsVar) {
        if (this.a != null) {
            xo.a((Runnable) new a(h4Var, rsVar));
        }
    }
}
