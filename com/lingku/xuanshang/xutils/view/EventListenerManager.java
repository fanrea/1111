package com.lingku.xuanshang.xutils.view;

import android.text.TextUtils;
import android.view.View;
import com.lingku.xuanshang.xutils.common.util.DoubleKeyValueMap;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.view.annotation.Event;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import lkxssdk.t0.a;
import lkxssdk.t0.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class EventListenerManager {
    public static final HashSet<String> a;
    public static final DoubleKeyValueMap<b, Class<?>, Object> b;

    public static class DynamicHandler implements InvocationHandler {
        public static long a;
        public WeakReference<Object> b;
        public final HashMap<String, Method> c = new HashMap<>(1);

        public DynamicHandler(Object obj) {
            this.b = new WeakReference<>(obj);
        }

        public void addMethod(String str, Method method) {
            this.c.put(str, method);
        }

        public Object getHandler() {
            return this.b.get();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2 = this.b.get();
            if (obj2 != null) {
                String name = method.getName();
                if ("toString".equals(name)) {
                    return DynamicHandler.class.getSimpleName();
                }
                Method value = this.c.get(name);
                if (value == null && this.c.size() == 1) {
                    Iterator<Map.Entry<String, Method>> it = this.c.entrySet().iterator();
                    if (it.hasNext()) {
                        Map.Entry<String, Method> next = it.next();
                        if (TextUtils.isEmpty(next.getKey())) {
                            value = next.getValue();
                        }
                    }
                }
                if (value != null) {
                    if (EventListenerManager.a.contains(name)) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - a;
                        if (jCurrentTimeMillis > 0 && jCurrentTimeMillis < 300) {
                            LogUtil.d("onClick cancelled: " + jCurrentTimeMillis);
                            return null;
                        }
                        a = System.currentTimeMillis();
                    }
                    try {
                        return value.invoke(obj2, objArr);
                    } catch (Throwable th) {
                        throw new RuntimeException("invoke method error:" + obj2.getClass().getName() + "#" + value.getName(), th);
                    }
                }
                LogUtil.w("method not impl: " + name + "(" + obj2.getClass().getSimpleName() + ")");
            }
            return null;
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>(2);
        a = hashSet;
        hashSet.add("onClick");
        hashSet.add("onItemClick");
        b = new DoubleKeyValueMap<>();
    }

    public static void a(a aVar, b bVar, Event event, Object obj, Method method) {
        boolean zEquals;
        try {
            aVar.getClass();
            View viewA = aVar.a(bVar.a, bVar.b);
            if (viewA != null) {
                Class<?> clsType = event.type();
                String str = event.setter();
                if (TextUtils.isEmpty(str)) {
                    str = "set" + clsType.getSimpleName();
                }
                String strMethod = event.method();
                DoubleKeyValueMap<b, Class<?>, Object> doubleKeyValueMap = b;
                Object objNewProxyInstance = doubleKeyValueMap.get(bVar, clsType);
                if (objNewProxyInstance != null) {
                    DynamicHandler dynamicHandler = (DynamicHandler) Proxy.getInvocationHandler(objNewProxyInstance);
                    zEquals = obj.equals(dynamicHandler.getHandler());
                    if (zEquals) {
                        dynamicHandler.addMethod(strMethod, method);
                    }
                } else {
                    zEquals = false;
                }
                if (!zEquals) {
                    DynamicHandler dynamicHandler2 = new DynamicHandler(obj);
                    dynamicHandler2.addMethod(strMethod, method);
                    objNewProxyInstance = Proxy.newProxyInstance(clsType.getClassLoader(), new Class[]{clsType}, dynamicHandler2);
                    doubleKeyValueMap.put(bVar, clsType, objNewProxyInstance);
                }
                viewA.getClass().getMethod(str, clsType).invoke(viewA, objNewProxyInstance);
            }
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }
}
