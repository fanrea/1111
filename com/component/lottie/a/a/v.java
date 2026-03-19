package com.component.lottie.a.a;

import android.graphics.Path;
import com.component.lottie.a.b.a;
import com.component.lottie.af;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class v implements p, a.InterfaceC0322a {
    private final String b;
    private final boolean c;
    private final af d;
    private final com.component.lottie.a.b.o e;
    private List<w> f;
    private boolean g;
    private final Path a = new Path();
    private final c h = new c();

    public v(af afVar, com.component.lottie.d.c.a aVar, com.component.lottie.d.b.q qVar) {
        this.b = qVar.a();
        this.c = qVar.c();
        this.d = afVar;
        this.e = qVar.b().a();
        aVar.a(this.e);
        this.e.a(this);
    }

    @Override // com.component.lottie.a.b.a.InterfaceC0322a
    public void a() {
        c();
    }

    private void c() {
        this.g = false;
        this.d.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    @Override // com.component.lottie.a.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.util.List<com.component.lottie.a.a.d> r6, java.util.List<com.component.lottie.a.a.d> r7) {
        /*
            r5 = this;
            r7 = 0
            r0 = 0
        L3:
            int r1 = r6.size()
            if (r0 >= r1) goto L3d
            java.lang.Object r1 = r6.get(r0)
            com.component.lottie.a.a.d r1 = (com.component.lottie.a.a.d) r1
            boolean r2 = r1 instanceof com.component.lottie.a.a.y
            if (r2 == 0) goto L28
            r2 = r1
            com.component.lottie.a.a.y r2 = (com.component.lottie.a.a.y) r2
            com.component.lottie.d.b.t$a r3 = r2.c()
            com.component.lottie.d.b.t$a r4 = com.component.lottie.d.b.t.a.SIMULTANEOUSLY
            if (r3 != r4) goto L28
        L1f:
            com.component.lottie.a.a.c r1 = r5.h
            r1.a(r2)
            r2.a(r5)
            goto L39
        L28:
            boolean r2 = r1 instanceof com.component.lottie.a.a.w
            if (r2 == 0) goto L39
            if (r7 != 0) goto L33
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L33:
            com.component.lottie.a.a.w r1 = (com.component.lottie.a.a.w) r1
            r7.add(r1)
            goto L3a
        L39:
        L3a:
            int r0 = r0 + 1
            goto L3
        L3d:
            com.component.lottie.a.b.o r6 = r5.e
            r6.a(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.lottie.a.a.v.a(java.util.List, java.util.List):void");
    }

    @Override // com.component.lottie.a.a.p
    public Path e() {
        if (this.g) {
            return this.a;
        }
        this.a.reset();
        if (this.c) {
            this.g = true;
            return this.a;
        }
        Path pathG = this.e.g();
        if (pathG == null) {
            return this.a;
        }
        this.a.set(pathG);
        this.a.setFillType(Path.FillType.EVEN_ODD);
        this.h.a(this.a);
        this.g = true;
        return this.a;
    }

    @Override // com.component.lottie.a.a.d
    public String b() {
        return this.b;
    }
}
