package com.bytedance.framwork.core.ef;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

/* compiled from: LogQueueManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class e {
    static final String[] a = {"_id", com.alipay.sdk.m.p0.b.d, "type", com.alipay.sdk.m.t.a.k, "retry_count", "retry_time"};
    private static e b;
    private SQLiteDatabase c;

    static e a(Context context) {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e(context);
                }
            }
        }
        return b;
    }

    private e(Context context) {
        if (context == null) {
            return;
        }
        try {
            this.c = com.bytedance.framwork.core.de.a.a(context).getWritableDatabase();
        } catch (Throwable unused) {
        }
    }

    synchronized boolean a() {
        SQLiteDatabase sQLiteDatabase = this.c;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            return true;
        }
        d.a("db not establish and open");
        return false;
    }

    synchronized long a(String str) {
        long j = 0;
        if (!a()) {
            return 0L;
        }
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = this.c.rawQuery(TextUtils.isEmpty(str) ? "select count(*) from queue" : "select count(*) from queue " + str, null);
            if (cursorRawQuery.moveToNext()) {
                j = cursorRawQuery.getLong(0);
            }
        } catch (Throwable unused) {
        }
        a(cursorRawQuery);
        return j;
    }

    synchronized long a(String str, byte[] bArr) {
        if (a() && bArr != null && bArr.length > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(com.alipay.sdk.m.p0.b.d, bArr);
            contentValues.put("type", str);
            contentValues.put(com.alipay.sdk.m.t.a.k, Long.valueOf(System.currentTimeMillis()));
            contentValues.put("retry_count", (Integer) 0);
            contentValues.put("retry_time", (Long) 0L);
            return this.c.insert("queue", null, contentValues);
        }
        return -1L;
    }

    synchronized void b() {
        if (a()) {
            try {
                this.c.execSQL("DROP TABLE IF EXISTS queue");
                this.c.execSQL("CREATE TABLE queue ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value BLOB, type TEXT, timestamp INTEGER, retry_count INTEGER, retry_time INTEGER )");
            } catch (Exception e) {
                d.a("recreateTableQueue db exception " + e);
            }
        }
    }

    synchronized void a(String str, int i, long j) {
        String str2;
        String[] strArr;
        if (a()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - j;
            if (TextUtils.isEmpty(str)) {
                str2 = "timestamp <= ? ";
                strArr = new String[]{String.valueOf(jCurrentTimeMillis)};
            } else {
                String str3 = "(timestamp <= ? OR retry_count > " + i + ") and type = ?";
                String[] strArr2 = {String.valueOf(jCurrentTimeMillis), str};
                str2 = str3;
                strArr = strArr2;
            }
            try {
                this.c.delete("queue", str2, strArr);
            } catch (Exception e) {
                d.a("delete expire log error:" + e);
            }
        }
    }

    synchronized b a(long j) {
        b bVar;
        Cursor cursorQuery;
        Cursor cursor = null;
        b bVar2 = null;
        cursor = null;
        if (!a()) {
            return null;
        }
        try {
            try {
                cursorQuery = this.c.query("queue", a, "_id > ?", new String[]{String.valueOf(j)}, null, null, "_id ASC", "1");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
            bVar = null;
        }
        try {
            try {
                if (cursorQuery.moveToNext()) {
                    bVar = new b();
                    try {
                        bVar.a = cursorQuery.getLong(0);
                        bVar.b = cursorQuery.getBlob(1);
                        bVar.f = cursorQuery.getString(2);
                        bVar.c = cursorQuery.getLong(3);
                        bVar.d = cursorQuery.getInt(4);
                        bVar.e = cursorQuery.getLong(5);
                        bVar2 = bVar;
                    } catch (Exception e2) {
                        e = e2;
                        cursor = cursorQuery;
                        d.a("getLog exception " + e);
                        a(cursor);
                        bVar2 = bVar;
                        return bVar2;
                    }
                }
                a(cursorQuery);
            } catch (Exception e3) {
                e = e3;
                bVar = null;
            }
            return bVar2;
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorQuery;
            a(cursor);
            throw th;
        }
    }

    synchronized boolean a(long j, boolean z, long j2, int i) {
        if (a() && j > 0) {
            boolean z2 = true;
            String[] strArr = {String.valueOf(j)};
            if (!z) {
                Cursor cursorQuery = null;
                try {
                    try {
                        cursorQuery = this.c.query("queue", new String[]{com.alipay.sdk.m.t.a.k, "retry_count"}, "_id = ?", strArr, null, null, null);
                        if (!cursorQuery.moveToNext()) {
                            return false;
                        }
                        long j3 = cursorQuery.getLong(0);
                        int i2 = cursorQuery.getInt(1);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (jCurrentTimeMillis - j3 < j2 && i2 < i) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("retry_count", Integer.valueOf(i2 + 1));
                            contentValues.put("retry_time", Long.valueOf(jCurrentTimeMillis));
                            this.c.update("queue", contentValues, "_id = ?", strArr);
                            return true;
                        }
                    } catch (Exception e) {
                        d.a("onLogSent exception: " + e);
                        a(cursorQuery);
                        z2 = false;
                    }
                } finally {
                    a(cursorQuery);
                }
            }
            if (!z2) {
                return false;
            }
            try {
                this.c.delete("queue", "_id = ?", strArr);
            } catch (Throwable unused) {
            }
            d.a("delete app_log: " + j);
            return false;
        }
        return false;
    }

    static void a(Cursor cursor) {
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
}
