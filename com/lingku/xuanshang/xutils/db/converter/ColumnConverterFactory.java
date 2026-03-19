package com.lingku.xuanshang.xutils.db.converter;

import com.lingku.xuanshang.xutils.common.util.LogUtil;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ColumnConverterFactory {
    public static final ConcurrentHashMap<String, ColumnConverter> a;

    static {
        ConcurrentHashMap<String, ColumnConverter> concurrentHashMap = new ConcurrentHashMap<>();
        a = concurrentHashMap;
        BooleanColumnConverter booleanColumnConverter = new BooleanColumnConverter();
        concurrentHashMap.put(Boolean.TYPE.getName(), booleanColumnConverter);
        concurrentHashMap.put(Boolean.class.getName(), booleanColumnConverter);
        concurrentHashMap.put(byte[].class.getName(), new ByteArrayColumnConverter());
        ByteColumnConverter byteColumnConverter = new ByteColumnConverter();
        concurrentHashMap.put(Byte.TYPE.getName(), byteColumnConverter);
        concurrentHashMap.put(Byte.class.getName(), byteColumnConverter);
        CharColumnConverter charColumnConverter = new CharColumnConverter();
        concurrentHashMap.put(Character.TYPE.getName(), charColumnConverter);
        concurrentHashMap.put(Character.class.getName(), charColumnConverter);
        concurrentHashMap.put(Date.class.getName(), new DateColumnConverter());
        DoubleColumnConverter doubleColumnConverter = new DoubleColumnConverter();
        concurrentHashMap.put(Double.TYPE.getName(), doubleColumnConverter);
        concurrentHashMap.put(Double.class.getName(), doubleColumnConverter);
        FloatColumnConverter floatColumnConverter = new FloatColumnConverter();
        concurrentHashMap.put(Float.TYPE.getName(), floatColumnConverter);
        concurrentHashMap.put(Float.class.getName(), floatColumnConverter);
        IntegerColumnConverter integerColumnConverter = new IntegerColumnConverter();
        concurrentHashMap.put(Integer.TYPE.getName(), integerColumnConverter);
        concurrentHashMap.put(Integer.class.getName(), integerColumnConverter);
        LongColumnConverter longColumnConverter = new LongColumnConverter();
        concurrentHashMap.put(Long.TYPE.getName(), longColumnConverter);
        concurrentHashMap.put(Long.class.getName(), longColumnConverter);
        ShortColumnConverter shortColumnConverter = new ShortColumnConverter();
        concurrentHashMap.put(Short.TYPE.getName(), shortColumnConverter);
        concurrentHashMap.put(Short.class.getName(), shortColumnConverter);
        concurrentHashMap.put(java.sql.Date.class.getName(), new SqlDateColumnConverter());
        concurrentHashMap.put(String.class.getName(), new StringColumnConverter());
    }

    public static ColumnConverter getColumnConverter(Class cls) {
        ColumnConverter columnConverter;
        ConcurrentHashMap<String, ColumnConverter> concurrentHashMap = a;
        if (concurrentHashMap.containsKey(cls.getName())) {
            columnConverter = concurrentHashMap.get(cls.getName());
        } else if (ColumnConverter.class.isAssignableFrom(cls)) {
            try {
                ColumnConverter columnConverter2 = (ColumnConverter) cls.newInstance();
                concurrentHashMap.put(cls.getName(), columnConverter2);
                columnConverter = columnConverter2;
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
            }
        } else {
            columnConverter = null;
        }
        if (columnConverter != null) {
            return columnConverter;
        }
        throw new RuntimeException("Database Column Not Support: " + cls.getName() + ", please impl ColumnConverter or use ColumnConverterFactory#registerColumnConverter(...)");
    }

    public static boolean isSupportColumnConverter(Class cls) {
        ConcurrentHashMap<String, ColumnConverter> concurrentHashMap = a;
        if (concurrentHashMap.containsKey(cls.getName())) {
            return true;
        }
        if (!ColumnConverter.class.isAssignableFrom(cls)) {
            return false;
        }
        try {
            concurrentHashMap.put(cls.getName(), (ColumnConverter) cls.newInstance());
            return true;
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            return false;
        }
    }

    public static void registerColumnConverter(Class cls, ColumnConverter columnConverter) {
        a.put(cls.getName(), columnConverter);
    }
}
