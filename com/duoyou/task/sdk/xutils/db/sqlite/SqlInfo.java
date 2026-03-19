package com.duoyou.task.sdk.xutils.db.sqlite;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.duoyou.task.sdk.xutils.common.util.KeyValue;
import com.duoyou.task.sdk.xutils.db.converter.ColumnConverter;
import com.duoyou.task.sdk.xutils.db.converter.ColumnConverterFactory;
import com.duoyou.task.sdk.xutils.db.table.ColumnUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class SqlInfo {
    private List<KeyValue> bindArgs;
    private String sql;

    public SqlInfo() {
    }

    public SqlInfo(String str) {
        this.sql = str;
    }

    public String getSql() {
        return this.sql;
    }

    public void setSql(String str) {
        this.sql = str;
    }

    public void addBindArg(KeyValue keyValue) {
        if (this.bindArgs == null) {
            this.bindArgs = new ArrayList();
        }
        this.bindArgs.add(keyValue);
    }

    public void addBindArgs(List<KeyValue> list) {
        List<KeyValue> list2 = this.bindArgs;
        if (list2 == null) {
            this.bindArgs = list;
        } else {
            list2.addAll(list);
        }
    }

    public SQLiteStatement buildStatement(SQLiteDatabase sQLiteDatabase) throws SQLException {
        SQLiteStatement sQLiteStatementCompileStatement = sQLiteDatabase.compileStatement(this.sql);
        if (this.bindArgs != null) {
            for (int i = 1; i < this.bindArgs.size() + 1; i++) {
                KeyValue keyValue = this.bindArgs.get(i - 1);
                Object obj = keyValue.value;
                if (obj == null) {
                    sQLiteStatementCompileStatement.bindNull(i);
                } else {
                    ColumnConverter columnConverter = ColumnConverterFactory.getColumnConverter(obj.getClass());
                    Object objFieldValue2DbValue = columnConverter.fieldValue2DbValue(keyValue.value);
                    int iOrdinal = columnConverter.getColumnDbType().ordinal();
                    if (iOrdinal == 0) {
                        sQLiteStatementCompileStatement.bindLong(i, ((Number) objFieldValue2DbValue).longValue());
                    } else if (iOrdinal == 1) {
                        sQLiteStatementCompileStatement.bindDouble(i, ((Number) objFieldValue2DbValue).doubleValue());
                    } else if (iOrdinal == 2) {
                        sQLiteStatementCompileStatement.bindString(i, objFieldValue2DbValue.toString());
                    } else if (iOrdinal == 3) {
                        sQLiteStatementCompileStatement.bindBlob(i, (byte[]) objFieldValue2DbValue);
                    } else {
                        sQLiteStatementCompileStatement.bindNull(i);
                    }
                }
            }
        }
        return sQLiteStatementCompileStatement;
    }

    /* renamed from: com.duoyou.task.sdk.xutils.db.sqlite.SqlInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$duoyou$task$sdk$xutils$db$sqlite$ColumnDbType;

        static {
            ColumnDbType.values();
            int[] iArr = new int[4];
            $SwitchMap$com$duoyou$task$sdk$xutils$db$sqlite$ColumnDbType = iArr;
            try {
                ColumnDbType columnDbType = ColumnDbType.INTEGER;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$duoyou$task$sdk$xutils$db$sqlite$ColumnDbType;
                ColumnDbType columnDbType2 = ColumnDbType.REAL;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$com$duoyou$task$sdk$xutils$db$sqlite$ColumnDbType;
                ColumnDbType columnDbType3 = ColumnDbType.TEXT;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$duoyou$task$sdk$xutils$db$sqlite$ColumnDbType;
                ColumnDbType columnDbType4 = ColumnDbType.BLOB;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public Object[] getBindArgs() {
        List<KeyValue> list = this.bindArgs;
        if (list == null) {
            return null;
        }
        Object[] objArr = new Object[list.size()];
        for (int i = 0; i < this.bindArgs.size(); i++) {
            objArr[i] = ColumnUtils.convert2DbValueIfNeeded(this.bindArgs.get(i).value);
        }
        return objArr;
    }

    public String[] getBindArgsAsStrArray() {
        List<KeyValue> list = this.bindArgs;
        if (list == null) {
            return null;
        }
        String[] strArr = new String[list.size()];
        for (int i = 0; i < this.bindArgs.size(); i++) {
            Object objConvert2DbValueIfNeeded = ColumnUtils.convert2DbValueIfNeeded(this.bindArgs.get(i).value);
            strArr[i] = objConvert2DbValueIfNeeded == null ? null : objConvert2DbValueIfNeeded.toString();
        }
        return strArr;
    }
}
