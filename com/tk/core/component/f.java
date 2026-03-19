package com.tk.core.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tk.core.o.ab;
import com.tk.core.o.k;
import com.tk.core.o.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class f extends com.tk.core.p.a.a {
    private int VF;
    private int VG;
    private GestureDetector aaf;
    private boolean abr;
    private boolean abs;
    private WeakReference<Context> abt;
    private int abu;
    private b abv;
    private c abw;
    private a abx;
    private boolean aby;
    private com.tk.core.g.a abz;
    private boolean mIsDestroy;
    private com.tk.core.bridge.b mTKJSContext;
    private boolean sT;

    public interface b {
        boolean dispatchTouchEvent(MotionEvent motionEvent);
    }

    public interface c {
        void b(String str, HashMap map);
    }

    public f(Context context) {
        super(context);
        this.abu = 0;
        this.VF = -1;
        this.VG = -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        k(motionEvent);
        b bVar = this.abv;
        if (bVar != null) {
            return bVar.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void k(MotionEvent motionEvent) {
        if (!qA() || this.abu == 0) {
            return;
        }
        if (this.aaf == null) {
            qz();
        }
        GestureDetector gestureDetector = this.aaf;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
    }

    public final void a(b bVar) {
        this.abv = bVar;
    }

    public final void qy() {
        this.abv = null;
    }

    public void setKeyboardDismissMode(int i) {
        this.abu = i;
        if (this.abu != 0) {
            qz();
        }
    }

    private void qz() {
        if (qA() && this.aaf == null) {
            this.aaf = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.tk.core.component.f.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public final boolean onDown(MotionEvent motionEvent) {
                    if (f.this.abu == 1) {
                        f.this.l(motionEvent);
                    }
                    return super.onDown(motionEvent);
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public final boolean onSingleTapUp(MotionEvent motionEvent) {
                    if (f.this.abu == 2) {
                        f.this.l(motionEvent);
                    }
                    return super.onSingleTapUp(motionEvent);
                }
            });
        }
    }

    final void l(MotionEvent motionEvent) {
        View viewR;
        try {
            if (this.abs) {
                viewR = findFocus();
            } else {
                viewR = com.tk.core.o.g.R(getRealContext());
            }
            if (viewR == null || ab.a(motionEvent.getX(), motionEvent.getY(), this)) {
                return;
            }
            com.tk.core.o.g.bh(viewR);
        } catch (Exception e) {
            com.tk.core.exception.a.a(this.mTKJSContext, e);
        }
    }

    public void setInDialog(boolean z) {
        this.abs = z;
    }

    public final void a(boolean z, com.tk.core.g.a aVar, com.tk.core.bridge.b bVar) {
        this.abr = z;
        this.abz = aVar;
        this.mTKJSContext = bVar;
        if (this.abu != 0) {
            qz();
        }
    }

    private boolean qA() {
        return this.abr;
    }

    public void setRealContext(Context context) {
        WeakReference<Context> weakReference = this.abt;
        if (weakReference != null) {
            if (weakReference.get() == context) {
                return;
            } else {
                a(this.abt);
            }
        }
        if (context == null) {
            this.abt = null;
        } else {
            this.abt = new WeakReference<>(context);
        }
    }

    private Context getRealContext() {
        WeakReference<Context> weakReference = this.abt;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context qB() {
        Context realContext = getRealContext();
        return realContext != null ? realContext : getContext();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        com.tk.core.g.a aVar;
        super.onAttachedToWindow();
        this.sT = true;
        if (!qA() || this.abs || this.aby || (aVar = this.abz) == null || !aVar.rO()) {
            return;
        }
        qD();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.sT = false;
        if (qA()) {
            qE();
        }
    }

    public final void onDestroy() {
        this.mIsDestroy = true;
        WeakReference<Context> weakReference = this.abt;
        if (weakReference != null) {
            a(weakReference);
            this.abt = null;
        }
        if (this.mTKJSContext != null) {
            this.mTKJSContext = null;
        }
        if (qA()) {
            qE();
        }
    }

    private static void a(WeakReference weakReference) {
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    public final void qC() {
        if (qA() && this.sT && !this.aby) {
            qD();
        }
    }

    private void qD() {
        qE();
        if (this.abx == null) {
            this.abx = new a();
        }
        getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.abx);
        this.aby = true;
    }

    public final void qE() {
        getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.abx);
        this.aby = false;
    }

    public void setKeyboardEventListener(c cVar) {
        this.abw = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getDecorView() {
        if (getContext() instanceof Activity) {
            return ((Activity) getContext()).getWindow().getDecorView();
        }
        WeakReference<Context> weakReference = this.abt;
        if (weakReference != null) {
            Context context = weakReference.get();
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return getRootView();
    }

    final void a(String str, HashMap map) {
        c cVar = this.abw;
        if (cVar != null) {
            cVar.b(str, map);
        }
    }

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        private Rect abB;
        private int VI = 0;
        private final int abC = o.eb(60);

        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            try {
                qF();
            } catch (Throwable th) {
                com.tk.core.exception.a.a(f.this.mTKJSContext, th);
            }
        }

        private Rect getRect() {
            if (this.abB == null) {
                this.abB = new Rect();
            }
            return this.abB;
        }

        private void qF() {
            if (f.this.mIsDestroy) {
                return;
            }
            if (f.this.VF < 0) {
                f.this.VF = o.sN();
            }
            if (f.this.VG < 0) {
                f fVar = f.this;
                fVar.VG = k.P(fVar.qB());
            }
            f.this.getDecorView().getWindowVisibleDisplayFrame(getRect());
            int i = getRect().bottom - getRect().top;
            int height = (f.this.getDecorView().getHeight() - f.this.VF) - f.this.VG;
            int i2 = height - i;
            if (i2 < 0) {
                height = (f.this.getDecorView().getWidth() - f.this.VF) - f.this.VG;
                i2 = height - i;
            }
            if (this.VI != i2 && i2 > height / 4) {
                this.VI = i2;
                f.this.a("keyboardDidShow", a(o.R(getRect().left), o.R(getRect().bottom), o.R(getRect().width()), o.R(this.VI), "keyboardDidShow"));
            } else {
                if (this.VI != 0 && i2 <= height / 4) {
                    this.VI = 0;
                    f.this.a("keyboardDidHide", a(0.0f, o.R(getRect().height()), o.R(getRect().width()), 0.0f, "keyboardDidHide"));
                }
            }
        }

        private static HashMap a(float f, float f2, float f3, float f4, String str) {
            HashMap map = new HashMap();
            map.put("screenX", Float.valueOf(f));
            map.put("screenY", Float.valueOf(f2));
            map.put("width", Float.valueOf(f3));
            map.put("height", Float.valueOf(f4));
            map.put("duration", 0);
            map.put("pushUp", 1);
            map.put("eventName", str);
            return map;
        }
    }
}
