package com.duoyou.task.sdk.xutils.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import com.duoyou.task.sdk.xutils.DbManager;
import com.duoyou.task.sdk.xutils.common.util.IOUtil;
import com.duoyou.task.sdk.xutils.common.util.KeyValue;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.db.sqlite.SqlInfo;
import com.duoyou.task.sdk.xutils.db.sqlite.SqlInfoBuilder;
import com.duoyou.task.sdk.xutils.db.sqlite.WhereBuilder;
import com.duoyou.task.sdk.xutils.db.table.ColumnEntity;
import com.duoyou.task.sdk.xutils.db.table.DbBase;
import com.duoyou.task.sdk.xutils.db.table.DbModel;
import com.duoyou.task.sdk.xutils.db.table.TableEntity;
import com.duoyou.task.sdk.xutils.ex.DbException;
import com.duoyou.task.sdk.xutils.x;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class DbManagerImpl extends DbBase {
    private static final HashMap<DbManager.DaoConfig, DbManagerImpl> DAO_MAP = new HashMap<>();
    private boolean allowTransaction;
    private DbManager.DaoConfig daoConfig;
    private SQLiteDatabase database;

    private DbManagerImpl(DbManager.DaoConfig daoConfig) throws DbException {
        if (daoConfig == null) {
            throw new IllegalArgumentException("daoConfig may not be null");
        }
        this.daoConfig = daoConfig;
        this.allowTransaction = daoConfig.isAllowTransaction();
        try {
            this.database = openOrCreateDatabase(daoConfig);
            DbManager.DbOpenListener dbOpenListener = daoConfig.getDbOpenListener();
            if (dbOpenListener != null) {
                dbOpenListener.onDbOpened(this);
            }
        } catch (DbException e) {
            IOUtil.closeQuietly(this.database);
            throw e;
        } catch (Throwable th) {
            IOUtil.closeQuietly(this.database);
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
    public static synchronized com.duoyou.task.sdk.xutils.DbManager getInstance(com.duoyou.task.sdk.xutils.DbManager.DaoConfig r5) {
        /*
            java.lang.Class<com.duoyou.task.sdk.xutils.db.DbManagerImpl> r0 = com.duoyou.task.sdk.xutils.db.DbManagerImpl.class
            monitor-enter(r0)
            if (r5 != 0) goto La
            com.duoyou.task.sdk.xutils.DbManager$DaoConfig r5 = new com.duoyou.task.sdk.xutils.DbManager$DaoConfig     // Catch: java.lang.Throwable -> L3f
            r5.<init>()     // Catch: java.lang.Throwable -> L3f
        La:
            java.util.HashMap<com.duoyou.task.sdk.xutils.DbManager$DaoConfig, com.duoyou.task.sdk.xutils.db.DbManagerImpl> r1 = com.duoyou.task.sdk.xutils.db.DbManagerImpl.DAO_MAP     // Catch: java.lang.Throwable -> L3f
            java.lang.Object r2 = r1.get(r5)     // Catch: java.lang.Throwable -> L3f
            com.duoyou.task.sdk.xutils.db.DbManagerImpl r2 = (com.duoyou.task.sdk.xutils.db.DbManagerImpl) r2     // Catch: java.lang.Throwable -> L3f
            if (r2 != 0) goto L1d
            com.duoyou.task.sdk.xutils.db.DbManagerImpl r2 = new com.duoyou.task.sdk.xutils.db.DbManagerImpl     // Catch: java.lang.Throwable -> L3f
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L3f
            r1.put(r5, r2)     // Catch: java.lang.Throwable -> L3f
            goto L1f
        L1d:
            r2.daoConfig = r5     // Catch: java.lang.Throwable -> L3f
        L1f:
            android.database.sqlite.SQLiteDatabase r1 = r2.database     // Catch: java.lang.Throwable -> L3f
            int r3 = r1.getVersion()     // Catch: java.lang.Throwable -> L3f
            int r4 = r5.getDbVersion()     // Catch: java.lang.Throwable -> L3f
            if (r3 == r4) goto L3d
            if (r3 == 0) goto L3a
            com.duoyou.task.sdk.xutils.DbManager$DbUpgradeListener r5 = r5.getDbUpgradeListener()     // Catch: java.lang.Throwable -> L3f
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
        throw new UnsupportedOperationException("Method not decompiled: com.duoyou.task.sdk.xutils.db.DbManagerImpl.getInstance(com.duoyou.task.sdk.xutils.DbManager$DaoConfig):com.duoyou.task.sdk.xutils.DbManager");
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public SQLiteDatabase getDatabase() {
        return this.database;
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public DbManager.DaoConfig getDaoConfig() {
        return this.daoConfig;
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public void saveOrUpdate(Object obj) {
        try {
            beginTransaction();
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.isEmpty()) {
                    return;
                }
                TableEntity<?> table = getTable(list.get(0).getClass());
                table.createTableIfNotExists();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    saveOrUpdateWithoutTransaction(table, it.next());
                }
            } else {
                TableEntity<?> table2 = getTable(obj.getClass());
                table2.createTableIfNotExists();
                saveOrUpdateWithoutTransaction(table2, obj);
            }
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public void replace(Object obj) {
        try {
            beginTransaction();
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
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public void save(Object obj) {
        try {
            beginTransaction();
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
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public boolean saveBindingId(Object obj) {
        try {
            beginTransaction();
            boolean zSaveBindingIdWithoutTransaction = false;
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.isEmpty()) {
                    return false;
                }
                TableEntity<?> table = getTable(list.get(0).getClass());
                table.createTableIfNotExists();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (!saveBindingIdWithoutTransaction(table, it.next())) {
                        throw new DbException("saveBindingId error, transaction will not commit!");
                    }
                }
            } else {
                TableEntity<?> table2 = getTable(obj.getClass());
                table2.createTableIfNotExists();
                zSaveBindingIdWithoutTransaction = saveBindingIdWithoutTransaction(table2, obj);
            }
            setTransactionSuccessful();
            return zSaveBindingIdWithoutTransaction;
        } finally {
            endTransaction();
        }
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public void deleteById(Class<?> cls, Object obj) {
        TableEntity table = getTable(cls);
        if (table.tableIsExists()) {
            try {
                beginTransaction();
                execNonQuery(SqlInfoBuilder.buildDeleteSqlInfoById(table, obj));
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public void delete(Object obj) {
        try {
            beginTransaction();
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
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public void delete(Class<?> cls) {
        delete(cls, null);
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public int delete(Class<?> cls, WhereBuilder whereBuilder) {
        TableEntity table = getTable(cls);
        if (!table.tableIsExists()) {
            return 0;
        }
        try {
            beginTransaction();
            int iExecuteUpdateDelete = executeUpdateDelete(SqlInfoBuilder.buildDeleteSqlInfo((TableEntity<?>) table, whereBuilder));
            setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            endTransaction();
        }
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public void update(Object obj, String... strArr) {
        try {
            beginTransaction();
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
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public int update(Class<?> cls, WhereBuilder whereBuilder, KeyValue... keyValueArr) {
        TableEntity table = getTable(cls);
        if (!table.tableIsExists()) {
            return 0;
        }
        try {
            beginTransaction();
            int iExecuteUpdateDelete = executeUpdateDelete(SqlInfoBuilder.buildUpdateSqlInfo((TableEntity<?>) table, whereBuilder, keyValueArr));
            setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            endTransaction();
        }
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public <T> T findById(Class<T> cls, Object obj) {
        Cursor cursorExecQuery;
        TableEntity<T> table = getTable(cls);
        if (table.tableIsExists() && (cursorExecQuery = execQuery(Selector.from(table).where(table.getId().getName(), "=", obj).limit(1).toString())) != null) {
            try {
                if (cursorExecQuery.moveToNext()) {
                    return (T) CursorUtils.getEntity(table, cursorExecQuery);
                }
            } finally {
            }
        }
        return null;
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public <T> T findFirst(Class<T> cls) {
        return selector(cls).findFirst();
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public <T> List<T> findAll(Class<T> cls) {
        return selector(cls).findAll();
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public <T> Selector<T> selector(Class<T> cls) {
        return Selector.from(getTable(cls));
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public DbModel findDbModelFirst(SqlInfo sqlInfo) throws DbException {
        Cursor cursorExecQuery = execQuery(sqlInfo);
        if (cursorExecQuery == null) {
            return null;
        }
        try {
            if (cursorExecQuery.moveToNext()) {
                return CursorUtils.getDbModel(cursorExecQuery);
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

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public List<DbModel> findDbModelAll(SqlInfo sqlInfo) throws DbException {
        ArrayList arrayList = new ArrayList();
        Cursor cursorExecQuery = execQuery(sqlInfo);
        if (cursorExecQuery != null) {
            while (cursorExecQuery.moveToNext()) {
                try {
                    arrayList.add(CursorUtils.getDbModel(cursorExecQuery));
                } finally {
                }
            }
        }
        return arrayList;
    }

    private SQLiteDatabase openOrCreateDatabase(DbManager.DaoConfig daoConfig) {
        File dbDir = daoConfig.getDbDir();
        if (dbDir != null && (dbDir.exists() || dbDir.mkdirs())) {
            return SQLiteDatabase.openOrCreateDatabase(new File(dbDir, daoConfig.getDbName()), (SQLiteDatabase.CursorFactory) null);
        }
        return x.app().openOrCreateDatabase(daoConfig.getDbName(), 0, null);
    }

    private void saveOrUpdateWithoutTransaction(TableEntity<?> tableEntity, Object obj) throws DbException {
        ColumnEntity id = tableEntity.getId();
        if (id.isAutoId()) {
            if (id.getColumnValue(obj) != null) {
                execNonQuery(SqlInfoBuilder.buildUpdateSqlInfo(tableEntity, obj, new String[0]));
                return;
            } else {
                saveBindingIdWithoutTransaction(tableEntity, obj);
                return;
            }
        }
        execNonQuery(SqlInfoBuilder.buildReplaceSqlInfo(tableEntity, obj));
    }

    private boolean saveBindingIdWithoutTransaction(TableEntity<?> tableEntity, Object obj) throws DbException {
        ColumnEntity id = tableEntity.getId();
        if (id.isAutoId()) {
            execNonQuery(SqlInfoBuilder.buildInsertSqlInfo(tableEntity, obj));
            long lastAutoIncrementId = getLastAutoIncrementId(tableEntity.getName());
            if (lastAutoIncrementId == -1) {
                return false;
            }
            id.setAutoIdValue(obj, lastAutoIncrementId);
            return true;
        }
        execNonQuery(SqlInfoBuilder.buildInsertSqlInfo(tableEntity, obj));
        return true;
    }

    private long getLastAutoIncrementId(String str) throws DbException {
        Cursor cursorExecQuery = execQuery("SELECT seq FROM sqlite_sequence WHERE name='" + str + "' LIMIT 1");
        if (cursorExecQuery != null) {
            try {
                j = cursorExecQuery.moveToNext() ? cursorExecQuery.getLong(0) : -1L;
            } finally {
            }
        }
        return j;
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        HashMap<DbManager.DaoConfig, DbManagerImpl> map = DAO_MAP;
        if (map.containsKey(this.daoConfig)) {
            map.remove(this.daoConfig);
            this.database.close();
        }
    }

    private void beginTransaction() {
        if (this.allowTransaction) {
            if (Build.VERSION.SDK_INT >= 16 && this.database.isWriteAheadLoggingEnabled()) {
                this.database.beginTransactionNonExclusive();
            } else {
                this.database.beginTransaction();
            }
        }
    }

    private void setTransactionSuccessful() {
        if (this.allowTransaction) {
            this.database.setTransactionSuccessful();
        }
    }

    private void endTransaction() {
        if (this.allowTransaction) {
            this.database.endTransaction();
        }
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public int executeUpdateDelete(SqlInfo sqlInfo) {
        SQLiteStatement sQLiteStatementBuildStatement = null;
        try {
            sQLiteStatementBuildStatement = sqlInfo.buildStatement(this.database);
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

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public int executeUpdateDelete(String str) {
        SQLiteStatement sQLiteStatementCompileStatement = null;
        try {
            sQLiteStatementCompileStatement = this.database.compileStatement(str);
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

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public void execNonQuery(SqlInfo sqlInfo) {
        SQLiteStatement sQLiteStatementBuildStatement = null;
        try {
            sQLiteStatementBuildStatement = sqlInfo.buildStatement(this.database);
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

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public void execNonQuery(String str) throws DbException {
        try {
            this.database.execSQL(str);
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public Cursor execQuery(SqlInfo sqlInfo) throws DbException {
        try {
            return this.database.rawQuery(sqlInfo.getSql(), sqlInfo.getBindArgsAsStrArray());
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public Cursor execQuery(String str) throws DbException {
        try {
            return this.database.rawQuery(str, null);
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }
}
