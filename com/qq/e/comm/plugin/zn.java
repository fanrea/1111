package com.qq.e.comm.plugin;

import android.view.ViewGroup;
import com.qq.e.comm.plugin.el;
import com.qq.e.comm.plugin.u40;
import com.qq.e.comm.plugin.w40;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class zn<L extends u40<V>, V extends ViewGroup & el> extends w40<L, V> {
    private final List<w40> G = new ArrayList();

    public boolean N() {
        return false;
    }

    @Override // com.qq.e.comm.plugin.w40
    public void H() {
        super.H();
        for (w40 w40Var : this.G) {
            if (w40Var != null) {
                w40Var.H();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    protected void M() {
        super.M();
        if (!this.t.a() || A() == null) {
            return;
        }
        A().setWillNotDraw(false);
    }

    public final int O() {
        return this.G.size();
    }

    public w40 m(int i) {
        if (i < 0 || i >= this.G.size()) {
            return null;
        }
        return this.G.get(i);
    }

    public void d(w40 w40Var) {
        if (w40Var != null) {
            this.G.add(w40Var);
            w40Var.a(this);
        }
    }

    public void c(w40 w40Var) {
        T t;
        if (w40Var == null || (t = this.f) == 0) {
            return;
        }
        ((u40) t).a(w40Var);
    }

    protected ViewGroup.LayoutParams a(rk rkVar) {
        return ((u40) this.f).a(rkVar);
    }

    public List<w40> P() {
        return this.G;
    }

    @Override // com.qq.e.comm.plugin.w40
    public void clear() {
        super.clear();
        Iterator<w40> it = this.G.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    public void c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0 || x().a(jSONObject) || !K()) {
            return;
        }
        Iterator<w40> it = this.G.iterator();
        while (it.hasNext()) {
            it.next().c(jSONObject);
        }
        super.c(jSONObject);
    }

    @Override // com.qq.e.comm.plugin.w40, com.qq.e.comm.plugin.fm
    public void a(String str, JSONObject jSONObject) {
        for (w40 w40Var : this.G) {
            if (w40Var.K()) {
                w40Var.a(str, jSONObject);
            }
        }
        super.a(str, jSONObject);
    }

    @Override // com.qq.e.comm.plugin.w40
    public void a(w40.d dVar) {
        super.a(dVar);
        Iterator<w40> it = this.G.iterator();
        while (it.hasNext()) {
            it.next().a(dVar);
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    public void a(w40.f fVar) {
        super.a(fVar);
        Iterator<w40> it = this.G.iterator();
        while (it.hasNext()) {
            it.next().a(fVar);
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        if ("60".equals(str)) {
            v().c(cmVar.f(new JSONObject[0]) == 1);
            return true;
        }
        return super.a(str, cmVar);
    }
}
