package com.bytedance.adsdk.lottie.d.d;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.d.hc.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements u, uo, d.InterfaceC0167d {
    private final String an;
    private final Matrix b;
    private final Path c;
    private final Paint d;
    private final List<b> gb;
    private final boolean h;
    private final RectF hc;
    private com.bytedance.adsdk.lottie.d.hc.cb mk;
    private List<uo> tc;
    private final com.bytedance.adsdk.lottie.gb tt;
    private final RectF u;

    private static List<b> d(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.an anVar, com.bytedance.adsdk.lottie.model.layer.b bVar, List<com.bytedance.adsdk.lottie.model.hc.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            b bVarD = list.get(i).d(gbVar, anVar, bVar);
            if (bVarD != null) {
                arrayList.add(bVarD);
            }
        }
        return arrayList;
    }

    static com.bytedance.adsdk.lottie.model.d.mq d(List<com.bytedance.adsdk.lottie.model.hc.b> list) {
        for (int i = 0; i < list.size(); i++) {
            com.bytedance.adsdk.lottie.model.hc.b bVar = list.get(i);
            if (bVar instanceof com.bytedance.adsdk.lottie.model.d.mq) {
                return (com.bytedance.adsdk.lottie.model.d.mq) bVar;
            }
        }
        return null;
    }

    public c(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.model.layer.b bVar, com.bytedance.adsdk.lottie.model.hc.cb cbVar, com.bytedance.adsdk.lottie.an anVar) {
        this(gbVar, bVar, cbVar.d(), cbVar.b(), d(gbVar, anVar, bVar, cbVar.hc()), d(cbVar.hc()));
    }

    c(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.model.layer.b bVar, String str, boolean z, List<b> list, com.bytedance.adsdk.lottie.model.d.mq mqVar) {
        this.d = new com.bytedance.adsdk.lottie.d.d();
        this.hc = new RectF();
        this.b = new Matrix();
        this.c = new Path();
        this.u = new RectF();
        this.an = str;
        this.tt = gbVar;
        this.h = z;
        this.gb = list;
        if (mqVar != null) {
            com.bytedance.adsdk.lottie.d.hc.cb cbVarTc = mqVar.tc();
            this.mk = cbVarTc;
            cbVarTc.d(bVar);
            this.mk.d(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            b bVar2 = list.get(size);
            if (bVar2 instanceof tc) {
                arrayList.add((tc) bVar2);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((tc) arrayList.get(size2)).d(list.listIterator(list.size()));
        }
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d.InterfaceC0167d
    public void d() {
        this.tt.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.d.d.b
    public void d(List<b> list, List<b> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.gb.size());
        arrayList.addAll(list);
        for (int size = this.gb.size() - 1; size >= 0; size--) {
            b bVar = this.gb.get(size);
            bVar.d(arrayList, this.gb.subList(0, size));
            arrayList.add(bVar);
        }
    }

    List<uo> hc() {
        if (this.tc == null) {
            this.tc = new ArrayList();
            for (int i = 0; i < this.gb.size(); i++) {
                b bVar = this.gb.get(i);
                if (bVar instanceof uo) {
                    this.tc.add((uo) bVar);
                }
            }
        }
        return this.tc;
    }

    Matrix b() {
        com.bytedance.adsdk.lottie.d.hc.cb cbVar = this.mk;
        if (cbVar != null) {
            return cbVar.c();
        }
        this.b.reset();
        return this.b;
    }

    @Override // com.bytedance.adsdk.lottie.d.d.uo
    public Path c() {
        this.b.reset();
        com.bytedance.adsdk.lottie.d.hc.cb cbVar = this.mk;
        if (cbVar != null) {
            this.b.set(cbVar.c());
        }
        this.c.reset();
        if (this.h) {
            return this.c;
        }
        for (int size = this.gb.size() - 1; size >= 0; size--) {
            b bVar = this.gb.get(size);
            if (bVar instanceof uo) {
                this.c.addPath(((uo) bVar).c(), this.b);
            }
        }
        return this.c;
    }

    @Override // com.bytedance.adsdk.lottie.d.d.u
    public void d(Canvas canvas, Matrix matrix, int i) {
        if (this.h) {
            return;
        }
        this.b.set(matrix);
        com.bytedance.adsdk.lottie.d.hc.cb cbVar = this.mk;
        if (cbVar != null) {
            this.b.preConcat(cbVar.c());
            i = (int) (((((this.mk.d() == null ? 100 : this.mk.d().h().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.tt.tc() && u() && i != 255;
        if (z) {
            this.hc.set(0.0f, 0.0f, 0.0f, 0.0f);
            d(this.hc, this.b, true);
            this.d.setAlpha(i);
            com.bytedance.adsdk.lottie.u.tt.d(canvas, this.hc, this.d);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.gb.size() - 1; size >= 0; size--) {
            b bVar = this.gb.get(size);
            if (bVar instanceof u) {
                ((u) bVar).d(canvas, this.b, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    private boolean u() {
        int i = 0;
        for (int i2 = 0; i2 < this.gb.size(); i2++) {
            if ((this.gb.get(i2) instanceof u) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.lottie.d.d.u
    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.b.set(matrix);
        com.bytedance.adsdk.lottie.d.hc.cb cbVar = this.mk;
        if (cbVar != null) {
            this.b.preConcat(cbVar.c());
        }
        this.u.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.gb.size() - 1; size >= 0; size--) {
            b bVar = this.gb.get(size);
            if (bVar instanceof u) {
                ((u) bVar).d(this.u, this.b, z);
                rectF.union(this.u);
            }
        }
    }
}
