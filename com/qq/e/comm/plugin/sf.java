package com.qq.e.comm.plugin;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.plugin.as;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class sf {
    public static final int A;
    private static final String x = String.format("https://%s/%s", "sdk.e.qq.com", com.sigmob.sdk.base.n.q);
    private static final sf y = new sf();
    public static final boolean z;
    private String a;
    private String b;
    private volatile int k;
    private Boolean n;
    private String o;
    private zj p;
    private long r;
    private Runnable s;
    private volatile long v;
    private boolean c = true;
    private List<j> d = new ArrayList();
    private ExecutorService e = Executors.newSingleThreadExecutor();
    private AtomicLong f = new AtomicLong();
    private final AtomicLong g = new AtomicLong();
    private AtomicLong h = new AtomicLong(0);
    private AtomicLong i = new AtomicLong();
    private volatile int j = 69;
    private long l = 0;
    private long m = 0;
    private long q = 0;
    private final AtomicReference<ScheduledFuture<?>> t = new AtomicReference<>();
    private volatile boolean u = true;
    private volatile boolean w = false;

    /* compiled from: A */
    public interface j {
        void a();
    }

    private int a(int i2, int i3, int i4) {
        return pro.getIresult(217, 0, this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    static /* synthetic */ int a(sf sfVar, int i2, int i3, int i4) {
        return pro.getIresult(218, 1, sfVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    static /* synthetic */ long a(sf sfVar, long j2) {
        return pro.getJresult(219, 1, sfVar, Long.valueOf(j2));
    }

    private String a(vx vxVar, hu huVar, qa qaVar, b0 b0Var) {
        return (String) pro.getobjresult(220, 0, this, vxVar, huVar, qaVar, b0Var);
    }

    private void a() {
        pro.getVresult(221, 0, this);
    }

    private void a(int i2, int i3) {
        pro.getVresult(222, 0, this, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    private void a(int i2, String str, int i3, int i4, int i5) {
        pro.getVresult(223, 0, this, Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private void a(int i2, boolean z2) {
        pro.getVresult(224, 0, this, Integer.valueOf(i2), Boolean.valueOf(z2));
    }

    static /* synthetic */ void a(sf sfVar) {
        pro.getVresult(225, 1, sfVar);
    }

    static /* synthetic */ void a(sf sfVar, int i2, int i3) {
        pro.getVresult(226, 1, sfVar, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    static /* synthetic */ void a(sf sfVar, int i2, String str, int i3, int i4, int i5) {
        pro.getVresult(227, 1, sfVar, Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    static /* synthetic */ void a(sf sfVar, int i2, boolean z2) {
        pro.getVresult(228, 1, sfVar, Integer.valueOf(i2), Boolean.valueOf(z2));
    }

    static /* synthetic */ void a(sf sfVar, String str) {
        pro.getVresult(229, 1, sfVar, str);
    }

    static /* synthetic */ void a(sf sfVar, boolean z2, JSONObject jSONObject) {
        pro.getVresult(230, 1, sfVar, Boolean.valueOf(z2), jSONObject);
    }

    private void a(String str) {
        pro.getVresult(231, 0, this, str);
    }

    private void a(String str, String str2) {
        pro.getVresult(232, 0, this, str, str2);
    }

    private void a(JSONObject jSONObject, JSONObject jSONObject2) {
        pro.getVresult(233, 0, this, jSONObject, jSONObject2);
    }

    private void a(boolean z2, int i2) {
        pro.getVresult(234, 0, this, Boolean.valueOf(z2), Integer.valueOf(i2));
    }

    private void a(boolean z2, JSONObject jSONObject) {
        pro.getVresult(235, 0, this, Boolean.valueOf(z2), jSONObject);
    }

    private boolean a(int i2) {
        return pro.getZresult(236, 0, this, Integer.valueOf(i2));
    }

    private static boolean a(Context context, String str, String str2) {
        return pro.getZresult(237, 1, context, str, str2);
    }

    static /* synthetic */ boolean a(sf sfVar, boolean z2) {
        return pro.getZresult(238, 1, sfVar, Boolean.valueOf(z2));
    }

    static /* synthetic */ long b(sf sfVar, long j2) {
        return pro.getJresult(239, 1, sfVar, Long.valueOf(j2));
    }

    private void b(int i2) {
        pro.getVresult(240, 0, this, Integer.valueOf(i2));
    }

    private void b(int i2, int i3) {
        pro.getVresult(241, 0, this, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    static /* synthetic */ void b(sf sfVar, String str) {
        pro.getVresult(242, 1, sfVar, str);
    }

    private void b(String str) {
        pro.getVresult(243, 0, this, str);
    }

    private void b(String str, String str2) {
        pro.getVresult(244, 0, this, str, str2);
    }

    private void c(String str) {
        pro.getVresult(245, 0, this, str);
    }

    private void c(String str, String str2) {
        pro.getVresult(246, 0, this, str, str2);
    }

    private void c(JSONObject jSONObject) {
        pro.getVresult(247, 0, this, jSONObject);
    }

    private long e() {
        return pro.getJresult(248, 0, this);
    }

    private void k() {
        pro.getVresult(249, 0, this);
    }

    public static sf l() {
        return (sf) pro.getobjresult(250, 1, new Object[0]);
    }

    private void n() {
        pro.getVresult(251, 0, this);
    }

    private void o() {
        pro.getVresult(252, 0, this);
    }

    public void a(long j2) {
        pro.getVresult(253, 0, this, Long.valueOf(j2));
    }

    public void a(j jVar) {
        pro.getVresult(254, 0, this, jVar);
    }

    public void a(JSONObject jSONObject) {
        pro.getVresult(255, 0, this, jSONObject);
    }

    void a(boolean z2) {
        pro.getVresult(256, 0, this, Boolean.valueOf(z2));
    }

    public void b() {
        pro.getVresult(257, 0, this);
    }

    public void b(JSONObject jSONObject) {
        pro.getVresult(258, 0, this, jSONObject);
    }

    public void b(boolean z2, JSONObject jSONObject) {
        pro.getVresult(259, 0, this, Boolean.valueOf(z2), jSONObject);
    }

    void c() {
        pro.getVresult(260, 0, this);
    }

    public long d() {
        return pro.getJresult(261, 0, this);
    }

    public int f() {
        return pro.getIresult(262, 0, this);
    }

    public String g() {
        return (String) pro.getobjresult(263, 0, this);
    }

    public String h() {
        return (String) pro.getobjresult(264, 0, this);
    }

    public long i() {
        return pro.getJresult(265, 0, this);
    }

    public void j() {
        pro.getVresult(266, 0, this);
    }

    public boolean m() {
        return pro.getZresult(267, 0, this);
    }

    void p() {
        pro.getVresult(268, 0, this);
    }

    public void q() {
        pro.getVresult(269, 0, this);
    }

    static {
        z = xc.a("sklcrr", 0, tc.c()) == 1;
        A = xc.a("skldr", 0, tc.c());
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            px.a().b();
            sf.a(sf.this);
        }
    }

    /* compiled from: A */
    class b implements j {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // com.qq.e.comm.plugin.sf.j
        public void a() {
            sf.a(sf.this, this.a, false);
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ JSONObject b;

        c(boolean z, JSONObject jSONObject) {
            this.a = z;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            sf.a(sf.this, this.a, this.b);
        }
    }

    /* compiled from: A */
    class d implements zj {
        final /* synthetic */ int a;

        d(int i) {
            this.a = i;
        }

        @Override // com.qq.e.comm.plugin.zj
        public void a(boolean z, JSONObject jSONObject) {
            if (jSONObject == null || jSONObject.optInt(com.sigmob.sdk.base.n.q) > 0) {
                sf.a(sf.this, this.a, true);
            }
        }

        @Override // com.qq.e.comm.plugin.zj
        public void a(int i) {
            sf.a(sf.this, this.a, true);
        }
    }

    /* compiled from: A */
    class e implements Runnable {
        final /* synthetic */ int a;

        @Override // java.lang.Runnable
        public void run() {
            qg.b.submit(new a());
        }

        e(int i) {
            this.a = i;
        }

        /* compiled from: A */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                sf.a(sf.this, eVar.a, false);
            }
        }
    }

    /* compiled from: A */
    class f extends hz {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        f(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // com.qq.e.comm.plugin.hz
        public void a(aw awVar, int i, Exception exc) {
            sf.a(sf.this, i, exc.getMessage(), 0, this.a, this.b);
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) throws IllegalStateException {
            try {
                int iA = hwVar.a();
                if (iA == 200) {
                    String strC = hwVar.c();
                    if (TextUtils.isEmpty(strC)) {
                        sf.a(sf.this, 3000, "reponse is empty", 0, this.a, this.b);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(strC);
                    int iOptInt = jSONObject.optInt(com.baidu.mobads.container.adrequest.g.ag, -1);
                    sf sfVar = sf.this;
                    sf.a(sfVar, 0, null, sf.a(sfVar, this.a, this.c, iOptInt), this.a, this.b);
                    sf.this.b(true, jSONObject);
                    return;
                }
                sf.a(sf.this, 3005, "status code=" + iA, 0, this.a, this.b);
                hwVar.a();
            } catch (IOException e) {
                sf.a(sf.this, 3001, e.getMessage(), 0, this.a, this.b);
            } catch (JSONException e2) {
                sf.a(sf.this, 5001, e2.getMessage(), 0, this.a, this.b);
            }
        }
    }

    /* compiled from: A */
    class g implements as.b {
        private final AtomicBoolean a = new AtomicBoolean(false);

        g() {
        }

        @Override // com.qq.e.comm.plugin.as.b
        public void a() {
            if (this.a.compareAndSet(false, true)) {
                as.b(this);
                sf.a(sf.this, 0, 2);
                sf.this.a(false);
            }
        }
    }

    /* compiled from: A */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            sf.a(sf.this, false);
            sf.a(sf.this, 0, 1);
            sf.this.a(false);
        }
    }

    /* compiled from: A */
    class i implements Runnable {
        final /* synthetic */ JSONObject a;

        i(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strOptString = this.a.optString("suid", null);
            if (!TextUtils.isEmpty(strOptString)) {
                sf.a(sf.this, strOptString);
            }
            String strOptString2 = this.a.optString(com.baidu.mobads.container.components.h.b.e.a, null);
            if (!TextUtils.isEmpty(strOptString2)) {
                sf.b(sf.this, strOptString2);
            }
            long jOptLong = this.a.optLong(com.alipay.sdk.m.t.a.k);
            if (jOptLong > 0) {
                sf.b(sf.this, jOptLong);
                sf.a(sf.this, SystemClock.elapsedRealtime() / 1000);
            }
        }
    }
}
