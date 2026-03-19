package com.duoyou.task.sdk.xutils.db;

import android.database.Cursor;
import com.duoyou.task.sdk.xutils.db.table.ColumnEntity;
import com.duoyou.task.sdk.xutils.db.table.DbModel;
import com.duoyou.task.sdk.xutils.db.table.TableEntity;
import java.util.LinkedHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class CursorUtils {
    public static <T> T getEntity(TableEntity<T> tableEntity, Cursor cursor) {
        T tCreateEntity = tableEntity.createEntity();
        LinkedHashMap<String, ColumnEntity> columnMap = tableEntity.getColumnMap();
        int columnCount = cursor.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            ColumnEntity columnEntity = columnMap.get(cursor.getColumnName(i));
            if (columnEntity != null) {
                columnEntity.setValueFromCursor(tCreateEntity, cursor, i);
            }
        }
        return tCreateEntity;
    }

    public static DbModel getDbModel(Cursor cursor) {
        DbModel dbModel = new DbModel();
        int columnCount = cursor.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            dbModel.add(cursor.getColumnName(i), cursor.getString(i));
        }
        return dbModel;
    }
}
