package com.kwad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.kwad.lottie.a.b.p;
import com.kwad.lottie.i;
import com.kwad.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends a {
    private final List<a> bjQ;
    private final RectF blm;
    private com.kwad.lottie.a.b.a<Float, Float> boG;
    private final RectF boH;

    public b(com.kwad.lottie.f fVar, Layer layer, List<Layer> list, com.kwad.lottie.d dVar) {
        int i;
        a aVar;
        super(fVar, layer);
        this.bjQ = new ArrayList();
        this.blm = new RectF();
        this.boH = new RectF();
        com.kwad.lottie.model.a.b bVarSr = layer.Sr();
        if (bVarSr != null) {
            com.kwad.lottie.a.b.a<Float, Float> aVarRj = bVarSr.Rj();
            this.boG = aVarRj;
            a(aVarRj);
            this.boG.b(this);
        } else {
            this.boG = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(dVar.Qg().size());
        int size = list.size() - 1;
        a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            a aVarA = a.a(layer2, fVar, dVar);
            if (aVarA != null) {
                longSparseArray.put(aVarA.RZ().getId(), aVarA);
                if (aVar2 != null) {
                    aVar2.b(aVarA);
                    aVar2 = null;
                } else {
                    this.bjQ.add(0, aVarA);
                    int i2 = AnonymousClass1.boI[layer2.Sl().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        aVar2 = aVarA;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            a aVar3 = (a) longSparseArray.get(longSparseArray.keyAt(i));
            if (aVar3 != null && (aVar = (a) longSparseArray.get(aVar3.RZ().Sm())) != null) {
                aVar3.c(aVar);
            }
        }
    }

    /* renamed from: com.kwad.lottie.model.layer.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] boI;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            boI = iArr;
            try {
                iArr[Layer.MatteType.Add.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                boI[Layer.MatteType.Invert.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.kwad.lottie.model.layer.a
    final void b(Canvas canvas, Matrix matrix, int i) {
        com.kwad.lottie.c.beginSection("CompositionLayer#draw");
        canvas.save();
        this.boH.set(0.0f, 0.0f, this.bov.Si(), this.bov.Sj());
        matrix.mapRect(this.boH);
        for (int size = this.bjQ.size() - 1; size >= 0; size--) {
            if (!this.boH.isEmpty() ? canvas.clipRect(this.boH) : true) {
                this.bjQ.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.kwad.lottie.c.dg("CompositionLayer#draw");
    }

    @Override // com.kwad.lottie.model.layer.a, com.kwad.lottie.a.a.d
    public final void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.blm.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.bjQ.size() - 1; size >= 0; size--) {
            this.bjQ.get(size).a(this.blm, this.bou);
            if (rectF.isEmpty()) {
                rectF.set(this.blm);
            } else {
                rectF.set(Math.min(rectF.left, this.blm.left), Math.min(rectF.top, this.blm.top), Math.max(rectF.right, this.blm.right), Math.max(rectF.bottom, this.blm.bottom));
            }
        }
    }

    @Override // com.kwad.lottie.model.layer.a
    public final void setProgress(float f) {
        super.setProgress(f);
        if (this.boG != null) {
            f = ((long) (this.boG.getValue().floatValue() * 1000.0f)) / this.bjz.getComposition().Qd();
        }
        if (this.bov.Se() != 0.0f) {
            f /= this.bov.Se();
        }
        float fSf = f - this.bov.Sf();
        for (int size = this.bjQ.size() - 1; size >= 0; size--) {
            this.bjQ.get(size).setProgress(fSf);
        }
    }

    @Override // com.kwad.lottie.model.layer.a
    protected final void b(com.kwad.lottie.model.e eVar, int i, List<com.kwad.lottie.model.e> list, com.kwad.lottie.model.e eVar2) {
        for (int i2 = 0; i2 < this.bjQ.size(); i2++) {
            this.bjQ.get(i2).a(eVar, i, list, eVar2);
        }
    }

    @Override // com.kwad.lottie.model.layer.a, com.kwad.lottie.model.f
    public final <T> void a(T t, com.kwad.lottie.e.c<T> cVar) {
        super.a((b) t, (com.kwad.lottie.e.c<b>) cVar);
        if (t == i.bkT) {
            if (cVar == null) {
                this.boG = null;
                return;
            }
            p pVar = new p(cVar);
            this.boG = pVar;
            a(pVar);
        }
    }
}
