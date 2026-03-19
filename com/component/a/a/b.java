package com.component.a.a;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.mobads.container.util.bv;
import com.luck.picture.lib.config.PictureMimeType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b extends com.component.a.d.c implements ValueAnimator.AnimatorUpdateListener {
    private final int a;
    private final AtomicInteger b;
    private ValueAnimator d;
    private int e;
    private float f;
    private int g;
    private int h;
    private int i;
    private int j;
    private final C0312b k;
    private long l;
    private int m;

    static class e {
        public static final String a = "speed";
        public static final String b = "duration";
        public static final String c = "delay";
        public static final String d = "bullets";
        public static final String e = "text";
        public static final String f = "icon";
        public static final String g = "text_color";
        public static final String h = "text_size";
        public static final String i = "bullet_height";
        public static final String j = "bullet_margin";
        public static final String k = "lines";

        e() {
        }
    }

    public b(Context context, com.component.a.f.e eVar) {
        super(context, eVar);
        this.a = 10000;
        this.b = new AtomicInteger(-1);
        this.e = 0;
        this.f = 1.0f;
        this.g = 10000;
        this.h = 10000;
        this.i = 0;
        this.j = 1;
        this.l = 0L;
        this.m = 0;
        this.k = new C0312b();
        a(eVar);
    }

    public void a(com.component.a.f.e eVar) {
        JSONObject jSONObjectC = eVar.c();
        if (jSONObjectC != null) {
            this.k.a(getContext(), jSONObjectC);
            this.f = (((float) jSONObjectC.optDouble(e.a, 1.0d)) * bv.e(getContext())) / 10.0f;
            this.g = jSONObjectC.optInt("duration", 10000);
            this.h = this.g + 10000;
            this.i = jSONObjectC.optInt(e.c, 0);
            this.m = this.i;
            this.j = jSONObjectC.optInt(e.k, 1);
        }
    }

    public void a() {
        this.d = ValueAnimator.ofInt(0, this.h);
        this.d.addUpdateListener(this);
        this.d.setInterpolator(new LinearInterpolator());
        this.d.setDuration(this.h);
        this.d.setRepeatCount(0);
        this.d.setStartDelay(this.i);
    }

    public void b() {
        if (this.d != null && this.b.compareAndSet(-1, 1)) {
            this.d.start();
            this.l = System.currentTimeMillis();
        }
    }

    public void c() {
        if (this.b.compareAndSet(1, 0) && this.d != null) {
            this.d.cancel();
            this.m = (int) Math.min(Math.max(0L, this.i - (System.currentTimeMillis() - this.l)), this.i);
        }
    }

    public void d() {
        if (this.b.compareAndSet(0, 1) && this.d != null && this.e < this.h) {
            this.d.setIntValues(this.e, this.h);
            this.d.setDuration(this.h - this.e);
            this.d.setRepeatCount(0);
            this.d.setStartDelay(this.m);
            this.d.start();
            this.l = System.currentTimeMillis();
        }
    }

    public void e() {
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
        this.b.set(-1);
        this.k.a();
        this.e = 0;
    }

    public void f() {
        setVisibility(8);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.k.a((-(iIntValue - this.e)) * this.f);
        this.e = iIntValue;
        if (iIntValue >= this.g) {
            this.k.k = true;
        }
        if (this.k.c() == 0) {
            e();
            f();
        }
        invalidate();
    }

    @Override // com.component.a.d.c, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.component.a.d.c, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        f();
    }

    @Override // com.component.a.d.c, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            b();
        } else {
            c();
        }
    }

    @Override // com.component.a.d.c, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            d();
        } else {
            c();
        }
    }

    @Override // com.component.a.d.c, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        if ((mode == 1073741824 && size == 0) || mode == Integer.MIN_VALUE || mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec((this.j * (this.k.g + this.k.h)) + this.k.h, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.component.a.d.c, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.d == null && this.k.a(getContext(), this.j, i3 - i, i4 - i2)) {
            a();
            b();
        }
    }

    @Override // com.component.a.d.c, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.k.a(canvas);
    }

    /* renamed from: com.component.a.a.b$b, reason: collision with other inner class name */
    static class C0312b {
        private int d;
        private int e;
        private int f;
        private int l;
        private int m;
        private int n;
        private final ArrayList<ArrayList<c>> a = new ArrayList<>();
        private final ArrayList<a> b = new ArrayList<>();
        private int c = -1;
        private int g = 10;
        private int h = 0;
        private int i = 0;
        private boolean k = false;
        private final d j = new d();

        public void a(Context context, JSONArray jSONArray) {
            int length;
            if (jSONArray != null && (length = jSONArray.length()) > 0) {
                this.b.clear();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString = jSONObjectOptJSONObject.optString("icon");
                        if ("emoji".equals(strOptString)) {
                            strOptString = "https://mobads-pre-config.bj.bcebos.com/sdk/dynamicBarrage/bd_barrage_emoji" + (new Random().nextInt(14) + 1) + PictureMimeType.PNG;
                        }
                        this.b.add(new a(context, strOptString, jSONObjectOptJSONObject.optString("text")));
                    }
                }
            }
        }

        public void a(Context context, JSONObject jSONObject) {
            a(context, jSONObject.optJSONArray(e.d));
            if (!this.b.isEmpty()) {
                this.g = bv.a(context, jSONObject.optInt(e.i, 24));
                this.i = bv.a(context, jSONObject.optInt(e.j, 12));
                this.h = bv.a(context, jSONObject.optInt(e.j, 12));
                this.l = bv.a(context, jSONObject.optInt(e.h, 12));
                String strOptString = jSONObject.optString(e.g);
                if (TextUtils.isEmpty(strOptString)) {
                    this.m = -1;
                } else {
                    this.m = Color.parseColor(strOptString);
                }
            }
        }

        public boolean a(Context context, int i, int i2, int i3) {
            this.e = i2;
            this.f = i3;
            if (i3 <= this.g || i2 <= bv.a(context, 80.0f)) {
                return false;
            }
            int i4 = i3 / (this.g + this.h);
            if (i4 == 0) {
                a(1);
                this.h = 0;
            } else if (i > i4) {
                a(i4);
            } else {
                a(i);
            }
            return true;
        }

        public void a(int i) {
            if (i > 0) {
                b();
                for (int i2 = 0; i2 < i; i2++) {
                    this.a.add(new ArrayList<>());
                }
            }
        }

        public void a() {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            this.b.clear();
        }

        public void b() {
            Iterator<ArrayList<c>> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().clear();
            }
            this.a.clear();
        }

        public void a(float f) {
            c cVarA;
            for (int i = 0; i < this.a.size(); i++) {
                ArrayList<c> arrayList = this.a.get(i);
                if (arrayList != null) {
                    c cVar = null;
                    if (arrayList.isEmpty()) {
                        c cVarA2 = a(i, (c) null);
                        if (cVarA2 != null) {
                            arrayList.add(cVarA2);
                            this.n++;
                        }
                    } else {
                        c cVar2 = null;
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            c cVar3 = arrayList.get(i2);
                            cVar3.a(f);
                            if (i2 == 0) {
                                cVar = cVar3;
                            }
                            if (i2 == arrayList.size() - 1) {
                                cVar2 = cVar3;
                            }
                        }
                        if (cVar != null && cVar.c() < 0) {
                            arrayList.remove(cVar);
                            this.n--;
                        }
                        if (cVar2 != null && cVar2.c() <= this.e && (cVarA = a(i, cVar2)) != null) {
                            arrayList.add(cVarA);
                            this.n++;
                        }
                    }
                }
            }
        }

        public int c() {
            return this.n;
        }

        public c a(int i, c cVar) {
            if (!this.k && !this.b.isEmpty()) {
                this.c = (this.c + 1) % this.b.size();
                return a(this.b.get(this.c), cVar == null ? this.e : cVar.c() + this.i, cVar == null ? (this.g * i) + (this.h * (i + 1)) : cVar.d());
            }
            return null;
        }

        private c a(a aVar, int i, int i2) {
            c cVar = new c(aVar);
            cVar.b(this.l, this.m);
            cVar.b(this.g);
            cVar.a(-2);
            cVar.a(this.g + 16, this.g + 16);
            int[] iArrA = this.j.a();
            cVar.c(iArrA[0], iArrA[1]);
            cVar.e();
            cVar.a(i, i2, this.g + i, this.g + i2);
            return cVar;
        }

        public void a(Canvas canvas) {
            if (!this.a.isEmpty()) {
                Iterator<ArrayList<c>> it = this.a.iterator();
                while (it.hasNext()) {
                    ArrayList<c> next = it.next();
                    if (!next.isEmpty()) {
                        Iterator<c> it2 = next.iterator();
                        while (it2.hasNext()) {
                            c next2 = it2.next();
                            if (next2 != null) {
                                next2.a(canvas);
                            }
                        }
                    }
                }
            }
        }

        public int d() {
            return this.c;
        }

        public int e() {
            return this.d;
        }

        public int f() {
            return this.a.size();
        }

        public a b(int i) {
            return null;
        }
    }

    static class d {
        private int b = 0;
        private final int[][] a = {new int[]{Color.parseColor("#99FF6A00"), Color.parseColor("#CCFF3333")}, new int[]{Color.parseColor("#B2FFAC00"), Color.parseColor("#CCFF8100")}, new int[]{Color.parseColor("#CC1EB297"), Color.parseColor("#B224B86C")}, new int[]{Color.parseColor("#CC217AE0"), Color.parseColor("#B21EADC9")}, new int[]{Color.parseColor("#CC891DDB"), Color.parseColor("#B25E54EC")}, new int[]{Color.parseColor("#CCFF1677"), Color.parseColor("#B2D921D9")}};

        d() {
        }

        public int[] a() {
            this.b = (this.b + 1) % this.a.length;
            return this.a[this.b];
        }
    }

    static class a {
        private Bitmap a;
        private final String b;
        private final String c;

        a(Context context, String str, String str2) {
            this.b = str;
            this.c = str2;
            a(context);
        }

        public void a(Context context) {
            if (!TextUtils.isEmpty(this.b)) {
                com.baidu.mobads.container.util.d.d.a(context).a(this.b, (com.baidu.mobads.container.util.d.a) new com.component.a.a.c(this));
            }
        }

        public String a() {
            if (this.c != null && this.c.length() > 13) {
                return this.c.substring(0, 12) + "...";
            }
            return this.c;
        }

        public Bitmap b() {
            return this.a;
        }

        public boolean c() {
            return (TextUtils.isEmpty(this.b) || this.a == null || this.a.isRecycled()) ? false : true;
        }

        public void d() {
            if (this.a != null && !this.a.isRecycled()) {
                this.a.recycle();
            }
        }
    }

    static class c {
        private Bitmap g;
        private String h;
        private final a k;
        private Drawable m;
        public int a = 0;
        public int b = 16;
        public int c = -7829368;
        public int d = -7829368;
        public int e = 0;
        public int f = 0;
        private int i = 12;
        private int j = -16777216;
        private final RectF l = new RectF();
        private final RectF n = new RectF();
        private final Paint o = new Paint();
        private final RectF p = new RectF();
        private final RectF q = new RectF();
        private float r = 0.0f;
        private boolean s = false;

        public c(a aVar) {
            this.k = aVar;
            this.h = aVar.a();
        }

        public void a(int i, int i2) {
            this.f = i;
            this.e = i2;
        }

        public void b(int i, int i2) {
            this.i = i;
            this.j = i2;
        }

        public void a() {
            this.o.setStyle(Paint.Style.FILL_AND_STROKE);
            this.o.setColor(this.j);
            this.o.setTextSize(this.i);
            this.o.setAntiAlias(true);
        }

        public void c(int i, int i2) {
            this.c = i;
            this.d = i2;
        }

        public boolean b() {
            return false;
        }

        public int c() {
            return (int) this.l.right;
        }

        public int d() {
            return (int) this.l.top;
        }

        public void a(int i) {
            this.a = i;
        }

        public void b(int i) {
            this.b = i;
        }

        public void e() {
            a();
            this.s = this.k.c();
            if (this.s) {
                this.h = "  " + this.k.a();
                float fMeasureText = this.o.measureText(this.h);
                this.l.set(0.0f, 0.0f, this.f + fMeasureText + (this.b / 2.0f), this.b);
                this.n.set(0.0f, 0.0f, (this.f / 2.0f) + fMeasureText + (this.b / 2.0f), this.b);
                this.q.set(0.0f, 0.0f, this.f, this.e);
                this.p.set(0.0f, 0.0f, fMeasureText, this.b);
            } else {
                this.h = "  " + this.k.a() + "  ";
                float fMeasureText2 = this.o.measureText(this.h);
                this.l.set(0.0f, 0.0f, this.b + fMeasureText2, this.b);
                this.n.set(0.0f, 0.0f, this.b + fMeasureText2, this.b);
                this.q.set(0.0f, 0.0f, 0.0f, 0.0f);
                this.p.set(0.0f, 0.0f, fMeasureText2, this.b);
            }
            this.a = (int) (this.l.right - this.l.left);
        }

        public void a(int i, int i2, int i3, int i4) {
            float f = i;
            float f2 = i2;
            this.l.offsetTo(f, f2);
            if (this.s) {
                this.n.offsetTo((this.f / 2.0f) + f, f2);
                this.q.offsetTo(f, ((this.b - this.e) / 2.0f) + f2);
                this.p.offsetTo(i + this.f, f2);
            } else {
                this.n.offsetTo(f, f2);
                this.p.offsetTo(f + (this.b / 2.0f), f2);
            }
            this.r = ((f2 + ((this.b + this.i) / 2.0f)) - this.o.descent()) + 3.0f;
            float[] fArr = new float[8];
            float f3 = this.b / 2.0f;
            if (this.s) {
                this.g = Bitmap.createScaledBitmap(this.k.a, this.f, this.e, false);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = f3;
                fArr[3] = f3;
                fArr[4] = f3;
                fArr[5] = f3;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
            } else {
                fArr[0] = f3;
                fArr[1] = f3;
                fArr[2] = f3;
                fArr[3] = f3;
                fArr[4] = f3;
                fArr[5] = f3;
                fArr[6] = f3;
                fArr[7] = f3;
            }
            this.m = com.component.a.i.r.a(0, GradientDrawable.Orientation.LEFT_RIGHT, new int[]{this.c, this.d}, -1, 0, fArr, 1.0f);
        }

        public void a(float f) {
            this.l.offset(f, 0.0f);
            this.n.offset(f, 0.0f);
            this.q.offset(f, 0.0f);
            this.p.offset(f, 0.0f);
            this.m.setBounds((int) this.n.left, (int) this.n.top, (int) this.n.right, (int) this.n.bottom);
        }

        public void a(Canvas canvas) {
            this.m.draw(canvas);
            if (this.s && !this.g.isRecycled()) {
                canvas.drawBitmap(this.g, this.q.left, this.q.top, (Paint) null);
            }
            canvas.drawText(this.h, this.p.left, this.r, this.o);
        }
    }
}
