package com.duoyou.task.sdk.xutils.db.converter;

import android.database.Cursor;
import com.duoyou.task.sdk.xutils.db.sqlite.ColumnDbType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class FloatColumnConverter implements ColumnConverter<Float> {
    @Override // com.duoyou.task.sdk.xutils.db.converter.ColumnConverter
    public Object fieldValue2DbValue(Float f) {
        return f;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.duoyou.task.sdk.xutils.db.converter.ColumnConverter
    public Float getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i));
    }

    @Override // com.duoyou.task.sdk.xutils.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        return ColumnDbType.REAL;
    }
}
