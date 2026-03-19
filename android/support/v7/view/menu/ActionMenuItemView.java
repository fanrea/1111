package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.a.a;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.n;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.ax;
import android.support.v7.widget.z;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ActionMenuItemView extends android.support.v7.widget.q implements n.a, ActionMenuView.a, View.OnClickListener {
    h gO;
    private Drawable gP;
    g.b gQ;
    private z gR;
    b gS;
    private boolean gT;
    private boolean gU;
    private int gV;
    private int gW;
    private int gX;
    private CharSequence gz;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static abstract class b {
        public abstract q aY();
    }

    @Override // android.support.v7.view.menu.n.a
    public final boolean aU() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.gT = aT();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ActionMenuItemView, i, 0);
        this.gV = typedArrayObtainStyledAttributes.getDimensionPixelSize(a.j.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.gX = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.gW = -1;
        setSaveEnabled(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gT = aT();
        aV();
    }

    private boolean aT() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (i < 480) {
            return (i >= 640 && i2 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.gW = i;
        super.setPadding(i, i2, i3, i4);
    }

    @Override // android.support.v7.view.menu.n.a
    public h getItemData() {
        return this.gO;
    }

    @Override // android.support.v7.view.menu.n.a
    public final void a(h hVar, int i) {
        this.gO = hVar;
        setIcon(hVar.getIcon());
        setTitle(hVar.a(this));
        setId(hVar.getItemId());
        setVisibility(hVar.isVisible() ? 0 : 8);
        setEnabled(hVar.isEnabled());
        if (hVar.hasSubMenu() && this.gR == null) {
            this.gR = new a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        z zVar;
        if (this.gO.hasSubMenu() && (zVar = this.gR) != null && zVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar = this.gQ;
        if (bVar != null) {
            bVar.d(this.gO);
        }
    }

    public void setItemInvoker(g.b bVar) {
        this.gQ = bVar;
    }

    public void setPopupCallback(b bVar) {
        this.gS = bVar;
    }

    public void setExpandedFormat(boolean z) {
        if (this.gU != z) {
            this.gU = z;
            h hVar = this.gO;
            if (hVar != null) {
                hVar.bF();
            }
        }
    }

    private void aV() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.gz);
        if (this.gP != null && (!this.gO.bJ() || (!this.gT && !this.gU))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.gz : null);
        CharSequence contentDescription = this.gO.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.gO.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.gO.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            ax.a(this, z3 ? null : this.gO.getTitle());
        } else {
            ax.a(this, tooltipText);
        }
    }

    public void setIcon(Drawable drawable) {
        this.gP = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.gX;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            int i2 = this.gX;
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
                intrinsicHeight = i2;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        aV();
    }

    public final boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.gz = charSequence;
        aV();
    }

    @Override // android.support.v7.widget.ActionMenuView.a
    public final boolean aW() {
        return hasText() && this.gO.getIcon() == null;
    }

    @Override // android.support.v7.widget.ActionMenuView.a
    public final boolean aX() {
        return hasText();
    }

    @Override // android.support.v7.widget.q, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        boolean zHasText = hasText();
        if (zHasText && (i3 = this.gW) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.gV) : this.gV;
        if (mode != 1073741824 && this.gV > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i2);
        }
        if (zHasText || this.gP == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.gP.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class a extends z {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // android.support.v7.widget.z
        public final q aY() {
            if (ActionMenuItemView.this.gS != null) {
                return ActionMenuItemView.this.gS.aY();
            }
            return null;
        }

        @Override // android.support.v7.widget.z
        public final boolean aZ() {
            q qVarAY;
            return ActionMenuItemView.this.gQ != null && ActionMenuItemView.this.gQ.d(ActionMenuItemView.this.gO) && (qVarAY = aY()) != null && qVarAY.isShowing();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
