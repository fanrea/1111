package com.bytedance.framwork.core.de;

import android.content.Context;
import com.bytedance.framwork.core.de.ha.e;
import com.bytedance.framwork.core.de.ha.f;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: LogReportManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements com.bytedance.framwork.core.de.gh.b {
    private c d;
    private String e;
    private Context f;
    private JSONObject g;
    private long j;
    private long k;
    private long a = 0;
    private int b = 120;
    private int c = 100;
    private volatile boolean h = true;
    private volatile boolean i = false;

    @Override // com.bytedance.framwork.core.de.gh.b
    public void onTimeEvent(long j) {
        long j2 = this.k;
        if (j2 > 0 && j - this.j > j2) {
            e();
        }
        a(false);
    }

    public b(Context context, String str) {
        this.f = context;
        this.d = c.a(context);
        this.e = str;
    }

    public void a() {
        com.bytedance.framwork.core.de.gh.c.a().a(this);
        com.bytedance.framwork.core.de.fg.d.a(this.e, new com.bytedance.framwork.core.de.fg.a(this.f, this.e));
    }

    private List<com.bytedance.framwork.core.de.ef.a> a(int i) throws NumberFormatException {
        return this.d.a(Integer.parseInt(this.e), i);
    }

    private long g() {
        return this.d.a(this.e);
    }

    public boolean a(boolean z) {
        if (!this.h || this.i) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jG = g();
        if (jG <= 0) {
            return true;
        }
        if (!z && jG <= this.c && (jCurrentTimeMillis - this.a) / 1000 <= this.b) {
            return false;
        }
        this.a = jCurrentTimeMillis;
        return c();
    }

    private int b(long j) {
        return this.d.a(this.e, j);
    }

    public int b() {
        return b(2147483647L);
    }

    public boolean c() throws NumberFormatException {
        List<com.bytedance.framwork.core.de.ef.a> listA = a(this.c);
        if (f.a(listA)) {
            return true;
        }
        long j = -1;
        boolean zA = false;
        try {
            JSONArray jSONArray = new JSONArray();
            LinkedList linkedList = new LinkedList();
            for (com.bytedance.framwork.core.de.ef.a aVar : listA) {
                long j2 = aVar.a;
                if (j2 > j) {
                    j = j2;
                }
                String str = aVar.e;
                linkedList.add(aVar);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("log_id", j2);
                    jSONObject.put("d_s_t", System.currentTimeMillis());
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("payload", jSONObject);
                    jSONObject2.put("log_type", jSONObject.opt("log_type"));
                    jSONArray.put(jSONObject2);
                } catch (Throwable unused) {
                }
            }
            zA = a(jSONArray, false);
            if (zA) {
                b(j);
            }
        } catch (Throwable unused2) {
        }
        return zA;
    }

    private boolean a(JSONArray jSONArray, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (e.a(jSONArray)) {
                return false;
            }
            jSONObject.put("data", jSONArray);
            JSONObject jSONObject2 = this.g;
            if (jSONObject2 == null) {
                return true;
            }
            jSONObject.put("header", jSONObject2);
            return com.bytedance.framwork.core.de.fg.d.a(this.e, jSONObject.toString());
        } catch (Throwable unused) {
            return false;
        }
    }

    public void d() {
        b(com.bytedance.framwork.core.de.de.c.a(this.e));
        c(com.bytedance.framwork.core.de.de.c.b(this.e));
        a(com.bytedance.framwork.core.de.de.c.c(this.e));
        com.bytedance.framwork.core.de.fg.b bVarB = com.bytedance.framwork.core.de.fg.d.b(this.e);
        if (bVarB instanceof com.bytedance.framwork.core.de.fg.a) {
            ((com.bytedance.framwork.core.de.fg.a) bVarB).b((String) null);
        }
    }

    private void b(int i) {
        if (i <= 0) {
            return;
        }
        this.b = i;
    }

    private void c(int i) {
        if (i <= 0) {
            return;
        }
        this.c = i;
    }

    private void a(JSONObject jSONObject) {
        this.g = jSONObject;
    }

    public void a(long j) {
        this.h = false;
        this.j = System.currentTimeMillis();
        this.k = j;
    }

    public void e() {
        this.h = true;
        this.k = 0L;
    }

    public void f() {
        this.i = true;
    }
}
