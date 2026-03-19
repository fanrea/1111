package com.duoyou.task.sdk.xutils.db.table;

import android.database.Cursor;
import com.duoyou.task.sdk.xutils.DbManager;
import com.duoyou.task.sdk.xutils.common.util.IOUtil;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.ex.DbException;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class DbBase implements DbManager {
    private final HashMap<Class<?>, TableEntity<?>> tableMap = new HashMap<>();

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public <T> TableEntity<T> getTable(Class<T> cls) {
        TableEntity<T> tableEntity;
        synchronized (this.tableMap) {
            tableEntity = (TableEntity) this.tableMap.get(cls);
            if (tableEntity == null) {
                try {
                    try {
                        tableEntity = new TableEntity<>(this, cls);
                        this.tableMap.put(cls, tableEntity);
                    } catch (Throwable th) {
                        throw new DbException(th);
                    }
                } catch (DbException e) {
                    throw e;
                }
            }
        }
        return tableEntity;
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public void dropTable(Class<?> cls) {
        TableEntity table = getTable(cls);
        if (table.tableIsExists()) {
            execNonQuery("DROP TABLE \"" + table.getName() + "\"");
            table.setTableCheckedStatus(false);
            removeTable(cls);
        }
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
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
            synchronized (this.tableMap) {
                Iterator<TableEntity<?>> it = this.tableMap.values().iterator();
                while (it.hasNext()) {
                    it.next().setTableCheckedStatus(false);
                }
                this.tableMap.clear();
            }
        }
    }

    @Override // com.duoyou.task.sdk.xutils.DbManager
    public void addColumn(Class<?> cls, String str) throws DbException {
        TableEntity table = getTable(cls);
        ColumnEntity columnEntity = table.getColumnMap().get(str);
        if (columnEntity != null) {
            if (table.tableIsExists()) {
                StringBuilder sb = new StringBuilder();
                sb.append("ALTER TABLE ").append("\"").append(table.getName()).append("\"").append(" ADD COLUMN ").append("\"").append(columnEntity.getName()).append("\"").append(" ").append(columnEntity.getColumnDbType()).append(" ").append(columnEntity.getProperty());
                execNonQuery(sb.toString());
                return;
            }
            return;
        }
        throw new DbException("the column(" + str + ") is not defined in table: " + table.getName());
    }

    public void removeTable(Class<?> cls) {
        synchronized (this.tableMap) {
            this.tableMap.remove(cls);
        }
    }
}
