package android.support.v7.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.aj;
import android.view.MotionEvent;
import com.kuaishou.socket.nano.SocketMessages;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class x extends aj.h implements aj.m {
    private aj mRecyclerView;
    private final int oH;
    private final int oI;
    final StateListDrawable oJ;
    final Drawable oK;
    private final int oL;
    private final int oM;
    private final StateListDrawable oN;
    private final Drawable oO;
    private final int oP;
    private final int oQ;
    int oR;
    int oS;
    float oT;
    int oU;
    int oV;
    float oW;
    private static final int[] PRESSED_STATE_SET = {R.attr.state_pressed};
    private static final int[] EMPTY_STATE_SET = new int[0];
    private int oX = 0;
    private int oY = 0;
    private boolean oZ = false;
    private boolean pa = false;
    private int mState = 0;
    private int pb = 0;
    private final int[] pc = new int[2];
    private final int[] pd = new int[2];
    final ValueAnimator pe = ValueAnimator.ofFloat(0.0f, 1.0f);
    int pf = 0;
    private final Runnable pg = new Runnable() { // from class: android.support.v7.widget.x.1
        @Override // java.lang.Runnable
        public final void run() {
            x.this.hide(500);
        }
    };
    private final aj.n mOnScrollListener = new aj.n() { // from class: android.support.v7.widget.x.2
        @Override // android.support.v7.widget.aj.n
        public final void onScrolled(aj ajVar, int i, int i2) {
            x.this.y(ajVar.computeHorizontalScrollOffset(), ajVar.computeVerticalScrollOffset());
        }
    };

    x(aj ajVar, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.oJ = stateListDrawable;
        this.oK = drawable;
        this.oN = stateListDrawable2;
        this.oO = drawable2;
        this.oL = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.oM = Math.max(i, drawable.getIntrinsicWidth());
        this.oP = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.oQ = Math.max(i, drawable2.getIntrinsicWidth());
        this.oH = i2;
        this.oI = i3;
        this.oJ.setAlpha(255);
        this.oK.setAlpha(255);
        this.pe.addListener(new a());
        this.pe.addUpdateListener(new b());
        a(ajVar);
    }

    private void a(aj ajVar) {
        aj ajVar2 = this.mRecyclerView;
        if (ajVar2 == ajVar) {
            return;
        }
        if (ajVar2 != null) {
            df();
        }
        this.mRecyclerView = ajVar;
        if (this.mRecyclerView != null) {
            de();
        }
    }

    private void de() {
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this);
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
    }

    private void df() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this);
        this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
        dh();
    }

    final void dg() {
        this.mRecyclerView.invalidate();
    }

    final void setState(int i) {
        if (i == 2 && this.mState != 2) {
            this.oJ.setState(PRESSED_STATE_SET);
            dh();
        }
        if (i == 0) {
            dg();
        } else {
            show();
        }
        if (this.mState == 2 && i != 2) {
            this.oJ.setState(EMPTY_STATE_SET);
            ai(SocketMessages.PayloadType.SC_LIVE_QUIZ3_SYNC);
        } else if (i == 1) {
            ai(1500);
        }
        this.mState = i;
    }

    private boolean isLayoutRTL() {
        return android.support.v4.e.o.g(this.mRecyclerView) == 1;
    }

    private void show() {
        int i = this.pf;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                this.pe.cancel();
            }
        }
        this.pf = 1;
        ValueAnimator valueAnimator = this.pe;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.pe.setDuration(500L);
        this.pe.setStartDelay(0L);
        this.pe.start();
    }

    final void hide(int i) {
        int i2 = this.pf;
        if (i2 == 1) {
            this.pe.cancel();
        } else if (i2 != 2) {
            return;
        }
        this.pf = 3;
        ValueAnimator valueAnimator = this.pe;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.pe.setDuration(500L);
        this.pe.start();
    }

    private void dh() {
        this.mRecyclerView.removeCallbacks(this.pg);
    }

    private void ai(int i) {
        dh();
        this.mRecyclerView.postDelayed(this.pg, i);
    }

    @Override // android.support.v7.widget.aj.h
    public final void onDrawOver(Canvas canvas, aj ajVar, aj.u uVar) {
        if (this.oX != this.mRecyclerView.getWidth() || this.oY != this.mRecyclerView.getHeight()) {
            this.oX = this.mRecyclerView.getWidth();
            this.oY = this.mRecyclerView.getHeight();
            setState(0);
        } else if (this.pf != 0) {
            if (this.oZ) {
                b(canvas);
            }
            if (this.pa) {
                c(canvas);
            }
        }
    }

    private void b(Canvas canvas) {
        int i = this.oX;
        int i2 = this.oL;
        int i3 = i - i2;
        int i4 = this.oS;
        int i5 = this.oR;
        int i6 = i4 - (i5 / 2);
        this.oJ.setBounds(0, 0, i2, i5);
        this.oK.setBounds(0, 0, this.oM, this.oY);
        if (isLayoutRTL()) {
            this.oK.draw(canvas);
            canvas.translate(this.oL, i6);
            canvas.scale(-1.0f, 1.0f);
            this.oJ.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate(-this.oL, -i6);
            return;
        }
        canvas.translate(i3, 0.0f);
        this.oK.draw(canvas);
        canvas.translate(0.0f, i6);
        this.oJ.draw(canvas);
        canvas.translate(-i3, -i6);
    }

    private void c(Canvas canvas) {
        int i = this.oY;
        int i2 = this.oP;
        int i3 = this.oV;
        int i4 = this.oU;
        this.oN.setBounds(0, 0, i4, i2);
        this.oO.setBounds(0, 0, this.oX, this.oQ);
        canvas.translate(0.0f, i - i2);
        this.oO.draw(canvas);
        canvas.translate(i3 - (i4 / 2), 0.0f);
        this.oN.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    final void y(int i, int i2) {
        int iComputeVerticalScrollRange = this.mRecyclerView.computeVerticalScrollRange();
        int i3 = this.oY;
        this.oZ = iComputeVerticalScrollRange - i3 > 0 && i3 >= this.oH;
        int iComputeHorizontalScrollRange = this.mRecyclerView.computeHorizontalScrollRange();
        int i4 = this.oX;
        this.pa = iComputeHorizontalScrollRange - i4 > 0 && i4 >= this.oH;
        if (!this.oZ && !this.pa) {
            if (this.mState != 0) {
                setState(0);
                return;
            }
            return;
        }
        if (this.oZ) {
            float f = i3;
            this.oS = (int) ((f * (i2 + (f / 2.0f))) / iComputeVerticalScrollRange);
            this.oR = Math.min(i3, (i3 * i3) / iComputeVerticalScrollRange);
        }
        if (this.pa) {
            float f2 = i4;
            this.oV = (int) ((f2 * (i + (f2 / 2.0f))) / iComputeHorizontalScrollRange);
            this.oU = Math.min(i4, (i4 * i4) / iComputeHorizontalScrollRange);
        }
        int i5 = this.mState;
        if (i5 == 0 || i5 == 1) {
            setState(1);
        }
    }

    @Override // android.support.v7.widget.aj.m
    public final boolean b(MotionEvent motionEvent) {
        int i = this.mState;
        if (i == 1) {
            boolean zH = h(motionEvent.getX(), motionEvent.getY());
            boolean zI = i(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zH && !zI) {
                return false;
            }
            if (zI) {
                this.pb = 1;
                this.oW = (int) motionEvent.getX();
            } else if (zH) {
                this.pb = 2;
                this.oT = (int) motionEvent.getY();
            }
            setState(2);
        } else if (i != 2) {
            return false;
        }
        return true;
    }

    @Override // android.support.v7.widget.aj.m
    public final void c(MotionEvent motionEvent) {
        if (this.mState == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zH = h(motionEvent.getX(), motionEvent.getY());
            boolean zI = i(motionEvent.getX(), motionEvent.getY());
            if (zH || zI) {
                if (zI) {
                    this.pb = 1;
                    this.oW = (int) motionEvent.getX();
                } else if (zH) {
                    this.pb = 2;
                    this.oT = (int) motionEvent.getY();
                }
                setState(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.mState == 2) {
            this.oT = 0.0f;
            this.oW = 0.0f;
            setState(1);
            this.pb = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.mState == 2) {
            show();
            if (this.pb == 1) {
                e(motionEvent.getX());
            }
            if (this.pb == 2) {
                d(motionEvent.getY());
            }
        }
    }

    private void d(float f) {
        int[] iArrDi = di();
        float fMax = Math.max(iArrDi[0], Math.min(iArrDi[1], f));
        if (Math.abs(this.oS - fMax) < 2.0f) {
            return;
        }
        int iA = a(this.oT, fMax, iArrDi, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.oY);
        if (iA != 0) {
            this.mRecyclerView.scrollBy(0, iA);
        }
        this.oT = fMax;
    }

    private void e(float f) {
        int[] iArrDj = dj();
        float fMax = Math.max(iArrDj[0], Math.min(iArrDj[1], f));
        if (Math.abs(this.oV - fMax) < 2.0f) {
            return;
        }
        int iA = a(this.oW, fMax, iArrDj, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.oX);
        if (iA != 0) {
            this.mRecyclerView.scrollBy(iA, 0);
        }
        this.oW = fMax;
    }

    private static int a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    private boolean h(float f, float f2) {
        if (isLayoutRTL()) {
            if (f > this.oL / 2) {
                return false;
            }
        } else if (f < this.oX - this.oL) {
            return false;
        }
        int i = this.oS;
        int i2 = this.oR;
        return f2 >= ((float) (i - (i2 / 2))) && f2 <= ((float) (i + (i2 / 2)));
    }

    private boolean i(float f, float f2) {
        if (f2 < this.oY - this.oP) {
            return false;
        }
        int i = this.oV;
        int i2 = this.oU;
        return f >= ((float) (i - (i2 / 2))) && f <= ((float) (i + (i2 / 2)));
    }

    private int[] di() {
        int[] iArr = this.pc;
        int i = this.oI;
        iArr[0] = i;
        iArr[1] = this.oY - i;
        return iArr;
    }

    private int[] dj() {
        int[] iArr = this.pd;
        int i = this.oI;
        iArr[0] = i;
        iArr[1] = this.oX - i;
        return iArr;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class a extends AnimatorListenerAdapter {
        private boolean jy = false;

        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (this.jy) {
                this.jy = false;
                return;
            }
            if (((Float) x.this.pe.getAnimatedValue()).floatValue() == 0.0f) {
                x xVar = x.this;
                xVar.pf = 0;
                xVar.setState(0);
            } else {
                x xVar2 = x.this;
                xVar2.pf = 2;
                xVar2.dg();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.jy = true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            x.this.oJ.setAlpha(iFloatValue);
            x.this.oK.setAlpha(iFloatValue);
            x.this.dg();
        }
    }
}
