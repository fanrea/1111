package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class ar {
    private static final ThreadLocal<TypedValue> et = new ThreadLocal<>();
    static final int[] vf = {-16842910};
    static final int[] FOCUSED_STATE_SET = {R.attr.state_focused};
    static final int[] vg = {R.attr.state_activated};
    static final int[] PRESSED_STATE_SET = {R.attr.state_pressed};
    static final int[] vh = {R.attr.state_checked};
    static final int[] SELECTED_STATE_SET = {R.attr.state_selected};
    static final int[] vi = {-16842919, -16842908};
    static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] vj = new int[1];

    public static int l(Context context, int i) {
        int[] iArr = vj;
        iArr[0] = i;
        av avVarA = av.a(context, (AttributeSet) null, iArr);
        try {
            return avVarA.getColor(0, 0);
        } finally {
            avVarA.recycle();
        }
    }

    public static ColorStateList m(Context context, int i) {
        int[] iArr = vj;
        iArr[0] = i;
        av avVarA = av.a(context, (AttributeSet) null, iArr);
        try {
            return avVarA.getColorStateList(0);
        } finally {
            avVarA.recycle();
        }
    }

    public static int n(Context context, int i) {
        ColorStateList colorStateListM = m(context, i);
        if (colorStateListM != null && colorStateListM.isStateful()) {
            return colorStateListM.getColorForState(vf, colorStateListM.getDefaultColor());
        }
        TypedValue typedValueAs = as();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueAs, true);
        return a(context, i, typedValueAs.getFloat());
    }

    private static TypedValue as() {
        TypedValue typedValue = et.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        et.set(typedValue2);
        return typedValue2;
    }

    private static int a(Context context, int i, float f) {
        return android.support.v4.graphics.a.c(l(context, i), Math.round(Color.alpha(r0) * f));
    }
}
