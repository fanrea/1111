package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.h4;
import com.qq.e.comm.plugin.nv;
import com.qq.e.comm.plugin.qo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class g1<T extends h4> {
    public static final String o = "g1";
    private static final ConcurrentHashMap<String, g1> p = new ConcurrentHashMap<>();
    private final qo a;
    private final nv b;
    private final e2 c;
    private boolean g;
    private int h;
    private JSONObject k;
    private j l;
    private final AtomicBoolean d = new AtomicBoolean();
    private final AtomicBoolean e = new AtomicBoolean();
    private final AtomicBoolean f = new AtomicBoolean();
    private int i = -1;
    private final ConcurrentHashMap<Integer, g1<T>.k> j = new ConcurrentHashMap<>();
    private zj m = null;
    private boolean n = false;

    /* compiled from: A */
    public interface h<T extends h4> {
        T a(JSONObject jSONObject);

        void a(eo eoVar);

        void a(T t);
    }

    /* compiled from: A */
    public static abstract class i<T extends h4> implements h<T> {
        @Override // com.qq.e.comm.plugin.g1.h
        public final void a(T t) {
        }

        public abstract void a(List<T> list);
    }

    /* compiled from: A */
    public interface j {
        void a(List<JSONObject> list);
    }

    /* compiled from: A */
    private class k {
        private int a;

        private k(int i) {
            this.a = i;
        }

        /* synthetic */ k(g1 g1Var, int i, a aVar) {
            this(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            int i = this.a;
            return i == 2 || i == 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            return this.a == 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            int i = this.a;
            return i == 4 || i == 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d() {
            return this.a == 7;
        }
    }

    private g1(String str, f5 f5Var, e2 e2Var) {
        this.a = new qo(str, f5Var, e2Var);
        this.b = new nv(str);
        this.c = e2Var;
        this.g = r1.d().f().a("prldadis", str, 0) == 0;
    }

    /* compiled from: A */
    class a implements qo.f {
        final /* synthetic */ qo.f a;
        final /* synthetic */ f5 b;

        a(qo.f fVar, f5 f5Var) {
            this.a = fVar;
            this.b = f5Var;
        }

        @Override // com.qq.e.comm.plugin.qo.f
        public void a(w1 w1Var, com.qq.e.comm.plugin.j jVar, int i) {
            String str = g1.o;
            qo.f fVar = this.a;
            if (fVar != null) {
                fVar.a(w1Var, jVar, i);
            }
            if (g1.this.a.a(g1.this.k)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(g1.this.k);
                g1.this.l.a(arrayList);
                g1.this.k = null;
            }
            g1.this.e.set(false);
            if (g1.this.f.compareAndSet(true, false)) {
                g1.this.b(w1Var, jVar, this.b);
            }
        }
    }

    /* compiled from: A */
    class b implements zj {
        final /* synthetic */ w1 a;
        final /* synthetic */ f5 b;
        final /* synthetic */ com.qq.e.comm.plugin.j c;

        b(w1 w1Var, f5 f5Var, com.qq.e.comm.plugin.j jVar) {
            this.a = w1Var;
            this.b = f5Var;
            this.c = jVar;
        }

        @Override // com.qq.e.comm.plugin.zj
        public void a(boolean z, JSONObject jSONObject) {
            g1.this.n = jSONObject.optInt("disable", 0) == 1;
            if (z && !g1.this.n) {
                int iOptInt = jSONObject.optInt("ltimes", -1);
                int iOptInt2 = jSONObject.optInt("lcnt", -1);
                if (iOptInt > 0 && iOptInt2 > 0) {
                    this.a.b(iOptInt2);
                    b10.a(1407023, this.b, Integer.valueOf(iOptInt), Integer.valueOf(iOptInt2), null);
                    g1.this.a(this.a, this.c, this.b, new AtomicInteger(iOptInt), true);
                    return;
                }
            }
            g1.this.c(this.a, this.c, this.b);
        }

        @Override // com.qq.e.comm.plugin.zj
        public void a(int i) {
            g1.this.c(this.a, this.c, this.b);
        }
    }

    /* compiled from: A */
    class c implements qo.d {
        final /* synthetic */ int a;
        final /* synthetic */ w1 b;
        final /* synthetic */ h c;
        final /* synthetic */ ja d;
        final /* synthetic */ f5 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ int g;
        final /* synthetic */ eo h;

        c(int i, w1 w1Var, h hVar, ja jaVar, f5 f5Var, boolean z, int i2, eo eoVar) {
            this.a = i;
            this.b = w1Var;
            this.c = hVar;
            this.d = jaVar;
            this.e = f5Var;
            this.f = z;
            this.g = i2;
            this.h = eoVar;
        }

        @Override // com.qq.e.comm.plugin.qo.d
        public void b(jw jwVar) throws JSONException {
            int iMin;
            if (!g1.this.a(Integer.valueOf(this.a)).b()) {
                f1.a(this.b, g1.this.c, 7);
                return;
            }
            g1.this.a(Integer.valueOf(this.a), 4);
            jwVar.a(System.currentTimeMillis());
            String str = g1.o;
            h4 h4VarA = this.c.a(jwVar.b());
            h4VarA.c(true);
            this.d.a("data", Integer.valueOf(h4VarA.e0()));
            this.d.a("data2", Integer.valueOf(h4VarA.t1() ? 1 : 0));
            hl.a(h4VarA);
            int iU = h4VarA.U();
            if (iU > 0) {
                iMin = Math.min(iU, g1.this.a.e() - 1);
                g1.this.a(2, h4VarA, iU == iMin ? 0 : 1);
            } else {
                iMin = 0;
            }
            for (int i = 0; i < iMin; i++) {
                g1 g1Var = g1.this;
                g1Var.a((g1) h4VarA, (h<g1>) this.c, g1Var.a.a(this.b).b(), i);
            }
            g1.this.a(this.b, (w1) h4VarA);
            g1.this.a((h<h>) this.c, (h) h4VarA, (eo) null, Integer.valueOf(this.a), this.b);
            y9.c(this.e, g1.this.h, this.d);
            if (this.f) {
                b10.a(1407020, this.e, 0, this.d);
            }
            y9.a(this.e, this.g, this.d);
            wt wtVarB = new wt(2301004).b(((System.currentTimeMillis() - h4VarA.d()) / 1000) / 60).b(3);
            wtVarB.a(this.e);
            b10.a(wtVarB);
        }

        @Override // com.qq.e.comm.plugin.qo.d
        public void a(jw jwVar) {
            if (!this.f || g1.this.a(Integer.valueOf(this.a)).d()) {
                g1.this.a(Integer.valueOf(this.a), 3);
                String str = g1.o;
                y9.a(this.e, g1.this.h, jwVar, this.d);
                if (this.f) {
                    b10.a(1407019, this.e, 0, this.d);
                }
                g1.this.a((h<h>) this.c, (h) null, this.h, Integer.valueOf(this.a), this.b);
                return;
            }
            g1.this.a(Integer.valueOf(this.a), 3);
            f1.a(this.b, g1.this.c, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(w1 w1Var, com.qq.e.comm.plugin.j jVar, f5 f5Var) {
        if (this.a.a(false)) {
            return;
        }
        w1Var.b(this.h);
        a(w1Var, jVar, f5Var, new AtomicInteger(1), false);
    }

    /* compiled from: A */
    class d implements nv.b {
        final /* synthetic */ int a;
        final /* synthetic */ boolean b;
        final /* synthetic */ AtomicInteger c;
        final /* synthetic */ f5 d;
        final /* synthetic */ w1 e;
        final /* synthetic */ com.qq.e.comm.plugin.j f;

        d(int i, boolean z, AtomicInteger atomicInteger, f5 f5Var, w1 w1Var, com.qq.e.comm.plugin.j jVar) {
            this.a = i;
            this.b = z;
            this.c = atomicInteger;
            this.d = f5Var;
            this.e = w1Var;
            this.f = jVar;
        }

        @Override // com.qq.e.comm.plugin.nv.b
        public void a(e1 e1Var) {
            int size = e1Var.a().size();
            String str = g1.o;
            if (size > 0) {
                if (this.b) {
                    g1.this.a.a(e1Var, this.c.get() == 1);
                } else {
                    g1.this.a.a(e1Var);
                }
            }
            g1.this.d.set(false);
            if (size > 0 && g1.this.l != null) {
                g1.this.l.a(e1Var.a());
            }
            b10.a(1407021, this.d, 1, Integer.valueOf(size), null);
            if (this.c.decrementAndGet() > 0) {
                g1.this.a(this.e, this.f, this.d, this.c, this.b);
            }
        }

        @Override // com.qq.e.comm.plugin.nv.b
        public void a(eo eoVar) {
            if (this.b) {
                g1.this.a.a(new e1(new CopyOnWriteArrayList()), true);
            }
            g1.this.d.set(false);
            String str = g1.o;
            b10.a(1407021, this.d, 2, Integer.valueOf(eoVar != null ? eoVar.a() : 0), null);
        }
    }

    /* compiled from: A */
    class e implements Runnable {
        final /* synthetic */ h a;
        final /* synthetic */ w1 b;
        final /* synthetic */ List c;
        final /* synthetic */ eo d;

        e(h hVar, w1 w1Var, List list, eo eoVar) {
            this.a = hVar;
            this.b = w1Var;
            this.c = list;
            this.d = eoVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (this.a == null) {
                String str = g1.o;
                f1.a(this.b, g1.this.c, 2);
                return;
            }
            List list = this.c;
            if (list != null && !list.isEmpty()) {
                h hVar = this.a;
                if (hVar instanceof i) {
                    ((i) hVar).a(this.c);
                } else {
                    hVar.a((h) this.c.get(0));
                }
                f1.c(this.b, g1.this.c);
                return;
            }
            this.a.a(this.d);
            f1.a(this.b, g1.this.c);
        }
    }

    /* compiled from: A */
    class f implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ w1 b;
        final /* synthetic */ h c;
        final /* synthetic */ f5 d;

        f(int i, w1 w1Var, h hVar, f5 f5Var) {
            this.a = i;
            this.b = w1Var;
            this.c = hVar;
            this.d = f5Var;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            String str = g1.o;
            if (g1.this.a()) {
                g1.this.a(this.b, this.c, this.d, true, 1, new eo("No Ad Error", 5004), this.a);
            }
        }
    }

    public void c() {
        this.a.f();
    }

    /* compiled from: A */
    class g implements nv.b {
        final /* synthetic */ Runnable a;
        final /* synthetic */ int b;
        final /* synthetic */ w1 c;
        final /* synthetic */ h d;
        final /* synthetic */ f5 e;
        final /* synthetic */ int f;
        final /* synthetic */ boolean g;
        final /* synthetic */ boolean h;
        final /* synthetic */ com.qq.e.comm.plugin.j i;

        g(Runnable runnable, int i, w1 w1Var, h hVar, f5 f5Var, int i2, boolean z, boolean z2, com.qq.e.comm.plugin.j jVar) {
            this.a = runnable;
            this.b = i;
            this.c = w1Var;
            this.d = hVar;
            this.e = f5Var;
            this.f = i2;
            this.g = z;
            this.h = z2;
            this.i = jVar;
        }

        @Override // com.qq.e.comm.plugin.nv.b
        public void a(e1 e1Var) throws JSONException {
            int iMin;
            h4 h4VarA;
            String str = g1.o;
            CopyOnWriteArrayList<JSONObject> copyOnWriteArrayListA = e1Var.a();
            int i = 0;
            JSONObject jSONObject = !copyOnWriteArrayListA.isEmpty() ? copyOnWriteArrayListA.get(0) : null;
            Runnable runnable = this.a;
            if (runnable != null) {
                xo.e(runnable);
            }
            if (g1.this.a(Integer.valueOf(this.b)).c()) {
                if (jSONObject == null) {
                    f1.a(this.c, g1.this.c, 3);
                    return;
                } else {
                    g1.this.a.b(jSONObject);
                    f1.a(this.c, g1.this.c, 4);
                    return;
                }
            }
            if (jSONObject != null) {
                g1.this.a(Integer.valueOf(this.b), 5);
                h4 h4VarA2 = this.d.a(jSONObject);
                g1.this.a(this.c, (w1) h4VarA2);
                int size = copyOnWriteArrayListA.size();
                if ((this.d instanceof i) && size > 1) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(h4VarA2);
                    for (int i2 = 1; i2 < size; i2++) {
                        JSONObject jSONObject2 = copyOnWriteArrayListA.get(i2);
                        if (jSONObject2 != null && (h4VarA = this.d.a(jSONObject2)) != null) {
                            arrayList.add(h4VarA);
                            g1.this.a(this.c, (w1) h4VarA);
                        }
                    }
                    g1.this.a(this.d, arrayList, (eo) null, Integer.valueOf(this.b), this.c);
                } else {
                    int iU = h4VarA2.U();
                    if (iU > 0) {
                        iMin = Math.min(iU, copyOnWriteArrayListA.size() - 1);
                        g1.this.a(1, h4VarA2, iU == iMin ? 0 : 1);
                    } else {
                        iMin = 0;
                    }
                    while (i < iMin) {
                        int i3 = i + 1;
                        g1.this.a((g1) h4VarA2, (h<g1>) this.d, copyOnWriteArrayListA.get(i3), i);
                        i = i3;
                    }
                    g1.this.a((h<h>) this.d, (h) h4VarA2, (eo) null, Integer.valueOf(this.b), this.c);
                }
                y9.a(this.e, g1.this.g, this.f, this.g, g1.this.a.e(), this.h);
                if (h4VarA2 == null || !g1.this.g || this.g || this.h || !p1.a(h4VarA2)) {
                    return;
                }
                g1.this.b(this.c, this.i, this.e);
                return;
            }
            a(new eo("json error", 5000));
        }

        @Override // com.qq.e.comm.plugin.nv.b
        public void a(eo eoVar) throws JSONException {
            String str = g1.o;
            Runnable runnable = this.a;
            if (runnable != null) {
                xo.e(runnable);
            }
            k kVarA = g1.this.a(Integer.valueOf(this.b));
            if (kVarA.c()) {
                f1.a(this.c, g1.this.c, 5);
                return;
            }
            if (!kVarA.b()) {
                if (!kVarA.a() || !g1.this.a()) {
                    g1.this.a(Integer.valueOf(this.b), 6);
                    g1.this.a((h<h>) this.d, (h) null, eoVar, Integer.valueOf(this.b), this.c);
                    return;
                } else {
                    g1.this.a(this.c, this.d, this.e, false, 3, eoVar, this.b);
                    return;
                }
            }
            g1.this.a(Integer.valueOf(this.b), 7);
            f1.a(this.c, g1.this.c, 6);
        }
    }

    private boolean b() {
        return !this.a.c();
    }

    public void b(w1 w1Var, com.qq.e.comm.plugin.j jVar, f5 f5Var) {
        if (this.g) {
            if (this.e.get()) {
                this.f.set(true);
            } else {
                if (a(w1Var, jVar, f5Var)) {
                    return;
                }
                c(w1Var, jVar, f5Var);
            }
        }
    }

    public g1<T> b(int i2) {
        int iC = xb.c(this.c);
        if (iC > 0) {
            i2 = iC;
        }
        this.i = i2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        qo qoVar;
        return this.g && (qoVar = this.a) != null && qoVar.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h<T> hVar, T t, eo eoVar, Integer num, w1 w1Var) {
        ArrayList arrayList;
        if (t != null) {
            arrayList = new ArrayList(1);
            arrayList.add(t);
        } else {
            arrayList = null;
        }
        a(hVar, arrayList, eoVar, num, w1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h<T> hVar, List<T> list, eo eoVar, Integer num, w1 w1Var) {
        if (this.j.remove(num) == null) {
            f1.a(w1Var, this.c, 1);
        } else {
            xo.a((Runnable) new e(hVar, w1Var, list, eoVar));
        }
    }

    public void a(w1 w1Var, com.qq.e.comm.plugin.j jVar, f5 f5Var, h<T> hVar) {
        w1Var.a(System.currentTimeMillis());
        f1.b(w1Var, this.c);
        c();
        a(w1Var, jVar, hVar, f5Var);
    }

    void a(w1 w1Var, h<T> hVar, f5 f5Var, boolean z, int i2, eo eoVar, int i3) throws JSONException {
        a(Integer.valueOf(i3), 2);
        ja jaVar = new ja();
        jaVar.a("du", Integer.valueOf(this.i));
        y9.b(f5Var, this.h, jaVar);
        this.a.a(w1Var, new c(i3, w1Var, hVar, jaVar, f5Var, z, i2, eoVar));
    }

    private void a(w1 w1Var, com.qq.e.comm.plugin.j jVar, h<T> hVar, f5 f5Var) {
        f fVar;
        int i2 = this.i;
        boolean zA = a();
        int iA = ks.a();
        a(Integer.valueOf(iA), 1);
        boolean z = w1Var.d() > 1 && (hVar instanceof i);
        if (!this.g || i2 <= 0 || (!(zA || b()) || z)) {
            fVar = null;
        } else {
            f fVar2 = new f(iA, w1Var, hVar, f5Var);
            xo.a(fVar2, i2);
            fVar = fVar2;
        }
        this.b.a(w1Var, jVar, new g(fVar, iA, w1Var, hVar, f5Var, i2, zA, z, jVar), f5Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g1<T>.k a(Integer num) {
        g1<T>.k kVar = this.j.get(num);
        if (kVar != null) {
            int unused = ((k) kVar).a;
            return kVar;
        }
        return new k(this, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w1 w1Var, com.qq.e.comm.plugin.j jVar, f5 f5Var, AtomicInteger atomicInteger, boolean z) {
        int iHashCode = w1Var.hashCode();
        atomicInteger.get();
        if (this.d.get()) {
            return;
        }
        this.d.set(true);
        w1Var.l(1);
        w1Var.b(false);
        if (w1Var.d() <= 0) {
            w1Var.b(this.h);
        }
        w1Var.d();
        y9.c(f5Var);
        this.b.a(w1Var, jVar, new d(iHashCode, z, atomicInteger, f5Var, w1Var, jVar), f5Var);
    }

    private boolean a(w1 w1Var, com.qq.e.comm.plugin.j jVar, f5 f5Var) throws JSONException {
        if (this.n) {
            return false;
        }
        String strB = jVar.b();
        String strB2 = wb.b(this.c, strB);
        if (!this.a.c() || wb.a(strB2)) {
            return false;
        }
        int iB = this.a.b();
        vb vbVarB = wb.b(strB2, this.c, strB, new ArrayList(this.a.a()), iB);
        b bVar = new b(w1Var, f5Var, jVar);
        this.m = bVar;
        vbVarB.a(bVar);
        ub.c().e(vbVarB);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public T a(T t, h<T> hVar, JSONObject jSONObject, int i2) {
        if (jSONObject == null) {
            return null;
        }
        T t2 = (T) hVar.a(jSONObject);
        if (t2 != null && (t2.C1() || !TextUtils.isEmpty(t2.c0()))) {
            t.a(i2, t2);
        }
        return t2;
    }

    public void a(T t, w1 w1Var, com.qq.e.comm.plugin.j jVar, qo.f fVar, f5 f5Var) {
        if (t == null || !t.s1()) {
            return;
        }
        t.S0();
        this.e.set(true);
        this.a.a(t.S0(), this.k, w1Var, jVar, new a(fVar, f5Var));
    }

    public g1<T> a(int i2) {
        int iB = xb.b(this.c);
        if (iB > 0) {
            i2 = iB;
        }
        this.h = i2;
        this.g = this.g && i2 > 0;
        return this;
    }

    public g1<T> a(j jVar) {
        this.l = jVar;
        return this;
    }

    public g1<T> a(boolean z) {
        this.g = this.g && z;
        return this;
    }

    public void a(JSONObject jSONObject) {
        this.a.b(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Integer num, int i2) {
        this.j.put(num, new k(this, i2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w1 w1Var, T t) {
        t.h(w1Var.A());
        t.d(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, h4 h4Var, int i3) {
        b10.a(9200016, f5.a(h4Var), Integer.valueOf(i2), Integer.valueOf(i3), null);
    }

    public static <T extends h4> g1<T> a(String str, f5 f5Var, e2 e2Var) {
        ConcurrentHashMap<String, g1> concurrentHashMap = p;
        g1<T> g1Var = concurrentHashMap.get(str);
        if (g1Var != null) {
            return g1Var;
        }
        concurrentHashMap.putIfAbsent(str, new g1(str, f5Var, e2Var));
        return concurrentHashMap.get(str);
    }
}
