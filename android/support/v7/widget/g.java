package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class g {
    private final View cu;
    private at mj;
    private at mk;
    private at ml;
    private int mi = -1;
    private final h mh = h.cH();

    g(View view) {
        this.cu = view;
    }

    final void a(AttributeSet attributeSet, int i) {
        av avVarA = av.a(this.cu.getContext(), attributeSet, a.j.ViewBackgroundHelper, i, 0);
        try {
            if (avVarA.hasValue(a.j.ViewBackgroundHelper_android_background)) {
                this.mi = avVarA.getResourceId(a.j.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateListH = this.mh.h(this.cu.getContext(), this.mi);
                if (colorStateListH != null) {
                    a(colorStateListH);
                }
            }
            if (avVarA.hasValue(a.j.ViewBackgroundHelper_backgroundTint)) {
                android.support.v4.e.o.a(this.cu, avVarA.getColorStateList(a.j.ViewBackgroundHelper_backgroundTint));
            }
            if (avVarA.hasValue(a.j.ViewBackgroundHelper_backgroundTintMode)) {
                android.support.v4.e.o.a(this.cu, v.d(avVarA.getInt(a.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            avVarA.recycle();
        }
    }

    final void aa(int i) {
        this.mi = i;
        h hVar = this.mh;
        a(hVar != null ? hVar.h(this.cu.getContext(), i) : null);
        cF();
    }

    final void cE() {
        this.mi = -1;
        a(null);
        cF();
    }

    final void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.mk == null) {
            this.mk = new at();
        }
        at atVar = this.mk;
        atVar.ay = colorStateList;
        atVar.fD = true;
        cF();
    }

    final ColorStateList getSupportBackgroundTintList() {
        at atVar = this.mk;
        if (atVar != null) {
            return atVar.ay;
        }
        return null;
    }

    final void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.mk == null) {
            this.mk = new at();
        }
        at atVar = this.mk;
        atVar.aB = mode;
        atVar.fE = true;
        cF();
    }

    final PorterDuff.Mode getSupportBackgroundTintMode() {
        at atVar = this.mk;
        if (atVar != null) {
            return atVar.aB;
        }
        return null;
    }

    final void cF() {
        Drawable background = this.cu.getBackground();
        if (background != null) {
            if (cG() && i(background)) {
                return;
            }
            at atVar = this.mk;
            if (atVar != null) {
                h.a(background, atVar, this.cu.getDrawableState());
                return;
            }
            at atVar2 = this.mj;
            if (atVar2 != null) {
                h.a(background, atVar2, this.cu.getDrawableState());
            }
        }
    }

    private void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.mj == null) {
                this.mj = new at();
            }
            at atVar = this.mj;
            atVar.ay = colorStateList;
            atVar.fD = true;
        } else {
            this.mj = null;
        }
        cF();
    }

    private boolean cG() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.mj != null : i == 21;
    }

    private boolean i(Drawable drawable) {
        if (this.ml == null) {
            this.ml = new at();
        }
        at atVar = this.ml;
        atVar.clear();
        ColorStateList colorStateListN = android.support.v4.e.o.n(this.cu);
        if (colorStateListN != null) {
            atVar.fD = true;
            atVar.ay = colorStateListN;
        }
        PorterDuff.Mode modeO = android.support.v4.e.o.o(this.cu);
        if (modeO != null) {
            atVar.fE = true;
            atVar.aB = modeO;
        }
        if (!atVar.fD && !atVar.fE) {
            return false;
        }
        h.a(drawable, atVar, this.cu.getDrawableState());
        return true;
    }
}
