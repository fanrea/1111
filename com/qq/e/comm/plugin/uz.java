package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.fo;
import com.qq.e.comm.plugin.g1;
import com.qq.e.comm.plugin.iw;
import com.qq.e.comm.plugin.qo;
import com.qq.e.comm.util.GDTLogger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class uz {
    private xz a;
    private mu c;
    private c e;
    private volatile g1<mu> f;
    private final wk<mu> b = new wk<>();
    private volatile List<mu> d = null;

    uz() {
    }

    public boolean d() {
        wk<mu> wkVar = this.b;
        return wkVar.a == null || !wkVar.a();
    }

    private void e() throws JSONException {
        c();
        w1 w1VarA = a(this.a);
        xz xzVar = this.a;
        f00.a(xzVar.e, xzVar.c, 3);
        g1<mu> g1Var = this.f;
        xz xzVar2 = this.a;
        g1Var.a(w1VarA, xzVar2.f, xzVar2.c(), new a(w1VarA));
    }

    /* compiled from: A */
    class a implements g1.h<mu> {
        final /* synthetic */ w1 a;

        a(w1 w1Var) {
            this.a = w1Var;
        }

        @Override // com.qq.e.comm.plugin.g1.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public mu a(JSONObject jSONObject) {
            return uz.this.a(jSONObject);
        }

        @Override // com.qq.e.comm.plugin.g1.h
        public void a(mu muVar) {
            if (!uz.this.d()) {
                go.b(uz.this.a.c(), 1);
                uz.this.b.a((wk) muVar);
                zz.c(muVar);
                jt.a(muVar);
                return;
            }
            uz.this.f.a(muVar.h());
            go.a(uz.this.a.c(), 9000, this.a.K());
        }

        @Override // com.qq.e.comm.plugin.g1.h
        public void a(eo eoVar) {
            if (uz.this.d()) {
                return;
            }
            uz.this.a(eoVar);
        }
    }

    private void c() {
        if (this.f != null) {
            return;
        }
        synchronized (this) {
            if (this.f != null) {
                return;
            }
            int iA = zz.a(this.a.c);
            boolean z = TextUtils.isEmpty(this.a.d) && iA > 0;
            xz xzVar = this.a;
            g1<mu> g1VarA = g1.a(xzVar.c, xzVar.c(), this.a.e);
            xz xzVar2 = this.a;
            int i = xzVar2.s;
            int i2 = xzVar2.o;
            if (i >= i2) {
                i = i2 - 200;
            }
            g1VarA.a(z).a(iA).b(i);
            this.f = g1VarA;
        }
    }

    public void f() {
        if (d()) {
            return;
        }
        xz xzVar = this.a;
        f00.a(xzVar.e, xzVar.c, 1);
        if (this.a.C) {
            e();
        } else {
            qg.b.execute(new b());
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            xz xzVar = uz.this.a;
            if (uz.this.d()) {
                return;
            }
            uz.this.d = pu.a().a(xzVar.b, xzVar.c, xzVar.d, xzVar.e, xzVar.i);
            uz uzVar = uz.this;
            w1 w1VarA = uzVar.a(uzVar.a);
            if (w1VarA == null) {
                return;
            }
            boolean zK = w1VarA.K();
            f00.a(xzVar.e, xzVar.c, 2);
            fo.a(w1VarA, xzVar.f, new a(zK));
        }

        /* compiled from: A */
        class a implements fo.c {
            final /* synthetic */ boolean a;

            a(boolean z) {
                this.a = z;
            }

            @Override // com.qq.e.comm.plugin.fo.c
            public void a(eo eoVar) {
                if (uz.this.d()) {
                    return;
                }
                uz.this.a(eoVar);
            }

            @Override // com.qq.e.comm.plugin.fo.c
            public void a(JSONObject jSONObject) throws JSONException {
                if (uz.this.d()) {
                    go.a(uz.this.a == null ? null : uz.this.a.c(), 9000, this.a);
                    return;
                }
                uz uzVar = uz.this;
                Pair pairA = uzVar.a(jSONObject, uzVar.a, this.a);
                if (pairA == null || uz.this.d()) {
                    return;
                }
                if (((Integer) pairA.first).intValue() != 0) {
                    uz.this.a(new eo("", ((Integer) pairA.first).intValue()));
                    return;
                }
                mu muVar = (mu) pairA.second;
                zz.c(muVar);
                uz.this.b.a((wk) muVar);
                jt.a(muVar);
            }
        }
    }

    /* compiled from: A */
    private static class c implements Runnable {
        xz a;
        final AtomicBoolean b = new AtomicBoolean(false);
        int c;

        c(xz xzVar) {
            this.a = xzVar;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            xz xzVar = this.a;
            if (xzVar == null || !this.b.compareAndSet(false, true)) {
                return;
            }
            pu.a().a(xzVar.e, xzVar.i, xzVar.b, xzVar.c, xzVar.d, xzVar.f, xzVar.h, this.c);
        }
    }

    public void g() {
        if (!g00.a(this.a.c)) {
            GDTLogger.e("preload 预加载调用过于频繁");
            b10.a(1012002, this.a.c());
        } else {
            if (this.a.C) {
                c();
                g1<mu> g1Var = this.f;
                w1 w1VarA = a(this.a);
                xz xzVar = this.a;
                g1Var.b(w1VarA, xzVar.f, xzVar.c());
                return;
            }
            pu puVarA = pu.a();
            xz xzVar2 = this.a;
            puVarA.a(xzVar2.e, xzVar2.i, xzVar2.b, xzVar2.c, xzVar2.d, xzVar2.f, xzVar2.h, 1);
        }
    }

    public mu b() {
        int size;
        if (this.c != null) {
            f00.a(this.a, true);
            return this.c;
        }
        List<mu> list = this.d;
        if (list != null && (size = list.size()) > 0) {
            f00.a(this.a, false);
            for (int i = 0; i < size; i++) {
                xz xzVar = this.a;
                if (xzVar == null) {
                    return null;
                }
                mu muVar = list.get(g00.b(xzVar.c) % size);
                if (xb.a(muVar)) {
                    b10.a(1407040, this.a.c(), 0);
                    return null;
                }
                pu.a().b(muVar.S0());
                if (muVar.s1()) {
                    return muVar;
                }
            }
            return null;
        }
        f00.b(this.a);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public w1 a(xz xzVar) throws JSONException {
        w1 w1Var = new w1(xzVar.e);
        w1Var.f(xzVar.c);
        w1Var.g(xzVar.d);
        w1Var.a(1);
        w1Var.b(r1.d().f().a("splashReqAdCount", xzVar.c, 1));
        w1Var.c(2);
        w1Var.a(xzVar.i);
        w1Var.e(xzVar.g);
        b2 b2VarA = x1.a(xzVar.e, r1.d().c().h());
        w1Var.k(b2VarA.c());
        w1Var.j(b2VarA.b());
        w1Var.g(xzVar.p ? 1 : 0);
        w1Var.b(true);
        w1Var.a(q8.a().a(xzVar.e));
        LoadAdParams loadAdParams = xzVar.h;
        if (loadAdParams != null) {
            w1Var.h(loadAdParams.getUin());
            w1Var.d(xzVar.h.getLoginOpenid());
            w1Var.c(xzVar.h.getLoginAppId());
            w1Var.a(xzVar.h.getDevExtra());
        }
        List<mu> list = this.d;
        if (list != null && list.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (mu muVar : list) {
                List<kz> listN1 = muVar.N1();
                if (listN1 != null && listN1.size() > 0) {
                    Iterator<kz> it = listN1.iterator();
                    while (it.hasNext()) {
                        List<Integer> listB = it.next().b();
                        if (listB != null && listB.size() > 0) {
                            for (Integer num : listB) {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put(IDJXAd.AD_CODE_ID, muVar.g());
                                    jSONObject2.put(com.baidu.mobads.container.adrequest.g.s, muVar.J1());
                                    jSONObject2.put("uoid", muVar.O1());
                                    jSONObject2.put("is_empty", muVar.P1() ? 1 : 0);
                                    jSONObject2.put("is_contract", muVar.l1() ? 1 : 0);
                                    jSONObject.put(num.toString(), jSONObject2);
                                    muVar.O1();
                                } catch (JSONException unused) {
                                }
                            }
                        }
                    }
                }
            }
            w1Var.c(jSONObject);
        }
        return w1Var;
    }

    public void a() {
        c cVar = this.e;
        if (cVar != null) {
            cVar.a = null;
            this.e = null;
        }
        this.b.a = null;
        this.c = null;
        this.d = null;
    }

    private mu a(List<JSONObject> list, xz xzVar, List<mu> list2) throws JSONException {
        mu muVar = null;
        mu muVar2 = null;
        for (int i = 0; i < list.size(); i++) {
            JSONObject jSONObject = list.get(i);
            String strOptString = jSONObject.optString("uoid");
            if (TextUtils.isEmpty(strOptString)) {
                if (muVar == null) {
                    muVar = new mu(xzVar.b, xzVar.c, xzVar.d, jSONObject, xzVar.i);
                }
            } else if (muVar2 == null && list2 != null) {
                Iterator<mu> it = list2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        mu next = it.next();
                        if (strOptString.equals(next.O1())) {
                            next.b(jSONObject);
                            muVar2 = next;
                            break;
                        }
                    }
                }
            }
        }
        if (muVar == null) {
            return muVar2;
        }
        this.c = muVar2;
        return muVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<Integer, mu> a(JSONObject jSONObject, xz xzVar, boolean z) throws JSONException {
        if (jSONObject == null || xzVar == null) {
            return null;
        }
        iw.b bVarA = iw.a(jSONObject, xzVar.c, xzVar.c(), z);
        JSONArray jSONArray = bVarA.a;
        if (jSONArray == null) {
            return new Pair<>(Integer.valueOf(bVarA.b), null);
        }
        int length = jSONArray.length();
        List<JSONObject> listA = k.a(jSONArray, xzVar.f);
        if (listA.size() <= 0) {
            go.a(ErrorCode.NO_AD_FILL_FOR_INSTALLED, xzVar.c(), length);
            return new Pair<>(Integer.valueOf(ErrorCode.NO_AD_FILL_FOR_INSTALLED), null);
        }
        int size = listA.size();
        mu muVarA = a(listA, xzVar, this.d);
        if (muVarA == null) {
            go.a(ErrorCode.SPLASH_PRELOAD_NOT_MATCH_NO_AD, xzVar.c(), size);
            return new Pair<>(Integer.valueOf(ErrorCode.SPLASH_PRELOAD_NOT_MATCH_NO_AD), null);
        }
        if (muVarA.Q1() && muVarA.P1()) {
            b10.a(1010025, xzVar.c());
            zt.a(muVarA.S());
            return new Pair<>(5004, null);
        }
        go.b(xzVar.c(), this.c == null ? 1 : 2);
        return new Pair<>(0, muVarA);
    }

    public void a(xz xzVar, vk<mu> vkVar) {
        this.a = xzVar;
        this.b.a = vkVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(eo eoVar) {
        if (d()) {
            return;
        }
        this.b.a(eoVar);
    }

    public void a(int i) {
        if (this.b.a == null) {
            return;
        }
        if (this.f != null) {
            w1 w1VarA = a(this.a);
            if (i == 2) {
                g1<mu> g1Var = this.f;
                mu muVarB = this.a.b();
                xz xzVar = this.a;
                g1Var.a((g1<mu>) muVarB, w1VarA, xzVar.f, (qo.f) null, xzVar.c());
            }
            g1<mu> g1Var2 = this.f;
            xz xzVar2 = this.a;
            g1Var2.b(w1VarA, xzVar2.f, xzVar2.c());
            return;
        }
        if (this.a.f()) {
            c cVar = this.e;
            if (cVar == null) {
                c cVar2 = new c(this.a);
                this.e = cVar2;
                cVar2.c = i;
                qg.f.schedule(cVar2, this.a.s, TimeUnit.MILLISECONDS);
                return;
            }
            if (cVar.b.get()) {
                return;
            }
            c cVar3 = this.e;
            cVar3.c = i;
            cVar3.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public mu a(JSONObject jSONObject) {
        xz xzVar = this.a;
        return new mu(xzVar.b, xzVar.c, xzVar.d, jSONObject, xzVar.i);
    }
}
