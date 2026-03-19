package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qo {
    protected static final String h = g1.o;
    private final String a;
    private final f5 b;
    private sk c;
    private final e2 d;
    private AtomicBoolean e = new AtomicBoolean(false);
    private AtomicBoolean f = new AtomicBoolean(false);
    private zj g = null;

    /* compiled from: A */
    public interface d {
        void a(jw jwVar);

        void b(jw jwVar);
    }

    /* compiled from: A */
    public interface f {
        void a(w1 w1Var, j jVar, int i);
    }

    private void d() {
        qg.b.execute(new a());
    }

    public qo(String str, f5 f5Var, e2 e2Var) {
        this.a = str;
        this.d = e2Var;
        this.c = new j10(str, e2Var);
        this.b = f5Var;
        d();
    }

    public void f() {
        if (!c()) {
            this.f.set(true);
            return;
        }
        e1 e1VarA = this.c.a();
        if (e1VarA == null) {
            return;
        }
        CopyOnWriteArrayList<JSONObject> copyOnWriteArrayListA = e1VarA.a();
        if (copyOnWriteArrayListA.size() <= 0) {
            return;
        }
        String strA = wb.a(this.d, this.a);
        if (wb.a(strA)) {
            return;
        }
        ArrayList arrayList = new ArrayList(copyOnWriteArrayListA);
        vb vbVarA = wb.a(strA, this.d, this.a, arrayList, this.c.b());
        e eVar = new e(this, arrayList, null);
        this.g = eVar;
        vbVarA.a(eVar);
        ub.c().e(vbVarA);
    }

    public int b() {
        return this.c.b();
    }

    /* compiled from: A */
    private static class e implements zj {
        private final List<JSONObject> a;
        private final qo b;

        @Override // com.qq.e.comm.plugin.zj
        public void a(int i) {
        }

        private e(qo qoVar, List<JSONObject> list) {
            this.b = qoVar;
            this.a = list;
        }

        @Override // com.qq.e.comm.plugin.zj
        public void a(boolean z, JSONObject jSONObject) {
            if (this.b == null || !z || this.a == null) {
                return;
            }
            this.b.a(xb.a(jSONObject), this.a);
        }

        /* synthetic */ e(qo qoVar, List list, a aVar) {
            this(qoVar, list);
        }
    }

    public void a(e1 e1Var, boolean z) {
        this.c.b(e1Var, z);
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = qo.h;
            synchronized (qo.this) {
                File fileF = gu.f(qo.this.a);
                String strD = gu.d(fileF);
                fileF.getAbsolutePath();
                qo.this.c.a(qo.this.a(strD), false);
                qo.this.e.set(true);
                if (qo.this.f.compareAndSet(true, false)) {
                    qo.this.f();
                }
            }
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ d b;

        b(int i, d dVar) {
            this.a = i;
            this.b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = qo.h;
            synchronized (qo.this) {
                jw jwVarD = qo.this.c.d();
                JSONObject jSONObjectB = jwVarD.b();
                if (jSONObjectB != null) {
                    jSONObjectB.optString("traceid");
                    d dVar = this.b;
                    if (dVar != null) {
                        dVar.b(jwVarD);
                    }
                } else {
                    d dVar2 = this.b;
                    if (dVar2 != null) {
                        dVar2.a(jwVarD);
                    }
                }
            }
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ JSONObject b;
        final /* synthetic */ f c;
        final /* synthetic */ w1 d;
        final /* synthetic */ j e;

        c(String str, JSONObject jSONObject, f fVar, w1 w1Var, j jVar) {
            this.a = str;
            this.b = jSONObject;
            this.c = fVar;
            this.d = w1Var;
            this.e = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = qo.h;
            synchronized (qo.this) {
                qo.this.c.a(this.a, this.b);
                f fVar = this.c;
                if (fVar != null) {
                    fVar.a(this.d, this.e, qo.this.c.size());
                }
            }
        }
    }

    public int e() {
        return this.c.size();
    }

    public boolean c() {
        return this.e.get();
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || this.c == null) {
            return;
        }
        if (xc.a("itratcl", this.d.c(), this.a, 0) == 1) {
            this.c.b(jSONObject);
            this.c.c();
            b10.a(1407024, this.b);
            return;
        }
        this.c.a(jSONObject);
    }

    public synchronized jw a(w1 w1Var) {
        return this.c.d();
    }

    public void a(w1 w1Var, d dVar) {
        qg.b.execute(new b(w1Var.hashCode(), dVar));
    }

    public List<JSONObject> a() {
        e1 e1VarA = this.c.a();
        if (e1VarA == null) {
            return Collections.emptyList();
        }
        return e1VarA.a();
    }

    public boolean a(boolean z) {
        sk skVar = this.c;
        if (skVar == null) {
            return false;
        }
        return skVar.a(z);
    }

    public boolean a(JSONObject jSONObject) {
        sk skVar;
        if (jSONObject == null || (skVar = this.c) == null) {
            return false;
        }
        return skVar.c(jSONObject);
    }

    public e1 a(String str) {
        JSONObject jSONObject;
        int length;
        y9.a(this.b);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (TextUtils.isEmpty(str)) {
            y9.a(this.b, 1);
            return new e1(copyOnWriteArrayList);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            y9.a(this.b, 2);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return new e1(copyOnWriteArrayList);
        }
        r1.d().f().a(this.a, jSONObject.optJSONObject("ctrl_config"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("list");
        if (jSONArrayOptJSONArray != null && (length = jSONArrayOptJSONArray.length()) > 0) {
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    copyOnWriteArrayList.add(jSONObjectOptJSONObject);
                }
            }
            copyOnWriteArrayList.size();
            y9.b(this.b);
            return new e1(copyOnWriteArrayList);
        }
        y9.a(this.b, 3);
        return new e1(copyOnWriteArrayList);
    }

    public void a(e1 e1Var) {
        this.c.a(e1Var, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray, List<JSONObject> list) {
        int i;
        JSONArray jSONArray2 = jSONArray;
        if (jSONArray2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.c.a().a());
        if (arrayList.size() != list.size()) {
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        int length = jSONArray.length();
        int size = arrayList.size();
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (i2 < length) {
            JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(i2);
            String strOptString = jSONObjectOptJSONObject.optString("aid");
            String strOptString2 = jSONObjectOptJSONObject.optString("tid");
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    i = length;
                    break;
                }
                JSONObject jSONObject = (JSONObject) arrayList.get(i4);
                String strOptString3 = jSONObject.optString("cl");
                String strOptString4 = jSONObject.optString("traceid");
                i = length;
                if (!TextUtils.equals(strOptString3, list.get(i4).optString("cl"))) {
                    return;
                }
                if (!TextUtils.isEmpty(strOptString2)) {
                    if (TextUtils.equals(strOptString2, strOptString4)) {
                        boolean z2 = i3 != i4 ? true : z;
                        copyOnWriteArrayList.add(jSONObject);
                        i3++;
                        z = z2;
                    }
                } else if (TextUtils.equals(strOptString, strOptString3)) {
                    if (i3 != i4) {
                        z = true;
                    }
                    copyOnWriteArrayList.add(jSONObject);
                    i3++;
                }
                i4++;
                length = i;
            }
            i2++;
            jSONArray2 = jSONArray;
            length = i;
        }
        int size2 = copyOnWriteArrayList.size();
        if (z || size2 < arrayList.size()) {
            b10.a(1407022, this.b, Integer.valueOf(size2 == 0 ? 1 : 2));
            synchronized (this) {
                this.c.a(new e1(copyOnWriteArrayList), true);
            }
        }
    }

    public void a(String str, JSONObject jSONObject, w1 w1Var, j jVar, f fVar) {
        qg.b.execute(new c(str, jSONObject, fVar, w1Var, jVar));
    }
}
