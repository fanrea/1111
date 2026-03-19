package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class l {
    private final ImageView mC;
    private at mD;
    private at mE;
    private at ml;

    public l(ImageView imageView) {
        this.mC = imageView;
    }

    public final void a(AttributeSet attributeSet, int i) {
        int resourceId;
        av avVarA = av.a(this.mC.getContext(), attributeSet, a.j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.mC.getDrawable();
            if (drawable == null && (resourceId = avVarA.getResourceId(a.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = android.support.v7.b.a.a.a(this.mC.getContext(), resourceId)) != null) {
                this.mC.setImageDrawable(drawable);
            }
            if (drawable != null) {
                v.k(drawable);
            }
            if (avVarA.hasValue(a.j.AppCompatImageView_tint)) {
                android.support.v4.widget.f.setImageTintList(this.mC, avVarA.getColorStateList(a.j.AppCompatImageView_tint));
            }
            if (avVarA.hasValue(a.j.AppCompatImageView_tintMode)) {
                android.support.v4.widget.f.a(this.mC, v.d(avVarA.getInt(a.j.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            avVarA.recycle();
        }
    }

    public final void setImageResource(int i) {
        if (i != 0) {
            Drawable drawableA = android.support.v7.b.a.a.a(this.mC.getContext(), i);
            if (drawableA != null) {
                v.k(drawableA);
            }
            this.mC.setImageDrawable(drawableA);
        } else {
            this.mC.setImageDrawable(null);
        }
        cI();
    }

    final boolean hasOverlappingRendering() {
        return Build.VERSION.SDK_INT < 21 || !(this.mC.getBackground() instanceof RippleDrawable);
    }

    final void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.mE == null) {
            this.mE = new at();
        }
        at atVar = this.mE;
        atVar.ay = colorStateList;
        atVar.fD = true;
        cI();
    }

    final ColorStateList getSupportImageTintList() {
        at atVar = this.mE;
        if (atVar != null) {
            return atVar.ay;
        }
        return null;
    }

    final void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.mE == null) {
            this.mE = new at();
        }
        at atVar = this.mE;
        atVar.aB = mode;
        atVar.fE = true;
        cI();
    }

    final PorterDuff.Mode getSupportImageTintMode() {
        at atVar = this.mE;
        if (atVar != null) {
            return atVar.aB;
        }
        return null;
    }

    final void cI() {
        Drawable drawable = this.mC.getDrawable();
        if (drawable != null) {
            v.k(drawable);
        }
        if (drawable != null) {
            if (cG() && i(drawable)) {
                return;
            }
            at atVar = this.mE;
            if (atVar != null) {
                h.a(drawable, atVar, this.mC.getDrawableState());
                return;
            }
            at atVar2 = this.mD;
            if (atVar2 != null) {
                h.a(drawable, atVar2, this.mC.getDrawableState());
            }
        }
    }

    private boolean cG() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.mD != null : i == 21;
    }

    private boolean i(Drawable drawable) {
        if (this.ml == null) {
            this.ml = new at();
        }
        at atVar = this.ml;
        atVar.clear();
        ColorStateList colorStateListA = android.support.v4.widget.f.a(this.mC);
        if (colorStateListA != null) {
            atVar.fD = true;
            atVar.ay = colorStateListA;
        }
        PorterDuff.Mode modeB = android.support.v4.widget.f.b(this.mC);
        if (modeB != null) {
            atVar.fE = true;
            atVar.aB = modeB;
        }
        if (!atVar.fD && !atVar.fE) {
            return false;
        }
        h.a(drawable, atVar, this.mC.getDrawableState());
        return true;
    }
}
