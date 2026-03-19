package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class r0 implements sk {
    protected static final String i = g1.o;
    protected JSONObject b;
    private final String c;
    private e2 d;
    private volatile e1 f;
    protected volatile int g;
    protected volatile CopyOnWriteArrayList<JSONObject> a = new CopyOnWriteArrayList<>();
    private final Lock e = new ReentrantLock(true);
    private boolean h = false;

    public abstract JSONObject e();

    protected abstract boolean e(JSONObject jSONObject);

    public r0(String str, e2 e2Var) {
        this.c = str;
        this.d = e2Var;
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = r0.i;
            r0.this.e.lock();
            try {
                try {
                } catch (Throwable th) {
                    String str2 = r0.i;
                    r0.this.e.unlock();
                    throw th;
                }
            } catch (Throwable unused) {
                String str3 = r0.i;
            }
            if (r0.this.a.isEmpty()) {
                gu.f(r0.this.c).delete();
                r0.this.e.unlock();
                return;
            }
            int size = r0.this.a.size();
            for (int i = 0; i < size; i++) {
                q8.a().a(r0.this.d, r0.this.a.get(i));
            }
            HashMap map = new HashMap();
            map.put("list", new ArrayList(r0.this.a));
            map.put("ctrl_config", r1.d().f().b(r0.this.c));
            JSONObject jSONObject = new JSONObject(map);
            File fileI = gu.i();
            if (!fileI.exists()) {
                fileI.mkdir();
            }
            gu.c(gu.f(r0.this.c), jSONObject.toString());
            String str4 = r0.i;
            r0.this.e.unlock();
        }
    }

    @Override // com.qq.e.comm.plugin.sk
    public void b(e1 e1Var, boolean z) {
        CopyOnWriteArrayList<JSONObject> copyOnWriteArrayListA = e1Var.a();
        if (copyOnWriteArrayListA.isEmpty()) {
            if (z && this.h) {
                c();
                return;
            }
            return;
        }
        if (this.a.isEmpty()) {
            a(e1Var, false);
        } else {
            CopyOnWriteArrayList<JSONObject> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.addAll(this.a);
            copyOnWriteArrayList.addAll(copyOnWriteArrayListA);
            this.a = copyOnWriteArrayList;
            this.f = new e1(copyOnWriteArrayList);
        }
        if (z) {
            c();
        } else {
            this.h = true;
        }
    }

    protected JSONObject a(String str) {
        Iterator<JSONObject> it = this.a.iterator();
        while (it.hasNext()) {
            JSONObject next = it.next();
            if (TextUtils.equals(str, next.optString("traceid"))) {
                return next;
            }
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.sk
    public boolean c(JSONObject jSONObject) {
        return this.a.contains(jSONObject);
    }

    @Override // com.qq.e.comm.plugin.sk
    public int size() {
        return this.a.size();
    }

    @Override // com.qq.e.comm.plugin.sk
    public e1 a() {
        return this.f;
    }

    public boolean d(JSONObject jSONObject) {
        return a(jSONObject, true);
    }

    @Override // com.qq.e.comm.plugin.sk
    public void c() {
        this.h = false;
        qg.b.execute(new a());
    }

    @Override // com.qq.e.comm.plugin.sk
    public boolean a(boolean z) throws JSONException {
        if (a(this.b, false)) {
            return true;
        }
        if (this.a.isEmpty()) {
            return false;
        }
        Iterator<JSONObject> it = this.a.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            JSONObject next = it.next();
            if (a(next, false)) {
                if (!a(z, next)) {
                    return true;
                }
                z2 = true;
            }
        }
        if (z2) {
            f5 f5Var = new f5();
            f5Var.a(this.d);
            f5Var.c(this.c);
            b10.a(1407040, f5Var, 1);
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.sk
    public jw d() throws JSONException {
        jw jwVar = new jw();
        if (this.a.isEmpty() && !a(this.b, false)) {
            jwVar.a(1);
            return jwVar;
        }
        JSONObject jSONObjectE = e();
        if (jSONObjectE == null) {
            jwVar.a(2);
        } else if (xb.a(jSONObjectE.optLong("adReturnTime"), this.d)) {
            jwVar.a(3);
            f5 f5Var = new f5();
            f5Var.a(this.d);
            f5Var.c(this.c);
            b10.a(1407040, f5Var, 0);
        } else {
            jwVar.a(jSONObjectE);
        }
        return jwVar;
    }

    private boolean a(boolean z, JSONObject jSONObject) {
        if (z) {
            return xb.a(jSONObject.optLong("adReturnTime"), this.d);
        }
        return false;
    }

    public boolean a(JSONObject jSONObject, boolean z) {
        ku kuVar;
        if (jSONObject == null) {
            return false;
        }
        try {
            kuVar = new ku(jSONObject.optJSONObject("posCfg"));
        } catch (Exception unused) {
            kuVar = null;
        }
        long jA = a(k.a(jSONObject.optInt("ad_expire"), k.a(this.c, kuVar, this.d)), jSONObject.optLong("adCachedTime"));
        boolean z2 = jA <= 0;
        if (!z2) {
            if (z) {
                wt wtVar = new wt(2301002);
                wtVar.b((jA / 1000) / 60);
                b10.a(wtVar);
            }
            System.currentTimeMillis();
        }
        return z2;
    }

    @Override // com.qq.e.comm.plugin.sk
    public void a(String str, JSONObject jSONObject) {
        HashSet hashSet = new HashSet();
        JSONObject jSONObjectA = a(str);
        if (jSONObjectA != null) {
            hashSet.add(jSONObjectA);
        }
        Iterator<JSONObject> it = this.a.iterator();
        while (it.hasNext()) {
            JSONObject next = it.next();
            if (!d(next)) {
                hashSet.add(next);
            }
        }
        boolean zE = false;
        Math.max(hashSet.size() - 1, 0);
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            zE |= e((JSONObject) it2.next());
        }
        if (zE) {
            JSONObject jSONObject2 = this.b;
            if (jSONObject2 != null) {
                this.b = null;
                jSONObject = jSONObject2;
            }
            if (jSONObject != null && d(jSONObject)) {
                b(jSONObject);
            }
            c();
        }
    }

    @Override // com.qq.e.comm.plugin.sk
    public void a(e1 e1Var, boolean z) {
        this.g = 0;
        this.f = e1Var;
        this.a = e1Var.a();
        if (z) {
            c();
        }
    }

    @Override // com.qq.e.comm.plugin.sk
    public void a(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    private long a(long j, long j2) {
        return System.currentTimeMillis() - (j2 + (j * 60000));
    }
}
