package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.plugin.w40;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class xf extends u4<b> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b b(e8 e8Var) {
        return new b(e8Var.d());
    }

    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "renderRange":
                if (cmVar.e(new JSONObject[0]) instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) cmVar.e(new JSONObject[0]);
                    ((b) this.A).a((float) jSONArray.optDouble(0, 0.0d), (float) jSONArray.optDouble(1, 360.0d));
                }
                return true;
            case "progressf":
                ((b) this.A).a(cmVar.b(new JSONObject[0]));
                return true;
            case "16":
                ((b) this.A).setBackgroundColor(v30.b(cmVar));
                return true;
            case "18":
                ((b) this.A).b(cmVar.c(new JSONObject[0]).e());
                return true;
            case "19":
                ((b) this.A).a(v30.b(cmVar));
                return true;
            case "style":
                ((b) this.A).c(cmVar.f(new JSONObject[0]));
                return true;
            default:
                return super.a(str, cmVar);
        }
    }

    /* compiled from: A */
    static class b extends View implements dl<xf> {
        private final float[] a;
        private final RectF b;
        private final Paint c;
        private final Path d;
        private int e;
        private int f;
        private int g;
        private int h;
        private float i;
        private xf j;

        public b(Context context) {
            super(context);
            this.a = new float[]{0.0f, 360.0f, 360.0f, 180.0f};
            this.b = new RectF();
            this.c = new Paint();
            this.d = new Path();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float f = this.h * 1.5f;
            float fMin = Math.min(getWidth(), getHeight()) - (f * 2.0f);
            float f2 = fMin / 2.0f;
            RectF rectF = this.b;
            rectF.top = f;
            rectF.left = f;
            float f3 = fMin + f;
            rectF.right = f3;
            rectF.bottom = f3;
            a(canvas);
            if (b()) {
                a(canvas, f2, f);
            }
            if (this.i > 0.0f) {
                b(canvas);
            }
        }

        private void b(Canvas canvas) {
            this.c.reset();
            this.c.setAntiAlias(true);
            this.c.setDither(true);
            this.c.setColor(this.g);
            this.c.setStyle(Paint.Style.STROKE);
            this.c.setStrokeCap(Paint.Cap.ROUND);
            this.c.setStrokeWidth(this.h);
            float f = this.a[2] * this.i;
            canvas.drawArc(this.b, a() ? this.a[0] : this.a[3] - (f / 2.0f), f, false, this.c);
        }

        private void a(Canvas canvas, float f, float f2) {
            this.c.reset();
            this.c.setAntiAlias(true);
            this.c.setDither(true);
            this.c.setColor(this.i >= 1.0f ? this.g : this.f);
            this.c.setStyle(Paint.Style.FILL);
            this.c.setStrokeWidth(1.0f);
            a(this.d, f, f2, this.a[0], true);
            canvas.drawPath(this.d, this.c);
            a(this.d, f, f2, this.a[1], false);
            canvas.drawPath(this.d, this.c);
        }

        @Override // android.view.View
        public void setBackgroundColor(int i) {
            this.f = i;
            postInvalidate();
        }

        void c(int i) {
            this.e = i;
            postInvalidate();
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            v40<V> v40VarV = this.j.v();
            if (v40VarV == 0) {
                super.onMeasure(i, i2);
                return;
            }
            Pair<Integer, Integer> pairB = v40VarV.b(i, i2);
            super.onMeasure(((Integer) pairB.first).intValue(), ((Integer) pairB.second).intValue());
            Pair<Integer, Integer> pairA = v40VarV.a(i, i2);
            if (pairA != null) {
                super.onMeasure(((Integer) pairA.first).intValue(), ((Integer) pairA.second).intValue());
            }
        }

        private void a(Canvas canvas) {
            this.c.reset();
            this.c.setAntiAlias(true);
            this.c.setDither(true);
            this.c.setColor(this.f);
            this.c.setStyle(Paint.Style.STROKE);
            this.c.setStrokeCap(b() ? Paint.Cap.BUTT : Paint.Cap.ROUND);
            this.c.setStrokeWidth(this.h);
            RectF rectF = this.b;
            float[] fArr = this.a;
            canvas.drawArc(rectF, fArr[0], fArr[2], false, this.c);
        }

        private boolean b() {
            return this.e == 1;
        }

        private void a(Path path, float f, float f2, double d, boolean z) {
            double d2 = (d * 3.141592653589793d) / 180.0d;
            float fCos = (float) Math.cos(d2);
            float fSin = (float) Math.sin(d2);
            float f3 = f * fCos;
            float f4 = f * fSin;
            float f5 = f + f2;
            float f6 = f5 * fCos;
            float f7 = f5 * fSin;
            float f8 = f - f2;
            float f9 = f8 * fCos;
            float f10 = f8 * fSin;
            float f11 = fSin * f2;
            float f12 = z ? f3 + f11 : f3 - f11;
            float f13 = f2 * fCos;
            float f14 = z ? f4 - f13 : f4 + f13;
            float fCenterX = this.b.centerX();
            float fCenterY = this.b.centerY();
            path.reset();
            path.moveTo(f12 + fCenterX, f14 + fCenterY);
            path.lineTo(f6 + fCenterX, f7 + fCenterY);
            path.lineTo(f9 + fCenterX, f10 + fCenterY);
            path.close();
        }

        void b(int i) {
            this.h = i;
            postInvalidate();
        }

        private boolean a() {
            return this.e == 2;
        }

        void a(int i) {
            this.g = i;
            postInvalidate();
        }

        void a(float f) {
            this.i = f;
            postInvalidate();
        }

        void a(float f, float f2) {
            float[] fArr = this.a;
            fArr[0] = f;
            fArr[1] = f2;
            float f3 = f2 - f;
            fArr[2] = f3;
            fArr[3] = f + (f3 / 2.0f);
            postInvalidate();
        }

        @Override // com.qq.e.comm.plugin.dl
        public void a(xf xfVar) {
            this.j = xfVar;
        }
    }

    /* compiled from: A */
    static class a implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            return new xf();
        }

        a() {
        }
    }
}
