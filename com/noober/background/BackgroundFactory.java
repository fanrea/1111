package com.noober.background;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class BackgroundFactory implements LayoutInflater.Factory2 {
    private LayoutInflater.Factory mViewCreateFactory;
    private LayoutInflater.Factory2 mViewCreateFactory2;
    private static final Class<?>[] sConstructorSignature = {Context.class, AttributeSet.class};
    private static final Object[] mConstructorArgs = new Object[2];
    private static final Map<String, Constructor<? extends View>> sConstructorMap = new ArrayMap();
    private static final HashMap<String, HashMap<String, Method>> methodMap = new HashMap<>();

    private static boolean hasStatus(int i, int i2) {
        return (i & i2) == i2;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = null;
        if (str.startsWith("com.noober.background.view")) {
            return null;
        }
        LayoutInflater.Factory2 factory2 = this.mViewCreateFactory2;
        if (factory2 != null) {
            View viewOnCreateView2 = factory2.onCreateView(str, context, attributeSet);
            viewOnCreateView = viewOnCreateView2 == null ? this.mViewCreateFactory2.onCreateView(null, str, context, attributeSet) : viewOnCreateView2;
        } else {
            LayoutInflater.Factory factory = this.mViewCreateFactory;
            if (factory != null) {
                viewOnCreateView = factory.onCreateView(str, context, attributeSet);
            }
        }
        return setViewBackground(str, context, attributeSet, viewOnCreateView);
    }

    public static View setViewBackground(Context context, AttributeSet attributeSet, View view) {
        return setViewBackground(null, context, attributeSet, view);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01d9 A[Catch: Exception -> 0x028c, all -> 0x02c1, TryCatch #0 {all -> 0x02c1, blocks: (B:92:0x01af, B:94:0x01b3, B:96:0x01b9, B:107:0x01e9, B:109:0x01f2, B:111:0x01fa, B:115:0x0209, B:117:0x0218, B:118:0x023e, B:120:0x0246, B:122:0x0252, B:124:0x0260, B:97:0x01c4, B:99:0x01c8, B:101:0x01ce, B:102:0x01d9, B:104:0x01dd, B:106:0x01e3, B:87:0x01a4, B:89:0x01aa, B:137:0x029a), top: B:147:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01f2 A[Catch: Exception -> 0x028c, all -> 0x02c1, TryCatch #0 {all -> 0x02c1, blocks: (B:92:0x01af, B:94:0x01b3, B:96:0x01b9, B:107:0x01e9, B:109:0x01f2, B:111:0x01fa, B:115:0x0209, B:117:0x0218, B:118:0x023e, B:120:0x0246, B:122:0x0252, B:124:0x0260, B:97:0x01c4, B:99:0x01c8, B:101:0x01ce, B:102:0x01d9, B:104:0x01dd, B:106:0x01e3, B:87:0x01a4, B:89:0x01aa, B:137:0x029a), top: B:147:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0246 A[Catch: Exception -> 0x028c, all -> 0x02c1, TryCatch #0 {all -> 0x02c1, blocks: (B:92:0x01af, B:94:0x01b3, B:96:0x01b9, B:107:0x01e9, B:109:0x01f2, B:111:0x01fa, B:115:0x0209, B:117:0x0218, B:118:0x023e, B:120:0x0246, B:122:0x0252, B:124:0x0260, B:97:0x01c4, B:99:0x01c8, B:101:0x01ce, B:102:0x01d9, B:104:0x01dd, B:106:0x01e3, B:87:0x01a4, B:89:0x01aa, B:137:0x029a), top: B:147:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b3 A[Catch: Exception -> 0x028c, all -> 0x02c1, TryCatch #0 {all -> 0x02c1, blocks: (B:92:0x01af, B:94:0x01b3, B:96:0x01b9, B:107:0x01e9, B:109:0x01f2, B:111:0x01fa, B:115:0x0209, B:117:0x0218, B:118:0x023e, B:120:0x0246, B:122:0x0252, B:124:0x0260, B:97:0x01c4, B:99:0x01c8, B:101:0x01ce, B:102:0x01d9, B:104:0x01dd, B:106:0x01e3, B:87:0x01a4, B:89:0x01aa, B:137:0x029a), top: B:147:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c4 A[Catch: Exception -> 0x028c, all -> 0x02c1, TryCatch #0 {all -> 0x02c1, blocks: (B:92:0x01af, B:94:0x01b3, B:96:0x01b9, B:107:0x01e9, B:109:0x01f2, B:111:0x01fa, B:115:0x0209, B:117:0x0218, B:118:0x023e, B:120:0x0246, B:122:0x0252, B:124:0x0260, B:97:0x01c4, B:99:0x01c8, B:101:0x01ce, B:102:0x01d9, B:104:0x01dd, B:106:0x01e3, B:87:0x01a4, B:89:0x01aa, B:137:0x029a), top: B:147:0x004f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.view.View setViewBackground(java.lang.String r20, android.content.Context r21, android.util.AttributeSet r22, android.view.View r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 742
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.noober.background.BackgroundFactory.setViewBackground(java.lang.String, android.content.Context, android.util.AttributeSet, android.view.View):android.view.View");
    }

    private static Method getMethod(Class cls, String str) {
        Method methodFindMethod;
        HashMap<String, HashMap<String, Method>> map = methodMap;
        HashMap<String, Method> map2 = map.get(cls.getCanonicalName());
        if (map2 != null) {
            methodFindMethod = map.get(cls.getCanonicalName()).get(str);
        } else {
            map2 = new HashMap<>();
            map.put(cls.getCanonicalName(), map2);
            methodFindMethod = null;
        }
        if (methodFindMethod == null && (methodFindMethod = findMethod(cls, str)) != null) {
            map2.put(str, methodFindMethod);
        }
        return methodFindMethod;
    }

    private static Method findMethod(Class cls, String str) {
        try {
            return cls.getMethod(str, new Class[0]);
        } catch (NoSuchMethodException unused) {
            return findDeclaredMethod(cls, str);
        }
    }

    private static Method findDeclaredMethod(Class cls, String str) throws NoSuchMethodException, SecurityException {
        Method declaredMethod = null;
        try {
            declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            return cls.getSuperclass() != null ? findDeclaredMethod(cls.getSuperclass(), str) : declaredMethod;
        }
    }

    private static void setDrawable(Drawable drawable, View view, TypedArray typedArray, TypedArray typedArray2) {
        if (view instanceof TextView) {
            if (typedArray.hasValue(R.styleable.bl_other_bl_position)) {
                if (typedArray.getInt(R.styleable.bl_other_bl_position, 0) == 1) {
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    ((TextView) view).setCompoundDrawables(drawable, null, null, null);
                    return;
                }
                if (typedArray.getInt(R.styleable.bl_other_bl_position, 0) == 2) {
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    ((TextView) view).setCompoundDrawables(null, drawable, null, null);
                    return;
                } else if (typedArray.getInt(R.styleable.bl_other_bl_position, 0) == 4) {
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    ((TextView) view).setCompoundDrawables(null, null, drawable, null);
                    return;
                } else {
                    if (typedArray.getInt(R.styleable.bl_other_bl_position, 0) == 8) {
                        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                        ((TextView) view).setCompoundDrawables(null, null, null, drawable);
                        return;
                    }
                    return;
                }
            }
            setBackground(drawable, view, typedArray2);
            return;
        }
        setBackground(drawable, view, typedArray2);
    }

    private static void setBackground(Drawable drawable, View view, TypedArray typedArray) {
        Drawable drawable2;
        float f = 0.0f;
        if (typedArray.hasValue(R.styleable.background_bl_stroke_width) && typedArray.hasValue(R.styleable.background_bl_stroke_position)) {
            float dimension = typedArray.getDimension(R.styleable.background_bl_stroke_width, 0.0f);
            int i = typedArray.getInt(R.styleable.background_bl_stroke_position, 0);
            float f2 = hasStatus(i, 2) ? 0.0f : -dimension;
            float f3 = hasStatus(i, 4) ? 0.0f : -dimension;
            float f4 = hasStatus(i, 8) ? 0.0f : -dimension;
            float f5 = hasStatus(i, 16) ? 0.0f : -dimension;
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable});
            layerDrawable.setLayerInset(0, (int) f2, (int) f3, (int) f4, (int) f5);
            drawable2 = layerDrawable;
        } else {
            drawable2 = drawable;
        }
        if (typedArray.hasValue(R.styleable.background_bl_shape_alpha)) {
            float f6 = typedArray.getFloat(R.styleable.background_bl_shape_alpha, 0.0f);
            if (f6 >= 1.0f) {
                f = 255.0f;
            } else if (f6 > 0.0f) {
                f = f6 * 255.0f;
            }
            drawable2.setAlpha((int) f);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable2);
        } else {
            view.setBackgroundDrawable(drawable2);
        }
    }

    public void setInterceptFactory(LayoutInflater.Factory factory) {
        this.mViewCreateFactory = factory;
    }

    public void setInterceptFactory2(LayoutInflater.Factory2 factory2) {
        this.mViewCreateFactory2 = factory2;
    }

    private static View createViewFromTag(Context context, String str, AttributeSet attributeSet) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            try {
                Object[] objArr = mConstructorArgs;
                objArr[0] = context;
                objArr[1] = attributeSet;
                if (-1 != str.indexOf(46)) {
                    View viewCreateView = createView(context, str, null);
                    objArr[0] = null;
                    objArr[1] = null;
                    return viewCreateView;
                }
                View viewCreateView2 = "View".equals(str) ? createView(context, str, "android.view.") : null;
                if (viewCreateView2 == null) {
                    viewCreateView2 = createView(context, str, "android.widget.");
                }
                if (viewCreateView2 == null) {
                    viewCreateView2 = createView(context, str, "android.webkit.");
                }
                objArr[0] = null;
                objArr[1] = null;
                return viewCreateView2;
            } catch (Exception unused) {
                Log.w("BackgroundLibrary", "cannot create 【" + str + "】 : ");
                Object[] objArr2 = mConstructorArgs;
                objArr2[0] = null;
                objArr2[1] = null;
                return null;
            }
        } catch (Throwable th) {
            Object[] objArr3 = mConstructorArgs;
            objArr3[0] = null;
            objArr3[1] = null;
            throw th;
        }
    }

    private static View createView(Context context, String str, String str2) throws InflateException, NoSuchMethodException, SecurityException {
        Map<String, Constructor<? extends View>> map = sConstructorMap;
        Constructor<? extends View> constructor = map.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(sConstructorSignature);
                map.put(str, constructor);
            } catch (Exception unused) {
                Log.w("BackgroundLibrary", "cannot create 【" + str + "】 : ");
                return null;
            }
        }
        constructor.setAccessible(true);
        return constructor.newInstance(mConstructorArgs);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return onCreateView(str, context, attributeSet);
    }

    private static boolean hasGradientState(TypedArray typedArray) {
        return typedArray.hasValue(R.styleable.background_bl_checkable_gradient_startColor) || typedArray.hasValue(R.styleable.background_bl_checked_gradient_startColor) || typedArray.hasValue(R.styleable.background_bl_enabled_gradient_startColor) || typedArray.hasValue(R.styleable.background_bl_selected_gradient_startColor) || typedArray.hasValue(R.styleable.background_bl_pressed_gradient_startColor) || typedArray.hasValue(R.styleable.background_bl_focused_gradient_startColor);
    }
}
