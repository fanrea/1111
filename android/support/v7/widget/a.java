package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
abstract class a extends ViewGroup {
    protected final C0016a jq;
    protected final Context jr;
    protected ActionMenuView js;
    protected c jt;
    protected int ju;
    protected android.support.v4.e.r jv;
    private boolean jw;
    private boolean jx;

    protected static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    a(Context context) {
        this(context, null);
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jq = new C0016a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(a.C0010a.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.jr = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.jr = context;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, a.j.ActionBar, a.C0010a.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(a.j.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        c cVar = this.jt;
        if (cVar != null) {
            cVar.bZ();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.jw = false;
        }
        if (!this.jw) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.jw = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.jw = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.jx = false;
        }
        if (!this.jx) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.jx = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.jx = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.ju = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.ju;
    }

    public int getAnimatedVisibility() {
        if (this.jv != null) {
            return this.jq.jz;
        }
        return getVisibility();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            android.support.v4.e.r rVar = this.jv;
            if (rVar != null) {
                rVar.cancel();
            }
            super.setVisibility(i);
        }
    }

    protected static int a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - 0);
    }

    protected static int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    /* renamed from: android.support.v7.widget.a$a, reason: collision with other inner class name */
    protected class C0016a {
        private boolean jy = false;
        int jz;

        protected C0016a() {
        }
    }
}
