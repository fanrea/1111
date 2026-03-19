package lkxssdk.g;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class j implements View.OnTouchListener, View.OnLayoutChangeListener {
    public ImageView h;
    public GestureDetector i;
    public lkxssdk.g.a j;
    public lkxssdk.g.c p;
    public lkxssdk.g.e q;
    public lkxssdk.g.d r;
    public i s;
    public View.OnClickListener t;
    public View.OnLongClickListener u;
    public lkxssdk.g.f v;
    public g w;
    public h x;
    public f y;
    public Interpolator a = new AccelerateDecelerateInterpolator();
    public int b = 200;
    public float c = 1.0f;
    public float d = 1.75f;
    public float e = 3.0f;
    public boolean f = true;
    public boolean g = false;
    public final Matrix k = new Matrix();
    public final Matrix l = new Matrix();
    public final Matrix m = new Matrix();
    public final RectF n = new RectF();
    public final float[] o = new float[9];
    public int z = 2;
    public int A = 2;
    public boolean B = true;
    public ImageView.ScaleType C = ImageView.ScaleType.FIT_CENTER;
    public lkxssdk.g.b D = new a();

    public class a implements lkxssdk.g.b {
        public a() {
        }

        public void a(float f, float f2, float f3, float f4, float f5) {
            float fE = j.this.e();
            j jVar = j.this;
            if (fE < jVar.e || f < 1.0f) {
                lkxssdk.g.f fVar = jVar.v;
                if (fVar != null) {
                    fVar.a(f, f2, f3);
                }
                j.this.m.postScale(f, f, f2, f3);
                j.this.m.postTranslate(f4, f5);
                j.this.a();
            }
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            j jVar = j.this;
            if (jVar.w == null || jVar.e() > 1.0f || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1) {
                return false;
            }
            return j.this.w.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            j jVar = j.this;
            View.OnLongClickListener onLongClickListener = jVar.u;
            if (onLongClickListener != null) {
                onLongClickListener.onLongClick(jVar.h);
            }
        }
    }

    public class c implements GestureDetector.OnDoubleTapListener {
        public c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0029 A[Catch: ArrayIndexOutOfBoundsException -> 0x002e, TRY_LEAVE, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x002e, blocks: (B:3:0x0001, B:5:0x0017, B:8:0x001f, B:10:0x0025, B:11:0x0029), top: B:15:0x0001 }] */
        @Override // android.view.GestureDetector.OnDoubleTapListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onDoubleTap(android.view.MotionEvent r7) {
            /*
                r6 = this;
                r0 = 1
                lkxssdk.g.j r1 = lkxssdk.g.j.this     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L2e
                float r1 = r1.e()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L2e
                float r2 = r7.getX()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L2e
                float r7 = r7.getY()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L2e
                lkxssdk.g.j r3 = lkxssdk.g.j.this     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L2e
                float r4 = r3.d     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L2e
                int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                if (r5 >= 0) goto L1b
                r3.a(r4, r2, r7, r0)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L2e
                goto L2e
            L1b:
                int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                if (r4 < 0) goto L29
                float r4 = r3.e     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L2e
                int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                if (r1 >= 0) goto L29
                r3.a(r4, r2, r7, r0)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L2e
                goto L2e
            L29:
                float r1 = r3.c     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L2e
                r3.a(r1, r2, r7, r0)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L2e
            L2e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: lkxssdk.g.j.c.onDoubleTap(android.view.MotionEvent):boolean");
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            j jVar = j.this;
            View.OnClickListener onClickListener = jVar.t;
            if (onClickListener != null) {
                onClickListener.onClick(jVar.h);
            }
            RectF rectFC = j.this.c();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            j jVar2 = j.this;
            i iVar = jVar2.s;
            if (iVar != null) {
                iVar.a(jVar2.h, x, y);
            }
            if (rectFC == null) {
                return false;
            }
            if (!rectFC.contains(x, y)) {
                j jVar3 = j.this;
                lkxssdk.g.d dVar = jVar3.r;
                if (dVar == null) {
                    return false;
                }
                dVar.a(jVar3.h);
                return false;
            }
            float fWidth = (x - rectFC.left) / rectFC.width();
            float fHeight = (y - rectFC.top) / rectFC.height();
            j jVar4 = j.this;
            lkxssdk.g.e eVar = jVar4.q;
            if (eVar == null) {
                return true;
            }
            eVar.a(jVar4.h, fWidth, fHeight);
            return true;
        }
    }

    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class e implements Runnable {
        public final float a;
        public final float b;
        public final long c = System.currentTimeMillis();
        public final float d;
        public final float e;

        public e(float f, float f2, float f3, float f4) {
            this.a = f3;
            this.b = f4;
            this.d = f;
            this.e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            float interpolation = j.this.a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.c) * 1.0f) / j.this.b));
            float f = this.d;
            ((a) j.this.D).a((f + ((this.e - f) * interpolation)) / j.this.e(), this.a, this.b, 0.0f, 0.0f);
            if (interpolation < 1.0f) {
                ImageView imageView = j.this.h;
                if (Build.VERSION.SDK_INT >= 16) {
                    imageView.postOnAnimation(this);
                } else {
                    imageView.postDelayed(this, 16L);
                }
            }
        }
    }

    public class f implements Runnable {
        public final OverScroller a;
        public int b;
        public int c;

        public f(Context context) {
            this.a = new OverScroller(context);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.isFinished() && this.a.computeScrollOffset()) {
                int currX = this.a.getCurrX();
                int currY = this.a.getCurrY();
                j.this.m.postTranslate(this.b - currX, this.c - currY);
                j.this.a();
                this.b = currX;
                this.c = currY;
                ImageView imageView = j.this.h;
                if (Build.VERSION.SDK_INT >= 16) {
                    imageView.postOnAnimation(this);
                } else {
                    imageView.postDelayed(this, 16L);
                }
            }
        }
    }

    public j(ImageView imageView) {
        this.h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.j = new lkxssdk.g.a(imageView.getContext(), this.D);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    public final int a(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    public final RectF a(Matrix matrix) {
        if (this.h.getDrawable() == null) {
            return null;
        }
        this.n.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.n);
        return this.n;
    }

    public final void a() {
        RectF rectFA;
        if (b()) {
            Matrix matrixD = d();
            this.h.setImageMatrix(matrixD);
            if (this.p == null || (rectFA = a(matrixD)) == null) {
                return;
            }
            this.p.a(rectFA);
        }
    }

    public void a(float f2, float f3, float f4, boolean z) {
        if (f2 < this.c || f2 > this.e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z) {
            this.h.post(new e(e(), f2, f3, f4));
        } else {
            this.m.setScale(f2, f2, f3, f4);
            a();
        }
    }

    public final void a(Drawable drawable) {
        Matrix matrix;
        Matrix.ScaleToFit scaleToFit;
        float fMin;
        if (drawable == null) {
            return;
        }
        float fB = b(this.h);
        float fA = a(this.h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.k.reset();
        float f2 = intrinsicWidth;
        float f3 = fB / f2;
        float f4 = intrinsicHeight;
        float f5 = fA / f4;
        ImageView.ScaleType scaleType = this.C;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.k.postTranslate((fB - f2) / 2.0f, (fA - f4) / 2.0f);
        } else {
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                fMin = Math.max(f3, f5);
            } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                fMin = Math.min(1.0f, Math.min(f3, f5));
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
                RectF rectF2 = new RectF(0.0f, 0.0f, fB, fA);
                if (((int) 0.0f) % 180 != 0) {
                    rectF = new RectF(0.0f, 0.0f, f4, f2);
                }
                int i = d.a[this.C.ordinal()];
                if (i == 1) {
                    matrix = this.k;
                    scaleToFit = Matrix.ScaleToFit.CENTER;
                } else if (i == 2) {
                    matrix = this.k;
                    scaleToFit = Matrix.ScaleToFit.START;
                } else if (i == 3) {
                    matrix = this.k;
                    scaleToFit = Matrix.ScaleToFit.END;
                } else if (i == 4) {
                    matrix = this.k;
                    scaleToFit = Matrix.ScaleToFit.FILL;
                }
                matrix.setRectToRect(rectF, rectF2, scaleToFit);
            }
            this.k.postScale(fMin, fMin);
            this.k.postTranslate((fB - (f2 * fMin)) / 2.0f, (fA - (f4 * fMin)) / 2.0f);
        }
        f();
    }

    public final int b(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public final boolean b() {
        float f2;
        RectF rectFA = a(d());
        if (rectFA == null) {
            return false;
        }
        float fHeight = rectFA.height();
        float fWidth = rectFA.width();
        float fA = a(this.h);
        float f3 = 0.0f;
        if (fHeight <= fA) {
            int i = d.a[this.C.ordinal()];
            if (i != 2) {
                float f4 = fA - fHeight;
                if (i != 3) {
                    f4 /= 2.0f;
                }
                f2 = f4 - rectFA.top;
            } else {
                f2 = -rectFA.top;
            }
            this.A = 2;
        } else {
            float f5 = rectFA.top;
            if (f5 > 0.0f) {
                this.A = 0;
                f2 = -f5;
            } else {
                float f6 = rectFA.bottom;
                if (f6 < fA) {
                    this.A = 1;
                    f2 = fA - f6;
                } else {
                    this.A = -1;
                    f2 = 0.0f;
                }
            }
        }
        float fB = b(this.h);
        if (fWidth <= fB) {
            int i2 = d.a[this.C.ordinal()];
            if (i2 != 2) {
                float f7 = fB - fWidth;
                if (i2 != 3) {
                    f7 /= 2.0f;
                }
                f3 = f7 - rectFA.left;
            } else {
                f3 = -rectFA.left;
            }
            this.z = 2;
        } else {
            float f8 = rectFA.left;
            if (f8 > 0.0f) {
                this.z = 0;
                f3 = -f8;
            } else {
                float f9 = rectFA.right;
                if (f9 < fB) {
                    f3 = fB - f9;
                    this.z = 1;
                } else {
                    this.z = -1;
                }
            }
        }
        this.m.postTranslate(f3, f2);
        return true;
    }

    public RectF c() {
        b();
        return a(d());
    }

    public final Matrix d() {
        this.l.set(this.k);
        this.l.postConcat(this.m);
        return this.l;
    }

    public float e() {
        this.m.getValues(this.o);
        float fPow = (float) Math.pow(this.o[0], 2.0d);
        this.m.getValues(this.o);
        return (float) Math.sqrt(fPow + ((float) Math.pow(this.o[3], 2.0d)));
    }

    public final void f() {
        RectF rectFA;
        this.m.reset();
        this.m.postRotate(0.0f);
        a();
        Matrix matrixD = d();
        this.h.setImageMatrix(matrixD);
        if (this.p != null && (rectFA = a(matrixD)) != null) {
            this.p.a(rectFA);
        }
        b();
    }

    public void g() {
        if (this.B) {
            a(this.h.getDrawable());
        } else {
            f();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
            return;
        }
        a(this.h.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bf  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.B
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lcb
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            android.graphics.drawable.Drawable r0 = r0.getDrawable()
            if (r0 == 0) goto L11
            r0 = r2
            goto L12
        L11:
            r0 = r1
        L12:
            if (r0 == 0) goto Lcb
            int r0 = r12.getAction()
            if (r0 == 0) goto L70
            if (r0 == r2) goto L20
            r3 = 3
            if (r0 == r3) goto L20
            goto L85
        L20:
            float r0 = r10.e()
            float r3 = r10.c
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L4a
            android.graphics.RectF r0 = r10.c()
            if (r0 == 0) goto L85
            lkxssdk.g.j$e r9 = new lkxssdk.g.j$e
            float r5 = r10.e()
            float r6 = r10.c
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
        L45:
            r11.post(r9)
            r11 = r2
            goto L86
        L4a:
            float r0 = r10.e()
            float r3 = r10.e
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L85
            android.graphics.RectF r0 = r10.c()
            if (r0 == 0) goto L85
            lkxssdk.g.j$e r9 = new lkxssdk.g.j$e
            float r5 = r10.e()
            float r6 = r10.e
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            goto L45
        L70:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L79
            r11.requestDisallowInterceptTouchEvent(r2)
        L79:
            lkxssdk.g.j$f r11 = r10.y
            if (r11 == 0) goto L85
            android.widget.OverScroller r11 = r11.a
            r11.forceFinished(r2)
            r11 = 0
            r10.y = r11
        L85:
            r11 = r1
        L86:
            lkxssdk.g.a r0 = r10.j
            if (r0 == 0) goto Lbf
            android.view.ScaleGestureDetector r11 = r0.c
            boolean r11 = r11.isInProgress()
            lkxssdk.g.a r0 = r10.j
            boolean r3 = r0.e
            android.view.ScaleGestureDetector r4 = r0.c     // Catch: java.lang.IllegalArgumentException -> L9c
            r4.onTouchEvent(r12)     // Catch: java.lang.IllegalArgumentException -> L9c
            r0.c(r12)     // Catch: java.lang.IllegalArgumentException -> L9c
        L9c:
            if (r11 != 0) goto Laa
            lkxssdk.g.a r11 = r10.j
            android.view.ScaleGestureDetector r11 = r11.c
            boolean r11 = r11.isInProgress()
            if (r11 != 0) goto Laa
            r11 = r2
            goto Lab
        Laa:
            r11 = r1
        Lab:
            if (r3 != 0) goto Lb5
            lkxssdk.g.a r0 = r10.j
            boolean r0 = r0.e
            if (r0 != 0) goto Lb5
            r0 = r2
            goto Lb6
        Lb5:
            r0 = r1
        Lb6:
            if (r11 == 0) goto Lbb
            if (r0 == 0) goto Lbb
            r1 = r2
        Lbb:
            r10.g = r1
            r1 = r2
            goto Lc0
        Lbf:
            r1 = r11
        Lc0:
            android.view.GestureDetector r11 = r10.i
            if (r11 == 0) goto Lcb
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto Lcb
            r1 = r2
        Lcb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.g.j.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
