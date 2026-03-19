package com.sigmob.sdk.videocache.sourcestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sigmob.sdk.videocache.o;
import com.sigmob.sdk.videocache.v;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class a extends SQLiteOpenHelper implements c {
    private static final String a = "SourceInfo";
    private static final String c = "url";
    private static final String e = "mime";
    private static final String g = "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);";
    private static final String b = "_id";
    private static final String d = "length";
    private static final String[] f = {b, "url", d, "mime"};

    a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        o.a(context);
    }

    private ContentValues a(v sourceInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", sourceInfo.a);
        contentValues.put(d, Long.valueOf(sourceInfo.b));
        contentValues.put("mime", sourceInfo.c);
        return contentValues;
    }

    private v a(Cursor cursor) {
        return new v(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow(d)), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.sigmob.sdk.videocache.sourcestorage.c
    public v a(String url) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        o.a(url);
        v vVarA = null;
        try {
            cursorQuery = getReadableDatabase().query(a, f, "url=?", new String[]{url}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        vVarA = a(cursorQuery);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return vVarA;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    @Override // com.sigmob.sdk.videocache.sourcestorage.c
    public void a() {
        close();
    }

    @Override // com.sigmob.sdk.videocache.sourcestorage.c
    public void a(String url, v sourceInfo) {
        o.a(url, sourceInfo);
        boolean z = a(url) != null;
        ContentValues contentValuesA = a(sourceInfo);
        if (z) {
            getWritableDatabase().update(a, contentValuesA, "url=?", new String[]{url});
        } else {
            getWritableDatabase().insert(a, null, contentValuesA);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) throws SQLException {
        o.a(db);
        db.execSQL(g);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
