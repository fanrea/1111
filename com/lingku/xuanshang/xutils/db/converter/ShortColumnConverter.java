package com.lingku.xuanshang.xutils.db.converter;

import android.database.Cursor;
import com.lingku.xuanshang.xutils.db.sqlite.ColumnDbType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ShortColumnConverter implements ColumnConverter<Short> {
    @Override // com.lingku.xuanshang.xutils.db.converter.ColumnConverter
    public Object fieldValue2DbValue(Short sh) {
        return sh;
    }

    @Override // com.lingku.xuanshang.xutils.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        return ColumnDbType.INTEGER;
    }

    @Override // com.lingku.xuanshang.xutils.db.converter.ColumnConverter
    public Short getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i));
    }
}
