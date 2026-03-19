package com.baidu.mobads.container.rewardvideo;

import android.view.View;
import com.component.a.i.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g {
    public static final int a = 1;
    public static final int b = 5;
    public static final int c = 10;
    private static final int d = 5;
    private com.component.a.d.c g;
    private boolean h = false;
    private final Map<com.component.a.d.c, b> e = new HashMap();
    private final List<a> f = new ArrayList();

    public interface a {
        void a(com.component.a.d.c cVar);

        void b(com.component.a.d.c cVar);

        void c(com.component.a.d.c cVar);
    }

    public @interface c {
    }

    public void a(a aVar) {
        this.f.add(aVar);
    }

    public void b(a aVar) {
        this.f.remove(aVar);
    }

    public g a(com.component.a.d.c cVar, int i) {
        if (cVar != null) {
            b bVar = new b(cVar, i);
            this.e.put(cVar, bVar);
            com.component.a.i.f fVarA = com.component.a.i.f.a((View) cVar);
            if (fVarA != null) {
                fVarA.a((f.a) bVar);
            }
        }
        return this;
    }

    public void a(com.component.a.d.c cVar) {
        if (cVar != null) {
            b bVarRemove = this.e.remove(cVar);
            com.component.a.i.f fVarA = com.component.a.i.f.a((View) cVar);
            if (fVarA != null) {
                fVarA.b((f.a) bVarRemove);
            }
        }
    }

    public boolean a() {
        return this.g != null && this.g.getVisibility() == 0 && com.component.a.i.w.a(this.g);
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b(boolean z) {
        if (this.g != null) {
            if (z) {
                com.baidu.mobads.container.util.cf.b(this.g);
            } else {
                this.g.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.component.a.d.c cVar) {
        int i;
        if (this.h && cVar != null) {
            cVar.setVisibility(4);
            Iterator<a> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().c(cVar);
            }
            return;
        }
        if (cVar == null || cVar == this.g || cVar.getVisibility() != 0 || cVar.getParent() == null) {
            return;
        }
        if (this.g == null) {
            this.g = cVar;
            Iterator<a> it2 = this.f.iterator();
            while (it2.hasNext()) {
                it2.next().a(cVar);
            }
            return;
        }
        b bVar = this.e.get(cVar);
        if (bVar == null) {
            i = 5;
        } else {
            i = bVar.b;
        }
        if (this.e.get(this.g).b >= i) {
            cVar.setVisibility(4);
            Iterator<a> it3 = this.f.iterator();
            while (it3.hasNext()) {
                it3.next().c(cVar);
            }
            return;
        }
        com.component.a.d.c cVar2 = this.g;
        this.g = cVar;
        cVar2.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.component.a.d.c cVar) {
        if (cVar == this.g) {
            this.g = null;
            Iterator<a> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().b(cVar);
            }
        }
    }

    class b extends f.a {
        final com.component.a.d.c a;
        final int b;
        boolean c;

        b(com.component.a.d.c cVar, int i) {
            this.a = cVar;
            this.b = i;
            this.c = com.component.a.i.w.a(cVar) && cVar.isShown();
        }

        @Override // com.component.a.i.f.a
        public void a(View view, int i) {
            if (i == 0 && !this.c && this.a == view) {
                this.c = true;
                g.this.b(this.a);
            } else if (i != 0 && this.c && this.a == view) {
                this.c = false;
                g.this.c(this.a);
            }
        }

        @Override // com.component.a.i.f.a
        public void a(View view) {
            if (this.a.isShown() && !this.c) {
                this.c = true;
                this.a.post(new h(this));
            }
        }

        @Override // com.component.a.i.f.a
        public void b(View view) {
            if (this.c) {
                this.c = false;
                g.this.c(this.a);
            }
        }
    }
}
