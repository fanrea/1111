package com.sigmob.sdk.downloader.core.breakpoint;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e extends SQLiteOpenHelper {
    static final String a = "taskFileDirty";
    private static final String b = "sig_breakpoint.db";
    private static final int c = 3;
    private static final String d = "FileDownloadResponseFilename";
    private static final String e = "breakpoint";
    private static final String f = "block";

    private interface a {
        public static final String a = "CREATE TABLE IF NOT EXISTS breakpoint( id INTEGER PRIMARY KEY, url VARCHAR NOT NULL, etag VARCHAR, parent_path VARCHAR NOT NULL, filename VARCHAR, task_only_parent_path TINYINT(1) DEFAULT 0, chunked TINYINT(1) DEFAULT 0)";
        public static final String b = "CREATE TABLE IF NOT EXISTS block( id INTEGER PRIMARY KEY AUTOINCREMENT, breakpoint_id INTEGER, block_index INTEGER, start_offset INTEGER, content_length INTEGER, current_offset INTEGER)";
        public static final String c = "CREATE TABLE IF NOT EXISTS FileDownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)";
        public static final String d = "CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)";
    }

    private interface b {
        public static final String a = "CREATE TABLE IF NOT EXISTS FileDownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)";
        public static final String b = "CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)";
    }

    private interface c {
        public static final String a = "SELECT * FROM taskFileDirty";
        public static final String b = "SELECT * FROM breakpoint";
        public static final String c = "SELECT * FROM block";
        public static final String d = "SELECT * FROM FileDownloadResponseFilename";
        public static final String e = "SELECT filename FROM FileDownloadResponseFilename WHERE url = ?";
        public static final String f = "SELECT id FROM breakpoint WHERE id = ? LIMIT 1";
    }

    public e(Context context) {
        super(context, b, (SQLiteDatabase.CursorFactory) null, 3);
    }

    private static ContentValues a(int breakpointId, int index, com.sigmob.sdk.downloader.core.breakpoint.a info) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("breakpoint_id", Integer.valueOf(breakpointId));
        contentValues.put("block_index", Integer.valueOf(index));
        contentValues.put("start_offset", Long.valueOf(info.b()));
        contentValues.put("content_length", Long.valueOf(info.d()));
        contentValues.put("current_offset", Long.valueOf(info.a()));
        return contentValues;
    }

    private static ContentValues c(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(cVar.a));
        contentValues.put("url", cVar.l());
        contentValues.put("etag", cVar.k());
        contentValues.put("parent_path", cVar.b.getAbsolutePath());
        contentValues.put("filename", cVar.m());
        contentValues.put("task_only_parent_path", Integer.valueOf(cVar.d() ? 1 : 0));
        contentValues.put("chunked", Integer.valueOf(cVar.b() ? 1 : 0));
        return contentValues;
    }

    public List<Integer> a() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = getWritableDatabase().rawQuery(c.a, null);
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("id"))));
            }
            return arrayList;
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    public void a(int id) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("id", Integer.valueOf(id));
        writableDatabase.insert(a, null, contentValues);
    }

    public void a(com.sigmob.sdk.downloader.core.breakpoint.c info) throws IOException {
        int iG = info.g();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        for (int i = 0; i < iG; i++) {
            com.sigmob.sdk.downloader.core.breakpoint.a aVarB = info.b(i);
            if (writableDatabase.insert(f, null, a(info.a, i, aVarB)) == -1) {
                throw new com.sigmob.sdk.downloader.core.exception.h("insert block " + aVarB + " failed!");
            }
        }
        if (writableDatabase.insert(e, null, c(info)) == -1) {
            throw new com.sigmob.sdk.downloader.core.exception.h("insert info " + info + " failed!");
        }
    }

    public void a(com.sigmob.sdk.downloader.core.breakpoint.c info, int blockIndex, long newCurrentOffset) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("current_offset", Long.valueOf(newCurrentOffset));
        getWritableDatabase().update(f, contentValues, "breakpoint_id = ? AND block_index = ?", new String[]{Integer.toString(info.a), Integer.toString(blockIndex)});
    }

    public void a(String url, String filename) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("url", url);
        contentValues.put("filename", filename);
        synchronized (url.intern()) {
            Cursor cursor = null;
            try {
                Cursor cursorRawQuery = writableDatabase.rawQuery(c.e, new String[]{url});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        writableDatabase.insert(d, null, contentValues);
                    } else if (!filename.equals(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("filename")))) {
                        writableDatabase.replace(d, null, contentValues);
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public SparseArray<com.sigmob.sdk.downloader.core.breakpoint.c> b() throws Throwable {
        Cursor cursor;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            Cursor cursorRawQuery2 = writableDatabase.rawQuery(c.b, null);
            while (cursorRawQuery2.moveToNext()) {
                try {
                    arrayList.add(new d(cursorRawQuery2));
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    cursorRawQuery = cursorRawQuery2;
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            cursorRawQuery = writableDatabase.rawQuery(c.c, null);
            while (cursorRawQuery.moveToNext()) {
                arrayList2.add(new com.sigmob.sdk.downloader.core.breakpoint.b(cursorRawQuery));
            }
            if (cursorRawQuery2 != null) {
                cursorRawQuery2.close();
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            SparseArray<com.sigmob.sdk.downloader.core.breakpoint.c> sparseArray = new SparseArray<>();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.sigmob.sdk.downloader.core.breakpoint.c cVarH = ((d) it.next()).h();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    com.sigmob.sdk.downloader.core.breakpoint.b bVar = (com.sigmob.sdk.downloader.core.breakpoint.b) it2.next();
                    if (bVar.a() == cVarH.a) {
                        cVarH.a(bVar.e());
                        it2.remove();
                    }
                }
                sparseArray.put(cVarH.a, cVarH);
            }
            return sparseArray;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public void b(int id) {
        getWritableDatabase().delete(a, "id = ?", new String[]{String.valueOf(id)});
    }

    public void b(com.sigmob.sdk.downloader.core.breakpoint.c info) throws IOException {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = getWritableDatabase().rawQuery(c.f, new String[]{Integer.toString(info.a)});
            if (cursorRawQuery.moveToNext()) {
                c(info.a);
                a(info);
                writableDatabase.setTransactionSuccessful();
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                writableDatabase.endTransaction();
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            writableDatabase.endTransaction();
        }
    }

    public HashMap<String, String> c() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        HashMap<String, String> map = new HashMap<>();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = writableDatabase.rawQuery(c.d, null);
            while (cursorRawQuery.moveToNext()) {
                int columnIndex = cursorRawQuery.getColumnIndex("url");
                String string = "";
                String string2 = columnIndex >= 0 ? cursorRawQuery.getString(columnIndex) : "";
                int columnIndex2 = cursorRawQuery.getColumnIndex("filename");
                if (columnIndex2 >= 0) {
                    string = cursorRawQuery.getString(columnIndex2);
                }
                map.put(string2, string);
            }
            return map;
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    public void c(int id) {
        getWritableDatabase().delete(e, "id = ?", new String[]{String.valueOf(id)});
        d(id);
    }

    public void d(int breakpointId) {
        getWritableDatabase().delete(f, "breakpoint_id = ?", new String[]{String.valueOf(breakpointId)});
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) throws SQLException {
        db.execSQL(a.a);
        db.execSQL(a.b);
        db.execSQL("CREATE TABLE IF NOT EXISTS FileDownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (Build.VERSION.SDK_INT >= 16) {
            setWriteAheadLoggingEnabled(true);
        } else {
            db.enableWriteAheadLogging();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) throws SQLException {
        if (oldVersion == 1 && newVersion == 2) {
            db.execSQL("CREATE TABLE IF NOT EXISTS FileDownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        }
        if (oldVersion <= 2) {
            db.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
        }
    }
}
