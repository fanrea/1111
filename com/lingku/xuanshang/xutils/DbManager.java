package com.lingku.xuanshang.xutils;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.lingku.xuanshang.xutils.common.util.KeyValue;
import com.lingku.xuanshang.xutils.db.Selector;
import com.lingku.xuanshang.xutils.db.sqlite.SqlInfo;
import com.lingku.xuanshang.xutils.db.sqlite.WhereBuilder;
import com.lingku.xuanshang.xutils.db.table.DbModel;
import com.lingku.xuanshang.xutils.db.table.TableEntity;
import java.io.Closeable;
import java.io.File;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface DbManager extends Closeable {

    public static class DaoConfig {
        public File a;
        public String b = "xUtils.db";
        public int c = 1;
        public boolean d = true;
        public DbUpgradeListener e;
        public TableCreateListener f;
        public DbOpenListener g;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DaoConfig daoConfig = (DaoConfig) obj;
            if (!this.b.equals(daoConfig.b)) {
                return false;
            }
            File file = this.a;
            File file2 = daoConfig.a;
            return file == null ? file2 == null : file.equals(file2);
        }

        public File getDbDir() {
            return this.a;
        }

        public String getDbName() {
            return this.b;
        }

        public DbOpenListener getDbOpenListener() {
            return this.g;
        }

        public DbUpgradeListener getDbUpgradeListener() {
            return this.e;
        }

        public int getDbVersion() {
            return this.c;
        }

        public TableCreateListener getTableCreateListener() {
            return this.f;
        }

        public int hashCode() {
            int iHashCode = this.b.hashCode() * 31;
            File file = this.a;
            return iHashCode + (file != null ? file.hashCode() : 0);
        }

        public boolean isAllowTransaction() {
            return this.d;
        }

        public DaoConfig setAllowTransaction(boolean z) {
            this.d = z;
            return this;
        }

        public DaoConfig setDbDir(File file) {
            this.a = file;
            return this;
        }

        public DaoConfig setDbName(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.b = str;
            }
            return this;
        }

        public DaoConfig setDbOpenListener(DbOpenListener dbOpenListener) {
            this.g = dbOpenListener;
            return this;
        }

        public DaoConfig setDbUpgradeListener(DbUpgradeListener dbUpgradeListener) {
            this.e = dbUpgradeListener;
            return this;
        }

        public DaoConfig setDbVersion(int i) {
            this.c = i;
            return this;
        }

        public DaoConfig setTableCreateListener(TableCreateListener tableCreateListener) {
            this.f = tableCreateListener;
            return this;
        }

        public String toString() {
            return String.valueOf(this.a) + "/" + this.b;
        }
    }

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
}
