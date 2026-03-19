package com.kwad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.kwad.lottie.a.b.n;
import com.kwad.lottie.i;
import com.kwad.lottie.m;
import com.kwad.lottie.model.a.k;
import com.kwad.lottie.model.content.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends a {
    private final com.kwad.lottie.d bjG;
    private final com.kwad.lottie.f bjz;
    private final Matrix bka;
    private com.kwad.lottie.a.b.a<Integer, Integer> blF;
    private final char[] bpb;
    private final RectF bpc;
    private final Paint bpd;
    private final Paint bpe;
    private final Map<com.kwad.lottie.model.d, List<com.kwad.lottie.a.a.c>> bpf;
    private final n bpg;
    private com.kwad.lottie.a.b.a<Integer, Integer> bph;
    private com.kwad.lottie.a.b.a<Float, Float> bpi;
    private com.kwad.lottie.a.b.a<Float, Float> bpj;

    g(com.kwad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        int i = 1;
        this.bpb = new char[1];
        this.bpc = new RectF();
        this.bka = new Matrix();
        this.bpd = new Paint(i) { // from class: com.kwad.lottie.model.layer.g.1
            {
                super(1);
                setStyle(Paint.Style.FILL);
            }
        };
        this.bpe = new Paint(i) { // from class: com.kwad.lottie.model.layer.g.2
            {
                super(1);
                setStyle(Paint.Style.STROKE);
            }
        };
        this.bpf = new HashMap();
        this.bjz = fVar;
        this.bjG = layer.getComposition();
        n nVarRj = layer.Sp().Rj();
        this.bpg = nVarRj;
        nVarRj.b(this);
        a(nVarRj);
        k kVarSq = layer.Sq();
        if (kVarSq != null && kVarSq.bnp != null) {
            com.kwad.lottie.a.b.a<Integer, Integer> aVarRj = kVarSq.bnp.Rj();
            this.blF = aVarRj;
            aVarRj.b(this);
            a(this.blF);
        }
        if (kVarSq != null && kVarSq.bnq != null) {
            com.kwad.lottie.a.b.a<Integer, Integer> aVarRj2 = kVarSq.bnq.Rj();
            this.bph = aVarRj2;
            aVarRj2.b(this);
            a(this.bph);
        }
        if (kVarSq != null && kVarSq.bnr != null) {
            com.kwad.lottie.a.b.a<Float, Float> aVarRj3 = kVarSq.bnr.Rj();
            this.bpi = aVarRj3;
            aVarRj3.b(this);
            a(this.bpi);
        }
        if (kVarSq == null || kVarSq.bns == null) {
            return;
        }
        com.kwad.lottie.a.b.a<Float, Float> aVarRj4 = kVarSq.bns.Rj();
        this.bpj = aVarRj4;
        aVarRj4.b(this);
        a(this.bpj);
    }

    @Override // com.kwad.lottie.model.layer.a
    final void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.bjz.Qr()) {
            canvas.setMatrix(matrix);
        }
        com.kwad.lottie.model.b value = this.bpg.getValue();
        com.kwad.lottie.model.c cVar = this.bjG.Qi().get(value.bmW);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        com.kwad.lottie.a.b.a<Integer, Integer> aVar = this.blF;
        if (aVar != null) {
            this.bpd.setColor(aVar.getValue().intValue());
        } else {
            this.bpd.setColor(value.color);
        }
        com.kwad.lottie.a.b.a<Integer, Integer> aVar2 = this.bph;
        if (aVar2 != null) {
            this.bpe.setColor(aVar2.getValue().intValue());
        } else {
            this.bpe.setColor(value.strokeColor);
        }
        int iIntValue = (this.bmd.QX().getValue().intValue() * 255) / 100;
        this.bpd.setAlpha(iIntValue);
        this.bpe.setAlpha(iIntValue);
        com.kwad.lottie.a.b.a<Float, Float> aVar3 = this.bpi;
        if (aVar3 != null) {
            this.bpe.setStrokeWidth(aVar3.getValue().floatValue());
        } else {
            this.bpe.setStrokeWidth((float) (value.bnc * com.kwad.lottie.d.f.SI() * com.kwad.lottie.d.f.b(matrix)));
        }
        if (this.bjz.Qr()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.kwad.lottie.model.b bVar, Matrix matrix, com.kwad.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.bmX) / 100.0f;
        float fB = com.kwad.lottie.d.f.b(matrix);
        String str = bVar.text;
        for (int i = 0; i < str.length(); i++) {
            com.kwad.lottie.model.d dVar = this.bjG.Qh().get(com.kwad.lottie.model.d.a(str.charAt(i), cVar.getFamily(), cVar.Rd()));
            if (dVar != null) {
                a(dVar, matrix, f, bVar, canvas);
                float fRf = ((float) dVar.Rf()) * f * com.kwad.lottie.d.f.SI() * fB;
                float fFloatValue = bVar.bmZ / 10.0f;
                com.kwad.lottie.a.b.a<Float, Float> aVar = this.bpj;
                if (aVar != null) {
                    fFloatValue += aVar.getValue().floatValue();
                }
                canvas.translate(fRf + (fFloatValue * fB), 0.0f);
            }
        }
    }

    private void a(com.kwad.lottie.model.b bVar, com.kwad.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float fB = com.kwad.lottie.d.f.b(matrix);
        Typeface typefaceN = this.bjz.N(cVar.getFamily(), cVar.Rd());
        if (typefaceN == null) {
            return;
        }
        String strDm = bVar.text;
        m mVarQq = this.bjz.Qq();
        if (mVarQq != null) {
            strDm = mVarQq.dm(strDm);
        }
        this.bpd.setTypeface(typefaceN);
        this.bpd.setTextSize((float) (bVar.bmX * com.kwad.lottie.d.f.SI()));
        this.bpe.setTypeface(this.bpd.getTypeface());
        this.bpe.setTextSize(this.bpd.getTextSize());
        for (int i = 0; i < strDm.length(); i++) {
            char cCharAt = strDm.charAt(i);
            a(cCharAt, bVar, canvas);
            char[] cArr = this.bpb;
            cArr[0] = cCharAt;
            float fMeasureText = this.bpd.measureText(cArr, 0, 1);
            float fFloatValue = bVar.bmZ / 10.0f;
            com.kwad.lottie.a.b.a<Float, Float> aVar = this.bpj;
            if (aVar != null) {
                fFloatValue += aVar.getValue().floatValue();
            }
            canvas.translate(fMeasureText + (fFloatValue * fB), 0.0f);
        }
    }

    private void a(com.kwad.lottie.model.d dVar, Matrix matrix, float f, com.kwad.lottie.model.b bVar, Canvas canvas) {
        List<com.kwad.lottie.a.a.c> listA = a(dVar);
        for (int i = 0; i < listA.size(); i++) {
            Path path = listA.get(i).getPath();
            path.computeBounds(this.bpc, false);
            this.bka.set(matrix);
            this.bka.preTranslate(0.0f, ((float) (-bVar.bnb)) * com.kwad.lottie.d.f.SI());
            this.bka.preScale(f, f);
            path.transform(this.bka);
            if (bVar.bnd) {
                a(path, this.bpd, canvas);
                a(path, this.bpe, canvas);
            } else {
                a(path, this.bpe, canvas);
                a(path, this.bpd, canvas);
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

    private void a(char c, com.kwad.lottie.model.b bVar, Canvas canvas) {
        this.bpb[0] = c;
        if (bVar.bnd) {
            a(this.bpb, this.bpd, canvas);
            a(this.bpb, this.bpe, canvas);
        } else {
            a(this.bpb, this.bpe, canvas);
            a(this.bpb, this.bpd, canvas);
        }
    }

    private static void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
    }

    private List<com.kwad.lottie.a.a.c> a(com.kwad.lottie.model.d dVar) {
        if (this.bpf.containsKey(dVar)) {
            return this.bpf.get(dVar);
        }
        List<j> listRe = dVar.Re();
        int size = listRe.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.kwad.lottie.a.a.c(this.bjz, this, listRe.get(i)));
        }
        this.bpf.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.kwad.lottie.model.layer.a, com.kwad.lottie.model.f
    public final <T> void a(T t, com.kwad.lottie.e.c<T> cVar) {
        com.kwad.lottie.a.b.a<Float, Float> aVar;
        com.kwad.lottie.a.b.a<Float, Float> aVar2;
        com.kwad.lottie.a.b.a<Integer, Integer> aVar3;
        com.kwad.lottie.a.b.a<Integer, Integer> aVar4;
        super.a((g) t, (com.kwad.lottie.e.c<g>) cVar);
        if (t == i.bkx && (aVar4 = this.blF) != null) {
            aVar4.a(cVar);
            return;
        }
        if (t == i.bky && (aVar3 = this.bph) != null) {
            aVar3.a(cVar);
            return;
        }
        if (t == i.bkH && (aVar2 = this.bpi) != null) {
            aVar2.a(cVar);
        } else {
            if (t != i.bkI || (aVar = this.bpj) == null) {
                return;
            }
            aVar.a(cVar);
        }
    }
}
