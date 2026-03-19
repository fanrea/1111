package com.bytedance.bdtracker;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.bdtracker.l0;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class j0 {
    public static final AtomicLong o = new AtomicLong(1000);
    public static b p;
    public long a;
    public final e0 b;
    public d4 c;
    public d4 d;
    public String e;
    public volatile long f;
    public int g;
    public volatile boolean i;
    public long j;
    public int k;
    public String l;
    public volatile String m;
    public long h = -1;
    public volatile boolean n = false;

    public class a implements EventBus.DataFetcher {
        public final /* synthetic */ d a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;

        public a(d dVar, boolean z, long j) {
            this.a = dVar;
            this.b = z;
            this.c = j;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", this.a.m);
                jSONObject.put("sessionId", j0.this.e);
                boolean z = true;
                jSONObject.put("isBackground", !this.b);
                if (this.c == -1) {
                    z = false;
                }
                jSONObject.put("newLaunch", z);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public static class b extends g4 {
        public /* synthetic */ b(a aVar) {
        }
    }

    public j0(e0 e0Var) {
        this.b = e0Var;
    }

    public static boolean a(t3 t3Var) {
        if (t3Var instanceof d4) {
            return ((d4) t3Var).k();
        }
        return false;
    }

    public String a() {
        return this.e;
    }

    public void a(IAppLogInstance iAppLogInstance, t3 t3Var) {
        JSONObject jSONObject;
        if (t3Var != null) {
            s1 s1Var = this.b.i;
            t3Var.m = iAppLogInstance.getAppId();
            t3Var.f = this.a;
            t3Var.g = s1Var.k();
            t3Var.h = s1Var.l();
            t3Var.i = s1Var.i();
            t3Var.e = this.e;
            t3Var.d = o.incrementAndGet();
            String strA = t3Var.j;
            String strA2 = s1Var.a();
            if (TextUtils.isEmpty(strA)) {
                strA = strA2;
            } else if (!TextUtils.isEmpty(strA2)) {
                Set<String> setC = s1Var.c(strA2);
                setC.addAll(s1Var.c(strA));
                strA = s1Var.a(setC);
            }
            t3Var.j = strA;
            t3Var.k = s4.b(this.b.b(), true).a;
            if (!(t3Var instanceof a4) || this.h <= 0 || !l0.b.a(((a4) t3Var).u, "$crash") || (jSONObject = t3Var.o) == null) {
                return;
            }
            try {
                jSONObject.put("$session_duration", System.currentTimeMillis() - this.h);
            } catch (Throwable unused) {
            }
        }
    }

    public String b() {
        return this.m;
    }

    public boolean c() {
        return this.i && this.j == 0;
    }

    public synchronized Bundle a(long j, long j2) {
        Bundle bundle;
        bundle = null;
        long j3 = this.f;
        if (this.b.e.c.isPlayEnable() && c() && j3 > 0) {
            long j4 = j - j3;
            if (j4 > j2) {
                bundle = new Bundle();
                bundle.putInt("session_no", this.k);
                int i = this.g + 1;
                this.g = i;
                bundle.putInt("send_times", i);
                bundle.putLong("current_duration", j4 / 1000);
                bundle.putString("session_start_time", t3.b(this.h));
                this.f = j;
            }
        }
        return bundle;
    }

    public boolean a(d dVar, t3 t3Var, List<t3> list) {
        boolean z;
        d4 d4Var;
        boolean z2 = t3Var instanceof d4;
        boolean zK = z2 ? ((d4) t3Var).k() : false;
        if (this.h != -1) {
            if (this.i || !zK) {
                long j = this.j;
                if (j != 0 && t3Var.c > this.b.e.f.getLong("session_interval", 30000L) + j) {
                    this.n = true;
                    a(dVar, t3Var, list, zK);
                } else {
                    if (this.h <= t3Var.c + 7200000) {
                        z = false;
                    }
                    a(dVar, t3Var, list, zK);
                }
            } else {
                a(dVar, t3Var, list, true);
            }
            z = true;
        } else {
            a(dVar, t3Var, list, zK);
            z = true;
        }
        if (z2) {
            d4 d4Var2 = (d4) t3Var;
            if (d4Var2.k()) {
                this.j = 0L;
                list.add(t3Var);
                if (TextUtils.isEmpty(d4Var2.t) && (((d4Var = this.d) != null && (d4Var2.c - d4Var.c) - d4Var.s < 500) || ((d4Var = this.c) != null && (d4Var2.c - d4Var.c) - d4Var.s < 500))) {
                    d4Var2.t = d4Var.u;
                }
            } else {
                Bundle bundleA = a(t3Var.c, 0L);
                if (dVar != null && bundleA != null) {
                    dVar.onEventV3("play_session", bundleA, 1);
                }
                this.j = d4Var2.c;
                list.add(t3Var);
                if (!d4Var2.D) {
                    this.c = d4Var2;
                } else {
                    this.d = d4Var2;
                    this.c = null;
                }
            }
        } else if (!(t3Var instanceof b)) {
            list.add(t3Var);
        }
        a(dVar, t3Var);
        return z;
    }

    public synchronized b4 a(d dVar, t3 t3Var, List<t3> list, boolean z) {
        b4 b4Var;
        long j = t3Var instanceof b ? -1L : t3Var.c;
        this.e = UUID.randomUUID().toString();
        LogUtils.sendJsonFetcher(PointCategory.SESSION_START, new a(dVar, z, j));
        if (z && !this.b.v && TextUtils.isEmpty(this.m)) {
            this.m = this.e;
        }
        AtomicLong atomicLong = o;
        atomicLong.set(1000L);
        this.h = j;
        this.i = z;
        this.j = 0L;
        this.f = 0L;
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String string = com.bytedance.bdtracker.a.a("").append(calendar.get(1)).append(calendar.get(2)).append(calendar.get(5)).toString();
            q1 q1Var = this.b.e;
            if (TextUtils.isEmpty(this.l)) {
                this.l = q1Var.e.getString("session_last_day", "");
                this.k = q1Var.e.getInt("session_order", 0);
            }
            if (string.equals(this.l)) {
                this.k++;
            } else {
                this.l = string;
                this.k = 1;
            }
            q1Var.e.edit().putString("session_last_day", string).putInt("session_order", this.k).apply();
            this.g = 0;
            this.f = t3Var.c;
        }
        b4Var = null;
        if (j != -1) {
            b4Var = new b4();
            b4Var.m = t3Var.m;
            b4Var.e = this.e;
            b4Var.u = !this.i;
            b4Var.d = atomicLong.incrementAndGet();
            b4Var.a(this.h);
            b4Var.t = this.b.i.n();
            b4Var.s = this.b.i.m();
            b4Var.f = this.a;
            b4Var.g = this.b.i.k();
            b4Var.h = this.b.i.l();
            b4Var.i = dVar.getSsid();
            b4Var.j = dVar.getAbSdkVersion();
            b4Var.w = z ? this.b.e.f.getInt("is_first_time_launch", 1) : 0;
            if (z && b4Var.w == 1) {
                this.b.e.f.edit().putInt("is_first_time_launch", 0).apply();
            }
            d4 d4VarA = w.a();
            if (d4VarA != null) {
                b4Var.y = d4VarA.u;
                b4Var.x = d4VarA.v;
            }
            if (this.i && this.n) {
                b4Var.z = this.n;
                this.n = false;
            }
            list.add(b4Var);
        }
        d dVar2 = this.b.d;
        if (dVar2.l <= 0) {
            dVar2.l = 6;
        }
        dVar.D.debug("Start new session:{} with background:{}", this.e, Boolean.valueOf(!this.i));
        return b4Var;
    }
}
