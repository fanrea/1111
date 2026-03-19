package com.lingku.xuanshang.xutils.db.converter;

import android.database.Cursor;
import com.lingku.xuanshang.xutils.db.sqlite.ColumnDbType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ByteArrayColumnConverter implements ColumnConverter<byte[]> {
    @Override // com.lingku.xuanshang.xutils.db.converter.ColumnConverter
    public Object fieldValue2DbValue(byte[] bArr) {
        return bArr;
    }

    @Override // com.lingku.xuanshang.xutils.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        return ColumnDbType.BLOB;
    }

    @Override // com.lingku.xuanshang.xutils.db.converter.ColumnConverter
    public byte[] getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return cursor.getBlob(i);
    }
}
