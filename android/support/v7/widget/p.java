package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.a.d;
import android.support.v7.a.a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class p {
    private final TextView mW;
    private at mX;
    private at mY;
    private at mZ;
    private at na;
    private at nb;
    private at nc;
    private final r nd;
    private int ne = 0;
    private Typeface nf;
    private boolean ng;

    p(TextView textView) {
        this.mW = textView;
        this.nd = new r(this.mW);
    }

    final void a(AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        boolean z;
        boolean z2;
        Context context = this.mW.getContext();
        h hVarCH = h.cH();
        av avVarA = av.a(context, attributeSet, a.j.AppCompatTextHelper, i, 0);
        int resourceId = avVarA.getResourceId(a.j.AppCompatTextHelper_android_textAppearance, -1);
        if (avVarA.hasValue(a.j.AppCompatTextHelper_android_drawableLeft)) {
            this.mX = a(context, hVarCH, avVarA.getResourceId(a.j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (avVarA.hasValue(a.j.AppCompatTextHelper_android_drawableTop)) {
            this.mY = a(context, hVarCH, avVarA.getResourceId(a.j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (avVarA.hasValue(a.j.AppCompatTextHelper_android_drawableRight)) {
            this.mZ = a(context, hVarCH, avVarA.getResourceId(a.j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (avVarA.hasValue(a.j.AppCompatTextHelper_android_drawableBottom)) {
            this.na = a(context, hVarCH, avVarA.getResourceId(a.j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (avVarA.hasValue(a.j.AppCompatTextHelper_android_drawableStart)) {
                this.nb = a(context, hVarCH, avVarA.getResourceId(a.j.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (avVarA.hasValue(a.j.AppCompatTextHelper_android_drawableEnd)) {
                this.nc = a(context, hVarCH, avVarA.getResourceId(a.j.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        avVarA.recycle();
        boolean z3 = this.mW.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z4 = true;
        if (resourceId != -1) {
            av avVarA2 = av.a(context, resourceId, a.j.TextAppearance);
            if (z3 || !avVarA2.hasValue(a.j.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = avVarA2.getBoolean(a.j.TextAppearance_textAllCaps, false);
                z = true;
            }
            a(context, avVarA2);
            if (Build.VERSION.SDK_INT < 23) {
                ColorStateList colorStateList3 = avVarA2.hasValue(a.j.TextAppearance_android_textColor) ? avVarA2.getColorStateList(a.j.TextAppearance_android_textColor) : null;
                colorStateList2 = avVarA2.hasValue(a.j.TextAppearance_android_textColorHint) ? avVarA2.getColorStateList(a.j.TextAppearance_android_textColorHint) : null;
                ColorStateList colorStateList4 = colorStateList3;
                colorStateList = avVarA2.hasValue(a.j.TextAppearance_android_textColorLink) ? avVarA2.getColorStateList(a.j.TextAppearance_android_textColorLink) : null;
                colorStateList = colorStateList4;
            } else {
                colorStateList = null;
                colorStateList2 = null;
            }
            avVarA2.recycle();
        } else {
            colorStateList = null;
            colorStateList2 = null;
            z = false;
            z2 = false;
        }
        av avVarA3 = av.a(context, attributeSet, a.j.TextAppearance, i, 0);
        if (z3 || !avVarA3.hasValue(a.j.TextAppearance_textAllCaps)) {
            z4 = z;
        } else {
            z2 = avVarA3.getBoolean(a.j.TextAppearance_textAllCaps, false);
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (avVarA3.hasValue(a.j.TextAppearance_android_textColor)) {
                colorStateList = avVarA3.getColorStateList(a.j.TextAppearance_android_textColor);
            }
            if (avVarA3.hasValue(a.j.TextAppearance_android_textColorHint)) {
                colorStateList2 = avVarA3.getColorStateList(a.j.TextAppearance_android_textColorHint);
            }
            if (avVarA3.hasValue(a.j.TextAppearance_android_textColorLink)) {
                colorStateList = avVarA3.getColorStateList(a.j.TextAppearance_android_textColorLink);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && avVarA3.hasValue(a.j.TextAppearance_android_textSize) && avVarA3.getDimensionPixelSize(a.j.TextAppearance_android_textSize, -1) == 0) {
            this.mW.setTextSize(0, 0.0f);
        }
        a(context, avVarA3);
        avVarA3.recycle();
        if (colorStateList != null) {
            this.mW.setTextColor(colorStateList);
        }
        if (colorStateList2 != null) {
            this.mW.setHintTextColor(colorStateList2);
        }
        if (colorStateList != null) {
            this.mW.setLinkTextColor(colorStateList);
        }
        if (!z3 && z4) {
            setAllCaps(z2);
        }
        Typeface typeface = this.nf;
        if (typeface != null) {
            this.mW.setTypeface(typeface, this.ne);
        }
        this.nd.a(attributeSet, i);
        if (android.support.v4.widget.b.du && this.nd.getAutoSizeTextType() != 0) {
            int[] autoSizeTextAvailableSizes = this.nd.getAutoSizeTextAvailableSizes();
            if (autoSizeTextAvailableSizes.length > 0) {
                if (this.mW.getAutoSizeStepGranularity() != -1.0f) {
                    this.mW.setAutoSizeTextTypeUniformWithConfiguration(this.nd.getAutoSizeMinTextSize(), this.nd.getAutoSizeMaxTextSize(), this.nd.getAutoSizeStepGranularity(), 0);
                } else {
                    this.mW.setAutoSizeTextTypeUniformWithPresetSizes(autoSizeTextAvailableSizes, 0);
                }
            }
        }
        av avVarA4 = av.a(context, attributeSet, a.j.AppCompatTextView);
        int dimensionPixelSize = avVarA4.getDimensionPixelSize(a.j.AppCompatTextView_firstBaselineToTopHeight, -1);
        int dimensionPixelSize2 = avVarA4.getDimensionPixelSize(a.j.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int dimensionPixelSize3 = avVarA4.getDimensionPixelSize(a.j.AppCompatTextView_lineHeight, -1);
        avVarA4.recycle();
        if (dimensionPixelSize != -1) {
            android.support.v4.widget.k.a(this.mW, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != -1) {
            android.support.v4.widget.k.b(this.mW, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != -1) {
            android.support.v4.widget.k.c(this.mW, dimensionPixelSize3);
        }
    }

    private void a(Context context, av avVar) {
        String string;
        this.ne = avVar.getInt(a.j.TextAppearance_android_textStyle, this.ne);
        if (avVar.hasValue(a.j.TextAppearance_android_fontFamily) || avVar.hasValue(a.j.TextAppearance_fontFamily)) {
            this.nf = null;
            int i = avVar.hasValue(a.j.TextAppearance_fontFamily) ? a.j.TextAppearance_fontFamily : a.j.TextAppearance_android_fontFamily;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.mW);
                try {
                    this.nf = avVar.a(i, this.ne, new d.a() { // from class: android.support.v7.widget.p.1
                        @Override // android.support.v4.content.a.d.a
                        public final void a(Typeface typeface) {
                            p.this.a(weakReference, typeface);
                        }
                    });
                    this.ng = this.nf == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.nf != null || (string = avVar.getString(i)) == null) {
                return;
            }
            this.nf = Typeface.create(string, this.ne);
            return;
        }
        if (avVar.hasValue(a.j.TextAppearance_android_typeface)) {
            this.ng = false;
            int i2 = avVar.getInt(a.j.TextAppearance_android_typeface, 1);
            if (i2 == 1) {
                this.nf = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.nf = Typeface.SERIF;
            } else {
                if (i2 != 3) {
                    return;
                }
                this.nf = Typeface.MONOSPACE;
            }
        }
    }

    final void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.ng) {
            this.nf = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.ne);
            }
        }
    }

    final void k(Context context, int i) {
        ColorStateList colorStateList;
        av avVarA = av.a(context, i, a.j.TextAppearance);
        if (avVarA.hasValue(a.j.TextAppearance_textAllCaps)) {
            setAllCaps(avVarA.getBoolean(a.j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && avVarA.hasValue(a.j.TextAppearance_android_textColor) && (colorStateList = avVarA.getColorStateList(a.j.TextAppearance_android_textColor)) != null) {
            this.mW.setTextColor(colorStateList);
        }
        if (avVarA.hasValue(a.j.TextAppearance_android_textSize) && avVarA.getDimensionPixelSize(a.j.TextAppearance_android_textSize, -1) == 0) {
            this.mW.setTextSize(0, 0.0f);
        }
        a(context, avVarA);
        avVarA.recycle();
        Typeface typeface = this.nf;
        if (typeface != null) {
            this.mW.setTypeface(typeface, this.ne);
        }
    }

    private void setAllCaps(boolean z) {
        this.mW.setAllCaps(z);
    }

    final void cK() {
        if (this.mX != null || this.mY != null || this.mZ != null || this.na != null) {
            Drawable[] compoundDrawables = this.mW.getCompoundDrawables();
            a(compoundDrawables[0], this.mX);
            a(compoundDrawables[1], this.mY);
            a(compoundDrawables[2], this.mZ);
            a(compoundDrawables[3], this.na);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.nb == null && this.nc == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.mW.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.nb);
            a(compoundDrawablesRelative[2], this.nc);
        }
    }

    private void a(Drawable drawable, at atVar) {
        if (drawable == null || atVar == null) {
            return;
        }
        h.a(drawable, atVar, this.mW.getDrawableState());
    }

    private static at a(Context context, h hVar, int i) {
        ColorStateList colorStateListH = hVar.h(context, i);
        if (colorStateListH == null) {
            return null;
        }
        at atVar = new at();
        atVar.fD = true;
        atVar.ay = colorStateListH;
        return atVar;
    }

    final void cL() {
        if (android.support.v4.widget.b.du) {
            return;
        }
        cM();
    }

    final void setTextSize(int i, float f) {
        if (android.support.v4.widget.b.du || cN()) {
            return;
        }
        b(i, f);
    }

    final void cM() {
        this.nd.cM();
    }

    final boolean cN() {
        return this.nd.cN();
    }

    private void b(int i, float f) {
        this.nd.b(i, f);
    }

    final void setAutoSizeTextTypeWithDefaults(int i) {
        this.nd.setAutoSizeTextTypeWithDefaults(i);
    }

    final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        this.nd.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
    }

    final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        this.nd.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
    }

    final int getAutoSizeTextType() {
        return this.nd.getAutoSizeTextType();
    }

    final int getAutoSizeStepGranularity() {
        return this.nd.getAutoSizeStepGranularity();
    }

    final int getAutoSizeMinTextSize() {
        return this.nd.getAutoSizeMinTextSize();
    }

    final int getAutoSizeMaxTextSize() {
        return this.nd.getAutoSizeMaxTextSize();
    }

    final int[] getAutoSizeTextAvailableSizes() {
        return this.nd.getAutoSizeTextAvailableSizes();
    }
}
