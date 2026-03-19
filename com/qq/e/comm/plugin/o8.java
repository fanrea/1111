package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.dl.LandingPageCallback;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class o8 {
    private final m8 a = new m8();
    private final Cif b;
    private final os c;
    private final LandingPageCallback d;

    public o8(h4 h4Var, Cif cif, os osVar) {
        this.b = cif;
        this.c = osVar;
        this.d = (LandingPageCallback) x5.b(h4Var.s0(), LandingPageCallback.class);
    }

    /* compiled from: A */
    class a extends ms<Void> {
        a(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r2) throws JSONException {
            o8.this.a.d(true);
            o8.this.b.a(o8.this.a.f());
        }
    }

    public void c() {
        this.d.U().a(new a(this.c));
        this.d.L().a(new b(this.c));
        this.d.l().a(new c(this.c));
        this.d.W().a(new d(this.c));
    }

    /* compiled from: A */
    class b extends ms<Integer> {
        b(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) throws JSONException {
            if (num == null) {
                return;
            }
            o8.this.a.c(true);
            o8.this.a.f(num.toString());
            o8.this.b.a(o8.this.a.f());
        }
    }

    /* compiled from: A */
    class c extends ms<Void> {
        c(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r2) throws JSONException {
            o8.this.a.c(false);
            o8.this.b.a(o8.this.a.f());
        }
    }

    /* compiled from: A */
    class d extends ms<Void> {
        d(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r2) throws JSONException {
            o8.this.a.c(false);
            o8.this.a.d(false);
            o8.this.b.a(o8.this.a.f());
        }
    }

    public void a() throws JSONException {
        this.d.t().a();
        this.a.d(false);
        this.a.c(false);
        this.b.a(this.a.f());
    }

    public void b() throws JSONException {
        this.d.l().a();
        this.a.c(false);
        this.b.a(this.a.f());
    }
}
