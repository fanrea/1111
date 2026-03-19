package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.z20;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class d9 extends s0 implements zl, ts {

    @Deprecated
    private final List<ts> q = new ArrayList();
    private boolean r = false;
    private boolean s = false;
    private z20 t;
    private int u;
    private int v;
    private boolean w;

    @Override // com.qq.e.comm.plugin.ts
    public void a() {
    }

    @Override // com.qq.e.comm.plugin.zl
    public void c() {
        this.s = true;
    }

    @Override // com.qq.e.comm.plugin.zl
    public boolean d() {
        return this.w;
    }

    @Override // com.qq.e.comm.plugin.s0
    protected void h() {
        super.h();
        int iE = this.u;
        if (iE <= 0) {
            iE = aq.e(this.a, this.f);
        }
        int iD = this.v;
        if (iD <= 0) {
            iD = aq.d(this.a, this.f);
        }
        z20 z20VarA = z20.a.a(iE, iD, aq.b(this.a));
        if (z20VarA != null) {
            aq.a(this.a, z20VarA, "startTwist");
            z20VarA.a(this);
            if (this.s) {
                int iF = aq.f(this.a, this.f);
                if (iF > 0) {
                    iE = iF;
                }
                z20VarA.c(iE);
            }
        }
        this.b = z20VarA;
        this.t = z20VarA;
        this.o = aq.c();
    }

    @Override // com.qq.e.comm.plugin.s0, com.qq.e.comm.plugin.yk
    public void stop() {
        super.stop();
        l();
    }

    private void a(h8 h8Var, float f, int i, int i2, int i3, long j) throws JSONException {
        boolean z = !TextUtils.isEmpty(h8Var.j);
        a(h8Var, "tf", Float.valueOf(f), z);
        a(h8Var, "tx", Integer.valueOf(i), z);
        a(h8Var, "ty", Integer.valueOf(i2), z);
        a(h8Var, "tz", Integer.valueOf(i3), z);
        if (f >= 1.0f) {
            a(h8Var, "nt", Long.valueOf(j), z);
        }
    }

    @Override // com.qq.e.comm.plugin.ts
    public void b() {
        Iterator<ts> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        l();
    }

    private void l() {
        gk gkVar;
        WeakReference<gk> weakReference = this.g;
        if (weakReference == null || !this.r || (gkVar = weakReference.get()) == null) {
            return;
        }
        this.r = false;
        for (Map.Entry<w40, h8> entry : this.c.entrySet()) {
            h8 value = entry.getValue();
            if (value.h) {
                gkVar.a(entry.getKey(), value);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.zl
    @Deprecated
    public void b(ts tsVar) {
        this.q.remove(tsVar);
    }

    @Override // com.qq.e.comm.plugin.zl
    public void b(int i) {
        if (i <= 0) {
            return;
        }
        z20 z20Var = this.t;
        if (z20Var != null) {
            z20Var.b(i);
        }
        this.v = i;
    }

    private void a(h8 h8Var, String str, Object obj, boolean z) throws JSONException {
        h8Var.a(str, obj);
        if (z) {
            h8Var.a(str + h8Var.j, obj);
        }
    }

    @Override // com.qq.e.comm.plugin.ts
    public void a(int i, int i2, int i3, int i4, float f) throws JSONException {
        gk gkVar = this.g.get();
        if (gkVar == null) {
            return;
        }
        Iterator<ts> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().a(i, i2, i3, i4, f);
        }
        if (f < this.o) {
            this.p = false;
        } else if (!this.p) {
            this.p = true;
            this.n = System.currentTimeMillis();
            long j = this.n;
        }
        if (this.d) {
            if (this.r) {
                for (Map.Entry<w40, h8> entry : this.c.entrySet()) {
                    h8 value = entry.getValue();
                    if (value.h) {
                        a(value, f, i, i2, i3, 0L);
                        gkVar.a(entry.getKey(), value, f);
                    }
                }
                return;
            }
            this.r = true;
            for (Map.Entry<w40, h8> entry2 : this.c.entrySet()) {
                h8 value2 = entry2.getValue();
                if (value2.h) {
                    a(value2, f, i, i2, i3, 0L);
                    gkVar.c(entry2.getKey(), value2);
                }
            }
        }
    }

    @Override // com.qq.e.comm.plugin.ts
    public void a(int i, int i2, int i3, int i4, long j) throws JSONException {
        gk gkVar = this.g.get();
        if (gkVar != null && i()) {
            Iterator<ts> it = this.q.iterator();
            while (it.hasNext()) {
                it.next().a(i, i2, i3, i4, j);
            }
            h8 h8VarG = g();
            h8VarG.a("motionDuration", Long.valueOf(System.currentTimeMillis() - this.n));
            a(h8VarG, 1.0f, i, i2, i3, j);
            gkVar.b(this.e, h8VarG);
        }
    }

    @Override // com.qq.e.comm.plugin.zl
    @Deprecated
    public void a(ts tsVar) {
        this.q.add(tsVar);
    }

    @Override // com.qq.e.comm.plugin.s0
    public void a(h4 h4Var) {
        super.a(h4Var);
        boolean zC = aq.c(this.a);
        this.w = zC;
        if (zC) {
            c();
        }
    }

    @Override // com.qq.e.comm.plugin.zl
    public void a(int i) {
        if (i <= 0) {
            return;
        }
        z20 z20Var = this.t;
        if (z20Var != null) {
            z20Var.a(i);
        }
        this.u = i;
    }
}
