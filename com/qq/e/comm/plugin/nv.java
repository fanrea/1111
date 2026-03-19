package com.qq.e.comm.plugin;

import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.plugin.fo;
import com.qq.e.comm.plugin.iw;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class nv {
    protected static final String b = g1.o;
    private final String a;

    /* compiled from: A */
    interface b {
        void a(e1 e1Var);

        void a(eo eoVar);
    }

    public nv(String str) {
        this.a = str;
    }

    /* compiled from: A */
    class a implements fo.c {
        final /* synthetic */ f5 a;
        final /* synthetic */ boolean b;
        final /* synthetic */ b c;
        final /* synthetic */ w1 d;
        final /* synthetic */ j e;
        final /* synthetic */ long f;

        a(f5 f5Var, boolean z, b bVar, w1 w1Var, j jVar, long j) {
            this.a = f5Var;
            this.b = z;
            this.c = bVar;
            this.d = w1Var;
            this.e = jVar;
            this.f = j;
        }

        @Override // com.qq.e.comm.plugin.fo.c
        public void a(eo eoVar) {
            b bVar = this.c;
            if (bVar != null) {
                bVar.a(eoVar);
                f1.b(this.d, this.e.a(), 5);
            } else {
                f1.b(this.d, this.e.a(), 6);
            }
        }

        @Override // com.qq.e.comm.plugin.fo.c
        public void a(JSONObject jSONObject) throws JSONException {
            int length;
            iw.b bVarA = iw.a(jSONObject, nv.this.a, this.a, this.b);
            JSONArray jSONArray = bVarA.a;
            if (jSONArray != null && (length = jSONArray.length()) > 0) {
                List<JSONObject> listA = k.a(jSONArray, this.e, null, this.d);
                if (listA.isEmpty()) {
                    go.a(ErrorCode.NO_AD_FILL_FOR_INSTALLED, this.a, length);
                    this.c.a(new eo("ad filtered", ErrorCode.NO_AD_FILL_FOR_INSTALLED));
                    f1.b(this.d, this.e.a(), 4);
                    return;
                } else {
                    this.c.a(new e1(new CopyOnWriteArrayList(listA)));
                    wt wtVarB = new wt(2301003).b(System.currentTimeMillis() - this.f).b(this.d.d());
                    wtVarB.a(this.a);
                    b10.a(wtVarB);
                    jt.a(this.a, listA.get(0));
                    f1.b(this.d, this.e.a(), 2);
                    return;
                }
            }
            this.c.a(new eo("parse error", bVarA.b));
            f1.b(this.d, this.e.a(), 3);
        }
    }

    public void a(w1 w1Var, j jVar, b bVar, f5 f5Var) {
        boolean zK = w1Var.K();
        long jCurrentTimeMillis = System.currentTimeMillis();
        f1.b(w1Var, jVar.a(), 1);
        f00.a(jVar.a(), jVar.b(), 4);
        fo.a(w1Var, jVar, new a(f5Var, zK, bVar, w1Var, jVar, jCurrentTimeMillis));
    }
}
