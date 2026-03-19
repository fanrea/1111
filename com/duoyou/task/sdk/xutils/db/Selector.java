package com.duoyou.task.sdk.xutils.db;

import android.database.Cursor;
import com.duoyou.task.sdk.xutils.db.sqlite.WhereBuilder;
import com.duoyou.task.sdk.xutils.db.table.DbModel;
import com.duoyou.task.sdk.xutils.db.table.TableEntity;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class Selector<T> {
    private int limit = 0;
    private int offset = 0;
    private List<OrderBy> orderByList;
    private final TableEntity<T> table;
    private WhereBuilder whereBuilder;

    private Selector(TableEntity<T> tableEntity) {
        this.table = tableEntity;
    }

    public static <T> Selector<T> from(TableEntity<T> tableEntity) {
        return new Selector<>(tableEntity);
    }

    public Selector<T> where(WhereBuilder whereBuilder) {
        this.whereBuilder = whereBuilder;
        return this;
    }

    public Selector<T> where(String str, String str2, Object obj) {
        this.whereBuilder = WhereBuilder.b(str, str2, obj);
        return this;
    }

    public Selector<T> and(String str, String str2, Object obj) {
        this.whereBuilder.and(str, str2, obj);
        return this;
    }

    public Selector<T> and(WhereBuilder whereBuilder) {
        this.whereBuilder.and(whereBuilder);
        return this;
    }

    public Selector<T> or(String str, String str2, Object obj) {
        this.whereBuilder.or(str, str2, obj);
        return this;
    }

    public Selector<T> or(WhereBuilder whereBuilder) {
        this.whereBuilder.or(whereBuilder);
        return this;
    }

    public Selector<T> expr(String str) {
        if (this.whereBuilder == null) {
            this.whereBuilder = WhereBuilder.b();
        }
        this.whereBuilder.expr(str);
        return this;
    }

    public DbModelSelector groupBy(String str) {
        return new DbModelSelector((Selector<?>) this, str);
    }

    public DbModelSelector select(String... strArr) {
        return new DbModelSelector((Selector<?>) this, strArr);
    }

    public Selector<T> orderBy(String str) {
        if (this.orderByList == null) {
            this.orderByList = new ArrayList(5);
        }
        this.orderByList.add(new OrderBy(str));
        return this;
    }

    public Selector<T> orderBy(String str, boolean z) {
        if (this.orderByList == null) {
            this.orderByList = new ArrayList(5);
        }
        this.orderByList.add(new OrderBy(str, z));
        return this;
    }

    public Selector<T> limit(int i) {
        this.limit = i;
        return this;
    }

    public Selector<T> offset(int i) {
        this.offset = i;
        return this;
    }

    public TableEntity<T> getTable() {
        return this.table;
    }

    public WhereBuilder getWhereBuilder() {
        return this.whereBuilder;
    }

    public List<OrderBy> getOrderByList() {
        return this.orderByList;
    }

    public int getLimit() {
        return this.limit;
    }

    public int getOffset() {
        return this.offset;
    }

    public T findFirst() {
        if (!this.table.tableIsExists()) {
            return null;
        }
        limit(1);
        Cursor cursorExecQuery = this.table.getDb().execQuery(toString());
        if (cursorExecQuery != null) {
            try {
                if (cursorExecQuery.moveToNext()) {
                    return (T) CursorUtils.getEntity(this.table, cursorExecQuery);
                }
            } finally {
            }
        }
        return null;
    }

    public List<T> findAll() {
        ArrayList arrayList = null;
        if (!this.table.tableIsExists()) {
            return null;
        }
        Cursor cursorExecQuery = this.table.getDb().execQuery(toString());
        if (cursorExecQuery != null) {
            try {
                arrayList = new ArrayList();
                while (cursorExecQuery.moveToNext()) {
                    arrayList.add(CursorUtils.getEntity(this.table, cursorExecQuery));
                }
            } finally {
            }
        }
        return arrayList;
    }

    public long count() {
        DbModel dbModelFindFirst;
        if (this.table.tableIsExists() && (dbModelFindFirst = select("count(\"" + this.table.getId().getName() + "\") as count").findFirst()) != null) {
            return dbModelFindFirst.getLong("count", 0L);
        }
        return 0L;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("*");
        sb.append(" FROM ").append("\"").append(this.table.getName()).append("\"");
        WhereBuilder whereBuilder = this.whereBuilder;
        if (whereBuilder != null && whereBuilder.getWhereItemSize() > 0) {
            sb.append(" WHERE ").append(this.whereBuilder.toString());
        }
        List<OrderBy> list = this.orderByList;
        if (list != null && list.size() > 0) {
            sb.append(" ORDER BY ");
            Iterator<OrderBy> it = this.orderByList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString()).append(StringUtil.COMMA);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if (this.limit > 0) {
            sb.append(" LIMIT ").append(this.limit);
            sb.append(" OFFSET ").append(this.offset);
        }
        return sb.toString();
    }

    public static class OrderBy {
        private String columnName;
        private boolean desc;

        public OrderBy(String str) {
            this.columnName = str;
        }

        public OrderBy(String str, boolean z) {
            this.columnName = str;
            this.desc = z;
        }

        public String toString() {
            return "\"" + this.columnName + "\"" + (this.desc ? " DESC" : " ASC");
        }
    }
}
