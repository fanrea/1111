package com.tachikoma.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.tachikoma.lottie.a.b.a;
import com.tachikoma.lottie.a.b.o;
import com.tachikoma.lottie.model.content.Mask;
import com.tachikoma.lottie.model.content.h;
import com.tachikoma.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public abstract class a implements com.tachikoma.lottie.a.a.e, a.InterfaceC0799a, com.tachikoma.lottie.model.e {
    final com.tachikoma.lottie.g Gt;
    final o Jw;
    private final String Mj;
    final Layer Ml;
    private com.tachikoma.lottie.a.b.g Mm;
    private a Mn;
    private a Mo;
    private List<a> Mp;
    private final Path Iz = new Path();
    private final Matrix Hh = new Matrix();
    private final Paint Mb = new com.tachikoma.lottie.a.a(1);
    private final Paint Mc = new com.tachikoma.lottie.a.a(1, PorterDuff.Mode.DST_IN);
    private final Paint Md = new com.tachikoma.lottie.a.a(1, PorterDuff.Mode.DST_OUT);
    private final Paint Me = new com.tachikoma.lottie.a.a(1);
    private final Paint Mf = new com.tachikoma.lottie.a.a(PorterDuff.Mode.CLEAR);
    private final RectF IB = new RectF();
    private final RectF Mg = new RectF();
    private final RectF Mh = new RectF();
    private final RectF Mi = new RectF();
    final Matrix Mk = new Matrix();
    private final List<com.tachikoma.lottie.a.b.a<?, ?>> Mq = new ArrayList();
    private boolean Mr = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    void b(com.tachikoma.lottie.model.d dVar, int i, List<com.tachikoma.lottie.model.d> list, com.tachikoma.lottie.model.d dVar2) {
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final void b(List<com.tachikoma.lottie.a.a.c> list, List<com.tachikoma.lottie.a.a.c> list2) {
    }

    static a a(Layer layer, com.tachikoma.lottie.g gVar, com.tachikoma.lottie.e eVar) {
        switch (layer.lH()) {
            case SHAPE:
                return new e(gVar, layer);
            case PRE_COMP:
                return new b(gVar, layer, eVar.U(layer.lE()), eVar);
            case SOLID:
                return new f(gVar, layer);
            case IMAGE:
                return new c(gVar, layer);
            case NULL:
                return new d(gVar, layer);
            case TEXT:
                return new g(gVar, layer);
            default:
                com.tachikoma.lottie.c.R("Unknown layer type " + layer.lH());
                return null;
        }
    }

    a(com.tachikoma.lottie.g gVar, Layer layer) {
        this.Gt = gVar;
        this.Ml = layer;
        this.Mj = layer.getName() + "#draw";
        if (layer.lI() == Layer.MatteType.INVERT) {
            this.Me.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.Me.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.Jw = layer.lp().kO();
        this.Jw.a((a.InterfaceC0799a) this);
        if (layer.ki() != null && !layer.ki().isEmpty()) {
            this.Mm = new com.tachikoma.lottie.a.b.g(layer.ki());
            Iterator<com.tachikoma.lottie.a.b.a<h, Path>> it = this.Mm.kj().iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
            for (com.tachikoma.lottie.a.b.a<Integer, Integer> aVar : this.Mm.kk()) {
                a(aVar);
                aVar.b(this);
            }
        }
        ly();
    }

    @Override // com.tachikoma.lottie.a.b.a.InterfaceC0799a
    public final void jO() {
        invalidateSelf();
    }

    final Layer lw() {
        return this.Ml;
    }

    final void b(a aVar) {
        this.Mn = aVar;
    }

    private boolean lx() {
        return this.Mn != null;
    }

    final void c(a aVar) {
        this.Mo = aVar;
    }

    private void ly() {
        if (!this.Ml.lD().isEmpty()) {
            final com.tachikoma.lottie.a.b.c cVar = new com.tachikoma.lottie.a.b.c(this.Ml.lD());
            cVar.kb();
            cVar.b(new a.InterfaceC0799a() { // from class: com.tachikoma.lottie.model.layer.a.1
                @Override // com.tachikoma.lottie.a.b.a.InterfaceC0799a
                public final void jO() {
                    a.this.setVisible(cVar.kh() == 1.0f);
                }
            });
            setVisible(cVar.getValue().floatValue() == 1.0f);
            a(cVar);
            return;
        }
        setVisible(true);
    }

    private void invalidateSelf() {
        this.Gt.invalidateSelf();
    }

    private static void a(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    public final void a(com.tachikoma.lottie.a.b.a<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.Mq.add(aVar);
    }

    public final void b(com.tachikoma.lottie.a.b.a<?, ?> aVar) {
        this.Mq.remove(aVar);
    }

    @Override // com.tachikoma.lottie.a.a.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.IB.set(0.0f, 0.0f, 0.0f, 0.0f);
        lA();
        this.Mk.set(matrix);
        if (z) {
            List<a> list = this.Mp;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.Mk.preConcat(this.Mp.get(size).Jw.getMatrix());
                }
            } else {
                a aVar = this.Mo;
                if (aVar != null) {
                    this.Mk.preConcat(aVar.Jw.getMatrix());
                }
            }
        }
        this.Mk.preConcat(this.Jw.getMatrix());
    }

    @Override // com.tachikoma.lottie.a.a.e
    public final void a(Canvas canvas, Matrix matrix, int i) {
        com.tachikoma.lottie.c.beginSection(this.Mj);
        if (!this.Mr || this.Ml.isHidden()) {
            com.tachikoma.lottie.c.S(this.Mj);
            return;
        }
        lA();
        com.tachikoma.lottie.c.beginSection("Layer#parentMatrix");
        this.Hh.reset();
        this.Hh.set(matrix);
        for (int size = this.Mp.size() - 1; size >= 0; size--) {
            this.Hh.preConcat(this.Mp.get(size).Jw.getMatrix());
        }
        com.tachikoma.lottie.c.S("Layer#parentMatrix");
        int iIntValue = (int) ((((i / 255.0f) * (this.Jw.ko() == null ? 100 : this.Jw.ko().getValue().intValue())) / 100.0f) * 255.0f);
        if (!lx() && !lz()) {
            this.Hh.preConcat(this.Jw.getMatrix());
            com.tachikoma.lottie.c.beginSection("Layer#drawLayer");
            b(canvas, this.Hh, iIntValue);
            com.tachikoma.lottie.c.S("Layer#drawLayer");
            i(com.tachikoma.lottie.c.S(this.Mj));
            return;
        }
        com.tachikoma.lottie.c.beginSection("Layer#computeBounds");
        a(this.IB, this.Hh, false);
        b(this.IB, matrix);
        this.Hh.preConcat(this.Jw.getMatrix());
        a(this.IB, this.Hh);
        com.tachikoma.lottie.c.S("Layer#computeBounds");
        if (!this.IB.isEmpty()) {
            com.tachikoma.lottie.c.beginSection("Layer#saveLayer");
            a(canvas, this.IB, this.Mb, true);
            com.tachikoma.lottie.c.S("Layer#saveLayer");
            g(canvas);
            com.tachikoma.lottie.c.beginSection("Layer#drawLayer");
            b(canvas, this.Hh, iIntValue);
            com.tachikoma.lottie.c.S("Layer#drawLayer");
            if (lz()) {
                a(canvas, this.Hh);
            }
            if (lx()) {
                com.tachikoma.lottie.c.beginSection("Layer#drawMatte");
                com.tachikoma.lottie.c.beginSection("Layer#saveLayer");
                a(canvas, this.IB, this.Me, false);
                com.tachikoma.lottie.c.S("Layer#saveLayer");
                g(canvas);
                this.Mn.a(canvas, matrix, iIntValue);
                com.tachikoma.lottie.c.beginSection("Layer#restoreLayer");
                canvas.restore();
                com.tachikoma.lottie.c.S("Layer#restoreLayer");
                com.tachikoma.lottie.c.S("Layer#drawMatte");
            }
            com.tachikoma.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tachikoma.lottie.c.S("Layer#restoreLayer");
        }
        i(com.tachikoma.lottie.c.S(this.Mj));
    }

    private void i(float f) {
        this.Gt.getComposition().getPerformanceTracker().a(this.Ml.getName(), f);
    }

    private void g(Canvas canvas) {
        com.tachikoma.lottie.c.beginSection("Layer#clearLayer");
        canvas.drawRect(this.IB.left - 1.0f, this.IB.top - 1.0f, this.IB.right + 1.0f, this.IB.bottom + 1.0f, this.Mf);
        com.tachikoma.lottie.c.S("Layer#clearLayer");
    }

    private void a(RectF rectF, Matrix matrix) {
        this.Mg.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (lz()) {
            int size = this.Mm.ki().size();
            for (int i = 0; i < size; i++) {
                Mask mask = this.Mm.ki().get(i);
                this.Iz.set(this.Mm.kj().get(i).getValue());
                this.Iz.transform(matrix);
                int i2 = AnonymousClass2.Mv[mask.lc().ordinal()];
                if (i2 == 1) {
                    return;
                }
                if ((i2 == 2 || i2 == 3) && mask.le()) {
                    return;
                }
                this.Iz.computeBounds(this.Mi, false);
                if (i == 0) {
                    this.Mg.set(this.Mi);
                } else {
                    RectF rectF2 = this.Mg;
                    rectF2.set(Math.min(rectF2.left, this.Mi.left), Math.min(this.Mg.top, this.Mi.top), Math.max(this.Mg.right, this.Mi.right), Math.max(this.Mg.bottom, this.Mi.bottom));
                }
            }
            if (rectF.intersect(this.Mg)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* renamed from: com.tachikoma.lottie.model.layer.a$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] Mv = new int[Mask.MaskMode.values().length];

        static {
            try {
                Mv[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Mv[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Mv[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            Mu = new int[Layer.LayerType.values().length];
            try {
                Mu[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Mu[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Mu[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                Mu[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                Mu[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                Mu[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                Mu[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private void b(RectF rectF, Matrix matrix) {
        if (lx() && this.Ml.lI() != Layer.MatteType.INVERT) {
            this.Mh.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.Mn.a(this.Mh, matrix, true);
            if (rectF.intersect(this.Mh)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void a(Canvas canvas, Matrix matrix) {
        com.tachikoma.lottie.c.beginSection("Layer#saveLayer");
        a(canvas, this.IB, this.Mc, false);
        com.tachikoma.lottie.c.S("Layer#saveLayer");
        for (int i = 0; i < this.Mm.ki().size(); i++) {
            Mask mask = this.Mm.ki().get(i);
            com.tachikoma.lottie.a.b.a<h, Path> aVar = this.Mm.kj().get(i);
            com.tachikoma.lottie.a.b.a<Integer, Integer> aVar2 = this.Mm.kk().get(i);
            int i2 = AnonymousClass2.Mv[mask.lc().ordinal()];
            if (i2 == 1) {
                if (i == 0) {
                    Paint paint = new Paint();
                    paint.setColor(-16777216);
                    canvas.drawRect(this.IB, paint);
                }
                if (mask.le()) {
                    c(canvas, matrix, aVar, aVar2);
                } else {
                    a(canvas, matrix, aVar);
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    if (mask.le()) {
                        b(canvas, matrix, aVar, aVar2);
                    } else {
                        a(canvas, matrix, aVar, aVar2);
                    }
                }
            } else if (mask.le()) {
                e(canvas, matrix, aVar, aVar2);
            } else {
                d(canvas, matrix, aVar, aVar2);
            }
        }
        com.tachikoma.lottie.c.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.tachikoma.lottie.c.S("Layer#restoreLayer");
    }

    private void a(Canvas canvas, Matrix matrix, com.tachikoma.lottie.a.b.a<h, Path> aVar, com.tachikoma.lottie.a.b.a<Integer, Integer> aVar2) {
        this.Iz.set(aVar.getValue());
        this.Iz.transform(matrix);
        this.Mb.setAlpha((int) (aVar2.getValue().intValue() * 2.55f));
        canvas.drawPath(this.Iz, this.Mb);
    }

    private void b(Canvas canvas, Matrix matrix, com.tachikoma.lottie.a.b.a<h, Path> aVar, com.tachikoma.lottie.a.b.a<Integer, Integer> aVar2) {
        a(canvas, this.IB, this.Mb, true);
        canvas.drawRect(this.IB, this.Mb);
        this.Iz.set(aVar.getValue());
        this.Iz.transform(matrix);
        this.Mb.setAlpha((int) (aVar2.getValue().intValue() * 2.55f));
        canvas.drawPath(this.Iz, this.Md);
        canvas.restore();
    }

    private void a(Canvas canvas, Matrix matrix, com.tachikoma.lottie.a.b.a<h, Path> aVar) {
        this.Iz.set(aVar.getValue());
        this.Iz.transform(matrix);
        canvas.drawPath(this.Iz, this.Md);
    }

    private void c(Canvas canvas, Matrix matrix, com.tachikoma.lottie.a.b.a<h, Path> aVar, com.tachikoma.lottie.a.b.a<Integer, Integer> aVar2) {
        a(canvas, this.IB, this.Md, true);
        canvas.drawRect(this.IB, this.Mb);
        this.Md.setAlpha((int) (aVar2.getValue().intValue() * 2.55f));
        this.Iz.set(aVar.getValue());
        this.Iz.transform(matrix);
        canvas.drawPath(this.Iz, this.Md);
        canvas.restore();
    }

    private void d(Canvas canvas, Matrix matrix, com.tachikoma.lottie.a.b.a<h, Path> aVar, com.tachikoma.lottie.a.b.a<Integer, Integer> aVar2) {
        a(canvas, this.IB, this.Mc, true);
        this.Iz.set(aVar.getValue());
        this.Iz.transform(matrix);
        this.Mb.setAlpha((int) (aVar2.getValue().intValue() * 2.55f));
        canvas.drawPath(this.Iz, this.Mb);
        canvas.restore();
    }

    private void e(Canvas canvas, Matrix matrix, com.tachikoma.lottie.a.b.a<h, Path> aVar, com.tachikoma.lottie.a.b.a<Integer, Integer> aVar2) {
        a(canvas, this.IB, this.Mc, true);
        canvas.drawRect(this.IB, this.Mb);
        this.Md.setAlpha((int) (aVar2.getValue().intValue() * 2.55f));
        this.Iz.set(aVar.getValue());
        this.Iz.transform(matrix);
        canvas.drawPath(this.Iz, this.Md);
        canvas.restore();
    }

    private boolean lz() {
        com.tachikoma.lottie.a.b.g gVar = this.Mm;
        return (gVar == null || gVar.kj().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisible(boolean z) {
        if (z != this.Mr) {
            this.Mr = z;
            invalidateSelf();
        }
    }

    void setProgress(float f) {
        this.Jw.setProgress(f);
        if (this.Mm != null) {
            for (int i = 0; i < this.Mm.kj().size(); i++) {
                this.Mm.kj().get(i).setProgress(f);
            }
        }
        if (this.Ml.lB() != 0.0f) {
            f /= this.Ml.lB();
        }
        a aVar = this.Mn;
        if (aVar != null) {
            this.Mn.setProgress(aVar.Ml.lB() * f);
        }
        for (int i2 = 0; i2 < this.Mq.size(); i2++) {
            this.Mq.get(i2).setProgress(f);
        }
    }

    private void lA() {
        if (this.Mp != null) {
            return;
        }
        if (this.Mo == null) {
            this.Mp = Collections.emptyList();
            return;
        }
        this.Mp = new ArrayList();
        for (a aVar = this.Mo; aVar != null; aVar = aVar.Mo) {
            this.Mp.add(aVar);
        }
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final String getName() {
        return this.Ml.getName();
    }

    @Override // com.tachikoma.lottie.model.e
    public final void a(com.tachikoma.lottie.model.d dVar, int i, List<com.tachikoma.lottie.model.d> list, com.tachikoma.lottie.model.d dVar2) {
        if (dVar.j(getName(), i)) {
            if (!"__container".equals(getName())) {
                dVar2 = dVar2.ad(getName());
                if (dVar.l(getName(), i)) {
                    list.add(dVar2.a(this));
                }
            }
            if (dVar.m(getName(), i)) {
                b(dVar, i + dVar.k(getName(), i), list, dVar2);
            }
        }
    }

    @Override // com.tachikoma.lottie.model.e
    public <T> void a(T t, com.tachikoma.lottie.e.c<T> cVar) {
        this.Jw.b(t, cVar);
    }
}
