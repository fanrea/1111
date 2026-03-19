package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.LongSparseArray;
import com.bytedance.adsdk.lottie.d.hc.e;
import com.bytedance.adsdk.lottie.model.hc;
import com.bytedance.adsdk.lottie.model.hc.cb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq extends b {
    private final com.bytedance.adsdk.lottie.gb cb;
    private com.bytedance.adsdk.lottie.d.hc.d<Float, Float> de;
    private final e e;
    private final RectF gb;
    private final StringBuilder h;
    private com.bytedance.adsdk.lottie.d.hc.d<Float, Float> he;
    private com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> jh;
    private final List<d> k;
    private final Paint mk;
    private final Map<com.bytedance.adsdk.lottie.model.c, List<com.bytedance.adsdk.lottie.d.d.c>> mq;
    private com.bytedance.adsdk.lottie.d.hc.d<Float, Float> np;
    private com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> rf;
    private com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> sy;
    private final Paint tc;
    private final Matrix tt;
    private final LongSparseArray<String> uo;
    private com.bytedance.adsdk.lottie.d.hc.d<Float, Float> v;
    private com.bytedance.adsdk.lottie.d.hc.d<Typeface, Typeface> vv;
    private final com.bytedance.adsdk.lottie.an w;
    private com.bytedance.adsdk.lottie.d.hc.d<Float, Float> yi;
    private com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> yo;

    mq(com.bytedance.adsdk.lottie.gb gbVar, gb gbVar2) {
        super(gbVar, gbVar2);
        this.h = new StringBuilder(2);
        this.gb = new RectF();
        this.tt = new Matrix();
        int i = 1;
        this.tc = new Paint(i) { // from class: com.bytedance.adsdk.lottie.model.layer.mq.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.mk = new Paint(i) { // from class: com.bytedance.adsdk.lottie.model.layer.mq.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.mq = new HashMap();
        this.uo = new LongSparseArray<>();
        this.k = new ArrayList();
        this.cb = gbVar;
        this.w = gbVar2.d();
        e eVarD = gbVar2.rf().d();
        this.e = eVarD;
        eVarD.d(this);
        d(eVarD);
        com.bytedance.adsdk.lottie.model.d.mk mkVarJh = gbVar2.jh();
        if (mkVarJh != null && mkVarJh.d != null) {
            com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVarD = mkVarJh.d.d();
            this.yo = dVarD;
            dVarD.d(this);
            d(this.yo);
        }
        if (mkVarJh != null && mkVarJh.hc != null) {
            com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVarD2 = mkVarJh.hc.d();
            this.jh = dVarD2;
            dVarD2.d(this);
            d(this.jh);
        }
        if (mkVarJh != null && mkVarJh.b != null) {
            com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD3 = mkVarJh.b.d();
            this.de = dVarD3;
            dVarD3.d(this);
            d(this.de);
        }
        if (mkVarJh == null || mkVarJh.c == null) {
            return;
        }
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD4 = mkVarJh.c.d();
        this.np = dVarD4;
        dVarD4.d(this);
        d(this.np);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.b, com.bytedance.adsdk.lottie.d.d.u
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.w.c().width(), this.w.c().height());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.b
    public void hc(Canvas canvas, Matrix matrix, int i) {
        super.hc(canvas, matrix, i);
        com.bytedance.adsdk.lottie.model.hc hcVarH = this.e.h();
        com.bytedance.adsdk.lottie.model.b bVar = this.w.cb().get(hcVarH.hc);
        if (bVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        d(hcVarH, matrix);
        if (this.cb.he()) {
            d(hcVarH, matrix, bVar, canvas);
        } else {
            d(hcVarH, bVar, canvas);
        }
        canvas.restore();
    }

    private void d(com.bytedance.adsdk.lottie.model.hc hcVar, Matrix matrix) {
        com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVar = this.rf;
        if (dVar != null) {
            this.tc.setColor(dVar.h().intValue());
        } else {
            com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVar2 = this.yo;
            if (dVar2 != null) {
                this.tc.setColor(dVar2.h().intValue());
            } else {
                this.tc.setColor(hcVar.gb);
            }
        }
        com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVar3 = this.sy;
        if (dVar3 != null) {
            this.mk.setColor(dVar3.h().intValue());
        } else {
            com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVar4 = this.jh;
            if (dVar4 != null) {
                this.mk.setColor(dVar4.h().intValue());
            } else {
                this.mk.setColor(hcVar.tt);
            }
        }
        int iIntValue = ((this.c.d() == null ? 100 : this.c.d().h().intValue()) * 255) / 100;
        this.tc.setAlpha(iIntValue);
        this.mk.setAlpha(iIntValue);
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVar5 = this.v;
        if (dVar5 != null) {
            this.mk.setStrokeWidth(dVar5.h().floatValue());
            return;
        }
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVar6 = this.de;
        if (dVar6 != null) {
            this.mk.setStrokeWidth(dVar6.h().floatValue());
        } else {
            this.mk.setStrokeWidth(hcVar.tc * com.bytedance.adsdk.lottie.u.tt.d());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(com.bytedance.adsdk.lottie.model.hc r21, android.graphics.Matrix r22, com.bytedance.adsdk.lottie.model.b r23, android.graphics.Canvas r24) {
        /*
            r20 = this;
            r8 = r20
            r9 = r21
            com.bytedance.adsdk.lottie.d.hc.d<java.lang.Float, java.lang.Float> r0 = r8.he
            if (r0 == 0) goto L13
            java.lang.Object r0 = r0.h()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L15
        L13:
            float r0 = r9.b
        L15:
            r1 = 1120403456(0x42c80000, float:100.0)
            float r10 = r0 / r1
            float r11 = com.bytedance.adsdk.lottie.u.tt.d(r22)
            java.lang.String r0 = r9.d
            java.util.List r12 = r8.d(r0)
            int r13 = r12.size()
            int r0 = r9.u
            float r0 = (float) r0
            r1 = 1092616192(0x41200000, float:10.0)
            float r0 = r0 / r1
            com.bytedance.adsdk.lottie.d.hc.d<java.lang.Float, java.lang.Float> r1 = r8.yi
            if (r1 == 0) goto L3d
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
        L3b:
            float r0 = r0 + r1
            goto L4c
        L3d:
            com.bytedance.adsdk.lottie.d.hc.d<java.lang.Float, java.lang.Float> r1 = r8.np
            if (r1 == 0) goto L4c
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L3b
        L4c:
            r14 = r0
            r0 = -1
            r15 = 0
            r7 = r0
            r6 = r15
        L51:
            if (r6 >= r13) goto Lb3
            java.lang.Object r0 = r12.get(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r9.uo
            if (r0 != 0) goto L60
            r0 = 0
            goto L64
        L60:
            android.graphics.PointF r0 = r9.uo
            float r0 = r0.x
        L64:
            r2 = r0
            r16 = 1
            r0 = r20
            r3 = r23
            r4 = r10
            r5 = r14
            r17 = r6
            r6 = r16
            java.util.List r6 = r0.d(r1, r2, r3, r4, r5, r6)
            r5 = r15
        L76:
            int r0 = r6.size()
            if (r5 >= r0) goto Lb0
            java.lang.Object r0 = r6.get(r5)
            com.bytedance.adsdk.lottie.model.layer.mq$d r0 = (com.bytedance.adsdk.lottie.model.layer.mq.d) r0
            int r7 = r7 + 1
            r24.save()
            float r1 = com.bytedance.adsdk.lottie.model.layer.mq.d.d(r0)
            r4 = r24
            r8.d(r4, r9, r7, r1)
            java.lang.String r1 = com.bytedance.adsdk.lottie.model.layer.mq.d.hc(r0)
            r0 = r20
            r2 = r21
            r3 = r23
            r16 = r5
            r5 = r11
            r18 = r6
            r6 = r10
            r19 = r7
            r7 = r14
            r0.d(r1, r2, r3, r4, r5, r6, r7)
            r24.restore()
            int r5 = r16 + 1
            r6 = r18
            r7 = r19
            goto L76
        Lb0:
            int r6 = r17 + 1
            goto L51
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.model.layer.mq.d(com.bytedance.adsdk.lottie.model.hc, android.graphics.Matrix, com.bytedance.adsdk.lottie.model.b, android.graphics.Canvas):void");
    }

    private void d(String str, com.bytedance.adsdk.lottie.model.hc hcVar, com.bytedance.adsdk.lottie.model.b bVar, Canvas canvas, float f, float f2, float f3) {
        for (int i = 0; i < str.length(); i++) {
            com.bytedance.adsdk.lottie.model.c cVar = this.w.e().get(com.bytedance.adsdk.lottie.model.c.d(str.charAt(i), bVar.d(), bVar.b()));
            if (cVar != null) {
                d(cVar, f2, hcVar, canvas);
                canvas.translate((((float) cVar.hc()) * f2 * com.bytedance.adsdk.lottie.u.tt.d()) + f3, 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(com.bytedance.adsdk.lottie.model.hc r19, com.bytedance.adsdk.lottie.model.b r20, android.graphics.Canvas r21) {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            android.graphics.Typeface r0 = r7.d(r9)
            if (r0 != 0) goto Lf
            return
        Lf:
            java.lang.String r1 = r8.d
            com.bytedance.adsdk.lottie.gb r2 = r7.cb
            com.bytedance.adsdk.lottie.jh r2 = r2.yi()
            if (r2 == 0) goto L21
            java.lang.String r3 = r18.mk()
            java.lang.String r1 = r2.b(r3, r1)
        L21:
            android.graphics.Paint r2 = r7.tc
            r2.setTypeface(r0)
            com.bytedance.adsdk.lottie.d.hc.d<java.lang.Float, java.lang.Float> r0 = r7.he
            if (r0 == 0) goto L35
            java.lang.Object r0 = r0.h()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L37
        L35:
            float r0 = r8.b
        L37:
            android.graphics.Paint r2 = r7.tc
            float r3 = com.bytedance.adsdk.lottie.u.tt.d()
            float r3 = r3 * r0
            r2.setTextSize(r3)
            android.graphics.Paint r2 = r7.mk
            android.graphics.Paint r3 = r7.tc
            android.graphics.Typeface r3 = r3.getTypeface()
            r2.setTypeface(r3)
            android.graphics.Paint r2 = r7.mk
            android.graphics.Paint r3 = r7.tc
            float r3 = r3.getTextSize()
            r2.setTextSize(r3)
            int r2 = r8.u
            float r2 = (float) r2
            r3 = 1092616192(0x41200000, float:10.0)
            float r2 = r2 / r3
            com.bytedance.adsdk.lottie.d.hc.d<java.lang.Float, java.lang.Float> r3 = r7.yi
            if (r3 == 0) goto L6d
            java.lang.Object r3 = r3.h()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
        L6b:
            float r2 = r2 + r3
            goto L7c
        L6d:
            com.bytedance.adsdk.lottie.d.hc.d<java.lang.Float, java.lang.Float> r3 = r7.np
            if (r3 == 0) goto L7c
            java.lang.Object r3 = r3.h()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            goto L6b
        L7c:
            float r3 = com.bytedance.adsdk.lottie.u.tt.d()
            float r2 = r2 * r3
            float r2 = r2 * r0
            r0 = 1120403456(0x42c80000, float:100.0)
            float r11 = r2 / r0
            java.util.List r12 = r7.d(r1)
            int r13 = r12.size()
            r0 = -1
            r14 = 0
            r15 = r0
            r6 = r14
        L92:
            if (r6 >= r13) goto Ldf
            java.lang.Object r0 = r12.get(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r8.uo
            if (r0 != 0) goto La1
            r0 = 0
            goto La5
        La1:
            android.graphics.PointF r0 = r8.uo
            float r0 = r0.x
        La5:
            r2 = r0
            r4 = 0
            r16 = 0
            r0 = r18
            r3 = r20
            r5 = r11
            r17 = r6
            r6 = r16
            java.util.List r0 = r0.d(r1, r2, r3, r4, r5, r6)
            r1 = r14
        Lb7:
            int r2 = r0.size()
            if (r1 >= r2) goto Ldc
            java.lang.Object r2 = r0.get(r1)
            com.bytedance.adsdk.lottie.model.layer.mq$d r2 = (com.bytedance.adsdk.lottie.model.layer.mq.d) r2
            int r15 = r15 + 1
            r21.save()
            float r3 = com.bytedance.adsdk.lottie.model.layer.mq.d.d(r2)
            r7.d(r10, r8, r15, r3)
            java.lang.String r2 = com.bytedance.adsdk.lottie.model.layer.mq.d.hc(r2)
            r7.d(r2, r8, r10, r11)
            r21.restore()
            int r1 = r1 + 1
            goto Lb7
        Ldc:
            int r6 = r17 + 1
            goto L92
        Ldf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.model.layer.mq.d(com.bytedance.adsdk.lottie.model.hc, com.bytedance.adsdk.lottie.model.b, android.graphics.Canvas):void");
    }

    private void d(Canvas canvas, com.bytedance.adsdk.lottie.model.hc hcVar, int i, float f) {
        PointF pointF = hcVar.mq;
        PointF pointF2 = hcVar.uo;
        float fD = com.bytedance.adsdk.lottie.u.tt.d();
        float f2 = (i * hcVar.an * fD) + (pointF == null ? 0.0f : (hcVar.an * 0.6f * fD) + pointF.y);
        float f3 = pointF == null ? 0.0f : pointF.x;
        float f4 = pointF2 != null ? pointF2.x : 0.0f;
        int i2 = AnonymousClass3.d[hcVar.c.ordinal()];
        if (i2 == 1) {
            canvas.translate(f3, f2);
        } else if (i2 == 2) {
            canvas.translate((f3 + f4) - f, f2);
        } else {
            if (i2 != 3) {
                return;
            }
            canvas.translate((f3 + (f4 / 2.0f)) - (f / 2.0f), f2);
        }
    }

    /* renamed from: com.bytedance.adsdk.lottie.model.layer.mq$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[hc.d.values().length];
            d = iArr;
            try {
                iArr[hc.d.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[hc.d.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[hc.d.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private Typeface d(com.bytedance.adsdk.lottie.model.b bVar) {
        Typeface typefaceH;
        com.bytedance.adsdk.lottie.d.hc.d<Typeface, Typeface> dVar = this.vv;
        if (dVar != null && (typefaceH = dVar.h()) != null) {
            return typefaceH;
        }
        Typeface typefaceD = this.cb.d(bVar);
        return typefaceD != null ? typefaceD : bVar.c();
    }

    private List<String> d(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void d(String str, com.bytedance.adsdk.lottie.model.hc hcVar, Canvas canvas, float f) {
        int length = 0;
        while (length < str.length()) {
            String strD = d(str, length);
            length += strD.length();
            d(strD, hcVar, canvas);
            canvas.translate(this.tc.measureText(strD) + f, 0.0f);
        }
    }

    private List<d> d(String str, float f, com.bytedance.adsdk.lottie.model.b bVar, float f2, float f3, boolean z) {
        float fMeasureText;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            if (z) {
                com.bytedance.adsdk.lottie.model.c cVar = this.w.e().get(com.bytedance.adsdk.lottie.model.c.d(cCharAt, bVar.d(), bVar.b()));
                if (cVar != null) {
                    fMeasureText = ((float) cVar.hc()) * f2 * com.bytedance.adsdk.lottie.u.tt.d();
                }
            } else {
                fMeasureText = this.tc.measureText(str.substring(i4, i4 + 1));
            }
            float f7 = fMeasureText + f3;
            if (cCharAt == ' ') {
                z2 = true;
                f6 = f7;
            } else if (z2) {
                z2 = false;
                i3 = i4;
                f5 = f7;
            } else {
                f5 += f7;
            }
            f4 += f7;
            if (f > 0.0f && f4 >= f && cCharAt != ' ') {
                i++;
                d dVarHc = hc(i);
                if (i3 == i2) {
                    dVarHc.d(str.substring(i2, i4).trim(), (f4 - f7) - ((r9.length() - r7.length()) * f6));
                    i2 = i4;
                    i3 = i2;
                    f4 = f7;
                    f5 = f4;
                } else {
                    dVarHc.d(str.substring(i2, i3 - 1).trim(), ((f4 - f5) - ((r7.length() - r13.length()) * f6)) - f6);
                    f4 = f5;
                    i2 = i3;
                }
            }
        }
        if (f4 > 0.0f) {
            i++;
            hc(i).d(str.substring(i2), f4);
        }
        return this.k.subList(0, i);
    }

    private d hc(int i) {
        for (int size = this.k.size(); size < i; size++) {
            this.k.add(new d());
        }
        return this.k.get(i - 1);
    }

    private void d(com.bytedance.adsdk.lottie.model.c cVar, float f, com.bytedance.adsdk.lottie.model.hc hcVar, Canvas canvas) {
        List<com.bytedance.adsdk.lottie.d.d.c> listD = d(cVar);
        for (int i = 0; i < listD.size(); i++) {
            Path pathC = listD.get(i).c();
            pathC.computeBounds(this.gb, false);
            this.tt.reset();
            this.tt.preTranslate(0.0f, (-hcVar.h) * com.bytedance.adsdk.lottie.u.tt.d());
            this.tt.preScale(f, f);
            pathC.transform(this.tt);
            if (hcVar.mk) {
                d(pathC, this.tc, canvas);
                d(pathC, this.mk, canvas);
            } else {
                d(pathC, this.mk, canvas);
                d(pathC, this.tc, canvas);
            }
        }
    }

    private void d(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void d(String str, com.bytedance.adsdk.lottie.model.hc hcVar, Canvas canvas) {
        if (hcVar.mk) {
            d(str, this.tc, canvas);
            d(str, this.mk, canvas);
        } else {
            d(str, this.mk, canvas);
            d(str, this.tc, canvas);
        }
    }

    private void d(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.bytedance.adsdk.lottie.d.d.c> d(com.bytedance.adsdk.lottie.model.c cVar) {
        if (this.mq.containsKey(cVar)) {
            return this.mq.get(cVar);
        }
        List<cb> listD = cVar.d();
        int size = listD.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.bytedance.adsdk.lottie.d.d.c(this.cb, this, listD.get(i), this.w));
        }
        this.mq.put(cVar, arrayList);
        return arrayList;
    }

    private String d(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!b(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.uo.indexOfKey(j) >= 0) {
            return this.uo.get(j);
        }
        this.h.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.h.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.h.toString();
        this.uo.put(j, string);
        return string;
    }

    private boolean b(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    private static class d {
        private String d;
        private float hc;

        private d() {
            this.d = "";
            this.hc = 0.0f;
        }

        void d(String str, float f) {
            this.d = str;
            this.hc = f;
        }
    }
}
