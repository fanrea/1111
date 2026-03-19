package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.c10;
import com.qq.e.comm.plugin.oc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class x9 implements mj {
    private static Boolean d;
    private boolean a = true;
    private volatile boolean b = false;
    private final Map<ob, aa> c = new HashMap();

    /* compiled from: A */
    interface f {
        void a(ob obVar);
    }

    public static boolean c() {
        Boolean bool = d;
        return bool != null && bool.booleanValue();
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ JSONObject a;

        a(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (Map.Entry entry : x9.this.c.entrySet()) {
                Object objE = ((ob) entry.getKey()).e(this.a);
                if (objE != null || x9.this.a) {
                    x9.this.a((aa) entry.getValue(), objE);
                }
            }
            x9.this.a = false;
        }
    }

    /* compiled from: A */
    class b implements f {
        final /* synthetic */ w40 a;
        final /* synthetic */ ob b;
        final /* synthetic */ String c;

        b(w40 w40Var, ob obVar, String str) {
            this.a = w40Var;
            this.b = obVar;
            this.c = str;
        }

        @Override // com.qq.e.comm.plugin.x9.f
        public void a(ob obVar) {
            x9.this.a(obVar, new v3(this.a, this.b, this.c));
        }
    }

    /* compiled from: A */
    class c implements f {
        final /* synthetic */ w40 a;
        final /* synthetic */ ob b;
        final /* synthetic */ h8 c;
        final /* synthetic */ String d;

        c(w40 w40Var, ob obVar, h8 h8Var, String str) {
            this.a = w40Var;
            this.b = obVar;
            this.c = h8Var;
            this.d = str;
        }

        @Override // com.qq.e.comm.plugin.x9.f
        public void a(ob obVar) {
            x9.this.a(obVar, new oc(this.a, this.b, new oc.a(this.c, this.d)));
        }
    }

    /* compiled from: A */
    class d implements f {
        final /* synthetic */ w40 a;
        final /* synthetic */ ob b;
        final /* synthetic */ z8 c;
        final /* synthetic */ String d;

        d(w40 w40Var, ob obVar, z8 z8Var, String str) {
            this.a = w40Var;
            this.b = obVar;
            this.c = z8Var;
            this.d = str;
        }

        @Override // com.qq.e.comm.plugin.x9.f
        public void a(ob obVar) {
            x9.this.a(obVar, new c10(this.a, this.b, new c10.a(this.c, this.d)));
        }
    }

    /* compiled from: A */
    class e implements f {
        final /* synthetic */ w40 a;
        final /* synthetic */ ob b;
        final /* synthetic */ s2 c;

        e(w40 w40Var, ob obVar, s2 s2Var) {
            this.a = w40Var;
            this.b = obVar;
            this.c = s2Var;
        }

        @Override // com.qq.e.comm.plugin.x9.f
        public void a(ob obVar) {
            x9.this.a(obVar, new q2(this.a, this.b, this.c));
        }
    }

    public void b() {
        Iterator<Map.Entry<ob, aa>> it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
        this.a = true;
        this.b = false;
    }

    public void a() {
        this.b = true;
    }

    private aa b(ob obVar) {
        aa aaVar = this.c.get(obVar);
        if (aaVar != null) {
            return aaVar;
        }
        aa aaVar2 = new aa();
        this.c.put(obVar, aaVar2);
        return aaVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ob obVar, z9<?> z9Var) {
        b(obVar).a.add(z9Var);
        obVar.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(aa aaVar, Object obj) {
        Object obj2 = aaVar.b;
        if (obj2 == null || !obj2.equals(obj)) {
            aaVar.b = obj;
            Iterator<z9<?>> it = aaVar.a.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        }
    }

    public void a(JSONObject jSONObject) {
        if (!this.b || jSONObject == null || this.c.isEmpty()) {
            return;
        }
        xo.d(new a(jSONObject));
    }

    @Override // com.qq.e.comm.plugin.mj
    public Object a(ob obVar) {
        aa aaVar = this.c.get(obVar);
        if (aaVar == null) {
            return null;
        }
        return aaVar.b;
    }

    public void a(w40<?, ?> w40Var, ob obVar, s2 s2Var) {
        a(obVar, new e(w40Var, obVar, s2Var));
    }

    public void a(w40<?, ?> w40Var, ob obVar, h8 h8Var, String str) {
        a(obVar, new c(w40Var, obVar, h8Var, str));
    }

    public void a(w40<?, ?> w40Var, ob obVar, z8 z8Var, String str) {
        a(obVar, new d(w40Var, obVar, z8Var, str));
    }

    public void a(w40<?, ?> w40Var, ob obVar, String str) {
        a(obVar, new b(w40Var, obVar, str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(ob obVar, f fVar) {
        if (obVar instanceof fl) {
            Iterator<ob> it = ((fl) obVar).b().iterator();
            while (it.hasNext()) {
                fVar.a(it.next());
            }
            return;
        }
        fVar.a(obVar);
    }

    public static void a(ku kuVar) {
        if (d != null) {
            return;
        }
        d = Boolean.valueOf(xc.a("ddb", "APP", 0, kuVar) == 1);
    }
}
