package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.LongSparseArray;
import com.bytedance.adsdk.lottie.model.layer.gb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends b {
    private final List<b> gb;
    private com.bytedance.adsdk.lottie.d.hc.d<Float, Float> h;
    private final Paint mk;
    private boolean mq;
    private final RectF tc;
    private final RectF tt;

    public c(com.bytedance.adsdk.lottie.gb gbVar, gb gbVar2, List<gb> list, com.bytedance.adsdk.lottie.an anVar, Context context) {
        int i;
        b bVar;
        gb.hc hcVarMq;
        int i2;
        super(gbVar, gbVar2);
        this.gb = new ArrayList();
        this.tt = new RectF();
        this.tc = new RectF();
        this.mk = new Paint();
        this.mq = true;
        com.bytedance.adsdk.lottie.model.d.hc hcVarSy = gbVar2.sy();
        if (hcVarSy != null) {
            com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD = hcVarSy.d();
            this.h = dVarD;
            d(dVarD);
            this.h.d(this);
        } else {
            this.h = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(anVar.k().size());
        int size = list.size() - 1;
        b bVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            gb gbVar3 = list.get(size);
            b bVarD = b.d(this, gbVar3, gbVar, anVar, context);
            if (bVarD != null) {
                longSparseArray.put(bVarD.c().u(), bVarD);
                if (bVar2 != null) {
                    bVar2.d(bVarD);
                    bVar2 = null;
                } else {
                    this.gb.add(0, bVarD);
                    if (gbVar3 != null && (hcVarMq = gbVar3.mq()) != null && ((i2 = AnonymousClass1.d[hcVarMq.ordinal()]) == 1 || i2 == 2)) {
                        bVar2 = bVarD;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            b bVar3 = (b) longSparseArray.get(longSparseArray.keyAt(i));
            if (bVar3 != null && (bVar = (b) longSparseArray.get(bVar3.c().uo())) != null) {
                bVar3.hc(bVar);
            }
        }
    }

    /* renamed from: com.bytedance.adsdk.lottie.model.layer.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[gb.hc.values().length];
            d = iArr;
            try {
                iArr[gb.hc.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[gb.hc.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void hc(boolean z) {
        this.mq = z;
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.b
    public void d(boolean z) {
        super.d(z);
        Iterator<b> it = this.gb.iterator();
        while (it.hasNext()) {
            it.next().d(z);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.b
    public void hc(Canvas canvas, Matrix matrix, int i) {
        super.hc(canvas, matrix, i);
        com.bytedance.adsdk.lottie.u.d("CompositionLayer#draw");
        this.tc.set(0.0f, 0.0f, this.b.gb(), this.b.tt());
        matrix.mapRect(this.tc);
        boolean z = this.hc.tc() && this.gb.size() > 1 && i != 255;
        if (z) {
            this.mk.setAlpha(i);
            com.bytedance.adsdk.lottie.u.tt.d(canvas, this.tc, this.mk);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.gb.size() - 1; size >= 0; size--) {
            if (((!this.mq && "__container".equals(this.b.an())) || this.tc.isEmpty()) ? true : canvas.clipRect(this.tc)) {
                this.gb.get(size).d(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.bytedance.adsdk.lottie.u.hc("CompositionLayer#draw");
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.b, com.bytedance.adsdk.lottie.d.d.u
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        for (int size = this.gb.size() - 1; size >= 0; size--) {
            this.tt.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.gb.get(size).d(this.tt, this.d, true);
            rectF.union(this.tt);
        }
    }

    public List<b> k() {
        return this.gb;
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.b
    public void d(float f) {
        super.d(f);
        if (this.h != null) {
            f = ((this.h.h().floatValue() * this.b.d().uo()) - this.b.d().an()) / (this.hc.vv().yo() + 0.01f);
        }
        if (this.h == null) {
            f -= this.b.b();
        }
        if (this.b.hc() != 0.0f && !"__container".equals(this.b.an())) {
            f /= this.b.hc();
        }
        for (int size = this.gb.size() - 1; size >= 0; size--) {
            this.gb.get(size).d(f);
        }
    }
}
