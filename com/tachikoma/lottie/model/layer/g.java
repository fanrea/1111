package com.tachikoma.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.tachikoma.lottie.a.b.n;
import com.tachikoma.lottie.model.DocumentData;
import com.tachikoma.lottie.model.a.k;
import com.tachikoma.lottie.model.content.j;
import com.tachikoma.lottie.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class g extends a {
    private final com.tachikoma.lottie.e GD;
    private final com.tachikoma.lottie.g Gt;
    private final Matrix Hh;
    private com.tachikoma.lottie.a.b.a<Integer, Integer> IX;
    private final StringBuilder MR;
    private final RectF MS;
    private final Paint MT;
    private final Paint MU;
    private final Map<com.tachikoma.lottie.model.c, List<com.tachikoma.lottie.a.a.d>> MV;
    private final android.support.v4.d.e<String> MW;
    private final n MX;
    private com.tachikoma.lottie.a.b.a<Integer, Integer> MY;
    private com.tachikoma.lottie.a.b.a<Float, Float> MZ;
    private com.tachikoma.lottie.a.b.a<Float, Float> Na;

    g(com.tachikoma.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.MR = new StringBuilder(2);
        this.MS = new RectF();
        this.Hh = new Matrix();
        int i = 1;
        this.MT = new Paint(i) { // from class: com.tachikoma.lottie.model.layer.g.1
            {
                super(1);
                setStyle(Paint.Style.FILL);
            }
        };
        this.MU = new Paint(i) { // from class: com.tachikoma.lottie.model.layer.g.2
            {
                super(1);
                setStyle(Paint.Style.STROKE);
            }
        };
        this.MV = new HashMap();
        this.MW = new android.support.v4.d.e<>();
        this.Gt = gVar;
        this.GD = layer.getComposition();
        this.MX = layer.lM().kB();
        this.MX.b(this);
        a(this.MX);
        k kVarLN = layer.lN();
        if (kVarLN != null && kVarLN.Lb != null) {
            this.IX = kVarLN.Lb.kB();
            this.IX.b(this);
            a(this.IX);
        }
        if (kVarLN != null && kVarLN.Lc != null) {
            this.MY = kVarLN.Lc.kB();
            this.MY.b(this);
            a(this.MY);
        }
        if (kVarLN != null && kVarLN.Ld != null) {
            this.MZ = kVarLN.Ld.kB();
            this.MZ.b(this);
            a(this.MZ);
        }
        if (kVarLN == null || kVarLN.Le == null) {
            return;
        }
        this.Na = kVarLN.Le.kB();
        this.Na.b(this);
        a(this.Na);
    }

    @Override // com.tachikoma.lottie.model.layer.a, com.tachikoma.lottie.a.a.e
    public final void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.GD.getBounds().width(), this.GD.getBounds().height());
    }

    @Override // com.tachikoma.lottie.model.layer.a
    final void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.Gt.jG()) {
            canvas.setMatrix(matrix);
        }
        DocumentData value = this.MX.getValue();
        com.tachikoma.lottie.model.b bVar = this.GD.jy().get(value.KF);
        if (bVar == null) {
            canvas.restore();
            return;
        }
        com.tachikoma.lottie.a.b.a<Integer, Integer> aVar = this.IX;
        if (aVar != null) {
            this.MT.setColor(aVar.getValue().intValue());
        } else {
            this.MT.setColor(value.color);
        }
        com.tachikoma.lottie.a.b.a<Integer, Integer> aVar2 = this.MY;
        if (aVar2 != null) {
            this.MU.setColor(aVar2.getValue().intValue());
        } else {
            this.MU.setColor(value.strokeColor);
        }
        int iIntValue = ((this.Jw.ko() == null ? 100 : this.Jw.ko().getValue().intValue()) * 255) / 100;
        this.MT.setAlpha(iIntValue);
        this.MU.setAlpha(iIntValue);
        com.tachikoma.lottie.a.b.a<Float, Float> aVar3 = this.MZ;
        if (aVar3 != null) {
            this.MU.setStrokeWidth(aVar3.getValue().floatValue());
        } else {
            float fB = com.tachikoma.lottie.d.f.b(matrix);
            Paint paint = this.MU;
            double d = value.KL;
            double dMf = com.tachikoma.lottie.d.f.mf();
            Double.isNaN(dMf);
            double d2 = d * dMf;
            double d3 = fB;
            Double.isNaN(d3);
            paint.setStrokeWidth((float) (d2 * d3));
        }
        if (this.Gt.jG()) {
            a(value, matrix, bVar, canvas);
        } else {
            a(value, bVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(DocumentData documentData, Matrix matrix, com.tachikoma.lottie.model.b bVar, Canvas canvas) {
        float f = ((float) documentData.KG) / 100.0f;
        float fB = com.tachikoma.lottie.d.f.b(matrix);
        String str = documentData.KE;
        float fMf = ((float) documentData.KJ) * com.tachikoma.lottie.d.f.mf();
        List<String> listAh = ah(str);
        int size = listAh.size();
        for (int i = 0; i < size; i++) {
            String str2 = listAh.get(i);
            float fA = a(str2, bVar, f, fB);
            canvas.save();
            a(documentData.KH, canvas, fA);
            canvas.translate(0.0f, (i * fMf) - (((size - 1) * fMf) / 2.0f));
            a(str2, documentData, matrix, bVar, canvas, fB, f);
            canvas.restore();
        }
    }

    private void a(String str, DocumentData documentData, Matrix matrix, com.tachikoma.lottie.model.b bVar, Canvas canvas, float f, float f2) {
        for (int i = 0; i < str.length(); i++) {
            com.tachikoma.lottie.model.c cVar = this.GD.jx().get(com.tachikoma.lottie.model.c.a(str.charAt(i), bVar.getFamily(), bVar.kv()));
            if (cVar != null) {
                a(cVar, matrix, f2, documentData, canvas);
                float fKx = ((float) cVar.kx()) * f2 * com.tachikoma.lottie.d.f.mf() * f;
                float fFloatValue = documentData.KI / 10.0f;
                com.tachikoma.lottie.a.b.a<Float, Float> aVar = this.Na;
                if (aVar != null) {
                    fFloatValue += aVar.getValue().floatValue();
                }
                canvas.translate(fKx + (fFloatValue * f), 0.0f);
            }
        }
    }

    private void a(DocumentData documentData, com.tachikoma.lottie.model.b bVar, Matrix matrix, Canvas canvas) {
        float fB = com.tachikoma.lottie.d.f.b(matrix);
        Typeface typefaceO = this.Gt.o(bVar.getFamily(), bVar.kv());
        if (typefaceO == null) {
            return;
        }
        String strAa = documentData.KE;
        p pVarJF = this.Gt.jF();
        if (pVarJF != null) {
            strAa = pVarJF.aa(strAa);
        }
        this.MT.setTypeface(typefaceO);
        Paint paint = this.MT;
        double d = documentData.KG;
        double dMf = com.tachikoma.lottie.d.f.mf();
        Double.isNaN(dMf);
        paint.setTextSize((float) (d * dMf));
        this.MU.setTypeface(this.MT.getTypeface());
        this.MU.setTextSize(this.MT.getTextSize());
        float fMf = ((float) documentData.KJ) * com.tachikoma.lottie.d.f.mf();
        List<String> listAh = ah(strAa);
        int size = listAh.size();
        for (int i = 0; i < size; i++) {
            String str = listAh.get(i);
            a(documentData.KH, canvas, this.MU.measureText(str));
            canvas.translate(0.0f, (i * fMf) - (((size - 1) * fMf) / 2.0f));
            a(str, documentData, canvas, fB);
            canvas.setMatrix(matrix);
        }
    }

    private static List<String> ah(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void a(String str, DocumentData documentData, Canvas canvas, float f) {
        int length = 0;
        while (length < str.length()) {
            String strN = n(str, length);
            length += strN.length();
            a(strN, documentData, canvas);
            float fMeasureText = this.MT.measureText(strN, 0, 1);
            float fFloatValue = documentData.KI / 10.0f;
            com.tachikoma.lottie.a.b.a<Float, Float> aVar = this.Na;
            if (aVar != null) {
                fFloatValue += aVar.getValue().floatValue();
            }
            canvas.translate(fMeasureText + (fFloatValue * f), 0.0f);
        }
    }

    private float a(String str, com.tachikoma.lottie.model.b bVar, float f, float f2) {
        float f3 = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            com.tachikoma.lottie.model.c cVar = this.GD.jx().get(com.tachikoma.lottie.model.c.a(str.charAt(i), bVar.getFamily(), bVar.kv()));
            if (cVar != null) {
                double d = f3;
                double dKx = cVar.kx();
                double d2 = f;
                Double.isNaN(d2);
                double d3 = dKx * d2;
                double dMf = com.tachikoma.lottie.d.f.mf();
                Double.isNaN(dMf);
                double d4 = d3 * dMf;
                double d5 = f2;
                Double.isNaN(d5);
                Double.isNaN(d);
                f3 = (float) (d + (d4 * d5));
            }
        }
        return f3;
    }

    /* renamed from: com.tachikoma.lottie.model.layer.g$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] Nc = new int[DocumentData.Justification.values().length];

        static {
            try {
                Nc[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Nc[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Nc[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static void a(DocumentData.Justification justification, Canvas canvas, float f) {
        int i = AnonymousClass3.Nc[justification.ordinal()];
        if (i != 1) {
            if (i == 2) {
                canvas.translate(-f, 0.0f);
            } else {
                if (i != 3) {
                    return;
                }
                canvas.translate((-f) / 2.0f, 0.0f);
            }
        }
    }

    private void a(com.tachikoma.lottie.model.c cVar, Matrix matrix, float f, DocumentData documentData, Canvas canvas) {
        List<com.tachikoma.lottie.a.a.d> listA = a(cVar);
        for (int i = 0; i < listA.size(); i++) {
            Path path = listA.get(i).getPath();
            path.computeBounds(this.MS, false);
            this.Hh.set(matrix);
            this.Hh.preTranslate(0.0f, ((float) (-documentData.KK)) * com.tachikoma.lottie.d.f.mf());
            this.Hh.preScale(f, f);
            path.transform(this.Hh);
            if (documentData.KM) {
                a(path, this.MT, canvas);
                a(path, this.MU, canvas);
            } else {
                a(path, this.MU, canvas);
                a(path, this.MT, canvas);
            }
        }
    }

    private static void a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void a(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.KM) {
            a(str, this.MT, canvas);
            a(str, this.MU, canvas);
        } else {
            a(str, this.MU, canvas);
            a(str, this.MT, canvas);
        }
    }

    private static void a(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.tachikoma.lottie.a.a.d> a(com.tachikoma.lottie.model.c cVar) {
        if (this.MV.containsKey(cVar)) {
            return this.MV.get(cVar);
        }
        List<j> listKw = cVar.kw();
        int size = listKw.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.tachikoma.lottie.a.a.d(this.Gt, this, listKw.get(i)));
        }
        this.MV.put(cVar, arrayList);
        return arrayList;
    }

    private String n(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!cx(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.MW.a(j)) {
            return this.MW.get(j);
        }
        this.MR.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.MR.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.MR.toString();
        this.MW.put(j, string);
        return string;
    }

    private static boolean cx(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 19;
    }

    @Override // com.tachikoma.lottie.model.layer.a, com.tachikoma.lottie.model.e
    public final <T> void a(T t, com.tachikoma.lottie.e.c<T> cVar) {
        com.tachikoma.lottie.a.b.a<Float, Float> aVar;
        com.tachikoma.lottie.a.b.a<Float, Float> aVar2;
        com.tachikoma.lottie.a.b.a<Integer, Integer> aVar3;
        com.tachikoma.lottie.a.b.a<Integer, Integer> aVar4;
        super.a((g) t, (com.tachikoma.lottie.e.c<g>) cVar);
        if (t == com.tachikoma.lottie.k.HJ && (aVar4 = this.IX) != null) {
            aVar4.a(cVar);
            return;
        }
        if (t == com.tachikoma.lottie.k.HK && (aVar3 = this.MY) != null) {
            aVar3.a(cVar);
            return;
        }
        if (t == com.tachikoma.lottie.k.HX && (aVar2 = this.MZ) != null) {
            aVar2.a(cVar);
        } else {
            if (t != com.tachikoma.lottie.k.HY || (aVar = this.Na) == null) {
                return;
            }
            aVar.a(cVar);
        }
    }
}
