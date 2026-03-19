package com.bytedance.sdk.component.tt;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.component.hc.d.mq;
import com.bytedance.sdk.component.hc.d.tt;
import com.bytedance.sdk.component.tt.b.an;
import com.bytedance.sdk.component.tt.b.h;
import com.bytedance.sdk.component.tt.c.b;
import com.bytedance.sdk.component.tt.hc.u;
import com.bytedance.sdk.component.utils.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private int b;
    private mq d;
    private an hc;

    private d(C0286d c0286d) {
        mq.d dVarHc = new mq.d().d(c0286d.d, TimeUnit.MILLISECONDS).b(c0286d.b, TimeUnit.MILLISECONDS).hc(c0286d.hc, TimeUnit.MILLISECONDS);
        if (c0286d.c) {
            an anVar = new an();
            this.hc = anVar;
            dVarHc.d(anVar);
        }
        if (c0286d.u != null && c0286d.u.size() > 0) {
            Iterator<tt> it = c0286d.u.iterator();
            while (it.hasNext()) {
                dVarHc.d(it.next());
            }
        }
        if (c0286d.h != null) {
            dVarHc.d(c0286d.h);
        }
        dVarHc.d(c0286d.an);
        if (c0286d.gb == null) {
            dVarHc.d(new com.bytedance.sdk.component.hc.d.d.d.hc());
        } else {
            dVarHc.d(c0286d.gb);
        }
        this.d = dVarHc.d();
    }

    public void d(Context context, boolean z, com.bytedance.sdk.component.tt.b.hc hcVar) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (hcVar == null) {
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
        int iD = hcVar.d();
        this.b = iD;
        an anVar = this.hc;
        if (anVar != null) {
            anVar.d(iD);
        }
        h.d().d(this.b).d(z);
        h.d().d(this.b).d(hcVar);
        h.d().d(this.b).d(context, w.d(context));
    }

    public void d(Context context, boolean z) {
        com.bytedance.sdk.component.tt.b.d.hc(true);
        if (d(context) || (!w.d(context) && z)) {
            h.d().d(this.b, context).c();
            h.d().d(this.b, context).d();
        }
        if (w.d(context)) {
            h.d().d(this.b, context).c();
            h.d().d(this.b, context).d();
        }
    }

    public static void d() {
        b.d(b.d.DEBUG);
    }

    public u hc() {
        return new u(this.d);
    }

    public com.bytedance.sdk.component.tt.hc.b b() {
        return new com.bytedance.sdk.component.tt.hc.b(this.d);
    }

    public com.bytedance.sdk.component.tt.hc.hc c() {
        return new com.bytedance.sdk.component.tt.hc.hc(this.d);
    }

    private static boolean d(Context context) {
        String strHc = w.hc(context);
        if (strHc != null) {
            return strHc.endsWith(":push") || strHc.endsWith(":pushservice");
        }
        return false;
    }

    public com.bytedance.sdk.component.tt.hc.d u() {
        return new com.bytedance.sdk.component.tt.hc.d(this.d);
    }

    public mq an() {
        return this.d;
    }

    /* renamed from: com.bytedance.sdk.component.tt.d$d, reason: collision with other inner class name */
    public static final class C0286d {
        private Set<String> an;
        private com.bytedance.sdk.component.hc.d.d.d.d gb;
        private Bundle h;
        boolean c = true;
        final List<tt> u = new ArrayList();
        int d = 10000;
        int hc = 10000;
        int b = 10000;

        public C0286d d(long j, TimeUnit timeUnit) {
            this.d = d("timeout", j, timeUnit);
            return this;
        }

        public C0286d hc(long j, TimeUnit timeUnit) {
            this.hc = d("timeout", j, timeUnit);
            return this;
        }

        public C0286d b(long j, TimeUnit timeUnit) {
            this.b = d("timeout", j, timeUnit);
            return this;
        }

        public C0286d d(boolean z) {
            this.c = z;
            return this;
        }

        public C0286d d(tt ttVar) {
            this.u.add(ttVar);
            return this;
        }

        public C0286d d(Set<String> set) {
            this.an = set;
            return this;
        }

        private static int d(String str, long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            }
            if (millis != 0 || j <= 0) {
                return (int) millis;
            }
            throw new IllegalArgumentException(str + " too small.");
        }

        public d d() {
            return new d(this);
        }
    }
}
