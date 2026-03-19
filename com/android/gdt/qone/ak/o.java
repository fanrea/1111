package com.android.gdt.qone.ak;

import android.content.Context;
import android.text.TextUtils;
import com.android.gdt.qone.report.beat.BeatType;
import com.android.gdt.qone.uin.U;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class o implements com.android.gdt.qone.ar.b, com.android.gdt.qone.ar.c, com.android.gdt.qone.aa.c {
    public static final ConcurrentHashMap j = new ConcurrentHashMap();
    public static final String k = "com.android.gdt.qone.sdk.QoneSDK";
    public final com.android.gdt.qone.al.a c;
    public final String d;
    public long i;
    public final List a = Collections.synchronizedList(new ArrayList(8));
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public Context e = null;
    public boolean f = false;
    public String g = "";
    public String h = "";

    public o(String str) {
        this.d = str;
        this.c = new com.android.gdt.qone.al.a(str);
    }

    public final void a(a aVar) {
        synchronized (this.a) {
            if (!this.a.contains(aVar)) {
                this.a.add(aVar);
            }
        }
    }

    public final synchronized void b(a aVar) {
        if (l()) {
            com.android.gdt.qone.v.a.a().a(new j(this, aVar));
        } else {
            a(aVar);
        }
    }

    @Override // com.android.gdt.qone.ar.b
    public final String c() {
        b bVarA = !l() ? null : com.android.gdt.qone.ap.f.a(this.d);
        return bVarA == null ? "" : bVarA.a();
    }

    @Override // com.android.gdt.qone.ar.b
    public final void d() {
        synchronized (this.a) {
            b bVarA = !l() ? null : com.android.gdt.qone.ap.f.a(this.d);
            if (bVarA != null && !bVarA.c()) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(bVarA);
                }
                this.a.clear();
            }
        }
    }

    @Override // com.android.gdt.qone.ar.b
    public final String e() {
        return new JSONObject(this.b).toString();
    }

    @Override // com.android.gdt.qone.ar.b
    public final String f() {
        b bVarA = !l() ? null : com.android.gdt.qone.ap.f.a(this.d);
        return bVarA == null ? "" : bVarA.b();
    }

    @Override // com.android.gdt.qone.ar.b
    public final String g() {
        return this.h;
    }

    @Override // com.android.gdt.qone.ar.c
    public final String getSdkVersion() {
        return "2.1.3.19";
    }

    @Override // com.android.gdt.qone.aa.c
    public final void h() {
        com.android.gdt.qone.w.c cVar;
        synchronized (com.android.gdt.qone.w.c.class) {
            cVar = com.android.gdt.qone.w.c.p;
        }
        cVar.t();
        m();
        com.android.gdt.qone.aw.b.a(this.d).a();
        com.android.gdt.qone.aj.c.a(this.d, BeatType.NET_CHANGE, com.android.gdt.qone.ac.a.a());
    }

    @Override // com.android.gdt.qone.aa.c
    public final void i() {
        com.android.gdt.qone.w.c cVar;
        synchronized (com.android.gdt.qone.w.c.class) {
            cVar = com.android.gdt.qone.w.c.p;
        }
        cVar.t();
    }

    public final synchronized boolean j() {
        TextUtils.isEmpty(this.d);
        return this.e != null;
    }

    public final void k() {
        if (TextUtils.isEmpty(com.android.gdt.qone.at.a.a(this.d).a.g)) {
            throw new AssertionError("Assertion failed: ReportDomain not Set!");
        }
        ConcurrentHashMap concurrentHashMap = com.android.gdt.qone.aq.b.a;
        com.android.gdt.qone.aq.a.a.getClass();
        ConcurrentHashMap concurrentHashMap2 = com.android.gdt.qone.aq.b.a;
        concurrentHashMap2.put("SdkInfo", this);
        concurrentHashMap2.put("BizInfo" + this.d, this);
        Context context = this.e;
        com.android.gdt.qone.an.b bVar = com.android.gdt.qone.an.a.a;
        String str = this.d;
        String str2 = k;
        String str3 = com.android.gdt.qone.at.a.a(str).a.h;
        boolean z = com.android.gdt.qone.at.a.a(this.d).a.e;
        boolean z2 = com.android.gdt.qone.at.a.a(this.d).a.f;
        synchronized (com.android.gdt.qone.an.b.class) {
            bVar.a(str, context, str2, str3, z, z2);
        }
        com.android.gdt.qone.ad.h hVarA = com.android.gdt.qone.ad.h.a(this.d);
        Context context2 = this.e;
        hVarA.e = str2;
        hVarA.c = context2;
        com.android.gdt.qone.ad.a.a(this.d).a(this.e, str2);
        com.android.gdt.qone.ad.b.a.b = this.e;
        com.android.gdt.qone.at.a.a(this.d).a();
        n();
        com.android.gdt.qone.v.a.a().a(new k(this));
        com.android.gdt.qone.v.a.a().a(new com.android.gdt.qone.ag.f(com.android.gdt.qone.ag.o.a(this.d), new l(this)));
    }

    public final synchronized boolean l() {
        boolean z;
        z = j() && this.f;
        if (!z) {
            com.android.gdt.qone.af.c.a("SDK_INIT", "appkey:%s uninitialized", this.d);
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m() {
        /*
            Method dump skipped, instructions count: 467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gdt.qone.ak.o.m():void");
    }

    public final void n() {
        com.android.gdt.qone.w.c cVar;
        synchronized (com.android.gdt.qone.w.c.class) {
            cVar = com.android.gdt.qone.w.c.p;
        }
        cVar.getClass();
        if (U.a(com.android.gdt.qone.s.b.a(23)).equals("Androws")) {
            if (!this.f) {
                this.h = "Androws";
            }
            this.b.put("guid", U.a(com.android.gdt.qone.s.b.a(24)));
            this.b.put("winQm", U.a(com.android.gdt.qone.s.b.a(22)));
        }
        if (U.a(com.android.gdt.qone.s.b.a(23)).equals("Syzs")) {
            if (!this.f) {
                this.h = "Syzs";
            }
            this.b.put("guid", U.a(com.android.gdt.qone.s.b.a(24)));
            this.b.put("winQm", U.a(com.android.gdt.qone.s.b.a(22)));
        }
    }

    @Override // com.android.gdt.qone.ar.c
    public final Context a() {
        if (this.e == null) {
            com.android.gdt.qone.af.c.a("SDK_INIT", "Context has been destroyed!!", new Object[0]);
        }
        return this.e;
    }

    @Override // com.android.gdt.qone.ar.b
    public final String b() {
        return this.g;
    }
}
