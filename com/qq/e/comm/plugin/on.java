package com.qq.e.comm.plugin;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.plugin.callback.biz.JumpOutBizCallback;
import com.qq.e.comm.plugin.s3;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class on {
    private static final long a = r1.d().f().a("cabt", 2000);
    private static final long b = r1.d().f().a("caft", 30000);
    private static final Map<c, Runnable> c = new ConcurrentHashMap();
    private static final Map<c, Runnable> d = new ConcurrentHashMap();

    public static boolean a(c cVar) {
        long j = a;
        if (j < 0) {
            return false;
        }
        s3 s3VarB = s3.b();
        Context contextA = r1.d().a();
        f5 f5VarA = cVar.a();
        b10.a(1200200, f5VarA, Integer.valueOf(cVar.b()), 0, null);
        if (!s3VarB.c() && !pa.d(contextA)) {
            b10.a(1200200, f5VarA, Integer.valueOf(cVar.b()), 1, null);
            return false;
        }
        s3VarB.a(cVar);
        if (j == 0) {
            return true;
        }
        a aVar = new a(cVar, s3VarB, contextA, f5VarA);
        c.put(cVar, aVar);
        xo.a(aVar, j);
        return true;
    }

    /* compiled from: A */
    public static class c implements s3.g {
        protected final int a;
        protected final f5 b;
        private final String c;

        public c(int i, f5 f5Var) {
            h4 h4VarA;
            this.a = i;
            this.b = f5Var;
            if (f5Var != null && (h4VarA = f5Var.a()) != null) {
                this.c = h4VarA.s0();
            } else {
                this.c = null;
            }
        }

        @Override // com.qq.e.comm.plugin.s3.g
        public boolean h() {
            xo.e((Runnable) on.c.remove(this));
            if (TextUtils.isEmpty(this.c)) {
                return true;
            }
            ((JumpOutBizCallback) x5.b(this.c, JumpOutBizCallback.class)).h().b(Integer.valueOf(this.a));
            return true;
        }

        @Override // com.qq.e.comm.plugin.s3.g
        public boolean d() {
            if (TextUtils.isEmpty(this.c)) {
                return true;
            }
            ((JumpOutBizCallback) x5.b(this.c, JumpOutBizCallback.class)).d().b(Integer.valueOf(this.a));
            return true;
        }

        public void c() {
            if (TextUtils.isEmpty(this.c)) {
                return;
            }
            ((JumpOutBizCallback) x5.b(this.c, JumpOutBizCallback.class)).x().b(Integer.valueOf(this.a));
        }

        public void e() {
            if (TextUtils.isEmpty(this.c)) {
                return;
            }
            ((JumpOutBizCallback) x5.b(this.c, JumpOutBizCallback.class)).a0().b(Integer.valueOf(this.a));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int b() {
            return this.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public f5 a() {
            return this.b;
        }
    }

    /* compiled from: A */
    public static class b extends c {
        protected final long d;
        private long e;

        public b(int i, f5 f5Var) {
            super(i, f5Var);
            this.d = SystemClock.elapsedRealtime();
        }

        @Override // com.qq.e.comm.plugin.on.c, com.qq.e.comm.plugin.s3.g
        public boolean d() {
            super.d();
            xo.e((Runnable) on.d.remove(this));
            if (this.e <= 0) {
                return true;
            }
            b10.a(4002028, new nn(this.b).a(SystemClock.elapsedRealtime() - this.e), Integer.valueOf(this.a));
            return true;
        }

        @Override // com.qq.e.comm.plugin.on.c, com.qq.e.comm.plugin.s3.g
        public boolean h() {
            super.h();
            this.e = SystemClock.elapsedRealtime();
            b10.a(4002027, new nn(this.b).a(this.e - this.d), Integer.valueOf(this.a));
            if (on.b <= 0) {
                return false;
            }
            a aVar = new a();
            on.d.put(this, aVar);
            xo.a(aVar, on.b);
            return false;
        }

        /* compiled from: A */
        class a implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                on.d.remove(b.this);
                if (s3.b().d(b.this)) {
                    if (pa.d(r1.d().a())) {
                        b.this.d();
                        b bVar = b.this;
                        b10.a(1200200, bVar.b, Integer.valueOf(bVar.a), 4, null);
                    } else {
                        b.this.e();
                        b bVar2 = b.this;
                        b10.a(1200200, bVar2.b, Integer.valueOf(bVar2.a), 5, null);
                    }
                }
            }

            a() {
            }
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ c a;
        final /* synthetic */ s3 b;
        final /* synthetic */ Context c;
        final /* synthetic */ f5 d;

        a(c cVar, s3 s3Var, Context context, f5 f5Var) {
            this.a = cVar;
            this.b = s3Var;
            this.c = context;
            this.d = f5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            on.c.remove(this.a);
            if (this.b.b(this.a)) {
                if (!pa.d(this.c)) {
                    boolean zH = this.a.h();
                    b10.a(1200200, this.d, Integer.valueOf(this.a.b()), 2, null);
                    if (!zH) {
                        return;
                    }
                } else {
                    this.a.c();
                    b10.a(1200200, this.d, Integer.valueOf(this.a.b()), 3, null);
                }
                this.b.d(this.a);
            }
        }
    }
}
