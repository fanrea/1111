package com.lingku.xuanshang.xutils.db.converter;

import android.database.Cursor;
import com.lingku.xuanshang.xutils.db.sqlite.ColumnDbType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DoubleColumnConverter implements ColumnConverter<Double> {
    @Override // com.lingku.xuanshang.xutils.db.converter.ColumnConverter
    public Object fieldValue2DbValue(Double d) {
        return d;
    }

    @Override // com.lingku.xuanshang.xutils.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        return ColumnDbType.REAL;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.lingku.xuanshang.xutils.db.converter.ColumnConverter
    public Double getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i));
    }
}
