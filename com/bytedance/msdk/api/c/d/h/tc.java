package com.bytedance.msdk.api.c.d.h;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc {
    public final int an;
    public final int b;
    public final int c;
    public final int d;
    public final int gb;
    public final int h;
    public final int hc;
    public final Map<String, Integer> k;
    public final int mk;
    public final int mq;
    public final int tc;
    public final int tt;
    public final int u;
    public final int uo;

    public static class d {
        protected int an;
        protected int b;
        protected int c;
        protected int d;
        protected int gb;
        protected int h;
        protected int hc;
        protected Map<String, Integer> k;
        protected int mk;
        protected int mq;
        protected int tc;
        protected int tt;
        protected int u;
        protected int uo;

        public d(int i) {
            this.k = Collections.emptyMap();
            this.d = i;
            this.k = new HashMap();
        }

        public d d(int i) {
            this.hc = i;
            return this;
        }

        public d hc(int i) {
            this.tt = i;
            return this;
        }

        public d b(int i) {
            this.tc = i;
            return this;
        }

        public d c(int i) {
            this.mk = i;
            return this;
        }

        public d u(int i) {
            this.mq = i;
            return this;
        }

        public d an(int i) {
            this.an = i;
            return this;
        }

        public d h(int i) {
            this.gb = i;
            return this;
        }

        public d gb(int i) {
            this.h = i;
            return this;
        }

        public d tt(int i) {
            this.b = i;
            return this;
        }

        public d tc(int i) {
            this.c = i;
            return this;
        }

        public d mk(int i) {
            this.u = i;
            return this;
        }

        public d d(Map<String, Integer> map) {
            this.k = new HashMap(map);
            return this;
        }

        public tc d() {
            return new tc(this);
        }
    }

    protected tc(d dVar) {
        this.d = dVar.d;
        this.hc = dVar.hc;
        this.b = dVar.b;
        this.c = dVar.c;
        this.u = dVar.u;
        this.an = dVar.an;
        this.h = dVar.h;
        this.gb = dVar.gb;
        this.k = dVar.k;
        this.tt = dVar.tc;
        this.tc = dVar.mk;
        this.mk = dVar.mq;
        this.mq = dVar.tt;
        this.uo = dVar.uo;
    }

    public static tc d(com.bytedance.sdk.openadsdk.mediation.ad.d.hc.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        d dVar = new d(cVar.d());
        dVar.d(cVar.hc()).tc(cVar.c()).tt(cVar.b()).b(cVar.tt()).c(cVar.tc()).u(cVar.mk()).an(cVar.an()).gb(cVar.h()).mk(cVar.u()).hc(cVar.mq()).h(cVar.gb()).d(cVar.uo());
        return dVar.d();
    }

    public static com.bytedance.msdk.d.c.hc.d d(tc tcVar) {
        if (tcVar != null) {
            return new com.bytedance.msdk.d.c.hc.d(tcVar);
        }
        return null;
    }
}
