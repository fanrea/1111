package com.qq.e.comm.plugin;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.qq.e.comm.plugin.f20;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.ss.ttm.player.MediaPlayer;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class z3 implements x3, f20.b, os {
    private final y3 b;
    private final f20.c c;
    private h4 d;
    private boolean e;
    private boolean f;
    private final ns a = new ns();
    private final long g = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;

    @Override // com.qq.e.comm.plugin.f20.b
    public void f() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_DYNAMIC_THREAD_PRIORITY_VALUE, 0, this);
    }

    public z3(y3 y3Var) {
        this.b = y3Var;
        f20.c cVar = new f20.c(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 500L);
        this.c = cVar;
        cVar.a(this);
    }

    /* compiled from: A */
    class a extends ms<i6> {
        a(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(i6 i6Var) {
            z3.this.b();
        }
    }

    /* compiled from: A */
    class b extends ms<Void> {
        b(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) {
            z3.this.b();
        }
    }

    /* compiled from: A */
    class c extends ms<Void> {
        c(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) {
            z3.this.b();
        }
    }

    private String c() {
        l3 l3VarO;
        h4 h4Var = this.d;
        return (h4Var == null || (l3VarO = h4Var.o()) == null) ? "应用" : l3VarO.a();
    }

    /* compiled from: A */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (z3.this.k()) {
                return;
            }
            z3 z3Var = z3.this;
            z3Var.a(z3Var.d.s0());
        }
    }

    @Override // com.qq.e.comm.plugin.x3
    public void a() {
        b();
        b10.a(1100930, f5.a(this.d));
    }

    @Override // com.qq.e.comm.plugin.os
    public ns i() {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.os
    public boolean k() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.c.h();
        this.b.destroy();
    }

    @Override // com.qq.e.comm.plugin.f20.b
    public void a(long j) {
        this.b.a(b(j));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(long r4) {
        /*
            r3 = this;
            com.qq.e.comm.plugin.h4 r0 = r3.d
            if (r0 == 0) goto L24
            com.qq.e.comm.plugin.l3 r0 = r0.o()
            if (r0 == 0) goto L24
            int r1 = r0.j()
            boolean r1 = com.qq.e.comm.plugin.h10.f(r1)
            if (r1 == 0) goto L17
            java.lang.String r0 = "打开"
            goto L26
        L17:
            int r0 = r0.j()
            boolean r0 = com.qq.e.comm.plugin.h10.d(r0)
            if (r0 == 0) goto L24
            java.lang.String r0 = "安装"
            goto L26
        L24:
            java.lang.String r0 = "下载"
        L26:
            r1 = 999(0x3e7, double:4.936E-321)
            long r4 = r4 + r1
            r1 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r1
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r5 = r3.c()
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            r1[r2] = r4
            r4 = 1
            r1[r4] = r0
            r4 = 2
            r1[r4] = r5
            java.lang.String r4 = "%s 秒后为您%s“%s”"
            java.lang.String r4 = java.lang.String.format(r4, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.z3.b(long):java.lang.String");
    }

    @Override // com.qq.e.comm.plugin.x3
    public void a(boolean z) {
        if (k()) {
            return;
        }
        if (z) {
            if (this.e) {
                this.c.f();
            } else {
                this.c.g();
            }
            this.e = false;
            return;
        }
        this.c.e();
        this.e = true;
    }

    private void b(h4 h4Var) {
        FSCallback fSCallback = (FSCallback) x5.b(h4Var.s0(), FSCallback.class);
        if (fSCallback == null) {
            return;
        }
        fSCallback.Y().a(new a(this));
        fSCallback.w().a(new b(this));
        fSCallback.p().a(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        i6 i6Var = new i6(this.d);
        i6Var.h = 8;
        ((FSCallback) x5.b(str, FSCallback.class)).Y().b(i6Var);
        b();
    }

    @Override // com.qq.e.comm.plugin.x3
    public void a(h4 h4Var) {
        if (h4Var == null) {
            return;
        }
        this.d = h4Var;
        long jW0 = h4Var.W0() * 1000;
        long jA = (dx.a(this.d) * 1000) + ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        l3 l3VarO = this.d.o();
        if (jW0 >= jA && l3VarO != null) {
            if (h10.e(l3VarO.j())) {
                b();
                return;
            }
            this.b.a();
            this.b.a(b(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT));
            b(this.d);
            return;
        }
        b();
    }
}
