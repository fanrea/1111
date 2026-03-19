package com.lingku.xuanshang.xutils.db.table;

import android.database.Cursor;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.db.annotation.Column;
import com.lingku.xuanshang.xutils.db.converter.ColumnConverter;
import com.lingku.xuanshang.xutils.db.converter.ColumnConverterFactory;
import com.lingku.xuanshang.xutils.db.sqlite.ColumnDbType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ColumnEntity {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final ColumnConverter columnConverter;
    public final Field columnField;
    public final Method getMethod;
    public final String name;
    public final Method setMethod;

    public ColumnEntity(Class<?> cls, Field field, Column column) throws NoSuchMethodException, SecurityException {
        field.setAccessible(true);
        this.columnField = field;
        this.name = column.name();
        this.a = column.property();
        boolean zIsId = column.isId();
        this.b = zIsId;
        Class<?> type = field.getType();
        this.c = zIsId && column.autoGen() && ColumnUtils.isAutoIdType(type);
        this.columnConverter = ColumnConverterFactory.getColumnConverter(type);
        Method methodA = ColumnUtils.a(cls, field);
        this.getMethod = methodA;
        if (methodA != null && !methodA.isAccessible()) {
            methodA.setAccessible(true);
        }
        Method methodB = ColumnUtils.b(cls, field);
        this.setMethod = methodB;
        if (methodB == null || methodB.isAccessible()) {
            return;
        }
        methodB.setAccessible(true);
    }

    public ColumnConverter getColumnConverter() {
        return this.columnConverter;
    }

    public ColumnDbType getColumnDbType() {
        return this.columnConverter.getColumnDbType();
    }

    public Field getColumnField() {
        return this.columnField;
    }

    public Object getColumnValue(Object obj) {
        Object fieldValue = getFieldValue(obj);
        if (this.c && (fieldValue.equals(0L) || fieldValue.equals(0))) {
            return null;
        }
        return this.columnConverter.fieldValue2DbValue(fieldValue);
    }

    public Object getFieldValue(Object obj) {
        if (obj != null) {
            Method method = this.getMethod;
            try {
                return method != null ? method.invoke(obj, new Object[0]) : this.columnField.get(obj);
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public String getProperty() {
        return this.a;
    }

    public boolean isAutoId() {
        return this.c;
    }

    public boolean isId() {
        return this.b;
    }

    public void setAutoIdValue(Object obj, long j) {
        Object objValueOf = Long.valueOf(j);
        if (ColumnUtils.isInteger(this.columnField.getType())) {
            objValueOf = Integer.valueOf((int) j);
        }
        Method method = this.setMethod;
        try {
            if (method != null) {
                method.invoke(obj, objValueOf);
            } else {
                this.columnField.set(obj, objValueOf);
            }
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    public void setValueFromCursor(Object obj, Cursor cursor, int i) {
        Object fieldValue = this.columnConverter.getFieldValue(cursor, i);
        if (fieldValue == null) {
            return;
        }
        Method method = this.setMethod;
        try {
            if (method != null) {
                method.invoke(obj, fieldValue);
            } else {
                this.columnField.set(obj, fieldValue);
            }
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    public String toString() {
        return this.name;
    }
}
