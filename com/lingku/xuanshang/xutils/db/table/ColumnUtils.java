package com.lingku.xuanshang.xutils.db.table;

import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.db.converter.ColumnConverter;
import com.lingku.xuanshang.xutils.db.converter.ColumnConverterFactory;
import com.lingku.xuanshang.xutils.db.sqlite.ColumnDbType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ColumnUtils {
    public static final HashSet<Class<?>> a;
    public static final HashSet<Class<?>> b;
    public static final HashSet<Class<?>> c;

    static {
        HashSet<Class<?>> hashSet = new HashSet<>(2);
        a = hashSet;
        HashSet<Class<?>> hashSet2 = new HashSet<>(2);
        b = hashSet2;
        HashSet<Class<?>> hashSet3 = new HashSet<>(4);
        c = hashSet3;
        hashSet.add(Boolean.TYPE);
        hashSet.add(Boolean.class);
        hashSet2.add(Integer.TYPE);
        hashSet2.add(Integer.class);
        hashSet3.addAll(hashSet2);
        hashSet3.add(Long.TYPE);
        hashSet3.add(Long.class);
    }

    public static Method a(Class<?> cls, Field field) throws NoSuchMethodException, SecurityException {
        String str;
        Method declaredMethod = null;
        if (Object.class.equals(cls)) {
            return null;
        }
        String name = field.getName();
        if (isBoolean(field.getType())) {
            if (name.startsWith("is")) {
                str = name;
            } else {
                str = "is" + name.substring(0, 1).toUpperCase();
                if (name.length() > 1) {
                    str = str + name.substring(1);
                }
            }
            try {
                declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
            } catch (NoSuchMethodException unused) {
                LogUtil.d(cls.getName() + "#" + str + " not exist");
            }
        }
        if (declaredMethod == null) {
            String str2 = "get" + name.substring(0, 1).toUpperCase();
            if (name.length() > 1) {
                str2 = str2 + name.substring(1);
            }
            try {
                declaredMethod = cls.getDeclaredMethod(str2, new Class[0]);
            } catch (NoSuchMethodException unused2) {
                LogUtil.d(cls.getName() + "#" + str2 + " not exist");
            }
        }
        return declaredMethod == null ? a(cls.getSuperclass(), field) : declaredMethod;
    }

    public static Method b(Class<?> cls, Field field) throws NoSuchMethodException, SecurityException {
        String string;
        StringBuilder sbAppend;
        String strSubstring;
        Method declaredMethod = null;
        if (Object.class.equals(cls)) {
            return null;
        }
        String name = field.getName();
        Class<?> type = field.getType();
        if (isBoolean(type)) {
            if (!name.startsWith("is") || name.length() <= 2) {
                string = "set" + name.substring(0, 1).toUpperCase();
                if (name.length() > 1) {
                    sbAppend = new StringBuilder().append(string);
                    strSubstring = name.substring(1);
                    string = sbAppend.append(strSubstring).toString();
                }
                try {
                    declaredMethod = cls.getDeclaredMethod(string, type);
                } catch (NoSuchMethodException unused) {
                    LogUtil.d(cls.getName() + "#" + string + " not exist");
                }
            } else {
                string = "set" + name.substring(2, 3).toUpperCase();
                if (name.length() > 3) {
                    sbAppend = new StringBuilder().append(string);
                    strSubstring = name.substring(3);
                    string = sbAppend.append(strSubstring).toString();
                }
                declaredMethod = cls.getDeclaredMethod(string, type);
            }
        }
        if (declaredMethod == null) {
            String str = "set" + name.substring(0, 1).toUpperCase();
            if (name.length() > 1) {
                str = str + name.substring(1);
            }
            try {
                declaredMethod = cls.getDeclaredMethod(str, type);
            } catch (NoSuchMethodException unused2) {
                LogUtil.d(cls.getName() + "#" + str + " not exist");
            }
        }
        return declaredMethod == null ? b(cls.getSuperclass(), field) : declaredMethod;
    }

    public static Object convert2DbValueIfNeeded(Object obj) {
        return obj != null ? ColumnConverterFactory.getColumnConverter(obj.getClass()).fieldValue2DbValue(obj) : obj;
    }

    public static String convert2SafeExpr(Object obj) {
        String strValueOf = String.valueOf(obj);
        return strValueOf.indexOf(39) != -1 ? strValueOf.replace("'", "''") : strValueOf;
    }

    public static boolean isAutoIdType(Class<?> cls) {
        return c.contains(cls);
    }

    public static boolean isBoolean(Class<?> cls) {
        return a.contains(cls);
    }

    public static boolean isInteger(Class<?> cls) {
        return b.contains(cls);
    }

    public static boolean isTextColumnDbType(Object obj) {
        ColumnConverter columnConverter;
        return (obj == null || (columnConverter = ColumnConverterFactory.getColumnConverter(obj.getClass())) == null || !ColumnDbType.TEXT.equals(columnConverter.getColumnDbType())) ? false : true;
    }
}
