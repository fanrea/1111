package com.duoyou.task.sdk.xutils.db.sqlite;

import android.text.TextUtils;
import com.duoyou.task.sdk.xutils.db.table.ColumnUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class WhereBuilder {
    private final List<String> whereItems = new ArrayList();

    private WhereBuilder() {
    }

    public static WhereBuilder b() {
        return new WhereBuilder();
    }

    public static WhereBuilder b(String str, String str2, Object obj) {
        WhereBuilder whereBuilder = new WhereBuilder();
        whereBuilder.appendCondition(null, str, str2, obj);
        return whereBuilder;
    }

    public WhereBuilder and(String str, String str2, Object obj) {
        appendCondition(this.whereItems.size() == 0 ? null : "AND", str, str2, obj);
        return this;
    }

    public WhereBuilder and(WhereBuilder whereBuilder) {
        return expr((this.whereItems.size() == 0 ? " " : "AND ") + "(" + whereBuilder.toString() + ")");
    }

    public WhereBuilder or(String str, String str2, Object obj) {
        appendCondition(this.whereItems.size() == 0 ? null : "OR", str, str2, obj);
        return this;
    }

    public WhereBuilder or(WhereBuilder whereBuilder) {
        return expr((this.whereItems.size() == 0 ? " " : "OR ") + "(" + whereBuilder.toString() + ")");
    }

    public WhereBuilder expr(String str) {
        this.whereItems.add(" " + str);
        return this;
    }

    public int getWhereItemSize() {
        return this.whereItems.size();
    }

    public String toString() {
        if (this.whereItems.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.whereItems.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Iterable] */
    private void appendCondition(String str, String str2, String str3, Object obj) {
        StringBuilder sb = new StringBuilder();
        if (this.whereItems.size() > 0) {
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str).append(" ");
        }
        sb.append("\"").append(str2).append("\"");
        if ("!=".equals(str3)) {
            str3 = "<>";
        } else if ("==".equals(str3)) {
            str3 = "=";
        }
        if (obj == null) {
            if ("=".equals(str3)) {
                sb.append(" IS NULL");
            } else if ("<>".equals(str3)) {
                sb.append(" IS NOT NULL");
            } else {
                sb.append(" ").append(str3).append(" NULL");
            }
        } else {
            sb.append(" ").append(str3).append(" ");
            int i = 0;
            ?? arrayList = 0;
            ?? arrayList2 = 0;
            if ("IN".equalsIgnoreCase(str3)) {
                if (obj instanceof Iterable) {
                    arrayList2 = (Iterable) obj;
                } else if (obj.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    arrayList2 = new ArrayList(length);
                    while (i < length) {
                        arrayList2.add(Array.get(obj, i));
                        i++;
                    }
                }
                if (arrayList2 != 0) {
                    StringBuilder sb2 = new StringBuilder("(");
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        Object objConvert2DbValueIfNeeded = ColumnUtils.convert2DbValueIfNeeded(it.next());
                        if (ColumnUtils.isTextColumnDbType(objConvert2DbValueIfNeeded)) {
                            sb2.append("'").append(ColumnUtils.convert2SafeExpr(objConvert2DbValueIfNeeded)).append("'");
                        } else {
                            sb2.append(objConvert2DbValueIfNeeded);
                        }
                        sb2.append(",");
                    }
                    if (sb2.length() > 1) {
                        sb2.deleteCharAt(sb2.length() - 1);
                    }
                    sb2.append(")");
                    sb.append(sb2.toString());
                } else {
                    throw new IllegalArgumentException("value must be an Array or an Iterable.");
                }
            } else if ("BETWEEN".equalsIgnoreCase(str3)) {
                if (obj instanceof Iterable) {
                    arrayList = (Iterable) obj;
                } else if (obj.getClass().isArray()) {
                    int length2 = Array.getLength(obj);
                    arrayList = new ArrayList(length2);
                    while (i < length2) {
                        arrayList.add(Array.get(obj, i));
                        i++;
                    }
                }
                if (arrayList != 0) {
                    Iterator it2 = arrayList.iterator();
                    if (!it2.hasNext()) {
                        throw new IllegalArgumentException("value must contains tow items.");
                    }
                    Object next = it2.next();
                    if (!it2.hasNext()) {
                        throw new IllegalArgumentException("value must contains tow items.");
                    }
                    Object next2 = it2.next();
                    Object objConvert2DbValueIfNeeded2 = ColumnUtils.convert2DbValueIfNeeded(next);
                    Object objConvert2DbValueIfNeeded3 = ColumnUtils.convert2DbValueIfNeeded(next2);
                    if (ColumnUtils.isTextColumnDbType(objConvert2DbValueIfNeeded2)) {
                        String strConvert2SafeExpr = ColumnUtils.convert2SafeExpr(objConvert2DbValueIfNeeded2);
                        String strConvert2SafeExpr2 = ColumnUtils.convert2SafeExpr(objConvert2DbValueIfNeeded3);
                        sb.append("'").append(strConvert2SafeExpr).append("'");
                        sb.append(" AND ");
                        sb.append("'").append(strConvert2SafeExpr2).append("'");
                    } else {
                        sb.append(objConvert2DbValueIfNeeded2);
                        sb.append(" AND ");
                        sb.append(objConvert2DbValueIfNeeded3);
                    }
                } else {
                    throw new IllegalArgumentException("value must be an Array or an Iterable.");
                }
            } else {
                Object objConvert2DbValueIfNeeded4 = ColumnUtils.convert2DbValueIfNeeded(obj);
                if (ColumnUtils.isTextColumnDbType(objConvert2DbValueIfNeeded4)) {
                    sb.append("'").append(ColumnUtils.convert2SafeExpr(objConvert2DbValueIfNeeded4)).append("'");
                } else {
                    sb.append(objConvert2DbValueIfNeeded4);
                }
            }
        }
        this.whereItems.add(sb.toString());
    }
}
