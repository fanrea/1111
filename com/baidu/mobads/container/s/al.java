package com.baidu.mobads.container.s;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.s.k;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.cf;
import com.baidu.mobads.container.util.d.d;
import com.component.a.g.d;
import com.kuaishou.socket.nano.SocketMessages;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class al extends RelativeLayout {
    public static final int a = 0;
    public static final int b = 1;
    private static final String c = "右";
    private static final String d = "上";
    private static final String e = "滑屏幕";
    private static final String f = "多方向滑动了解更多";
    private static final int g = 20001;
    private static final int h = 20002;
    private static final int i = 20003;
    private static final int j = 300;
    private static final int k = 200;
    private static final int l = 39;
    private int m;
    private int n;
    private int o;
    private Context p;
    private a q;
    private k.b r;
    private AnimatorSet s;
    private ImageView t;
    private View u;
    private int v;
    private int w;
    private Boolean x;

    public interface a {
        void a(View view, boolean z, MotionEvent motionEvent, MotionEvent motionEvent2);
    }

    public al(Context context, k.b bVar, com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar) {
        super(context);
        this.v = -1;
        this.w = -1;
        this.x = false;
        try {
            this.p = context;
            this.r = bVar;
            if (this.p != null && this.r != null) {
                this.q = this.r.h;
                this.m = bv.b(context);
                this.n = bv.a(this.p, this.r.b);
                this.o = bv.a(this.p, this.r.c);
                this.w = bv.a(this.p, this.r.m);
                this.v = bv.a(this.p, this.r.l);
                int i2 = 1;
                if (this.r.p == 1 && b(kVar, jVar)) {
                    a(kVar, jVar);
                } else {
                    c();
                }
                b();
                d();
                if (this.r.p == 1) {
                    i2 = -1;
                } else if (this.r.j != 3) {
                    i2 = 0;
                }
                a(this, this.u, this.q, this.r.i, i2, true, true, -1, this.v, this.w, 0, 0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bv.a(this.p, 300.0f), bv.a(this.p, 200.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = bv.a(this.p, 39.0f);
        addView(new com.component.a.g.d(kVar, jVar).a((ViewGroup) null, com.component.a.i.n.b(com.baidu.mobads.container.u.n.e), (d.c) null), layoutParams);
    }

    private boolean b(com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar) {
        if (com.baidu.mobads.container.util.x.a(null).a() <= 25) {
            return this.x.booleanValue();
        }
        if (kVar != null && jVar != null && com.baidu.mobads.container.util.d.d.a(this.p).b(com.baidu.mobads.container.u.n.g, d.e.COMMON)) {
            this.x = true;
        }
        return this.x.booleanValue();
    }

    public void a(int i2) {
        this.v = i2;
    }

    public void b(int i2) {
        this.w = i2;
    }

    public AnimatorSet a() {
        return this.s;
    }

    public void b() {
        String str;
        LinearLayout linearLayout = new LinearLayout(this.p);
        linearLayout.setId(20001);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        addView(linearLayout, layoutParams);
        TextView textView = new TextView(this.p);
        if (TextUtils.isEmpty(this.r.q)) {
            if (this.r.p == 1 && this.x.booleanValue()) {
                str = f;
            } else if (this.r.j == 3) {
                str = "上滑屏幕";
            } else {
                str = "右滑屏幕";
            }
            textView.setText(str);
        } else {
            String str2 = this.r.q;
            textView.setText(str2.substring(0, Math.min(10, str2.length())));
        }
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        textView.setGravity(17);
        textView.setShadowLayer(10.0f, 3.0f, 3.0f, -2013265920);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        TextView textView2 = new TextView(this.p);
        if (TextUtils.isEmpty(this.r.r)) {
            textView2.setText(e());
        } else {
            String str3 = this.r.r;
            textView2.setText(str3.substring(0, Math.min(10, str3.length())));
        }
        textView2.setTextColor(-1);
        textView2.setTextSize(14.0f);
        textView2.setGravity(17);
        textView2.setShadowLayer(10.0f, 3.0f, 3.0f, -2013265920);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = bv.a(this.p, 8.0f);
        layoutParams2.bottomMargin = bv.a(this.p, 24.0f);
        linearLayout.addView(textView2, layoutParams2);
    }

    private String e() {
        ab.a aVarA = com.baidu.mobads.container.util.ab.a(this.p, this.r.a);
        if (aVarA == ab.a.DEEP_LINK) {
            return "跳转至第三方页面";
        }
        if (aVarA == ab.a.APP_DOWNLOAD) {
            return "下载应用";
        }
        return "跳转至详情页";
    }

    public void c() {
        Bitmap bitmapA;
        Bitmap bitmapB;
        String str;
        int i2;
        int i3;
        int i4;
        AnimatorSet animatorSetA;
        AnimatorSet animatorSetA2;
        int i5 = 0;
        setClipChildren(false);
        RelativeLayout relativeLayout = new RelativeLayout(this.p);
        relativeLayout.setId(20003);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(2, 20001);
        layoutParams.addRule(14);
        addView(relativeLayout, layoutParams);
        if (!TextUtils.isEmpty(this.r.n) && !TextUtils.isEmpty(this.r.o)) {
            bitmapA = com.baidu.mobads.container.util.d.d.a(this.p).e(this.r.n);
            bitmapB = com.baidu.mobads.container.util.d.d.a(this.p).e(this.r.o);
        } else {
            bitmapA = null;
            bitmapB = null;
        }
        this.t = new ImageView(this.p);
        if (this.r.k == 1) {
            str = "ic_slide_arrow_point";
        } else {
            double d2 = this.m;
            Double.isNaN(d2);
            i5 = (int) (d2 * 0.04d);
            str = "ic_slide_arrow_duplicate";
        }
        if (bitmapA == null) {
            bitmapA = com.component.b.a.a().b(str);
        }
        if (this.r.j == 3) {
            double d3 = this.m;
            Double.isNaN(d3);
            i2 = (int) (d3 * 0.09d);
            double d4 = this.m;
            Double.isNaN(d4);
            i3 = (int) (d4 * 0.48d);
            i4 = -60;
        } else {
            bitmapA = cf.a(bitmapA, 90);
            double d5 = this.m;
            Double.isNaN(d5);
            i2 = (int) (d5 * 0.48d);
            double d6 = this.m;
            Double.isNaN(d6);
            i3 = (int) (d6 * 0.09d);
            i4 = 30;
        }
        this.t.setImageBitmap(bitmapA);
        this.t.setVisibility(4);
        this.t.setId(20002);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i3);
        layoutParams2.addRule(10);
        layoutParams2.addRule(14);
        relativeLayout.addView(this.t, layoutParams2);
        ImageView imageView = new ImageView(this.p);
        if (bitmapB == null) {
            bitmapB = com.component.b.a.a().b("ic_white_finger_shadow");
        }
        imageView.setImageBitmap(cf.a(bitmapB, i4));
        imageView.setVisibility(4);
        double d7 = this.m;
        Double.isNaN(d7);
        int i6 = (int) (d7 * 0.24d);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i6, i6);
        if (this.r.j == 3) {
            layoutParams3.addRule(1, 20002);
            layoutParams3.addRule(8, 20002);
            double d8 = -this.m;
            Double.isNaN(d8);
            layoutParams3.leftMargin = ((int) (d8 * 0.08d)) + i5;
            double d9 = -this.m;
            Double.isNaN(d9);
            layoutParams3.bottomMargin = (int) (d9 * 0.08d);
        } else {
            layoutParams3.addRule(3, 20002);
            layoutParams3.addRule(5, 20002);
            double d10 = -this.m;
            Double.isNaN(d10);
            layoutParams3.leftMargin = (int) (d10 * 0.08d);
            double d11 = -this.m;
            Double.isNaN(d11);
            layoutParams3.topMargin = ((int) (d11 * 0.08d)) + i5;
        }
        relativeLayout.addView(imageView, layoutParams3);
        this.s = new AnimatorSet();
        if (this.r.j == 3) {
            animatorSetA = com.baidu.mobads.container.util.animation.j.a(this.t, 600, 80, 2);
            Double.isNaN(-this.m);
            animatorSetA2 = com.baidu.mobads.container.util.animation.j.a(imageView, SocketMessages.PayloadType.SC_LIVE_QUIZ3_SYNC, 300, 0.0f, (int) (r6 * 0.38d), 0.0f, 45.0f);
        } else {
            animatorSetA = com.baidu.mobads.container.util.animation.j.a(this.t, 600, 3, 1);
            Double.isNaN(this.m);
            animatorSetA2 = com.baidu.mobads.container.util.animation.j.a(imageView, SocketMessages.PayloadType.SC_LIVE_QUIZ3_SYNC, 300, (int) (r6 * 0.38d), 0.0f, 0.0f, 45.0f);
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.t, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(400L);
        this.s.play(animatorSetA).with(objectAnimatorOfFloat).before(animatorSetA2);
        cf.a(this.t, new am(this));
    }

    public void d() {
        this.u = new View(this.p);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setAlpha((int) (this.r.f * 255.0f));
        gradientDrawable.setColor(this.r.d);
        float f2 = this.r.g * this.o;
        gradientDrawable.setCornerRadii(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
        this.u.setBackgroundDrawable(gradientDrawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.n, this.o);
        if (this.w == -1 || this.v == -1) {
            layoutParams.addRule(6, 20003);
        } else {
            layoutParams.addRule(12);
        }
        layoutParams.addRule(14);
        layoutParams.topMargin = -com.baidu.mobads.container.util.ab.a(this.p, 10.0f);
        addView(this.u, 0, layoutParams);
    }

    public static void a(ViewGroup viewGroup, View view, a aVar, boolean z, int i2, boolean z2, boolean z3, int i3, int i4, int i5, int i6, int i7) {
        if (viewGroup == null || view == null) {
            return;
        }
        cf.a(viewGroup, new an(viewGroup, view, z, i2, z3, i3, z2, i6, i7, i5, i4, aVar));
    }

    public static void a(ViewGroup viewGroup, View view, a aVar, boolean z, int i2, int i3, boolean z2) {
        a(viewGroup, view, aVar, z, i2, z2, true, i3, -1, -1, 0, 0);
    }

    public void a(RelativeLayout relativeLayout) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        relativeLayout.addView(this, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b extends View {
        private static final int a = 20;
        private static final int b = 5;
        private static final int c = 3;
        private boolean A;
        private a d;
        private final Path e;
        private final Paint f;
        private final int g;
        private final boolean h;
        private final int i;
        private final View j;
        private MotionEvent k;
        private float l;
        private float m;
        private float n;
        private float o;
        private float p;
        private float q;
        private boolean r;
        private boolean s;
        private boolean t;
        private int u;
        private int v;
        private int w;
        private int x;
        private WeakReference<ViewGroup> y;
        private boolean z;

        public b(Context context, View view, boolean z, int i, boolean z2, int i2) {
            super(context);
            this.e = new Path();
            this.f = new Paint();
            this.r = false;
            this.s = false;
            this.t = false;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = 0;
            this.z = false;
            this.A = true;
            this.g = com.baidu.mobads.container.util.ab.a(context, 3.0f);
            this.j = view;
            this.h = z;
            this.i = i;
            this.A = z2;
            setLayerType(1, this.f);
            this.f.setColor(i2);
            this.f.setStyle(Paint.Style.STROKE);
            this.f.setStrokeWidth(20.0f);
            this.f.setStrokeCap(Paint.Cap.ROUND);
            this.f.setShadowLayer(5.0f, 3.0f, 3.0f, -16777216);
        }

        public void a(ViewGroup viewGroup) {
            this.y = new WeakReference<>(viewGroup);
        }

        public void a(boolean z) {
            this.z = z;
        }

        public void a(int i) {
            this.u = i;
        }

        public void b(int i) {
            this.v = i;
        }

        public void c(int i) {
            this.x = i;
        }

        public void d(int i) {
            this.w = i;
        }

        public void a(a aVar) {
            this.d = aVar;
        }

        private boolean a(float f, float f2) {
            if (this.j != null) {
                if (this.x == 0) {
                    int left = this.j.getLeft();
                    return f2 >= ((float) this.j.getTop()) && f2 <= ((float) this.j.getBottom()) && f >= ((float) left) && f <= ((float) this.j.getRight());
                }
                if (this.x == 1) {
                    return Math.sqrt(Math.pow((double) ((this.j.getX() + (((float) this.j.getWidth()) / 2.0f)) - f), 2.0d) + Math.pow((double) ((this.j.getY() + (((float) this.j.getHeight()) / 2.0f)) - f2), 2.0d)) <= ((double) this.w);
                }
            }
            return false;
        }

        private boolean b(float f, float f2) {
            if (this.v == -1 || this.u == -1) {
                return a(f, f2);
            }
            try {
                int height = getHeight();
                int width = getWidth();
                if (f2 < height - this.v) {
                    return false;
                }
                double d = f;
                double d2 = width;
                double d3 = this.u;
                Double.isNaN(d2);
                Double.isNaN(d3);
                if (d < (d2 - d3) / 2.0d) {
                    return false;
                }
                double d4 = this.u;
                Double.isNaN(d2);
                Double.isNaN(d4);
                return d <= (d2 + d4) / 2.0d;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        private boolean a(float f, float f2, float f3, float f4, float f5) {
            return this.i == 0 ? f - f3 > ((float) com.baidu.mobads.container.util.ab.a(getContext(), f5)) : this.i == -1 || f2 - f4 < ((float) (-com.baidu.mobads.container.util.ab.a(getContext(), f5)));
        }

        private void b(boolean z) {
            ViewGroup viewGroup;
            if (this.y != null && this.z && (viewGroup = this.y.get()) != null) {
                viewGroup.requestDisallowInterceptTouchEvent(z);
            }
        }

        @Override // android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (motionEvent != null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    b(true);
                } else if (action == 1) {
                    b(false);
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            try {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                switch (motionEvent.getAction()) {
                    case 0:
                        this.r = false;
                        this.s = false;
                        this.t = false;
                        this.l = x;
                        this.m = y;
                        this.p = x;
                        this.q = y;
                        return true;
                    case 1:
                        if (!this.r) {
                            if (!this.t && (b(x, y) || !this.h)) {
                                if (this.d != null) {
                                    this.d.a(this, true, this.k, motionEvent);
                                }
                            } else if (this.s) {
                                b(motionEvent, x, y);
                            }
                        }
                        a();
                        break;
                    case 2:
                        if (Math.abs(x - this.l) >= this.g || Math.abs(y - this.m) >= this.g) {
                            this.t = true;
                        }
                        if (!this.r) {
                            if (a(x, y) && a(this.p, this.q)) {
                                if (this.s && this.A) {
                                    this.e.quadTo(this.p, this.q, (this.p + x) / 2.0f, (this.q + y) / 2.0f);
                                    invalidate();
                                } else if (!this.s && a(x, y, this.p, this.q, 0.0f)) {
                                    a(motionEvent, x, y);
                                }
                            } else if (a(x, y) && !a(this.p, this.q)) {
                                if (!this.s && a(x, y, this.p, this.q, 0.0f)) {
                                    a(motionEvent, x, y);
                                }
                            } else if (!a(x, y) && a(this.p, this.q) && this.s) {
                                this.r = true;
                                b(motionEvent, x, y);
                            }
                            this.p = x;
                            this.q = y;
                            break;
                        } else {
                            break;
                        }
                        break;
                    case 3:
                        a();
                        break;
                }
            } catch (Throwable th) {
                bq.a().a(th);
            }
            return super.onTouchEvent(motionEvent);
        }

        private void a(MotionEvent motionEvent, float f, float f2) {
            this.s = true;
            this.n = f;
            this.o = f2;
            this.k = MotionEvent.obtainNoHistory(motionEvent);
            if (this.A) {
                this.e.moveTo(f, f2);
                invalidate();
            }
        }

        private void b(MotionEvent motionEvent, float f, float f2) {
            if (this.d != null && a(f, f2, this.n, this.o, 20.0f)) {
                this.d.a(this, false, this.k, MotionEvent.obtainNoHistory(motionEvent));
            }
        }

        private void a() {
            if (this.A) {
                this.e.reset();
                invalidate();
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.A) {
                canvas.drawPath(this.e, this.f);
            }
        }
    }
}
