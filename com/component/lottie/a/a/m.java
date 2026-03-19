package com.component.lottie.a.a;

import android.graphics.Path;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class m implements k, p {
    private final String d;
    private final com.component.lottie.d.b.i f;
    private final Path a = new Path();
    private final Path b = new Path();
    private final Path c = new Path();
    private final List<p> e = new ArrayList();

    public m(com.component.lottie.d.b.i iVar) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.d = iVar.a();
        this.f = iVar;
    }

    @Override // com.component.lottie.a.a.k
    public void a(ListIterator<d> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            d dVarPrevious = listIterator.previous();
            if (dVarPrevious instanceof p) {
                this.e.add((p) dVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.component.lottie.a.a.d
    public void a(List<d> list, List<d> list2) {
        for (int i = 0; i < this.e.size(); i++) {
            this.e.get(i).a(list, list2);
        }
    }

    @Override // com.component.lottie.a.a.p
    public Path e() {
        this.c.reset();
        if (this.f.c()) {
            return this.c;
        }
        switch (n.a[this.f.b().ordinal()]) {
            case 1:
                a();
                break;
            case 2:
                a(Path.Op.UNION);
                break;
            case 3:
                a(Path.Op.REVERSE_DIFFERENCE);
                break;
            case 4:
                a(Path.Op.INTERSECT);
                break;
            case 5:
                a(Path.Op.XOR);
                break;
        }
        return this.c;
    }

    @Override // com.component.lottie.a.a.d
    public String b() {
        return this.d;
    }

    private void a() {
        for (int i = 0; i < this.e.size(); i++) {
            this.c.addPath(this.e.get(i).e());
        }
    }

    private void a(Path.Op op) {
        this.b.reset();
        this.a.reset();
        for (int size = this.e.size() - 1; size >= 1; size--) {
            p pVar = this.e.get(size);
            if (pVar instanceof e) {
                e eVar = (e) pVar;
                List<p> listC = eVar.c();
                for (int size2 = listC.size() - 1; size2 >= 0; size2--) {
                    Path pathE = listC.get(size2).e();
                    pathE.transform(eVar.d());
                    this.b.addPath(pathE);
                }
            } else {
                this.b.addPath(pVar.e());
            }
        }
        p pVar2 = this.e.get(0);
        if (pVar2 instanceof e) {
            e eVar2 = (e) pVar2;
            List<p> listC2 = eVar2.c();
            for (int i = 0; i < listC2.size(); i++) {
                Path pathE2 = listC2.get(i).e();
                pathE2.transform(eVar2.d());
                this.a.addPath(pathE2);
            }
        } else {
            this.a.set(pVar2.e());
        }
        this.c.op(this.a, this.b, op);
    }
}
