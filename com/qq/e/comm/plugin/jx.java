package com.qq.e.comm.plugin;

import android.os.SystemClock;
import com.baidu.mobads.sdk.api.SplashAd;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class jx<T> extends l4<T> implements hx {
    private final List<tr> d;
    private final int e;
    private final int f;
    private String g;
    private long h;
    private qy i;
    private volatile T j;
    private volatile tr k;
    private volatile boolean l;
    private volatile boolean m;

    public jx(List<tr> list, int i, int i2, String str, no<T> noVar) {
        super(noVar);
        this.d = list;
        this.e = i;
        this.f = i2;
        this.g = str;
    }

    public void e() {
        this.l = true;
        List<tr> list = this.d;
        if (list != null && list.size() > 0) {
            this.h = System.currentTimeMillis();
            ix.a(this.d, this.g, this);
            g();
            return;
        }
        a();
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean unused = jx.this.l;
            if (jx.this.l) {
                jx.this.a();
            }
        }
    }

    private void g() {
        this.a.postAtTime(new a(), this.b, SystemClock.uptimeMillis() + this.e);
    }

    public void f() {
        if (this.j == null) {
            this.c.a(false);
            return;
        }
        this.m = true;
        this.a.postAtTime(new b(), this.b, SystemClock.uptimeMillis() + this.f);
        no<T> noVar = this.c;
        T t = this.j;
        int iA = this.k.a();
        qy qyVar = this.i;
        noVar.a((no<T>) t, iA, qyVar != null ? qyVar.f() : "");
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (jx.this.m) {
                jx.this.m = false;
                jx.this.c.a(false);
                b10.a(1145002, (f5) null);
            }
        }
    }

    public List<tr> c() {
        return this.d;
    }

    @Override // com.qq.e.comm.plugin.l4
    protected void a() {
        if (this.l) {
            this.l = false;
            this.a.removeCallbacksAndMessages(this.b);
            this.c.a(this, (jx<T>) this.j, this.k);
        }
    }

    public qy d() {
        return this.i;
    }

    @Override // com.qq.e.comm.plugin.hx
    public void a(qy qyVar, Map<Integer, tr> map) {
        if (qyVar == null) {
            if (this.l) {
                Iterator<tr> it = this.d.iterator();
                while (it.hasNext()) {
                    it.next().c(1);
                }
                a();
                return;
            }
            return;
        }
        this.i = qyVar;
        this.k = map.get(Integer.valueOf(qyVar.a()));
        if (this.k != null) {
            int iC = qyVar.c();
            if (this.l) {
                this.k.c(3);
            }
            this.k.b(iC);
            this.k.e(-1);
            this.k.a(iC - 1);
            this.k.b(Integer.valueOf((int) (System.currentTimeMillis() - this.h)));
        }
        JSONArray jSONArrayB = qyVar.b();
        if (jSONArrayB != null && jSONArrayB.length() > 0) {
            for (int i = 0; i < jSONArrayB.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayB.optJSONObject(i);
                tr trVar = map.get(Integer.valueOf(jSONObjectOptJSONObject.optInt("adnet_id")));
                if (trVar != null) {
                    trVar.a(Integer.valueOf(jSONObjectOptJSONObject.optInt("load_ec")));
                    trVar.a(jSONObjectOptJSONObject.optString("load_em"));
                    trVar.c(jSONObjectOptJSONObject.optInt("load_state"));
                    int iOptInt = jSONObjectOptJSONObject.optInt(SplashAd.KEY_BIDFAIL_ECPM);
                    trVar.b(iOptInt);
                    trVar.e(-1);
                    trVar.a(iOptInt - 1);
                }
            }
        }
        this.j = this.c.a(this.k);
        a();
    }

    public void a(lo<T> loVar) {
        if (this.m && this.j == loVar.a()) {
            this.m = false;
            int iF = loVar.f();
            this.k.b(loVar.g());
            this.k.a(loVar.d());
            this.k.a(loVar.e());
            boolean z = iF == 3;
            if (!z) {
                b10.a(1145001, (f5) null);
            }
            this.c.a(z);
        }
    }
}
