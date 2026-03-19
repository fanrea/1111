package com.sigmob.sdk.mraid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.Preconditions;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a extends FrameLayout {
    static final float a = 30.0f;
    static final float b = 50.0f;
    static final float c = 8.0f;
    private final int d;
    private b e;
    private final StateListDrawable f;
    private EnumC0738a g;
    private final int h;
    private final int i;
    private final int j;
    private boolean k;
    private final Rect l;
    private final Rect m;
    private final Rect n;
    private final Rect o;
    private boolean p;
    private c q;

    /* renamed from: com.sigmob.sdk.mraid.a$a, reason: collision with other inner class name */
    public enum EnumC0738a {
        TOP_LEFT(51),
        TOP_CENTER(49),
        TOP_RIGHT(53),
        CENTER(17),
        BOTTOM_LEFT(83),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(85);

        private final int h;

        EnumC0738a(final int mGravity) {
            this.h = mGravity;
        }

        int a() {
            return this.h;
        }
    }

    public interface b {
        void a();
    }

    private final class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.setClosePressed(false);
        }
    }

    public a(Context context) {
        this(context, null, 0);
    }

    public a(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public a(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.l = new Rect();
        this.m = new Rect();
        this.n = new Rect();
        this.o = new Rect();
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f = stateListDrawable;
        this.g = EnumC0738a.TOP_RIGHT;
        stateListDrawable.setState(EMPTY_STATE_SET);
        stateListDrawable.setCallback(this);
        this.d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.h = Dips.asIntPixels(50.0f, context);
        this.i = Dips.asIntPixels(a, context);
        this.j = Dips.asIntPixels(8.0f, context);
        setWillNotDraw(false);
        this.p = true;
    }

    private void a(EnumC0738a closePosition, final int size, Rect bounds, Rect outBounds) {
        Gravity.apply(closePosition.a(), size, size, bounds, outBounds);
    }

    private void b(EnumC0738a closePosition, Rect bounds, Rect outBounds) {
        a(closePosition, this.i, bounds, outBounds);
    }

    private void c() {
        playSoundEffect(0);
        b bVar = this.e;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClosePressed(boolean pressed) {
        if (pressed == b()) {
            return;
        }
        this.f.setState(pressed ? SELECTED_STATE_SET : EMPTY_STATE_SET);
        invalidate(this.m);
    }

    public void a(EnumC0738a closePosition, Rect bounds, Rect closeBounds) {
        a(closePosition, this.h, bounds, closeBounds);
    }

    boolean a() {
        return this.p || this.f.isVisible();
    }

    boolean a(int x, int y, int slop) {
        return x >= this.m.left - slop && y >= this.m.top - slop && x < this.m.right + slop && y < this.m.bottom + slop;
    }

    boolean b() {
        return this.f.getState() == SELECTED_STATE_SET;
    }

    @Override // android.view.View
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        if (this.k) {
            this.k = false;
            this.l.set(0, 0, getWidth(), getHeight());
            a(this.g, this.l, this.m);
            this.o.set(this.m);
            Rect rect = this.o;
            int i = this.j;
            rect.inset(i, i);
            b(this.g, this.o, this.n);
            this.f.setBounds(this.n);
        }
        if (this.f.isVisible()) {
            this.f.draw(canvas);
        }
    }

    Rect getCloseBounds() {
        return this.m;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(final MotionEvent event) {
        if (event.getAction() != 0) {
            return false;
        }
        return a((int) event.getX(), (int) event.getY(), 0);
    }

    @Override // android.view.View
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        this.k = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (!a((int) event.getX(), (int) event.getY(), this.d) || !a()) {
            setClosePressed(false);
            super.onTouchEvent(event);
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            setClosePressed(true);
        } else if (action != 1) {
            if (action == 3) {
                setClosePressed(false);
            }
        } else if (b()) {
            if (this.q == null) {
                this.q = new c();
            }
            postDelayed(this.q, ViewConfiguration.getPressedStateDuration());
            c();
        }
        return true;
    }

    public void setCloseAlwaysInteractable(boolean closeAlwaysInteractable) {
        this.p = closeAlwaysInteractable;
    }

    void setCloseBoundChanged(boolean changed) {
        this.k = changed;
    }

    void setCloseBounds(Rect closeBounds) {
        this.m.set(closeBounds);
    }

    public void setClosePosition(EnumC0738a closePosition) {
        Preconditions.checkNotNull(closePosition);
        this.g = closePosition;
        this.k = true;
        invalidate();
    }

    public void setCloseVisible(boolean visible) {
        if (this.f.setVisible(visible, false)) {
            invalidate(this.m);
        }
    }

    public void setOnCloseListener(b onCloseListener) {
        this.e = onCloseListener;
    }
}
