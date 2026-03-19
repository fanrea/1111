package com.lingku.xuanshang.xutils.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.lingku.xuanshang.xutils.db.Selector;
import com.lingku.xuanshang.xutils.db.sqlite.WhereBuilder;
import com.lingku.xuanshang.xutils.db.table.DbModel;
import com.lingku.xuanshang.xutils.db.table.TableEntity;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lkxssdk.l0.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class DbModelSelector {
    public String[] a;
    public String b;
    public WhereBuilder c;
    public Selector<?> d;

    public DbModelSelector(Selector<?> selector, String str) {
        this.d = selector;
        this.b = str;
    }

    public DbModelSelector(Selector<?> selector, String[] strArr) {
        this.d = selector;
        this.a = strArr;
    }

    public DbModelSelector and(WhereBuilder whereBuilder) {
        this.d.and(whereBuilder);
        return this;
    }

    public DbModelSelector and(String str, String str2, Object obj) {
        this.d.and(str, str2, obj);
        return this;
    }

    public DbModelSelector expr(String str) {
        this.d.expr(str);
        return this;
    }

    public List<DbModel> findAll() {
        TableEntity<?> table = this.d.getTable();
        ArrayList arrayList = null;
        if (!table.tableIsExists()) {
            return null;
        }
        Cursor cursorExecQuery = table.getDb().execQuery(toString());
        if (cursorExecQuery != null) {
            try {
                arrayList = new ArrayList();
                while (cursorExecQuery.moveToNext()) {
                    arrayList.add(a.a(cursorExecQuery));
                }
            } finally {
            }
        }
        return arrayList;
    }

    public DbModel findFirst() {
        TableEntity<?> table = this.d.getTable();
        if (!table.tableIsExists()) {
            return null;
        }
        limit(1);
        Cursor cursorExecQuery = table.getDb().execQuery(toString());
        if (cursorExecQuery != null) {
            try {
                if (cursorExecQuery.moveToNext()) {
                    return a.a(cursorExecQuery);
                }
            } finally {
            }
        }
        return null;
    }

    public TableEntity<?> getTable() {
        return this.d.getTable();
    }

    public DbModelSelector groupBy(String str) {
        this.b = str;
        return this;
    }

    public DbModelSelector having(WhereBuilder whereBuilder) {
        this.c = whereBuilder;
        return this;
    }

    public DbModelSelector limit(int i) {
        this.d.limit(i);
        return this;
    }

    public DbModelSelector offset(int i) {
        this.d.offset(i);
        return this;
    }

    public DbModelSelector or(WhereBuilder whereBuilder) {
        this.d.or(whereBuilder);
        return this;
    }

    public DbModelSelector or(String str, String str2, Object obj) {
        this.d.or(str, str2, obj);
        return this;
    }

    public DbModelSelector orderBy(String str) {
        this.d.orderBy(str);
        return this;
    }

    public DbModelSelector orderBy(String str, boolean z) {
        this.d.orderBy(str, z);
        return this;
    }

    public DbModelSelector select(String... strArr) {
        this.a = strArr;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        String[] strArr = this.a;
        if (strArr == null || strArr.length <= 0) {
            sb.append(!TextUtils.isEmpty(this.b) ? this.b : "*");
        } else {
            for (String str : strArr) {
                sb.append(str);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(" FROM ").append("\"").append(this.d.getTable().getName()).append("\"");
        WhereBuilder whereBuilder = this.d.getWhereBuilder();
        if (whereBuilder != null && whereBuilder.getWhereItemSize() > 0) {
            sb.append(" WHERE ").append(whereBuilder.toString());
        }
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" GROUP BY ").append("\"").append(this.b).append("\"");
            WhereBuilder whereBuilder2 = this.c;
            if (whereBuilder2 != null && whereBuilder2.getWhereItemSize() > 0) {
                sb.append(" HAVING ").append(this.c.toString());
            }
        }
        List<Selector.OrderBy> orderByList = this.d.getOrderByList();
        if (orderByList != null && orderByList.size() > 0) {
            sb.append(" ORDER BY ");
            Iterator<Selector.OrderBy> it = orderByList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString()).append(StringUtil.COMMA);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if (this.d.getLimit() > 0) {
            sb.append(" LIMIT ").append(this.d.getLimit());
            sb.append(" OFFSET ").append(this.d.getOffset());
        }
        return sb.toString();
    }

    public DbModelSelector where(WhereBuilder whereBuilder) {
        this.d.where(whereBuilder);
        return this;
    }

    public DbModelSelector where(String str, String str2, Object obj) {
        this.d.where(str, str2, obj);
        return this;
    }
}
