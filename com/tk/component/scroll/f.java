package com.tk.component.scroll;

import android.R;
import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.kwad.yoga.YogaEdge;
import com.tk.core.component.view.TKView;
import com.tk.core.o.k;
import com.tk.core.o.o;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f {
    private View VA;
    private Map<View, View.OnFocusChangeListener> VC;
    private Map<View, View.OnFocusChangeListener> VD;
    private float VH;
    private int VI;
    private final Activity Vu;
    private final c Vv;
    private final TKView Vw;
    private View Vx;
    private int Vy;
    private int Vz;
    private final com.tk.core.bridge.b mTKJSContext;
    private ViewTreeObserver.OnGlobalLayoutListener ml;
    private Rect nw;
    private boolean VB = false;
    private boolean VE = false;
    private int VF = -1;
    private int VG = -1;
    private boolean mIsDestroy = false;
    private float VJ = 0.0f;
    private float VK = 0.0f;

    public f(Activity activity, c cVar, TKView tKView, com.tk.core.bridge.b bVar) {
        this.Vu = activity;
        this.Vv = cVar;
        this.Vw = tKView;
        this.mTKJSContext = bVar;
        ae();
    }

    private void ae() {
        this.Vx = ((FrameLayout) this.Vu.findViewById(R.id.content)).getChildAt(0);
        View view = this.Vx;
        if (view == null) {
            return;
        }
        this.Vy = view.getMeasuredHeight();
        if (this.ml == null) {
            this.ml = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tk.component.scroll.f.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    if (f.this.Vy <= 0) {
                        f fVar = f.this;
                        fVar.Vy = fVar.Vx.getMeasuredHeight();
                        com.tk.core.i.a.z("VerticalScrollerViewSoftInputHelper", "get rootView height onGlobalLayout: " + f.this.Vy);
                    }
                    try {
                        f.this.nU();
                    } catch (Throwable th) {
                        com.tk.core.exception.a.a(f.this.Vv.pO(), th);
                    }
                }
            };
        }
        this.Vx.getViewTreeObserver().addOnGlobalLayoutListener(this.ml);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nU() {
        if (this.mIsDestroy) {
            return;
        }
        nZ();
        if (this.VF < 0) {
            this.VF = o.sN();
        }
        if (this.VG < 0) {
            this.VG = k.P(this.Vu);
        }
        if (this.VC == null) {
            this.VC = new HashMap();
        }
        if (this.VD == null) {
            this.VD = new HashMap();
        }
        this.Vx.getWindowVisibleDisplayFrame(nV());
        int i = this.nw.bottom - this.nw.top;
        int height = (this.Vu.getWindow().getDecorView().getHeight() - this.VF) - this.VG;
        int i2 = height - i;
        if (i2 < 0) {
            height = (this.Vu.getWindow().getDecorView().getWidth() - this.VF) - this.VG;
            i2 = height - i;
        }
        if (i2 > height / 4) {
            aN(i, i2);
        } else {
            dh(i);
        }
    }

    private void dh(int i) {
        if (this.Vz == i || !this.VE) {
            return;
        }
        this.Vz = i;
        this.VE = false;
        this.VB = false;
        nY();
        this.Vx.getLayoutParams().height = this.Vy;
        float f = this.VK;
        if (f == 0.0f) {
            f = 1.0f;
        }
        this.Vw.pR().getYogaNode().setPadding(YogaEdge.BOTTOM, this.VH * f);
        this.Vw.getView().requestLayout();
    }

    private void aN(int i, int i2) {
        final View viewFindFocus = this.Vx.findFocus();
        if ((viewFindFocus instanceof EditText) && aK(viewFindFocus)) {
            if (i == this.Vz && this.VA == viewFindFocus) {
                return;
            }
            if (this.VE && this.VA == viewFindFocus && Math.abs(this.VI - i2) < this.VI / 4) {
                this.VI = i2;
                return;
            }
            this.VA = viewFindFocus;
            this.Vz = i;
            this.VI = i2;
            this.VE = true;
            View.OnFocusChangeListener onFocusChangeListener = viewFindFocus.getOnFocusChangeListener();
            View.OnFocusChangeListener onFocusChangeListener2 = this.VD.get(viewFindFocus);
            if (onFocusChangeListener == null) {
                this.VC.remove(viewFindFocus);
            } else if (onFocusChangeListener != onFocusChangeListener2) {
                this.VC.put(viewFindFocus, onFocusChangeListener);
            }
            if (onFocusChangeListener2 == null) {
                View.OnFocusChangeListener onFocusChangeListener3 = new View.OnFocusChangeListener() { // from class: com.tk.component.scroll.f.2
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view, boolean z) {
                        if (f.this.mIsDestroy) {
                            return;
                        }
                        View.OnFocusChangeListener onFocusChangeListener4 = (View.OnFocusChangeListener) f.this.VC.get(viewFindFocus);
                        if (onFocusChangeListener4 != null && onFocusChangeListener4 != this) {
                            try {
                                onFocusChangeListener4.onFocusChange(view, z);
                            } catch (Throwable th) {
                                com.tk.core.exception.a.a(f.this.mTKJSContext, th);
                            }
                        }
                        f.this.Vx.postDelayed(new Runnable() { // from class: com.tk.component.scroll.f.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    f.this.nU();
                                } catch (Throwable th2) {
                                    com.tk.core.exception.a.a(f.this.Vv.pO(), th2);
                                }
                            }
                        }, 150L);
                    }
                };
                this.VD.put(viewFindFocus, onFocusChangeListener3);
                viewFindFocus.setOnFocusChangeListener(onFocusChangeListener3);
            }
            final int i3 = this.VF + (i / 2);
            int[] iArr = new int[2];
            viewFindFocus.getLocationOnScreen(iArr);
            int i4 = iArr[1];
            final float f = this.VK;
            if (f == 0.0f) {
                f = 1.0f;
            }
            float f2 = (i4 - i3) * f;
            this.Vx.getLayoutParams().height = this.Vy;
            if (!this.VB) {
                this.VH = nW();
            }
            this.Vw.pR().getYogaNode().setPadding(YogaEdge.BOTTOM, (i2 + this.VH) * f);
            this.VB = true;
            this.Vw.getView().requestLayout();
            this.Vv.smoothScrollBy(iArr[0], (int) f2);
            this.Vx.post(new Runnable() { // from class: com.tk.component.scroll.f.3
                @Override // java.lang.Runnable
                public final void run() {
                    int[] iArr2 = new int[2];
                    viewFindFocus.getLocationOnScreen(iArr2);
                    f.this.Vv.smoothScrollBy(iArr2[0], (int) ((iArr2[1] - i3) * f));
                }
            });
        }
    }

    private Rect nV() {
        if (this.nw == null) {
            this.nw = new Rect();
        }
        return this.nw;
    }

    private static boolean aK(View view) {
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof e) {
                return true;
            }
        }
        return false;
    }

    private float nW() {
        float f = this.Vw.pR().getYogaNode().getPadding(YogaEdge.BOTTOM).value;
        if (Float.isNaN(f)) {
            return 0.0f;
        }
        return f;
    }

    private void nX() {
        View view;
        if (this.ml == null || (view = this.Vx) == null) {
            return;
        }
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.ml);
    }

    private void nY() {
        Map<View, View.OnFocusChangeListener> map = this.VC;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<View, View.OnFocusChangeListener> entry : this.VC.entrySet()) {
                if (entry != null) {
                    View key = entry.getKey();
                    View.OnFocusChangeListener value = entry.getValue();
                    if (key != null && value != null) {
                        key.setOnFocusChangeListener(value);
                    }
                }
            }
            this.VC.clear();
        }
        Map<View, View.OnFocusChangeListener> map2 = this.VD;
        if (map2 != null) {
            map2.clear();
        }
    }

    private void nZ() {
        if (this.VJ == 0.0f || this.VK == 0.0f) {
            Matrix matrix = new Matrix();
            Matrix matrix2 = new Matrix();
            Object parent = this.Vw.getView().getParent();
            while (parent instanceof View) {
                View view = (View) parent;
                view.getMatrix().invert(matrix2);
                matrix.setConcat(matrix, matrix2);
                parent = view.getParent();
            }
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            float f = fArr[0];
            float f2 = fArr[4];
            if (f != 1.0f || f2 != 1.0f) {
                this.VJ = f;
                this.VK = f2;
            } else {
                this.VJ = 1.0f;
                this.VK = 1.0f;
            }
        }
    }

    public final void destroy() {
        this.mIsDestroy = true;
        nX();
        nY();
        this.Vx = null;
    }
}
