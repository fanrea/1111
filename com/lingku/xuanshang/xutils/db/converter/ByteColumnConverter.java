package com.lingku.xuanshang.xutils.db.converter;

import android.database.Cursor;
import com.lingku.xuanshang.xutils.db.sqlite.ColumnDbType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ByteColumnConverter implements ColumnConverter<Byte> {
    @Override // com.lingku.xuanshang.xutils.db.converter.ColumnConverter
    public Object fieldValue2DbValue(Byte b) {
        return b;
    }

    @Override // com.lingku.xuanshang.xutils.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        return ColumnDbType.INTEGER;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.lingku.xuanshang.xutils.db.converter.ColumnConverter
    public Byte getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Byte.valueOf((byte) cursor.getInt(i));
    }
}
