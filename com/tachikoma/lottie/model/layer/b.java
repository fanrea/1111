package com.tachikoma.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.tachikoma.lottie.a.b.p;
import com.tachikoma.lottie.k;
import com.tachikoma.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b extends a {
    private final List<a> GR;
    private final RectF IB;
    private com.tachikoma.lottie.a.b.a<Float, Float> Mw;
    private final RectF Mx;

    public b(com.tachikoma.lottie.g gVar, Layer layer, List<Layer> list, com.tachikoma.lottie.e eVar) {
        int i;
        a aVar;
        super(gVar, layer);
        this.GR = new ArrayList();
        this.IB = new RectF();
        this.Mx = new RectF();
        com.tachikoma.lottie.model.a.b bVarLO = layer.lO();
        if (bVarLO != null) {
            this.Mw = bVarLO.kB();
            a(this.Mw);
            this.Mw.b(this);
        } else {
            this.Mw = null;
        }
        android.support.v4.d.e eVar2 = new android.support.v4.d.e(eVar.jw().size());
        int size = list.size() - 1;
        a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            a aVarA = a(layer2, gVar, eVar);
            if (aVarA != null) {
                eVar2.put(aVarA.lw().getId(), aVarA);
                if (aVar2 != null) {
                    aVar2.b(aVarA);
                    aVar2 = null;
                } else {
                    this.GR.add(0, aVarA);
                    int i2 = AnonymousClass1.My[layer2.lI().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        aVar2 = aVarA;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < eVar2.size(); i++) {
            a aVar3 = (a) eVar2.get(eVar2.keyAt(i));
            if (aVar3 != null && (aVar = (a) eVar2.get(aVar3.lw().lJ())) != null) {
                aVar3.c(aVar);
            }
        }
    }

    /* renamed from: com.tachikoma.lottie.model.layer.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] My = new int[Layer.MatteType.values().length];

        static {
            try {
                My[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                My[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.tachikoma.lottie.model.layer.a
    final void b(Canvas canvas, Matrix matrix, int i) {
        com.tachikoma.lottie.c.beginSection("CompositionLayer#draw");
        canvas.save();
        this.Mx.set(0.0f, 0.0f, this.Ml.lF(), this.Ml.lG());
        matrix.mapRect(this.Mx);
        for (int size = this.GR.size() - 1; size >= 0; size--) {
            if (!this.Mx.isEmpty() ? canvas.clipRect(this.Mx) : true) {
                this.GR.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.tachikoma.lottie.c.S("CompositionLayer#draw");
    }

    @Override // com.tachikoma.lottie.model.layer.a, com.tachikoma.lottie.a.a.e
    public final void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        for (int size = this.GR.size() - 1; size >= 0; size--) {
            this.IB.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.GR.get(size).a(this.IB, this.Mk, true);
            rectF.union(this.IB);
        }
    }

    @Override // com.tachikoma.lottie.model.layer.a
    public final void setProgress(float f) {
        super.setProgress(f);
        if (this.Mw != null) {
            f = ((long) (this.Mw.getValue().floatValue() * 1000.0f)) / this.Gt.getComposition().jt();
        }
        if (this.Ml.lB() != 0.0f) {
            f /= this.Ml.lB();
        }
        float fLC = f - this.Ml.lC();
        for (int size = this.GR.size() - 1; size >= 0; size--) {
            this.GR.get(size).setProgress(fLC);
        }
    }

    @Override // com.tachikoma.lottie.model.layer.a
    protected final void b(com.tachikoma.lottie.model.d dVar, int i, List<com.tachikoma.lottie.model.d> list, com.tachikoma.lottie.model.d dVar2) {
        for (int i2 = 0; i2 < this.GR.size(); i2++) {
            this.GR.get(i2).a(dVar, i, list, dVar2);
        }
    }

    @Override // com.tachikoma.lottie.model.layer.a, com.tachikoma.lottie.model.e
    public final <T> void a(T t, com.tachikoma.lottie.e.c<T> cVar) {
        super.a((b) t, (com.tachikoma.lottie.e.c<b>) cVar);
        if (t == k.Ij) {
            if (cVar == null) {
                this.Mw = null;
            } else {
                this.Mw = new p(cVar);
                a(this.Mw);
            }
        }
    }
}
