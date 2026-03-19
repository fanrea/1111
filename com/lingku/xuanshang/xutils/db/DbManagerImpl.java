package com.lingku.xuanshang.xutils.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import com.lingku.xuanshang.xutils.DbManager;
import com.lingku.xuanshang.xutils.common.util.IOUtil;
import com.lingku.xuanshang.xutils.common.util.KeyValue;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.db.sqlite.SqlInfo;
import com.lingku.xuanshang.xutils.db.sqlite.SqlInfoBuilder;
import com.lingku.xuanshang.xutils.db.sqlite.WhereBuilder;
import com.lingku.xuanshang.xutils.db.table.ColumnEntity;
import com.lingku.xuanshang.xutils.db.table.DbBase;
import com.lingku.xuanshang.xutils.db.table.DbModel;
import com.lingku.xuanshang.xutils.db.table.TableEntity;
import com.lingku.xuanshang.xutils.ex.DbException;
import com.lingku.xuanshang.xutils.x;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import lkxssdk.l0.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class DbManagerImpl extends DbBase {
    public static final HashMap<DbManager.DaoConfig, DbManagerImpl> b = new HashMap<>();
    public SQLiteDatabase c;
    public DbManager.DaoConfig d;
    public boolean e;

    public DbManagerImpl(DbManager.DaoConfig daoConfig) throws DbException {
        this.d = daoConfig;
        this.e = daoConfig.isAllowTransaction();
        try {
            this.c = a(daoConfig);
            DbManager.DbOpenListener dbOpenListener = daoConfig.getDbOpenListener();
            if (dbOpenListener != null) {
                dbOpenListener.onDbOpened(this);
            }
        } catch (DbException e) {
            IOUtil.closeQuietly(this.c);
            throw e;
        } catch (Throwable th) {
            IOUtil.closeQuietly(this.c);
            throw new DbException(th.getMessage(), th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014 A[Catch: all -> 0x003f, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x0014, B:10:0x001f, B:13:0x002d, B:15:0x0033, B:16:0x0037, B:17:0x003a, B:9:0x001d), top: B:23:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001d A[Catch: all -> 0x003f, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x0014, B:10:0x001f, B:13:0x002d, B:15:0x0033, B:16:0x0037, B:17:0x003a, B:9:0x001d), top: B:23:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized com.lingku.xuanshang.xutils.DbManager getInstance(com.lingku.xuanshang.xutils.DbManager.DaoConfig r5) {
        /*
            java.lang.Class<com.lingku.xuanshang.xutils.db.DbManagerImpl> r0 = com.lingku.xuanshang.xutils.db.DbManagerImpl.class
            monitor-enter(r0)
            if (r5 != 0) goto La
            com.lingku.xuanshang.xutils.DbManager$DaoConfig r5 = new com.lingku.xuanshang.xutils.DbManager$DaoConfig     // Catch: java.lang.Throwable -> L3f
            r5.<init>()     // Catch: java.lang.Throwable -> L3f
        La:
            java.util.HashMap<com.lingku.xuanshang.xutils.DbManager$DaoConfig, com.lingku.xuanshang.xutils.db.DbManagerImpl> r1 = com.lingku.xuanshang.xutils.db.DbManagerImpl.b     // Catch: java.lang.Throwable -> L3f
            java.lang.Object r2 = r1.get(r5)     // Catch: java.lang.Throwable -> L3f
            com.lingku.xuanshang.xutils.db.DbManagerImpl r2 = (com.lingku.xuanshang.xutils.db.DbManagerImpl) r2     // Catch: java.lang.Throwable -> L3f
            if (r2 != 0) goto L1d
            com.lingku.xuanshang.xutils.db.DbManagerImpl r2 = new com.lingku.xuanshang.xutils.db.DbManagerImpl     // Catch: java.lang.Throwable -> L3f
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L3f
            r1.put(r5, r2)     // Catch: java.lang.Throwable -> L3f
            goto L1f
        L1d:
            r2.d = r5     // Catch: java.lang.Throwable -> L3f
        L1f:
            android.database.sqlite.SQLiteDatabase r1 = r2.c     // Catch: java.lang.Throwable -> L3f
            int r3 = r1.getVersion()     // Catch: java.lang.Throwable -> L3f
            int r4 = r5.getDbVersion()     // Catch: java.lang.Throwable -> L3f
            if (r3 == r4) goto L3d
            if (r3 == 0) goto L3a
            com.lingku.xuanshang.xutils.DbManager$DbUpgradeListener r5 = r5.getDbUpgradeListener()     // Catch: java.lang.Throwable -> L3f
            if (r5 == 0) goto L37
            r5.onUpgrade(r2, r3, r4)     // Catch: java.lang.Throwable -> L3f
            goto L3a
        L37:
            r2.dropDb()     // Catch: java.lang.Throwable -> L3f
        L3a:
            r1.setVersion(r4)     // Catch: java.lang.Throwable -> L3f
        L3d:
            monitor-exit(r0)
            return r2
        L3f:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lingku.xuanshang.xutils.db.DbManagerImpl.getInstance(com.lingku.xuanshang.xutils.DbManager$DaoConfig):com.lingku.xuanshang.xutils.DbManager");
    }

    public final SQLiteDatabase a(DbManager.DaoConfig daoConfig) {
        File dbDir = daoConfig.getDbDir();
        return (dbDir == null || !(dbDir.exists() || dbDir.mkdirs())) ? x.app().openOrCreateDatabase(daoConfig.getDbName(), 0, null) : SQLiteDatabase.openOrCreateDatabase(new File(dbDir, daoConfig.getDbName()), (SQLiteDatabase.CursorFactory) null);
    }

    public final void a() {
        if (this.e) {
            if (Build.VERSION.SDK_INT < 16 || !this.c.isWriteAheadLoggingEnabled()) {
                this.c.beginTransaction();
            } else {
                this.c.beginTransactionNonExclusive();
            }
        }
    }

    public final boolean a(TableEntity<?> tableEntity, Object obj) throws DbException {
        long j;
        ColumnEntity id = tableEntity.getId();
        if (!id.isAutoId()) {
            execNonQuery(SqlInfoBuilder.buildInsertSqlInfo(tableEntity, obj));
            return true;
        }
        execNonQuery(SqlInfoBuilder.buildInsertSqlInfo(tableEntity, obj));
        Cursor cursorExecQuery = execQuery("SELECT seq FROM sqlite_sequence WHERE name='" + tableEntity.getName() + "' LIMIT 1");
        if (cursorExecQuery != null) {
            try {
                j = cursorExecQuery.moveToNext() ? cursorExecQuery.getLong(0) : -1L;
            } finally {
            }
        } else {
            j = -1;
        }
        if (j == -1) {
            return false;
        }
        id.setAutoIdValue(obj, j);
        return true;
    }

    public final void b() {
        if (this.e) {
            this.c.endTransaction();
        }
    }

    public final void b(TableEntity<?> tableEntity, Object obj) throws DbException {
        SqlInfo sqlInfoBuildReplaceSqlInfo;
        ColumnEntity id = tableEntity.getId();
        if (!id.isAutoId()) {
            sqlInfoBuildReplaceSqlInfo = SqlInfoBuilder.buildReplaceSqlInfo(tableEntity, obj);
        } else {
            if (id.getColumnValue(obj) == null) {
                a(tableEntity, obj);
                return;
            }
            sqlInfoBuildReplaceSqlInfo = SqlInfoBuilder.buildUpdateSqlInfo(tableEntity, obj, new String[0]);
        }
        execNonQuery(sqlInfoBuildReplaceSqlInfo);
    }

    public final void c() {
        if (this.e) {
            this.c.setTransactionSuccessful();
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        HashMap<DbManager.DaoConfig, DbManagerImpl> map = b;
        if (map.containsKey(this.d)) {
            map.remove(this.d);
            this.c.close();
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public int delete(Class<?> cls, WhereBuilder whereBuilder) {
        TableEntity table = getTable(cls);
        if (!table.tableIsExists()) {
            return 0;
        }
        try {
            a();
            int iExecuteUpdateDelete = executeUpdateDelete(SqlInfoBuilder.buildDeleteSqlInfo((TableEntity<?>) table, whereBuilder));
            c();
            return iExecuteUpdateDelete;
        } finally {
            b();
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public void delete(Class<?> cls) {
        delete(cls, null);
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public void delete(Object obj) {
        try {
            a();
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.isEmpty()) {
                    return;
                }
                TableEntity table = getTable(list.get(0).getClass());
                if (!table.tableIsExists()) {
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    execNonQuery(SqlInfoBuilder.buildDeleteSqlInfo((TableEntity<?>) table, it.next()));
                }
            } else {
                TableEntity table2 = getTable(obj.getClass());
                if (!table2.tableIsExists()) {
                    return;
                } else {
                    execNonQuery(SqlInfoBuilder.buildDeleteSqlInfo((TableEntity<?>) table2, obj));
                }
            }
            c();
        } finally {
            b();
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public void deleteById(Class<?> cls, Object obj) {
        TableEntity table = getTable(cls);
        if (table.tableIsExists()) {
            try {
                a();
                execNonQuery(SqlInfoBuilder.buildDeleteSqlInfoById(table, obj));
                c();
            } finally {
                b();
            }
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public void execNonQuery(SqlInfo sqlInfo) {
        SQLiteStatement sQLiteStatementBuildStatement = null;
        try {
            sQLiteStatementBuildStatement = sqlInfo.buildStatement(this.c);
            sQLiteStatementBuildStatement.execute();
            try {
                sQLiteStatementBuildStatement.releaseReference();
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
            }
        } catch (Throwable th2) {
            try {
                throw new DbException(th2);
            } catch (Throwable th3) {
                if (sQLiteStatementBuildStatement != null) {
                    try {
                        sQLiteStatementBuildStatement.releaseReference();
                    } catch (Throwable th4) {
                        LogUtil.e(th4.getMessage(), th4);
                    }
                }
                throw th3;
            }
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public void execNonQuery(String str) throws DbException {
        try {
            this.c.execSQL(str);
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public Cursor execQuery(SqlInfo sqlInfo) throws DbException {
        try {
            return this.c.rawQuery(sqlInfo.getSql(), sqlInfo.getBindArgsAsStrArray());
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public Cursor execQuery(String str) throws DbException {
        try {
            return this.c.rawQuery(str, null);
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public int executeUpdateDelete(SqlInfo sqlInfo) {
        SQLiteStatement sQLiteStatementBuildStatement = null;
        try {
            sQLiteStatementBuildStatement = sqlInfo.buildStatement(this.c);
            int iExecuteUpdateDelete = sQLiteStatementBuildStatement.executeUpdateDelete();
            try {
                sQLiteStatementBuildStatement.releaseReference();
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
            }
            return iExecuteUpdateDelete;
        } catch (Throwable th2) {
            try {
                throw new DbException(th2);
            } catch (Throwable th3) {
                if (sQLiteStatementBuildStatement != null) {
                    try {
                        sQLiteStatementBuildStatement.releaseReference();
                    } catch (Throwable th4) {
                        LogUtil.e(th4.getMessage(), th4);
                    }
                }
                throw th3;
            }
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public int executeUpdateDelete(String str) {
        SQLiteStatement sQLiteStatementCompileStatement = null;
        try {
            sQLiteStatementCompileStatement = this.c.compileStatement(str);
            int iExecuteUpdateDelete = sQLiteStatementCompileStatement.executeUpdateDelete();
            try {
                sQLiteStatementCompileStatement.releaseReference();
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
            }
            return iExecuteUpdateDelete;
        } catch (Throwable th2) {
            try {
                throw new DbException(th2);
            } catch (Throwable th3) {
                if (sQLiteStatementCompileStatement != null) {
                    try {
                        sQLiteStatementCompileStatement.releaseReference();
                    } catch (Throwable th4) {
                        LogUtil.e(th4.getMessage(), th4);
                    }
                }
                throw th3;
            }
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public <T> List<T> findAll(Class<T> cls) {
        return selector(cls).findAll();
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public <T> T findById(Class<T> cls, Object obj) {
        Cursor cursorExecQuery;
        TableEntity<T> table = getTable(cls);
        if (table.tableIsExists() && (cursorExecQuery = execQuery(new Selector(table).where(table.getId().getName(), "=", obj).limit(1).toString())) != null) {
            try {
                if (cursorExecQuery.moveToNext()) {
                    return (T) a.a(table, cursorExecQuery);
                }
            } finally {
            }
        }
        return null;
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public List<DbModel> findDbModelAll(SqlInfo sqlInfo) throws DbException {
        ArrayList arrayList = new ArrayList();
        Cursor cursorExecQuery = execQuery(sqlInfo);
        if (cursorExecQuery != null) {
            while (cursorExecQuery.moveToNext()) {
                try {
                    arrayList.add(a.a(cursorExecQuery));
                } finally {
                }
            }
        }
        return arrayList;
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public DbModel findDbModelFirst(SqlInfo sqlInfo) throws DbException {
        Cursor cursorExecQuery = execQuery(sqlInfo);
        if (cursorExecQuery == null) {
            return null;
        }
        try {
            if (cursorExecQuery.moveToNext()) {
                return a.a(cursorExecQuery);
            }
            return null;
        } catch (Throwable th) {
            try {
                throw new DbException(th);
            } finally {
                IOUtil.closeQuietly(cursorExecQuery);
            }
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public <T> T findFirst(Class<T> cls) {
        return selector(cls).findFirst();
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public DbManager.DaoConfig getDaoConfig() {
        return this.d;
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public SQLiteDatabase getDatabase() {
        return this.c;
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public void replace(Object obj) {
        try {
            a();
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.isEmpty()) {
                    return;
                }
                TableEntity table = getTable(list.get(0).getClass());
                table.createTableIfNotExists();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    execNonQuery(SqlInfoBuilder.buildReplaceSqlInfo(table, it.next()));
                }
            } else {
                TableEntity table2 = getTable(obj.getClass());
                table2.createTableIfNotExists();
                execNonQuery(SqlInfoBuilder.buildReplaceSqlInfo(table2, obj));
            }
            c();
        } finally {
            b();
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public void save(Object obj) {
        try {
            a();
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.isEmpty()) {
                    return;
                }
                TableEntity table = getTable(list.get(0).getClass());
                table.createTableIfNotExists();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    execNonQuery(SqlInfoBuilder.buildInsertSqlInfo(table, it.next()));
                }
            } else {
                TableEntity table2 = getTable(obj.getClass());
                table2.createTableIfNotExists();
                execNonQuery(SqlInfoBuilder.buildInsertSqlInfo(table2, obj));
            }
            c();
        } finally {
            b();
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public boolean saveBindingId(Object obj) {
        try {
            a();
            boolean zA = false;
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.isEmpty()) {
                    return false;
                }
                TableEntity<?> table = getTable(list.get(0).getClass());
                table.createTableIfNotExists();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (!a(table, it.next())) {
                        throw new DbException("saveBindingId error, transaction will not commit!");
                    }
                }
            } else {
                TableEntity<?> table2 = getTable(obj.getClass());
                table2.createTableIfNotExists();
                zA = a(table2, obj);
            }
            c();
            return zA;
        } finally {
            b();
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public void saveOrUpdate(Object obj) {
        try {
            a();
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.isEmpty()) {
                    return;
                }
                TableEntity<?> table = getTable(list.get(0).getClass());
                table.createTableIfNotExists();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    b(table, it.next());
                }
            } else {
                TableEntity<?> table2 = getTable(obj.getClass());
                table2.createTableIfNotExists();
                b(table2, obj);
            }
            c();
        } finally {
            b();
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public <T> Selector<T> selector(Class<T> cls) {
        return new Selector<>(getTable(cls));
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public int update(Class<?> cls, WhereBuilder whereBuilder, KeyValue... keyValueArr) {
        TableEntity table = getTable(cls);
        if (!table.tableIsExists()) {
            return 0;
        }
        try {
            a();
            int iExecuteUpdateDelete = executeUpdateDelete(SqlInfoBuilder.buildUpdateSqlInfo((TableEntity<?>) table, whereBuilder, keyValueArr));
            c();
            return iExecuteUpdateDelete;
        } finally {
            b();
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public void update(Object obj, String... strArr) {
        try {
            a();
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.isEmpty()) {
                    return;
                }
                TableEntity table = getTable(list.get(0).getClass());
                if (!table.tableIsExists()) {
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    execNonQuery(SqlInfoBuilder.buildUpdateSqlInfo((TableEntity<?>) table, it.next(), strArr));
                }
            } else {
                TableEntity table2 = getTable(obj.getClass());
                if (!table2.tableIsExists()) {
                    return;
                } else {
                    execNonQuery(SqlInfoBuilder.buildUpdateSqlInfo((TableEntity<?>) table2, obj, strArr));
                }
            }
            c();
        } finally {
            b();
        }
    }
}
