package com.qq.e.comm.plugin;

import android.os.SystemClock;
import android.util.Pair;
import com.qq.e.comm.util.GDTLogger;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class fo {
    private static int a = 10;
    private static d20 b = new d20(f());
    private static final boolean c;
    private static final AtomicBoolean d;
    private static final AtomicBoolean e;
    private static volatile long f;
    private static final AtomicBoolean g;
    private static final AtomicBoolean h;

    /* compiled from: A */
    public interface c {
        void a(eo eoVar);

        void a(JSONObject jSONObject);
    }

    static {
        c = r1.d().f().a("laibg", 1) == 1;
        d = new AtomicBoolean(false);
        e = new AtomicBoolean(false);
        g = new AtomicBoolean(true);
        h = new AtomicBoolean(true);
    }

    private static int a(j jVar) {
        return pro.getIresult(644, 1, jVar);
    }

    static /* synthetic */ Pair a(w1 w1Var, JSONObject jSONObject, j jVar, aw awVar) throws JSONException {
        return (Pair) pro.getobjresult(645, 1, w1Var, jSONObject, jVar, awVar);
    }

    private static eo a(String str) {
        return (eo) pro.getobjresult(646, 1, str);
    }

    static /* synthetic */ String a(boolean z) {
        return (String) pro.getobjresult(647, 1, Boolean.valueOf(z));
    }

    private static JSONArray a(JSONObject jSONObject, JSONObject jSONObject2, j jVar) {
        return (JSONArray) pro.getobjresult(648, 1, jSONObject, jSONObject2, jVar);
    }

    private static JSONObject a(boolean z, JSONObject jSONObject, j jVar) throws JSONException {
        return (JSONObject) pro.getobjresult(649, 1, Boolean.valueOf(z), jSONObject, jVar);
    }

    static /* synthetic */ void a() {
        pro.getVresult(650, 1, new Object[0]);
    }

    private static void a(j jVar, long j) {
        pro.getVresult(651, 1, jVar, Long.valueOf(j));
    }

    static /* synthetic */ void a(j jVar, long j, boolean z, int i) {
        pro.getVresult(652, 1, jVar, Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(i));
    }

    static /* synthetic */ void a(w1 w1Var) {
        pro.getVresult(653, 1, w1Var);
    }

    public static void a(w1 w1Var, j jVar, c cVar) {
        pro.getVresult(654, 1, w1Var, jVar, cVar);
    }

    static /* synthetic */ void a(w1 w1Var, j jVar, c cVar, String str) {
        pro.getVresult(655, 1, w1Var, jVar, cVar, str);
    }

    private static void a(JSONObject jSONObject, int i, String str, JSONObject jSONObject2, double d2, boolean z, aw awVar) throws JSONException {
        pro.getVresult(656, 1, jSONObject, Integer.valueOf(i), str, jSONObject2, Double.valueOf(d2), Boolean.valueOf(z), awVar);
    }

    private static void a(JSONObject jSONObject, j jVar) {
        pro.getVresult(657, 1, jSONObject, jVar);
    }

    private static boolean a(e2 e2Var) {
        return pro.getZresult(658, 1, e2Var);
    }

    private static boolean a(JSONObject jSONObject) {
        return pro.getZresult(659, 1, jSONObject);
    }

    private static Pair<JSONObject, Boolean> b(w1 w1Var, JSONObject jSONObject, j jVar, aw awVar) throws JSONException {
        return (Pair) pro.getobjresult(660, 1, w1Var, jSONObject, jVar, awVar);
    }

    private static String b(boolean z) {
        return (String) pro.getobjresult(661, 1, Boolean.valueOf(z));
    }

    static /* synthetic */ AtomicBoolean b() {
        return (AtomicBoolean) pro.getobjresult(662, 1, new Object[0]);
    }

    private static void b(e2 e2Var) {
        pro.getVresult(663, 1, e2Var);
    }

    private static void b(j jVar, long j, boolean z, int i) {
        pro.getVresult(664, 1, jVar, Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(i));
    }

    private static void b(w1 w1Var) {
        pro.getVresult(665, 1, w1Var);
    }

    private static void b(w1 w1Var, j jVar, c cVar, String str) {
        pro.getVresult(666, 1, w1Var, jVar, cVar, str);
    }

    static /* synthetic */ void c() {
        pro.getVresult(667, 1, new Object[0]);
    }

    private static void c(w1 w1Var) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_PRECISE_PAUSE_PTS, 1, w1Var);
    }

    public static String d() {
        return (String) pro.getobjresult(669, 1, new Object[0]);
    }

    public static String e() {
        return (String) pro.getobjresult(670, 1, new Object[0]);
    }

    private static int f() {
        return pro.getIresult(671, 1, new Object[0]);
    }

    private static boolean g() {
        return pro.getZresult(672, 1, new Object[0]);
    }

    private static void h() {
        pro.getVresult(673, 1, new Object[0]);
    }

    private static void i() {
        pro.getVresult(674, 1, new Object[0]);
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ w1 a;
        final /* synthetic */ j b;
        final /* synthetic */ c c;

        a(w1 w1Var, j jVar, c cVar) {
            this.a = w1Var;
            this.b = jVar;
            this.c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            w1 w1Var = this.a;
            fo.a(w1Var, this.b, this.c, fo.a(w1Var.K()));
        }
    }

    /* compiled from: A */
    class b extends hz {
        final /* synthetic */ j a;
        final /* synthetic */ w1 b;
        final /* synthetic */ int c;
        final /* synthetic */ AtomicLong d;
        final /* synthetic */ c e;
        final /* synthetic */ f5 f;
        final /* synthetic */ long g;

        b(j jVar, w1 w1Var, int i, AtomicLong atomicLong, c cVar, f5 f5Var, long j) {
            this.a = jVar;
            this.b = w1Var;
            this.c = i;
            this.d = atomicLong;
            this.e = cVar;
            this.f = f5Var;
            this.g = j;
        }

        @Override // com.qq.e.comm.plugin.hz
        public void a(aw awVar, int i, Exception exc) throws Throwable {
            System.currentTimeMillis();
            this.e.a(new eo(exc, i));
            go.a(this.a, this.b, i, false, this.c);
            p20.a("#loadADRes#", exc, new Object[0]);
            fo.a(this.b);
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) throws Throwable {
            String strC;
            int iA;
            int iA2 = hwVar.a();
            if (iA2 == 200) {
                fo.a();
                go.b(this.a, this.b, false, this.c);
                try {
                    try {
                        strC = hwVar.c();
                    } catch (JSONException e) {
                        e = e;
                        strC = null;
                    }
                } catch (Throwable th) {
                    go.a(this.a, this.b, th);
                    this.e.a(new eo(th, 3000));
                }
                try {
                    p20.a("#loadADRes#", strC, new Object[0]);
                    fo.a(this.a, this.d.get(), awVar.a(), (d2.a() * 10) + this.c);
                    JSONObject jSONObject = new JSONObject(strC);
                    sf.l().a(jSONObject);
                    hl.a(this.b, jSONObject);
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    Pair pairA = fo.a(this.b, jSONObject, this.a, awVar);
                    this.e.a((JSONObject) pairA.first);
                    if (((Boolean) pairA.second).booleanValue()) {
                        wt wtVarB = new wt(2130305).b(SystemClock.elapsedRealtime() - jElapsedRealtime).b(fo.b().compareAndSet(true, false) ? 1 : 0);
                        wtVarB.a(this.f);
                        b10.a(wtVarB);
                        wt wtVarB2 = new wt(2130306).b(System.currentTimeMillis() - this.g);
                        if (iu.c()) {
                            iA = iu.a() + 10;
                        } else {
                            iA = iu.a();
                        }
                        wt wtVarB3 = wtVarB2.b(iA);
                        wtVarB3.a(this.f);
                        b10.a(wtVarB3);
                    }
                    fo.c();
                } catch (JSONException e2) {
                    e = e2;
                    go.a(this.a, this.b, strC);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.putOpt("ej", s60.a(strC));
                    } catch (JSONException unused) {
                    }
                    this.e.a(new eo(jSONObject2.toString(), e, 5001));
                    vv.i();
                    fo.a(this.b);
                    return;
                }
                vv.i();
                fo.a(this.b);
                return;
            }
            go.a(this.a, this.b, iA2, false, this.c);
            GDTLogger.e("网络异常，Http状态码非200，状态码为:" + iA2);
            this.e.a(new eo("HttpStatus error", 3001));
            p20.a("#loadADRes#", "网络异常，Http状态码非200，状态码为:%s", Integer.valueOf(iA2));
            fo.a(this.b);
        }
    }
}
