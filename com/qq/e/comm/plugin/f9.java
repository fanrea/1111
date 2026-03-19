package com.qq.e.comm.plugin;

import android.view.View;
import com.qq.e.comm.plugin.callback.biz.VideoDownloadErrorCallback;
import com.qq.e.comm.plugin.dysi.IGDTBiz;
import com.qq.e.comm.plugin.hg;
import com.qq.e.comm.plugin.v8;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class f9 implements os {
    public static final /* synthetic */ int t = 0;
    protected final im a;
    protected final h4 b;
    protected final yq c;
    protected final f5 d;
    private hg.b f;
    protected ng h;
    protected List<String> i;
    protected List<String> j;
    protected gf m;
    private Set<w40> n;
    private View.OnAttachStateChangeListener s;
    protected final JSONObject e = new JSONObject();
    private boolean g = true;
    private final ns o = new ns();
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;

    public f9(im imVar, h4 h4Var, yq yqVar) throws JSONException {
        this.a = imVar;
        this.b = h4Var;
        this.c = yqVar;
        this.d = f5.a(h4Var, yqVar);
        e8 e8VarC = imVar.c();
        if (h4Var != null) {
            int iJ0 = h4Var.J0();
            e8VarC.a(iJ0 == -1 ? y8.a(h4Var) : iJ0);
            e8VarC.b(zu.a(y8.c(h4Var)));
            this.h = ng.a(this, imVar, h4Var, yqVar);
        }
        b();
        a();
        p();
    }

    public e8 e() {
        return this.a.c();
    }

    public View l() {
        return this.a.g();
    }

    im m() {
        return this.a;
    }

    public yq h() {
        return this.c;
    }

    public mh j() {
        if (f() == null) {
            return null;
        }
        return f().b();
    }

    public hg.b f() {
        hg.b bVar = this.f;
        if (bVar != null) {
            return bVar;
        }
        if (this.g) {
            this.f = (hg.b) this.a.g().findViewWithTag("GDTDLVideoView");
            this.g = false;
        }
        return this.f;
    }

    public boolean n() {
        hg.b bVarF = f();
        return bVarF != null && bVarF.f();
    }

    /* compiled from: A */
    class a implements hg.c {
        final /* synthetic */ hg.c a;

        a(hg.c cVar) {
            this.a = cVar;
        }

        @Override // com.qq.e.comm.plugin.hg.c
        public void onPlayStateChange(j40 j40Var, int i) {
            ng ngVar;
            IGDTBiz iGDTBizD;
            int i2 = f9.t;
            hg.c cVar = this.a;
            if (cVar != null) {
                cVar.onPlayStateChange(j40Var, i);
            }
            j40 j40Var2 = j40.ERROR;
            if ((j40Var == j40Var2 && f9.this.r) || (ngVar = f9.this.h) == null || (iGDTBizD = ngVar.d()) == null) {
                return;
            }
            iGDTBizD.onPlayStateChange(j40Var, i);
            if (j40Var == j40Var2) {
                f9.this.r = true;
            }
        }

        @Override // com.qq.e.comm.plugin.hg.c
        public void a(int i) {
            e2 e2VarK;
            hg.c cVar = this.a;
            if (cVar != null) {
                cVar.a(i);
            }
            h4 h4Var = f9.this.b;
            if (h4Var != null && (e2VarK = h4Var.k()) != null && !e2VarK.h() && !e2VarK.k() && !e2VarK.l()) {
                f9.this.a(i);
            }
            int i2 = f9.t;
        }
    }

    /* compiled from: A */
    class b extends ms<Void> {
        b(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r3) {
            ng ngVar;
            IGDTBiz iGDTBizD;
            int i = f9.t;
            if (f9.this.r || (ngVar = f9.this.h) == null || (iGDTBizD = ngVar.d()) == null) {
                return;
            }
            iGDTBizD.onPlayStateChange(j40.ERROR, -1);
            f9.this.r = true;
        }
    }

    /* compiled from: A */
    class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            f9.this.a(true);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            f9.this.a(false);
        }
    }

    /* compiled from: A */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            int iB;
            int iB2;
            View viewG = f9.this.a.g();
            if (viewG == null) {
                return;
            }
            if (((View) viewG.getParent()) != null) {
                iB = zu.b(r0.getWidth());
                iB2 = zu.b(r0.getHeight());
            } else {
                iB = 0;
                iB2 = 0;
            }
            if (iB == 0 || iB2 == 0) {
                return;
            }
            jn jnVar = new jn();
            jnVar.a("w", iB);
            jnVar.a("h", iB2);
            f9.this.a(new m8().a(jnVar.toString()).f());
        }
    }

    private void p() {
        this.a.g().post(new d());
    }

    protected void b() throws JSONException {
        v8.a aVarB = v8.b();
        if (this.b != null) {
            JSONObject jSONObjectF = new m8().d(this.b).f();
            c(jSONObjectF);
            this.a.a(new jn(this.b.i()).a("posID", this.b.y0()).a("dlInfo", jSONObjectF).a());
        }
        c(this.a.h());
        aVarB.c = x9.c() ? 1 : 2;
        v8.b(2230104, aVarB, e().c());
    }

    public void c() {
        if (this.p) {
            return;
        }
        this.p = true;
        if (this.b != null && k.b() && this.q) {
            x5.c(this.b.s0(), VideoDownloadErrorCallback.class);
        }
        if (this.s != null) {
            this.a.g().removeOnAttachStateChangeListener(this.s);
        }
        ng ngVar = this.h;
        if (ngVar != null) {
            ngVar.c();
        }
        this.a.clear();
    }

    public boolean o() {
        IGDTBiz iGDTBizG = g();
        return iGDTBizG != null && iGDTBizG.isTimerTickEnable();
    }

    public Set<w40> d() {
        return this.n;
    }

    protected IGDTBiz g() {
        ng ngVar = this.h;
        if (ngVar != null) {
            return ngVar.d();
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.os
    public ns i() {
        return this.o;
    }

    @Override // com.qq.e.comm.plugin.os
    public boolean k() {
        return this.p;
    }

    private void a(w40 w40Var) {
        if (this.n == null) {
            this.n = new HashSet();
        }
        this.n.add(w40Var);
    }

    public void b(JSONObject jSONObject) {
        gf gfVar = this.m;
        if (gfVar == null) {
            return;
        }
        gfVar.a(jSONObject);
    }

    private void c(JSONObject jSONObject) throws JSONException {
        if (this.j == null || this.h == null) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject2 = new JSONObject();
            for (String str : this.j) {
                Object objOpt = jSONObject.opt(str);
                if (!JSONObject.NULL.equals(objOpt)) {
                    jSONObject2.putOpt(str, objOpt);
                }
            }
            if (jSONObject2.length() > 0) {
                this.h.e().onBindData(jSONObject2);
                ey.a(System.currentTimeMillis() - jCurrentTimeMillis, this.d);
            }
        } catch (Exception unused) {
        }
    }

    private void a() {
        IGDTBiz iGDTBizG = g();
        if (iGDTBizG != null && iGDTBizG.isOnViewAppearanceChangedEnable()) {
            this.s = new c();
            this.a.g().addOnAttachStateChangeListener(this.s);
        }
    }

    public void a(JSONObject jSONObject) throws JSONException {
        if (ln.b(jSONObject)) {
            return;
        }
        try {
            c(jSONObject);
            this.e.putOpt("dlInfo", jSONObject);
            this.a.a(this.e);
        } catch (JSONException unused) {
        }
    }

    public void b(h8 h8Var) {
        gf gfVar = this.m;
        if (gfVar == null) {
            return;
        }
        gfVar.f(h8Var);
    }

    private void c(w40 w40Var) {
        if (b(w40Var)) {
            a(w40Var);
        }
        if (w40Var instanceof zn) {
            Iterator<w40> it = ((zn) w40Var).P().iterator();
            while (it.hasNext()) {
                c(it.next());
            }
        }
    }

    public void c(String str) {
        List<String> list = this.i;
        if (list != null && list.contains(str)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.h.e().onStartAnimation(str);
            ey.b(System.currentTimeMillis() - jCurrentTimeMillis, this.d);
        }
        y7 y7VarB = this.a.b(str);
        if (y7VarB != null) {
            y7VarB.start();
        }
    }

    public void a(h8 h8Var) {
        gf gfVar = this.m;
        if (gfVar == null) {
            return;
        }
        gfVar.c(h8Var);
    }

    public void a(String str) {
        this.a.a(str, (JSONObject) null);
    }

    private boolean b(w40 w40Var) {
        if (w40Var != null && w40Var.t().size() != 0) {
            for (h8 h8Var : w40Var.t()) {
                if ("adClose".equals(h8Var.b) || "endCardClose".equals(h8Var.b) || "forceCloseAd".equals(h8Var.b)) {
                    return true;
                }
            }
        }
        return false;
    }

    Object a(String str, String str2, Object... objArr) throws JSONException {
        if (this.h == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Object objA = this.h.a(str, str2, objArr);
        ey.a((int) (System.currentTimeMillis() - jCurrentTimeMillis), this.d, str2);
        return objA;
    }

    public void a(hg.c cVar) {
        a("initVideo");
        hg.b bVarF = f();
        if (bVarF == null) {
            return;
        }
        bVarF.a(new a(cVar));
        if (this.b == null || !k.b()) {
            return;
        }
        ((VideoDownloadErrorCallback) x5.b(this.b.s0(), VideoDownloadErrorCallback.class)).y().a(new b(this));
        this.q = true;
    }

    public void b(String str) {
        IGDTBiz iGDTBizG = g();
        if (iGDTBizG == null) {
            return;
        }
        iGDTBizG.onBizCustomEventTriggered(str);
    }

    public void a(List<String> list, List<String> list2) {
        this.j = list;
        this.i = list2;
    }

    public boolean a(i6 i6Var) {
        gf gfVar = this.m;
        if (gfVar == null || !gfVar.b(i6Var)) {
            return false;
        }
        this.m.a(i6Var, (h8) null);
        return true;
    }

    public void a(h8 h8Var, String str) {
        ng ngVar = this.h;
        if (ngVar != null) {
            ngVar.a(h8Var, str);
        }
    }

    public void a(long j) {
        ng ngVar = this.h;
        if (ngVar == null) {
            return;
        }
        ngVar.a(j);
        IGDTBiz iGDTBizD = this.h.d();
        if (iGDTBizD == null) {
            return;
        }
        iGDTBizD.onTimerTick(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        IGDTBiz iGDTBizG = g();
        if (iGDTBizG == null) {
            return;
        }
        iGDTBizG.onViewAppearanceChanged(z ? "1" : "0");
    }

    public void a(gf gfVar) {
        this.m = gfVar;
        this.a.a(gfVar);
    }

    public void a(tl tlVar) {
        this.a.a(tlVar);
    }
}
