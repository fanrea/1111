package androidx.room.util;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CursorUtil.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a#\u0010\u0003\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a)\u0010\r\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010\u001a/\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u0012*\u00020\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u00120\u0014H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"copyAndClose", "Landroid/database/Cursor;", "c", "findColumnIndexBySuffix", "", "cursor", "name", "", "columnNames", "", "([Ljava/lang/String;Ljava/lang/String;)I", "getColumnIndex", "getColumnIndexOrThrow", "wrapMappedColumns", "mapping", "", "(Landroid/database/Cursor;[Ljava/lang/String;[I)Landroid/database/Cursor;", "useCursor", "R", "block", "Lkotlin/Function1;", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "room-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class CursorUtil {
    public static final int getColumnIndex(Cursor cursor, String str) {
        Intrinsics.checkNotNullParameter(cursor, "c");
        Intrinsics.checkNotNullParameter(str, "name");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex('`' + str + '`');
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(cursor, str);
    }

    public static final int getColumnIndexOrThrow(Cursor cursor, String str) {
        String strJoinToString$default;
        Intrinsics.checkNotNullParameter(cursor, "c");
        Intrinsics.checkNotNullParameter(str, "name");
        int columnIndex = getColumnIndex(cursor, str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            Intrinsics.checkNotNullExpressionValue(columnNames, "c.columnNames");
            strJoinToString$default = ArraysKt.joinToString$default(columnNames, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        } catch (Exception e) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
            strJoinToString$default = "unknown";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + strJoinToString$default);
    }

    private static final int findColumnIndexBySuffix(Cursor cursor, String str) {
        if (Build.VERSION.SDK_INT > 25) {
            return -1;
        }
        if (str.length() == 0) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        Intrinsics.checkNotNullExpressionValue(columnNames, "columnNames");
        return findColumnIndexBySuffix(columnNames, str);
    }

    public static final int findColumnIndexBySuffix(String[] strArr, String str) {
        Intrinsics.checkNotNullParameter(strArr, "columnNames");
        Intrinsics.checkNotNullParameter(str, "name");
        String str2 = '.' + str;
        String str3 = '.' + str + '`';
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str4 = strArr[i];
            int i3 = i2 + 1;
            if (str4.length() >= str.length() + 2) {
                if (StringsKt.endsWith$default(str4, str2, false, 2, (Object) null)) {
                    return i2;
                }
                if (str4.charAt(0) == '`' && StringsKt.endsWith$default(str4, str3, false, 2, (Object) null)) {
                    return i2;
                }
            }
            i++;
            i2 = i3;
        }
        return -1;
    }

    public static final <R> R useCursor(Cursor cursor, Function1<? super Cursor, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (Build.VERSION.SDK_INT > 15) {
            Cursor cursor2 = cursor;
            try {
                R r = (R) function1.invoke(cursor2);
                InlineMarker.finallyStart(1);
                CloseableKt.closeFinally(cursor2, (Throwable) null);
                InlineMarker.finallyEnd(1);
                return r;
            } finally {
            }
        } else {
            try {
                return (R) function1.invoke(cursor);
            } finally {
                InlineMarker.finallyStart(1);
                cursor.close();
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public static final Cursor wrapMappedColumns(Cursor cursor, final String[] strArr, final int[] iArr) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(strArr, "columnNames");
        Intrinsics.checkNotNullParameter(iArr, "mapping");
        if (!(strArr.length == iArr.length)) {
            throw new IllegalStateException("Expected columnNames.length == mapping.length".toString());
        }
        return new CursorWrapper(cursor) { // from class: androidx.room.util.CursorUtil.wrapMappedColumns.2
            @Override // android.database.CursorWrapper, android.database.Cursor
            public int getColumnIndex(String columnName) {
                Intrinsics.checkNotNullParameter(columnName, "columnName");
                String[] strArr2 = strArr;
                int[] iArr2 = iArr;
                int length = strArr2.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    int i3 = i2 + 1;
                    if (StringsKt.equals(strArr2[i], columnName, true)) {
                        return iArr2[i2];
                    }
                    i++;
                    i2 = i3;
                }
                return super.getColumnIndex(columnName);
            }
        };
    }

    public static final Cursor copyAndClose(Cursor cursor) {
        MatrixCursor matrixCursor;
        Intrinsics.checkNotNullParameter(cursor, "c");
        if (Build.VERSION.SDK_INT <= 15) {
            try {
                matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
                while (cursor.moveToNext()) {
                    Object[] objArr = new Object[cursor.getColumnCount()];
                    int columnCount = cursor.getColumnCount();
                    for (int i = 0; i < columnCount; i++) {
                        int type = cursor.getType(i);
                        if (type == 0) {
                            objArr[i] = null;
                        } else if (type == 1) {
                            objArr[i] = Long.valueOf(cursor.getLong(i));
                        } else if (type == 2) {
                            objArr[i] = Double.valueOf(cursor.getDouble(i));
                        } else if (type == 3) {
                            objArr[i] = cursor.getString(i);
                        } else if (type == 4) {
                            objArr[i] = cursor.getBlob(i);
                        } else {
                            throw new IllegalStateException();
                        }
                    }
                    matrixCursor.addRow(objArr);
                }
            } finally {
                cursor.close();
            }
        } else {
            Cursor cursor2 = cursor;
            try {
                Cursor cursor3 = cursor2;
                matrixCursor = new MatrixCursor(cursor3.getColumnNames(), cursor3.getCount());
                while (cursor3.moveToNext()) {
                    Object[] objArr2 = new Object[cursor3.getColumnCount()];
                    int columnCount2 = cursor.getColumnCount();
                    for (int i2 = 0; i2 < columnCount2; i2++) {
                        int type2 = cursor3.getType(i2);
                        if (type2 == 0) {
                            objArr2[i2] = null;
                        } else if (type2 == 1) {
                            objArr2[i2] = Long.valueOf(cursor3.getLong(i2));
                        } else if (type2 == 2) {
                            objArr2[i2] = Double.valueOf(cursor3.getDouble(i2));
                        } else if (type2 == 3) {
                            objArr2[i2] = cursor3.getString(i2);
                        } else if (type2 == 4) {
                            objArr2[i2] = cursor3.getBlob(i2);
                        } else {
                            throw new IllegalStateException();
                        }
                    }
                    matrixCursor.addRow(objArr2);
                }
                CloseableKt.closeFinally(cursor2, (Throwable) null);
            } finally {
            }
        }
        return matrixCursor;
    }
}
