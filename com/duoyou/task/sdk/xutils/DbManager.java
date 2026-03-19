package com.duoyou.task.sdk.xutils;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.duoyou.task.sdk.xutils.common.util.KeyValue;
import com.duoyou.task.sdk.xutils.db.Selector;
import com.duoyou.task.sdk.xutils.db.sqlite.SqlInfo;
import com.duoyou.task.sdk.xutils.db.sqlite.WhereBuilder;
import com.duoyou.task.sdk.xutils.db.table.DbModel;
import com.duoyou.task.sdk.xutils.db.table.TableEntity;
import java.io.Closeable;
import java.io.File;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface DbManager extends Closeable {

    public interface DbOpenListener {
        void onDbOpened(DbManager dbManager);
    }

    public interface DbUpgradeListener {
        void onUpgrade(DbManager dbManager, int i, int i2);
    }

    public interface TableCreateListener {
        void onTableCreated(DbManager dbManager, TableEntity<?> tableEntity);
    }

    void addColumn(Class<?> cls, String str);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int delete(Class<?> cls, WhereBuilder whereBuilder);

    void delete(Class<?> cls);

    void delete(Object obj);

    void deleteById(Class<?> cls, Object obj);

    void dropDb();

    void dropTable(Class<?> cls);

    void execNonQuery(SqlInfo sqlInfo);

    void execNonQuery(String str);

    Cursor execQuery(SqlInfo sqlInfo);

    Cursor execQuery(String str);

    int executeUpdateDelete(SqlInfo sqlInfo);

    int executeUpdateDelete(String str);

    <T> List<T> findAll(Class<T> cls);

    <T> T findById(Class<T> cls, Object obj);

    List<DbModel> findDbModelAll(SqlInfo sqlInfo);

    DbModel findDbModelFirst(SqlInfo sqlInfo);

    <T> T findFirst(Class<T> cls);

    DaoConfig getDaoConfig();

    SQLiteDatabase getDatabase();

    <T> TableEntity<T> getTable(Class<T> cls);

    void replace(Object obj);

    void save(Object obj);

    boolean saveBindingId(Object obj);

    void saveOrUpdate(Object obj);

    <T> Selector<T> selector(Class<T> cls);

    int update(Class<?> cls, WhereBuilder whereBuilder, KeyValue... keyValueArr);

    void update(Object obj, String... strArr);

    public static class DaoConfig {
        private File dbDir;
        private DbOpenListener dbOpenListener;
        private DbUpgradeListener dbUpgradeListener;
        private TableCreateListener tableCreateListener;
        private String dbName = "xUtils.db";
        private int dbVersion = 1;
        private boolean allowTransaction = true;

        public DaoConfig setDbDir(File file) {
            this.dbDir = file;
            return this;
        }

        public DaoConfig setDbName(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.dbName = str;
            }
            return this;
        }

        public DaoConfig setDbVersion(int i) {
            this.dbVersion = i;
            return this;
        }

        public DaoConfig setAllowTransaction(boolean z) {
            this.allowTransaction = z;
            return this;
        }

        public DaoConfig setDbOpenListener(DbOpenListener dbOpenListener) {
            this.dbOpenListener = dbOpenListener;
            return this;
        }

        public DaoConfig setDbUpgradeListener(DbUpgradeListener dbUpgradeListener) {
            this.dbUpgradeListener = dbUpgradeListener;
            return this;
        }

        public DaoConfig setTableCreateListener(TableCreateListener tableCreateListener) {
            this.tableCreateListener = tableCreateListener;
            return this;
        }

        public File getDbDir() {
            return this.dbDir;
        }

        public String getDbName() {
            return this.dbName;
        }

        public int getDbVersion() {
            return this.dbVersion;
        }

        public boolean isAllowTransaction() {
            return this.allowTransaction;
        }

        public DbOpenListener getDbOpenListener() {
            return this.dbOpenListener;
        }

        public DbUpgradeListener getDbUpgradeListener() {
            return this.dbUpgradeListener;
        }

        public TableCreateListener getTableCreateListener() {
            return this.tableCreateListener;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DaoConfig daoConfig = (DaoConfig) obj;
            if (!this.dbName.equals(daoConfig.dbName)) {
                return false;
            }
            File file = this.dbDir;
            File file2 = daoConfig.dbDir;
            return file == null ? file2 == null : file.equals(file2);
        }

        public int hashCode() {
            int iHashCode = this.dbName.hashCode() * 31;
            File file = this.dbDir;
            return iHashCode + (file != null ? file.hashCode() : 0);
        }

        public String toString() {
            return String.valueOf(this.dbDir) + "/" + this.dbName;
        }
    }
}
