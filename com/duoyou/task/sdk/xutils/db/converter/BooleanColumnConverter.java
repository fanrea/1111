package com.duoyou.task.sdk.xutils.db.converter;

import android.database.Cursor;
import com.duoyou.task.sdk.xutils.db.sqlite.ColumnDbType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class BooleanColumnConverter implements ColumnConverter<Boolean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.duoyou.task.sdk.xutils.db.converter.ColumnConverter
    public Boolean getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Boolean.valueOf(cursor.getInt(i) == 1);
    }

    @Override // com.duoyou.task.sdk.xutils.db.converter.ColumnConverter
    public Object fieldValue2DbValue(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return Integer.valueOf(bool.booleanValue() ? 1 : 0);
    }

    @Override // com.duoyou.task.sdk.xutils.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        return ColumnDbType.INTEGER;
    }
}
