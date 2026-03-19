package com.qq.e.comm.plugin;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.Stack;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class or {
    private static final int h = zu.a(r1.d().f().a("nuiosl", 50));
    private static final String[] i = r1.d().f().b("nuaicl", "com.facebook.drawee.view.SimpleDraweeView").split(",");
    private static final String[] j = r1.d().f().b("nuaipcl", "").split(",");
    private final fr a;
    private final f5 b;
    private com.qq.e.comm.plugin.nativeadunified.c c;
    private nr d;
    private View e;
    private View f;
    private boolean g;

    public or(fr frVar, com.qq.e.comm.plugin.nativeadunified.c cVar, f5 f5Var) {
        this.a = frVar;
        this.b = f5Var;
        this.c = cVar;
        b10.a(1060037, f5Var, 1);
    }

    private boolean g(View view) {
        FrameLayout frameLayoutH;
        if (view == null || (frameLayoutH = h(view)) == null) {
            return false;
        }
        nr nrVar = this.d;
        if (nrVar == null) {
            nr nrVar2 = new nr(view.getContext(), this.a, this.c);
            this.d = nrVar2;
            nrVar2.s();
            this.e = this.d.r();
            boolean z = jr.a;
        } else {
            nrVar.p();
        }
        boolean z2 = jr.a;
        this.d.a(frameLayoutH);
        return true;
    }

    public void e(View view) {
        if (this.g) {
            return;
        }
        View viewC = c(view);
        if (g(viewC)) {
            this.f = viewC;
            b10.a(1060037, this.b, 3);
        } else {
            b10.a(1060037, this.b, 4);
        }
    }

    public void f(View view) {
        if (this.g) {
            return;
        }
        int i2 = this.d == null ? 0 : 1;
        View viewC = c(view);
        if (viewC != null && viewC != this.f) {
            if (g(viewC)) {
                this.f = viewC;
                b10.a(1060037, this.b, 5);
            } else {
                b10.a(1060037, this.b, 6);
            }
            i2 = 2;
        }
        fr frVar = this.a;
        if (frVar != null) {
            frVar.h(3);
        }
        b10.a(1060035, this.b, Integer.valueOf(i2));
    }

    private FrameLayout h(View view) {
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int iIndexOfChild = viewGroup.indexOfChild(view);
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            frameLayout.setLayoutParams(layoutParams);
        }
        viewGroup.removeView(view);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(view.getElevation());
        }
        frameLayout.addView(view);
        viewGroup.addView(frameLayout, iIndexOfChild);
        return frameLayout;
    }

    private View c(View view) {
        b10.a(1060037, this.b, 2);
        Stack stack = new Stack();
        stack.push(view);
        int i2 = 0;
        View view2 = null;
        while (!stack.isEmpty()) {
            View view3 = (View) stack.pop();
            if (d(view3) && a(view3)) {
                int width = view3.getWidth();
                int height = view3.getHeight();
                int i3 = width * height;
                if (Math.min(width, height) >= h && i3 > i2) {
                    view2 = view3;
                    i2 = i3;
                }
            }
            if ((view3 instanceof ViewGroup) && view3 != this.e) {
                ViewGroup viewGroup = (ViewGroup) view3;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    stack.push(viewGroup.getChildAt(childCount));
                }
            }
        }
        if (view2 == null || !b(view2)) {
            return null;
        }
        return view2;
    }

    private boolean d(View view) {
        if (view == null) {
            return false;
        }
        if (view instanceof ImageView) {
            return true;
        }
        try {
            for (String str : i) {
                if (view.getClass().getName().equals(str)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private boolean a(View view) {
        return view.getVisibility() == 0 && view.getAlpha() == 1.0f;
    }

    private boolean b(View view) throws JSONException {
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            return false;
        }
        if (!(parent instanceof FrameLayout) && !(parent instanceof LinearLayout)) {
            ja jaVar = new ja();
            jaVar.a("msg", parent.getClass().getName());
            b10.a(1060036, this.b, 0, null, jaVar);
            try {
                for (String str : j) {
                    if (parent.getClass().getName().equals(str)) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
            return false;
        }
        b10.a(1060036, this.b, 1, null, null);
        return true;
    }

    public void c() {
        if (this.g) {
            return;
        }
        if (this.d != null) {
            boolean z = jr.a;
            this.d.p();
            b10.a(1060037, this.b, 7);
        }
        this.f = null;
    }

    public void a() {
        nr nrVar = this.d;
        if (nrVar != null) {
            nrVar.p();
            this.d.destroy();
        }
        this.f = null;
        this.e = null;
        this.c = null;
    }

    public nr b() {
        return this.d;
    }

    public static boolean a(String str) {
        return xc.a("naspp", 0, tc.a(str)) == 0;
    }

    public void a(boolean z) {
        this.g = z;
    }
}
