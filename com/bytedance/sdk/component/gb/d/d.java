package com.bytedance.sdk.component.gb.d;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements u {
    private com.bytedance.sdk.component.gb.hc.c.hc.d an;
    private String b;
    private Context c;
    private an d;
    private com.bytedance.sdk.component.gb.hc.c.hc.d gb;
    private com.bytedance.sdk.component.gb.hc.c.hc.d h;
    private mk hc;
    private int k;
    private c mk;
    private AtomicBoolean mq;
    private boolean tc;
    private com.bytedance.sdk.component.gb.hc.c.hc.d tt;
    private com.bytedance.sdk.component.gb.hc.c.hc.d u;
    private int uo;

    private d() {
        this.mq = new AtomicBoolean(false);
        this.uo = 200;
        this.k = 10;
    }

    @Override // com.bytedance.sdk.component.gb.d.u
    public com.bytedance.sdk.component.gb.hc.c.hc.d d() {
        return this.gb;
    }

    @Override // com.bytedance.sdk.component.gb.d.u
    public Context getContext() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.gb.d.u
    public an hc() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.gb.d.u
    public void d(an anVar) {
        this.d = anVar;
    }

    @Override // com.bytedance.sdk.component.gb.d.u
    public void d(boolean z) {
        this.mq.set(z);
    }

    @Override // com.bytedance.sdk.component.gb.d.u
    public boolean b() {
        return this.mq.get();
    }

    @Override // com.bytedance.sdk.component.gb.d.u
    public c c() {
        return this.mk;
    }

    @Override // com.bytedance.sdk.component.gb.d.u
    public String u() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.gb.d.u
    public com.bytedance.sdk.component.gb.hc.c.hc.d an() {
        return this.tt;
    }

    @Override // com.bytedance.sdk.component.gb.d.u
    public com.bytedance.sdk.component.gb.hc.c.hc.d h() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.gb.d.u
    public com.bytedance.sdk.component.gb.hc.c.hc.d gb() {
        return this.an;
    }

    @Override // com.bytedance.sdk.component.gb.d.u
    public com.bytedance.sdk.component.gb.hc.c.hc.d tt() {
        return this.h;
    }

    @Override // com.bytedance.sdk.component.gb.d.u
    public mk tc() {
        return this.hc;
    }

    @Override // com.bytedance.sdk.component.gb.d.u
    public boolean mk() {
        return this.tc;
    }

    /* renamed from: com.bytedance.sdk.component.gb.d.d$d, reason: collision with other inner class name */
    public static class C0276d {
        private boolean an;
        private com.bytedance.sdk.component.gb.hc.c.hc.d b;
        private com.bytedance.sdk.component.gb.hc.c.hc.d c;
        private mk d;
        private an gb;
        private c h;
        private com.bytedance.sdk.component.gb.hc.c.hc.d hc;
        private String mq;
        private com.bytedance.sdk.component.gb.hc.c.hc.d u;
        private Context uo;
        private final AtomicBoolean tt = new AtomicBoolean(false);
        private int tc = 5000;
        private int mk = 10;

        public C0276d d(Context context) {
            this.uo = context;
            return this;
        }

        public C0276d d(String str) {
            this.mq = str;
            return this;
        }

        public C0276d d(boolean z) {
            this.tt.set(z);
            return this;
        }

        public C0276d d(an anVar) {
            this.gb = anVar;
            return this;
        }

        public C0276d d(c cVar) {
            this.h = cVar;
            return this;
        }

        public C0276d hc(boolean z) {
            this.an = z;
            return this;
        }

        public C0276d d(com.bytedance.sdk.component.gb.hc.c.hc.d dVar) {
            this.hc = dVar;
            return this;
        }

        public C0276d hc(com.bytedance.sdk.component.gb.hc.c.hc.d dVar) {
            this.b = dVar;
            return this;
        }

        public C0276d b(com.bytedance.sdk.component.gb.hc.c.hc.d dVar) {
            this.c = dVar;
            return this;
        }

        public C0276d d(mk mkVar) {
            this.d = mkVar;
            return this;
        }

        public d d() {
            d dVar = new d();
            dVar.hc = this.d;
            dVar.u = this.hc;
            dVar.an = this.b;
            dVar.h = this.c;
            dVar.gb = this.u;
            dVar.tc = this.an;
            dVar.mk = this.h;
            dVar.d = this.gb;
            dVar.mq = this.tt;
            dVar.b = this.mq;
            dVar.c = this.uo;
            dVar.k = this.mk;
            dVar.uo = this.tc;
            return dVar;
        }
    }
}
