package com.component.lottie.d.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.component.lottie.a.b.q;
import com.component.lottie.af;
import com.component.lottie.ba;
import com.component.lottie.bj;
import com.component.lottie.d.b;
import com.component.lottie.d.b.p;
import com.component.lottie.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class k extends a {
    private final StringBuilder g;
    private final RectF h;
    private final Matrix i;
    private final Paint j;
    private final Paint k;
    private final Map<com.component.lottie.d.d, List<com.component.lottie.a.a.e>> l;
    private final com.component.lottie.b.b<String> m;
    private final q n;
    private final af o;
    private final t p;
    private com.component.lottie.a.b.a<Integer, Integer> q;
    private com.component.lottie.a.b.a<Integer, Integer> r;
    private com.component.lottie.a.b.a<Integer, Integer> s;
    private com.component.lottie.a.b.a<Integer, Integer> t;
    private com.component.lottie.a.b.a<Float, Float> u;
    private com.component.lottie.a.b.a<Float, Float> v;
    private com.component.lottie.a.b.a<Float, Float> w;
    private com.component.lottie.a.b.a<Float, Float> x;
    private com.component.lottie.a.b.a<Float, Float> y;
    private com.component.lottie.a.b.a<Typeface, Typeface> z;

    k(af afVar, g gVar) {
        super(afVar, gVar);
        this.g = new StringBuilder(2);
        this.h = new RectF();
        this.i = new Matrix();
        this.j = new l(this, 1);
        this.k = new m(this, 1);
        this.l = new HashMap();
        this.m = new com.component.lottie.b.b<>();
        this.o = afVar;
        this.p = gVar.a();
        this.n = gVar.s().a();
        this.n.a(this);
        a(this.n);
        com.component.lottie.d.a.k kVarT = gVar.t();
        if (kVarT != null && kVarT.a != null) {
            this.q = kVarT.a.a();
            this.q.a(this);
            a(this.q);
        }
        if (kVarT != null && kVarT.b != null) {
            this.s = kVarT.b.a();
            this.s.a(this);
            a(this.s);
        }
        if (kVarT != null && kVarT.c != null) {
            this.u = kVarT.c.a();
            this.u.a(this);
            a(this.u);
        }
        if (kVarT != null && kVarT.d != null) {
            this.w = kVarT.d.a();
            this.w.a(this);
            a(this.w);
        }
    }

    @Override // com.component.lottie.d.c.a, com.component.lottie.a.a.f
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.p.e().width(), this.p.e().height());
    }

    @Override // com.component.lottie.d.c.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.o.B()) {
            canvas.concat(matrix);
        }
        com.component.lottie.d.b bVarG = this.n.g();
        com.component.lottie.d.c cVar = this.p.l().get(bVarG.b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.r != null) {
            this.j.setColor(this.r.g().intValue());
        } else if (this.q != null) {
            this.j.setColor(this.q.g().intValue());
        } else {
            this.j.setColor(bVarG.h);
        }
        if (this.t != null) {
            this.k.setColor(this.t.g().intValue());
        } else if (this.s != null) {
            this.k.setColor(this.s.g().intValue());
        } else {
            this.k.setColor(bVarG.i);
        }
        int iIntValue = ((this.d.a() == null ? 100 : this.d.a().g().intValue()) * 255) / 100;
        this.j.setAlpha(iIntValue);
        this.k.setAlpha(iIntValue);
        if (this.v != null) {
            this.k.setStrokeWidth(this.v.g().floatValue());
        } else if (this.u != null) {
            this.k.setStrokeWidth(this.u.g().floatValue());
        } else {
            this.k.setStrokeWidth(bVarG.j * com.component.lottie.g.g.a() * com.component.lottie.g.g.a(matrix));
        }
        if (this.o.B()) {
            a(bVarG, matrix, cVar, canvas);
        } else {
            a(bVarG, cVar, canvas);
        }
        canvas.restore();
    }

    private void a(com.component.lottie.d.b bVar, Matrix matrix, com.component.lottie.d.c cVar, Canvas canvas) {
        float fFloatValue;
        if (this.y != null) {
            fFloatValue = this.y.g().floatValue();
        } else {
            fFloatValue = bVar.c;
        }
        float f = fFloatValue / 100.0f;
        float fA = com.component.lottie.g.g.a(matrix);
        String str = bVar.a;
        float fA2 = bVar.f * com.component.lottie.g.g.a();
        List<String> listA = a(str);
        int size = listA.size();
        for (int i = 0; i < size; i++) {
            String str2 = listA.get(i);
            float fA3 = a(str2, cVar, f, fA);
            canvas.save();
            a(bVar.d, canvas, fA3);
            canvas.translate(0.0f, (i * fA2) - (((size - 1) * fA2) / 2.0f));
            a(str2, bVar, matrix, cVar, canvas, fA, f);
            canvas.restore();
        }
    }

    private void a(String str, com.component.lottie.d.b bVar, Matrix matrix, com.component.lottie.d.c cVar, Canvas canvas, float f, float f2) {
        for (int i = 0; i < str.length(); i++) {
            com.component.lottie.d.d dVarA = this.p.k().a(com.component.lottie.d.d.a(str.charAt(i), cVar.a(), cVar.c()));
            if (dVarA != null) {
                a(dVarA, matrix, f2, bVar, canvas);
                float fB = ((float) dVarA.b()) * f2 * com.component.lottie.g.g.a() * f;
                float fFloatValue = bVar.e / 10.0f;
                if (this.x != null) {
                    fFloatValue += this.x.g().floatValue();
                } else if (this.w != null) {
                    fFloatValue += this.w.g().floatValue();
                }
                canvas.translate(fB + (fFloatValue * f), 0.0f);
            }
        }
    }

    private void a(com.component.lottie.d.b bVar, com.component.lottie.d.c cVar, Canvas canvas) {
        float fFloatValue;
        Typeface typefaceA = a(cVar);
        if (typefaceA == null) {
            return;
        }
        String strC = bVar.a;
        bj bjVarA = this.o.A();
        if (bjVarA != null) {
            strC = bjVarA.c(b(), strC);
        }
        this.j.setTypeface(typefaceA);
        if (this.y != null) {
            fFloatValue = this.y.g().floatValue();
        } else {
            fFloatValue = bVar.c;
        }
        this.j.setTextSize(com.component.lottie.g.g.a() * fFloatValue);
        this.k.setTypeface(this.j.getTypeface());
        this.k.setTextSize(this.j.getTextSize());
        float fA = bVar.f * com.component.lottie.g.g.a();
        float fFloatValue2 = bVar.e / 10.0f;
        if (this.x != null) {
            fFloatValue2 += this.x.g().floatValue();
        } else if (this.w != null) {
            fFloatValue2 += this.w.g().floatValue();
        }
        float fA2 = ((fFloatValue2 * com.component.lottie.g.g.a()) * fFloatValue) / 100.0f;
        List<String> listA = a(strC);
        int size = listA.size();
        for (int i = 0; i < size; i++) {
            String str = listA.get(i);
            float fMeasureText = this.k.measureText(str) + ((str.length() - 1) * fA2);
            canvas.save();
            a(bVar.d, canvas, fMeasureText);
            canvas.translate(0.0f, (i * fA) - (((size - 1) * fA) / 2.0f));
            a(str, bVar, canvas, fA2);
            canvas.restore();
        }
    }

    private Typeface a(com.component.lottie.d.c cVar) {
        Typeface typefaceG;
        if (this.z != null && (typefaceG = this.z.g()) != null) {
            return typefaceG;
        }
        Typeface typefaceA = this.o.a(cVar.a(), cVar.c());
        if (typefaceA != null) {
            return typefaceA;
        }
        return cVar.e();
    }

    private List<String> a(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void a(String str, com.component.lottie.d.b bVar, Canvas canvas, float f) {
        int length = 0;
        while (length < str.length()) {
            String strA = a(str, length);
            length += strA.length();
            a(strA, bVar, canvas);
            canvas.translate(this.j.measureText(strA) + f, 0.0f);
        }
    }

    private float a(String str, com.component.lottie.d.c cVar, float f, float f2) {
        float f3 = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            com.component.lottie.d.d dVarA = this.p.k().a(com.component.lottie.d.d.a(str.charAt(i), cVar.a(), cVar.c()));
            if (dVarA != null) {
                double d = f3;
                double dB = dVarA.b();
                double d2 = f;
                Double.isNaN(d2);
                double d3 = dB * d2;
                double dA = com.component.lottie.g.g.a();
                Double.isNaN(dA);
                double d4 = d3 * dA;
                double d5 = f2;
                Double.isNaN(d5);
                Double.isNaN(d);
                f3 = (float) (d + (d4 * d5));
            }
        }
        return f3;
    }

    private void a(b.a aVar, Canvas canvas, float f) {
        switch (aVar) {
            case RIGHT_ALIGN:
                canvas.translate(-f, 0.0f);
                break;
            case CENTER:
                canvas.translate((-f) / 2.0f, 0.0f);
                break;
        }
    }

    private void a(com.component.lottie.d.d dVar, Matrix matrix, float f, com.component.lottie.d.b bVar, Canvas canvas) {
        List<com.component.lottie.a.a.e> listA = a(dVar);
        for (int i = 0; i < listA.size(); i++) {
            Path pathE = listA.get(i).e();
            pathE.computeBounds(this.h, false);
            this.i.set(matrix);
            this.i.preTranslate(0.0f, (-bVar.g) * com.component.lottie.g.g.a());
            this.i.preScale(f, f);
            pathE.transform(this.i);
            if (bVar.k) {
                a(pathE, this.j, canvas);
                a(pathE, this.k, canvas);
            } else {
                a(pathE, this.k, canvas);
                a(pathE, this.j, canvas);
            }
        }
    }

    private void a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void a(String str, com.component.lottie.d.b bVar, Canvas canvas) {
        if (bVar.k) {
            a(str, this.j, canvas);
            a(str, this.k, canvas);
        } else {
            a(str, this.k, canvas);
            a(str, this.j, canvas);
        }
    }

    private void a(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.component.lottie.a.a.e> a(com.component.lottie.d.d dVar) {
        if (this.l.containsKey(dVar)) {
            return this.l.get(dVar);
        }
        List<p> listA = dVar.a();
        int size = listA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.component.lottie.a.a.e(this.o, this, listA.get(i)));
        }
        this.l.put(dVar, arrayList);
        return arrayList;
    }

    private String a(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!a(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.m.e(j)) {
            return this.m.a(j);
        }
        this.g.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.g.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.g.toString();
        this.m.d(j, string);
        return string;
    }

    private boolean a(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    @Override // com.component.lottie.d.c.a, com.component.lottie.d.f
    public <T> void a(T t, com.component.lottie.h.j<T> jVar) {
        super.a((k) t, (com.component.lottie.h.j<k>) jVar);
        if (t == ba.a) {
            if (this.r != null) {
                b(this.r);
            }
            if (jVar == null) {
                this.r = null;
                return;
            }
            this.r = new com.component.lottie.a.b.t(jVar);
            this.r.a(this);
            a(this.r);
            return;
        }
        if (t == ba.b) {
            if (this.t != null) {
                b(this.t);
            }
            if (jVar == null) {
                this.t = null;
                return;
            }
            this.t = new com.component.lottie.a.b.t(jVar);
            this.t.a(this);
            a(this.t);
            return;
        }
        if (t == ba.s) {
            if (this.v != null) {
                b(this.v);
            }
            if (jVar == null) {
                this.v = null;
                return;
            }
            this.v = new com.component.lottie.a.b.t(jVar);
            this.v.a(this);
            a(this.v);
            return;
        }
        if (t == ba.t) {
            if (this.x != null) {
                b(this.x);
            }
            if (jVar == null) {
                this.x = null;
                return;
            }
            this.x = new com.component.lottie.a.b.t(jVar);
            this.x.a(this);
            a(this.x);
            return;
        }
        if (t == ba.F) {
            if (this.y != null) {
                b(this.y);
            }
            if (jVar == null) {
                this.y = null;
                return;
            }
            this.y = new com.component.lottie.a.b.t(jVar);
            this.y.a(this);
            a(this.y);
            return;
        }
        if (t == ba.M) {
            if (this.z != null) {
                b(this.z);
            }
            if (jVar == null) {
                this.z = null;
                return;
            }
            this.z = new com.component.lottie.a.b.t(jVar);
            this.z.a(this);
            a(this.z);
            return;
        }
        if (t == ba.O) {
            this.n.b(jVar);
        }
    }
}
