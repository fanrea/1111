package com.duoyou.task.sdk.xutils.db.table;

import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.db.annotation.Column;
import com.duoyou.task.sdk.xutils.db.converter.ColumnConverterFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class TableUtils {
    private TableUtils() {
    }

    public static LinkedHashMap<String, ColumnEntity> findColumnMap(Class<?> cls) {
        LinkedHashMap<String, ColumnEntity> linkedHashMap = new LinkedHashMap<>();
        addColumns2Map(cls, linkedHashMap);
        return linkedHashMap;
    }

    private static void addColumns2Map(Class<?> cls, HashMap<String, ColumnEntity> map) {
        Column column;
        if (Object.class.equals(cls)) {
            return;
        }
        try {
            for (Field field : cls.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers) && (column = (Column) field.getAnnotation(Column.class)) != null && ColumnConverterFactory.isSupportColumnConverter(field.getType())) {
                    ColumnEntity columnEntity = new ColumnEntity(cls, field, column);
                    if (!map.containsKey(columnEntity.getName())) {
                        map.put(columnEntity.getName(), columnEntity);
                    }
                }
            }
            addColumns2Map(cls.getSuperclass(), map);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }
}
