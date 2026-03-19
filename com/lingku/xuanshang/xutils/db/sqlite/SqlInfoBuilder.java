package com.lingku.xuanshang.xutils.db.sqlite;

import com.lingku.xuanshang.xutils.common.util.KeyValue;
import com.lingku.xuanshang.xutils.db.table.ColumnEntity;
import com.lingku.xuanshang.xutils.db.table.TableEntity;
import com.lingku.xuanshang.xutils.ex.DbException;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class SqlInfoBuilder {
    public static final ConcurrentHashMap<TableEntity<?>, String> a = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<TableEntity<?>, String> b = new ConcurrentHashMap<>();

    public static SqlInfo buildCreateTableSqlInfo(TableEntity<?> tableEntity) {
        StringBuilder sbAppend;
        String str;
        ColumnEntity id = tableEntity.getId();
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append("\"").append(tableEntity.getName()).append("\"");
        sb.append(" ( ");
        if (id.isAutoId()) {
            sbAppend = sb.append("\"").append(id.getName()).append("\"");
            str = " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        } else {
            sbAppend = sb.append("\"").append(id.getName()).append("\"").append(id.getColumnDbType());
            str = " PRIMARY KEY, ";
        }
        sbAppend.append(str);
        for (ColumnEntity columnEntity : tableEntity.getColumnMap().values()) {
            if (!columnEntity.isId()) {
                sb.append("\"").append(columnEntity.getName()).append("\"");
                sb.append(' ').append(columnEntity.getColumnDbType());
                sb.append(' ').append(columnEntity.getProperty());
                sb.append(StringUtil.COMMA);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" )");
        return new SqlInfo(sb.toString());
    }

    public static SqlInfo buildDeleteSqlInfo(TableEntity<?> tableEntity, WhereBuilder whereBuilder) {
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append("\"").append(tableEntity.getName()).append("\"");
        if (whereBuilder != null && whereBuilder.getWhereItemSize() > 0) {
            sb.append(" WHERE ").append(whereBuilder.toString());
        }
        return new SqlInfo(sb.toString());
    }

    public static SqlInfo buildDeleteSqlInfo(TableEntity<?> tableEntity, Object obj) throws DbException {
        SqlInfo sqlInfo = new SqlInfo();
        ColumnEntity id = tableEntity.getId();
        Object columnValue = id.getColumnValue(obj);
        if (columnValue == null) {
            throw new DbException("this entity[" + tableEntity.getEntityType() + "]'s id value is null");
        }
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append("\"").append(tableEntity.getName()).append("\"");
        sb.append(" WHERE ").append(WhereBuilder.b(id.getName(), "=", columnValue));
        sqlInfo.setSql(sb.toString());
        return sqlInfo;
    }

    public static SqlInfo buildDeleteSqlInfoById(TableEntity<?> tableEntity, Object obj) throws DbException {
        SqlInfo sqlInfo = new SqlInfo();
        ColumnEntity id = tableEntity.getId();
        if (obj == null) {
            throw new DbException("this entity[" + tableEntity.getEntityType() + "]'s id value is null");
        }
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append("\"").append(tableEntity.getName()).append("\"");
        sb.append(" WHERE ").append(WhereBuilder.b(id.getName(), "=", obj));
        sqlInfo.setSql(sb.toString());
        return sqlInfo;
    }

    public static SqlInfo buildInsertSqlInfo(TableEntity<?> tableEntity, Object obj) {
        List<KeyValue> listEntity2KeyValueList = entity2KeyValueList(tableEntity, obj);
        if (listEntity2KeyValueList.size() == 0) {
            return null;
        }
        SqlInfo sqlInfo = new SqlInfo();
        String str = a.get(tableEntity);
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ");
            sb.append("\"").append(tableEntity.getName()).append("\"");
            sb.append(" (");
            Iterator<KeyValue> it = listEntity2KeyValueList.iterator();
            while (it.hasNext()) {
                sb.append("\"").append(it.next().key).append("\"").append(StringUtil.COMMA);
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(") VALUES (");
            int size = listEntity2KeyValueList.size();
            for (int i = 0; i < size; i++) {
                sb.append("?,");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            String string = sb.toString();
            sqlInfo.setSql(string);
            sqlInfo.addBindArgs(listEntity2KeyValueList);
            a.put(tableEntity, string);
        } else {
            sqlInfo.setSql(str);
            sqlInfo.addBindArgs(listEntity2KeyValueList);
        }
        return sqlInfo;
    }

    public static SqlInfo buildReplaceSqlInfo(TableEntity<?> tableEntity, Object obj) {
        List<KeyValue> listEntity2KeyValueList = entity2KeyValueList(tableEntity, obj);
        if (listEntity2KeyValueList.size() == 0) {
            return null;
        }
        SqlInfo sqlInfo = new SqlInfo();
        String str = b.get(tableEntity);
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("REPLACE INTO ");
            sb.append("\"").append(tableEntity.getName()).append("\"");
            sb.append(" (");
            Iterator<KeyValue> it = listEntity2KeyValueList.iterator();
            while (it.hasNext()) {
                sb.append("\"").append(it.next().key).append("\"").append(StringUtil.COMMA);
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(") VALUES (");
            int size = listEntity2KeyValueList.size();
            for (int i = 0; i < size; i++) {
                sb.append("?,");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            String string = sb.toString();
            sqlInfo.setSql(string);
            sqlInfo.addBindArgs(listEntity2KeyValueList);
            b.put(tableEntity, string);
        } else {
            sqlInfo.setSql(str);
            sqlInfo.addBindArgs(listEntity2KeyValueList);
        }
        return sqlInfo;
    }

    public static SqlInfo buildUpdateSqlInfo(TableEntity<?> tableEntity, WhereBuilder whereBuilder, KeyValue... keyValueArr) {
        if (keyValueArr == null || keyValueArr.length == 0) {
            return null;
        }
        SqlInfo sqlInfo = new SqlInfo();
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append("\"").append(tableEntity.getName()).append("\"");
        sb.append(" SET ");
        for (KeyValue keyValue : keyValueArr) {
            sb.append("\"").append(keyValue.key).append("\"").append("=?,");
            sqlInfo.addBindArg(keyValue);
        }
        sb.deleteCharAt(sb.length() - 1);
        if (whereBuilder != null && whereBuilder.getWhereItemSize() > 0) {
            sb.append(" WHERE ").append(whereBuilder.toString());
        }
        sqlInfo.setSql(sb.toString());
        return sqlInfo;
    }

    public static SqlInfo buildUpdateSqlInfo(TableEntity<?> tableEntity, Object obj, String... strArr) {
        List<KeyValue> listEntity2KeyValueList = entity2KeyValueList(tableEntity, obj);
        HashSet hashSet = null;
        if (listEntity2KeyValueList.size() == 0) {
            return null;
        }
        if (strArr != null && strArr.length > 0) {
            hashSet = new HashSet(strArr.length);
            Collections.addAll(hashSet, strArr);
        }
        ColumnEntity id = tableEntity.getId();
        Object columnValue = id.getColumnValue(obj);
        if (columnValue == null) {
            throw new DbException("this entity[" + tableEntity.getEntityType() + "]'s id value is null");
        }
        SqlInfo sqlInfo = new SqlInfo();
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append("\"").append(tableEntity.getName()).append("\"");
        sb.append(" SET ");
        for (KeyValue keyValue : listEntity2KeyValueList) {
            if (hashSet == null || hashSet.contains(keyValue.key)) {
                sb.append("\"").append(keyValue.key).append("\"").append("=?,");
                sqlInfo.addBindArg(keyValue);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" WHERE ").append(WhereBuilder.b(id.getName(), "=", columnValue));
        sqlInfo.setSql(sb.toString());
        return sqlInfo;
    }

    public static List<KeyValue> entity2KeyValueList(TableEntity<?> tableEntity, Object obj) {
        Collection<ColumnEntity> collectionValues = tableEntity.getColumnMap().values();
        ArrayList arrayList = new ArrayList(collectionValues.size());
        for (ColumnEntity columnEntity : collectionValues) {
            KeyValue keyValue = columnEntity.isAutoId() ? null : new KeyValue(columnEntity.getName(), columnEntity.getFieldValue(obj));
            if (keyValue != null) {
                arrayList.add(keyValue);
            }
        }
        return arrayList;
    }
}
