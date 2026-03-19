package com.qq.e.comm.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class kg {
    private static volatile kg m;
    private Handler c;
    private volatile String e;
    Random g;
    private volatile long h;
    private final AtomicBoolean a = new AtomicBoolean(false);
    private volatile boolean b = false;
    private final List<String> d = new ArrayList();
    private volatile int f = -1;
    private volatile int i = -1;
    private volatile int j = -1;
    private volatile int k = -1;
    private final Runnable l = new b();

    private boolean j() {
        return pro.getZresult(401, 0, this);
    }

    private boolean k() {
        return pro.getZresult(402, 0, this);
    }

    private void l() {
        if (Build.VERSION.SDK_INT >= 24 ? k() : j()) {
            if (r1.d().f().a("sisdc", 1) > 0) {
                h9.c().a(true);
            } else {
                qg.b.submit(new d());
            }
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        qg.c.submit(new c());
    }

    public void q() {
        if (jh.c().a() || this.c != null || f() <= 1) {
            if (f() <= 1) {
                h9.c().a();
                return;
            }
            return;
        }
        if (this.a.compareAndSet(false, true)) {
            f();
            m();
            if (b() > 1 || u()) {
                if (b() == 4) {
                    a();
                }
                l();
                if (b() > 1) {
                    a(false);
                }
            }
            this.c = new Handler(Looper.getMainLooper());
            s();
            a(r1.d().a());
            this.b = true;
        }
    }

    public static kg d() {
        if (m == null) {
            synchronized (kg.class) {
                if (m == null) {
                    m = new kg();
                }
            }
        }
        return m;
    }

    public int e() {
        return r1.d().f().a("dphl", 10) * 60;
    }

    private kg() {
    }

    /* compiled from: A */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            kg.this.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        try {
            this.c.removeCallbacksAndMessages(null);
            if (n()) {
                int iA = r1.d().f().a("hdrnit", 0);
                if (iA > 0) {
                    this.c.postDelayed(this.l, iA);
                } else {
                    this.c.post(this.l);
                }
            }
        } catch (Exception e) {
            e.toString();
        }
    }

    public boolean o() {
        if (this.f < 0) {
            int iA = r1.d().f().a("hdlur", 10);
            if (iA <= 0) {
                this.f = 1;
            } else {
                if (this.g == null) {
                    this.g = new Random();
                }
                double dNextDouble = this.g.nextDouble();
                double d2 = iA;
                Double.isNaN(d2);
                this.f = dNextDouble < d2 * 0.001d ? 1 : 0;
            }
        }
        return this.f > 0;
    }

    public void r() {
        if (this.c == null || SystemClock.elapsedRealtime() - this.h <= 1000) {
            return;
        }
        this.c.post(this.l);
        this.h = SystemClock.elapsedRealtime();
    }

    public int g() {
        if (f() == 1 && b() == 1) {
            return 1;
        }
        if (f() <= 1) {
            return 0;
        }
        if (b() == 1) {
            return 2;
        }
        if (b() == 2) {
            return 3;
        }
        if (b() == 3) {
            return 4;
        }
        if (b() == 4) {
            return 5;
        }
        return b() == 5 ? 6 : 0;
    }

    public int f() {
        if (this.i < 0) {
            this.i = xc.a("prhs", "APP", "", 0);
        }
        return this.i;
    }

    public boolean u() {
        if (this.k < 0) {
            this.k = r1.d().f().a("pdhlc", 1);
        }
        return this.k > 0;
    }

    public List<String> h() {
        return this.d;
    }

    private String i() {
        return this.e;
    }

    private void m() {
        this.d.clear();
        if (b() == 5) {
            List<String> listA = aj.b().a();
            if (listA == null || listA.isEmpty()) {
                return;
            }
            this.d.addAll(new LinkedHashSet(listA));
            return;
        }
        String strB = r1.d().f().b("prh", "mi.gdt.qq.com,v2.gdt.qq.com,c2.gdt.qq.com,pgdt.ugdtimg.com,adsmind.ugdtimg.com,qzs.gdtimg.com");
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        this.d.addAll(new LinkedHashSet(Arrays.asList(strB.split(","))));
        this.e = strB;
    }

    public int b() {
        if (this.j < 0) {
            this.j = xc.a("htph", "APP", "", 0);
        }
        return this.j;
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            kg.this.s();
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() throws UnknownHostException {
            kg.this.v();
            int iA = r1.d().f().a("prhi", 2000);
            if (iA > 0) {
                int iF = kg.this.f();
                if (iF > 2) {
                    iA = iF * 1000;
                }
                if (kg.this.c != null) {
                    kg.this.c.postDelayed(kg.this.l, iA);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() throws UnknownHostException {
        for (int i = 0; i < this.d.size(); i++) {
            try {
                String str = this.d.get(i);
                SystemClock.elapsedRealtime();
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null && allByName.length > 0) {
                    SystemClock.elapsedRealtime();
                }
            } catch (Exception e) {
                e.toString();
            }
        }
    }

    /* compiled from: A */
    class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            h9.c().a(false);
        }

        d() {
        }
    }

    private void a() {
        this.d.add("doh.pub");
        this.d.add("dns.alidns.com");
    }

    private void t() {
        b10.a(9130075, null, 1, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0039 -> B:19:0x003a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean n() {
        /*
            r3 = this;
            com.qq.e.comm.plugin.r1 r0 = com.qq.e.comm.plugin.r1.d()     // Catch: java.lang.Exception -> L39
            android.content.Context r0 = r0.a()     // Catch: java.lang.Exception -> L39
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Exception -> L39
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.Exception -> L39
            if (r0 == 0) goto L39
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L39
            r2 = 23
            if (r1 >= r2) goto L23
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch: java.lang.Exception -> L39
            if (r0 == 0) goto L39
            boolean r0 = r0.isConnected()     // Catch: java.lang.Exception -> L39
            goto L3a
        L23:
            android.net.Network r1 = r0.getActiveNetwork()     // Catch: java.lang.Exception -> L39
            if (r1 == 0) goto L39
            android.net.NetworkCapabilities r0 = r0.getNetworkCapabilities(r1)     // Catch: java.lang.Exception -> L39
            if (r0 == 0) goto L39
            r1 = 16
            boolean r0 = r0.hasCapability(r1)     // Catch: java.lang.Exception -> L39
            if (r0 == 0) goto L39
            r0 = 1
            goto L3a
        L39:
            r0 = 0
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.kg.n():boolean");
    }

    public int c() {
        if (this.b && f() > 1 && b() == 5) {
            return aj.b().e();
        }
        return 0;
    }

    public boolean a(String str, int i, int i2) {
        return this.b && f() > 1 && b() == 5 && aj.b().a(str, i, i2);
    }

    private void a(Context context) {
        try {
            context.getApplicationContext().registerReceiver(new a(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Throwable unused) {
        }
    }

    private void a(Exception exc) throws JSONException {
        exc.toString();
        ja jaVar = new ja();
        jaVar.a("data", Log.getStackTraceString(exc));
        b10.a(9130075, null, 2, 2, jaVar);
    }

    public void a(boolean z) {
        int iB = b();
        if (iB == 2) {
            a20.a().a(i(), z);
            return;
        }
        if (iB == 3) {
            xu.a().a(h(), z);
        } else if (iB == 4) {
            cf.a().a(h(), z);
        } else if (iB == 5) {
            aj.b().a(h(), z);
        }
    }

    private void a(String str) throws JSONException {
        ja jaVar = new ja();
        jaVar.a("data", str);
        b10.a(9130075, null, 2, 1, jaVar);
    }
}
