package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.v4.graphics.drawable.d;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class e extends d {
    private static Method aL;

    e(Drawable drawable) {
        super(drawable);
        C();
    }

    e(d.a aVar, Resources resources) {
        super(aVar, resources);
        C();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f, float f2) {
        this.aH.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.aH.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        this.aH.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public final Rect getDirtyBounds() {
        return this.aH.getDirtyBounds();
    }

    @Override // android.support.v4.graphics.drawable.d, android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public final void setTintList(ColorStateList colorStateList) {
        if (B()) {
            super.setTintList(colorStateList);
        } else {
            this.aH.setTintList(colorStateList);
        }
    }

    @Override // android.support.v4.graphics.drawable.d, android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public final void setTint(int i) {
        if (B()) {
            super.setTint(i);
        } else {
            this.aH.setTint(i);
        }
    }

    @Override // android.support.v4.graphics.drawable.d, android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public final void setTintMode(PorterDuff.Mode mode) {
        if (B()) {
            super.setTintMode(mode);
        } else {
            this.aH.setTintMode(mode);
        }
    }

    @Override // android.support.v4.graphics.drawable.d, android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.support.v4.graphics.drawable.d
    protected final boolean B() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.aH;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isProjected() {
        Method method;
        if (this.aH != null && (method = aL) != null) {
            try {
                return ((Boolean) method.invoke(this.aH, new Object[0])).booleanValue();
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e);
            }
        }
        return false;
    }

    @Override // android.support.v4.graphics.drawable.d
    final d.a A() {
        return new a(this.aG, null);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class a extends d.a {
        a(d.a aVar, Resources resources) {
            super(aVar);
        }

        @Override // android.support.v4.graphics.drawable.d.a, android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }
    }

    private static void C() {
        if (aL == null) {
            try {
                aL = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }
}
