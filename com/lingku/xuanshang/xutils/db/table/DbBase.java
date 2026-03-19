package com.lingku.xuanshang.xutils.db.table;

import android.database.Cursor;
import com.lingku.xuanshang.xutils.DbManager;
import com.lingku.xuanshang.xutils.common.util.IOUtil;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.ex.DbException;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class DbBase implements DbManager {
    public final HashMap<Class<?>, TableEntity<?>> a = new HashMap<>();

    @Override // com.lingku.xuanshang.xutils.DbManager
    public void addColumn(Class<?> cls, String str) throws DbException {
        TableEntity table = getTable(cls);
        ColumnEntity columnEntity = table.getColumnMap().get(str);
        if (columnEntity == null) {
            throw new DbException("the column(" + str + ") is not defined in table: " + table.getName());
        }
        if (table.tableIsExists()) {
            StringBuilder sb = new StringBuilder();
            sb.append("ALTER TABLE ").append("\"").append(table.getName()).append("\"").append(" ADD COLUMN ").append("\"").append(columnEntity.getName()).append("\"").append(" ").append(columnEntity.getColumnDbType()).append(" ").append(columnEntity.getProperty());
            execNonQuery(sb.toString());
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public void dropDb() {
        Cursor cursorExecQuery = execQuery("SELECT name FROM sqlite_master WHERE type='table' AND name<>'sqlite_sequence'");
        if (cursorExecQuery != null) {
            while (cursorExecQuery.moveToNext()) {
                try {
                    try {
                        execNonQuery("DROP TABLE " + cursorExecQuery.getString(0));
                    } catch (Throwable th) {
                        LogUtil.e(th.getMessage(), th);
                    }
                } catch (Throwable th2) {
                    try {
                        throw new DbException(th2);
                    } finally {
                        IOUtil.closeQuietly(cursorExecQuery);
                    }
                }
            }
            synchronized (this.a) {
                Iterator<TableEntity<?>> it = this.a.values().iterator();
                while (it.hasNext()) {
                    it.next().g = Boolean.FALSE;
                }
                this.a.clear();
            }
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public void dropTable(Class<?> cls) {
        TableEntity table = getTable(cls);
        if (table.tableIsExists()) {
            execNonQuery("DROP TABLE \"" + table.getName() + "\"");
            table.g = Boolean.FALSE;
            removeTable(cls);
        }
    }

    @Override // com.lingku.xuanshang.xutils.DbManager
    public <T> TableEntity<T> getTable(Class<T> cls) {
        TableEntity<T> tableEntity;
        synchronized (this.a) {
            tableEntity = (TableEntity) this.a.get(cls);
            if (tableEntity == null) {
                try {
                    try {
                        tableEntity = new TableEntity<>(this, cls);
                        this.a.put(cls, tableEntity);
                    } catch (DbException e) {
                        throw e;
                    }
                } catch (Throwable th) {
                    throw new DbException(th);
                }
            }
        }
        return tableEntity;
    }

    public void removeTable(Class<?> cls) {
        synchronized (this.a) {
            this.a.remove(cls);
        }
    }
}
