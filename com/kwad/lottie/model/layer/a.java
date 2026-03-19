package com.kwad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.kwad.lottie.a.b.a;
import com.kwad.lottie.a.b.o;
import com.kwad.lottie.model.content.Mask;
import com.kwad.lottie.model.content.h;
import com.kwad.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a implements com.kwad.lottie.a.a.d, a.InterfaceC0568a, com.kwad.lottie.model.f {
    final com.kwad.lottie.f bjz;
    private final RectF blm;
    final o bmd;
    private final List<com.kwad.lottie.a.b.a<?, ?>> boA;
    private boolean boB;
    private final Paint bom;
    private final Paint bon;
    private final Paint boo;
    private final Paint bop;
    private final RectF boq;
    private final RectF bor;
    private final RectF bos;
    private final String bot;
    final Matrix bou;
    final Layer bov;
    private com.kwad.lottie.a.b.g bow;
    private a box;
    private a boy;
    private List<a> boz;
    private final Path blk = new Path();
    private final Matrix bka = new Matrix();
    private final Paint bol = new Paint(1);

    abstract void b(Canvas canvas, Matrix matrix, int i);

    void b(com.kwad.lottie.model.e eVar, int i, List<com.kwad.lottie.model.e> list, com.kwad.lottie.model.e eVar2) {
    }

    @Override // com.kwad.lottie.a.a.b
    public final void b(List<com.kwad.lottie.a.a.b> list, List<com.kwad.lottie.a.a.b> list2) {
    }

    static a a(Layer layer, com.kwad.lottie.f fVar, com.kwad.lottie.d dVar) {
        switch (AnonymousClass2.boE[layer.Sk().ordinal()]) {
            case 1:
                return new e(fVar, layer);
            case 2:
                return new b(fVar, layer, dVar.di(layer.Sh()), dVar);
            case 3:
                return new f(fVar, layer);
            case 4:
                return new c(fVar, layer);
            case 5:
                return new d(fVar, layer);
            case 6:
                return new g(fVar, layer);
            default:
                com.kwad.lottie.c.df("Unknown layer type " + layer.Sk());
                return null;
        }
    }

    a(com.kwad.lottie.f fVar, Layer layer) {
        Paint paint = new Paint(1);
        this.bom = paint;
        Paint paint2 = new Paint(1);
        this.bon = paint2;
        Paint paint3 = new Paint(1);
        this.boo = paint3;
        Paint paint4 = new Paint();
        this.bop = paint4;
        this.blm = new RectF();
        this.boq = new RectF();
        this.bor = new RectF();
        this.bos = new RectF();
        this.bou = new Matrix();
        this.boA = new ArrayList();
        this.boB = true;
        this.bjz = fVar;
        this.bov = layer;
        this.bot = layer.getName() + "#draw";
        paint4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.Sl() == Layer.MatteType.Invert) {
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        o oVarRs = layer.RS().Rs();
        this.bmd = oVarRs;
        oVarRs.a((a.InterfaceC0568a) this);
        if (layer.QS() != null && !layer.QS().isEmpty()) {
            com.kwad.lottie.a.b.g gVar = new com.kwad.lottie.a.b.g(layer.QS());
            this.bow = gVar;
            Iterator<com.kwad.lottie.a.b.a<h, Path>> it = gVar.QT().iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
            for (com.kwad.lottie.a.b.a<Integer, Integer> aVar : this.bow.QU()) {
                a(aVar);
                aVar.b(this);
            }
        }
        Sb();
    }

    @Override // com.kwad.lottie.a.b.a.InterfaceC0568a
    public final void Qz() {
        invalidateSelf();
    }

    final Layer RZ() {
        return this.bov;
    }

    final void b(a aVar) {
        this.box = aVar;
    }

    private boolean Sa() {
        return this.box != null;
    }

    final void c(a aVar) {
        this.boy = aVar;
    }

    private void Sb() {
        if (!this.bov.Sg().isEmpty()) {
            final com.kwad.lottie.a.b.c cVar = new com.kwad.lottie.a.b.c(this.bov.Sg());
            cVar.QM();
            cVar.b(new a.InterfaceC0568a() { // from class: com.kwad.lottie.model.layer.a.1
                @Override // com.kwad.lottie.a.b.a.InterfaceC0568a
                public final void Qz() {
                    a.this.setVisible(cVar.getValue().floatValue() == 1.0f);
                }
            });
            setVisible(cVar.getValue().floatValue() == 1.0f);
            a(cVar);
            return;
        }
        setVisible(true);
    }

    private void invalidateSelf() {
        this.bjz.invalidateSelf();
    }

    private static void a(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    public final void a(com.kwad.lottie.a.b.a<?, ?> aVar) {
        this.boA.add(aVar);
    }

    @Override // com.kwad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.bou.set(matrix);
        this.bou.preConcat(this.bmd.getMatrix());
    }

    @Override // com.kwad.lottie.a.a.d
    public final void a(Canvas canvas, Matrix matrix, int i) {
        com.kwad.lottie.c.beginSection(this.bot);
        if (!this.boB) {
            com.kwad.lottie.c.dg(this.bot);
            return;
        }
        Sd();
        com.kwad.lottie.c.beginSection("Layer#parentMatrix");
        this.bka.reset();
        this.bka.set(matrix);
        for (int size = this.boz.size() - 1; size >= 0; size--) {
            this.bka.preConcat(this.boz.get(size).bmd.getMatrix());
        }
        com.kwad.lottie.c.dg("Layer#parentMatrix");
        int iIntValue = (int) ((((i / 255.0f) * this.bmd.QX().getValue().intValue()) / 100.0f) * 255.0f);
        if (!Sa() && !Sc()) {
            this.bka.preConcat(this.bmd.getMatrix());
            com.kwad.lottie.c.beginSection("Layer#drawLayer");
            b(canvas, this.bka, iIntValue);
            com.kwad.lottie.c.dg("Layer#drawLayer");
            E(com.kwad.lottie.c.dg(this.bot));
            return;
        }
        com.kwad.lottie.c.beginSection("Layer#computeBounds");
        this.blm.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.blm, this.bka);
        c(this.blm, this.bka);
        this.bka.preConcat(this.bmd.getMatrix());
        b(this.blm, this.bka);
        this.blm.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.kwad.lottie.c.dg("Layer#computeBounds");
        com.kwad.lottie.c.beginSection("Layer#saveLayer");
        a(canvas, this.blm, this.bol, true);
        com.kwad.lottie.c.dg("Layer#saveLayer");
        h(canvas);
        com.kwad.lottie.c.beginSection("Layer#drawLayer");
        b(canvas, this.bka, iIntValue);
        com.kwad.lottie.c.dg("Layer#drawLayer");
        if (Sc()) {
            a(canvas, this.bka);
        }
        if (Sa()) {
            com.kwad.lottie.c.beginSection("Layer#drawMatte");
            com.kwad.lottie.c.beginSection("Layer#saveLayer");
            a(canvas, this.blm, this.boo, false);
            com.kwad.lottie.c.dg("Layer#saveLayer");
            h(canvas);
            this.box.a(canvas, matrix, iIntValue);
            com.kwad.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.kwad.lottie.c.dg("Layer#restoreLayer");
            com.kwad.lottie.c.dg("Layer#drawMatte");
        }
        com.kwad.lottie.c.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.kwad.lottie.c.dg("Layer#restoreLayer");
        E(com.kwad.lottie.c.dg(this.bot));
    }

    private void E(float f) {
        this.bjz.getComposition().getPerformanceTracker().a(this.bov.getName(), f);
    }

    private void h(Canvas canvas) {
        com.kwad.lottie.c.beginSection("Layer#clearLayer");
        canvas.drawRect(this.blm.left - 1.0f, this.blm.top - 1.0f, this.blm.right + 1.0f, this.blm.bottom + 1.0f, this.bop);
        com.kwad.lottie.c.dg("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.boq.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (Sc()) {
            int size = this.bow.QS().size();
            for (int i = 0; i < size; i++) {
                Mask mask = this.bow.QS().get(i);
                this.blk.set(this.bow.QT().get(i).getValue());
                this.blk.transform(matrix);
                int i2 = AnonymousClass2.boF[mask.RG().ordinal()];
                if (i2 == 1 || i2 == 2) {
                    return;
                }
                this.blk.computeBounds(this.bos, false);
                if (i == 0) {
                    this.boq.set(this.bos);
                } else {
                    RectF rectF2 = this.boq;
                    rectF2.set(Math.min(rectF2.left, this.bos.left), Math.min(this.boq.top, this.bos.top), Math.max(this.boq.right, this.bos.right), Math.max(this.boq.bottom, this.bos.bottom));
                }
            }
            rectF.set(Math.max(rectF.left, this.boq.left), Math.max(rectF.top, this.boq.top), Math.min(rectF.right, this.boq.right), Math.min(rectF.bottom, this.boq.bottom));
        }
    }

    /* renamed from: com.kwad.lottie.model.layer.a$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] boE;
        static final /* synthetic */ int[] boF;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            boF = iArr;
            try {
                iArr[Mask.MaskMode.MaskModeSubtract.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                boF[Mask.MaskMode.MaskModeIntersect.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                boF[Mask.MaskMode.MaskModeAdd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            boE = iArr2;
            try {
                iArr2[Layer.LayerType.Shape.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                boE[Layer.LayerType.PreComp.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                boE[Layer.LayerType.Solid.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                boE[Layer.LayerType.Image.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                boE[Layer.LayerType.Null.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                boE[Layer.LayerType.Text.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                boE[Layer.LayerType.Unknown.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (Sa() && this.bov.Sl() != Layer.MatteType.Invert) {
            this.box.a(this.bor, matrix);
            rectF.set(Math.max(rectF.left, this.bor.left), Math.max(rectF.top, this.bor.top), Math.min(rectF.right, this.bor.right), Math.min(rectF.bottom, this.bor.bottom));
        }
    }

    private void a(Canvas canvas, Matrix matrix) {
        a(canvas, matrix, Mask.MaskMode.MaskModeAdd);
        a(canvas, matrix, Mask.MaskMode.MaskModeIntersect);
        a(canvas, matrix, Mask.MaskMode.MaskModeSubtract);
    }

    private void a(Canvas canvas, Matrix matrix, Mask.MaskMode maskMode) {
        Paint paint;
        boolean z = true;
        if (AnonymousClass2.boF[maskMode.ordinal()] == 1) {
            paint = this.bon;
        } else {
            paint = this.bom;
        }
        int size = this.bow.QS().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
                break;
            } else if (this.bow.QS().get(i).RG() == maskMode) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            com.kwad.lottie.c.beginSection("Layer#drawMask");
            com.kwad.lottie.c.beginSection("Layer#saveLayer");
            a(canvas, this.blm, paint, false);
            com.kwad.lottie.c.dg("Layer#saveLayer");
            h(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.bow.QS().get(i2).RG() == maskMode) {
                    this.blk.set(this.bow.QT().get(i2).getValue());
                    this.blk.transform(matrix);
                    com.kwad.lottie.a.b.a<Integer, Integer> aVar = this.bow.QU().get(i2);
                    int alpha = this.bol.getAlpha();
                    this.bol.setAlpha((int) (aVar.getValue().intValue() * 2.55f));
                    canvas.drawPath(this.blk, this.bol);
                    this.bol.setAlpha(alpha);
                }
            }
            com.kwad.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.kwad.lottie.c.dg("Layer#restoreLayer");
            com.kwad.lottie.c.dg("Layer#drawMask");
        }
    }

    private boolean Sc() {
        com.kwad.lottie.a.b.g gVar = this.bow;
        return (gVar == null || gVar.QT().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisible(boolean z) {
        if (z != this.boB) {
            this.boB = z;
            invalidateSelf();
        }
    }

    void setProgress(float f) {
        this.bmd.setProgress(f);
        if (this.bow != null) {
            for (int i = 0; i < this.bow.QT().size(); i++) {
                this.bow.QT().get(i).setProgress(f);
            }
        }
        if (this.bov.Se() != 0.0f) {
            f /= this.bov.Se();
        }
        a aVar = this.box;
        if (aVar != null) {
            this.box.setProgress(aVar.bov.Se() * f);
        }
        for (int i2 = 0; i2 < this.boA.size(); i2++) {
            this.boA.get(i2).setProgress(f);
        }
    }

    private void Sd() {
        if (this.boz != null) {
            return;
        }
        if (this.boy == null) {
            this.boz = Collections.emptyList();
            return;
        }
        this.boz = new ArrayList();
        for (a aVar = this.boy; aVar != null; aVar = aVar.boy) {
            this.boz.add(aVar);
        }
    }

    @Override // com.kwad.lottie.a.a.b
    public final String getName() {
        return this.bov.getName();
    }

    @Override // com.kwad.lottie.model.f
    public final void a(com.kwad.lottie.model.e eVar, int i, List<com.kwad.lottie.model.e> list, com.kwad.lottie.model.e eVar2) {
        if (eVar.q(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.dp(getName());
                if (eVar.s(getName(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.t(getName(), i)) {
                b(eVar, i + eVar.r(getName(), i), list, eVar2);
            }
        }
    }

    @Override // com.kwad.lottie.model.f
    public <T> void a(T t, com.kwad.lottie.e.c<T> cVar) {
        this.bmd.b(t, cVar);
    }
}
