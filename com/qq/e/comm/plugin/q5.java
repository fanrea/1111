package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.callback.biz.DialogStateCallback;
import com.qq.e.comm.plugin.callback.biz.LifecycleCallback;
import com.qq.e.comm.plugin.callback.biz.TimerStateCallback;
import com.qq.e.comm.plugin.f20;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class q5 implements os {
    private int b;
    private final f20.c c;
    private final ns a = new ns();
    private boolean d = false;

    /* compiled from: A */
    static /* synthetic */ class g {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LifecycleCallback.a.values().length];
            a = iArr;
            try {
                iArr[LifecycleCallback.a.PAUSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LifecycleCallback.a.RESUMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    q5(h4 h4Var, e20 e20Var) {
        f20.c cVar = new f20.c(9999000L, 500L);
        this.c = cVar;
        cVar.a(new a(e20Var));
        a(h4Var, cVar);
        cVar.g();
    }

    /* compiled from: A */
    class a implements f20.b {
        final /* synthetic */ e20 a;

        @Override // com.qq.e.comm.plugin.f20.b
        public void f() {
        }

        a(e20 e20Var) {
            this.a = e20Var;
        }

        @Override // com.qq.e.comm.plugin.f20.b
        public void a(long j) {
            this.a.a(q5.this.c.a());
        }
    }

    /* compiled from: A */
    class b extends ms<LifecycleCallback.a> {
        b(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(LifecycleCallback.a aVar) {
            if (aVar == null) {
                return;
            }
            int i = g.a[aVar.ordinal()];
            if (i == 1) {
                q5.this.b();
            } else {
                if (i != 2) {
                    return;
                }
                q5.this.c();
            }
        }
    }

    void a() {
        this.c.h();
        this.c.a((f20.b) null);
        this.d = true;
    }

    /* compiled from: A */
    class c extends ms<Integer> {
        c(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            q5.this.b();
        }
    }

    /* compiled from: A */
    class d extends ms<Integer> {
        d(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            q5.this.c();
        }
    }

    /* compiled from: A */
    class e extends ms<Void> {
        e(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) {
            q5.this.b();
        }
    }

    /* compiled from: A */
    class f extends ms<Void> {
        f(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) {
            q5.this.c();
        }
    }

    private void a(h4 h4Var, f20.c cVar) {
        ((LifecycleCallback) x5.b(h4Var.s0(), LifecycleCallback.class)).I().a(new b(this));
        DialogStateCallback dialogStateCallback = (DialogStateCallback) x5.b(h4Var.s0(), DialogStateCallback.class);
        dialogStateCallback.j().a(new c(this));
        dialogStateCallback.i().a(new d(this));
        TimerStateCallback timerStateCallback = (TimerStateCallback) x5.b(h4Var.s0(), TimerStateCallback.class);
        timerStateCallback.onPause().a(new e(this));
        timerStateCallback.onResume().a(new f(this));
    }

    @Override // com.qq.e.comm.plugin.os
    public ns i() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i = this.b;
        if (i > 0) {
            this.b = i - 1;
        }
        if (this.b == 0) {
            this.c.f();
        }
    }

    @Override // com.qq.e.comm.plugin.os
    public boolean k() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.b++;
        this.c.e();
    }
}
