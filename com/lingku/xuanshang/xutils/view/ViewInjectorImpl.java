package com.lingku.xuanshang.xutils.view;

import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lingku.xuanshang.xutils.ViewInjector;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.view.annotation.ContentView;
import com.lingku.xuanshang.xutils.view.annotation.Event;
import com.lingku.xuanshang.xutils.view.annotation.ViewInject;
import com.lingku.xuanshang.xutils.x;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import lkxssdk.t0.a;
import lkxssdk.t0.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ViewInjectorImpl implements ViewInjector {
    public static final HashSet<Class<?>> a;
    public static final Object b;
    public static volatile ViewInjectorImpl c;

    static {
        HashSet<Class<?>> hashSet = new HashSet<>();
        a = hashSet;
        hashSet.add(Object.class);
        hashSet.add(Activity.class);
        hashSet.add(Fragment.class);
        try {
            hashSet.add(Class.forName("android.support.v4.app.Fragment"));
            hashSet.add(Class.forName("android.support.v4.app.FragmentActivity"));
        } catch (Throwable unused) {
        }
        b = new Object();
    }

    public static ContentView a(Class<?> cls) {
        if (cls == null || a.contains(cls) || cls.getName().startsWith("androidx.")) {
            return null;
        }
        ContentView contentView = (ContentView) cls.getAnnotation(ContentView.class);
        return contentView == null ? a(cls.getSuperclass()) : contentView;
    }

    public static void a(Object obj, Class<?> cls, a aVar) throws SecurityException {
        Event event;
        ViewInject viewInject;
        if (cls == null || a.contains(cls) || cls.getName().startsWith("androidx.")) {
            return;
        }
        a(obj, cls.getSuperclass(), aVar);
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                Class<?> type = field.getType();
                if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers()) && !type.isPrimitive() && !type.isArray() && (viewInject = (ViewInject) field.getAnnotation(ViewInject.class)) != null) {
                    try {
                        View viewA = aVar.a(viewInject.value(), viewInject.parentId());
                        if (viewA == null) {
                            throw new RuntimeException("Invalid @ViewInject for " + cls.getSimpleName() + "." + field.getName());
                        }
                        field.setAccessible(true);
                        field.set(obj, viewA);
                    } catch (Throwable th) {
                        LogUtil.e(th.getMessage(), th);
                    }
                }
            }
        }
        Method[] declaredMethods = cls.getDeclaredMethods();
        if (declaredMethods == null || declaredMethods.length <= 0) {
            return;
        }
        for (Method method : declaredMethods) {
            if (!Modifier.isStatic(method.getModifiers()) && Modifier.isPrivate(method.getModifiers()) && (event = (Event) method.getAnnotation(Event.class)) != null) {
                try {
                    int[] iArrValue = event.value();
                    int[] iArrParentId = event.parentId();
                    int length = iArrParentId == null ? 0 : iArrParentId.length;
                    int i = 0;
                    while (i < iArrValue.length) {
                        int i2 = iArrValue[i];
                        if (i2 > 0) {
                            b bVar = new b();
                            bVar.a = i2;
                            bVar.b = length > i ? iArrParentId[i] : 0;
                            method.setAccessible(true);
                            EventListenerManager.a(aVar, bVar, event, obj, method);
                        }
                        i++;
                    }
                } catch (Throwable th2) {
                    LogUtil.e(th2.getMessage(), th2);
                }
            }
        }
    }

    public static void registerInstance() {
        if (c == null) {
            synchronized (b) {
                if (c == null) {
                    c = new ViewInjectorImpl();
                }
            }
        }
        x.Ext.setViewInjector(c);
    }

    @Override // com.lingku.xuanshang.xutils.ViewInjector
    public View inject(Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup) throws SecurityException {
        ContentView contentViewA;
        int iValue;
        Class<?> cls = obj.getClass();
        try {
            contentViewA = a(cls);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
        View viewInflate = (contentViewA == null || (iValue = contentViewA.value()) <= 0) ? null : layoutInflater.inflate(iValue, viewGroup, false);
        a(obj, cls, new a(viewInflate));
        return viewInflate;
    }

    @Override // com.lingku.xuanshang.xutils.ViewInjector
    public void inject(Activity activity) throws SecurityException {
        int iValue;
        Class<?> cls = activity.getClass();
        try {
            ContentView contentViewA = a(cls);
            if (contentViewA != null && (iValue = contentViewA.value()) > 0) {
                activity.setContentView(iValue);
            }
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
        a(activity, cls, new a(activity));
    }

    @Override // com.lingku.xuanshang.xutils.ViewInjector
    public void inject(View view) throws SecurityException {
        a(view, view.getClass(), new a(view));
    }

    @Override // com.lingku.xuanshang.xutils.ViewInjector
    public void inject(Object obj, View view) throws SecurityException {
        a(obj, obj.getClass(), new a(view));
    }
}
