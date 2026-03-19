package com.component.a.a;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.x;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends com.component.a.d.c implements ValueAnimator.AnimatorUpdateListener, Runnable {
    private final int a;
    private final int b;
    private final int d;
    private final int e;
    private final float f;
    private final String g;
    private final Paint h;
    private final Paint i;
    private JSONArray j;
    private String[] k;
    private float[] l;
    private int m;
    private int n;
    private volatile int o;
    private boolean p;
    private ValueAnimator q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;

    public a(Context context, com.component.a.f.e eVar) {
        super(context, eVar);
        this.a = 4;
        this.b = 200;
        this.d = 1000;
        this.e = 6;
        this.f = 0.75f;
        this.g = "[\"居然还可以这么玩\",\"家人们关注起来\",\"这次一定\",\"富贵让我们相遇\",\"点赞666\",\"关注了该资讯\",\"这个看起来还不错\",\"助力每一个梦想\",\"求关注求关注求关注\",\"点进去高能预警\",\"居然这么多人在看\",\"画风突变\",\"没错你卡了\",\"我来证明你开了弹幕\",\"注入灵魂了\",\"老铁双击666\",\"这是彩蛋吗？\",\"送你上热门\",\"这个弹幕有亿点点神奇\",\"试试可不可以双击666\"]";
        this.h = new Paint();
        this.i = new Paint();
        this.m = 0;
        this.n = 0;
        this.o = -1;
        this.p = true;
        this.r = 0;
        this.s = 0;
        a(context, eVar);
    }

    public void a(JSONArray jSONArray) {
        this.j = jSONArray;
    }

    public void a() {
        if (this.o > -1) {
            this.o = 1;
            postDelayed(this, 1000L);
        }
    }

    public void b() {
        if (this.o == 0) {
            this.o = 1;
            postDelayed(this, 1000L);
        }
    }

    public void c() {
        if (this.o > -1) {
            this.o = 0;
            removeCallbacks(this);
        }
    }

    public void d() {
        this.o = -1;
        removeCallbacks(this);
        this.r = 0;
        this.m = 0;
        this.n = 0;
    }

    @Override // com.component.a.d.c, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.component.a.d.c, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // com.component.a.d.c, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            a();
        } else {
            c();
        }
    }

    @Override // com.component.a.d.c, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            b();
        } else {
            c();
        }
    }

    @Override // com.component.a.d.c, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.s = (i4 - i2) / 4;
        if (this.s > 50) {
            this.t = i3 - i;
            this.u = this.s - bv.a(getContext(), 6.0f);
            this.v = this.u / 2;
            this.i.setTextSize(this.u * 0.75f);
            g();
            e();
        }
    }

    @Override // com.component.a.d.c, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.k != null && this.k.length > 0) {
            for (int i = 0; i < this.m; i++) {
                a(canvas, (4 - this.m) + i, (this.n + i) % this.k.length);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.o == 1) {
            if (this.m < 4) {
                this.m++;
            } else if (this.n < this.k.length - 1) {
                this.n++;
            } else {
                this.n = 0;
            }
            if (this.p) {
                f();
            } else {
                invalidate();
            }
            postDelayed(this, 1000L);
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.r = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        invalidate();
    }

    private void a(Context context, com.component.a.f.e eVar) {
        this.h.setStyle(Paint.Style.FILL);
        this.h.setColor(-16777216);
        this.h.setAntiAlias(true);
        this.i.setStyle(Paint.Style.FILL_AND_STROKE);
        this.i.setColor(-1);
        this.i.setAntiAlias(true);
        this.p = x.a(context).a() >= 26;
        a(eVar.o(""));
    }

    private void a(String str) {
        try {
            JSONArray jSONArrayB = b(str);
            if (jSONArrayB != null) {
                a(jSONArrayB);
            } else {
                a(b("[\"居然还可以这么玩\",\"家人们关注起来\",\"这次一定\",\"富贵让我们相遇\",\"点赞666\",\"关注了该资讯\",\"这个看起来还不错\",\"助力每一个梦想\",\"求关注求关注求关注\",\"点进去高能预警\",\"居然这么多人在看\",\"画风突变\",\"没错你卡了\",\"我来证明你开了弹幕\",\"注入灵魂了\",\"老铁双击666\",\"这是彩蛋吗？\",\"送你上热门\",\"这个弹幕有亿点点神奇\",\"试试可不可以双击666\"]"));
            }
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    private void e() {
        this.q = ValueAnimator.ofInt(this.s, 0);
        this.q.addUpdateListener(this);
        this.q.setInterpolator(new AccelerateDecelerateInterpolator());
        this.q.setDuration(200L);
        this.q.setRepeatCount(0);
    }

    private void f() {
        if (this.q != null) {
            this.q.start();
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        RectF rectFA = a(i, this.l[i2]);
        this.h.setAlpha(b(i));
        canvas.drawRoundRect(rectFA, this.v, this.v, this.h);
        this.i.setAlpha(c(i));
        canvas.drawText(this.k[i2], rectFA.left + this.v, rectFA.bottom - (this.u * 0.25f), this.i);
    }

    private JSONArray b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    return jSONArray;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            bq.a().a(th);
            return null;
        }
    }

    private void g() {
        if (this.j != null) {
            this.o = 0;
            int length = this.j.length();
            this.k = new String[length];
            this.l = new float[length];
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    this.k[i] = c(this.j.optString(i));
                    float fMeasureText = this.i.measureText(this.k[i]) + this.u;
                    if (fMeasureText < this.t) {
                        this.l[i] = fMeasureText;
                    } else {
                        this.l[i] = this.t;
                    }
                }
            }
        }
    }

    private String c(String str) {
        String strTrim = str.trim();
        float f = this.t - this.u;
        if (!TextUtils.isEmpty(strTrim) && f > 0.0f) {
            int iBreakText = this.i.breakText(strTrim, true, f, null);
            return (iBreakText >= strTrim.length() || iBreakText <= 0) ? strTrim : strTrim.substring(0, iBreakText - 2) + "...";
        }
        return "";
    }

    private RectF a(int i, float f) {
        float f2 = (i * this.s) + this.r;
        return new RectF(0.0f, f2, f, this.u + f2);
    }

    private int b(int i) {
        if (i == 0) {
            return (this.r * 76) / this.s;
        }
        if (1 == i) {
            return ((this.r * 38) / this.s) + 76;
        }
        if (2 == i) {
            return ((this.r * 12) / this.s) + 114;
        }
        if (3 == i) {
            return 127 - ((this.r * 127) / this.s);
        }
        return 0;
    }

    private int c(int i) {
        if (i == 0) {
            return (this.r * 153) / this.s;
        }
        if (1 == i) {
            return ((this.r * 63) / this.s) + 153;
        }
        if (2 == i) {
            return ((this.r * 39) / this.s) + 216;
        }
        if (3 == i) {
            return 255 - ((this.r * 255) / this.s);
        }
        return 0;
    }
}
