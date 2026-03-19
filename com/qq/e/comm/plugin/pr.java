package com.qq.e.comm.plugin;

import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class pr {
    private static volatile pr o;
    private ConcurrentLinkedQueue<c> a;
    private int c;
    private int d;
    private int f;
    private long g;
    private long h;
    private int[] i;
    private int j;
    private zy k;
    private boolean l;
    private boolean m;
    private boolean n;
    private final AtomicBoolean b = new AtomicBoolean(false);
    private int e = 0;

    /* compiled from: A */
    public static class c {
        private long a;
        private long b;
        private boolean c;
        private final float d;

        public c(float f) {
            this.d = f;
        }

        public c a(boolean z) {
            this.c = z;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.a;
            this.b = jElapsedRealtime;
            if (z) {
                this.b = (long) (jElapsedRealtime * this.d);
            } else if (jElapsedRealtime < 2000) {
                this.b = 2000L;
            }
            return this;
        }

        public c a() {
            this.a = SystemClock.elapsedRealtime();
            return this;
        }
    }

    private pr() {
        JSONObject jSONObjectA;
        int length;
        boolean z = false;
        this.c = 0;
        this.d = 0;
        this.n = false;
        String strB = r1.d().f().b("nqmc", "");
        if (TextUtils.isEmpty(strB) || (jSONObjectA = new jn(strB).a()) == null || jSONObjectA.length() == 0) {
            return;
        }
        int iOptInt = jSONObjectA.optInt("rl");
        this.f = iOptInt;
        if (iOptInt <= 0) {
            return;
        }
        long jOptInt = jSONObjectA.optInt("rtw");
        this.g = jOptInt;
        if (jOptInt <= 0) {
            return;
        }
        this.h = jOptInt * 60000;
        JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("tcr");
        if (jSONArrayOptJSONArray == null || (length = jSONArrayOptJSONArray.length()) == 0) {
            return;
        }
        this.n = true;
        this.a = new ConcurrentLinkedQueue<>();
        this.i = new int[length];
        for (int i = 0; i < length; i++) {
            this.i[i] = jSONArrayOptJSONArray.optInt(i);
        }
        this.j = jSONObjectA.optInt("cec");
        boolean z2 = Build.VERSION.SDK_INT >= 29;
        this.m = z2 && jSONObjectA.optInt("css") == 1;
        if (z2 && jSONObjectA.optInt("wss") == 1) {
            z = true;
        }
        this.l = z;
        if (this.m || z) {
            this.k = new zy();
        }
        if (as.i()) {
            return;
        }
        this.c = -1;
        this.d = -1;
    }

    private void c() {
        while (this.a.size() > this.f) {
            this.a.poll();
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (!this.a.isEmpty()) {
            c cVarPeek = this.a.peek();
            if (cVarPeek != null && jElapsedRealtime - cVarPeek.a <= this.h) {
                return;
            } else {
                this.a.poll();
            }
        }
    }

    private int b() {
        if (!this.b.compareAndSet(true, false)) {
            return this.c;
        }
        c();
        if (this.a.isEmpty()) {
            return this.c;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<c> it = this.a.iterator();
        float f = 0.0f;
        float f2 = 0.0f;
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            c next = it.next();
            if (next != null) {
                i = next.c ? 0 : i + 1;
                i2++;
                double dA = a(next.a, jElapsedRealtime);
                if (dA > 0.0d) {
                    double d = f2;
                    double d2 = next.b;
                    Double.isNaN(d2);
                    Double.isNaN(d);
                    f2 = (float) (d + (d2 * dA));
                    double d3 = f;
                    Double.isNaN(d3);
                    f = (float) (d3 + dA);
                    jElapsedRealtime = jElapsedRealtime;
                }
            }
        }
        int i3 = this.c;
        if (i3 == -1 && i == i2) {
            return i3;
        }
        int i4 = this.j;
        if (i4 > 0 && i >= i4) {
            this.c = -1;
            return -1;
        }
        if (f < 1.0f) {
            return i3;
        }
        int iRound = Math.round(f2 / f);
        int i5 = 0;
        while (true) {
            int[] iArr = this.i;
            if (i5 >= iArr.length) {
                break;
            }
            if (iRound >= iArr[i5]) {
                this.c = i5 + 1;
                break;
            }
            i5++;
        }
        return this.c;
    }

    public void d() {
        if (this.m) {
            qg.c.submit(new a());
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            pr.this.k.c();
        }
    }

    public void e() {
        if (this.m) {
            qg.c.submit(new b());
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            pr.this.k.d();
        }
    }

    public ja a(zr zrVar, ja jaVar) throws JSONException {
        if (!this.n) {
            return jaVar;
        }
        int iB = b();
        if (iB != this.d) {
            this.e++;
            this.d = iB;
        }
        int i = as.p;
        if (jaVar == null) {
            jaVar = new ja();
        }
        jaVar.a("nq", Integer.valueOf(iB)).a("nqcc", Integer.valueOf(this.e));
        if (this.l && zrVar == zr.WIFI) {
            jaVar.a("wss", Integer.valueOf(this.k.b()));
        } else if (this.m && as.b(zrVar)) {
            jaVar.a("css", Integer.valueOf(this.k.a()));
        }
        return jaVar;
    }

    public void a(c cVar) {
        if (this.n) {
            this.a.add(cVar);
            this.b.compareAndSet(false, true);
        }
    }

    private double a(long j, long j2) {
        double d = j2 - j;
        Double.isNaN(d);
        double dFloor = Math.floor(d / 60000.0d);
        double d2 = this.g;
        Double.isNaN(d2);
        return 1.0d - (dFloor / d2);
    }

    public void a(boolean z) {
        if (this.n) {
            this.c = z ? -1 : 0;
            this.a.clear();
            this.b.compareAndSet(true, false);
        }
    }

    public void a(NetworkCapabilities networkCapabilities) {
        if (this.l) {
            this.k.a(networkCapabilities);
        }
    }

    public static pr a() {
        if (o != null) {
            return o;
        }
        synchronized (pr.class) {
            if (o == null) {
                o = new pr();
            }
        }
        return o;
    }
}
