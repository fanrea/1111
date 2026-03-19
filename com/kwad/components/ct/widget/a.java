package com.kwad.components.ct.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.TranslateAnimation;
import androidx.viewpager.widget.ViewPager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends ViewPager {
    private Rect anI;
    private boolean baA;
    private float baB;
    private InterfaceC0545a baC;
    private float baD;
    private boolean baE;
    private boolean baF;
    private float baG;
    private float baH;
    private float baI;
    private int mCurrentPosition;

    /* renamed from: com.kwad.components.ct.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0545a {
        void a(boolean z, float f);

        void ci(int i);

        void t(float f);
    }

    public a(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.anI = new Rect();
        this.baA = true;
        this.baB = 0.0f;
        this.baE = true;
        this.baF = false;
        this.baI = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public final void setDragListener(InterfaceC0545a interfaceC0545a) {
        this.baC = interfaceC0545a;
    }

    public final void setBounceSlideEnable(boolean z) {
        this.baE = z;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) throws Resources.NotFoundException {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.baE || !z || this.baC == null || i == this.anI.left) {
            return;
        }
        this.baC.a(getCurrentItem() == 0, this.anI.left - getLeft());
    }

    @Override // android.view.View
    protected final void onScrollChanged(int i, int i2, int i3, int i4) {
        InterfaceC0545a interfaceC0545a;
        super.onScrollChanged(i, i2, i3, i4);
        if (!this.baE || (interfaceC0545a = this.baC) == null) {
            return;
        }
        interfaceC0545a.ci(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.baE) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.baG = motionEvent.getRawX();
            this.baH = motionEvent.getRawY();
            this.baF = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2 && !this.baF) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float f = rawX - this.baG;
            float f2 = rawY - this.baH;
            if (Math.abs(f) > this.baI && Math.abs(f) > Math.abs(f2)) {
                getParent().requestDisallowInterceptTouchEvent(true);
                this.baF = true;
            } else if (Math.abs(f2) - Math.abs(f) > this.baI) {
                getParent().requestDisallowInterceptTouchEvent(false);
                this.baF = true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.baE) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            this.mCurrentPosition = getCurrentItem();
            float pageWidth = 0.0f;
            if (getAdapter() != null) {
                for (int i = 0; i < getAdapter().getCount(); i++) {
                    pageWidth += getAdapter().getPageWidth(i);
                }
            }
            this.baD = (pageWidth - 1.0f) * getMeasuredWidth();
            if (this.mCurrentPosition == 0 || getScrollX() >= this.baD) {
                this.baB = motionEvent.getX();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.baE) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            Lv();
        } else if (actionMasked == 2) {
            int sideEdgeType = getSideEdgeType();
            if (sideEdgeType > 0 && this.baB < 0.0f) {
                this.baB = motionEvent.getX(0);
            }
            if (getAdapter().getCount() == 1) {
                float x = motionEvent.getX(0);
                float f = x - this.baB;
                this.baB = x;
                if (f > 10.0f || f < -10.0f) {
                    C(f);
                } else if (!this.baA) {
                    int i = (int) (f * 0.5f);
                    if (getLeft() + i != this.anI.left) {
                        layout(getLeft() + i, getTop(), getRight() + i, getBottom());
                    }
                }
            } else if (sideEdgeType > 0) {
                float x2 = motionEvent.getX(0);
                float f2 = x2 - this.baB;
                this.baB = x2;
                if (sideEdgeType == 1) {
                    if (f2 > 10.0f) {
                        C(f2);
                    } else if (!this.baA) {
                        int i2 = (int) (f2 * 0.5f);
                        if (getLeft() + i2 >= this.anI.left) {
                            layout(getLeft() + i2, getTop(), getRight() + i2, getBottom());
                        }
                    }
                } else if (f2 < -10.0f) {
                    C(f2);
                } else if (!this.baA) {
                    int i3 = (int) (f2 * 0.5f);
                    if (getRight() + i3 <= this.anI.right) {
                        layout(getLeft() + i3, getTop(), getRight() + i3, getBottom());
                    }
                }
            } else {
                this.baA = true;
            }
            if (!this.baA) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void C(float f) {
        if (this.anI.isEmpty()) {
            this.anI.set(getLeft(), getTop(), getRight(), getBottom());
        }
        this.baA = false;
        int i = (int) (f * 0.5f);
        layout(getLeft() + i, getTop(), getRight() + i, getBottom());
    }

    private int getSideEdgeType() {
        if (getScrollX() >= this.baD) {
            return 2;
        }
        return this.mCurrentPosition == 0 ? 1 : 0;
    }

    private void Lv() {
        if (!this.anI.isEmpty()) {
            Lw();
        }
        this.baB = -1.0f;
    }

    private void Lw() {
        TranslateAnimation translateAnimation = new TranslateAnimation(getLeft(), this.anI.left, 0.0f, 0.0f);
        translateAnimation.setDuration(200L);
        startAnimation(translateAnimation);
        layout(this.anI.left, this.anI.top, this.anI.right, this.anI.bottom);
        this.anI.setEmpty();
        this.baA = true;
        InterfaceC0545a interfaceC0545a = this.baC;
        if (interfaceC0545a != null) {
            interfaceC0545a.t(this.anI.left - getLeft());
        }
    }
}
