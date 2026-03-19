package com.duoyou.task.sdk.xutils.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.duoyou.task.sdk.xutils.db.Selector;
import com.duoyou.task.sdk.xutils.db.sqlite.WhereBuilder;
import com.duoyou.task.sdk.xutils.db.table.DbModel;
import com.duoyou.task.sdk.xutils.db.table.TableEntity;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class DbModelSelector {
    private String[] columnExpressions;
    private String groupByColumnName;
    private WhereBuilder having;
    private Selector<?> selector;

    private DbModelSelector(TableEntity<?> tableEntity) {
        this.selector = Selector.from(tableEntity);
    }

    public DbModelSelector(Selector<?> selector, String str) {
        this.selector = selector;
        this.groupByColumnName = str;
    }

    public DbModelSelector(Selector<?> selector, String[] strArr) {
        this.selector = selector;
        this.columnExpressions = strArr;
    }

    public static DbModelSelector from(TableEntity<?> tableEntity) {
        return new DbModelSelector(tableEntity);
    }

    public DbModelSelector where(WhereBuilder whereBuilder) {
        this.selector.where(whereBuilder);
        return this;
    }

    public DbModelSelector where(String str, String str2, Object obj) {
        this.selector.where(str, str2, obj);
        return this;
    }

    public DbModelSelector and(String str, String str2, Object obj) {
        this.selector.and(str, str2, obj);
        return this;
    }

    public DbModelSelector and(WhereBuilder whereBuilder) {
        this.selector.and(whereBuilder);
        return this;
    }

    public DbModelSelector or(String str, String str2, Object obj) {
        this.selector.or(str, str2, obj);
        return this;
    }

    public DbModelSelector or(WhereBuilder whereBuilder) {
        this.selector.or(whereBuilder);
        return this;
    }

    public DbModelSelector expr(String str) {
        this.selector.expr(str);
        return this;
    }

    public DbModelSelector groupBy(String str) {
        this.groupByColumnName = str;
        return this;
    }

    public DbModelSelector having(WhereBuilder whereBuilder) {
        this.having = whereBuilder;
        return this;
    }

    public DbModelSelector select(String... strArr) {
        this.columnExpressions = strArr;
        return this;
    }

    public DbModelSelector orderBy(String str) {
        this.selector.orderBy(str);
        return this;
    }

    public DbModelSelector orderBy(String str, boolean z) {
        this.selector.orderBy(str, z);
        return this;
    }

    public DbModelSelector limit(int i) {
        this.selector.limit(i);
        return this;
    }

    public DbModelSelector offset(int i) {
        this.selector.offset(i);
        return this;
    }

    public TableEntity<?> getTable() {
        return this.selector.getTable();
    }

    public DbModel findFirst() {
        TableEntity<?> table = this.selector.getTable();
        if (!table.tableIsExists()) {
            return null;
        }
        limit(1);
        Cursor cursorExecQuery = table.getDb().execQuery(toString());
        if (cursorExecQuery != null) {
            try {
                if (cursorExecQuery.moveToNext()) {
                    return CursorUtils.getDbModel(cursorExecQuery);
                }
            } finally {
            }
        }
        return null;
    }

    public List<DbModel> findAll() {
        TableEntity<?> table = this.selector.getTable();
        ArrayList arrayList = null;
        if (!table.tableIsExists()) {
            return null;
        }
        Cursor cursorExecQuery = table.getDb().execQuery(toString());
        if (cursorExecQuery != null) {
            try {
                arrayList = new ArrayList();
                while (cursorExecQuery.moveToNext()) {
                    arrayList.add(CursorUtils.getDbModel(cursorExecQuery));
                }
            } finally {
            }
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        String[] strArr = this.columnExpressions;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                sb.append(str);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        } else if (!TextUtils.isEmpty(this.groupByColumnName)) {
            sb.append(this.groupByColumnName);
        } else {
            sb.append("*");
        }
        sb.append(" FROM ").append("\"").append(this.selector.getTable().getName()).append("\"");
        WhereBuilder whereBuilder = this.selector.getWhereBuilder();
        if (whereBuilder != null && whereBuilder.getWhereItemSize() > 0) {
            sb.append(" WHERE ").append(whereBuilder.toString());
        }
        if (!TextUtils.isEmpty(this.groupByColumnName)) {
            sb.append(" GROUP BY ").append("\"").append(this.groupByColumnName).append("\"");
            WhereBuilder whereBuilder2 = this.having;
            if (whereBuilder2 != null && whereBuilder2.getWhereItemSize() > 0) {
                sb.append(" HAVING ").append(this.having.toString());
            }
        }
        List<Selector.OrderBy> orderByList = this.selector.getOrderByList();
        if (orderByList != null && orderByList.size() > 0) {
            sb.append(" ORDER BY ");
            Iterator<Selector.OrderBy> it = orderByList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString()).append(StringUtil.COMMA);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if (this.selector.getLimit() > 0) {
            sb.append(" LIMIT ").append(this.selector.getLimit());
            sb.append(" OFFSET ").append(this.selector.getOffset());
        }
        return sb.toString();
    }
}
