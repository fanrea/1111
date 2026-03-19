package com.qq.e.comm.plugin;

import android.database.Cursor;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class f50 {
    private final Map<String, JSONArray> a;
    private final Set<String> b;
    private final Set<String> c;
    private final boolean d;
    private final int e;
    private long f;

    /* compiled from: A */
    private static class c {
        private static final f50 a = new f50(null);
    }

    static /* synthetic */ long a(f50 f50Var, long j) {
        return pro.getJresult(161, 1, f50Var, Long.valueOf(j));
    }

    public static f50 a() {
        return (f50) pro.getobjresult(162, 1, new Object[0]);
    }

    private File a(String str) {
        return (File) pro.getobjresult(163, 0, this, str);
    }

    private String a(String str, String str2) {
        return (String) pro.getobjresult(164, 0, this, str, str2);
    }

    private JSONObject a(File file, String str, String str2, Cursor cursor) {
        return (JSONObject) pro.getobjresult(165, 0, this, file, str, str2, cursor);
    }

    private void a(long j, int i, f5 f5Var) {
        pro.getVresult(166, 0, this, Long.valueOf(j), Integer.valueOf(i), f5Var);
    }

    static /* synthetic */ void a(f50 f50Var, long j, int i, f5 f5Var) {
        pro.getVresult(167, 1, f50Var, Long.valueOf(j), Integer.valueOf(i), f5Var);
    }

    static /* synthetic */ void a(f50 f50Var, String str, JSONArray jSONArray) {
        pro.getVresult(168, 1, f50Var, str, jSONArray);
    }

    static /* synthetic */ void a(f50 f50Var, boolean z, long j, int i, int i2) {
        pro.getVresult(169, 1, f50Var, Boolean.valueOf(z), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
    }

    private void a(String str, JSONArray jSONArray) {
        pro.getVresult(170, 0, this, str, jSONArray);
    }

    private void a(boolean z, long j, int i, int i2) {
        pro.getVresult(171, 0, this, Boolean.valueOf(z), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
    }

    static /* synthetic */ boolean a(f50 f50Var, String str, String str2) {
        return pro.getZresult(172, 1, f50Var, str, str2);
    }

    private JSONArray b(String str) {
        return (JSONArray) pro.getobjresult(173, 0, this, str);
    }

    static /* synthetic */ void b(f50 f50Var, String str, String str2) {
        pro.getVresult(174, 1, f50Var, str, str2);
    }

    private void b(String str, JSONArray jSONArray) {
        pro.getVresult(175, 0, this, str, jSONArray);
    }

    private boolean c(String str, String str2) {
        return pro.getZresult(176, 0, this, str, str2);
    }

    private void d(String str, String str2) {
        pro.getVresult(177, 0, this, str, str2);
    }

    public void a(String str, String str2, Cursor cursor) {
        pro.getVresult(178, 0, this, str, str2, cursor);
    }

    public void a(JSONObject jSONObject, String str, e2 e2Var) {
        pro.getVresult(179, 0, this, jSONObject, str, e2Var);
    }

    public JSONArray b(String str, String str2) {
        return (JSONArray) pro.getobjresult(180, 0, this, str, str2);
    }

    public boolean b() {
        return pro.getZresult(181, 0, this);
    }

    private f50() {
        this.a = new HashMap();
        this.b = new HashSet();
        this.c = new HashSet();
        int iA = r1.d().f().a("wgpde", 1);
        iA = iA > 2 ? com.qq.e.comm.plugin.b.c().a(String.valueOf(iA), 1) : iA;
        this.e = iA;
        this.d = iA > 0;
    }

    /* synthetic */ f50(a aVar) {
        this();
    }

    /* compiled from: A */
    class a extends ez {
        final /* synthetic */ String a;
        final /* synthetic */ long b;
        final /* synthetic */ int c;
        final /* synthetic */ AtomicInteger d;
        final /* synthetic */ String e;
        final /* synthetic */ JSONArray f;

        a(String str, long j, int i, AtomicInteger atomicInteger, String str2, JSONArray jSONArray) {
            this.a = str;
            this.b = j;
            this.c = i;
            this.d = atomicInteger;
            this.e = str2;
            this.f = jSONArray;
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) {
            if (!this.a.equals(gp.a(file))) {
                file.delete();
                f50.a(f50.this, false, this.b, this.c, 8);
            } else if (this.d.incrementAndGet() == this.c) {
                f50.a(f50.this, this.e, this.f);
                f50.a(f50.this, true, this.b, this.c, 0);
            }
        }

        @Override // com.qq.e.comm.plugin.ez, com.qq.e.comm.plugin.bb
        public void a(db dbVar) {
            f50.a(f50.this, false, this.b, this.c, dbVar.a());
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ String b;
        final /* synthetic */ e2 c;

        b(JSONObject jSONObject, String str, e2 e2Var) {
            this.a = jSONObject;
            this.b = str;
            this.c = e2Var;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            k50 k50VarA = h4.a(this.a);
            f5 f5VarA = new f5().c(this.b).a(this.c).b(this.a.optInt("producttype")).a(this.a.optString("cl")).a(this.a);
            if (f50.a(f50.this, k50VarA.c, k50VarA.d)) {
                f50.a(f50.this, 0L);
                b10.a(5000024, f5VarA);
                return;
            }
            JSONObject jSONObjectA = i50.a(k50VarA);
            long jCurrentTimeMillis = System.currentTimeMillis();
            b10.a(5000015, f5VarA);
            int iA = i50.a(jSONObjectA, 2);
            f50.b(f50.this, k50VarA.c, k50VarA.d);
            f50.a(f50.this, jCurrentTimeMillis, iA, f5VarA);
        }
    }
}
