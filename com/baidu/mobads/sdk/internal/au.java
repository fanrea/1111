package com.baidu.mobads.sdk.internal;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class au {
    private static volatile Map<String, au> c = new HashMap();
    private Class<?> a;
    private Method[] b;

    public static au a(Context context, String str) {
        if (!c.containsKey(str) || c.get(str).a == null) {
            synchronized (au.class) {
                if (!c.containsKey(str) || c.get(str).a == null) {
                    c.put(str, new au(context, str));
                }
            }
        }
        return c.get(str);
    }

    private au(Context context, String str) {
        this.b = null;
        try {
            Class<?> cls = Class.forName(str, true, bt.a(context));
            this.a = cls;
            this.b = cls.getMethods();
        } catch (Throwable th) {
            bu.a().a(th);
        }
    }

    public Object a(Class<?>[] clsArr, Object... objArr) {
        Constructor<?> constructor;
        if (objArr != null) {
            try {
                if (objArr.length == 0) {
                    constructor = this.a.getConstructor(new Class[0]);
                } else {
                    constructor = this.a.getConstructor(clsArr);
                }
            } catch (Throwable th) {
                bu.a().a(th);
                return null;
            }
        } else {
            constructor = this.a.getConstructor(new Class[0]);
        }
        return constructor.newInstance(objArr);
    }

    public void a(Object obj, String str, Object... objArr) {
        try {
            Method methodA = a(str);
            if (methodA != null) {
                if (objArr == null || objArr.length == 0) {
                    methodA.invoke(obj, new Object[0]);
                } else {
                    methodA.invoke(obj, objArr);
                }
            }
        } catch (Throwable th) {
            bu.a().a(th);
        }
    }

    public Object b(Object obj, String str, Object... objArr) {
        try {
            Method methodA = a(str);
            if (methodA == null) {
                return null;
            }
            if (objArr != null && objArr.length != 0) {
                return methodA.invoke(obj, objArr);
            }
            return methodA.invoke(obj, new Object[0]);
        } catch (Throwable th) {
            bu.a().a(th);
            return null;
        }
    }

    public String c(Object obj, String str, Object... objArr) {
        Object objInvoke;
        try {
            Method methodA = a(str);
            if (methodA == null) {
                return null;
            }
            if (objArr == null || objArr.length == 0) {
                objInvoke = methodA.invoke(obj, new Object[0]);
            } else {
                objInvoke = methodA.invoke(obj, objArr);
            }
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            bu.a().a(th);
            return null;
        }
    }

    private Method a(String str) {
        Method[] methodArr = this.b;
        if (methodArr == null) {
            return null;
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }
}
