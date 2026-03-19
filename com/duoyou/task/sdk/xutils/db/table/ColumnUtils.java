package com.duoyou.task.sdk.xutils.db.table;

import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.db.converter.ColumnConverter;
import com.duoyou.task.sdk.xutils.db.converter.ColumnConverterFactory;
import com.duoyou.task.sdk.xutils.db.sqlite.ColumnDbType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ColumnUtils {
    private static final HashSet<Class<?>> AUTO_INCREMENT_TYPES;
    private static final HashSet<Class<?>> BOOLEAN_TYPES;
    private static final HashSet<Class<?>> INTEGER_TYPES;

    private ColumnUtils() {
    }

    static {
        HashSet<Class<?>> hashSet = new HashSet<>(2);
        BOOLEAN_TYPES = hashSet;
        HashSet<Class<?>> hashSet2 = new HashSet<>(2);
        INTEGER_TYPES = hashSet2;
        HashSet<Class<?>> hashSet3 = new HashSet<>(4);
        AUTO_INCREMENT_TYPES = hashSet3;
        hashSet.add(Boolean.TYPE);
        hashSet.add(Boolean.class);
        hashSet2.add(Integer.TYPE);
        hashSet2.add(Integer.class);
        hashSet3.addAll(hashSet2);
        hashSet3.add(Long.TYPE);
        hashSet3.add(Long.class);
    }

    public static boolean isAutoIdType(Class<?> cls) {
        return AUTO_INCREMENT_TYPES.contains(cls);
    }

    public static boolean isInteger(Class<?> cls) {
        return INTEGER_TYPES.contains(cls);
    }

    public static boolean isBoolean(Class<?> cls) {
        return BOOLEAN_TYPES.contains(cls);
    }

    public static boolean isTextColumnDbType(Object obj) {
        ColumnConverter columnConverter;
        return (obj == null || (columnConverter = ColumnConverterFactory.getColumnConverter(obj.getClass())) == null || !ColumnDbType.TEXT.equals(columnConverter.getColumnDbType())) ? false : true;
    }

    public static String convert2SafeExpr(Object obj) {
        String strValueOf = String.valueOf(obj);
        return strValueOf.indexOf(39) != -1 ? strValueOf.replace("'", "''") : strValueOf;
    }

    public static Object convert2DbValueIfNeeded(Object obj) {
        return obj != null ? ColumnConverterFactory.getColumnConverter(obj.getClass()).fieldValue2DbValue(obj) : obj;
    }

    public static Method findGetMethod(Class<?> cls, Field field) throws NoSuchMethodException, SecurityException {
        if (Object.class.equals(cls)) {
            return null;
        }
        String name = field.getName();
        Method methodFindBooleanGetMethod = isBoolean(field.getType()) ? findBooleanGetMethod(cls, name) : null;
        if (methodFindBooleanGetMethod == null) {
            String str = "get" + name.substring(0, 1).toUpperCase();
            if (name.length() > 1) {
                str = str + name.substring(1);
            }
            try {
                methodFindBooleanGetMethod = cls.getDeclaredMethod(str, new Class[0]);
            } catch (NoSuchMethodException unused) {
                LogUtil.d(cls.getName() + "#" + str + " not exist");
            }
        }
        return methodFindBooleanGetMethod == null ? findGetMethod(cls.getSuperclass(), field) : methodFindBooleanGetMethod;
    }

    public static Method findSetMethod(Class<?> cls, Field field) throws NoSuchMethodException, SecurityException {
        if (Object.class.equals(cls)) {
            return null;
        }
        String name = field.getName();
        Class<?> type = field.getType();
        Method methodFindBooleanSetMethod = isBoolean(type) ? findBooleanSetMethod(cls, name, type) : null;
        if (methodFindBooleanSetMethod == null) {
            String str = "set" + name.substring(0, 1).toUpperCase();
            if (name.length() > 1) {
                str = str + name.substring(1);
            }
            try {
                methodFindBooleanSetMethod = cls.getDeclaredMethod(str, type);
            } catch (NoSuchMethodException unused) {
                LogUtil.d(cls.getName() + "#" + str + " not exist");
            }
        }
        return methodFindBooleanSetMethod == null ? findSetMethod(cls.getSuperclass(), field) : methodFindBooleanSetMethod;
    }

    private static Method findBooleanGetMethod(Class<?> cls, String str) {
        if (!str.startsWith("is")) {
            String str2 = "is" + str.substring(0, 1).toUpperCase();
            str = str.length() > 1 ? str2 + str.substring(1) : str2;
        }
        try {
            return cls.getDeclaredMethod(str, new Class[0]);
        } catch (NoSuchMethodException unused) {
            LogUtil.d(cls.getName() + "#" + str + " not exist");
            return null;
        }
    }

    private static Method findBooleanSetMethod(Class<?> cls, String str, Class<?> cls2) {
        String str2;
        if (str.startsWith("is") && str.length() > 2) {
            str2 = "set" + str.substring(2, 3).toUpperCase();
            if (str.length() > 3) {
                str2 = str2 + str.substring(3);
            }
        } else {
            str2 = "set" + str.substring(0, 1).toUpperCase();
            if (str.length() > 1) {
                str2 = str2 + str.substring(1);
            }
        }
        try {
            return cls.getDeclaredMethod(str2, cls2);
        } catch (NoSuchMethodException unused) {
            LogUtil.d(cls.getName() + "#" + str2 + " not exist");
            return null;
        }
    }
}
