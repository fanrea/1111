package com.bytedance.sdk.component.hc.d;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.b.hc.j;
import com.bytedance.sdk.component.b.hc.jh;
import com.bytedance.sdk.component.b.hc.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq extends gb implements Cloneable {
    static final List<uo> gb = com.bytedance.sdk.component.hc.d.hc.tc.d(uo.HTTP_2, uo.HTTP_1_1);
    public long an;
    public TimeUnit b;
    public long c;
    public List<tt> d;
    public TimeUnit h;
    public long hc;
    public v.d mk;
    public Bundle mq;
    public Set<String> tc;
    public List<uo> tt;
    public TimeUnit u;

    public c d() {
        return null;
    }

    public hc d(k kVar) {
        return null;
    }

    public mq() {
        this(new d());
    }

    public mq(d dVar) {
        this.hc = dVar.b;
        this.c = dVar.u;
        this.an = dVar.h;
        this.b = dVar.c;
        this.u = dVar.an;
        this.h = dVar.gb;
        this.d = dVar.d;
        this.tt = dVar.tt;
        this.tc = dVar.tc;
    }

    public mq(v.d dVar) {
        this.hc = dVar.np;
        this.c = dVar.yi;
        this.an = dVar.he;
        this.b = dVar.s;
        this.u = dVar.us;
        this.h = dVar.z;
        this.tc = dVar.j;
        this.mk = dVar;
    }

    public static final class d {
        public TimeUnit an;
        public long b;
        public TimeUnit c;
        public final List<tt> d;
        public TimeUnit gb;
        public long h;
        public com.bytedance.sdk.component.hc.d.d.d.d hc;
        public Bundle mk;
        private v.d mq;
        public Set<String> tc;
        List<uo> tt;
        public long u;

        public d() {
            this.d = new ArrayList();
            this.b = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.c = TimeUnit.MILLISECONDS;
            this.u = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.an = TimeUnit.MILLISECONDS;
            this.h = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.gb = TimeUnit.MILLISECONDS;
            if (com.bytedance.sdk.component.hc.d.d.d.d().hc()) {
                this.mq = new v.d();
            }
        }

        public d(String str) {
            this.d = new ArrayList();
            this.b = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.c = TimeUnit.MILLISECONDS;
            this.u = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.an = TimeUnit.MILLISECONDS;
            this.h = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.gb = TimeUnit.MILLISECONDS;
            this.tt = mq.gb;
            if (com.bytedance.sdk.component.hc.d.d.d.d().hc()) {
                this.mq = new v.d();
            }
        }

        public d(mq mqVar) {
            this.d = new ArrayList();
            this.b = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.c = TimeUnit.MILLISECONDS;
            this.u = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.an = TimeUnit.MILLISECONDS;
            this.h = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.gb = TimeUnit.MILLISECONDS;
            this.b = mqVar.hc;
            this.c = mqVar.b;
            this.u = mqVar.c;
            this.an = mqVar.u;
            this.h = mqVar.an;
            this.gb = mqVar.h;
            this.tt = mqVar.tt;
            this.tc = mqVar.tc;
            if (com.bytedance.sdk.component.hc.d.d.d.d().hc()) {
                this.mq = mqVar.mk;
            }
            v.d dVar = this.mq;
            if (dVar != null) {
                dVar.np = (int) mqVar.hc;
                this.mq.s = mqVar.b;
                this.mq.yi = (int) mqVar.c;
                this.mq.us = mqVar.u;
                this.mq.he = (int) mqVar.an;
                this.mq.z = mqVar.h;
                this.mq.j = mqVar.tc;
                this.mq.zw = mqVar.mq;
            }
        }

        public d d(long j, TimeUnit timeUnit) {
            v.d dVar;
            this.b = j;
            this.c = timeUnit;
            if (com.bytedance.sdk.component.hc.d.d.d.d().hc() && (dVar = this.mq) != null) {
                dVar.d(this.b, timeUnit);
            }
            return this;
        }

        public d hc(long j, TimeUnit timeUnit) {
            v.d dVar;
            this.u = j;
            this.an = timeUnit;
            if (com.bytedance.sdk.component.hc.d.d.d.d().hc() && (dVar = this.mq) != null) {
                dVar.hc(this.u, timeUnit);
            }
            return this;
        }

        public d b(long j, TimeUnit timeUnit) {
            v.d dVar;
            this.h = j;
            this.gb = timeUnit;
            if (com.bytedance.sdk.component.hc.d.d.d.d().hc() && (dVar = this.mq) != null) {
                dVar.b(this.h, timeUnit);
            }
            return this;
        }

        public d d(com.bytedance.sdk.component.hc.d.d.d.d dVar) {
            v.d dVar2;
            this.hc = dVar;
            if (com.bytedance.sdk.component.hc.d.d.d.d().hc() && (dVar2 = this.mq) != null) {
                dVar2.d(new com.bytedance.sdk.component.hc.d.d.d.b(dVar));
            }
            return this;
        }

        public d d(final tt ttVar) {
            v.d dVar;
            this.d.add(ttVar);
            if (com.bytedance.sdk.component.hc.d.d.d.d().hc() && (dVar = this.mq) != null) {
                dVar.d(new jh() { // from class: com.bytedance.sdk.component.hc.d.mq.d.1
                    @Override // com.bytedance.sdk.component.b.hc.jh
                    public j d(jh.d dVar2) throws IOException {
                        return ((com.bytedance.sdk.component.hc.d.d.d.tt) ttVar.d(new com.bytedance.sdk.component.hc.d.d.d.u(dVar2))).d;
                    }
                });
            }
            return this;
        }

        public d d(Set<String> set) {
            this.tc = set;
            v.d dVar = this.mq;
            if (dVar != null) {
                dVar.d(set);
            }
            return this;
        }

        public d d(List<uo> list) {
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.contains(uo.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols doesn't contain http/1.1: ".concat(String.valueOf(arrayList)));
            }
            if (arrayList.contains(uo.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: ".concat(String.valueOf(arrayList)));
            }
            if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(uo.SPDY_3);
            this.tt = Collections.unmodifiableList(arrayList);
            return this;
        }

        public d d(Bundle bundle) {
            this.mk = bundle;
            v.d dVar = this.mq;
            if (dVar != null) {
                dVar.zw = bundle;
            }
            return this;
        }

        public mq d() {
            if (com.bytedance.sdk.component.hc.d.d.d.d().hc()) {
                return com.bytedance.sdk.component.hc.d.d.d.d(this.mq);
            }
            return com.bytedance.sdk.component.hc.d.d.d.d(this);
        }
    }

    public d hc() {
        return new d(this);
    }
}
