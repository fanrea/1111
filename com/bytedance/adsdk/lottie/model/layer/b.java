package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.adsdk.lottie.d.hc.cb;
import com.bytedance.adsdk.lottie.d.hc.d;
import com.bytedance.adsdk.lottie.model.hc.gb;
import com.bytedance.adsdk.lottie.model.layer.gb;
import com.bytedance.adsdk.lottie.tt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class b implements com.bytedance.adsdk.lottie.d.d.u, d.InterfaceC0167d {
    BlurMaskFilter an;
    final gb b;
    final cb c;
    private final Paint cb;
    final Matrix d;
    private final String de;
    private final Paint e;
    private float fs;
    private boolean gb;
    final com.bytedance.adsdk.lottie.gb hc;
    private b he;
    private boolean j;
    private final RectF jh;
    private com.bytedance.adsdk.lottie.d.hc.c np;
    private final RectF rf;
    private boolean s;
    private final RectF sy;
    float u;
    private Paint us;
    private com.bytedance.adsdk.lottie.d.hc.gb v;
    private List<b> vv;
    private final RectF w;
    private b yi;
    private final RectF yo;
    private final Matrix z;
    private final List<com.bytedance.adsdk.lottie.d.hc.d<?, ?>> zw;
    private final Handler h = new Handler(Looper.getMainLooper());
    private final Path tt = new Path();
    private final Matrix tc = new Matrix();
    private final Matrix mk = new Matrix();
    private final Paint mq = new com.bytedance.adsdk.lottie.d.d(1);
    private final Paint uo = new com.bytedance.adsdk.lottie.d.d(1, PorterDuff.Mode.DST_IN);
    private final Paint k = new com.bytedance.adsdk.lottie.d.d(1, PorterDuff.Mode.DST_OUT);

    @Override // com.bytedance.adsdk.lottie.d.d.b
    public void d(List<com.bytedance.adsdk.lottie.d.d.b> list, List<com.bytedance.adsdk.lottie.d.d.b> list2) {
    }

    public boolean hc() {
        return this.gb;
    }

    public void b() {
        this.gb = true;
    }

    public void d(Runnable runnable) {
        this.h.post(runnable);
    }

    static b d(c cVar, gb gbVar, com.bytedance.adsdk.lottie.gb gbVar2, com.bytedance.adsdk.lottie.an anVar, Context context) {
        switch (AnonymousClass2.d[gbVar.mk().ordinal()]) {
            case 1:
                return new tc(gbVar2, gbVar, cVar, anVar);
            case 2:
                return new c(gbVar2, gbVar, anVar.hc(gbVar.h()), anVar, context);
            case 3:
                return new mk(gbVar2, gbVar);
            case 4:
                if (d(gbVar2, gbVar, "text:")) {
                    return new an(gbVar2, gbVar, context);
                }
                if (d(gbVar2, gbVar, "videoview:")) {
                    tt.d dVarD = d(gbVar2, gbVar);
                    if (dVarD != null) {
                        if (dVarD.d != null && dVarD.d.d > 0.0f) {
                            return new u(gbVar2, gbVar, context, dVarD.d);
                        }
                        if (dVarD.hc) {
                            return new hc(gbVar2, gbVar, context);
                        }
                        return new k(gbVar2, gbVar, context);
                    }
                    return new k(gbVar2, gbVar, context);
                }
                if (d(gbVar2, gbVar, "animview:")) {
                    return new d(gbVar2, gbVar, context);
                }
                if (d(gbVar2, gbVar, "view:")) {
                    return new uo(gbVar2, gbVar, context);
                }
                return new h(gbVar2, gbVar);
            case 5:
                return new tt(gbVar2, gbVar);
            case 6:
                return new mq(gbVar2, gbVar);
            default:
                com.bytedance.adsdk.lottie.u.u.hc("Unknown layer type " + gbVar.mk());
                return null;
        }
    }

    private static tt.d d(com.bytedance.adsdk.lottie.gb gbVar, gb gbVar2) {
        com.bytedance.adsdk.lottie.tt ttVarAn;
        if (gbVar == null || gbVar2 == null || (ttVarAn = gbVar.an(gbVar2.h())) == null) {
            return null;
        }
        return ttVarAn.tc();
    }

    private static boolean d(com.bytedance.adsdk.lottie.gb gbVar, gb gbVar2, String str) {
        com.bytedance.adsdk.lottie.tt ttVarAn;
        if (gbVar == null || gbVar2 == null || str == null || (ttVarAn = gbVar.an(gbVar2.h())) == null) {
            return false;
        }
        return str.equals(ttVarAn.uo());
    }

    b(com.bytedance.adsdk.lottie.gb gbVar, gb gbVar2) {
        com.bytedance.adsdk.lottie.d.d dVar = new com.bytedance.adsdk.lottie.d.d(1);
        this.e = dVar;
        this.cb = new com.bytedance.adsdk.lottie.d.d(PorterDuff.Mode.CLEAR);
        this.w = new RectF();
        this.yo = new RectF();
        this.rf = new RectF();
        this.jh = new RectF();
        this.sy = new RectF();
        this.d = new Matrix();
        this.zw = new ArrayList();
        this.j = true;
        this.u = 0.0f;
        this.z = new Matrix();
        this.fs = 1.0f;
        this.hc = gbVar;
        this.b = gbVar2;
        this.de = gbVar2.an() + "#draw";
        if (gbVar2.mq() == gb.hc.INVERT) {
            dVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            dVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        cb cbVarTc = gbVar2.e().tc();
        this.c = cbVarTc;
        cbVarTc.d((d.InterfaceC0167d) this);
        if (gbVar2.tc() != null && !gbVar2.tc().isEmpty()) {
            com.bytedance.adsdk.lottie.d.hc.gb gbVar3 = new com.bytedance.adsdk.lottie.d.hc.gb(gbVar2.tc());
            this.v = gbVar3;
            Iterator<com.bytedance.adsdk.lottie.d.hc.d<com.bytedance.adsdk.lottie.model.hc.k, Path>> it = gbVar3.hc().iterator();
            while (it.hasNext()) {
                it.next().d(this);
            }
            for (com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVar2 : this.v.b()) {
                d(dVar2);
                dVar2.d(this);
            }
        }
        k();
    }

    void d(boolean z) {
        if (z && this.us == null) {
            this.us = new com.bytedance.adsdk.lottie.d.d();
        }
        this.s = z;
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d.InterfaceC0167d
    public void d() {
        e();
    }

    gb c() {
        return this.b;
    }

    void d(b bVar) {
        this.yi = bVar;
    }

    boolean u() {
        return this.yi != null;
    }

    void hc(b bVar) {
        this.he = bVar;
    }

    private void k() {
        if (!this.b.c().isEmpty()) {
            com.bytedance.adsdk.lottie.d.hc.c cVar = new com.bytedance.adsdk.lottie.d.hc.c(this.b.c());
            this.np = cVar;
            cVar.d();
            this.np.d(new d.InterfaceC0167d() { // from class: com.bytedance.adsdk.lottie.model.layer.b.1
                @Override // com.bytedance.adsdk.lottie.d.hc.d.InterfaceC0167d
                public void d() {
                    b bVar = b.this;
                    bVar.hc(bVar.np.tt() == 1.0f);
                }
            });
            hc(this.np.h().floatValue() == 1.0f);
            d(this.np);
            return;
        }
        hc(true);
    }

    private void e() {
        this.hc.invalidateSelf();
    }

    public void d(com.bytedance.adsdk.lottie.d.hc.d<?, ?> dVar) {
        if (dVar == null) {
            return;
        }
        this.zw.add(dVar);
    }

    public Matrix an() {
        return this.z;
    }

    public String h() {
        gb gbVar = this.b;
        if (gbVar != null) {
            return gbVar.h();
        }
        return null;
    }

    @Override // com.bytedance.adsdk.lottie.d.d.u
    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.w.set(0.0f, 0.0f, 0.0f, 0.0f);
        w();
        this.d.set(matrix);
        if (z) {
            List<b> list = this.vv;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.d.preConcat(this.vv.get(size).c.c());
                }
            } else {
                b bVar = this.he;
                if (bVar != null) {
                    this.d.preConcat(bVar.c.c());
                }
            }
        }
        this.d.preConcat(this.c.c());
    }

    @Override // com.bytedance.adsdk.lottie.d.d.u
    public void d(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        Integer numH;
        com.bytedance.adsdk.lottie.u.d(this.de);
        if (!this.j || this.b.de()) {
            com.bytedance.adsdk.lottie.u.hc(this.de);
            return;
        }
        w();
        com.bytedance.adsdk.lottie.u.d("Layer#parentMatrix");
        this.z.set(matrix);
        this.tc.reset();
        this.tc.set(matrix);
        for (int size = this.vv.size() - 1; size >= 0; size--) {
            this.tc.preConcat(this.vv.get(size).c.c());
        }
        com.bytedance.adsdk.lottie.u.hc("Layer#parentMatrix");
        int iIntValue = 100;
        com.bytedance.adsdk.lottie.d.hc.d<?, Integer> dVarD = this.c.d();
        if (dVarD != null && (numH = dVarD.h()) != null) {
            iIntValue = numH.intValue();
        }
        int i2 = (int) ((((i / 255.0f) * iIntValue) / 100.0f) * 255.0f);
        if (!u() && !tt()) {
            this.tc.preConcat(this.c.c());
            com.bytedance.adsdk.lottie.u.d("Layer#drawLayer");
            hc(canvas, this.tc, i2);
            com.bytedance.adsdk.lottie.u.hc("Layer#drawLayer");
            b(com.bytedance.adsdk.lottie.u.hc(this.de));
            return;
        }
        com.bytedance.adsdk.lottie.u.d("Layer#computeBounds");
        d(this.w, this.tc, false);
        hc(this.w, matrix);
        this.tc.preConcat(this.c.c());
        d(this.w, this.tc);
        this.yo.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.mk);
        if (!this.mk.isIdentity()) {
            Matrix matrix2 = this.mk;
            matrix2.invert(matrix2);
            this.mk.mapRect(this.yo);
        }
        if (!this.w.intersect(this.yo)) {
            this.w.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        com.bytedance.adsdk.lottie.u.hc("Layer#computeBounds");
        if (this.w.width() >= 1.0f && this.w.height() >= 1.0f) {
            com.bytedance.adsdk.lottie.u.d("Layer#saveLayer");
            this.mq.setAlpha(255);
            com.bytedance.adsdk.lottie.u.tt.d(canvas, this.w, this.mq);
            com.bytedance.adsdk.lottie.u.hc("Layer#saveLayer");
            d(canvas);
            com.bytedance.adsdk.lottie.u.d("Layer#drawLayer");
            hc(canvas, this.tc, i2);
            com.bytedance.adsdk.lottie.u.hc("Layer#drawLayer");
            if (tt()) {
                d(canvas, this.tc);
            }
            if (u()) {
                com.bytedance.adsdk.lottie.u.d("Layer#drawMatte");
                com.bytedance.adsdk.lottie.u.d("Layer#saveLayer");
                com.bytedance.adsdk.lottie.u.tt.d(canvas, this.w, this.e, 19);
                com.bytedance.adsdk.lottie.u.hc("Layer#saveLayer");
                d(canvas);
                this.yi.d(canvas, matrix, i2);
                com.bytedance.adsdk.lottie.u.d("Layer#restoreLayer");
                canvas.restore();
                com.bytedance.adsdk.lottie.u.hc("Layer#restoreLayer");
                com.bytedance.adsdk.lottie.u.hc("Layer#drawMatte");
            }
            com.bytedance.adsdk.lottie.u.d("Layer#restoreLayer");
            canvas.restore();
            com.bytedance.adsdk.lottie.u.hc("Layer#restoreLayer");
        }
        if (this.s && (paint = this.us) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.us.setColor(-251901);
            this.us.setStrokeWidth(4.0f);
            canvas.drawRect(this.w, this.us);
            this.us.setStyle(Paint.Style.FILL);
            this.us.setColor(1357638635);
            canvas.drawRect(this.w, this.us);
        }
        b(com.bytedance.adsdk.lottie.u.hc(this.de));
    }

    private void b(float f) {
        this.hc.vv().b().d(this.b.an(), f);
    }

    private void d(Canvas canvas) {
        com.bytedance.adsdk.lottie.u.d("Layer#clearLayer");
        canvas.drawRect(this.w.left - 1.0f, this.w.top - 1.0f, this.w.right + 1.0f, this.w.bottom + 1.0f, this.cb);
        com.bytedance.adsdk.lottie.u.hc("Layer#clearLayer");
    }

    private void d(RectF rectF, Matrix matrix) {
        this.rf.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (tt()) {
            int size = this.v.d().size();
            for (int i = 0; i < size; i++) {
                com.bytedance.adsdk.lottie.model.hc.gb gbVar = this.v.d().get(i);
                Path pathH = this.v.hc().get(i).h();
                if (pathH != null) {
                    this.tt.set(pathH);
                    this.tt.transform(matrix);
                    int i2 = AnonymousClass2.hc[gbVar.d().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        return;
                    }
                    if ((i2 == 3 || i2 == 4) && gbVar.c()) {
                        return;
                    }
                    this.tt.computeBounds(this.sy, false);
                    if (i == 0) {
                        this.rf.set(this.sy);
                    } else {
                        RectF rectF2 = this.rf;
                        rectF2.set(Math.min(rectF2.left, this.sy.left), Math.min(this.rf.top, this.sy.top), Math.max(this.rf.right, this.sy.right), Math.max(this.rf.bottom, this.sy.bottom));
                    }
                }
            }
            if (rectF.intersect(this.rf)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* renamed from: com.bytedance.adsdk.lottie.model.layer.b$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] d;
        static final /* synthetic */ int[] hc;

        static {
            int[] iArr = new int[gb.d.values().length];
            hc = iArr;
            try {
                iArr[gb.d.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                hc[gb.d.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                hc[gb.d.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                hc[gb.d.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[gb.d.values().length];
            d = iArr2;
            try {
                iArr2[gb.d.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                d[gb.d.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                d[gb.d.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                d[gb.d.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                d[gb.d.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                d[gb.d.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                d[gb.d.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private void hc(RectF rectF, Matrix matrix) {
        if (u() && this.b.mq() != gb.hc.INVERT) {
            this.jh.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.yi.d(this.jh, matrix, true);
            if (rectF.intersect(this.jh)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public float gb() {
        return this.fs;
    }

    protected void d(int i) {
        this.fs = ((this.c.d() != null ? this.c.d().h().intValue() : 100) / 100.0f) * (i / 255.0f);
    }

    public void hc(Canvas canvas, Matrix matrix, int i) {
        d(i);
    }

    private void d(Canvas canvas, Matrix matrix) {
        com.bytedance.adsdk.lottie.u.d("Layer#saveLayer");
        com.bytedance.adsdk.lottie.u.tt.d(canvas, this.w, this.uo, 19);
        if (Build.VERSION.SDK_INT < 28) {
            d(canvas);
        }
        com.bytedance.adsdk.lottie.u.hc("Layer#saveLayer");
        for (int i = 0; i < this.v.d().size(); i++) {
            com.bytedance.adsdk.lottie.model.hc.gb gbVar = this.v.d().get(i);
            com.bytedance.adsdk.lottie.d.hc.d<com.bytedance.adsdk.lottie.model.hc.k, Path> dVar = this.v.hc().get(i);
            com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVar2 = this.v.b().get(i);
            int i2 = AnonymousClass2.hc[gbVar.d().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.mq.setColor(-16777216);
                        this.mq.setAlpha(255);
                        canvas.drawRect(this.w, this.mq);
                    }
                    if (gbVar.c()) {
                        b(canvas, matrix, dVar, dVar2);
                    } else {
                        d(canvas, matrix, dVar);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (gbVar.c()) {
                            hc(canvas, matrix, dVar, dVar2);
                        } else {
                            d(canvas, matrix, dVar, dVar2);
                        }
                    }
                } else if (gbVar.c()) {
                    u(canvas, matrix, dVar, dVar2);
                } else {
                    c(canvas, matrix, dVar, dVar2);
                }
            } else if (cb()) {
                this.mq.setAlpha(255);
                canvas.drawRect(this.w, this.mq);
            }
        }
        com.bytedance.adsdk.lottie.u.d("Layer#restoreLayer");
        canvas.restore();
        com.bytedance.adsdk.lottie.u.hc("Layer#restoreLayer");
    }

    private boolean cb() {
        if (this.v.hc().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.v.d().size(); i++) {
            if (this.v.d().get(i).d() != gb.d.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void d(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.d.hc.d<com.bytedance.adsdk.lottie.model.hc.k, Path> dVar, com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVar2) {
        this.tt.set(dVar.h());
        this.tt.transform(matrix);
        this.mq.setAlpha((int) (dVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.tt, this.mq);
    }

    private void hc(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.d.hc.d<com.bytedance.adsdk.lottie.model.hc.k, Path> dVar, com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVar2) {
        com.bytedance.adsdk.lottie.u.tt.d(canvas, this.w, this.mq);
        canvas.drawRect(this.w, this.mq);
        this.tt.set(dVar.h());
        this.tt.transform(matrix);
        this.mq.setAlpha((int) (dVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.tt, this.k);
        canvas.restore();
    }

    private void d(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.d.hc.d<com.bytedance.adsdk.lottie.model.hc.k, Path> dVar) {
        this.tt.set(dVar.h());
        this.tt.transform(matrix);
        canvas.drawPath(this.tt, this.k);
    }

    private void b(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.d.hc.d<com.bytedance.adsdk.lottie.model.hc.k, Path> dVar, com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVar2) {
        com.bytedance.adsdk.lottie.u.tt.d(canvas, this.w, this.k);
        canvas.drawRect(this.w, this.mq);
        this.k.setAlpha((int) (dVar2.h().intValue() * 2.55f));
        this.tt.set(dVar.h());
        this.tt.transform(matrix);
        canvas.drawPath(this.tt, this.k);
        canvas.restore();
    }

    private void c(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.d.hc.d<com.bytedance.adsdk.lottie.model.hc.k, Path> dVar, com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVar2) {
        com.bytedance.adsdk.lottie.u.tt.d(canvas, this.w, this.uo);
        this.tt.set(dVar.h());
        this.tt.transform(matrix);
        this.mq.setAlpha((int) (dVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.tt, this.mq);
        canvas.restore();
    }

    private void u(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.d.hc.d<com.bytedance.adsdk.lottie.model.hc.k, Path> dVar, com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVar2) {
        com.bytedance.adsdk.lottie.u.tt.d(canvas, this.w, this.uo);
        canvas.drawRect(this.w, this.mq);
        this.k.setAlpha((int) (dVar2.h().intValue() * 2.55f));
        this.tt.set(dVar.h());
        this.tt.transform(matrix);
        canvas.drawPath(this.tt, this.k);
        canvas.restore();
    }

    boolean tt() {
        com.bytedance.adsdk.lottie.d.hc.gb gbVar = this.v;
        return (gbVar == null || gbVar.hc().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(boolean z) {
        if (z != this.j) {
            this.j = z;
            e();
        }
    }

    public boolean tc() {
        return this.j;
    }

    void d(float f) {
        this.c.d(f);
        if (this.v != null) {
            for (int i = 0; i < this.v.hc().size(); i++) {
                this.v.hc().get(i).d(f);
            }
        }
        com.bytedance.adsdk.lottie.d.hc.c cVar = this.np;
        if (cVar != null) {
            cVar.d(f);
        }
        b bVar = this.yi;
        if (bVar != null) {
            bVar.d(f);
        }
        for (int i2 = 0; i2 < this.zw.size(); i2++) {
            this.zw.get(i2).d(f);
        }
    }

    private void w() {
        if (this.vv != null) {
            return;
        }
        if (this.he == null) {
            this.vv = Collections.emptyList();
            return;
        }
        this.vv = new ArrayList();
        for (b bVar = this.he; bVar != null; bVar = bVar.he) {
            this.vv.add(bVar);
        }
    }

    public String mk() {
        return this.b.an();
    }

    public com.bytedance.adsdk.lottie.model.hc.d mq() {
        return this.b.v();
    }

    public BlurMaskFilter hc(float f) {
        if (this.u == f) {
            return this.an;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.an = blurMaskFilter;
        this.u = f;
        return blurMaskFilter;
    }

    public com.bytedance.adsdk.lottie.c.tc uo() {
        return this.b.np();
    }
}
