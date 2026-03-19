package android.support.v7.b.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.h;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class a {
    private static final ThreadLocal<TypedValue> et = new ThreadLocal<>();
    private static final WeakHashMap<Context, SparseArray<C0012a>> eu = new WeakHashMap<>(0);
    private static final Object ev = new Object();

    public static ColorStateList b(Context context, int i) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList colorStateListD = d(context, i);
        if (colorStateListD != null) {
            return colorStateListD;
        }
        ColorStateList colorStateListC = c(context, i);
        if (colorStateListC != null) {
            a(context, i, colorStateListC);
            return colorStateListC;
        }
        return android.support.v4.content.a.b(context, i);
    }

    public static Drawable a(Context context, int i) {
        return h.cH().a(context, i);
    }

    private static ColorStateList c(Context context, int i) throws Resources.NotFoundException {
        if (e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return android.support.v4.content.a.a.createFromXml(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    private static ColorStateList d(Context context, int i) {
        C0012a c0012a;
        synchronized (ev) {
            SparseArray<C0012a> sparseArray = eu.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0012a = sparseArray.get(i)) != null) {
                if (c0012a.ey.equals(context.getResources().getConfiguration())) {
                    return c0012a.ew;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    private static void a(Context context, int i, ColorStateList colorStateList) {
        synchronized (ev) {
            SparseArray<C0012a> sparseArray = eu.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                eu.put(context, sparseArray);
            }
            sparseArray.append(i, new C0012a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static boolean e(Context context, int i) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        TypedValue typedValueAs = as();
        resources.getValue(i, typedValueAs, true);
        return typedValueAs.type >= 28 && typedValueAs.type <= 31;
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

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    /* renamed from: android.support.v7.b.a.a$a, reason: collision with other inner class name */
    static class C0012a {
        final ColorStateList ew;
        final Configuration ey;

        C0012a(ColorStateList colorStateList, Configuration configuration) {
            this.ew = colorStateList;
            this.ey = configuration;
        }
    }
}
