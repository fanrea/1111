package com.duoyou.task.sdk.xutils.db.table;

import android.database.Cursor;
import com.duoyou.task.sdk.xutils.DbManager;
import com.duoyou.task.sdk.xutils.db.annotation.Table;
import com.duoyou.task.sdk.xutils.ex.DbException;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class TableEntity<T> {
    private final LinkedHashMap<String, ColumnEntity> columnMap;
    private final Constructor<T> constructor;
    private final DbManager db;
    private final Class<T> entityType;
    private ColumnEntity id;
    private final String name;
    private final String onCreated;
    private volatile Boolean tableCheckedStatus;

    public TableEntity(DbManager dbManager, Class<T> cls) throws DbException {
        this.db = dbManager;
        this.entityType = cls;
        Table table = (Table) cls.getAnnotation(Table.class);
        if (table == null) {
            throw new DbException("missing @Table on " + cls.getName());
        }
        this.name = table.name();
        this.onCreated = table.onCreated();
        Constructor<T> constructor = cls.getConstructor(new Class[0]);
        this.constructor = constructor;
        constructor.setAccessible(true);
        LinkedHashMap<String, ColumnEntity> linkedHashMapFindColumnMap = TableUtils.findColumnMap(cls);
        this.columnMap = linkedHashMapFindColumnMap;
        for (ColumnEntity columnEntity : linkedHashMapFindColumnMap.values()) {
            if (columnEntity.isId()) {
                this.id = columnEntity;
                return;
            }
        }
    }

    public T createEntity() {
        return this.constructor.newInstance(new Object[0]);
    }

    public boolean tableIsExists() {
        return tableIsExists(false);
    }

    public boolean tableIsExists(boolean z) {
        if (this.tableCheckedStatus != null && (this.tableCheckedStatus.booleanValue() || !z)) {
            return this.tableCheckedStatus.booleanValue();
        }
        Cursor cursorExecQuery = this.db.execQuery("SELECT COUNT(*) AS c FROM sqlite_master WHERE type='table' AND name='" + this.name + "'");
        if (cursorExecQuery != null) {
            try {
                if (cursorExecQuery.moveToNext() && cursorExecQuery.getInt(0) > 0) {
                    this.tableCheckedStatus = true;
                    return this.tableCheckedStatus.booleanValue();
                }
            } finally {
            }
        }
        this.tableCheckedStatus = false;
        return this.tableCheckedStatus.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f A[Catch: all -> 0x0051, DONT_GENERATE, TryCatch #0 {, blocks: (B:10:0x0011, B:12:0x0017, B:14:0x002e, B:15:0x0035, B:20:0x0048, B:21:0x004f, B:17:0x0041), top: B:26:0x0011, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void createTableIfNotExists() {
        /*
            r4 = this;
            java.lang.Boolean r0 = r4.tableCheckedStatus
            if (r0 == 0) goto Ld
            java.lang.Boolean r0 = r4.tableCheckedStatus
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto Ld
            return
        Ld:
            java.lang.Class<T> r0 = r4.entityType
            monitor-enter(r0)
            r1 = 1
            boolean r2 = r4.tableIsExists(r1)     // Catch: java.lang.Throwable -> L51
            if (r2 != 0) goto L4f
            com.duoyou.task.sdk.xutils.db.sqlite.SqlInfo r2 = com.duoyou.task.sdk.xutils.db.sqlite.SqlInfoBuilder.buildCreateTableSqlInfo(r4)     // Catch: java.lang.Throwable -> L51
            com.duoyou.task.sdk.xutils.DbManager r3 = r4.db     // Catch: java.lang.Throwable -> L51
            r3.execNonQuery(r2)     // Catch: java.lang.Throwable -> L51
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L51
            r4.tableCheckedStatus = r1     // Catch: java.lang.Throwable -> L51
            java.lang.String r1 = r4.onCreated     // Catch: java.lang.Throwable -> L51
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L51
            if (r1 != 0) goto L35
            com.duoyou.task.sdk.xutils.DbManager r1 = r4.db     // Catch: java.lang.Throwable -> L51
            java.lang.String r2 = r4.onCreated     // Catch: java.lang.Throwable -> L51
            r1.execNonQuery(r2)     // Catch: java.lang.Throwable -> L51
        L35:
            com.duoyou.task.sdk.xutils.DbManager r1 = r4.db     // Catch: java.lang.Throwable -> L51
            com.duoyou.task.sdk.xutils.DbManager$DaoConfig r1 = r1.getDaoConfig()     // Catch: java.lang.Throwable -> L51
            com.duoyou.task.sdk.xutils.DbManager$TableCreateListener r1 = r1.getTableCreateListener()     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L4f
            com.duoyou.task.sdk.xutils.DbManager r2 = r4.db     // Catch: java.lang.Throwable -> L47
            r1.onTableCreated(r2, r4)     // Catch: java.lang.Throwable -> L47
            goto L4f
        L47:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()     // Catch: java.lang.Throwable -> L51
            com.duoyou.task.sdk.xutils.common.util.LogUtil.e(r2, r1)     // Catch: java.lang.Throwable -> L51
        L4f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L51
            return
        L51:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L51
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duoyou.task.sdk.xutils.db.table.TableEntity.createTableIfNotExists():void");
    }

    public DbManager getDb() {
        return this.db;
    }

    public String getName() {
        return this.name;
    }

    public Class<T> getEntityType() {
        return this.entityType;
    }

    public String getOnCreated() {
        return this.onCreated;
    }

    public ColumnEntity getId() {
        return this.id;
    }

    public LinkedHashMap<String, ColumnEntity> getColumnMap() {
        return this.columnMap;
    }

    public void setTableCheckedStatus(boolean z) {
        this.tableCheckedStatus = Boolean.valueOf(z);
    }

    public String toString() {
        return this.name;
    }
}
