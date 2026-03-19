package com.baidu.ad.magic.flute.a.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class p {
    p() {
    }

    private static Class a(Class cls) {
        if (cls == Character.TYPE) {
            return Character.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        throw new IllegalArgumentException(String.format("Don't know the wrapper type for primitive type %s.", cls));
    }

    public static Object a(Class cls, Object[] objArr) {
        return (objArr == null || objArr.length <= 0) ? cls.newInstance() : b(cls, objArr);
    }

    public static String a(byte[] bArr) {
        return new String(new com.baidu.ad.magic.flute.b.a.b().b(bArr), "UTF-8");
    }

    public static Method a(Class cls, String str, Class[] clsArr) throws NoSuchMethodException, SecurityException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    private static Object b(Class cls, Object[] objArr) throws SecurityException {
        Constructor<?> constructor = null;
        for (Constructor<?> constructor2 : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if (parameterTypes.length >= objArr.length) {
                int i = 0;
                int i2 = 0;
                while (i < objArr.length) {
                    Object obj = objArr[i];
                    while (obj != null && i2 < parameterTypes.length) {
                        Class<?> clsA = parameterTypes[i2];
                        if (clsA.isPrimitive()) {
                            clsA = a(clsA);
                        }
                        if (clsA.isInstance(obj)) {
                            break;
                        }
                        i2++;
                    }
                    if (i2 == parameterTypes.length) {
                        break;
                    }
                    i2++;
                    i++;
                }
                if (i != objArr.length) {
                    continue;
                } else if (constructor == null || parameterTypes.length < constructor.getParameterTypes().length) {
                    constructor = constructor2;
                } else if (parameterTypes.length == constructor.getParameterTypes().length) {
                    throw new IllegalArgumentException("Multiple consturctors match parameters");
                }
            }
        }
        if (constructor != null) {
            return constructor.newInstance(objArr);
        }
        return null;
    }
}
