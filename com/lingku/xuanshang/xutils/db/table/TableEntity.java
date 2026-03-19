package com.lingku.xuanshang.xutils.db.table;

import android.database.Cursor;
import com.lingku.xuanshang.xutils.DbManager;
import com.lingku.xuanshang.xutils.db.annotation.Table;
import com.lingku.xuanshang.xutils.ex.DbException;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import lkxssdk.l0.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class TableEntity<T> {
    public final DbManager a;
    public final String b;
    public final String c;
    public final Class<T> d;
    public final Constructor<T> e;
    public ColumnEntity f;
    public volatile Boolean g;
    public final LinkedHashMap<String, ColumnEntity> h;

    public TableEntity(DbManager dbManager, Class<T> cls) throws DbException {
        this.a = dbManager;
        this.d = cls;
        Table table = (Table) cls.getAnnotation(Table.class);
        if (table == null) {
            throw new DbException("missing @Table on " + cls.getName());
        }
        this.b = table.name();
        this.c = table.onCreated();
        Constructor<T> constructor = cls.getConstructor(new Class[0]);
        this.e = constructor;
        constructor.setAccessible(true);
        LinkedHashMap<String, ColumnEntity> linkedHashMapA = a.a((Class<?>) cls);
        this.h = linkedHashMapA;
        for (ColumnEntity columnEntity : linkedHashMapA.values()) {
            if (columnEntity.isId()) {
                this.f = columnEntity;
                return;
            }
        }
    }

    public T createEntity() {
        return this.e.newInstance(new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004d A[Catch: all -> 0x004f, DONT_GENERATE, TryCatch #1 {, blocks: (B:10:0x0011, B:12:0x0017, B:14:0x002c, B:15:0x0033, B:20:0x0046, B:21:0x004d, B:17:0x003f), top: B:28:0x0011, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void createTableIfNotExists() {
        /*
            r3 = this;
            java.lang.Boolean r0 = r3.g
            if (r0 == 0) goto Ld
            java.lang.Boolean r0 = r3.g
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto Ld
            return
        Ld:
            java.lang.Class<T> r0 = r3.d
            monitor-enter(r0)
            r1 = 1
            boolean r1 = r3.tableIsExists(r1)     // Catch: java.lang.Throwable -> L4f
            if (r1 != 0) goto L4d
            com.lingku.xuanshang.xutils.db.sqlite.SqlInfo r1 = com.lingku.xuanshang.xutils.db.sqlite.SqlInfoBuilder.buildCreateTableSqlInfo(r3)     // Catch: java.lang.Throwable -> L4f
            com.lingku.xuanshang.xutils.DbManager r2 = r3.a     // Catch: java.lang.Throwable -> L4f
            r2.execNonQuery(r1)     // Catch: java.lang.Throwable -> L4f
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L4f
            r3.g = r1     // Catch: java.lang.Throwable -> L4f
            java.lang.String r1 = r3.c     // Catch: java.lang.Throwable -> L4f
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L4f
            if (r1 != 0) goto L33
            com.lingku.xuanshang.xutils.DbManager r1 = r3.a     // Catch: java.lang.Throwable -> L4f
            java.lang.String r2 = r3.c     // Catch: java.lang.Throwable -> L4f
            r1.execNonQuery(r2)     // Catch: java.lang.Throwable -> L4f
        L33:
            com.lingku.xuanshang.xutils.DbManager r1 = r3.a     // Catch: java.lang.Throwable -> L4f
            com.lingku.xuanshang.xutils.DbManager$DaoConfig r1 = r1.getDaoConfig()     // Catch: java.lang.Throwable -> L4f
            com.lingku.xuanshang.xutils.DbManager$TableCreateListener r1 = r1.getTableCreateListener()     // Catch: java.lang.Throwable -> L4f
            if (r1 == 0) goto L4d
            com.lingku.xuanshang.xutils.DbManager r2 = r3.a     // Catch: java.lang.Throwable -> L45
            r1.onTableCreated(r2, r3)     // Catch: java.lang.Throwable -> L45
            goto L4d
        L45:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()     // Catch: java.lang.Throwable -> L4f
            com.lingku.xuanshang.xutils.common.util.LogUtil.e(r2, r1)     // Catch: java.lang.Throwable -> L4f
        L4d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4f
            return
        L4f:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4f
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lingku.xuanshang.xutils.db.table.TableEntity.createTableIfNotExists():void");
    }

    public LinkedHashMap<String, ColumnEntity> getColumnMap() {
        return this.h;
    }

    public DbManager getDb() {
        return this.a;
    }

    public Class<T> getEntityType() {
        return this.d;
    }

    public ColumnEntity getId() {
        return this.f;
    }

    public String getName() {
        return this.b;
    }

    public String getOnCreated() {
        return this.c;
    }

    public boolean tableIsExists() {
        return tableIsExists(false);
    }

    public boolean tableIsExists(boolean z) {
        if (this.g == null || (!this.g.booleanValue() && z)) {
            Cursor cursorExecQuery = this.a.execQuery("SELECT COUNT(*) AS c FROM sqlite_master WHERE type='table' AND name='" + this.b + "'");
            if (cursorExecQuery != null) {
                try {
                    if (cursorExecQuery.moveToNext() && cursorExecQuery.getInt(0) > 0) {
                        this.g = Boolean.TRUE;
                        return this.g.booleanValue();
                    }
                } finally {
                }
            }
            this.g = Boolean.FALSE;
        }
        return this.g.booleanValue();
    }

    public String toString() {
        return this.b;
    }
}
