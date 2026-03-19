package com.lingku.xuanshang.xutils.db;

import android.database.Cursor;
import com.lingku.xuanshang.xutils.db.sqlite.WhereBuilder;
import com.lingku.xuanshang.xutils.db.table.DbModel;
import com.lingku.xuanshang.xutils.db.table.TableEntity;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lkxssdk.l0.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Selector<T> {
    public final TableEntity<T> a;
    public WhereBuilder b;
    public List<OrderBy> c;
    public int d = 0;
    public int e = 0;

    public static class OrderBy {
        public String a;
        public boolean b;

        public OrderBy(String str) {
            this.a = str;
        }

        public OrderBy(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public String toString() {
            return "\"" + this.a + "\"" + (this.b ? " DESC" : " ASC");
        }
    }

    public Selector(TableEntity<T> tableEntity) {
        this.a = tableEntity;
    }

    public Selector<T> and(WhereBuilder whereBuilder) {
        this.b.and(whereBuilder);
        return this;
    }

    public Selector<T> and(String str, String str2, Object obj) {
        this.b.and(str, str2, obj);
        return this;
    }

    public long count() {
        DbModel dbModelFindFirst;
        if (this.a.tableIsExists() && (dbModelFindFirst = select("count(\"" + this.a.getId().getName() + "\") as count").findFirst()) != null) {
            return dbModelFindFirst.getLong("count", 0L);
        }
        return 0L;
    }

    public Selector<T> expr(String str) {
        if (this.b == null) {
            this.b = WhereBuilder.b();
        }
        this.b.expr(str);
        return this;
    }

    public List<T> findAll() {
        ArrayList arrayList = null;
        if (!this.a.tableIsExists()) {
            return null;
        }
        Cursor cursorExecQuery = this.a.getDb().execQuery(toString());
        if (cursorExecQuery != null) {
            try {
                arrayList = new ArrayList();
                while (cursorExecQuery.moveToNext()) {
                    arrayList.add(a.a(this.a, cursorExecQuery));
                }
            } finally {
            }
        }
        return arrayList;
    }

    public T findFirst() {
        if (!this.a.tableIsExists()) {
            return null;
        }
        limit(1);
        Cursor cursorExecQuery = this.a.getDb().execQuery(toString());
        if (cursorExecQuery != null) {
            try {
                if (cursorExecQuery.moveToNext()) {
                    return (T) a.a(this.a, cursorExecQuery);
                }
            } finally {
            }
        }
        return null;
    }

    public int getLimit() {
        return this.d;
    }

    public int getOffset() {
        return this.e;
    }

    public List<OrderBy> getOrderByList() {
        return this.c;
    }

    public TableEntity<T> getTable() {
        return this.a;
    }

    public WhereBuilder getWhereBuilder() {
        return this.b;
    }

    public DbModelSelector groupBy(String str) {
        return new DbModelSelector((Selector<?>) this, str);
    }

    public Selector<T> limit(int i) {
        this.d = i;
        return this;
    }

    public Selector<T> offset(int i) {
        this.e = i;
        return this;
    }

    public Selector<T> or(WhereBuilder whereBuilder) {
        this.b.or(whereBuilder);
        return this;
    }

    public Selector<T> or(String str, String str2, Object obj) {
        this.b.or(str, str2, obj);
        return this;
    }

    public Selector<T> orderBy(String str) {
        if (this.c == null) {
            this.c = new ArrayList(5);
        }
        this.c.add(new OrderBy(str));
        return this;
    }

    public Selector<T> orderBy(String str, boolean z) {
        if (this.c == null) {
            this.c = new ArrayList(5);
        }
        this.c.add(new OrderBy(str, z));
        return this;
    }

    public DbModelSelector select(String... strArr) {
        return new DbModelSelector((Selector<?>) this, strArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("*");
        sb.append(" FROM ").append("\"").append(this.a.getName()).append("\"");
        WhereBuilder whereBuilder = this.b;
        if (whereBuilder != null && whereBuilder.getWhereItemSize() > 0) {
            sb.append(" WHERE ").append(this.b.toString());
        }
        List<OrderBy> list = this.c;
        if (list != null && list.size() > 0) {
            sb.append(" ORDER BY ");
            Iterator<OrderBy> it = this.c.iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString()).append(StringUtil.COMMA);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if (this.d > 0) {
            sb.append(" LIMIT ").append(this.d);
            sb.append(" OFFSET ").append(this.e);
        }
        return sb.toString();
    }

    public Selector<T> where(WhereBuilder whereBuilder) {
        this.b = whereBuilder;
        return this;
    }

    public Selector<T> where(String str, String str2, Object obj) {
        this.b = WhereBuilder.b(str, str2, obj);
        return this;
    }
}
