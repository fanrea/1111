package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.dynamic.c;
import com.qq.e.comm.plugin.edgeanalytics.IEAB;
import com.qq.e.comm.plugin.zb;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ub {
    private static volatile ub i;
    private volatile rb a;
    private zb b;
    private ScheduledExecutorService c;
    private com.qq.e.comm.dynamic.b d;
    private IEAB e;
    private Map<String, l> f;
    private volatile AtomicBoolean g = null;
    private final AtomicBoolean h = new AtomicBoolean(false);

    private boolean f() {
        int iA = r1.d().f().a("emanaed", 0);
        if (iA == 1) {
            return true;
        }
        if (iA == 0) {
            if (this.g == null) {
                this.g = new AtomicBoolean(true);
            }
        } else if (iA == -1) {
            rb.a();
        }
        return false;
    }

    /* compiled from: A */
    private static class l {
        private vb a;
        private Runnable b;
        private AtomicBoolean c;
        private String d;
        private long e;
        private long f;

        private l(vb vbVar) {
            this.c = new AtomicBoolean(false);
            this.a = vbVar;
        }

        /* synthetic */ l(vb vbVar, c cVar) {
            this(vbVar);
        }
    }

    private ub() {
    }

    public synchronized void d() {
        if (!this.h.get() && f()) {
            ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new c());
            this.c = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
            this.a = new rb(scheduledExecutorServiceNewSingleThreadScheduledExecutor);
            this.e = a();
            this.f = new ConcurrentHashMap();
            this.b = new zb();
            this.c.submit(new d());
            this.h.set(true);
        }
    }

    /* compiled from: A */
    class c implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_EA_THREAD");
        }

        c() {
        }
    }

    /* compiled from: A */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ub.this.b.b();
        }
    }

    /* compiled from: A */
    class e extends pg {
        e(rb rbVar) {
            super(rbVar);
        }

        @Override // com.qq.e.comm.plugin.pg, com.qq.e.comm.plugin.edgeanalytics.IEAB
        public String oc(String str, String str2, String str3) {
            String strOc = super.oc(str, str2, str3);
            l lVar = (l) ub.this.f.get(str);
            if (lVar != null) {
                lVar.d = strOc;
            }
            return strOc;
        }
    }

    public void b() {
        if (this.g == null || !this.g.compareAndSet(true, false)) {
            return;
        }
        d();
    }

    /* compiled from: A */
    class f implements Runnable {
        final /* synthetic */ vb a;
        final /* synthetic */ JSONObject b;

        f(vb vbVar, JSONObject jSONObject) {
            this.a = vbVar;
            this.b = jSONObject;
        }

        /* compiled from: A */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() throws JSONException {
                try {
                    f fVar = f.this;
                    ub.this.a(fVar.a, fVar.b);
                } catch (Throwable th) {
                    f fVar2 = f.this;
                    ub.this.a(fVar2.a, 0, th.getMessage(), "");
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ub.this.c.submit(new a());
        }
    }

    /* compiled from: A */
    class g implements Runnable {
        final /* synthetic */ vb a;
        final /* synthetic */ JSONObject b;

        g(vb vbVar, JSONObject jSONObject) {
            this.a = vbVar;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            try {
                ub.this.a(this.a, this.b);
            } catch (Throwable th) {
                ub.this.a(this.a, 0, th.getMessage(), "");
            }
        }
    }

    /* compiled from: A */
    class h implements zb.c {
        final /* synthetic */ vb a;
        final /* synthetic */ JSONObject b;

        h(vb vbVar, JSONObject jSONObject) {
            this.a = vbVar;
            this.b = jSONObject;
        }

        @Override // com.qq.e.comm.plugin.zb.c
        public void a(String str, byte[] bArr) throws JSONException {
            ub.this.a(this.a, str, bArr, this.b);
        }

        @Override // com.qq.e.comm.plugin.zb.c
        public void a(int i, String str) throws JSONException {
            ub.this.a(this.a, 2, String.valueOf(i), str);
        }
    }

    /* compiled from: A */
    class i implements Runnable {
        final /* synthetic */ vb a;
        final /* synthetic */ String b;
        final /* synthetic */ byte[] c;
        final /* synthetic */ JSONObject d;

        i(vb vbVar, String str, byte[] bArr, JSONObject jSONObject) {
            this.a = vbVar;
            this.b = str;
            this.c = bArr;
            this.d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            try {
                ub.this.b(this.a, this.b, this.c, this.d);
            } catch (Throwable th) {
                ub.this.a(this.a, 0, th.getMessage(), "");
            }
        }
    }

    /* compiled from: A */
    class j implements c.e {
        final /* synthetic */ vb a;
        final /* synthetic */ String b;
        final /* synthetic */ byte[] c;
        final /* synthetic */ JSONObject d;

        j(vb vbVar, String str, byte[] bArr, JSONObject jSONObject) {
            this.a = vbVar;
            this.b = str;
            this.c = bArr;
            this.d = jSONObject;
        }

        @Override // com.qq.e.comm.dynamic.c.e
        public void b() throws JSONException {
            ub.this.a(this.a, this.b, this.c, this.d);
        }
    }

    /* compiled from: A */
    class k implements Runnable {
        final /* synthetic */ AtomicBoolean a;
        final /* synthetic */ vb b;

        k(AtomicBoolean atomicBoolean, vb vbVar) {
            this.a = atomicBoolean;
            this.b = vbVar;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            this.a.set(true);
            ub ubVar = ub.this;
            vb vbVar = this.b;
            ubVar.a(vbVar, 4, String.valueOf(vbVar.k()), (String) null);
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ zj a;
        final /* synthetic */ boolean b;
        final /* synthetic */ JSONObject c;

        a(zj zjVar, boolean z, JSONObject jSONObject) {
            this.a = zjVar;
            this.b = z;
            this.c = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b, this.c);
        }
    }

    private void c(vb vbVar) throws JSONException {
        l lVarRemove = this.f.remove(vbVar.g());
        if (lVarRemove == null) {
            return;
        }
        a(lVarRemove);
        xo.e(lVarRemove.b);
        if (lVarRemove.c.get() || lVarRemove.a.d() == null) {
            return;
        }
        a(lVarRemove, true, new jn(lVarRemove.d).a());
    }

    public static ub c() {
        if (i == null) {
            synchronized (ub.class) {
                if (i == null) {
                    i = new ub();
                }
            }
        }
        return i;
    }

    private boolean d(vb vbVar) {
        l lVar = this.f.get(vbVar.g());
        if (lVar == null) {
            return false;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        k kVar = new k(atomicBoolean, vbVar);
        lVar.c = atomicBoolean;
        lVar.b = kVar;
        if (vbVar.k() <= 0) {
            return true;
        }
        xo.a(kVar, vbVar.k());
        return true;
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ zj a;
        final /* synthetic */ int b;

        b(zj zjVar, int i) {
            this.a = zjVar;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b);
        }
    }

    public boolean e() {
        return this.a != null;
    }

    private com.qq.e.comm.dynamic.b b(vb vbVar) throws Throwable {
        com.qq.e.comm.dynamic.b bVar;
        boolean zN = vbVar.n();
        if (zN && (bVar = this.d) != null) {
            return bVar;
        }
        com.qq.e.comm.dynamic.b bVarA = com.qq.e.comm.dynamic.b.a(1);
        if (bVarA != null) {
            try {
                bVarA.a("GDTEAB", IEAB.class, this.e);
            } catch (Throwable th) {
                bVarA.a();
                throw th;
            }
        }
        if (zN) {
            this.d = bVarA;
        }
        return bVarA;
    }

    public boolean e(vb vbVar) {
        if (!this.h.get() || !vbVar.m()) {
            return false;
        }
        l lVar = this.f.get(vbVar.g());
        if (lVar != null) {
            lVar.a.a(vbVar.d());
            return true;
        }
        JSONObject jSONObjectA = a(vbVar);
        l lVar2 = new l(vbVar, null);
        if (this.a.a(jSONObjectA, vbVar.e())) {
            a(lVar2, false, jSONObjectA);
            return true;
        }
        this.f.put(vbVar.g(), lVar2);
        if (vbVar.j() < 0) {
            xo.c(new f(vbVar, jSONObjectA));
        } else {
            this.c.schedule(new g(vbVar, jSONObjectA), vbVar.j(), TimeUnit.MILLISECONDS);
        }
        return true;
    }

    public void a(qc qcVar, boolean z) {
        if (this.a != null) {
            this.a.a(qcVar, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(vb vbVar, JSONObject jSONObject) throws JSONException {
        l lVar = this.f.get(vbVar.g());
        if (lVar != null) {
            lVar.e = System.currentTimeMillis();
        }
        if (vbVar.n() && a(vbVar, this.d)) {
            b(vbVar, (String) null, (byte[]) null, jSONObject);
        } else {
            a("ea execute %s", vbVar.g());
            this.b.a(vbVar.i(), vbVar.o(), new h(vbVar, jSONObject));
        }
    }

    public void b(String str) {
        if (this.a == null) {
            return;
        }
        this.a.c(str);
    }

    private void a(l lVar, boolean z, JSONObject jSONObject) {
        zj zjVarD = lVar.a.d();
        if (zjVarD == null) {
            return;
        }
        xo.a((Runnable) new a(zjVarD, z, jSONObject));
    }

    private void b(vb vbVar, int i2, String str, String str2) throws JSONException {
        ja jaVar = new ja();
        if (!TextUtils.isEmpty(str)) {
            jaVar.a("msg", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            jaVar.a("data2", str2);
        }
        jaVar.a("data", vbVar.i());
        b10.a(9900001, null, Integer.valueOf(vbVar.b()), Integer.valueOf(i2), jaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(com.qq.e.comm.plugin.vb r10, java.lang.String r11, byte[] r12, org.json.JSONObject r13) throws org.json.JSONException {
        /*
            r9 = this;
            com.qq.e.comm.dynamic.c r0 = com.qq.e.comm.dynamic.c.a()
            boolean r0 = r0.e()
            r1 = 0
            if (r0 != 0) goto L1e
            com.qq.e.comm.dynamic.c r0 = com.qq.e.comm.dynamic.c.a()
            com.qq.e.comm.plugin.ub$j r8 = new com.qq.e.comm.plugin.ub$j
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r2.<init>(r4, r5, r6, r7)
            r0.a(r8, r1)
            return
        L1e:
            java.util.Map<java.lang.String, com.qq.e.comm.plugin.ub$l> r0 = r9.f
            java.lang.String r2 = r10.g()
            java.lang.Object r0 = r0.get(r2)
            com.qq.e.comm.plugin.ub$l r0 = (com.qq.e.comm.plugin.ub.l) r0
            if (r0 == 0) goto L33
            long r2 = java.lang.System.currentTimeMillis()
            com.qq.e.comm.plugin.ub.l.a(r0, r2)
        L33:
            r0 = 3
            com.qq.e.comm.dynamic.b r2 = r9.b(r10)     // Catch: java.lang.Throwable -> Ld4
            if (r2 != 0) goto L3e
            r9.a(r10, r0)
            return
        L3e:
            boolean r0 = r9.d(r10)
            if (r0 != 0) goto L49
            r11 = 5
            r9.a(r10, r11)
            return
        L49:
            boolean r0 = r10.n()
            r3 = 1
            boolean r4 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L99
            if (r4 == 0) goto L5b
            if (r12 != 0) goto L5b
            java.lang.String r11 = r10.a(r13)     // Catch: java.lang.Throwable -> L99
            goto L88
        L5b:
            boolean r4 = r10.o()     // Catch: java.lang.Throwable -> L99
            if (r4 != 0) goto L66
            java.lang.String r11 = r10.a(r11, r13, r3)     // Catch: java.lang.Throwable -> L99
            goto L88
        L66:
            if (r12 == 0) goto L69
            goto L75
        L69:
            java.lang.String r12 = r10.i()     // Catch: java.lang.Throwable -> L94
            java.lang.String r4 = r10.a(r11, r13, r1)     // Catch: java.lang.Throwable -> L94
            byte[] r12 = r9.a(r2, r12, r4)     // Catch: java.lang.Throwable -> L94
        L75:
            if (r12 == 0) goto L84
            r2.a(r12)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r11 = r10.a(r13)     // Catch: java.lang.Throwable -> L99
            goto L88
        L7f:
            r11 = move-exception
            throw r11     // Catch: java.lang.Throwable -> L81
        L81:
            r11 = move-exception
            r12 = 6
            goto L9b
        L84:
            java.lang.String r11 = r10.a(r11, r13, r3)     // Catch: java.lang.Throwable -> L99
        L88:
            r2.b(r11)     // Catch: java.lang.Throwable -> L99
            if (r0 != 0) goto L90
            r2.a()
        L90:
            r9.c(r10)
            return
        L94:
            r11 = move-exception
            throw r11     // Catch: java.lang.Throwable -> L96
        L96:
            r11 = move-exception
            r12 = 7
            goto L9b
        L99:
            r11 = move-exception
            r12 = 0
        L9b:
            if (r0 == 0) goto La3
            r2.a()     // Catch: java.lang.Throwable -> Lcd
            r13 = 0
            r9.d = r13     // Catch: java.lang.Throwable -> Lcd
        La3:
            java.lang.String r13 = android.util.Log.getStackTraceString(r11)     // Catch: java.lang.Throwable -> Lcd
            boolean r4 = android.text.TextUtils.isEmpty(r13)     // Catch: java.lang.Throwable -> Lcd
            if (r4 != 0) goto Lb9
            int r4 = r13.length()     // Catch: java.lang.Throwable -> Lcd
            r5 = 256(0x100, float:3.59E-43)
            if (r4 <= r5) goto Lb9
            java.lang.String r13 = r13.substring(r1, r5)     // Catch: java.lang.Throwable -> Lcd
        Lb9:
            if (r12 != 0) goto Lbc
            goto Lbd
        Lbc:
            r3 = r12
        Lbd:
            java.lang.String r12 = r11.getMessage()     // Catch: java.lang.Throwable -> Lcd
            r9.a(r10, r3, r12, r13)     // Catch: java.lang.Throwable -> Lcd
            r11.getMessage()     // Catch: java.lang.Throwable -> Lcd
            if (r0 != 0) goto Lcc
            r2.a()
        Lcc:
            return
        Lcd:
            r10 = move-exception
            if (r0 != 0) goto Ld3
            r2.a()
        Ld3:
            throw r10
        Ld4:
            r11 = move-exception
            java.lang.String r11 = r11.getMessage()
            java.lang.String r12 = ""
            r9.a(r10, r0, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.ub.b(com.qq.e.comm.plugin.vb, java.lang.String, byte[], org.json.JSONObject):void");
    }

    private void a(vb vbVar, int i2) throws JSONException {
        a(vbVar, i2, (String) null, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(vb vbVar, int i2, String str, String str2) throws JSONException {
        qm$h$$ExternalSyntheticBackport0.m(vbVar.d());
        this.f.remove(vbVar.g());
        b(vbVar, i2, str, str2);
        zj zjVarD = vbVar.d();
        if (zjVarD == null) {
            return;
        }
        xo.a((Runnable) new b(zjVarD, i2));
    }

    private byte[] a(com.qq.e.comm.dynamic.b bVar, String str, String str2) throws Throwable {
        byte[] bArrA = bVar.a(str2);
        if (bArrA == null || bArrA.length == 0) {
            return null;
        }
        this.b.a(str, bArrA);
        return bArrA;
    }

    public JSONObject a(vb vbVar) {
        if (this.a == null) {
            return null;
        }
        JSONObject jSONObjectA = this.a.a(vbVar.g(), vbVar.a(), vbVar.l());
        return (jSONObjectA != null || vbVar.c() == null) ? jSONObjectA : vbVar.c();
    }

    JSONObject a(String str) {
        return this.a.a(str, null, false);
    }

    private boolean a(vb vbVar, com.qq.e.comm.dynamic.b bVar) {
        if (bVar == null) {
            return false;
        }
        String strH = vbVar.h();
        try {
            Object objB = bVar.b("typeof(" + strH + ")=='function' && " + strH + "!= null;");
            if (objB instanceof Boolean) {
                return ((Boolean) objB).booleanValue();
            }
            return false;
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }

    private void a(l lVar) throws JSONException {
        int iF = lVar.a.f();
        if (iF > 0 && lVar.e > 0 && lVar.f > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - lVar.e;
            long jCurrentTimeMillis2 = System.currentTimeMillis() - lVar.f;
            wt wtVar = new wt(9900001);
            wtVar.b(iF);
            wtVar.b(jCurrentTimeMillis);
            ja jaVar = new ja();
            jaVar.a("du", Long.valueOf(jCurrentTimeMillis2));
            wtVar.a(jaVar);
            b10.a(wtVar);
            wt wtVar2 = new wt(9900002);
            wtVar2.b(iF);
            wtVar2.b(jCurrentTimeMillis2);
            ja jaVar2 = new ja();
            jaVar2.a("du", Long.valueOf(jCurrentTimeMillis));
            wtVar2.a(jaVar2);
            b10.a(wtVar2);
        }
    }

    private IEAB a() {
        return new e(this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(vb vbVar, String str, byte[] bArr, JSONObject jSONObject) throws JSONException {
        if ("GDT_EA_THREAD".equals(Thread.currentThread().getName())) {
            b(vbVar, str, bArr, jSONObject);
        } else {
            this.c.submit(new i(vbVar, str, bArr, jSONObject));
        }
    }

    private void a(String str, Object... objArr) {
        if (r1.d().f().a("eaplir", 0) == 0) {
            return;
        }
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        GDTLogger.w(str);
    }
}
