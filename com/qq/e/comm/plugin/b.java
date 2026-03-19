package com.qq.e.comm.plugin;

import android.os.Looper;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class b {
    private static final String f = "b";
    private static final String g = gu.a("e_qq_com_setting");
    private static volatile b h;
    private volatile ku a;
    private final ConcurrentHashMap<String, ku> b = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, ku> c = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Boolean> d = new ConcurrentHashMap<>();
    private volatile boolean e = false;

    private static <T> void a(ku kuVar, String str, T t) {
    }

    public static b c() {
        if (h == null) {
            synchronized (b.class) {
                if (h == null) {
                    h = new b();
                }
            }
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            qg.c.submit(new a());
        } else {
            try {
                a(new JSONObject(m10.a(gu.d(new File(r1.d().a().getDir(g, 0), "posConfig")))));
            } catch (Throwable unused) {
            }
        }
    }

    private b() {
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject f() throws JSONException {
        jn jnVar = new jn();
        jnVar.a(PointCategory.APP, this.a.a());
        jn jnVar2 = new jn();
        for (Map.Entry<String, ku> entry : this.b.entrySet()) {
            jnVar2.a(entry.getKey(), entry.getValue().a());
        }
        jnVar.a(com.baidu.mobads.container.landingpage.aq.b, jnVar2.a());
        return jnVar.a();
    }

    public int a(ku kuVar, String str, int i) {
        return b(kuVar, str, i);
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.e();
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.b$b, reason: collision with other inner class name */
    class RunnableC0701b implements Runnable {
        RunnableC0701b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.e = false;
            String unused = b.f;
            File dir = r1.d().a().getDir(b.g, 0);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, "posConfig");
            String strB = m10.b(b.this.f().toString());
            String unused2 = b.f;
            gu.c(file, strB);
            String unused3 = b.f;
        }
    }

    public ku d() {
        return this.a;
    }

    public int a(int i, String str, int i2) {
        return a(this.b.get(String.valueOf(i)), str, i2);
    }

    private int b(ku kuVar, String str, int i) {
        JSONObject jSONObjectB;
        a(kuVar, str, Integer.valueOf(i));
        return (kuVar == null || (jSONObjectB = kuVar.b()) == null || TextUtils.isEmpty(str)) ? i : jSONObjectB.optInt(str, i);
    }

    public int a(String str, int i) {
        return a(this.a, str, i);
    }

    private String b(ku kuVar, String str, String str2) {
        JSONObject jSONObjectB;
        a(kuVar, str, str2);
        return (kuVar == null || (jSONObjectB = kuVar.b()) == null || TextUtils.isEmpty(str)) ? str2 : jSONObjectB.optString(str, str2);
    }

    public ku a(tc tcVar) {
        String strB;
        String strA = tcVar.a();
        ku kuVar = !TextUtils.isEmpty(strA) ? this.c.get(strA) : null;
        if (kuVar == null && (strB = tcVar.b()) != null) {
            kuVar = this.b.get(strB);
        }
        return kuVar == null ? this.a : kuVar;
    }

    public ku a(int i) {
        return this.b.get(String.valueOf(i));
    }

    public String a(ku kuVar, String str, String str2) {
        return b(kuVar, str, str2);
    }

    private void a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(PointCategory.APP);
        if (jSONObjectOptJSONObject != null && this.a == null) {
            this.a = new ku(jSONObjectOptJSONObject);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(com.baidu.mobads.container.landingpage.aq.b);
        if (jSONObjectOptJSONObject2 != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(next);
                if (jSONObjectOptJSONObject3 != null && this.b.get(next) == null) {
                    this.b.put(next, new ku(jSONObjectOptJSONObject3));
                }
            }
        }
    }

    public void a(ku kuVar, h4 h4Var) {
        if (kuVar.a() == null) {
            return;
        }
        this.a = kuVar;
        String strC = h4Var.k().c();
        this.b.put(strC, kuVar);
        this.c.put(h4Var.y0(), kuVar);
        a(strC);
    }

    private void a(String str) {
        if (this.d.containsKey(str)) {
            return;
        }
        this.d.put(str, Boolean.TRUE);
        if (this.e) {
            return;
        }
        this.e = true;
        qg.c.submit(new RunnableC0701b());
    }
}
