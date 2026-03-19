package com.duoyou.task.sdk.xutils.db.converter;

import android.database.Cursor;
import com.duoyou.task.sdk.xutils.db.sqlite.ColumnDbType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DoubleColumnConverter implements ColumnConverter<Double> {
    @Override // com.duoyou.task.sdk.xutils.db.converter.ColumnConverter
    public Object fieldValue2DbValue(Double d) {
        return d;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.duoyou.task.sdk.xutils.db.converter.ColumnConverter
    public Double getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i));
    }

    @Override // com.duoyou.task.sdk.xutils.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        return ColumnDbType.REAL;
    }
}
