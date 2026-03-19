package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.support.v7.a.a;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class r {
    private static final RectF nk = new RectF();
    private static ConcurrentHashMap<String, Method> nl = new ConcurrentHashMap<>();
    private final TextView em;
    private final Context mContext;
    private int nm = 0;
    private boolean nn = false;
    private float no = -1.0f;
    private float np = -1.0f;
    private float nq = -1.0f;
    private int[] nr = new int[0];
    private boolean ns = false;
    private TextPaint nt;

    r(TextView textView) {
        this.em = textView;
        this.mContext = this.em.getContext();
    }

    final void a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, a.j.AppCompatTextView, i, 0);
        if (typedArrayObtainStyledAttributes.hasValue(a.j.AppCompatTextView_autoSizeTextType)) {
            this.nm = typedArrayObtainStyledAttributes.getInt(a.j.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(a.j.AppCompatTextView_autoSizeStepGranularity) ? typedArrayObtainStyledAttributes.getDimension(a.j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(a.j.AppCompatTextView_autoSizeMinTextSize) ? typedArrayObtainStyledAttributes.getDimension(a.j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(a.j.AppCompatTextView_autoSizeMaxTextSize) ? typedArrayObtainStyledAttributes.getDimension(a.j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(a.j.AppCompatTextView_autoSizePresetSizes) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(a.j.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            b(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (cS()) {
            if (this.nm == 1) {
                if (!this.ns) {
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    if (dimension2 == -1.0f) {
                        dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (dimension3 == -1.0f) {
                        dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (dimension == -1.0f) {
                        dimension = 1.0f;
                    }
                    b(dimension2, dimension3, dimension);
                }
                cQ();
                return;
            }
            return;
        }
        this.nm = 0;
    }

    final void setAutoSizeTextTypeWithDefaults(int i) {
        if (cS()) {
            if (i == 0) {
                cR();
                return;
            }
            if (i == 1) {
                DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                b(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                if (cQ()) {
                    cM();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Unknown auto-size text type: " + i);
        }
    }

    final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (cS()) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            b(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (cQ()) {
                cM();
            }
        }
    }

    final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (cS()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                this.nr = d(iArrCopyOf);
                if (!cP()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.ns = false;
            }
            if (cQ()) {
                cM();
            }
        }
    }

    final int getAutoSizeTextType() {
        return this.nm;
    }

    final int getAutoSizeStepGranularity() {
        return Math.round(this.no);
    }

    final int getAutoSizeMinTextSize() {
        return Math.round(this.np);
    }

    final int getAutoSizeMaxTextSize() {
        return Math.round(this.nq);
    }

    final int[] getAutoSizeTextAvailableSizes() {
        return this.nr;
    }

    private void b(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.nr = d(iArr);
            cP();
        }
    }

    private boolean cP() {
        this.ns = this.nr.length > 0;
        if (this.ns) {
            this.nm = 1;
            int[] iArr = this.nr;
            this.np = iArr[0];
            this.nq = iArr[r0 - 1];
            this.no = -1.0f;
        }
        return this.ns;
    }

    private static int[] d(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    private void b(float f, float f2, float f3) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        }
        if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        }
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
        this.nm = 1;
        this.np = f;
        this.nq = f2;
        this.no = f3;
        this.ns = false;
    }

    private boolean cQ() {
        if (cS() && this.nm == 1) {
            if (!this.ns || this.nr.length == 0) {
                float fRound = Math.round(this.np);
                int i = 1;
                while (Math.round(this.no + fRound) <= Math.round(this.nq)) {
                    i++;
                    fRound += this.no;
                }
                int[] iArr = new int[i];
                float f = this.np;
                for (int i2 = 0; i2 < i; i2++) {
                    iArr[i2] = Math.round(f);
                    f += this.no;
                }
                this.nr = d(iArr);
            }
            this.nn = true;
        } else {
            this.nn = false;
        }
        return this.nn;
    }

    final void cM() {
        if (cN()) {
            if (this.nn) {
                if (this.em.getMeasuredHeight() <= 0 || this.em.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = ((Boolean) b((Object) this.em, "getHorizontallyScrolling", (String) Boolean.FALSE)).booleanValue() ? 1048576 : (this.em.getMeasuredWidth() - this.em.getTotalPaddingLeft()) - this.em.getTotalPaddingRight();
                int height = (this.em.getHeight() - this.em.getCompoundPaddingBottom()) - this.em.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                synchronized (nk) {
                    nk.setEmpty();
                    nk.right = measuredWidth;
                    nk.bottom = height;
                    float fA = a(nk);
                    if (fA != this.em.getTextSize()) {
                        b(0, fA);
                    }
                }
            }
            this.nn = true;
        }
    }

    private void cR() {
        this.nm = 0;
        this.np = -1.0f;
        this.nq = -1.0f;
        this.no = -1.0f;
        this.nr = new int[0];
        this.nn = false;
    }

    final void b(int i, float f) {
        Resources resources;
        Context context = this.mContext;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        c(TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
    }

    private void c(float f) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f != this.em.getPaint().getTextSize()) {
            this.em.getPaint().setTextSize(f);
            boolean zIsInLayout = Build.VERSION.SDK_INT >= 18 ? this.em.isInLayout() : false;
            if (this.em.getLayout() != null) {
                this.nn = false;
                try {
                    Method methodF = f("nullLayouts");
                    if (methodF != null) {
                        methodF.invoke(this.em, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (!zIsInLayout) {
                    this.em.requestLayout();
                } else {
                    this.em.forceLayout();
                }
                this.em.invalidate();
            }
        }
    }

    private int a(RectF rectF) {
        int length = this.nr.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i = length - 1;
        int i2 = 1;
        int i3 = 0;
        while (i2 <= i) {
            int i4 = (i2 + i) / 2;
            if (a(this.nr[i4], rectF)) {
                int i5 = i4 + 1;
                i3 = i2;
                i2 = i5;
            } else {
                i3 = i4 - 1;
                i = i3;
            }
        }
        return this.nr[i3];
    }

    private boolean a(int i, RectF rectF) {
        StaticLayout staticLayoutA;
        CharSequence transformation;
        CharSequence text = this.em.getText();
        TransformationMethod transformationMethod = this.em.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.em)) != null) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.em.getMaxLines() : -1;
        TextPaint textPaint = this.nt;
        if (textPaint == null) {
            this.nt = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.nt.set(this.em.getPaint());
        this.nt.setTextSize(i);
        Layout.Alignment alignment = (Layout.Alignment) b((Object) this.em, "getLayoutAlignment", (String) Layout.Alignment.ALIGN_NORMAL);
        if (Build.VERSION.SDK_INT >= 23) {
            staticLayoutA = a(text, alignment, Math.round(rectF.right), maxLines);
        } else {
            staticLayoutA = a(text, alignment, Math.round(rectF.right));
        }
        return (maxLines == -1 || (staticLayoutA.getLineCount() <= maxLines && staticLayoutA.getLineEnd(staticLayoutA.getLineCount() - 1) == text.length())) && ((float) staticLayoutA.getHeight()) <= rectF.bottom;
    }

    private StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) b((Object) this.em, "getTextDirectionHeuristic", (String) TextDirectionHeuristics.FIRSTSTRONG_LTR);
        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.nt, i).setAlignment(alignment).setLineSpacing(this.em.getLineSpacingExtra(), this.em.getLineSpacingMultiplier()).setIncludePad(this.em.getIncludeFontPadding()).setBreakStrategy(this.em.getBreakStrategy()).setHyphenationFrequency(this.em.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        return hyphenationFrequency.setMaxLines(i2).setTextDirection(textDirectionHeuristic).build();
    }

    private StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i) {
        float fFloatValue;
        float fFloatValue2;
        boolean zBooleanValue;
        if (Build.VERSION.SDK_INT >= 16) {
            fFloatValue = this.em.getLineSpacingMultiplier();
            fFloatValue2 = this.em.getLineSpacingExtra();
            zBooleanValue = this.em.getIncludeFontPadding();
        } else {
            fFloatValue = ((Float) b((Object) this.em, "getLineSpacingMultiplier", (String) Float.valueOf(1.0f))).floatValue();
            fFloatValue2 = ((Float) b((Object) this.em, "getLineSpacingExtra", (String) Float.valueOf(0.0f))).floatValue();
            zBooleanValue = ((Boolean) b((Object) this.em, "getIncludeFontPadding", (String) Boolean.TRUE)).booleanValue();
        }
        return new StaticLayout(charSequence, this.nt, i, alignment, fFloatValue, fFloatValue2, zBooleanValue);
    }

    private <T> T b(Object obj, String str, T t) {
        try {
            return (T) f(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return t;
        }
    }

    private static Method f(String str) {
        try {
            Method declaredMethod = nl.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                nl.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    final boolean cN() {
        return cS() && this.nm != 0;
    }

    private boolean cS() {
        return !(this.em instanceof i);
    }
}
