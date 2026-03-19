package com.bytedance.framwork.core.de;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.bytedance.framwork.core.de.ha.f;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: LogStoreManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    static boolean a = false;
    static boolean b = false;
    static long c = 5000;
    static final String[] d = {"_id", "data"};
    private static c j = null;
    private static String k = "SELECT count(*) FROM monitor_log WHERE aid = ?";
    private static String l = "SELECT count(*) FROM monitor_log";
    private Context h;
    private SQLiteDatabase i;
    private Map<String, Integer> f = new HashMap(2);
    private int g = 0;
    String e = "INSERT INTO monitor_log(aid,type,type2,time,data) VALUES ( ?, ?, ?, ?, ?)";

    public static c a(Context context) {
        if (j == null) {
            synchronized (a.class) {
                if (j == null) {
                    j = new c(context);
                }
            }
        }
        return j;
    }

    private c(Context context) {
        this.h = context;
        this.i = a.a(context).getWritableDatabase();
    }

    public synchronized void a(String str, List<com.bytedance.framwork.core.de.ef.a> list) {
        SQLiteDatabase sQLiteDatabase;
        if (this.i != null && !f.a(list)) {
            b();
            this.i.beginTransaction();
            try {
                try {
                    SQLiteStatement sQLiteStatementCompileStatement = this.i.compileStatement(this.e);
                    for (com.bytedance.framwork.core.de.ef.a aVar : list) {
                        sQLiteStatementCompileStatement.bindString(1, String.valueOf(aVar.b));
                        sQLiteStatementCompileStatement.bindString(2, aVar.c == null ? "" : aVar.c);
                        sQLiteStatementCompileStatement.bindString(3, aVar.d == null ? "" : aVar.d);
                        sQLiteStatementCompileStatement.bindLong(4, aVar.f);
                        sQLiteStatementCompileStatement.bindString(5, aVar.e == null ? "" : aVar.e);
                        sQLiteStatementCompileStatement.executeInsert();
                    }
                    this.i.setTransactionSuccessful();
                    a(str, list.size());
                    sQLiteDatabase = this.i;
                } catch (Exception e) {
                    e.printStackTrace();
                    sQLiteDatabase = this.i;
                }
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                this.i.endTransaction();
                throw th;
            }
        }
    }

    private void a(String str, int i) {
        if (!this.f.containsKey(str) && i > 0) {
            this.f.put(str, Integer.valueOf(i));
        } else {
            this.f.put(str, Integer.valueOf(Math.max(0, i + this.f.get(str).intValue())));
        }
    }

    public List<com.bytedance.framwork.core.de.ef.a> a(int i, int i2) {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            cursorQuery = this.i.query("monitor_log", d, "aid= ?", new String[]{String.valueOf(i)}, null, null, "_id ASC ", i2 + "");
        } catch (Throwable unused) {
        }
        try {
            if (cursorQuery.getCount() != 0) {
                LinkedList linkedList = new LinkedList();
                while (cursorQuery.moveToNext()) {
                    linkedList.add(new com.bytedance.framwork.core.de.ef.a(cursorQuery.getLong(cursorQuery.getColumnIndex("_id")), cursorQuery.getString(cursorQuery.getColumnIndex("data"))));
                }
                a(cursorQuery);
                return linkedList;
            }
            a(cursorQuery);
            return null;
        } catch (Throwable unused2) {
            cursor = cursorQuery;
            a(cursor);
            return Collections.emptyList();
        }
    }

    public synchronized int a(String str, long j2) {
        if (this.i != null && j2 >= 0) {
            int iDelete = this.i.delete("monitor_log", "aid = ? AND _id<= ? ", new String[]{str, String.valueOf(j2)});
            a(str, iDelete * (-1));
            return iDelete;
        }
        return -1;
    }

    private synchronized int b(String str) {
        SQLiteDatabase sQLiteDatabase = this.i;
        int i = -1;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return -1;
        }
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = this.i.rawQuery(k, new String[]{str});
            if (cursorRawQuery.moveToNext()) {
                i = cursorRawQuery.getInt(0);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            a(cursorRawQuery);
            throw th;
        }
        a(cursorRawQuery);
        return i;
    }

    private synchronized int a() {
        SQLiteDatabase sQLiteDatabase = this.i;
        int i = -1;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return -1;
        }
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = this.i.rawQuery(l, null);
            if (cursorRawQuery.moveToNext()) {
                i = cursorRawQuery.getInt(0);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            a(cursorRawQuery);
            throw th;
        }
        a(cursorRawQuery);
        return i;
    }

    public synchronized int a(String str) {
        int iIntValue;
        if (this.g > 10 || !this.f.containsKey(str)) {
            int iB = b(str);
            this.f.put(str, Integer.valueOf(iB));
            this.g = 0;
            iIntValue = iB;
        } else {
            iIntValue = this.f.get(str).intValue();
            this.g++;
        }
        return iIntValue;
    }

    private synchronized void b() {
        if (!b) {
            b = true;
            if (a() >= c) {
                a(500L);
            }
        }
        if (!a) {
            a = true;
            c();
        }
    }

    public synchronized void a(long j2) {
        if (this.i == null || j2 <= 0) {
            return;
        }
        try {
            this.i.execSQL(" DELETE FROM monitor_log WHERE _id IN (SELECT _id FROM monitor_log ORDER BY _id ASC LIMIT " + j2 + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    private void c() {
        c("psdkmon");
    }

    private void c(String str) {
        try {
            File databasePath = this.h.getDatabasePath(str + ".db");
            if (databasePath.exists()) {
                databasePath.delete();
            }
        } catch (Exception unused) {
        }
    }
}
