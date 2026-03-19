package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class d extends Drawable implements Drawable.Callback, android.support.v4.graphics.drawable.b, c {
    static final PorterDuff.Mode aA = PorterDuff.Mode.SRC_IN;
    private int aD;
    private PorterDuff.Mode aE;
    private boolean aF;
    a aG;
    Drawable aH;
    private boolean mMutated;

    protected boolean B() {
        return true;
    }

    d(a aVar, Resources resources) {
        this.aG = aVar;
        a(resources);
    }

    d(Drawable drawable) {
        this.aG = A();
        d(drawable);
    }

    private void a(Resources resources) {
        a aVar = this.aG;
        if (aVar == null || aVar.aJ == null) {
            return;
        }
        d(this.aG.aJ.newDrawable(resources));
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.aH.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.aH.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.aH;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.aH.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        a aVar = this.aG;
        return changingConfigurations | (aVar != null ? aVar.getChangingConfigurations() : 0) | this.aH.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.aH.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.aH.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.aH.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.aH.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        a aVar;
        ColorStateList colorStateList = (!B() || (aVar = this.aG) == null) ? null : aVar.aK;
        return (colorStateList != null && colorStateList.isStateful()) || this.aH.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return a(iArr) || this.aH.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.aH.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.aH.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.aH.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.aH.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.aH.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.aH.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.aH.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.aH.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.aH.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.aH.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.aH.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.aH.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        a aVar = this.aG;
        if (aVar == null || !aVar.canConstantState()) {
            return null;
        }
        this.aG.aI = getChangingConfigurations();
        return this.aG;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.aG = A();
            Drawable drawable = this.aH;
            if (drawable != null) {
                drawable.mutate();
            }
            a aVar = this.aG;
            if (aVar != null) {
                Drawable drawable2 = this.aH;
                aVar.aJ = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.mMutated = true;
        }
        return this;
    }

    a A() {
        return new b(this.aG, null);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.aH.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.aG.aK = colorStateList;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.aG.aB = mode;
        a(getState());
    }

    private boolean a(int[] iArr) {
        if (!B()) {
            return false;
        }
        ColorStateList colorStateList = this.aG.aK;
        PorterDuff.Mode mode = this.aG.aB;
        if (colorStateList != null && mode != null) {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.aF || colorForState != this.aD || mode != this.aE) {
                setColorFilter(colorForState, mode);
                this.aD = colorForState;
                this.aE = mode;
                this.aF = true;
                return true;
            }
        } else {
            this.aF = false;
            clearColorFilter();
        }
        return false;
    }

    @Override // android.support.v4.graphics.drawable.c
    public final Drawable w() {
        return this.aH;
    }

    private void d(Drawable drawable) {
        Drawable drawable2 = this.aH;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.aH = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            a aVar = this.aG;
            if (aVar != null) {
                aVar.aJ = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    protected static abstract class a extends Drawable.ConstantState {
        PorterDuff.Mode aB;
        int aI;
        Drawable.ConstantState aJ;
        ColorStateList aK;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public abstract Drawable newDrawable(Resources resources);

        a(a aVar) {
            this.aK = null;
            this.aB = d.aA;
            if (aVar != null) {
                this.aI = aVar.aI;
                this.aJ = aVar.aJ;
                this.aK = aVar.aK;
                this.aB = aVar.aB;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            int i = this.aI;
            Drawable.ConstantState constantState = this.aJ;
            return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
        }

        final boolean canConstantState() {
            return this.aJ != null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class b extends a {
        b(a aVar, Resources resources) {
            super(aVar);
        }

        @Override // android.support.v4.graphics.drawable.d.a, android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }
}
