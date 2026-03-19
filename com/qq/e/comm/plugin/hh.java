package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.dysi.IGDTRF;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class hh {
    private static final Map<String, Class<?>> a = new HashMap();
    private static final Map<String, Method> b = new HashMap();

    /* compiled from: A */
    class a implements IGDTRF {
        final /* synthetic */ Map a;

        a(Map map) {
            this.a = map;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTRF
        public int fc(String str) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                return System.identityHashCode(hh.b(str));
            } catch (Throwable th) {
                th.toString();
                return -1;
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTRF
        public int ci(String str, String str2, String str3, int[] iArr) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && iArr != null && iArr.length == 0) {
                try {
                    Object objNewInstance = hh.b(str).newInstance();
                    int iIdentityHashCode = System.identityHashCode(objNewInstance);
                    this.a.put(Integer.valueOf(iIdentityHashCode), objNewInstance);
                    return iIdentityHashCode;
                } catch (Throwable th) {
                    th.toString();
                    return -1;
                }
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                try {
                    Class clsB = hh.b(str);
                    String[] strArrSplit = str2.split(",");
                    String[] strArrSplit2 = str3.split(",");
                    if (strArrSplit.length > 0 && strArrSplit.length == strArrSplit2.length) {
                        Class<?>[] clsArr = new Class[strArrSplit.length];
                        Object[] objArr = new Object[strArrSplit2.length];
                        for (int i = 0; i < strArrSplit.length; i++) {
                            clsArr[i] = hh.b(strArrSplit[i]);
                            if (!hh.b(i, iArr)) {
                                Object objB = hh.b(clsArr[i], strArrSplit2[i]);
                                if (objB == null) {
                                    return -1;
                                }
                                objArr[i] = objB;
                            } else {
                                Object obj = this.a.get(Integer.valueOf(Integer.parseInt(strArrSplit2[i])));
                                if (obj == null || !obj.getClass().equals(clsArr[i])) {
                                    return -1;
                                }
                                objArr[i] = obj;
                            }
                        }
                        Object objNewInstance2 = clsB.getConstructor(clsArr).newInstance(objArr);
                        int iIdentityHashCode2 = System.identityHashCode(objNewInstance2);
                        this.a.put(Integer.valueOf(iIdentityHashCode2), objNewInstance2);
                        return iIdentityHashCode2;
                    }
                } catch (Throwable th2) {
                    th2.toString();
                }
            }
            return -1;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTRF
        public int fm(String str, String str2, String str3) {
            Method method;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    String str4 = str + "." + str2 + "(" + str3 + ")";
                    Method method2 = (Method) hh.b.get(str4);
                    if (method2 == null) {
                        Class clsB = hh.b(str);
                        if (TextUtils.isEmpty(str3)) {
                            method = clsB.getMethod(str2, new Class[0]);
                        } else {
                            String[] strArrSplit = str3.split(",");
                            if (strArrSplit.length > 0) {
                                Class<?>[] clsArr = new Class[strArrSplit.length];
                                for (int i = 0; i < strArrSplit.length; i++) {
                                    clsArr[i] = hh.b(strArrSplit[i]);
                                }
                                method = clsB.getMethod(str2, clsArr);
                            }
                        }
                        method2 = method;
                    }
                    if (method2 != null) {
                        int iIdentityHashCode = System.identityHashCode(method2);
                        method2.setAccessible(true);
                        hh.b.put(str4, method2);
                        this.a.put(Integer.valueOf(iIdentityHashCode), method2);
                        return iIdentityHashCode;
                    }
                } catch (Throwable th) {
                    th.toString();
                }
            }
            return -1;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTRF
        public int iv(int i, int i2, String str, int[] iArr) {
            Method method;
            Object objInvoke;
            try {
                method = (Method) this.a.get(Integer.valueOf(i));
            } catch (Throwable th) {
                th.toString();
            }
            if (method == null) {
                return -1;
            }
            Object obj = this.a.get(Integer.valueOf(i2));
            if (TextUtils.isEmpty(str)) {
                objInvoke = method.invoke(obj, new Object[0]);
                if (objInvoke == null) {
                    return 1;
                }
            } else {
                String[] strArrSplit = str.split(",");
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (strArrSplit.length == parameterTypes.length) {
                    Object[] objArr = new Object[parameterTypes.length];
                    for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                        if (!hh.b(i3, iArr)) {
                            Object objB = hh.b(parameterTypes[i3], strArrSplit[i3]);
                            if (objB == null) {
                                return -1;
                            }
                            objArr[i3] = objB;
                        } else {
                            Object obj2 = this.a.get(Integer.valueOf(Integer.parseInt(strArrSplit[i3])));
                            if (obj2 == null || !obj2.getClass().equals(parameterTypes[i3])) {
                                return -1;
                            }
                            objArr[i3] = obj2;
                        }
                    }
                    objInvoke = method.invoke(obj, objArr);
                    if (objInvoke == null) {
                        return 1;
                    }
                } else {
                    objInvoke = null;
                }
            }
            if (objInvoke != null) {
                int iIdentityHashCode = System.identityHashCode(objInvoke);
                this.a.put(Integer.valueOf(iIdentityHashCode), objInvoke);
                return iIdentityHashCode;
            }
            return -1;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTRF
        public int gf(int i, String str) {
            Class<?> cls;
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                Object obj = this.a.get(Integer.valueOf(i));
                if (obj != null) {
                    if (obj.getClass().equals(Class.class)) {
                        cls = (Class) obj;
                    } else {
                        cls = obj.getClass();
                    }
                    Field field = cls.getField(str);
                    field.setAccessible(true);
                    Object obj2 = field.get(cls);
                    int iIdentityHashCode = System.identityHashCode(obj2);
                    this.a.put(Integer.valueOf(iIdentityHashCode), obj2);
                    return iIdentityHashCode;
                }
            } catch (Throwable th) {
                th.toString();
            }
            return -1;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTRF
        public int sf(int i, String str, String str2, int i2) {
            Class<?> cls;
            Object objB;
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                Object obj = this.a.get(Integer.valueOf(i));
                if (obj != null) {
                    if (obj.getClass().equals(Class.class)) {
                        cls = (Class) obj;
                    } else {
                        cls = obj.getClass();
                    }
                    Field field = cls.getField(str);
                    field.setAccessible(true);
                    if (str2 == null) {
                        field.set(obj, null);
                        return 1;
                    }
                    if (i2 <= 0) {
                        objB = hh.b(field.getType(), str2);
                    } else {
                        objB = this.a.get(Integer.valueOf(Integer.parseInt(str2)));
                    }
                    if (objB == null) {
                        return -1;
                    }
                    field.set(obj, objB);
                    return 1;
                }
            } catch (Throwable th) {
                th.toString();
            }
            return -1;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTRF
        public void d(int[] iArr) {
            if (iArr == null || iArr.length <= 0) {
                return;
            }
            try {
                for (int i : iArr) {
                    this.a.remove(Integer.valueOf(i));
                }
            } catch (Throwable th) {
                th.toString();
            }
        }
    }

    static void a(com.qq.e.comm.dynamic.b bVar, Map<Integer, Object> map) {
        if (bVar == null || !bVar.b() || map == null) {
            return;
        }
        bVar.a("GDTRF", IGDTRF.class, new a(map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(int i, int[] iArr) {
        if (iArr != null) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object b(Class<?> cls, String str) {
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if (String.class.equals(cls)) {
            return str;
        }
        if (!Boolean.TYPE.equals(cls) && !Boolean.class.equals(cls)) {
            if (!Byte.TYPE.equals(cls) && !Byte.class.equals(cls)) {
                if (!Short.TYPE.equals(cls) && !Short.class.equals(cls)) {
                    if (!Integer.TYPE.equals(cls) && !Integer.class.equals(cls)) {
                        if (!Long.TYPE.equals(cls) && !Long.class.equals(cls)) {
                            if (!Double.TYPE.equals(cls) && !Double.class.equals(cls)) {
                                if (Float.TYPE.equals(cls) || Float.class.equals(cls)) {
                                    return Float.valueOf(Float.parseFloat(str));
                                }
                                return null;
                            }
                            return Double.valueOf(Double.parseDouble(str));
                        }
                        return Long.valueOf(Long.parseLong(str));
                    }
                    return Integer.valueOf(Integer.parseInt(str));
                }
                return Short.valueOf(Short.parseShort(str));
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Class<?> b(String str) throws Throwable {
        Map<String, Class<?>> map = a;
        Class<?> cls = map.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str);
        map.put(str, cls2);
        return cls2;
    }
}
