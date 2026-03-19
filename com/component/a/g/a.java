package com.component.a.g;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.by;
import com.component.a.b.e;
import com.component.a.c.d;
import com.component.a.d.c;
import com.component.a.f.a;
import com.component.a.f.e;
import com.component.a.g.c.aa;
import com.component.a.g.c.bj;
import com.component.a.g.c.bk;
import com.component.a.g.c.bl;
import com.component.a.g.c.bm;
import com.component.a.g.c.bo;
import com.component.a.g.c.br;
import com.component.a.g.c.bx;
import com.component.a.g.c.e;
import com.component.a.g.c.g;
import com.component.a.g.c.k;
import com.component.a.g.c.m;
import com.component.a.g.c.v;
import com.component.a.i.f;
import com.component.a.i.w;
import com.style.widget.marketing.MarketingTextViewModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a implements com.component.a.c.d {
    private final Context a;
    private final j b;
    private String c;
    private String d;
    private String e;
    private final com.component.a.g.b f;
    private final by.b g;
    private final C0317a j;
    private final com.component.a.b.f k;
    private com.component.a.f l;
    private d.a m;
    private final List<com.component.a.i.f> h = new ArrayList();
    private final List<com.component.a.g.c.e> i = new ArrayList();
    private final Set<String> n = new HashSet();
    private final Set<String> o = new HashSet();
    private final Set<String> p = new HashSet();

    public a(Context context, j jVar, com.component.a.g.b bVar, by.b bVar2, C0317a c0317a) {
        this.c = "lp";
        this.d = "image";
        this.e = "common";
        this.a = context.getApplicationContext();
        this.b = jVar;
        this.g = bVar2;
        c0317a = c0317a == null ? new C0317a() : c0317a;
        this.j = c0317a;
        if (c0317a.c == null) {
            this.f = bVar;
        } else {
            this.f = c0317a.c;
        }
        this.f.a(this.j.p);
        this.c = g();
        this.d = h();
        this.e = this.j.v;
        this.k = new com.component.a.b.f(c0317a.d);
        f();
    }

    public void a(View view) {
        this.l = new com.component.a.f(view);
        this.k.a(this.l);
        for (String str : this.j.e.keySet()) {
            this.k.a(str, (e.a) this.j.e.get(str));
        }
    }

    public com.component.a.f b() {
        if (this.l != null) {
            return this.l;
        }
        return new com.component.a.f(null);
    }

    private void f() {
        e.a aVar = new e.a(this);
        this.i.add(new com.component.a.g.c.g(this.a, this.b, aVar, this.j.j));
        this.i.add(new bx(this.a, this.b, aVar, this.j.k));
        this.i.add(new k(this.a, this.b, aVar));
        this.i.add(new bm(this.a, this.b, aVar, this.j.i));
        this.i.add(new bl(this.a, this.b, aVar));
        this.i.add(new br(this.a, this.b, aVar));
        this.i.add(new MarketingTextViewModule(this.a, this.b, aVar));
        this.i.add(new bo(this.a, this.b, aVar, this.j.m));
        this.i.add(new com.component.a.g.c.a(this.a, this.b, aVar));
        this.i.add(new v(this.a, this.b, aVar));
        this.i.add(new bj(this.a, this.b, aVar));
        this.i.add(new bk(this.a, this.b, aVar));
        this.i.add(new aa(this.a, this.b, aVar));
        this.i.add(new com.component.a.g.c.d(this.a, this.b, aVar));
        this.i.add(new m(this.a, this.b, aVar));
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String[] strArrSplit = str.split("/");
        this.n.clear();
        this.o.clear();
        this.p.clear();
        int length = strArrSplit.length;
        for (int i = 0; i < length; i++) {
            String strB = strArrSplit[i];
            if (TextUtils.equals(com.component.a.g.b.t, strB) || TextUtils.equals("ios", strB) || TextUtils.equals("render", strB)) {
                return false;
            }
            if (TextUtils.equals("android", strB) && strArrSplit.length == 1) {
                return true;
            }
            if (TextUtils.equals("dl_all", strB)) {
                strB = a.EnumC0315a.DL.b();
            }
            if (a.EnumC0315a.b(strB)) {
                this.n.add(strB);
            }
            if (a.c.b(strB)) {
                this.o.add(strB);
            }
            if (a.b.b(strB)) {
                this.p.add(strB);
            }
        }
        return (this.n.isEmpty() || this.n.contains(this.c)) && (this.o.isEmpty() || this.o.contains(this.d)) && (this.p.isEmpty() || this.p.contains(this.e));
    }

    @Override // com.component.a.c.d
    public boolean a(com.component.a.f.d dVar) {
        if (dVar == null) {
            return false;
        }
        View viewE = dVar.e();
        if (this.b != null) {
            if (!a(dVar.g())) {
                return false;
            }
            com.component.a.f.e eVarF = dVar.f();
            if (eVarF != null) {
                dVar.a(b(viewE, eVarF));
                return true;
            }
            return true;
        }
        return true;
    }

    private View b(View view, com.component.a.f.e eVar) {
        if (eVar != null && e.d.VIDEO.equals(eVar.e()) && (!j.a.VIDEO.equals(this.b.getCreativeType()) || TextUtils.isEmpty(this.b.getVideoUrl()))) {
            view = new com.component.a.a.e().a(this.a, eVar);
        }
        Iterator<com.component.a.g.c.e> it = this.i.iterator();
        while (it.hasNext()) {
            View viewOnPrepareView = it.next().onPrepareView(view, eVar);
            if (viewOnPrepareView != null) {
                view = viewOnPrepareView;
            }
        }
        return view;
    }

    @Override // com.component.a.c.d
    public View b(com.component.a.f.d dVar) {
        com.component.a.i.f fVarA;
        if (dVar == null) {
            return null;
        }
        View viewE = dVar.e();
        com.component.a.f.e eVarF = dVar.f();
        if (this.b != null && viewE != null && eVarF != null && (fVarA = com.component.a.i.f.a(viewE)) != null) {
            fVarA.a((f.a) new b(eVarF, this.b, this.j));
            this.h.add(fVarA);
            this.k.a(fVarA);
            e.b bVarM = eVarF.m();
            for (String str : bVarM.b()) {
                this.k.a(str, com.component.a.b.a.a(viewE, bVarM.a(str)));
            }
            e.b bVarN = eVarF.n();
            for (String str2 : bVarN.b()) {
                this.k.a(fVarA, str2, com.component.a.b.a.a(viewE, bVarN.a(str2)));
            }
        }
        Iterator<com.component.a.g.c.e> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().onCreateView(dVar);
        }
        if (viewE != null && eVarF != null) {
            Animator animatorA = a(viewE, eVarF);
            com.component.a.i.f fVarA2 = com.component.a.i.f.a(viewE);
            if (fVarA2 != null) {
                fVarA2.a(animatorA);
            }
        }
        if (this.m != null) {
            this.m.a(dVar);
        }
        return viewE;
    }

    protected Animator a(View view, com.component.a.f.e eVar) {
        Iterator<com.component.a.g.c.e> it = this.i.iterator();
        Animator animator = null;
        while (it.hasNext()) {
            Animator animatorInitViewAnimation = it.next().initViewAnimation(view, eVar);
            if (animatorInitViewAnimation != null) {
                animator = animatorInitViewAnimation;
            }
        }
        if (animator != null) {
            return animator;
        }
        e.C0316e c0316eJ = eVar.j();
        a.c cVarA = a(view, com.baidu.mobads.container.util.animation.a.a(view), eVar, c0316eJ);
        if (a.b.GROUP.b().equals(c0316eJ.a(""))) {
            List<e.C0316e> listC = c0316eJ.c();
            ArrayList arrayList = new ArrayList();
            if (listC.size() > 0) {
                for (e.C0316e c0316e : listC) {
                    arrayList.add(a(view, com.baidu.mobads.container.util.animation.a.a(view), eVar, c0316e).d(c0316e.a("")));
                }
            }
            cVarA.a(arrayList);
        }
        return cVarA.d(c0316eJ.a("")).i();
    }

    protected a.c a(View view, a.c cVar, com.component.a.f.e eVar, e.C0316e c0316e) {
        e.f fVarH = eVar.h();
        cVar.a(c0316e.a(-1)).b(c0316e.b(0)).c(c0316e.c(-2)).a(c0316e.b()).a(c0316e.b("")).b(c0316e.c("")).c(c0316e.d("")).a(c0316e.a(new int[0])).d(ab.a(this.a, fVarH.g(0))).a(fVarH.f(-2.0f));
        Iterator<com.component.a.g.c.e> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().buildJsonAnimator(view, cVar, eVar, c0316e);
        }
        return cVar;
    }

    public by.b c() {
        return this.g;
    }

    public w d() {
        return this.j.t;
    }

    public com.component.a.d.c e() {
        return this.j.u;
    }

    @Override // com.component.a.c.d
    public void a() {
        Iterator<com.component.a.g.c.e> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        Iterator<com.component.a.i.f> it2 = this.h.iterator();
        while (it2.hasNext()) {
            it2.next().g();
        }
        this.h.clear();
    }

    @Override // com.component.a.c.d
    public void c(com.component.a.f.d dVar) {
        com.component.a.i.f fVarA;
        Iterator<com.component.a.g.c.e> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().onClickView(dVar);
        }
        if (this.f != null) {
            this.f.a(dVar);
        }
        if (dVar.e() != null && (fVarA = com.component.a.i.f.a(dVar.e())) != null) {
            fVarA.a(com.component.a.g.b.c.d);
        }
        if (this.m != null) {
            this.m.b(dVar);
        }
    }

    @Override // com.component.a.c.d
    public void a(com.component.a.f.d dVar, ViewGroup viewGroup) {
        Iterator<com.component.a.g.c.e> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().onRootAttach(dVar, viewGroup);
        }
    }

    @Override // com.component.a.c.d
    public void d(com.component.a.f.d dVar) {
        Iterator<com.component.a.g.c.e> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().onCustomEvent(dVar);
        }
        if (this.m != null) {
            this.m.c(dVar);
        }
    }

    @Override // com.component.a.c.d
    public void a(d.a aVar) {
        this.m = aVar;
    }

    private String g() {
        if (this.b != null) {
            ab.a aVarA = ab.a(this.a, this.b);
            if (ab.a.APP_DOWNLOAD.equals(aVarA)) {
                return a.EnumC0315a.DL.b();
            }
            if (ab.a.DEEP_LINK.equals(aVarA)) {
                return a.EnumC0315a.APO.b();
            }
            return a.EnumC0315a.LP.b();
        }
        return a.EnumC0315a.LP.b();
    }

    private String h() {
        if (this.b != null && TextUtils.equals("video", this.b.getMaterialType())) {
            return a.c.VIDEO.b();
        }
        return a.c.IMAGE.b();
    }

    private static class b extends f.a {
        private final com.component.a.f.e a;
        private final j b;
        private final C0317a c;

        b(com.component.a.f.e eVar, j jVar, C0317a c0317a) {
            this.a = eVar;
            this.b = jVar;
            this.c = c0317a;
        }

        @Override // com.component.a.i.f.a
        public void a(ViewGroup.LayoutParams layoutParams) {
            if (this.a != null) {
                float fA = this.a.a(0.0f);
                if (fA < 0.0f && this.b != null) {
                    int mainMaterialWidth = this.b.getMainMaterialWidth();
                    int mainMaterialHeight = this.b.getMainMaterialHeight();
                    if (mainMaterialWidth > 0 && mainMaterialHeight > 0) {
                        fA = mainMaterialWidth / mainMaterialHeight;
                        if (this.c.r > 0.0f) {
                            fA = Math.max(this.c.r, fA);
                        }
                        if (this.c.s > 0.0f) {
                            fA = Math.min(this.c.s, fA);
                        }
                    } else if (this.c != null) {
                        fA = this.c.q;
                    }
                    if (fA > 0.0f) {
                        if (layoutParams instanceof c.a) {
                            ((c.a) layoutParams).a().u = fA;
                        } else if (layoutParams.width > 0) {
                            layoutParams.height = (int) (layoutParams.width / fA);
                        } else if (layoutParams.height > 0) {
                            layoutParams.width = (int) (layoutParams.height * fA);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.component.a.g.a$a, reason: collision with other inner class name */
    public static class C0317a {
        private com.component.a.g.b c;
        private com.component.a.b.e d;
        private bm.a i;
        private g.a j;
        private bx.a k;
        private bo.a m;
        private w t;
        private final Map<String, e.a> e = new HashMap();
        private boolean f = true;
        private boolean g = true;
        private boolean h = false;
        boolean a = false;
        boolean b = false;
        private boolean l = false;
        private boolean n = false;
        private boolean o = false;
        private boolean p = false;
        private float q = 1.778f;
        private float r = 0.0f;
        private float s = 0.0f;
        private com.component.a.d.c u = null;
        private String v = "common";

        public C0317a a(com.component.a.g.b bVar) {
            this.c = bVar;
            return this;
        }

        public C0317a a(com.component.a.b.e eVar) {
            this.d = eVar;
            return this;
        }

        public C0317a a(com.component.a.b.j jVar, e.a aVar) {
            this.e.put(jVar.a(), aVar);
            return this;
        }

        C0317a a(w wVar) {
            this.t = wVar;
            return this;
        }

        public C0317a a(com.component.a.d.c cVar) {
            this.u = cVar;
            return this;
        }

        public C0317a a(a.b bVar) {
            this.v = bVar.b();
            return this;
        }

        public C0317a a(boolean z, g.a aVar) {
            this.j = aVar;
            this.f = z;
            return this;
        }

        public C0317a a(boolean z, bo.a aVar) {
            this.l = z;
            this.m = aVar;
            return this;
        }

        public C0317a a(boolean z) {
            this.n = z;
            return this;
        }

        public C0317a b(boolean z) {
            this.o = z;
            return this;
        }

        public C0317a a(boolean z, bx.a aVar) {
            this.a = z;
            this.k = aVar;
            return this;
        }

        public C0317a c(boolean z) {
            this.g = z;
            return this;
        }

        public C0317a a(boolean z, bm.a aVar) {
            this.h = z;
            this.i = aVar;
            return this;
        }

        public C0317a d(boolean z) {
            this.p = z;
            return this;
        }

        public C0317a a(float f, float f2, float f3) {
            this.q = f;
            this.r = f2;
            this.s = f3;
            return this;
        }

        public C0317a e(boolean z) {
            this.b = z;
            return this;
        }
    }
}
