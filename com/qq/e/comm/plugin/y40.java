package com.qq.e.comm.plugin;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.comm.plugin.w40;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class y40 implements im, w40.f {
    private w40 b;
    private e8 c;
    private View d;
    private x40 e;
    private tl f;
    private String g;
    private y10 n;
    private boolean h = true;
    private int i = 0;
    private final Map<String, p4> j = new HashMap();
    private final w7 a = new w7();
    private final x9 m = new x9();

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ FrameLayout b;

        a(View view, FrameLayout frameLayout) {
            this.a = view;
            this.b = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout frameLayout;
            View view = this.a;
            if (view == null || (frameLayout = this.b) == null || frameLayout.indexOfChild(view) >= 0) {
                return;
            }
            this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.b.addView(this.a);
        }
    }

    /* compiled from: A */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (y40.this.c == null) {
                return;
            }
            y40.this.j();
            if (!y40.this.h) {
                y40.this.a.d();
            } else {
                y40.this.h = false;
                y40.this.a(s2.q);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (y40.this.c == null) {
                return;
            }
            y40.this.k();
            y40.this.a.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qq.e.comm.plugin.im
    public void a(e8 e8Var) {
        if (e8Var == null) {
            return;
        }
        this.c = e8Var;
        w40 w40Var = this.b;
        if (w40Var == null) {
            return;
        }
        w40Var.H();
        this.a.b();
        View viewA = this.b.A();
        if (viewA != 0) {
            if (viewA instanceof el) {
                ((el) viewA).a(new ao(viewA, this.c.c()));
            }
            ViewGroup.LayoutParams tqVar = new tq(this.b.w());
            e8 e8Var2 = this.c;
            String strE = e8Var2 != null ? e8Var2.e() : "";
            if (!TextUtils.isEmpty(strE)) {
                View view = new View(viewA.getContext());
                view.setBackgroundColor(Color.parseColor(strE));
                view.setTag(2131755013, "gdtdmmt");
                FrameLayout frameLayout = new FrameLayout(viewA.getContext());
                frameLayout.setLayoutParams(tqVar);
                frameLayout.addView(viewA);
                frameLayout.post(new a(view, frameLayout));
                this.d = frameLayout;
            } else {
                viewA.setLayoutParams(tqVar);
                this.d = viewA;
            }
            this.d.addOnAttachStateChangeListener(new b());
        }
        this.m.a();
    }

    @Override // com.qq.e.comm.plugin.im
    public View g() {
        return this.d;
    }

    @Override // com.qq.e.comm.plugin.im
    public String e() {
        String str = this.g;
        return str == null ? "" : str;
    }

    @Override // com.qq.e.comm.plugin.im
    public e8 c() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.im
    public y7 b(String str) {
        return this.a.a(str);
    }

    @Override // com.qq.e.comm.plugin.im
    public void clear() {
        if (this.i == 2) {
            w40 w40Var = this.b;
            if (w40Var != null) {
                w40Var.clear();
            }
            k();
            this.a.a();
            this.h = true;
            if (!a50.e) {
                this.c = null;
            }
            this.d = null;
            x40 x40Var = this.e;
            if (x40Var != null) {
                x40Var.a(null);
                this.e = null;
            }
            this.f = null;
            this.m.b();
            this.i = 1;
        }
    }

    @Override // com.qq.e.comm.plugin.im
    public void a(w40 w40Var) {
        this.b = w40Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        e8 e8Var = this.c;
        if (e8Var == null) {
            return;
        }
        ql qlVarH = e8Var.h();
        if (qlVarH != null) {
            qlVarH.start();
        }
        zl zlVarJ = this.c.j();
        if (zlVarJ != null) {
            zlVarJ.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        e8 e8Var = this.c;
        if (e8Var == null) {
            return;
        }
        ql qlVarH = e8Var.h();
        if (qlVarH != null) {
            qlVarH.stop();
        }
        zl zlVarJ = this.c.j();
        if (zlVarJ != null) {
            zlVarJ.stop();
        }
    }

    @Override // com.qq.e.comm.plugin.im
    public w40 h() {
        return this.b;
    }

    @Override // com.qq.e.comm.plugin.im
    public int f() {
        v40 v40VarV;
        w40 w40Var = this.b;
        if (w40Var == null || (v40VarV = w40Var.v()) == null) {
            return 0;
        }
        return v40VarV.b();
    }

    @Override // com.qq.e.comm.plugin.im
    public void c(String str) {
        this.g = str;
    }

    @Override // com.qq.e.comm.plugin.im
    public int d() {
        v40 v40VarV;
        w40 w40Var = this.b;
        if (w40Var == null || (v40VarV = w40Var.v()) == null) {
            return 0;
        }
        return v40VarV.c();
    }

    @Override // com.qq.e.comm.plugin.im
    public x9 i() {
        return this.m;
    }

    void a(w40 w40Var, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (!TextUtils.isEmpty(str)) {
            a(str);
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            a(jSONObject);
        }
        if (jSONObject2 == null || jSONObject2.length() <= 0) {
            return;
        }
        if (x9.c()) {
            a(jSONObject2);
        } else {
            w40Var.c(jSONObject2);
        }
    }

    @Override // com.qq.e.comm.plugin.im
    public int b() {
        return this.i;
    }

    @Override // com.qq.e.comm.plugin.fm
    public void a(String str, JSONObject jSONObject) {
        w40 w40Var = this.b;
        if (w40Var != null) {
            w40Var.a(str, jSONObject);
        }
    }

    @Override // com.qq.e.comm.plugin.im
    public void b(String str, r2 r2Var) {
        y7 y7VarB = b(str);
        if (y7VarB == null) {
            return;
        }
        y7VarB.a(r2Var);
    }

    @Override // com.qq.e.comm.plugin.im
    public w7 a() {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.w40.f
    public void a(w40 w40Var, z8 z8Var) {
        tl tlVar = this.f;
        if (tlVar == null) {
            return;
        }
        tlVar.a(w40Var, z8Var);
        a(w40Var, z8Var.d, z8Var.e, z8Var.f);
    }

    @Override // com.qq.e.comm.plugin.im
    public void a(String str, p4 p4Var) {
        if (p4Var == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.j.put(str, p4Var);
    }

    @Override // com.qq.e.comm.plugin.im
    public void a(gk gkVar) {
        if (this.b == null) {
            return;
        }
        if (this.e == null) {
            x40 x40Var = new x40(this);
            this.e = x40Var;
            this.b.a(x40Var);
        }
        this.e.a(gkVar);
    }

    @Override // com.qq.e.comm.plugin.im
    public void a(tl tlVar) {
        if (tlVar != null && this.f == null) {
            this.b.a((w40.f) this);
        }
        this.f = tlVar;
    }

    @Override // com.qq.e.comm.plugin.im
    public void a(int i) {
        this.i = i;
    }

    public void a(y10 y10Var) {
        this.n = y10Var;
    }

    @Override // com.qq.e.comm.plugin.im
    public void a(String str, r2 r2Var) {
        p4 p4Var = this.j.get(str);
        if (p4Var == null) {
            return;
        }
        p4Var.a(r2Var);
    }

    @Override // com.qq.e.comm.plugin.im
    public void a(String str) {
        b(str, null);
    }

    @Override // com.qq.e.comm.plugin.im
    public void a(JSONObject jSONObject) {
        if (x9.c()) {
            this.m.a(jSONObject);
            return;
        }
        w40 w40Var = this.b;
        if (w40Var != null) {
            w40Var.c(jSONObject);
        }
    }
}
