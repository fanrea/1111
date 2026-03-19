package com.component.a.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    private static final String a = b.class.getSimpleName();
    private ViewGroup b;

    public interface c {
        C0314b a();
    }

    public b(ViewGroup viewGroup) {
        if (viewGroup != null) {
            this.b = viewGroup;
            f.a(viewGroup.getContext());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(int i, int i2) {
        if (this.b == null) {
            return;
        }
        b("adjusting %s ---> w_spec: %s h_spec: %s", this.b, View.MeasureSpec.toString(i), View.MeasureSpec.toString(i2));
        int size = (View.MeasureSpec.getSize(i) - this.b.getPaddingLeft()) - this.b.getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i2) - this.b.getPaddingTop()) - this.b.getPaddingBottom();
        int childCount = this.b.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.b.getChildAt(i3);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            b("adjusting %s for %s", childAt, layoutParams);
            if (layoutParams instanceof c) {
                C0314b c0314bA = ((c) layoutParams).a();
                b("adjust using %s", c0314bA);
                if (c0314bA != null) {
                    a(size, size2, childAt, c0314bA);
                    c0314bA.a(layoutParams, size, size2);
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        c0314bA.a(childAt, (ViewGroup.MarginLayoutParams) layoutParams, size, size2);
                    }
                }
            }
        }
    }

    public void a(int i, int i2, View view, C0314b c0314b) {
        float fC;
        float f = c0314b.v;
        float f2 = c0314b.x;
        float f3 = c0314b.w;
        if (f != -1.0f) {
            fC = i * f;
        } else if (f2 != -1.0f) {
            fC = i2 * f2;
        } else if (f3 == -1.0f) {
            fC = 0.0f;
        } else {
            fC = com.component.a.i.a.c(view.getContext()) * f3;
        }
        if (fC != 0.0f && (view instanceof TextView)) {
            ((TextView) view).setTextSize(0, fC);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        if (this.b == null) {
            return;
        }
        int childCount = this.b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.b.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            b("need restore %s %s", childAt, layoutParams);
            if (layoutParams instanceof c) {
                C0314b c0314bA = ((c) layoutParams).a();
                b("restore using %s", c0314bA);
                if (c0314bA != null) {
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        c0314bA.a((ViewGroup.MarginLayoutParams) layoutParams);
                    } else {
                        c0314bA.a(layoutParams);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean b() {
        C0314b c0314bA;
        if (this.b == null) {
            return false;
        }
        int childCount = this.b.getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = this.b.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            b("check if child view [%s] needs more space..", childAt);
            if ((layoutParams instanceof c) && (c0314bA = ((c) layoutParams).a()) != null) {
                if (a(childAt, c0314bA)) {
                    layoutParams.width = -2;
                    z = true;
                }
                if (b(childAt, c0314bA)) {
                    layoutParams.height = -2;
                    z = true;
                }
            }
        }
        b("result: " + (z ? "" : "not ") + "need second measure", new Object[0]);
        return z;
    }

    private static boolean a(View view, C0314b c0314b) {
        return (view.getMeasuredWidthAndState() & (-16777216)) == 16777216 && c0314b.a >= 0.0f && c0314b.y.width == -2;
    }

    private static boolean b(View view, C0314b c0314b) {
        return (view.getMeasuredHeightAndState() & (-16777216)) == 16777216 && c0314b.b >= 0.0f && c0314b.y.height == -2;
    }

    static class d extends ViewGroup.MarginLayoutParams {
        private boolean a;
        private boolean b;

        public d(int i, int i2) {
            super(i, i2);
        }
    }

    /* renamed from: com.component.a.d.b$b, reason: collision with other inner class name */
    public static class C0314b {
        public float u;
        public float a = -1.0f;
        public float b = -1.0f;
        public float c = -1.0f;
        public float d = -1.0f;
        public float e = -1.0f;
        public float f = -1.0f;
        public float g = -1.0f;
        public float h = -1.0f;
        public float i = -1.0f;
        public float j = -1.0f;
        public float k = -1.0f;
        public float l = -1.0f;
        public float m = -1.0f;
        public float n = -1.0f;
        public float o = -1.0f;
        public float p = -1.0f;
        public float q = -1.0f;
        public float r = -1.0f;
        public float s = -1.0f;
        public float t = -1.0f;
        public float v = -1.0f;
        public float x = -1.0f;
        public float w = -1.0f;
        final d y = new d(0, 0);

        public void a(ViewGroup.LayoutParams layoutParams, int i, int i2) {
            this.y.width = layoutParams.width;
            this.y.height = layoutParams.height;
            boolean z = (this.y.b || this.y.width == 0) && this.a < 0.0f;
            boolean z2 = (this.y.a || this.y.height == 0) && this.b < 0.0f;
            if (this.a >= 0.0f) {
                layoutParams.width = Math.round(i * this.a);
            }
            if (this.b >= 0.0f) {
                layoutParams.height = Math.round(i2 * this.b);
            }
            if (this.u > 1.0E-4d) {
                if (z) {
                    layoutParams.width = Math.round(layoutParams.height * this.u);
                    this.y.b = true;
                }
                if (z2) {
                    layoutParams.height = Math.round(layoutParams.width / this.u);
                    this.y.a = true;
                }
            }
            b.b("fill result: [w:%d, h:%d]", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        }

        public void a(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
            boolean z;
            this.y.leftMargin = marginLayoutParams.leftMargin;
            this.y.topMargin = marginLayoutParams.topMargin;
            this.y.rightMargin = marginLayoutParams.rightMargin;
            this.y.bottomMargin = marginLayoutParams.bottomMargin;
            f.a(this.y, f.a(marginLayoutParams));
            f.b(this.y, f.b(marginLayoutParams));
            int iC = com.component.a.i.a.c(view.getContext());
            int iD = com.component.a.i.a.d(view.getContext());
            if (this.c >= 0.0f) {
                marginLayoutParams.leftMargin = Math.round(i * this.c);
            } else if (this.d >= 0.0f) {
                marginLayoutParams.leftMargin = Math.round(i2 * this.d);
            } else if (this.e >= 0.0f) {
                marginLayoutParams.leftMargin = Math.round(iC * this.e);
            } else if (this.f >= 0.0f) {
                marginLayoutParams.leftMargin = Math.round(iD * this.f);
            }
            if (this.g >= 0.0f) {
                marginLayoutParams.topMargin = Math.round(i * this.g);
            } else if (this.h >= 0.0f) {
                marginLayoutParams.topMargin = Math.round(i2 * this.h);
            } else if (this.i >= 0.0f) {
                marginLayoutParams.topMargin = Math.round(iC * this.i);
            } else if (this.j >= 0.0f) {
                marginLayoutParams.topMargin = Math.round(iD * this.j);
            }
            if (this.k >= 0.0f) {
                marginLayoutParams.rightMargin = Math.round(i * this.k);
            } else if (this.l >= 0.0f) {
                marginLayoutParams.rightMargin = Math.round(i2 * this.l);
            } else if (this.m >= 0.0f) {
                marginLayoutParams.rightMargin = Math.round(iC * this.m);
            } else if (this.n >= 0.0f) {
                marginLayoutParams.rightMargin = Math.round(iD * this.n);
            }
            if (this.o >= 0.0f) {
                marginLayoutParams.bottomMargin = Math.round(i * this.o);
            } else if (this.p >= 0.0f) {
                marginLayoutParams.bottomMargin = Math.round(i2 * this.p);
            } else if (this.q >= 0.0f) {
                marginLayoutParams.bottomMargin = Math.round(iC * this.q);
            } else if (this.r >= 0.0f) {
                marginLayoutParams.bottomMargin = Math.round(iD * this.r);
            }
            if (this.s < 0.0f) {
                z = false;
            } else {
                f.a(marginLayoutParams, Math.round(i * this.s));
                z = true;
            }
            if (this.t >= 0.0f) {
                f.b(marginLayoutParams, Math.round(i * this.t));
                z = true;
            }
            if (z) {
                f.c(marginLayoutParams, f.a(view));
            }
            b.b("fill(margin) result: [w:%d, h:%d]", Integer.valueOf(marginLayoutParams.width), Integer.valueOf(marginLayoutParams.height));
        }

        public String toString() {
            return String.format(Locale.getDefault(), "JsonLayoutInfo size:[w: %f, h %f], margins:[%f, %f,  %f, %f, %f, %f], aspect:[%f]", Float.valueOf(this.a), Float.valueOf(this.b), Float.valueOf(this.c), Float.valueOf(this.h), Float.valueOf(this.k), Float.valueOf(this.p), Float.valueOf(this.s), Float.valueOf(this.t), Float.valueOf(this.u));
        }

        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            a((ViewGroup.LayoutParams) marginLayoutParams);
            marginLayoutParams.leftMargin = this.y.leftMargin;
            marginLayoutParams.topMargin = this.y.topMargin;
            marginLayoutParams.rightMargin = this.y.rightMargin;
            marginLayoutParams.bottomMargin = this.y.bottomMargin;
            f.a(marginLayoutParams, f.a(this.y));
            f.b(marginLayoutParams, f.b(this.y));
        }

        public void a(ViewGroup.LayoutParams layoutParams) {
            if (!this.y.b) {
                layoutParams.width = this.y.width;
            }
            if (!this.y.a) {
                layoutParams.height = this.y.height;
            }
            this.y.b = false;
            this.y.a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, Object... objArr) {
    }

    public static class a {
        public int a;
        public int b;

        public static void a(a aVar, float f, ViewGroup.LayoutParams layoutParams, int i, int i2) {
            if (f <= 0.0f || layoutParams == null) {
                return;
            }
            if (a(layoutParams.height)) {
                aVar.b = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(aVar.a) - i) / f) + i2), aVar.b), 1073741824);
            } else if (a(layoutParams.width)) {
                aVar.a = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(aVar.b) - i2) * f) + i), aVar.a), 1073741824);
            }
        }

        private static boolean a(int i) {
            return i == 0 || i == -2;
        }
    }
}
