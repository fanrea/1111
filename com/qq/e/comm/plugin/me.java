package com.qq.e.comm.plugin;

import android.os.CountDownTimer;
import android.text.TextUtils;
import com.qq.e.comm.plugin.gb;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class me implements i40 {
    private static final int d = r1.d().f().a("ifsvmlt", 20000);
    private static volatile me e;
    private final Map<String, Set<c>> a = new ConcurrentHashMap();
    private final Map<String, CountDownTimer> b = new ConcurrentHashMap();
    private final Map<String, lj> c = new ConcurrentHashMap();

    /* compiled from: A */
    public interface c {
        void a();

        void a(int i, long j, long j2);

        void a(db dbVar);

        void a(String str);

        void a(boolean z);

        void b();

        void onCancel();
    }

    /* compiled from: A */
    public static class d implements c {
        @Override // com.qq.e.comm.plugin.me.c
        public void a() {
        }

        @Override // com.qq.e.comm.plugin.me.c
        public void a(int i, long j, long j2) {
        }

        @Override // com.qq.e.comm.plugin.me.c
        public void a(String str) {
        }

        @Override // com.qq.e.comm.plugin.me.c
        public void a(boolean z) {
        }
    }

    private me() {
    }

    /* compiled from: A */
    class a implements bb {
        private int a;
        private int b = -1;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ h4 e;

        a(String str, String str2, h4 h4Var) {
            this.c = str;
            this.d = str2;
            this.e = h4Var;
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.me$a$a, reason: collision with other inner class name */
        class RunnableC0714a implements Runnable {
            RunnableC0714a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Set set = (Set) me.this.a.get(a.this.c);
                if (set == null || set.size() <= 0) {
                    return;
                }
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a();
                }
            }
        }

        /* compiled from: A */
        class b implements Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ long b;
            final /* synthetic */ long c;

            b(int i, long j, long j2) {
                this.a = i;
                this.b = j;
                this.c = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Set set = (Set) me.this.a.get(a.this.c);
                if (set != null && set.size() > 0) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        ((c) it.next()).a(this.a, this.b, this.c);
                    }
                }
                a aVar = a.this;
                me.this.a(aVar.c);
            }
        }

        /* compiled from: A */
        class c implements Runnable {
            final /* synthetic */ File a;

            c(File file) {
                this.a = file;
            }

            @Override // java.lang.Runnable
            public void run() {
                Set<c> set = (Set) me.this.a.get(a.this.c);
                if (set != null && set.size() > 0) {
                    for (c cVar : set) {
                        File file = this.a;
                        cVar.a(file == null ? "" : file.getAbsolutePath());
                    }
                }
                me.this.a.remove(a.this.c);
            }
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) {
            xo.a((Runnable) new c(file));
            me.this.a(this.c);
            a40.a(j, this.a, this.d, f5.a(this.e));
        }

        /* compiled from: A */
        class d implements Runnable {
            final /* synthetic */ boolean a;

            d(boolean z) {
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Set set = (Set) me.this.a.get(a.this.c);
                if (set == null || set.size() <= 0) {
                    return;
                }
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a(this.a);
                }
            }
        }

        /* compiled from: A */
        class e implements Runnable {
            e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Set set = (Set) me.this.a.get(a.this.c);
                if (set != null && set.size() > 0) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        ((c) it.next()).onCancel();
                    }
                }
                me.this.a.remove(a.this.c);
            }
        }

        @Override // com.qq.e.comm.plugin.bb
        public void b() {
            xo.a((Runnable) new e());
            me.this.a(this.c);
        }

        /* compiled from: A */
        class f implements Runnable {
            final /* synthetic */ db a;

            f(db dbVar) {
                this.a = dbVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Set set = (Set) me.this.a.get(a.this.c);
                if (set != null && set.size() > 0) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        ((c) it.next()).a(this.a);
                    }
                }
                me.this.a.remove(a.this.c);
            }
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(long j, boolean z) {
            this.a = (int) (j >> 10);
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(db dbVar) {
            GDTLogger.w("视频下载失败, code: " + dbVar.a() + ", msg: " + dbVar.b(), null);
            xo.a((Runnable) new f(dbVar));
            me.this.a(this.c);
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a() {
            xo.a((Runnable) new RunnableC0714a());
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(long j, long j2, int i) {
            xo.a((Runnable) new b(i, j, j2));
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(boolean z) {
            xo.a((Runnable) new d(z));
        }
    }

    private lj c(h4 h4Var) {
        String strS0 = h4Var.S0();
        if (strS0 == null) {
            return new es();
        }
        lj ljVar = this.c.get(strS0);
        if (ljVar != null) {
            return ljVar;
        }
        w5 w5Var = new w5(h4Var, this);
        this.c.put(strS0, w5Var);
        return w5Var;
    }

    public boolean d(h4 h4Var) {
        return c(h4Var).f();
    }

    public void f(h4 h4Var) {
        lj ljVar = this.c.get(b(h4Var));
        if (ljVar != null) {
            ljVar.g();
        }
    }

    public void e(h4 h4Var) {
        lj ljVar = this.c.get(b(h4Var));
        if (ljVar != null) {
            ljVar.e();
        }
    }

    public void g(h4 h4Var) {
        lj ljVar = this.c.get(b(h4Var));
        if (ljVar != null) {
            ljVar.d();
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ h4 c;

        b(String str, int i, h4 h4Var) {
            this.a = str;
            this.b = i;
            this.c = h4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((CountDownTimer) me.this.b.get(this.a)) == null) {
                long j = this.b;
                me.this.b.put(this.a, new a(j, j).start());
            }
        }

        /* compiled from: A */
        class a extends CountDownTimer {
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            a(long j, long j2) {
                super(j, j2);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                le.e(b.this.c);
                Set set = (Set) me.this.a.get(b.this.a);
                if (set == null || set.size() <= 0) {
                    return;
                }
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).b();
                }
            }
        }
    }

    private String b(h4 h4Var) {
        if (h4Var == null) {
            return "";
        }
        if (h4Var.S0() == null) {
            return h4Var.V0() == null ? "" : h4Var.V0();
        }
        return h4Var.S0();
    }

    public void a(h4 h4Var, mh mhVar) {
        String strB = b(h4Var);
        lj ljVarRemove = this.c.remove(strB);
        if (ljVarRemove != null) {
            ljVarRemove.a(mhVar);
        }
        this.a.remove(strB);
    }

    private void a(h4 h4Var) {
        String strS0 = h4Var.S0();
        if (strS0 == null) {
            return;
        }
        this.c.put(strS0, new es());
    }

    public void a(String str, String str2, c cVar, h4 h4Var, boolean z) {
        String str3;
        double dC;
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("下载视频失败，videoUrl为空");
            return;
        }
        boolean z2 = !TextUtils.isEmpty(str2);
        if (!z2) {
            a(h4Var);
        } else if (z) {
            if (v5.a(h4Var.K())) {
                return;
            } else {
                a(h4Var);
            }
        } else {
            lj ljVarC = c(h4Var);
            String strB = ljVarC.b();
            dC = ljVarC.c();
            str3 = strB;
            a(str, z2, cVar, h4Var, dC, str3);
        }
        dC = 1.0d;
        str3 = "";
        a(str, z2, cVar, h4Var, dC, str3);
    }

    private void a(String str, boolean z, c cVar, h4 h4Var, double d2, String str2) {
        gb.b bVar = new gb.b();
        bVar.a(d2);
        String strB = b(h4Var);
        a(!z ? d : d * 2, strB, h4Var);
        if (cVar != null) {
            Set<c> hashSet = this.a.get(strB);
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            hashSet.add(cVar);
            this.a.put(strB, hashSet);
        }
        fb.a().a(bVar.d(str).a(f40.b(str)).a(gu.o()).d(!z).c(str2).a(f5.a(h4Var)).a(), new a(strB, str, h4Var));
    }

    public void a(h4 h4Var, int i, j40 j40Var) {
        lj ljVar;
        String strS0 = h4Var.S0();
        if (strS0 == null || (ljVar = this.c.get(strS0)) == null) {
            return;
        }
        ljVar.a(i, j40Var);
    }

    public void a(h4 h4Var, int i, int i2, int i3) {
        lj ljVar;
        String strS0 = h4Var.S0();
        if (strS0 == null || (ljVar = this.c.get(strS0)) == null) {
            return;
        }
        ljVar.a(i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        CountDownTimer countDownTimer;
        Map<String, CountDownTimer> map = this.b;
        if (map == null || (countDownTimer = map.get(str)) == null) {
            return;
        }
        countDownTimer.cancel();
        this.b.remove(str);
    }

    @Override // com.qq.e.comm.plugin.i40
    public void a(lj ljVar, double d2) {
        a(ljVar.a().V0(), true, null, ljVar.a(), d2, ljVar.b());
    }

    public static me a() {
        if (e == null) {
            synchronized (me.class) {
                if (e == null) {
                    e = new me();
                }
            }
        }
        return e;
    }

    private void a(int i, String str, h4 h4Var) {
        xo.a((Runnable) new b(str, i, h4Var));
    }
}
