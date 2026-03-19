package com.bytedance.bdtracker;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationRequestCompat;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.applog.IHeaderCustomTimelyCallback;
import com.bytedance.applog.IPullAbTestConfigCallback;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.UriConfig;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.util.UriConstants;
import com.bytedance.bdtracker.j0;
import com.bytedance.bdtracker.l0;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class e0 implements Handler.Callback, Comparator<t3> {
    public final j3 A;
    public final j B;
    public final k1 C;
    public long D;
    public final g3 F;
    public b0 b;
    public boolean c;
    public final com.bytedance.bdtracker.d d;
    public final q1 e;
    public d0 f;
    public volatile z3 h;
    public final s1 i;
    public volatile Handler j;
    public h0 k;
    public i0 l;
    public volatile a0 m;
    public UriConfig o;
    public final Handler p;
    public i2 q;
    public volatile boolean r;
    public c0 s;
    public volatile g0 t;
    public volatile boolean v;
    public volatile long w;
    public volatile b1 y;
    public volatile InitConfig.IpcDataChecker z;
    public long a = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
    public final ArrayList<t3> g = new ArrayList<>(32);
    public final CopyOnWriteArrayList<c0> u = new CopyOnWriteArrayList<>();
    public final List<d> x = new ArrayList();
    public final j0 n = new j0(this);
    public final f0 E = new f0(this);

    public class a implements EventBus.DataFetcher {
        public a() {
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", e0.this.d.m);
                jSONObject.put("isMainProcess", e0.this.e.h());
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public class b implements g {
        public b() {
        }

        public void a(Map<String, String> map) {
            if (e0.this.i.e() == null || e0.this.i.e().opt("oaid") != null || map == null) {
                return;
            }
            e0.this.j.obtainMessage(17, map).sendToTarget();
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ List a;

        public c(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            List list = this.a;
            if (list == null || list.size() <= 0) {
                return;
            }
            c4 c4Var = new c4();
            e0 e0Var = e0.this;
            i0 i0Var = e0Var.l;
            JSONObject jSONObjectA = l0.b.a(e0Var.i.e());
            IHeaderCustomTimelyCallback headerCustomCallback = i0Var.f.getHeaderCustomCallback();
            if (headerCustomCallback != null) {
                headerCustomCallback.updateHeader(jSONObjectA);
            }
            c4Var.y = jSONObjectA;
            c4Var.m = e0.this.d.m;
            ArrayList arrayList = new ArrayList();
            for (t3 t3Var : this.a) {
                if (t3Var instanceof a4) {
                    arrayList.add((a4) t3Var);
                }
            }
            c4Var.s = arrayList;
            c4Var.m();
            c4Var.n();
            c4Var.z = c4Var.o();
            if (!e0.this.l.a(c4Var)) {
                e0.this.D = System.currentTimeMillis();
                e0.this.p.obtainMessage(8, this.a).sendToTarget();
            } else {
                e0 e0Var2 = e0.this;
                e0Var2.D = 0L;
                z3 z3VarC = e0Var2.c();
                z3VarC.c.a(this.a);
            }
        }
    }

    public static abstract class d<T> {
        public T a;

        public d(T t) {
            this.a = t;
        }
    }

    public class e extends d<String> {
        public e(String str) {
            super(str);
        }
    }

    public e0(com.bytedance.bdtracker.d dVar, q1 q1Var, s1 s1Var, k1 k1Var) {
        this.d = dVar;
        this.e = q1Var;
        this.i = s1Var;
        this.C = k1Var;
        HandlerThread handlerThread = new HandlerThread(com.bytedance.bdtracker.a.a("bd_tracker_w:").append(dVar.m).toString());
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.p = handler;
        j jVar = new j(this);
        this.B = jVar;
        if (q1Var.c.isDeferredALinkEnabled()) {
            dVar.addDataObserver(jVar);
        }
        ((m4) s1Var.h).b.a(handler);
        if (s1Var.c.c.isMigrateEnabled()) {
            Context context = s1Var.b;
            try {
                try {
                    if (h2.a(context).c) {
                        q1 q1Var2 = s1Var.c;
                        if (q1Var2 != null) {
                            q1Var2.f.edit().remove("google_aid").apply();
                        }
                        SharedPreferences sharedPreferences = s1Var.g;
                        String strB = ((m4) s1Var.h).b();
                        if (sharedPreferences != null) {
                            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                            editorEdit.putString("old_did", strB);
                            editorEdit.putBoolean("is_migrate", true);
                            editorEdit.apply();
                        }
                        ((m4) s1Var.h).a("openudid");
                        ((m4) s1Var.h).a("clientudid");
                        ((m4) s1Var.h).a("serial_number");
                        ((m4) s1Var.h).a("sim_serial_number");
                        ((m4) s1Var.h).a("udid");
                        ((m4) s1Var.h).a("udid_list");
                        ((m4) s1Var.h).a(com.baidu.mobads.upgrade.remote.gray.c.l);
                        s1Var.b("clearMigrationInfo");
                    }
                } catch (Exception e2) {
                    LoggerImpl.global().debug("detect migrate is error, ", e2);
                }
                try {
                    h2.a(context).a();
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                try {
                    h2.a(context).a();
                } catch (Throwable unused2) {
                }
                throw th;
            }
        }
        this.A = new j3(this);
        if (this.e.c.isClearDidAndIid()) {
            this.i.b(this.e.c.getClearKey());
        }
        if (this.e.c.getIpcDataChecker() != null && !this.e.h()) {
            this.z = this.e.c.getIpcDataChecker();
        }
        if (this.e.i()) {
            this.q = new n2(this);
        }
        this.p.sendEmptyMessage(10);
        if (this.e.c.autoStart()) {
            i();
        }
        this.F = new g3(this);
    }

    public void a() {
        h5.a(new b());
    }

    public void a(Long l) {
        long jLongValue = 0;
        if (l != null && l.longValue() > 0) {
            jLongValue = l.longValue();
        }
        this.a = jLongValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:9:0x001f, B:15:0x003b, B:17:0x0041, B:19:0x0047, B:12:0x0030), top: B:24:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(org.json.JSONObject r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = "ssid"
            java.lang.String r2 = ""
            java.lang.String r3 = r8.optString(r1, r2)
            boolean r3 = com.bytedance.bdtracker.l0.b.d(r3)
            r4 = 1
            if (r3 == 0) goto L14
            return r4
        L14:
            com.bytedance.bdtracker.d r3 = r7.d
            com.bytedance.applog.log.IAppLogLogger r3 = r3.D
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.String r6 = "Register to get ssid by temp header..."
            r3.debug(r6, r5)
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L50
            r3.<init>()     // Catch: java.lang.Throwable -> L50
            com.bytedance.bdtracker.l0.b.a(r3, r8)     // Catch: java.lang.Throwable -> L50
            com.bytedance.bdtracker.h0 r5 = r7.k     // Catch: java.lang.Throwable -> L50
            org.json.JSONObject r3 = r5.b(r3)     // Catch: java.lang.Throwable -> L50
            if (r3 != 0) goto L30
            goto L3a
        L30:
            java.lang.String r2 = r3.optString(r1, r2)     // Catch: java.lang.Throwable -> L50
            boolean r3 = com.bytedance.bdtracker.l0.b.c(r2)     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L3b
        L3a:
            r2 = 0
        L3b:
            boolean r3 = com.bytedance.bdtracker.l0.b.d(r2)     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L5c
            com.bytedance.bdtracker.d r3 = r7.d     // Catch: java.lang.Throwable -> L50
            com.bytedance.applog.log.IAppLogLogger r3 = r3.D     // Catch: java.lang.Throwable -> L50
            java.lang.String r5 = "Register to get ssid by header success."
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L50
            r3.debug(r5, r6)     // Catch: java.lang.Throwable -> L50
            r8.put(r1, r2)     // Catch: java.lang.Throwable -> L50
            return r4
        L50:
            r8 = move-exception
            com.bytedance.bdtracker.d r1 = r7.d
            com.bytedance.applog.log.IAppLogLogger r1 = r1.D
            java.lang.Object[] r2 = new java.lang.Object[r0]
            java.lang.String r3 = "JSON handle failed"
            r1.error(r3, r8, r2)
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.e0.a(org.json.JSONObject):boolean");
    }

    public boolean a(boolean z) {
        if ((!this.c || z) && this.j != null) {
            this.c = true;
            this.j.removeMessages(11);
            this.j.sendEmptyMessage(11);
        }
        return this.c;
    }

    public Context b() {
        return this.d.n;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.A.a(jSONObject);
    }

    public z3 c() {
        if (this.h == null) {
            synchronized (this) {
                z3 z3Var = this.h;
                if (z3Var == null) {
                    z3Var = new z3(this, this.e.c.getDbName());
                }
                this.h = z3Var;
            }
        }
        return this.h;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.A.b(jSONObject);
    }

    @Override // java.util.Comparator
    public int compare(t3 t3Var, t3 t3Var2) {
        long j = t3Var.c - t3Var2.c;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    public String d() {
        j0 j0Var = this.n;
        if (j0Var != null) {
            return j0Var.e;
        }
        return null;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.A.c(jSONObject);
    }

    public UriConfig e() {
        if (this.o == null) {
            UriConfig uriConfig = this.e.c.getUriConfig();
            this.o = uriConfig;
            if (uriConfig == null) {
                this.o = UriConstants.createUriConfig(0);
            }
        }
        return this.o;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.A.d(jSONObject);
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.A.e(jSONObject);
    }

    public final boolean f() {
        return this.e.g() && !TextUtils.isEmpty(e().getAbUri());
    }

    public boolean g() {
        q1 q1Var = this.e;
        return q1Var.s == 1 && q1Var.c.isAutoTrackEnabled();
    }

    public boolean h() {
        return (this.i.g.getInt("version_code", 0) == this.i.m() && TextUtils.equals(this.e.f.getString("channel", ""), this.e.b())) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.bdtracker.j0$a] */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.bytedance.bdtracker.b1] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Map<String, ?> all;
        Set set;
        Set set2;
        String str;
        String str2;
        ?? d1Var = 0;
        String[] strArr = null;
        d1Var = 0;
        d1Var = 0;
        switch (message.what) {
            case 1:
                this.d.D.info("AppLog is starting...", new Object[0]);
                q1 q1Var = this.e;
                q1Var.s = q1Var.f.getBoolean("bav_log_collect", q1Var.c.isAutoTrackEnabled()) ? 1 : 0;
                if (this.i.q()) {
                    if (this.e.h()) {
                        HandlerThread handlerThread = new HandlerThread(com.bytedance.bdtracker.a.a("bd_tracker_n:").append(this.d.m).toString());
                        handlerThread.start();
                        this.j = new Handler(handlerThread.getLooper(), this);
                        this.j.sendEmptyMessage(2);
                        if (this.g.size() > 0) {
                            this.p.removeMessages(4);
                            this.p.sendEmptyMessageDelayed(4, 1000L);
                        }
                        Application application = this.d.n;
                        v4.a = true;
                        x.a.submit(new w4(application));
                        this.d.D.info("AppLog started on main process.", new Object[0]);
                    } else {
                        this.d.D.info("AppLog started on secondary process.", new Object[0]);
                    }
                    LogUtils.sendJsonFetcher("start_end", new a());
                } else {
                    this.d.D.info("AppLog is not ready, will try start again after 1 second...", new Object[0]);
                    this.p.removeMessages(1);
                    this.p.sendEmptyMessageDelayed(1, 1000L);
                }
                return true;
            case 2:
                h0 h0Var = new h0(this);
                this.k = h0Var;
                this.u.add(h0Var);
                InitConfig initConfig = this.e.c;
                if (!((initConfig == null || initConfig.isTrackEventEnabled()) ? false : true)) {
                    i0 i0Var = new i0(this);
                    this.l = i0Var;
                    this.u.add(i0Var);
                }
                UriConfig uriConfigE = e();
                if (!TextUtils.isEmpty(uriConfigE.getSettingUri())) {
                    d0 d0Var = new d0(this);
                    this.f = d0Var;
                    this.u.add(d0Var);
                }
                if (!TextUtils.isEmpty(uriConfigE.getProfileUri())) {
                    Handler handler = this.A.b;
                    handler.sendMessage(handler.obtainMessage(106));
                }
                this.j.removeMessages(13);
                this.j.sendEmptyMessage(13);
                String strA = com.bytedance.bdtracker.b.a(this.d, "sp_filter_name");
                if (h()) {
                    h0 h0Var2 = this.k;
                    if (h0Var2 != null) {
                        h0Var2.b = true;
                    }
                    d0 d0Var2 = this.f;
                    if (d0Var2 != null) {
                        d0Var2.b = true;
                    }
                    if (this.e.c.isEventFilterEnable()) {
                        this.y = b1.a(this.d.n, strA, null);
                    }
                } else if (this.e.c.isEventFilterEnable()) {
                    try {
                        SharedPreferences sharedPreferencesA = f4.a(this.d.n, strA, 0);
                        HashSet hashSet = new HashSet();
                        HashMap map = new HashMap();
                        try {
                            all = sharedPreferencesA.getAll();
                        } catch (Throwable unused) {
                            all = null;
                        }
                        if (all != null && all.size() > 0) {
                            int i = 0;
                            for (Map.Entry<String, ?> entry : all.entrySet()) {
                                if (entry != null) {
                                    String key = entry.getKey();
                                    if ("is_block".equals(key)) {
                                        i = sharedPreferencesA.getInt("is_block", 0);
                                    } else if ("events".equals(key)) {
                                        try {
                                            set2 = (Set) entry.getValue();
                                        } catch (Throwable unused2) {
                                            set2 = null;
                                        }
                                        if (set2 != null && set2.size() > 0) {
                                            hashSet.addAll(set2);
                                        }
                                    } else if (!TextUtils.isEmpty(key)) {
                                        HashSet hashSet2 = new HashSet();
                                        try {
                                            set = (Set) entry.getValue();
                                        } catch (Throwable unused3) {
                                            set = null;
                                        }
                                        if (set != null && set.size() > 0) {
                                            hashSet2.addAll(set);
                                        }
                                        if (hashSet2.size() > 0) {
                                            map.put(key, hashSet2);
                                        }
                                    }
                                }
                            }
                            d1Var = i > 0 ? new d1(hashSet, map) : new c1(hashSet, map);
                        }
                    } catch (Throwable unused4) {
                    }
                    this.y = d1Var;
                }
                this.j.removeMessages(6);
                this.j.sendEmptyMessage(6);
                i2 i2Var = this.q;
                if (i2Var != null) {
                    n2 n2Var = (n2) i2Var;
                    q1 q1Var2 = n2Var.c.e;
                    Intrinsics.checkExpressionValueIsNotNull(q1Var2, "mEngine.config");
                    if (q1Var2.i()) {
                        n2Var.b.a(new m2(n2Var));
                    }
                }
                return true;
            case 3:
            case 5:
            default:
                this.d.D.error("Unknown handler message type", new Object[0]);
                return true;
            case 4:
                a((String[]) message.obj, false);
                return true;
            case 6:
                this.j.removeMessages(6);
                long j = 5000;
                if (!this.d.x && (!this.e.c.isSilenceInBackground() || this.n.c())) {
                    long j2 = LocationRequestCompat.PASSIVE_INTERVAL;
                    Iterator<c0> it = this.u.iterator();
                    while (it.hasNext()) {
                        c0 next = it.next();
                        if (!next.d) {
                            long jA = next.a();
                            if (jA < j2) {
                                j2 = jA;
                            }
                        }
                    }
                    long jCurrentTimeMillis = j2 - System.currentTimeMillis();
                    if (jCurrentTimeMillis <= 5000) {
                        j = jCurrentTimeMillis;
                    }
                }
                this.j.sendEmptyMessageDelayed(6, j);
                if (this.x.size() > 0) {
                    synchronized (this.x) {
                        for (d dVar : this.x) {
                            if (dVar != null) {
                                e eVar = (e) dVar;
                                e0.this.a((String) eVar.a);
                            }
                        }
                        this.x.clear();
                    }
                }
                return true;
            case 7:
                synchronized (this.g) {
                    ArrayList<t3> arrayList = this.g;
                    if (j0.p == null) {
                        j0.p = new j0.b(d1Var);
                    }
                    j0.p.a(0L);
                    arrayList.add(j0.p);
                }
                a((String[]) null, false);
                return true;
            case 8:
                c().c.b((ArrayList) message.obj);
                return true;
            case 9:
                c0 c0Var = this.s;
                if (!c0Var.d) {
                    long jA2 = c0Var.a();
                    if (!c0Var.d) {
                        this.j.sendEmptyMessageDelayed(9, jA2 - System.currentTimeMillis());
                    }
                }
                return true;
            case 10:
                synchronized (this.g) {
                    this.C.a(this.g);
                }
                k1 k1Var = this.C;
                int size = k1Var.b.size();
                if (size > 0) {
                    strArr = new String[size];
                    k1Var.b.toArray(strArr);
                    k1Var.b.clear();
                }
                a(strArr, false);
                return true;
            case 11:
                b0 b0Var = this.b;
                if (b0Var == null) {
                    b0 b0Var2 = new b0(this);
                    this.b = b0Var2;
                    this.u.add(b0Var2);
                } else {
                    b0Var.d = false;
                }
                a(this.b);
                return true;
            case 12:
                Object obj = message.obj;
                a(obj != null ? obj.toString() : null);
                return true;
            case 13:
                if (f()) {
                    if (this.m == null) {
                        this.m = new a0(this);
                    }
                    if (!this.u.contains(this.m)) {
                        this.u.add(this.m);
                    }
                    a(this.m);
                } else {
                    if (this.m != null) {
                        this.m.d = true;
                        this.u.remove(this.m);
                        this.m = null;
                    }
                    s1 s1Var = this.i;
                    s1Var.e(null);
                    s1Var.f("");
                    s1Var.a((JSONObject) null);
                }
                return true;
            case 14:
                a((String[]) null, true);
                return true;
            case 15:
                Object[] objArr = (Object[]) message.obj;
                boolean zBooleanValue = ((Boolean) objArr[0]).booleanValue();
                String str3 = (String) objArr[1];
                if (this.t != null) {
                    this.t.d = true;
                    this.u.remove(this.t);
                    this.t = null;
                }
                if (zBooleanValue) {
                    this.t = new g0(this, str3);
                    this.u.add(this.t);
                    this.j.removeMessages(6);
                    this.j.sendEmptyMessage(6);
                }
                return true;
            case 16:
                b((t3) message.obj);
                return true;
            case 17:
                Map map2 = (Map) message.obj;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("oaid", new JSONObject(map2));
                    String strC = this.i.c();
                    String strF = this.i.f();
                    jSONObject.put("bd_did", strC);
                    jSONObject.put("install_id", strF);
                    if (y4.c.b(new Object[0]).booleanValue()) {
                        str = "os";
                        str2 = "Harmony";
                    } else {
                        str = "os";
                        str2 = "Android";
                    }
                    jSONObject.put(str, str2);
                    jSONObject.put("aid", this.i.b());
                    this.d.D.debug("Report oaid success: {}", this.k.c(jSONObject));
                } catch (Throwable th) {
                    this.d.D.error("Report oaid failed", th, new Object[0]);
                }
                return true;
            case 18:
                Object obj2 = message.obj;
                if (obj2 instanceof IPullAbTestConfigCallback) {
                    int i2 = message.arg1;
                    IPullAbTestConfigCallback iPullAbTestConfigCallback = (IPullAbTestConfigCallback) obj2;
                    if (f()) {
                        if (this.m == null) {
                            this.m = new a0(this);
                        }
                        try {
                            JSONObject jSONObjectA = this.m.a(i2);
                            if (iPullAbTestConfigCallback != null) {
                                iPullAbTestConfigCallback.onRemoteConfig(jSONObjectA);
                            }
                        } catch (f3 unused5) {
                            if (iPullAbTestConfigCallback != null) {
                                iPullAbTestConfigCallback.onTimeoutError();
                            }
                        }
                    } else {
                        this.d.D.warn("ABTest is not enabled", new Object[0]);
                    }
                } else {
                    a(this.m);
                }
                return true;
        }
    }

    public final void i() {
        this.r = true;
        s1 s1Var = this.i;
        if (s1Var.c.j()) {
            h5.a.b(s1Var.b).a();
        }
        this.p.sendEmptyMessage(1);
    }

    public void b(t3 t3Var) {
        if (this.t == null) {
            return;
        }
        if ((t3Var instanceof a4) || (((t3Var instanceof d4) && g()) || (t3Var instanceof w3) || (t3Var instanceof e4))) {
            JSONObject jSONObjectH = t3Var.h();
            if (t3Var instanceof d4) {
                if (!((d4) t3Var).k()) {
                    return;
                }
                JSONObject jSONObjectOptJSONObject = jSONObjectH.optJSONObject("params");
                if (jSONObjectOptJSONObject != null) {
                    try {
                        jSONObjectOptJSONObject.remove("duration");
                        jSONObjectH.put("params", jSONObjectOptJSONObject);
                    } catch (Throwable unused) {
                    }
                }
            }
            if ((t3Var instanceof w3) && !jSONObjectH.has(NotificationCompat.CATEGORY_EVENT)) {
                try {
                    jSONObjectH.put(NotificationCompat.CATEGORY_EVENT, jSONObjectH.optString("log_type", ((w3) t3Var).s));
                } catch (Throwable unused2) {
                }
            }
            this.d.k.a(jSONObjectH, this.t.g);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String[] r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 625
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.e0.a(java.lang.String[], boolean):void");
    }

    public void a(t3 t3Var) {
        int size;
        if (t3Var.c == 0) {
            this.d.D.warn("Data ts is 0", new Object[0]);
        }
        synchronized (this.g) {
            size = this.g.size();
            this.g.add(t3Var);
        }
        boolean z = t3Var instanceof d4;
        if (size % 10 == 0 || z) {
            this.p.removeMessages(4);
            if (z || size != 0) {
                this.p.sendEmptyMessage(4);
            } else {
                this.p.sendEmptyMessageDelayed(4, 200L);
            }
        }
    }

    public final void a(String str) {
        JSONObject jSONObject = new JSONObject();
        l0.b.a(jSONObject, this.i.e());
        try {
            h0 h0Var = this.k;
            if (h0Var == null || !h0Var.a(jSONObject)) {
                return;
            }
            if (l0.b.d(str)) {
                this.e.f.edit().putInt("is_first_time_launch", 1).apply();
            }
            a(true);
        } catch (Throwable th) {
            this.d.D.error("Register new uuid:{} failed", th, str);
        }
    }

    public final void a(List<t3> list) {
        x.a.execute(new c(list));
    }

    public final void a(String str, String str2) {
        boolean zIsEmpty = TextUtils.isEmpty(this.i.k());
        this.i.h(str);
        this.i.i(str2);
        this.i.g("");
        this.i.d("$tr_web_ssid");
        if (this.e.c.isClearABCacheOnUserChange() && !zIsEmpty) {
            this.i.e(null);
        }
        this.v = true;
        if (this.j != null) {
            this.j.sendMessage(this.j.obtainMessage(12, str));
            return;
        }
        synchronized (this.x) {
            this.x.add(new e(str));
        }
    }

    public final void a(c0 c0Var) {
        if (this.j == null || c0Var == null || this.d.x) {
            return;
        }
        c0Var.b = true;
        if (Looper.myLooper() == this.j.getLooper()) {
            c0Var.a();
        } else {
            this.j.removeMessages(6);
            this.j.sendEmptyMessage(6);
        }
    }
}
