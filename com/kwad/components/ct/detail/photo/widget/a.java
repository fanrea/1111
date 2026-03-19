package com.kwad.components.ct.detail.photo.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.cb;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends GestureDetector implements cb.a {
    private static final int awV = ViewConfiguration.getLongPressTimeout();
    private static final int awW = ViewConfiguration.getTapTimeout();
    public static final int awX = ViewConfiguration.getDoubleTapTimeout();
    private int awQ;
    private int awR;
    private int awS;
    private int awT;
    private int awU;
    private final GestureDetector.OnGestureListener awY;
    private GestureDetector.OnDoubleTapListener awZ;
    private boolean axa;
    private boolean axb;
    private boolean axc;
    private boolean axd;
    private boolean axe;
    private boolean axf;
    private boolean axg;
    private MotionEvent axh;
    private MotionEvent axi;
    private boolean axj;
    private float axk;
    private float axl;
    private float axm;
    private float axn;
    private boolean axo;
    private long axp;
    private final Handler mHandler;
    private VelocityTracker mVelocityTracker;

    public a(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    private a(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        super(context, onGestureListener, null);
        this.axp = awX;
        this.mHandler = new cb(this);
        this.awY = onGestureListener;
        if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
            setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) onGestureListener);
        }
        init(context);
    }

    private void init(Context context) {
        int scaledDoubleTapSlop;
        int touchSlop;
        ax.checkNotNull(this.awY);
        this.axo = true;
        int i = 300;
        if (context == null) {
            touchSlop = ViewConfiguration.getTouchSlop();
            this.awT = ViewConfiguration.getMinimumFlingVelocity();
            this.awU = ViewConfiguration.getMaximumFlingVelocity();
            scaledDoubleTapSlop = 300;
            i = touchSlop;
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.awT = viewConfiguration.getScaledMinimumFlingVelocity();
            this.awU = viewConfiguration.getScaledMaximumFlingVelocity();
            touchSlop = scaledTouchSlop;
        }
        this.awQ = touchSlop * touchSlop;
        this.awR = i * i;
        this.awS = scaledDoubleTapSlop * scaledDoubleTapSlop;
    }

    @Override // android.view.GestureDetector
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.awZ = onDoubleTapListener;
    }

    @Override // android.view.GestureDetector
    public void setIsLongpressEnabled(boolean z) {
        this.axo = z;
    }

    @Override // android.view.GestureDetector
    public boolean isLongpressEnabled() {
        return this.axo;
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnDoubleTap;
        MotionEvent motionEvent2;
        boolean zOnFling;
        GestureDetector.OnDoubleTapListener onDoubleTapListener;
        int action = motionEvent.getAction();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i = action & 255;
        boolean z = i == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        boolean z2 = (motionEvent.getFlags() & 8) != 0;
        int pointerCount = motionEvent.getPointerCount();
        float x = 0.0f;
        float y = 0.0f;
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (actionIndex != i2) {
                x += motionEvent.getX(i2);
                y += motionEvent.getY(i2);
            }
        }
        float f = z ? pointerCount - 1 : pointerCount;
        float f2 = x / f;
        float f3 = y / f;
        if (i == 0) {
            if (this.awZ == null) {
                zOnDoubleTap = false;
            } else {
                boolean zHasMessages = this.mHandler.hasMessages(3);
                if (zHasMessages) {
                    this.mHandler.removeMessages(3);
                }
                MotionEvent motionEvent3 = this.axh;
                if (motionEvent3 != null && (motionEvent2 = this.axi) != null && zHasMessages && a(motionEvent3, motionEvent2, motionEvent)) {
                    this.axj = true;
                    zOnDoubleTap = this.awZ.onDoubleTap(this.axh) | false | this.awZ.onDoubleTapEvent(motionEvent);
                } else {
                    this.mHandler.sendEmptyMessageDelayed(3, this.axp);
                    zOnDoubleTap = false;
                }
            }
            this.axk = f2;
            this.axm = f2;
            this.axl = f3;
            this.axn = f3;
            MotionEvent motionEvent4 = this.axh;
            if (motionEvent4 != null) {
                motionEvent4.recycle();
            }
            this.axh = MotionEvent.obtain(motionEvent);
            this.axe = true;
            this.axf = true;
            this.axa = true;
            this.axc = false;
            this.axb = false;
            if (this.axo) {
                this.mHandler.removeMessages(2);
                this.mHandler.sendEmptyMessageAtTime(2, this.axh.getDownTime() + awV);
            }
            this.mHandler.sendEmptyMessageAtTime(1, this.axh.getDownTime() + awW);
            return zOnDoubleTap | this.awY.onDown(motionEvent);
        }
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    cancel();
                    return false;
                }
                if (i == 5) {
                    this.axk = f2;
                    this.axm = f2;
                    this.axl = f3;
                    this.axn = f3;
                    BP();
                    return false;
                }
                if (i != 6) {
                    return false;
                }
                this.axk = f2;
                this.axm = f2;
                this.axl = f3;
                this.axn = f3;
                this.mVelocityTracker.computeCurrentVelocity(1000, this.awU);
                int actionIndex2 = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex2);
                float xVelocity = this.mVelocityTracker.getXVelocity(pointerId);
                float yVelocity = this.mVelocityTracker.getYVelocity(pointerId);
                for (int i3 = 0; i3 < pointerCount; i3++) {
                    if (i3 != actionIndex2) {
                        int pointerId2 = motionEvent.getPointerId(i3);
                        if ((this.mVelocityTracker.getXVelocity(pointerId2) * xVelocity) + (this.mVelocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                            this.mVelocityTracker.clear();
                            return false;
                        }
                    }
                }
                return false;
            }
            if (this.axc || this.axd) {
                return false;
            }
            float f4 = this.axk - f2;
            float f5 = this.axl - f3;
            if (this.axj) {
                return false | this.awZ.onDoubleTapEvent(motionEvent);
            }
            if (!this.axe) {
                if (Math.abs(f4) < 1.0f && Math.abs(f5) < 1.0f) {
                    return false;
                }
                boolean zOnScroll = this.awY.onScroll(this.axh, motionEvent, f4, f5);
                this.axk = f2;
                this.axl = f3;
                return zOnScroll;
            }
            int i4 = (int) (f2 - this.axm);
            int i5 = (int) (f3 - this.axn);
            int i6 = (i4 * i4) + (i5 * i5);
            if (i6 > (z2 ? 0 : this.awQ)) {
                zOnFling = this.awY.onScroll(this.axh, motionEvent, f4, f5);
                this.axk = f2;
                this.axl = f3;
                this.axe = false;
                this.mHandler.removeMessages(3);
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(2);
            } else {
                zOnFling = false;
            }
            if (i6 > (z2 ? 0 : this.awR)) {
                this.axf = false;
            }
        } else {
            this.axa = false;
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            if (this.axj) {
                zOnFling = this.awZ.onDoubleTapEvent(motionEvent) | false;
            } else {
                if (this.axc) {
                    this.mHandler.removeMessages(3);
                    this.axc = false;
                } else if (this.axe && !this.axg) {
                    boolean zOnSingleTapUp = this.awY.onSingleTapUp(motionEvent);
                    if (this.axb && (onDoubleTapListener = this.awZ) != null) {
                        onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                    }
                    zOnFling = zOnSingleTapUp;
                } else if (!this.axg) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    int pointerId3 = motionEvent.getPointerId(0);
                    velocityTracker.computeCurrentVelocity(1000, this.awU);
                    float yVelocity2 = velocityTracker.getYVelocity(pointerId3);
                    float xVelocity2 = velocityTracker.getXVelocity(pointerId3);
                    if (Math.abs(yVelocity2) > this.awT || Math.abs(xVelocity2) > this.awT) {
                        zOnFling = this.awY.onFling(this.axh, motionEvent, xVelocity2, yVelocity2);
                    }
                }
                zOnFling = false;
            }
            MotionEvent motionEvent5 = this.axi;
            if (motionEvent5 != null) {
                motionEvent5.recycle();
            }
            this.axi = motionEventObtain;
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
            this.axj = false;
            this.axb = false;
            this.axg = false;
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
        return zOnFling;
    }

    private void cancel() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        this.axj = false;
        this.axa = false;
        this.axe = false;
        this.axf = false;
        this.axb = false;
        this.axc = false;
        this.axd = false;
        this.axg = false;
    }

    private void BP() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.axj = false;
        this.axe = false;
        this.axf = false;
        this.axb = false;
        this.axc = false;
        this.axd = false;
        this.axg = false;
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (!this.axf) {
            return false;
        }
        long eventTime = motionEvent3.getEventTime() - motionEvent2.getEventTime();
        if (eventTime <= this.axp && eventTime >= 10) {
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((x * x) + (y * y) < ((motionEvent.getFlags() & 8) != 0 ? 0 : this.awS)) {
                return true;
            }
        }
        return false;
    }

    private void BQ() {
        this.mHandler.removeMessages(3);
        this.axb = false;
        this.axc = true;
        this.awY.onLongPress(this.axh);
    }

    public final void Z(long j) {
        this.axp = j;
    }

    @Override // com.kwad.sdk.utils.cb.a
    public final void a(Message message) {
        GestureDetector.OnDoubleTapListener onDoubleTapListener;
        int i = message.what;
        if (i == 1) {
            this.awY.onShowPress(this.axh);
            return;
        }
        if (i == 2) {
            BQ();
            return;
        }
        if (i == 3 && (onDoubleTapListener = this.awZ) != null) {
            if (!this.axa) {
                onDoubleTapListener.onSingleTapConfirmed(this.axh);
            } else {
                this.axb = true;
            }
        }
    }
}
