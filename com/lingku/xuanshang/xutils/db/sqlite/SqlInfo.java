package com.lingku.xuanshang.xutils.db.sqlite;

import com.lingku.xuanshang.xutils.common.util.KeyValue;
import com.lingku.xuanshang.xutils.db.table.ColumnUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class SqlInfo {
    public String a;
    public List<KeyValue> b;

    public SqlInfo() {
    }

    public SqlInfo(String str) {
        this.a = str;
    }

    public void addBindArg(KeyValue keyValue) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(keyValue);
    }

    public void addBindArgs(List<KeyValue> list) {
        List<KeyValue> list2 = this.b;
        if (list2 == null) {
            this.b = list;
        } else {
            list2.addAll(list);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.database.sqlite.SQLiteStatement buildStatement(android.database.sqlite.SQLiteDatabase r6) throws android.database.SQLException {
        /*
            r5 = this;
            java.lang.String r0 = r5.a
            android.database.sqlite.SQLiteStatement r6 = r6.compileStatement(r0)
            java.util.List<com.lingku.xuanshang.xutils.common.util.KeyValue> r0 = r5.b
            if (r0 == 0) goto L6c
            r0 = 1
            r1 = r0
        Lc:
            java.util.List<com.lingku.xuanshang.xutils.common.util.KeyValue> r2 = r5.b
            int r2 = r2.size()
            int r2 = r2 + r0
            if (r1 >= r2) goto L6c
            java.util.List<com.lingku.xuanshang.xutils.common.util.KeyValue> r2 = r5.b
            int r3 = r1 + (-1)
            java.lang.Object r2 = r2.get(r3)
            com.lingku.xuanshang.xutils.common.util.KeyValue r2 = (com.lingku.xuanshang.xutils.common.util.KeyValue) r2
            java.lang.Object r3 = r2.value
            if (r3 != 0) goto L24
            goto L44
        L24:
            java.lang.Class r3 = r3.getClass()
            com.lingku.xuanshang.xutils.db.converter.ColumnConverter r3 = com.lingku.xuanshang.xutils.db.converter.ColumnConverterFactory.getColumnConverter(r3)
            java.lang.Object r2 = r2.value
            java.lang.Object r2 = r3.fieldValue2DbValue(r2)
            com.lingku.xuanshang.xutils.db.sqlite.ColumnDbType r3 = r3.getColumnDbType()
            int r3 = r3.ordinal()
            if (r3 == 0) goto L60
            if (r3 == r0) goto L56
            r4 = 2
            if (r3 == r4) goto L4e
            r4 = 3
            if (r3 == r4) goto L48
        L44:
            r6.bindNull(r1)
            goto L69
        L48:
            byte[] r2 = (byte[]) r2
            r6.bindBlob(r1, r2)
            goto L69
        L4e:
            java.lang.String r2 = r2.toString()
            r6.bindString(r1, r2)
            goto L69
        L56:
            java.lang.Number r2 = (java.lang.Number) r2
            double r2 = r2.doubleValue()
            r6.bindDouble(r1, r2)
            goto L69
        L60:
            java.lang.Number r2 = (java.lang.Number) r2
            long r2 = r2.longValue()
            r6.bindLong(r1, r2)
        L69:
            int r1 = r1 + 1
            goto Lc
        L6c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lingku.xuanshang.xutils.db.sqlite.SqlInfo.buildStatement(android.database.sqlite.SQLiteDatabase):android.database.sqlite.SQLiteStatement");
    }

    public Object[] getBindArgs() {
        List<KeyValue> list = this.b;
        if (list == null) {
            return null;
        }
        Object[] objArr = new Object[list.size()];
        for (int i = 0; i < this.b.size(); i++) {
            objArr[i] = ColumnUtils.convert2DbValueIfNeeded(this.b.get(i).value);
        }
        return objArr;
    }

    public String[] getBindArgsAsStrArray() {
        List<KeyValue> list = this.b;
        if (list == null) {
            return null;
        }
        String[] strArr = new String[list.size()];
        for (int i = 0; i < this.b.size(); i++) {
            Object objConvert2DbValueIfNeeded = ColumnUtils.convert2DbValueIfNeeded(this.b.get(i).value);
            strArr[i] = objConvert2DbValueIfNeeded == null ? null : objConvert2DbValueIfNeeded.toString();
        }
        return strArr;
    }

    public String getSql() {
        return this.a;
    }

    public void setSql(String str) {
        this.a = str;
    }
}
